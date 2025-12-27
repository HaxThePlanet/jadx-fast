package e.a.a.a.b.d;

import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickStepEntity;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.android.persistencedb.room.entity.TrickVariationEntity;
import app.dogo.android.persistencedb.room.entity.VideoStepEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: TrickFullEntity.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005HÆ\u0003JS\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00052\u000e\u0008\u0002\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00052\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000fR\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000f¨\u0006\"", d2 = {"Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "", "trick", "Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "videoSteps", "", "Lapp/dogo/android/persistencedb/room/entity/VideoStepEntity;", "trickSteps", "Lapp/dogo/android/persistencedb/room/entity/TrickStepEntity;", "tags", "Lapp/dogo/android/persistencedb/room/entity/TrickTagEntity;", "variations", "Lapp/dogo/android/persistencedb/room/entity/TrickVariationEntity;", "(Lapp/dogo/android/persistencedb/room/entity/TrickEntity;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTags", "()Ljava/util/List;", "getTrick", "()Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "getTrickSteps", "getVariations", "getVideoSteps", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final /* data */ class TrickFullEntity {

    private final TrickEntity a;
    private final List<VideoStepEntity> b;
    /* renamed from: c, reason: from kotlin metadata */
    private final List<TrickStepEntity> trickSteps;
    /* renamed from: d, reason: from kotlin metadata */
    private final List<TrickTagEntity> variations;
    /* renamed from: e, reason: from kotlin metadata */
    private final List<TrickVariationEntity> videoSteps;
    public g(TrickEntity trickEntity, List<VideoStepEntity> list, List<TrickStepEntity> list2, List<TrickTagEntity> list3, List<TrickVariationEntity> list4) {
        n.f(trickEntity, "trick");
        n.f(list, "videoSteps");
        n.f(list2, "trickSteps");
        n.f(list3, "tags");
        n.f(list4, "variations");
        super();
        this.a = trickEntity;
        this.b = list;
        this.trickSteps = list2;
        this.variations = list3;
        this.videoSteps = list4;
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final List<TrickTagEntity> component1() {
        return this.variations;
    }

    public final TrickEntity d() {
        return this.a;
    }

    public final List<TrickStepEntity> e() {
        return this.trickSteps;
    }

    public final List<TrickVariationEntity> f() {
        return this.videoSteps;
    }

    public final List<VideoStepEntity> g() {
        return this.b;
    }

    public static /* synthetic */ g b(g gVar, TrickEntity trickEntity, List list, List list2, List list3, List list4, int i, Object object) {
        TrickEntity trickEntity22;
        List object82;
        List list42;
        List list52;
        List list62;
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
        return gVar.copy(trickEntity22, object82, list42, list52, list62);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final g copy(TrickEntity trick, List<VideoStepEntity> videoSteps, List<TrickStepEntity> trickSteps, List<TrickTagEntity> tags, List<TrickVariationEntity> variations) {
        n.f(trick, "trick");
        n.f(videoSteps, "videoSteps");
        n.f(trickSteps, "trickSteps");
        n.f(tags, "tags");
        n.f(variations, "variations");
        TrickFullEntity trickFullEntity = new TrickFullEntity(trick, videoSteps, trickSteps, tags, variations);
        return trickFullEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof TrickFullEntity)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (!n.b(this.trickSteps, other.trickSteps)) {
            return false;
        }
        if (!n.b(this.variations, other.variations)) {
            return false;
        }
        return !n.b(this.videoSteps, other.videoSteps) ? z7 : z;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + this.trickSteps.hashCode() * 31 + this.variations.hashCode() * 31 + this.videoSteps.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickFullEntity(trick=";
        String str3 = ", videoSteps=";
        String str4 = ", trickSteps=";
        String str5 = ", tags=";
        String str6 = ", variations=";
        str = str2 + this.a + str3 + this.b + str4 + this.trickSteps + str5 + this.variations + str6 + this.videoSteps + 41;
        return str;
    }
}
