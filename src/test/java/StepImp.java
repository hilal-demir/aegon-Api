import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class StepImp {
    private Logger logger = LoggerFactory.getLogger(getClass());


//
//    @Step("Api Test")
//    public void apiTest(){
//        ResourceBundle properties= ReadProperties.readProp(BaseTest.scenarioName+".properties");
//
//        logger.info("Post is sending... ");
//        logger.info("\n************************  Post  ************************");
//
//        Response r=given()
//                .contentType("application/json").body(BodyCreater.createBodyByScenarioName())
//                .log().all().when().post(properties.getString("link"))
//                .then().extract().response();
//
//        logger.info(
//                "\n+++++++++++++++++ Response +++++++++++++++++\n"+
//                "\n "+r.prettyPrint()+" \n"+
//                "Response Time= "+r.getTime()+"ms"+
//                "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
//
//        Assert.assertEquals("Status cod = ",200,r.getStatusCode());
//
//    }
//
//
//
//    // Get Tests---------------------------------------------------------------------------
//
//    @Step("Currency")
//    public void currency(){
//        Response r=given().when().get("https://service-test.aegon.com.tr/sales/aegon-currency/")
//                .then().extract().response();
//        logger.info(
//                "\n+++++++++++++++++ Response +++++++++++++++++\n"+
//                        "\n "+r.prettyPrint()+" \n"+
//                        "Response Time= "+r.getTime()+"ms"+
//                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
//
//        Assert.assertEquals("Status cod = ",200,r.getStatusCode());
//    }
//    @Step("Moreum")
//    public void Moreum(){
//        Response r=given().when().get("https://service-test.aegon.com.tr/sales/aegon-moreum/moreum/archive/checkServiceStatus")
//                .then().extract().response();
//        logger.info(
//                "\n+++++++++++++++++ Response +++++++++++++++++\n"+
//                        "\n "+r.prettyPrint()+" \n"+
//                        "Response Time= "+r.getTime()+"ms"+
//                        "\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
//
//        Assert.assertEquals("Status cod = ",200,r.getStatusCode());
//    }

}








