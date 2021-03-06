# vackrugerns

Reto para postulaci贸n a KRUGER

## Comenzando 馃殌

Estas instrucciones te permitir谩n obtener una copia del proyecto en funcionamiento en tu m谩quina local para prop贸sitos de desarrollo y pruebas.

## Arquitectura tecnol贸gica

![stack-tecnologico-RETO-KRUGER](https://user-images.githubusercontent.com/12236951/138923948-30be892b-efc5-45d8-9656-ffbacad83a03.png)

### Pre-requisitos 馃搵

* Computador en el cual debe estar instalado la herramienta docker. (Necesario para compilar la aplicaci贸n),
    - Procesador i3 o superior, 贸 en su defecto al menos 2 nucleos.
    - RAM, m帽inimamente 4GB
    - Espacio en disco de 5 GB
    - Conexi贸n a internet.
* Cuenta en dockerhub
* Instalar [Postman](https://www.postman.com/downloads/) 

## Despliegue 馃摝

* En el computador realizar lo siguiente:
	- Clonar el repositorio.
	- Abrir una terminal y situarse en la raiz del proyecto clonado.
	- Ejecutar los siguientes comandos en el orden que precede:
		- $ docker-compose up -d
        (Nota: Espere aproximadamente 5 minutos a que se levanten los servicios)

## Pruebas mediante postman

* Importar los archivos "/springboot-service-vackrugern/newman/KRUGER.postman_collection.json" y "/springboot-service-vackrugern/newman/vackrugern.postman_environment.json" a la herramienta Postman
* Obtener el token a partir de la consulta "oauth"
* Crear un usuario a partir de la consulta "create-user" (Se enviar谩 un correo a la cuenta ingresada, con las credenciales de acceso)
* Actualizar datos del usaurio a partir de la consulta "update-user"

## Quitar despliegue

* En el computador realizar lo siguiente:
    - Abrir una terminal y situarse en la raiz del proyecto clonado.
    - Ejecutar los siguientes comandos en el orden que precede:
        - $ docker-compose down --volume

## Documentaci贸n de servicios web

* Abrir un navegador e ingresar la siguiente url
    http://localhost:9100/swagger-ui.html#/


## Evidencias

![oauth_postman](https://user-images.githubusercontent.com/12236951/138925903-dfd99c76-c868-4f9c-bf17-a4db518b94da.png)

![getuser_postman](https://user-images.githubusercontent.com/12236951/138925961-fde54e54-fd8c-4fd3-baae-2f3c7f08036c.png)

![send_mail](https://user-images.githubusercontent.com/12236951/138925968-76148088-45d7-4fa2-9385-9327ce65ec9a.png)

## EXTRAS

## CI/CD

* Para el despligue sobre el servidor Jenkins, es necesario realizar el build del archivo "DockerfileJenkinsWithDocker"
* Configurar el servidor de acuerdo al manual "config_server_jenkins.docx"

## Construido con 馃洜锔?

* [Maven](https://maven.apache.org/) - Manejador de dependencias backend

## Versionado 馃搶

Usamos [GitHub](https://github.com/) para el versionado.

## Licencia 馃搫

Uso exclusivo para reto KRUGER.

## Expresiones de Gratitud 馃巵

* Caminando por el sendero del bien, gracias Dios.
