@echo off
echo Running installer.jar...

java --module-path C:\tools\javafx-sdk-24.0.1\lib --add-modules javafx.controls -jar installer.jar

pause
