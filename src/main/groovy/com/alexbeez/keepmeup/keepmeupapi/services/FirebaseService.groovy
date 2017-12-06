package com.alexbeez.keepmeup.keepmeupapi.services

import com.alexbeez.keepmeup.keepmeupapi.domain.Metadata
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.command.AsyncResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.concurrent.Future

/**
 * Created by Alex Bezverkhniy on 12/5/17.
 */
@Service
class FirebaseService {
    @Autowired
    private FirebaseDatabase database

    @Autowired
    private ObjectMapper mapper

    @HystrixCommand(groupKey="firebase", commandKey = "create")
    Future<Metadata> create(DatabaseReference ref, Metadata data) {
        return new AsyncResult<Object>() {
            @Override
            public Object invoke() {
                if (!data) throw new IllegalArgumentException("data should not be null")
                if (!ref) throw new IllegalArgumentException("ref should not be null")

                DatabaseReference pushedRef = ref.push()
                if (pushedRef) {
                    data.key = pushedRef.key
                    pushedRef.setValueAsync(mapper.convertValue(data, Map)).get()
                }
                return data
            }
        }
    }
}
