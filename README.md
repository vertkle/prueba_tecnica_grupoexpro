# Prueba técnica GrupoExpro
## Instrucciones de Instalación

1. Clona el repositorio.
2. Ejecuta el proyecto
3. Utiliza algún cliente HTTP (Postman)
4. El proyecto está configurado con spring security (JWT), para acceder a los endpoints, primero tiene que tener el token, para ello, se ha habilitado el siguiente y único usuario: Usuario(admin) & Password(admin). Por defecto correrá en el puerto 8080 (verifica que no tengas ningun proceso corriendo en este puerto). 
![Logo del Proyecto](https://raw.githubusercontent.com/vertkle/prueba_tecnica_grupoexpro/main/src/main/resources/static/login_1.png)

el endpoint es `/api/usuario/login`

Y el body, (repito el único usuario con que funciona es con admin)
```javascript
{
    "usuario": "admin", 
    "password": "admin"
}
```
5. Cuando ya tengas el token, ya podrás utilizar los otros endpoints, continuamos con el endpoint que crea la empresa

![Logo del Proyecto](https://raw.githubusercontent.com/vertkle/prueba_tecnica_grupoexpro/main/src/main/resources/static/create_2_1.png)

el endpoint es `/api/empresa`, con el método POST
Y el body
```javascript
{
    "ruc":"10700469852",
     "razon_social":"razon social test",
     "direccion":"direccion test"
}
```

Luego tienes que poner el token que generaste:
![Logo del Proyecto](https://raw.githubusercontent.com/vertkle/prueba_tecnica_grupoexpro/main/src/main/resources/static/create_2_2.png)

Luego de poner el token, ya puedes ejecutar el endpoint, si resulta ok, te devolverá el objeto insertado.

6. Él último endpoint, te retorna los 3 últimos registros, del mismo modo, necesita el token, para ver la información

![Logo del Proyecto](https://raw.githubusercontent.com/vertkle/prueba_tecnica_grupoexpro/main/src/main/resources/static/get_3.png)



