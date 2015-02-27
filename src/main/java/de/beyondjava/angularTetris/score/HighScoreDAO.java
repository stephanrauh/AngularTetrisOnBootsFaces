package de.beyondjava.angularTetris.score;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HighScoreDAO {

    private static SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration()
        .setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
        .setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
        .setProperty("hibernate.connection.url", "jdbc:hsqldb:file:tetrisHighScores")
        .setProperty("hibernate.connection.username", "sa")
        .setProperty("hibernate.connection.password", "")
        .setProperty("hibernate.hbm2ddl.auto", "update")
        .setProperty("hibernate.show_sql", "true")
        .setProperty("hibernate.order_updates", "true")
        .addAnnotatedClass(HighScore.class);
        
        
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

    public List<HighScore> loadHighScoreTable() {
        Session session = sessionFactory.openSession();
        try {
            return (List<HighScore>) session.createQuery("from HighScore order by score desc").list();
        } finally {
            session.close();
        }
    }
}
