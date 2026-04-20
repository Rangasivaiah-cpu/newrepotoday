# Generate and open Allure report (run after tests: .\run-tests.ps1 first).
# Usage: .\allure-report.ps1
$ErrorActionPreference = "Stop"
$ProjectRoot = $PSScriptRoot
Set-Location $ProjectRoot

$mvnPath = "C:\Users\tvams\Downloads\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd"
if (Test-Path $mvnPath) {
    & $mvnPath allure:serve
} else {
    mvn allure:serve
}
