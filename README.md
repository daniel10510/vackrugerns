# vackrugerns

Reto para postulación a KRUGER

## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

### Pre-requisitos 📋

* Computador en el cual debe estar instalado la herramienta docker. (Necesario para compilar la aplicación),
    - Procesador i3 o superior, ó en su defecto al menos 2 nucleos.
    - RAM, mñinimamente 4GB
    - Espacio en disco de 5 GB
    - Conexión a internet.
* Cuenta en dockerhub

## Despliegue 📦

* En el computador realizar lo siguiente:
	- Clonar el repositorio.
	- Abrir una terminal y situarse en la raiz del proyecto clonado.
	- Ejecutar los siguientes comandos en el orden que precede:
		- $ docker-compose up -d
        (Nota: Espere aproximadamente 5 minutos a que se levanten los servicios)
	
## Quitar despliegue

* En el computador realizar lo siguiente:
    - Abrir una terminal y situarse en la raiz del proyecto clonado.
    - Ejecutar los siguientes comandos en el orden que precede:
        - $ docker-compose down --volume
            
## CI/CD

* Para el despligue sobre el servidor Jenkins, es necesario realizar el build del archivo "DockerfileJenkinsWithDocker"
* Configurar el servidor de acuerdo al manual "config_server_jenkins.docx"

## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias backend

## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado.

## Licencia 📄

Uso exclusivo para reto KRUGER.

## Expresiones de Gratitud 🎁

* Caminando por el sendero del bien, gracias Dios.
