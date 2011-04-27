package com.mobilevle.core.moodle;

import com.mobilevle.core.InvalidSessionException;
import com.mobilevle.core.VLEHandlerFactory;
import com.mobilevle.core.MobileVLECoreException;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;

import android.content.Context;

/**
 * <p></p>
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
 *         Date: 17-Dec-2010
 *         Time: 11:19:23
 */
public class MockMoodleVLEHandlerImpl implements MoodleVLEHandler {

    /**
     * <p>Add an instance of this class to the {@link com.mobilevle.core.VLEHandlerFactory}</p>
     */
    static {
        VLEHandlerFactory factory = VLEHandlerFactory.getInstance();

        try {
            factory.addVLEHandler(new MockMoodleVLEHandlerImpl());

        } catch (MobileVLECoreException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 
     * @return
     * @throws InvalidSessionException
     */
    public List<Course> getCourses() throws InvalidSessionException {
        List<Course> courses = new ArrayList<Course>();
        Course course = new Course();
        course.setId(1);
        course.setCourseId("PH1");
        course.setName("Physics");
        courses.add(course);

        Course course1 = new Course();
        course1.setId(2);
        course1.setCourseId("CH1");
        course1.setName("Chemistry");
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(3);
        course2.setCourseId("BI1");
        course2.setName("Biology");
        courses.add(course2);

        return courses;
    }

    /**
     *
     * @param courseId
     * @return
     * @throws InvalidSessionException
     */
    public List<Activity> getCourseActivities(int courseId) throws InvalidSessionException {
        List<Activity> activities = new ArrayList<Activity>();
        activities.addAll(createForums(courseId));
        activities.addAll(createQuiz(courseId));
        activities.addAll(createQuiz(courseId));
        activities.addAll(createWikis(courseId));
        return activities;
    }

    /**
     *
     * @param courseId
     * @param activityType
     * @return
     * @throws InvalidSessionException
     */
    public List<Activity> getCourseActivityByType(int courseId, ActivityType activityType) throws InvalidSessionException {
        List<Activity> activities = new ArrayList<Activity>();

        if(activityType.label.equalsIgnoreCase(ActivityType.FORUM.label)) activities.addAll(createForums(courseId));

        if(activityType.label.equalsIgnoreCase(ActivityType.LESSON.label)) activities.addAll(createLessons(courseId));

        if(activityType.label.equalsIgnoreCase(ActivityType.QUIZ.label)) activities.addAll(createQuiz(courseId));

        if(activityType.label.equalsIgnoreCase(ActivityType.WIKI.label)) activities.addAll(createWikis(courseId));

        return activities;

    }

    /**
     * 
     * @param courseId
     * @return
     * @throws InvalidSessionException
     */
    public List<User> getStudentsByCourse(int courseId) throws InvalidSessionException {
        return null;
    }

    public List<User> getTeachersByCourse(int courseId) throws InvalidSessionException {
        return null;
    }

    public List<User> getCourseUsers(int courseId) throws InvalidSessionException {
        return null;
    }

    public List<Message> getNewMessages() throws InvalidSessionException {
        return null;
    }

    public List<Message> getConversation(String userId) throws InvalidSessionException {
        return null;
    }

    public boolean sendMessage(Message message) throws InvalidSessionException {
        return false;
    }

    public List<User> searchUsers(String field, String value) throws InvalidSessionException {
        return null;
    }

    /**
     *
     * @return
     */
    private Collection<Lesson> createLessons(final int courseId) {
        Collection<Lesson> lessons = new ArrayList<Lesson>();

        Lesson lesson1 = new Lesson();
        lesson1.setCourseId(courseId);
        lesson1.setName("Lesson1");
        lesson1.setVisible(true);
        lesson1.setId(1);
        lesson1.setSummary("A Mock Lesson in course "+courseId);
        lessons.add(lesson1);

        Lesson lesson2 = new Lesson();
        lesson2.setCourseId(courseId);
        lesson2.setName("Lesson2");
        lesson2.setVisible(true);
        lesson2.setId(2);
        lesson2.setSummary("A Mock Lesson in course "+courseId);
        lessons.add(lesson2);

        Lesson lesson3 = new Lesson();
        lesson3.setCourseId(courseId);
        lesson3.setName("Lesson3");
        lesson3.setVisible(true);
        lesson3.setId(3);
        lesson3.setSummary("A Mock Lesson in course "+courseId);
        lessons.add(lesson3);

        return lessons;
    }

    /**
     *
     * @return
     */
    private Collection<Forum> createForums(final int courseId) {
        Collection<Forum> forums = new ArrayList<Forum>();

        Forum forum1 = new Forum();
        forum1.setCourseId(courseId);
        forum1.setName("Forum1");
        forum1.setVisible(true);
        forum1.setId(4);
        forum1.setSummary("A Mock Forum in course "+courseId);
        forums.add(forum1);


        return forums;

    }


    /**
     *
     * @return
     */
    private Collection<Quiz> createQuiz(final int courseId) {
        Collection<Quiz> quizzes = new ArrayList<Quiz>();

        Quiz quiz1 = new Quiz();
        quiz1.setCourseId(courseId);
        quiz1.setName("Quiz1");
        quiz1.setVisible(true);
        quiz1.setId(5);
        quiz1.setSummary("A Mock Quiz in course "+courseId);
        quizzes.add(quiz1);


        return quizzes;
    }

     /**
     *
     * @return
     */
    private Collection<Wiki> createWikis(final int courseId) {
        Collection<Wiki> wikis = new ArrayList<Wiki>();

        Wiki wiki1 = new Wiki();
        wiki1.setCourseId(courseId);
        wiki1.setName("Wiki1");
        wiki1.setVisible(true);
        wiki1.setId(6);
        wiki1.setSummary("A Mock Wiki in course "+courseId);
        wikis.add(wiki1);


        return wikis;
    }

    /**
     *
     * @param params
     */
    public void setParams(Map<String, String> params) {

    }

    /**
     *
     * @param context
     * @param username
     * @param password
     * @param rememberPassword
     * @return
     * @throws InvalidSessionException
     */
    public boolean authenticate(Context context, String username, String password, boolean rememberPassword) throws InvalidSessionException {
        return true;
    }
}
