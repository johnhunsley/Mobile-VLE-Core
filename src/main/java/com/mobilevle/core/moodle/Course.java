package com.mobilevle.core.moodle;

import android.os.Parcelable;
import android.os.Parcel;

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
 *         Date: 23-Nov-2010
 *         Time: 13:22:34
 */
public class Course implements Parcelable {
    private int id;
    private String name;
    private String courseId;

    /**
     *
     */
    public Course() { }

    /**
     *
     * @param id
     * @param name
     * @param courseId
     */
    public Course(int id, String name, String courseId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
    }

    /**
     * 
     * @param in
     */
    public Course(Parcel in) {
        id = in.readInt();
        courseId = in.readString();
        name = in.readString();
    }

    /**
     *
     * @return id
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
     * @return courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     *
     * @return 0
     */
    public int describeContents() {
        return 0;
    }

    /**
     *
     * @param parcel
     * @param i
     */
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(courseId);
        parcel.writeString(name);
    }

    /**
     * 
     */
    public static final Parcelable.Creator<Course> CREATOR  = new Parcelable.Creator<Course>() {

        /**
         *
         * @param in
         * @return {@link Course }
         */
         public Course createFromParcel(Parcel in) {
             return new Course(in);
         }

        /**
         *
         * @param size
         * @return
         */
         public Course[] newArray(int size) {
             return new Course[size];
         }
     };
}
