
import com.github.openjson.JSONException;
import com.github.openjson.JSONObject;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class BaseTest {

    public static String[][] postChanges=new String[100][100];
    public static String[][] expectedChanges=new String[100][100];

    private Logger logger = LoggerFactory.getLogger(getClass());
    public static String scenarioName;

    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext){
        scenarioName=executionContext.getCurrentScenario().getName();
        logger.info(
            "\n\n\n\n+++++++++++++++++ Scenario Name +++++++++++++++++\n"+
            "\n--------------"+scenarioName+"-----------------\n"+
            "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");
        if (StringUtils.isEmpty(System.getenv("key"))) {
            logger.info("local koşum");

        } else {
            //Testinium üzerinden yapılan değişşiklikler güncelleniyor
            setChangesForPost();
            setChangesForExpected();


        }
    }
    public void setChangesForPost(){
        String changes;
        String changesNames[];
        changes= System.getenv("PostChanges");
        if(changes==null){
            logger.info("PostChanges için değişiklik yapılacak bir degişken bulunamadı");
            return;
        }
        logger.info("PostChanges için veriler alınıyor.");

        changesNames=changes.split(",");

        for (int i=0; i<changesNames.length;i++){
            postChanges[i][1]=System.getenv(changesNames[i].replaceAll(" ",""));
            postChanges[i][0]=changesNames[i];
        }

        int i=0;
        logger.info("Testinium üzerinden post için çekilen degişiklikler;");
        while (true){

            if(postChanges[i][0]==null){
                break;
            }

            System.out.println(postChanges[i][0]+"="+postChanges[i][1]);
            i++;
        }
    }

    public void setChangesForExpected(){
        String changes;
        String changesNames[];
        changes= System.getenv("ExpectedChanges");
        if(changes==null){
            logger.info("ExpectedChanges için değişiklik yapılacak bir degişken bulunamadı");
            return;
        }
        logger.info("ExpectedChanges için veriler alınıyor.");

        changesNames=changes.split(",");

        for (int i=0; i<changesNames.length;i++){
            expectedChanges[i][1]=System.getenv(changesNames[i].replaceAll(" ",""));
            expectedChanges[i][0]=changesNames[i];
        }

        int i=0;
        logger.info("Testinium üzerinden expected için çekilen degişiklikler;");
        while (true){
            if(expectedChanges[i][0]==null){
                break;
            }
            System.out.println(expectedChanges[i][0]+"="+expectedChanges[i][1]);
            i++;
        }
    }



}