package Controllers.DAO;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Controllers.Model.Employee;

public class DAOImpl implements DAO{
	JdbcTemplate jdbcTemp;
	public JdbcTemplate getJdbcTemp() {
		return jdbcTemp;
	}
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}

	
	  @Override
	  public List<Employee> getEmps(){ 
		List<Employee> l=jdbcTemp.query("select * from employee", new BeanPropertyRowMapper(Employee.class)); 
		
		return l; 
	}

		@Override
		public int addEmps( Employee emp){
			//System.out.println("Updating employee name foe id "+id);
			return jdbcTemp.update("insert into employee(name,pNo) values(?,?)", emp.getName(),emp.getpNo());
			 
		}
	
	@Override
	public int updateEmps( Employee emp){
		//System.out.println("Updating employee name foe id "+id);
		return jdbcTemp.update("update employee set name=? where id=?", emp.getName(),emp.getId());
		 
	}
	@Override
	public int delEmps(Employee emp){
		return jdbcTemp.update("delete from employee where id=?", emp.getId());
		
	}
	@Override
	public int updateEmps(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
