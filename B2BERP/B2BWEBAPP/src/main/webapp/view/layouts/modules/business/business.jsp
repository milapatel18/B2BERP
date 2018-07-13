<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="businessContentLayout" class="easyui-layout" data-option="fit:true">
    <div data-options="region:'north',title:'SEARCH BUSINESSES',split:true" style="height:80%;padding: 20px">
        <%@include file="search.jsp" %>
        <%@include file="list.jsp" %>
    </div>
    <div id="businessContentLayoutEditCenter" data-options="region:'center',title:'EDIT BUSINESS COMPANY'" style="padding:5px;height:2px;">

    </div>
</div>

<script>
    $("#businessContentLayout").layout({
        fit: true,
        collapsedContent: function (title) {
            var region = $(this).panel('options').region;
            if (region === 'north' || region === 'center') {
                return title;
            } else {
                return "<div class='mytitle'>" + title + "</div>";
            }
        }
    });
</script>