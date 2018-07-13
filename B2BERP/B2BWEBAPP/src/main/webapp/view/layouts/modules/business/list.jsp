<%-- 
    Document   : list
    Created on : Jan 28, 2018, 9:25:49 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br/><hr/>
<table title="Business Companies" class="easyui-treegrid" id="businessCompanyTreeGrid" style="width:100%;height:300px"
       data-options="
       url: 'domain/businesscompany/list',
       rownumbers: true,
       pagination: true,
       pageSize: 5,
       pageList: [5,10,20],
       idField: 'id',
       treeField: 'businessName',
       onBeforeLoad: function(row,param){
       if (!row) {    // load top level rows
       param.id = 0;    // set id=0, indicate to load new page rows
       }
       }
       ">
    <thead>
        <tr>
            <th field="id" width="30">id</th>
            <th field="businessName" width="250">Business Name</th>
            <th field="businessId" width="100" align="right">Business ID</th>
            <th field="category" width="150" align="right">Business category</th>
            <th field="active" width="150" align="right">Business active</th>
        </tr>
    </thead>
</table>
<script>
    $("#businessCompanyTreeGrid").treegrid();
    $("#businessCompanyTreeGrid").treegrid({
        onDblClickRow: function (row) {
            //alert(row.id);
            Setting.prototype.loadEditBusinessCompany(row.id);
        }
    });
</script>
