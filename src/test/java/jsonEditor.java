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
//        JSONObject js = null;
//        try {
//            js = new JSONObject(s);
//        }catch (JSONException err){
//            System.out.println("Error "+ err.toString());
//        }

      //  updateTheValue("data.Results","",js);
     //   System.out.println(getValueOfPath("header.statusCode",s));

    }
    public String updateTheValue(String pathOfValue, String value, String jsText){
    //    String[] path=pathOfValue.trim().split(" ");
        String[] path=pathOfValue.trim().split("\\.");

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
        System.out.println("--after---------js="+js);

        return js.toString();

    }
    public static String getValueOfPath(String pathOfValue, String jsText){
        //Bu method belli bir pathe göre json dosyası içersinden veri almaya yarar
        //eger verilen yol bir köşeli parantez içersine giriyorsa çalışmaz
        JSONObject js = null;
        String[] path=pathOfValue.trim().split("\\.");
        String result=null;
        try {
            js = new JSONObject(jsText);
        }catch (JSONException err){
            System.out.println("Error "+ err.toString());
        }

        if(path.length==1){
            result=js.getString(path[0]);
        }
        else if(path.length==2){
            result=js.getJSONObject(path[0]).getString(path[1]);
        }
        else if(path.length==3){
            result=js.getJSONObject(path[0]).getJSONObject(path[1]).getString(path[2]);
        }
        else if(path.length==4){
            result=js.getJSONObject(path[0]).getJSONObject(path[1]).getJSONObject(path[2]).getString(path[3]);
        }
        else {
            Assert.fail("Bulunamayan path="+pathOfValue+" path beklenenden uzun ");
        }
        System.out.println(pathOfValue+" pahtinde agaran değer "+result+" olarak bulundu");
        return result;
    }
}
