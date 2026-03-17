# JavaFX Standalone Installer

A **self-contained JavaFX-based installer** for Windows that packages your application into an executable `.jar` and generates a native `.msi` installer — all without requiring users to have Java pre-installed.

This project uses **JavaFX**, **JLink**, and **JPackage** to create a polished installer experience, complete with:
- A **custom Java runtime image** (minimal size, only required modules)
- **Modern JavaFX-based UI**
- **Step-by-step installation wizard**
- **Native Windows `.msi` installer** with Start Menu & Desktop shortcuts

---

## 📂 Project Structure

├── src\                   # Source code directory <br/>
│   ├── app\               # Entry point and main Application class <br/>
│   │   └── InstallerApp.java <br/>
│   ├── panes\             # JavaFX UI panels used in the installer wizard <br/>
│   │   ├── IntroductionPane.java <br/>
│   │   ├── LicensePane.java <br/>
│   │   ├── DirectoryPane.java <br/>
│   │   ├── SummaryPane.java <br/>
│   │   ├── InstallPane.java <br/>
│   │   └── FinishPane.java <br/>
│   └── util\              # Utility classes for helper functions (e.g., unzip) <br/>
│       └── InstallerUtils.java <br/>
│ <br/>
├── resources\             # Extra files/resources to embed in JAR <br/>
│   └── archive.zip <br/>
│ <br/>
├── out\                   # (🛠️ Generated) Compiled .class files (created by compile.bat) <br/>
│   └── app\ <br/>
│   └── panes\ <br/>
│   └── util\ <br/>
│ <br/>
├── runtime\               # (🛠️ Generated) Custom Java runtime (created by generate_runtime.bat) <br/>
│   └── bin\ ... <br/>
│ <br/>
├── installer.jar          # (🛠️ Generated) Bundled JAR file (created by create_jar.bat) <br/>
│ <br/>
├── MyInstaller-1.0.msi    # (🛠️ Generated) Native Windows installer (created by build_msi.bat) <br/>
│ <br/>
├── *.bat                  # Build and run scripts <br/>
│   ├── compile.bat <br/>
│   ├── create_jar.bat <br/>
│   ├── generate_runtime.bat <br/>
│   ├── test_jar_installer.bat <br/>
│   ├── build_msi.bat <br/>
│   └── clean_up.bat <br/>
├── error.log              # (🛠️ Optional) Runtime log if errors occur in GUI launch <br/>


## 🛠 Tools & Requirements

| Tool / Dependency | Purpose |
|-------------------|---------|
| **JDK 17+** | Compile & run JavaFX apps |
| **JavaFX SDK** (e.g., 24.0.1) | UI library |
| **WiX Toolset v3+** | Required for `.msi` creation |
| **Windows 10+ (x64)** | Target OS |
| **Admin Rights** | Required for `.msi` installation testing |

**Download Links**  
- [JDK (Temurin)](https://adoptium.net/en-GB/temurin/releases/)  
- [JavaFX SDK](https://gluonhq.com/products/javafx/)  
- [WiX Toolset](https://wixtoolset.org/releases/)

---

## ⚙️ Environment Configuration

### 1. Install JDK 17 or above
- Add JDK’s `bin` folder to your system PATH  
- Set `JAVA_HOME` environment variable  
```sh JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17```

## 2. Install JavaFX SDK
Extract to:
C:\tools\javafx-sdk-24.0.1

Use lib/ folder in --module-path during compile & run

## 3. Install WiX Toolset
Install WiX Toolset v3+

Add candle.exe and light.exe to PATH
```PATH=C:\Program Files (x86)\WiX Toolset v3.11\bin;%PATH%```

# 🚀 Build & Packaging Process
## Step 1 — (Optional) Clean Previous Builds

```clean_up.bat```
Removes out/, installer.jar, runtime/, .msi, and error.log.

## Step 2 — Compile Java Sources
```compile.bat```

Compiles .java files into .class files inside out/.

## Step 3 — Create Executable JAR
```create_jar.bat```

Bundles compiled classes + archive.zip into installer.jar.

## Step 4 — Generate Custom Java Runtime
```generate_runtime.bat```

Uses jlink to create a minimal runtime containing only the required modules.

## Step 5 — (Optional) Test the JAR
```test_jar_installer.bat```

Runs installer.jar to verify UI & functionality.

## Step 6 — Build Native .msi Installer
```build_msi.bat```

Creates MyInstaller-1.0.msi using jpackage with:

- Start Menu shortcut
- Desktop shortcut
- Bundled runtime

## Script Details 📜

- clean_up.bat	Deletes all generated files
- compile.bat	Compiles Java source files
- create_jar.bat	Packages installer JAR
- generate_runtime.bat	Creates minimal Java runtime using jlink
- test_jar_installer.bat	Runs the installer JAR
- build_msi.bat	Creates native .msi installer using jpackage

## Application UI Flow 🖼

- Introduction Pane – Welcome message & overview

- License Pane – Displays license agreement

- Directory Pane – Choose installation folder

- Summary Pane – Review install settings

- Install Pane – Installation progress bar

- Finish Pane – Completion & exit

## Features 💡
- Fully self-contained installer (no external Java required)
 
- Professional .msi output for Windows
 
- JavaFX-based wizard interface
 
- Step-by-step UI panels for better UX
 
- Custom minimal runtime for reduced size
 
- Automated build process via .bat scripts
