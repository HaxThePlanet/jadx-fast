package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickTagEntity.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;", "", "tagId", "", "locale", "name", "updatedAt", "", "locale_tagId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "getLocale_tagId", "getName", "getTagId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickTagEntity {

    private final String locale;
    private final String locale_tagId;
    private final String name;
    private final String tagId;
    private final long updatedAt;
    public TrickTagEntity(String str, String str2, String str3, long j, String str4) {
        n.f(str, "tagId");
        n.f(str2, "locale");
        n.f(str3, "name");
        n.f(str4, "locale_tagId");
        super();
        this.tagId = str;
        this.locale = str2;
        this.name = str3;
        this.updatedAt = j;
        this.locale_tagId = str4;
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

    public /* synthetic */ TrickTagEntity(String str, String str2, String str3, long j, String str4, int i, g gVar) {
        String i62;
        i = i & 16;
        if (i & 16 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            char c = '_';
            i62 = str2 + c + str;
        }
        this(str, str2, str3, j, str7, i62);
    }

    public static /* synthetic */ TrickTagEntity copy$default(TrickTagEntity trickTagEntity, String str, String str2, String str3, long j, String str4, int i, Object object) {
        String str22;
        String str32;
        String str42;
        long j52;
        String i72;
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
        return trickTagEntity.copy(str22, str32, str42, j52, i72);
    }

    /* operator */ public final String component1() {
        return this.tagId;
    }

    /* operator */ public final String component2() {
        return this.locale;
    }

    /* operator */ public final String component3() {
        return this.name;
    }

    /* operator */ public final long component4() {
        return this.updatedAt;
    }

    /* operator */ public final String component5() {
        return this.locale_tagId;
    }

    public final TrickTagEntity copy(String tagId, String locale, String name, long updatedAt, String locale_tagId) {
        n.f(tagId, "tagId");
        n.f(locale, "locale");
        n.f(name, "name");
        n.f(locale_tagId, "locale_tagId");
        TrickTagEntity trickTagEntity = new TrickTagEntity(tagId, locale, name, updatedAt, str5, locale_tagId);
        return trickTagEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof TrickTagEntity)) {
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
        return (this.tagId.hashCode() * 31) + this.locale.hashCode() * 31 + this.name.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_tagId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickTagEntity(tagId=";
        String str3 = ", locale=";
        String str4 = ", name=";
        String str5 = ", updatedAt=";
        String str6 = ", locale_tagId=";
        str = str2 + this.tagId + str3 + this.locale + str4 + this.name + str5 + this.updatedAt + str6 + this.locale_tagId + 41;
        return str;
    }
}
