# 03_SpringSecurityExample
# Security implementation using JWT tokens

En este ejemplo el funcionamiento es distinto, es decir NO es una autenticación básica
sino que va por token, por lo tanto existe un controlador que responderá al path /auth/login
y hará la autenticación y devolverá un token y por otro lado un filtro para todos los recursos 
que validará este token y al hacerlo extraerá la autenticacion la meterá en el ContextHolder
para que luego spring security válide sus authorities (roles
```
curl -X POST \
  http://localhost:8080/auth/login \
  -H 'Content-Type: application/json' 
  -d '{
	"username":"maiki",
	"password":"12345"
}'
```
Esta petición nos devolverá un response body similar a este:
```
{
    "username": "maiki",
    "avatar": null,
    "roles": [
        "ADMIN",
        "USER"
    ],
    "token": "eyJ0eXAiOiJCZWFyZXIiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MjM5NTUzMjEsImV4cCI6MTYyNDgxOTMyMSwic3ViIjoiOTk5OSIsImZ1bGxOYW1lIjoibWFpa2kiLCJyb2xlcyI6IlVTRVIsQURNSU4ifQ.S0fh1_ehE5G0r1TeniiMQb-k5DuMl8NLwROhNboaR8G-MrPvZ8eb-ZusAdKK1vRhKnmqHnXSueOLFuOc7riNWA"
}
```
De este pillaremos el token y lo enviaremos en cada una de las peticiones por cabecera, con el token type Bearer, así:
```
curl -X GET \
  http://localhost:8080/products \
  -H 'Authorization: Bearer eyJ0eXAiOiJCZWFyZXIiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MjM5NTUzMjEsImV4cCI6MTYyNDgxOTMyMSwic3ViIjoiOTk5OSIsImZ1bGxOYW1lIjoibWFpa2kiLCJyb2xlcyI6IlVTRVIsQURNSU4ifQ.S0fh1_ehE5G0r1TeniiMQb-k5DuMl8NLwROhNboaR8G-MrPvZ8eb-ZusAdKK1vRhKnmqHnXSueOLFuOc7riNWA' 
```