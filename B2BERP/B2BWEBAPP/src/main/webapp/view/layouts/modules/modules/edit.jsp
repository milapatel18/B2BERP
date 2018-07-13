<%-- 
    Document   : edit
    Created on : Jan 28, 2018, 9:26:10 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="easyui-tabs" id="modulesEditTabs" data-options="tabWidth:150,fit:true" style="width:100%;height:100%">
    <div title="Basic Details" style="padding:0px">
        <form id="modulesEditform" action="domain/modules/update" method="post" novalidate style="margin:0;padding:20px 20px">
            <input type="hidden" name="id"
                   value="${modules.id}" />
            <table id='modulesEditformTable' style="width: 100%">
                <tr>
                    <td style="width: 15%">Module Name : </td>
                    <td style="width: 35%"><input name="moduleName" value="${modules.moduleName}" class="easyui-textbox" data-options="label:'Module Name'" required="true" style="width:100%;height: 30px;"></td>
                    <td style="width: 15%">Module Title : </td>
                    <td style="width: 35%"><input name="moduleTitle" value="${modules.moduleTitle}" class="easyui-textbox" data-options="label:'Module Title'" required="true" style="width:100%;height: 30px;"></td>
                </tr>
                <tr>
                    <td>Module Description : </td>
                    <td><input name="moduleDesc" class="easyui-textbox" value="${modules.moduleDesc}" data-options="label:'Module Description'" required="true" style="width:100%;height: 30px;"></td>
                    <td>Module Image : </td>
                    <td><input name="moduleImage" class="easyui-textbox" value="${modules.moduleImage}" data-options="label:'Module Image'" required="true" style="width:100%;height: 30px;"></td>
                </tr>
                <tr>
                    <td>Module Type : </td>
                    <td><input name="moduleType" class="easyui-textbox" value="${modules.moduleType}" data-options="label:'Module Type'" required="true" style="width:100%;height: 30px;"></td>
                    <td>Module URL : </td>
                    <td><input name="moduleUrl" class="easyui-textbox" value="${modules.moduleUrl}" data-options="label:'Module URL'" required="true" style="width:100%;height: 30px;"></td>
                </tr>
                <tr> 
                    <td>Module CSS : </td>
                    <td><input name="moduleCss" class="easyui-textbox" value="${modules.moduleCss}" data-options="label:'Module CSS'" required="true" style="width:100%;height: 30px;"></td>
                    <td>Module ICON CLASS : </td>
                    <td><input name="moduleIconClass" class="easyui-textbox" value="${modules.moduleIconClass}" data-options="label:'Module CLASS'" required="true" style="width:100%;height: 30px;"></td>
                </tr>
                <tr> 
                    <td>Module IS PARENT : </td>
                    <td>
                        <input name="hasChildrenSwitch" class="easyui-switchbutton" data-options="checked:${(modules.hasChildren==1)?'true':'false'},onText:'Yes',offText:'No',onChange: function(checked){
                               console.log(checked);$('#modulesEditform input[name=hasChildren]').val(checked?1:0);
                               }" required="true" style="width:100%;height: 30px;">
                        <input type="hidden" name="hasChildren"  value="${modules.hasChildren}">
                    </td>
                    <td>Module IS Active : </td>
                    <td><input name="activeSwitch" class="easyui-switchbutton" data-options="checked:${(modules.active==1)?'true':'false'},onText:'Yes',offText:'No',onChange: function(checked){
                               console.log(checked);$('#modulesEditform input[name=active]').val(checked?1:0);
                               }" required="true" style="width:100%;height: 30px;">
                        <input type="hidden" name="active" id='active'  value="${modules.active}">
                    </td>
                </tr>
                <tr> 
                    <td>Module Priority : </td>
                    <td><input name="priorityIndex" class="easyui-numberbox" value="${modules.priorityIndex}" data-options="min:0,precision:0" required="true" style="width:100%;height: 30px;"></td>
                    <td>Module Parent : </td>
                    <td>
                        <input name="parent" class="easyui-combotree" value="${parentModule.id}" data-options="url:'domain/modules/modulestreecombo',method:'get',label:'Select Parent',labelPosition:'top'"required="true" style="width:100%;height: 30px;">
                        <input name="parentOld" type="hidden" value="${parentModule.id}">
                    </td>
                </tr>
                <tr> 
                    <td colspan="4"> 
                        <div id="">
                            <a href="javascript:void(0)" class="easyui-linkbutton c6" onclick="Setting.prototype.updateModules();" iconCls="icon-ok" onclick="" style="width:90px">UPDATE</a>
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
    <div title="Modules User" style="padding:0px">
        <p>
            List all user to whom this module is assigned.
            Add a button to assign user's to this module. Load only those which are not assigned yet.
            For each selection of user load assigned roles to this user in besides or metadata option whatever is best and it should be also updatable.
        </p>
    </div>
    <div title="Module Business" style="padding:0px">
        <p>Just List all businesses to which this module is assigned. Just Read Only. CRUD will be in Business Section, checked treegrid.</p>
    </div>
    <div title="Module Roles" style="padding:0px">
        <p>This are just auto managed when module is created and deleted. So just list them in Basic Info, not CRUD just list..</p>
        So remove this tab.
    </div>
    <div title="User Roles" style="padding:0px">
        <p>This will be deleted and associated to Modules User TAB.</p>
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

