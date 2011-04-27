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
 *         Date: 30-Nov-2010
 *         Time: 11:57:58
 */
public class Forum extends Activity implements Parcelable {

    public Forum() {}

    /**
     *
     * @param in
     */
    public Forum(Parcel in) {
        super.id = in.readInt();
        super.courseId = in.readInt();
        super.name = in.readString();
        super.summary = in.readString();
    }

    /**
     *
     */
    public static final Parcelable.Creator<Forum> CREATOR  = new Parcelable.Creator<Forum>() {
        /**
         *
         * @param in
         * @return {@link Course }
         */
         public Forum createFromParcel(Parcel in) {
             return new Forum(in);
         }

        /**
         *
         * @param size
         * @return
         */
         public Forum[] newArray(int size) {
             return new Forum[size];
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
