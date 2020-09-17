import com.github.openjson.JSONException;
import com.github.openjson.JSONObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class jsonEditor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        String s="{\n" +
                "    \"data\": {\n" +
                "        \"id\": 621,\n" +
                "        \"Results\": [\n" +
                "            {\n" +
                "                \"MessageID\": \"9D98F773879A4495BB6476C0ECDD5610\",\n" +
                "                \"Status\": \"0\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Error\": \"0\"\n" +
                "    },\n" +
                "    \"header\": {\n" +
                "        \"message\": null,\n" +
                "        \"status\": \"SUCCESS\",\n" +
                "        \"statusCode\": 200,\n" +
                "        \"detailCode\": null,\n" +
                "        \"txId\": null,\n" +
                "        \"info\": []\n" +
                "    }\n" +
                "}";
        JSONObject js = null;
        try {
            js = new JSONObject(s);
        }catch (JSONException err){
            System.out.println("Error "+ err.toString());
        }

      //  updateTheValue("data.Results","",js);


    }
    public String updateTheValue(String pathOfValue, String value, String jsText){
        String[] path=pathOfValue.split("xxx");
        logger.info(pathOfValue+" yolundaki deger ="+value+" olarak güncelleniyor");

        JSONObject js = null;
        try {
            js = new JSONObject(jsText);
        }catch (JSONException err){
            System.out.println("Error "+ err.toString());
        }
        System.out.println("--before---------js="+js);

        if(path.length==1){
            js.put(path[0],value);
            System.out.println("--after---------js="+js);
        }
        else if(path.length==2){
            js.getJSONObject(path[0]).put(path[1],value);
        }
        else if(path.length==3){
            js.getJSONObject(path[0]).getJSONObject(path[1]).put(path[2],value);
        }
        else if(path.length==4){
            js.getJSONObject(path[0]).getJSONObject(path[1]).getJSONObject(path[2]).put(path[3],value);
        }
        else {
            Assert.fail("Bulunamayan path="+pathOfValue+" path beklenenden uzun ");
        }

        return js.toString();

    }
}
