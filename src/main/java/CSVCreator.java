import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import response.ProductInfo;
import java.lang.reflect.Field;
import exception.CreatedFileException;
import java.nio.charset.StandardCharsets;


public class CSVCreator {

    private final static Field[] fields = ProductInfo.class.getDeclaredFields();

    /**
     * save data about product in csv/products-data.csv file
     * @param data store information about products
     * @param path where we save the file
     * @param divider symbol that we use in .csv file for separate fields
     */
    public static void saveData(final DataStorage data, final String path, final String divider) {
        PrintWriter printWriter = createPrintWriter(path);
        printData(printWriter, data.getData(), divider);
        printWriter.close();
    }

    /**
     * write names of fields in product-data.csv file
     * @param printWriter for print in file
     * @param divider symbol for separate fields
     */
    private static void printFields(PrintWriter printWriter, String divider) {
        printWriter.print(fields[0].getName());
        for (int i = 1; i < fields.length; i++) {
            printWriter.printf("%s%s", divider, fields[i].getName());
        }
        printWriter.print("\n");
    }

    /**
     * write data about products in product-data.csv file
     * @param printWriter for print in file
     * @param productsInfo list with data of ProductInfo type
     * @param divider symbol for separate fields
     */
    private static void printData(PrintWriter printWriter, List<ProductInfo> productsInfo, String divider) {
        printFields(printWriter, divider);

        List<List<String>> products = convertData(productsInfo);
        for (List<String> productFields : products) {
            String field;
            for (int i = 0; i < productFields.size() - 1; i++) {
                field = normalizeField(productFields.get(i));
                printWriter.printf("%s%s", field, divider);
            }
            field = normalizeField(productFields.get(productFields.size() - 1));
            printWriter.printf("%s\n", field);
        }
    }

    /**
     * convert List<ProductInfo> into List<List<String>> for further works with it
     * @param dataList store information about products
     * @return {@code List<List<String>>} with information about products
     */
    private static List<List<String>> convertData(List<ProductInfo> dataList) {
        List<List<String>> products = new ArrayList<>();
        for (ProductInfo product : dataList) {
            List<String> productFields = new ArrayList<>();
            productFields.add(product.getProductId().toString());
            productFields.add(product.getSellerId().toString());
            productFields.add(product.getOriMinPrice());
            productFields.add(product.getOriMaxPrice());
            productFields.add(product.getPromotionId().toString());
            productFields.add(product.getStartTime().toString());
            productFields.add(product.getEndTime().toString());
            productFields.add(product.getPhase().toString());
            productFields.add(product.getProductTitle());
            productFields.add(product.getMinPrice());
            productFields.add(product.getMaxPrice());
            productFields.add(product.getDiscount());
            productFields.add(product.getOrders());
            productFields.add(product.getProductImage());
            productFields.add(product.getProductDetailUrl());
            productFields.add(product.getShopUrl());
            productFields.add(product.getTrace());
            productFields.add(product.getTotalTranpro3());
            productFields.add(product.getProductPositiveRate());
            productFields.add(product.getProductAverageStar());
            productFields.add(product.getItemEvalTotalNum().toString());
            products.add(productFields);
        }
        return products;
    }

    /**
     * normalize string on rules of .csv file for write it in further
     * @param rawField how string looks before processing
     * @return {@code String} field that we can write in .csv file
     */
    private static String normalizeField(final String rawField) {
        StringBuilder field = new StringBuilder();
        if (rawField.contains("\"")) {
            field.append("\"");
            char[] chars = rawField.toCharArray();
            int j = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '\"') {
                    field.append(rawField, j, i);
                    field.append("\"");
                    j = i;
                }
            }
            field.append(rawField, j, rawField.length());
            field.append("\"");
        } else if (rawField.contains(",") || rawField.contains("\n")) {
            field.append(String.format("\"%s\"", rawField));
        } else {
            field.append(rawField);
        }
        return field.toString();
    }

    /**
     * create directory ./csv/ and file products-data.csv for further work
     * @param path where store file
     * @return {@code PrintWriter} to work with file
     */
    private static PrintWriter createPrintWriter(final String path) {
        try {
            Files.createDirectories(Paths.get(path).getParent());
            OutputStream fileOutputStream = new FileOutputStream(path);
            return new PrintWriter(
                    new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CreatedFileException("Unable to create file");
        }
    }
}
