package OmerAndLinoy;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Cloneable, Serializable {
    private String nameOfDepartment;
    private int numOfStudents;
    private ArrayList<Lecturer> lecturers;

    public Department(String nameOfDepartment, int numOfStudents) {
        this.nameOfDepartment = nameOfDepartment;
        this.numOfStudents = numOfStudents;
        this.lecturers = new ArrayList<>();
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public boolean removeLecturerFromDepartment(String name) {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getName().equals(name)) {
                lecturers.remove(i);
                return true;
            }
        }
        return false;
    }

    public int sumOfArticles() {
        int sum = 0;
        for (Lecturer lecturer : lecturers) {
            if (lecturer instanceof Doctor) {
                sum += lecturer.getNumOfArticles();
            }
        }
        return sum;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public int getNumberOfLecturers() {
        return lecturers.size();
    }

    @Override
    public String toString() {
        return "Department{" +
                "nameOfDepartment='" + nameOfDepartment + '\'' +
                ", numOfStudents=" + numOfStudents +
                ", lecturers=" + lecturers +
                ", lecturersCount=" + lecturers.size() +
                '}';
    }
}
