<%@ include file="../common/IncludeTop.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean" />

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean">
    Return to BOARD LIST
</stripes:link></div>

<div id="Catalog">

    <h2>게시판</h2>

    <table>
        <tr>
            <th>제목</th>
            <td>${actionBean.board.title}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${actionBean.board.userId}</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td><fmt:formatDate value="${actionBean.board.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><pre>${actionBean.board.content}</pre></td>
        </tr>
    </table>
    <c:if test="${sessionScope.accountBean != null}">
        <c:if test="${sessionScope.accountBean.authenticated}">
            <c:if test="${sessionScope.accountBean.account.username.equals(actionBean.board.userId)}">
                <stripes:link beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean" event="updateBoardForm">
                    수정
                    <stripes:param name="boardId" value="${actionBean.board.bnum}" />
                </stripes:link>
                <stripes:link beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean" event="deleteBoard">
                    삭제
                    <stripes:param name="boardId" value="${actionBean.board.bnum}" />
                </stripes:link>
            </c:if>
        </c:if>
    </c:if>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>




