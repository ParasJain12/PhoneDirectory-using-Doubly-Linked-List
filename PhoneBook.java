import java.util.Scanner;

class DNode {
    String number;
    String gmail;
    String name;
    DNode prev, next;

    public DNode(String n, String r, String g) {
        name = n;
        number = r;
        gmail = g;
        next = null;
        prev = null;
    }
}

class DList {
    DNode head, temp, ptr;
    DNode ptr1, ptr2, dup;

    public void accept() {
        Scanner scanner = new Scanner(System.in);
        String name, number, gmail;
        char ans;
        do {
            System.out.print("ENTER NAME      :");
            name = scanner.next();
            System.out.print("ENTER NUMBER    :");
            number = scanner.next();
            while (number.length() != 10) {
                System.out.print("ENTER VALID NUMBER  :");
                number = scanner.next();
            }
            System.out.print("ENTER G-MAIL    :");
            gmail = scanner.next();
            temp = new DNode(name, number, gmail);
            if (head == null) {
                head = temp;
            } else {
                ptr = head;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
                temp.prev = ptr;
            }
            System.out.print("DO YOU WANT TO CONTINUE? (y/n): ");
            ans = scanner.next().charAt(0);
        } while (ans == 'y');
    }

    public void display() {
        ptr = head;
        while (ptr != null) {
            System.out.println("\n\nNAME  ::\t" + ptr.name);
            System.out.println("NUMBER::\t+91-" + ptr.number);
            System.out.println("G-MAIL::\t" + ptr.gmail);
            ptr = ptr.next;
        }
    }

    public void insert() {
        accept();
    }

    public void sort() {
        DNode current;
        boolean sorted = false;
        if (head == null) {
            return;
        }
        while (!sorted) {
            sorted = true;
            current = head;
            while (current.next != null) {
                if (current.name.compareTo(current.next.name) > 0) {
                    // Swap nodes' data
                    String tempName = current.name;
                    String tempNumber = current.number;
                    String tempGmail = current.gmail;
                    current.name = current.next.name;
                    current.number = current.next.number;
                    current.gmail = current.next.gmail;
                    current.next.name = tempName;
                    current.next.number = tempNumber;
                    current.next.gmail = tempGmail;
                    sorted = false;
                }
                current = current.next;
            }
        }
    }
    

