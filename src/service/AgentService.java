package service;

import dao.AgentDAO;
import model.Agent;

import java.sql.SQLException;

public class AgentService {
    private AgentDAO agentDAO;

    public AgentService() {
        this.agentDAO = new AgentDAO();
    }

    public boolean save(Agent agent){
        Agent existingAgent= agentDAO.findByEmail(agent.getEmail());
        if(existingAgent!= null){
            return false;
        }
        return agentDAO.save(agent);
    }

    public Agent findByEmail(String email){
        Agent agent= agentDAO.findByEmail(email);
        if(agent!= null){
            return agent;
        }
        return null;
    }

    public boolean findById(int id){
        return agentDAO.delete(id);
    }

    public boolean delete(int id){
        return agentDAO.delete(id);
    }


}
