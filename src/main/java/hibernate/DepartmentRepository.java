package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {

    public Department findById(Integer deptId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Department departmentEg = session.find(Department.class, deptId);
        session.close();
        return departmentEg;
    }

    public List<Department> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();

        Query selectAllDepartmentsQuery = session.createQuery("select * from Departments");

        List<Department> departmentList = selectAllDepartmentsQuery.list();

        session.close();
        return departmentList;

    }

    public void save(Department department) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(department);

        transaction.commit();
        session.close();
    }


    public void update(Department department) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(department);

        transaction.commit();
        session.close();
    }


    public void delete(Department department) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(department);

        transaction.commit();
        session.close();
    }


    public void saveOrUpdate(Department department) {
        // il cautam
        Department foundDep = findById(department.getDepartmentId());

        // daca ii diferit de null inseamna ca are instanta, adica exita si stunci ii facem update
        if (foundDep != null) {
            update(department);
        } else {
            // daca nu-l gasim, inseamna ca nu exista in DB si il vom crea
            save(department);
        }

    }
}