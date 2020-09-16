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
        String data="";
        String post="";
        Path filePath= Paths.get("./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/Post.txt");

        try {
            File myObj = new File(filePath.toString());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();
                 post= post+data+"\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Assert.fail(filePath+" pathinde bir dosya bulunamadı "+e);
        }

        doTheChanges(post,BaseTest.postChanges);
        return post;
    }

    public String getExpected(String scenarioName,String scenarioType){
        String data="";
        String post="";
        String filePath="./target/test-classes/Documents/"+scenarioName+"/"+scenarioType+"/Expected.txt";

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                post= post+data+"\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            Assert.fail(filePath+" pathinde bir dosya bulunamadı"+ e);
        }

        return post;
    }

    public void doTheChanges(String js,String[][] changes){
        jsonEditor jsEditor=new jsonEditor();
        int i=0;
        while (true){
            if(changes[i][0]==null){
                break;
            }
            jsEditor.updateTheValue(changes[i][0],changes[i][1],js);
            i++;
        }

    }

}
