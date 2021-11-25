<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<br>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
        event="viewSalesList">
    Return to SALES LIST
</stripes:link></div></br></br>
<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        /background-color: #333;/
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
<body>

<h2>분양등록</h2>

<hr>

<table align="center">
    <tr>
        <td>
            <stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                    event="insertSalesForm" >
                <stripes:param name="check" value="0" />
                <img src="../images/freesale.gif" height="300" width="300"/>
            </stripes:link>
        </td>
        <td>
            <stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.UserSalesActionBean"
                    event="insertSalesForm">
                <stripes:param name="check" value="1" />
                <img  src="../images/notfreesale.gif" height="300" width="300" />

            </stripes:link>
        </td>
    </tr>
</table>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>