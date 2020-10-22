package org.example;

public class Department {
    private Integer departmentId;
    private String name;

    public Department(Integer departmentId, String name) {

        this.departmentId = departmentId;
        this.name = name;
    }

    public Department(){

    }


    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                '}';
    }
}
