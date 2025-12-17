package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0019\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001B\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00082\u0006\u0010.\u001a\u00020'H\u0002J\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080&J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+J\u0006\u00102\u001a\u00020+J\r\u00103\u001a\u00020+H\u0000¢\u0006\u0002\u00084J\u001e\u00105\u001a\u000206*\u00020'2\u0006\u00107\u001a\u000206H$ø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u0014\u0010:\u001a\u00020\u0008*\u00020'2\u0006\u0010,\u001a\u00020\u0007H$R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u000e\"\u0004\u0008\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000eR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u000e\"\u0004\u0008\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u000e\"\u0004\u0008\u001e\u0010\u0010R\u001a\u0010\u001f\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u000e\"\u0004\u0008!\u0010\u0010R\u001a\u0010\"\u001a\u00020\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u000e\"\u0004\u0008$\u0010\u0010R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080&*\u00020'X¤\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010)\u0082\u0001\u0002;<\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006=", d2 = {"Landroidx/compose/ui/node/AlignmentLines;", "", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "alignmentLineMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "dirty", "", "getDirty$ui_release", "()Z", "setDirty$ui_release", "(Z)V", "previousUsedDuringParentLayout", "getPreviousUsedDuringParentLayout$ui_release", "setPreviousUsedDuringParentLayout$ui_release", "queried", "getQueried$ui_release", "queryOwner", "required", "getRequired$ui_release", "usedByModifierLayout", "getUsedByModifierLayout$ui_release", "setUsedByModifierLayout$ui_release", "usedByModifierMeasurement", "getUsedByModifierMeasurement$ui_release", "setUsedByModifierMeasurement$ui_release", "usedDuringParentLayout", "getUsedDuringParentLayout$ui_release", "setUsedDuringParentLayout$ui_release", "usedDuringParentMeasurement", "getUsedDuringParentMeasurement$ui_release", "setUsedDuringParentMeasurement$ui_release", "alignmentLinesMap", "", "Landroidx/compose/ui/node/NodeCoordinator;", "getAlignmentLinesMap", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "addAlignmentLine", "", "alignmentLine", "initialPosition", "initialCoordinator", "getLastCalculation", "onAlignmentsChanged", "recalculate", "recalculateQueryOwner", "reset", "reset$ui_release", "calculatePositionInParent", "Landroidx/compose/ui/geometry/Offset;", "position", "calculatePositionInParent-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "getPositionFor", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "Landroidx/compose/ui/node/LookaheadAlignmentLines;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AlignmentLines {

    public static final int $stable = 8;
    private final Map<AlignmentLine, Integer> alignmentLineMap;
    private final androidx.compose.ui.node.AlignmentLinesOwner alignmentLinesOwner;
    private boolean dirty;
    private boolean previousUsedDuringParentLayout;
    private androidx.compose.ui.node.AlignmentLinesOwner queryOwner;
    private boolean usedByModifierLayout;
    private boolean usedByModifierMeasurement;
    private boolean usedDuringParentLayout;
    private boolean usedDuringParentMeasurement;
    static {
        final int i = 8;
    }

    private AlignmentLines(androidx.compose.ui.node.AlignmentLinesOwner alignmentLinesOwner) {
        super();
        this.alignmentLinesOwner = alignmentLinesOwner;
        this.dirty = true;
        HashMap hashMap = new HashMap();
        this.alignmentLineMap = (Map)hashMap;
    }

    public AlignmentLines(androidx.compose.ui.node.AlignmentLinesOwner alignmentLinesOwner, DefaultConstructorMarker defaultConstructorMarker2) {
        super(alignmentLinesOwner);
    }

    public static final void access$addAlignmentLine(androidx.compose.ui.node.AlignmentLines $this, AlignmentLine alignmentLine, int initialPosition, androidx.compose.ui.node.NodeCoordinator initialCoordinator) {
        $this.addAlignmentLine(alignmentLine, initialPosition, initialCoordinator);
    }

    public static final Map access$getAlignmentLineMap$p(androidx.compose.ui.node.AlignmentLines $this) {
        return $this.alignmentLineMap;
    }

    private final void addAlignmentLine(AlignmentLine alignmentLine, int initialPosition, androidx.compose.ui.node.NodeCoordinator initialCoordinator) {
        long position;
        androidx.compose.ui.node.NodeCoordinator coordinator;
        boolean positionFor;
        float x-impl;
        float f;
        float f2;
        int merge;
        final float f4 = (float)initialPosition;
        position = OffsetKt.Offset((float)initialPosition, f4);
        coordinator = initialCoordinator;
        position = calculatePositionInParent-R5De75A(coordinator, position);
        androidx.compose.ui.node.NodeCoordinator wrappedBy$ui_release = coordinator.getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        coordinator = wrappedBy$ui_release;
        while (!Intrinsics.areEqual(coordinator, this.alignmentLinesOwner.getInnerCoordinator())) {
            if (getAlignmentLinesMap(coordinator).containsKey(alignmentLine)) {
            }
            position = calculatePositionInParent-R5De75A(coordinator, position);
            wrappedBy$ui_release = coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            coordinator = wrappedBy$ui_release;
            positionFor = getPositionFor(coordinator, alignmentLine);
            position = OffsetKt.Offset((float)positionFor, (float)positionFor);
        }
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            x-impl = Offset.getY-impl(position);
        } else {
            x-impl = Offset.getX-impl(position);
        }
        int i = 0;
        int $this$fastRoundToInt$iv = Math.round(x-impl);
        if (this.alignmentLineMap.containsKey(alignmentLine)) {
            merge = AlignmentLineKt.merge(alignmentLine, (Number)MapsKt.getValue(this.alignmentLineMap, alignmentLine).intValue(), $this$fastRoundToInt$iv);
        } else {
            merge = $this$fastRoundToInt$iv;
        }
        this.alignmentLineMap.put(alignmentLine, Integer.valueOf(merge));
    }

    protected abstract long calculatePositionInParent-R5De75A(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, long l2);

    protected abstract Map<AlignmentLine, Integer> getAlignmentLinesMap(androidx.compose.ui.node.NodeCoordinator nodeCoordinator);

    public final androidx.compose.ui.node.AlignmentLinesOwner getAlignmentLinesOwner() {
        return this.alignmentLinesOwner;
    }

    public final boolean getDirty$ui_release() {
        return this.dirty;
    }

    public final Map<AlignmentLine, Integer> getLastCalculation() {
        return this.alignmentLineMap;
    }

    protected abstract int getPositionFor(androidx.compose.ui.node.NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine2);

    public final boolean getPreviousUsedDuringParentLayout$ui_release() {
        return this.previousUsedDuringParentLayout;
    }

    public final boolean getQueried$ui_release() {
        int i;
        boolean usedDuringParentMeasurement;
        if (!this.usedDuringParentMeasurement && !this.previousUsedDuringParentLayout && !this.usedByModifierMeasurement) {
            if (!this.previousUsedDuringParentLayout) {
                if (!this.usedByModifierMeasurement) {
                    if (this.usedByModifierLayout) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final boolean getRequired$ui_release() {
        int i;
        recalculateQueryOwner();
        i = this.queryOwner != null ? 1 : 0;
        return i;
    }

    public final boolean getUsedByModifierLayout$ui_release() {
        return this.usedByModifierLayout;
    }

    public final boolean getUsedByModifierMeasurement$ui_release() {
        return this.usedByModifierMeasurement;
    }

    public final boolean getUsedDuringParentLayout$ui_release() {
        return this.usedDuringParentLayout;
    }

    public final boolean getUsedDuringParentMeasurement$ui_release() {
        return this.usedDuringParentMeasurement;
    }

    public final void onAlignmentsChanged() {
        boolean usedDuringParentMeasurement;
        boolean usedByModifierMeasurement;
        boolean usedByModifierLayout;
        this.dirty = true;
        androidx.compose.ui.node.AlignmentLinesOwner parentAlignmentLinesOwner = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null) {
        }
        if (this.usedDuringParentMeasurement) {
            parentAlignmentLinesOwner.requestMeasure();
        } else {
            if (!this.previousUsedDuringParentLayout) {
                if (this.usedDuringParentLayout) {
                    parentAlignmentLinesOwner.requestLayout();
                }
            } else {
            }
        }
        if (this.usedByModifierMeasurement) {
            this.alignmentLinesOwner.requestMeasure();
        }
        if (this.usedByModifierLayout) {
            this.alignmentLinesOwner.requestLayout();
        }
        parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
    }

    public final void recalculate() {
        this.alignmentLineMap.clear();
        AlignmentLines.recalculate.1 anon = new AlignmentLines.recalculate.1(this);
        this.alignmentLinesOwner.forEachChildAlignmentLinesOwner((Function1)anon);
        this.alignmentLineMap.putAll(getAlignmentLinesMap(this.alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void recalculateQueryOwner() {
        androidx.compose.ui.node.AlignmentLinesOwner parent;
        androidx.compose.ui.node.AlignmentLinesOwner queryOwner;
        androidx.compose.ui.node.AlignmentLinesOwner queried$ui_release;
        androidx.compose.ui.node.AlignmentLinesOwner queried$ui_release2;
        Object parentAlignmentLinesOwner;
        Object parentAlignmentLinesOwner2;
        if (getQueried$ui_release()) {
            parent = this.alignmentLinesOwner;
            this.queryOwner = parent;
        } else {
            androidx.compose.ui.node.AlignmentLinesOwner parentAlignmentLinesOwner3 = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
            if (parentAlignmentLinesOwner3 == null) {
            }
            queryOwner = alignmentLines.queryOwner;
            if (queryOwner != null && queryOwner.getAlignmentLines().getQueried$ui_release()) {
                if (queryOwner.getAlignmentLines().getQueried$ui_release()) {
                    parent = queryOwner;
                } else {
                    queried$ui_release = this.queryOwner;
                    if (queried$ui_release != null) {
                        if (queried$ui_release.getAlignmentLines().getQueried$ui_release()) {
                        } else {
                            parentAlignmentLinesOwner = queried$ui_release.getParentAlignmentLinesOwner();
                            parentAlignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines();
                            if (parentAlignmentLinesOwner != null && parentAlignmentLinesOwner != null) {
                                parentAlignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines();
                                if (parentAlignmentLinesOwner != null) {
                                    parentAlignmentLinesOwner.recalculateQueryOwner();
                                }
                            }
                            parentAlignmentLinesOwner2 = queried$ui_release.getParentAlignmentLinesOwner();
                            parentAlignmentLinesOwner2 = parentAlignmentLinesOwner2.getAlignmentLines();
                            if (parentAlignmentLinesOwner2 != null && parentAlignmentLinesOwner2 != null) {
                                parentAlignmentLinesOwner2 = parentAlignmentLinesOwner2.getAlignmentLines();
                                queried$ui_release2 = parentAlignmentLinesOwner2 != null ? parentAlignmentLinesOwner2.queryOwner : 0;
                            } else {
                            }
                            parent = queried$ui_release2;
                        }
                    }
                }
            } else {
            }
        }
    }

    public final void reset$ui_release() {
        this.dirty = true;
        int i2 = 0;
        this.usedDuringParentMeasurement = i2;
        this.previousUsedDuringParentLayout = i2;
        this.usedDuringParentLayout = i2;
        this.usedByModifierMeasurement = i2;
        this.usedByModifierLayout = i2;
        this.queryOwner = 0;
    }

    public final void setDirty$ui_release(boolean <set-?>) {
        this.dirty = <set-?>;
    }

    public final void setPreviousUsedDuringParentLayout$ui_release(boolean <set-?>) {
        this.previousUsedDuringParentLayout = <set-?>;
    }

    public final void setUsedByModifierLayout$ui_release(boolean <set-?>) {
        this.usedByModifierLayout = <set-?>;
    }

    public final void setUsedByModifierMeasurement$ui_release(boolean <set-?>) {
        this.usedByModifierMeasurement = <set-?>;
    }

    public final void setUsedDuringParentLayout$ui_release(boolean <set-?>) {
        this.usedDuringParentLayout = <set-?>;
    }

    public final void setUsedDuringParentMeasurement$ui_release(boolean <set-?>) {
        this.usedDuringParentMeasurement = <set-?>;
    }
}
