import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Создаем объекты ProcessBuilder для отправителя и получателя
        ProcessBuilder senderProcessBuilder = new ProcessBuilder("java", "Sender");
        ProcessBuilder receiverProcessBuilder = new ProcessBuilder("java", "Receiver");

        // Устанавливаем рабочий каталог для процессов
        senderProcessBuilder.directory(new File("."));
        receiverProcessBuilder.directory(new File("."));

        // Направляем вывод всех процессов в один и тот же файл
        senderProcessBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("dialogue.txt")));
        receiverProcessBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("dialogue.txt")));

        // Перенаправляем стандартный ввод процессов на стандартный ввод консоли
        senderProcessBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        receiverProcessBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);

        // Запускаем процессы и ожидаем их завершения
        Process senderProcess = senderProcessBuilder.start();
        Process receiverProcess = receiverProcessBuilder.start();
        senderProcess.waitFor();
        receiverProcess.waitFor();
    }
}
