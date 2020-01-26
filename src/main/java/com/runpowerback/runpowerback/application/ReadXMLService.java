package com.runpowerback.runpowerback.application;

import com.runpowerback.runpowerback.domaine.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.runpowerback.runpowerback.domaine.Activity;


import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
@Transactional
public class ReadXMLService {

    @Autowired
    ActivityRepository activityRepository;

    void toReadXMLService() throws IOException {

        try {

            File f = new File("src/repertoire.xml");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLineOfXML = "";
            String xmlTag = "";

            String trkptLatLonBegin = "<trkpt ";
            String trkptLatLonEnd = ">";

            float latitude=0;
            String extractLatBegin = "lat=\"";
            String extractLatEnd = "\"";
            int posLat = 0;

            float longitude=0;
            String extractLonBegin = "lon=\"";
            String extractLonEnd = "\"";
            int posLon = 1;

            float elevation=0;
            String trkptEleBegin = "<ele>";
            String trkptEleEnd = "</ele>";

            float hearthrate=0;
            String trkptHrBegin = "<gpxtpx:hr>";
            String trkptHrEnd = "</gpxtpx:hr>";

            String timezone="";
            String trkptTimeBegin = "<time>";
            String trkptTimeEnd = "</time>";

            String trkptEnd = "</trkpt>";

            String extractLonLat = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLineOfXML = b.readLine()) != null) {

                xmlTag=readLineOfXML.trim();

                if (xmlTag.startsWith(trkptLatLonBegin)) {
                    extractLonLat = getMappedXML(xmlTag, trkptLatLonBegin, trkptLatLonEnd);
                    //  System.out.println("words : " + extractLonLat.split(" ")[0]);
                    //  System.out.println(getMappedXML(extractLonLat.split(" ")[posLat], extractLatBegin, extractLatEnd));
                    //  System.out.println(getMappedXML(extractLonLat.split(" ")[posLon], extractLonBegin, extractLonEnd));
                    //  System.out.println(xmlTag.substring(12,21));
                    //  latitude = Float.parseFloat(xmlTag.substring(12,21));
                    latitude = Float.parseFloat(getMappedXML(extractLonLat.split(" ")[posLat], extractLatBegin, extractLatEnd));
                    // longitude = Float.parseFloat(xmlTag.substring(29,37));
                    longitude = Float.parseFloat(getMappedXML(extractLonLat.split(" ")[posLon], extractLonBegin, extractLonEnd));

                    System.out.println(latitude);
                    System.out.println(longitude);
                }
                if (xmlTag.startsWith(trkptEleBegin)) {
                    //    words = getMappedXML(xmlTag,"<ele>","</ele>");
                    //    System.out.println(words);
                    //     elevation = Float.parseFloat(xmlTag.substring(5,9));
                    elevation = Float.parseFloat(getMappedXML(xmlTag, trkptEleBegin, trkptEleEnd));
                    System.out.println(elevation);
                }
                if (xmlTag.startsWith(trkptTimeBegin)) {
                    //   timezone = xmlTag.substring(6,25);
                    timezone = getMappedXML(xmlTag, trkptTimeBegin, trkptTimeEnd);
                    System.out.println(timezone);
                }
                if (xmlTag.startsWith(trkptHrBegin)) {
                    //    System.out.println(xmlTag.substring(11,14));
                    //    System.out.println(xmlTag.substring(13,14));
                    //    if (xmlTag.substring(13,14).equals("<")) {
                    //        hearthrate = Float.parseFloat(xmlTag.substring(11,13));
                    //    } else {
                    //        hearthrate = Float.parseFloat(xmlTag.substring(11, 14));
                    //    }
                    //    System.out.println("hearthrate : " + hearthrate);
                    hearthrate = Float.parseFloat(getMappedXML(xmlTag,trkptHrBegin,trkptHrEnd));
                    System.out.println("hearthrate 2 : " + hearthrate);

                }
                if (xmlTag.startsWith(trkptEnd)) {
                //    System.out.println("Activity : " +  latitude + " ; "+ longitude + " ; "+ elevation + " ; "
                //            + hearthrate + " ; " + timezone);
                    Activity  activity = new Activity(null, latitude, longitude, elevation, hearthrate, timezone);
                    this.activityRepository.save(activity);
                    System.out.println("Activity" + activity);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String getMappedXML(String res, String xml_begin, String xml_end) {
        return res.replace(xml_begin,"").replace(xml_end,"");
    }

}


