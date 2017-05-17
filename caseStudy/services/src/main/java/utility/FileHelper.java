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

    public static Company readSingleStock(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
        return mapper.readValue(inputStream, new TypeReference<Stock>() {});
    }

    public static Stock readAllStocks(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
        return mapper.readValue(inputStream, new TypeReference<List<Stock>>() {
        });
    }

    public static Company readSingleCompany(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<Company>() {});
    }

    public static List<Company> readAllCompanies(String fileName) throws IOException {

        InputStream inputStream = new FileInputStream(("data" + File.separatorChar + fileName));
//        InputStream resourceAsStream = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return mapper.readValue(inputStream, new TypeReference<List<Company>>() {
        });
    }

