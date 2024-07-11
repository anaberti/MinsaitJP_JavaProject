markdown
Copiar código
# PeoplePlus

[![Build Status](https://img.shields.io/github/workflow/status/anaberti/MinsaitJP_JavaProject/Build)](https://github.com/anaberti/MinsaitJP_JavaProject/actions)
[![License](https://img.shields.io/github/license/anaberti/MinsaitJP_JavaProject)](https://opensource.org/licenses/MIT)

**PeoplePlus** é uma aplicação Java desenvolvida para [Minsait JP](https://www.minsait.com/). O projeto visa fornecer uma plataforma para a gestão de informações de contatos, integrando funcionalidades de CRUD (Create, Read, Update, Delete) com uma interface amigável e uma estrutura de dados eficiente.

## Índice

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Uso](#uso)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Sobre

O **PeoplePlus** é um sistema de gerenciamento de cadastros projetado para facilitar a administração de contatos. A aplicação foi criada como parte de um projeto acadêmico de desenvolvimento de software, com foco em boas práticas de codificação.

## Funcionalidades

- **Cadastro de Pessoas:** Adicione novas Pessoas ao sistema com informações detalhadas.
- **Consulta de Pessoas:** Busque e visualize informações sobre Pessoas existentes.
- **Atualização de Dados:** Edite informações de Pessoas conforme necessário.
- **Exclusão de Pessoas:** Remova Pessoas do sistema quando necessário.
- **Interface Gráfica:** Interface amigável desenvolvida usando Swing para interação com o usuário.
- **Persistência de Dados:** Armazenamento de dados utilizando [JDBC](https://www.oracle.com/java/technologies/jdbc.html) para comunicação com um banco de dados relacional.

## Tecnologias

Este projeto utiliza as seguintes tecnologias:

- **Linguagem:** Java 21
- **Frameworks e Bibliotecas:** 
  - [Swing](https://docs.oracle.com/javase/tutorial/uiswing/) para a interface gráfica
  - [JDBC](https://www.oracle.com/java/technologies/jdbc.html) para a persistência de dados
- **Banco de Dados:** [H2 Database](https://www.h2database.com/html/main.html) (para fins de desenvolvimento e teste)

## Instalação

Para configurar o projeto localmente, siga estas etapas:

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/anaberti/MinsaitJP_JavaProject.git
Navegue até o diretório do projeto:

bash
Copiar código
cd MinsaitJP_JavaProject/PeoplePlus
Compile o projeto:

Você pode usar o Maven ou Gradle para compilar o projeto. Execute um dos seguintes comandos, dependendo da ferramenta que você prefere:

Com Maven:

bash
Copiar código
mvn clean install
Com Gradle:

bash
Copiar código
./gradlew build
Execute a aplicação:

Depois de compilar, você pode executar a aplicação com o comando:

bash
Copiar código
java -cp target/PeoplePlus.jar com.example.Main
Certifique-se de ajustar o caminho e a classe principal conforme necessário.

Uso
Após a instalação, inicie o aplicativo e você verá uma interface gráfica onde você pode adicionar, consultar, atualizar e excluir informações de funcionários. A interface é intuitiva e permite que você acesse todas as funcionalidades principais do sistema.

Contribuição
Se você deseja contribuir para o desenvolvimento do PeoplePlus, siga estas etapas:

Faça um fork do repositório.

Crie uma branch para a sua feature ou correção:

bash
Copiar código
git checkout -b minha-nova-feature
Faça suas alterações e commit:

bash
Copiar código
git commit -am 'Adiciona uma nova feature'
Faça push para a branch:

bash
Copiar código
git push origin minha-nova-feature
Abra um Pull Request.

Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para detalhes.

Contato
Se você tiver dúvidas ou sugestões, entre em contato com o mantenedor:

GitHub: anaberti
