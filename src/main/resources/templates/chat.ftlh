<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Chat</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script>
        let webSocket;

        function connect() {
            webSocket = new SockJS("http://localhost:8080/webSockets");

            webSocket.onmessage = function receiveMessage(response) {
                let data = response['data'];
                let json = JSON.parse(data);
                const jsonName = json['chatName'];
                const name = $('#chatName').val();
                if (jsonName === name) {
                    $('#messagesList').first().after("<li>" + json['login'] + ' ' + json['text'] + "</li>");
                }
            }
        }

        function sendMessage(text, pageId, chatName, login) {
            let message = {
                "text": text,
                "from": pageId,
                "chatName": chatName,
                "login": login
            };

            webSocket.send(JSON.stringify(message));
        }
    </script>
</head>
<body onload="connect()">
<param id="chatName" value="${name}">
<h1>${name}</h1>
<p>You are logged as ${login}</p>
<div>
    <label for="message">Text of message</label>
    <input name="message" id="message" placeholder="Message">
    <button onclick="sendMessage($('#message').val(), '${pageId}', '${name}', '${login}')">Send</button>
    <h3>Messages</h3>
    <ul id="messagesList">

    </ul>
</div>
<button onclick="location.href='/'">Back to main</button>
</body>
</html>
