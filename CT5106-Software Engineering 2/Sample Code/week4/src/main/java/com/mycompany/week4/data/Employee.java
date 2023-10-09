/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week4.data;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author o_molloy
 */
@Entity
@Table(name = "Employee")
public class Employee implements Serializable //implements Serializable
{

    @Id
    @Column(name="id")
    private int empid;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private long salary;

    public Employee()
    {
    }

    public Employee(int empid, String name, long salary)
    {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpid()
    {
        return empid;
    }

    public void setEmpid(int empid)
    {
        this.empid = empid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getSalary()
    {
        return salary;
    }

    public void setSalary(long salary)
    {
        this.salary = salary;
    }

}
