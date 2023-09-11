package com.design.patterns.structural.adapter;

import java.util.List;

import com.design.patterns.structural.adapter.analytics.AnalyticsServiceImpl;
import com.design.patterns.structural.adapter.models.JsonData;
import com.design.patterns.structural.adapter.models.XMLData;

/**
 * The AnalyticsYoutubeClassAdapter class is an adapter that extends AnalyticsServiceImpl
 * to adapt the XML data processing capabilities to work with YouTube-specific XML data.
 * It implements an adapter with the class adapter design pattern which follows inheritance principle.
 */
public class AnalyticsYoutubeClassAdapter extends AnalyticsServiceImpl{
    
    /**
     * Extracts data points from XML data specific to YouTube.
     *
     * @param xmlData The YouTube-specific XML data from which data points will be extracted.
     * @return A list of strings representing extracted data points.
     */
    public List<String> extractDataPoints(XMLData xmlData){
        JsonData jsonData = this.convertXmlToJson(xmlData);
        return super.extractDataPoints(jsonData);
    }

    /**
     * Converts YouTube-specific XML data to JSON data.
     *
     * @param xmlData The YouTube-specific XML data to be converted.
     * @return A JsonData object containing the converted data.
     */
    private JsonData convertXmlToJson(XMLData xmlData){
        return new JsonData(xmlData.getData());
    }
}
