import java.util.Scanner;
public class NumberOfDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int year = 0;
        boolean check = false;
        while (!check) {
            System.out.print("Enter year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0) {
                    check = true;
                } else {
                    System.out.println("Invalid year.");
                }
            } else {
                System.out.println("Invalid year.");
                sc.next();
            }
        }
        check = false;
        while (!check) {
            System.out.print("Enter month: ");
            if (sc.hasNextInt()) {
                month = sc.nextInt();
                if (month >= 1 && month <= 12) {
                    check = true;
                } else {
                    System.out.println("Invalid month.");
                }
            } else {
                String str = sc.next();
                month = getMonth(str);
                if (month != -1) {
                    check = true;
                } else {
                    System.out.println("Invalid month.");
                }
            }
        }
        int days = getDays(month, year);
        System.out.println("Number of days: " + days);
        sc.close();
    }

    private static int getMonth(String str) {
        switch (str) {
            case "January":
            case "Jan.":
            case "Jan":
                return 1;
            case "February":
            case "Feb.":
            case "Feb":
                return 2;
            case "March":
            case "Mar.":
            case "Mar":
                return 3;
            case "April":
            case "Apr.":
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "June":
            case "Jun":
                return 6;
            case "July":
            case "Jul":
                return 7;
            case "August":
            case "Aug.":
            case "Aug":
                return 8;
            case "September":
            case "Sep.":
            case "Sep":
                return 9;
            case "October":
            case "Oct.":
            case "Oct":
                return 10;
            case "November":
            case "Nov.":
            case "Nov":
                return 11;
            case "December":
            case "Dec.":
            case "Dec":
                return 12;
            default:
                return -1;
        }
    }

    private static int getDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 & year % 400 != 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
