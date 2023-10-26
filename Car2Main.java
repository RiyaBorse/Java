package com.jsiders.cardekho.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekho.entity.Car;
import com.jspiders.cardekho.operation.CarJDBC;

public class Car2Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CarJDBC car1 = new CarJDBC ();
		Scanner sc = new Scanner (System.in);
		boolean condition = true;
		
		String un = "Riya";
		int p =123;
		System.out.println("********LOGIN********");
		System.out.println("Enter the user name");
		String userName = sc.nextLine();
		System.out.println("Enter the password");
		int pass = sc.nextInt();
		
		if (userName.equals(un) && pass == 123) {
			System.out.println("LOGIN SUCCESSFULLY.");
			System.out.println();
		
		
		while (condition) {
			
			System.out.println();
			
			System.out.println("--OPERATIONS--");
			System.out.println("Enter 1 to add car");
			System.out.println("Enter 2 to get car by id");
			System.out.println("Enter 3 to get all cars");
			System.out.println("Enter 4 to delete car");
			System.out.println("Enter 5 to Update car");
			System.out.println("Enter 6 to exit car");
			
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				Car car = new Car();
				System.out.println("Enter car id.");
				car.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter car name.");
				car.setName(sc.nextLine());
				System.out.println("Enter car brand.");
				car.setBrand(sc.nextLine());
				System.out.println("Enter car price.");
				car.setPrice(sc.nextInt());
				car1.addCar(car);
				break;
				
			}
			case 2:{
				System.out.println("Enter car id.");
				Car c = car1.getCarById(sc.nextInt());
				System.out.println(c);
				break;
			}
			case 3:{
				
				List<Car> car = car1.getAllCars();
				for (Car c : car) {
					System.out.println(c);
				}
				break;
			}
			case 4:{
				System.out.println("Enter car id.");
				car1.deleteCar(sc.nextInt());
				break;
			}
			case 5:{
				System.out.println("Enter car id.");
				car1.updateCar(sc.nextInt(), sc);
				break;
			}
			case 6:{
				System.out.println("Thank you!");
				condition = false;
				break;
			}
			default:
				System.out.println("Invalid choice.");
			}
		  }
		}
		else {
			System.out.println("Invalid Credentials!!!");
		}
		
	}
}
