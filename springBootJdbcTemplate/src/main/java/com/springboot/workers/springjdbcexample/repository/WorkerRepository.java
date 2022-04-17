package com.springboot.workers.springjdbcexample.repository;


import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;

@Repository
public class WorkerRepository implements WorkerDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplateObject;


	@Override
    public int add(Worker worker) throws SQLException
    {
    	String format = "insert into worker values(?,?,?,?,?,?,?)";
    	
    	 System.out.println("Adding a student...");
		 return jdbcTemplateObject.update(format,worker.getWorker_id(),worker.getFirst_name(),
				 worker.getLast_name(),worker.getSalary(), worker.getJoining_date(), worker.getDepartment(), worker.getEmail());
    	
    }
	
	@Override
	public void delete(int workerId ) throws SQLException{
        String deleteSql = "delete from worker where worker_id = ?";
		 System.out.println("Deleting a student...");
		 jdbcTemplateObject.update(deleteSql,workerId);
		 System.out.println("Worker with workerId = "+ workerId +"is successfully deleted");
		 return ;

	}
	

    @Override
    public Worker getWorker(int workerId) throws SQLException {
    	String getSql = "Select * from worker where worker_id=?";
		
		@SuppressWarnings("deprecation")
		Worker worker = jdbcTemplateObject.queryForObject(getSql, new Object[] {workerId}, new WorkerMapper());

		return worker;
    }
    
    public List<Worker> getWorkers() throws SQLException {
    	String sql = "SELECT * FROM worker";
		List<Worker> workers = jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
		
		return workers;
    }
    
    public void update(Worker worker) throws SQLException {
    	String sql = "update worker set first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
		jdbcTemplateObject.update(sql, worker.getFirst_name(), worker.getLast_name(),
		        worker.getSalary(), worker.getJoining_date(), worker.getDepartment(), worker.getEmail(), worker.getWorker_id());
		System.out.println("Record's updated");
		return;
    }
	
	
	
	

}
