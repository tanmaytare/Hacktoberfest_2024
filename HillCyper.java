import java.util.Scanner;

public class HillCyper {

    private static int[] multiplyMatrix(int[][] matrix, int[] vector) {
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i] = (result[i] + matrix[i][j] * vector[j]) % 26;
            }
        }
        return result;
    }


    private static String encrypt(String plaintext, int[][] key) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            int[] block = new int[2];
            for (int j = 0; j < 2; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
            }
            int[] encryptedBlock = multiplyMatrix(key, block);
            for (int value : encryptedBlock) {
                ciphertext.append((char) (value + 'A'));
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n =2;
        System.out.println("Enter the 2x2 key matrix (4 numbers):");
        int[][] key = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {   
                key[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the plaintext (multiple of 2 characters):");
        sc.nextLine();
        String plaintext = sc.nextLine().toUpperCase();
        if (plaintext.length() % n != 0) {
            System.out.println("Plaintext length should be a multiple of " + n);
            return;
        }

        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

    }
}
