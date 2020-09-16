import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtEditor {

    public String getPost(String scenarioName,String scenarioType){
        String data="";
        String post="";
        String filePath="/home/batuhan.zafer/workspace/aegontest-37-2/src/test/resources/Documents/"+scenarioName+"/"+scenarioType+"/post.txt";
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
            Assert.fail(filePath+" pathinde bir dosya bulunamadı");
        }

        return post;
    }

    public String getExpected(String scenarioName,String scenarioType){
        String data="";
        String post="";
        String filePath="/home/batuhan.zafer/workspace/aegontest-37-2/src/test/resources/Documents/"+scenarioName+"/"+scenarioType+"/expected.txt";
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
            Assert.fail(filePath+" pathinde bir dosya bulunamadı");
        }

        return post;
    }
}
