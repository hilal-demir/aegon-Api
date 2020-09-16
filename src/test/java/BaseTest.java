import com.github.openjson.JSONException;
import com.github.openjson.JSONObject;
import com.google.api.client.json.Json;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseTest {
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
            String test= System.getenv().toString();
            System.out.println(test+"----------------------------------");
        }
        }

}