<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<br>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div></br></br>
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
<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >

<h2>분양등록</h2>

<hr>

<table align="center">
    <tr>
        <td>분양자 정보</td>
        <td>${actionBean.account.username}</td>
    </tr>
    <tr>
        <td>종류</td>
        <td>
            <stripes:select name="userSale.scategory">
                <stripes:option>강아지</stripes:option>
                <stripes:option>고양이</stripes:option>
                <stripes:option>물고기</stripes:option>
                <stripes:option>새</stripes:option>
                <stripes:option>파충류</stripes:option>
                <stripes:option>기타</stripes:option>
            </stripes:select>
        </td>
    </tr>
    <tr>
        <td>품종</td>
        <td><stripes:text name="userSale.sdesc" /></td>
    </tr>
    <tr>
        <td>성별</td>
        <td>
            <stripes:select name="userSale.sgender">
                <stripes:option>수컷</stripes:option>
                <stripes:option>암컷</stripes:option>
                <stripes:option>중성화</stripes:option>
            </stripes:select>
        </td>
    </tr>
    <tr>
        <td>개월 수</td>
        <td><stripes:text name="userSale.sage" /></td>
    </tr>
    <tr>
        <td>분양구분</td>
        <td>
        <c:if test="${actionBean.check==0}">
            무료
        </c:if>
            <c:if test="${actionBean.check==1}">
                유료
            </c:if>
        </td>
    </tr>
    <tr>
        <td>분양가</td>
        <td>
            <c:if test="${actionBean.check==0}">
                0
            </c:if>
            <c:if test="${actionBean.check==1}">
                <stripes:text name="userSale.sprice" />
            </c:if>
        </td>
    </tr>
    <tr>
        <td>분양지역</td>
        <td>
            <stripes:select name="userSale.sarea">
                <stripes:option>서울특별시</stripes:option>
                <stripes:option>경기도</stripes:option>
                <stripes:option>대전광역시</stripes:option>
                <stripes:option>부산광역시</stripes:option>
                <stripes:option>광주광역시</stripes:option>
                <stripes:option>대구광역시</stripes:option>
                <stripes:option>울산광역시</stripes:option>
                <stripes:option>강원도</stripes:option>
                <stripes:option>충청북도</stripes:option>
                <stripes:option>충청남도</stripes:option>
                <stripes:option>경상북도</stripes:option>
                <stripes:option>경상남도</stripes:option>
                <stripes:option>전라북도</stripes:option>
                <stripes:option>전라남도</stripes:option>
                <stripes:option>제주도</stripes:option>
            </stripes:select>
        </td>
    </tr>
    <tr>
        <td>이미지1</td>
        <td><button type="button">첨부</button></td>
    </tr>
    <tr>
        <td>이미지2</td>
        <td><button type="button">첨부</button></td>
    </tr>
    <tr>
        <td>이미지3</td>
        <td><button type="button">첨부</button></td>
    </tr>
    <tr>
        <td>특이사항</td>
        <td><stripes:text name="userSale.snote" /></td>
    </tr>
</table>
<stripes:submit name="insertSales" value="작성"/>
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>