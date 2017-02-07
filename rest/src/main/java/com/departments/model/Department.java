package com.departments.model;





import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by alex on 7.2.17.
 */

public class Department implements Serializable {
    @AssertTrue(message = "Should by Name of department")
    public boolean isShouldNameOfDepartment(){
        Boolean result=true;
        if(nameDepartment==null){
            result=false;
        }
        return result;
    }

    @NotNull
    private long id ;
    @NotNull
    @Size(min = 1,max = 45)
    private String nameDepartment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
}
