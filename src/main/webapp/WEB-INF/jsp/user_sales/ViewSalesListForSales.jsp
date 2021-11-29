<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp" %>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div>
</br></br>
<style>
    table{
        text-align:center;
    }
    td{
        text-align:center;
    }
</style>
<div id="Catalog">
    <h2>분양 등록 목록</h2>
    <table style="display: inline; line-height: 25px;">
        <tr>
            <th>분양 번호</th>
            <th>종류</th>
            <th>품종</th>
            <th>날짜</th>
        </tr>

        <c:forEach var="UserSale" items="${actionBean.userSalesList}">
            <tr>
                <td><stripes:link
                        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                        event="viewAdoptListSl">
                    <stripes:param name="sid" value="${UserSale.sid}"/>
                    ${UserSale.sid}
                </stripes:link>
                </td>
                <td>${UserSale.scategory}</td>
                <td>${UserSale.sdesc}</td>
                <td><fmt:formatDate value="${UserSale.date}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>

    </table>
    <table style="display:inline; margin-left: -7px; line-height: 25px">
        <tr>
            <th>입양 신청 갯수</th>
        </tr>
                <c:forEach var="AdoptCnt" items="${actionBean.adoptCntList}">
                    <tr><td style="text-align: center">${AdoptCnt}</td></tr>
                </c:forEach>
    </table>
</div>
<%@ include file="../common/IncludeBottom.jsp" %>