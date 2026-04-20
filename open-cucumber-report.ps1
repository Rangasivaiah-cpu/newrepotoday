# Open Cucumber report in Chrome or Edge (always in a browser).
$reportPath = Join-Path $PSScriptRoot "target\cucumber-reports.html"
if (-not (Test-Path $reportPath)) {
    Write-Host "Report not found. Run tests first: .\run-daily.ps1" -ForegroundColor Yellow
    exit 1
}
$fileUri = ([System.Uri]::new((Get-Item $reportPath).FullName)).AbsoluteUri
if (Test-Path "C:\Program Files\Google\Chrome\Application\chrome.exe") {
    Start-Process "C:\Program Files\Google\Chrome\Application\chrome.exe" $fileUri
} elseif (Test-Path "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe") {
    Start-Process "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" $fileUri
} else {
    Start-Process msedge $fileUri
}
