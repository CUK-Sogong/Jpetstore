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
</head>

<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >

    <h2>분양 수정</h2>
    <hr>
    * : 필수 입력 사항
    <table align="center">
        <tr>
            <td>분양자 정보</td>
            <td>${actionBean.account.username}</td>
        </tr>
        <tr>
            <td>* 종류</td>
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
            <td>* 품종</td>
            <td><stripes:text name="userProduct.name" /></td>
        </tr>
        <tr>
            <td>* 성별</td>
            <td>
                <stripes:select name="userItem.attribute1">
                    <stripes:option>수컷</stripes:option>
                    <stripes:option>암컷</stripes:option>
                    <stripes:option>중성화</stripes:option>
                </stripes:select>
            </td>
        </tr>
        <tr>
            <td>* 개월 수</td>
            <td><stripes:text name="userItem.attribute2" /></td>
        </tr>
        <tr>
            <td>* 분양구분</td>
            <td>
                <c:if test="${actionBean.userItem.charge==0}">
                    무료
                </c:if>
                <c:if test="${actionBean.userItem.charge==1}">
                    유료
                </c:if>
            </td>
        </tr>
        <tr>
            <td>* 분양가</td>
            <td>
                <c:if test="${actionBean.userItem.charge==0}">
                    0
                </c:if>
                <c:if test="${actionBean.userItem.charge==1}">
                    <stripes:text name="userItem.listPrice" />
                </c:if>
                단위 : $
            </td>
        </tr>
        <tr>
            <td>* 분양지역</td>
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
            <td>* 특이사항</td>
            <td><stripes:textarea id="test" name="userItem.attribute4" style="width:500px;height:200px;" />
                <div id="test_cnt">(0 / 100)</div>
                <script>
                    $(document).ready(function() {
                        $('#test').on('keyup', function() {
                            $('#test_cnt').html("("+$(this).val().length+" / 100)");

                            if($(this).val().length >= 100) {
                                $(this).val($(this).val().substring(0, 100));
                                $('#test_cnt').html("(100 / 100)");
                            }
                        });
                    });
                </script>
            </td>
        </tr>
    </table>
    <stripes:submit name="updateSales" value="작성"/>
</stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>