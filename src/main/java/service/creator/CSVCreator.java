package service.creator;

import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

import domain.dto.ProductDTO;
import java.lang.reflect.Field;
import service.DataStorage;
import domain.mapper.ProductDTOMapper;
import service.validator.FieldValidator;
import domain.exception.FileCreateException;

import java.nio.charset.StandardCharsets;


public class CSVCreator implements Creator {

    private final String path;

    private final String separator;

    private final PrintWriter printWriter;

    public CSVCreator(final String path, final String separator) {
        this.path = path;
        this.separator = separator;
        this.printWriter = createPrintWriter();
    }

    /**
     * save information about products into file
     * @param data store data of products
     */
    @Override
    public void save(DataStorage data) {
        List<List<String>> products = new ProductDTOMapper(data.getData()).toEntity();
        writeData(products);
        printWriter.close();
    }

    /**
     * write information into products-data.csv file
     * @param products lists with information of products
     */
    private void writeData(List<List<String>> products) {
        Field[] fields = ProductDTO.class.getDeclaredFields();
        printWriter.print(fields[0].getName());
        for (int i = 1; i < fields.length; i++) {
            printWriter.printf("%s%s", separator, fields[i].getName());
        }
        printWriter.print("\n");

        for (List<String> productFields : products) {
            String field;
            for (int i = 0; i < productFields.size() - 1; i++) {
                field = FieldValidator.validate(productFields.get(i));
                printWriter.printf("%s%s", field, separator);
            }
            field = FieldValidator.validate(productFields.get(productFields.size() - 1));
            printWriter.printf("%s\n", field);
        }
    }

    /**
     * create directory ./csv/ and file products-data.csv for writing data
     * @return {@code PrintWriter} for work with this file
     */
    private PrintWriter createPrintWriter() {
        try {
            Files.createDirectories(Paths.get(path).getParent());
            OutputStream fileOutputStream = new FileOutputStream(path);
            return new PrintWriter(
                    new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileCreateException("Unable to create file");
        }
    }

}
