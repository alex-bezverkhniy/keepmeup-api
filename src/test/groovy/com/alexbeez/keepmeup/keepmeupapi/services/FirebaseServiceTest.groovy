package com.alexbeez.keepmeup.keepmeupapi.services

import com.alexbeez.keepmeup.keepmeupapi.KeepmeupApiApplication
import com.alexbeez.keepmeup.keepmeupapi.domain.Watcher
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.firebase.database.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import static junit.framework.Assert.assertNotNull
import static junit.framework.Assert.assertTrue

/**
 * Created by Alex Bezverkhniy on 12/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KeepmeupApiApplication.class)
class FirebaseServiceTest {

    @Autowired
    private FirebaseDatabase database

    @Autowired
    private ObjectMapper mapper

    @Autowired
    private FirebaseService firebaseService

    @Test
    void createTwoWatchers() {

        DatabaseReference watchersRef = database.getReference("watchers")

        assertNotNull(watchersRef)
        watchersRef.runTransaction(new Transaction.Handler() {
            @Override
            Transaction.Result doTransaction(MutableData currentData) {
                Watcher w = new Watcher(
                        title: "Sample",
                        description: "Sample Watcher",
                        createdAt: new Date(),
                        updatedAt: new Date(),
                        siteUrl: "https://www.google.com"
                )

                Map data = ['sample1': mapper.convertValue(w, Map)]
                currentData.setValue(data)

                currentData.child('sample2').setValue(mapper.convertValue(new Watcher(
                        title: "Sample",
                        description: "Sample Watcher",
                        createdAt: new Date(),
                        updatedAt: new Date(),
                        siteUrl: "https://www.google.com"
                ), Map))

                return currentData
            }

            @Override
            void onComplete(DatabaseError error, boolean committed, DataSnapshot currentData) {
                assertTrue(committed)
            }
        })


    }

    @Test
    void createTest() {
      firebaseService.create(database.getReference("watchers"), new Watcher(
              title: "Sample #N",
              description: "Sample Watcher",
              createdAt: new Date(),
              updatedAt: new Date(),
              siteUrl: "https://www.google.com"
      )).get()
    }
}
