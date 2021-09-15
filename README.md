# data-parser

## 🤖 Information

### ☝ What does the program do? 
Receives product data from the site and saves it in the _.csv_ format

Saves data from _Aliexpress_ website: `https://flashdeals.aliexpress.com/en.htm?`

### ☝ How many products are parsed?
By default, the program receives data for the first 100 products.

If you need a different number of products, just change the value of the variable in the _Main.java_ class:
``` java
private final static int PRODUCT_COUNT = 100;
```
### ☝ What is the _.csv_ format?
All fields and values are separated by `,`

If you need a different delimiter, just change the value of the variable in the _Main.java_ class:
``` java
private final static String CSV_SEPARATOR = ",";
```
## 📝 How to run
To get the data, clone the repository to yourself and run _Main.java_

By default, the file will be saved to _./csv/products-data.csv_
