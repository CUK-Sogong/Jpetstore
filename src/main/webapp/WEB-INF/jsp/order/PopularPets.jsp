<%--
       Copyright 2010-2016 the original author or authors.
       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at
          http://www.apache.org/licenses/LICENSE-2.0
       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<jsp:useBean id="order"
             class="org.mybatis.jpetstore.web.actions.OrderActionBean" />

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean">
  Return to MAIN MENU
</stripes:link></div>

<div id="Popular">

  <h2>Popular Pets</h2>

  <table>
    <tr>
      <th>Item ID</th>
      <th>Description</th>
      <th>Quantity</th>
    </tr>
    <c:forEach var="lineItem" items="${actionBean.lineItems}">
      <tr>
        <td><stripes:link
                beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                event="viewItem">
          <stripes:param name="itemId" value="${lineItem.itemId}" />
          ${lineItem.itemId}
        </stripes:link></td>
        <td>${lineItem.item.attribute1} ${lineItem.item.product.name}</td>
        <td>${lineItem.quantity}</td>
      </tr>
    </c:forEach>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>