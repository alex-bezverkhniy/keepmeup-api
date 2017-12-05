package com.alexbeez.keepmeup.keepmeupapi.controllers

import com.alexbeez.keepmeup.keepmeupapi.domain.Screenshot
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import sun.reflect.generics.reflectiveObjects.NotImplementedException

/**
 * Created by Alex Bezverkhniy on 12/5/17.
 */
@RestController
@RequestMapping("/screenshot")
class ScreenshotController {
    /**
     * Creates new screenshot of website (screenshot.siteUrl)
     * @param screenshot
     * @return screenshot object and status
     */
    @RequestMapping(method = RequestMethod.POST)
    Map<String, Object> create(Screenshot screenshot) {
        throw new NotImplementedException()
    }

    /**
     * Updates exist screenshot of website (screenshot.siteUrl)
     * @param screenshot
     * @return screenshot object and status
     */
    @RequestMapping(method = RequestMethod.PUT)
    Map<String, Object> update(Screenshot screenshot) {
        throw new NotImplementedException()
    }
}
