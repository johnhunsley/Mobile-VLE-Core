package com.mobilevle.core.moodle;

/**
 * <p>An Enumeration which defines the instance type which are used to request instance type required when
 * calling the get_instance_bytype request. The parameter is <type xsi:type="xsd:string">intanceType.label</type></p>
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
 *         Time: 16:22:14
 */
public enum ActivityType {
    LESSON("lesson"),
    FORUM("forum"),
    QUIZ("quiz"),
    WIKI("wiki");

    public final String label;

    /**
     *
     * @param label
     */
    private ActivityType(final String label) {
        this.label = label;
    }
}
