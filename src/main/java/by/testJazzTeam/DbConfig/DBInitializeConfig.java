package by.testJazzTeam.DbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DBInitializeConfig {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO robots " +
                            "(name,type,status) " +
                            "VALUES " + "('RobotOne','kitchen','sleep')"
            );
            statement.executeUpdate(
                    "INSERT INTO robots " +
                            "(name,type,status) " +
                            "VALUES " + "('RobotTwo','indoor','clear')"
            );
            statement.executeUpdate(
                    "INSERT INTO robots " +
                            "(name,type,status) " +
                            "VALUES " + "('RobotThree','indoor','sleep')"
            );
            statement.executeUpdate(
                    "INSERT INTO robots " +
                            "(name,type,status) " +
                            "VALUES " + "('RobotFour','kitchen','cook')"
            );
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
