package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class RPCClient {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        String opcion = "", firstNumber = "", secondNumber = "";
        do {
            System.out.println("\n1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Exponente");
            System.out.println("6. Raiz");
            System.out.println("7. consultar historial");
            System.out.println("8. salir ");
            System.out.println("Seleccione una opcion...");
            opcion = sc.next();
            if (isNumber(opcion)) {
                switch (Integer.parseInt(opcion)) {
                    case 1:
                        do {
                            System.out.println("--SUMA--");
                            System.out.println("Ingresa el primer número");
                            firstNumber = sc.next();
                            if (!isDouble(firstNumber)) {
                                System.out.println("Ingrese un número valido");
                            }
                        } while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingresa el segundo número");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isDouble(secondNumber));
                        //Ejecucion del metodo en el servidor...
                        Object[] suma = {firstNumber, secondNumber};
                        String response = (String) client.execute("Operations.suma", suma);
                        System.out.println(response);
                        break;

                    case 2:
                        do {
                            System.out.println("Ingresa el primer valor");
                            firstNumber = sc.next();
                            if (!isNumber(firstNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(firstNumber));
                        do {
                            System.out.println("Ingresa el segundo valor");
                            secondNumber = sc.next();
                            if (!isNumber(secondNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(secondNumber));
                        Object[] resta = {firstNumber, secondNumber};
                        String response2 = (String) client.execute("Operations.resta", resta);
                        System.out.println(response2);
                        break;

                    case 3:
                        do {
                            System.out.println("Ingresa el primer valor");
                            firstNumber = sc.next();
                            if (!isNumber(firstNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(firstNumber));
                        do {
                            System.out.println("Ingresa el segundo valor");
                            secondNumber = sc.next();
                            if (!isNumber(secondNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(secondNumber));
                        Object[] multiplicacion = {firstNumber, secondNumber};
                        String response3 = (String) client.execute("Operations.multiplicacion", multiplicacion);
                        System.out.println(response3);
                        break;

                    case 4:
                        do {
                            System.out.println("Ingresa el primer valor");
                            firstNumber = sc.next();
                            if (!isNumber(firstNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(firstNumber));
                        do {
                            System.out.println("Ingresa el segundo valor");
                            secondNumber = sc.next();
                            if (!isNumber(secondNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(secondNumber));
                        Object[] division = {firstNumber, secondNumber};
                        String response4 = (String) client.execute("Operations.division", division);
                        System.out.println(response4);
                        break;

                    case 5:
                        do {
                            System.out.println("Ingresa el primer valor");
                            firstNumber = sc.next();
                            if (!isNumber(firstNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(firstNumber));
                        do {
                            System.out.println("Ingresa el segundo valor");
                            secondNumber = sc.next();
                            if (!isNumber(secondNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(secondNumber));
                        //Se envia la llamada al servidor
                        Object[] exponente = {firstNumber, secondNumber};
                        String response5 = (String) client.execute("Operations.exponente", exponente);//Se envian los numeros al metodo del servidor
                        System.out.println(response5);
                        break;
                    case 6:
                        do {
                            System.out.println("Ingresa el primer valor");
                            firstNumber = sc.next();
                            if (!isNumber(firstNumber)) {
                                System.out.println("Error, ingrese un valor numerico");
                            }
                        } while (!isNumber(firstNumber));
                        //Se envia la llamada al servidor
                        Object[] raiz = {firstNumber};
                        String response6 = (String) client.execute("Operations.raiz", raiz);
                        System.out.println(response6);
                        break;
                    case 7:

                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No existe esa opción");
                        break;

                }
            } else {
                System.out.println("opción invalida");
            }

        } while (!opcion.equals("8"));

    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
