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
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.model.models.Account;
import com.leo.model.models.Authority;
import com.leo.model.models.Quota;
import com.leo.model.models.State;
import com.leo.model.models.Vaccine;
import com.leo.web.auth.AccountAuth;
import com.leo.web.auth.AccountRole;
import com.leo.web.auth.AuthHelper;
import com.leo.web.auth.AuthPassport;
import com.leo.web.auth.AuthorityMenu;
import com.leo.web.auth.PermissionMenu;
import com.leo.web.models.AccountLoginModel;
import com.leo.web.models.VaccineQuotaModel;

@Controller
@RequestMapping(value="/vaccineCata")
public class CDCVaccineCataController extends BaseController {
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
        		
        int pageNo = ServletRequestUtils.getIntParameter(request, PageListUtil.PAGE_NO_NAME, PageListUtil.DEFAULT_PAGE_NO);
        int pageSize = ServletRequestUtils.getIntParameter(request, PageListUtil.PAGE_SIZE_NAME, PageListUtil.DEFAULT_PAGE_SIZE);      
        model.addAttribute("contentModel", vaccineService.listPage(pageNo, pageSize));
        return "vaccineCata/list";
	}
	
	@AuthPassport
	@RequestMapping(value="/quota/{id}", method=RequestMethod.GET)
	public String quota(HttpServletRequest request, Model model ,@PathVariable(value="id") Integer id) throws NumberFormatException, ValidatException, EntityOperateException{		
		int populationSum = 0;
		
		Vaccine vaccine = vaccineService.get(id);
		int availa = vaccine.getAvailability();		
		List<VaccineQuotaModel> vqmList = new ArrayList<VaccineQuotaModel>();
		List<State> states = stateService.listState();
		for(int i=0; i<states.size(); i++){
			populationSum += states.get(i).getPopulation();
		}
		System.out.println("population is :"+populationSum);
		for(int j=0; j<states.size(); j++){
			VaccineQuotaModel vqm = new VaccineQuotaModel();
			vqm.setVaccineName(vaccine.getName());
			vqm.setId(states.get(j).getId());
			System.out.println("State id is :"+vqm.getId());
			vqm.setStateName(states.get(j).getName());
			System.out.println("State id is :"+vqm.getStateName());
			int quota = states.get(j).getPopulation()*availa/populationSum;
			System.out.println("Quota is :"+quota);			
			Quota q = new Quota();
			q.setId(vqm.getId());
			q.setVaccine(vaccine);
			q.setState(states.get(j));
			q.setQuota(quota);
			quotaService.save(q);
			vqm.setQuota(quota);
			vqmList.add(vqm);
		}
		
		if(!model.containsAttribute("contentModel"))
		{
			model.addAttribute("contentModel", vqmList);
		}				
		
		return "vaccineCata/quota";
	}
	
}
