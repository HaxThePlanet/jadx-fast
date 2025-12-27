package app.dogo.com.dogo_android.model.goodexamples;

import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: GoodTrickExampleModel.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001BK\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u000cJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u000e¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "", "id", "", "updatedAt", "", "trick", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "dogName", "dogId", "trickId", "contentId", "(Ljava/lang/String;JLapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getContentId", "()J", "getDogId", "()Ljava/lang/String;", "getDogName", "getId", "getTrick", "()Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "getTrickId", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GoodTrickExampleModel {

    private final long contentId;
    private final String dogId;
    private final String dogName;
    private final String id;
    private final TrickModel trick;
    private final String trickId;
    private final long updatedAt;
    public GoodTrickExampleModel(String str, long j, TrickModel trickModel, String str2, String str3, String str4, long j2) {
        n.f(str, "id");
        n.f(trickModel, "trick");
        n.f(str2, "dogName");
        n.f(str3, "dogId");
        n.f(str4, "trickId");
        super();
        this.id = str;
        this.updatedAt = j;
        this.trick = trickModel;
        this.dogName = str2;
        this.dogId = str3;
        this.trickId = str4;
        this.contentId = j2;
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

    public /* synthetic */ GoodTrickExampleModel(String str, long j, TrickModel trickModel, String str2, String str3, String str4, long j2, int i, g gVar) {
        TrickModel str42;
        int i82 = 0;
        str2 = "";
        String r0 = i & 1 != 0 ? str2 : str;
        i82 = 0;
        int r5 = i & 2 != 0 ? 0 : j;
        if (i & 4 != 0) {
            str3 = null;
            String str7 = null;
            String str8 = null;
            java.util.List list = null;
            app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickCategory = null;
            String str9 = null;
            Integer num = null;
            boolean z = false;
            Integer num2 = null;
            java.util.List list2 = null;
            boolean z2 = false;
            String str10 = null;
            String str11 = null;
            java.util.List list3 = null;
            String str12 = null;
            long l = 0L;
            java.util.List list4 = null;
            i = 0;
            gVar = 262143;
            int i2 = 0;
            super(str3, str7, str8, list, trickCategory, str9, num, z, num2, list2, z2, str10, str11, list3, str12, l, str13, list4, i, gVar, i2);
        } else {
            str42 = trickModel;
        }
        String r7 = str2;
        String r8 = i & 16 != 0 ? str2 : str3;
        if (i & 32 == 0) {
            str2 = str4;
        }
        if (i & 64 == 0) {
            i82 = j2;
        }
        this(str2, i82, trickModel, str42, str2, str2, str2, i82, i);
    }

    public GoodTrickExampleModel() {
        this(null, 0L, trickModel, null, null, null, 0L, 0, gVar, 127, 0);
    }

    public static /* synthetic */ GoodTrickExampleModel copy$default(GoodTrickExampleModel goodTrickExampleModel, String str, long j, TrickModel trickModel, String str2, String str3, String str4, long j2, int i, Object object) {
        String str22;
        long j32;
        TrickModel str52;
        String str62;
        String str72;
        String j82;
        long i92;
        Object goodTrickExampleModel2 = goodTrickExampleModel;
        String r1 = i & 1 != 0 ? goodTrickExampleModel2.id : str;
        long r2 = i & 2 != 0 ? goodTrickExampleModel2.updatedAt : j;
        TrickModel r4 = i & 4 != 0 ? goodTrickExampleModel2.trick : trickModel;
        String r5 = i & 8 != 0 ? goodTrickExampleModel2.dogName : str2;
        String r6 = i & 16 != 0 ? goodTrickExampleModel2.dogId : str3;
        String r7 = i & 32 != 0 ? goodTrickExampleModel2.trickId : str4;
        long r8 = i & 64 != 0 ? goodTrickExampleModel2.contentId : j2;
        return goodTrickExampleModel.copy(str22, j32, r13, str52, str62, str72, j82, (i & 64 != 0 ? goodTrickExampleModel2.contentId : j2), r19);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final long component2() {
        return this.updatedAt;
    }

    /* operator */ public final TrickModel component3() {
        return this.trick;
    }

    /* operator */ public final String component4() {
        return this.dogName;
    }

    /* operator */ public final String component5() {
        return this.dogId;
    }

    /* operator */ public final String component6() {
        return this.trickId;
    }

    /* operator */ public final long component7() {
        return this.contentId;
    }

    public final GoodTrickExampleModel copy(String id, long updatedAt, TrickModel trick, String dogName, String dogId, String trickId, long contentId) {
        n.f(id, "id");
        n.f(trick, "trick");
        final Object dogId2 = dogName;
        n.f(dogId2, "dogName");
        final Object trickId2 = dogId;
        n.f(trickId2, "dogId");
        final Object contentId2 = trickId;
        n.f(contentId2, "trickId");
        GoodTrickExampleModel goodTrickExampleModel = new GoodTrickExampleModel(id, updatedAt, trickModel, trick, dogId2, trickId2, contentId2, contentId, obj2);
        return goodTrickExampleModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z8 = false;
        if (!(other instanceof GoodTrickExampleModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.trick, other.trick)) {
            return false;
        }
        if (!n.b(this.dogName, other.dogName)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        return this.contentId != other.contentId ? z8 : z;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + Long.hashCode(this.updatedAt) * 31 + this.trick.hashCode() * 31 + this.dogName.hashCode() * 31 + this.dogId.hashCode() * 31 + this.trickId.hashCode() * 31 + Long.hashCode(this.contentId);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "GoodTrickExampleModel(id=";
        String str3 = ", updatedAt=";
        String str4 = ", trick=";
        String str5 = ", dogName=";
        String str6 = ", dogId=";
        String str7 = ", trickId=";
        String str8 = ", contentId=";
        str = str2 + this.id + str3 + this.updatedAt + str4 + this.trick + str5 + this.dogName + str6 + this.dogId + str7 + this.trickId + str8 + this.contentId + 41;
        return str;
    }
}
