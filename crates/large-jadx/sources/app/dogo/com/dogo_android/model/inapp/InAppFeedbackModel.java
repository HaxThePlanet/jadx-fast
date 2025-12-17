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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0008HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000cHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003Jy\u0010,\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0008HÖ\u0001J\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000102J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0013¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/model/inapp/InAppFeedbackModel;", "", "userId", "", "dogId", "campaignId", "campaignName", "score", "", "comment", "locale", "timestamp", "", "appVersion", "platform", "extra", "Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;)V", "getAppVersion", "()Ljava/lang/String;", "getCampaignId", "getCampaignName", "getComment", "getDogId", "getExtra", "()Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "getLocale", "getPlatform", "getScore", "()I", "getTimestamp", "()J", "getUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toMap", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppFeedbackModel {

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
    public InAppFeedbackModel(String string, String string2, String string3, String string4, int i5, String string6, String string7, long l8, String string9, String string10, InAppFeedbackExtras inAppFeedbackExtras11) {
        n.f(string, "userId");
        n.f(string2, "dogId");
        n.f(string3, "campaignId");
        n.f(string4, "campaignName");
        n.f(string6, "comment");
        n.f(string7, "locale");
        n.f(string10, "appVersion");
        n.f(inAppFeedbackExtras11, "platform");
        super();
        this.userId = string;
        this.dogId = string2;
        this.campaignId = string3;
        this.campaignName = string4;
        this.score = i5;
        this.comment = string6;
        this.locale = string7;
        this.timestamp = l8;
        this.appVersion = string10;
        this.platform = inAppFeedbackExtras11;
        this.extra = obj13;
    }

    public InAppFeedbackModel(String string, String string2, String string3, String string4, int i5, String string6, String string7, long l8, String string9, String string10, InAppFeedbackExtras inAppFeedbackExtras11, int i12, g g13) {
        String str4;
        int currentTimeMillis;
        int str;
        long l;
        String str2;
        String str3;
        int i = g13;
        if (i & 128 != 0) {
            l = currentTimeMillis;
        } else {
            l = l8;
        }
        str2 = i & 256 != 0 ? str : string10;
        str3 = i &= 512 != 0 ? str4 : inAppFeedbackExtras11;
        super(string, string2, string3, string4, i5, string6, string7, l, obj12, str2, str3, i12);
    }

    public static app.dogo.com.dogo_android.model.inapp.InAppFeedbackModel copy$default(app.dogo.com.dogo_android.model.inapp.InAppFeedbackModel inAppFeedbackModel, String string2, String string3, String string4, String string5, int i6, String string7, String string8, long l9, String string10, String string11, InAppFeedbackExtras inAppFeedbackExtras12, int i13, Object object14) {
        InAppFeedbackExtras extra;
        String userId;
        String dogId;
        String campaignId;
        String campaignName;
        int score;
        String comment;
        String locale;
        long timestamp;
        String appVersion;
        String platform;
        Object obj = inAppFeedbackModel;
        int i = object14;
        userId = i & 1 != 0 ? obj.userId : string2;
        dogId = i & 2 != 0 ? obj.dogId : string3;
        campaignId = i & 4 != 0 ? obj.campaignId : string4;
        campaignName = i & 8 != 0 ? obj.campaignName : string5;
        score = i & 16 != 0 ? obj.score : i6;
        comment = i & 32 != 0 ? obj.comment : string7;
        locale = i & 64 != 0 ? obj.locale : string8;
        timestamp = i & 128 != 0 ? obj.timestamp : l9;
        appVersion = i & 256 != 0 ? obj.appVersion : string11;
        platform = i & 512 != 0 ? obj.platform : inAppFeedbackExtras12;
        extra = i &= 1024 != 0 ? obj.extra : i13;
        return inAppFeedbackModel.copy(userId, dogId, campaignId, campaignName, score, comment, locale, timestamp, string10, appVersion, platform);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.platform;
    }

    public final InAppFeedbackExtras component11() {
        return this.extra;
    }

    public final String component2() {
        return this.dogId;
    }

    public final String component3() {
        return this.campaignId;
    }

    public final String component4() {
        return this.campaignName;
    }

    public final int component5() {
        return this.score;
    }

    public final String component6() {
        return this.comment;
    }

    public final String component7() {
        return this.locale;
    }

    public final long component8() {
        return this.timestamp;
    }

    public final String component9() {
        return this.appVersion;
    }

    public final app.dogo.com.dogo_android.model.inapp.InAppFeedbackModel copy(String string, String string2, String string3, String string4, int i5, String string6, String string7, long l8, String string9, String string10, InAppFeedbackExtras inAppFeedbackExtras11) {
        n.f(string, "userId");
        final Object obj = string2;
        n.f(obj, "dogId");
        final Object obj2 = string3;
        n.f(obj2, "campaignId");
        final Object obj3 = string4;
        n.f(obj3, "campaignName");
        final Object obj4 = string6;
        n.f(obj4, "comment");
        final Object obj5 = string7;
        n.f(obj5, "locale");
        final Object obj6 = string10;
        n.f(obj6, "appVersion");
        final Object obj7 = inAppFeedbackExtras11;
        n.f(obj7, "platform");
        super(string, obj, obj2, obj3, i5, obj4, obj5, l8, obj10, obj6, obj7, obj26);
        return inAppFeedbackModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof InAppFeedbackModel) {
            return i2;
        }
        if (!n.b(this.userId, object.userId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.campaignId, object.campaignId)) {
            return i2;
        }
        if (!n.b(this.campaignName, object.campaignName)) {
            return i2;
        }
        if (this.score != object.score) {
            return i2;
        }
        if (!n.b(this.comment, object.comment)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (Long.compare(timestamp, timestamp2) != 0) {
            return i2;
        }
        if (!n.b(this.appVersion, object.appVersion)) {
            return i2;
        }
        if (!n.b(this.platform, object.platform)) {
            return i2;
        }
        if (!n.b(this.extra, object.extra)) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        int i;
        InAppFeedbackExtras extra = this.extra;
        if (extra == null) {
            i = 0;
        } else {
            i = extra.hashCode();
        }
        return i21 += i;
    }

    public final Map<String, Object> toMap() {
        Integer valueOf;
        int map;
        o[] value2;
        int value;
        o oVar;
        int str;
        int score = this.score;
        if (score > 0) {
            valueOf = Integer.valueOf(score);
        } else {
            valueOf = map;
        }
        value2 = new o[11];
        o oVar2 = new o("userId", this.userId);
        str = 0;
        value2[str] = oVar2;
        o oVar3 = new o("dogId", this.dogId);
        int i11 = 1;
        value2[i11] = oVar3;
        o oVar9 = new o("campaignId", this.campaignId);
        value2[2] = oVar9;
        o oVar10 = new o("campaignName", this.campaignName);
        value2[3] = oVar10;
        o oVar11 = new o("score", valueOf);
        value2[4] = oVar11;
        o oVar4 = new o("comment", this.comment);
        value2[5] = oVar4;
        String str7 = "locale";
        o oVar5 = new o(str7, this.locale);
        value2[6] = oVar5;
        o oVar6 = new o("timestamp", Long.valueOf(this.timestamp));
        value2[7] = oVar6;
        o oVar7 = new o("appVersion", this.appVersion);
        value2[8] = oVar7;
        o oVar8 = new o("platform", this.platform);
        value2[9] = oVar8;
        InAppFeedbackExtras extra = this.extra;
        if (extra == null) {
        } else {
            map = extra.toMap();
        }
        oVar = new o("extra", map);
        value2[10] = oVar;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator iterator = j0.k(value2).entrySet().iterator();
        while (iterator.hasNext()) {
            value2 = iterator.next();
            if ((Map.Entry)value2.getValue() != null) {
            } else {
            }
            oVar = str;
            if (oVar != null) {
            }
            linkedHashMap2.put(value2.getKey(), value2.getValue());
            oVar = i11;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(linkedHashMap2.size()));
        Iterator iterator2 = linkedHashMap2.entrySet().iterator();
        for (Map.Entry next3 : iterator2) {
            value = next3.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Any");
            linkedHashMap.put(next3.getKey(), value);
        }
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InAppFeedbackModel(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", campaignId=");
        stringBuilder.append(this.campaignId);
        stringBuilder.append(", campaignName=");
        stringBuilder.append(this.campaignName);
        stringBuilder.append(", score=");
        stringBuilder.append(this.score);
        stringBuilder.append(", comment=");
        stringBuilder.append(this.comment);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", appVersion=");
        stringBuilder.append(this.appVersion);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", extra=");
        stringBuilder.append(this.extra);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
