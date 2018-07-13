<%-- 
    Document   : edit
    Created on : Jan 28, 2018, 9:26:10 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">Module Create Form</div>
<form id="newBusinessCompanyCreationform" action="domain/businesscompany/create" method="post" novalidate style="margin:0;padding:20px 20px">

    <table id='newBusinessCompanyCreationformTable' style="width: 100%">
        <tr>
            <td style="width: 15%">Business Name : </td>
            <td style="width: 35%"><input name="businessName" class="easyui-textbox" data-options="label:'Module Name'" required="true" style="width:50%;height: 30px;"></td>
        </tr>
        <tr>   <td style="width: 15%">Business Id : </td>
            <td style="width: 35%"><input name="businessId" class="easyui-textbox" data-options="label:'Module Title'" required="true" style="width:50%;height: 30px;"></td>
        </tr>
        <tr>
            <td>Business Category : </td>
            <td><input name="category" class="easyui-textbox" data-options="label:'Module Description'" required="true" style="width:50%;height: 30px;"></td>

        </tr>

        <tr> 
            <td>Business IS Active : </td>
            <td><input name="activeSwitchBusiness" class="easyui-switchbutton" data-options="onText:'Yes',offText:'No',onChange: function(checked){
                       console.log(checked);$('#newBusinessCompanyCreationformTable input[name=active]').val(checked?1:0);
                       }" required="true" style="width:50%;height: 30px;">
                <input type="hidden" name="active" id='active' value="0">
            </td>
        </tr>
        <tr> 
            <td>Business Parent : </td>
            <td>
                <input name="parent" class="easyui-combotree" data-options="url:'domain/businesscompany/businesscompanytreecombo',method:'get',label:'Select Parent',labelPosition:'top'"required="true" style="width:50%;height: 30px;">
            </td>
        </tr>
    </table>
</form>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="Setting.prototype.createNewBusinessCompany();" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-cancel" onclick="$('#businessCreateForm').window({closed: true});" style="width:90px">Cancel</a>
</div>
<style>
    #newModuleCreationformTable tr td{
        padding: 10px;
    }
</style>
