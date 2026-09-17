# Teste Técnico Prothera

## Ferramenta Utilizada

- **NetBeans IDE 8.2 (Java)**

## Orientações do Teste

Considerando que uma indústria possui os funcionários apresentados na tabela do teste, foi desenvolvido um projeto Java para atender aos seguintes requisitos:

### 1. Classe Pessoa

Criar uma classe `Pessoa` com os atributos:

- `nome` (`String`)
- `dataNascimento` (`LocalDate`)

### 2. Classe Funcionário

Criar uma classe `Funcionario` que estenda a classe `Pessoa`, contendo os atributos:

- `salario` (`BigDecimal`)
- `funcao` (`String`)

### 3. Classe Principal

Criar uma classe `Principal` responsável por executar as seguintes ações:

#### 3.1 - Inserção dos funcionários

Inserir todos os funcionários mantendo a mesma ordem e as mesmas informações apresentadas na tabela do teste.

#### 3.2 - Remoção do funcionário João

Remover o funcionário **João** da lista.

#### 3.3 - Impressão dos funcionários

Imprimir todos os funcionários com todas as suas informações.

- A data deve ser exibida no formato `dd/MM/yyyy`.
- Os valores numéricos devem utilizar ponto (`.`) como separador de milhar e vírgula (`,`) como separador decimal.

#### 3.4 - Aumento salarial

Aplicar um aumento de **10%** no salário de todos os funcionários e atualizar a lista com os novos valores.

#### 3.5 - Agrupamento por função

Agrupar os funcionários por função em um `Map`, utilizando:

- **Chave:** função do funcionário.
- **Valor:** lista de funcionários.

#### 3.6 - Impressão dos funcionários agrupados

Imprimir os funcionários agrupados por função.

#### 3.8 - Aniversariantes

Imprimir os funcionários que fazem aniversário nos meses:

- Outubro (`10`)
- Dezembro (`12`)

#### 3.9 - Funcionário com maior idade

Identificar e imprimir o funcionário com a maior idade, exibindo:

- Nome
- Idade

#### 3.10 - Ordem alfabética

Imprimir a lista de funcionários em **ordem alfabética** pelo nome.

#### 3.11 - Total dos salários

Calcular e imprimir o **valor total dos salários** de todos os funcionários.

#### 3.12 - Salários mínimos

Calcular e imprimir quantos **salários mínimos** cada funcionário recebe.

Para o cálculo, deve ser considerado o salário mínimo de **R$ 1.212,00.**

## Estrutura do Projeto

```text
src/
└── testetecnicoprothera/
    ├── Pessoa.java
    ├── Funcionario.java
    └── Principal.java
```
