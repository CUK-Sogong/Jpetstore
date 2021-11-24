<%@ include file="../common/IncludeTop.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean" />

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean">
  Return to BOARD LIST
</stripes:link></div>

<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
        focus="" acceptcharset="UTF-8" >

  <h2>게시글 수정</h2>

  <table>
    <tr>
      <td>제목 : </td>
      <td><stripes:text name="board.title" style="width:500px;" /></td>
    </tr>
    <tr>
      <td>내용 : </td>
      <td><stripes:textarea id="test" name="board.content" style="width:500px;height:200px;" />
        <div id="test_cnt">(0 / 500)</div>

        <script>
          $(document).ready(function() {
            $('#test').on('keyup', function() {
              $('#test_cnt').html("("+$(this).val().length+" / 500)");

              if($(this).val().length >= 500) {
                $(this).val($(this).val().substring(0, 500));
                $('#test_cnt').html("(500 / 500)");
              }
            });
          });

        </script>
      </td>
    </tr>

  </table>
  <stripes:param name="boardId" value="${actionBean.board.bnum}" />
  <stripes:submit name="updateBoard" value="수정"/>

</stripes:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>