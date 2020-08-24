/**
 * @(#)Dao.java        1.0  08/24/2020
 *
 * Copyright (C) 2020,  Luis Acevedo
 *
 * This file is part of luis-api-translate.
 *
 * luis-api-translate is a free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation
 *
 * There is not liability or WARRANTY for the use of this code.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with luis-api-translate. If not, see <http://www.luis.org/licenses/>.
 */

package org.luis.api.data;

import org.luis.api.service.exception.DictionaryNotAvailableException;

import java.util.List;

/**
 * Represents a Data Transfer Object with all it's crud operations.
 * @param <T> of type T
 * @author Luis Acevedo
 */
public interface Dao<T> {
    /**
     * Crud operation find all objects of type T from repository.
     * @return List of T  Returns a list of all objects of type T from the repository.
     */
    List<T> findAll();

    /**
     * Crud operation add to repository.
     * @param t of type T
     */
    void add(T t);

    /**
     * Crud operation delete all from repository.
     */
    void deleteAll();
    //void update(T t);

}
