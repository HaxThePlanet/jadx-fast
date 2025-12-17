package app.dogo.com.dogo_android.model;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/BreedModel;", "", "id", "", "locale", "title", "updatedAt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getLocale", "getTitle", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BreedModel {

    private final String id;
    private final String locale;
    private final String title;
    private final long updatedAt;
    public BreedModel() {
        super(0, 0, 0, 0, obj5, 15, 0);
    }

    public BreedModel(String string, String string2, String string3, long l4) {
        n.f(string, "id");
        n.f(string2, "locale");
        n.f(string3, "title");
        super();
        this.id = string;
        this.locale = string2;
        this.title = string3;
        this.updatedAt = l4;
    }

    public BreedModel(String string, String string2, String string3, long l4, int i5, g g6) {
        String str2;
        String str;
        int obj6;
        String obj9;
        str2 = "";
        obj9 = g6 & 1 != 0 ? str2 : string;
        str = g6 & 2 != 0 ? str2 : string2;
        if (g6 & 4 != 0) {
        } else {
            str2 = string3;
        }
        obj6 = g6 & 8 != 0 ? 0 : obj6;
        super(obj9, str, str2, obj6, g6);
    }

    public static app.dogo.com.dogo_android.model.BreedModel copy$default(app.dogo.com.dogo_android.model.BreedModel breedModel, String string2, String string3, String string4, long l5, int i6, Object object7) {
        String obj4;
        String obj5;
        String obj6;
        long obj7;
        if (object7 & 1 != 0) {
            obj4 = breedModel.id;
        }
        if (object7 & 2 != 0) {
            obj5 = breedModel.locale;
        }
        String obj10 = obj5;
        if (object7 & 4 != 0) {
            obj6 = breedModel.title;
        }
        if (object7 & 8 != 0) {
            obj7 = breedModel.updatedAt;
        }
        return breedModel.copy(obj4, obj10, obj6, obj7);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.locale;
    }

    public final String component3() {
        return this.title;
    }

    public final long component4() {
        return this.updatedAt;
    }

    public final app.dogo.com.dogo_android.model.BreedModel copy(String string, String string2, String string3, long l4) {
        n.f(string, "id");
        n.f(string2, "locale");
        n.f(string3, "title");
        super(string, string2, string3, l4, obj6);
        return breedModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BreedModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        return i;
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

    public int hashCode() {
        return i6 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BreedModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
