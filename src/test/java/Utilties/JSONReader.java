package Utilties;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

//Data file class to read data from json file
    public class JSONReader {
        public static  JsonObject readJSONFile() {
            Gson gson = new Gson();

            try (FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src/test/java\\Data\\data.json")) {
                return gson.fromJson(reader, JsonObject.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
}
