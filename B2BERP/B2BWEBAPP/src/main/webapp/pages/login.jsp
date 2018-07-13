<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<form id="companyuserlogin" style="padding:10px 20px 10px 40px;" method="POST">
    <table>
        <tr>
            <td class="left">Username : </td>
            <td><input type="text" name="username"  class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
        </tr>
        <tr>
            <td>Password : </td>
            <td><input type="password" name="password"  class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
        </tr>
    </table>
    <div style="padding:5px;text-align:center;">
        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-ok" onclick="login()">Login</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-clear">Clear</a>
    </div>
</form>
<style>
    .left{
        padding-left: 0px;
    }
    .textbox{
        height: 25px;
        padding-left: 5px;

    }
</style>
<script type="text/javascript">
    function login() {
        $('#companyuserlogin').form('submit', {
            url: "<%=request.getContextPath()%>/home/login.html",
            method: "POST",
            closable: false,
            onSubmit: function () {

            },
            success: function (data) {
                //alert(data);
                window.location.reload();
                $('#companyuserlogin')[0].reset();
            }
        });
    }
</script>