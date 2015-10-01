<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Conquer | Admin Dashboard Template</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
   
   <%@ include file="../shared/importCss.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
   <link href="<c:url value='/plugins/fullcalendar/fullcalendar/fullcalendar.css'/>" rel="stylesheet" type="text/css"/>
   <!-- END PAGE LEVEL PLUGIN STYLES -->
   
   <link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
   
   <%-- <%@ include file="../shared/pageHeader.jsp"%> --%>
   <%@ include file="../profile.vm"%>
   
   <div class="clearfix"></div>
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
      
      <%@ include file="../shared/sidebarMenu.jsp"%>
      
      <!-- BEGIN PAGE -->
      <div class="page-content">
         
         <%-- <%@ include file="../shared/styleSet.jsp"%> --%>
         <%@ include file="../styleSet.ftl"%>
           
         <!-- BEGIN PAGE HEADER-->
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN PAGE TITLE & BREADCRUMB-->
               <h3 class="page-title">
                  Dashboard <small>statistics and more</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li>
                     <i class="icon-home"></i>
                     ${requestScope.permissionMenu.rootName}
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>${requestScope.permissionMenu.subName}</li>
                  <li class="pull-right">
                     <div id="dashboard-report-range" class="dashboard-date-range tooltips" data-placement="top" data-original-title="Change dashboard date range">
                        <i class="icon-calendar"></i>
                        <span></span>
                        <i class="icon-angle-down"></i>
                     </div>
                  </li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         
         <div class="clearfix"></div>
         <div class="row">
            
            
         </div>
         
            <%-- <label>${requestScope['javax.servlet.forward.request_uri']}</label><br/>
			<label>${pageContext.request.queryString}</label><br/>
			<label>${PageContract.DEFAULT_PAGE_SIZE}</label><br/>
			
			<label>getScheme <%=request.getScheme() %></label><br/>
			<label>getServerName <%=request.getServerName() %></label><br/>
			<label>getRequestURI <%=request.getRequestURI() %></label><br/>
			
			<label>getContextPath <%=request.getContextPath() %></label><br/>
			<label>getServletPath <%=request.getServletPath() %></label><br/>
			
			<label>getQueryString <%=request.getQueryString() %></label><br/> --%>
    
      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
   <div class="footer">
      <div class="footer-inner">
         2015 &copy; National Vaccine Distribution System.
      </div>
      <div class="footer-tools">
         <span class="go-top">
         <i class="icon-angle-up"></i>
         </span>
      </div>
   </div>
   <!-- END FOOTER -->
   
   <%@ include file="../shared/importJs.jsp"%>
   <!-- BEGIN PAGE LEVEL PLUGINS -->
   <script src="<c:url value='/plugins/gritter/js/jquery.gritter.js'/>" type="text/javascript"></script>
   <!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
   <script src="<c:url value='/plugins/fullcalendar/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
   <script src="<c:url value='/plugins/jquery.sparkline.min.js'/>" type="text/javascript"></script>  
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="<c:url value='/js/app.js'/>" type="text/javascript"></script>
   <script src="<c:url value='/js/index.js'/>" type="text/javascript"></script>  
   <!-- END PAGE LEVEL SCRIPTS -->  

   <script type="text/javascript">
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
         Index.init();
         Index.initCalendar(); // init index page's custom scripts
         Index.initPeityElements();
         Index.initKnowElements();
         Index.initDashboardDaterange();
      });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
</html>