package hibernate;

import org.hibernate.Session;

public class EmployeeRepository {
    public Employee findById(Integer employeeId){
        Session session=HibernateUtils.getSessionFactory().openSession();

        Employee employee=session.find(Employee.class,employeeId);


        session.close();

        return employee;
    }
}
