package java;

public class DocumentValidator {
    public static void main(String[] args) {
        String input1 = "111.222.333-44";
        String input2 = "11.222.333/0001-55";
        System.out.println("Input 1: " + input1);
        System.out.println("Input 2: " + input2);
        System.out.println("Input 1 is CPF? " + isCPF(input1));
        System.out.println("Input 2 is CPF? " + isCPF(input2));
    }

    public static boolean isCPF(String input) {
        // remove all non-digit characters from input string
        String cpf = input.replaceAll("\\D", "");

        // CPF must have 11 digits
        if (cpf.length() != 11) {
            return false;
        }

        // validate CPF checksum digit
        int sum = 0;
        int weight = 10;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(cpf.substring(i, i + 1));
            sum += digit * weight;
            weight--;
        }
        int remainder = sum % 11;
        int checksum1 = (remainder < 2) ? 0 : 11 - remainder;
        if (checksum1 != Integer.parseInt(cpf.substring(9, 10))) {
            return false;
        }

        // validate CPF second checksum digit
        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            int digit = Integer.parseInt(cpf.substring(i, i + 1));
            sum += digit * weight;
            weight--;
        }
        remainder = sum % 11;
        int checksum2 = (remainder < 2) ? 0 : 11 - remainder;
        if (checksum2 != Integer.parseInt(cpf.substring(10))) {
            return false;
        }

        return true;
    }
}