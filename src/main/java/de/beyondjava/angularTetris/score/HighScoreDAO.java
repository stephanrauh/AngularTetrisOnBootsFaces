package de.beyondjava.angularTetris.score;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HighScoreDAO {

    private static SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
                .setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
                .setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:tetrisHighScores")
                .setProperty("hibernate.connection.username", "sa").setProperty("hibernate.connection.password", "")
                .setProperty("hibernate.hbm2ddl.auto", "update").setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.order_updates", "true").addAnnotatedClass(HighScore.class);

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
            List<HighScore> result = (List<HighScore>) session.createQuery("from HighScore order by score desc").list();
            result = addDefaultEntries(result);
            result.sort(new Comparator<HighScore>() {
                public int compare(HighScore o1, HighScore o2) {
                    return o2.getScore() - o1.getScore();
                }
            });
            while (result.size()>100)
                result.remove(100); // Protection against Out of Memory
            return result;
        } finally {
            session.close();
        }
    }

    public List<HighScore> addDefaultEntries(List<HighScore> scores) {
        scores.add(new HighScore("Alf Abet", 100));
        scores.add(new HighScore("Anna Lytic", 200));
        scores.add(new HighScore("Brook Lynn", 300));
        scores.add(new HighScore("Buzz Zing", 400));
        scores.add(new HighScore("Cal Efornia", 500));
        scores.add(new HighScore("Di Nomite", 600));
        scores.add(new HighScore("Frank Lee Speaking", 700));
        scores.add(new HighScore("Gene Poole", 800));
        scores.add(new HighScore("Herb Garden", 900));
        scores.add(new HighScore("Iknowa Nothing", 1000));
        scores.add(new HighScore("Justin Time ", 1100));
        scores.add(new HighScore("Ken U. Seemee", 1200));
        scores.add(new HighScore("Les Izmore", 1300));
        scores.add(new HighScore("Marge Innastraightline", 1400));
        scores.add(new HighScore("Nick O'Teen", 1500));
        scores.add(new HighScore("Otto Mobile", 1600));
        scores.add(new HighScore("Park Bench", 1700));
        scores.add(new HighScore("Rusty Carr", 1800));
        scores.add(new HighScore("Sonny Day", 1900));
        scores.add(new HighScore("Taylor Maide", 2000));
        scores.add(new HighScore("Ulee Daway ", 2100));
        scores.add(new HighScore("Van Ishingpoint ", 2200));
        scores.add(new HighScore("Wanda Party", 2300));
        scores.add(new HighScore("X. Ray Specs", 2400));
        scores.add(new HighScore("Yuri Diculous", 2500));
        scores.add(new HighScore("Zalt Ann Pepper ", 2600));
        return scores;
    }
}