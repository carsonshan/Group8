package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Stock;
import pojo.Company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

public class FileHelper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Stock readStockToFile(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
        return mapper.readValue(inputStream, new TypeReference<Stock>() {});
    }

    public static Company readCompanyToFile(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
        return mapper.readValue(inputStream, new TypeReference<Company>() {});
    }










/*    public static void writeTeamsToFile(String fileName, List<Team> teams) throws IOException {

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), teams);
    }

    public static void writeTeamToFile(String fileName, Team team) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("data", fileName), team);
    }*/

}
