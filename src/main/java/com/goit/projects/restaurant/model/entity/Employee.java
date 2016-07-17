package com.goit.projects.restaurant.model.entity;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "cell")
    private String cell;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if (Double.compare(employee.salary, salary) != 0) return false;
        if (!name.equals(employee.name)) return false;
        if (!surname.equals(employee.surname)) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (cell != null ? !cell.equals(employee.cell) : employee.cell != null) return false;
        return position != null ? position.equals(employee.position) : employee.position == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (cell != null ? cell.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", cell='" + cell + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
