# Entendendo Mongo DB e NOSQL
### Problemas do banco de dados relacional:

#### Problema 1: Incompatibilidade de impedância
*   No modelo relacional, os dados estão distribuídos em tabelas diferentes. 
    Se for necessário montar um relatório, será necessário buscar cada um
    em suas respectivas tabelas.
*   Um software precisa constantemente buscar nas tabelas os dados e os juntar 
    adequadamente, sendo um processo "caro”.
*   Transações e junções degradam performance.
#### Problema 2: Grande volume de dados e acessos
*   Escada vertical ou horizontal? +HW ou Cluster/Grid, banco de dados relacionais
não foram projetados para funcionar bem em clusters. Fortemente acoplado.
    
### NoSQL

* Nome NoSQL é acidental
* Vários tipos, mas possuem características comuns:
    - Não utilizam o modelo relacional
    - Funciona bem em clusters
    - Geralmente OpenSource
    - Não tem esquema

### Modelos NoSQL

* Banco de dados orientado a agregados
    - Modelo chave-valor (Raak, Redis)
    - Modelo de documentos (MongoDB, CouchDB)
    - Modelo família de colunas (Cassandra, Apache HBASE)
    
* Banco de dados Grafos (Neo4j)
    - Relacionamentos complexos

### Agregado
> Conjunto de objetos relacionados que desejamos tratar como uma unidade!

Ex: Bloco único com os dados do cliente
```json
[
  {
    "cliente": {
      "id": 1,
      "nome": "Maria"
    },
    "EnderecoEntrega": {
      "id": 1,
      "logradouro": "Rua sei lá",
      "numero": "300"
    }
  }
]
```

> Dados frequentemente acessados juntos > Normalização

## Por que agregados?

* Já possível a estrutura de objetos associados.
* Minimiza impedância
* Unidade natural de replicação e fragmentação

* Nota: Não suportam todo suporte ACID como nos bancos relacionais.
