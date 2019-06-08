package Drugo;

import com.google.gson.Gson;

import java.io.*;
import java.sql.SQLException;

public class Helper {

        public static void WritetoFile(String fileName, String text) {

            try (FileWriter writer = new FileWriter(fileName)) {

                writer.write(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String ReadFromFile(String fileName) {
            String text = null;
            FileReader reader = null;
            File file = new File(fileName);

            try {reader = new FileReader(file) ;
                char[] chars = new char[(int) file.length()];
                reader.read(chars);
                text = new String(chars);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return text;
        }
    }







