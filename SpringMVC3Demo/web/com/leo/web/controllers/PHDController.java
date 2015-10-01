package com.leo.web.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.leo.model.models.Account;
import com.leo.model.models.Authority;
import com.leo.model.models.Cart;
import com.leo.model.models.Hospital;
import com.leo.web.auth.AccountAuth;
import com.leo.web.auth.AccountRole;
import com.leo.web.auth.AuthHelper;
import com.leo.web.auth.AuthPassport;
import com.leo.web.auth.AuthorityMenu;
import com.leo.web.auth.PermissionMenu;
import com.leo.web.models.AccountLoginModel;
import com.leo.web.models.PHDOrderModel;


@Controller
@RequestMapping(value="/phd")
public class PHDController extends BaseController{
	
	@RequestMapping(value="/login", method = {RequestMethod.GET})
    public String login(Model model){
		if(!model.containsAttribute("contentModel"))
            model.addAttribute("contentModel", new AccountLoginModel());
        return "account/login";
    }
	

	@RequestMapping(value="/login", method = {RequestMethod.POST})
	public String login(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountLoginModel accountLoginModel, BindingResult result) throws ValidatException, EntityOperateException, NoSuchAlgorithmException{
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return login(model);
        Account account=accountService.login(accountLoginModel.getUsername().trim(), accountLoginModel.getPassword().trim());
        if(account==null || account.getEnable()==false || account.getRole()==null){
        	if(account==null){
	        	result.addError(new FieldError("contentModel","username","Wrong username or password"));
	        	result.addError(new FieldError("contentModel","password","Wrong username or password"));
        	}
        	else if(account.getEnable()==false)
        		result.addError(new FieldError("contentModel","username","the user has been banned, cannot sign in."));
        	else
        		result.addError(new FieldError("contentModel","username","the user has not been authorized, cannot sign in."));
            return login(model);
        }
        else{
        	AccountAuth accountAuth=new AccountAuth(account.getId(), account.getName(), account.getUsername());
        	AccountRole accountRole=new AccountRole(account.getRole().getId(), account.getRole().getName());
        	List<AuthorityMenu> authorityMenus=new ArrayList<AuthorityMenu>();
        	List<Authority> roleAuthorities=account.getRole().getAuthorities();
        	
        	for(Authority authority :roleAuthorities){
        		if(authority.getParent()==null){
        			AuthorityMenu authorityMenu=new AuthorityMenu(authority.getId(), authority.getName(), authority.getItemIcon(), authority.getUrl());
        			
        			List<AuthorityMenu> childrenAuthorityMenus=new ArrayList<AuthorityMenu>();
        			for(Authority subAuthority :roleAuthorities){   				
        				if(subAuthority.getParent()!=null && subAuthority.getParent().getId().equals(authority.getId()))
        					childrenAuthorityMenus.add(new AuthorityMenu(subAuthority.getId(), subAuthority.getName(), subAuthority.getItemIcon(), subAuthority.getUrl()));
        			}
        			authorityMenu.setChildrens(childrenAuthorityMenus);
        			authorityMenus.add(authorityMenu);
        		}
        	}
        	
    		List<PermissionMenu> permissionMenus=new ArrayList<PermissionMenu>(); 	
        	for(Authority authority : roleAuthorities){ 	  		
        		List<Authority> parentAuthorities=new ArrayList<Authority>();
        		Authority tempAuthority=authority;
        		while(tempAuthority.getParent()!=null){
        			parentAuthorities.add(tempAuthority.getParent());
        			tempAuthority=tempAuthority.getParent();
        		}
        		if(parentAuthorities.size()>=2)
        			permissionMenus.add(new PermissionMenu(parentAuthorities.get(parentAuthorities.size()-1).getId(),parentAuthorities.get(parentAuthorities.size()-1).getName(),parentAuthorities.get(parentAuthorities.size()-2).getId(),parentAuthorities.get(parentAuthorities.size()-2).getName(),authority.getName(),authority.getMatchUrl()));
        		else if(parentAuthorities.size()==1)
        			permissionMenus.add(new PermissionMenu(parentAuthorities.get(0).getId(),parentAuthorities.get(0).getName(),authority.getId(),authority.getName(),authority.getName(),authority.getMatchUrl()));
        		else
        			permissionMenus.add(new PermissionMenu(authority.getId(),authority.getName(),null,null,authority.getName(),authority.getMatchUrl()));
        	}
        	accountRole.setAuthorityMenus(authorityMenus);
        	accountRole.setPermissionMenus(permissionMenus);
        	accountAuth.setAccountRole(accountRole);
        	AuthHelper.setSessionAccountAuth(request, accountAuth);
        }
        
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        if(returnUrl==null)
        	returnUrl="/home/index";
    	return "redirect:"+returnUrl; 	
	}
	
	@AuthPassport
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) throws NumberFormatException, ValidatException{
		model.addAttribute("requestUrl", request.getServletPath());
		model.addAttribute("requestQuery", request.getQueryString());
        
		List<PHDOrderModel> pomList = new ArrayList<PHDOrderModel>(); 		 
	    List<Cart> carts = cartService.listCarts();
	    for(int i=0; i<carts.size();i++){
	    	PHDOrderModel pom = new PHDOrderModel();
	    	pom.setId(carts.get(i).getId());
	    	pom.setDate(carts.get(i).getDate());
	    	pom.setPriceTotal(carts.get(i).getPriceTotal());
	    	pom.setOrderStatus(carts.get(i).getStatus());
	    	Account account = accountService.get(Integer.parseInt(carts.get(i).getAccountId()));
	    	pom.setAccountName(account.getName());
	    	Hospital hospital = hospitalService.get(Integer.parseInt(account.getHospitalId()));
	    	pom.setHosName(hospital.getName());
	    	pom.setRegisterStatus(hospital.getEnable());
	    	pomList.add(pom);	    	
	    }
		
	    System.out.println("good 8");
	    
		if(!model.containsAttribute("contentModel"))
		{
			model.addAttribute("contentModel", pomList);
		}				
       
        return "phd/list";
	}
	
	@AuthPassport
	@RequestMapping(value="/approve/{id}", method=RequestMethod.GET)
	public String add(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws ValidatException, EntityOperateException{
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		Cart cart = cartService.get(id);
		cart.setPhdEnable(true);
		cart.setStatus("PHD Approved!");
		cartService.update(cart);
		
		if(returnUrl==null)
			returnUrl="phd/list";
		return "redirect:"+returnUrl;			
	}
	
	@AuthPassport
	@RequestMapping(value="/reject/{id}", method=RequestMethod.GET)
	public String reject(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws ValidatException, EntityOperateException{
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		Cart cart = cartService.get(id);
		cart.setPhdEnable(false);
		cart.setStatus("PHD rejected!");
		cartService.update(cart);
		
		if(returnUrl==null)
			returnUrl="phd/list";
		return "redirect:"+returnUrl;
			
	}
	
}
