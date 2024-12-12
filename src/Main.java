import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path directoryPath = Path.of("users_directory");
        if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
            System.out.println("Директорія створена: " + directoryPath.toAbsolutePath());
        } else {
            System.out.println("Директорія вже існує: " + directoryPath.toAbsolutePath());
        }

        Path userFilePath = directoryPath.resolve("users.txt");
        Files.write(userFilePath, List.of(
                "Ім'я: Maxym, Вік: 40, Стать: Чоловіча",
                "Ім'я: Cris, Вік: 20, Стать: Жіноча",
                "Ім'я: Mario, Вік: 34, Стать: Чоловіча"
        ), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Файл створено або перезаписано: " + userFilePath.toAbsolutePath());

        List<String> lines = Files.readAllLines(userFilePath);
        System.out.println("Текст у файлі:");
        lines.forEach(line -> System.out.println("- " + line));
        System.out.println("Кількість рядків у файлі: " + lines.size());

        Path copiedFilePath = directoryPath.resolve("copied_users.txt");
        Files.copy(userFilePath, copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Дані скопійовані до файлу: " + copiedFilePath.toAbsolutePath());
    }
}
