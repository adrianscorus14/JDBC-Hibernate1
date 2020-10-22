package hibernate;

public class HibernateApp {
    public static void main(String[] args) {

//        Session session = HibernateUtils.getSessionFactory().openSession();
//        System.out.println("Session Open");
//        Department dept = session.find(Department.class, 1);
//        System.out.println(dept);
//        session.close();

        DepartmentRepository departmentRepository = new DepartmentRepository();



        System.out.println(departmentRepository.findById(2));

//        create only once
//        Department newDeb = new Department("Financial");
        // save a department
//        System.out.println("update dep: " + newDeb);
//        departmentRepository.save(newDeb);

        // updateDepartment POJO la mine in JVM
        Department updateDepartment = new Department(5, "Financial-Commerce");
        // incrementare a in DB


        // update a department
//        System.out.println("update dep: " + updateDepartment);
//        departmentRepository.update(updateDepartment);

        // delete a department
//        System.out.println("delete dep: " + updateDepartment);
//        departmentRepository.delete(updateDepartment);


        Department updateOrSavedDepartment = new Department(1, "HR-HR");
        // saveOrUpdate a department
        System.out.println("saveOrUpdate dep: " + updateOrSavedDepartment);
        departmentRepository.saveOrUpdate(updateOrSavedDepartment);


//        ProjectRepository projectRepository=new ProjectRepository();
//        System.out.println(projectRepository.findById(2));


    }
}