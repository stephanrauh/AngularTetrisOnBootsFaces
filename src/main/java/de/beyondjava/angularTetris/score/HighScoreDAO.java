package de.beyondjava.angularTetris.score;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hsqldb.rights.User;

public class HighScoreDAO {

    private SessionFactory sessionFactory;
    private Configuration config;
    private Session session;

    public HighScoreDAO() {
        // 1. configuring hibernate
        config = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(ssrb.build());
        session = sessionFactory.openSession();
    }

    public void persistUser(HighScore user) {

        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();

    }

    public ArrayList<HighScore> loadAll() {

        // Criteria criteria = session.createCriteria(User.class);
        // criteria.addOrder(Order.asc( "lastName" ));

        return (ArrayList<HighScore>) session.createCriteria(HighScore.class).list();
    }

    // public Boolean exists(HighScore score) {
    // Query query = session.createQuery("select 1 from User u where u.email = :key");
    // query.setString("key", score.getEmail());
    // return (query.uniqueResult() != null);
    // }
}
