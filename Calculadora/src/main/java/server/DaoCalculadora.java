package server;

import utils.MySQLConnection;

import java.sql.*;

public class DaoCalculadora {

    PreparedStatement pstm;
    Connection conn; // conecciona  a la base de datos
    CallableStatement cstm; // llamadas a procedimientos almacenado
    ResultSet rs; // cacha registros de la base de datos


    public boolean registerOperation(String type, double num1, double num2){
        try {
            conn = new MySQLConnection().getConnection();
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement("", PreparedStatement.RETURN_GENERATED_KEYS);// insert en la primera tabla
            pstm.execute();
            rs = pstm.getGeneratedKeys();
            if (rs.next()){
                long id = rs.getLong(1);
            }
            conn.commit();
            return true;
        }catch(SQLException e){
            try {
                conn.rollback();
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }
        return false;
    }

    public void closeConnections(){
        try {
            if (conn != null)
                conn.close();
            if (pstm != null)
                pstm.close();
            if (cstm != null)
                cstm.close();
            if (rs != null)
                rs.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }



}
