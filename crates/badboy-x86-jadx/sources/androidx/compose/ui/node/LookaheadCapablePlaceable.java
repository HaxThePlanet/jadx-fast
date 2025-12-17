package androidx.compose.ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008 \u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010?\u001a\u00020@2\u0006\u0010!\u001a\u00020\"2\u0006\u0010A\u001a\u000205H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH&J\u0017\u0010F\u001a\u00020@2\u0008\u0010G\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\u0008HJ\u0010\u0010F\u001a\u00020@2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00002\u0006\u0010A\u001a\u000205H\u0002J\u0016\u0010L\u001a\u00020M2\u0006\u0010A\u001a\u0002052\u0006\u0010N\u001a\u00020MJ\u0011\u0010O\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0086\u0002J\u0010\u0010P\u001a\u00020@2\u0006\u0010A\u001a\u000205H\u0002J`\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020C2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0U2\u0019\u0010V\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020@\u0018\u00010W¢\u0006\u0002\u0008X2\u0017\u0010Y\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020@0W¢\u0006\u0002\u0008XH\u0016J&\u0010Z\u001a\u00020@2\u001c\u0010[\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\u0008\u0012\u0004\u0012\u00020\"`806H\u0002J\u0016\u0010\\\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\u0016\u0010^\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\r\u0010_\u001a\u00020@H ¢\u0006\u0002\u0008`J\u000c\u0010a\u001a\u00020@*\u00020bH\u0004J\u0014\u0010c\u001a\u00020\u0013*\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u0004\u001a\u0004\u0008\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015\"\u0004\u0008\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u0015\"\u0004\u0008 \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0012\u0010%\u001a\u00020&X \u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0014\u0010)\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010\rR\u0011\u0010+\u001a\u00020,¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0018\u0010/\u001a\u000200X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00081\u00102R2\u00103\u001a&\u0012\u0004\u0012\u000205\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\u0008\u0012\u0004\u0012\u00020\"`806\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008:\u0010;R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006f", d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "()V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "isLookingAhead$annotations", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "parent", "getParent", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/node/WeakReference;", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "addRulerReader", "", "ruler", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "captureRulers", "result", "captureRulers$ui_release", "placeableResult", "Landroidx/compose/ui/node/PlaceableResult;", "findAncestorRulerDefiner", "findRulerValue", "", "defaultValue", "get", "invalidateChildrenOfDefiningRuler", "layout", "width", "height", "alignmentLines", "", "rulers", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "notifyRulerValueChange", "layoutNodes", "provideRelativeRulerValue", "value", "provideRulerValue", "replace", "replace$ui_release", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLayoutNodeAncestor", "ancestor", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LookaheadCapablePlaceable extends Placeable implements androidx.compose.ui.node.MeasureScopeWithLayoutNode, androidx.compose.ui.node.MotionReferencePlacementDelegate {

    public static final int $stable;
    public static final androidx.compose.ui.node.LookaheadCapablePlaceable.Companion Companion;
    private static final Function1<androidx.compose.ui.node.PlaceableResult, Unit> onCommitAffectingRuler;
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope;
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<androidx.compose.ui.node.LayoutNode>>> rulerReaders;
    private MutableObjectFloatMap<Ruler> rulerValues;
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$Companion;", "", "()V", "onCommitAffectingRuler", "Lkotlin/Function1;", "Landroidx/compose/ui/node/PlaceableResult;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        LookaheadCapablePlaceable.Companion companion = new LookaheadCapablePlaceable.Companion(0);
        LookaheadCapablePlaceable.Companion = companion;
        LookaheadCapablePlaceable.onCommitAffectingRuler = (Function1)LookaheadCapablePlaceable.Companion.onCommitAffectingRuler.1.INSTANCE;
    }

    public LookaheadCapablePlaceable() {
        super();
        this.placementScope = PlaceableKt.PlacementScope(this);
    }

    public static final void access$captureRulers(androidx.compose.ui.node.LookaheadCapablePlaceable $this, androidx.compose.ui.node.PlaceableResult placeableResult) {
        $this.captureRulers(placeableResult);
    }

    private final void addRulerReader(androidx.compose.ui.node.LayoutNode layoutNode, Ruler ruler) {
        MutableScatterMap rulerReaders;
        MutableScatterMap this_$iv2;
        long[] $i$f$removeIf2;
        int i2;
        int i6;
        int i$iv$iv2;
        int $i$f$maskEmptyOrDeleted;
        Object obj;
        int mutableScatterSet;
        int value$iv$iv$iv;
        int j$iv$iv4;
        int i$iv$iv;
        long slot$iv$iv3;
        int i9;
        int $this$maskEmptyOrDeleted$iv$iv$iv3;
        int j$iv$iv3;
        int value$iv$iv$iv2;
        Object[] values;
        MutableScatterMap map;
        int $i$f$removeIf;
        int i10;
        int i;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int cmp2;
        int i5;
        long l;
        int i4;
        Object obj3;
        int i12;
        MutableScatterMap this_$iv;
        int i8;
        long[] lArr;
        Object obj2;
        long[] lArr2;
        long slot$iv$iv2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object[] objArr;
        int i7;
        int j$iv$iv;
        int i3;
        int cmp;
        int i11;
        int index$iv;
        int j$iv$iv2;
        final Object obj4 = this;
        final Object obj5 = ruler;
        rulerReaders = obj4.rulerReaders;
        if (rulerReaders != null) {
            $i$f$removeIf = 0;
            i10 = 128;
            $i$f$removeIf2 = map.metadata;
            length += -2;
            i = 255;
            if (0 <= i6) {
            } else {
                this_$iv = rulerReaders;
                lArr = $i$f$removeIf2;
                $this$maskEmptyOrDeleted$iv$iv$iv = value$iv$iv$iv2;
                i5 = 7;
                l = -9187201950435737472L;
            }
        } else {
            i10 = 128;
            i = 255;
            i5 = 7;
            l = -9187201950435737472L;
        }
        MutableScatterMap rulerReaders2 = obj4.rulerReaders;
        if (rulerReaders2 != null) {
            i$iv$iv2 = 0;
            $i$f$maskEmptyOrDeleted = i6.metadata;
            length2 += -2;
            if (0 <= mutableScatterSet) {
            } else {
                $i$f$removeIf = $i$f$removeIf2;
            }
        }
        i2 = 0;
        if (obj4.rulerReaders == null) {
            this_$iv2 = new MutableScatterMap(0, 1, i2);
            i$iv$iv2 = 0;
            obj4.rulerReaders = this_$iv2;
        }
        MutableScatterMap map2 = this_$iv2;
        int i13 = 0;
        if (map2.get(obj5) == null) {
            int i14 = 0;
            mutableScatterSet = new MutableScatterSet(0, 1, i2);
            int i15 = 0;
            map2.set(obj5, mutableScatterSet);
            obj = mutableScatterSet;
        }
        WeakReference weakReference = new WeakReference(layoutNode);
        (MutableScatterSet)obj.plusAssign(weakReference);
    }

    private final void captureRulers(androidx.compose.ui.node.PlaceableResult placeableResult) {
        Object cmp;
        androidx.compose.ui.node.PlaceableResult j$iv$iv3;
        int newValue;
        int j$iv$iv4;
        Function1 index$iv$iv;
        Object[] mutableObjectFloatMap;
        MutableScatterMap keys;
        int i6;
        Object snapshotObserver;
        long[] mutableObjectFloatMap2;
        int i8;
        int i9;
        int i$iv$iv;
        int i$iv$iv3;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int j$iv$iv2;
        Object i$iv$iv2;
        int slot$iv$iv2;
        int value$iv$iv$iv2;
        MutableScatterMap value$iv$iv$iv;
        int metadata;
        int i5;
        int i7;
        int i3;
        int i4;
        long slot$iv$iv;
        int cmp3;
        long l2;
        MutableScatterMap this_$iv;
        int ruler;
        long l;
        int cmp2;
        MutableObjectFloatMap $i$f$forEachKey;
        int i2;
        int remove;
        int j$iv$iv;
        int i;
        float newValue2;
        cmp = this;
        j$iv$iv3 = placeableResult;
        if (cmp.isPlacingForAlignment) {
        }
        index$iv$iv = j$iv$iv3.getResult().getRulers();
        final MutableScatterMap rulerReaders = cmp.rulerReaders;
        slot$iv$iv2 = 8;
        if (index$iv$iv == null) {
            if (rulerReaders != null) {
                value$iv$iv$iv = rulerReaders;
                metadata = 0;
                i7 = 0;
                mutableObjectFloatMap2 = keys.metadata;
                length += -2;
                if (0 <= i8) {
                } else {
                    this_$iv = value$iv$iv$iv;
                }
                rulerReaders.clear();
                this_$iv = index$iv$iv;
            } else {
                this_$iv = index$iv$iv;
            }
        } else {
            i5 = 128;
            i3 = 255;
            i4 = 7;
            l = -9187201950435737472L;
            i6 = 0;
            if (cmp.rulerValuesCache == null) {
                mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, i6);
                i8 = 0;
                cmp.rulerValuesCache = mutableObjectFloatMap;
            }
            if (cmp.rulerValues == null) {
                mutableObjectFloatMap2 = new MutableObjectFloatMap(0, 1, i6);
                $this$maskEmptyOrDeleted$iv$iv$iv = 0;
                cmp.rulerValues = mutableObjectFloatMap2;
            } else {
                i9 = 0;
                i$iv$iv3 = 1;
            }
            mutableObjectFloatMap.putAll((ObjectFloatMap)mutableObjectFloatMap2);
            mutableObjectFloatMap2.clear();
            snapshotObserver = cmp.getLayoutNode().getOwner$ui_release();
            snapshotObserver = snapshotObserver.getSnapshotObserver();
            if (snapshotObserver != null && snapshotObserver != null) {
                snapshotObserver = snapshotObserver.getSnapshotObserver();
                if (snapshotObserver != null) {
                    i$iv$iv2 = new LookaheadCapablePlaceable.captureRulers.3(j$iv$iv3, cmp);
                    snapshotObserver.observeReads$ui_release((OwnerScope)j$iv$iv3, LookaheadCapablePlaceable.onCommitAffectingRuler, (Function0)i$iv$iv2);
                }
            }
            if (rulerReaders != null) {
                snapshotObserver = mutableObjectFloatMap;
                $this$maskEmptyOrDeleted$iv$iv$iv = 0;
                value$iv$iv$iv2 = snapshotObserver;
                value$iv$iv$iv = 0;
                metadata = value$iv$iv$iv2.metadata;
                length2 += -2;
                if (0 <= i9) {
                } else {
                    this_$iv = index$iv$iv;
                    $i$f$forEachKey = value$iv$iv$iv2;
                }
            } else {
                this_$iv = index$iv$iv;
            }
            j$iv$iv3 = mutableObjectFloatMap2;
            i$iv$iv = 0;
            $this$maskEmptyOrDeleted$iv$iv$iv = i8.metadata;
            length3 += -2;
            if (0 <= j$iv$iv2) {
            } else {
                slot$iv$iv = j$iv$iv3;
                $i$f$forEachKey = index$iv$iv;
            }
            mutableObjectFloatMap.clear();
        }
    }

    private final androidx.compose.ui.node.LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        Object p;
        androidx.compose.ui.node.LookaheadCapablePlaceable parent;
        MutableObjectFloatMap rulerValues;
        int i;
        int i2;
        p = this;
        rulerValues = p.rulerValues;
        i = 0;
        while (rulerValues != null) {
            i2 = 1;
            if (rulerValues.contains(ruler) == i2) {
            }
            parent = p.getParent();
            p = parent;
            rulerValues = p.rulerValues;
            i = 0;
            i = i2;
        }
        return p;
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        Object remove;
        MutableScatterMap rulerReaders = ancestorRulerDefiner.rulerReaders;
        if (rulerReaders != null) {
            remove = rulerReaders.remove(ruler);
        } else {
            remove = 0;
        }
        if (remove != null) {
            notifyRulerValueChange(remove);
        }
    }

    private final boolean isLayoutNodeAncestor(androidx.compose.ui.node.LayoutNode $this$isLayoutNodeAncestor, androidx.compose.ui.node.LayoutNode ancestor) {
        boolean layoutNodeAncestor;
        if ($this$isLayoutNodeAncestor == ancestor) {
            return 1;
        }
        androidx.compose.ui.node.LayoutNode parent$ui_release = $this$isLayoutNodeAncestor.getParent$ui_release();
        if (parent$ui_release != null) {
            layoutNodeAncestor = isLayoutNodeAncestor(parent$ui_release, ancestor);
        } else {
            layoutNodeAncestor = 0;
        }
        return layoutNodeAncestor;
    }

    public static void isLookingAhead$annotations() {
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<androidx.compose.ui.node.LayoutNode>> layoutNodes) {
        Object this_$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i6;
        int j$iv$iv;
        int i3;
        int i;
        long l;
        int i2;
        int i5;
        int i4;
        int i7;
        Object obj;
        Object this_$iv;
        this_$iv2 = layoutNodes;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            this_$iv = this_$iv2;
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    @Override // androidx.compose.ui.layout.Placeable
    public final void captureRulers$ui_release(MeasureResult result) {
        MeasureResult rulerValues;
        MutableScatterMap placeableResult;
        int i3;
        Object[] values;
        MutableScatterMap map;
        int i6;
        long[] metadata;
        int i5;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i7;
        int i4;
        MutableScatterMap this_$iv;
        long l;
        int i;
        int i2;
        final androidx.compose.ui.node.LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        rulerValues = result;
        if (rulerValues != null) {
            placeableResult = new PlaceableResult(rulerValues, lookaheadCapablePlaceable);
            lookaheadCapablePlaceable.captureRulers(placeableResult);
        } else {
            placeableResult = lookaheadCapablePlaceable.rulerReaders;
            if (placeableResult != null) {
                i3 = 0;
                i6 = 0;
                metadata = map.metadata;
                length += -2;
                if (0 <= i5) {
                } else {
                    this_$iv = placeableResult;
                }
            }
            MutableScatterMap rulerReaders = lookaheadCapablePlaceable.rulerReaders;
            if (rulerReaders != null) {
                rulerReaders.clear();
            }
            rulerValues = lookaheadCapablePlaceable.rulerValues;
            if (rulerValues != null) {
                rulerValues.clear();
            }
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final float findRulerValue(Ruler ruler, float defaultValue) {
        Object p;
        androidx.compose.ui.node.LookaheadCapablePlaceable parent;
        int orDefault;
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        p = this;
        MutableObjectFloatMap rulerValues = p.rulerValues;
        while (rulerValues != null) {
            orDefault = rulerValues.getOrDefault(ruler, 2143289344);
            parent = p.getParent();
            p = parent;
            rulerValues = p.rulerValues;
        }
        p.addRulerReader(getLayoutNode(), ruler);
        return ruler.calculateCoordinate$ui_release(orDefault, p.getCoordinates(), getCoordinates());
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        int y-impl;
        int i = Integer.MIN_VALUE;
        if (!getHasMeasureResult()) {
            return i;
        }
        int alignmentLine2 = calculateAlignmentLine(alignmentLine);
        if (alignmentLine2 == i) {
            return i;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            y-impl = IntOffset.getX-impl(getApparentToRealOffset-nOcc-ac());
        } else {
            y-impl = IntOffset.getY-impl(getApparentToRealOffset-nOcc-ac());
        }
        return y-impl += alignmentLine2;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public abstract androidx.compose.ui.node.AlignmentLinesOwner getAlignmentLinesOwner();

    @Override // androidx.compose.ui.layout.Placeable
    public abstract androidx.compose.ui.node.LookaheadCapablePlaceable getChild();

    @Override // androidx.compose.ui.layout.Placeable
    public abstract LayoutCoordinates getCoordinates();

    @Override // androidx.compose.ui.layout.Placeable
    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.layout.Placeable
    public abstract androidx.compose.ui.node.LayoutNode getLayoutNode();

    @Override // androidx.compose.ui.layout.Placeable
    public abstract MeasureResult getMeasureResult$ui_release();

    @Override // androidx.compose.ui.layout.Placeable
    public abstract androidx.compose.ui.node.LookaheadCapablePlaceable getParent();

    @Override // androidx.compose.ui.layout.Placeable
    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public abstract long getPosition-nOcc-ac();

    @Override // androidx.compose.ui.layout.Placeable
    public final RulerScope getRulerScope() {
        RulerScope _rulerScope;
        if (this._rulerScope == null) {
            _rulerScope = new LookaheadCapablePlaceable.rulerScope.1(this);
        }
        return _rulerScope;
    }

    @Override // androidx.compose.ui.layout.Placeable
    protected final void invalidateAlignmentLinesFromPositionChange(androidx.compose.ui.node.NodeCoordinator $this$invalidateAlignmentLinesFromPositionChange) {
        int layoutNode;
        Object parentAlignmentLinesOwner;
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = $this$invalidateAlignmentLinesFromPositionChange.getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            layoutNode = wrapped$ui_release.getLayoutNode();
        } else {
            layoutNode = 0;
        }
        if (!Intrinsics.areEqual(layoutNode, $this$invalidateAlignmentLinesFromPositionChange.getLayoutNode())) {
            $this$invalidateAlignmentLinesFromPositionChange.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
        } else {
            parentAlignmentLinesOwner = $this$invalidateAlignmentLinesFromPositionChange.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
            parentAlignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines();
            if (parentAlignmentLinesOwner != null && parentAlignmentLinesOwner != null) {
                parentAlignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines();
                if (parentAlignmentLinesOwner != null) {
                    parentAlignmentLinesOwner.onAlignmentsChanged();
                }
            }
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public boolean isLookingAhead() {
        return 0;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super RulerScope, Unit> rulers, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        int i2;
        int i;
        String string;
        StringBuilder append;
        String str;
        int i3 = 0;
        i2 = -16777216;
        if (width & i2 == 0 && i2 &= height == 0) {
            i = i2 &= height == 0 ? 1 : 0;
        } else {
        }
        int i7 = 0;
        if (i == 0) {
            int i8 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Size(").append(width).append(" x ").append(height).append(") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }
        LookaheadCapablePlaceable.layout.1 $i$f$checkMeasuredSize = new LookaheadCapablePlaceable.layout.1(width, height, alignmentLines, rulers, placementBlock, this);
        return (MeasureResult)$i$f$checkMeasuredSize;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final void provideRelativeRulerValue(Ruler ruler, float value) {
        MutableObjectFloatMap mutableObjectFloatMap;
        MutableObjectFloatMap num;
        int i3;
        int i;
        int i2;
        if (this.rulerValues == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, 0);
            i = 0;
            this.rulerValues = mutableObjectFloatMap;
        }
        if (getLayoutDirection() == LayoutDirection.Ltr) {
            i3 = value;
        } else {
            f -= value;
        }
        mutableObjectFloatMap.set(ruler, i3);
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final void provideRulerValue(Ruler ruler, float value) {
        MutableObjectFloatMap mutableObjectFloatMap;
        MutableObjectFloatMap num;
        int i2;
        int i;
        if (this.rulerValues == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, 0);
            i2 = 0;
            this.rulerValues = mutableObjectFloatMap;
        }
        mutableObjectFloatMap.set(ruler, value);
    }

    @Override // androidx.compose.ui.layout.Placeable
    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.layout.Placeable
    public void setPlacedUnderMotionFrameOfReference(boolean <set-?>) {
        this.isPlacedUnderMotionFrameOfReference = <set-?>;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final void setPlacingForAlignment$ui_release(boolean <set-?>) {
        this.isPlacingForAlignment = <set-?>;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final void setShallowPlacing$ui_release(boolean <set-?>) {
        this.isShallowPlacing = <set-?>;
    }
}
