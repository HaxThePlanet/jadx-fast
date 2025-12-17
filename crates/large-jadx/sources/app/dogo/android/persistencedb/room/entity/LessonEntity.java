package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "", "lessonId", "", "index", "", "locale", "programId", "updatedAt", "", "locale_lessonId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getIndex", "()I", "getLessonId", "()Ljava/lang/String;", "getLocale", "getLocale_lessonId", "getProgramId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LessonEntity {

    private final int index;
    private final String lessonId;
    private final String locale;
    private final String locale_lessonId;
    private final String programId;
    private final long updatedAt;
    public LessonEntity(String string, int i2, String string3, String string4, long l5, String string6) {
        n.f(string, "lessonId");
        n.f(string3, "locale");
        n.f(string4, "programId");
        n.f(obj8, "locale_lessonId");
        super();
        this.lessonId = string;
        this.index = i2;
        this.locale = string3;
        this.programId = string4;
        this.updatedAt = l5;
        this.locale_lessonId = obj8;
    }

    public LessonEntity(String string, int i2, String string3, String string4, long l5, String string6, int i7, g g8) {
        String string2;
        int i;
        String str;
        String str2;
        String str3;
        if (g8 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = string3;
            stringBuilder.append(string3);
            stringBuilder.append('_');
            str = string;
            stringBuilder.append(string);
            str3 = string2;
        } else {
            str = string;
            str2 = string3;
            str3 = i7;
        }
        super(string, i2, string3, string4, l5, obj7, str3);
    }

    public static app.dogo.android.persistencedb.room.entity.LessonEntity copy$default(app.dogo.android.persistencedb.room.entity.LessonEntity lessonEntity, String string2, int i3, String string4, String string5, long l6, String string7, int i8, Object object9) {
        String obj6;
        int obj7;
        String obj8;
        String obj9;
        long obj10;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = lessonEntity.lessonId;
        }
        if (object9 & 2 != 0) {
            obj7 = lessonEntity.index;
        }
        if (object9 & 4 != 0) {
            obj8 = lessonEntity.locale;
        }
        if (object9 & 8 != 0) {
            obj9 = lessonEntity.programId;
        }
        if (object9 & 16 != 0) {
            obj10 = lessonEntity.updatedAt;
        }
        if (object9 & 32 != 0) {
            obj12 = lessonEntity.locale_lessonId;
        }
        return lessonEntity.copy(obj6, obj7, obj8, obj9, obj10, object9);
    }

    public final String component1() {
        return this.lessonId;
    }

    public final int component2() {
        return this.index;
    }

    public final String component3() {
        return this.locale;
    }

    public final String component4() {
        return this.programId;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final String component6() {
        return this.locale_lessonId;
    }

    public final app.dogo.android.persistencedb.room.entity.LessonEntity copy(String string, int i2, String string3, String string4, long l5, String string6) {
        n.f(string, "lessonId");
        n.f(string3, "locale");
        n.f(string4, "programId");
        final Object obj = obj16;
        n.f(obj, "locale_lessonId");
        super(string, i2, string3, string4, l5, obj7, obj);
        return lessonEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LessonEntity) {
            return i2;
        }
        if (!n.b(this.lessonId, object.lessonId)) {
            return i2;
        }
        if (this.index != object.index) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_lessonId, object.locale_lessonId)) {
            return i2;
        }
        return i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getLessonId() {
        return this.lessonId;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_lessonId() {
        return this.locale_lessonId;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonEntity(lessonId=");
        stringBuilder.append(this.lessonId);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_lessonId=");
        stringBuilder.append(this.locale_lessonId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
