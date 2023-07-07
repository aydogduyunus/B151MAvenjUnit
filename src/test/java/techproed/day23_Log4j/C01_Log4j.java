package techproed.day23_Log4j;

import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C01_Log4j {

    @Test
    public void log4j() {
        /*
        Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api'dir
        Log4j ile bu bilgilendirmeleri hem konsolda tarih saat olarak hemde src> main> resources icine
        koydugumuz log4j.xml fail da belirttigimiz .log uzantili dosytada yine tarih saat olarak kayir altina
        almis olacagiz
        Log4j kullanabilmek icin oncelikle log4j-api ve log4j-core dependency lerini mvnrepository.ciom
        adresinden (ayni version numaralarina sahip) alip pom.xml dosyasina koymaliyiz
        src>main>resources icine koydugumuz log4j.xml dosyasindaki kodlara pdf'deki adresten ulasabilirsiniz
         */
        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARN");


    }
}
