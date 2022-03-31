package com.helpers;

import java.util.List;

import com.models.Worker;

public class WorkerHelper {
	public static void printWorkers(List<Worker> list)
	{
		list.forEach( elem -> System.out.println(elem) );
	}
}
