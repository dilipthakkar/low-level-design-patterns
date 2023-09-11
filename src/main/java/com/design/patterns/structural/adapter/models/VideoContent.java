package com.design.patterns.structural.adapter.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data object that represents a Video and its related content.
 */
@Data
@AllArgsConstructor
public class VideoContent {
    private String content;
}
