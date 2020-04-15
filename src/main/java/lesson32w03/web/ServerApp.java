package lesson32w03.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);
        ServletContextHandler handler = new ServletContextHandler();

        //handler.addServlet(new ServletHolder(new InfoServlet()), "/info");
        handler.addServlet(new ServletHolder(new CalcServlet()), "/calc/*");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
