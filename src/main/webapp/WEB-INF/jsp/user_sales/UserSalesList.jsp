<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../common/IncludeTop.jsp"%>

<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean" />

<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            /*background-color: #333;*/
            text-align:center
        }
        ul:after{
            content:'';
            display: block;
            clear:both;
        }
        li {
            display: inline-block;
        }
        li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        li a:hover:not(.active) {
            background-color: darkgray;
        }
        .active {
            background-color: #4CAF50;
        }
        table{
            text-align:center
        }
        td{text-align:center}
    </style>
</head>

<body>

<ul>
    <li><a class="active" href="#home">분양게시판</a></li>
    <li><a href="#news">강아지</a></li>
    <li><a href="#contact">고양이</a></li>
    <li><a href="<#911247992831500350>out">물고기</a></li>
    <li><a href="<#911247992831500350>out">새</a></li>
    <li><a href="<#911247992831500350>out">파충류</a></li>
    <li><a href="<#911247992831500350>out">기타</a></li>
</ul>
<hr>
<ul>
    <li><a href="<#911247992831500350>out">전체분양</a></li>
    <li><a href="#news">무료분양</a></li>
    <li><a href="#contact">유료분양</a></li>
    <li><a href="<#911247992831500350>out">인기순</a></li>
    <li><a href="<#911247992831500350>out">최신순</a></li>
    <li><input type ="text" name ="q" value=""/>
        <input type = "submit" value ="검색"></li>
</ul>
<hr>
<ul>
    <li>
        <stripes:link
            beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
            event="selectSalesForm">
        분양등록
    </stripes:link>
    </li>
</ul>
<hr>
<table align="center" >
    <tr>
        <th>번호</th>
        <th>사진</th>
        <th width="200">분양 상태</th>
        <th width="100">유료/무료</th>

    </tr>
    <c:forEach var="UserSale" items="${actionBean.userSalesList}">
        <tr>
            <td>${UserSale.sid}</td>
            <td><stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                    event="viewSales">
                <stripes:param name="sid" value="${UserSale.sid}" />
                ${UserSale.sdesc}
            </stripes:link></td>
            <td>
            <c:if test = "${UserSale.sstatus == 0}">
                분양완료
            </c:if>
                <c:if test = "${UserSale.sstatus == 1}">
                    분양가능
                </c:if>
                    </td>
            <td>
                <c:if test = "${UserSale.scharge == 0}">
                    무료
                </c:if>
                <c:if test = "${UserSale.scharge == 1}">
                    유료
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>