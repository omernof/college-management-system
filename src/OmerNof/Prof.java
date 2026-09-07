package OmerNof;

import java.io.Serializable;

public class Prof extends Doctor implements Serializable{
    protected String[] article = new String[2];
    protected String institutionName;

    public Prof(String name, int id, Degree typeOfDegree,  String nameOfDegree, double salary, String department, String institutionName){
        super(name,id, typeOfDegree, nameOfDegree, salary, department);
        this.institutionName = institutionName;
    }




}
