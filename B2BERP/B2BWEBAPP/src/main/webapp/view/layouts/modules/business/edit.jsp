<%-- 
    Document   : edit
    Created on : Jan 28, 2018, 9:26:10 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="easyui-tabs" id="businessEditTabs" data-options="tabWidth:150,fit:true" style="width:100%;height:100%">
    <div title="Basic Details" style="padding:0px">
        <form id="businessCompanyEditform" action="domain/businesscompany/update" method="post" novalidate style="margin:0;padding:20px 20px">
            <input type="hidden" name="id"
                   value="${businessCompany.id}" />
            <table id='businessCompanyEditformTable' style="width: 100%">
                <tr>
                    <td style="width: 10%">Business Name : </td>
                    <td style="width: 90%"><input name="businessName" class="easyui-textbox"value="${businessCompany.businessName}" data-options="label:'Module Name'" required="true" style="width:50%;height: 30px;"></td>
                </tr>
                <tr>   <td>Business Id : </td>
                    <td><input name="businessId" class="easyui-textbox"value="${businessCompany.businessId}" data-options="label:'Module Title'" required="true" style="width:50%;height: 30px;"></td>
                </tr>
                <tr>
                    <td>Business Category : </td>
                    <td><input name="category" class="easyui-textbox"value="${businessCompany.category}" data-options="label:'Module Description'" required="true" style="width:50%;height: 30px;"></td>

                </tr>

                <tr> 
                    <td>Business IS Active : </td>
                    <td><input name="activeSwitchBusiness" class="easyui-switchbutton" data-options="checked:${(businessCompany.active==1)?'true':'false'},onText:'Yes',offText:'No',onChange: function(checked){
                               console.log(checked);$('#businessCompanyEditform input[name=active]').val(checked?1:0);
                               }" required="true" style="width:50%;height: 30px;">
                        <input type="hidden" name="active" id='active' value="${businessCompany.active}">
                    </td>
                </tr>
                <tr> 
                    <td>Business Parent : </td>
                    <td>
                        <input name="parent" value="${parentBusinessCompany.id}" class="easyui-combotree" data-options="url:'domain/businesscompany/businesscompanytreecombo',method:'get',label:'Select Parent',labelPosition:'top'" style="width:50%;height: 30px;">
                        <input name="parentOld" type="hidden" value="${parentBusinessCompany.id}">

                    </td>
                </tr>
                <tr> 
                    <td colspan="4"> 
                        <div id="">
                            <a href="javascript:void(0)" class="easyui-linkbutton c6" onclick="Setting.prototype.updateBusinessCompany();" iconCls="icon-ok" onclick="" style="width:90px">UPDATE</a>
                        </div></td>

                </tr>
            </table>
        </form>


        <style>
            #modulesEditform tr td{
                padding: 10px;
            }
        </style>
    </div>
    <div title="Business Users" style="padding:0px">
        <p>
            List all user to whom this module is assigned.
            Add a button to assign user's to this module. Load only those which are not assigned yet.
            For each selection of user load assigned roles to this user in besides or metadata option whatever is best and it should be also updatable.
        </p>
    </div>
    <div title="Business Clients" style="padding:0px">
        <p>Just List all businesses to which this module is assigned. Just Read Only. CRUD will be in Business Section, checked treegrid.</p>
    </div>
    <div title="Business Modules" style="padding:0px">
        <p>This are just auto managed when module is created and deleted. So just list them in Basic Info, not CRUD just list..</p>
        So remove this tab.
    </div>

</div>
<script type="text/javascript">
    $(".easyui-tabs").tabs();
    $(".easyui-textbox").textbox();
    $(".easyui-switchbutton").switchbutton();
    $(".easyui-combotree").combotree();
    $(".easyui-numberbox").numberbox();
    $(".easyui-linkbutton").linkbutton();
</script>

