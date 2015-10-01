<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- BEGIN HEADER -->   
<div class="header navbar navbar-inverse navbar-fixed-top">
   <!-- BEGIN TOP NAVIGATION BAR -->
  <div class="header-inner">
     <!-- BEGIN LOGO -->  
     <a class="navbar-brand" href="index.html">
     <img src="/images/logo.png" alt="NVDS" class="img-responsive" />
     </a>
     <!-- <form class="search-form search-form-header" role="form" action="index.html" >
        <div class="input-icon right">
           <i class="icon-search"></i>
           <input type="text" class="form-control input-medium input-sm" name="query" placeholder="Search...">
        </div>
     </form> -->
     <!-- END LOGO -->
     <!-- BEGIN RESPONSIVE MENU TOGGLER --> 
     <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
     <img src="<c:url value='/images/menu-toggler.png'/>" alt=""/>
     </a> 
     <!-- END RESPONSIVE MENU TOGGLER -->
     <!-- BEGIN TOP NAVIGATION MENU -->
     <ul class="nav navbar-nav pull-right">
       <!--  <li class="devider">&nbsp;</li> -->
        <!-- BEGIN USER LOGIN DROPDOWN -->
        <li class="dropdown user">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
           <img alt="" src="<c:url value='/images/avatar1.jpg'/>"/>&nbsp;
           <span class="username">${sessionScope.accountAuth.name}</span>&nbsp;-&nbsp;
           <span class="username">${sessionScope.accountAuth.accountRole.name}</span>                      
           <i class="icon-angle-down"></i>
           </a>
           <ul class="dropdown-menu">
              <li><a href="<c:url value='/account/profile'/>"><i class="icon-user"></i>My account</a>
              </li>
              <li class="divider"></li>
              </li>
              <li><a href="login.html"><i class="icon-off"></i>Sign out</a>
              </li>
           </ul>
        </li>
        <!-- END USER LOGIN DROPDOWN -->
     </ul>
     <!-- END TOP NAVIGATION MENU -->
  </div>
  <!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->