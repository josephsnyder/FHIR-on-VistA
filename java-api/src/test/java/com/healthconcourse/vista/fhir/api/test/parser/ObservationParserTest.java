/* Created by Perspecta http://www.perspecta.com */
/*
(c) 2017-2019 Perspecta

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.healthconcourse.vista.fhir.api.test.parser;

import com.healthconcourse.vista.fhir.api.parser.ObservationParser;
import org.hl7.fhir.dstu3.model.Observation;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ObservationParserTest {

    @Test
    public void TestInvalidVitalsObservationParse () {
        String input = "ThisIsNotDataFromVista";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseVitalsList(input);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void TestEmptyVitalsObservationParse () {
        String input = "";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseVitalsList(input);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void TestSuccesfulVitalsObservationParse() {
        String input = "5000001534V744140^27113001|Body weight|144|20140630|442V29141^27113001|Body weight|145|20141125|442V29148^27113001|Body weight|151|2 0141229|442V29154^27113001|Body weight|143|20150107|442V29164^27113001|Body weight|149|20150630|442V29317^27113001|Body weight|145|2 0150706|442V29325^27113001|Body weight|142|20150810|442V29392^50373000|Body height|62|20140630|442V29142^50373000|Body height|62|201 50706|442V29323^75367002|Blood pressure|128/70|20140630|442V29137^75367002|Blood pressure|120/66|20141125|442V29143^75367002|Blood p ressure|123/71|20141229|442V29149^75367002|Blood pressure|115/64|20141229|442V29155^75367002|Blood pressure|107/58|20150107|442V2915 9^75367002|Blood pressure|115/70|20150630|442V29311^75367002|Blood pressure|103/62|20150706|442V29318^75367002|Blood pressure|118/66 |20150810|442V29386^78564009|Pulse rate|57|20140630|442V29138^78564009|Pulse rate|56|20141125|442V29144^78564009|Pulse rate|62|20141 229|442V29150^78564009|Pulse rate|59|20141229|442V29156^78564009|Pulse rate|63|20150107|442V29160^78564009|Pulse rate|63|20150630|44 2V29312^78564009|Pulse rate|65|20150706|442V29319^78564009|Pulse rate|62|20150810|442V29387^86290005|Respiration|14|20140630|442V291 40^86290005|Respiration|14|20141125|442V29147^86290005|Respiration|19|20141229|442V29153^86290005|Respiration|13|20141229|442V29158^ 86290005|Respiration|14|20150107|442V29163^86290005|Respiration|17|20150630|442V29315^86290005|Respiration|15|20150706|442V29320^862 90005|Respiration|12|20150810|442V29390^386725007|Body Temperature|98.9|20140630|442V29139^386725007|Body Temperature|97.8|20141125| 442V29146^386725007|Body Temperature|98.8|20141229|442V29152^386725007|Body Temperature|98.4|20150107|442V29162^386725007|Body Tempe rature|98.6|20150630|442V29314^386725007|Body Temperature|98.1|20150706|442V29321^386725007|Body Temperature|98.7|20150810|442V29389";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseVitalsList(input);

        Assert.assertEquals("Correct number of items", 40, result.size());
    }

    @Test
    public void TestInvalidLabsObservationParse () {

        String input = "ThisIsNotDataFromVista";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseLabsList(input);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void TestSuccesfulLabsObservationParse() {
        String input = "5000001533V676621^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|70|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|139|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|162|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|1|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|3.06|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|60|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|35|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.051|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.357|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|1.428|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|8|20150720083902-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|2.9|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|5.1|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|34.2|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|231|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7.9|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|4|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|25|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|92|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|12.6|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|0.204|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|1.9|20150720083902-0500|44263673^5901-4|COAGULATION TISSUE FACTOR INDUCED:TIME:PT:PPP~CONTROL:QN:COAG|7.1|20150720083903-0500|44263673";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseLabsList(input);

        Assert.assertEquals("Correct number of items", 24, result.size());
    }

    @Test
    public void TestSuccesfulLabsObservationParseAllDatesPresent() {
        String input = "5000001533V676621^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|70|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|139|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|162|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|1|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|3.06|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|60|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|35|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.051|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.357|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|1.428|201311190927-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|8|20150720083902-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|2.9|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|5.1|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|34.2|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|231|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7.9|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|4|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|25|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|92|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|12.6|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|0.204|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|1.9|20150720083902-0500|44263673^5901-4|COAGULATION TISSUE FACTOR INDUCED:TIME:PT:PPP~CONTROL:QN:COAG|7.1|20150720083903-0500|44263673";

        boolean found = testObservationDates(input);

        Assert.assertEquals("All dates present", true, found);
    }

    private boolean testObservationDates(String input) {
        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseLabsList(input);

        boolean found = true;

        for(Observation item : result) {
            if (item.getEffective() == null) {
                found = false;
            }
        }
        return found;
    }

    @Test
    public void TestSuccesfulLabsObservationParseBadDate() {
        String input = "5000001533V676621^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|70|20150what83901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|139|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|162|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|1|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|3.06|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|60|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|35|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.051|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.357|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|1.428|201311190927-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|8|20150720083902-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|2.9|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|5.1|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|34.2|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|231|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7.9|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|4|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|25|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|92|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|12.6|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|0.204|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|1.9|20150720083902-0500|44263673^5901-4|COAGULATION TISSUE FACTOR INDUCED:TIME:PT:PPP~CONTROL:QN:COAG|7.1|20150720083903-0500|44263673";

        boolean found = testObservationDates(input);

        Assert.assertEquals("All dates not present", false, found);
    }

    @Test
    public void TestLabsObservationParseBadDate() {
        String input = "5000001533V676621^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|70|NOTADATE|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|139|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|162|20150720083901-0500|44263673^2000-8|CALCIUM:SCNC:PT:SER/PLAS:QN|1|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|3.06|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|60|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|35|20150720083901-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.051|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|0.357|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|1.428|20131119092704-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|8|20150720083902-0500|44263673^2093-3|CHOLESTEROL:MCNC:PT:SER/PLAS:QN|2.9|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|5.1|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|34.2|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|231|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7.9|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|7|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|4|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|25|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|92|20150720083901-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|12.6|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|0.204|20131119092704-0500|44263673^2350-7|GLUCOSE:MCNC:PT:UR:QN|1.9|20150720083902-0500|44263673^5901-4|COAGULATION TISSUE FACTOR INDUCED:TIME:PT:PPP~CONTROL:QN:COAG|7.1|20150720083903-0500|44263673";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseLabsList(input);

        Assert.assertEquals("Correct number of items", 24, result.size());
    }

    @Test
    public void TestSuccesfulMentalHealthObservationParse() {
        String input = "5000000352V586511^44249-1|PHQ9 Result|715252007|PHQ9 Result|PHQ9|201411121444-0500|PRIMARY CARE TELEPHONE|PROVIDER,SIX|Total:4|V_500_601.84_100012^44249-1|PHQ9 Result|715252007|PHQ9 Result|PHQ9|201410081626-0500|PRIMARY CARE TELEPHONE|PROVIDER,SIX|Total:5|V_500_601.84_100011^|PCLC Result||PCLC Result|PCLC|201409101449-0500|MENTAL HEALTH|PROVIDER,THIRTYNINE|Total:52|V_500_601.84_100016^|AUDC Result||AUDC Result|AUDC|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Total:8|V_500_601.84_100009^71754-6|PC PTSD Result||PC PTSD Result|PC PTSD|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Total:3|V_500_601.84_100010^55758-7|PHQ-2 Result|454711000124102|PHQ-2 Result|PHQ-2|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Depression:4|V_500_601.84_100007^44249-1|PHQ9 Result|715252007|PHQ9 Result|PHQ9|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Total:7|V_500_601.84_100008^|GAF||GAF|Global Assessment of Functioning|20140910||PROVIDER,SEVEN|GAF Scale:65|V_500_627.8_172";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseMentalHealthList(input);

        Assert.assertEquals("Correct number of items", 8, result.size());
    }

    @Test
    public void TestSuccesfulMentalHealthObservationParseBadDate() {
        String input = "5000000352V586511^44249-1|PHQ9 Result|715252007|PHQ9 Result|PHQ9|NOTADATE|PRIMARY CARE TELEPHONE|PROVIDER,SIX|Total:4|V_500_601.84_100012^44249-1|PHQ9 Result|715252007|PHQ9 Result|PHQ9|201410081626-0500|PRIMARY CARE TELEPHONE|PROVIDER,SIX|Total:5|V_500_601.84_100011^|PCLC Result||PCLC Result|PCLC|201409101449-0500|MENTAL HEALTH|PROVIDER,THIRTYNINE|Total:52|V_500_601.84_100016^|AUDC Result||AUDC Result|AUDC|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Total:8|V_500_601.84_100009^71754-6|PC PTSD Result||PC PTSD Result|PC PTSD|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Total:3|V_500_601.84_100010^55758-7|PHQ-2 Result|454711000124102|PHQ-2 Result|PHQ-2|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Depression:4|V_500_601.84_100007^44249-1|PHQ9 Result|715252007|PHQ9 Result|PHQ9|201408311400-0500|PRIMARY CARE|PROVIDER,SEVEN|Total:7|V_500_601.84_100008^|GAF||GAF|Global Assessment of Functioning|20140910||PROVIDER,SEVEN|GAF Scale:65|V_500_627.8_172";

        ObservationParser parser = new ObservationParser();

        List<Observation> result = parser.parseMentalHealthList(input);

        Assert.assertEquals("Correct number of items", 8, result.size());

        Assert.assertNull(result.get(0).getEffective());
    }
}
