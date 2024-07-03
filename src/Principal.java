import Conversor.models.ConversaoDeMoeda;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int option = 0;
        ConversaoDeMoeda coin = new ConversaoDeMoeda();

        String menssage = """
                              --------------------------------------------------------------
                              Seja bem-vindo ao conversor de moedas.
                              
                              escolha uma opção:
                              
                              1 - Converter do Real Brasileiro para o Dolar.
                              2 - Converter do Dolar para o Real Brasileiro.
                              3 - Converter do Peso Argentino para o Dolar.
                              4 - Converter do Dolar para o peso Argentino.
                              5 - Converter do Euro para o Dolar.
                              6 - Converter do Dolar para o Euro.
                              7 - Encerrar.
                              """;
        System.out.println(menssage);
        while(option!=7){
            Scanner optionEntry = new Scanner(System.in);
            try {
                option = optionEntry.nextInt();
                switch (option){
                    case 1:
                        System.out.println("Insira o valor para conversão:");
                        coin.conversao("BRL","USD", optionEntry.nextDouble());
                        System.out.println(menssage);
                        break;
                    case 2:
                        System.out.println("Insira o valor para conversão:");
                        coin.conversao("USD","BRL", optionEntry.nextDouble());
                        System.out.println(menssage);
                        break;
                    case 3:
                        System.out.println("Insira o valor para conversão:");
                        coin.conversao("ARS","USD", optionEntry.nextDouble());
                        System.out.println(menssage);
                        break;
                    case 4:
                        System.out.println("Insira o valor para conversão:");
                        coin.conversao("USD","ARS", optionEntry.nextDouble());
                        System.out.println(menssage);
                        break;
                    case 5:
                        System.out.println("Insira o valor para conversão:");
                        coin.conversao("EUR","USD", optionEntry.nextDouble());
                        System.out.println(menssage);
                        break;
                    case 6:
                        System.out.println("Insira o valor para conversão:");
                        coin.conversao("USD","EUR", optionEntry.nextDouble());
                        System.out.println(menssage);
                        break;
                }if ((option < 1) || (option > 7)) {
                    System.out.println("Opção invalida.");
                    System.out.println(menssage);
                }
            }catch (Exception e){
                System.out.println("Houve um erro na entrada de dados.");
                System.out.println(menssage);
            }
        }
        System.out.println("O sistema foi finalizado.");
    }
}
