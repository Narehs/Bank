<%@ page import="grails.util.Holders" %>

<tbody>
<g:each in="${user.transactions}" var="transaction">
    <g:render template="/user/table/tableRow" model="[transaction: transaction]"/>
</g:each>
</tbody>
