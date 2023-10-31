import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.*;


public class uzd1 {
    public static void main(String[] args) {
        String filePath = "G:/Java mokymai/Kartojimas/OOP Paskaitos/Kartojimas egzui/Geresnis pasaulis.txt";
        String contentToAppend = "E X T R A   T E K S T A S";
        String textToAdd = "Vision of <PAULIUS>\n";

        try {

            String existingContent = new String(Files.readAllBytes(Paths.get(filePath)));


            String newContent = textToAdd + existingContent;


            Files.write(Paths.get(filePath), newContent.getBytes());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());

    }
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); //nuskaityto failo eiluciu spausdinimas
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(contentToAppend);
            bufferedWriter.newLine(); // iterpiama nauja eilute
            System.out.println("E X T R A   T E K S T A S");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




