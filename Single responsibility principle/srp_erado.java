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
