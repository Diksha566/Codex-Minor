import java.util.Scanner;

public class Codex_Minor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Logic Gate Simulator");
        System.out.println("Enter 'exit' to quit the program.");

        while (!exit) {
            System.out.println("==============================================");
            System.out.print("Enter the number of inputs: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            int numInputs;
            try {
                numInputs = Integer.parseInt(input);
                if (numInputs <= 0) {
                    System.out.println("Invalid number of inputs. Please enter a positive integer.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of inputs. Please enter a positive integer.");
                continue;
            }

            boolean[] inputs = new boolean[numInputs];
            for (int i = 0; i < numInputs; i++) {
                System.out.print("Enter the value for input " + (i + 1) + " (true/false): ");
                String inputValue = scanner.nextLine().trim().toLowerCase();
                if (inputValue.equals("true")) {
                    inputs[i] = true;
                } else if (inputValue.equals("false")) {
                    inputs[i] = false;
                } else {
                    System.out.println("Invalid input value. Please enter 'true' or 'false'.");
                    continue;
                }
            }

            System.out.print("Enter the gate type (AND/OR/NOT/NAND/NOR/XOR/XNOR): ");
            String gateType = scanner.nextLine().trim().toUpperCase();

            boolean output = false;
            switch (gateType) {
                case "AND":
                    output = performAndGate(inputs);
                    break;
                case "OR":
                    output = performOrGate(inputs);
                    break;
                case "NOT":
                    output = performNotGate(inputs[0]);
                    break;
                case "NAND":
                    output = performNandGate(inputs);
                    break;
                case "NOR":
                    output = performNorGate(inputs);
                    break;
                case "XOR":
                    output = performXorGate(inputs);
                    break;
                case "XNOR":
                    output = performXnorGate(inputs);
                    break;
                default:
                    System.out.println("Invalid gate type!");
                    continue;
            }

            System.out.println("Output: " + output);
        }

        System.out.println("Exiting the program. Goodbye!");
    }

    private static boolean performAndGate(boolean[] inputs) {
        for (boolean input : inputs) {
            if (!input) {
                return false;
            }
        }
        return true;
    }

    private static boolean performOrGate(boolean[] inputs) {
        for (boolean input : inputs) {
            if (input) {
                return true;
            }
        }
        return false;
    }

    private static boolean performNotGate(boolean input) {
        return !input;
    }

    private static boolean performNandGate(boolean[] inputs) {
        return !performAndGate(inputs);
    }

    private static boolean performNorGate(boolean[] inputs) {
        return !performOrGate(inputs);
    }

    private static boolean performXorGate(boolean[] inputs) {
        boolean result = false;
        for (boolean input : inputs) {
            result ^= input;
        }
        return result;
    }

    private static boolean performXnorGate(boolean[] inputs) {
        return !performXorGate(inputs);
    }
}
