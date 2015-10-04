package de.smasi.tickmate.models;

// js TODO For the future, consider:
//  o Forbidding the creation of a new group that has the same name as an existing group (but code
//      must not assume such duplicates don't exist.)
//  o whether longs or ints are better for ids
//  o introducing icons for groups


// AVP TODO load group IDs into Track objects when they are read from database
// AVP TODO store all Track/Group data in memory and update database when necessary (implementing locking if need be)
// js - ...after ironing out all wrinkles in current (db centric) approach
// js - We would need to ensure that every time any track/group link is established - whether individually
//      or using lists of IDs, and whether via Track.linkGroup or Group.linkTrack or TracksDataSource.linkBlah
//      methods - that all affected objects (as well as db) are updated.  I don't see how to do
//      this without a centralized list of references to all of the tracks and groups, which would
//      in turn require that we carefully regulate the creation of new Track and Group objects
//      everywhere in the code (otherwise someone may hold a reference to a stale object, which is
//      not in the centralized master list and whose data is therefore not updated

// TODO NOW js - currently trying to allow group order to be changed, in preparation for using a TabView (so users won't be forced to swipe across too many tabs)

import android.util.Log;

/**
 * Groups are a way to organize and categorize Tracks. Groups can be predefined or user-defined.
 */
public class Group {

    public static final Group ALL_GROUP = new Group("All");  // Used to indicate that 'all groups' have been selected for display
    private static final String TAG = "Group";

    private int mId = -1;         // Unique identifier will be assigned by database
    private String mName = "(Name not initialized)";
    private String mDescription = "(Description not initialized)";
    private boolean mIsSectionHeader = false; // For entries derived from groups.xml to be section headers
    private int mOrder = 0;

    /**
     * @param name group name
     */
    public Group(String name) {
        mName = name;
    }

    /**
     * @param name group name
     * @param description group description
     */
    public Group(String name, String description) {
        mName = name;
        mDescription = description;
    }

    /**
     * @return group id
     */
    public int getId() {
        return mId;
    }

    /**
     * @param id group id
     */
    public void setId(int id) {
        mId = id;
    }

    /**
     * @return group description
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * @param description group description
     */
    public void setDescription(String description) {
        mDescription = description;
    }

    /**
     * @return group name
     */
    public String getName() {
        return mName;
    }

    /**
     * @param name group name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * @return group name
     */
    public boolean isSectionHeader() {
        return mIsSectionHeader;
    }

    /**
     * Prints contents on Group object. Used primarily for debug purposes.
     */
    public String toString() {
//        return "Group:  id(" + mId + ") name(" + mName + ") description(" + mDescription + ")  trackIds(" + TextUtils.join(",", mTrackIds) + ")";
        return "Group:  id(" + mId + ") name(" + mName + ") description(" + mDescription + ")  trackIds(not stored here at the moment)";
    }

    /**
     * Only used when parsing groups.xml.
     *
     * @param sectionHeader group name
     */
    public void setSectionHeader(boolean sectionHeader) {
        mIsSectionHeader = sectionHeader;
    }

    public void setOrder(int groupOrder) {
        Log.e(TAG, "Group.setOrder(" + groupOrder + ")");
        mOrder = groupOrder;
    }

    public int getOrder() {
        return mOrder;
    }
}

