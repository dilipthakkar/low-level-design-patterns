package com.design.patterns.structural.adapter;

import java.util.List;

import com.design.patterns.structural.adapter.analytics.AnalyticsService;
import com.design.patterns.structural.adapter.analytics.AnalyticsServiceImpl;
import com.design.patterns.structural.adapter.models.JsonData;
import com.design.patterns.structural.adapter.models.XMLData;

/**
 * This class represents an adapter between Analytics Service and YouTube service.
 * It implements an Object adapter which works on the composition principle.
 */
public class AnalyticsYoutubeObjectAdapter {

    /**
     * Object of the Analytics Service.
     */
    AnalyticsService analyticsService;

    public AnalyticsYoutubeObjectAdapter(){
        this.analyticsService = new AnalyticsServiceImpl();
    }
    
    /**
     * Extracts data points from XML data specific to YouTube.
     *
     * @param xmlData The YouTube-specific XML data from which data points will be extracted.
     * @return A list of strings representing extracted data points.
     */
    public List<String> extractDataPoints(XMLData xmlData){
        JsonData jsonData = this.convertXmlToJson(xmlData);
        return this.analyticsService.extractDataPoints(jsonData);
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