/*

   @Step("User Info agencyRegistryNumber=<agency> nickName=<nick> registryNumber=<number>")
    public void userInfo(String agency,String nick,String number){
        Response r=given()
                .contentType("application/json").body(
                "{\n" +
                "  \"agencyRegistryNumber\": \""+agency+"\",\n" +
                "  \"nickName\": \""+nick+"\",\n" +
                "  \"registryNumber\": \""+number+"\"\n" +
                "}").log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-userinfo/userinfo")
                .then().statusCode(200).extract().response();
    }

    @Step("Currency")
    public void currency(){
        Response r=given().when().get("https://service-test.aegon.com.tr/sales/aegon-currency/")
                .then().statusCode(200).extract().response();

    }

    @Step("SMS numara=<number>")
    public void sms(String number){
        Response r=given()
                .contentType("application/json").body("{\n" +
                        "  \"application\": \"aegon-sales\",\n" +
                        "  \"campaign\": \"test_islemi\",\n" +
                        "  \"content\": \"Değerli müşterimiz, hesaplama sonucunuza göre Aegon Kredi Hayat Sigortası Prim tutarınız 5.311 TL?dir. Ayrıntılı bilgi için: aegondirekt.com.tr / 0850 222 34 66 \\nSms Listesinden çıkmak için AEGON RET yaz 3634'e gonder. Mersis No: 0069010263400023 Aegondirekt\",\n" +
                        "  \"mobileNumber\": \""+number+"\",\n" +
                        "  \"polid\": \"\"\n" +
                        "}")
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-sms/")
                .then().statusCode(200).extract().response();
    }

    @Step("Email")
    public void Email(){
        Response r=given()
                .contentType("application/json").body("{\n" +
                        "  \"toEmail\": \"eren.celik@aegon.com.tr\",\n" +
                        "  \"ccEmail\": \"eren.celik@aegon.com.tr\",\n" +
                        "  \"bccEmail\": \"eren.celik@aegon.com.tr\",\n" +
                        "  \"content\": \"test email içerik\",\n" +
                        "  \"subject\": \"test email konu\",\n" +
                        "  \"polid\": \"2150215\",\n" +
                        "  \"application\": \"aegon-sales\",\n" +
                        "  \"campaign\": \"test_islemi\",\n" +
                        "    \"attachmentList\": [\n" +
                        "    {\n" +
                        "      \"attachment\": \"QW55IFN0cmluZyB5b3Ugd2FudA==\",\n" +
                        "      \"fileName\": \"test_attachment.txt\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-email/")
                .then().statusCode(200).extract().response();
    }

    @Step("TCKN-gsm")
    public void sms(){
        Response r=given()
                .contentType("application/json").body("{\n" +
                        "  \"dogrulamaType\": \"KIMLIK_GSM\",\n" +
                        "  \"gsmNo\": 5111111111,\n" +
                        "  \"kanal\": 11,\n" +
                        "  \"kimlikNo\": 11111111111,\n" +
                        "  \"kullaniciAdi\": \"eren.celik\",\n" +
                        "  \"platformId\": 5\n" +
                        "}")
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-tckn/kkb-findeks/verify")
                .then().statusCode(200).extract().response();
    }

    @Step("Customer Adress")
    public void customerAdress(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "    \"tcId\":\"17222447278\"\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-customer-address/address-information")
                .then().statusCode(200).extract().response();
    }
    @Step("Mernis")
    public void mernis(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "  \"tckn\": \"12345678901\"\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-mernis/birlesik-sorgulama")
                .then().statusCode(200).extract().response();
    }
    @Step("Black List")
    public void blackList(){
        Response r=given()
                .contentType("application/json").body(BodyCreater.createBodyByScenarioName()
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-blacklist/query")
                .then().statusCode(200).extract().response();
    }

    @Step("Total Assurance")
    public void totalAssurance(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "\t \"citizenId\": \"12345678901\"\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-total-assurance/")
                .then().statusCode(200).extract().response();
    }

    @Step("Kredi Kartı Kontrol")
    public void creditCardControl(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "  \"creditCardNo\": 1234123412341234\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-credit-card/creditcard-control")
                .then().statusCode(200).extract().response();
    }

    @Step("Tckn Iban")
    public void tcknIban(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "  \"dogrulamaType\": \"KIMLIK_IBAN\",\n" +
                                "  \"gsmNo\": \"\",\n" +
                                "  \"iban\": \"TR11111111111111111\",\n" +
                                "  \"kanal\": 11,\n" +
                                "  \"kimlikNo\": 11111111111,\n" +
                                "  \"kullaniciAdi\": \"aegon.aegon\",\n" +
                                "  \"platformId\": 5\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-tckn/kkb-findeks/verify")
                .then().statusCode(200).extract().response();
    }

    @Step("Purchase")
    public void purchase(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "    \"broker\": {\n" +
                                "        \"brokerIdNumber\": \"13031935128\",\n" +
                                "        \"reference\": null,\n" +
                                "        \"referenceAgency\": null,\n" +
                                "        \"referenceConsultant\": null\n" +
                                "    },\n" +
                                "    \"coverages\": [\n" +
                                "        {\n" +
                                "            \"amount\": 1000,\n" +
                                "            \"code\": \"VEF\",\n" +
                                "            \"surprim\": 50,\n" +
                                "            \"surprimType\": \"S\"\n" +
                                "        }\n" +
                                "    ],\n" +
                                "    \"insured\": {\n" +
                                "        \"citizenId\": \"16172133330\",\n" +
                                "        \"cityOfBirth\": \"İSTANBUL\",\n" +
                                "        \"countryOfBirth\": \"TÜRKİYE\",\n" +
                                "        \"education\": \"2\",\n" +
                                "        \"gender\": \"K\",\n" +
                                "        \"jobCode\": 36,\n" +
                                "        \"alcohol\": \"\",\n" +
                                "        \"smoking\": \"\",\n" +
                                "        \"motherMaidenName\": \"\",\n" +
                                "        \"passport\": \"\",\n" +
                                "        \"registirationNumber\": \"\",\n" +
                                "        \"contactInfo\": [\n" +
                                "            {\n" +
                                "                \"address\": \"Kemal Türkler Mahallesi\",\n" +
                                "                \"city\": \"İSTANBUL\",\n" +
                                "                \"country\": \"TÜRKİYE\",\n" +
                                "                \"email\": \"merve.demirhan@gmail.com\",\n" +
                                "                \"phoneNumber\": \"5419532330\",\n" +
                                "                \"town\": \"SANCAKTEPE\",\n" +
                                "                \"zipCode\": \"\"\n" +
                                "            }\n" +
                                "        ],\n" +
                                "        \"bankInfo\": {\n" +
                                "            \"bankCode\": 0,\n" +
                                "            \"iban\": \"\"\n" +
                                "        },\n" +
                                "        \"creditCardInfo\": [\n" +
                                "            {\n" +
                                "                \"bankNumber\": 64,\n" +
                                "                \"cardNumber\": \"4543607865435678\",\n" +
                                "                \"cardType\": \"MASTER\",\n" +
                                "                \"expireDate\": \"08-2022\",\n" +
                                "                \"priority\": 1\n" +
                                "            }\n" +
                                "        ]\n" +
                                "    },\n" +
                                "    \"isInsurerSame\": \"T\",\n" +
                                "    \"insurer\": {\n" +
                                "        \"citizenId\": \"16172133330\",\n" +
                                "        \"cityOfBirth\": \"İSTANBUL\",\n" +
                                "        \"countryOfBirth\": \"TÜRKİYE\",\n" +
                                "        \"education\": \"\",\n" +
                                "        \"isLegal\": \"\",\n" +
                                "        \"jobCode\": 0,\n" +
                                "        \"motherMaidenName\": \"\",\n" +
                                "        \"passport\": \"\",\n" +
                                "        \"registirationNumber\": \"\",\n" +
                                "        \"contactInfo\": [\n" +
                                "            {\n" +
                                "                \"address\": \"string\",\n" +
                                "                \"city\": \"string\",\n" +
                                "                \"country\": \"string\",\n" +
                                "                \"email\": \"string\",\n" +
                                "                \"phoneNumber\": \"\",\n" +
                                "                \"town\": \"string\",\n" +
                                "                \"zipCode\": \"1234\"\n" +
                                "            }\n" +
                                "        ],\n" +
                                "        \"bankInfo\": {\n" +
                                "            \"bankCode\": 0,\n" +
                                "            \"iban\": \"\"\n" +
                                "        },\n" +
                                "        \"creditCardInfo\": [\n" +
                                "            {\n" +
                                "                \"bankNumber\": 64,\n" +
                                "                \"cardNumber\": \"4543607865435678\",\n" +
                                "                \"cardType\": \"MASTER\",\n" +
                                "                \"expireDate\": \"08-2022\",\n" +
                                "                \"priority\": 0\n" +
                                "            }\n" +
                                "        ],\n" +
                                "        \"companyInfo\": {\n" +
                                "            \"companType\": \"\",\n" +
                                "            \"company\": \"\",\n" +
                                "            \"jobTitle\": \"\",\n" +
                                "            \"taxNumber\": \"\",\n" +
                                "            \"taxOffice\": \"\",\n" +
                                "            \"usaTaxNumber\": \"\"\n" +
                                "        }\n" +
                                "    },\n" +
                                "    \"policy\": {\n" +
                                "        \"agitouw\": \"\",\n" +
                                "        \"amount\": 1,\n" +
                                "        \"annualPremium\": 1000,\n" +
                                "        \"applicationId\": 3738081132,\n" +
                                "        \"campaingCode\": 17,\n" +
                                "        \"currency\": \"USD\",\n" +
                                "        \"duration\": 15,\n" +
                                "        \"firstCollectionDate\": \"15062020\",\n" +
                                "        \"followingCollectionDay\": 10,\n" +
                                "        \"otherVendorCode\": \"\",\n" +
                                "        \"patch1\": \"1000\",\n" +
                                "        \"patch2\": \"12000\",\n" +
                                "        \"paymentOption\": \"\",\n" +
                                "        \"paymentPeriod\": 12,\n" +
                                "        \"paymentType\": \"CREDIT_CARD\",\n" +
                                "        \"policyEndDate\": \"23062030\",\n" +
                                "        \"policyStartDate\": \"23062020\",\n" +
                                "        \"policyStartYear\": 2020,\n" +
                                "        \"renewalCount\": 0,\n" +
                                "        \"riskClass\": \"1\",\n" +
                                "        \"standard\": \"\",\n" +
                                "        \"surprimChart\": \"\",\n" +
                                "        \"surprimReason\": null,\n" +
                                "        \"tariffCode\": \"ROPFR15\",\n" +
                                "        \"year\": 15\n" +
                                "    },\n" +
                                "    \"endorsees\": [\n" +
                                "        {\n" +
                                "            \"affinity\": \"\",\n" +
                                "            \"benefitType\": \"\",\n" +
                                "            \"citizenId\": \"17222447278\",\n" +
                                "            \"cityOfBirth\": \"İSTANBUL\",\n" +
                                "            \"countryOfBirth\": \"TÜRKİYE\",\n" +
                                "            \"endorseeType\": \"\",\n" +
                                "            \"job\": \"\",\n" +
                                "            \"jobCode\": 0,\n" +
                                "            \"percentage\": 100,\n" +
                                "            \"contactInfo\": {\n" +
                                "                \"address\": \"ŞİŞLİ MAHALLESİ\",\n" +
                                "                \"city\": \"İSTANBUL\",\n" +
                                "                \"country\": \"TÜRKİYE\",\n" +
                                "                \"email\": \"irem@aegon.com.tr\",\n" +
                                "                \"phoneNumber\": \"5439377620\",\n" +
                                "                \"town\": \"şişli\",\n" +
                                "                \"zipCode\": \"\"\n" +
                                "            }\n" +
                                "        }\n" +
                                "    ],\n" +
                                "    \"healthQuestions\": [\n" +
                                "        {\n" +
                                "            \"no\": \"619\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"621\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"617\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"615\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"597\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"598\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"599\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"600\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"601\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"602\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"no\": \"603\",\n" +
                                "            \"answer\": \"H\",\n" +
                                "            \"desc\": \"asd\"\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-purchase/policy")
                .then().statusCode(200).extract().response();
    }

    @Step("Purchase Documents")
    public void purchaseDocuments(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "  \"applicationNumber\": 1234567890,\n" +
                                "  \"archivalRequired\": true,\n" +
                                "  \"backUrl\": \"http://www.example.com\",\n" +
                                "  \"bankAccountInfos\": [\n" +
                                "    {\n" +
                                "      \"title\": \"'Banka İsmi:' veya 'Hesap No:' gibi\",\n" +
                                "      \"value\": \"'Örnek Bankası' veya 'TR1234567812345678' gibi\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"campaignCode\": 1234567,\n" +
                                "  \"confirmation\": {\n" +
                                "    \"companyEmployeeName\": \"Jane Doe\",\n" +
                                "    \"companyName\": \"Örnek Şirketi Ltd.\",\n" +
                                "    \"companySignImageData\": \"data:image/gif;base64,XCY..\",\n" +
                                "    \"companySignImageUrl\": \"http://www.example.com/imza2.jpg\",\n" +
                                "    \"companySigningDate\": \"01/01/2018\",\n" +
                                "    \"insurerInitialsImageData\": \"string\",\n" +
                                "    \"insurerInitialsImageUrl\": \"http://www.example.com/paraf1.jpg\",\n" +
                                "    \"insurerName\": \"Jane Doe\",\n" +
                                "    \"insurerSignImageData\": \"data:image/gif;base64,XCY..\",\n" +
                                "    \"insurerSignImageUrl\": \"http://www.example.com/imza1.jpg\",\n" +
                                "    \"insurerSigningDate\": \"01/01/2018\"\n" +
                                "  },\n" +
                                "  \"creditCards\": [\n" +
                                "    {\n" +
                                "      \"bankName\": \"Örnek Bankası\",\n" +
                                "      \"expirationDate\": \"01/23\",\n" +
                                "      \"number\": 1234567812345678,\n" +
                                "      \"ownerName\": \"John Doe\",\n" +
                                "      \"preferred\": true,\n" +
                                "      \"type\": \"Master\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"durationYears\": 10,\n" +
                                "  \"endDate\": \"01/01/2023\",\n" +
                                "  \"endorseds\": [\n" +
                                "    {\n" +
                                "      \"name\": \"John Doe\",\n" +
                                "      \"percent\": 10,\n" +
                                "      \"personalIdNumber\": 12345678901\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"firstPaymentDate\": \"01/01/2018\",\n" +
                                "  \"guarantees\": [\n" +
                                "    {\n" +
                                "      \"currency\": \"TL\",\n" +
                                "      \"mainCategory\": true,\n" +
                                "      \"price\": 1,\n" +
                                "      \"title\": \"Vefat Teminatı\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"guaranteesExplanation\": \"*KAP'ın yıllık prim tutarı kadar olan teminatlar yıl bazında ödenirken, ...\",\n" +
                                "  \"healthBasic\": {\n" +
                                "    \"additionalGuaranteesAfterTitle\": \"Prim Artışı\",\n" +
                                "    \"additionalGuaranteesBeforeTitle\": \"Uygulama Öncesi\",\n" +
                                "    \"additionalGuaranteesExplanation\": \"Başvurunuza istinaden yapılan ön değerlendirme sonuçları ...\",\n" +
                                "    \"additionalGuaranteesNameTitle\": \"Teminat\",\n" +
                                "    \"additionalGuaranteesPercentTitle\": \"Sürprim Oranı\",\n" +
                                "    \"additionalGuaranteesTableRows\": [\n" +
                                "      {\n" +
                                "        \"feeAfter\": \"1.100 TL\",\n" +
                                "        \"feeBefore\": \"1.000 TL\",\n" +
                                "        \"feePercent\": \"%10\",\n" +
                                "        \"name\": \"Vefat Teminatı\"\n" +
                                "      }\n" +
                                "    ],\n" +
                                "    \"hasDeclinedApplicationForInsurance\": true,\n" +
                                "    \"hasDeclinedApplicationForInsuranceExplanation\": \"1 yıl önce de başvurmuşttum, kabul edilmedi\",\n" +
                                "    \"hasIllnessCancer\": true,\n" +
                                "    \"hasIllnessColitis\": true,\n" +
                                "    \"hasIllnessDiabetes\": true,\n" +
                                "    \"hasIllnessExplanation\": \"Diğer-Açıklama\",\n" +
                                "    \"hasIllnessHeart\": true,\n" +
                                "    \"hasIllnessHepatitis\": true,\n" +
                                "    \"hasIllnessHypertension\": true,\n" +
                                "    \"hasIllnessKidneys\": true,\n" +
                                "    \"hasIllnessNervousSystem\": true,\n" +
                                "    \"hasIllnessOthers\": true,\n" +
                                "    \"hasIllnessParalysis\": true,\n" +
                                "    \"hasReceivedDisabilitiesPayment\": true,\n" +
                                "    \"hasReceivedDisabilitiesPaymentExplanation\": \"5 senedir maluliyet ödemesi alıyorum\",\n" +
                                "    \"hasTakenMedications\": true,\n" +
                                "    \"hasTakenMedicationsExplanation\": \"1 hafta önce antibiotik aldım\",\n" +
                                "    \"hasVisitedPhysician\": true,\n" +
                                "    \"hasVisitedPhysicianExplanation\": \"1 hafta önce grip olmuştum\"\n" +
                                "  },\n" +
                                "  \"healthExtended\": {\n" +
                                "    \"additionalGuaranteesAfterTitle\": \"Prim Artışı\",\n" +
                                "    \"additionalGuaranteesBeforeTitle\": \"Uygulama Öncesi\",\n" +
                                "    \"additionalGuaranteesExplanation\": \"Başvurunuza istinaden yapılan ön değerlendirme sonuçları ...\",\n" +
                                "    \"additionalGuaranteesNameTitle\": \"Vefat Teminatı\",\n" +
                                "    \"additionalGuaranteesPercentTitle\": \"Sürprim Oranı\",\n" +
                                "    \"additionalGuaranteesTableRows\": [\n" +
                                "      {\n" +
                                "        \"feeAfter\": \"1.100 TL\",\n" +
                                "        \"feeBefore\": \"1.000 TL\",\n" +
                                "        \"feePercent\": \"%10\",\n" +
                                "        \"name\": \"Vefat Teminatı\"\n" +
                                "      }\n" +
                                "    ],\n" +
                                "    \"hasAnyIllnessBelow\": true,\n" +
                                "    \"hasChronicIllness\": true,\n" +
                                "    \"hasChronicIllnessExplanation\": \"Sağ kolumda deformasyon var ...\",\n" +
                                "    \"hasGallbladderRemoved\": true,\n" +
                                "    \"hasHivSuspicion\": true,\n" +
                                "    \"hasHivSuspicionExplanation\": \"AIDS için kan testi yaptırmıştım .\",\n" +
                                "    \"hasIllnessCardiovascular\": true,\n" +
                                "    \"hasIllnessCardiovascularExplanation\": \"string\",\n" +
                                "    \"hasIllnessDigestive\": true,\n" +
                                "    \"hasIllnessDigestiveExplanation\": \"string\",\n" +
                                "    \"hasIllnessDigestiveOther\": true,\n" +
                                "    \"hasIllnessGenitourinary\": true,\n" +
                                "    \"hasIllnessGenitourinaryExplanation\": \"string\",\n" +
                                "    \"hasIllnessGenitourinaryOther\": true,\n" +
                                "    \"hasIllnessGland\": true,\n" +
                                "    \"hasIllnessGlandExplanation\": \"string\",\n" +
                                "    \"hasIllnessKidneyStone\": true,\n" +
                                "    \"hasIllnessNervous\": true,\n" +
                                "    \"hasIllnessNervousExplanation\": \"string\",\n" +
                                "    \"hasIllnessOther\": true,\n" +
                                "    \"hasIllnessOtherExplanation\": \"Diğer hastalıklar listesi ..\",\n" +
                                "    \"hasIllnessRespiratory\": true,\n" +
                                "    \"hasIllnessRespiratoryExplanation\": \"string\",\n" +
                                "    \"hasIllnessUnexplainable\": true,\n" +
                                "    \"hasIllnessUnexplainableExplanation\": \"string\",\n" +
                                "    \"hasNotificationOfIllness\": true,\n" +
                                "    \"hasNotificationOfIllnessExplanation\": \"Ameliyat sonrası 15 gün işe devam edemedim .\",\n" +
                                "    \"hasParalysis\": true,\n" +
                                "    \"hasParalysisExplanation\": \"Geçici felç yaşadım ..\",\n" +
                                "    \"hasReceivedBloodTransfusion\": true,\n" +
                                "    \"hasReceivedBloodTransfusionExplanation\": \"Ameliyat olduğumda kan nakli yapılmıştı .\",\n" +
                                "    \"hasReceivedDisabilityPayments\": true,\n" +
                                "    \"hasReceivedDisabilityPaymentsExplanation\": \"5 yıldır maluliyet ödemesi alıyorum .\",\n" +
                                "    \"hasRejectedInsurance\": true,\n" +
                                "    \"hasRejectedInsuranceExplanation\": \"1 yıl önce de başvurmuşttum, kabul edilmedi\",\n" +
                                "    \"hasSimilarProblems\": true,\n" +
                                "    \"hasSimilarProblemsExplanation\": \"Babam geçici felç geçirdi ..\",\n" +
                                "    \"hasTransplantation\": true,\n" +
                                "    \"hasTransplantationExplanation\": \"Organ veya doku nakli ...\",\n" +
                                "    \"hasVisitedPhysician\": true,\n" +
                                "    \"visitType\": \"Rutin Kontroller\",\n" +
                                "    \"wasAtHospital\": true,\n" +
                                "    \"wasAtHospitalExplanation\": \"Geçen sene ameliyat olmuştum .\"\n" +
                                "  },\n" +
                                "  \"insuranceSlug\": \"5-5-odullu-birikim\",\n" +
                                "  \"insuredName\": \"Jane Doe\",\n" +
                                "  \"insuredPerson\": {\n" +
                                "    \"addressHome\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "    \"addressWork\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "    \"birthDate\": \"01/01/1980\",\n" +
                                "    \"education\": \"Lise\",\n" +
                                "    \"emailAddress\": \"john@example.com\",\n" +
                                "    \"expirationDate\": \"01/01/2019\",\n" +
                                "    \"fathersName\": \"John\",\n" +
                                "    \"firstName\": \"John\",\n" +
                                "    \"gender\": \"E\",\n" +
                                "    \"lastName\": \"Doe\",\n" +
                                "    \"mothersName\": \"Jane\",\n" +
                                "    \"nationality\": \"TC\",\n" +
                                "    \"personalIdNumber\": 12345678912,\n" +
                                "    \"phoneNumber\": \"0 (216) 555 55 55\",\n" +
                                "    \"phoneNumberMobile\": \"0 (555) 555 55 55\",\n" +
                                "    \"profession\": \"Muhasebeci\",\n" +
                                "    \"selectedNotificationForm\": \"E-Posta\",\n" +
                                "    \"selectedPostalAddress\": \"Ev\",\n" +
                                "    \"serialNumber\": \"A3568Z5460\",\n" +
                                "    \"usaTinNumber\": 1234567890\n" +
                                "  },\n" +
                                "  \"insuredPersonalId\": \"012345678901\",\n" +
                                "  \"insurerCompany\": {\n" +
                                "    \"activity\": \"Ürün alım satım\",\n" +
                                "    \"address\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "    \"emailAddress\": \"info@example.com\",\n" +
                                "    \"employee\": {\n" +
                                "      \"addressHome\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "      \"addressWork\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "      \"birthDate\": \"01/01/1980\",\n" +
                                "      \"education\": \"Lise\",\n" +
                                "      \"emailAddress\": \"john@example.com\",\n" +
                                "      \"expirationDate\": \"01/01/2019\",\n" +
                                "      \"fathersName\": \"John\",\n" +
                                "      \"firstName\": \"John\",\n" +
                                "      \"gender\": \"E\",\n" +
                                "      \"lastName\": \"Doe\",\n" +
                                "      \"mothersName\": \"Jane\",\n" +
                                "      \"nationality\": \"TC\",\n" +
                                "      \"personalIdNumber\": 12345678912,\n" +
                                "      \"phoneNumber\": \"0 (216) 555 55 55\",\n" +
                                "      \"phoneNumberMobile\": \"0 (555) 555 55 55\",\n" +
                                "      \"profession\": \"Muhasebeci\",\n" +
                                "      \"serialNumber\": \"A3568Z5460\",\n" +
                                "      \"usaTinNumber\": 1234567890\n" +
                                "    },\n" +
                                "    \"phoneNumber\": \"0 (216) 666 66 66\",\n" +
                                "    \"phoneNumberMobile\": \"0 (555) 555 55 55\",\n" +
                                "    \"registrationNumber\": 1234567890,\n" +
                                "    \"relationToInsured\": \"İş veren\",\n" +
                                "    \"sector\": \"E-Ticaret\",\n" +
                                "    \"taxAdministration\": \"Üsküdar\",\n" +
                                "    \"taxId\": 1234567890,\n" +
                                "    \"title\": \"Örnek Şirketi Ltd.\",\n" +
                                "    \"website\": \"http://www.example.com\"\n" +
                                "  },\n" +
                                "  \"insurerName\": \"John Doe\",\n" +
                                "  \"insurerPerson\": {\n" +
                                "    \"addressHome\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "    \"addressWork\": \"Örnek Mah. Örnek Sok. No 5 Üsküdar-İstanbul\",\n" +
                                "    \"birthDate\": \"01/01/1980\",\n" +
                                "    \"education\": \"Lise\",\n" +
                                "    \"emailAddress\": \"john@example.com\",\n" +
                                "    \"expirationDate\": \"01/01/2019\",\n" +
                                "    \"fathersName\": \"John\",\n" +
                                "    \"firstName\": \"John\",\n" +
                                "    \"gender\": \"E\",\n" +
                                "    \"lastName\": \"Doe\",\n" +
                                "    \"mothersName\": \"Jane\",\n" +
                                "    \"nationality\": \"TC\",\n" +
                                "    \"personalIdNumber\": 12345678912,\n" +
                                "    \"phoneNumber\": \"0 (216) 555 55 55\",\n" +
                                "    \"phoneNumberMobile\": \"0 (555) 555 55 55\",\n" +
                                "    \"profession\": \"Muhasebeci\",\n" +
                                "    \"relationToInsured\": \"Amcası\",\n" +
                                "    \"selectedNotificationForm\": \"E-Posta\",\n" +
                                "    \"selectedPostalAddress\": \"Ev\",\n" +
                                "    \"serialNumber\": \"A3568Z5460\",\n" +
                                "    \"usaTinNumber\": 1234567890\n" +
                                "  },\n" +
                                "  \"insurerPersonalId\": \"012345678901\",\n" +
                                "  \"lifestyle\": {\n" +
                                "    \"armyAsked\": true,\n" +
                                "    \"armyExplanation\": \"Askerlik yapmadım çünkü...\",\n" +
                                "    \"armyStatus\": \"Muaf\",\n" +
                                "    \"doingExtremeSports\": true,\n" +
                                "    \"drinking\": true,\n" +
                                "    \"drinkingPeriod\": \"1 Kadeh\",\n" +
                                "    \"education\": \"Yüksek Lisans\",\n" +
                                "    \"extremeSportsExplanation\": \"Dağcılık\",\n" +
                                "    \"healthDeclaration\": \"Hayat sigortası için yaptığım başvuru tarihi itibarıyla; ...\",\n" +
                                "    \"height\": \"1 m 75 cm\",\n" +
                                "    \"numSmokingPerDay\": 20,\n" +
                                "    \"profession\": \"Avukat\",\n" +
                                "    \"smoking\": true,\n" +
                                "    \"travelling\": true,\n" +
                                "    \"travellingAsked\": true,\n" +
                                "    \"travellingCountries\": \"Norveç, Almanya\",\n" +
                                "    \"wasAtArmy\": true,\n" +
                                "    \"weight\": \"70 kg\"\n" +
                                "  },\n" +
                                "  \"mediator\": {\n" +
                                "    \"companyName\": \"Örnek Sigorta Acentesi Lt.d\",\n" +
                                "    \"companyType\": \"Acente\",\n" +
                                "    \"personName\": \"John Doe\",\n" +
                                "    \"personType\": \"Aracı\"\n" +
                                "  },\n" +
                                "  \"monthlyPaymentDay\": 15,\n" +
                                "  \"paymentPeriodMonths\": 6,\n" +
                                "  \"periodicalPrice\": 1,\n" +
                                "  \"periodicalPriceCurrency\": \"TL\",\n" +
                                "  \"polId\": 2223524,\n" +
                                "  \"policyNumber\": \"ROP_AD_3017060001\",\n" +
                                "  \"secondYearlyPrice\": 1,\n" +
                                "  \"secondYearlyPriceCurrency\": \"TL\",\n" +
                                "  \"startDate\": \"01/01/2018\",\n" +
                                "  \"tckn\": 17222447278,\n" +
                                "  \"yearlyPrice\": 1,\n" +
                                "  \"yearlyPriceCurrency\": \"TL\"\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-purchase-documents/application-form/pdf")
                .then().statusCode(200).extract().response();
    }

    @Step("Presales Collection")
    public void presalesCollection(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "  \"amount\": 0.01,\n" +
                                "  \"apllicationId\": 3333333302,\n" +
                                "  \"creditCardExpDate\": \"07-24\",\n" +
                                "  \"creditCardNo\": 1234123412341234,\n" +
                                "  \"currencyType\": \"TL\",\n" +
                                "  \"cvvNo\": 111,\n" +
                                "  \"isProvision\": 1,\n" +
                                "  \"partajNo\": 11111111111,\n" +
                                "  \"paymentDate\": \"26/08/2020\",\n" +
                                "  \"paymentType\": 3,\n" +
                                "  \"tcId\": 11111111111\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-presales-collection/collect")
                .then().statusCode(200).extract().response();
    }

    @Step("Policy Creation")
    public void policyCreation(){
        Response r=given()
                .contentType("application/json").body(
                        "{\n" +
                                "  \"brokerIdNumber\": \"13031935128\",\n" +
                                "  \"payment\": {\n" +
                                "    \"amount\": 1,\n" +
                                "    \"bankCode\": 62,\n" +
                                "    \"cardNumber\": \"5440781111111111\",\n" +
                                "    \"creditCardType\": \"MASTER\",\n" +
                                "    \"expireDate\": \"022022\",\n" +
                                "    \"name\": \"MEHMET EREN\",\n" +
                                "    \"paymentDate\": \"12082020\",\n" +
                                "    \"paymentType\": \"CREDIT_CARD\",\n" +
                                "    \"surname\": \"ÇELİK\"\n" +
                                "  },\n" +
                                "  \"polId\": 2389612,\n" +
                                "  \"app\":\"aegondirekt\"\n" +
                                "}"
                )
                .log().all().when()
                .post("https://service-test.aegon.com.tr/sales/aegon-policy/create")
                .then().statusCode(200).extract().response();
    }
 */
