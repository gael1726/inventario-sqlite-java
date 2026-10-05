/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unison.base_datos;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gaelm
 */
public class InventarioBD {
    
    public InventarioBD(){
        String url = "jdbc:sqlite:Inventario.db";
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                System.out.println("El driver usado es: " + meta.getDriverName());
                System.out.println("Se creo una nueva base de datos.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void CrearTabla(){
        var url = "jdbc:sqlite:productos.db";
        var sql = "CREATE TABLE IF NOT EXISTS productos ("
                + " id INTEGER PRIMARY KEY,"
                + " nombre text NOT NULL,"
                + " precio REAL"
                + ");";
        try (var conn = DriverManager.getConnection(url); var stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void InsertarProducto(){
        var url = "jdbc:sqlite:productos.db";
        String sql = "INSERT INTO productos(nombre,precio) VALUES(?,?)";
        try(var conn=DriverManager.getConnection(url);var pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, "Coca-Cola 3L");
            pstmt.setDouble(2, 55.0f);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void ConsultarProducto(){
        var url = "jdbc:sqlite:productos.db";
        var sql = "SELECT id, nombre, precio FROM productos";
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("%-5s%-25s%-10s%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public void ActualizarProducto(){
        var url = "jdbc:sqlite:productos.db";
        var sql = "UPDATE productos SET nombre = ? , "
                + "precio = ? "
                + "WHERE id = ?";
        try (var conn=DriverManager.getConnection(url); var pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1, "Fritos Azteca");
            pstmt.setDouble(2, 30.0f);
            pstmt.setInt(3, 4);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public void EliminarProducto(){
        var url = "jdbc:sqlite:productos.db";
        var sql = "DELETE FROM productos WHERE id = ?";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 3);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
