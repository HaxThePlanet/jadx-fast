package app.dogo.com.dogo_android.model;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: BreedModel.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/BreedModel;", "", "id", "", "locale", "title", "updatedAt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getLocale", "getTitle", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BreedModel {

    private final String id;
    private final String locale;
    private final String title;
    private final long updatedAt;
    public BreedModel(String str, String str2, String str3, long j) {
        n.f(str, "id");
        n.f(str2, "locale");
        n.f(str3, "title");
        super();
        this.id = str;
        this.locale = str2;
        this.title = str3;
        this.updatedAt = j;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ BreedModel(String str, String str2, String str3, long j, int i, g gVar) {
        String str32;
        int j42 = 0;
        str32 = "";
        gVar = i & 1 != 0 ? str32 : str;
        String r1 = i & 2 != 0 ? str32 : str2;
        if (i & 4 == 0) {
            str32 = str3;
        }
        j42 = i & 8 != 0 ? 0 : j42;
        this(str32, str32, str32, j42, i);
    }

    public BreedModel() {
        this(null, null, null, 0L, i5, 15, 0);
    }

    public static /* synthetic */ BreedModel copy$default(BreedModel breedModel, String str, String str2, String str3, long j, int i, Object object) {
        String str22;
        String str32;
        String str42;
        long j52;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return breedModel.copy(str22, str32, str42, j52);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.locale;
    }

    /* operator */ public final String component3() {
        return this.title;
    }

    /* operator */ public final long component4() {
        return this.updatedAt;
    }

    public final BreedModel copy(String id, String locale, String title, long updatedAt) {
        n.f(id, "id");
        n.f(locale, "locale");
        n.f(title, "title");
        BreedModel breedModel = new BreedModel(id, locale, title, updatedAt, obj);
        return breedModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof BreedModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        return this.updatedAt != other.updatedAt ? z6 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.locale.hashCode() * 31 + this.title.hashCode() * 31 + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "BreedModel(id=";
        String str3 = ", locale=";
        String str4 = ", title=";
        String str5 = ", updatedAt=";
        str = str2 + this.id + str3 + this.locale + str4 + this.title + str5 + this.updatedAt + 41;
        return str;
    }
}
