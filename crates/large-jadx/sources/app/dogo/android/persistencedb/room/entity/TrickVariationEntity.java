package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickVariationEntity.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0017\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u000f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J_\u0010!\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u000c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000f¨\u0006(", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "", "tips", "", "", "variationId", "title", "description", "locale", "contentfulId", "updatedAt", "", "locale_variationId", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getContentfulId", "()Ljava/lang/String;", "getDescription", "getLocale", "getLocale_variationId", "getTips", "()Ljava/util/List;", "getTitle", "getUpdatedAt", "()J", "getVariationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickVariationEntity {

    private final String contentfulId;
    private final String description;
    private final String locale;
    private final String locale_variationId;
    private final List<String> tips;
    private final String title;
    private final long updatedAt;
    private final String variationId;
    public TrickVariationEntity(List<String> list, String str, String str2, String str3, String str4, String str5, long j, String str6) {
        n.f(list, "tips");
        n.f(str, "variationId");
        n.f(str2, "title");
        n.f(str3, "description");
        n.f(str4, "locale");
        n.f(str5, "contentfulId");
        n.f(str6, "locale_variationId");
        super();
        this.tips = list;
        this.variationId = str;
        this.title = str2;
        this.description = str3;
        this.locale = str4;
        this.contentfulId = str5;
        this.updatedAt = j;
        this.locale_variationId = str6;
    }

    public final String getContentfulId() {
        return this.contentfulId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_variationId() {
        return this.locale_variationId;
    }

    public final List<String> getTips() {
        return this.tips;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getVariationId() {
        return this.variationId;
    }

    public /* synthetic */ TrickVariationEntity(List list, String str, String str2, String str3, String str4, String str5, long j, String str6, int i, g gVar) {
        String i92;
        if (i & 128 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str52 = str4;
            char c = '_';
            str22 = str;
            i92 = str52 + c + str;
        } else {
            str22 = str;
            str52 = str4;
            i92 = str6;
        }
        this(list, str, str2, str3, str4, str5, j, str, i92);
    }

    public static /* synthetic */ TrickVariationEntity copy$default(TrickVariationEntity trickVariationEntity, List list, String str, String str2, String str3, String str4, String str5, long j, String str6, int i, Object object) {
        String i102;
        List list22;
        String str32;
        String str42;
        String str52;
        String str62;
        String str72;
        long j82;
        Object trickVariationEntity2 = trickVariationEntity;
        int object112 = i;
        List r2 = object112 & 1 != 0 ? trickVariationEntity2.tips : list;
        String r3 = object112 & 2 != 0 ? trickVariationEntity2.variationId : str;
        String r4 = object112 & 4 != 0 ? trickVariationEntity2.title : str2;
        String r5 = object112 & 8 != 0 ? trickVariationEntity2.description : str3;
        String r6 = object112 & 16 != 0 ? trickVariationEntity2.locale : str4;
        String r7 = object112 & 32 != 0 ? trickVariationEntity2.contentfulId : str5;
        long r8 = object112 & 64 != 0 ? trickVariationEntity2.updatedAt : j;
        String r1 = object112 & 128 != 0 ? trickVariationEntity2.locale_variationId : str6;
        return trickVariationEntity.copy(list22, str32, str42, str52, str62, str72, j82, r18, (object112 & 128 != 0 ? trickVariationEntity2.locale_variationId : str6));
    }

    /* operator */ public final List<String> component1() {
        return this.tips;
    }

    /* operator */ public final String component2() {
        return this.variationId;
    }

    /* operator */ public final String component3() {
        return this.title;
    }

    /* operator */ public final String component4() {
        return this.description;
    }

    /* operator */ public final String component5() {
        return this.locale;
    }

    /* operator */ public final String component6() {
        return this.contentfulId;
    }

    /* operator */ public final long component7() {
        return this.updatedAt;
    }

    /* operator */ public final String component8() {
        return this.locale_variationId;
    }

    public final TrickVariationEntity copy(List<String> tips, String variationId, String title, String description, String locale, String contentfulId, long updatedAt, String locale_variationId) {
        n.f(tips, "tips");
        n.f(variationId, "variationId");
        n.f(title, "title");
        n.f(description, "description");
        final Object locale2 = locale;
        n.f(locale2, "locale");
        final Object contentfulId2 = contentfulId;
        n.f(contentfulId2, "contentfulId");
        final Object obj = locale_variationId;
        n.f(obj, "locale_variationId");
        TrickVariationEntity trickVariationEntity = new TrickVariationEntity(tips, variationId, title, description, locale2, contentfulId2, updatedAt, str8, obj);
        return trickVariationEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z9 = false;
        if (!(other instanceof TrickVariationEntity)) {
            return false;
        }
        if (!n.b(this.tips, other.tips)) {
            return false;
        }
        if (!n.b(this.variationId, other.variationId)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.contentfulId, other.contentfulId)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        return !n.b(this.locale_variationId, other.locale_variationId) ? z9 : z;
    }

    public int hashCode() {
        return (this.tips.hashCode() * 31) + this.variationId.hashCode() * 31 + this.title.hashCode() * 31 + this.description.hashCode() * 31 + this.locale.hashCode() * 31 + this.contentfulId.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_variationId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickVariationEntity(tips=";
        String str3 = ", variationId=";
        String str4 = ", title=";
        String str5 = ", description=";
        String str6 = ", locale=";
        String str7 = ", contentfulId=";
        String str8 = ", updatedAt=";
        String str9 = ", locale_variationId=";
        str = str2 + this.tips + str3 + this.variationId + str4 + this.title + str5 + this.description + str6 + this.locale + str7 + this.contentfulId + str8 + this.updatedAt + str9 + this.locale_variationId + 41;
        return str;
    }
}
