import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    private static List<Employee> employeeList;

    public static void main(String[] args) throws Exception {
        employeeList = new ArrayList<>();

        // Khởi tạo 10 nhân viên mẫu
        initializeEmployees();
        // Hiển thị danh sách nhân viên
        displayEmployeeList();

        int choice;
        // Tạo vòng lặp chạy ứng dụng
        do {
            System.out.println("The function of App:");
            System.out.println("1: Add New Employee");
            System.out.println("2: Remove Employee");
            System.out.println("3: Display Employee List");
            System.out.println("4: Close App");
            System.out.print("Your choice: ");
            Scanner scanner = new Scanner(System.in);

            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    addNewEmployee(); // Thêm một nhân viên mới
                    break;
                case 2:
                    removeEmployee(); // Xóa một nhân viên
                    break;
                case 3:
                    displayEmployeeList(); // Hiển thị danh sách nhân viên
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }

    // Hàm hởi tạo 10 nhân viên mẫu
    private static void initializeEmployees() {
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee(i, "Employee " + i, 25 + i, "Department " + i, "Code " + i, 1000 * i);
            employeeList.add(employee);
        }
    }

    // Hàm hiển thị danh sách nhân viên
    private static void displayEmployeeList() {
        System.out.println("Employee List:");
        System.out.println("id\tname\t\tage\tdepartment\t\tcode\tsalaryrate");
        for (Employee employee : employeeList) {
            String formattedString = String.format("%-8d%-16s%-8d%-24s%-8s%.2f",
                    employee.id, employee.name, employee.age, employee.department, employee.code, employee.salaryrate);
            System.out.println(formattedString);
        }
        System.out.println();
    }

    // Hàm thêm một nhân viên mới
    private static void addNewEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        boolean checkId = true;
        for (Employee employee : employeeList) {
            if (id == employee.id) {
                checkId = false;
                break;
            }
        }
        // Kiểm tra trùng id
        if (checkId) {
            scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc số nguyên

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc số nguyên

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Code: ");
            String code = scanner.nextLine();

            System.out.print("Salary Rate: ");
            double salaryRate = scanner.nextDouble();

            Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
            employeeList.add(newEmployee);
            System.out.println();

            System.out.println("New employee added successfully.\n");
            System.out.println();
        } else {
            System.out.println("Your id is erroe!");
            System.out.println();
        }

        // // không đóng scanner luôn vì khi đóng nó là đóng luôn System.in và không thể
        // mở ra trong ứng dụng này
        // scanner.close();
    }

    // Hàm xóa một nhân viên
    private static void removeEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();

        boolean removed = false;
        for (Employee employee : employeeList) {
            if (employee.id == id) {
                employeeList.remove(employee);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Employee with ID " + id + " removed successfully.\n");
            System.out.println();
        } else {
            System.out.println("Employee with ID " + id + " not found.\n");
            System.out.println();
        }
    }
}
