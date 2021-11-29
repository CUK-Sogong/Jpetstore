<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div></br></br>
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
        focus="" acceptcharset="UTF-8" enctype="multipart/form-data">
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
            <stripes:select name="userProduct.categoryId">
                <stripes:option value="DOGS">강아지</stripes:option>
                <stripes:option value="CATS">고양이</stripes:option>
                <stripes:option value="FISH">물고기</stripes:option>
                <stripes:option value="BIRDS">새</stripes:option>
                <stripes:option value="REPTILES">파충류</stripes:option>
            </stripes:select>
        </td>
    </tr>
    <tr>
        <td>품종</td>
        <td><stripes:text name="userProduct.name" /></td>
    </tr>
    <tr>
        <td>성별</td>
        <td>
            <stripes:select name="userItem.attribute1">
                <stripes:option>수컷</stripes:option>
                <stripes:option>암컷</stripes:option>
                <stripes:option>중성화</stripes:option>
            </stripes:select>
        </td>
    </tr>
    <tr>
        <td>개월 수</td>
        <td><stripes:text name="userItem.attribute2" /></td>
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
                <stripes:text name="userItem.listPrice" />
            </c:if>
             단위 : $
        </td>
    </tr>
    <tr>
        <td>분양지역</td>
        <td>
            <stripes:select name="userItem.attribute3">
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
        <td><stripes:file name="img1"/></td>
    </tr>
    <tr>
        <td>이미지2</td>
        <td><stripes:file name="img2"/></td>
    </tr>
    <tr>
        <td>이미지3</td>
        <td><stripes:file name="img3"/></td>
    </tr>
    <tr>
        <td>특이사항</td>
        <td><stripes:text name="userItem.attribute4" /></td>
    </tr>
</table>
<stripes:submit name="insertSales" value="작성"/>
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>