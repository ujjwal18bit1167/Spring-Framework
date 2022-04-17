package com.springboot.workers.springjdbcexample.controller;
import com.springboot.workers.springjdbcexample.model.Worker;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.workers.springjdbcexample.repository.WorkerRepository;


@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepository;
	
	@GetMapping("/showWorker")
	public Worker showWorker()
	{
		try {
			return workerRepository.getWorker(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("all/showWorkers")
	public List<Worker> showAllWorkers()
	{
		try {
			return workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@GetMapping("/create")
	public String addWorker()
	{
		Worker worker = new Worker(100,"Ujjwal", "Gupta", 50000, Date.valueOf("2022-03-15"), "Software Developer","Ujjwal@gmail.com");
		try {
			workerRepository.add(worker);
			return worker.getFirst_name() +" added successfully";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error while adding a new record";
		}
	}
	
	@GetMapping("/update")
	public String updateWorker()
	{
		Worker worker = new Worker(100,"Ujjwal", "Gupta", 50000, Date.valueOf("2022-03-15"), "Software Developer","mfs.akash@gmail.com");
		try {
			workerRepository.update(worker);
			return "Worker updated successfully";

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error occured while updating worker";
		}
	}
	
	@GetMapping("/delete")
	public String deleteWorker() {
		try {
			workerRepository.delete(1);
			return "Worker deleted sucdessfully";

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error occured while deleting a record";
		}
	}
	
	
}
