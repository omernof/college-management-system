package OmerAndLinoy;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the college's departments, lecturers and committees entirely in memory
 * (no external database) using the OOP class hierarchy: Lecturer / Doctor / Prof,
 * Department and Committee.
 */
public class CollegeManager {
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Committee> committees = new ArrayList<>();

    public void printMenu() {
        System.out.println("\n=== College Management System ===");
        System.out.println("0- Exit");
        System.out.println("1- add lecturer");
        System.out.println("2- add committee");
        System.out.println("3- add member to committee");
        System.out.println("4- update chairman to committee");
        System.out.println("5- remove member from committee");
        System.out.println("6- add department");
        System.out.println("7- average salary of all lecturers");
        System.out.println("8- average salary of specific department");
        System.out.println("9- details of all lecturers");
        System.out.println("10- details of all committees");
        System.out.println("11- Highest paid lecturer");
        System.out.println("12- Count members in each committee");
        System.out.println("13- Lecturers without any committee");
        System.out.println("14- Department with the most students");
        System.out.println("15- Lecturers in 2 or more committees");
        System.out.println("16- Professors ordered by salary");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }

    // --- helpers ---

    private Department findDepartment(String name) {
        for (Department d : departments) {
            if (d.getNameOfDepartment().equals(name)) return d;
        }
        return null;
    }

    private Committee findCommittee(String name) {
        for (Committee c : committees) {
            if (c.getNameOfCommittee().equals(name)) return c;
        }
        return null;
    }

    private Lecturer findLecturerById(int id) {
        for (Department d : departments) {
            for (Lecturer l : d.getLecturers()) {
                if (l.getId() == id) return l;
            }
        }
        return null;
    }

    private List<Lecturer> allLecturers() {
        List<Lecturer> all = new ArrayList<>();
        for (Department d : departments) {
            all.addAll(d.getLecturers());
        }
        return all;
    }

    // --- menu operations ---

    public void addDepartment(String name, int students) {
        if (findDepartment(name) != null) {
            System.out.println("Department already exists.");
            return;
        }
        departments.add(new Department(name, students));
        System.out.println("Department added successfully.");
    }

    public void addLecturer(String name, int id, String type, String degName, double sal, String dept) {
        Department department = findDepartment(dept);
        if (department == null) {
            System.out.println("Department not found.");
            return;
        }

        Lecturer.Degree degree;
        try {
            degree = Lecturer.Degree.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown degree type. Use: first, second, dr, prof");
            return;
        }

        Lecturer lecturer;
        if (degree == Lecturer.Degree.prof) {
            lecturer = new Prof(name, id, degree, degName, sal, dept, "");
        } else if (degree == Lecturer.Degree.dr) {
            lecturer = new Doctor(name, id, degree, degName, sal, dept);
        } else {
            lecturer = new Lecturer(name, id, degree, degName, sal, dept);
        }

        department.addLecturer(lecturer);
        System.out.println("Lecturer added successfully.");
    }

    public void addCommittee(String name, int chairId) {
        if (findCommittee(name) != null) {
            System.out.println("Committee already exists.");
            return;
        }
        Lecturer chairman = findLecturerById(chairId);
        if (chairman == null) {
            System.out.println("Lecturer not found.");
            return;
        }
        committees.add(new Committee(name, chairman, chairman.getTypeOfDegree()));
        System.out.println("Committee added successfully.");
    }

    public void assignLecturerToCommittee(int lecId, String cName) {
        Committee committee = findCommittee(cName);
        if (committee == null) {
            System.out.println("Committee not found.");
            return;
        }
        Lecturer lecturer = findLecturerById(lecId);
        if (lecturer == null) {
            System.out.println("Lecturer not found.");
            return;
        }
        committee.addLecturerToCommittee(lecturer);
        System.out.println("Lecturer assigned to committee.");
    }

    public void updateChairman(String cName, int newChairId) {
        Committee committee = findCommittee(cName);
        if (committee == null) {
            System.out.println("Committee not found.");
            return;
        }
        Lecturer lecturer = findLecturerById(newChairId);
        if (lecturer == null) {
            System.out.println("Lecturer not found.");
            return;
        }
        committee.setChairman(lecturer);
        System.out.println("Chairman updated.");
    }

