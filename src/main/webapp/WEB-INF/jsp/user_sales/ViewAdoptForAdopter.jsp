<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
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
            <td>
                <c:if test="${actionBean.userAdopt.apetexp==1}">있음</c:if>
                <c:if test="${actionBean.userAdopt.apetexp==0}">없음</c:if>
            </td>
        </tr>
        <tr>
            <td>사유 및 각오</td>
            <td>${actionBean.userAdopt.anote}</td>
        </tr>
    </table>
    <h3>분양 정보</h3>
    <c:if test="${actionBean.userItem != null}">
        <table align="center">
        <tr>
            <td>아이디</td>
            <td>${actionBean.userItem.userId}</td>
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
            <td>${actionBean.userItem.product.categoryId}</td>
            <td>성별</td>
            <td>${actionBean.userItem.attribute1}</td>
        </tr>
        <tr>
            <td>품종</td>
            <td>${actionBean.userItem.product.name}</td>
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
    </c:if>
    <c:if test="${actionBean.userItem == null}">
        분양이 삭제되었습니다.<br><br><br>
    </c:if>
    <stripes:submit name="deleteAdopt" value="삭제"/>
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>