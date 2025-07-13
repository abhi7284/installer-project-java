@echo off
echo Building installer.jar...

jar cfe installer.jar app.InstallerApp -C out . -C resources archive.zip

IF %ERRORLEVEL% NEQ 0 (
    echo Failed to create JAR.
    pause
    exit /b 1
) ELSE (
    echo installer.jar created successfully.
)

pause