@echo off
chcp 65001 > nul
cls
echo ======================================================================
echo   StarLog Almoxarifado (Aula 30) • Compilando e Executando CRUD SQLite
echo ======================================================================
echo.

if not exist "bin" mkdir bin

echo [1/2] Compilando as classes Java...
javac -encoding UTF-8 -cp "lib/*" -d bin src/br/com/starlog/model/*.java src/br/com/starlog/factory/*.java src/br/com/starlog/dao/*.java src/br/com/starlog/controller/*.java src/br/com/starlog/main/*.java

if %errorlevel% neq 0 (
    echo [ERRO] Falha durante a compilacao!
    pause
    exit /b 1
)

echo [2/2] Executando a simulacao completa do CRUD...
echo ======================================================================
java -cp "bin;lib/*" br.com.starlog.main.Main

echo.
pause
