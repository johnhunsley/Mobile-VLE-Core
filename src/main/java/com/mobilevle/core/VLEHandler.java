package com.mobilevle.core;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * <p>VLE Handler for accessing generic VLE functions, implemented depending on which service is used to access the VLE</p>
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p>
 * @author johnhunsley
 *         Date: 08-Nov-2010
 *         Time: 23:47:16
 */
public interface VLEHandler {

    /**
     *  <p>Set the params for this implementation</p>
     * @param params
     */
    void setParams(Map<String, String> params);

    /**
     *
     * @param username
     * @param password
     * @param rememberPassword
     * @return
     * @throws InvalidSessionException
     */
    boolean authenticate(Context context, String username, String password, boolean rememberPassword) throws InvalidSessionException;
}
