package hibernate;

import org.hibernate.Session;

public class ProjectRepository {

    public Project findById(Integer projectId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Project project = session.find(Project.class, projectId);
        session.close();
        return project;

    }
}
