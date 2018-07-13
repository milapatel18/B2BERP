
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="global" tagdir="/WEB-INF/tags/global/" %> 

<c:url value="/home/logout.html" var="logoutUrl" />
<form action="${logoutUrl}" method="get" id="logoutForm">

</form>
<div class="easyui-layout" data-options="fit:true">
    <!--                
    <div data-options="region:'north',hidden:true,collapsed:true" style="height:0px;padding-top: 0px;"></div>
    -->
    <!--                
    <div data-options="region:'south',split:false,hidden:true" style="height:10px;"></div>
    -->
    <div data-options="region:'center',iconCls:'icon-ok'" style="height:100%;">
        <global:tabs></global:tabs>
    </div>
</div>
