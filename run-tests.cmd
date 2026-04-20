@echo off
cd /d "%~dp0"
set MVN=C:\Users\tvams\Downloads\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd
if exist %MVN% (
    call %MVN% clean test %*
) else (
    call mvn clean test %*
)
