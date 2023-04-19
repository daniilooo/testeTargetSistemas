import javax.swing.JOptionPane;

public class InverterString {

  public static void main(String[] args) {
    
    // Solicita a entrada do usuário
    String entrada = JOptionPane.showInputDialog(null, "Digite uma palavra ou frase:").toUpperCase();
    
    // Inverte a string utilizando um loop
    String invertido = "";
    for (int i = entrada.length() - 1; i >= 0; i--) {
      invertido += entrada.charAt(i);
    }
    
    // Exibe o resultado ao usuário
    JOptionPane.showMessageDialog(null, "A string invertida é:\n" + invertido);
    
  }
  
}
