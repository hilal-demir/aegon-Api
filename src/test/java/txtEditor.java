import org.apache.commons.io.IOUtils;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Files;
public class txtEditor {

    public String getPost(String scenarioName,String scenarioType){
//        String fileName = "config/sample.txt";

        String data="";
        String post="";
        Path filePath= Paths.get("./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/post.txt");

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
        System.out.println("test başlıyor");
            Path test=Paths.get("./target");
            Assert.assertTrue(Files.exists(test));
        System.out.println("./target var");

        Path test1=Paths.get("./target/test-classes");
        Assert.assertTrue(Files.exists(test1));
        System.out.println("./target/test-classes var");

        Path test2=Paths.get("./target/test-classes/Documents");
        Assert.assertTrue(Files.exists(test2));
        System.out.println("./target/test-classes/Documents var");

        Path test3=Paths.get("./target/test-classes/Documents"+scenarioName);
        Assert.assertTrue(Files.exists(test3));
        System.out.println("./target/test-classes/Documents"+scenarioName+"  var");

        Path test4=Paths.get("./target/test-classes/Documents/"+scenarioName+"/"+scenarioType);
        Assert.assertTrue(Files.exists(test4));
        System.out.println("./target/test-classes/Documents"+scenarioName+"/"+scenarioType+"  var");

        Path test5=Paths.get("./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/post.txt");
        Assert.assertTrue(Files.exists(test5));
        System.out.println("./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/post.txt"+"  var");
        System.out.println("what is your problem ");
        try {
            File myObj = new File(filePath.toString());
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
