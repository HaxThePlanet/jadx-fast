package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "", "value", "", "(I)V", "getValue$foundation_release", "()I", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StaggeredGridItemSpan {

    public static final int $stable;
    public static final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan.Companion Companion;
    private static final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan FullLine;
    private static final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan SingleLane;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan$Companion;", "", "()V", "FullLine", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "getFullLine", "()Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "SingleLane", "getSingleLane", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan getFullLine() {
            return StaggeredGridItemSpan.access$getFullLine$cp();
        }

        public final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan getSingleLane() {
            return StaggeredGridItemSpan.access$getSingleLane$cp();
        }
    }
    static {
        StaggeredGridItemSpan.Companion companion = new StaggeredGridItemSpan.Companion(0);
        StaggeredGridItemSpan.Companion = companion;
        StaggeredGridItemSpan staggeredGridItemSpan = new StaggeredGridItemSpan(0);
        StaggeredGridItemSpan.FullLine = staggeredGridItemSpan;
        StaggeredGridItemSpan staggeredGridItemSpan2 = new StaggeredGridItemSpan(1);
        StaggeredGridItemSpan.SingleLane = staggeredGridItemSpan2;
    }

    private StaggeredGridItemSpan(int value) {
        super();
        this.value = value;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan access$getFullLine$cp() {
        return StaggeredGridItemSpan.FullLine;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan access$getSingleLane$cp() {
        return StaggeredGridItemSpan.SingleLane;
    }

    public final int getValue$foundation_release() {
        return this.value;
    }
}
