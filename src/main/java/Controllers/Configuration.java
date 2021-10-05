package Controllers;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.DefaultUriBuilderFactory;

import Controllers.DAO.DAOImpl;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "Controllers")
@EnableWebMvc
@PropertySource(value="/WEB-INF/jdbc.properties")
public class Configuration{ 
	@Value("${jdbc.user}")
	private String username;
	@Value("${jdbc.pass}")
	private String password;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.driver}")
	private String driver;
	
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	@Bean
    public DAOImpl getDAOImpl() {
        DAOImpl daoimpl=new DAOImpl();
        daoimpl.setJdbcTemp(getJdbcTemplate());
        return daoimpl;
    }
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource sd=new DriverManagerDataSource();
		sd.setDriverClassName(driver);
		sd.setUsername(username);
		sd.setPassword(password);
		sd.setUrl(url);
		JdbcTemplate jdbctemp=new JdbcTemplate();
		jdbctemp.setDataSource(sd);
		return jdbctemp;
	}
	
	
	

}
