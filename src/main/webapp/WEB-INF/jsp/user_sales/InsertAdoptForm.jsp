<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div><br/><br/>
<head>
    <style>
        table{
            text-align:center;
        }
        td{
            text-align:center;
        }
    </style>
</head>


<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >

<h2>입양신청</h2>
<hr>
* : 필수 입력 사항
<table align="center">
    <tr>
        <td>입양자 정보</td>
        <td>${actionBean.account.username}</td>
    </tr>
    <tr>
        <td>* 거주지역</td>
        <td>
            <stripes:select name="userAdopt.aarea">
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
        <td>* 월급</td>
        <td><stripes:text name="userAdopt.asalary"/> 단위 : $</td>
    </tr>
    <tr>
        <td>* 거주 형태</td>
        <td>
            <stripes:select name="userAdopt.ahome">
                <stripes:option>원룸</stripes:option>
                <stripes:option>투룸</stripes:option>
                <stripes:option>쓰리룸</stripes:option>
                <stripes:option>전원주택</stripes:option>
                <stripes:option>기타</stripes:option>
            </stripes:select>
        </td>
    </tr>

    <tr>
        <td>* 동거인 수</td>
        <td><stripes:text name="userAdopt.afamnum"/></td>
    </tr>
    <tr>
        <td>* 동거 반려동물</td>
        <td><stripes:text name="userAdopt.apets"/> ex) 강아지 1마리, 고양이 1마리</td>
    </tr>
    <tr>
        <td>* 반려동물 키움 경험</td>
        <td>
            <stripes:radio value="1" name="userAdopt.apetexp"/>있음
            <stripes:radio value="0" name="userAdopt.apetexp"/>없음
        </td>
    </tr>
    <tr>
        <td>* 사유 및 각오</td>
        <td>
            <stripes:textarea name="userAdopt.anote"/>
        </td>
    </tr>
</table>
    <h3>반려동물 정보</h3>
    <table align="center" border>
        <tr>
            <td>종류</td>
            <td>${actionBean.userProduct.categoryId}</td>
            <td>성별</td>
            <td>${actionBean.userItem.attribute1}</td>
        </tr>
        <tr>
            <td>품종</td>
            <td>${actionBean.userProduct.name}</td>
            <td>개월 수</td>
            <td>${actionBean.userItem.attribute2}</td>
        </tr>
        <tr>
            <td>분양구분</td>
            <td>
                <c:if test="${actionBean.userItem.charge==0}">
                    무료
                </c:if>
                <c:if test="${actionBean.userItem.charge==1}">
                    유료
                </c:if>
            </td>
            <td>분양지역</td>
            <td>${actionBean.userItem.attribute3}</td>
        </tr>
        <tr>
            <td>분양가</td>
            <td>${actionBean.userItem.listPrice} $</td>
            <td>특이사항</td>
            <td>${actionBean.userItem.attribute4}</td>
        </tr>
        <c:forEach var="img" items="${actionBean.userImageList}">
            <tr>
                <td>사진</td>
                <td colspan='3'><img src=${img.dir} height="300" width="300"/></td>
            </tr>
        </c:forEach>
    </table>
    <stripes:submit name="insertAdopt" value="입양 신청"/>
</stripes:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
</html>