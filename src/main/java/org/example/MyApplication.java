package org.example;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;

// mvn liberty:run

@ApplicationPath("/api")
public class MyApplication extends Application {
}
