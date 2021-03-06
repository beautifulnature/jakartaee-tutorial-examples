/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.helloservice.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * HelloServiceBean is a web service endpoint implemented as a stateless
 * session bean.
 */

@Stateless
@WebService
public class HelloServiceBean {
    private final String message = "Hello, ";
    
    public void HelloServiceBean() {}
    
    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
