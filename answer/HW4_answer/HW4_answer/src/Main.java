import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the test file name.");
        String filename = s.next();
        File file = new File(filename);

        s.close();

        Scanner sc = new Scanner(file);
        KeywordList kLst = new KeywordList();

        while (sc.hasNext()) {
            String cmd = sc.next();
            try {
                switch (cmd) {
                    case "add": {
                        String name = sc.next();
                        int count = 0;
                        float weight = 0.0f;

                        // Check if the input format is correct for 'add'
                        if (sc.hasNextInt()) {
                            count = sc.nextInt();
                        } else {
                            throw new InputMismatchException("Count must be an integer.");
                        }

                        if (sc.hasNextFloat()) {
                            weight = sc.nextFloat();
                        } else {
                            throw new InputMismatchException("Weight must be a float.");
                        }

                        Keyword k = new Keyword(name, count, weight);
                        kLst.add(k);
                    }
                    break;

                    case "outputIndex": {
                        if (sc.hasNextInt()) {
                            int index = sc.nextInt();
                            kLst.outputIndex(index);
                        } else {
                            throw new InputMismatchException("Index must be an integer.");
                        }
                    }
                    break;

                    case "outputCount": {
                        if (sc.hasNextInt()) {
                            int count = sc.nextInt();
                            kLst.outputCount(count);
                        } else {
                            throw new InputMismatchException("Count must be an integer.");
                        }
                    }
                    break;

                    case "outputHas": {
                        String pattern = sc.next();
                        kLst.outputHas(pattern);
                    }
                    break;

                    case "outputName": {
                        String name = sc.next();
                        kLst.outputName(name);
                    }
                    break;

                    case "outputFirstN": {
                        if (sc.hasNextInt()) {
                            int n = sc.nextInt();
                            kLst.outputFirstN(n);
                        } else {
                            throw new InputMismatchException("N must be an integer.");
                        }
                    }
                    break;

                    case "outputScore": {
                        kLst.outputScore();
                    }
                    break;

                    case "deleteIndex": {
                        if (sc.hasNextInt()) {
                            int index = sc.nextInt();
                            kLst.deleteIndex(index);
                        } else {
                            throw new InputMismatchException("Index must be an integer.");
                        }
                    }
                    break;

                    case "deleteCount": {
                        if (sc.hasNextInt()) {
                            int count = sc.nextInt();
                            kLst.deleteCount(count);
                        } else {
                            throw new InputMismatchException("Count must be an integer.");
                        }
                    }
                    break;

                    case "deleteHas": {
                        String pattern = sc.next();
                        kLst.deleteHas(pattern);
                    }
                    break;

                    case "deleteName": {
                        String name = sc.next();
                        kLst.deleteName(name);
                    }
                    break;

                    case "deleteFirstN": {
                        if (sc.hasNextInt()) {
                            int n = sc.nextInt();
                            kLst.deleteFirstN(n);
                        } else {
                            throw new InputMismatchException("N must be an integer.");
                        }
                    }
                    break;

                    case "deleteAll": {
                        kLst.deleteAll();
                    }
                    break;

                    default: {
                        throw new IllegalArgumentException("Invalid operation: " + cmd);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: " + e.getMessage());
                sc.nextLine(); // Skip invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException: " + e.getMessage());
            }
        }
        sc.close();
    }
}
