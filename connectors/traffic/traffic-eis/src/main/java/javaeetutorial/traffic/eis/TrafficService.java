/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.traffic.eis;

import java.io.StringWriter;
import java.util.Random;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

public class TrafficService {
    
    private String[] cities = {
        "City1", "City2", "City3", "City4", "City5"
    };
    private String[] accessRoutes = {
        "AccessA", "AccessB", "AccessC", "AccessD", "AccessE"
    };
    private String[] statuses = {
        "GOOD", "SLOW", "CONGESTED"
    };
    private Random random;
    
    public TrafficService() { 
        random = new Random();
    }
    
    /* Return a line with a JSON report like this:
     * {"report":[ {"city":"city_i","access":"access_j","status":"status_k"}, ... ]} */
    public String getReport() {
        
        StringWriter swriter = new StringWriter();
        try (JsonGenerator gen = Json.createGenerator(swriter)) {
            gen.writeStartObject();
            gen.writeStartArray("report");
            for (String city : cities) {
                for (String accessRoute : accessRoutes) {
                    int i = random.nextInt(statuses.length);
                    gen.writeStartObject();
                    gen.write("city", city);
                    gen.write("access", accessRoute);
                    gen.write("status", statuses[i]);
                    gen.writeEnd();
                }
            }
            gen.writeEnd();
            gen.writeEnd();
        }
        return swriter.toString();
    }
}
