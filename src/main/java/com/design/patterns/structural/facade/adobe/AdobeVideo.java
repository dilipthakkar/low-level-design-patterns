package com.design.patterns.structural.facade.adobe;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class provides implementation of Adobe video files 
 */
@AllArgsConstructor
@Getter
public class AdobeVideo {
    private VideoType type;
    private String content;
}
