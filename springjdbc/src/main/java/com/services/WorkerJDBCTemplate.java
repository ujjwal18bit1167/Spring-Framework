package com.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dao.WorkerDAO;
import com.mappers.WorkerMapper;
import com.models.Worker;

public class WorkerJDBCTemplate implements WorkerDAO {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	 public int add(Worker worker)
	 {
		 String addSql = """
	                insert into worker(worker_id,first_name,last_name
	                        ,salary,joining_date,department,email) values(?,?,?,?,?,?,?);
	                        """;
		 System.out.println("Adding a student...");
		 return jdbcTemplateObject.update(addSql,worker.getWorker_id(),worker.getFirst_name(),
				 worker.getLast_name(),worker.getSalary(), worker.getJoining_date(), worker.getDepartment(), worker.getEmail());
	 }
	 
	 public void delete(int workerId)
	 {
		 String deleteSql = "delete from worker where worker_id = ?";
		 System.out.println("Deleting a student...");
		 jdbcTemplateObject.update(deleteSql,workerId);
		 System.out.println("Worker with workerId = "+ workerId +"is successfully deleted");
		 return ;
	 }
	 
	 
	 public Worker getWorker(int workerId) {
			String getSql = "Select * from worker where worker_id=?";
			
				Worker worker = jdbcTemplateObject.queryForObject(getSql, new Object[] {workerId}, new WorkerMapper());

			return worker;
		}
	
		public List<Worker> getWorkers() {
			String sql = "SELECT * FROM worker";
			List<Worker> workers = jdbcTemplateObject.query(
					sql, 
					new WorkerMapper()
					);
			
			return workers;
		}
		public void update(Worker worker) {
			String sql = "update worker set first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
			jdbcTemplateObject.update(sql, worker.getFirst_name(), worker.getLast_name(),
			        worker.getSalary(), worker.getJoining_date(), worker.getDepartment(), worker.getEmail(), worker.getWorker_id());
			System.out.println("Record's updated");
			return;
		}
	 
	
}
