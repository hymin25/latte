<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<title>INDEX</title>
<script type="text/javascript">
$(document).on('click', '#btn_api4', function(e){
	$.ajax({
        url : "/hymin/trade/api_4",
        type: "get",
        data : { "brName" : $("#brName").val() },
        success: function(result){
        	$("#ajax").remove();
            
            if(!result){
            	var person = JSON.stringify(result);
                $("#container").after(person);
                
                alert("존재하지 않는 지점입니다");
                return false;
            }else{            	                
                var person = JSON.stringify(result);
                $("#container").after(person);
            }
        	
        }
    });
});

$(document).on('click', '#btn_api4ddddd', function(e){
	event.preventDefault();
		
	// JSON으로 요청
    var data = {};
    $.each( $(this).serializeArray(), function(index, o){
    	data[o.name] = o.value
    })
        
	$.ajax({
		url: "/hymin/trade/api_4",
		type: "GET",
		dataType: "json",
		contentType: "application/json",  // ajax 통신으로 보내는 타입
		data: JSON.stringify(data),
		success: function(result){
		// ajax 통신 성공 시 로직 수행
		
		}	
	})	
});
</script>
</head>
<body>
	<h1>Trade INDEX</h1>
    <p>views/trade/index.jsp</p>
    
    <a href="<c:url value="/trade/api_1" />">API1</a><br>
    <a href="<c:url value="/trade/api_2" />">API2</a><br>
    <a href="<c:url value="/trade/api_3" />">API3</a><br>
    <form id="add-form" action="" method="get">
		<input type="text" name="brName" id="brName" placeholder="관리점명">
		<button type="button" id="btn_api4">API4 조회</button>
		<p id="container"></p>
	</form>
    
</body>
</html>