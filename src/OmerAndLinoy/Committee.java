package OmerAndLinoy;

import java.io.Serializable;
import java.util.ArrayList;

public class Committee implements Cloneable, Serializable{
    private String nameOfCommittee;
    private ArrayList<Lecturer> lecturers;
    private Lecturer chairman; // יושב ראש הוועדה
    private Lecturer.Degree requiredDegree;
    private int lecturersIndex = 0;
    private Lecturer[] committeeLecturers;
    private int committeeLecturersIndex;

    public Committee(String nameOfCommittee, Lecturer chairman, Lecturer.Degree requiredDegree) {
        this.nameOfCommittee = nameOfCommittee;
        this.chairman = chairman;
        this.requiredDegree = requiredDegree;
        this.lecturers = new ArrayList<>();
        this.lecturers.add(chairman);
    }

    @Override
    public Committee clone() throws CloneNotSupportedException {
        Committee clonedCommittee = (Committee) super.clone();

        clonedCommittee.nameOfCommittee = "new" + this.nameOfCommittee;
        clonedCommittee.chairman = this.chairman;
        clonedCommittee.lecturers = new ArrayList<>(this.lecturers);

        return clonedCommittee;
    }

    public boolean isLecturerExists(Lecturer lecturer) {
        return lecturers.contains(lecturer);
    }

    // הוסרו כל הפרינטים - הלוגיקה מטופלת ב-CollegeManager
    public void addLecturerToCommittee(Lecturer lecturer) {
        if (lecturers.contains(lecturer)) {
            return; // כבר קיים
        }
        lecturers.add(lecturer);
    }

    // הפונקציה מחזירה boolean כדי ש-CollegeManager יוכל לטפל בהדפסה
    public boolean removeLecturerFromCommittee(String name) {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getName().equals(name)) {
                lecturers.remove(i);
                return true; // נמצא והוסר
            }
        }
        return false; // לא נמצא
    }

    private Lecturer[] increaseArr(Lecturer[] arr, int index) {
        int newSize = arr.length * 2;
        Lecturer[] newArr = new Lecturer[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public String getNameOfCommittee() {
        return nameOfCommittee;
    }

    public Lecturer getChairman() {
        return chairman;
    }

    public Lecturer.Degree getRequiredDegree() {
        return requiredDegree;
    }

    public void setNameOfCommittee(String nameOfCommittee) {
        this.nameOfCommittee = nameOfCommittee;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void setChairman(Lecturer chairman) {
        this.chairman = chairman;
    }

    @Override
    public String toString() {
        return "Committee{" +
                "nameOfCommittee='" + nameOfCommittee + '\'' +
                ", lecturers=" + lecturers +
                ", chairman=" + chairman +
                ", lecturersCount=" + lecturers.size() +
                '}';
    }
}
