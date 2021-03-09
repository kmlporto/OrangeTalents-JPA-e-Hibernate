# OrangeTalents-JPA-e-Hibernate

### Modulo 1 - Sobre a Java Persistence API(JPA)

Como é feito a persistência de dados sem usar JPA?
* especificação JDBC - possibilita o reuso de código para nos conectarmos com qualquer banco de dados geracional

O que é JPA? Hibernate?
* JPA é um ORM (Object Relacional Mapper) Java;
	* um ORM mapeia as classes para tabelas e gera o SQL de forma automática;
* JPA é uma especificação no mundo Java que cuida do papel de persistência com mapeamento-objeto-relacional. 
* Hibernate é a a implementação de referência do JPA;
* para inicializar a JPA, é preciso definir um arquivo de configuração, chamado de persistence.xml
	* nesse arquivo está todas as configurações que precisamos dentro de uma unidade de persistência para acessarmos o banco;
* podemos usar JPA para gerar e atualizar as tabelas no banco de dados;
* EntityManager - Interface JPA, por meio dela podemos abstrair o mundo relacional e focar apenas em objetos;
* através da classe Persistence é possível lê as configurações do arquivo persistence.xml e então criar uma EntitiManagerFactory;
* toda entidade deve possuir a annotation @Entity e possuir um identificador anotado como @Id;

### Modulo 2 - Usando EntityManager


