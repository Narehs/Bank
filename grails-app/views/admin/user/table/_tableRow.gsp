<tr>
    <td >${transaction.sendingAccountId}</td>
    <td >${transaction.receivingAccountId}</td>
    <td >${transaction.amount}</td>
    <td >${transaction.status}</td>
    <td >${transaction.type}</td>
    <td data-id = ${transaction.id}><button id="accept" type="submit" name="submit">Accept</button></td>
    <td data-id = ${transaction.id}><button id="reject" type="submit" name="submit">Reject</button></td>
</tr>