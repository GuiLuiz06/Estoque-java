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
* **Objetivo:** Fornecer uma API RESTful robusta e uma interface WEB para gerenciar produtos e categorias, além de registrar rigorosamente todas as movimentações de estoque, garantindo a integridade dos dados.

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
Também é possível executar pelo IntelliJ: abra `src/test/java/com/estoque/projeto/service/MovimentacaoServiceTest.java`, clique com o botão direito e escolha Run `MovimentacaoServiceTest`.

Os testes (JUnit 5) verificam:

| Teste                                            |                                              O que verifica |
| ------------------------------------------------ | ----------------------------------------------------------- |
| **deveCadastrarProduto**                         | O produto é cadastrado, recebe ID e começa com estoque zero |
| **deveRegistrarEntrada**                         |                               Uma entrada aumenta o estoque |
| **deveRegistrarSaida**                           |                                 Uma saída diminui o estoque |
| **naoDevePermitirSaidaMaiorQueEstoque**          |                         Saída maior que o saldo é bloqueada |
| **naoDevePermitirQuantidadeMenorOuIgualAZero**   |                      Quantidade zero ou negativa é recusada |
| **naoDevePermitirProdutoInexistente**            |                  Movimentar produto inexistente é bloqueado |

---

## 9. Estrutura do Projeto

```text
sistema-controle-estoque
 ├── pom.xml
 ├── README.md
 ├── GUIA_APRESENTACAO.md
 └── src/
     ├── main/
     │   ├── java/
     │   │   └─ com/estoque/projeto/
     │   │       ├── Main.java
     │   │       ├── controller/
     │   │       │   ├── CategoriaController.java
     │   │       │   ├── ProdutoController.java
     │   │       │   └── MovimentacaoController.java
     │   │       ├── model/
     │   │       │   ├── Categoria.java
     │   │       │   ├── Produto.java
     │   │       │   └── Movimentacao.java
     │   │       ├── repository/
     │   │       │   ├── CategoriaRepository.java
     │   │       │   ├── ProdutoRepository.java
     │   │       │   └── MovimentacaoRepository.java
     │   │       └── service/
     │   │           ├── CategoriaService.java
     │   │           ├── ProdutoService.java
     │   │           └── MovimentacaoService.java
     │   └── resources/
     │       └── static/
     │           └── index.html
     └── test/
         └── java/
             └── com/
                 └── estoque/
                     └── projeto/
                         └── service/
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

## 11. Prompts
* **Prompt inicial — criação do projeto**
  
"Quero desenvolver um projeto acadêmico chamado Sistema de Controle de Estoque.
 Analise os requisitos da atividade que estou seguindo e desenvolva o projeto completo em Java com Spring Boot e Maven, mantendo uma estrutura simples e adequada para um aluno apresentar e explicar.

 A ideia é que com o projeto possamos fazer o cadastro de categorias, de produtos, controle de estoque, entradas e saídas, regras de negócio, armazenamento em memória (sem banco de dados), organização em Model, Repository, Service e Controller. 
 
 Priorize um código simples e didático. Evite implementar funcionalidades desnecessárias que não sejam exigidas pela atividade.
 
Antes de criar o projeto, apresente a estrutura de pastas e explique brevemente a responsabilidade de cada camada."

O objetivo era pedir que a IA assumisse a construção do projeto acadêmico a partir dos requisitos da atividade, criando a estrutura inicial do sistema.
  
* **Prompt — interface interativa**

"Ajuste o projeto para que eu consiga testar todas as funcionalidades de forma interativa, sem precisar utilizar Postman ou outra ferramenta externa.

 Crie uma interface simples conectada ao Back-End que permita demonstrar: cadastro de categorias, cadastro de produtos, listagem de produtos, entrada de estoque, saída de estoque, consulta de estoque, identificação de estoque baixo, consulta das movimentações.

 A interface deve utilizar as mesmas regras de negócio do projeto, sem criar uma lógica paralela apenas para demonstração.

Mantenha a arquitetura: Controller → Service → Repository → dados em memória.

O objetivo principal é facilitar a demonstração do projeto na apresentação."

Ele mudou o modo de interação, mas não deveria mudar a lógica do sistema.
Antes:
```
Postman / navegador
       ↓
   Controller
       ↓
    Service
       ↓
  Repository

```
Com interface:
```
   Interface
       ↓
   Controller
       ↓
    Service
       ↓
  Repository

```
Ou seja, a interface apenas tornou o sistema mais fácil de utilizar.

* **Prompt — simplificar as classes**

"Quero que todas as classes, métodos e estruturas utilizadas estejam em um nível que eu consiga entender e explicar.

Por exemplo, se existir uma classe como ApiExceptionHandler que não seja necessária para os requisitos e seja difícil de explicar, simplifique ou remova-a.

Depois da revisão: liste o que foi removido, liste o que foi simplificado, explique a responsabilidade de cada classe, explique como as classes se relacionam;"

* **Prompt — README profissional**

"Me ajude com um README.md profissional e completo para o projeto Sistema de Controle de Estoque. O texto deve ser profissional, mas escrito de maneira que um aluno consiga entender e explicar o conteúdo durante uma apresentação."

* **O que aconteceu com os prompts?**

A sequência foi aproximadamente:
```
1. Criar o projeto
        ↓
2. Entregar como projeto pronto
        ↓
3. Criar interface para testar
        ↓
4. Simplificar para eu conseguir explicar
        ↓
5. Documentar profissionalmente
        ↓
6. Trocar HTML por terminal

```

| Etapa                                            |                                       Principal preocupação |
| ------------------------------------------------ | ----------------------------------------------------------- |
| **Criação**                                      |                                             Fazer o sistema |
| **Estrutura**                                    |                                 Conseguir abrir no IntelliJ |
| **Interface**                                    |                                            Conseguir testar |
| **Simplificação**                                |                                          Conseguir explicar |
| **README**                                       |                                        Conseguir documentar |

---

## 12. Participação dos Integrantes

| Integrante         |                Contribuições |
| ------------------ | ---------------------------- |
| **Isadora Maria**  |                        Model |
| **Guilherme Luiz** |                   Repository |
| **Jose Lucas**     |                     Services |
| **Bruno Serpa**    |                  Controllers |
| **Italo Romero**   |                       Testes |
| **Artur Barreto**  |     Documentação / Interface |