    public void removeLecturerFromCommittee(String cName, int lecId) {
        Committee committee = findCommittee(cName);
        if (committee == null) {
            System.out.println("Committee not found.");
            return;
        }
        Lecturer lecturer = findLecturerById(lecId);
        if (lecturer == null) {
            System.out.println("Lecturer not found.");
            return;
        }
        boolean removed = committee.removeLecturerFromCommittee(lecturer.getName());
        if (removed) System.out.println("Lecturer removed.");
        else System.out.println("Lecturer not found in this committee.");
    }

    public void averageSalaryAll() {
        List<Lecturer> all = allLecturers();
        if (all.isEmpty()) {
            System.out.println("No lecturers found.");
            return;
        }
        double sum = 0;
        for (Lecturer l : all) sum += l.getSalary();
        System.out.println("Average salary of all lecturers: " + (sum / all.size()));
    }

    public void averageSalaryByDepartment(String dept) {
        Department department = findDepartment(dept);
        if (department == null) {
            System.out.println("Department not found.");
            return;
        }
        List<Lecturer> lecturers = department.getLecturers();
        if (lecturers.isEmpty()) {
            System.out.println("No lecturers found in this department.");
            return;
        }
        double sum = 0;
        for (Lecturer l : lecturers) sum += l.getSalary();
        System.out.println("Average salary in " + dept + ": " + (sum / lecturers.size()));
    }

    public void printAllLecturers() {
        for (Lecturer l : allLecturers()) {
            System.out.println(l);
        }
    }

    public void printAllCommittees() {
        for (Committee c : committees) {
            System.out.println(c);
        }
    }

    // --- reports ---

    public void getHighestPaidLecturer() {
        Lecturer best = null;
        for (Lecturer l : allLecturers()) {
            if (best == null || l.getSalary() > best.getSalary()) best = l;
        }
        if (best != null) {
            System.out.println("Highest Paid Lecturer: " + best.getName() + " with salary " + best.getSalary());
        } else {
            System.out.println("No lecturers found.");
        }
    }

    public void countCommitteeMembers() {
        for (Committee c : committees) {
            // lecturers count includes the chairman, who is added on creation
            System.out.println("Committee: " + c.getNameOfCommittee());
        }
    }

    public void getLecturersWithoutCommittee() {
        System.out.println("Lecturers without any committee:");
        boolean found = false;
        for (Lecturer l : allLecturers()) {
            boolean inCommittee = false;
            for (Committee c : committees) {
                if (c.isLecturerExists(l)) {
                    inCommittee = true;
                    break;
                }
            }
            if (!inCommittee) {
                System.out.println("- " + l.getName());
                found = true;
            }
        }
        if (!found) System.out.println("Everyone is in a committee!");
    }

    public void getLargestDepartment() {
        Department largest = null;
        for (Department d : departments) {
            if (largest == null || d.getNumOfStudents() > largest.getNumOfStudents()) largest = d;
        }
        if (largest != null) {
            System.out.println("Largest Department: " + largest.getNameOfDepartment() + " (" + largest.getNumOfStudents() + " students)");
        } else {
            System.out.println("No departments found.");
        }
    }

    public void getBusyLecturers() {
        System.out.println("Lecturers in 2 or more committees:");
        boolean found = false;
        for (Lecturer l : allLecturers()) {
            int count = 0;
            for (Committee c : committees) {
                if (c.isLecturerExists(l)) count++;
            }
            if (count >= 2) {
                System.out.println("- " + l.getName() + " (in " + count + " committees)");
                found = true;
            }
        }
        if (!found) System.out.println("No lecturer is in 2 or more committees.");
    }

    public void getProfessorsBySalary() {
        List<Lecturer> profs = new ArrayList<>();
        for (Lecturer l : allLecturers()) {
            if (l.getTypeOfDegree() == Lecturer.Degree.prof) profs.add(l);
        }
        profs.sort((a, b) -> Double.compare(b.getSalary(), a.getSalary()));

        System.out.println("Professors ranked by salary:");
        if (profs.isEmpty()) {
            System.out.println("No professors found.");
            return;
        }
        for (Lecturer l : profs) {
            System.out.println("- " + l.getName() + " | Salary: " + l.getSalary());
        }
    }
}
