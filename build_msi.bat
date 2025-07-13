jpackage --type msi --name MyInstaller ^
  --input . ^
  --main-jar installer.jar ^
  --main-class app.InstallerApp ^
  --runtime-image runtime ^
  --win-menu ^
  --win-shortcut
