<%-- 
    Document   : menu
    Created on : Jan 22, 2018, 6:06:39 PM
    Author     : Milap Patel
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>


<c:if test="${pageContext.request.userPrincipal.name != null}">
    <!--                        <h2>
                                User : ${pageContext.request.userPrincipal.name} | <a
                                    href="javascript:formSubmit()"> Logout</a>
                            </h2>-->
</c:if>
<%-- any content can be specified here e.g.: --%>
<div class="easyui-panel" style="padding:5px;">ERP Commerce
    <a href="#" class="easyui-linkbutton c2" icon="icon-ok" data-options="plain:true">Home</a>
    <a href="#" class="easyui-menubutton c3" data-options="menu:'#mm1',iconCls:'icon-edit'">Edit</a>
    <a href="#" class="easyui-menubutton c4" data-options="menu:'#mm2',iconCls:'icon-help'">Logout</a>
    <a href="#" class="easyui-menubutton c6" data-options="menu:'#mm3'">About</a>
</div>
<div id="mm1" style="width:150px;">
    <div data-options="iconCls:'icon-undo'">Undo</div>
    <div data-options="iconCls:'icon-redo'">Redo</div>
    <div class="menu-sep"></div>
    <div>Cut</div>
    <div>Copy</div>
    <div>Paste</div>
    <div class="menu-sep"></div>
    <div>
        <span>Toolbar</span>
        <div>
            <div>Address</div>
            <div>Link</div>
            <div>Navigation Toolbar</div>
            <div>Bookmark Toolbar</div>
            <div class="menu-sep"></div>
            <div>New Toolbar...</div>
        </div>
    </div>
    <div data-options="iconCls:'icon-remove'">Delete</div>
    <div>Select All</div>
</div>
<div id="mm2" style="width:100px;">
    <div>Help</div>
    <div>Update</div>
    <div>About</div>
    <div><a
            href="javascript:ERP.prototype.logoutFormSubmit()"> Logout</a></div>
</div>
<div id="mm3" class="menu-content" style="background:#f0f0f0;padding:10px;text-align:left">
    <img src="webresources/images/micslogo.png">
    <p style="font-size:14px;color:#444;">MITRA INFORMATICS & CONSULTING SERVICES</p>
</div>