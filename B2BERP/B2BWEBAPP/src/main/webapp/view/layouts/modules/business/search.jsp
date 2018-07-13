<%-- 
    Document   : search
    Created on : Jan 28, 2018, 9:25:38 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<input class="easyui-searchbox businessCompanySearch" data-options="prompt:'Search for Businesses'" style="width:200px;padding: 20px;">
<a href="javascript:void(0)" onclick="Setting.prototype.createNewBusinessForm('business')" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add New Business</a>
<a href="javascript:void(0)" onclick="Setting.prototype.deleteBusinessSelected('business')"class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove Selection</a>
<script>
    $('.businessCompanySearch').searchbox({
        searcher: function (value, name) {
            alert(value + "," + name);
        },
        prompt: 'Please Input Value'
    });
</script>
