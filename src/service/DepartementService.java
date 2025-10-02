package service;

import dao.DepartementDAO;
import model.Departement;

public class DepartementService {
    private DepartementDAO departementDAO;

    public DepartementService(){
        this.departementDAO= new DepartementDAO();
    }

    public boolean save(Departement departement){
        return departementDAO.save(departement);
    }

    public Departement findById(int id){
//        Departement departement = departementDAO.findById(id);
//        return departement;
       return departementDAO.findById(id);
    }

    public boolean delete(int id){
        return departementDAO.delete(id);
    }

    public boolean update(Departement departement){
        return departementDAO.update(departement);
    }
}
