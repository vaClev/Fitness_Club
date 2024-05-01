import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;

public class Site extends Club {

    int index;

    public void greeting() {

        System.out.println("Members:");
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i).name + "   " + memberList.get(i).id);
        }
        System.out.println();

        System.out.println("Trainers:");
        for (int i = 0; i < trainerList.size(); i++) {
            System.out.println(trainerList.get(i).name + "   " + trainerList.get(i).id);
        }
        System.out.println();

        System.out.println("Admins");
        for (int i = 0; i < adminList.size(); i++) {
            System.out.println(adminList.get(i).name + "   " + adminList.get(i).id);
        }
        System.out.println();
        System.out.println("Director");
        System.out.println(director.name + "   " + director.id);

        System.out.println();
        System.out.println();

        System.out.println("We glad to see you on out site!");
        System.out.println("\'Description\'");
        while (true) {
            menu();
        }
    }

    public void menu() {
        while (true) {

            System.out.println("" +
                    "Menu:\n" +
                    "1) Become a new member\n" +
                    "2) Look at public programs\n" +
                    "3) Look at price\n" +
                    "4) Sign in like a Member\n" +
                    "5) Sign in like a Trainer\n" +
                    "6) Sign in like a Administrator\n" +
                    "7) Sign in like a Director\n" +
                    "0) Exit from site");
            logistic();

        }
    }

    public void logistic() {
        int answer;
        try {
            System.out.print("Enter your answer - ");
            answer = Main.scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Error");
            Main.scanner.nextLine();
            return;
        }
            switch (answer) {
                case 1:
                    memberList.add(new Member("qwe", "qwe", 2));
                    break;
                case 2:
                    showPublicProgram();
                    break;
                case 3:
                    showTicketList();
                    break;
                case 4:
                    joinMember();
                    break;
                case 5:
                    joinTrainer();
                    break;
                case 6:
                    joinAdmin();
                    break;
                case 7:
                    joinDirector();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong enter");
            }
            System.out.println();
    }

    private void joinDirector() {
        System.out.print("Please enter the password: ");
        String directorPassword = Main.scanner.nextLine();
        directorPassword = Main.scanner.nextLine();
        if (Objects.equals(directorPassword, director.id)) {
            System.out.println();
            System.out.println("Hello " + director.name);
            director.visitorMenu();
        } else {
            System.out.println("Wrong password");
            System.out.println(directorPassword + "  " + director.id);
        }
    }

    private void joinAdmin() {
        System.out.print("Please enter the password: ");
        String adminPassword = Main.scanner.nextLine();
        adminPassword = Main.scanner.nextLine();
        index = -1;
        for (int i = 0; i < adminList.size(); i++) {
            if (Objects.equals(adminPassword, adminList.get(i).id)) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println();
            System.out.println("Hello " + adminList.get(index).name);
            adminList.get(index).visitorMenu();
        } else {
            System.out.println("Wrong password");
        }
    }

    private void joinTrainer() {
        System.out.print("Please enter the password: ");
        String trainerPassword = Main.scanner.nextLine();
        trainerPassword = Main.scanner.nextLine();
        index = -1;
        for (int i = 0; i < trainerList.size(); i++) {
            if (Objects.equals(trainerPassword, trainerList.get(i).id)) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println();
            System.out.println("Hello " + trainerList.get(index).name);
            trainerList.get(index).visitorMenu();
        } else {
            System.out.println("Wrong password");
        }
    }

    private void joinMember() {
        System.out.print("Please enter the password: ");
        String memberPassword = Main.scanner.nextLine();
        memberPassword = Main.scanner.nextLine();
        index = -1;
        for (int i = 0; i < memberList.size(); i++) {
            if (Objects.equals(memberPassword, memberList.get(i).id)) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println();
            System.out.println("Hello " + memberList.get(index).name);
            memberList.get(index).visitorMenu();
        } else {
            System.out.println("Wrong password");
        }
    }

    public void showTicketList() {
        for (Map.Entry<Integer, Integer> elem : prices.entrySet()) {
            System.out.println(elem.getValue() + " " + elem.getKey());
        }
    }

    public void showPublicProgram() {
        for (int i = 0; i < publicProgramList.size(); i++) {
            System.out.println((i + 1) + ") " + publicProgramList.get(i).name);
        }
    }

    public void showTrainerList() {
        for (Trainer elem : trainerList) {
            System.out.println(elem.name + " - " + elem.id);
        }
    }
}
