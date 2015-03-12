<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebSocket Example</title>
<style type="text/css">
.message-area {
	min-height: 200px;
	max-width: 400px;
	border: 1px solid green;
}
</style>
</head>
<body>
	<h1>WebSocket Example</h1>
	<div>
		<input id="connect" type="button" value="Connect" onclick="connect()">
		<input id="disconnect" type="button" value="Disconnect"
			onclick="disconnect()">
	</div>
	<br>
	<div class="message-area"></div>
	<br>
	<div>
		<input type="text" placeholder="Enter your message!" id="msgtext">
		<input type="button" value="Send!" onclick="send()">
	</div>

	<script src="lib/js/sockjs.min.js"></script>
	<script type="text/javascript" src="lib/js/stomp.js"></script>
	<script type="text/javascript">
		var stompClient = null;
		var messageBox = document.querySelector(".message-area");
		function connect() {
			var socket = new SockJS("/SpringWebSocket/appservice");
			stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame) {
				console.log("connected: ", frame);
				messageBox.innerHTML = messageBox.innerHTML
						+ "<br> connected..";

				stompClient.subscribe("/testResult", function(message) {
					console.log("message received:", message);
					messageBox.innerHTML = messageBox.innerHTML + "<br>"
							+ message.body;
				});

			});
		};

		function send() {
			var message = document.getElementById("msgtext").value;
			stompClient.send("/app/test", {}, message);
		}

		function disconnect() {
			stompClient.disconnect(function() {
				console.log("disconnected!");
				messageBox.innerHTML = messageBox.innerHTML
						+ "<br> disconnected..";
			});
		};
	</script>
</body>
</html>
