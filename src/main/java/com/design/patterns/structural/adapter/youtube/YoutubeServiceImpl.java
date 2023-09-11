package com.design.patterns.structural.adapter.youtube;

import com.design.patterns.structural.adapter.models.VideoContent;
import com.design.patterns.structural.adapter.models.XMLData;

/**
 * An implementation class for the youtube serivce.
 */
public class YoutubeServiceImpl implements YoutubeService{

    @Override
    public XMLData getXMLData(VideoContent video) {
        return new XMLData(video.getContent());
    }
    
}
