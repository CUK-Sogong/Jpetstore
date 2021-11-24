<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@ include file="../common/IncludeTop.jsp"%>
<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        /background-color: #333;/
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
<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >


<h2>분양정보</h2>
<hr>

<table align="center" border>
    <tr>
        <td>종류</td>
        <td>${actionBean.userSale.scategory}</td>
        <td>성별</td>
        <td>${actionBean.userSale.sgender}</td>
    </tr>
    <tr>
        <td>품종</td>
        <td>${actionBean.userSale.sdesc}</td>
        <td>나이</td>
        <td>${actionBean.userSale.sage}</td>
    </tr>
    <tr>
        <td>분양가</td>
        <td>${actionBean.userSale.sprice}</td>
        <td>분양지역</td>
        <td>${actionBean.userSale.sarea}</td>
    </tr>
    <tr>
        <td>분양구분</td>
        <td>${actionBean.userSale.scharge}</td>
    </tr>
    <tr>
        <td>사진1</td>
        <td>${actionBean.userSale.simg1}</td>
    </tr>
    <tr>
        <td>사진2</td>
        <td>${actionBean.userSale.simg2}</td>
    </tr>
    <tr>
        <td>사진3</td>
        <td>${actionBean.userSale.simg3}</td>
    </tr>
</table>
<div style="text-align: center">
    <stripes:submit name="deleteSales" value="삭제"/>
    <stripes:submit name="updateSalesForm" value="수정"/>
    <stripes:submit name="insertAdoptForm" value="입양신청"/>
</div>
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>