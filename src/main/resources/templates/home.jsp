<html>
	<head><title>Home Page</title></head>
	<body>
		<h1>Hello ! <span th:text="${username}">Username</span></h1>
		<p>Welcome to <span th:text="${appName}">Our App</span></p>
		<table>
			<tr>
				<th>itemId</th>
				<th>creationId</th>
				<th>unitPrice</th>
			</tr>
			<tr th:each="auction: ${topTenAuctions}">
				<td th:text="${auction.itemId}"/>
				<td th:text="${auction.creationDate}"/>
				<td th:text="${auction.unitPrice}"/>
			</tr>
		</table>
		<form th:action="@{/auctionItem}" method="POST" th:object="${auction}">
			itemId : <input type="text" th:field="*{itemId}"/>
			<input type="submit" value="Submit"/> 
		</form>
	</body>
</html>