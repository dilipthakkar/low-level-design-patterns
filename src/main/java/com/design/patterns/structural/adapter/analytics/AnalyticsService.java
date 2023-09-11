package com.design.patterns.structural.adapter.analytics;

import java.util.List;

import com.design.patterns.structural.adapter.models.JsonData;

/**
 * The AnalyticsService interface defines a contract for classes that perform analytics operations
 * on data, particularly focusing on extracting data points from JSON data.
 */

public interface AnalyticsService {
    
    // List<String> extractDataPoints(XMLData data);

    /**
     * Extracts data points from JSON data.
     *
     * @param data The JSON data from which data points will be extracted.
     * @return A list of strings representing extracted data points.
     */
    List<String> extractDataPoints(JsonData data);

}
