import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FaturamentoMensal {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Digite o caminho do arquivo dados.xml: ");
    String filePath = input.nextLine();
    
    try {
      File xmlFile = new File(filePath);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();

      NodeList nodeList = doc.getElementsByTagName("row");
      double[] faturamentoDiario = new double[nodeList.getLength()];
      double totalFaturamento = 0;

      for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) node;
          faturamentoDiario[i] = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());
          totalFaturamento += faturamentoDiario[i];
        }
      }

      int diasComFaturamentoAcimaDaMedia = 0;
      double mediaMensal = totalFaturamento / nodeList.getLength();
      double menorFaturamentoDiario = faturamentoDiario[0];
      double maiorFaturamentoDiario = faturamentoDiario[0];

      for (int i = 1; i < nodeList.getLength(); i++) {
        if (faturamentoDiario[i] < menorFaturamentoDiario) {
          menorFaturamentoDiario = faturamentoDiario[i];
        }
        if (faturamentoDiario[i] > maiorFaturamentoDiario) {
          maiorFaturamentoDiario = faturamentoDiario[i];
        }
        if (faturamentoDiario[i] > mediaMensal) {
          diasComFaturamentoAcimaDaMedia++;
        }
      }

      System.out.println("Menor faturamento diário: " + menorFaturamentoDiario);
      System.out.println("Maior faturamento diário: " + maiorFaturamentoDiario);
      System.out.println("Dias com faturamento acima da média: " + diasComFaturamentoAcimaDaMedia);
      
    } catch (Exception e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }
  }
}
