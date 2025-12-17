package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005HÆ\u0003JS\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00052\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00052\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000fR\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000f¨\u0006\"", d2 = {"Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "", "trick", "Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "videoSteps", "", "Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "trickSteps", "Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "tags", "Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;", "variations", "Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickEntity;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTags", "()Ljava/util/List;", "getTrick", "()Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "getTrickSteps", "getVariations", "getVideoSteps", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g {

    private final TrickEntity a;
    private final List<VideoStepEntity> b;
    private final List<TrickStepEntity> c;
    private final List<TrickTagEntity> d;
    private final List<TrickVariationEntity> e;
    public g(TrickEntity trickEntity, List<VideoStepEntity> list2, List<TrickStepEntity> list3, List<TrickTagEntity> list4, List<TrickVariationEntity> list5) {
        n.f(trickEntity, "trick");
        n.f(list2, "videoSteps");
        n.f(list3, "trickSteps");
        n.f(list4, "tags");
        n.f(list5, "variations");
        super();
        this.a = trickEntity;
        this.b = list2;
        this.c = list3;
        this.d = list4;
        this.e = list5;
    }

    public static e.a.a.a.b.d.g b(e.a.a.a.b.d.g g, TrickEntity trickEntity2, List list3, List list4, List list5, List list6, int i7, Object object8) {
        TrickEntity obj4;
        List obj5;
        List obj6;
        List obj7;
        List obj8;
        if (i7 & 1 != 0) {
            obj4 = g.a;
        }
        if (i7 & 2 != 0) {
            obj5 = g.b;
        }
        if (i7 & 4 != 0) {
            obj6 = g.c;
        }
        if (i7 & 8 != 0) {
            obj7 = g.d;
        }
        if (i7 & 16 != 0) {
            obj8 = g.e;
        }
        return g.a(obj4, obj5, obj6, obj7, obj8);
    }

    public final e.a.a.a.b.d.g a(TrickEntity trickEntity, List<VideoStepEntity> list2, List<TrickStepEntity> list3, List<TrickTagEntity> list4, List<TrickVariationEntity> list5) {
        n.f(trickEntity, "trick");
        n.f(list2, "videoSteps");
        n.f(list3, "trickSteps");
        n.f(list4, "tags");
        n.f(list5, "variations");
        super(trickEntity, list2, list3, list4, list5);
        return gVar;
    }

    public final List<TrickTagEntity> c() {
        return this.d;
    }

    public final TrickEntity d() {
        return this.a;
    }

    public final List<TrickStepEntity> e() {
        return this.c;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (!n.b(this.d, object.d)) {
            return i2;
        }
        if (!n.b(this.e, object.e)) {
            return i2;
        }
        return i;
    }

    public final List<TrickVariationEntity> f() {
        return this.e;
    }

    public final List<VideoStepEntity> g() {
        return this.b;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickFullEntity(trick=");
        stringBuilder.append(this.a);
        stringBuilder.append(", videoSteps=");
        stringBuilder.append(this.b);
        stringBuilder.append(", trickSteps=");
        stringBuilder.append(this.c);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.d);
        stringBuilder.append(", variations=");
        stringBuilder.append(this.e);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
