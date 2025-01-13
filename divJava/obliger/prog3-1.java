import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    // 1: Slett det første elementet i listen.. Tidskompleksitet: O(1)
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
            System.out.println("Slettet første element.");
        } else {
            System.out.println("Listen er tom.");
        }
    }

    // 2: Legge til et element på slutten av listen. Tidskompleksitet: O(n)
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Element er lagt til slutten av listen.");
    }

    // 3: Slette det siste elementet i listen. Tidskompleksitet: O(n)
    public void deleteLast() {
        if (head == null) {
            System.out.println("Listen er tom.");
        } else if (head.next == null) {
            head = null;
            System.out.println("Siste element i listen er slettet.");
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            System.out.println("Siste element i listen er blitt slettet.");
        }
    }

    // 4: Slett et element med en spesifikk verdi. Tidskompleksitet: O(n)
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("Listen er tom.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("Element med verdi " + value + " er slettet.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Element med verdi " + value + " er slettet.");
        } else {
            System.out.println("Element med verdi " + value + " finnes ikke.");
        }
    }

    // 5: Legg til et element etter et element med kjent verdi. Tidskompleksitet: O(n)
    public void addAfter(int target, int data) {
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Element med verdi " + data + " er lagt til etter " + target + ".");
        } else {
            System.out.println("Element med oppgitt verdi " + target + " finnes ikke.");
        }
    }

    // 6: Legg til et element før et element med kjent verdi. Tidskomplektistet: O(n)
    public void addBefore(int target, int data) {
        if (head == null) {
            System.out.println("Listen er tom.");
            return;
        }
        if (head.data == target) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            System.out.println("Element med verdi " + data + " lagt til før element med oppgitt verdi " + target + ".");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Element med verdi " + data + " lagt til før element med oppgitt verdi " + target + ".");
        } else {
            System.out.println("Element med verdi " + target + " finnes ikke.");
        }
    }

    // 7: Printer lengden av listen til terminalen. Tidskompleksitet: O(n)
    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Listen har lengde: " + count);
        return count;
    }

    // 8: Tell forekomster av element med oppgitt verdi. Tidskompleksitet: O(n)
    public int countOccurrences(int value) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                count++;
            }
            temp = temp.next;
        }
        System.out.println("Forekomster av: " + value + ": " + count);
        return count;
    }

    // 9: Printer hele listen til terminalen. Tidskompleksitet: O(n)
    public void printList() {
        if (head == null) {
            System.out.println("Listen er tom.");
            return;
        }
        Node temp = head;
        System.out.print("Elementer i listen: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 10: Sletter hele listen og oppgir antall elementer slettet. Tidskompleksitet: O(n)
    public void deleteAll() {
        int count = length();
        head = null;
        System.out.println("Alle elementer i listen er slettet. Antall elementer slettet: " + count);
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMeny:");
            System.out.println("1: Slett det første elementet i listen");
            System.out.println("2: Legg til et element på slutten av listen");
            System.out.println("3: Slett det siste elementet i listen");
            System.out.println("4: Slett element med oppgitt verdi");
            System.out.println("5: Legg til et element etter en oppgitt verdi");
            System.out.println("6: Legg til et element før en oppgitt verdi");
            System.out.println("7: Print lengden av listen");
            System.out.println("8: Tell antall forekomster av en oppgitt verdi");
            System.out.println("9: Print hele listen til terminalen");
            System.out.println("10: Slett hele listen og returner antall elementer slettet");
            System.out.println("11: Exit");
            System.out.print("Bruk 1-11 for å velge funksjon: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                int value, target;

                if (choice == 1) {
                    list.deleteFirst();
                } else if (choice == 2) {
                    System.out.print("Skriv inn verdien som skal legges til: ");
                    if (scanner.hasNextInt()) {
                        value = scanner.nextInt();
                        list.addLast(value);
                    } else {
                        System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                        scanner.next(); // Forbruker den ugyldige inputen
                    }
                } else if (choice == 3) {
                    list.deleteLast();
                } else if (choice == 4) {
                    System.out.print("Skriv inn verdien som skal slettes: ");
                    if (scanner.hasNextInt()) {
                        value = scanner.nextInt();
                        list.deleteByValue(value);
                    } else {
                        System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                        scanner.next();
                    }
                } else if (choice == 5) {
                    System.out.print("Skriv inn målverdien: ");
                    if (scanner.hasNextInt()) {
                        target = scanner.nextInt();
                        System.out.print("Skriv inn verdien som skal legges til etter " + target + ": ");
                        if (scanner.hasNextInt()) {
                            value = scanner.nextInt();
                            list.addAfter(target, value);
                        } else {
                            System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                        scanner.next();
                    }
                } else if (choice == 6) {
                    System.out.print("Skriv inn målverdien: ");
                    if (scanner.hasNextInt()) {
                        target = scanner.nextInt();
                        System.out.print("Skriv inn verdien som skal legges til foran " + target + ": ");
                        if (scanner.hasNextInt()) {
                            value = scanner.nextInt();
                            list.addBefore(target, value);
                        } else {
                            System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                        scanner.next();
                    }
                } else if (choice == 7) {
                    list.length();
                } else if (choice == 8) {
                    System.out.print("Skriv inn verdien som skal telles: ");
                    if (scanner.hasNextInt()) {
                        value = scanner.nextInt();
                        list.countOccurrences(value);
                    } else {
                        System.out.println("Ugyldig input. Vennligst skriv inn et heltall.");
                        scanner.next();
                    }
                } else if (choice == 9) {
                    list.printList();
                } else if (choice == 10) {
                    list.deleteAll();
                } else if (choice == 11) {
                    running = false;
                    System.out.println("Avslutter programmet.");
                } else {
                    System.out.println("Ugyldig valg. Prøv igjen.");
                }
            } else {
                System.out.println("Ugyldig input. Vennligst skriv inn et tall fra menyen.");
                scanner.next(); // Forbruker den ugyldige inputen
            }
        }
        scanner.close();
    }
}

