/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.asynchconsumer;

import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * The TextListener class implements the MessageListener interface by defining
 * an onMessage method that displays the contents of a TextMessage.
 *
 * This class acts as the listener for the AsynchConsumer class.
 */
public class TextListener implements MessageListener {

    /**
     * Displays the message text.
     *
     * @param message the incoming message
     */
    @Override
    public void onMessage(Message m) {
        try {
            if (m instanceof TextMessage) {
                System.out.println(
                        "Reading message: " + m.getBody(String.class));
            } else {
                System.out.println("Message is not a TextMessage");
            }
        } catch (JMSException | JMSRuntimeException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        }
    }
}
