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