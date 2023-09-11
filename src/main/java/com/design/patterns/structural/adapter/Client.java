package com.design.patterns.structural.adapter;

import java.util.List;

import com.design.patterns.structural.adapter.analytics.AnalyticsService;
import com.design.patterns.structural.adapter.analytics.AnalyticsServiceImpl;
import com.design.patterns.structural.adapter.models.VideoContent;
import com.design.patterns.structural.adapter.models.XMLData;
import com.design.patterns.structural.adapter.video.VideoService;
import com.design.patterns.structural.adapter.video.VideoServiceImpl;
import com.design.patterns.structural.adapter.youtube.YoutubeService;
import com.design.patterns.structural.adapter.youtube.YoutubeServiceImpl;

/**
 * The Client class demonstrates the usage of the Adapter Pattern to integrate
 * the YouTube-specific analytics library with existing services.
 */
public class Client {
    public static void main(String[] args) {
        /**
         * Old code that stops working after upgrading Analytics library
         */
        // AnalyticsService analyticsService = new AnalyticsServiceImpl();
        // YoutubeService youtubeService = new YoutubeServiceImpl();
        // VideoService videoService = new VideoServiceImpl();

        // // find video by id from our internal video service.
        // VideoContent video = videoService.getVideoById(1);

        // // get xmlData from the video content using youtube service.
        // XMLData xmlData = youtubeService.getXMLData(video);

        // // extract data points from the xml data using analytics library 1.x
        // List<String> dataPoints = analyticsService.extractDataPoints(xmlData);


        /**
         * new code with adapter pattern
         */
        AnalyticsYoutubeObjectAdapter analyticsService = new AnalyticsYoutubeObjectAdapter();
        YoutubeService youtubeService = new YoutubeServiceImpl();
        VideoService videoService = new VideoServiceImpl();

        // find video by id from our internal video service.
        VideoContent video = videoService.getVideoById(1);

        // get xmlData from the video content using youtube service.
        XMLData xmlData = youtubeService.getXMLData(video);

        // extract data points from the xml data using analytics library 1.x
        List<String> dataPoints = analyticsService.extractDataPoints(xmlData);

    }

}
