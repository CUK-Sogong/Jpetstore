<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<html>
<body>
<h2>입양 신청 목록</h2>
<table border align="center">
    <tr>
        <th>입양 번호</th>
        <th>승인 여부</th>
    </tr>
    <c:forEach var="UserAdopt" items="${actionBean.userAdoptsList}">
        <tr>
            <td><stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                    event="viewAdoptAdt">
                <stripes:param name="aid" value="${UserAdopt.aid}" />
                ${UserAdopt.aid}
            </stripes:link>
            </td>
            <td>
                <c:if test="${UserAdopt.astatus==0}">거절</c:if>
                <c:if test="${UserAdopt.astatus==1}">수락</c:if>
                <c:if test="${UserAdopt.astatus==2}">대기</c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>