package model;
import enums.TypeAgent;

public class Agent extends Personne {
    private int idAgent;
    private TypeAgent typeAgent;
    private Departement departement;
//    private  List<Paiement> paiments;

    public Agent( String nom, String prenom, String email, String motDePasse, TypeAgent typeAgent){
        super(nom, prenom,email, motDePasse);
        this.typeAgent= typeAgent;
        this.departement= null;
//        this.paiements = new ArrayList<>();
    }

    public Agent(int idAgent, String nom, String prenom, String email, String motDePasse, TypeAgent typeAgent, Departement departement){
        super(nom, prenom,email, motDePasse);
        this.idAgent=idAgent;
        this.typeAgent= typeAgent;
        this.departement= departement;
//        this.paiements = new ArrayList<>();
    }



    public int getIdAgent(){
        return idAgent;
    }

    public TypeAgent getTypeAgent() {
        return typeAgent;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public void setTypeAgent(TypeAgent typeAgent) {
        this.typeAgent = typeAgent;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
