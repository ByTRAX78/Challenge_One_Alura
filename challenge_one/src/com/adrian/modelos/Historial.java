package com.adrian.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historial {

    private List<Map<String, String>> list = new ArrayList<>();
    private LocalDateTime fechaYHoraActual = LocalDateTime.now();
    private  DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Historial() {
    }


    public void obtenerHistorial() {
        if (list.isEmpty()) {
            System.out.println("Aun no tienes registros de tus conversiones");
        } else {
            System.out.println("*********Historial:*********");
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> entry = list.get(i);
                System.out.println((i + 1) + ". " + mapToString(entry));
            }
            System.out.println("----------------------------");
            System.out.println("\n");
        }
    }

    public void agregarHistorial(String conversion, double cantidad, double cantidadTotal) {
        Map<String, String> historial = new HashMap<>();
        String cantidadformateada = String.format("%.2f",cantidad);
        String cantidadTotalFormateada = String.format("%.2f",cantidadTotal);
        historial.put(conversion, "Monto total que se convirtió $" + cantidadformateada  + ", resultado de la conversión fue de $" + cantidadTotalFormateada + ", Fecha de la operación: " + fechaYHoraActual.format(formato));
        list.add(historial);
    }

    private static String mapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue())
                    .append(", ");
        }
        // Eliminar la última coma y espacio
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
