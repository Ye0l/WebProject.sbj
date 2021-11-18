<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		xhr.open("POST", "list.do", true);
		xhr.send();
	}
</script>
</head>
<body>
	<div class="container">
		<form name="myForm" method="post">
			
		</form>
	</div>
</body>
</html>