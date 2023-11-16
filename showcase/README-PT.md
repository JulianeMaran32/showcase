# Showcase

Este projeto é um exemplo de implementação de um sistema Java Spring Boot com um conjunto de funcionalidades comuns. O
projeto pode ser usado como ponto de partida para o desenvolvimento de outros sistemas.

O projeto inclui as seguintes características:

* **Testes de normalização e similaridade:** testes automatizados para verificar se os dados estão sendo normalizados e
  se são suficientemente similares para serem considerados iguais.
* **Exception handler:** tratamento de exceções para capturar e responder a erros de forma consistente.
* **Uso de bibliotecas como Lombok, MapStruct, Jackson:** bibliotecas Java para facilitar o desenvolvimento de código.
* **MySQL database:** banco de dados utilizado para armazenar dados da aplicação.
* **Configuração do Lombok e MapStruct:** configuração das bibliotecas Lombok e MapStruct.
* **Docker:** O projeto utiliza o Docker para executar a aplicação. Isso significa que a aplicação pode ser executada em
  qualquer ambiente que tenha o Docker instalado.

--- 

## Tecnologias

* Java 17
* Spring Boot 3
* Docker
* Maven
* MySQL 8

---

## Executando a aplicação

Para executar a aplicação sem o Docker, siga estes passos:

1. Instale o Java JDK 17 ou superior.
2. Instale o Maven.
3. Clone o repositório do projeto.
4. Acesse o diretório do projeto.
5. Execute o comando `mvn clean install` para criar o arquivo JAR da aplicação.
6. Execute o comando `java -jar target/showcase-0.0.1-SNAPSHOT.jar` para iniciar a aplicação.

A aplicação estará disponível no endereço http://localhost:8080.

Para executar a aplicação usando o Docker, siga estes passos:

1. Instale o Docker no seu computador.
2. Clone o repositório do projeto.
3. Acesse o diretório do projeto.
4. Execute o comando `docker build -t showcase .` para criar a imagem Docker.
5. Execute o comando `docker run -p 8080:8080 showcase` para iniciar a aplicação.

A aplicação estará disponível no endereço http://localhost:8080.

---

## Executando os testes

Para executar os testes do projeto, siga estas etapas:

1. Instale o Java JDK 17 ou superior.
2. Instale o Maven.
3. Clone o repositório do projeto.
4. Acesse o diretório do projeto.
5. Execute o comando `mvn clean test`.

Os testes serão executados, e os resultados serão exibidos no console.

Para executar os testes usando o Docker, siga estas etapas:

1. Instale o Docker no seu computador.
2. Clone o repositório do projeto.
3. Acesse o diretório do projeto.
4. Execute o comando `docker build -t showcase .` para criar a imagem Docker.
5. Execute o comando `docker run -p 8080:8080 showcase` para iniciar a aplicação.
6. Execute o comando `docker exec showcase mvn clean test` para executar os testes.

Os testes serão executados, e os resultados serão exibidos no console.

---

## Recomendações

É recomendado configurar o servidor de aplicação Tomcat para executar a aplicação. Isso facilitará a execução e
gerenciamento da aplicação.

* O projeto está configurado para usar o banco de dados MySQL. Para utilizar outro banco de dados, altere a configuração
  do arquivo `application.yaml`.
* O projeto está configurado para usar Lombok e MapStruct. Para desativar o uso dessas bibliotecas, altere a
  configuração do arquivo `pom.xml`.
* Se estiver usando um IDE, como IntelliJ IDEA ou Eclipse, você pode executar a aplicação clicando no botão "Run".
* Se estiver usando o Maven, também é possível executar a aplicação usando o comando `mvn spring-boot:run`.

---

## Implementações Futuras

Além das funcionalidades já implementadas, o projeto visa implementar as seguintes funcionalidades no futuro:

* **Busca de dados na API externa Via Cep:** Essa funcionalidade permitirá que a aplicação busque dados de endereço
  a partir de um CEP usando a API externa Via Cep.
* **Autenticação e autorização:** Essa funcionalidade permitirá que usuários se autentiquem e sejam autorizados a
  acessar a aplicação.
* **Geração de tokens:** Essa funcionalidade permitirá que a aplicação gere tokens para autenticação do usuário.
* **Mensageria com Apache Kafka:** Essa funcionalidade permitirá que a aplicação envie e receba mensagens por meio do
  Apache Kafka.
* **Envio de e-mail com link e senha:** Essa funcionalidade permitirá que a aplicação envie um e-mail com um link para
  redefinição de senha aos usuários.

Essas implementações irão aprimorar a funcionalidade e segurança da aplicação.

---

## Fluxo de Erro

A aplicação possui um fluxo básico de tratamento de erros que lida com erros comuns. Se ocorrer um erro, a aplicação irá
registrar
o erro no console e retornar uma resposta de erro para o usuário.

A aplicação lida com erros usando as seguintes estratégias:

* Registro (Logging): Todos os erros são registrados no console.
* Exceções: Exceções são lançadas para todos os erros que não podem ser tratados de forma adequada.
* Páginas de erro: Páginas de erro são exibidas para usuários em casos de erros que podem ser tratados de forma
  adequada. (implementação futura)

| Code                                 | Description                                                                 |
|:-------------------------------------|:----------------------------------------------------------------------------|
| 400 - ARGUMENT NOT VALID             | Requisição inválida                                                         |
| 400 - EMAIL ALREADY EXISTS           | E-mail já cadastrado no sistema                                             |
| 400 - DOCUMENT NUMBER ALREADY EXISTS | Número de documento já cadastrado no sistema                                |
| 400 - CUSTOMER NOT ACTIVE            | Usuário não cadastrado ou não ativo                                         |
| 401 - UNAUTHORIZED                   | Usuário não atuenticado. Deve realizar o cadastro ou o login.               |
| 403 - FORBIDDEN                      | Página restrita. Usuário não possui permissão para acessar a página.        |
| 404 - CUSTOMER NOT LOGGED IN         | Deve efetuar o login para realizar as alterações desejadas.                 |
| 404 - NOT FOUND                      | Não foi possível encontrar os dados solicitados.                            |
| 404 - CUSTOMER NOT FOUND             | Não foi possível encontrar o cliente!                                       |
| 404 - DOCUMENT NUMBER NOT CHANGEABLE | O númeo de documento não pode ser alterado. Entre em contato com o suporte! |
| 404 - EMAIL NOT CHANGEABLE           | O e-mail não pode ser alterado. Entre em contato com o suporte!             |
| 500 - SERVER ERROR                   | Ocorreu um erro interno no servidor. Tente mais tarde                       |

---