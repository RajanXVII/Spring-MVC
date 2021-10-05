package Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Controllers.DAO.DAOImpl;
import Controllers.Model.Employee;

@Controller
public class Controller1 implements WebMvcConfigurer{
	
	@Autowired
	DAOImpl daoImpl;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,value = "/get")
	public List<Employee> getSomething() {
		List<Employee> ls=daoImpl.getEmps();
		return ls;
	}
	/*
	 * @RequestMapping(method = RequestMethod.POST,value = "/add") public
	 * List<Employee> DelSomething(@RequestBody Employee employee) { List<Employee>
	 * ls=daoImpl.getEmps(); return ls; }
	 */
	/*
	 * @RequestMapping(method = RequestMethod.GET,value = "/modify") public String
	 * UpdateSomething(@RequestParam("update_id") int id,ModelMap ma) { int
	 * ls=daoImpl.updateEmps(id); ma.addAttribute("message", "updated id "+id);
	 * return "main"; }
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value = "/add")
	public List<Employee> addSomething(@ModelAttribute("employee") Employee employee,ModelMap m) {
		System.out.println(employee);
		//m.addAttribute("message", employee);
		for(Employee l:daoImpl.getEmps()) {
			if(l.getName().equals(employee.getName())) {
				System.out.println("id exists");
				return daoImpl.getEmps();
			}
		}
		int ls=daoImpl.addEmps(employee);
		
		return daoImpl.getEmps();
	}
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value = "/modify")
	public List<Employee> updateSomething(@ModelAttribute("employee") Employee employee,ModelMap m) {
		System.out.println(employee);
		//m.addAttribute("message", employee);
		boolean flag=false;
		
		for(Employee l:daoImpl.getEmps()) {
			if((l.getId()==(employee.getId()))) {
				System.out.println("id exists");
				flag=true;
			}
		}
		if(flag) {int ls=daoImpl.updateEmps(employee);}
		
		return daoImpl.getEmps();
	}
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,value = "/remove")
	public List<Employee> removeSomething(@ModelAttribute("employee") Employee employee,ModelMap m) {
		System.out.println(employee);
		//m.addAttribute("message", employee);
		boolean flag=false;
		for(Employee l:daoImpl.getEmps()) {
			if((l.getId()==(employee.getId()))) {
				System.out.println("id exists");
				flag=true;
			}
		}
		if(flag) {int ls=daoImpl.delEmps(employee);}
		
		return daoImpl.getEmps();
	}
	
	@RequestMapping(value = "/")
	public String baseCall() {
		
		return "main";
	}
	
	
}
