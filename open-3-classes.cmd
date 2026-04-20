@echo off
cd /d "%~dp0"
REM Opens the 3 main code files in Cursor/VS Code so they appear in your tab bar.
start "" "cursor" "%~dp0src\test\java\profoodorderbasepackage\profoodorderbaseclass.java" "%~dp0src\test\java\profoodorderpompagepackage\profoodorderpompageclass.java" "%~dp0src\test\java\testngpackage\testngclass.java" 2>nul
if errorlevel 1 start "" "code" "%~dp0src\test\java\profoodorderbasepackage\profoodorderbaseclass.java" "%~dp0src\test\java\profoodorderpompagepackage\profoodorderpompageclass.java" "%~dp0src\test\java\testngpackage\testngclass.java"
exit /b 0
