/**
 * The VideoService interface defines a contract for classes that provide access to video content.
 * Implementing classes are expected to retrieve video content based on a unique identifier.
 */
package com.design.patterns.structural.adapter.video;

import com.design.patterns.structural.adapter.models.VideoContent;

public interface VideoService {

    /**
     * Retrieves video content by its unique identifier.
     *
     * @param id The unique identifier of the video content.
     * @return The VideoContent object associated with the provided identifier, or null if not found.
     */
    VideoContent getVideoById(Integer id);
}
