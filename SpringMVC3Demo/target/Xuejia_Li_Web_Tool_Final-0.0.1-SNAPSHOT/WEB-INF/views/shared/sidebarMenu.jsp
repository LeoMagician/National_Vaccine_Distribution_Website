<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar navbar-collapse collapse">
   <!-- BEGIN SIDEBAR MENU -->        
<ul class="page-sidebar-menu">
   <li>
      <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
      <div class="sidebar-toggler"></div>
      <div class="clearfix"></div>
      <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
   </li>   
   
   <c:forEach items="${sessionScope.accountAuth.accountRole.authorityMenus}" var="item" varStatus="status">
   		<c:choose>  
        <c:when test="${status.first}">
            <c:choose>  
		        <c:when test="${item.id eq requestScope.permissionMenu.rootId}">  
		            <li class="start active">
		        </c:when>  
		        <c:otherwise>  
		            <li class="start">
		        </c:otherwise>  
		    </c:choose>
        </c:when>  
        <c:otherwise>  
            <c:choose>  
		        <c:when test="${item.id eq requestScope.permissionMenu.rootId}">  
		            <li class="active">
		        </c:when>  
		        <c:otherwise>  
		            <li class="">
		        </c:otherwise>  
		    </c:choose>
        </c:otherwise>  
    	</c:choose>
   		<a href="javascript:;">
			<i class='${ empty item.itemIcon?"icon-list": item.itemIcon}'></i>
			<span class="title">${ item.name }</span>
			<span class="arrow "></span>
		</a>
		<c:forEach items="${item.childrens}" var="subItem" varStatus="subStatus">
			<c:if test="${subStatus.first}">
			<ul class="sub-menu">
			</c:if>
			
			<c:choose>  
		        <c:when test="${subItem.id eq requestScope.permissionMenu.subId}">  
		            <li class="active">
		        </c:when>  
		        <c:otherwise>  
		            <li>
		        </c:otherwise>  
		    </c:choose>		   		    		
	            	<a href="<c:url value='${ subItem.url }'/>">${ subItem.name }</a>	            	
         		</li>
			<c:if test="${subStatus.last}">
			</ul>
			</c:if>
		</c:forEach>
   			</li>
   </c:forEach>
   
   <li class="last">
      <a href="login.html">
      <i class="icon-off"></i> 
      <span class="title">Sign Out</span>
      </a>
   </li>
</ul>
<!-- END SIDEBAR MENU -->
</div>
<!-- END SIDEBAR -->