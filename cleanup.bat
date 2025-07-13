@echo off
echo Cleaning up build files...

REM Delete the compiled classes
if exist out (
    echo Deleting 'out' folder...
    rmdir /s /q out
)

REM Delete the generated JAR
if exist installer.jar (
    echo Deleting 'installer.jar'...
    del /f /q installer.jar
)

REM Delete the runtime image
if exist runtime (
    echo Deleting 'runtime' folder...
    rmdir /s /q runtime
)

REM Delete the MSI installer (if exists)
for %%f in (*.msi) do (
    echo Deleting '%%f'...
    del /f /q "%%f"
)

REM Delete any error logs
if exist error.log (
    echo Deleting 'error.log'...
    del /f /q error.log
)

echo Cleanup complete.
pause
