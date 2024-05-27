package jfinal;

import com.jfinal.core.JFinalFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class MyApp {
    public static void main(String[] args) {
        Server server = new Server(8082);

        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        ServletHandler handler = new ServletHandler();
//        ServletHolder sh = new ServletHolder(new MyServlet());
//        context.addServlet(sh, "/*");

        FilterHolder fh = handler.addFilterWithMapping(JFinalFilter.class.getName(), "/*", EnumSet.of(DispatcherType.REQUEST));
        fh.setInitParameter("configClass", "jfinal.DemoConfig");

        context.addFilter(fh, "/*", EnumSet.of(DispatcherType.REQUEST));
        context.insertHandler(handler);
        server.setHandler(context);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
