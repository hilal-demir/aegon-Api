import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtEditor {

    public String getPost(String scenarioName,String scenarioType){
        String data="";
        String post="";
        try {
            File myObj = new File("r/Testinium/aegon-Api/src/test/Documents/"+scenarioName+"/"+scenarioType+"/post.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();
                 post= post+data+"\n";
              //  System.out.println("okunan deger="+data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Assert.fail("src/test/Documents/"+scenarioName+"/"+scenarioType+"/post.txt"+" pathinde bir dosya bulunamadı");
        }

        return post;
    }

    public String getExpected(String scenarioName,String scenarioType){
        String data="";
        String post="";
        try {
            File myObj = new File("r/Testinium/aegon-Api/src/test/Documents/"+scenarioName+"/"+scenarioType+"/expected.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                post= post+data+"\n";
                //  System.out.println("okunan deger="+data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            Assert.fail("src/test/Documents/"+scenarioName+"/"+scenarioType+"/expected.txt"+" pathinde bir dosya bulunamadı");
        }

        return post;
    }
}
