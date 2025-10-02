package dao;

import enums.TypeAgent;
import model.Agent;
import model.Departement;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartementDAO {
    private final Connection conn;

    public DepartementDAO(){
        this.conn= DatabaseConnection.getConnection();
    }

    public Departement findById(int id){
        String sql = "Select * from departement where idDepartement= ?";
        try(PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs= ps.executeQuery()){
                if(rs.next()) {
                    int idDepart= rs.getInt("idDepartement");
                    String nom= rs.getString("nom");
                    return new Departement(idDepart, nom, null);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(("eroor"+ e.getMessage()));
        }
        return null;
    }

    public boolean save(Departement departement){
        String sql= "Insert into departement(nom) values(?)";
        try(PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setString(1, departement.getNom());

            int row= ps.executeUpdate();
            return row>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id){
        String sql= "Delete from departement where idDepartement= ?";
        try(PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setInt(1, id);
            int row= ps.executeUpdate();
            return row>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Departement departement){
        String sql= "update departement set nom= ? where idDepartement= ?";
        try(PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setString(1, departement.getNom());
            ps.setInt(2, departement.getIdDepartement());

            int row= ps.executeUpdate();
            return row>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }


}
