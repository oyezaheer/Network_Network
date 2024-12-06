import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MessageDigestExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text to hash: ");
            String input = scanner.nextLine();

            // Calculate hash using SHA-1
            String sha1Hash = calculateHash(input, "SHA-1");
            System.out.println("SHA-1 Hash: " + sha1Hash);

            // Calculate hash using SHA-256
            String sha256Hash = calculateHash(input, "SHA-256");
            System.out.println("SHA-256 Hash: " + sha256Hash);

            // Calculate hash using SHA-512
            String sha512Hash = calculateHash(input, "SHA-512");
            System.out.println("SHA-512 Hash: " + sha512Hash);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to calculate hash
    public static String calculateHash(String input, String algorithm) throws NoSuchAlgorithmException {
        // Get MessageDigest instance for the given algorithm
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        // Generate the hash as a byte array
        byte[] hashBytes = messageDigest.digest(input.getBytes());

        // Convert the byte array to a hexadecimal string
        StringBuilder hashString = new StringBuilder();
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x", b));
        }
        return hashString.toString();
    }
}
