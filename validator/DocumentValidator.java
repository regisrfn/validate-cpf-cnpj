package validator;


public class DocumentValidator {
    public static void main(String[] args) {
        String cpf = "111.111.111-11";
        String cnpj = "00.000.000/0001-91";
        System.out.println(cpf + " is " + (isCPF(cpf) ? "valid" : "invalid"));
        System.out.println(cnpj + " is " + (isCNPJ(cnpj) ? "valid" : "invalid"));
    }

    public static boolean isCPF(String cpf) {
        // Remove all non-digit characters
        cpf = cpf.replaceAll("\\D", "");
    
        // Check if length is valid
        if (cpf.length() != 11) {
            return false;
        }
    
        // Check if all digits are equal
        boolean allEqual = true;
        char firstChar = cpf.charAt(0);
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != firstChar) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) {
            return false;
        }
    
        // Validate the check digits
        int[] factors1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] factors2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum1 += digit * factors1[i];
            sum2 += digit * factors2[i];
        }
        int digit1 = (sum1 % 11 < 2) ? 0 : (11 - sum1 % 11);
        sum2 += digit1 * factors2[9];
        int digit2 = (sum2 % 11 < 2) ? 0 : (11 - sum2 % 11);
        return (digit1 == Character.getNumericValue(cpf.charAt(9))
                && digit2 == Character.getNumericValue(cpf.charAt(10)));
    }
    
    public static boolean isCNPJ(String cnpj) {
        // Remove all non-digit characters
        cnpj = cnpj.replaceAll("\\D", "");
    
        // Check if length is valid
        if (cnpj.length() != 14) {
            return false;
        }
    
        // Check if all digits are equal
        boolean allEqual = true;
        char firstChar = cnpj.charAt(0);
        for (int i = 1; i < 14; i++) {
            if (cnpj.charAt(i) != firstChar) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) {
            return false;
        }
    
        // Validate the check digits
        int[] factors1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] factors2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(cnpj.charAt(i));
            sum1 += digit * factors1[i];
            sum2 += digit * factors2[i];
        }
        sum2 += Character.getNumericValue(cnpj.charAt(12)) * factors2[12];
        int digit1 = (sum1 % 11 < 2) ? 0 : (11 - sum1 % 11);
        int digit2 = (sum2 % 11 < 2) ? 0 : (11 - sum2 % 11);
        return (digit1 == Character.getNumericValue(cnpj.charAt(12))
                && digit2 == Character.getNumericValue(cnpj.charAt(13)));
    }
    
}
