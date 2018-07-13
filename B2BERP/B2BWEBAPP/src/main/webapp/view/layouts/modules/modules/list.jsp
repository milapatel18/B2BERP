<%-- 
    Document   : list
    Created on : Jan 28, 2018, 9:25:49 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<br/><hr/>
<table title="Modules" class="easyui-treegrid" id="modulesTreeGrid" style="width:100%;height:300px"
       data-options="
       url: 'domain/modules/list',
       rownumbers: true,
       pagination: true,
       pageSize: 5,
       pageList: [5,10,20],
       idField: 'id',
       treeField: 'moduleName',
       onBeforeLoad: function(row,param){
       if (!row) {    // load top level rows
       param.id = 0;    // set id=0, indicate to load new page rows
       }
       }
       ">
    <thead>
        <tr>
            <th field="id" width="30">id</th>
            <th field="moduleName" width="250">Module Name</th>
            <th field="moduleTitle" width="100" align="right">Module Title</th>
            <th field="moduleType" width="150" align="right">Module Type</th>
            <th field="moduleUrl" width="150" align="right">Module Url</th>
        </tr>
    </thead>
</table>
<script>
    $("#modulesTreeGrid").treegrid();
    $("#modulesTreeGrid").treegrid({
        onDblClickRow: function (row) {
            //alert(row.id);
            Setting.prototype.loadEditModules(row.id);
        }
    });
</script>
