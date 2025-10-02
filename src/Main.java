import controller.AuthController;
import controller.DepartementController;
import dao.AgentDAO;
import dao.DepartementDAO;
import enums.TypeAgent;
import model.Departement;
import service.AgentService;
import service.DepartementService;
import util.DatabaseConnection;
import model.Agent;

public class Main {
    public static void main(String[] args) {


    AuthController authController= new AuthController();
//    authController.register();
//        authController.login();
                authController.delete();

        DepartementController dc= new DepartementController();

//        departementController.save();
//        departementController.delete();
         dc.update();

//        DepartementService ds= new DepartementService();
//        Departement d= ds.findById(2);
//        System.out.println(d.getNom());







    }
}