import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        String menu ="";
        String opcion ="";

        String nombre;
        String apellido;
        int nroRegistro;
        String fechaDeteccion;
        String mac;

        while (!menu.equals("salir")){
            opcion = JOptionPane.showInputDialog("Escriba el numero de una de las opciones: \n1- Agregar una persona\n2- Ver la lista\n3- Remover una persona de la lista \n4- Ordenar y mostrar la lista por algun dato\n5- Salir");
            switch (opcion){
                case "1":
                        nombre = JOptionPane.showInputDialog("Nombre de la persona");
                        apellido = JOptionPane.showInputDialog("Apellido de la persona");
                        String registro = JOptionPane.showInputDialog("Numero de registro");
                        nroRegistro = Integer.parseInt(registro);
                        fechaDeteccion = JOptionPane.showInputDialog("Fecha de deteccion");
                        mac = JOptionPane.showInputDialog("Ingrese el numero de mac separado con guiones");
                        if (!lista.agregarPersona(nombre,apellido,nroRegistro,fechaDeteccion,mac)){
                            System.out.println("No se pudo agregar la persona, la direccion mac esta en un formato incorrecto");
                        }
                        else {
                            System.out.println("Persona agregada con exito");
                        }
                        break;
                case "2":
                        System.out.println(lista.obtenerLista());
                        break;
                case "3":
                    String numero = JOptionPane.showInputDialog("Escriba el numero de registro de la persona a remover de la lista");

                    if (lista.removerPersona(Integer.parseInt(numero))){
                        System.out.println("se removio con exito la persona con registro: " + numero);
                    }
                    else {
                        System.out.println(numero+ " no es un numero de registro en la lista");
                    }
                    break;
                case "4":
                    String numeroOrdernar;
                    numeroOrdernar = JOptionPane.showInputDialog("Escriba el numero de la opcion para ordenar la lista \n1- nombre \n2- apellido \n3-numero de registro \n4-fecha de deteccion \n5- direccion MAC");
                    switch (numeroOrdernar){
                        case"1":
                            lista.ordenarPorNombre();
                            System.out.println(lista.obtenerLista());

                            break;
                        case "2":
                            lista.ordenarPorApellido();
                            System.out.println(lista.obtenerLista());

                            break;
                        case "3":
                            lista.ordenarPorRegistro();
                            System.out.println(lista.obtenerLista());

                            break;
                        case "4":
                            lista.ordenarPorFecha();
                            System.out.println(lista.obtenerLista());

                            break;
                        case "5":
                            lista.ordenarPorMac();
                            System.out.println(lista.obtenerLista());
                            break;
                    }
                    break;
                case "5":
                default:
                        menu = "salir";
                        System.out.println("no se ingreso opcion o se selecciono salir");
                        break;

            }
        }

    }
}
