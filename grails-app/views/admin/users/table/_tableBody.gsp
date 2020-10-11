<%@ page import="grails.util.Holders" %>

<tbody>
<g:each in="${users}" var="user">
    <g:render template="/admin/users/table/tableRow" model="[user: user]"/>
</g:each>
</tbody>
