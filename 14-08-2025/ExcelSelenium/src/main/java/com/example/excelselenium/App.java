package com.example.excelselenium;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
public class App{
	static WebDriver driver;
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("TestSteps.xlsx"));
			System.out.println("File....");
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
	
			for (Row row : sheet) {
			    if (row.getRowNum() == 0) continue; 

			    String keyword = getCellValue(row.getCell(1)).trim();
			    String locatorType = getCellValue(row.getCell(2)).trim();
			    String locatorValue = getCellValue(row.getCell(3)).trim();
			    String data = getCellValue(row.getCell(4)).trim();

			   
			    if (keyword.isEmpty()) {
			        break;
			    }

			    executeStep(keyword, locatorType, locatorValue, data);
			}

			System.out.println("Inside for");
			
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getCellValue(Cell cell) {
	    if (cell == null) return "";

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();

	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
	                return sdf.format(cell.getDateCellValue());
	            } else {
	                return String.valueOf((int) cell.getNumericCellValue());
	            }

	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());

	        default:
	            return "";
	    }
	

	}
	public static void executeStep(String keyword, String locatorType, String locatorValue, String data) {
	    if(keyword.equalsIgnoreCase("openbrowser")) {
	        driver = new ChromeDriver();
	    }
	    if(keyword.equalsIgnoreCase("openurl")) {
	        driver.get(data);
	    }    
	    if(keyword.equalsIgnoreCase("inputtext")) {
	        getElement(locatorType, locatorValue).sendKeys(data);
	    }
	    if(keyword.equalsIgnoreCase("click")) {
	        getElement(locatorType, locatorValue).click();
	    }
	    if(keyword.equalsIgnoreCase("closebrowser")) {
	       // driver.quit();
	    }
	}

	public static WebElement getElement(String type, String value) {
	    if(type.equalsIgnoreCase("id")) 
	        return driver.findElement(By.id(value));
	    if(type.equalsIgnoreCase("name"))
	        return driver.findElement(By.name(value));
	    if(type.equalsIgnoreCase("cssselector"))
	        return driver.findElement(By.cssSelector(value));
	    if(type.equalsIgnoreCase("xpath"))
	        return driver.findElement(By.xpath(value));
	    throw new IllegalArgumentException("Invalid locator type: " + type);
	}

	}