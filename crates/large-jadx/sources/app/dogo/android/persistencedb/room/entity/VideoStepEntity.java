package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: VideoStepEntity.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "", "stepId", "", "text", "locale", "startTime", "", "updatedAt", "", "locale_stepId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getLocale_stepId", "getStartTime", "()I", "getStepId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class VideoStepEntity {

    private final String locale;
    private final String locale_stepId;
    private final int startTime;
    private final String stepId;
    private final String text;
    private final long updatedAt;
    public VideoStepEntity(String str, String str2, String str3, int i, long j, String str4) {
        n.f(str, "stepId");
        n.f(str2, "text");
        n.f(str3, "locale");
        n.f(str4, "locale_stepId");
        super();
        this.stepId = str;
        this.text = str2;
        this.locale = str3;
        this.startTime = i;
        this.updatedAt = j;
        this.locale_stepId = str4;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_stepId() {
        return this.locale_stepId;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public final String getText() {
        return this.text;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ VideoStepEntity(String str, String str2, String str3, int i, long j, String str4, int i2, g gVar) {
        String i72;
        if (i2 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str32 = str3;
            char c = '_';
            str4 = str;
            i72 = str3 + c + str;
        } else {
            str4 = str;
            str32 = str3;
            i72 = str4;
        }
        this(str, str2, str3, i, j, str7, i72);
    }

    public static /* synthetic */ VideoStepEntity copy$default(VideoStepEntity videoStepEntity, String str, String str2, String str3, int i, long j, String str4, int i2, Object object) {
        String str22;
        String str32;
        String str42;
        int i52;
        long j62;
        String i82;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        if (i2 & 8 != 0) {
        }
        if (i2 & 16 != 0) {
        }
        if (i2 & 32 != 0) {
        }
        return videoStepEntity.copy(str22, str32, str42, i52, j62, i82);
    }

    /* operator */ public final String component1() {
        return this.stepId;
    }

    /* operator */ public final String component2() {
        return this.text;
    }

    /* operator */ public final String component3() {
        return this.locale;
    }

    /* operator */ public final int component4() {
        return this.startTime;
    }

    /* operator */ public final long component5() {
        return this.updatedAt;
    }

    /* operator */ public final String component6() {
        return this.locale_stepId;
    }

    public final VideoStepEntity copy(String stepId, String text, String locale, int startTime, long updatedAt, String locale_stepId) {
        n.f(stepId, "stepId");
        n.f(text, "text");
        n.f(locale, "locale");
        final Object obj = locale_stepId;
        n.f(obj, "locale_stepId");
        VideoStepEntity videoStepEntity = new VideoStepEntity(stepId, text, locale, startTime, updatedAt, str5, obj);
        return videoStepEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof VideoStepEntity)) {
            return false;
        }
        if (!n.b(this.stepId, other.stepId)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (this.startTime != other.startTime) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale_stepId, other.locale_stepId) ? z6 : z;
    }

    public int hashCode() {
        return (this.stepId.hashCode() * 31) + this.text.hashCode() * 31 + this.locale.hashCode() * 31 + Integer.hashCode(this.startTime) * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_stepId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "VideoStepEntity(stepId=";
        String str3 = ", text=";
        String str4 = ", locale=";
        String str5 = ", startTime=";
        String str6 = ", updatedAt=";
        String str7 = ", locale_stepId=";
        str = str2 + this.stepId + str3 + this.text + str4 + this.locale + str5 + this.startTime + str6 + this.updatedAt + str7 + this.locale_stepId + 41;
        return str;
    }
}
