package com.jspiders.cardekho.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jspiders.cardekho.entity.Car;


public class CarJDBC {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;
	
	public void addCar (Car car) throws ClassNotFoundException, SQLException {
		connection = openConnection();
		query = "INSERT INTO car VALUES (?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, car.getId());
		preparedStatement.setString(2, car.getName());
		preparedStatement.setString(3, car.getBrand());
		preparedStatement.setInt(4, car.getPrice());
		int row = preparedStatement.executeUpdate();
		System.out.println(row + " row(s) affected.");
		System.out.println();
	}
	
	public List<Car> getAllCars() {

		ArrayList<Car> list = new ArrayList<>();

		try {
			connection = openConnection();
			query = "SELECT * FROM car";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Car car = new Car();
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setPrice(resultSet.getInt(4));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public Car getCarById(int id) {

		Car car = new Car();

		try {
			connection = openConnection();
			query = "SELECT * FROM car WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setPrice(resultSet.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return car;
	}
	
	public void deleteCar(int id) {

		try {
			connection = openConnection();
			query = "DELETE FROM car WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " row(s) affected.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateCar(int id, Scanner sc) {

		try {
			connection = openConnection();
			query = "UPDATE car SET name = ?, brand = ?, price = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			sc.nextLine();
			
			System.out.println("Enter car name.");
			preparedStatement.setString(1, sc.nextLine());
			System.out.println("Enter car brand.");
			preparedStatement.setString(2, sc.nextLine());
			System.out.println("Enter car price.");
			preparedStatement.setInt(3, sc.nextInt());
			preparedStatement.setInt(4, id);
			
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " row(s) affected.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");
	}

	private void closeConnection() throws SQLException {

		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}