package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: User.java */
/* loaded from: classes2.dex */
public class User implements Serializable {

    private static final String ACCOUNT_BASIC = "basic";
    private static final String ACCOUNT_BUSINESS = "business";
    private static final String ACCOUNT_PLUS = "plus";
    private static final String ACCOUNT_PRO = "pro";
    private static final String ACCOUNT_STAFF = "staff";
    private static final long serialVersionUID = -4112910222188194647L;
    public String account;
    public UserBadge badge;
    public String bio;
    public Date createdTime;
    public ArrayList<Email> emails;
    public String link;
    public String location;
    public Metadata metadata;
    public String name;
    public PictureCollection pictures;
    public Preferences preferences;
    public UploadQuota uploadQuota;
    public String uri;
    public ArrayList<Website> websites;

    public enum AccountType {

        BASIC,
        BUSINESS,
        PLUS,
        PRO,
        STAFF;
    }
    public boolean canFollow() {
        boolean z = true;
        int r0 = getFollowInteraction() != null ? 1 : 0;
        return (getFollowInteraction() != null ? 1 : 0);
    }

    public boolean canUploadPicture() {
        if (this.metadata != null && metadata2.connections != null && connections2.pictures != null && pictures2.options != null) {
            return pictures2.options.contains("POST");
        }
        return false;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean equals = false;
        if (this == object) {
            return true;
        }
        int i = 0;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.uri != null && object.uri != null) {
                    equals = this.uri.equals(object.uri);
                }
            }
        }
        return equals;
    }

    public String getAccount() {
        return this.account;
    }

    public User.AccountType getAccountType() {
        int i2 = -1;
        if (this.account == null) {
            return User.AccountType.BASIC;
        }
        i2 = -1;
        i2 = 3;
        i2 = 2;
        i2 = 1;
        switch (this.account.hashCode()) {
            case -1146830912:
                i2 = 0;
                break;
            case 111277:
                break;
            case 3444122:
                break;
            case 93508654:
                i2 = 4;
                break;
            case 109757152:
                break;
            default:
        }
        if (i2 != 0 && i2 != i2) {
            if (i2 != i2 && i2 != i2) {
                return User.AccountType.BASIC;
            }
            return User.AccountType.PRO;
        }
        return User.AccountType.BUSINESS;
    }

    public Connection getAppearancesConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.appearances != null) {
            return connections2.appearances;
        }
        return null;
    }

    public int getAppearancesCount() {
        if (getAppearancesConnection() != null) {
            return getAppearancesConnection().total;
        }
        return 0;
    }

    public String getBio() {
        return this.bio;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public Interaction getFollowInteraction() {
        if (this.metadata != null && metadata2.interactions != null && interactions2.follow != null) {
            return interactions2.follow;
        }
        return null;
    }

    public int getFollowerCount() {
        if (getFollowersConnection() != null) {
            return getFollowersConnection().total;
        }
        return 0;
    }

    public Connection getFollowersConnection() {
        if (this.metadata != null && metadata2.connections != null) {
            return connections2.followers;
        }
        return null;
    }

    public Connection getFollowingConnection() {
        if (this.metadata != null && metadata2.connections != null) {
            return connections2.following;
        }
        return null;
    }

    public int getFollowingCount() {
        if (getFollowingConnection() != null) {
            return getFollowingConnection().total;
        }
        return 0;
    }

    public long getFreeUploadSpace() {
        if (this.uploadQuota != null) {
            return this.uploadQuota.getFreeUploadSpace();
        }
        return -1;
    }

    public Connection getLikesConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.likes != null) {
            return connections2.likes;
        }
        return null;
    }

    public int getLikesCount() {
        if (getLikesConnection() != null) {
            return getLikesConnection().total;
        }
        return 0;
    }

    public String getLink() {
        return this.link;
    }

    public String getLocation() {
        return this.location;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Picture> getPictures() {
        return new ArrayList();
    }

    public Preferences getPreferences() {
        return this.preferences;
    }

    public Privacy.PrivacyValue getPreferredVideoPrivacyValue() {
        com.vimeo.networking.model.Privacy.PrivacyValue privacyValueFromString = null;
        if (getPreferences() != null) {
            if (getPreferences().getVideos() != null) {
                if (getPreferences().getVideos().getPrivacy() != null) {
                    privacyValueFromString = Privacy.PrivacyValue.privacyValueFromString(getPreferences().getVideos().getPrivacy());
                } else {
                    int i = 0;
                }
            }
        }
        return privacyValueFromString;
    }

    public UploadQuota getUploadQuota() {
        return this.uploadQuota;
    }

    public String getUri() {
        return this.uri;
    }

    public UserBadge.UserBadgeType getUserBadgeType() {
        com.vimeo.networking.model.UserBadge.UserBadgeType badgeType;
        if (this.badge == null) {
            badgeType = UserBadge.UserBadgeType.NONE;
        } else {
            badgeType = this.badge.getBadgeType();
        }
        return badgeType;
    }

    public ArrayList<Email> getVerifiedEmails() {
        return this.emails;
    }

    public int getVideoCount() {
        if (getVideosConnection() != null) {
            return this.metadata.connections.videos.total;
        }
        return 0;
    }

    public Connection getVideosConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.videos != null) {
            return connections2.videos;
        }
        return null;
    }

    public Connection getWatchLaterConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.watchlater != null) {
            return connections2.watchlater;
        }
        return null;
    }

    public ArrayList<Website> getWebsites() {
        return this.websites;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.uri != null) {
            i = this.uri.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isFollowing() {
        boolean z = false;
        if (getFollowInteraction() != null) {
            int r0 = this.metadata.interactions.follow.added ? 1 : 0;
        }
        return (this.metadata.interactions.follow.added ? 1 : 0);
    }

    public boolean isPlusOrPro() {
        boolean z = false;
        com.vimeo.networking.model.User.AccountType pLUS2;
        if (getAccountType() != User.AccountType.PLUS) {
            if (getAccountType() == User.AccountType.PRO) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }
}