    public void deleteContact(String s) {
        ptr = head;
        while (ptr != null) {
            if (ptr.name.equals(s)) {
                if (ptr == head) {
                    head = head.next;
                    head.prev = null;
                } else {
                    ptr.prev.next = ptr.next;
                    if (ptr.next != null) {
                        ptr.next.prev = ptr.prev;
                    }
                }
                System.out.println("YOUR CONTACT IS SUCCESSFULLY DELETED\n\n");
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("YOUR ENTERED NAME IS NOT IN THE LIST...");
    }

    public void deleteSameName() {
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.name.equals(ptr2.next.name)) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void deleteSameNumber() {
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.number.equals(ptr2.next.number)) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void deleteSameGmail() {
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.gmail.equals(ptr2.next.gmail)) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void searchByName(String na) {
        ptr = head;
        while (ptr != null) {
            if (ptr.name.equals(na)) {
                System.out.println("NAME FOUND");
                System.out.println("CONTACT DETAILS ARE BELOW:\n");
                System.out.println("\n\nNAME  ::\t" + ptr.name);
                System.out.println("NUMBER::\t+91-" + ptr.number);
                System.out.println("G-MAIL::\t" + ptr.gmail);
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("NAME NOT FOUND");
    }

    public void searchByNumber(String num) {
        ptr = head;
        while (ptr != null) {
            if (ptr.number.equals(num)) {
                System.out.println("NUMBER FOUND\n");
                System.out.println("CONTACT DETAILS ARE BELOW:\n");
                System.out.println("\n\nNAME  ::\t" + ptr.name);
                System.out.println("NUMBER::\t+91-" + ptr.number);
                System.out.println("G-MAIL::\t" + ptr.gmail);
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("NUMBER NOT FOUND");
    }

    public void searchByGmail(String gm) {
        ptr = head;
        while (ptr != null) {
            if (ptr.gmail.equals(gm)) {
                System.out.println("G-MAIL FOUND\n");
                System.out.println("CONTACT DETAILS ARE BELOW:\n");
                System.out.println("\n\nNAME  ::\t" + ptr.name);
                System.out.println("NUMBER::\t+91-" + ptr.number);
                System.out.println("G-MAIL::\t" + ptr.gmail);
                return;
            }
            ptr = ptr.next;
        }
        System.out.println("G-MAIL NOT FOUND");
    }

    public void update(String n) {
        Scanner scanner = new Scanner(System.in);
        char ans;
        int c;
        ptr = head;
        while (ptr != null) {
            if (ptr.name.equals(n)) {
                do {
                    System.out.println("\nWHAT DO YOU WANT TO UPDATE?");
                    System.out.println("1. NAME");
                    System.out.println("2. PHONE NUMBER");
                    System.out.println("3. G-MAIL");
                    c = scanner.nextInt();
                    switch (c) {
                        case 1:
                            System.out.print("ENTER NEW NAME: ");
                            ptr.name = scanner.next();
                            break;
                        case 2:
                            System.out.print("ENTER NEW PHONE NUMBER: ");
                            String newNumber = scanner.next();
                            while (newNumber.length() != 10) {
                                System.out.print("ENTER VALID NUMBER: ");
                                newNumber = scanner.next();
                            }
                            ptr.number = newNumber;
                            break;
                        case 3:
                            System.out.print("ENTER NEW G-MAIL: ");
                            ptr.gmail = scanner.next();
                            break;
                    }
                    System.out.print("DO YOU WANT TO CONTINUE UPDATING? (y/n): ");
                    ans = scanner.next().charAt(0);
                } while (ans == 'y');
            }
        }
    }
}
    public class PhoneBook {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String name;
            char ans;
            int ch, a;
            DList d1 = new DList();
            System.out.println("**************                                PHONE BOOK                          ********************");
            System.out.print("\n\nWHAT IS YOUR NAME?\n");
            name = scanner.nextLine();
            System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!   WELCOME " + name + "   !!!!!!!!!!!!!!!!!!!!!");
            System.out.println("\n\n\nLET'S CREATE OUR PHONEBOOK " + name + "  \n\n");
            d1.accept();
            do {
                System.out.println("\n\n\n\n1) DISPLAY YOUR PHONE BOOK\n2) INSERT NEW CONTACT\n3) UPDATE DETAILS ON EXISTING CONTACT\n4) DELETE CONTACT\n5) DELETE SAME NAME IN PHONEBOOK\n6) DELETE SAME NUMBERS IN PHONEBOOK\n7) SEARCH\n");
                ch = scanner.nextInt();
                switch (ch) {
                    case 2:
                        d1.insert();
                        // Assuming sort method is called after insert
                        // d1.sort();
                        break;
                    case 1:
                        // d1.sort();
                        d1.display();
                        break;
                    case 3:
                        System.out.println("\n\nENTER THE NAME OF PERSON WHOSE DETAILS YOU WANT TO UPDATE...\n");
                        String n = scanner.next();
                        d1.update(n);
                        // d1.sort();
                        break;
                    case 4:
                        System.out.println("\nENTER THE NAME YOU WANT TO DELETE FROM PHONEBOOK\n");
                        String delName = scanner.next();
                        d1.deleteContact(delName);
                        break;
                    case 5:
                        d1.deleteSameName();
                        d1.display();
                        break;
                    case 6:
                        d1.deleteSameNumber();
                        d1.display();
                        break;
                    case 7:
                        do {
                            System.out.println("1.SEARCH BY NAME\n2.SEARCH BY NUMBER\n3.SEARCH BY GMAIL");
                            a = scanner.nextInt();
                            switch (a) {
                                case 1:
                                    System.out.println("ENTER THE NAME TO BE SEARCHED\n");
                                    String searchName = scanner.next();
                                    d1.searchByName(searchName);
                                    break;
                                case 2:
                                    System.out.println("ENTER THE NAME TO BE SEARCHED\n");
                                    String searchNumber = scanner.next();
                                    d1.searchByNumber(searchNumber);
                                    break;
                                case 3:
                                    System.out.println("ENTER THE NAME TO BE SEARCHED\n");
                                    String searchGmail = scanner.next();
                                    d1.searchByGmail(searchGmail);
                                    break;
                                default:
                                    System.out.println("\nNO PROPER INPUT GIVEN.....\n");
                            }
                            System.out.print("DO YOU WANT TO CONTINUE SEARCHING? (y/n): ");
                            ans = scanner.next().charAt(0);
                        } while (ans == 'y');
                        break;
                    case 8:
                        d1.deleteSameGmail();
                        d1.display();
                        break;
                    default:
                        System.out.println("\nNO PROPER INPUT GIVEN..\n");
                }
                System.out.print("\n\nDO YOU WANT TO CONTINUE OPERATIONS? (y/n): ");
                ans = scanner.next().charAt(0);
            } while (ans == 'y');
        }
    }
