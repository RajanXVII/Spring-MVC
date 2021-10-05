package Controllers.Model;

public class Employee {
private String name;
private int id;
private String pNo;
public Employee() {
	System.out.println("No arg constructor!!");
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getpNo() {
	return pNo;
}
public void setpNo(String pNo) {
	this.pNo = pNo;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + ", pNo=" + pNo + "]";
}

}
