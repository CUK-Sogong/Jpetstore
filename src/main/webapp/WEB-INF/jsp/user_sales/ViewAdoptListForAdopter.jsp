<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<html>
<body>
<h2>입양신청목록</h2>
<table border align="center">
    <th>종류</th>
    <th>품종</th>
    <th>확인</th>
    <th>승인</th>
    <th>특이사항</th>
<%--    <c:forEach var="UserSale" items="${actionBean.userSalesList}">--%>
<%--        <tr>--%>
<%--            <td>${UserSale.scategory}</td>--%>
<%--            <td><stripes:link--%>
<%--                    beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"--%>
<%--                    event="viewAdoptAdt">--%>
<%--                <stripes:param name="asid" value="${UserSale.sId}" />--%>
<%--                ${UserSale.sdesc}--%>
<%--            </stripes:link></td>--%>
<%--            <td>--%>
<%--                <c:if test = "${UserSale.sread == 0}">--%>
<%--                    읽지않음--%>
<%--                </c:if>--%>
<%--                <c:if test = "${UserSale.sread == 1}">--%>
<%--                    읽음--%>
<%--                </c:if>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:if test = "${UserSale.sstatus == 0}">--%>
<%--                    완료--%>
<%--                </c:if>--%>
<%--                <c:if test = "${UserSale.sstatus == 1}">--%>
<%--                    가능--%>
<%--                </c:if>--%>
<%--            </td>--%>
<%--            <td>${UserSale.snote}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>