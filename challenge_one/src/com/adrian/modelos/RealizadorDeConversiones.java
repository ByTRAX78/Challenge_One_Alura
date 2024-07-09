package com.adrian.modelos;

import java.io.IOException;
import java.util.*;
//    USD - Dólar estadounidense
//    ARS - Peso argentino
//    BRL - Real brasileño
//    COP - Peso colombiano
//    MXN - Peso méxicano

public class RealizadorDeConversiones {
    private double cantidadParaConvertir,operacion;
    private ValoresActualesDeModena valoresActualesDeModena;
    private ConexionApi conexionApi = new ConexionApi();
    private String respuesta;
    private String repetirCiclo;
    private int opcion;
    private boolean repetirSwitch = true;
    Scanner scanner = new Scanner(System.in);

    private Historial historial = new Historial();;

    double usd = 0;
    double ars = 0;
    double brl = 0;
    double cop = 0;
    double mxn = 0;



    private String menu = """
            *********************************************
            
            Sea bienvenido/a al Conversor de modenedas =]
                
                Por favor, elija una opción valida ;)
                
            1) Dólar           ==>  Peso argentino
            2) Peso argentino  ==>  Dólar
            3) Dólar           ==>  Real brasileño
            4) Real brasileño  ==>  Dólar
            5) Dólar           ==>  Peso colombiano
            6) Peso colombiano ==>  Dólar 
            7) Dólar           ==>  Peso Méxicano 
            8) Peso Méxicano   ==>  Dólar 
            9) Ver historial
            10)Salir
            
            *********************************************   
            """;
    public void realizarConversion() throws IOException, InterruptedException {


        do{
            try {
                respuesta = "no";
                System.out.println(menu);
                opcion = scanner.nextInt();
                scanner.nextLine();


                switch (opcion){
                    case 1:
                        conversion("USD","ARS","ars");
                        break;
                    case 2:

                        conversion("ARS","USD","usd");
                        break;


                    case 3:


                        conversion("USD","BRL","brl");
                        break;



                    case 4:

                        conversion("BRL","USD","usd");
                        break;

                    case 5:

                        conversion("USD","COP","cop");
                        break;

                    case 6:

                        conversion("COP","USD","usd");
                        break;

                    case 7:

                        conversion("USD","MXN","mxn");
                        break;

                    case 8:

                        conversion("MXN","USD","usd");
                        break;

                    case 9:
                        historial.obtenerHistorial();


                        break;


                    case 10:
                        System.out.println("Gracias por usar esta aplicación :). Hasta luego crack ;)");
                        System.exit(0); // Termina la aplicación
                        break;



                    default:
                        System.out.println("Opción no valida, coloque una opción valida");
                        realizarConversion();
                        break;

                }
            }catch (Exception e){

                System.out.println("Coloca una opción valida, no se permiten letras u otros caracteres.");
                repetirCiclo = "si";
                repetirSwitch = false;
                scanner.nextLine();


            }
            if (repetirSwitch){
                repetir();
            }


        }while (repetirCiclo.equalsIgnoreCase("si"));


        System.out.println("\n\t******Gracias por usar esta aplicación******");
        System.out.println("\n----Aplicación creada por Adrian Martinez Martinez----\n");
        System.exit(0);




    }
    private void operacion(String conversion,double cantidadParaConvertir, double valorACambiar) throws IOException, InterruptedException {
        operacion = cantidadParaConvertir * valorACambiar;
        historial.agregarHistorial(conversion,cantidadParaConvertir,operacion);
        String operacionFormateada = String.format("%.2f",operacion);
        System.out.println("El resultado de la conversión es: $" + operacionFormateada);

        repetir();

    }

    private void repetir() throws IOException, InterruptedException {


        System.out.println("¿Te gustaria hacer otra conversión o elegir otra opción? :) (Coloca 'si' ó 'no')");
        respuesta = scanner.nextLine() ;

        if (respuesta.equalsIgnoreCase("no")){

            repetirCiclo = "no";

        } else if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("\nDe acuerdo, vamos a hacer otra conversión ;)\n");
            realizarConversion();
            scanner.next();
        }else {
            System.out.println("Coloca una opción valida");
            repetir();

        }


    }

    private void conversion(String conversor1, String conversor2, String valorDeModena) throws IOException, InterruptedException {

        try {
            System.out.println("Ingresa la cantidad de " + conversor1 + " que quieres convertir a " + conversor2);
            cantidadParaConvertir = scanner.nextDouble();
            scanner.nextLine();
            valoresActualesDeModena = conexionApi.buscarConversor(conversor1);
            double valor = 0;
            switch (valorDeModena){
                case "usd":
                    valor = valoresActualesDeModena.USD();
                    break;
                case "ars":
                    valor = valoresActualesDeModena.ARS();
                    break;
                case "brl":
                    valor = valoresActualesDeModena.BRL();
                    break;
                case "cop":
                    valor = valoresActualesDeModena.COP();
                    break;
                case "mxn":
                    valor = valoresActualesDeModena.MXN();
                    break;
                default:
                    break;
            }


            operacion(conversor1 + "-" + conversor2,cantidadParaConvertir,  valor);
        }catch (Exception e){
            System.out.println("Coloca una cantidad valida, no se permiten letras u otros caracteres \n");
            scanner.nextLine();
            conversion(conversor1,conversor2,valorDeModena);
        }


    }


}
