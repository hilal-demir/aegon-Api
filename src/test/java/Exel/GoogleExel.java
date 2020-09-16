package Exel;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;



public class GoogleExel {

    private  static Sheets sheetsService;
    private  static String APPLICATION_NAME = "yenitest";
    private  static String SPREADSHEET_ID = "1i0SHHA0vZnTKJTq6CQFJouY3hGzDnK1b7tjlYTIEvV4";

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static Credential authorize() throws IOException, GeneralSecurityException {
        // Load client secrets.
        InputStream in = GoogleExel.class.getResourceAsStream("/credentials.json");

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in));
        List<String> scopes= Arrays.asList(SheetsScopes.SPREADSHEETS);
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
                .authorize("user");
        return credential;
    }
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException{
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),credential).setApplicationName(APPLICATION_NAME).build();
    }

    public static void main(String[] args) throws IOException,GeneralSecurityException {
        sheetsService=getSheetsService();
        String range="sayfa1!A1:J10";
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID,range)
                .execute();

        List<List<Object>> values=response.getValues();
        System.out.println(values);
    }
    public void fillExcel(String scnerioName,String date,String post,String expectedStatus,String actualStatus,String errorMessage,String message,String responseTime,Boolean status) throws IOException, GeneralSecurityException {
//        sheetsService = getSheetsService();
//        String statusText;
//        if(status){
//            statusText="Fail";
//        }else{
//            statusText="Pass";
//
//        }
//
//        ValueRange appendBody =new ValueRange()
//                .setValues(Arrays.asList(
//                        Arrays.asList(
//                                scnerioName,date,post,expectedStatus,actualStatus,errorMessage,message,responseTime,statusText )
//                ));
//
//        AppendValuesResponse appendResult2 =   sheetsService.spreadsheets().values()
//                .append(SPREADSHEET_ID,"Sayfa1",appendBody)
//                .setValueInputOption("USER_ENTERED")
//                .setInsertDataOption("INSERT_ROWS")
//                .setIncludeValuesInResponse(true)
//                .execute();
    }

    public void getSheetDataAndSendTheMail(String date) throws IOException, GeneralSecurityException {
        localExcel local=new localExcel();
        sheetsService=getSheetsService();
        String range="sayfa1!A1:J400";
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID,range)
                .execute();

        List<List<Object>> values=response.getValues();
        logger.info("Google Sheets sevisinden rapor çakildi");
        local.createAnExcell(values,date);

    }


}
