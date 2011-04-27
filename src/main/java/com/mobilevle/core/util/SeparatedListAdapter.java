package com.mobilevle.core.util;

import android.widget.BaseAdapter;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * <p>Extension of the {@link BaseAdapter} which created a segmented list with
 * each segment separated by a header</p>
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
 *         Time: 12:39:00
 */
public class SeparatedListAdapter extends BaseAdapter {
    public final Map<String, Adapter> sections = new LinkedHashMap<String,Adapter>();
    public final ArrayAdapter<String> headers;
    public final static int TYPE_SECTION_HEADER = 0;

    /**
     *
     * @param context
     */
    public SeparatedListAdapter(Context context, final int resourceId) {
        headers = new ArrayAdapter<String>(context, resourceId);
    }

    /**
     *
     * @param section
     * @param adapter
     */
    public void addSection(String section, Adapter adapter) {
        this.headers.add(section);
        this.sections.put(section, adapter);
    }

    /**
     *
     * @param position
     * @return Object
     */
    public Object getItem(int position) {
        for(Object section : this.sections.keySet()) {
            Adapter adapter = sections.get(section);
            int size = adapter.getCount() + 1;

            // check if position inside this section
            if(position == 0) return section;
            if(position < size) return adapter.getItem(position - 1);

            // otherwise jump into next section
            position -= size;
        }
        return null;
    }

    /**
     *
     * @return count
     */
    public int getCount() {
        // total together all sections, plus one for each section header
        int total = 0;
        for(Adapter adapter : this.sections.values())
            total += adapter.getCount() + 1;
        return total;
    }

    /**
     *
     * @return number of different type views
     */
    public int getViewTypeCount() {
        // assume that headers count as one, then total all sections
        int total = 1;
        for(Adapter adapter : this.sections.values())
            total += adapter.getViewTypeCount();
        return total;
    }

    /**
     *
     * @param position
     * @return number of views per type
     */
    public int getItemViewType(int position) {
        int type = 1;
        for(Object section : this.sections.keySet()) {
            Adapter adapter = sections.get(section);
            int size = adapter.getCount() + 1;

            // check if position inside this section
            if(position == 0) return TYPE_SECTION_HEADER;
            if(position < size) return type + adapter.getItemViewType(position - 1);

            // otherwise jump into next section
            position -= size;
            type += adapter.getViewTypeCount();
        }
        return -1;
    }

    /**
     *
     * @return false (headers not selectable)
     */
    public boolean areAllItemsSelectable() {
        return false;
    }

    /**
     *
     * @param position
     * @return true if the item at the given position is not a section header
     */
    public boolean isEnabled(int position) {
        return (getItemViewType(position) != TYPE_SECTION_HEADER);
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return view at the given position
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        int sectionnum = 0;
        for(Object section : this.sections.keySet()) {
            Adapter adapter = sections.get(section);
            int size = adapter.getCount() + 1;

            // check if position inside this section
            if(position == 0) return headers.getView(sectionnum, convertView, parent);
            if(position < size) return adapter.getView(position - 1, convertView, parent);

            // otherwise jump into next section
            position -= size;
            sectionnum++;
        }
        return null;
    }

    /**
     *
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }
}