package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Utility {
	  public void writeJson(String jsonfile,String username, String password) throws IOException{
	  
		  JSONObject jsonObject = new JSONObject();
		  jsonObject.put("username", username);
	      jsonObject.put("password", password);
	      try {
	          FileWriter file = new FileWriter(jsonfile);
	          file.write(jsonObject.toJSONString());
	          file.close();
	       } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	       }
	  }
	  
	  public String readJson(String jsonfile,String attribute) throws IOException{
		  
		  //Creating a JSONParser object
	      JSONParser jsonParser = new JSONParser();
	      
	         //Parsing the contents of the JSON file
	         JSONObject jsonObject = null;
			try {
				jsonObject = (JSONObject) jsonParser.parse(new FileReader(jsonfile));
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         String value = (String) jsonObject.get(attribute);
	        
	         return value;
	     
	  }
	  
	  public String readExcel(String fileName) throws IOException{
		  
		  FileInputStream fis = new FileInputStream(fileName);
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0);
		                          //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		                          //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		  Row row = sheet.getRow(0);
		  Cell cell = row.getCell(0);
		                         System.out.println(cell);
		  System.out.println(sheet.getRow(1).getCell(0));
		  String value = sheet.getRow(1).getCell(0).toString();
		return value;
	  }
   
	  public String getProperty(String propertyName) throws IOException {
		  String path = System.getProperty("user.dir"); 
		  FileInputStream fis = new FileInputStream(path+"\\src\\test\\resources\\config.properties");
		  Properties prop = new Properties();
		  prop.load(fis);
		  System.out.println(prop.get(propertyName));
		  String propValue = prop.get(propertyName).toString();
		return propValue;
		  
	  }
	  
	  public String setProperty(String propertyName, String propertyValue) throws IOException {
		  String path = System.getProperty("user.dir");
		  FileInputStream fis = new FileInputStream(path+"\\src\\test\\resources\\config.properties");
		  Properties prop = new Properties();
		  prop.load(fis);
		  System.out.println(prop.setProperty(propertyName, propertyValue));
		  String propValue = prop.get(propertyName).toString();
		return propValue;
		  
	  }
	  
	//driver and screenshotName
	  public static String capture(WebDriver driver) throws IOException {
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		  + ".png");
		  String errflpath = Dest.getAbsolutePath();
		  FileUtils.copyFile(scrFile, Dest);
		  return errflpath;
		  }
	  
	  private static final String SECRET_KEY
      = "my_super_secret_key_ho_ho_ho";
  
  private static final String SALT = "ssshhhhhhhhhhh!!!!";

  // This method use to encrypt to string
  public String encrypt(String strToEncrypt)
  {
      try {

          // Create default byte array
          byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 };
          IvParameterSpec ivspec
              = new IvParameterSpec(iv);

          // Create SecretKeyFactory object
          SecretKeyFactory factory
              = SecretKeyFactory.getInstance(
                  "PBKDF2WithHmacSHA256");
          
          // Create KeySpec object and assign with
          // constructor
          KeySpec spec = new PBEKeySpec(
              SECRET_KEY.toCharArray(), SALT.getBytes(),
              65536, 256);
          SecretKey tmp = factory.generateSecret(spec);
          SecretKeySpec secretKey = new SecretKeySpec(
              tmp.getEncoded(), "AES");

          Cipher cipher = Cipher.getInstance(
              "AES/CBC/PKCS5Padding");
          cipher.init(Cipher.ENCRYPT_MODE, secretKey,
                      ivspec);
          // Return encrypted string
          return Base64.getEncoder().encodeToString(
              cipher.doFinal(strToEncrypt.getBytes(
                  StandardCharsets.UTF_8)));
      }
      catch (Exception e) {
          System.out.println("Error while encrypting: "
                             + e.toString());
      }
      return null;
  }

  // This method use to decrypt to string
  public static String decrypt(String strToDecrypt)
  {
      try {

          // Default byte array
          byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0, 0 };
          // Create IvParameterSpec object and assign with
          // constructor
          IvParameterSpec ivspec
              = new IvParameterSpec(iv);

          // Create SecretKeyFactory Object
          SecretKeyFactory factory
              = SecretKeyFactory.getInstance(
                  "PBKDF2WithHmacSHA256");

          // Create KeySpec object and assign with
          // constructor
          KeySpec spec = new PBEKeySpec(
              SECRET_KEY.toCharArray(), SALT.getBytes(),
              65536, 256);
          SecretKey tmp = factory.generateSecret(spec);
          SecretKeySpec secretKey = new SecretKeySpec(
              tmp.getEncoded(), "AES");

          Cipher cipher = Cipher.getInstance(
              "AES/CBC/PKCS5PADDING");
          cipher.init(Cipher.DECRYPT_MODE, secretKey,
                      ivspec);
          // Return decrypted string
          return new String(cipher.doFinal(
              Base64.getDecoder().decode(strToDecrypt)));
      }
      catch (Exception e) {
          System.out.println("Error while decrypting: "
                             + e.toString());
      }
      return null;
  }


}