import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class txtEditor {
    private Logger logger = LoggerFactory.getLogger(getClass());

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
        if(System.getenv("AllPost")!=null){
            post=System.getenv("AllPost");
            logger.info("AllPost değeri bulundu ve 'Post=AllPost' olarak güncellendi");
        }else{
            logger.info("AllPost değeri bulunamadı");
            post=doTheChanges(post,BaseTest.expectedChanges);
        }


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

        if(System.getenv("AllExpected")!=null){
            post=System.getenv("AllExpected");
            logger.info("AllExpected değeri bulundu ve 'Expexted Response=AllExpected' olarak güncellendi");
        } else{
            logger.info("AllExpected değeri bulunamadı");
            post=doTheChanges(post,BaseTest.expectedChanges);
        }

        logger.info(
                "\n\n\n\n+++++++++++++++++ Expexted Response +++++++++++++++++\n"+
                        post+
                "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

        return post;
    }

    public String doTheChanges(String js, String[][] changes){
        jsonEditor jsEditor=new jsonEditor();
        int i=0;
        while (true){
            if(changes[i][0]==null){
                break;
            }
            js=jsEditor.updateTheValue(changes[i][0],changes[i][1],js);
            i++;
        }
        return js;
    }

}
