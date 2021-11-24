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
                <%--        <td>${actionBean.UserSale.suserid}</td>--%>
        </tr>
        <tr>
            <td>종류</td>
            <td>
                <select class ="category1">
                    <option value="">강아지</option>
                    <option value="">고양이</option>
                    <option value="">물고기</option>
                    <option value="">새</option>
                    <option value="">파충류</option>
                    <option value="">기타</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>품종</td>
            <td><stripes:text name="UserSale.sdesc" /></td>
        </tr>
        <tr>
            <td>성별</td>
            <td>
                    <%--            <stripes:select name="account.languagePreference">--%>
                    <%--                <stripes:options-collection collection="${actionBean.languages}" />--%>
                    <%--            </stripes:select>--%>
            </td>
        </tr>
        <tr>
            <td>개월수</td>
            <td><stripes:text name="UserSale.sage" /></td>
        </tr>
        <tr>
            <td>분양구분</td>
            <td>유료 / 무료</td>
        </tr>
        <tr>
            <td>분양가</td>
            <td><stripes:text name="UserSale.sprice" /></td>
        </tr>
        <tr>
            <td>분양지역</td>
            <td>
                <select class ="category1">
                    <option value="">서울특별시</option>
                    <option value="">경기도</option>
                    <option value="">대전광역시</option>
                    <option value="">부산광역시</option>
                    <option value="">광주광역시</option>
                    <option value="">대구광역시</option>
                    <option value="">울산광역시</option>
                    <option value="">강원도</option>
                    <option value="">충청북도</option>
                    <option value="">충청남도</option>
                    <option value="">경상북도</option>
                    <option value="">경상남도</option>
                    <option value="">전라북도</option>
                    <option value="">전라남도</option>
                    <option value="">제주도</option>

                </select>
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
            <td><stripes:text name="UserSale.snote" /></td>
        </tr>
    </table>
    <stripes:submit name="updateSales" value="수정"/>
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>