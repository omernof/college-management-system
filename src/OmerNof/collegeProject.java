package OmerNof;

import java.util.Scanner;

public class collegeProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollegeManager manager = new CollegeManager();

        int choice;
        do {
            manager.printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                case 1:
                    System.out.println("Enter lecturer's name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name of degree:");
                    String nameOfDegree = scanner.nextLine();
                    System.out.println("Enter type of degree: first, second, dr, prof");
                    String typeOfDegree = scanner.nextLine();
                    System.out.println("Enter department:");
                    String department = scanner.nextLine();
                    System.out.println("Enter salary:");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    manager.addLecturer(name, id, typeOfDegree, nameOfDegree, salary, department);
                    break;
                case 2:
                    System.out.println("Enter committee name:");
                    String committeeName = scanner.nextLine();
                    System.out.println("Enter chairman ID:");
                    int chairmanId = scanner.nextInt();
                    scanner.nextLine();
                    manager.addCommittee(committeeName, chairmanId);
                    break;
                case 3:
                    System.out.println("Enter committee name:");
                    String cName = scanner.nextLine();
                    System.out.println("Enter lecturer ID to add:");
                    int lecId = scanner.nextInt();
                    scanner.nextLine();
                    manager.assignLecturerToCommittee(lecId, cName);
                    break;
                case 4:
                    System.out.println("Enter committee name:");
                    String comName = scanner.nextLine();
                    System.out.println("Enter new chairman ID:");
                    int newChairId = scanner.nextInt();
                    scanner.nextLine();
                    manager.updateChairman(comName, newChairId);
                    break;
                case 5:
                    System.out.println("Enter committee name:");
                    String comNameToRemove = scanner.nextLine();
                    System.out.println("Enter lecturer ID to remove:");
                    int lecToRemove = scanner.nextInt();
                    scanner.nextLine();
                    manager.removeLecturerFromCommittee(comNameToRemove, lecToRemove);
                    break;
                case 6:
                    System.out.println("Enter department name:");
                    String deptName = scanner.nextLine();
                    System.out.println("Enter number of students:");
                    int students = scanner.nextInt();
                    scanner.nextLine();
                    manager.addDepartment(deptName, students);
                    break;
                case 7:
                    manager.averageSalaryAll();
                    break;
                case 8:
                    System.out.println("Enter department name:");
                    String dept = scanner.nextLine();
                    manager.averageSalaryByDepartment(dept);
                    break;
                case 9:
                    manager.printAllLecturers();
                    break;
                case 10:
                    manager.printAllCommittees();
                    break;
                case 11:
                    manager.getHighestPaidLecturer();
                    break;
                case 12:
                    manager.countCommitteeMembers();
                    break;
                case 13:
                    manager.getLecturersWithoutCommittee();
                    break;
                case 14:
                    manager.getLargestDepartment();
                    break;
                case 15:
                    manager.getBusyLecturers();
                    break;
                case 16:
                    manager.getProfessorsBySalary();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
