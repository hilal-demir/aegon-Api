import Exel.GoogleExel;
import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import mail.mail;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;
import static io.restassured.RestAssured.given;

public class StepImplementation {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public boolean error=false;
    public String errorMessage=" ";
    public String expectedStatusCode;
    public String actualStatusCode;
    txtEditor txtEditor= new txtEditor();
    GoogleExel googleExel=new GoogleExel();

    @Step("User Info <scenarioType>")
    public void userInfo(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="agencyRegistryNumber#nickName#registryNumber";
        //KARŞILAŞTIRILMASINI İSTEMEDİGİNİZ DEGİŞKENLERİ BURAYA YAZIN
        String ignoreThePath=null;

        String post=txtEditor.getPost("User Info",scenarioType);
        String expectedResponse=txtEditor.getExpected("User Info",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-userinfo/userinfo");

         expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
        .replaceAll(" ","");
        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),
                expectedStatusCode,actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Tckn Iban <scenarioType>")
    public void tcknIban(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="iban#kimlikNo#kullaniciAdi#dogrulamaType";
        String ignoreThePath=null;
        String post=txtEditor.getPost("Tckn Iban",scenarioType);
        String expectedResponse=txtEditor.getExpected("Tckn Iban",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-tckn/kkb-findeks/verify");

         expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
        .replaceAll(" ","");
        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),"message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("SMS <scenarioType>")
    public void Sms(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="mobileNumber#content";
        String ignoreThePath="data.Results[0].MessageID#data.id";

        String post=txtEditor.getPost("Sms",scenarioType);
        String expectedResponse=txtEditor.getExpected("Sms",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-sms/");

         expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
        .replaceAll(" ","");
        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),"message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Email <scenarioType>")
    public void Email(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="toEmail#ccEmail#bccEmail#content";
        String ignoreThePath="data.messageId";

        String post=txtEditor.getPost("Email",scenarioType);
        String expectedResponse=txtEditor.getExpected("Email",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-email/");

         expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
        .replaceAll(" ","");
        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                        BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                        actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Tckn Gsm <scenarioType>")
    public void tcknGsm(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="dogrulamaType#gsmNo#kanal#kimlikNo#kullaniciAdi";
        String ignoreThePath="";

        String post=txtEditor.getPost("Tckn Gsm",scenarioType);
        String expectedResponse=txtEditor.getExpected("Tckn Gsm",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-tckn/kkb-findeks/verify");

        expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");
        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Collection <scenarioType>")
    public void Collection(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="amount#creditCardNo#apllicationId";
        //Response karşılaştırmasında görmezden gelmek istediginiz pathleri buraya yazın
        String ignoreThePath=null;

        String post=txtEditor.getPost("Collection",scenarioType);
        String expectedResponse=txtEditor.getExpected("Collection",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-presales-collection/collect");

         expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
        .replaceAll(" ","");

        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Customer Adress <scenarioType>")
    public void customerAdress(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="tcId";
        //Response karşılaştırmasında görmezden gelmek istediginiz pathleri buraya yazın
        String ignoreThePath=null;

        String post=txtEditor.getPost("Customer Adress",scenarioType);
        String expectedResponse=txtEditor.getExpected("Customer Adress",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-customer-address/address-information");

        expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");

        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Mernis <scenarioType>")
    public void Mernis(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="tckn";
        //Response karşılaştırmasında görmezden gelmek istediginiz pathleri buraya yazın
        String ignoreThePath=null;

        String post=txtEditor.getPost("Mernis",scenarioType);
        String expectedResponse=txtEditor.getExpected("Mernis",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-mernis/birlesik-sorgulama");

        expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");

        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Total Assurance <scenarioType>")
    public void totalAssurance(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="tckn";
        //Response karşılaştırmasında görmezden gelmek istediginiz pathleri buraya yazın
        String ignoreThePath=null;

        String post=txtEditor.getPost("Total Assurance",scenarioType);
        String expectedResponse=txtEditor.getExpected("Total Assurance",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-total-assurance/");

        expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");

        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Purchase Document <scenarioType>")
    public void purchaseDocument(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="applicationNumber#campaignCode#personalIdNumber";
        //Response karşılaştırmasında görmezden gelmek istediginiz pathleri buraya yazın
        String ignoreThePath=null;

        String post=txtEditor.getPost("Purchase Document",scenarioType);
        String expectedResponse=txtEditor.getExpected("Purchase Document",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-purchase-documents/application-form/pdf");

        expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");

        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Black List <scenarioType>")
    public void blackList(String scenarioType) throws IOException, GeneralSecurityException {

        //excel raporlamasında post kısmında görmek istediginiz değişkenleri buraya yazın.
        String postForExcel="citizenId#name#occupation#salt";
        //Response karşılaştırmasında görmezden gelmek istediginiz pathleri buraya yazın
        String ignoreThePath=null;

        String post=txtEditor.getPost("Black List",scenarioType);
        String expectedResponse=txtEditor.getExpected("Black List",scenarioType);

        Response r=sendThePost(post,"https://service-test.aegon.com.tr/sales/aegon-blacklist/query");

        expectedStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");

        actualStatusCode=equalsWhat(expectedResponse,"statusCode")
                .replaceAll(" ","");
        // status kod aşagıdaki konnda yanlış çekildigi için yukarıdeki koda geçildi
//        actualStatusCode=String.valueOf(r.statusCode());

        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        } else{
            System.out.println("expected responseeee"+expectedResponse);
            compare(r.prettyPrint(),expectedResponse,ignoreThePath);
        }

        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),getPostVariableForExcel(post,postForExcel),expectedStatusCode,
                actualStatusCode,errorMessage,equalsWhat(r.prettyPrint(),
                        "message"),r.getTime()+"ms",error);

        if(error){
            Assert.fail("\n"+errorMessage);
        }

    }

    @Step("Moreum")
    public void Moreum() throws IOException, GeneralSecurityException {
        Response r=sentTheGet("https://service-test.aegon.com.tr/sales/aegon-moreum/moreum/archive/checkServiceStatus");
        expectedStatusCode="200";
        actualStatusCode=String.valueOf(r.statusCode());
        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        }
        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),"GET","200",
                actualStatusCode,errorMessage,"",r.getTime()+"ms",error);
        if(error){
            Assert.fail("\n"+errorMessage);
        }
    }

    @Step("Currency")
    public void currency() throws IOException, GeneralSecurityException {
        Response r=sentTheGet("https://service-test.aegon.com.tr/sales/aegon-currency/");
        expectedStatusCode="200";
        actualStatusCode=String.valueOf(r.statusCode());
        if(!expectedStatusCode.equals(actualStatusCode)){
            error=true;
            errorMessage="Beklenmeyen StatusCode Lütfen logu inceleyin";
        }
        googleExel.fillExcel(
                BaseTest.scenarioName,getDate(),"GET","200",
                actualStatusCode,errorMessage,"",r.getTime()+"ms",error);
        if(error){
            Assert.fail("\n"+errorMessage);
        }
    }

    @Step("Send The Report Mail")
    public void sendTheReportMail() throws IOException, GeneralSecurityException {
        mail Mail=new mail();
        Mail.sendReport("10-9-2020 10.59.29.xlsx");
   //     googleExel.getSheetDataAndSendTheMail(getDate().replaceAll("\n"," "));
    }



    //------ methods----------
    public Response sentTheGet(String link){
        logger.info("******** Get Gönderiliyor ********");
        Response r=given().contentType("application/json").log().all().when().get(link)
                .then().extract().response();

        logger.info(
                "\n+++++++++++++++++ Response +++++++++++++++++\n"+
                        "\n "+r.prettyPrint()+" \n"+
                        "Response Time= "+r.getTime()+"ms"+
                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return r;
    }

    public Response sendThePost(String post, String link){
        logger.info("Post is sending... ");
        logger.info("\n************************  Post  ************************");
        Response r=given()
                .contentType("application/json").body(post)
                .log().all().when().post(link)
                .then().extract().response();

        logger.info(
                "\n+++++++++++++++++ Response +++++++++++++++++\n"+
                "\n "+r.prettyPrint()+" \n"+
                "Response Time= "+r.getTime()+"ms"+
                "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
        return r;
    }

    public  void compare(String response,String expectedResponse,String ignoreThePath) {
        logger.info("********Response ile beklenen Response Karşılaştırılıyor********");
        JSONCompareResult result =
                JSONCompare.compareJSON(expectedResponse, response, JSONCompareMode.STRICT);

        if(ignoreThePath != null && !ignoreThePath.isEmpty()){

            logger.info("ignoreThePath stringinde yer alan pahtlar karşılaştırılmıyor...");

            String ignore[]=ignoreThePath.split("#");
            String matris[]=result.toString()
                    .replaceAll(" ","")
                    .replaceAll(";","")
                    .split("\n");

            for(int i=0;i<matris.length;i++){
                for(int j=0;j<ignore.length;j++){
                    if(matris[i].equals(ignore[j])){
                        matris[i]="";
                        matris[i+1]="";
                        matris[i+2]="";
                        i=i+2;
                        break;
                    }
                }
            }
            for(int i=0;i<matris.length;i++){

                errorMessage=errorMessage+matris[i]+"\n";
            }
        } else{
            logger.info("ignoreThePath Stringinde bir deger bulunamadı.");
            errorMessage=result.toString();
        }
        logger.info("Karşılaştırma tamamlandı ve hata mesajı düzenlendi.");
        error=!errorMessage.replaceAll(" ","").
        replaceAll("\n","").isEmpty();
    }

    public static String equalsWhat(String text,String constant){
        System.out.println(constant+" Degerini jsonda karşılıgı aranıyor");
        String equals=null;
        String s=text;

        s=s.replaceAll("\\\\","");
        s=s.replaceAll("\n","");
        s=s.replaceAll(":","");
        s=s.replaceAll(",","");
        s=s.replaceAll(" ","");
        s=s.replaceAll("\"\"","\"");
        String[] words=s.split("\"");

        for(int i =0; i<words.length;i++)
            if (constant.trim().equals(words[i].trim())){
                equals=words[i+1];
            }
        if (equals.isEmpty()){
            equals="null";
        }
        System.out.println(constant+" Degerinin karşılıgı '"+equals+"' olarak bulundu");
        return equals;
    }

    public String getPostVariableForExcel(String post, String postForExcel){
        String matris[]=postForExcel.split("#");
        String postToSentExcel = "\n";
        try{
            for (int i=0;i<matris.length;i++){
                postToSentExcel=postToSentExcel+" "+matris[i]+" = "+equalsWhat(post,matris[i])+"\n";
            }
        }catch (Exception e){
            Assert.fail("getPostVariableForExcel Stringinde belirlediginiz deger post içersinde bulunamadı.");
        }

        return postToSentExcel;
    }

    public String getDate(){
        logger.info("Tarih ve saat belirleniyor...");
        SimpleDateFormat bicim2=new SimpleDateFormat("dd-M-yyyy hh.mm.ss");

        Date tarihSaat=new Date();

        return String.valueOf(bicim2.format(tarihSaat)).replaceAll(" ","\n");
    }
}



