package com.leo.web.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.infrastructure.project.common.extension.StringHelper;
import com.infrastructure.project.common.utilities.PageListUtil;
import com.leo.model.models.Account;
import com.leo.model.models.Authority;
import com.leo.service.interfaces.IAccountService;
import com.leo.web.auth.AccountAuth;
import com.leo.web.auth.AccountRole;
import com.leo.web.auth.AuthHelper;
import com.leo.web.auth.AuthPassport;
import com.leo.web.auth.AuthorityMenu;
import com.leo.web.auth.PermissionMenu;
import com.leo.web.models.AccountAuthorizeModel;
import com.leo.web.models.AccountLoginModel;
import com.leo.web.models.AccountRegisterModel;
import com.leo.web.models.AccountSearchModel;
import com.leo.web.models.TreeModel;
import com.leo.web.models.extension.AccountAuthorizeModelExtension;
import com.leo.web.models.extension.AccountRegisterModelExtension;
import com.leo.web.models.extension.TreeModelExtension;

@Controller
@RequestMapping(value = "/account")
public class AccountController extends BaseController {  
	
	@Autowired
    @Qualifier("AccountService")
    private IAccountService accountService;
	
	@RequestMapping(value="/login", method = {RequestMethod.GET})
    public String login(Model model){
		if(!model.containsAttribute("contentModel"))
            model.addAttribute("contentModel", new AccountLoginModel());
        return "account/login";
    }
	
	@RequestMapping(value="/login", method = {RequestMethod.POST})
	public String login(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountLoginModel accountLoginModel, BindingResult result) throws ValidatException, EntityOperateException, NoSuchAlgorithmException{
		
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
	
	@RequestMapping(value="/register", method = {RequestMethod.GET})
    public String register(Model model){
		if(!model.containsAttribute("contentModel"))
            model.addAttribute("contentModel", new AccountRegisterModel());
        return "account/register";
    }
	
	@RequestMapping(value="/register", method = {RequestMethod.POST})
	public String register(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountRegisterModel accountRegisterModel, BindingResult result) throws ValidatException, EntityOperateException, NoSuchAlgorithmException{
		if(!accountRegisterModel.getPassword().equals(accountRegisterModel.getConfirmPassword()))
			result.addError(new FieldError("contentModel","confirmPassword","Your passwords are not match."));
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return register(model);
        else if(accountService.accountExist(accountRegisterModel.getUsername())){
        	result.addError(new FieldError("contentModel","username","Username already exist."));
            return register(model);
        }      
        accountService.saveRegister(AccountRegisterModelExtension.toAccount(accountRegisterModel));
        
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        if(returnUrl==null)
//        	returnUrl="account/login";
        	returnUrl="login";
    	return "redirect:"+returnUrl; 	
	}
	
	@AuthPassport
	@RequestMapping(value="/list", method = {RequestMethod.GET})
    public String list(HttpServletRequest request, Model model, AccountSearchModel searchModel){ 			
    	model.addAttribute("requestUrl", request.getServletPath());
		model.addAttribute("requestQuery", request.getQueryString());

        model.addAttribute("searchModel", searchModel);
        int pageNo = ServletRequestUtils.getIntParameter(request, PageListUtil.PAGE_NO_NAME, PageListUtil.DEFAULT_PAGE_NO);
        int pageSize = ServletRequestUtils.getIntParameter(request, PageListUtil.PAGE_SIZE_NAME, PageListUtil.DEFAULT_PAGE_SIZE);      
        model.addAttribute("contentModel", accountService.listPage(searchModel.getName(), searchModel.getUsername(), pageNo, pageSize));

        return "account/list";
    }
	
	@AuthPassport
	@RequestMapping(value="/authorize/{id}", method = {RequestMethod.GET})
    public String authorize(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws ValidatException{	
		if(!model.containsAttribute("contentModel")){
			AccountAuthorizeModel accountBindModel=AccountAuthorizeModelExtension.toAccountBindModel(accountService.get(id));
            model.addAttribute("contentModel", accountBindModel);
        }	

		List<TreeModel> treeModels;
		AccountAuthorizeModel authorizeModel=(AccountAuthorizeModel)model.asMap().get("contentModel");
		String expanded = ServletRequestUtils.getStringParameter(request, "expanded", null);
		if(authorizeModel.getOrganizationId()!=null && authorizeModel.getOrganizationId()>0){
			List<TreeModel> children=TreeModelExtension.ToTreeModels(organizationService.listChain(), authorizeModel.getOrganizationId(), null, StringHelper.toIntegerList( expanded, ","));		
			treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","Root",false,false,false,children)));
		}
		else{
			List<TreeModel> children=TreeModelExtension.ToTreeModels(organizationService.listChain(), null, null, StringHelper.toIntegerList( expanded, ","));		
			treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","Root",false,true,false,children)));
		}
		model.addAttribute(treeDataSourceName, JSONArray .fromObject(treeModels, new JsonConfig()).toString());
		model.addAttribute(selectDataSourceName, roleService.getSelectSource());
		
        return "account/authorize";
    }

	@AuthPassport
	@RequestMapping(value="/authorize/{id}", method = {RequestMethod.POST})
	public String authorize(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountAuthorizeModel accountAuthorizeModel, @PathVariable(value="id") Integer id, BindingResult result) throws ValidatException, EntityOperateException{
		if(result.hasErrors())
            return authorize(request, model, id);
		
		accountService.updateBind(id, accountAuthorizeModel.getRoleId(), accountAuthorizeModel.getOrganizationId());       
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        if(returnUrl==null)
        	returnUrl="account/list";
    	return "redirect:"+returnUrl; 	
	}
	
	@AuthPassport
	@RequestMapping(value = "/enable/{id}", method = {RequestMethod.GET})
	public String enable(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws EntityOperateException, ValidatException{
		
	String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
	Account account = accountService.get(id);
	account.setEnable(true);
	accountService.update(account);
	if(returnUrl==null)
	returnUrl="account/list";
	return "redirect:"+returnUrl;
	}
	
	@AuthPassport
	@RequestMapping(value = "/disable/{id}", method = {RequestMethod.GET})
	public String disable(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws EntityOperateException, ValidatException{

	String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
	Account account = accountService.get(id);
	account.setEnable(false);
	accountService.update(account);
	if(returnUrl==null)
	returnUrl="account/list";
	return "redirect:"+returnUrl;
	}
	
	@AuthPassport
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET})
	public String delete(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws EntityOperateException, ValidatException{

	accountService.delete(id);	
	String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);	
	if(returnUrl==null)
	returnUrl="account/list";
	return "redirect:"+returnUrl;
	}
}  
