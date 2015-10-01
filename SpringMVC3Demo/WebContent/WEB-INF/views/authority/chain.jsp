<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="com.infrastructure.project.common.extension.UrlHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../shared/taglib.jsp"%>

<html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
   <script type="text/javascript" src="<c:url value='/js/jquery.toolbarlite.js?ver=10'/>"></script>
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
                  Dashboard <small>statistics and more</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li>
                     <i class="icon-home"></i>
                     <a href="<c:url value='/home/index'/>">Home</a> 
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
               <div class="portlet">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-sitemap"></i>${requestScope.permissionMenu.curName}</div>
                  </div>
                  <div class="portlet-body">
                     <div id="treeData-list"></div>
                  </div>
                  
                  <div class="portlet-title tool-bottom">
                  </div>
                  
               </div>
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
		   
		   $("#treeData-list").treeLite({
           	   items: <c:out value="${contentModel}" escapeXml="false"></c:out>
           });
		   
	       $(".tool-bottom").toolbarLite({
	           items: [       
	               { link: true, display: "Add same level root", css: "icon-plus", showIcon: true, url: "javascript:;", 
	                   click: function() {
	                       var parentId = $('#treeData-list').treeLite('parentId');
	                       var expanded = $('#treeData-list').treeLite('expandedIds');
	                       if(parentId != undefined) 
	                           location.href = "<%= UrlHelper.resolveWithReturnUrl("/authority/add/{0}", request.getAttribute("requestUrl"), request.getAttribute("requestQuery"), "expanded={1}", pageContext)%>".replace("{0}", parentId).replace(escape("{1}"), expanded);
	                       else
	                           alert("Must have to select one root!");
	                       return false;
	                  }
	               },
	               { splitter: true }, 
	               { link: true, display: "Add child root", css: "icon-plus", showIcon: true, url: "javascript:;", 
	                   click: function() {
	                       var selectedId = $('#treeData-list').treeLite('selectedId');
	                       var expanded = $('#treeData-list').treeLite('expandedIds');
	                       if(selectedId != undefined)
	                       	location.href = "<%= UrlHelper.resolveWithReturnUrl("/authority/add/{0}", request.getAttribute("requestUrl"), request.getAttribute("requestQuery"), "expanded={1}", pageContext)%>".replace("{0}", selectedId).replace(escape("{1}"), expanded);
	                       else
	                           alert("Must have to select one root!");
	                       return false;
	                   }
	                },
	                { splitter: true }, 
	                { link: true, display: "Edit", css: "icon-edit", showIcon: true, url: "javascript:;",
	                    click: function() {
	                       var selectedId = $('#treeData-list').treeLite('selectedId');
	                       var expanded = $('#treeData-list').treeLite('expandedIds');
	                       if(selectedId != undefined) 
	                       	location.href = "<%= UrlHelper.resolveWithReturnUrl("/authority/edit/{0}", request.getAttribute("requestUrl"), request.getAttribute("requestQuery"), "expanded={1}", pageContext)%>".replace("{0}", selectedId).replace(escape("{1}"), expanded);
	                       else
	                           alert("Must have to select one root!");
	                       return false;
	                   } 
	                },
	                { splitter: true }, 
	                { link: true, display: "Delete", css: "icon-trash", showIcon: true, url: "javascript:;",
	                    click: function() {
	                       var selectedId = $('#treeData-list').treeLite('selectedId');
	                       var expanded = $('#treeData-list').treeLite('expandedIds');
	                       if(selectedId && selectedId != undefined) 
	                       {
	                           if(confirm("Sure to delete selected root?"))
	                           	location.href = "<%= UrlHelper.resolveWithReturnUrl("/authority/delete/{0}", request.getAttribute("requestUrl"), request.getAttribute("requestQuery"), "expanded={1}", pageContext)%>".replace("{0}", selectedId).replace(escape("{1}"), expanded);
	                       }
	                       else
	                           alert("Must have to select one root!");
	                       return false;
	                   } 
	                }
	           ]
	       });                  
	   });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>