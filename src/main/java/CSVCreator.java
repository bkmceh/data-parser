import response.ProductInfo;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CSVCreator {

    private final static Field[] fields = ProductInfo.class.getDeclaredFields();

    public static void saveData(final DataStorage data, final String path, final String divider) {
        try {
            Files.createDirectories(Paths.get(path).getParent());
            OutputStream fileOutputStream = new FileOutputStream(path);
            PrintWriter printWriter = new PrintWriter(
                    new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));

            printData(printWriter, data.getData(), divider);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFields(PrintWriter printWriter, String divider) {
        printWriter.print(fields[0].getName());
        for (int i = 1; i < fields.length; i++) {
            printWriter.printf("%s%s", divider, fields[i].getName());
        }
        printWriter.print("\n");
    }

    private static void printData(PrintWriter printWriter, List<ProductInfo> productsInfo, String divider) {
        printFields(printWriter, divider);

        List<List<String>> products = convertData(productsInfo);
        for (List<String> productFields : products) {
            String field;
            for (int i = 0; i < productFields.size()-1; i++) {
                field = normalizeField(productFields.get(i));
                printWriter.printf("%s%s", field, divider);
            }
            field = normalizeField(productFields.get(productFields.size()-1));
            printWriter.printf("%s\n", field);
        }
    }

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
}
