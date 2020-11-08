<html>
	<head><title>Home Page</title></head>
	<body>
		<h1>Hello ! <span th:text="${username}">Username</span></h1>
		<table>
			<tr>
				<th>itemId</th>
				<th>creationId</th>
				<th>unitPrice</th>
			</tr>
			<tr th:each="auction: ${auctions}">
				<td th:text="${auction.itemId}"/>
				<td th:text="${auction.creationDate}"/>
				<td th:text="${auction.unitPrice}"/>
			</tr>
		</table>
	</body>
</html>