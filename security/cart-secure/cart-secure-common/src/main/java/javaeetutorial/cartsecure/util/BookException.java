/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.cartsecure.util;

public class BookException extends Exception {
    private static final long serialVersionUID = 6274585742564840905L;
    public BookException() {
    }

    public BookException(String msg) {
        super(msg);
    }
}
