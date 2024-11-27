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


* Na terceira semana do Desafio Alura, focamos em implementar um serviço de autenticação robusto utilizando o Auth0 e o conceito de JWT (JSON Web Token). Essa abordagem garantiu maior segurança e controle no acesso às funcionalidades da aplicação, permitindo a autenticação e autorização de usuários de forma prática e confiável.

Além disso, desenvolvemos a funcionalidade de vídeos gratuitos, que podem ser acessados sem a necessidade de login ou autenticação. Essa implementação teve como objetivo ampliar o alcance da plataforma, oferecendo conteúdo acessível para todos os usuários, enquanto mantemos recursos exclusivos disponíveis apenas para aqueles que estão autenticados.

Foi implementado o Spring Docs no projeto, com o objetivo de proporcionar uma melhor visualização e organização da documentação da API. Essa integração permite que os desenvolvedores e demais stakeholders tenham acesso a uma interface amigável e interativa, facilitando o entendimento das funcionalidades disponíveis, dos endpoints, e dos parâmetros necessários para cada operação. Além disso, contribui para a padronização e a eficiência no desenvolvimento e manutenção do projeto.

Essas melhorias não apenas enriqueceram a experiência do usuário, mas também demonstraram a importância de equilibrar acessibilidade e segurança em uma aplicação moderna. Foi uma semana desafiadora e de grande aprendizado, consolidando conceitos importantes de autenticação e usabilidade.


