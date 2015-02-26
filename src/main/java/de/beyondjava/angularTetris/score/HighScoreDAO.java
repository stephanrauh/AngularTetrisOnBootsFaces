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

    private static SessionFactory sessionFactory;
    
    static {
        Configuration config;
        config = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(ssrb.build());
        
    }

    public HighScoreDAO() {
    }

    public void persistScore(HighScore score) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(score);
        transaction.commit();
        session.close();
    }

    public ArrayList<HighScore> loadHighScoreTable() {
        Session session = sessionFactory.openSession();
        try {
            return (ArrayList<HighScore>) session.createQuery("from HighScore order by score desc");
        } finally {
            session.close();
        }
    }
}
