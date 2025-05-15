import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);

        String endereco = "https://v6.exchangerate-api.com/v6/37d8ab7b08ef036747a171c7/latest/USD";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            apiResposta api = gson.fromJson(response.body(), apiResposta.class);

            String texto =  """
                Seja bem-vindo/a ao Conversor de Moeda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) sair
                Escolha uma opção válida:
                """;

            String opcao = "";

            while (true) {
                System.out.println("*".repeat(20));
                System.out.println(texto);
                System.out.println("*".repeat(20));
                System.out.println();

                opcao = entrada.nextLine();
                if (opcao.equalsIgnoreCase("7")) {
                    System.out.println("Programa finalizado!");
                    break;
                }

                System.out.println("Digite o valor que deseja converter:");
                double valor = entrada.nextDouble();
                entrada.nextLine();
                switch (opcao) {
                    case "1":
                        System.out.println(String.format("Valor %.1f [USD] corresponde ao valor final de =>>> %f [ARS]", valor, api.getConversion_rates().dolarParaPesoArgentino(valor)));
                        break;
                    case "2":
                        System.out.println(String.format("Valor %.1f [ARS] corresponde ao valor final de =>>> %f [USD]", valor, api.getConversion_rates().pesoArgentinoParaDolar(valor)));
                        break;
                    case "3":
                        System.out.println(String.format("Valor %.1f [USD] corresponde ao valor final de =>>> %f [BRL]", valor, api.getConversion_rates().dolarParaRealBrasileiro(valor)));
                        break;
                    case "4":
                        System.out.println(String.format("Valor %.1f [BRL] corresponde ao valor final de =>>> %f [USD]", valor, api.getConversion_rates().realBrasileiroParaDolar(valor)));
                        break;
                    case "5":
                        System.out.println(String.format("Valor %.1f [USD] corresponde ao valor final de =>>> %f [COP]", valor, api.getConversion_rates().dolarParaPesoColombiano(valor)));
                        break;
                    case "6":
                        System.out.println(String.format("Valor %.1f [COP] corresponde ao valor final de =>>> %f [USD]", valor, api.getConversion_rates().pesoColombianoParaDolar(valor)));
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
