package com.leo.web.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leo.service.interfaces.IAccountService;
import com.leo.service.interfaces.IAuthorityService;
import com.leo.service.interfaces.ICartService;
import com.leo.service.interfaces.IDCService;
import com.leo.service.interfaces.IHospitalService;
import com.leo.service.interfaces.IInventoryService;
import com.leo.service.interfaces.IOrderItemService;
import com.leo.service.interfaces.IOrganizationService;
import com.leo.service.interfaces.IQuotaService;
import com.leo.service.interfaces.IRoleService;
import com.leo.service.interfaces.IShoppingCartService;
import com.leo.service.interfaces.IStateService;
import com.leo.service.interfaces.IVaccineService;

public abstract class BaseController {  

	protected final String searchModelName="searchModel";
	protected final String cartModelName="cartModel";
	protected final String treeDataSourceName="treeDataSource";
	protected final String selectDataSourceName="selectDataSource";
	
	@Autowired
    @Qualifier("RoleService")
    protected IRoleService roleService;
	
	@Autowired
    @Qualifier("AccountService")
    protected IAccountService accountService;
	
	@Autowired
    @Qualifier("AuthorityService")
	protected IAuthorityService authorityService;
	
	@Autowired
    @Qualifier("OrganizationService")
	protected IOrganizationService organizationService;
	
	@Autowired
	@Qualifier("StateService")
	protected IStateService stateService;
	
	@Autowired
	@Qualifier("VaccineService")
	protected IVaccineService vaccineService;
	
	@Autowired
	@Qualifier("HospitalService")
	protected IHospitalService hospitalService;
	
	@Autowired
	@Qualifier("OrderItemService")
	protected IOrderItemService orderItemService;
	
	@Autowired
	@Qualifier("ShoppingCartService")
	protected IShoppingCartService shoppingCartService;

	@Autowired
	@Qualifier("CartService")
	protected ICartService cartService;
	
	@Autowired
	@Qualifier("QuotaService")
	protected IQuotaService quotaService;
	
	@Autowired
	@Qualifier("DCService")
	protected IDCService dcService;
	
	@Autowired
	@Qualifier("InventoryService")
	protected IInventoryService inventoryService;
	
	@ExceptionHandler  
    public String exception(HttpServletRequest request, Exception e) {  
          
        request.setAttribute("exceptionMessage", e.getMessage());  
          
        // 根据不同错误转向不同页面  
        if(e instanceof SQLException) 
            return "testerror";   
        else
            return "error";  
    }  
	
}  
