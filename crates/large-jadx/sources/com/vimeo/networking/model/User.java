package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes2.dex */
public class User implements Serializable {

    private static final String ACCOUNT_BASIC = "basic";
    private static final String ACCOUNT_BUSINESS = "business";
    private static final String ACCOUNT_PLUS = "plus";
    private static final String ACCOUNT_PRO = "pro";
    private static final String ACCOUNT_STAFF = "staff";
    private static final long serialVersionUID = -4112910222188194647L;
    public String account;
    public com.vimeo.networking.model.UserBadge badge;
    public String bio;
    public Date createdTime;
    public ArrayList<com.vimeo.networking.model.Email> emails;
    public String link;
    public String location;
    public com.vimeo.networking.model.Metadata metadata;
    public String name;
    public com.vimeo.networking.model.PictureCollection pictures;
    public com.vimeo.networking.model.Preferences preferences;
    public com.vimeo.networking.model.UploadQuota uploadQuota;
    public String uri;
    public ArrayList<com.vimeo.networking.model.Website> websites;

    public static enum AccountType {

        BASIC,
        BUSINESS,
        PRO,
        PLUS,
        STAFF;
    }
    @Override // java.io.Serializable
    public boolean canFollow() {
        int i;
        i = getFollowInteraction() != null ? 1 : 0;
        return i;
    }

    @Override // java.io.Serializable
    public boolean canUploadPicture() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.pictures;
        connections = connections.options;
        if (connections != null && connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.pictures;
                if (connections != null) {
                    connections = connections.options;
                    if (connections != null) {
                        return connections.contains("POST");
                    }
                }
            }
        }
        return 0;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int equals;
        Object class2;
        Class class;
        Object obj4;
        if (this == object) {
            return 1;
        }
        equals = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                class2 = this.uri;
                obj4 = object.uri;
                if (class2 != null && obj4 != null) {
                    obj4 = object.uri;
                    if (obj4 != null) {
                        equals = class2.equals(obj4);
                    }
                }
            }
        }
        return equals;
    }

    @Override // java.io.Serializable
    public String getAccount() {
        return this.account;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.User.AccountType getAccountType() {
        String account;
        int i;
        int str;
        account = this.account;
        if (account == null) {
            return User.AccountType.BASIC;
        }
        i = -1;
        final int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        switch (account) {
            case "business":
                i = 0;
                break;
            case "pro":
                i = i4;
                break;
            case "plus":
                i = i5;
                break;
            case "basic":
                i = 4;
                break;
            case "staff":
                i = i3;
                break;
            default:
        }
        if (i != 0 && i != i5 && i != i4 && i != i3) {
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        return User.AccountType.BASIC;
                    }
                    return User.AccountType.STAFF;
                }
                return User.AccountType.PRO;
            }
            return User.AccountType.PLUS;
        }
        return User.AccountType.BUSINESS;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getAppearancesConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.appearances;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.appearances;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getAppearancesCount() {
        if (getAppearancesConnection() != null) {
            return appearancesConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public String getBio() {
        return this.bio;
    }

    @Override // java.io.Serializable
    public Date getCreatedTime() {
        return this.createdTime;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Interaction getFollowInteraction() {
        Object interactions;
        interactions = this.metadata;
        interactions = interactions.interactions;
        interactions = interactions.follow;
        if (interactions != null && interactions != null && interactions != null) {
            interactions = interactions.interactions;
            if (interactions != null) {
                interactions = interactions.follow;
                if (interactions != null) {
                    return interactions;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getFollowerCount() {
        if (getFollowersConnection() != null) {
            return followersConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getFollowersConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        if (connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                return connections.followers;
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getFollowingConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        if (connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                return connections.following;
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getFollowingCount() {
        if (getFollowingConnection() != null) {
            return followingConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public long getFreeUploadSpace() {
        com.vimeo.networking.model.UploadQuota uploadQuota = this.uploadQuota;
        if (uploadQuota != null) {
            return uploadQuota.getFreeUploadSpace();
        }
        return -1;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getLikesConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.likes;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.likes;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getLikesCount() {
        if (getLikesConnection() != null) {
            return likesConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public String getLink() {
        return this.link;
    }

    @Override // java.io.Serializable
    public String getLocation() {
        return this.location;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // java.io.Serializable
    public String getName() {
        return this.name;
    }

    public ArrayList<com.vimeo.networking.model.Picture> getPictures() {
        Object pictures;
        pictures = this.pictures;
        pictures = pictures.sizes;
        if (pictures != null && pictures == null) {
            pictures = pictures.sizes;
            if (pictures == null) {
            }
            return pictures;
        }
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Preferences getPreferences() {
        return this.preferences;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Privacy.PrivacyValue getPreferredVideoPrivacyValue() {
        com.vimeo.networking.model.Privacy.PrivacyValue privacyValueFromString;
        Object preferences;
        if (getPreferences() != null && getPreferences().getVideos() != null && getPreferences().getVideos().getPrivacy() != null) {
            if (getPreferences().getVideos() != null) {
                if (getPreferences().getVideos().getPrivacy() != null) {
                    privacyValueFromString = Privacy.PrivacyValue.privacyValueFromString(getPreferences().getVideos().getPrivacy());
                } else {
                    privacyValueFromString = 0;
                }
            } else {
            }
        } else {
        }
        return privacyValueFromString;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.UploadQuota getUploadQuota() {
        return this.uploadQuota;
    }

    @Override // java.io.Serializable
    public String getUri() {
        return this.uri;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.UserBadge.UserBadgeType getUserBadgeType() {
        com.vimeo.networking.model.UserBadge.UserBadgeType badgeType;
        com.vimeo.networking.model.UserBadge badge = this.badge;
        if (badge == null) {
            badgeType = UserBadge.UserBadgeType.NONE;
        } else {
            badgeType = badge.getBadgeType();
        }
        return badgeType;
    }

    public ArrayList<com.vimeo.networking.model.Email> getVerifiedEmails() {
        return this.emails;
    }

    @Override // java.io.Serializable
    public int getVideoCount() {
        if (getVideosConnection() != null) {
            return videos.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getVideosConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.videos;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.videos;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getWatchLaterConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.watchlater;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.watchlater;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    public ArrayList<com.vimeo.networking.model.Website> getWebsites() {
        return this.websites;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        String uri = this.uri;
        if (uri != null) {
            i = uri.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isFollowing() {
        com.vimeo.networking.model.Interaction followInteraction;
        int i;
        if (getFollowInteraction() != null && follow.added) {
            i = follow.added ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isPlusOrPro() {
        int i;
        com.vimeo.networking.model.User.AccountType accountType;
        com.vimeo.networking.model.User.AccountType pLUS;
        if (getAccountType() != User.AccountType.PLUS) {
            if (getAccountType() == User.AccountType.PRO) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
