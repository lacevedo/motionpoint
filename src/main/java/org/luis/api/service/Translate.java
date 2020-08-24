/**
 * @(#)Translate.java        1.0  08/24/2020
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

package org.luis.api.service;

import org.luis.api.domain.User;
import org.luis.api.service.exception.DictionaryNotAvailableException;
import org.luis.api.util.Language;

/**
 * Interface Translate exposes the method translate, an overloaded version to translate by batch,
 * and also exposes method setLoggedUser to update the repository with the user that submitted the request.
 * @version 1.0
 */

public interface Translate {

    /**
     * Translates a String text from a given Language to another Language using Yahoo Translate.
     *
     * @param text The String to translate.
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @throws DictionaryNotAvailableException on error.
     */

    void translate(final String text, final Language from, final Language to) throws DictionaryNotAvailableException;

    /**
     * Translates a String array of texts from a given Language to another Language using Yahoo Translate.
     *
     * @param text The Array of String to translate in Batch.
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @throws DictionaryNotAvailableException on error.
     */

    void translate(final String[] text, final Language from, final Language to) throws DictionaryNotAvailableException;

    /**
     * Set the registered user that sent a valid registration key to the api.
     *
     * @param user The User object.
     */
    void setLoggedUser(User user);



}
