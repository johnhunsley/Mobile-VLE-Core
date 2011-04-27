package com.mobilevle.core.moodle;

/**
 * <p>A Moodle user with a defined role. Not used for authentication purposes</p>
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
 *         Date: 04-Jan-2011
 *         Time: 16:34:54
 */
public class User implements Comparable {
    public static final String UNKNOWN_USER = "Unknown Contact";
    public final static int UNKNOWN_ROLE = 0;
    public final static int ADMIN_ROLE = 1;
    public final static int TEACHER_ROLE = 3;
    public final static int NONE_EDIT_TEACHER_ROLE = 4;
    public final static int STUDENT_ROLE = 5;
    private String id;
    private int role;
    private String firstName;
    private String lastName;
    private String username;
    private String email;      

    public User() {  }

    /**
     *
     * @param role
     */
    public User(final int role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return Full name of the user
     */
    public String getFullName() {
        StringBuffer buffer = new StringBuffer();

        if(firstName != null && firstName.length() > 0) buffer.append(firstName).append(" ");

        if(lastName != null && lastName.length() > 0) buffer.append(lastName);

        if(buffer.length() < 1) return UNKNOWN_USER;

        return buffer.toString();
    }

    /**
     *
     * @param o
     * @return
     */
    public int compareTo(Object o) {

        if(o instanceof User) {
            User that = (User)o;

            return this.getFullName().compareToIgnoreCase(that.getFullName());
        }

        return -1;
    }
}
