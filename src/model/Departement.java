package model;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private int idDepartement;
    private String nom;
    private Agent responsable;
    private List<Agent> agents;

    public Departement(int idDepartement, String nom, Agent responsable) {
        this.idDepartement = idDepartement;
        this.nom = nom;
        this.responsable = responsable;
        this.agents = new ArrayList<>();
    }

    public Departement( String nom) {
        this.nom = nom;
        this.responsable = null;
        this.agents = null;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public String getNom() {
        return nom;
    }

    public Agent getResponsable() {
        return responsable;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setResponsable(Agent responsable) {
        this.responsable = responsable;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public void addAgent(Agent agent){
        this.agents.add(agent);
    }
}
