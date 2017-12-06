package com.alexbeez.keepmeup.keepmeupapi.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.FirebaseDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Alex Bezverkhniy on 12/5/17.
 */
@Configuration
class DatabaseConfig {
    private static final SERVICE_ACCOUNT_FILE_PATH = "keepmeup-test-3365bf0899e9.json"
    private static final DB_URL = "https://keepmeup-53f95.firebaseio.com/"



    @Bean
    FirebaseDatabase firebaseDatabase() {
        // Use a service account
        InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream(SERVICE_ACCOUNT_FILE_PATH)

        if (!serviceAccount) return null

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(DB_URL)
                .build();

        FirebaseApp.initializeApp(options);

        return FirebaseDatabase.getInstance()
    }
}
