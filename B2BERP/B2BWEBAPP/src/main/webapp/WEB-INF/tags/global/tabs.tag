<%-- 
    Document   : tabs
    Created on : Jan 22, 2018, 6:20:01 PM
    Author     : Milap Patel
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="module" tagdir="/WEB-INF/tags/setting/" %> 
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<div class="easyui-tabs" data-options="tabWidth:120,fit:true,tools:'#maintab-tools'" style="width:100%;height:100%">
    <div title="Dashboard" style="padding:0px">
    </div>
    <div title="Settings" style="padding:10px">
        <module:settingMenu></module:settingMenu>
        </div>
        <div title="Products" style="padding:10px">
            <div class="easyui-layout"  data-options="fit:true"  style="height:100%;padding: 0px;">
                <div data-options="region:'west',split:false" title="Backend Details" style="width:200px;">
                </div>
                <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
                </div>
            </div>
        </div>
        <div title="Sales & Order" style="padding:10px">
            <div class="easyui-layout"  data-options="fit:true"  style="height:100%;padding: 0px;">
                <div data-options="region:'west',split:false" title="Backend Details" style="width:200px;">
                </div>
                <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
                </div>
            </div>
        </div>
    </div>


    <div id="maintab-tools">       
        <a href="#" class="easyui-menubutton" data-options="plain:true,menu:'#userTitleMenu'">
            <c:if test="${sessionScope.user.id != null}">
            ${sessionScope.user.loginid}
        </c:if>
    </a>
    <div id="userTitleMenu" style="width:100px;">
        <div>Help</div>
        <div>Update</div>
        <div>About</div>
        <div><a
                href="javascript:ERP.prototype.logoutFormSubmit()"> Logout</a></div>
    </div>
</div>
