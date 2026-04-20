@echo off
cd /d "%~dp0"
powershell -NoProfile -Command ^
  "$f = Join-Path (Get-Location) 'target\cucumber-reports.html';" ^
  "if (-not (Test-Path $f)) { Write-Host 'Report not found. Run tests first.'; exit 1 };" ^
  "$uri = ([System.Uri]::new((Get-Item $f).FullName)).AbsoluteUri;" ^
  "if (Test-Path 'C:\Program Files\Google\Chrome\Application\chrome.exe') { Start-Process 'C:\Program Files\Google\Chrome\Application\chrome.exe' $uri }" ^
  "elseif (Test-Path 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe') { Start-Process 'C:\Program Files (x86)\Google\Chrome\Application\chrome.exe' $uri }" ^
  "else { Start-Process msedge $uri }"
exit /b 0
