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

  public double getTaxa() {
    return taxa;
  }
}

public class calculoTaxa {

  public static double calcularTaxa(srp_erado product) {
    return product.getpreco() * product.getTaxa();
  }
}
