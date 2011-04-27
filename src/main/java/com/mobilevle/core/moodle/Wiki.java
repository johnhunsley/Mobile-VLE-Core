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
 *         Date: 29-Nov-2010
 *         Time: 12:04:40
 */
public class Wiki extends Activity implements Parcelable {

    public Wiki() {}

    /**
     *
     * @param in
     */
    public Wiki(Parcel in) {
        super.id = in.readInt();
        super.courseId = in.readInt();
        super.name = in.readString();
        super.summary = in.readString();
    }

    /**
     *
     */
    public static final Parcelable.Creator<Wiki> CREATOR  = new Parcelable.Creator<Wiki>() {
        /**
         *
         * @param in
         * @return {@link Course }
         */
        public Wiki createFromParcel(Parcel in) {
            return new Wiki(in);
        }

        /**
         *
         * @param size
         * @return
         */
        public Wiki[] newArray(int size) {
            return new Wiki[size];
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
