package Controllers.DAO;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import Controllers.Model.Employee;

public interface DAO {
	public List<Employee> getEmps();
	//public ModelAndView getEmps();
	public int updateEmps(int id);
	public int delEmps(Employee emp);
	int updateEmps(Employee emp);
	int addEmps(Employee emp);
}
