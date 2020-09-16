package mail;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mail {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public void sendReport(String fileName) {
        logger.info("Oluşturulan "+fileName+" Dosyası mail olarak gönderiliyor");
        String count="null";
        try {
            // e-postayı göndereceğiniz adres
            String from = "testiniumAegonApi@gmail.com";
            // hesabınızın parolası
            String pass = "Testinium1994";
            // e-postanın gönderileceği adresler
           // String[] to = { "baris.zinkildak@testinium.com","umit.gok@testinium.com","batuhan.zafer@testinium.com" };
            String[] to = { "baris.zinkildak@testinium.com","znkldk@gmail.com" };

            // host
            String host = "smtp.gmail.com";

            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            // başlık
            message.setSubject("Otomasyon Koşum Raporu");
            // içerik
            logger.info(count);
            message.setText("test");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(
                    "Merhabalar, \n\n" +
                            "Ben bir otomasyon yazılımıyım son koşumun raporunu aşağıda paylaşıyorum \n\n" +
                            count+"\n"+
                            "Bu bir otomatik mesajdır");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            System.out.println("path testi başlasın");
            Path test2= Paths.get("./Test Reports/"+fileName);
            Assert.assertTrue(Files.exists(test2));
            System.out.println("./Test Reports/"+fileName+" da dosya bulundu garip");

            Path test3= Paths.get("Test Reports/"+fileName);
            Assert.assertTrue(Files.exists(test3));
            System.out.println("Test Reports/"+fileName+" da dosya bulundu garip");
            System.out.println("path testi bitti başarılı");


            messageBodyPart = new MimeBodyPart();
            String filename = "Test Reports/"+fileName;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);


            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            logger.info("Mail başarılı bir şekilde gönderildi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}