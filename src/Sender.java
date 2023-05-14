import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("dialogue.txt")));
            while (true) {
                String message = scanner.nextLine();
                writer.println("Sender: " + message);
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
