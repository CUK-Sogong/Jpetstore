<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2021/11/21
  Time: 6:30 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div></br></br>

<body>
<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >
    <h2>분양 정보</h2>
    <hr>


    <table align="center" border>
        <tr>
            <td>아이디</td>
            <td>${actionBean.userSale.suserid}</td>
            <td>이름</td>
            <td>${actionBean.account.firstName} ${actionBean.account.lastName}</td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td>${actionBean.account.phone}</td>
            <td>이메일</td>
            <td>${actionBean.account.email}</td>
        </tr>
        <tr>
            <td>종류</td>
            <td>${actionBean.userSale.scategory}</td>
            <td>성별</td>
            <td>${actionBean.userSale.sgender}</td>
        </tr>
        <tr>
            <td>품종</td>
            <td>${actionBean.userSale.sdesc}</td>
            <td>개월 수</td>
            <td>${actionBean.userSale.sage}</td>
        </tr>
        <tr>
            <td>분양구분</td>
            <td>
                <c:if test="${actionBean.userSale.scharge==0}">
                    무료
                </c:if>
                <c:if test="${actionBean.userSale.scharge==1}">
                    유료
                </c:if>
            </td>
            <td>분양지역</td>
            <td>${actionBean.userSale.sarea}</td>
        </tr>
        <tr>
            <td>분양가</td>
            <td>${actionBean.userSale.sprice} $</td>
            <td>특이사항</td>
            <td>${actionBean.userSale.snote}</td>
        </tr>
        <c:forEach var="img" items="${actionBean.userImageList}">
            <tr>
                <td>사진</td>
                <td><img src=${img.dir} height="300" width="300"/></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align: center">
        <c:if test="${sessionScope.accountBean != null}">
            <c:if test="${sessionScope.accountBean.authenticated}">
                <c:if test="${sessionScope.accountBean.account.username.equals(actionBean.userSale.suserid)}">
                    <stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="updateSalesForm">
                        수정
                        <stripes:param name="sid" value="${actionBean.userSale.sid}" />
                    </stripes:link>
                    <stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="deleteSales">
                        삭제
                        <stripes:param name="sid" value="${actionBean.userSale.sid}" />
                    </stripes:link>
                </c:if>
            </c:if>
        </c:if>
    </div>
    <h2>입양 신청서 목록</h2>
    <table border align="center">
        <tr>
            <th>입양 번호</th>
            <th>날짜</th>
        </tr>
        <c:forEach var="UserAdopt" items="${actionBean.userAdoptsList}">
        <tr>
            <td><stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                    event="viewAdoptSl">
                <stripes:param name="aid" value="${UserAdopt.aid}" />
                ${UserAdopt.aid}
            </stripes:link>
            </td>
            <td><fmt:formatDate value="${UserAdopt.date}" pattern="yyyy-MM-dd"/></td>
        </tr>
        </c:forEach>
    </table>

</stripes:form>
</div>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>