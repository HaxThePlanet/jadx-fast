package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ArticleTagEntity.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006!", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ArticleTagEntity;", "", "hidden", "", "tagId", "", "locale", "name", "updatedAt", "", "locale_tagId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getHidden", "()Z", "getLocale", "()Ljava/lang/String;", "getLocale_tagId", "getName", "getTagId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ArticleTagEntity {

    private final boolean hidden;
    private final String locale;
    private final String locale_tagId;
    private final String name;
    private final String tagId;
    private final long updatedAt;
    public ArticleTagEntity(boolean z, String str, String str2, String str3, long j, String str4) {
        n.f(str, "tagId");
        n.f(str2, "locale");
        n.f(str3, "name");
        n.f(str4, "locale_tagId");
        super();
        this.hidden = z;
        this.tagId = str;
        this.locale = str2;
        this.name = str3;
        this.updatedAt = j;
        this.locale_tagId = str4;
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

    public /* synthetic */ ArticleTagEntity(boolean z, String str, String str2, String str3, long j, String str4, int i, g gVar) {
        String i72;
        if (i & 32 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str32 = str2;
            char c = '_';
            str22 = str;
            i72 = str2 + c + str;
        } else {
            str22 = str;
            str32 = str2;
            i72 = str4;
        }
        this(z, str, str2, str3, j, str, i72);
    }

    public static /* synthetic */ ArticleTagEntity copy$default(ArticleTagEntity articleTagEntity, boolean z, String str, String str2, String str3, long j, String str4, int i, Object object) {
        boolean z22;
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
        return articleTagEntity.copy(z22, str32, str42, str52, j62, i82);
    }

    /* operator */ public final boolean component1() {
        return this.hidden;
    }

    /* operator */ public final String component2() {
        return this.tagId;
    }

    /* operator */ public final String component3() {
        return this.locale;
    }

    /* operator */ public final String component4() {
        return this.name;
    }

    /* operator */ public final long component5() {
        return this.updatedAt;
    }

    /* operator */ public final String component6() {
        return this.locale_tagId;
    }

    public final ArticleTagEntity copy(boolean hidden, String tagId, String locale, String name, long updatedAt, String locale_tagId) {
        n.f(tagId, "tagId");
        n.f(locale, "locale");
        n.f(name, "name");
        final Object obj = locale_tagId;
        n.f(obj, "locale_tagId");
        ArticleTagEntity articleTagEntity = new ArticleTagEntity(hidden, tagId, locale, name, updatedAt, str5, obj);
        return articleTagEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof ArticleTagEntity)) {
            return false;
        }
        if (this.hidden != other.hidden) {
            return false;
        }
        if (!n.b(this.tagId, other.tagId)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale_tagId, other.locale_tagId) ? z6 : z;
    }

    public int hashCode() {
        boolean hidden2 = true;
        if (this.hidden) {
            int i11 = 1;
        }
        return (hidden2 * 31) + this.tagId.hashCode() * 31 + this.locale.hashCode() * 31 + this.name.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_tagId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ArticleTagEntity(hidden=";
        String str3 = ", tagId=";
        String str4 = ", locale=";
        String str5 = ", name=";
        String str6 = ", updatedAt=";
        String str7 = ", locale_tagId=";
        str = str2 + this.hidden + str3 + this.tagId + str4 + this.locale + str5 + this.name + str6 + this.updatedAt + str7 + this.locale_tagId + 41;
        return str;
    }
}
