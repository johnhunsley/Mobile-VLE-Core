package com.mobilevle.core.moodle;

import com.mobilevle.core.MobileVLECoreException;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * <p>
 *  A Message, sent or received from or to the authenitcated user. Comparable by send date and time
 * </p>
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
 *         Time: 17:00:19
 */
public class Message implements Comparable {
    private static final int MAX_CONTENT_ELEMENT_LENGTH = 18;
    public static final int INBOUND = 1;
    public static final int OUTBOUND = 2;
    public static final int UNREAD = 0;
    public static final int READ = 1;
    private User fromUser;
    private User toUser;
    private int type;
    private int id;
    private String content;
    private String subject;
    private Date sendDate;
    private int read;
    public static final int SUBJECT = 1;
    public static final int CONTENT = 2;

    /**
     *
     */
    public Message() {}

    /**
     *
     * @param type
     */
    public Message(final int type) {
        this.type = type;
    }

    /**
     *
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * 
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     * @return sendDate
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * <p>
     *  Returns the sendDate of this message with the time set to midday
     * Should only be used when the date is to be used and not the time.
     * </p>
     * @return {@link Date} set to midday of the sendDate date
     */
    public Date getSendDayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(sendDate);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     *
     * @param sendDate
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     *
     * @return fromUser
     */
    public User getFromUser() {
        return fromUser;
    }

    /**
     *
     * @param fromUser
     */
    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    /**
     *
     * @return toUser
     */
    public User getToUser() {
        return toUser;
    }

    /**
     *
     * @param toUser
     */
    public void setToUser(User toUser) {
        this.toUser = toUser;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return read
     */
    public int getRead() {
        return read;
    }

    /**
     *
     * @param read
     */
    public void setRead(int read) {
        this.read = read;
    }

    /**
     *
     * @return read > UNREAD
     */
    public boolean isRead() {
        return read > UNREAD;
    }

    /**
     * <p>Get a summary of the content element requested, either the message subject or the content.
     * Returns a snippet of the element with added dots if the requested element is over the
     * MAX_CONTENT_ELEMENT_LENGTH value</p>
     * @return String
     */
    public String getMessageElementSummary(final int contentElementId) throws MobileVLECoreException {
        String contentElement;

        switch(contentElementId) {
            case SUBJECT : contentElement = subject; break;
            case CONTENT : contentElement = content; break;
            default : throw new MobileVLECoreException(contentElementId+" is not a valid content element id");
        }           

        StringBuffer buffer = new StringBuffer();

        if(contentElement != null && contentElement.length() > 0) {

            if(contentElement.length() > MAX_CONTENT_ELEMENT_LENGTH)
                buffer.append(content.substring(0, MAX_CONTENT_ELEMENT_LENGTH)).append("..... ");

            else buffer.append(content);
        }

        return buffer.toString();
    }

    /**
     * <p>Was this message sent or received from the user with the given id</p>
     * @param userId
     * @return
     */
    public boolean isConversationMessage(final int userId) {

        if(toUser != null) {

            if(toUser.getId().equals(userId)) return true;
        }

        if(fromUser != null) {

            if(fromUser.getId().equals(userId)) return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if(id != message.id) return false;

        if(type != message.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    /**
     *
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        Message comparable = (Message)o;    

        if(sendDate.before(comparable.sendDate)) return 1;

        if(sendDate.after(comparable.sendDate)) return -1;

        return 0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("############# Message #############");
        buffer.append("\nID = ").append(id);

        if(fromUser != null) buffer.append("\nFROM = ").append(fromUser.getId());
        if(toUser != null) buffer.append("TO = ").append(toUser.getId());

        buffer.append("\nSUBJECT = ").append(subject);
        buffer.append("\nCONTENT = ").append(content);
        buffer.append("\nREAD = ").append(isRead());
        buffer.append("\nSEND TIME = ").append(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(sendDate));
        return buffer.append("\n").toString();       
    }
}
