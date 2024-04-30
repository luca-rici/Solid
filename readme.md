# Single Responsiblity Principle

### O princípio afirma que cada entidade deve ter apenas uma única responsabilidade. 

No código errado a classe produto é responsável pelo cálculo do imposto do produto.
~~~java
public class srp_erado {
  private String titulo;
  private double preco;
  private double taxa;

  public srp_erado(String titulo, double preco, double taxa) {
    this.titulo = titulo;
    this.preco = preco;
    this.taxa = taxa;
  }

  public double calculoTaxa() {
    return preco * taxa;
  }
}
~~~
Para o código ficar correto o cálculo da taxa não deve fazer parte da classe, pois sempre que alterarmos a taxa vamos alterar o produto também. 

No código correto, o cálculo da taxa e feito por outra entidade, assim o cálculo da taxa pode ser feito sem alterar a classe produto, e assim serapando as responsabilidades.

~~~java
public class srp_correto {

  private String titulo;
  private double preco;
  private double taxa;

  public srp_correto(String titulo, double preco, double taxa) {
    this.titulo = titulo;
    this.preco = preco;
    this.taxa = taxa;
  }

  public double getpreco() {
    return preco;
  }

  public double getTaxRate() {
    return taxa;
  }
}

public class calculoTaxa {

  public static double calcularTaxa(srp_erado product) {
    return product.getpreco() * product.getTaxRate();
  }
}
~~~

# Interface Segregation Principle

### É o princípio de design em programação orientada a objetos que afirma que nenhum cliente deve ser forçado a depender de interfaces que não usa.

Portanto, uma única interface deve ser dividida em várias interfaces menores e bem definidas. 

No exemplo, em vez de uma interface única Relogio que suporta configuração de alarme, exibição de temperatura e reprodução de rádio, ela deve ser dividida em Alarme, Radio, Termometro. 
~~~java
interface Relogio {
    void setAlarme(Instant instant);
    float lerTermometro();
    void sincronizarRadio();
}
class relogioAntigo implements Relogio {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public float lerTermometro() {
        throw new operacaoNaoSuportada("Relogio antigo não tem termometro");
    }
    @Override
    public void sincronizarRadio() {
    }
}
class relogioModerno implements Relogio {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public float lerTermometro() {
    }
    @Override
    public void sincronizarRadio() {
        throw new operacaoNaoSuportada("Relogio moderno não suporta Radio");
    }
}
~~~

No código correto,o resultado é que nem todas as classes de relógio precisam suportar rádio ou termômetro. Mas caso queira vai ter uma interface para ter acesso a essa funcionalidade.

~~~java
interface Termometro {
    float lerTermometro();
}
interface Radio {
    void sincronizarRadio();
}   
interface Alarme {
    void setAlarme(Instant instant);
}
class relogioAntigo implements Alarme, Radio {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public void sincronizarRadio() {
    }
}
class relogioMOderno implements Alarme, Termometro {
    @Override
    public void setAlarme(Instant instant) {
    }
    @Override
    public float lerTermometro() {
    }
}
~~~

# Dependecy inversion principle

### Diz que os módulos de alto nível não devem depender de módulos de baixo nível, ambos devem depender de abstrações.

No código erado, a classe LoginService depende diretamente da classe AuthService. Isso significa que qualquer alteração na implementação do AuthService impacta diretamente o LoginService, tornando o código rígido e difícil de testar.

~~~java
public class LoginService {

    private AuthService authService;

    public User login(String username, String password) {
        User user = authService.authenticate(username, password);
        // Processa o login do usuário autenticado
        return user;
    }
}
~~~

No código correto, a classe LoginService agora depende da interface AuthService em vez da implementação concreta. Agora traz flexibilidade para o uso e facilidade para testar.

~~~java
public interface AuthService {
    User authenticate(String username, String password);
}

public class LoginService {

    private AuthService authService;
    public LoginService(AuthService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {
        User user = authService.authenticate(username, password);
        return user;
    }
}
~~~

# Composition over inheritance
### Esse príncipio diz que, as classes devem alcançar comportamento polimórfico e reutilização de código por meio de sua composição, em vez de usar a herança de uma classe base ou pai. 

A herança só deve ser usada quando a subclasse 'é uma' superclasse. Não use herança para reutilizar código. Se não houver relacionamento 'é um', use a composição para reutilização de código.

No exemplo de código usando herança, o Funcionário “é uma” Pessoa ou herda de Pessoa. Todos os relacionamentos de herança são relacionamentos “é um”.

~~~java

class Pessoa {
 String titulo;
 String nome;
 int idade;
}

class Funcionario extends Pessoa { 
 int salario;
 String titulo;
}
~~~
A composição normalmente é “tem um” ou “usa um” relacionamento. 

Com composição, a classe Funcionario possui uma Pessoa. Ele não herda de Pessoa, mas em vez disso recebe o objeto Pessoa, e é por isso que “tem” uma Pessoa.

~~~java
class Pessoa {
 String titulo;
 String nome;
 int idade;

 public Pessoa(String titulo, String nome, String idade) {
    this.titulo = titulo;
    this.nome = nome;
    this.idade = idade;
 }
}

class Funcionario {
 int salario;
 private Pessoa Pessoa;

 public Funcionario(Pessoa p, int salario) {
     this.Pessoa = p;
     this.salario = salario;
 }
}
~~~
