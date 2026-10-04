# Sistema de Controle de Estoque

## 1. Identificação
* **Nome do projeto:** Sistema de Controle de Estoque
* **Participantes:** Artur Barreto, Guilherme Luiz, Jose Lucas, Isadora Maria, Bruno Serpa, Italo Romero.
* **Instituição:** Universidade Tiradentes (UNIT)
* **Turma:** GP0159MAT03B / TURMA ADS 3° PERIODO
* **Disciplina:** DESENVOLVIMENTO BACK-END

---

## 2. Descrição
* **O problema:** A dificuldade de empresas em gerenciar de forma eficiente a entrada, saída e o saldo atual de seus produtos, o que pode gerar inconsistências, perdas ou falta de mercadorias.
* **Público-alvo:** Administradores, gerentes de estoque e funcionários responsáveis pelo controle de inventário da empresa.
* **Objetivo:** Fornecer uma API RESTful robusta e uma interface web para gerenciar produtos e categorias, além de registrar rigorosamente todas as movimentações de estoque, garantindo a integridade dos dados.

---

## 3. Funcionalidades
* **Gerenciamento de Categorias:** Cadastro, listagem, atualização e remoção de categorias de produtos.
* **Gerenciamento de Produtos:** Cadastro, listagem e vinculação de produtos às suas respectivas categorias.
* **Controle de Movimentações:** Registro de entrada e saída de produtos no estoque.
* **Interface Web:** Interface frontend acessível via navegador integrada diretamente na aplicação (`index.html`).

---

## 4. Regras de Negócio
* Uma movimentação de **saída** não pode ser concluída se não houver saldo suficiente do produto no estoque.
* Todo `Produto` deve obrigatoriamente estar vinculado a uma `Categoria` previamente cadastrada.
* Toda `Movimentacao` deve registrar a data/hora da operação, a quantidade movimentada e o tipo (Entrada ou Saída).

---

## 5. Arquitetura

O projeto foi construído utilizando o padrão de camadas MVC/API RESTful, seguindo a estrutura abaixo:

**Controller ↓ Service ↓ Repository**

* **Controller (`ProdutoController`, `MovimentacaoController`, `CategoriaController`):** Responsável por interceptar as requisições HTTP da interface, direcionar para o serviço correto e retornar as respostas ao cliente.
* **Service (`ProdutoService`, `MovimentacaoService`, `CategoriaService`):** Onde reside a lógica de negócio principal. Por exemplo, é nesta camada que o sistema verifica se há estoque suficiente antes de autorizar uma saída.
* **Repository:** Interfaces de persistência que interagem com o banco de dados (Spring Data JPA).
* **Model:** Representação das entidades de domínio (`Produto`, `Categoria`, `Movimentacao`).

---

## 6. Tecnologias
* **Java**
* **Maven** (Gerenciamento de dependências)
* **Spring Boot** (Framework backend principal)
* **Spring Data JPA** (Persistência de dados)
* **JUnit** (Testes unitários)
* **Frontend:** HTML, CSS e JavaScript (com arquivos devidamente separados para melhor organização).

---

## 7. Como Executar

Siga os passos abaixo para rodar a aplicação localmente:

1. Clone o repositório:
```bash
git clone [URL_DO_SEU_REPOSITORIO]

```

2. Acesse o diretório principal do projeto:

```bash
cd sistema-controle-estoque

```

3. Execute a aplicação utilizando o Maven:

```bash
mvn spring-boot:run

```

A API estará rodando na porta padrão (geralmente `8080`). Para acessar a interface, abra o navegador e acesse `http://localhost:8080` (ou `http://localhost:8080/index.html`).

---

## 8. Como Executar os Testes

O projeto conta com testes automatizados para garantir a integridade das regras de negócio (como o `MovimentacaoServiceTest`). Para executá-los, utilize o comando:

```bash
mvn test

```

---

## 9. Estrutura do Projeto

```text
sistema-controle-estoque
 ├── pom.xml
 ├── README.md
 ├── GUIA_APRESENTACAO.md
 └── src
     ├── main
     │   ├── java
     │   │   └── com
     │   │       └── estoque
     │   │           └── projeto
     │   │               ├── Main.java
     │   │               ├── controller
     │   │               ├── model
     │   │               ├── repository
     │   │               └── service
     │   └── resources
     │       └── static
     │           └── index.html
     └── test
         └── java
             └── com
                 └── estoque
                     └── projeto
                         └── service
                             └── MovimentacaoServiceTest.java

```

---

## 10. Histórico do Desenvolvimento

* **Modelagem:** Definição da relação entre as entidades Categoria, Produto e Movimentação.
* **Criação das entidades:** Implementação dos models e mapeamento relacional.
* **Repositories:** Criação das interfaces para conexão e operações no banco de dados.
* **Services:** Implementação das regras de negócio (validação de saldo, cálculo de estoque).
* **Controllers:** Exposição dos endpoints da API.
* **Interface (Frontend):** Desenvolvimento da tela de uso no diretório estático.
* **Testes:** Escrita do `MovimentacaoServiceTest.java` para garantir o funcionamento correto do cálculo de estoque.
* **Documentação:** Elaboração deste documento e do `GUIA_APRESENTACAO.md`.

---

## 11. Prompts utilizados

* **Modelagem:** 
* **Criação das entidades:** 
* **Repositories:** 
* **Services:** 
* **Controllers:** 
* **Interface (Frontend):** 
* **Testes:** 
* **Documentação:** 

---

## 12. Participação dos Integrantes

| Integrante | Contribuições |
| ------------------ | ---------------------------- |
| **Artur Barreto**  | [Descrever as contribuições] |
| **Guilherme Luiz** | [Descrever as contribuições] |
| **Jose Lucas**     | [Descrever as contribuições] |
| **Isadora Maria**  | [Descrever as contribuições] |
| **Bruno Serpa**    | [Descrever as contribuições] |
| **Italo Romero**   | [Descrever as contribuições] |
