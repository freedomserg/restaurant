package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.Employee;
import com.goit.projects.restaurant.model.EmployeeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcEmployeeDAO implements EmployeeDAO {

    //private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAO.class);
    private JdbcTemplate jdbcTemplate;
    //private DataSource dataSource;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    public void addEmployee(Employee newEmployee) {

    }

    @Override
    public void removeEmployee(Employee employee) {

    }

//    @Override
//    @Transactional(propagation = Propagation.MANDATORY)
//    public List<Employee> loadBySurname(String surname) {
//        List<Employee> result = new ArrayList<>();
//        try(Connection connection = dataSource.getConnection();
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE surname = ?")) {
//            statement.setString(1, surname);
//            ResultSet resultSet = statement.executeQuery();
//                while (resultSet.next()) {
//                    result.add(createEmployee(resultSet));
//                }
//        } catch (SQLException e) {
//            LOGGER.error("Exception occurred while connecting to DB: " + e);
//        }
//        return result;
//    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> loadBySurname(String surname) {
        String sql = "SELECT * FROM employee WHERE surname = ?";
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), new Object[]{surname});
    }

//    private Employee createEmployee(ResultSet resultSet) throws SQLException {
//        Employee employee = new Employee();
//        employee.setEmployee_id(resultSet.getInt("employee_id"));
//        employee.setName(resultSet.getString("name"));
//        employee.setSurname(resultSet.getString("surname"));
//        employee.setBirthday(new Date(resultSet.getDate("birthday").getTime()));
//        employee.setCell(resultSet.getString("cell"));
//        employee.setPosition(resultSet.getString("position"));
//        employee.setSalary(resultSet.getDouble("salary"));
//        return employee;
//    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
