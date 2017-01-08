package starter.config.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
public class WebConfig implements ServletContextInitializer {

  private final Logger log = LoggerFactory.getLogger(WebConfig.class);

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    log.debug("Initialize H2 console");
    ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
    h2ConsoleServlet.addMapping("/console/*");
    h2ConsoleServlet.setInitParameter("-properties", "src/main/resources");
    h2ConsoleServlet.setLoadOnStartup(1);
  }
}