package com.alexbeez.keepmeup.keepmeupapi.services

import org.springframework.stereotype.Service
import sun.reflect.generics.reflectiveObjects.NotImplementedException

/**
 * Created by Alex Bezverkhniy on 12/5/17.
 */
@Service
class SeleniumService {

    /**
     * Create site screenshot
     * @param url - site url
     * @return path to image file
     */
    String createScreenshot(String url) {
        throw new NotImplementedException()
    }
}
