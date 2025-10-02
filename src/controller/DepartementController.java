package controller;

import model.Departement;
import service.DepartementService;

import java.util.Scanner;

public class DepartementController {
    private DepartementService departementService;
    private Scanner sc;

    public DepartementController(){
        this.departementService= new DepartementService();
        this.sc= new Scanner(System.in);
    }

    public void save(){
        System.out.println("entrer le nom d'epartement");
        String nom= sc.nextLine();
        Departement departement= new Departement(nom);
        if(departementService.save(departement)){
            System.out.println("Departement enregistré avec success");
        }
    }

    public void delete(){
        System.out.println("entrer id de departement a supprimer");
        int id= sc.nextInt();
        if(departementService.delete(id)){
            System.out.println("Departement a ete supprimer");
        }
    }

    public void update(){
        System.out.println("entrer id de departement a modifier: ");
        int id= sc.nextInt();
        Departement departement= departementService.findById(id);
        if(departement!= null){
            System.out.println("entrer le nouveau nom de departement");
            String newNom= sc.nextLine();
            departement.setNom(newNom);
            departementService.update(departement);
            System.out.println("le nom de departement a ete bien modifier");
        }else{
            System.out.println("Désolé il n'ya aucune departement avec cet id");
        }
    }
}
