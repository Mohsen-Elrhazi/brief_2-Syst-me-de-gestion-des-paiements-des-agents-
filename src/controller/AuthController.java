package controller;

import enums.TypeAgent;
import model.Agent;
import service.AgentService;

import java.util.Scanner;

public class AuthController {
    private AgentService agentService;
    private Scanner sc;

    public AuthController() {
        this.agentService = new AgentService();
        this.sc= new Scanner(System.in);
    }

    public void register(){
        System.out.println("entrer le nom");
        String nom= sc.nextLine();
        System.out.println("entrer le prenom");
        String prenom= sc.nextLine();
        System.out.println("entrer l'email");
        String email= sc.nextLine();
        System.out.println("entrer le mot de passe ");
        String motDePasse= sc.nextLine();

        TypeAgent correctType= null;
        String type;
        do{
            System.out.println("entrer le type d'agent(Ouvrier, Responsable departement, Directeur, Stagiaire: ");
             type= sc.nextLine().trim().toLowerCase();
            if(type.equals("ouvrier")) correctType= TypeAgent.OUVRIER;
            else if(type.equals("responsable_departement")) correctType= TypeAgent.RESPONSABLE_DEPARTEMENT;
            else if(type.equals("directeur")) correctType= TypeAgent.DIRECTEUR;
           else if(type.equals("stagiaire")) correctType= TypeAgent.STAGIAIRE;
           else System.out.println("le type d'agent est incorrect, réessayez");

        }while(!type.equals("ouvrier") && !type.equals("responsable_departement") && !type.equals("directeur") && !type.equals("stagiaire"));

         Agent agent= new Agent(nom, prenom, email, motDePasse, correctType);
        if(agentService.save(agent)){
            System.out.println("vous avez enregistré avec success");
        }else{
            System.out.println("Email deja utilisé vuillez réessayer");
        }
    }

    public void login(){
        System.out.println("======LOGIN======");
        System.out.println("entrer votre email");
        String email= sc.nextLine();
        System.out.println("entrer votre mot de passe");
        String motDePasse= sc.nextLine();
        Agent agent =agentService.findByEmail(email);
        if(agent!=null && agent.getMotDePasse().equals(motDePasse)){
            System.out.println("Vous êtes connecté avec succès ");
            // rediriger apres login
        }else{
            System.out.println("Email ou mot de passe incorrect");
        }
    }

    public void delete() {
        System.out.println("entrer id d'agent a supprimer: ");
        int id = sc.nextInt();

        if (agentService.findById(id)) {
            agentService.delete(id);
            System.out.println("L'agent a été bien supprimé");
        } else {
            System.out.println("Agent avec cet id n'existe pas");
        }
    }

}
