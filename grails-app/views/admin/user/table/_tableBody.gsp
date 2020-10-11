<%@ page import="grails.util.Holders; com.neovision.bank.transaction.TransactionStatus" %>

<tbody>
<g:each in="${user.transactions}" var="transaction">
    <g:if test="${transaction.status == TransactionStatus.PENDING}">
        <g:render template="/admin/user/table/tableRow" model="[transaction: transaction]"/>
</g:if>
</g:each>
</tbody>
