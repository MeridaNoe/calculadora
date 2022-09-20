package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoOperations {

    Connection conn;
    PreparedStatement pstm;

    public String GET_OPERACIONES = "SELECT * FROM operaciones";

    public String INSERT_OPERA = "INSERT INTO operaciones(type, first_number, second_number, result, created_at) VALUES (?,?,?,?,?)";




}
