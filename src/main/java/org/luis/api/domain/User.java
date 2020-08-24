/**
 * @(#)User.java        1.0  08/24/2020
 *
 * Copyright (C) 2020,  Luis Acevedo
 *
 * This file is part of luis-api-translate.
 *
 * luis-api-translate is a free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation
 *
 * There is not liability or WARRANTY forthe use of this code.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with luis-api-translate. If not, see <http://www.luis.org/licenses/>.
 */

package org.luis.api.domain;

/**
 * the Logged user is persisted to the database this is the transfer object.
 * @version 1.0
 */
public class User {
    /**
     * Represents the id of the user.
     */
    private int id;

    /**
     * Represents the username of the User.
     */
    private String userName;

    /**
     * Getter.
     * @return id salary returns integer with the user id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     * @param pid id to set id
     */
    public void setId(int pid) {
        this.id = pid;
    }

    /**
     * Constructor for User object.
     * @param puserMame to intialize object.
     */
    public User(String puserMame){
        this.userName=puserMame;
    }

    /**
     * Getter.
     * @return  username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter.
     * @param puserMame Setter for the username.
     */
    public void setUserName(String puserMame) {
        this.userName = puserMame;
    }
}
