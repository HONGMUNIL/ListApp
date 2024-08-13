
import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    // 할 일  ArrayList
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {      
            System.out.println("== 할 일 목록 관리 프로그램 ==");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 보기");
            System.out.println("3. 할 일 삭제");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 


           //기능 실행
            switch (choice) {
                    case 1:
                        addTodo(scanner);
                        break;
                    case 2:
                        viewTodos();
                    break;
                    case 3:
                        deleteTodo(scanner);
                    break;
                    case 0:
                        System.out.println("프로그램을 종료.");
                    break;
                default:
                    System.out.println("잘못된 입력. 다시 시도하세요.");
             }
        } while (choice != 0);

        scanner.close();
    }

    // 할 일 추가 메서드
    private static void addTodo(Scanner scanner) {
        System.out.print("추가할 할 일: ");
        String todo = scanner.nextLine();
        todoList.add(todo);
        System.out.println("할 일이 추가.");
    }

    // 할 일 목록 메서드
    private static void viewTodos() {
        System.out.println("== 현재 할 일 목록 ==");
            if (todoList.isEmpty()) {
             System.out.println("할 일이 없습니다.");
            } else {
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println((i + 1) + ". " + todoList.get(i));
                }
            }
    }

    // 삭제 메서드
    private static void deleteTodo(Scanner scanner) {
        viewTodos();
            if (!todoList.isEmpty()) {
                System.out.print("삭제할 할 일 번호: ");
                int index = scanner.nextInt();
                scanner.nextLine();  // 개행 문자 소비

                if (index > 0 && index <= todoList.size()) {
                    todoList.remove(index - 1);
                    System.out.println("할 일 삭제.");
                } else {
                 System.out.println("잘못된 번호.");
                }
        }
    }
}

