@echo off
echo Running all batch files in sequence...

echo genearte runtime folder...
call generate_runtime.bat
echo runtime folder generated

echo compiling codebase...
call compile.bat
echo compilation completed


echo creating .jar file
call create_jar.bat
echo .jar file created


echo building msi installer...
call build_msi.bat
echo building msi completed

echo All tasks completed.
pause
