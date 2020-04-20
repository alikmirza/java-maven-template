package lesson33w04hw;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new LoginServlet()),"/login/*");
        handler.addServlet(new ServletHolder(new RegisterServlet()),"/registration/*");
        handler.addServlet(new ServletHolder(new HomeServlet()), "/home/*");
        handler.addServlet(new ServletHolder(new RedirectServlet("/login")),"/login.html");
        handler.addServlet(new ServletHolder(new RedirectServlet("/registration")),"/registration.html");
        handler.addServlet(new ServletHolder(new RedirectServlet("/home")),"/home.html");
        handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
