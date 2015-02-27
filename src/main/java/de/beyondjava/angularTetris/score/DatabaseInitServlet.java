package de.beyondjava.angularTetris.score;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.hsqldb.server.Servlet;

public class DatabaseInitServlet extends Servlet {
    private static final long serialVersionUID = 1L;

    @Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Starting HSQLDB database!");
		try {
			HsqlProperties p = new HsqlProperties();
			p.setProperty("server.database.0", "mem:mymemdb");
			p.setProperty("server.dbname.0", "tetrisHighScores");
			p.setProperty("server.port", "9001");
			Server server = new Server();

			server.setProperties(p);

			server.setLogWriter(null); // can use custom writer
			server.setErrWriter(null); // can use custom writer
			server.start();
		} catch (IOException | AclFormatException e) {
			throw new ServletException(e);
		}
	}
}
