import java.text.DecimalFormat;
public class Distribuidora {

    public static void main(String[] args) {
        
        // Definição das variáveis de faturamento por estado
        double faturamentoSP = 67836.43;
        double faturamentoRJ = 36678.66;
        double faturamentoMG = 29229.88;
        double faturamentoES = 27165.48;
        double faturamentoOutros = 19849.53;

        // Instanciando a classe DecimalFormat para formatar percentual e moedas.
        DecimalFormat formatPercent = new DecimalFormat("##,##%");
        DecimalFormat formatMoeda = new DecimalFormat("R$ #,##0.00");
        
        // Cálculo do faturamento total
        double faturamentoTotal = faturamentoSP + faturamentoRJ + faturamentoMG + faturamentoES + faturamentoOutros;
        
        // Cálculo do percentual de representação de cada estado
        double percentualSP = faturamentoSP / faturamentoTotal * 100;
        double percentualRJ = faturamentoRJ / faturamentoTotal * 100;
        double percentualMG = faturamentoMG / faturamentoTotal * 100;
        double percentualES = faturamentoES / faturamentoTotal * 100;
        double percentualOutros = faturamentoOutros / faturamentoTotal * 100;
        
        // Impressão dos resultados
        System.out.println("Faturamento total: " +formatMoeda.format(faturamentoTotal));
        System.out.println("Percentual de representação por estado:");
        System.out.println("SP: " + formatPercent.format(percentualSP) + "%");
        System.out.println("RJ: " + formatPercent.format(percentualRJ) + "%");
        System.out.println("MG: " + formatPercent.format(percentualMG)+ "%");
        System.out.println("ES: " + formatPercent.format(percentualES) + "%");
        System.out.println("Outros: " + formatPercent.format(percentualOutros) + "%");
    }
}
