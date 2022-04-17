package com.springboot.workers.springjdbcexample.dao;

import com.springboot.workers.springjdbcexample.model.Worker;
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

    public void update(Worker emp)
            throws SQLException;
}