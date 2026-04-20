# Run Cucumber tests, then open Cucumber report when execution finishes.
$ProjectRoot = $PSScriptRoot
Set-Location $ProjectRoot
$ErrorActionPreference = "Continue"

$mvnPath = "C:\Users\tvams\Downloads\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd"
$mvn = if (Test-Path $mvnPath) { $mvnPath } else { "mvn" }

Write-Host "=== 1. Running Cucumber tests ===" -ForegroundColor Cyan
& $mvn test -Ppro-food-order
$testExit = $LASTEXITCODE

# Once execution has run, open Cucumber report
Start-Sleep -Seconds 8
$reportPath = Join-Path $ProjectRoot "target\cucumber-reports.html"
if (-not (Test-Path $reportPath)) { $reportPath = Join-Path $ProjectRoot "target\cucumber-reports-login.html" }

if (Test-Path $reportPath) {
    Write-Host "`n=== 2. Opening Cucumber report in Chrome ===" -ForegroundColor Cyan
    $fullPath = (Resolve-Path -LiteralPath $reportPath).Path
    $chromePaths = @(
        "C:\Program Files\Google\Chrome\Application\chrome.exe",
        "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe",
        "$env:LOCALAPPDATA\Google\Chrome\Application\chrome.exe"
    )
    $chrome = $null
    foreach ($p in $chromePaths) {
        if (Test-Path $p) { $chrome = $p; break }
    }
    if ($chrome) {
        Start-Process -FilePath $chrome -ArgumentList "`"$fullPath`""
        Write-Host "    Opened in Chrome." -ForegroundColor Gray
    } else {
        Start-Process -FilePath $fullPath
    }
} else {
    Write-Host "`nReport not found. Opening target folder." -ForegroundColor Yellow
    Invoke-Item (Join-Path $ProjectRoot "target")
}

Write-Host "`nDone." -ForegroundColor Green
exit $testExit
