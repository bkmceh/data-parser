package validator;

public class FieldValidator {

    /**
     * checking string on rules of .csv file for write it in further
     * @param uncheckedField how string looks before processing
     * @return {@code String} field that we can write in .csv file
     */
    public static String validate(final String uncheckedField) {
        StringBuilder checkedField = new StringBuilder();
        if (uncheckedField.contains("\"")) {
            checkedField.append("\"");
            char[] chars = uncheckedField.toCharArray();
            int j = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '\"') {
                    checkedField.append(uncheckedField, j, i);
                    checkedField.append("\"");
                    j = i;
                }
            }
            checkedField.append(uncheckedField, j, uncheckedField.length());
            checkedField.append("\"");
        } else if (uncheckedField.contains(",") || uncheckedField.contains("\n")) {
            checkedField.append(String.format("\"%s\"", uncheckedField));
        } else {
            checkedField.append(uncheckedField);
        }
        return checkedField.toString();
    }

}
