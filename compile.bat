@echo off
echo Compiling JavaFX Installer...

REM Set JavaFX path
set JAVAFX_PATH=C:\tools\javafx-sdk-24.0.1\lib

REM Create output directory if it doesn't exist
if not exist out (
    mkdir out
)

REM Compile all source files
javac --module-path "%JAVAFX_PATH%" --add-modules javafx.controls -d out ^
    src\app\InstallerApp.java ^
    src\panes\*.java ^
    src\util\InstallerUtils.java

IF %ERRORLEVEL% NEQ 0 (
    echo Compilation failed.
    exit /b 1
) ELSE (
    echo Compilation successful.
)

@REM pause
