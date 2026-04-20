# Run TestNG/Cucumber tests. Always runs from project root.
# Usage:
#   .\run-tests.ps1              → runs full suite (Cucumber + Pro Food Order)
#   .\run-tests.ps1 -ProFoodOnly → runs only Pro Food Order tests
$ErrorActionPreference = "Stop"
$ProjectRoot = $PSScriptRoot
Set-Location $ProjectRoot

# Prefer Maven from PATH; fallback to local path if you use a specific install
$mvnPath = "C:\Users\tvams\Downloads\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd"
if ($args -match "-ProFoodOnly") {
    $args = $args | Where-Object { $_ -ne "-ProFoodOnly" }
    if (Test-Path $mvnPath) {
        & $mvnPath clean test -Ppro-food-order @args
    } else {
        mvn clean test -Ppro-food-order @args
    }
} else {
    if (Test-Path $mvnPath) {
        & $mvnPath clean test @args
    } else {
        mvn clean test @args
    }
}
