package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "", "stepId", "", "text", "locale", "startTime", "", "updatedAt", "", "locale_stepId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getLocale_stepId", "getStartTime", "()I", "getStepId", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VideoStepEntity {

    private final String locale;
    private final String locale_stepId;
    private final int startTime;
    private final String stepId;
    private final String text;
    private final long updatedAt;
    public VideoStepEntity(String string, String string2, String string3, int i4, long l5, String string6) {
        n.f(string, "stepId");
        n.f(string2, "text");
        n.f(string3, "locale");
        n.f(obj8, "locale_stepId");
        super();
        this.stepId = string;
        this.text = string2;
        this.locale = string3;
        this.startTime = i4;
        this.updatedAt = l5;
        this.locale_stepId = obj8;
    }

    public VideoStepEntity(String string, String string2, String string3, int i4, long l5, String string6, int i7, g g8) {
        String string4;
        int i;
        String str2;
        String str3;
        String str;
        if (g8 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = string3;
            stringBuilder.append(string3);
            stringBuilder.append('_');
            str2 = string;
            stringBuilder.append(string);
            str = string4;
        } else {
            str2 = string;
            str3 = string3;
            str = i7;
        }
        super(string, string2, string3, i4, l5, obj7, str);
    }

    public static app.dogo.android.persistencedb.room.entity.VideoStepEntity copy$default(app.dogo.android.persistencedb.room.entity.VideoStepEntity videoStepEntity, String string2, String string3, String string4, int i5, long l6, String string7, int i8, Object object9) {
        String obj6;
        String obj7;
        String obj8;
        int obj9;
        long obj10;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = videoStepEntity.stepId;
        }
        if (object9 & 2 != 0) {
            obj7 = videoStepEntity.text;
        }
        if (object9 & 4 != 0) {
            obj8 = videoStepEntity.locale;
        }
        if (object9 & 8 != 0) {
            obj9 = videoStepEntity.startTime;
        }
        if (object9 & 16 != 0) {
            obj10 = videoStepEntity.updatedAt;
        }
        if (object9 & 32 != 0) {
            obj12 = videoStepEntity.locale_stepId;
        }
        return videoStepEntity.copy(obj6, obj7, obj8, obj9, obj10, object9);
    }

    public final String component1() {
        return this.stepId;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.locale;
    }

    public final int component4() {
        return this.startTime;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final String component6() {
        return this.locale_stepId;
    }

    public final app.dogo.android.persistencedb.room.entity.VideoStepEntity copy(String string, String string2, String string3, int i4, long l5, String string6) {
        n.f(string, "stepId");
        n.f(string2, "text");
        n.f(string3, "locale");
        final Object obj = obj16;
        n.f(obj, "locale_stepId");
        super(string, string2, string3, i4, l5, obj7, obj);
        return videoStepEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof VideoStepEntity) {
            return i2;
        }
        if (!n.b(this.stepId, object.stepId)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (this.startTime != object.startTime) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_stepId, object.locale_stepId)) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoStepEntity(stepId=");
        stringBuilder.append(this.stepId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_stepId=");
        stringBuilder.append(this.locale_stepId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
