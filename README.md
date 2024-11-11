# Alura Challenge - API Rest de Vídeos
Este repositório contém o projeto desenvolvido no Alura Challenge, onde criamos uma API Rest para gerenciar uma lista de vídeos.

## Descrição do Projeto
O objetivo deste projeto é desenvolver uma API que permite operações CRUD (Create, Read, Update, Delete) para gerenciar vídeos em um banco de dados, possibilitando o cadastro, consulta, atualização e exclusão de vídeos.

## 🚀 Tecnologias Utilizadas
* Java com Spring Boot
* Banco de Dados: MySql (ou substitua pelo que estiver usando)
* Maven para gerenciamento de dependências


## 📜 Criação do Modelo de Vídeo:
Funcionalidades Implementadas
Na primeira semana, focamos em:
Criamos uma classe Video que representa o modelo de dados para armazenar informações dos vídeos.
O modelo inclui atributos como título, descrição, URL e outras informações necessárias.
Repository:

Implementamos o repositório VideoRepository, responsável por salvar e manipular os dados dos vídeos no banco de dados.
Controllers e Rotas:

### Implementamos as principais rotas da API para o gerenciamento dos vídeos:
* GET: Recupera uma lista de vídeos ou um vídeo específico por ID
* POST: Adiciona um novo vídeo ao banco de dados
* PUT: Atualiza as informações de um vídeo existente
* DELETE: Remove um vídeo do banco de dados

* Na segunda semana do Desafio Alura, foram implementadas funcionalidades essenciais para o avanço do projeto. Nesta etapa, foi criado o modelo de Categoria, incluindo os métodos GET, PUT, POST e DELETE, possibilitando a manipulação completa dos dados de categorias. Além disso, foi realizada a relação entre Vídeo e Categoria, permitindo uma associação eficiente e estruturada entre essas entidades.

Como parte do processo, também foram desenvolvidos alguns testes automatizados, assegurando a qualidade e a correta funcionalidade dos métodos implementados. Essa série de aprimoramentos reforça a arquitetura do projeto e contribui para a entrega de uma aplicação mais robusta e confiável.


