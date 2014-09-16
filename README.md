RunxSrvWs
=============
Projet test regroupant les technos suivantes :
Spring boot : Spring mvc - Spring tymleaf - restFull

L'idée c'est d'afficher une page web restituant les infos d'un fichier FIT Garmin.
Vitesse, BPM, Altitude avec quelques bidouilles de corrections
Plus visu google map.
Et graphiques avec la lib javascript http://www.highcharts.com/demo

Pour lancer : mvn spring-boot:run
Pour lancer en debug : mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
Pour Packager : mvn package (Genere un Jar :D)

Pour lancer le jar : java -jar appli.jar
Pour lancer le jar en debug : java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=5005,suspend=n -jar target/RunxSrvWs*.jar

- Pour acceder à la page web : exemple : http://localhost:8080/map/

- Pour acceder au contenu du fichier FIT en mode brut (RAW) via json : http://localhost:8080/json/fit/Amne/activity/20140824101122/

Ou Amne = nom du user et nom du répertoire

Ou 20140824101122 =  id de l'activité basé sur le nom du fichier FIT dans le répertoire C:\Users\amne\workspace\RunxSrc\Amne\2014-08-24-10-11-22.fit

- Pour acceder à l'activite en mode service via json : http://localhost:8080/json/run/Amne/activity/20140824101122/

Plus info voir fichier controller