package app.dogo.com.dogo_android.model.goodexamples;

import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001BK\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u000cJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000e¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "", "id", "", "updatedAt", "", "trick", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "dogName", "dogId", "trickId", "contentId", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getContentId", "()J", "getDogId", "()Ljava/lang/String;", "getDogName", "getId", "getTrick", "()Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "getTrickId", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GoodTrickExampleModel {

    private final long contentId;
    private final String dogId;
    private final String dogName;
    private final String id;
    private final TrickModel trick;
    private final String trickId;
    private final long updatedAt;
    public GoodTrickExampleModel() {
        super(0, 0, obj3, 0, 0, 0, 0, 0, obj9, 127, 0);
    }

    public GoodTrickExampleModel(String string, long l2, TrickModel trickModel3, String string4, String string5, String string6, long l7) {
        n.f(string, "id");
        n.f(string4, "trick");
        n.f(string5, "dogName");
        n.f(string6, "dogId");
        n.f(l7, "trickId");
        super();
        this.id = string;
        this.updatedAt = l2;
        this.trick = string4;
        this.dogName = string5;
        this.dogId = string6;
        this.trickId = l7;
        this.contentId = obj9;
    }

    public GoodTrickExampleModel(String string, long l2, TrickModel trickModel3, String string4, String string5, String string6, long l7, int i8, g g9) {
        String str2;
        String str;
        TrickModel trickModel;
        int i3;
        int i11;
        TrickModel trickModel2;
        String str4;
        int i7;
        String str3;
        int i4;
        int i;
        int i12;
        int i9;
        int i10;
        int i6;
        int i2;
        int i13;
        int i16;
        int i14;
        int i19;
        int i15;
        int i17;
        int i21;
        int i5;
        int i20;
        int i22;
        int i18;
        int i23;
        str = "";
        str2 = obj39 & 1 != 0 ? str : string;
        i11 = obj39 & 2 != 0 ? i3 : l2;
        if (obj39 & 4 != 0) {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj24, 0, 0, 262143, 0);
        } else {
            trickModel = string4;
        }
        str4 = obj39 & 8 != 0 ? str : string5;
        str3 = obj39 & 16 != 0 ? str : string6;
        if (obj39 & 32 != 0) {
        } else {
            str = l7;
        }
        if (obj39 & 64 != 0) {
        } else {
            i3 = i8;
        }
        super(str2, i11, string4, trickModel, str4, str3, str, i3, obj39);
    }

    public static app.dogo.com.dogo_android.model.goodexamples.GoodTrickExampleModel copy$default(app.dogo.com.dogo_android.model.goodexamples.GoodTrickExampleModel goodTrickExampleModel, String string2, long l3, TrickModel trickModel4, String string5, String string6, String string7, long l8, int i9, Object object10) {
        String str;
        long updatedAt;
        TrickModel trick;
        String dogName;
        String dogId;
        String trickId;
        long contentId;
        Object obj = goodTrickExampleModel;
        str = obj20 & 1 != 0 ? obj.id : string2;
        updatedAt = obj20 & 2 != 0 ? obj.updatedAt : l3;
        trick = obj20 & 4 != 0 ? obj.trick : string5;
        dogName = obj20 & 8 != 0 ? obj.dogName : string6;
        dogId = obj20 & 16 != 0 ? obj.dogId : string7;
        trickId = obj20 & 32 != 0 ? obj.trickId : l8;
        contentId = obj20 & 64 != 0 ? obj.contentId : i9;
        return goodTrickExampleModel.copy(str, updatedAt, trickModel4, trick, dogName, dogId, trickId);
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.updatedAt;
    }

    public final TrickModel component3() {
        return this.trick;
    }

    public final String component4() {
        return this.dogName;
    }

    public final String component5() {
        return this.dogId;
    }

    public final String component6() {
        return this.trickId;
    }

    public final long component7() {
        return this.contentId;
    }

    public final app.dogo.com.dogo_android.model.goodexamples.GoodTrickExampleModel copy(String string, long l2, TrickModel trickModel3, String string4, String string5, String string6, long l7) {
        n.f(string, "id");
        n.f(string4, "trick");
        final Object obj = string5;
        n.f(obj, "dogName");
        final Object obj2 = string6;
        n.f(obj2, "dogId");
        final Object obj3 = l7;
        n.f(obj3, "trickId");
        super(string, l2, obj4, string4, obj, obj2, obj3, obj19, obj10);
        return goodTrickExampleModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof GoodTrickExampleModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.trick, object.trick)) {
            return i2;
        }
        if (!n.b(this.dogName, object.dogName)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (Long.compare(contentId, contentId2) != 0) {
            return i2;
        }
        return i;
    }

    public final long getContentId() {
        return this.contentId;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getDogName() {
        return this.dogName;
    }

    public final String getId() {
        return this.id;
    }

    public final TrickModel getTrick() {
        return this.trick;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return i12 += i19;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoodTrickExampleModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", trick=");
        stringBuilder.append(this.trick);
        stringBuilder.append(", dogName=");
        stringBuilder.append(this.dogName);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", contentId=");
        stringBuilder.append(this.contentId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
