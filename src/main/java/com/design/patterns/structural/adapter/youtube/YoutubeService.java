package com.design.patterns.structural.adapter.youtube;

import com.design.patterns.structural.adapter.models.VideoContent;
import com.design.patterns.structural.adapter.models.XMLData;

/**
 * The YoutubeService interface defines a contract for classes that provide access to YouTube-related data.
 */
public interface YoutubeService {

    /**
     * Retrieves XML data related to a video content.
     *
     * @param video The VideoContent object for which XML data is requested.
     * @return An XMLData object containing data related to the provided video content.
     */
    XMLData getXMLData(VideoContent video);
}
