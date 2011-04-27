package com.mobilevle.core.moodle;

import com.mobilevle.core.VLEHandler;
import com.mobilevle.core.InvalidSessionException;

import java.util.List;
import java.io.IOException;

/**
 * <p>Moodle Implementation of the {@link VLEHandler}</p>
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
 *         Date: 25-Nov-2010
 *         Time: 16:15:30
 */
public interface MoodleVLEHandler extends VLEHandler {

    /**
     *
     * @return
     * @throws com.mobilevle.core.InvalidSessionException
     */
    List<Course> getCourses() throws InvalidSessionException;

    /**
     * <p>find the {@link Activity} instances of any type for the given course id</p>
     * @param courseId
     * @return
     * @throws InvalidSessionException
     */
    List<Activity> getCourseActivities(int courseId) throws InvalidSessionException;

     /**
     * <p>Get the {@link Activity} implementations for the given course id as
     * defined by the given {@link ActivityType}</p>
     * @param courseId
     * @param activityType
     * @return list of {@link Activity} defined by the given {@link ActivityType}
     */
    List<Activity> getCourseActivityByType(int courseId,  ActivityType activityType) throws InvalidSessionException;

    /**
     * <p>
     * 
     * </p>
     * @param courseId
     * @return
     * @throws InvalidSessionException
     */
    List<User> getStudentsByCourse(int courseId) throws InvalidSessionException;

    /**
     * <p></p>
     * @param courseId
     * @return
     * @throws InvalidSessionException
     */
    List<User> getTeachersByCourse(int courseId) throws InvalidSessionException;

    /**
     * <p></p>
     * @param courseId
     * @return
     * @throws InvalidSessionException
     */
    List<User> getCourseUsers(final int courseId) throws InvalidSessionException;

    /**
     *
     * @return
     * @throws InvalidSessionException
     */
    List<Message> getNewMessages() throws InvalidSessionException, IOException;

    /**
     *
     * @param userId
     * @return
     * @throws InvalidSessionException
     */
    List<Message> getConversation(String userId) throws InvalidSessionException;

    /**
     * 
     * @param message
     * @return
     * @throws InvalidSessionException
     */
    boolean sendMessage(Message message) throws InvalidSessionException;

    /**
     * <p>Search for users based on the given field name with the given value</p>
     * @param field
     * @param value
     * @return
     * @throws InvalidSessionException
     */
    List<User> searchUsers(String field, String value) throws InvalidSessionException;

}
