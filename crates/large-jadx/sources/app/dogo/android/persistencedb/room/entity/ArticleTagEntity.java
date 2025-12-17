package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;", "", "hidden", "", "tagId", "", "locale", "name", "updatedAt", "", "locale_tagId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getHidden", "()Z", "getLocale", "()Ljava/lang/String;", "getLocale_tagId", "getName", "getTagId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ArticleTagEntity {

    private final boolean hidden;
    private final String locale;
    private final String locale_tagId;
    private final String name;
    private final String tagId;
    private final long updatedAt;
    public ArticleTagEntity(boolean z, String string2, String string3, String string4, long l5, String string6) {
        n.f(string2, "tagId");
        n.f(string3, "locale");
        n.f(string4, "name");
        n.f(obj8, "locale_tagId");
        super();
        this.hidden = z;
        this.tagId = string2;
        this.locale = string3;
        this.name = string4;
        this.updatedAt = l5;
        this.locale_tagId = obj8;
    }

    public ArticleTagEntity(boolean z, String string2, String string3, String string4, long l5, String string6, int i7, g g8) {
        String string;
        int i;
        String str3;
        String str2;
        String str;
        if (g8 & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = string3;
            stringBuilder.append(string3);
            stringBuilder.append('_');
            str3 = string2;
            stringBuilder.append(string2);
            str = string;
        } else {
            str3 = string2;
            str2 = string3;
            str = i7;
        }
        super(z, string2, string3, string4, l5, obj7, str);
    }

    public static app.dogo.android.persistencedb.room.entity.ArticleTagEntity copy$default(app.dogo.android.persistencedb.room.entity.ArticleTagEntity articleTagEntity, boolean z2, String string3, String string4, String string5, long l6, String string7, int i8, Object object9) {
        boolean obj6;
        String obj7;
        String obj8;
        String obj9;
        long obj10;
        String obj12;
        if (object9 & 1 != 0) {
            obj6 = articleTagEntity.hidden;
        }
        if (object9 & 2 != 0) {
            obj7 = articleTagEntity.tagId;
        }
        if (object9 & 4 != 0) {
            obj8 = articleTagEntity.locale;
        }
        if (object9 & 8 != 0) {
            obj9 = articleTagEntity.name;
        }
        if (object9 & 16 != 0) {
            obj10 = articleTagEntity.updatedAt;
        }
        if (object9 & 32 != 0) {
            obj12 = articleTagEntity.locale_tagId;
        }
        return articleTagEntity.copy(obj6, obj7, obj8, obj9, obj10, object9);
    }

    public final boolean component1() {
        return this.hidden;
    }

    public final String component2() {
        return this.tagId;
    }

    public final String component3() {
        return this.locale;
    }

    public final String component4() {
        return this.name;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final String component6() {
        return this.locale_tagId;
    }

    public final app.dogo.android.persistencedb.room.entity.ArticleTagEntity copy(boolean z, String string2, String string3, String string4, long l5, String string6) {
        n.f(string2, "tagId");
        n.f(string3, "locale");
        n.f(string4, "name");
        final Object obj = obj16;
        n.f(obj, "locale_tagId");
        super(z, string2, string3, string4, l5, obj7, obj);
        return articleTagEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ArticleTagEntity) {
            return i2;
        }
        if (this.hidden != object.hidden) {
            return i2;
        }
        if (!n.b(this.tagId, object.tagId)) {
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
        if (!n.b(this.locale_tagId, object.locale_tagId)) {
            return i2;
        }
        return i;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_tagId() {
        return this.locale_tagId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        boolean hidden;
        if (this.hidden) {
            hidden = 1;
        }
        return i9 += i15;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArticleTagEntity(hidden=");
        stringBuilder.append(this.hidden);
        stringBuilder.append(", tagId=");
        stringBuilder.append(this.tagId);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_tagId=");
        stringBuilder.append(this.locale_tagId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
