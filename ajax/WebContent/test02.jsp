<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">	
	function sendData() {
		var table = document.getElementById("ajaxTable");
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) {
				var json = this.responseText;
				var list = JSON.parse(json);
				for(var i =0 in list){
					var row = table.insertRow(0);
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					
					cell1.innerHTML = list[i].id;
					cell2.innerHTML = list[i].name;
					cell3.innerHTML = list[i].pwd;
				}
			}
		};
		xhr.open("POST", "list", true);
		xhr.send();
	}
</script>
</head>
<body>
	<div class="container">
	<form name="myForm" method="post">
		<input type="button" name="myname" onclick="sendData()" value="XmLHTTPRequest Send">
	</form>
	<br><br>
	
	<table class="table" style="text-align:center; border:1px solid #dddddd">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>pwd</th>
		</tr>
		<tbody id="ajaxTable">
		</tbody>
	</table>
	</div>
</body>
</html>