package com.springboot.workers.crudapi.dao;

import com.springboot.workers.crudapi.model.Worker;
import java.sql.SQLException;
import java.util.List;

public interface WorkerDAO {
    public int add(Worker worker)
            throws SQLException;

    public void delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public void replace(Worker emp)
            throws SQLException;
    
    public boolean updateWorkerEmailById(String email, int workerId)
    		throws SQLException;
}