<html lang="en">
<#include "base.ftl">

<#macro title>Users</#macro>

<#macro content>
    <#if users?has_content>
    Пользователи:
        <br>
        Имя Очки
    <br>
    <#list users as u>
        ${u.name} ${u.score}
        <br>
    </#list>
    </#if>
</#macro>



</html>