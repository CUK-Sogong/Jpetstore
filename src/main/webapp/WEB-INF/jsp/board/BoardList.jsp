<%@ include file="../common/IncludeTop.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean" />

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
  Return to MAIN MENU
</stripes:link></div>

<style>
  h2 {
    text-align: center;
  }
  table {
    width: 40%;
  }
  #outter {
    display: block;
    width: 60%;
    margin: auto;
  }
  a {
    text-decoration: none;
  }
</style>
<div id="Catalog">

  <h2>게시판</h2>

    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>

      </tr>
      <c:forEach var="board" items="${actionBean.pageList}">
        <tr>
          <td>${board.bnum+1}</td>
          <td><stripes:link
                  beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
                  event="viewContent">
            <stripes:param name="boardId" value="${board.bnum}" />
            ${board.title}
          </stripes:link></td>
          <td>${board.userId}</td>
          <td> <fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        </tr>
      </c:forEach>
    </table>
    <c:forEach var="i" begin="0" end="${actionBean.size-1}">
      <a><stripes:link
              beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
              event="viewBoard">
        <stripes:param name="page" value="${i}" />
        ${i+1}
      </stripes:link></a>
    </c:forEach>
    <br/>
    <c:if test="${sessionScope.accountBean != null}">
      <c:if test="${sessionScope.accountBean.authenticated}">
        <stripes:link beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean" event="newBoardForm">
          글쓰기
        </stripes:link>
      </c:if>
    </c:if>

  </div>

  <%@ include file="../common/IncludeBottom.jsp"%>




