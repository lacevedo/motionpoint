/**
 * @(#)TranslateRequestDao.java        1.0  08/24/2020
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


package org.luis.api.data;

import org.luis.api.domain.TranslateRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * TranslateRequest concrete Dao.
 * @version 1.0
 */
public class TranslateRequestDao implements Dao<TranslateRequest> {

    /**
     * This static list represents the repository of all translation requests made.
     */
    private static List<TranslateRequest> translationRequests=new ArrayList<TranslateRequest>();

    @Override
    public List<TranslateRequest> findAll() {
        return translationRequests;
    }


    @Override
    public void add(TranslateRequest t) {
        translationRequests.add(t);
    }

    @Override
    public void deleteAll() {
        translationRequests.clear();
    }
}
