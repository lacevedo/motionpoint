/**
 * @(#)DictionaryNotAvailableException.java        1.0  08/24/2020
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

package org.luis.api.service.exception;

/**
 * Exception throun when a combination of language from-to does not have a concrete implementation.
 * @version 1.0
 */
public class DictionaryNotAvailableException extends RuntimeException {
    /**
     * DictionaryNotAvailableException constructor.
     * @param errorMessage The Exception error message.
     */
    public DictionaryNotAvailableException(String errorMessage) {
        super(errorMessage);
    }

}
