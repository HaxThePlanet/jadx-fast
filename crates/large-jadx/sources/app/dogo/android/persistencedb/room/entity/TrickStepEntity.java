package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickStepEntity.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006 ", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "", "stepId", "", "description", "image", "locale", "updatedAt", "", "locale_stepId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getImage", "getLocale", "getLocale_stepId", "getStepId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickStepEntity {

    private final String description;
    private final String image;
    private final String locale;
    private final String locale_stepId;
    private final String stepId;
    private final long updatedAt;
    public TrickStepEntity(String str, String str2, String str3, String str4, long j, String str5) {
        n.f(str, "stepId");
        n.f(str2, "description");
        n.f(str3, "image");
        n.f(str4, "locale");
        n.f(str5, "locale_stepId");
        super();
        this.stepId = str;
        this.description = str2;
        this.image = str3;
        this.locale = str4;
        this.updatedAt = j;
        this.locale_stepId = str5;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_stepId() {
        return this.locale_stepId;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ TrickStepEntity(String str, String str2, String str3, String str4, long j, String str5, int i, g gVar) {
        String i72;
        if (i & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str42 = str4;
            char c = '_';
            str5 = str;
            i72 = str4 + c + str;
        } else {
            str5 = str;
            str42 = str4;
            i72 = str5;
        }
        this(str, str2, str3, str4, j, str8, i72);
    }

    public static /* synthetic */ TrickStepEntity copy$default(TrickStepEntity trickStepEntity, String str, String str2, String str3, String str4, long j, String str5, int i, Object object) {
        String str22;
        String str32;
        String str42;
        String str52;
        long j62;
        String i82;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        if (i & 32 != 0) {
        }
        return trickStepEntity.copy(str22, str32, str42, str52, j62, i82);
    }

    /* operator */ public final String component1() {
        return this.stepId;
    }

    /* operator */ public final String component2() {
        return this.description;
    }

    /* operator */ public final String component3() {
        return this.image;
    }

    /* operator */ public final String component4() {
        return this.locale;
    }

    /* operator */ public final long component5() {
        return this.updatedAt;
    }

    /* operator */ public final String component6() {
        return this.locale_stepId;
    }

    public final TrickStepEntity copy(String stepId, String description, String image, String locale, long updatedAt, String locale_stepId) {
        n.f(stepId, "stepId");
        n.f(description, "description");
        n.f(image, "image");
        n.f(locale, "locale");
        final Object obj = locale_stepId;
        n.f(obj, "locale_stepId");
        TrickStepEntity trickStepEntity = new TrickStepEntity(stepId, description, image, locale, updatedAt, str6, obj);
        return trickStepEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof TrickStepEntity)) {
            return false;
        }
        if (!n.b(this.stepId, other.stepId)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale_stepId, other.locale_stepId) ? z7 : z;
    }

    public int hashCode() {
        return (this.stepId.hashCode() * 31) + this.description.hashCode() * 31 + this.image.hashCode() * 31 + this.locale.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_stepId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickStepEntity(stepId=";
        String str3 = ", description=";
        String str4 = ", image=";
        String str5 = ", locale=";
        String str6 = ", updatedAt=";
        String str7 = ", locale_stepId=";
        str = str2 + this.stepId + str3 + this.description + str4 + this.image + str5 + this.locale + str6 + this.updatedAt + str7 + this.locale_stepId + 41;
        return str;
    }
}
