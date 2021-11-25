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
<script type="text/javascript">
    $(document).ready(function(){

        $("#nextBtn").click(function(){
            if($("#check_1").is(":checked") == false){
                alert("약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
                return;
            }else{
                $("#terms_form").submit();
            }
        });
    });
</script>

<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        focus="" acceptcharset="UTF-8"  >

<h2>입양신청</h2>
<hr>

<table align="center">
    <tr>
        <td>분양자 정보</td>
            <%--        <td>${actionBean.UserSale.suserid}</td>--%>
    </tr>
    <tr>
        <td>거주지역</td>
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
        <td>반려동물 키움여부</td>
        <td>
            <select class ="category1">
                <option value="">예</option>
                <option value="">아니오</option>
            </select>
        </td>
    </tr>
</table>
<table border align="center">
    <tr>
        <td>종류</td>
            <%--        <td>${actionBean.UserSale.scategory}</td>--%>
        <td>성별</td>
            <%--        <td>${actionBean.UserSale.sgender}</td>--%>
    </tr>
    <tr>
        <td>품종</td>
            <%--        <td>${actionBean.UserSale.sdesc}</td>--%>
        <td>나이</td>
            <%--        <td>${actionBean.UserSale.sage}</td>--%>
    </tr>
    <tr>
        <td>분양가</td>
            <%--        <td>${actionBean.UserSale.sprice}</td>--%>
        <td>분양지역</td>
            <%--        <td>${actionBean.UserSale.sarea}</td>--%>
    </tr>
    <tr>
        <td>분양구분</td>
            <%--        <td>${actionBean.UserSale.scharge}</td>--%>
    </tr>
</table>
<div align="center">
    <tr>
        <td>약관</td>
        <br>
        <td>약관 예시 text</td>
    </tr>
</div>
<div style="text-align: center">

    동의합니다
    <p>
        <input type="checkbox" id="check_1"  name="" /> 위의 약관에 동의 합니다.<br />
    </p>

    <stripes:submit name="viewAdoptListAdt2" value="입양 신청"/>
</div>
</stripes:form>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>