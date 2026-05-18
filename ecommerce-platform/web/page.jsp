<%-- page.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-bar">
    <ul class="pagination">
        <c:if test="${p.pageNumber > 1}">
            <li><a href="${url}?page=1${param}">首页</a></li>
            <li><a href="${url}?page=${p.pageNumber-1}${param}">上一页</a></li>
        </c:if>

        <c:forEach begin="1" end="${p.totalPage}" var="i">
            <li <c:if test="${p.pageNumber == i}">class="active"</c:if>>
                <a href="${url}?page=${i}${param}">${i}</a>
            </li>
        </c:forEach>

        <c:if test="${p.pageNumber < p.totalPage}">
            <li><a href="${url}?page=${p.pageNumber+1}${param}">下一页</a></li>
            <li><a href="${url}?page=${p.totalPage}${param}">尾页</a></li>
        </c:if>
    </ul>
</div>
