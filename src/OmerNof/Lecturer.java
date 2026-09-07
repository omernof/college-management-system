package OmerNof;
import java.io.Serializable;

public class Lecturer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;

    public enum Degree{first, second, dr, prof};
    private Degree typeOfDegree;
    private String nameOfDegree;
    private double salary;
    private String department;

    public Lecturer(String name, int id, Degree typeOfDegree,  String nameOfDegree, double salary, String department){
        this.name = name;
        this.id = id;
        this.typeOfDegree = typeOfDegree;
        this.nameOfDegree = nameOfDegree;
        this.salary = salary;
        this.department = department;
    }

    public Lecturer(Lecturer other){
        setName(other.name);
        setId(other.id);
        setNameOfDegree(other.nameOfDegree);
        setSalary(other.salary);
        setDepartment(other.department);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameOfDegree(String nameOfDegree) {
        this.nameOfDegree = nameOfDegree;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumOfArticles() {
        return 0;
    }

    public String getName (){
        return name;
    }

    public int getId (){
        return id;
    }

    public Degree getTypeOfDegree() {
        return typeOfDegree;
    }

    public String getNameOfDegree (){
        return nameOfDegree;
    }

    public Degree getDegree() {return typeOfDegree;}

    public void setDegree(Degree degree) {this.typeOfDegree = typeOfDegree;}

    public double getSalary(){
        return salary;
    }

    public String getDepartment(){
        return department;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type of degree='" + typeOfDegree + '\'' +
                ", nameOfDegree='" + nameOfDegree + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
