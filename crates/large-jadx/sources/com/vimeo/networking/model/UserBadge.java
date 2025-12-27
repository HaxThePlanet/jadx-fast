package com.vimeo.networking.model;

import android.graphics.PorterDuff.Mode;
import com.google.protobuf.z;
import java.io.Serializable;

/* compiled from: UserBadge.java */
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

    public enum UserBadgeType {

        ALUM,
        BUSINESS,
        CURATION,
        NONE,
        PLUS,
        POTUS,
        PRO,
        STAFF,
        SUPPORT;
    }
    public UserBadge.UserBadgeType getBadgeType() {
        int i = 1;
        if (this.mBadgeType == null) {
            return UserBadge.UserBadgeType.NONE;
        }
        this.mBadgeType.hashCode();
        i = -1;
        switch (this.mBadgeType.hashCode()) {
            case -1854767153:
                str = "support";
                i = 0;
                break;
            case -1146830912:
                str = "business";
                i = 1;
                break;
            case 111277:
                str = "pro";
                i = 2;
                break;
            case 2997251:
                str = "alum";
                i = 3;
                break;
            case 3444122:
                str = "plus";
                i = 4;
                break;
            case 106856371:
                str = "potus";
                i = 5;
                break;
            case 109757152:
                str = "staff";
                i = 6;
                break;
            case 560144565:
                str = "curation";
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
