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
<style>
    table{
        text-align:center;
    }
    td{
        text-align:center;
    }
</style>
<body>
<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >
    <h2>입양 신청서 정보</h2>
    <table align="center">
        <tr>
            <td>입양자 정보</td>
            <td>${actionBean.userAdopt.auserid}</td>
        </tr>
        <tr>
            <td>거주지역</td>
            <td>${actionBean.userAdopt.aarea}</td>
        </tr>
        <tr>
            <td>월급</td>
            <td>${actionBean.userAdopt.asalary} $</td>
        </tr>
        <tr>
            <td>거주 형태</td>
            <td>${actionBean.userAdopt.ahome}</td>
        </tr>

        <tr>
            <td>동거인 수</td>
            <td>${actionBean.userAdopt.afamnum}</td>
        </tr>
        <tr>
            <td>동거 반려동물</td>
            <td>${actionBean.userAdopt.apets}</td>
        </tr>
        <tr>
            <td>반려동물 키움 경험</td>
            <td>${actionBean.userAdopt.apetexp}</td>
        </tr>
        <tr>
            <td>사유 및 각오</td>
            <td>${actionBean.userAdopt.anote}</td>
        </tr>
    </table>
    <c:if test="${actionBean.userAdopt.astatus == 2}">
        <stripes:submit name="acceptAdopt" value="수락"/>
        <stripes:submit name="refusalAdopt" value="거절"/>
    </c:if>

</stripes:form>
</div>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>

