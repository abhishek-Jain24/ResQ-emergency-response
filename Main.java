import model.*;
import service.ResQService;
import java.util.Scanner;

public class Main {
    
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextLine()) {
                System.out.println("\nInput stream closed. Exiting ResQ...");
                System.exit(0);
            }
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a number.");
            }
        }
    }


    public static void main(String[] args) {
        ResQService service = new ResQService();
        Scanner sc = new Scanner(System.in);

        service.addResource(new Resource("AMB-01", EmergencyType.MEDICAL));
        service.addResource(new Resource("FIRE-01", EmergencyType.FIRE));
        service.addResource(new Resource("POL-01", EmergencyType.CRIME));

        int idCounter = 100;
        int arrivalCounter = 0;

        while (true) {
            System.out.println("\n=== ResQ MENU ===");
            System.out.println("1. Report Emergency");
            System.out.println("2. Dispatch Next");
            System.out.println("3. Free Resource (Resolves Emergency)");
            System.out.println("4. View Pending");
            System.out.println("5. View History");
            System.out.println("6. Exit");
            
            int choice = readInt(sc, "Choose: ");

            if (choice == 1) {
                System.out.print("Location: ");
                if (!sc.hasNextLine()) {
                    System.out.println("\nInput stream closed. Exiting ResQ...");
                    break;
                }
                String loc = sc.nextLine().trim();
                
                int s = readInt(sc, "Severity (1=HIGH, 2=MEDIUM, 3=LOW): ");
                if (s < 1 || s > 3) {
                    System.out.println(" Invalid severity. Try again.");
                    continue;
                }
                Severity sev = (s == 1) ? Severity.HIGH : (s == 2) ? Severity.MEDIUM : Severity.LOW;

                int t = readInt(sc, "Type (1=MEDICAL, 2=FIRE, 3=CRIME): ");
                if (t < 1 || t > 3) {
                    System.out.println("Invalid type. Try again.");
                    continue;
                }
                EmergencyType type = (t == 1) ? EmergencyType.MEDICAL : (t == 2) ? EmergencyType.FIRE : EmergencyType.CRIME;

                idCounter++;
                arrivalCounter++;
                service.reportEmergency(new Emergency("EMG-" + idCounter, loc, sev, type, arrivalCounter));

            } 
            
            else if (choice == 2) {
                service.processNext();

            } 
            else if (choice == 3) {
                System.out.print("Resource ID to free: ");
                if (!sc.hasNextLine()) {
                    System.out.println("\nInput stream closed. Exiting ResQ...");
                    break;
                }
                service.resolveResource(sc.nextLine().trim());

            } 
            else if (choice == 4) {
                service.showPending();

            } 
            else if (choice == 5) {
                service.showHistory();

            } 
            else if (choice == 6) {
                System.out.println(" Exiting ResQ...");
                break;
            } 
            else {
                System.out.println(" Invalid choice.");
            }
        }
        sc.close();
    }
}