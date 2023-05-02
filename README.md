## Back Nisum
El proyecto fue desarrollado con Java 17 y corre por defecto en el puerto 8080.

### Probar la aplicacion:
1. Importar proyecto al IDE, descargar las dependencias del gradle y ejecutarlo.
#### Nota: Este backend usa una base de datos en memoria H2 en la que está cargando automaticamente los datos de un usuario de prueba.

2. Generar el token(JWT): Para esto se hace una peticion tipo POST al endpoint "http://localhost:8080/nisum/api/v1/user-registry/getToken" y se envía un body tipo JSON con los datos del usuario. EJ:
```json
{
"email": "afpena44@gmail.com",
"password": "pipe123"
}
```
![image](https://user-images.githubusercontent.com/30056975/235616098-7b4951dc-bd47-418c-b059-6c9aa8c96971.png)
	
3. Al recibir el codigo 200 OK, en los headers de la respuesta está el Authorization con el token.
4. Adicional a la prueba se desarrolló un endpoint que lista todos los usuarios existentes en la base de datos:
GET - http://localhost:8080/nisum/api/v1/user-registry/user/get-all
#### Nota: Se indica que requiere autorizacion de tipo Bearer Token y se pega el token generado en el paso anterior.
![image](https://user-images.githubusercontent.com/30056975/235616631-7bb98b4c-a95c-48ad-abf5-0f4f6d1b34db.png)

5. El endpoint principal que se solicita en la prueba para la creacion de un usuario es:
POST - http://localhost:8080/nisum/api/v1/user-registry/user/create
#### Nota: Se indica que requiere autorizacion de tipo Bearer Token y se pega el token generado en el paso 2 y 3.
Este endpoint requiere de un body tipo JSON con la siguiente estructura:
```
{
    "name": "Camila Nayely",
    "email": "cami@gmail.com",
    "password": "cami12345",
    "phones": [
        {
            "number": "320 215 14 36",
            "cityCode": "604",
            "contryCode": "57"
        }
    ]
}
```
![image](https://user-images.githubusercontent.com/30056975/235617867-85eecfdd-08cb-4aef-bb63-980725f8cbe9.png)
#### Este endpoint valida que el campo password sea alfanumerico y que tenga mas de 6 caracteres, que el correo tenga un formato correcto y que claramente no exista en la base de datos

6. Para acceder a la documentacion de la api con Swagger la direccion es: http://localhost:8080/nisum/api/v1/user-registry/swagger-ui/index.html

![image](https://user-images.githubusercontent.com/30056975/235621170-65df34cd-c2cd-48fe-8040-4d0043d980cc.png)

# Muchas gracias! estaré muy atento.










