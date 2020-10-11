<tr>
    <td >${transaction.sendingAccountId}</td>
    <td >${transaction.receivingAccountId}</td>
    <td >${transaction.amount}</td>
    <td >${transaction.status}</td>
    <td >${transaction.type}</td>
    <td data-id = ${transaction.id}><g:if test="${transaction.status == com.neovision.bank.transaction.TransactionStatus.PENDING}">
    <button id="withdraw" type="submit" name="submit">Withdraw</button>
    </g:if>
    </td>
</tr>