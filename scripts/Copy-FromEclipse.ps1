# Copy everything from your Eclipse project INTO this Cursor project.
# READ-ONLY for Eclipse: This script only READS from Eclipse and WRITES to Cursor.
# Your Eclipse project, code, and files are NEVER modified or disrupted.

# Run from project root:   .\scripts\Copy-FromEclipse.ps1
# Or with path:            .\scripts\Copy-FromEclipse.ps1 -EclipsePath "C:\Users\tvams\eclipse-workspace\MyProject"

param(
    [Parameter(Mandatory = $false)] { }
    [string]$EclipsePath = "C:\Users\tvams\eclipse-workspace\automation-project-v2"
)

$CursorProject = Split-Path -Parent (Split-Path -Parent $PSScriptRoot)

if (-not (Test-Path $EclipsePath)) {
    Write-Host "ERROR: Eclipse project path not found: $EclipsePath" -ForegroundColor Red
    Write-Host "Edit this script and set `$EclipsePath to your Eclipse project folder, or run:" -ForegroundColor Yellow
    Write-Host "  .\scripts\Copy-FromEclipse.ps1 -EclipsePath 'C:\path\to\your\eclipse-project'" -ForegroundColor Yellow
    exit 1
}

Write-Host "Copying from: $EclipsePath" -ForegroundColor Cyan
Write-Host "Copying to:   $CursorProject" -ForegroundColor Cyan
Write-Host ""

# Copy src (main + test)
$srcFrom = Join-Path $EclipsePath "src"
$srcTo   = Join-Path $CursorProject "src"
if (Test-Path $srcFrom) {
    if (Test-Path $srcTo) {
        Copy-Item -Path "$srcFrom\*" -Destination $srcTo -Recurse -Force
    } else {
        Copy-Item -Path $srcFrom -Destination $srcTo -Recurse -Force
    }
    Write-Host "  [OK] src\" -ForegroundColor Green
} else {
    Write-Host "  [SKIP] src\ not found in Eclipse project" -ForegroundColor Yellow
}

# We do NOT copy pom.xml: Cursor's pom already has your versions and TestNG suite config.
# Your Eclipse pom is never touched.

# Copy testng.xml if at project root
$testngEclipse = Join-Path $EclipsePath "testng.xml"
$testngCursor  = Join-Path $CursorProject "src\test\resources\testng.xml"
if (Test-Path $testngEclipse) {
    $destDir = Split-Path $testngCursor
    if (-not (Test-Path $destDir)) { New-Item -ItemType Directory -Path $destDir -Force | Out-Null }
    Copy-Item $testngEclipse $testngCursor -Force
    Write-Host "  [OK] testng.xml -> src\test\resources\testng.xml" -ForegroundColor Green
}

# Copy any .feature files from project root if present
$featureRoot = Join-Path $EclipsePath "*.feature"
if (Test-Path $featureRoot) {
    $destFeatures = Join-Path $CursorProject "src\test\resources"
    if (-not (Test-Path $destFeatures)) { New-Item -ItemType Directory -Path $destFeatures -Force | Out-Null }
    Copy-Item $featureRoot $destFeatures -Force
    Write-Host "  [OK] *.feature -> src\test\resources\" -ForegroundColor Green
}

Write-Host ""
Write-Host "Done. Next: run in Cursor terminal:  mvn clean test" -ForegroundColor Green
