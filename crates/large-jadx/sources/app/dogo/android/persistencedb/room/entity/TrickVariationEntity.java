package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0017\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004¢\u0006\u0002\u0010\rJ\u000f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J_\u0010!\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u000c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u000f¨\u0006(", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "", "tips", "", "", "variationId", "title", "description", "locale", "contentfulId", "updatedAt", "", "locale_variationId", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getContentfulId", "()Ljava/lang/String;", "getDescription", "getLocale", "getLocale_variationId", "getTips", "()Ljava/util/List;", "getTitle", "getUpdatedAt", "()J", "getVariationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickVariationEntity {

    private final String contentfulId;
    private final String description;
    private final String locale;
    private final String locale_variationId;
    private final List<String> tips;
    private final String title;
    private final long updatedAt;
    private final String variationId;
    public TrickVariationEntity(List<String> list, String string2, String string3, String string4, String string5, String string6, long l7, String string8) {
        n.f(list, "tips");
        n.f(string2, "variationId");
        n.f(string3, "title");
        n.f(string4, "description");
        n.f(string5, "locale");
        n.f(string6, "contentfulId");
        n.f(obj10, "locale_variationId");
        super();
        this.tips = list;
        this.variationId = string2;
        this.title = string3;
        this.description = string4;
        this.locale = string5;
        this.contentfulId = string6;
        this.updatedAt = l7;
        this.locale_variationId = obj10;
    }

    public TrickVariationEntity(List list, String string2, String string3, String string4, String string5, String string6, long l7, String string8, int i9, g g10) {
        String string;
        int i;
        String str3;
        String str2;
        String str;
        if (i2 &= 128 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string5);
            stringBuilder.append('_');
            str3 = string2;
            stringBuilder.append(string2);
            str = string;
        } else {
            str3 = string2;
            str2 = string5;
            str = i9;
        }
        super(list, string2, string3, string4, string5, string6, l7, obj9, str);
    }

    public static app.dogo.android.persistencedb.room.entity.TrickVariationEntity copy$default(app.dogo.android.persistencedb.room.entity.TrickVariationEntity trickVariationEntity, List list2, String string3, String string4, String string5, String string6, String string7, long l8, String string9, int i10, Object object11) {
        String locale_variationId;
        List tips;
        String variationId;
        String title;
        String description;
        String locale;
        String contentfulId;
        long updatedAt;
        Object obj = trickVariationEntity;
        int i = object11;
        tips = i & 1 != 0 ? obj.tips : list2;
        variationId = i & 2 != 0 ? obj.variationId : string3;
        title = i & 4 != 0 ? obj.title : string4;
        description = i & 8 != 0 ? obj.description : string5;
        locale = i & 16 != 0 ? obj.locale : string6;
        contentfulId = i & 32 != 0 ? obj.contentfulId : string7;
        updatedAt = i & 64 != 0 ? obj.updatedAt : l8;
        locale_variationId = i &= 128 != 0 ? obj.locale_variationId : i10;
        return trickVariationEntity.copy(tips, variationId, title, description, locale, contentfulId, updatedAt, string9);
    }

    public final List<String> component1() {
        return this.tips;
    }

    public final String component2() {
        return this.variationId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.locale;
    }

    public final String component6() {
        return this.contentfulId;
    }

    public final long component7() {
        return this.updatedAt;
    }

    public final String component8() {
        return this.locale_variationId;
    }

    public final app.dogo.android.persistencedb.room.entity.TrickVariationEntity copy(List<String> list, String string2, String string3, String string4, String string5, String string6, long l7, String string8) {
        n.f(list, "tips");
        n.f(string2, "variationId");
        n.f(string3, "title");
        n.f(string4, "description");
        final Object obj = string5;
        n.f(obj, "locale");
        final Object obj2 = string6;
        n.f(obj2, "contentfulId");
        final Object obj3 = obj20;
        n.f(obj3, "locale_variationId");
        super(list, string2, string3, string4, obj, obj2, l7, obj9, obj3);
        return trickVariationEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickVariationEntity) {
            return i2;
        }
        if (!n.b(this.tips, object.tips)) {
            return i2;
        }
        if (!n.b(this.variationId, object.variationId)) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.contentfulId, object.contentfulId)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_variationId, object.locale_variationId)) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        return i14 += i22;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickVariationEntity(tips=");
        stringBuilder.append(this.tips);
        stringBuilder.append(", variationId=");
        stringBuilder.append(this.variationId);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", contentfulId=");
        stringBuilder.append(this.contentfulId);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_variationId=");
        stringBuilder.append(this.locale_variationId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
