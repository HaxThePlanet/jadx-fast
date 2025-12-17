package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008 \u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0008NJ\u0010\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0012H\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0016J\u0010\u0010S\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0012H\u0016J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0016J)\u0010U\u001a\u00020V2\u0006\u0010\u0018\u001a\u00020\u00192\u000c\u0010W\u001a\u0008\u0012\u0004\u0012\u00020\u00070XH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZJ=\u0010[\u001a\u00020\\2\u0006\u0010C\u001a\u00020D2\u0006\u0010]\u001a\u00020#2\u0019\u0010^\u001a\u0015\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\\\u0018\u00010_¢\u0006\u0002\u0008aH\u0004ø\u0001\u0000¢\u0006\u0004\u0008b\u0010cJ\u0008\u0010d\u001a\u00020\\H\u0014J\u001a\u0010e\u001a\u00020\\2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\u0008f\u0010GJ\u001a\u0010g\u001a\u00020\\2\u0006\u0010C\u001a\u00020DH\u0000ø\u0001\u0000¢\u0006\u0004\u0008h\u0010GJ%\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020)H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008l\u0010mJ\r\u0010n\u001a\u00020\\H\u0010¢\u0006\u0002\u0008oR\"\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00198@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010+R\u0014\u0010-\u001a\u00020.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008/\u00100R\u0014\u00101\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00083\u00104R\u0011\u00105\u001a\u000206¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0014\u00109\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008:\u0010;R\u001c\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008>\u0010\u0017R\u0016\u0010?\u001a\u0004\u0018\u00010@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010BR\"\u0010C\u001a\u00020DX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\u0008E\u0010\u001b\"\u0004\u0008F\u0010GR\u001a\u0010I\u001a\u00020J8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008K\u0010\u001b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006p", d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "result", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "cachedAlignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getCachedAlignmentLinesMap", "()Ljava/util/Map;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk$ui_release", "()J", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "oldAlignmentLines", "parent", "getParent", "parentData", "", "getParentData", "()Ljava/lang/Object;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$ui_release", "getCachedAlignmentLine", "alignmentLine", "getCachedAlignmentLine$ui_release", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "block", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeChildren", "placeSelf", "placeSelf--gyyYBs", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset--gyyYBs$ui_release", "positionIn", "ancestor", "excludingAgnosticOffset", "positionIn-iSbpLlY$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;Z)J", "replace", "replace$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LookaheadDelegate extends androidx.compose.ui.node.LookaheadCapablePlaceable implements Measurable {

    public static final int $stable;
    private MeasureResult _measureResult;
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap;
    private final androidx.compose.ui.node.NodeCoordinator coordinator;
    private final LookaheadLayoutCoordinates lookaheadLayoutCoordinates;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    static {
    }

    public LookaheadDelegate(androidx.compose.ui.node.NodeCoordinator coordinator) {
        super();
        this.coordinator = coordinator;
        this.position = IntOffset.Companion.getZero-nOcc-ac();
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = new LookaheadLayoutCoordinates(this);
        this.lookaheadLayoutCoordinates = lookaheadLayoutCoordinates;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.cachedAlignmentLinesMap = (Map)linkedHashMap;
    }

    public static final void access$setMeasurementConstraints-BRTryo0(androidx.compose.ui.node.LookaheadDelegate $this, long value) {
        $this.setMeasurementConstraints-BRTryo0(value);
    }

    public static final void access$set_measureResult(androidx.compose.ui.node.LookaheadDelegate $this, MeasureResult result) {
        $this.set_measureResult(result);
    }

    private final void placeSelf--gyyYBs(long position) {
        boolean coordinator;
        boolean placingForAlignment$ui_release;
        setPosition--gyyYBs(position);
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
        if (!IntOffset.equals-impl0(getPosition-nOcc-ac(), obj1) && lookaheadPassDelegate$ui_release != null) {
            setPosition--gyyYBs(position);
            lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (!isPlacingForAlignment$ui_release()) {
            captureRulers$ui_release(getMeasureResult$ui_release());
        }
    }

    private final void set_measureResult(MeasureResult result) {
        Unit it;
        Map oldAlignmentLines3;
        int oldAlignmentLines2;
        int oldAlignmentLines;
        long zero-YbymL2g;
        int height;
        if (result != null) {
            Object obj = result;
            oldAlignmentLines = 0;
            height = obj.getHeight();
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(obj.getWidth(), height));
            it = Unit.INSTANCE;
        } else {
            it = 0;
        }
        if (it == null) {
            oldAlignmentLines = 0;
            (LookaheadDelegate)this.setMeasuredSize-ozmzZPI(IntSize.Companion.getZero-YbymL2g());
        }
        if (!Intrinsics.areEqual(this._measureResult, result) && result != null) {
            if (result != null) {
                oldAlignmentLines3 = this.oldAlignmentLines;
                if (oldAlignmentLines3 != null) {
                    if (oldAlignmentLines3.isEmpty()) {
                        oldAlignmentLines2 = 1;
                    } else {
                        oldAlignmentLines2 = 0;
                    }
                } else {
                }
                if (oldAlignmentLines2 != 0) {
                    getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                    if (!result.getAlignmentLines().isEmpty() && !Intrinsics.areEqual(result.getAlignmentLines(), this.oldAlignmentLines) && this.oldAlignmentLines == null) {
                        if (!Intrinsics.areEqual(result.getAlignmentLines(), this.oldAlignmentLines)) {
                            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                            if (this.oldAlignmentLines == null) {
                                oldAlignmentLines2 = new LinkedHashMap();
                                zero-YbymL2g = 0;
                                this.oldAlignmentLines = (Map)oldAlignmentLines2;
                            }
                            oldAlignmentLines2.clear();
                            oldAlignmentLines2.putAll(result.getAlignmentLines());
                        }
                    }
                } else {
                }
            }
        }
        this._measureResult = result;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.AlignmentLinesOwner getAlignmentLinesOwner() {
        androidx.compose.ui.node.AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final int getCachedAlignmentLine$ui_release(AlignmentLine alignmentLine) {
        int intValue;
        Object obj = this.cachedAlignmentLinesMap.get(alignmentLine);
        if ((Integer)obj != null) {
            intValue = (Integer)obj.intValue();
        } else {
            intValue = Integer.MIN_VALUE;
        }
        return intValue;
    }

    protected final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.LookaheadCapablePlaceable getChild() {
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate;
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        } else {
            lookaheadDelegate = 0;
        }
        return (LookaheadCapablePlaceable)lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final long getConstraints-msEJaDk$ui_release() {
        return getMeasurementConstraints-msEJaDk();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return (LayoutCoordinates)this.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final androidx.compose.ui.node.NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        int i;
        i = this._measureResult != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadLayoutCoordinates getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult _measureResult = this._measureResult;
        if (_measureResult == null) {
        } else {
            return _measureResult;
        }
        IllegalStateException illegalStateException = new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public androidx.compose.ui.node.LookaheadCapablePlaceable getParent() {
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate;
        androidx.compose.ui.node.NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null) {
            lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate();
        } else {
            lookaheadDelegate = 0;
        }
        return (LookaheadCapablePlaceable)lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long getPosition-nOcc-ac() {
        return this.position;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final long getSize-YbymL2g$ui_release() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean isLookingAhead() {
        return 1;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int maxIntrinsicHeight(int width) {
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int maxIntrinsicWidth(int height) {
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int minIntrinsicHeight(int width) {
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int minIntrinsicWidth(int height) {
        androidx.compose.ui.node.NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = wrapped$ui_release.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.minIntrinsicWidth(height);
    }

    public final Placeable performingMeasure-K40F9xA(long constraints, Function0<? extends MeasureResult> block) {
        final int i = 0;
        LookaheadDelegate.access$setMeasurementConstraints-BRTryo0(this, constraints);
        LookaheadDelegate.access$set_measureResult(this, (MeasureResult)obj5.invoke());
        return (Placeable)this;
    }

    protected final void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        placeSelf--gyyYBs(position);
        if (isShallowPlacing$ui_release()) {
        }
        placeChildren();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    protected void placeChildren() {
        getMeasureResult$ui_release().placeChildren();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void placeSelfApparentToRealOffset--gyyYBs$ui_release(long position) {
        placeSelf--gyyYBs(IntOffset.plus-qkQi6aY(position, obj4));
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final long positionIn-iSbpLlY$ui_release(androidx.compose.ui.node.LookaheadDelegate ancestor, boolean excludingAgnosticOffset) {
        long aggregatedOffset;
        Object lookaheadDelegate2;
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate;
        boolean placedUnderMotionFrameOfReference;
        aggregatedOffset = IntOffset.Companion.getZero-nOcc-ac();
        lookaheadDelegate2 = this;
        while (!Intrinsics.areEqual(lookaheadDelegate2, ancestor)) {
            if (lookaheadDelegate2.isPlacedUnderMotionFrameOfReference()) {
            } else {
            }
            aggregatedOffset = IntOffset.plus-qkQi6aY(aggregatedOffset, obj1);
            androidx.compose.ui.node.NodeCoordinator wrappedBy$ui_release = lookaheadDelegate2.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            lookaheadDelegate2 = lookaheadDelegate;
            if (excludingAgnosticOffset == null) {
            }
        }
        return aggregatedOffset;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        placeAt-f8xVGno(getPosition-nOcc-ac(), obj1, 0);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void setPosition--gyyYBs(long <set-?>) {
        this.position = <set-?>;
    }
}
