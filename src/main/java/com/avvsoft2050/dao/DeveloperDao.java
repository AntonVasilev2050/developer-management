package com.avvsoft2050.dao;

import com.avvsoft2050.model.Developer;
import com.avvsoft2050.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DeveloperDao {
    private final Connection connection;

    public DeveloperDao() {
        connection = DbUtil.getConnection();
    }

    public void addDeveloper(Developer developer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into developers(name,specialty,salary) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, developer.getName());
            preparedStatement.setString(2, developer.getSpecialty());
            preparedStatement.setInt(3, developer.getSalary());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeveloper(int developerId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from developers where developerId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, developerId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeveloper(Developer developer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update developers set name=?, specialty=?, salary=?" +
                            "where developerId=?");
            // Parameters start with 1
            preparedStatement.setString(1, developer.getName());
            preparedStatement.setString(2, developer.getSpecialty());
            preparedStatement.setInt(3, developer.getSalary());
            preparedStatement.setInt(4, developer.getDeveloperId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Developer> getAllDevelopers() {
        ArrayList<Developer> developers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from developers order by developerId");
            while (rs.next()) {
                Developer developer = new Developer();
                developer.setDeveloperId(rs.getInt("developerId"));
                developer.setName(rs.getString("name"));
                developer.setSpecialty(rs.getString("specialty"));
                developer.setSalary(rs.getInt("salary"));
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developers;
    }

    public Developer getDeveloperById(int developerId) {
        Developer developer = new Developer();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from developers where developerId=?");
            preparedStatement.setInt(1, developerId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                developer.setDeveloperId(rs.getInt("developerId"));
                developer.setName(rs.getString("name"));
                developer.setSpecialty(rs.getString("specialty"));
                developer.setSalary(rs.getInt("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return developer;
    }
}
