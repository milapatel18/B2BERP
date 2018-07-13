<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="message"%>

<div class="easyui-layout"  data-options="fit:true"  style="height:100%;padding-top: 10px;">
    <div id="settingModuleMenus" data-options="region:'west',split:false" title="Backend Details" style="width:200px;">
        <div style="margin:20px;padding-bottom:10px;">
            <a href="javascript:void(0)" class="easyui-linkbutton businessModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('business', this)" data-options="iconCls:'erp-icon-datacube',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Main Business</a><br/>
            <a href="javascript:void(0)" class="easyui-linkbutton userModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('user', this)" data-options="iconCls:'erp-icon-users',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Users</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton rolesModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('roles', this)" data-options="iconCls:'erp-icon-users',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Roles</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton attributeModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('attribute', this)" data-options="iconCls:'erp-icon-account',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Attributes</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton clientsModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('clients', this)" data-options="iconCls:'erp-icon-users',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Clients</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton addressModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('address', this)" data-options="iconCls:'erp-icon-home',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Addresses</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton bankingModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('banking', this)" data-options="iconCls:'erp-icon-diary',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Banking</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton taxesModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('taxes', this)" data-options="iconCls:'erp-icon-reports',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Taxes</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton warehousesModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('warehouses', this)" data-options="iconCls:'erp-icon-delivery',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">Warehouses</a> <br/>
            <a href="javascript:void(0)" class="easyui-linkbutton modulesModuleButton settingbuttons" onclick="Setting.prototype.loadMainContentOfModule('modules', this)" data-options="iconCls:'erp-icon-datacube',size:'large',iconAlign:'top'" style="width:120px;padding-bottom:10px;">MODULES</a> <br/>
        </div>
    </div>
    <div id="settingModuleContent" data-options="iconCls:'erp-icon-setting',region:'center',title:'Setting'">
        <div id="businessModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="userModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="rolesModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="attributeModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="clientsModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="addressModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="bankingModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="taxesModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="warehousesModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="modulesModuleContent" class="easyui-panel settingModulePanel" data-options="fit:true" style="padding:0px;"></div>
        <div id="modulesCreateForm" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save',closed:true,modal:true,inline:true" style="width:500px;height:200px;padding:5px;"></div>
        <div id="businessCreateForm" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save',closed:true,modal:true,inline:true" style="width:500px;height:200px;padding:5px;"></div>
    </div>
</div>