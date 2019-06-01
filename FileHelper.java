import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    private List<String> readFile(String fileName) {
        List<String> contents = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                contents.add(line);
            }
            reader.close();
            return contents;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", fileName);
            e.printStackTrace();
            return null;
        }
    }


    private void writeFile(String contents, String fileName, Boolean newLine, Boolean toAppend) {
        try(FileWriter fw = new FileWriter(fileName, toAppend);
        BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(contents);
            if (newLine)
                writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to write '%s'.", contents);
            e.printStackTrace();
        }
    }
}
