# 📦 Sistema de Almoxarifado StarLog — Aula 30 (DAO & CRUD Completo)

Implementação completa do padrão arquitetural **DAO (Data Access Object)** em Java com persistência relacional embarcada em **SQLite** (`starlog_almoxarifado.db`).

---

## 📂 Estrutura do Projeto

```text
Aula30-StarLog-DAO-CRUD
├── .vscode/
│   └── settings.json                        <- Configuração de classpath para o VS Code
├── lib/
│   ├── sqlite-jdbc-3.45.1.0.jar             <- Driver JDBC do SQLite
│   ├── slf4j-api-1.7.36.jar                 <- API de Log
│   └── slf4j-simple-1.7.36.jar              <- Implementação simples de Log
├── src/br/com/starlog/
│   ├── model/
│   │   └── Produto.java                     <- Entidade de domínio com validação de invariantes
│   ├── factory/
│   │   └── ConexaoFactory.java              <- Fábrica de conexões JDBC SQLite
│   ├── dao/
│   │   ├── ProdutoDAO.java                  <- Interface de contrato CRUD desacoplada
│   │   └── ProdutoDAOSqlite.java            <- Implementação concreta SQLite (Create, Read, Update, Delete)
│   ├── controller/
│   │   └── ProdutoController.java           <- Camada de orquestração
│   └── main/
│       └── Main.java                        <- Simulação completa das 5 etapas do ciclo de negócio
├── LISTA_INTERATIVA_AULA_30_CRUD.html       <- Enunciado e laboratório interativo da Aula 30
├── executar.bat                             <- Script de compilação e execução rápida (Windows)
└── .gitignore                               <- Ignora binários (.class) e bancos locais (.db)
```

---

## 🚀 Como Compilar e Executar

### Opção 1: Windows (1 clique)
Basta executar o arquivo `executar.bat`.

### Opção 2: Terminal (Windows / Linux / macOS)
```bash
mkdir bin
javac -encoding UTF-8 -cp "lib/*" -d bin src/br/com/starlog/model/*.java src/br/com/starlog/factory/*.java src/br/com/starlog/dao/*.java src/br/com/starlog/controller/*.java src/br/com/starlog/main/*.java

# No Windows:
java -cp "bin;lib/*" br.com.starlog.main.Main

# No Linux / macOS:
java -cp "bin:lib/*" br.com.starlog.main.Main
```
