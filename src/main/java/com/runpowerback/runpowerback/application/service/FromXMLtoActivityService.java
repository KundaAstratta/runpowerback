package com.runpowerback.runpowerback.application.service;

import com.runpowerback.runpowerback.application.StorageService;
import com.runpowerback.runpowerback.domaine.repository.ActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.runpowerback.runpowerback.domaine.entity.ActivityPointOf;


import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class FromXMLtoActivityService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    StorageService storageService;

    @Value("${runpower.upload.location}")
    private String location;

    public String toReadXMLService(String fileXML) throws IOException {

        try {

            String fileSeparator = System.getProperty("file.separator");

    //        Path someDirectory = Paths.get(fileSeparator+"Users"+fileSeparator+"runpower");
            Path someDirectory = Paths.get(location);

    //        final String subdirectoryName = "tmp";
            final String subdirectoryName = "";

            Path someSubdirectory = someDirectory.resolve(subdirectoryName);
            try {
                Files.createDirectory(someSubdirectory);
            } catch (FileAlreadyExistsException e) {
                logger.info("The directory already exists", e);
            } catch (IOException e) {
                logger.info("The directory can't be created", e);
            }

            logger.info("file separator : {}",  fileSeparator);
//            String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"runpower"+fileSeparator+"tmp"+fileSeparator+fileXML;
            String relativeFilePath = location + fileSeparator + fileXML;
 //           logger.info("absoluteFilePath :{}", absoluteFilePath);
            logger.info("relativeFilePath :{}", relativeFilePath);


 //           File f =  new File(absoluteFilePath);
            File f =  new File(relativeFilePath);

            if (f.exists()) {
                System.out.println("exist");
                BufferedReader b = new BufferedReader(new FileReader(f));

                String readLineOfXML = "";
                String xmlTag = "";

                // Extract trkpt
                String trkptLatLonBegin = "<trkpt ";
                String trkptLatLonEnd = ">";

                // Extract latitude from trkpt
                float latitude = 0;
                String extractLatBegin = "lat=\"";
                String extractLatEnd = "\"";
                int posLat = 0;

                // Extract longitude from trkpt
                float longitude = 0;
                String extractLonBegin = "lon=\"";
                String extractLonEnd = "\"";
                int posLon = 1;

                // Extract elevation in trkpt balise
                float elevation = 0;
                String trkptEleBegin = "<ele>";
                String trkptEleEnd = "</ele>";

                float hearthrate = 0;
                String trkptHrBegin = "<gpxtpx:hr>";
                String trkptHrEnd = "</gpxtpx:hr>";

                String timezone = "";
                String trkptTimeBegin = "<time>";
                String trkptTimeEnd = "</time>";

                String trkptEnd = "</trkpt>";

                String extractLonLat = "";

                System.out.println("Reading file using Buffered Reader");

                while ((readLineOfXML = b.readLine()) != null) {

                    xmlTag = readLineOfXML.trim();

                    if (xmlTag.startsWith(trkptLatLonBegin)) {
                        extractLonLat = getMappedXML(xmlTag, trkptLatLonBegin, trkptLatLonEnd);
                        latitude = Float.parseFloat(getMappedXML(extractLonLat.split(" ")[posLat], extractLatBegin, extractLatEnd));
                        longitude = Float.parseFloat(getMappedXML(extractLonLat.split(" ")[posLon], extractLonBegin, extractLonEnd));

                        logger.info(latitude);
                        logger.info(longitude);
                    }
                    if (xmlTag.startsWith(trkptEleBegin)) {
                        elevation = Float.parseFloat(getMappedXML(xmlTag, trkptEleBegin, trkptEleEnd));
                        logger.info(elevation);
                    }
                    if (xmlTag.startsWith(trkptTimeBegin)) {
                        timezone = getMappedXML(xmlTag, trkptTimeBegin, trkptTimeEnd);
                        logger.info(timezone);
                    }
                    if (xmlTag.startsWith(trkptHrBegin)) {
                        hearthrate = Float.parseFloat(getMappedXML(xmlTag, trkptHrBegin, trkptHrEnd));
                        logger.info("hearthrate 2 : " + hearthrate);

                    }
                    if (xmlTag.startsWith(trkptEnd)) {
                        ActivityPointOf activity = new ActivityPointOf(null, latitude, longitude, elevation, hearthrate, timezone);
                        this.activityRepository.save(activity);
                        logger.info("Activity" + activity);
                    }


                }

                storageService.deleteAll();
                storageService.init();

                return "exist";
            } else {
                System.out.println("not exist");
              return "notexist";
            }
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            return e.getMessage();
        }



    }

    static String getMappedXML(String extractedXML, String xml_begin, String xml_end) {
        return extractedXML.replace(xml_begin,"").replace(xml_end,"");
    }

}


