<%-- 
    Document   : index
    Created on : 5 Jan, 2016, 9:04:16 PM
    Author     : MITRA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>B2B COMMERCE</title>
        <link rel="stylesheet" type="text/css" href="webresources/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="webresources/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="webresources/themes/color.css">
        <link rel="stylesheet" type="text/css" href="webresources/themes/demo/demo.css">
        <script type="text/javascript" src="webresources/scripts/jquery/jquery-1.11.3.js"></script>
        <script type="text/javascript" src="webresources/scripts/jeasyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="webresources/scripts/jeasyui/jquery.edatagrid.js"></script>
        <script type="text/javascript" src="webresources/scripts/jeasyui/jquery.pivotgrid.js"></script>
        <script type="text/javascript" src="webresources/scripts/jeasyui/jquery.portal.js"></script>
        <script type="text/javascript" src="webresources/scripts/jeasyui/datagrid-detailview.js"></script>
        <script type="text/javascript" src="webresources/scripts/erp/mainlayouts.js"></script>
        <script type="text/javascript" src="webresources/scripts/erp/settingModule.js"></script>

    </head>
    <body>
        <%
            if (!session.isNew() && session.getAttribute("userid") != null) {
                int l = Integer.parseInt(session.getAttribute("userid").toString());
        %>
        <%@include file="pages/dashboard.jsp" %>
        <%        } else {
        %>
        <div id="winlogin" class="easyui-window"
             title="Login" minimizable="false" maximizable="false" closable="false" resizable="false"
             style="height: 180px;width: 400px;">
            <%@include file="pages/login.jsp" %>
        </div>
        <%
            }
        %>
    <style>
        .left{
            padding-left: 0px;
        }
        .textbox{
            height: 20px;
            padding-left: 5px;
        }
    </style>
</body>
</html>
