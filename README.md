# Event-Driver-Architecture


curl request to send message

curl --location 'http://localhost:8082/api/v1/publisher/publish' \
--header 'Content-Type: application/json' \
--header 'x-api-key: c4cb57f5-eda9-439a-b91d-b17bd7b80e02' \
--data '{
	"origin": "3191111111",
    "destination": "31922222222",
    "messageType": "TEXT",
    "content": "new message content"
}'