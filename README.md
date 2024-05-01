# Backend da Aplicação de Mapeamento e Análise de Ocorrências de Bullying

Este é o backend da aplicação web de mapeamento e análise de ocorrências de bullying. Foi desenvolvido usando Spring Boot e fornece APIs RESTful para manipulação de dados.

## Funcionalidades Principais

- Gerenciamento de ocorrências de bullying, incluindo criação, leitura, atualização e exclusão.
- Análise de padrões de comportamento com base nos dados das ocorrências.
- Autenticação e autorização de usuários.
- Integração com banco de dados para armazenamento de dados.

## Pré-requisitos

- Java Development Kit (JDK) 8 ou superior instalado.
- Apache Maven para compilação e gerenciamento de dependências.
- Um banco de dados compatível (por exemplo, MySQL, PostgreSQL) para armazenar os dados da aplicação.

## Configuração

1. Clone este repositório:

    ```bash
    git clone https://github.com/Jadilumi/CyberWatch.git
    ```

2. Navegue até o diretório clonado:

    ```bash
    cd CyberWatch
    ```

3. Configure as propriedades do banco de dados no arquivo `application.properties`.

4. Compile o projeto:

    ```bash
    mvn clean install
    ```

5. Execute a aplicação:

    ```bash
    java -jar target/cyberwatch.jar
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Documentação da API

A documentação da API está disponível em `http://localhost:8080/swagger-ui.html`, onde você pode explorar os endpoints e realizar testes diretamente na interface Swagger.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias, correções de bugs, ou novas funcionalidades.

## Autores

- [Milton Oliveira](https://github.com/Noltim)
- [Dielder Leal](https://github.com/Dielder)
- [Lucas Crespo](https://github.com/LucasCrespo75)
- [Jailton Junior](https://github.com/jailtonjuniordev)

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
