package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LessonEntity.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/LessonEntity;", "", "lessonId", "", "index", "", "locale", "programId", "updatedAt", "", "locale_lessonId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getIndex", "()I", "getLessonId", "()Ljava/lang/String;", "getLocale", "getLocale_lessonId", "getProgramId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LessonEntity {

    private final int index;
    private final String lessonId;
    private final String locale;
    private final String locale_lessonId;
    private final String programId;
    private final long updatedAt;
    public LessonEntity(String str, int i, String str2, String str3, long j, String str4) {
        n.f(str, "lessonId");
        n.f(str2, "locale");
        n.f(str3, "programId");
        n.f(str4, "locale_lessonId");
        super();
        this.lessonId = str;
        this.index = i;
        this.locale = str2;
        this.programId = str3;
        this.updatedAt = j;
        this.locale_lessonId = str4;
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

    public /* synthetic */ LessonEntity(String str, int i, String str2, String str3, long j, String str4, int i2, g gVar) {
        String i72;
        if (i2 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str32 = str2;
            char c = '_';
            str2 = str;
            i72 = str2 + c + str;
        } else {
            str2 = str;
            str32 = str2;
            i72 = str4;
        }
        this(str, i, str2, str3, j, str7, i72);
    }

    public static /* synthetic */ LessonEntity copy$default(LessonEntity lessonEntity, String str, int i, String str2, String str3, long j, String str4, int i2, Object object) {
        String str22;
        int i32;
        String str42;
        String str52;
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
        return lessonEntity.copy(str22, i32, str42, str52, j62, i82);
    }

    /* operator */ public final String component1() {
        return this.lessonId;
    }

    /* operator */ public final int component2() {
        return this.index;
    }

    /* operator */ public final String component3() {
        return this.locale;
    }

    /* operator */ public final String component4() {
        return this.programId;
    }

    /* operator */ public final long component5() {
        return this.updatedAt;
    }

    /* operator */ public final String component6() {
        return this.locale_lessonId;
    }

    public final LessonEntity copy(String lessonId, int index, String locale, String programId, long updatedAt, String locale_lessonId) {
        n.f(lessonId, "lessonId");
        n.f(locale, "locale");
        n.f(programId, "programId");
        final Object obj = locale_lessonId;
        n.f(obj, "locale_lessonId");
        LessonEntity lessonEntity = new LessonEntity(lessonId, index, locale, programId, updatedAt, str5, obj);
        return lessonEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof LessonEntity)) {
            return false;
        }
        if (!n.b(this.lessonId, other.lessonId)) {
            return false;
        }
        if (this.index != other.index) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale_lessonId, other.locale_lessonId) ? z6 : z;
    }

    public int hashCode() {
        return (this.lessonId.hashCode() * 31) + Integer.hashCode(this.index) * 31 + this.locale.hashCode() * 31 + this.programId.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_lessonId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonEntity(lessonId=";
        String str3 = ", index=";
        String str4 = ", locale=";
        String str5 = ", programId=";
        String str6 = ", updatedAt=";
        String str7 = ", locale_lessonId=";
        str = str2 + this.lessonId + str3 + this.index + str4 + this.locale + str5 + this.programId + str6 + this.updatedAt + str7 + this.locale_lessonId + 41;
        return str;
    }
}
