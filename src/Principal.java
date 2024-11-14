import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
        public static void main(String[] args) {
            Scanner lectura = new Scanner(System.in);
            int opccionSeleccionada = 0;

            ConsultaConversor consulta = new ConsultaConversor();

            Calculos calculos = new Calculos(consulta);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();

            List<String> respuesta = new ArrayList<>();

            String menu = """
                \n **¡Bienvenido a la App de C3onversión de moneda!"**
                *Convierta fácilmente sus monedas con solo unos clics*
                  
                Elija una opción de cambio:
                  
                1. Peso Colombiano      ==>> Dólar Estadounidense
                2. Dólar Estadounidense ==>> Peso Colombiano
                3. Peso Colombiano      ==>> Euro
                4. Euro                 ==>> Peso Colombiano
                5. Peso Colombiano      ==>> Libra esterlina
                6. Libra esterlina      ==>> Peso Colombiano
                
                7. Más opciones de conversion.
                
                8. Salir.
                *****************************************
                """;

            while (opccionSeleccionada != 8){
                try {
                    System.out.println(menu);
                    opccionSeleccionada = Integer.parseInt(lectura.nextLine());

                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formattedDate = myDateObj.format(myFormatObj);

                    switch (opccionSeleccionada){
                        case 1:
                            calculos.almacenarValores("COP", "USD");
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 2:
                            calculos.almacenarValores("USD", "COP");
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 3:
                            calculos.almacenarValores("COP", "EUR");
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 4:
                            calculos.almacenarValores("EUR", "COP");
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 5:
                            calculos.almacenarValores("COP", "GBP");
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 6:
                            calculos.almacenarValores("GBP", "COP");
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 7:
                            calculos.almacenarValoresPersonalizados();
                            respuesta.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Ingrese una opción válida");
                    }
                } catch (JsonSyntaxException | NullPointerException e) {
                    System.out.println("Error. Ingrese solo códigos de moneda válidos.");
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("Error. Ingrese un valor numérico válido.");
                }
            }
            generador.guardarJson(respuesta);

            System.out.println("Gracias por usar la App de Conversión de Monedas. ¡Hasta pronto!");
        }
    }

