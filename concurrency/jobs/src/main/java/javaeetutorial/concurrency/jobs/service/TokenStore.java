/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.concurrency.jobs.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * @author markito
 */
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class TokenStore implements Serializable {

    private final List<String> store;

    public TokenStore() {
        this.store = new ArrayList<>();
    }

    @Lock(LockType.WRITE)
    public void put(String key) {
        store.add(key);
    }

    @Lock(LockType.READ)
    public boolean isValid(String key) {
        return store.contains(key);
    }
}
