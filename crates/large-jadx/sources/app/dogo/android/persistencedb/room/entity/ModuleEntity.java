package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ModuleEntity;", "", "moduleId", "", "index", "", "name", "locale", "updatedAt", "", "locale_moduleId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getIndex", "()I", "getLocale", "()Ljava/lang/String;", "getLocale_moduleId", "getModuleId", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ModuleEntity {

    private final int index;
    private final String locale;
    private final String locale_moduleId;
    private final String moduleId;
    private final String name;
    private final long updatedAt;
    public ModuleEntity(String string, int i2, String string3, String string4, long l5, String string6) {
        n.f(string, "moduleId");
        n.f(string3, "name");
        n.f(string4, "locale");
        n.f(obj8, "locale_moduleId");
        super();
        this.moduleId = string;
        this.index = i2;
        this.name = string3;
        this.locale = string4;
        this.updatedAt = l5;
        this.locale_moduleId = obj8;
    }

    public ModuleEntity(String string, int i2, String string3, String string4, long l5, String string6, int i7, g g8) {
        String string2;
        int i;
        String str;
        String str2;
        String str3;
        if (g8 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = string4;
            stringBuilder.append(string4);
            stringBuilder.append('_');
            str = string;
            stringBuilder.append(string);
            str3 = string2;
        } else {
            str = string;
            str2 = string4;
            str3 = i7;
        }
        super(string, i2, string3, string4, l5, obj7, str3);
    }

    public static app.dogo.android.persistencedb.room.entity.ModuleEntity copy$default(app.dogo.android.persistencedb.room.entity.ModuleEntity moduleEntity, String string2, int i3, String string4, String string5, long l6, String string7, int i8, Object object9) {
        String obj6;
        int obj7;
        String obj8;
        String obj9;
        long obj10;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = moduleEntity.moduleId;
        }
        if (object9 & 2 != 0) {
            obj7 = moduleEntity.index;
        }
        if (object9 & 4 != 0) {
            obj8 = moduleEntity.name;
        }
        if (object9 & 8 != 0) {
            obj9 = moduleEntity.locale;
        }
        if (object9 & 16 != 0) {
            obj10 = moduleEntity.updatedAt;
        }
        if (object9 & 32 != 0) {
            obj12 = moduleEntity.locale_moduleId;
        }
        return moduleEntity.copy(obj6, obj7, obj8, obj9, obj10, object9);
    }

    public final String component1() {
        return this.moduleId;
    }

    public final int component2() {
        return this.index;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.locale;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final String component6() {
        return this.locale_moduleId;
    }

    public final app.dogo.android.persistencedb.room.entity.ModuleEntity copy(String string, int i2, String string3, String string4, long l5, String string6) {
        n.f(string, "moduleId");
        n.f(string3, "name");
        n.f(string4, "locale");
        final Object obj = obj16;
        n.f(obj, "locale_moduleId");
        super(string, i2, string3, string4, l5, obj7, obj);
        return moduleEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ModuleEntity) {
            return i2;
        }
        if (!n.b(this.moduleId, object.moduleId)) {
            return i2;
        }
        if (this.index != object.index) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_moduleId, object.locale_moduleId)) {
            return i2;
        }
        return i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_moduleId() {
        return this.locale_moduleId;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getName() {
        return this.name;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i10 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModuleEntity(moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_moduleId=");
        stringBuilder.append(this.locale_moduleId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
