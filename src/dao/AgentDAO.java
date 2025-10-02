package dao;
import java.sql.*;

import enums.TypeAgent;
import model.Departement;
import util.DatabaseConnection;
import model.Agent;

public class AgentDAO {
    private final Connection conn;
    private DepartementDAO departementDAO;

    public AgentDAO(){
        this.conn= DatabaseConnection.getConnection();
        departementDAO= new DepartementDAO();
    }

    public boolean save(Agent agent) {
        String sql = "insert into agent(nom, prenom, email, motDePasse, typeAgent) values(?, ?, ?, ?, ?) ";
       try(PreparedStatement ps = conn.prepareStatement(sql) ){

            ps.setString(1, agent.getNom());
            ps.setString(2, agent.getPrenom());
            ps.setString(3, agent.getEmail());
            ps.setString(4, agent.getMotDePasse());
            ps.setString(5, agent.getTypeAgent().name());

            int rows= ps.executeUpdate();
            return rows >0;
        }catch(SQLException e){
           e.printStackTrace();
           return  false;
       }
    }

//    public boolean findByEmail(String email){
//        String sql= "Select * from agent where email= ?";
//        try(PreparedStatement ps= conn.prepareStatement(sql)){
//            ps.setString(1, email );
//            try(ResultSet rs= ps.executeQuery()){
//            return rs.next();
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//            return false;
//        }
//    }
public Agent findByEmail(String email){
    String sql= "Select * from agent where email= ?";
    try(PreparedStatement ps= conn.prepareStatement(sql)){
        ps.setString(1, email );
       try(ResultSet rs= ps.executeQuery()){
           if(rs.next()) {
              int idAgent= rs.getInt("idAgent");
               String nom= rs.getString("nom");
               String prenom= rs.getString("prenom");
               String motDePasse= rs.getString("motDePasse");
               TypeAgent typeAgent = TypeAgent.valueOf(rs.getString("typeAgent").toUpperCase());

               int idDepartement= rs.getInt("idDepartement");
               Departement departement= departementDAO.findById(idDepartement);

               return new Agent(idAgent, nom, prenom, email, motDePasse,typeAgent,departement);
           }
       }

    }catch(SQLException e){
        e.printStackTrace();
    }
    return null;
}

}
