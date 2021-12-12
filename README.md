# Verificación y Validación del Software 2021
IWT42 - GRUPO 5

## Instrucciones para utilizar este proyecto
### Prerrequisitos
-	Tener instalado Java.
-	Tener instalado Maven, en caso de no tener Java y/o Maven, sigue las instrucciones de  la siguiente página  https://www.baeldung.com/install-maven-on-windows-linux-mac
-	Se recomienda utilizar IDE de Eclipse o IntelliJ para poder seguir las instrucciones de la manera más sencilla.
### Pasos
1.	Haz un clone del repositorio remoto en su local
2.	Abre el proyecto como proyecto Maven en el IDE de Eclipse o IntelliJ
3.	Asegura de que el run configuration esta configurado correctamente. En caso de duda, consulta el siguiente documento https://docs.google.com/presentation/d/1VX0uWhLNbWvJrnODCPdtUbIMXB_uQEPnDIYJo_HXc-Y/edit#slide=id.p 
4.	Haz clic derecho sobre el proyecto en la pestaña Project del IDE y elige la opción de abrir en terminal
5.	Escribe el siguiente comando en la terminal “mvn clean install”
Una vez hecho el último paso, se compilará el programa y se ejecutarán los tests automáticamente almacenando sus resultados en el directorio target/surefire_reports.
