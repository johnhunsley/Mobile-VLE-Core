package com.mobilevle.core;

/**
 * <p></p>
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
 *         Date: 10-Nov-2010
 *         Time: 12:35:22
 */
public class InvalidSessionException extends MobileVLECoreException {

    /**
     *
     */
    public InvalidSessionException() {
        super("Invalid session");
    }

    /**
     * 
     * @param cause
     */
    public InvalidSessionException(Throwable cause) {
        super(cause);
    }
}
