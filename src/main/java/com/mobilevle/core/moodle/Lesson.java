package com.mobilevle.core.moodle;

import android.os.Parcel;
import android.os.Parcelable;

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
 *         Date: 26-Nov-2010
 *         Time: 21:01:09
 */
public class Lesson extends Activity implements Parcelable {

    public Lesson() {}

    /**
     *
     * @param in
     */
    public Lesson(Parcel in) {
        super.id = in.readInt();
        super.courseId = in.readInt();
        super.name = in.readString();
        super.summary = in.readString();
    }

    /**
     *
     */
    public static final Parcelable.Creator<Lesson> CREATOR  = new Parcelable.Creator<Lesson>() {
        /**
         *
         * @param in
         * @return {@link Course }
         */
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }

        /**
         *
         * @param size
         * @return
         */
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };

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
        parcel.writeInt(courseId);
        parcel.writeString(name);
        parcel.writeString(summary);
    }
}
