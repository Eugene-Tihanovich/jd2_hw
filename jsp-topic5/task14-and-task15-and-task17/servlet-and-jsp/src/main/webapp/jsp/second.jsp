<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>New expenses</title>
</head>
<body>

<h3>Your expenses</h3>

<br>
<table border="3">
<tr>
      <th>Num</th><th>Paydate</th><th>Receiver</th><th>Value</th>
</tr>
    <c:forEach items="${expense}" var="expense">
        <tr>
            <td> ${expense.num} </td>
            <td> ${expense.paydate} </td>
            <td> ${expense.receiver} </td>
            <td> ${expense.value} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>