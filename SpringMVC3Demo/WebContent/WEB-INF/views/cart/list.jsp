<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
   <meta charset="utf-8" />
   <title>Welcome to national vaccine distribution system</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
   
   <%@ include file="../shared/importCss.jsp"%>
   <%@ include file="../shared/importJs.jsp"%>
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script type="text/javascript" src="<c:url value='/js/jquery.treeLite.js?ver=10'/>"></script>
   <script type="text/javascript" src="<c:url value='/js/app.js'/>"></script> 
   <!-- END PAGE LEVEL SCRIPTS -->

   <link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="page-header-fixed">
   
   <%@ include file="../shared/pageHeader.jsp"%>
   
   <div class="clearfix"></div>
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
      
      <%@ include file="../shared/sidebarMenu.jsp"%>
      
      <!-- BEGIN PAGE -->  
      <div class="page-content">
         
         <%@ include file="../shared/styleSet.jsp"%>
                    
         <!-- BEGIN PAGE HEADER-->   
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN PAGE TITLE & BREADCRUMB-->
               <h3 class="page-title">
                  Shopping Cart <small>Welcome to national vaccine distribution system</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li>
                     <i class="icon-home"></i>
                     <a href="<c:url value='/home/index'/>">Welcome</a> 
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>
                     <span>${requestScope.permissionMenu.rootName}</span>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li><span>${requestScope.permissionMenu.subName}</span></li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         <!-- BEGIN PAGE CONTENT-->
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN SAMPLE FORM PORTLET-->   
               <div class="portlet ">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-reorder"></i>${requestScope.permissionMenu.curName}</div>
                  </div>
                  <div class="portlet-body form">
                     <form:form modelAttribute="orderModel" class="form-horizontal" method="POST">
                        <div class="form-body">
                           <div class="table-scrollable">
		                     <table class="table table-striped table-bordered table-hover" id="data-table">
		                        <thead>
		                           <tr>
		                              <th class="table-checkbox"><input type="checkbox" class="group-checkable"/></th>			                              	                              
		                              <th >Name</th>		                              		                              
		                              <th >Price</th>		                              
		                              <th >Amount</th>
		                           </tr>
		                        </thead>
		                        <tbody>
		                        	<c:forEach items="${contentModel.items}" var="item" varStatus="status">
							        <tr class="even gradeX">
							        	<td class="check_cell">
									        <input type="checkbox" class="checkboxes" name="Id" value="${ item.id }" />
									        <%-- <form:checkbox path="orderItemId" class="checkboxes" name="Id" value="${ item.id }"/> --%>
									    </td> 														    								    				  
							            <td>${ item.name }</td>
							            <td>${ item.price }</td>
							            <td>${ item.amount }</td>							           
							        </tr>
							        </c:forEach>
		                        </tbody>
		                        
		                     </table>
	                     </div>                                                                                                                           
                        </div>
                        <div class="form-actions fluid">
                        <div class="col-md-6" align="right" style="width:900px; height: 25px; font-weight:bold; font-size: 30px">
								Price Total:<c:out value="${priceTotal}"/> $    
								<form:hidden path="priceTotal" value="${priceTotal}"/>                                                      
                        </div>
                        </div>
                        <div class="form-actions fluid">
                           <div class="col-md-offset-6 col-md-6">
                              <button type="submit" class="btn btn-success">Check Out</button>                             
                           </div>
                        </div>
                     </form:form>
                  </div>
               </div>
               <!-- END SAMPLE FORM PORTLET-->
            </div>
         </div>
         <!-- END PAGE CONTENT-->    
      </div>
      <!-- END PAGE -->  
   </div>
   <!-- END CONTAINER -->
   <%@ include file="../shared/pageFooter.jsp"%>
     
   <script type="text/javascript">
   	  $(function() {   
         App.init();
      });
   </script>
   <!-- END JAVASCRIPTS -->   
</body>
<!-- END BODY -->
</html>