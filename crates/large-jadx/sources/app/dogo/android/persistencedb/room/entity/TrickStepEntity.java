package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006 ", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "", "stepId", "", "description", "image", "locale", "updatedAt", "", "locale_stepId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getImage", "getLocale", "getLocale_stepId", "getStepId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickStepEntity {

    private final String description;
    private final String image;
    private final String locale;
    private final String locale_stepId;
    private final String stepId;
    private final long updatedAt;
    public TrickStepEntity(String string, String string2, String string3, String string4, long l5, String string6) {
        n.f(string, "stepId");
        n.f(string2, "description");
        n.f(string3, "image");
        n.f(string4, "locale");
        n.f(obj8, "locale_stepId");
        super();
        this.stepId = string;
        this.description = string2;
        this.image = string3;
        this.locale = string4;
        this.updatedAt = l5;
        this.locale_stepId = obj8;
    }

    public TrickStepEntity(String string, String string2, String string3, String string4, long l5, String string6, int i7, g g8) {
        String string5;
        int i;
        String str2;
        String str3;
        String str;
        if (g8 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str3 = string4;
            stringBuilder.append(string4);
            stringBuilder.append('_');
            str2 = string;
            stringBuilder.append(string);
            str = string5;
        } else {
            str2 = string;
            str3 = string4;
            str = i7;
        }
        super(string, string2, string3, string4, l5, obj7, str);
    }

    public static app.dogo.android.persistencedb.room.entity.TrickStepEntity copy$default(app.dogo.android.persistencedb.room.entity.TrickStepEntity trickStepEntity, String string2, String string3, String string4, String string5, long l6, String string7, int i8, Object object9) {
        String obj6;
        String obj7;
        String obj8;
        String obj9;
        long obj10;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = trickStepEntity.stepId;
        }
        if (object9 & 2 != 0) {
            obj7 = trickStepEntity.description;
        }
        if (object9 & 4 != 0) {
            obj8 = trickStepEntity.image;
        }
        if (object9 & 8 != 0) {
            obj9 = trickStepEntity.locale;
        }
        if (object9 & 16 != 0) {
            obj10 = trickStepEntity.updatedAt;
        }
        if (object9 & 32 != 0) {
            obj12 = trickStepEntity.locale_stepId;
        }
        return trickStepEntity.copy(obj6, obj7, obj8, obj9, obj10, object9);
    }

    public final String component1() {
        return this.stepId;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.locale;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final String component6() {
        return this.locale_stepId;
    }

    public final app.dogo.android.persistencedb.room.entity.TrickStepEntity copy(String string, String string2, String string3, String string4, long l5, String string6) {
        n.f(string, "stepId");
        n.f(string2, "description");
        n.f(string3, "image");
        n.f(string4, "locale");
        final Object obj = obj16;
        n.f(obj, "locale_stepId");
        super(string, string2, string3, string4, l5, obj7, obj);
        return trickStepEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickStepEntity) {
            return i2;
        }
        if (!n.b(this.stepId, object.stepId)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
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

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickStepEntity(stepId=");
        stringBuilder.append(this.stepId);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_stepId=");
        stringBuilder.append(this.locale_stepId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
