<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="com.infrastructure.project.common.utilities.IPageList" 
    import="com.infrastructure.project.common.utilities.PageListUtil" 
    import="org.apache.taglibs.standard.tag.common.core.UrlSupport"%>

<%
	String urlAddress=request.getParameter("urlAddress");
	String pageModelName= request.getParameter("pageModelName");
	Integer pageCount=(request.getParameter("pageCount")!=null&&!request.getParameter("pageCount").isEmpty())?Integer.valueOf(request.getParameter("pageCount")):10;
%>

<div class="row">
<%
	if(pageModelName==null || pageModelName.isEmpty()){%>
		Didn't get page mark!
	<%}
	else if(urlAddress==null || urlAddress.isEmpty()){%>
		Didn't get url address!
	<%}
	else if(pageCount<10){%>
		The item number in each page cannot less than 10!
	<%}

	IPageList<?> pageModel = (IPageList<?>)request.getAttribute(pageModelName);
	if(pageModel==null){%>
		Didn't get each page mark!
	<%}
	else{%>
	
		<div class="col-md-5 col-sm-12">
			<div class="dataTables_info">(Each page shows <%=pageModel.getPageSize() %> items, in total <%=pageModel.getItemCount() %> results)</div>
		</div>
	
		<div class="col-md-7 col-sm-12">
			<div class="dataTables_paginate paging_bootstrap">
		   		<ul class="pagination">

		<%String queryString=request.getQueryString();
		urlAddress = UrlSupport.resolveUrl(urlAddress, null, pageContext);
		if (pageModel.getHasPre()) {
            String preUrl = pageModel.resolveUrl(urlAddress, queryString, pageModel.getPageIndex() - 1, null);%>
            <li class="prev">
				<a href="<%=preUrl%>">Previous</a>
			</li>
        <%}
		else{%>
			<li class="prev disabled">
				<span>Previous</span>
			</li>
		<%}
		if(pageModel.getPageCount()<=pageCount){
        	for(int i=1;i<=pageModel.getPageCount();i++){
        		if(i==pageModel.getPageIndex()){%>
        			<li class="active"><a href="#"><%=i %></a></li>
        		<%}
        		else{
        			String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, i, null);%>
                    <li><a href="<%=pageUrl%>"><%=i %></a></li>
                <%}	
        	}
        }
		else{   	
        	for(int i=1;i<=pageCount;i++){
        		if(pageModel.getPageIndex()<=pageCount/2){
        			if(i==pageModel.getPageIndex()){%>
        				<li class="active"><a href="#"><%=i %></a></li>
        			<%}
        			else if(pageCount-i>2){
        				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, i, null);%>
                        <li><a href="<%=pageUrl%>"><%=i %></a></li>
    				<%}
        			else if(i==pageCount-2){%>
        				<span>...</span>
        			<%}
        			else{
    					int pageNo=pageModel.getPageCount()-(pageCount-i);
    					String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>
                        <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
        			<%}
        		}
        		else if(pageModel.getPageCount()-pageModel.getPageIndex()<pageCount/2){
        			if(i<3){
        				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, i, null);%>
                        <li><a href="<%=pageUrl%>"><%=i %></a></li>
        			<%}
        			else if(i==3){%>
        				<span>...</span>
        			<%}
        			else{
        				int pageNo=pageModel.getPageCount()-(pageCount-i);
        				if(pageNo==pageModel.getPageIndex()){%>
        					<li class="active"><a href="#"><%=pageNo %></a></li>
        				<%}
        				else{
        					String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>
                            <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
        				<%}
        			}
        		}
        		else{
        			if(i<3){
        				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, i, null);%>
                        <li><a href="<%=pageUrl%>"><%=i %></a></li>
        			<%}
        			else if(i==3 || i==pageCount-2){%>
        				<span>...</span>
        			<%}
        			else if(i>pageCount-2){
        				int pageNo=pageModel.getPageCount()-(pageCount-i);
        				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>
                        <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
        			<%}
        			else{
        				if(pageCount%2==0)
        				{
            				if(i==pageCount/2){%>
            					<li class="active"><a href="#"><%=pageModel.getPageIndex() %></a></li>
            				<%}
            				else if(i<pageCount/2){
            					int pageNo=pageModel.getPageIndex()-(pageCount/2-i);
                				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>
                                <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
            				<%}
            				else{
            					int pageNo=pageModel.getPageIndex()+(i-pageCount/2);
                				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>
                                <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
            				<%}
        				}
        				else{
        					if(i==(pageCount+1)/2){%>
            					<li class="active"><a href="#"><%=pageModel.getPageIndex() %></a></li>
            				<%}
        					else if(i<(pageCount+1)/2){
            					int pageNo=pageModel.getPageIndex()-((pageCount+1)/2-i);
                				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>                            
                                <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
            				<%}
            				else{
            					int pageNo=pageModel.getPageIndex()+(i-(pageCount+1)/2);
                				String pageUrl  = pageModel.resolveUrl(urlAddress, queryString, pageNo, null);%>
                                <li><a href="<%=pageUrl%>"><%=pageNo %></a></li>
            				<%}
        				}
        			}
        		}
        	}
        }
		if (pageModel.getHasNext()) {
            String nextUrl  = pageModel.resolveUrl(urlAddress, queryString, pageModel.getPageIndex() + 1, null);%>
            <li class="next">
				<a href="<%=nextUrl %>">Next</a>
			</li>
        <%}
        else{%>
        	<li class="next disabled">
				<span>Next</span>
			</li>
        <%}%>
        		</ul>
			</div>
		</div>
        	
	<%}%>
