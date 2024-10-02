import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String menu = """
                **************************************************
                Sea bienvenido/a al Conversion de Monedas =]
                1) Dolar => Peso argentino
                2) Peso argentino => Dolar
                3) Dolar => Real brasileno
                4) Real brasileno => Dolar
                5) Dolar => Peso colombiano
                6) Peso colombiano => Dolar
                7) Salir
                Elija una opcion valida:
                **************************************************""";

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese la cantidad de dinero a convertir: ");
                double cantidad = teclado.nextDouble();

                switch (opcion) {
                    case 1:
                        Conversor.convertirMoneda("USD", "ARS", cantidad);  // Dólar a Peso Argentino
                        break;
                    case 2:
                        Conversor.convertirMoneda("ARS", "USD", cantidad);  // Peso Argentino a Dólar
                        break;
                    case 3:
                        Conversor.convertirMoneda("USD", "BRL", cantidad);  // Dólar a Real Brasileño
                        break;
                    case 4:
                        Conversor.convertirMoneda("BRL", "USD", cantidad);  // Real Brasileño a Dólar
                        break;
                    case 5:
                        Conversor.convertirMoneda("USD", "COP", cantidad);  // Dólar a Peso Colombiano
                        break;
                    case 6:
                        Conversor.convertirMoneda("COP", "USD", cantidad);  // Peso Colombiano a Dólar
                        break;
                }
            } else if (opcion == 7) {
                System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}