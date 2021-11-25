<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div></br></br>
<body>
<h2>분양 등록 목록</h2>
<table border align="center">
    <tr>
        <th>분양 번호</th>
    </tr>
    <c:forEach var="UserSale" items="${actionBean.userSalesList}">
    <tr>
        <td><stripes:link
                beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                event="viewAdoptListSl">
            <stripes:param name="sid" value="${UserSale.sid}" />
            ${UserSale.sid}
        </stripes:link>
        </td>
        </c:forEach>
</table>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>