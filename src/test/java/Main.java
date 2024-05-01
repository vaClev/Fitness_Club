import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Site site = new Site();

    public static void main(String[] args) {
        site.createPrices();
        site.createAdmins();
        site.createMembers();
        site.createTrainers();
        site.createPublicPrograms();

        site.greeting();
//      Избавиться от рекурсии

    }
}
