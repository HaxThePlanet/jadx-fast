package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u0005J\u001d\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\u0008J+\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00102\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0013H\u0086\u0008R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "()V", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "dependency", "oldDependenciesSet", "oldDependency", "trackingInProgress", "", "onDependencyAdded", "graphicsLayer", "removeDependencies", "", "block", "Lkotlin/Function1;", "withTracking", "onDependencyRemoved", "Lkotlin/Function0;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChildLayerDependenciesTracker {

    private MutableScatterSet<androidx.compose.ui.graphics.layer.GraphicsLayer> dependenciesSet;
    private androidx.compose.ui.graphics.layer.GraphicsLayer dependency;
    private MutableScatterSet<androidx.compose.ui.graphics.layer.GraphicsLayer> oldDependenciesSet;
    private androidx.compose.ui.graphics.layer.GraphicsLayer oldDependency;
    private boolean trackingInProgress;
    public static final MutableScatterSet access$getDependenciesSet$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this) {
        return $this.dependenciesSet;
    }

    public static final androidx.compose.ui.graphics.layer.GraphicsLayer access$getDependency$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this) {
        return $this.dependency;
    }

    public static final MutableScatterSet access$getOldDependenciesSet$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this) {
        return $this.oldDependenciesSet;
    }

    public static final androidx.compose.ui.graphics.layer.GraphicsLayer access$getOldDependency$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this) {
        return $this.oldDependency;
    }

    public static final void access$setDependency$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this, androidx.compose.ui.graphics.layer.GraphicsLayer <set-?>) {
        $this.dependency = <set-?>;
    }

    public static final void access$setOldDependenciesSet$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this, MutableScatterSet <set-?>) {
        $this.oldDependenciesSet = <set-?>;
    }

    public static final void access$setOldDependency$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this, androidx.compose.ui.graphics.layer.GraphicsLayer <set-?>) {
        $this.oldDependency = <set-?>;
    }

    public static final void access$setTrackingInProgress$p(androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker $this, boolean <set-?>) {
        $this.trackingInProgress = <set-?>;
    }

    public final boolean onDependencyAdded(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer) {
        Object mutableScatterSetOf;
        String $i$a$RequirePreconditionChildLayerDependenciesTracker$onDependencyAdded$1;
        int i;
        androidx.compose.ui.graphics.layer.GraphicsLayer dependency;
        int i4 = 0;
        if (!this.trackingInProgress) {
            int i7 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }
        int i5 = 0;
        if (this.dependenciesSet != null) {
            mutableScatterSetOf = this.dependenciesSet;
            Intrinsics.checkNotNull(mutableScatterSetOf);
            mutableScatterSetOf.add(graphicsLayer);
        } else {
            if (this.dependency != null) {
                mutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                $i$a$RequirePreconditionChildLayerDependenciesTracker$onDependencyAdded$1 = mutableScatterSetOf;
                i = 0;
                dependency = this.dependency;
                Intrinsics.checkNotNull(dependency);
                $i$a$RequirePreconditionChildLayerDependenciesTracker$onDependencyAdded$1.add(dependency);
                $i$a$RequirePreconditionChildLayerDependenciesTracker$onDependencyAdded$1.add(graphicsLayer);
                this.dependenciesSet = mutableScatterSetOf;
                this.dependency = i5;
            } else {
                this.dependency = graphicsLayer;
            }
        }
        int i6 = 1;
        if (this.oldDependenciesSet != null) {
            MutableScatterSet oldDependenciesSet2 = this.oldDependenciesSet;
            Intrinsics.checkNotNull(oldDependenciesSet2);
            return remove ^= i6;
        }
        if (this.oldDependency != graphicsLayer) {
            return i6;
        }
        this.oldDependency = i5;
        return 0;
    }

    public final void removeDependencies(Function1<? super androidx.compose.ui.graphics.layer.GraphicsLayer, Unit> block) {
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int set2;
        int j$iv$iv;
        int i3;
        androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker childLayerDependenciesTracker;
        int i4;
        Object[] elements;
        MutableScatterSet set3;
        int i2;
        long[] metadata;
        int i6;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        MutableScatterSet set4;
        int i7;
        int $i$f$removeDependencies;
        MutableScatterSet set;
        long l;
        int i;
        int i5;
        final Object obj = block;
        $this$maskEmptyOrDeleted$iv$iv$iv = 0;
        androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer = ChildLayerDependenciesTracker.access$getDependency$p(this);
        if (graphicsLayer != null) {
            j$iv$iv = 0;
            obj.invoke(graphicsLayer);
            ChildLayerDependenciesTracker.access$setDependency$p(this, 0);
        } else {
            childLayerDependenciesTracker = this;
        }
        set2 = ChildLayerDependenciesTracker.access$getDependenciesSet$p(childLayerDependenciesTracker);
        if (set2 != null) {
            i3 = set2;
            i4 = 0;
            i2 = 0;
            metadata = set3.metadata;
            length += -2;
            if (0 <= i6) {
            } else {
                $i$f$removeDependencies = $this$maskEmptyOrDeleted$iv$iv$iv;
                set = set2;
                $this$maskEmptyOrDeleted$iv$iv$iv2 = j$iv$iv;
                set4 = i3;
            }
            set.clear();
        } else {
            $i$f$removeDependencies = $this$maskEmptyOrDeleted$iv$iv$iv;
        }
    }

    public final void withTracking(Function1<? super androidx.compose.ui.graphics.layer.GraphicsLayer, Unit> onDependencyRemoved, Function0<Unit> block) {
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i7;
        int i2;
        boolean mutableScatterSetOf;
        MutableScatterSet j$iv$iv;
        MutableScatterSet $i$f$isFull;
        int notEmpty;
        int i;
        Object[] elements;
        MutableScatterSet set;
        int i6;
        long[] metadata;
        int i3;
        int i$iv$iv;
        long slot$iv$iv;
        MutableScatterSet oldSet;
        int i8;
        int cmp;
        long l;
        int i4;
        int i5;
        final androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker childLayerDependenciesTracker = this;
        final Object obj = onDependencyRemoved;
        final int i9 = 0;
        ChildLayerDependenciesTracker.access$setOldDependency$p(childLayerDependenciesTracker, ChildLayerDependenciesTracker.access$getDependency$p(childLayerDependenciesTracker));
        MutableScatterSet set2 = ChildLayerDependenciesTracker.access$getDependenciesSet$p(childLayerDependenciesTracker);
        i7 = 0;
        if (set2 != null && set2.isNotEmpty() && ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childLayerDependenciesTracker) == null) {
            i7 = 0;
            if (set2.isNotEmpty()) {
                if (ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childLayerDependenciesTracker) == null) {
                    notEmpty = 0;
                    ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(childLayerDependenciesTracker, ScatterSetKt.mutableScatterSetOf());
                }
                mutableScatterSetOf.addAll((ScatterSet)set2);
                set2.clear();
            }
        }
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(childLayerDependenciesTracker, true);
        block.invoke();
        ChildLayerDependenciesTracker.access$setTrackingInProgress$p(childLayerDependenciesTracker, false);
        androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer2 = ChildLayerDependenciesTracker.access$getOldDependency$p(childLayerDependenciesTracker);
        if (graphicsLayer2 != null) {
            obj.invoke(graphicsLayer2);
        }
        j$iv$iv = ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(childLayerDependenciesTracker);
        if (j$iv$iv != null) {
            $i$f$isFull = 0;
            if (j$iv$iv.isNotEmpty()) {
                notEmpty = j$iv$iv;
                i = 0;
                i6 = 0;
                metadata = set.metadata;
                length += -2;
                if (0 <= i3) {
                } else {
                    oldSet = j$iv$iv;
                    i8 = $i$f$isFull;
                }
                oldSet.clear();
            } else {
                oldSet = j$iv$iv;
                i8 = $i$f$isFull;
            }
        }
    }
}
