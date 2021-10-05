<html>
	<body>
		<span>${employee.id} ${employee.name}  ${employee.pNo} </span>
		<a href="get">Click Here to get list of employees!!!</a><br/>
		Add Form<br/>
		<form action="add" method="POST" modelAttribute="Employee">
			Enter Id:<input type="textbox" name="id"/><br/>
			<input type="textbox" name="name"/><br/>
			<input type="textbox" name="pNo"/><br/>
			<button>ADD</button>
		</form>
		Update Form<br/>
		<form action="modify" method="POST" modelAttribute="Employee">
			Enter Id:<input type="textbox" name="id"/><br/>
			<input type="textbox" name="name"/><br/>
			<input type="textbox" name="pNo"/><br/>
			<button>UPDATE</button>
		</form>
		DELETE Form<br/>
		<form action="remove" method="POST" modelAttribute="Employee">
			Enter Id:<input type="textbox" name="id"/><br/>
			
			<button>DELETE</button>
		</form>
	</body>
</html>