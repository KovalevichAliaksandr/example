package com.departments.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by alex on 14.2.17.
 */
public class DepartmentsWithAvgSalary implements Serializable {
    private Long id;
    private String name;
    private Integer AvgSalary;

    public DepartmentsWithAvgSalary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvgSalary() {
        return AvgSalary;
    }

    public void setAvgSalary(Integer avgSalary) {
        AvgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "DepartmentsWithAvgSalary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", AvgSalary=" + AvgSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentsWithAvgSalary that = (DepartmentsWithAvgSalary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(AvgSalary, that.AvgSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, AvgSalary);
    }
}
