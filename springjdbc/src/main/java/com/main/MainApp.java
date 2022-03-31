package com.main;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpers.WorkerHelper;
import com.models.Worker;
import com.services.WorkerJDBCTemplate;

public class MainApp {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		WorkerJDBCTemplate workerJDBCTemplate = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");
		
	     System.out.println("Creating Records");
	     Worker worker1 = new Worker( 11 , "Ujjwal", "Gupta", 75000, Date.valueOf("2022-03-31") ,"IT", "u@gmail.com" );
		 workerJDBCTemplate.add(worker1);
		 
		 Worker worker2 = new Worker( 12 , "Ujjwal", "Gupta", 75000, Date.valueOf("2022-03-31") ,"IT", "u@gmail.com" );
		 workerJDBCTemplate.add(worker2);
		 
		 workerJDBCTemplate.delete(11);
		 
		 Worker worker3 = new Worker( 11 , "Ram", "Gupta", 75000, Date.valueOf("2022-03-31") ,"IT", "u@gmail.com" );
		 workerJDBCTemplate.update(worker3);
		 
		 System.out.println(" Displaying workers........ ");
		 List<Worker> workerList = workerJDBCTemplate.getWorkers(); 
		 WorkerHelper.printWorkers(workerList);
			
		
		 Worker worker4 = workerJDBCTemplate.getWorker(1);
		 System.out.println(worker4);
		 
	}
}
