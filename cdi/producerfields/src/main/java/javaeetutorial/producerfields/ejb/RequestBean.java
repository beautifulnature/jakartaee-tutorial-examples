/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package javaeetutorial.producerfields.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javaeetutorial.producerfields.db.UserDatabase;
import javaeetutorial.producerfields.entity.ToDo;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ConversationScoped
@Stateful
public class RequestBean {

    @Inject
    @UserDatabase
    EntityManager em;

    public ToDo createToDo(String inputString) {
        ToDo toDo;
        Date currentTime = Calendar.getInstance().getTime();

        try {
            toDo = new ToDo();
            toDo.setTaskText(inputString);
            toDo.setTimeCreated(currentTime);
            em.persist(toDo);
            return toDo;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<ToDo> getToDos() {
        try {
            List<ToDo> toDos =
                    (List<ToDo>) em.createQuery(
                    "SELECT t FROM ToDo t ORDER BY t.timeCreated")
                    .getResultList();
            return toDos;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
