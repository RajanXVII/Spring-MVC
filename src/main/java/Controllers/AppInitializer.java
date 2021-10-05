package Controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer{

	
	  @Override 
	  public void onStartup(ServletContext sc) throws ServletException {
	  System.out.println("here!!"); AnnotationConfigWebApplicationContext ac=new
	  AnnotationConfigWebApplicationContext(); ac.register(Configuration.class);
	  ac.setServletContext(sc);
		/*
		 * XmlWebApplicationContext ac=new XmlWebApplicationContext();
		 * ac.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		 */
	  ServletRegistration.Dynamic sd=sc.addServlet("dispatcher", new
	  DispatcherServlet(ac)); sd.setLoadOnStartup(1); sd.addMapping("/"); }
	 

}
