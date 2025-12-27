package app.dogo.com.dogo_android.model.inapp;

import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;

/* compiled from: InAppFeedbackModel.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0008HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000cHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003Jy\u0010,\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0008HÖ\u0001J\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000102J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0013¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/model/inapp/InAppFeedbackModel;", "", "userId", "", "dogId", "campaignId", "campaignName", "score", "", "comment", "locale", "timestamp", "", "appVersion", "platform", "extra", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;)V", "getAppVersion", "()Ljava/lang/String;", "getCampaignId", "getCampaignName", "getComment", "getDogId", "getExtra", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getLocale", "getPlatform", "getScore", "()I", "getTimestamp", "()J", "getUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toMap", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InAppFeedbackModel {

    private final String appVersion;
    private final String campaignId;
    private final String campaignName;
    private final String comment;
    private final String dogId;
    private final InAppFeedbackExtras extra;
    private final String locale;
    private final String platform;
    private final int score;
    private final long timestamp;
    private final String userId;
    public InAppFeedbackModel(String str, String str2, String str3, String str4, int i, String str5, String str6, long j, String str7, String str8, InAppFeedbackExtras inAppFeedbackExtras) {
        n.f(str, "userId");
        n.f(str2, "dogId");
        n.f(str3, "campaignId");
        n.f(str4, "campaignName");
        n.f(str5, "comment");
        n.f(str6, "locale");
        n.f(str7, "appVersion");
        n.f(str8, "platform");
        super();
        this.userId = str;
        this.dogId = str2;
        this.campaignId = str3;
        this.campaignName = str4;
        this.score = i;
        this.comment = str5;
        this.locale = str6;
        this.timestamp = j;
        this.appVersion = str7;
        this.platform = str8;
        this.extra = inAppFeedbackExtras;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final String getCampaignName() {
        return this.campaignName;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final InAppFeedbackExtras getExtra() {
        return this.extra;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final int getScore() {
        return this.score;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Map<String, Object> toMap() {
        Integer num;
        Map map = null;
        o pair;
        if (this.score > 0) {
            num = Integer.valueOf(this.score);
        } else {
        }
        o[] value = new o[11];
        int i4 = 0;
        value[i4] = new Pair("userId", this.userId);
        int i3 = 1;
        value[i3] = new Pair("dogId", this.dogId);
        value[2] = new Pair("campaignId", this.campaignId);
        value[3] = new Pair("campaignName", this.campaignName);
        value[4] = new Pair("score", num);
        value[5] = new Pair("comment", this.comment);
        String str7 = "locale";
        value[6] = new Pair(str7, this.locale);
        value[7] = new Pair("timestamp", Long.valueOf(this.timestamp));
        value[8] = new Pair("appVersion", this.appVersion);
        value[9] = new Pair("platform", this.platform);
        if (this.extra != null) {
            map = this.extra.toMap();
        }
        pair = new Pair("extra", map);
        value[10] = pair;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = j0.k(value).entrySet().iterator();
        while (it.hasNext()) {
            value = it.next();
            int r3 = value.getValue() != null ? i3 : i4;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(linkedHashMap2.size()));
        Iterator it2 = linkedHashMap2.entrySet().iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            Object value2 = item.getValue();
            Objects.requireNonNull(value2, "null cannot be cast to non-null type kotlin.Any");
            linkedHashMap.put(item.getKey(), value2);
        }
        return linkedHashMap;
    }

    public /* synthetic */ InAppFeedbackModel(String str, String str2, String str3, String str4, int i, String str5, String str6, long j, String str7, String str8, InAppFeedbackExtras inAppFeedbackExtras, int i2, g gVar) {
        long j82;
        String str102;
        Object inAppFeedbackExtras112;
        int gVar132 = i2;
        i = gVar132 & 128;
        j82 = gVar132 & 128 != 0 ? j82 : j;
        i2 = gVar132 & 256;
        str102 = gVar132 & 256 != 0 ? str102 : str7;
        str5 = gVar132 & 512 != 0 ? str5 : str8;
        this(str, str2, str3, str4, i, str5, str6, j82, str12, str102, inAppFeedbackExtras112, inAppFeedbackExtras);
    }

    public static /* synthetic */ InAppFeedbackModel copy$default(InAppFeedbackModel inAppFeedbackModel, String str, String str2, String str3, String str4, int i, String str5, String str6, long j, String str7, String str8, InAppFeedbackExtras inAppFeedbackExtras, int i2, Object object) {
        InAppFeedbackExtras i132;
        String str22;
        String str32;
        String str42;
        String str52;
        int i62;
        String str72;
        String str82;
        long j92;
        String str112;
        String inAppFeedbackExtras122;
        Object inAppFeedbackModel2 = inAppFeedbackModel;
        int object142 = i2;
        String r2 = object142 & 1 != 0 ? inAppFeedbackModel2.userId : str;
        String r3 = object142 & 2 != 0 ? inAppFeedbackModel2.dogId : str2;
        String r4 = object142 & 4 != 0 ? inAppFeedbackModel2.campaignId : str3;
        String r5 = object142 & 8 != 0 ? inAppFeedbackModel2.campaignName : str4;
        int r6 = object142 & 16 != 0 ? inAppFeedbackModel2.score : i;
        String r7 = object142 & 32 != 0 ? inAppFeedbackModel2.comment : str5;
        String r8 = object142 & 64 != 0 ? inAppFeedbackModel2.locale : str6;
        long r9 = object142 & 128 != 0 ? inAppFeedbackModel2.timestamp : j;
        String r11 = object142 & 256 != 0 ? inAppFeedbackModel2.appVersion : str7;
        String r12 = object142 & 512 != 0 ? inAppFeedbackModel2.platform : str8;
        InAppFeedbackExtras r1 = object142 & 1024 != 0 ? inAppFeedbackModel2.extra : inAppFeedbackExtras;
        return inAppFeedbackModel.copy(str22, str32, str42, str52, i62, str72, str82, j92, r22, str112, inAppFeedbackExtras122, (object142 & 1024 != 0 ? inAppFeedbackModel2.extra : inAppFeedbackExtras));
    }

    /* operator */ public final String component1() {
        return this.userId;
    }

    /* operator */ public final String component10() {
        return this.platform;
    }

    /* operator */ public final InAppFeedbackExtras component11() {
        return this.extra;
    }

    /* operator */ public final String component2() {
        return this.dogId;
    }

    /* operator */ public final String component3() {
        return this.campaignId;
    }

    /* operator */ public final String component4() {
        return this.campaignName;
    }

    /* operator */ public final int component5() {
        return this.score;
    }

    /* operator */ public final String component6() {
        return this.comment;
    }

    /* operator */ public final String component7() {
        return this.locale;
    }

    /* operator */ public final long component8() {
        return this.timestamp;
    }

    /* operator */ public final String component9() {
        return this.appVersion;
    }

    public final InAppFeedbackModel copy(String userId, String dogId, String campaignId, String campaignName, int score, String comment, String locale, long timestamp, String appVersion, String platform, InAppFeedbackExtras extra) {
        n.f(userId, "userId");
        final Object dogId2 = dogId;
        n.f(dogId2, "dogId");
        final Object campaignId2 = campaignId;
        n.f(campaignId2, "campaignId");
        final Object campaignName2 = campaignName;
        n.f(campaignName2, "campaignName");
        final Object comment2 = comment;
        n.f(comment2, "comment");
        final Object locale2 = locale;
        n.f(locale2, "locale");
        final Object platform2 = appVersion;
        n.f(platform2, "appVersion");
        final Object extra2 = platform;
        n.f(extra2, "platform");
        InAppFeedbackModel inAppFeedbackModel = new InAppFeedbackModel(userId, dogId2, campaignId2, campaignName2, score, comment2, locale2, timestamp, str9, platform2, extra2, extra);
        return inAppFeedbackModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z11 = false;
        if (!(other instanceof InAppFeedbackModel)) {
            return false;
        }
        if (!n.b(this.userId, other.userId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.campaignId, other.campaignId)) {
            return false;
        }
        if (!n.b(this.campaignName, other.campaignName)) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (!n.b(this.comment, other.comment)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        if (!n.b(this.appVersion, other.appVersion)) {
            return false;
        }
        if (!n.b(this.platform, other.platform)) {
            return false;
        }
        return !n.b(this.extra, other.extra) ? z11 : z;
    }

    public int hashCode() {
        int i = 0;
        if (this.extra == null) {
            i = 0;
        } else {
            i = this.extra.hashCode();
        }
        return (this.userId.hashCode() * 31) + this.dogId.hashCode() * 31 + this.campaignId.hashCode() * 31 + this.campaignName.hashCode() * 31 + Integer.hashCode(this.score) * 31 + this.comment.hashCode() * 31 + this.locale.hashCode() * 31 + Long.hashCode(this.timestamp) * 31 + this.appVersion.hashCode() * 31 + this.platform.hashCode() * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "InAppFeedbackModel(userId=";
        String str3 = ", dogId=";
        String str4 = ", campaignId=";
        String str5 = ", campaignName=";
        String str6 = ", score=";
        String str7 = ", comment=";
        String str8 = ", locale=";
        String str9 = ", timestamp=";
        String str10 = ", appVersion=";
        String str11 = ", platform=";
        String str12 = ", extra=";
        str = str2 + this.userId + str3 + this.dogId + str4 + this.campaignId + str5 + this.campaignName + str6 + this.score + str7 + this.comment + str8 + this.locale + str9 + this.timestamp + str10 + this.appVersion + str11 + this.platform + str12 + this.extra + 41;
        return str;
    }
}
