import controller.AuthController;
import controller.DepartementController;
import dao.AgentDAO;
import enums.TypeAgent;
import model.Departement;
import service.AgentService;
import util.DatabaseConnection;
import model.Agent;

public class Main {
    public static void main(String[] args) {


//    AuthController authController= new AuthController();
//    authController.register();
//        authController.login();

        DepartementController departementController= new DepartementController();

//        departementController.save();
//        departementController.delete();
        departementController.update();











    }
}