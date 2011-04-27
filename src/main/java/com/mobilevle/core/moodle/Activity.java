package com.mobilevle.core.moodle;

import com.mobilevle.core.MobileVLECoreException;

/**
 * <p>A generic activity within the context of Moodle</p>
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
 *         Date: 26-Nov-2010
 *         Time: 21:00:44
 */
public abstract class Activity {
    public final static int MAX_SUMMARY_LENGTH = 35;
    protected String name;
    protected int courseId;
    protected boolean visible;
    protected String summary;
    protected int id;


    /**
     * <p></p>
     * @param type
     * @return  {@link Activity} instance by {@link ActivityType)
     */
    public static final Activity createActivitybyType(ActivityType type) throws MobileVLECoreException {
        if(type.label.equals(ActivityType.LESSON.label)) return new Lesson();

        if(type.label.equals(ActivityType.QUIZ.label)) return new Quiz();

        if(type.label.equals(ActivityType.FORUM.label)) return new Forum();

        if(type.label.equals(ActivityType.WIKI.label)) return new Wiki();

        throw new MobileVLECoreException(type.label+" is an unknown type");
    }

    /**
     *
     * @return  id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return  courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     *
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     *
     * @return visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     *
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     *
     * @return summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     * @return
     */
    public String getAbreviatedSummary() {
        String temp = summary;

        if(temp == null) temp = "";

        if(temp.length() > MAX_SUMMARY_LENGTH) temp = temp.substring(0, MAX_SUMMARY_LENGTH);

        return temp+".....";
    }
}
