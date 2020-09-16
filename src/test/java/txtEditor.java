import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.file.Files;
public class txtEditor {

    public String getPost(String scenarioName,String scenarioType){
//        String fileName = "config/sample.txt";

        String data="";
        String post="";
        String filePath="./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/post.txt";

//        System.out.println(filePath+" dosyasına bakılacak");
//        String fileName = filePath;
//        ClassLoader classLoader = getClass().getClassLoader();
//
//        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
//
//            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//            System.out.println(result);
//            post=result;
//        } catch (IOException e) {
//            Assert.fail(filePath+" dosyası bulunamadı "+e);
//
//        }
//        System.out.println("dosya bulundu =" +post);

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();
                 post= post+data+"\n";
              //  System.out.println("okunan deger="+data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Assert.fail(filePath+" pathinde bir dosya bulunamadı "+e);
        }

        return post;
    }

    public String getExpected(String scenarioName,String scenarioType){
        String data="";
        String post="";
        String filePath="./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/expected.txt";

//
//        String fileName = filePath;
//        ClassLoader classLoader = getClass().getClassLoader();
//
//        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
//
//            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//            System.out.println(result);
//            post=result;
//        } catch (IOException e) {
//            Assert.fail(filePath+" dosyası bulunamadı "+e);
//        }
//        System.out.println("dosya bulundu =" +post);

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                post= post+data+"\n";
                //  System.out.println("okunan deger="+data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            Assert.fail(filePath+" pathinde bir dosya bulunamadı"+ e);
        }

        return post;
    }
}
