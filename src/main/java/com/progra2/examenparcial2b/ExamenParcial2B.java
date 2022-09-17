/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.progra2.examenparcial2b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author dual4
 */
public class ExamenParcial2B {

    public static void buscarbd() {
        int total;
        Scanner t = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/siscomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "Dual1020");
            Statement sentencia = conexion.createStatement();
             System.out.println("INGRESA EL NIV DEL EMPLEADO A BUSCAR: ");
            int emp = t.nextInt();
            String sql = "SELECT * FROM tb_empleados  where Niv = " + emp;
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("NIV =" + resultado.getInt(1));
                System.out.println("Nombre = " + resultado.getString(2));
                System.out.println("Enero =" + resultado.getInt(3));
                System.out.println("Febrero =" + resultado.getInt(4));
                System.out.println("Marzo =" + resultado.getInt(5));
                System.out.println("Abril =" + resultado.getInt(6));
                System.out.println("Mayo =" + resultado.getInt(7));
                System.out.println("Junio =" + resultado.getInt(8));
                total = resultado.getInt(3) + resultado.getInt(4) + resultado.getInt(5) + resultado.getInt(6) + resultado.getInt(7) + resultado.getInt(8);
                System.out.println("TOTAL DE VENTAS = " + total);
            }

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void consultarbd() {
        String url = "jdbc:mysql://localhost:3306/siscomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "Dual1020");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM tb_empleados";
            ResultSet resultado = sentencia.executeQuery(sql);
            System.out.println("NIV\tNOMBRE\tENERO\tFEBRERO\tMARZO\tABRIL\tMAYO\tJUNIO");
            while (resultado.next()) {
                System.out.println(resultado.getInt(1) + "\t" + resultado.getString(2) + "\t" + resultado.getInt(3) + "\t" + resultado.getInt(4) + "\t" + resultado.getInt(5) + "\t" + resultado.getInt(6) + "\t" + resultado.getInt(7) + "\t" + resultado.getInt(8));
            }

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void eliminarbd() {
        int emp;
        int opc = 0;
        String nombre = "";
        Scanner t = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/siscomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "Dual1020");
            Statement sentencia = conexion.createStatement();

            System.out.println("INGRESA EL NIV DEL EMPLEADO A ELIMINAR: ");
            emp = t.nextInt();
            String sql = "SELECT * FROM tb_empleados  where NIV= " + emp;
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                nombre = resultado.getString(2);
            }
            System.out.println("SEGURO QUE QUIERES ELIMINAR A :" + nombre);
            System.out.println("ELEGIR OPCION");
            System.out.println("1. Si");
            System.out.println("2. No :");
            opc = t.nextInt();
            if (opc == 1) {
                String sq2 = "DELETE FROM tb_empleados where NIV=" + emp;
                sentencia.execute(sq2);
                System.out.println("ELIMINADO EXITOSO ");
            } else if (opc == 2) {
                System.out.println("NO HA SIDO ELIMINADO: ");
            } else {
                return;
            }

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void actualizarbd() {
        int emp;
        String nombre = "";
        String cadena = "";
        Scanner t = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/siscomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "Dual1020");
            Statement sentencia = conexion.createStatement();
           
            System.out.println("INGRESA EL NIV DEL EMPLEADO A ACTUALIZAR: ");
            emp = t.nextInt();
            String sql = "SELECT * FROM tb_empleados  where NIV= " + emp;
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("SEGURO QUE QUIERES CAMBIAR EL NOMBRE: " +resultado.getString(2));
            }

            System.out.println("ELEGIR OPCION");
            System.out.println("1. Si");
            System.out.println("2. No :");
            int opc = t.nextInt();
            
            
             if (opc == 1) {
                 Scanner te = new Scanner(System.in);
                System.out.println("INGRESE NOMBRE NUEVO: ");
                cadena=te.nextLine();
                
                String sq2 = "update tb_empleados  set Nombre= '"+ cadena +"' "+ " where Niv = " + emp;
                sentencia.execute(sq2);
                System.out.println("CAMBIO EXITOSO ");
             }
             else if(opc == 2) {
                System.out.println("NO HA SIDO ELIMINADO: ");
            } else {
                return;
            }
             

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void ingresarbd() {
        String nombre;
        int num = 2;
        int enero;
        int febrero;
        int marzo;
        int abril;
        int mayo;
        int junio;
        Scanner t = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/siscomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "Dual1020");
            Statement sentencia = conexion.createStatement();

            System.out.println("Ingrese nombre");
            nombre = t.nextLine();
            System.out.println("Ingrese enero");
            enero = t.nextInt();
            System.out.println("Ingrese febrero");
            febrero = t.nextInt();
            System.out.println("Ingrese marzo");
            marzo = t.nextInt();
            System.out.println("Ingrese abril");
            abril = t.nextInt();
            System.out.println("Ingrese mayo");
            mayo = t.nextInt();
            System.out.println("Ingrese junio");
            junio = t.nextInt();
            String sql = "insert into tb_empleados (Nombre, Enero, Febrero, Marzo, Abril, Mayo, Junio) values ('" + nombre + "'," + enero + "," + febrero + "," + marzo + "," + abril + "," + mayo + "," + junio + ")";

            sentencia.execute(sql);
            num = num + 1;
            System.out.println("Ingresado Exitoso");
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        Scanner sn = new Scanner(System.in);
        do {
        //Mensajes del menu
            System.out.println("");
            System.out.println("MENU");
            System.out.println("1. Mostrar Vendedores");
            System.out.println("2. Ventas por vendedor");
            System.out.println("3. Ingresar Vendedor");
            System.out.println("4. Eliminar Vendedor");
            System.out.println("5. Actualizar datos");
            System.out.println("6. Salir");
            System.out.println("Elije una opcion");
            opcion = sn.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("MOSTRANDO VENDEDORES");
                    consultarbd();
 
                    break;
                case 2:
                    System.out.println("VENTAS POR VENDEDOR");
                   buscarbd();
                    
                    break;
                case 3:
                    System.out.println("INGRESANDO VENDEDORES");
                    ingresarbd();
                    break;
                case 4:
                    System.out.println("ELIMINANDO VENDEDORES");
                   eliminarbd();
                   break;
                   
                   case 5:
                       System.out.println("ACTUALIZANDO VENDEDORES");
                   actualizarbd();
                   break;
                   
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Tienes que meter un valor entre 1 y 8");
        
        
            }    
            
        }while (!salir);
 
        System.out.println("FIN");
    }
}

