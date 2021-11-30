<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
    Return to MAIN MENU
</stripes:link></div><br/><br/>
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
            text-align:center;
        }
        .td{text-align:center;
            padding-top: 30px;

        }
        tr{
            text-align: center;
        }
        th{
            text-align: center
        }

    </style>
</head>


<ul>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesListAll">
        분양게시판</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_category" value="DOGS" />강아지</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_category" value="CATS" />고양이</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_category" value="FISH" />물고기</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_category" value="BIRDS" />새</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_category" value="REPTILES" />파충류</stripes:link></li>
</ul>
<hr>
<ul>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_charge" value="%" /><stripes:param name="f_order" value='0' />전체분양</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_charge" value='0' />무료분양</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_charge" value='1' />유료분양</stripes:link></li>
    <li><stripes:link beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean" event="viewSalesList">
        <stripes:param name="f_order" value='1' />최신순</stripes:link></li>
    <li><stripes:form
            beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean">
        <stripes:text name="f_search" size="14" />
        <stripes:submit name="viewSalesList" value="검색" />
    </stripes:form></li>
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
<div id="Catalog">
    <h2>${actionBean.msg}</h2>
    <table text-align="center" >
        <tr>
            <th>사진</th>
            <th>품종</th>
            <th width="100">분양 상태</th>
            <th width="100">유료/무료</th>
            <th width="100">성별</th>
            <th>분양지역</th>
            <th>날짜</th>
        </tr>

        <c:forEach var="UserItem" items="${actionBean.userItemList}" varStatus="statusNm">
            <tr>
                <td>
                    <stripes:link
                            beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                            event="viewSales">
                        <stripes:param name="itemId" value="${UserItem.itemId}" />
                        <img src=${UserItem.product.description} height="70" width="70"/>
                    </stripes:link>
                </td>
                <td class="td">${UserItem.product.name}</td>
                    <td class="td">
                        <c:if test = "${UserItem.saleStatus == 0}">
                            분양완료
                        </c:if>
                        <c:if test = "${UserItem.saleStatus == 1}">
                            분양가능
                        </c:if>
                    </td>
                    <td class="td">
                        <c:if test = "${UserItem.charge == 0}">
                            무료
                        </c:if>
                        <c:if test = "${UserItem.charge == 1}">
                            유료
                        </c:if>
                    </td>
                    <td class="td">${UserItem.attribute1}</td>
                    <td class="td">${UserItem.attribute3}</td>
                    <td class="td"><fmt:formatDate value="${UserItem.date}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
    </table>

</div>



<%@ include file="../common/IncludeBottom.jsp"%>
</html>