package com.alexbeez.keepmeup.keepmeupapi.controllers

import com.alexbeez.keepmeup.keepmeupapi.domain.Thumbnail
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import sun.reflect.generics.reflectiveObjects.NotImplementedException

/**
 * Created by Alex Bezverkhniy on 12/5/17.
 */
@RestController
@RequestMapping("/thumbnail")
class ThumbnailController {
    /**
     * Creates new thumbnail based on rectangle and parent screenshot.
     * Save new data into storage.
     * @param thumbnail
     * @return thumbnail object and status
     */
    @RequestMapping(method = RequestMethod.POST)
    Map<String, Object> create(Thumbnail thumbnail) {
        throw new NotImplementedException()
    }

    /**
     * Updates exist thumbnail based on rectangle and parent screenshot.
     * Save updated data into storage.
     * @param thumbnail
     * @return thumbnail object and status
     */
    @RequestMapping(method = RequestMethod.PUT)
    Map<String, Object> update(Thumbnail thumbnail) {
        throw new NotImplementedException()
    }

    /**
     * Compares two thumbnails (images)
     * @param oldThumbnail
     * @param newThumbnail
     * @return "true" if both identical, "false" if not
     */
    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    Map<String, Object> compare(Thumbnail oldThumbnail, Thumbnail newThumbnail) {
        throw new NotImplementedException()
    }
}
