package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickCategoryEntity;", "", "categoryId", "", "locale", "name", "updatedAt", "", "locale_categoryId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getLocale", "getLocale_categoryId", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickCategoryEntity {

    private final String categoryId;
    private final String locale;
    private final String locale_categoryId;
    private final String name;
    private final long updatedAt;
    public TrickCategoryEntity(String string, String string2, String string3, long l4, String string5) {
        n.f(string, "categoryId");
        n.f(string2, "locale");
        n.f(string3, "name");
        n.f(obj7, "locale_categoryId");
        super();
        this.categoryId = string;
        this.locale = string2;
        this.name = string3;
        this.updatedAt = l4;
        this.locale_categoryId = obj7;
    }

    public TrickCategoryEntity(String string, String string2, String string3, long l4, String string5, int i6, g g7) {
        String obj13;
        int obj14;
        if (g7 &= 16 != 0) {
            obj13 = new StringBuilder();
            obj13.append(string2);
            obj13.append('_');
            obj13.append(string);
            obj13 = obj13.toString();
        }
        super(string, string2, string3, l4, obj5, obj13);
    }

    public static app.dogo.android.persistencedb.room.entity.TrickCategoryEntity copy$default(app.dogo.android.persistencedb.room.entity.TrickCategoryEntity trickCategoryEntity, String string2, String string3, String string4, long l5, String string6, int i7, Object object8) {
        String obj5;
        String obj6;
        String obj7;
        long obj8;
        String obj10;
        if (object8 & 1 != 0) {
            obj5 = trickCategoryEntity.categoryId;
        }
        if (object8 & 2 != 0) {
            obj6 = trickCategoryEntity.locale;
        }
        if (object8 & 4 != 0) {
            obj7 = trickCategoryEntity.name;
        }
        if (object8 & 8 != 0) {
            obj8 = trickCategoryEntity.updatedAt;
        }
        if (object8 & 16 != 0) {
            obj10 = trickCategoryEntity.locale_categoryId;
        }
        return trickCategoryEntity.copy(obj5, obj6, obj7, obj8, object8);
    }

    public final String component1() {
        return this.categoryId;
    }

    public final String component2() {
        return this.locale;
    }

    public final String component3() {
        return this.name;
    }

    public final long component4() {
        return this.updatedAt;
    }

    public final String component5() {
        return this.locale_categoryId;
    }

    public final app.dogo.android.persistencedb.room.entity.TrickCategoryEntity copy(String string, String string2, String string3, long l4, String string5) {
        n.f(string, "categoryId");
        n.f(string2, "locale");
        n.f(string3, "name");
        n.f(obj14, "locale_categoryId");
        super(string, string2, string3, l4, obj6, obj14);
        return trickCategoryEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickCategoryEntity) {
            return i2;
        }
        if (!n.b(this.categoryId, object.categoryId)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_categoryId, object.locale_categoryId)) {
            return i2;
        }
        return i;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_categoryId() {
        return this.locale_categoryId;
    }

    public final String getName() {
        return this.name;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickCategoryEntity(categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_categoryId=");
        stringBuilder.append(this.locale_categoryId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
