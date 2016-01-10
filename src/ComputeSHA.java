import java.io.*;
import java.security.*;

public class ComputeSHA {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String filename = args[0];
        String text = getFileContent(filename);

        String sha1 = convertToSHA1(text);
        System.out.println(sha1);
    }

    public static String getFileContent(String filename) throws IOException {
        String text = "";
        FileInputStream in = null;
        try {
            in = new FileInputStream(filename);
            int c;
            while ((c = in.read()) != -1) {
                text += (char)c;
            }

            return text;
        } finally {
            if (in != null)
                in.close();
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
