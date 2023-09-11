package com.design.patterns.structural.adapter.video;

import com.design.patterns.structural.adapter.models.VideoContent;

/**
 * The VideoServiceImpl class implements the VideoService interface and provides a basic implementation
 * for retrieving video content based on a unique identifier.
 */
public class VideoServiceImpl implements VideoService{

    @Override
    public VideoContent getVideoById(Integer id) {
        return new VideoContent(id.toString());
    }
    
}
