<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.infrastructure.project.common.extension.UrlHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
   <meta charset="utf-8" />
   <title>Conquer | Form Stuff - Form Controls</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
   
   <%@ include file="../shared/importCss.jsp"%>
   <!-- BEGIN PAGE LEVEL STYLES -->
   <link rel="stylesheet" href="<c:url value='/plugins/data-tables/DT_bootstrap.css'/>" type="text/css"/>
   <!-- END PAGE LEVEL STYLES -->
   
   <%@ include file="../shared/importJs.jsp"%>
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script type="text/javascript" src="<c:url value='/plugins/data-tables/jquery.dataTables.js'/>"></script>
   <script type="text/javascript" src="<c:url value='/plugins/data-tables/DT_bootstrap.js'/>"></script>
   <script type="text/javascript" src="<c:url value='/plugins/uniform/jquery.uniform.min.js'/>"></script>
   <script type="text/javascript" src="<c:url value='/js/jquery.toolbarlite.js?ver=10'/>"></script> 
   <script type="text/javascript" src="<c:url value='/js/app.js'/>"></script> 
   <script type="text/javascript" src="<c:url value='/js/jquery.tableManaged.js'/>"></script>
   <script type="text/javascript" src="<c:url value='/js/jquery.treeLite.js?ver=10'/>"></script>
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
                  Form Controls <small>form controls and more</small>
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
               
               <!-- BEGIN EXAMPLE TABLE PORTLET-->
               <div class="portlet box light-grey">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-table"></i>${requestScope.permissionMenu.curName}</div>
                  </div>
                  <div class="portlet-body">
                     <div class="table-toolbar"></div>
                     <div class="dataTables_wrapper form-inline" role="grid">
	                     <div class="table-scrollable">
		                     <table class="table table-striped table-bordered table-hover" id="data-table">
		                        <thead>
		                           <tr>
		                              <th class="table-checkbox"><input type="checkbox" class="group-checkable"/></th>	
		                              <th>Order ID</th>	 
		                              <th>From Hospital</th>  		                              
		                              <th>From Account</th>                           
		                              <th>Date</th>
		                              <th>PriceTotal</th>
		                              <th>Order Status</th>		                              
		                              		                              
		                           </tr>
		                        </thead>
		                        <tbody>
		                        	<c:forEach items="${contentModel}" var="item" varStatus="status">
							        <tr class="even gradeX">
							        	<td class="check_cell">
									        <input type="checkbox" class="checkboxes" name="Id" value="${ item.id }" />
									    </td> 					
									    <td>${ item.id }</td>
									    <td>${ item.hosName }</td>									    
									    <td>${ item.accountName }</td>									    
									    <td>${ item.date.getTime().toLocaleString() }</td>	
									    <td>${ item.priceTotal }</td>
									    <td>${ item.orderStatus }</td>									    								    				   							           
							        </tr>
							        </c:forEach>
		                        </tbody>
		                     </table>
	                     </div>	                     
       				 </div>
                  </div>
               </div>
               <!-- END EXAMPLE TABLE PORTLET-->
               
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
         
         $("#data-table").tableManaged();
         
         $(".table-toolbar").toolbarLite({
             items: [                 
                 { link: true, display: "Approve", css: "icon-ok", showIcon: true, url: "<%=UrlHelper.resolveWithReturnUrl("/delivery/approve/{0}", request.getAttribute("requestUrl"), request.getAttribute("requestQuery"), pageContext)%>", 
                   	selector: "#data-table .checkboxes", mustSelect: "select first!", singleSelect: "Only support single select!"},
                 { splitter: true },                                 
                 { link: true, display: "Reject", css: "icon-trash", showIcon: true, url: "<%=UrlHelper.resolveWithReturnUrl("/delivery/reject/{0}", request.getAttribute("requestUrl"), request.getAttribute("requestQuery"), pageContext)%>", 
                   	selector: "#data-table .checkboxes", mustSelect: "select first!"}
             ]
         });
      });
   </script>
   <!-- END JAVASCRIPTS -->   
</body>
<!-- END BODY -->
</html>