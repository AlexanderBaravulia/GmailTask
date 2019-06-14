package utill;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonParser {

    public static <T> List<T> parseToList(String pathToJsonFile, Class<T> clazz) {
        try {
            String json = new String (Files.readAllBytes(Paths.get(pathToJsonFile) ) );
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            return new Gson().fromJson(json, typeOfT);
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e);
        }
    }
}
