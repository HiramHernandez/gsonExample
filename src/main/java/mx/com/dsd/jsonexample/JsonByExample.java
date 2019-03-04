package mx.com.dsd.jsonexample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class JsonByExample {

    static public void main(String[] args) {
        DetallesVenta detalle1 = new DetallesVenta("BARRA ALL BRAN CHOCOLATE", new BigDecimal("6.264"),
                new BigDecimal("62.64"), 10);

        DetallesVenta detalle2 = new DetallesVenta("MONED. ORO VITR. 10/120/5.9", new BigDecimal("116.64"),
                new BigDecimal("233.28"), 2);

        DetallesVenta detalle3 = new DetallesVenta("PAK. ZUCARITAS", new BigDecimal("4.752"), new BigDecimal("4.752"),
                1);

        ArrayList<DetallesVenta> detalles = new ArrayList<>();
        Venta venta = new Venta();

        Calendar calendario = Calendar.getInstance();
        Date fecha = new Date(calendario.getTimeInMillis());

        detalles.add(detalle1);
        detalles.add(detalle2);
        detalles.add(detalle3);

        venta.setCliente("PUBLICO GENERAL NACIONAL");
        venta.setFecha(fecha);
        venta.setDetalle(detalles);

        // Creamos el objeto Gson que se encargara de las conversiones
        Gson gson = new Gson();

        // Convertimos un objecto sencillo a JSON
        System.out.println(gson.toJson(detalle1));
        System.out.println();

        // Convertimos un Objecto que contiene un arreglo de objetos
        System.out.println(gson.toJson(venta));
        System.out.println();

        // Convertimos un JSON sencillo a un objeto adecuado
        // Note que convertimos las comillas dobles a comillas simples, esto es
        // necesario debido
        // a que las comillas dobles son caracteres reservados en Java
        String jsonSimple = "{'producto': 'EXTRA 310 GRS', 'importe': 105.84, 'precioUnitario': 52.92, 'cantidad': 2}";
        DetallesVenta detalles4 = gson.fromJson(jsonSimple, DetallesVenta.class);
        System.out.println("********************* NOTA DE VENTA ********************");
        System.out.println("* Producto: " + detalles4.getProducto() + "            *");
        System.out.println("* Importe: " + detalles4.getImporte() + "              *");
        System.out.println("* Precio Unitario: " + detalles4.getPrecioUnitario() + " *");
        System.out.println("**************** GRACIAS POR SU COMPRA *****************");
        System.out.println();

        // Convertimos un JSON que incluye un arreglo de objetos a un objeto
        String jsonComplejo = "{'fecha':'Jul 9, 2018 3:37:49 PM', 'cliente': 'PUBLIC EN GENERAL NACIONAL', 'detalle':[{'producto': 'Cloro', 'importe':150.0,' precioUnitario':15.00, 'cantidad':10}, {'producto': 'Escoba', 'importe':30, 'precioUnitario': 30.00, 'cantidad': 1},{'producto': 'Aromatizante ambiental', 'importe':100.0, 'precioUnitario': 10.00, 'cantidad': 10}]}";
        Venta venta2 = gson.fromJson(jsonComplejo, Venta.class);
        System.out.println("Ahi va la venta mi amigo");
        System.out.println("#########################");
        System.out.println(gson.toJson(venta2));
        System.out.println("#########################");
        System.out.println("Fecha: " + venta2.getFecha());
        System.out.println("Cliente: " + venta2.getCliente());
        System.out.println();

        for (DetallesVenta detalle : venta2.getDetalle()) {
            System.out.println("Producto: " + detalle.getProducto());
            System.out.println("Importe: " + detalle.getImporte());
            System.out.println("Precio Unitario: " + detalle.getPrecioUnitario());
            System.out.println();
        }

        // Convertimos un arreglo suelto a JSON
        String jsonArray = gson.toJson(detalles);
        System.out.println(jsonArray);

        // Convertir un array Json a ArrayList

        // Creaos el tipo que represente el arreglo
        Type listType = new TypeToken<ArrayList<DetallesVenta>>() {
        }.getType();
        ArrayList<DetallesVenta> arrayDeJson = gson.fromJson(jsonArray, listType);

        System.out.println("\n");

        for (DetallesVenta detalle : arrayDeJson) {
            System.out.println(detalle.getProducto());
        }

        Cargo cargo = new Cargo(1478, "2019-01-25", "2019-01-30");
        System.out.println("########CARTERA DEL CLIENTE########");
        System.out.println(gson.toJson(cargo));
        System.out.println("Con formato");
        System.out.println("Id del cliente: " + cargo.getIdCliente());
        System.out.println("Fecha de la deuda: " + cargo.getFechaInicio());
        System.out.println("Fecha limite para no generar interés: " + cargo.getFechaFin());
        System.out.println("########CARTERA DEL CLIENTE########");

    }
}