</div>

<%-- <script type="text/javascript">  
function gotoSelectedPage()   
{   
    var x = document.getElementById("navigatorForm");   
    //alert("Original action: " + x.action)   
    x.submit();   
}   
</script>  
<form action="Posts" method="get" id="navigatorForm">  
    <a href="Posts?pageNumber=1">首页</a>    
    <c:if test="${pageNumber>1}">  
        <a href="Posts?pageNumber=${pageNumber-1}">上一页</a>  
    </c:if>    
    跳转到第 <select name="pageNumber" onchange="gotoSelectedPage();">  
    <c:forEach begin="1" end="${totalPages}" step="1" var="pageIndex">  
        <c:choose>  
            <c:when test="${pageIndex eq pageNumber}">  
                <option value="${pageIndex}" selected="selected">${pageIndex}</option>  
            </c:when>  
            <c:otherwise>  
                <option value="${pageIndex}">${pageIndex}</option>  
            </c:otherwise>  
        </c:choose>  
    </c:forEach>  
    </select>页    
    <c:if test="${pageNumber<totalPages}">  
        <a href="Posts?pageNumber=${pageNumber+1}">下一页</a>  
    </c:if>    
    <a href="Posts?pageNumber=${totalPages}">末页</a>  
</form>  --%>

<%-- <% String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString(); %> --%>

<%-- <c:set value="dmodel" var="aaa" />
<label>${model.getPageCount()}</label><br/>

<label>${requestScope[param.pageName].getPageCount()}</label><br/>


<c:forEach var="i" begin="1" end="10" step="1">
    <c:out value="${i}" />
    <br>
    <c:out value="${fn:replace(pageContext.request.queryString,'pageNo=','ddd')}"/>
    <br>
</c:forEach>


<label>${requestScope['javax.servlet.forward.request_uri']}</label><br/>
<label>${pageContext.request.queryString}</label><br/>
<label>${PageContract.DEFAULT_PAGE_SIZE}</label><br/>

<label><%=request.getScheme() %></label><br/>
<label><%=request.getServerName() %></label><br/>
<label><%=request.getRequestURI() %></label><br/>

<label><%=request.getContextPath() %></label><br/>
<label><%=request.getServletPath() %></label><br/>

<label><%=request.getQueryString() %></label><br/> --%>
<%-- <label><%=PageContract.DEFAULT_PAGE_SIZE %></label><br/> --%>

 <%-- <li>c:import标签 </li>  
     <c:import url="http://www.baidu.com"></c:import><br>  
     <p>  
      <li>c:url,c:param</li><br>  
     <c:url value="http://www.baidu.com" var="u">  
        <c:param name="userId" value="zhangsan"></c:param>  
        <c:param name="age" value="20"></c:param>  
     </c:url>  
     ${u }<br>  
      <li>c:redirect</li><br>  
     <c:redirect url="http://hao.360.cn/"></c:redirect>  --%>


