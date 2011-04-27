package com.mobilevle.core;

import java.util.Hashtable;
import java.util.Map;

/**
 * <p>Factory for accessing the {@link VLEHandler} implementation</p>
 *
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
 *
 * @author johnhunsley
 *         Date: 09-Nov-2010
 *         Time: 13:53:22
 */
public class VLEHandlerFactory {
    private static VLEHandlerFactory thisInstance;
    private Hashtable<String, VLEHandler> handlers;

    /**
     *
     */
    private VLEHandlerFactory() {
        handlers = new Hashtable<String, VLEHandler>();
    }

    /**
     *
     * @return VLEHandlerFactory
     */
    public static VLEHandlerFactory getInstance() {
        if(thisInstance == null) thisInstance = new VLEHandlerFactory();

        return thisInstance;
    }


    /**
     * <p>Returns a {@link VLEHandler} object for the given label. If the object is not present then
     * returns the default implementation</p>
     * @param name
     * @param params
     * @return the {@link VLEHandler} with the given label or if not present the default object
     * @throws MobileVLECoreException  if the requested object or default implementation is not present in the factory
     */
    public VLEHandler getVLEHandler(final String name, final Map<String, String> params) throws MobileVLECoreException {
        VLEHandler handler = handlers.get(name);

        if(handler == null) {
            
            try {
                Class.forName(name);
                handler = handlers.get(name);
                handler.setParams(params);

            } catch (ClassNotFoundException e) {
                throw new MobileVLECoreException(e);
            }
        }

        if(handler == null)
            throw new MobileVLECoreException("No handler for label - "+name+" or default handler available");

        return handler;
    }


    /**
     * <p>Add the {@link VLEHandler} to the factory against its unique label</p>
     * @param handler
     * @throws MobileVLECoreException if {@link VLEHandler} already exists with the same label
     */
    public void addVLEHandler(final VLEHandler handler) throws MobileVLECoreException {
        String name = handler.getClass().getName();

        //if a handler alreasdy exists throw and exception
        if(handlers.get(name) != null)
            throw new MobileVLECoreException("A handler of type - "+name+" already exists!");

        handlers.put(name, handler);
    }
}
