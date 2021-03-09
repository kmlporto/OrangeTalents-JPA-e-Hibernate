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

* Transações - é um conjunto de operações que executam de forma atômica, e  são criadas e gerenciadas pelos SGBD's;
* Estados de objetos com relação ao jpa
	* managed - gerenciado pela JPA, existe uma sincronização dos dados.
		* ao fazer um find, o  JPA ainda terá uma referencia para o objeto devolvido;
		* assim, quando alterarmos algum atributo desse objeto e fazermos o commit, haverá uma sincronização automática;
		* possui id;
	* detached - não é gerenciado pelo JPA, não há sincronização com os dados.
		* podemos ver esse estado quando fechamos a conexão com o EntityManager, após essa conexão ser fechada toda a alteração que é realizada com o objeto em questão ela não é refletida no banco;
		* para refletir alterações realizadas depois de fechar uma conexão com o EntityManager, é necessário criar outro EntityManager (e então volta para o estado managed) e aplicar alterações usando um merge;
		* possui id;
	* transiente - não possui representação no banco de dados, nem o EntityManager o conhece;
		* não possui id;
	* removed - objeto conhecido pelo EntityManage, e que foi deletado no banco de dados;
		* não possui registro no banco, pois acabou de ser removido;
		* possui id;
