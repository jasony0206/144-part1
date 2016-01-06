import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.*;

public class ComputeSHA {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String filename = args[0];
        String text = getFileContent(filename);

        String sha1 = convertToSHA1(text);
        System.out.println(sha1);
    }

    public static String getFileContent(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String text;
        try {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                builder.append(line);
                line = reader.readLine();
                if (line != null) {
                    builder.append("\n");
                }
            }

            text = builder.toString();
            return text;
        } finally {
            reader.close();
        }
    }

    public static String convertToSHA1(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(text.getBytes());
        byte[] messageDigestSHA1 = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();

        for (byte digit : messageDigestSHA1) {
            stringBuilder.append(String.format("%02x", digit & 0xff));
        }

        return stringBuilder.toString();
    }
}
