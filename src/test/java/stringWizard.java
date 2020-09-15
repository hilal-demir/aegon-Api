import java.util.ArrayList;
import java.util.List;

public class stringWizard {
    public static void main(String[] args) {
        System.out.println(equalsWhat("statusCode"));
    }
    public static String equalsWhat(String constant){
        String equals=null;
        List<String> list=new ArrayList<String>();
        String s="{\n" +
                "    \"data\": {\n" +
                "        \"agency\": null,\n" +
                "        \"user\": {\n" +
                "            \"id\": \"d9cdd7eb-7c26-49ef-9be0-690080c1aeef\",\n" +
                "            \"nickName\": \"a.b\",\n" +
                "            \"registryNumber\": \"11111\",\n" +
                "            \"name\": \"\",\n" +
                "            \"surname\": \"\",\n" +
                "            \"tck\": \"\",\n" +
                "            \"phoneNumber\": \"\",\n" +
                "            \"photoUrl\": \"emakin.aegon.com.tr/file/\",\n" +
                "            \"salesChannel\": \"Outsource\",\n" +
                "            \"areaGroup\": null,\n" +
                "            \"area\": \"ANALİZ VE PROJE YÖNETİMİ\",\n" +
                "            \"branch\": \"İŞ ANALİZİ VE PROJE YÖNETİMİ\",\n" +
                "            \"team\": \"İŞ ANALİZİ VE PROJE YÖNETİMİ\",\n" +
                "            \"subTeam\": \"İŞ ANALİZİ VE PROJE YÖNETİMİ\",\n" +
                "            \"title\": \"UZMAN 2\",\n" +
                "            \"role\": \"\",\n" +
                "            \"managerTCK\": {\n" +
                "                \"string\": [\n" +
                "                    \"63172415560\",\n" +
                "                    \"44719866892\",\n" +
                "                    \"52678168520\"\n" +
                "                ]\n" +
                "            },\n" +
                "            \"startDate\": \"2016-07-27T21:00:00.000+0000\",\n" +
                "            \"endDate\": null,\n" +
                "            \"phoneNumbers\": null,\n" +
                "            \"segem\": \"0\",\n" +
                "            \"tobb\": \"false\",\n" +
                "            \"active\": true,\n" +
                "            \"email\": \"a.b@aegon.com.tr\"\n" +
                "        },\n" +
                "        \"message\": null\n" +
                "    },\n" +
                "    \"header\": {\n" +
                "        \"message\": \"İşlem Başarılı\",\n" +
                "        \"statusCode\": 200,\n" +
                "        \"detailCode\": \"0\"\n" +
                "    }\n" +
                "}";

        s=s.replaceAll("\\\\","");
        s=s.replaceAll("\n","");
        s=s.replaceAll(":","");
        s=s.replaceAll(",","");
        s=s.replaceAll(" ","");
        s=s.replaceAll("\"\"","\"");
        String[] words=s.split("\"");

        for(int i =0; i<words.length;i++)
            if (constant.equals(words[i])){
                equals=words[i+1];
            }
        return equals;
    }
}
