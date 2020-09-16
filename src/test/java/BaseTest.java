
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class BaseTest {

    public String[][] postChanges=new String[100][100];
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static String scenarioName;

    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext){
        scenarioName=executionContext.getCurrentScenario().getName();
        logger.info(
            "\n+++++++++++++++++ Scenario Name +++++++++++++++++\n"+
            "\n--------------"+scenarioName+"-----------------\n"+
            "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
        if (StringUtils.isEmpty(System.getenv("key"))) {
            logger.info("local koşum");
        } else {
            logger.info("Testinium üzerinden koşum");
            logger.info("Testinium üzerinden değişiklikler çekikiliyor.");
            String changesNames= System.getenv("Changes");
//
//            for (int i=0; i<changesNames.length;i++){
//                postChanges[i][1]=System.getenv(changesNames[i]);
//                postChanges[i][0]=changesNames[i];
//
//            }
//            int i=0;
//            while (true){
//                if(postChanges[i][0]==null){
//                    break;
//                }
//                System.out.println("--------------------------------");
//                System.out.println(postChanges[i][0]+"="+postChanges[i][1]);
//                if(i>10){
//                    System.out.println("i 10 u geçti bu durmuyor");
//                    break;
//                }
//                i++;
//            }
//
        }
        }

}