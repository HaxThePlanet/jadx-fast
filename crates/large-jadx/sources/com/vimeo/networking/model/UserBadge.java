package com.vimeo.networking.model;

import android.graphics.PorterDuff.Mode;
import com.google.protobuf.z;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class UserBadge implements Serializable {

    private static final String BADGE_ALUM = "alum";
    private static final String BADGE_BUSINESS = "business";
    private static final String BADGE_CURATION = "curation";
    private static final String BADGE_PLUS = "plus";
    private static final String BADGE_POTUS = "potus";
    private static final String BADGE_PRO = "pro";
    private static final String BADGE_STAFF = "staff";
    private static final String BADGE_SUPPORT = "support";
    private static final long serialVersionUID = 927892812790804141L;
    public String mAlternateText;
    public String mBadgeType;
    public String mText;
    public String mUrl;

    public static enum UserBadgeType {

        NONE,
        ALUM,
        BUSINESS,
        CURATION,
        PLUS,
        POTUS,
        PRO,
        STAFF,
        SUPPORT;
    }
    @Override // java.io.Serializable
    public com.vimeo.networking.model.UserBadge.UserBadgeType getBadgeType() {
        boolean mBadgeType;
        int i;
        String str;
        mBadgeType = this.mBadgeType;
        if (mBadgeType == null) {
            return UserBadge.UserBadgeType.NONE;
        }
        mBadgeType.hashCode();
        i = -1;
        switch (mBadgeType) {
            case "support":
                i = 0;
                break;
            case "business":
                i = 1;
                break;
            case "pro":
                i = 2;
                break;
            case "alum":
                i = 3;
                break;
            case "plus":
                i = 4;
                break;
            case "potus":
                i = 5;
                break;
            case "staff":
                i = 6;
                break;
            case "curation":
                i = 7;
                break;
            default:
        }
        switch (i) {
            case 0:
                return UserBadge.UserBadgeType.SUPPORT;
            case 1:
                return UserBadge.UserBadgeType.BUSINESS;
            case 2:
                return UserBadge.UserBadgeType.PRO;
            case 3:
                return UserBadge.UserBadgeType.ALUM;
            case 4:
                return UserBadge.UserBadgeType.PLUS;
            case 5:
                return UserBadge.UserBadgeType.POTUS;
            case 6:
                return UserBadge.UserBadgeType.STAFF;
            case 7:
                return UserBadge.UserBadgeType.CURATION;
            default:
                return UserBadge.UserBadgeType.NONE;
        }
    }
}
