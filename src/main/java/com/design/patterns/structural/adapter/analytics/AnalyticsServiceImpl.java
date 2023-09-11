package com.design.patterns.structural.adapter.analytics;

import java.util.Arrays;
import java.util.List;

import com.design.patterns.structural.adapter.models.JsonData;

/**
 * An implementation class for the analytics service.
 */
public class AnalyticsServiceImpl implements AnalyticsService{

    @Override
    public List<String> extractDataPoints(JsonData jsonData) {
        return Arrays.asList(jsonData.getData());
    }
    
}
