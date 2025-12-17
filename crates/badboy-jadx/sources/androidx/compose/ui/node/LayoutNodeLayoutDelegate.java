package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u001c\u0008\u0000\u0018\u00002\u00020\u0001:\u0002ghB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010R\u001a\u00020MH\u0000¢\u0006\u0002\u0008SJ\u0006\u0010T\u001a\u00020MJ\u0006\u0010U\u001a\u00020MJ\r\u0010V\u001a\u00020MH\u0000¢\u0006\u0002\u0008WJ\r\u0010X\u001a\u00020MH\u0000¢\u0006\u0002\u0008YJ\r\u0010Z\u001a\u00020MH\u0000¢\u0006\u0002\u0008[J\r\u0010\\\u001a\u00020MH\u0000¢\u0006\u0002\u0008]J\u0006\u0010^\u001a\u00020MJ\u001a\u0010_\u001a\u00020M2\u0006\u0010`\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\u0008a\u0010bJ\u001a\u0010c\u001a\u00020M2\u0006\u0010`\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\u0008d\u0010bJ\u0006\u0010e\u001a\u00020MJ\u0006\u0010f\u001a\u00020MR\u0014\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\r\"\u0004\u0008\u0012\u0010\u000fR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u0016\"\u0004\u0008\u001b\u0010\u0018R\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\rR\u0019\u0010!\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0019\u0010%\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008&\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u0016R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020*@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R\u0016\u0010.\u001a\u0004\u0018\u00010\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008/\u0010\u0008R$\u00100\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u0010\u0016\"\u0004\u00082\u0010\u0018R$\u00103\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u0010\u0016\"\u0004\u00085\u0010\u0018R\u001e\u00106\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\u0016R\u000e\u00108\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010\u0016R*\u0010<\u001a\u0008\u0018\u00010;R\u00020\u00002\u000c\u0010\u001c\u001a\u0008\u0018\u00010;R\u00020\u0000@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010>R\u0018\u0010?\u001a\u00060@R\u00020\u0000X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010BR\u001e\u0010C\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010\u0016R\u000e\u0010E\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010G\u001a\u00020H8F¢\u0006\u0006\u001a\u0004\u0008I\u0010JR\u0014\u0010K\u001a\u0008\u0012\u0004\u0012\u00020M0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\u00020\"X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010OR\u0014\u0010P\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008Q\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006i", d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", "", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "childrenAccessingLookaheadCoordinatesDuringPlacement", "getChildrenAccessingLookaheadCoordinatesDuringPlacement", "setChildrenAccessingLookaheadCoordinatesDuringPlacement", "", "coordinatesAccessedDuringModifierPlacement", "getCoordinatesAccessedDuringModifierPlacement", "()Z", "setCoordinatesAccessedDuringModifierPlacement", "(Z)V", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "setCoordinatesAccessedDuringPlacement", "<set-?>", "detachedFromParentLookaheadPass", "getDetachedFromParentLookaheadPass$ui_release", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadCoordinatesAccessedDuringModifierPlacement", "getLookaheadCoordinatesAccessedDuringModifierPlacement", "setLookaheadCoordinatesAccessedDuringModifierPlacement", "lookaheadCoordinatesAccessedDuringPlacement", "getLookaheadCoordinatesAccessedDuringPlacement", "setLookaheadCoordinatesAccessedDuringPlacement", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "nextChildLookaheadPlaceOrder", "nextChildPlaceOrder", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "performMeasureBlock", "Lkotlin/Function0;", "", "performMeasureConstraints", "J", "width", "getWidth$ui_release", "ensureLookaheadDelegateCreated", "ensureLookaheadDelegateCreated$ui_release", "invalidateParentData", "markChildrenDirty", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onCoordinatesUsed", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutNodeLayoutDelegate {

    public static final int $stable = 8;
    private int childrenAccessingCoordinatesDuringPlacement;
    private int childrenAccessingLookaheadCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringModifierPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    private boolean detachedFromParentLookaheadPass;
    private final androidx.compose.ui.node.LayoutNode layoutNode;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private androidx.compose.ui.node.LayoutNode.LayoutState layoutState;
    private boolean lookaheadCoordinatesAccessedDuringModifierPlacement;
    private boolean lookaheadCoordinatesAccessedDuringPlacement;
    private boolean lookaheadLayoutPending;
    private boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate;
    private final androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate;
    private boolean measurePending;
    private int nextChildLookaheadPlaceOrder;
    private int nextChildPlaceOrder;
    private final Function0<Unit> performMeasureBlock;
    private long performMeasureConstraints;

    @Metadata(d1 = "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0002\u0008\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u00080\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0014\u0010b\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020J0cH\u0016J\u0008\u0010e\u001a\u00020.H\u0002J\u0008\u0010f\u001a\u00020.H\u0002J\u001c\u0010g\u001a\u00020.2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020.0,H\u0016J!\u0010i\u001a\u00020.2\u0016\u0010h\u001a\u0012\u0012\u0008\u0012\u00060\u0000R\u00020\u0008\u0012\u0004\u0012\u00020.0,H\u0082\u0008J\u0011\u0010j\u001a\u00020J2\u0006\u0010k\u001a\u00020dH\u0096\u0002J\u000e\u0010l\u001a\u00020.2\u0006\u0010m\u001a\u00020\u0012J\u0006\u0010n\u001a\u00020.J\u0008\u0010o\u001a\u00020.H\u0016J\u0008\u0010p\u001a\u00020.H\u0002J\u0008\u0010q\u001a\u00020.H\u0002J\u0010\u0010r\u001a\u00020J2\u0006\u0010s\u001a\u00020JH\u0016J\u0010\u0010t\u001a\u00020J2\u0006\u0010u\u001a\u00020JH\u0016J\u001a\u0010v\u001a\u00020\u00012\u0006\u0010w\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\u0008x\u0010yJ\u0010\u0010z\u001a\u00020J2\u0006\u0010s\u001a\u00020JH\u0016J\u0010\u0010{\u001a\u00020J2\u0006\u0010u\u001a\u00020JH\u0016J\u0006\u0010|\u001a\u00020.J\u0008\u0010}\u001a\u00020.H\u0002J\u0008\u0010~\u001a\u00020.H\u0002J\u0006\u0010\u007f\u001a\u00020.J\u000f\u0010\u0080\u0001\u001a\u00020.H\u0000¢\u0006\u0003\u0008\u0081\u0001JC\u0010\u0082\u0001\u001a\u00020.2\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u0002082\u001a\u0010\u0085\u0001\u001a\u0015\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,¢\u0006\u0002\u0008/H\u0014ø\u0001\u0000¢\u0006\u0006\u0008\u0086\u0001\u0010\u0087\u0001J0\u0010\u0082\u0001\u001a\u00020.2\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u0002082\u0007\u0010\u0088\u0001\u001a\u00020(H\u0014ø\u0001\u0000¢\u0006\u0006\u0008\u0086\u0001\u0010\u0089\u0001JN\u0010\u008a\u0001\u001a\u00020.2\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u0002082\u001a\u0010\u0085\u0001\u001a\u0015\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,¢\u0006\u0002\u0008/2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010(H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u008b\u0001\u0010\u008c\u0001J\u001b\u0010\u008d\u0001\u001a\u00020\u00122\u0006\u0010w\u001a\u00020$ø\u0001\u0000¢\u0006\u0006\u0008\u008e\u0001\u0010\u008f\u0001J\u0007\u0010\u0090\u0001\u001a\u00020.J\t\u0010\u0091\u0001\u001a\u00020.H\u0016J\t\u0010\u0092\u0001\u001a\u00020.H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020.2\u0008\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J\u0007\u0010\u0096\u0001\u001a\u00020\u0012R\u0018\u0010\u0006\u001a\u000c\u0012\u0008\u0012\u00060\u0000R\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\r\u001a\u000c\u0012\u0008\u0012\u00060\u0000R\u00020\u00080\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0014\"\u0004\u0008\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014\"\u0004\u0008\u001f\u0010\u0016R$\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u0014\"\u0004\u0008\"\u0010\u0016R\u0019\u0010#\u001a\u0004\u0018\u00010$8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\"\u0010)\u001a\u0004\u0018\u00010(2\u0008\u0010'\u001a\u0004\u0018\u00010(@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+RD\u00100\u001a\u0015\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,¢\u0006\u0002\u0008/2\u0019\u0010'\u001a\u0015\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0018\u00010,¢\u0006\u0002\u0008/@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R&\u00104\u001a\u0002032\u0006\u0010'\u001a\u000203@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00107\u001a\u0004\u00085\u00106R\u001e\u00109\u001a\u0002082\u0006\u0010'\u001a\u000208@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u001e\u0010<\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010\u0014R\u0016\u0010>\u001a\u0004\u0018\u00010$X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\u00060@R\u00020\u00088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010BR\u001a\u0010C\u001a\u00020DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010F\"\u0004\u0008G\u0010HR\u0014\u0010I\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008K\u0010LR\u000e\u0010M\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010LR\u000e\u0010P\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008R\u0010SR\"\u0010U\u001a\u0004\u0018\u00010T2\u0008\u0010'\u001a\u0004\u0018\u00010T@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008V\u0010WR\u000e\u0010X\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u00020JX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010L\"\u0004\u0008[\u0010\\R\u001a\u0010]\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008^\u0010\u0014\"\u0004\u0008_\u0010\u0016R\u0018\u0010`\u001a\u00020J2\u0006\u0010'\u001a\u00020J@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0097\u0001", d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "setPlaced", "new", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "<set-?>", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastExplicitLayer", "getLastExplicitLayer$ui_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastLayerBlock", "getLastLayerBlock$ui_release", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/IntOffset;", "lastPosition", "getLastPosition-nOcc-ac$ui_release", "()J", "J", "", "lastZIndex", "getLastZIndex$ui_release", "()F", "layingOutChildren", "getLayingOutChildren", "lookaheadConstraints", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "onNodePlacedCalled", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "setPlaceOrder$ui_release", "(I)V", "placedOnce", "getPlacedOnce$ui_release", "setPlacedOnce$ui_release", "previousPlaceOrder", "relayoutWithoutParentInProgress", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingLookaheadCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackLookaheadMeasurementByParent", "node", "Landroidx/compose/ui/node/LayoutNode;", "updateParentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class LookaheadPassDelegate extends Placeable implements Measurable, androidx.compose.ui.node.AlignmentLinesOwner, androidx.compose.ui.node.MotionReferencePlacementDelegate {

        private final MutableVector<androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate> _childDelegates;
        private final androidx.compose.ui.node.AlignmentLines alignmentLines;
        private boolean childDelegatesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPlacedUnderMotionFrameOfReference;
        private GraphicsLayer lastExplicitLayer;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition;
        private float lastZIndex;
        private boolean layingOutChildren;
        private Constraints lookaheadConstraints;
        private androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParent = Integer.MAX_VALUE;
        private boolean measuredOnce;
        private boolean onNodePlacedCalled;
        private Object parentData;
        private boolean parentDataDirty = true;
        private int placeOrder = Integer.MAX_VALUE;
        private boolean placedOnce;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private boolean relayoutWithoutParentInProgress;
        final androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0;
        public LookaheadPassDelegate(androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0) {
            this.this$0 = this$0;
            super();
            int i = Integer.MAX_VALUE;
            androidx.compose.ui.node.LayoutNode.UsageByParent notUsed = LayoutNode.UsageByParent.NotUsed;
            this.lastPosition = IntOffset.Companion.getZero-nOcc-ac();
            LookaheadAlignmentLines lookaheadAlignmentLines = new LookaheadAlignmentLines((AlignmentLinesOwner)this);
            this.alignmentLines = (AlignmentLines)lookaheadAlignmentLines;
            int i4 = 0;
            MutableVector mutableVector = new MutableVector(new LayoutNodeLayoutDelegate.LookaheadPassDelegate[16], 0);
            this._childDelegates = mutableVector;
            int i3 = 1;
            this.parentData = getMeasurePassDelegate$ui_release().getParentData();
        }

        public static final void access$checkChildrenPlaceOrderForUpdates(androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate $this) {
            $this.checkChildrenPlaceOrderForUpdates();
        }

        public static final void access$clearPlaceOrder(androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate $this) {
            $this.clearPlaceOrder();
        }

        private final void checkChildrenPlaceOrderForUpdates() {
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            int i2;
            int previousPlaceOrder;
            int placeOrder;
            final int i3 = 0;
            final int i4 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).get_children$ui_release();
            final int i5 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv$iv = 0;
                i = 0;
                lookaheadPassDelegate$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                i2 = 0;
                do {
                    i = 0;
                    lookaheadPassDelegate$ui_release = (LayoutNode)content[i$iv$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    i2 = 0;
                    if (i$iv$iv$iv++ < size) {
                    }
                    if (lookaheadPassDelegate$ui_release.placeOrder == Integer.MAX_VALUE) {
                    }
                    lookaheadPassDelegate$ui_release.markSubtreeAsNotPlaced();
                } while (lookaheadPassDelegate$ui_release.previousPlaceOrder != lookaheadPassDelegate$ui_release.placeOrder);
            }
        }

        private final void clearPlaceOrder() {
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i2;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            int i;
            androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParent;
            androidx.compose.ui.node.LayoutNode.UsageByParent inLayoutBlock;
            LayoutNodeLayoutDelegate.access$setNextChildLookaheadPlaceOrder$p(this.this$0, 0);
            int i4 = 0;
            final int i5 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).get_children$ui_release();
            final int i6 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv$iv = 0;
                i2 = 0;
                lookaheadPassDelegate$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                i = 0;
                lookaheadPassDelegate$ui_release.previousPlaceOrder = lookaheadPassDelegate$ui_release.placeOrder;
                lookaheadPassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                do {
                    i2 = 0;
                    lookaheadPassDelegate$ui_release = (LayoutNode)content[i$iv$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    i = 0;
                    lookaheadPassDelegate$ui_release.previousPlaceOrder = lookaheadPassDelegate$ui_release.placeOrder;
                    lookaheadPassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                    if (i$iv$iv$iv++ < size) {
                    }
                    lookaheadPassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                } while (lookaheadPassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock);
            }
        }

        private final void forEachChildDelegate(Function1<? super androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate, Unit> block) {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            final int i2 = 0;
            final int i3 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            final int i4 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                i = 0;
                lookaheadPassDelegate$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                block.invoke(lookaheadPassDelegate$ui_release);
                while (i$iv$iv++ >= size) {
                    i = 0;
                    lookaheadPassDelegate$ui_release = (LayoutNode)content[i$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    block.invoke(lookaheadPassDelegate$ui_release);
                }
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            int lookaheadMeasurePending$ui_release;
            androidx.compose.ui.node.LayoutNode layoutNode;
            int i4;
            int i5;
            int i2;
            int i$iv$iv;
            int content;
            Object obj;
            int i3;
            int placeOrder$ui_release;
            int i;
            setPlaced(true);
            if (!isPlaced() && this.this$0.getLookaheadMeasurePending$ui_release()) {
                if (this.this$0.getLookaheadMeasurePending$ui_release()) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), true, false, false, 6, 0);
                }
            }
            int i6 = 0;
            MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            int i7 = 0;
            int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv];
                i3 = 0;
                do {
                    obj = content[i$iv$iv];
                    i3 = 0;
                    if (i$iv$iv++ < size) {
                    }
                    placeOrder$ui_release = obj.getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(placeOrder$ui_release);
                    placeOrder$ui_release.markNodeAndSubtreeAsPlaced();
                    obj.rescheduleRemeasureOrRelayout$ui_release(obj);
                } while ((LayoutNode)obj.getPlaceOrder$ui_release() != Integer.MAX_VALUE);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            boolean placed;
            int i;
            androidx.compose.ui.node.LayoutNode layoutNode;
            int i3;
            MutableVector mutableVector;
            int i4;
            int size;
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i2;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            int i5;
            setPlaced(false);
            i = 0;
            i3 = 0;
            mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(placed.this$0).get_children$ui_release();
            i4 = 0;
            size = mutableVector.getSize();
            if (isPlaced() && size > 0) {
                setPlaced(false);
                i = 0;
                i3 = 0;
                mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(placed.this$0).get_children$ui_release();
                i4 = 0;
                size = mutableVector.getSize();
                if (size > 0) {
                    i$iv$iv$iv = 0;
                    i2 = 0;
                    lookaheadPassDelegate$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    i5 = 0;
                    lookaheadPassDelegate$ui_release.markSubtreeAsNotPlaced();
                    while (i$iv$iv$iv++ >= size) {
                        i2 = 0;
                        lookaheadPassDelegate$ui_release = (LayoutNode)content[i$iv$iv$iv].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        i5 = 0;
                        lookaheadPassDelegate$ui_release.markSubtreeAsNotPlaced();
                    }
                }
            }
        }

        private final void onBeforeLayoutChildren() {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i6;
            boolean lookaheadMeasurePending$ui_release;
            androidx.compose.ui.node.LayoutNode.UsageByParent inMeasureBlock;
            int i;
            int i3;
            int i4;
            int i2;
            int i5;
            final Object obj2 = this;
            final int i7 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).get_children$ui_release();
            final int i8 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv];
                i6 = 0;
                do {
                    obj = content[i$iv$iv];
                    i6 = 0;
                    if (i$iv$iv++ < size) {
                    }
                    androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = obj.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    Constraints lastLookaheadConstraints-DWUhwKw = obj.getLayoutDelegate$ui_release().getLastLookaheadConstraints-DWUhwKw();
                    Intrinsics.checkNotNull(lastLookaheadConstraints-DWUhwKw);
                    if (obj.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && lookaheadPassDelegate$ui_release.remeasure-BRTryo0(lastLookaheadConstraints-DWUhwKw.unbox-impl())) {
                    }
                    lookaheadPassDelegate$ui_release = obj.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lastLookaheadConstraints-DWUhwKw = obj.getLayoutDelegate$ui_release().getLastLookaheadConstraints-DWUhwKw();
                    Intrinsics.checkNotNull(lastLookaheadConstraints-DWUhwKw);
                    if (lookaheadPassDelegate$ui_release.remeasure-BRTryo0(lastLookaheadConstraints-DWUhwKw.unbox-impl())) {
                    }
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0), false, false, false, 7, 0);
                } while ((LayoutNode)obj.getLookaheadMeasurePending$ui_release());
            }
        }

        private final void onIntrinsicsQueried() {
            Object intrinsicsUsageByParent$ui_release2;
            int intrinsicsUsageByParent$ui_release;
            int $EnumSwitchMapping$0;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, false, false, 7, 0);
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            if (parent$ui_release != null && LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                if (LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                    switch (i) {
                        case 2:
                            intrinsicsUsageByParent$ui_release = LayoutNode.UsageByParent.InMeasureBlock;
                            break;
                        case 3:
                            intrinsicsUsageByParent$ui_release = LayoutNode.UsageByParent.InLayoutBlock;
                            break;
                        default:
                            intrinsicsUsageByParent$ui_release = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
                    }
                    LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).setIntrinsicsUsageByParent$ui_release(intrinsicsUsageByParent$ui_release);
                }
            }
        }

        private final void placeSelf-MLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
            Object lookaheadDelegate;
            boolean lookaheadCoordinatesAccessedDuringModifierPlacement;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate lookaheadLayoutPending$ui_release;
            String $i$a$RequirePreconditionLayoutNodeLayoutDelegate$LookaheadPassDelegate$placeSelf$1;
            androidx.compose.ui.node.LayoutNode layoutNode;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate.placeSelf.2 anon;
            int i2;
            int i3;
            int i6 = 1;
            int i7 = 0;
            if (deactivated ^= i6 == 0) {
                int i8 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.LookaheadLayingOut);
            this.placedOnce = i6;
            int i5 = 0;
            this.onNodePlacedCalled = i5;
            if (!IntOffset.equals-impl0(position, zIndex)) {
                if (!this.this$0.getLookaheadCoordinatesAccessedDuringModifierPlacement()) {
                    if (this.this$0.getLookaheadCoordinatesAccessedDuringPlacement()) {
                        LayoutNodeLayoutDelegate.access$setLookaheadLayoutPending$p(this.this$0, i6);
                    }
                } else {
                }
                notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            androidx.compose.ui.node.Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0));
            if (!this.this$0.getLookaheadLayoutPending$ui_release() && isPlaced()) {
                if (isPlaced()) {
                    lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
                    Intrinsics.checkNotNull(lookaheadDelegate);
                    lookaheadDelegate.placeSelfApparentToRealOffset--gyyYBs$ui_release(position);
                    onNodePlaced$ui_release();
                } else {
                    this.this$0.setLookaheadCoordinatesAccessedDuringModifierPlacement(i5);
                    getAlignmentLines().setUsedByModifierLayout$ui_release(i5);
                    lookaheadDelegate = new LayoutNodeLayoutDelegate.LookaheadPassDelegate.placeSelf.2(this.this$0, requireOwner, position, zIndex);
                    OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(requireOwner.getSnapshotObserver(), LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, (Function0)lookaheadDelegate, 2, 0);
                }
            } else {
            }
            this.lastPosition = position;
            this.lastZIndex = layerBlock;
            this.lastLayerBlock = layer;
            this.lastExplicitLayer = obj14;
            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.Idle);
        }

        private final void trackLookaheadMeasurementByParent(androidx.compose.ui.node.LayoutNode node) {
            androidx.compose.ui.node.LayoutNode.UsageByParent inMeasureBlock;
            int i;
            androidx.compose.ui.node.LayoutNode.UsageByParent canMultiMeasure$ui_release;
            int[] $EnumSwitchMapping$0;
            String $i$a$CheckPreconditionLayoutNodeLayoutDelegate$LookaheadPassDelegate$trackLookaheadMeasurementByParent$1;
            final androidx.compose.ui.node.LayoutNode parent$ui_release = node.getParent$ui_release();
            if (parent$ui_release != null) {
                if (this.measuredByParent != LayoutNode.UsageByParent.NotUsed) {
                    if (node.getCanMultiMeasure$ui_release()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
                int i3 = 0;
                if (i == 0) {
                    int i4 = 0;
                    InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
                }
                switch (i2) {
                    case 1:
                        inMeasureBlock = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 2:
                        inMeasureBlock = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Measurable could be only measured from the parent's measure or layout block. Parents state is ").append(parent$ui_release.getLayoutState$ui_release()).toString());
                        throw illegalStateException;
                }
                this.measuredByParent = inMeasureBlock;
            }
            this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            boolean duringAlignmentLinesQuery;
            int i;
            androidx.compose.ui.node.LayoutNode.LayoutState lookaheadMeasuring;
            i = 1;
            if (!this.duringAlignmentLinesQuery) {
                if (this.this$0.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(i);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        this.this$0.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(i);
                }
            }
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate == null) {
            } else {
                lookaheadDelegate.setPlacingForAlignment$ui_release(i);
            }
            layoutChildren();
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate2 == null) {
            } else {
                lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super androidx.compose.ui.node.AlignmentLinesOwner, Unit> block) {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i;
            androidx.compose.ui.node.AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release;
            final int i2 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            final int i3 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                i = 0;
                lookaheadAlignmentLinesOwner$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv].getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                block.invoke(lookaheadAlignmentLinesOwner$ui_release);
                while (i$iv$iv++ >= size) {
                    i = 0;
                    lookaheadAlignmentLinesOwner$ui_release = (LayoutNode)content[i$iv$iv].getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                    Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                    block.invoke(lookaheadAlignmentLinesOwner$ui_release);
                }
            }
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int get(AlignmentLine alignmentLine) {
            int layoutState$ui_release2;
            Object lookaheadLayingOut;
            int layoutState$ui_release;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            if (parent$ui_release != null) {
                layoutState$ui_release2 = parent$ui_release.getLayoutState$ui_release();
            } else {
                layoutState$ui_release2 = layoutState$ui_release;
            }
            final int i3 = 1;
            if (layoutState$ui_release2 == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(i3);
            } else {
                androidx.compose.ui.node.LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState$ui_release = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(i3);
                }
            }
            this.duringAlignmentLinesQuery = i3;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            this.duringAlignmentLinesQuery = false;
            return lookaheadDelegate.get(alignmentLine);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public androidx.compose.ui.node.AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final List<androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate> getChildDelegates$ui_release() {
            androidx.compose.ui.node.LayoutNode $this$updateChildMeasurables$iv2;
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i;
            int i2;
            int i3;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            androidx.compose.ui.node.LayoutNode $this$updateChildMeasurables$iv;
            final Object obj2 = this;
            List children$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).getChildren$ui_release();
            int i5 = 0;
            if (!obj2.childDelegatesDirty) {
                return obj2._childDelegates.asMutableList();
            }
            $this$updateChildMeasurables$iv2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0);
            MutableVector _childDelegates2 = obj2._childDelegates;
            int i6 = 0;
            final int i7 = 0;
            final MutableVector mutableVector = $this$updateChildMeasurables$iv2.get_children$ui_release();
            final int i8 = 0;
            final int size3 = mutableVector.getSize();
            if (size3 > 0) {
                i$iv$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv$iv];
                i = i$iv$iv$iv;
                i2 = 0;
                while (_childDelegates2.getSize() <= i) {
                    lookaheadPassDelegate$ui_release = 0;
                    $this$updateChildMeasurables$iv = $this$updateChildMeasurables$iv2;
                    $this$updateChildMeasurables$iv2 = (LayoutNode)obj.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull($this$updateChildMeasurables$iv2);
                    _childDelegates2.add($this$updateChildMeasurables$iv2);
                    if (i$iv$iv$iv++ < size3) {
                    }
                    $this$updateChildMeasurables$iv2 = $this$updateChildMeasurables$iv;
                    obj = content[i$iv$iv$iv];
                    i = i$iv$iv$iv;
                    i2 = 0;
                    $this$updateChildMeasurables$iv = $this$updateChildMeasurables$iv2;
                    i3 = 0;
                    lookaheadPassDelegate$ui_release = (LayoutNode)obj.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    _childDelegates2.set(i, lookaheadPassDelegate$ui_release);
                }
            } else {
                $this$updateChildMeasurables$iv = $this$updateChildMeasurables$iv2;
            }
            _childDelegates2.removeRange($this$updateChildMeasurables$iv.getChildren$ui_release().size(), _childDelegates2.getSize());
            obj2.childDelegatesDirty = false;
            return obj2._childDelegates.asMutableList();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getChildDelegatesDirty$ui_release() {
            return this.childDelegatesDirty;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public androidx.compose.ui.node.NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getInnerCoordinator$ui_release();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final Constraints getLastConstraints-DWUhwKw() {
            return this.lookaheadConstraints;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final GraphicsLayer getLastExplicitLayer$ui_release() {
            return this.lastExplicitLayer;
        }

        public final Function1<GraphicsLayerScope, Unit> getLastLayerBlock$ui_release() {
            return this.lastLayerBlock;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final long getLastPosition-nOcc-ac$ui_release() {
            return this.lastPosition;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final float getLastZIndex$ui_release() {
            return this.lastZIndex;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
            return this.this$0.getMeasurePassDelegate$ui_release();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final androidx.compose.ui.node.LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
            return this.measuredByParent;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredHeight() {
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredHeight();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredWidth() {
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredWidth();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public androidx.compose.ui.node.AlignmentLinesOwner getParentAlignmentLinesOwner() {
            Object layoutDelegate$ui_release;
            int lookaheadAlignmentLinesOwner$ui_release;
            layoutDelegate$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            layoutDelegate$ui_release = layoutDelegate$ui_release.getLayoutDelegate$ui_release();
            if (layoutDelegate$ui_release != null && layoutDelegate$ui_release != null) {
                layoutDelegate$ui_release = layoutDelegate$ui_release.getLayoutDelegate$ui_release();
                if (layoutDelegate$ui_release != null) {
                    lookaheadAlignmentLinesOwner$ui_release = layoutDelegate$ui_release.getLookaheadAlignmentLinesOwner$ui_release();
                } else {
                    lookaheadAlignmentLinesOwner$ui_release = 0;
                }
            } else {
            }
            return lookaheadAlignmentLinesOwner$ui_release;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public Object getParentData() {
            return this.parentData;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getPlaceOrder$ui_release() {
            return this.placeOrder;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getPlacedOnce$ui_release() {
            return this.placedOnce;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            androidx.compose.ui.node.LayoutNode intrinsicsUsageByParent$ui_release;
            androidx.compose.ui.node.LayoutNode.UsageByParent lookaheadRoot$ui_release;
            androidx.compose.ui.node.LayoutNode intrinsicsUsingParent;
            boolean forceRequest2;
            int i3;
            int i2;
            int i;
            int i4;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            androidx.compose.ui.node.LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release != null && intrinsicsUsageByParent$ui_release2 != LayoutNode.UsageByParent.NotUsed) {
                if (intrinsicsUsageByParent$ui_release2 != LayoutNode.UsageByParent.NotUsed) {
                    intrinsicsUsingParent = intrinsicsUsageByParent$ui_release;
                    while (intrinsicsUsingParent.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release2) {
                        intrinsicsUsageByParent$ui_release = intrinsicsUsingParent.getParent$ui_release();
                        if (intrinsicsUsageByParent$ui_release == null) {
                            break;
                        } else {
                        }
                        intrinsicsUsingParent = intrinsicsUsageByParent$ui_release;
                    }
                    switch (i5) {
                        case 1:
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(intrinsicsUsingParent, forceRequest, false, false, 6, 0);
                            LayoutNode.requestRemeasure$ui_release$default(intrinsicsUsingParent, forceRequest, false, false, 6, 0);
                            break;
                        case 2:
                            intrinsicsUsingParent.requestLookaheadRelayout$ui_release(forceRequest);
                            forceRequest2 = forceRequest;
                            intrinsicsUsingParent.requestRelayout$ui_release(forceRequest);
                            forceRequest2 = forceRequest;
                            break;
                        default:
                            boolean z = forceRequest;
                            IllegalStateException obj10 = new IllegalStateException("Intrinsics isn't used by the parent".toString());
                            throw obj10;
                    }
                }
            }
            forceRequest2 = forceRequest;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public boolean isPlaced() {
            return this.isPlaced;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public boolean isPlacedUnderMotionFrameOfReference() {
            return this.isPlacedUnderMotionFrameOfReference;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void layoutChildren() {
            boolean required$ui_release;
            boolean duringAlignmentLinesQuery;
            boolean usedDuringParentLayout$ui_release;
            androidx.compose.ui.node.Owner requireOwner;
            boolean lookaheadCoordinatesAccessedDuringPlacement;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0;
            androidx.compose.ui.node.OwnerSnapshotObserver snapshotObserver;
            androidx.compose.ui.node.LayoutNode layoutNode;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate.layoutChildren.1 anon;
            int i2;
            int i3;
            int i4 = 1;
            this.layingOutChildren = i4;
            getAlignmentLines().recalculateQueryOwner();
            if (this.this$0.getLookaheadLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            final int i5 = 0;
            if (!LayoutNodeLayoutDelegate.access$getLookaheadLayoutPendingForAlignment$p(this.this$0)) {
                LayoutNodeLayoutDelegate.access$setLookaheadLayoutPending$p(this.this$0, i5);
                LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.LookaheadLayingOut);
                this.this$0.setLookaheadCoordinatesAccessedDuringPlacement(i5);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate.layoutChildren.1 anon2 = new LayoutNodeLayoutDelegate.LookaheadPassDelegate.layoutChildren.1(this, lookaheadDelegate, this.this$0);
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0)).getSnapshotObserver(), LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, (Function0)anon2, 2, 0);
                LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, this.this$0.getLayoutState$ui_release());
                if (!this.duringAlignmentLinesQuery && !lookaheadDelegate.isPlacingForAlignment$ui_release() && this.this$0.getLookaheadLayoutPending$ui_release() && this.this$0.getLookaheadCoordinatesAccessedDuringPlacement() && lookaheadDelegate.isPlacingForAlignment$ui_release()) {
                    if (!lookaheadDelegate.isPlacingForAlignment$ui_release()) {
                        if (this.this$0.getLookaheadLayoutPending$ui_release()) {
                            LayoutNodeLayoutDelegate.access$setLookaheadLayoutPending$p(this.this$0, i5);
                            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.LookaheadLayingOut);
                            this.this$0.setLookaheadCoordinatesAccessedDuringPlacement(i5);
                            anon2 = new LayoutNodeLayoutDelegate.LookaheadPassDelegate.layoutChildren.1(this, lookaheadDelegate, this.this$0);
                            OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0)).getSnapshotObserver(), LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, (Function0)anon2, 2, 0);
                            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, this.this$0.getLayoutState$ui_release());
                            if (this.this$0.getLookaheadCoordinatesAccessedDuringPlacement()) {
                                if (lookaheadDelegate.isPlacingForAlignment$ui_release()) {
                                    requestLayout();
                                }
                            }
                            LayoutNodeLayoutDelegate.access$setLookaheadLayoutPendingForAlignment$p(this.this$0, i5);
                        }
                    }
                }
            } else {
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(i4);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                if (getAlignmentLines().getRequired$ui_release()) {
                    getAlignmentLines().recalculate();
                }
            }
            this.layingOutChildren = i5;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public Placeable measure-BRTryo0(long constraints) {
            int layoutState$ui_release2;
            Object intrinsicsUsageByParent$ui_release;
            int layoutState$ui_release;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            if (parent$ui_release != null) {
                layoutState$ui_release2 = parent$ui_release.getLayoutState$ui_release();
            } else {
                layoutState$ui_release2 = layoutState$ui_release;
            }
            if (layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadMeasuring) {
                androidx.compose.ui.node.LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState$ui_release = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
                    LayoutNodeLayoutDelegate.access$setDetachedFromParentLookaheadPass$p(this.this$0, false);
                }
            } else {
            }
            trackLookaheadMeasurementByParent(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0));
            if (LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).clearSubtreeIntrinsicsUsage$ui_release();
            }
            remeasure-BRTryo0(constraints);
            return (Placeable)this;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
            int childrenAccessingLookaheadCoordinatesDuringPlacement;
            int i2;
            MutableVector mutableVector;
            int i3;
            int size;
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i4;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            int i5;
            boolean lookaheadCoordinatesAccessedDuringPlacement;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            int i;
            boolean lookaheadLayoutPending$ui_release;
            i2 = 0;
            mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            i3 = 0;
            size = mutableVector.getSize();
            if (this.this$0.getChildrenAccessingLookaheadCoordinatesDuringPlacement() > 0 && size > 0) {
                i2 = 0;
                mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
                i3 = 0;
                size = mutableVector.getSize();
                if (size > 0) {
                    i$iv$iv = 0;
                    obj = mutableVector.getContent()[i$iv$iv];
                    i4 = 0;
                    layoutDelegate$ui_release = (LayoutNode)obj.getLayoutDelegate$ui_release();
                    int i6 = 0;
                    i = 1;
                    do {
                        obj = content[i$iv$iv];
                        i4 = 0;
                        layoutDelegate$ui_release = (LayoutNode)obj.getLayoutDelegate$ui_release();
                        i6 = 0;
                        i = 1;
                        i5 = i;
                        if (i5 != 0 && !layoutDelegate$ui_release.getLookaheadLayoutPending$ui_release()) {
                        }
                        lookaheadPassDelegate$ui_release = layoutDelegate$ui_release.getLookaheadPassDelegate$ui_release();
                        if (lookaheadPassDelegate$ui_release != null) {
                        }
                        if (i$iv$iv++ < size) {
                        }
                        lookaheadPassDelegate$ui_release.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                        if (!layoutDelegate$ui_release.getLookaheadLayoutPending$ui_release()) {
                        }
                        LayoutNode.requestLookaheadRelayout$ui_release$default(obj, i6, i, 0);
                        if (layoutDelegate$ui_release.getLookaheadCoordinatesAccessedDuringModifierPlacement()) {
                        } else {
                        }
                        i5 = i6;
                    } while (!layoutDelegate$ui_release.getLookaheadCoordinatesAccessedDuringPlacement());
                }
            }
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void onNodeDetached() {
            int i = Integer.MAX_VALUE;
            this.placeOrder = i;
            this.previousPlaceOrder = i;
            setPlaced(false);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void onNodePlaced$ui_release() {
            boolean relayoutWithoutParentInProgress;
            int i;
            androidx.compose.ui.node.LayoutNode.LayoutState $i$a$CheckPreconditionLayoutNodeLayoutDelegate$LookaheadPassDelegate$onNodePlaced$1;
            final int i2 = 1;
            this.onNodePlacedCalled = i2;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            i = 0;
            markNodeAndSubtreeAsPlaced();
            if (!isPlaced() && this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                markNodeAndSubtreeAsPlaced();
                if (this.relayoutWithoutParentInProgress) {
                    if (parent$ui_release != null) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, i, i2, 0);
                    }
                }
            }
            if (parent$ui_release != null) {
                if (!this.relayoutWithoutParentInProgress) {
                    if (parent$ui_release.getLayoutState$ui_release() != LayoutNode.LayoutState.LayingOut) {
                        if (parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut && this.placeOrder == Integer.MAX_VALUE) {
                            if (this.placeOrder == Integer.MAX_VALUE) {
                                i = i2;
                            }
                            int i3 = 0;
                            if (i == 0) {
                                int i6 = 0;
                                InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                            }
                            this.placeOrder = LayoutNodeLayoutDelegate.access$getNextChildLookaheadPlaceOrder$p(parent$ui_release.getLayoutDelegate$ui_release());
                            relayoutWithoutParentInProgress = parent$ui_release.getLayoutDelegate$ui_release();
                            LayoutNodeLayoutDelegate.access$setNextChildLookaheadPlaceOrder$p(relayoutWithoutParentInProgress, i5 += i2);
                        }
                    } else {
                    }
                }
            } else {
                this.placeOrder = i;
            }
            layoutChildren();
        }

        @Override // androidx.compose.ui.layout.Placeable
        protected void placeAt-f8xVGno(long position, float zIndex, GraphicsLayer layer) {
            this.placeSelf-MLgxB_4(position, obj2, layer, 0);
        }

        protected void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            this.placeSelf-MLgxB_4(position, obj2, layerBlock, obj10);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean remeasure-BRTryo0(long constraints) {
            int i2;
            boolean lookaheadMeasurePending$ui_release;
            long measuredSize-YbymL2g;
            String $i$a$RequirePreconditionLayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1;
            boolean canMultiMeasure$ui_release;
            int i3;
            int i;
            int height-impl;
            int height;
            String $i$a$CheckPreconditionLayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$3;
            i2 = 1;
            int i5 = 0;
            if (deactivated ^= i2 == 0) {
                int i7 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            final int i8 = 0;
            if (!LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getCanMultiMeasure$ui_release()) {
                if (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()) {
                    if (parent$ui_release.getCanMultiMeasure$ui_release()) {
                        i3 = i2;
                    } else {
                        i3 = i8;
                    }
                } else {
                }
            } else {
            }
            LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).setCanMultiMeasure$ui_release(i3);
            if (!LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getLookaheadMeasurePending$ui_release()) {
                Constraints lookaheadConstraints = this.lookaheadConstraints;
                if (lookaheadConstraints == null) {
                    lookaheadMeasurePending$ui_release = i8;
                } else {
                    lookaheadMeasurePending$ui_release = Constraints.equals-impl0(lookaheadConstraints.unbox-impl(), i3);
                }
                if (!lookaheadMeasurePending$ui_release) {
                } else {
                    androidx.compose.ui.node.Owner owner$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getOwner$ui_release();
                    if (owner$ui_release != null) {
                        owner$ui_release.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), i2);
                    }
                }
                LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).resetSubtreeIntrinsicsUsage$ui_release();
                return i8;
            }
            this.lookaheadConstraints = Constraints.box-impl(constraints);
            setMeasurementConstraints-BRTryo0(constraints);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(i8);
            forEachChildAlignmentLinesOwner((Function1)LayoutNodeLayoutDelegate.LookaheadPassDelegate.remeasure.2.INSTANCE);
            if (this.measuredOnce) {
                measuredSize-YbymL2g = getMeasuredSize-YbymL2g();
            } else {
                int i6 = Integer.MIN_VALUE;
                measuredSize-YbymL2g = IntSizeKt.IntSize(i6, i6);
            }
            this.measuredOnce = i2;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            i = lookaheadDelegate != null ? i2 : i8;
            int i9 = 0;
            if (i == 0) {
                int i10 = 0;
                InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
            }
            LayoutNodeLayoutDelegate.access$performLookaheadMeasure-BRTryo0(this.this$0, constraints);
            int height2 = lookaheadDelegate.getHeight();
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.getWidth(), height2));
            if (IntSize.getWidth-impl(measuredSize-YbymL2g) == lookaheadDelegate.getWidth()) {
                if (IntSize.getHeight-impl(measuredSize-YbymL2g) != lookaheadDelegate.getHeight()) {
                } else {
                    i2 = i8;
                }
            } else {
            }
            return i2;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void replace() {
            Object obj;
            int i;
            long onNodePlacedCalled;
            String str;
            final int i2 = 1;
            final int i3 = 0;
            this.relayoutWithoutParentInProgress = i2;
            int i4 = 0;
            if (!this.placedOnce) {
                i = 0;
                InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
            }
            this.onNodePlacedCalled = i3;
            Object obj2 = this;
            obj2.placeSelf-MLgxB_4(this.lastPosition, str, 0, this.lastLayerBlock);
            onNodePlacedCalled = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).getParent$ui_release();
            if (isPlaced() && !obj2.onNodePlacedCalled && onNodePlacedCalled != null) {
                try {
                    if (!obj2.onNodePlacedCalled) {
                    }
                    onNodePlacedCalled = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).getParent$ui_release();
                    if (onNodePlacedCalled != null) {
                    }
                    LayoutNode.requestLookaheadRelayout$ui_release$default(onNodePlacedCalled, i3, i2, 0);
                    obj2.relayoutWithoutParentInProgress = i3;
                    obj.relayoutWithoutParentInProgress = obj1;
                    throw th;
                } catch (Throwable th) {
                }
            }
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, 1, 0);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, false, false, 7, 0);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setChildDelegatesDirty$ui_release(boolean <set-?>) {
            this.childDelegatesDirty = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setDuringAlignmentLinesQuery$ui_release(boolean <set-?>) {
            this.duringAlignmentLinesQuery = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setMeasuredByParent$ui_release(androidx.compose.ui.node.LayoutNode.UsageByParent <set-?>) {
            this.measuredByParent = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setPlaceOrder$ui_release(int <set-?>) {
            this.placeOrder = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void setPlaced(boolean <set-?>) {
            this.isPlaced = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setPlacedOnce$ui_release(boolean <set-?>) {
            this.placedOnce = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void setPlacedUnderMotionFrameOfReference(boolean new) {
            int valueOf;
            boolean lookaheadDelegate;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                valueOf = Boolean.valueOf(lookaheadDelegate2.isPlacedUnderMotionFrameOfReference());
            } else {
                valueOf = 0;
            }
            if (!Intrinsics.areEqual(Boolean.valueOf(new), valueOf)) {
                lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
                if (lookaheadDelegate == null) {
                } else {
                    lookaheadDelegate.setPlacedUnderMotionFrameOfReference(new);
                }
            }
            this.isPlacedUnderMotionFrameOfReference = new;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean updateParentData() {
            Object parentData;
            final int i2 = 0;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            if (getParentData() == null && lookaheadDelegate2.getParentData() == null) {
                lookaheadDelegate2 = this.this$0.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate2);
                if (lookaheadDelegate2.getParentData() == null) {
                    return i2;
                }
            }
            if (!this.parentDataDirty) {
                return i2;
            }
            this.parentDataDirty = i2;
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            this.parentData = lookaheadDelegate.getParentData();
            return 1;
        }
    }

    @Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0002\u0008\u0013\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u00085\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0014\u0010_\u001a\u000e\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020A0`H\u0016J\u0008\u0010b\u001a\u00020/H\u0002J\u0008\u0010c\u001a\u00020/H\u0002J\u001c\u0010d\u001a\u00020/2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020/0-H\u0016J!\u0010f\u001a\u00020/2\u0016\u0010e\u001a\u0012\u0012\u0008\u0012\u00060\u0000R\u00020\u0008\u0012\u0004\u0012\u00020/0-H\u0082\u0008J\u0011\u0010g\u001a\u00020A2\u0006\u0010h\u001a\u00020aH\u0096\u0002J\u000e\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020\u0012J\u0006\u0010k\u001a\u00020/J\u0008\u0010l\u001a\u00020/H\u0016J\r\u0010m\u001a\u00020/H\u0000¢\u0006\u0002\u0008nJ\u0008\u0010o\u001a\u00020/H\u0002J\u0008\u0010p\u001a\u00020/H\u0002J\u0010\u0010q\u001a\u00020A2\u0006\u0010r\u001a\u00020AH\u0016J\u0010\u0010s\u001a\u00020A2\u0006\u0010t\u001a\u00020AH\u0016J\u001a\u0010u\u001a\u00020\u00022\u0006\u0010v\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\u0008w\u0010xJ\u0006\u0010y\u001a\u00020/J\u0010\u0010z\u001a\u00020A2\u0006\u0010r\u001a\u00020AH\u0016J\u0010\u0010{\u001a\u00020A2\u0006\u0010t\u001a\u00020AH\u0016J\u0006\u0010|\u001a\u00020/J\u0008\u0010}\u001a\u00020/H\u0002J\u0008\u0010~\u001a\u00020/H\u0002J\u0006\u0010\u007f\u001a\u00020/J\u000f\u0010\u0080\u0001\u001a\u00020/H\u0000¢\u0006\u0003\u0008\u0081\u0001JB\u0010\u0082\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u0002052\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\u00080H\u0014ø\u0001\u0000¢\u0006\u0006\u0008\u0085\u0001\u0010\u0086\u0001J/\u0010\u0082\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u0002052\u0007\u0010\u0087\u0001\u001a\u00020+H\u0014ø\u0001\u0000¢\u0006\u0006\u0008\u0085\u0001\u0010\u0088\u0001J\u0007\u0010\u0089\u0001\u001a\u00020/JM\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u0002052\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\u000802\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010+H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u008b\u0001\u0010\u008c\u0001JM\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u0002052\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\u000802\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010+H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u008e\u0001\u0010\u008c\u0001J\u001b\u0010\u008f\u0001\u001a\u00020\u00122\u0006\u0010v\u001a\u00020'ø\u0001\u0000¢\u0006\u0006\u0008\u0090\u0001\u0010\u0091\u0001J\u0007\u0010\u0092\u0001\u001a\u00020/J\t\u0010\u0093\u0001\u001a\u00020/H\u0016J\t\u0010\u0094\u0001\u001a\u00020/H\u0016J\u0013\u0010\u0095\u0001\u001a\u00020/2\u0008\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\u0007\u0010\u0098\u0001\u001a\u00020\u0012R\u0018\u0010\u0006\u001a\u000c\u0012\u0008\u0012\u00060\u0000R\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\r\u001a\u000c\u0012\u0008\u0012\u00060\u0000R\u00020\u00080\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0014\"\u0004\u0008\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u0014\"\u0004\u0008 \u0010\u0016R$\u0010!\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u0014\"\u0004\u0008\"\u0010\u0016R$\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010\u0014\"\u0004\u0008%\u0010\u0016R\u0019\u0010&\u001a\u0004\u0018\u00010'8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010,\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\u00080X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\u000202X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\u0014R\u0014\u00108\u001a\u0008\u0012\u0004\u0012\u00020/09X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010=\"\u0004\u0008>\u0010?R\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008B\u0010CR\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008F\u0010CR\u000e\u0010G\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010KR\"\u0010M\u001a\u0004\u0018\u00010L2\u0008\u0010\u001e\u001a\u0004\u0018\u00010L@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010OR\u000e\u0010P\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u00020A2\u0006\u0010\u001e\u001a\u00020A@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010CR\u0014\u0010S\u001a\u0008\u0012\u0004\u0012\u00020/09X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010U\u001a\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-¢\u0006\u0002\u00080X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010V\u001a\u000202X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00103R\u000e\u0010W\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Y\u001a\u00020A2\u0006\u0010\u001e\u001a\u00020A@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008Z\u0010CR\u000e\u0010[\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\\\u001a\u0002052\u0006\u0010\u001e\u001a\u000205@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008]\u0010^\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0099\u0001", d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "<set-?>", "isPlaced", "setPlaced$ui_release", "isPlacedByParent", "setPlacedByParent$ui_release", "new", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "layingOutChildren", "getLayingOutChildren", "layoutChildrenBlock", "Lkotlin/Function0;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "needsCoordinatesUpdate", "onNodePlacedCalled", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "placeOuterCoordinatorBlock", "placeOuterCoordinatorLayer", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placedOnce", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "zIndex", "getZIndex$ui_release", "()F", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markDetachedFromParentLookaheadPass", "markDetachedFromParentLookaheadPass$ui_release", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measureBasedOnLookahead", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "placeAt", "position", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeBasedOnLookahead", "placeOuterCoordinator", "placeOuterCoordinator-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeSelf-MLgxB_4", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackMeasurementByParent", "node", "Landroidx/compose/ui/node/LayoutNode;", "updateParentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MeasurePassDelegate extends Placeable implements Measurable, androidx.compose.ui.node.AlignmentLinesOwner, androidx.compose.ui.node.MotionReferencePlacementDelegate {

        private final MutableVector<androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate> _childDelegates;
        private final androidx.compose.ui.node.AlignmentLines alignmentLines;
        private boolean childDelegatesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPlacedByParent;
        private boolean isPlacedUnderMotionFrameOfReference;
        private GraphicsLayer lastExplicitLayer;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition;
        private float lastZIndex;
        private boolean layingOutChildren;
        private final Function0<Unit> layoutChildrenBlock;
        private androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParent = Integer.MAX_VALUE;
        private boolean measuredOnce;
        private boolean needsCoordinatesUpdate;
        private boolean onNodePlacedCalled;
        private Object parentData;
        private boolean parentDataDirty = true;
        private int placeOrder = Integer.MAX_VALUE;
        private final Function0<Unit> placeOuterCoordinatorBlock;
        private GraphicsLayer placeOuterCoordinatorLayer;
        private Function1<? super GraphicsLayerScope, Unit> placeOuterCoordinatorLayerBlock;
        private long placeOuterCoordinatorPosition;
        private float placeOuterCoordinatorZIndex;
        private boolean placedOnce;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private boolean relayoutWithoutParentInProgress;
        final androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0;
        private float zIndex;
        public MeasurePassDelegate(androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0) {
            this.this$0 = this$0;
            super();
            int i = Integer.MAX_VALUE;
            androidx.compose.ui.node.LayoutNode.UsageByParent notUsed = LayoutNode.UsageByParent.NotUsed;
            this.lastPosition = IntOffset.Companion.getZero-nOcc-ac();
            int i2 = 1;
            LayoutNodeAlignmentLines layoutNodeAlignmentLines = new LayoutNodeAlignmentLines((AlignmentLinesOwner)this);
            this.alignmentLines = (AlignmentLines)layoutNodeAlignmentLines;
            int i4 = 0;
            MutableVector mutableVector = new MutableVector(new LayoutNodeLayoutDelegate.MeasurePassDelegate[16], 0);
            this._childDelegates = mutableVector;
            LayoutNodeLayoutDelegate.MeasurePassDelegate.layoutChildrenBlock.1 anon = new LayoutNodeLayoutDelegate.MeasurePassDelegate.layoutChildrenBlock.1(this);
            this.layoutChildrenBlock = (Function0)anon;
            this.placeOuterCoordinatorPosition = IntOffset.Companion.getZero-nOcc-ac();
            LayoutNodeLayoutDelegate.MeasurePassDelegate.placeOuterCoordinatorBlock.1 anon2 = new LayoutNodeLayoutDelegate.MeasurePassDelegate.placeOuterCoordinatorBlock.1(this.this$0, this);
            this.placeOuterCoordinatorBlock = (Function0)anon2;
        }

        public static final void access$checkChildrenPlaceOrderForUpdates(androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate $this) {
            $this.checkChildrenPlaceOrderForUpdates();
        }

        public static final void access$clearPlaceOrder(androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate $this) {
            $this.clearPlaceOrder();
        }

        public static final GraphicsLayer access$getPlaceOuterCoordinatorLayer$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate $this) {
            return $this.placeOuterCoordinatorLayer;
        }

        public static final Function1 access$getPlaceOuterCoordinatorLayerBlock$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate $this) {
            return $this.placeOuterCoordinatorLayerBlock;
        }

        public static final long access$getPlaceOuterCoordinatorPosition$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate $this) {
            return $this.placeOuterCoordinatorPosition;
        }

        public static final float access$getPlaceOuterCoordinatorZIndex$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate $this) {
            return $this.placeOuterCoordinatorZIndex;
        }

        private final void checkChildrenPlaceOrderForUpdates() {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i;
            int placeOrder$ui_release;
            int placeOrder$ui_release2;
            androidx.compose.ui.node.LayoutNode layoutNode = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0);
            final int i2 = 0;
            final int i3 = 0;
            final MutableVector mutableVector = layoutNode.get_children$ui_release();
            final int i4 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv];
                i = 0;
                do {
                    obj = content[i$iv$iv];
                    i = 0;
                    if (i$iv$iv++ < size) {
                    }
                    layoutNode.onZSortedChildrenInvalidated$ui_release();
                    layoutNode.invalidateLayer$ui_release();
                    if (obj.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                    }
                    obj.getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                } while (measurePassDelegate$ui_release.previousPlaceOrder != obj.getPlaceOrder$ui_release());
            }
        }

        private final void clearPlaceOrder() {
            int inLayoutBlock;
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i2;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release;
            int i;
            androidx.compose.ui.node.LayoutNode.UsageByParent measuredByParent;
            LayoutNodeLayoutDelegate.access$setNextChildPlaceOrder$p(obj2.this$0, 0);
            final int i3 = 0;
            final int i4 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj3.this$0).get_children$ui_release();
            final int i5 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv$iv = 0;
                i2 = 0;
                measurePassDelegate$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv$iv].getMeasurePassDelegate$ui_release();
                i = 0;
                measurePassDelegate$ui_release.previousPlaceOrder = measurePassDelegate$ui_release.placeOrder;
                measurePassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                measurePassDelegate$ui_release.isPlacedByParent = inLayoutBlock;
                while (measurePassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                    measurePassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    if (i$iv$iv$iv++ < size) {
                    }
                    inLayoutBlock = 0;
                    i2 = 0;
                    measurePassDelegate$ui_release = (LayoutNode)content[i$iv$iv$iv].getMeasurePassDelegate$ui_release();
                    i = 0;
                    measurePassDelegate$ui_release.previousPlaceOrder = measurePassDelegate$ui_release.placeOrder;
                    measurePassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                    measurePassDelegate$ui_release.isPlacedByParent = inLayoutBlock;
                }
            }
        }

        private final void forEachChildDelegate(Function1<? super androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate, Unit> block) {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release;
            final int i2 = 0;
            final int i3 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            final int i4 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                i = 0;
                block.invoke((LayoutNode)mutableVector.getContent()[i$iv$iv].getMeasurePassDelegate$ui_release());
                while (i$iv$iv++ >= size) {
                    i = 0;
                    block.invoke((LayoutNode)content[i$iv$iv].getMeasurePassDelegate$ui_release());
                }
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean lookaheadMeasurePending$ui_release;
            int i4;
            int i6;
            androidx.compose.ui.node.NodeCoordinator delegate$iv;
            int i2;
            int i3;
            int i$iv$iv;
            boolean lastLayerDrawingWasSkipped$ui_release;
            Object obj;
            int i5;
            int placeOrder$ui_release;
            int i;
            setPlaced$ui_release(true);
            final androidx.compose.ui.node.LayoutNode layoutNode = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0);
            int i8 = 0;
            if (!isPlaced()) {
                if (layoutNode.getMeasurePending$ui_release()) {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNode, true, false, false, 6, 0);
                } else {
                    if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                        LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, true, false, false, 6, 0);
                    }
                }
            }
            androidx.compose.ui.node.LayoutNode layoutNode2 = layoutNode;
            int i9 = 0;
            delegate$iv = layoutNode2.getOuterCoordinator$ui_release();
            while (!Intrinsics.areEqual(delegate$iv, layoutNode2.getInnerCoordinator$ui_release().getWrapped$ui_release())) {
                if (delegate$iv != null) {
                }
                i3 = delegate$iv;
                i$iv$iv = 0;
                if (i3.getLastLayerDrawingWasSkipped$ui_release()) {
                }
                delegate$iv = delegate$iv.getWrapped$ui_release();
                i3.invalidateLayer();
            }
            int i10 = 0;
            MutableVector mutableVector = layoutNode.get_children$ui_release();
            int i11 = 0;
            int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv];
                i5 = 0;
                do {
                    obj = lastLayerDrawingWasSkipped$ui_release[i$iv$iv];
                    i5 = 0;
                    if (i$iv$iv++ < size) {
                    }
                    obj.getMeasurePassDelegate$ui_release().markNodeAndSubtreeAsPlaced();
                    layoutNode.rescheduleRemeasureOrRelayout$ui_release(obj);
                } while ((LayoutNode)obj.getPlaceOrder$ui_release() != Integer.MAX_VALUE);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            boolean this_$iv;
            int i5;
            androidx.compose.ui.node.LayoutNode layoutNode;
            androidx.compose.ui.node.NodeCoordinator delegate$iv;
            int i4;
            MutableVector mutableVector;
            int i;
            int size;
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i2;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release;
            int i3;
            if (isPlaced()) {
                setPlaced$ui_release(false);
                androidx.compose.ui.node.LayoutNode layoutNode2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0);
                int i7 = 0;
                delegate$iv = layoutNode2.getOuterCoordinator$ui_release();
                while (!Intrinsics.areEqual(delegate$iv, layoutNode2.getInnerCoordinator$ui_release().getWrapped$ui_release())) {
                    if (delegate$iv != null) {
                    }
                    i = 0;
                    delegate$iv.releaseLayer();
                    delegate$iv = delegate$iv.getWrapped$ui_release();
                }
                i5 = 0;
                i4 = 0;
                mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this_$iv.this$0).get_children$ui_release();
                i = 0;
                size = mutableVector.getSize();
                if (size > 0) {
                    i$iv$iv$iv = 0;
                    i2 = 0;
                    i3 = 0;
                    (LayoutNode)mutableVector.getContent()[i$iv$iv$iv].getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                    while (i$iv$iv$iv++ >= size) {
                        i2 = 0;
                        i3 = 0;
                        (LayoutNode)content[i$iv$iv$iv].getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                    }
                }
            }
        }

        private final void onBeforeLayoutChildren() {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i4;
            boolean measurePending$ui_release;
            androidx.compose.ui.node.LayoutNode.UsageByParent inMeasureBlock;
            int i6;
            int i5;
            int i;
            int i2;
            int i3;
            final Object obj2 = this;
            final int i7 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).get_children$ui_release();
            final int i8 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv];
                i4 = 0;
                do {
                    obj = content[i$iv$iv];
                    i4 = 0;
                    if (i$iv$iv++ < size) {
                    }
                    int i9 = 0;
                    if (obj.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.remeasure-_Sx5XlM$ui_release$default(obj, i9, 1, i9)) {
                    }
                    i9 = 0;
                    if (LayoutNode.remeasure-_Sx5XlM$ui_release$default(obj, i9, 1, i9)) {
                    }
                    LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0), false, false, false, 7, 0);
                } while ((LayoutNode)obj.getMeasurePending$ui_release());
            }
        }

        private final void onIntrinsicsQueried() {
            Object intrinsicsUsageByParent$ui_release;
            int intrinsicsUsageByParent$ui_release2;
            int $EnumSwitchMapping$0;
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, false, false, 7, 0);
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            if (parent$ui_release != null && LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                if (LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                    switch (i) {
                        case 1:
                            intrinsicsUsageByParent$ui_release2 = LayoutNode.UsageByParent.InMeasureBlock;
                            break;
                        case 2:
                            intrinsicsUsageByParent$ui_release2 = LayoutNode.UsageByParent.InLayoutBlock;
                            break;
                        default:
                            intrinsicsUsageByParent$ui_release2 = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
                    }
                    LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).setIntrinsicsUsageByParent$ui_release(intrinsicsUsageByParent$ui_release2);
                }
            }
        }

        private final void placeOuterCoordinator-MLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
            androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0;
            boolean layoutPending$ui_release;
            String $i$a$RequirePreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1;
            long position2;
            float f;
            Function1 function1;
            GraphicsLayer graphicsLayer;
            long obj9;
            androidx.compose.ui.node.LayoutNode obj10;
            float obj11;
            int i2 = 1;
            int i3 = 0;
            if (deactivated ^= i2 == 0) {
                int i4 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.LayingOut);
            this.lastPosition = position;
            this.lastZIndex = layerBlock;
            this.lastLayerBlock = layer;
            this.lastExplicitLayer = obj13;
            this.placedOnce = i2;
            this$0 = 0;
            this.onNodePlacedCalled = this$0;
            if (!this.this$0.getLayoutPending$ui_release() && isPlaced()) {
                if (isPlaced()) {
                    this.this$0.getOuterCoordinator().placeSelfApparentToRealOffset-MLgxB_4(position, obj4, layerBlock, layer);
                    onNodePlaced$ui_release();
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(this$0);
                    this.this$0.setCoordinatesAccessedDuringModifierPlacement(this$0);
                    this.placeOuterCoordinatorLayerBlock = layer;
                    this.placeOuterCoordinatorPosition = position;
                    this.placeOuterCoordinatorZIndex = layerBlock;
                    this.placeOuterCoordinatorLayer = obj13;
                    LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0)).getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), this$0, this.placeOuterCoordinatorBlock);
                }
            } else {
            }
            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.Idle);
        }

        private final void placeSelf-MLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
            boolean needsCoordinatesUpdate;
            boolean outMostLookaheadRoot;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2;
            int $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeSelf$2;
            int i4;
            Placeable.PlacementScope placementScope;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            int layoutDelegate$ui_release;
            int y-impl;
            int i6;
            int i2;
            int i3;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate2;
            int i5;
            final Object obj = this;
            int i7 = 1;
            obj.isPlacedByParent = i7;
            final long l = position;
            $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeSelf$2 = 0;
            if (IntOffset.equals-impl0(l, obj5)) {
                if (obj.needsCoordinatesUpdate) {
                    if (!obj.this$0.getCoordinatesAccessedDuringModifierPlacement() && !obj.this$0.getCoordinatesAccessedDuringPlacement()) {
                        if (!obj.this$0.getCoordinatesAccessedDuringPlacement()) {
                            if (obj.needsCoordinatesUpdate) {
                                LayoutNodeLayoutDelegate.access$setLayoutPending$p(obj.this$0, i7);
                                obj.needsCoordinatesUpdate = $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeSelf$2;
                            }
                        } else {
                        }
                    } else {
                    }
                    obj.notifyChildrenUsingCoordinatesWhilePlacing();
                }
            } else {
            }
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj.this$0))) {
                outMostLookaheadRoot = obj.this$0.getOuterCoordinator().getWrappedBy$ui_release();
                if (outMostLookaheadRoot != null) {
                    if (outMostLookaheadRoot.getPlacementScope() == null) {
                        outMostLookaheadRoot = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj.this$0)).getPlacementScope();
                    }
                } else {
                }
                androidx.compose.ui.node.LayoutNodeLayoutDelegate this$06 = obj.this$0;
                i = 0;
                lookaheadPassDelegate$ui_release = this$06.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate2 = lookaheadPassDelegate$ui_release;
                i5 = 0;
                androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this$06).getParent$ui_release();
                if (parent$ui_release != null) {
                    lookaheadPassDelegate$ui_release = 0;
                    LayoutNodeLayoutDelegate.access$setNextChildLookaheadPlaceOrder$p(parent$ui_release.getLayoutDelegate$ui_release(), $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeSelf$2);
                }
                lookaheadPassDelegate2.setPlaceOrder$ui_release(Integer.MAX_VALUE);
                Placeable.PlacementScope.place$default(outMostLookaheadRoot, (Placeable)lookaheadPassDelegate2, IntOffset.getX-impl(l), IntOffset.getY-impl(l), 0, 4, 0);
            }
            lookaheadPassDelegate$ui_release2 = obj.this$0.getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release2 != null && !lookaheadPassDelegate$ui_release2.getPlacedOnce$ui_release()) {
                if (!lookaheadPassDelegate$ui_release2.getPlacedOnce$ui_release()) {
                    $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeSelf$2 = i7;
                }
            }
            int i9 = 0;
            if (i7 ^= $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$placeSelf$2 == 0) {
                int i10 = 0;
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }
            placeOuterCoordinator-MLgxB_4(position, zIndex, layerBlock, layer);
        }

        private final void trackMeasurementByParent(androidx.compose.ui.node.LayoutNode node) {
            androidx.compose.ui.node.LayoutNode.UsageByParent inMeasureBlock;
            int i;
            androidx.compose.ui.node.LayoutNode.UsageByParent canMultiMeasure$ui_release;
            int[] $EnumSwitchMapping$0;
            String $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$trackMeasurementByParent$1;
            final androidx.compose.ui.node.LayoutNode parent$ui_release = node.getParent$ui_release();
            if (parent$ui_release != null) {
                if (this.measuredByParent != LayoutNode.UsageByParent.NotUsed) {
                    if (node.getCanMultiMeasure$ui_release()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
                int i3 = 0;
                if (i == 0) {
                    int i4 = 0;
                    InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
                }
                switch (i2) {
                    case 1:
                        inMeasureBlock = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 2:
                        inMeasureBlock = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Measurable could be only measured from the parent's measure or layout block. Parents state is ").append(parent$ui_release.getLayoutState$ui_release()).toString());
                        throw illegalStateException;
                }
                this.measuredByParent = inMeasureBlock;
            }
            this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            boolean duringAlignmentLinesQuery;
            androidx.compose.ui.node.LayoutNode.LayoutState measuring;
            int i = 1;
            if (!this.duringAlignmentLinesQuery) {
                if (this.this$0.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(i);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        this.this$0.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(i);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(i);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super androidx.compose.ui.node.AlignmentLinesOwner, Unit> block) {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i;
            androidx.compose.ui.node.AlignmentLinesOwner alignmentLinesOwner$ui_release;
            final int i2 = 0;
            final MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            final int i3 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                i = 0;
                block.invoke((LayoutNode)mutableVector.getContent()[i$iv$iv].getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
                while (i$iv$iv++ >= size) {
                    i = 0;
                    block.invoke((LayoutNode)content[i$iv$iv].getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
                }
            }
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int get(AlignmentLine alignmentLine) {
            int layoutState$ui_release2;
            Object alignmentLines;
            int layoutState$ui_release;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            if (parent$ui_release != null) {
                layoutState$ui_release2 = parent$ui_release.getLayoutState$ui_release();
            } else {
                layoutState$ui_release2 = layoutState$ui_release;
            }
            final int i3 = 1;
            if (layoutState$ui_release2 == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(i3);
            } else {
                androidx.compose.ui.node.LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState$ui_release = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(i3);
                }
            }
            this.duringAlignmentLinesQuery = i3;
            this.duringAlignmentLinesQuery = false;
            return this.this$0.getOuterCoordinator().get(alignmentLine);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public androidx.compose.ui.node.AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final List<androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate> getChildDelegates$ui_release() {
            int i$iv$iv$iv;
            Object[] content;
            Object obj;
            int i2;
            int i3;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate it;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            final Object obj2 = this;
            LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).updateChildrenIfDirty$ui_release();
            if (!obj2.childDelegatesDirty) {
                return obj2._childDelegates.asMutableList();
            }
            androidx.compose.ui.node.LayoutNode layoutNode2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0);
            final MutableVector _childDelegates3 = obj2._childDelegates;
            final int i4 = 0;
            int i5 = 0;
            final MutableVector mutableVector = layoutNode2.get_children$ui_release();
            final int i6 = 0;
            final int size3 = mutableVector.getSize();
            if (size3 > 0) {
                i$iv$iv$iv = 0;
                obj = mutableVector.getContent()[i$iv$iv$iv];
                i2 = i$iv$iv$iv;
                i3 = 0;
                do {
                    obj = content[i$iv$iv$iv];
                    i2 = i$iv$iv$iv;
                    i3 = 0;
                    i = 0;
                    _childDelegates3.set(i2, (LayoutNode)(LayoutNode)obj.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                    if (i$iv$iv$iv++ < size3) {
                    }
                    i = 0;
                    _childDelegates3.add(obj.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                } while (_childDelegates3.getSize() <= i2);
            }
            _childDelegates3.removeRange(layoutNode2.getChildren$ui_release().size(), _childDelegates3.getSize());
            obj2.childDelegatesDirty = false;
            return obj2._childDelegates.asMutableList();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getChildDelegatesDirty$ui_release() {
            return this.childDelegatesDirty;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public androidx.compose.ui.node.NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getInnerCoordinator$ui_release();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final Constraints getLastConstraints-DWUhwKw() {
            Constraints box-impl;
            if (this.measuredOnce) {
                box-impl = Constraints.box-impl(getMeasurementConstraints-msEJaDk());
            } else {
                box-impl = 0;
            }
            return box-impl;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final androidx.compose.ui.node.LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
            return this.measuredByParent;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredHeight() {
            return this.this$0.getOuterCoordinator().getMeasuredHeight();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredWidth() {
            return this.this$0.getOuterCoordinator().getMeasuredWidth();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public androidx.compose.ui.node.AlignmentLinesOwner getParentAlignmentLinesOwner() {
            Object layoutDelegate$ui_release;
            int alignmentLinesOwner$ui_release;
            layoutDelegate$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            layoutDelegate$ui_release = layoutDelegate$ui_release.getLayoutDelegate$ui_release();
            if (layoutDelegate$ui_release != null && layoutDelegate$ui_release != null) {
                layoutDelegate$ui_release = layoutDelegate$ui_release.getLayoutDelegate$ui_release();
                if (layoutDelegate$ui_release != null) {
                    alignmentLinesOwner$ui_release = layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
                } else {
                    alignmentLinesOwner$ui_release = 0;
                }
            } else {
            }
            return alignmentLinesOwner$ui_release;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public Object getParentData() {
            return this.parentData;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getPlaceOrder$ui_release() {
            return this.placeOrder;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getPreviousPlaceOrder$ui_release() {
            return this.previousPlaceOrder;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final float getZIndex$ui_release() {
            return this.zIndex;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            androidx.compose.ui.node.LayoutNode.UsageByParent notUsed;
            androidx.compose.ui.node.LayoutNode intrinsicsUsageByParent$ui_release;
            androidx.compose.ui.node.LayoutNode intrinsicsUsingParent;
            boolean forceRequest2;
            int i3;
            int i2;
            int i4;
            int i;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            androidx.compose.ui.node.LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release != null && intrinsicsUsageByParent$ui_release2 != LayoutNode.UsageByParent.NotUsed) {
                if (intrinsicsUsageByParent$ui_release2 != LayoutNode.UsageByParent.NotUsed) {
                    intrinsicsUsingParent = intrinsicsUsageByParent$ui_release;
                    while (intrinsicsUsingParent.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release2) {
                        intrinsicsUsageByParent$ui_release = intrinsicsUsingParent.getParent$ui_release();
                        if (intrinsicsUsageByParent$ui_release == null) {
                            break;
                        } else {
                        }
                        intrinsicsUsingParent = intrinsicsUsageByParent$ui_release;
                    }
                    switch (notUsed) {
                        case 1:
                            LayoutNode.requestRemeasure$ui_release$default(intrinsicsUsingParent, forceRequest, false, false, 6, 0);
                            break;
                        case 2:
                            intrinsicsUsingParent.requestRelayout$ui_release(forceRequest);
                            forceRequest2 = forceRequest;
                            break;
                        default:
                            boolean z = forceRequest;
                            IllegalStateException obj10 = new IllegalStateException("Intrinsics isn't used by the parent".toString());
                            throw obj10;
                    }
                }
            }
            forceRequest2 = forceRequest;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public boolean isPlaced() {
            return this.isPlaced;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean isPlacedByParent() {
            return this.isPlacedByParent;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public boolean isPlacedUnderMotionFrameOfReference() {
            return this.isPlacedUnderMotionFrameOfReference;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void layoutChildren() {
            boolean required$ui_release;
            boolean duringAlignmentLinesQuery;
            boolean usedDuringParentLayout$ui_release;
            boolean placingForAlignment$ui_release;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate this$0;
            int i;
            androidx.compose.ui.node.Owner requireOwner;
            androidx.compose.ui.node.OwnerSnapshotObserver snapshotObserver;
            Function0 layoutChildrenBlock;
            int i2 = 1;
            this.layingOutChildren = i2;
            getAlignmentLines().recalculateQueryOwner();
            if (this.this$0.getLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            final int i3 = 0;
            if (!LayoutNodeLayoutDelegate.access$getLayoutPendingForAlignment$p(this.this$0)) {
                LayoutNodeLayoutDelegate.access$setLayoutPending$p(this.this$0, i3);
                LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.LayingOut);
                this.this$0.setCoordinatesAccessedDuringPlacement(i3);
                androidx.compose.ui.node.LayoutNode layoutNode = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0);
                i = 0;
                LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(layoutNode, i3, this.layoutChildrenBlock);
                LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, this.this$0.getLayoutState$ui_release());
                if (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && this.this$0.getLayoutPending$ui_release() && getInnerCoordinator().isPlacingForAlignment$ui_release() && this.this$0.getCoordinatesAccessedDuringPlacement()) {
                    if (!getInnerCoordinator().isPlacingForAlignment$ui_release()) {
                        if (this.this$0.getLayoutPending$ui_release()) {
                            LayoutNodeLayoutDelegate.access$setLayoutPending$p(this.this$0, i3);
                            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, LayoutNode.LayoutState.LayingOut);
                            this.this$0.setCoordinatesAccessedDuringPlacement(i3);
                            layoutNode = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0);
                            i = 0;
                            LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(layoutNode, i3, this.layoutChildrenBlock);
                            LayoutNodeLayoutDelegate.access$setLayoutState$p(this.this$0, this.this$0.getLayoutState$ui_release());
                            if (getInnerCoordinator().isPlacingForAlignment$ui_release()) {
                                if (this.this$0.getCoordinatesAccessedDuringPlacement()) {
                                    requestLayout();
                                }
                            }
                            LayoutNodeLayoutDelegate.access$setLayoutPendingForAlignment$p(this.this$0, i3);
                        }
                    }
                }
            } else {
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(i2);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                if (getAlignmentLines().getRequired$ui_release()) {
                    getAlignmentLines().recalculate();
                }
            }
            this.layingOutChildren = i3;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void markDetachedFromParentLookaheadPass$ui_release() {
            LayoutNodeLayoutDelegate.access$setDetachedFromParentLookaheadPass$p(this.this$0, true);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return this.this$0.getOuterCoordinator().maxIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return this.this$0.getOuterCoordinator().maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public Placeable measure-BRTryo0(long constraints) {
            Object intrinsicsUsageByParent$ui_release;
            boolean outMostLookaheadRoot;
            androidx.compose.ui.node.LayoutNode.UsageByParent notUsed2;
            androidx.compose.ui.node.LayoutNode.UsageByParent notUsed;
            if (LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).clearSubtreeIntrinsicsUsage$ui_release();
            }
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0))) {
                outMostLookaheadRoot = this.this$0.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(outMostLookaheadRoot);
                notUsed2 = 0;
                outMostLookaheadRoot.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                outMostLookaheadRoot.measure-BRTryo0(constraints);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0));
            remeasure-BRTryo0(constraints);
            return (Placeable)this;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void measureBasedOnLookahead() {
            Enum measuredByParent$ui_release2;
            long measuredByParent$ui_release;
            Enum inMeasureBlock;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = this.this$0.getLookaheadPassDelegate$ui_release();
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            int i = 0;
            if (parent$ui_release == null) {
            } else {
                int i2 = 0;
                if (lookaheadPassDelegate$ui_release == null) {
                } else {
                    inMeasureBlock = LayoutNode.LayoutState.Measuring;
                    if (lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && parent$ui_release.getLayoutState$ui_release() == inMeasureBlock) {
                        inMeasureBlock = LayoutNode.LayoutState.Measuring;
                        if (parent$ui_release.getLayoutState$ui_release() == inMeasureBlock) {
                            Constraints lastConstraints-DWUhwKw = lookaheadPassDelegate$ui_release.getLastConstraints-DWUhwKw();
                            Intrinsics.checkNotNull(lastConstraints-DWUhwKw);
                            measure-BRTryo0(lastConstraints-DWUhwKw.unbox-impl());
                        } else {
                            inMeasureBlock = LayoutNode.LayoutState.LayingOut;
                            if (lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock && parent$ui_release.getLayoutState$ui_release() == inMeasureBlock) {
                                inMeasureBlock = LayoutNode.LayoutState.LayingOut;
                                if (parent$ui_release.getLayoutState$ui_release() == inMeasureBlock) {
                                    Constraints lastConstraints-DWUhwKw2 = lookaheadPassDelegate$ui_release.getLastConstraints-DWUhwKw();
                                    Intrinsics.checkNotNull(lastConstraints-DWUhwKw2);
                                    measure-BRTryo0(lastConstraints-DWUhwKw2.unbox-impl());
                                }
                            }
                        }
                    } else {
                    }
                }
                int i4 = 0;
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("invalid lookaheadDelegate");
                KotlinNothingValueException kotlinNothingValueException2 = new KotlinNothingValueException();
                throw kotlinNothingValueException2;
            }
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("layoutNode parent is not set");
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return this.this$0.getOuterCoordinator().minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return this.this$0.getOuterCoordinator().minIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            int childrenAccessingCoordinatesDuringPlacement;
            int i5;
            MutableVector mutableVector;
            int i;
            int size;
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i2;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            int i4;
            boolean coordinatesAccessedDuringPlacement;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release;
            int i3;
            boolean layoutPending$ui_release;
            i5 = 0;
            mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
            i = 0;
            size = mutableVector.getSize();
            if (this.this$0.getChildrenAccessingCoordinatesDuringPlacement() > 0 && size > 0) {
                i5 = 0;
                mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).get_children$ui_release();
                i = 0;
                size = mutableVector.getSize();
                if (size > 0) {
                    i$iv$iv = 0;
                    obj = mutableVector.getContent()[i$iv$iv];
                    i2 = 0;
                    layoutDelegate$ui_release = (LayoutNode)obj.getLayoutDelegate$ui_release();
                    int i6 = 0;
                    i3 = 1;
                    do {
                        obj = content[i$iv$iv];
                        i2 = 0;
                        layoutDelegate$ui_release = (LayoutNode)obj.getLayoutDelegate$ui_release();
                        i6 = 0;
                        i3 = 1;
                        i4 = i3;
                        if (i4 != 0 && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        }
                        layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                        if (i$iv$iv++ < size) {
                        }
                        if (!layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        }
                        LayoutNode.requestRelayout$ui_release$default(obj, i6, i3, 0);
                        if (layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement()) {
                        } else {
                        }
                        i4 = i6;
                    } while (!layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement());
                }
            }
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void onNodeDetached() {
            int i = Integer.MAX_VALUE;
            this.placeOrder = i;
            this.previousPlaceOrder = i;
            setPlaced$ui_release(false);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void onNodePlaced$ui_release() {
            float newZIndex;
            int i;
            boolean relayoutWithoutParentInProgress;
            int i2;
            androidx.compose.ui.node.NodeCoordinator $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$onNodePlaced$2;
            androidx.compose.ui.node.NodeCoordinator nodeCoordinator;
            int i3;
            float zIndex;
            final int i4 = 1;
            this.onNodePlacedCalled = i4;
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            int i5 = 0;
            newZIndex = getInnerCoordinator().getZIndex();
            androidx.compose.ui.node.LayoutNode layoutNode2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0);
            int i8 = 0;
            $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$onNodePlaced$2 = layoutNode2.getOuterCoordinator$ui_release();
            while ($i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$onNodePlaced$2 != layoutNode2.getInnerCoordinator$ui_release()) {
                Intrinsics.checkNotNull($i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$onNodePlaced$2, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                i3 = 0;
                newZIndex += zIndex;
                $i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$onNodePlaced$2 = (LayoutModifierNodeCoordinator)$i$a$CheckPreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$onNodePlaced$2.getWrapped$ui_release();
            }
            i2 = 0;
            i = Float.compare(newZIndex, this_$iv) == 0 ? i4 : i2;
            this.zIndex = newZIndex;
            if (i == 0 && parent$ui_release != null) {
                this.zIndex = newZIndex;
                if (parent$ui_release != null) {
                    parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                }
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
            }
            if (!isPlaced() && parent$ui_release != null) {
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
                markNodeAndSubtreeAsPlaced();
                if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                    if (parent$ui_release != null) {
                        LayoutNode.requestRelayout$ui_release$default(parent$ui_release, i2, i4, 0);
                    }
                }
            }
            if (parent$ui_release != null) {
                if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut && this.placeOrder == Integer.MAX_VALUE) {
                    if (parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                        if (this.placeOrder == Integer.MAX_VALUE) {
                            i2 = i4;
                        }
                        int i6 = 0;
                        if (i2 == 0) {
                            int i10 = 0;
                            InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                        }
                        this.placeOrder = LayoutNodeLayoutDelegate.access$getNextChildPlaceOrder$p(parent$ui_release.getLayoutDelegate$ui_release());
                        relayoutWithoutParentInProgress = parent$ui_release.getLayoutDelegate$ui_release();
                        LayoutNodeLayoutDelegate.access$setNextChildPlaceOrder$p(relayoutWithoutParentInProgress, i9 += i4);
                    }
                }
            } else {
                this.placeOrder = i2;
            }
            layoutChildren();
        }

        @Override // androidx.compose.ui.layout.Placeable
        protected void placeAt-f8xVGno(long position, float zIndex, GraphicsLayer layer) {
            this.placeSelf-MLgxB_4(position, obj2, layer, 0);
        }

        protected void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            this.placeSelf-MLgxB_4(position, obj2, layerBlock, obj10);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void placeBasedOnLookahead() {
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = this.this$0.getLookaheadPassDelegate$ui_release();
            int i = 0;
            if (lookaheadPassDelegate$ui_release == null) {
            } else {
                this.placeSelf-MLgxB_4(lookaheadPassDelegate$ui_release.getLastPosition-nOcc-ac$ui_release(), obj3, lookaheadPassDelegate$ui_release.getLastZIndex$ui_release(), lookaheadPassDelegate$ui_release.getLastLayerBlock$ui_release());
            }
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("invalid lookaheadDelegate");
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean remeasure-BRTryo0(long constraints) {
            int i;
            String $i$a$RequirePreconditionLayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1;
            boolean measurePending$ui_release;
            boolean canMultiMeasure$ui_release;
            int i2;
            boolean height;
            long height2;
            i = 1;
            int i4 = 0;
            if (deactivated ^= i == 0) {
                int i5 = 0;
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            androidx.compose.ui.node.LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getParent$ui_release();
            int i8 = 0;
            if (!LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getCanMultiMeasure$ui_release()) {
                if (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()) {
                    if (parent$ui_release.getCanMultiMeasure$ui_release()) {
                        i2 = i;
                    } else {
                        i2 = i8;
                    }
                } else {
                }
            } else {
            }
            LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).setCanMultiMeasure$ui_release(i2);
            if (!LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).getMeasurePending$ui_release() && !Constraints.equals-impl0(getMeasurementConstraints-msEJaDk(), i2)) {
                if (!Constraints.equals-impl0(getMeasurementConstraints-msEJaDk(), i2)) {
                }
                Owner.forceMeasureTheSubtree$default(LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0)), LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), i8, 2, 0);
                LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0).resetSubtreeIntrinsicsUsage$ui_release();
                return i8;
            }
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(i8);
            forEachChildAlignmentLinesOwner((Function1)LayoutNodeLayoutDelegate.MeasurePassDelegate.remeasure.2.INSTANCE);
            this.measuredOnce = i;
            setMeasurementConstraints-BRTryo0(constraints);
            LayoutNodeLayoutDelegate.access$performMeasure-BRTryo0(this.this$0, constraints);
            if (IntSize.equals-impl0(this.this$0.getOuterCoordinator().getSize-YbymL2g(), obj7) && this.this$0.getOuterCoordinator().getWidth() == getWidth()) {
                if (this.this$0.getOuterCoordinator().getWidth() == getWidth()) {
                    if (this.this$0.getOuterCoordinator().getHeight() != getHeight()) {
                    } else {
                        i = i8;
                    }
                } else {
                }
            } else {
            }
            int height3 = this.this$0.getOuterCoordinator().getHeight();
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(this.this$0.getOuterCoordinator().getWidth(), height3));
            return i;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void replace() {
            Object obj;
            int i;
            long onNodePlacedCalled;
            String str;
            final int i2 = 1;
            final int i3 = 0;
            this.relayoutWithoutParentInProgress = i2;
            int i4 = 0;
            if (!this.placedOnce) {
                i = 0;
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }
            Object obj2 = this;
            obj2.placeOuterCoordinator-MLgxB_4(this.lastPosition, str, this.lastZIndex, this.lastLayerBlock);
            onNodePlacedCalled = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).getParent$ui_release();
            if (isPlaced() && !obj2.onNodePlacedCalled && onNodePlacedCalled != null) {
                try {
                    if (!obj2.onNodePlacedCalled) {
                    }
                    onNodePlacedCalled = LayoutNodeLayoutDelegate.access$getLayoutNode$p(obj2.this$0).getParent$ui_release();
                    if (onNodePlacedCalled != null) {
                    }
                    LayoutNode.requestRelayout$ui_release$default(onNodePlacedCalled, i3, i2, 0);
                    obj2.relayoutWithoutParentInProgress = i3;
                    obj.relayoutWithoutParentInProgress = obj1;
                    throw th;
                } catch (Throwable th) {
                }
            }
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, 1, 0);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0), false, false, false, 7, 0);
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setChildDelegatesDirty$ui_release(boolean <set-?>) {
            this.childDelegatesDirty = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setDuringAlignmentLinesQuery$ui_release(boolean <set-?>) {
            this.duringAlignmentLinesQuery = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setMeasuredByParent$ui_release(androidx.compose.ui.node.LayoutNode.UsageByParent <set-?>) {
            this.measuredByParent = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void setPlaced$ui_release(boolean <set-?>) {
            this.isPlaced = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final void setPlacedByParent$ui_release(boolean <set-?>) {
            this.isPlacedByParent = <set-?>;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public void setPlacedUnderMotionFrameOfReference(boolean new) {
            int i;
            boolean placedUnderMotionFrameOfReference = this.this$0.getOuterCoordinator().isPlacedUnderMotionFrameOfReference();
            if (new != placedUnderMotionFrameOfReference) {
                this.this$0.getOuterCoordinator().setPlacedUnderMotionFrameOfReference(placedUnderMotionFrameOfReference);
                this.needsCoordinatesUpdate = true;
            }
            this.isPlacedUnderMotionFrameOfReference = new;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final boolean updateParentData() {
            Object parentData;
            final int i2 = 0;
            if (getParentData() == null && this.this$0.getOuterCoordinator().getParentData() == null) {
                if (this.this$0.getOuterCoordinator().getParentData() == null) {
                    return i2;
                }
            }
            if (!this.parentDataDirty) {
                return i2;
            }
            this.parentDataDirty = i2;
            this.parentData = this.this$0.getOuterCoordinator().getParentData();
            return 1;
        }
    }
    static {
        final int i = 8;
    }

    public LayoutNodeLayoutDelegate(androidx.compose.ui.node.LayoutNode layoutNode) {
        super();
        this.layoutNode = layoutNode;
        this.layoutState = LayoutNode.LayoutState.Idle;
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = new LayoutNodeLayoutDelegate.MeasurePassDelegate(this);
        this.measurePassDelegate = measurePassDelegate;
        this.performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
        LayoutNodeLayoutDelegate.performMeasureBlock.1 anon = new LayoutNodeLayoutDelegate.performMeasureBlock.1(this);
        this.performMeasureBlock = (Function0)anon;
    }

    public static final androidx.compose.ui.node.LayoutNode access$getLayoutNode$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this) {
        return $this.layoutNode;
    }

    public static final boolean access$getLayoutPendingForAlignment$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this) {
        return $this.layoutPendingForAlignment;
    }

    public static final boolean access$getLookaheadLayoutPendingForAlignment$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this) {
        return $this.lookaheadLayoutPendingForAlignment;
    }

    public static final int access$getNextChildLookaheadPlaceOrder$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this) {
        return $this.nextChildLookaheadPlaceOrder;
    }

    public static final int access$getNextChildPlaceOrder$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this) {
        return $this.nextChildPlaceOrder;
    }

    public static final long access$getPerformMeasureConstraints$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this) {
        return $this.performMeasureConstraints;
    }

    public static final void access$performLookaheadMeasure-BRTryo0(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, long constraints) {
        $this.performLookaheadMeasure-BRTryo0(constraints);
    }

    public static final void access$performMeasure-BRTryo0(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, long constraints) {
        $this.performMeasure-BRTryo0(constraints);
    }

    public static final void access$setDetachedFromParentLookaheadPass$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, boolean <set-?>) {
        $this.detachedFromParentLookaheadPass = <set-?>;
    }

    public static final void access$setLayoutPending$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, boolean <set-?>) {
        $this.layoutPending = <set-?>;
    }

    public static final void access$setLayoutPendingForAlignment$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, boolean <set-?>) {
        $this.layoutPendingForAlignment = <set-?>;
    }

    public static final void access$setLayoutState$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, androidx.compose.ui.node.LayoutNode.LayoutState <set-?>) {
        $this.layoutState = <set-?>;
    }

    public static final void access$setLookaheadLayoutPending$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, boolean <set-?>) {
        $this.lookaheadLayoutPending = <set-?>;
    }

    public static final void access$setLookaheadLayoutPendingForAlignment$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, boolean <set-?>) {
        $this.lookaheadLayoutPendingForAlignment = <set-?>;
    }

    public static final void access$setNextChildLookaheadPlaceOrder$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, int <set-?>) {
        $this.nextChildLookaheadPlaceOrder = <set-?>;
    }

    public static final void access$setNextChildPlaceOrder$p(androidx.compose.ui.node.LayoutNodeLayoutDelegate $this, int <set-?>) {
        $this.nextChildPlaceOrder = <set-?>;
    }

    private final void performLookaheadMeasure-BRTryo0(long constraints) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        LayoutNodeLayoutDelegate.performLookaheadMeasure.1 anon = new LayoutNodeLayoutDelegate.performLookaheadMeasure.1(this, constraints, obj9);
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, (Function0)anon, 2, 0);
        markLookaheadLayoutPending$ui_release();
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    private final void performMeasure-BRTryo0(long constraints) {
        int i;
        androidx.compose.ui.node.LayoutNode.LayoutState layoutState;
        String $i$a$CheckPreconditionLayoutNodeLayoutDelegate$performMeasure$1;
        final int i3 = 0;
        i = this.layoutState == LayoutNode.LayoutState.Idle ? 1 : i3;
        int i2 = 0;
        if (i == 0) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
        }
        this.layoutState = LayoutNode.LayoutState.Measuring;
        this.measurePending = i3;
        this.performMeasureConstraints = constraints;
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, i3, this.performMeasureBlock);
        if (this.layoutState == LayoutNode.LayoutState.Measuring) {
            markLayoutPending$ui_release();
            this.layoutState = LayoutNode.LayoutState.Idle;
        }
    }

    public final void ensureLookaheadDelegateCreated$ui_release() {
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate;
        if (this.lookaheadPassDelegate == null) {
            lookaheadPassDelegate = new LayoutNodeLayoutDelegate.LookaheadPassDelegate(this);
            this.lookaheadPassDelegate = lookaheadPassDelegate;
        }
    }

    public final androidx.compose.ui.node.AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return (AlignmentLinesOwner)this.measurePassDelegate;
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final int getChildrenAccessingLookaheadCoordinatesDuringPlacement() {
        return this.childrenAccessingLookaheadCoordinatesDuringPlacement;
    }

    public final boolean getCoordinatesAccessedDuringModifierPlacement() {
        return this.coordinatesAccessedDuringModifierPlacement;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final boolean getDetachedFromParentLookaheadPass$ui_release() {
        return this.detachedFromParentLookaheadPass;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    public final Constraints getLastConstraints-DWUhwKw() {
        return this.measurePassDelegate.getLastConstraints-DWUhwKw();
    }

    public final Constraints getLastLookaheadConstraints-DWUhwKw() {
        Constraints lastConstraints-DWUhwKw;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lastConstraints-DWUhwKw = lookaheadPassDelegate.getLastConstraints-DWUhwKw();
        } else {
            lastConstraints-DWUhwKw = 0;
        }
        return lastConstraints-DWUhwKw;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    public final androidx.compose.ui.node.LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    public final androidx.compose.ui.node.AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return (AlignmentLinesOwner)this.lookaheadPassDelegate;
    }

    public final boolean getLookaheadCoordinatesAccessedDuringModifierPlacement() {
        return this.lookaheadCoordinatesAccessedDuringModifierPlacement;
    }

    public final boolean getLookaheadCoordinatesAccessedDuringPlacement() {
        return this.lookaheadCoordinatesAccessedDuringPlacement;
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.lookaheadLayoutPending;
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.lookaheadMeasurePending;
    }

    public final androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.measurePassDelegate;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    public final androidx.compose.ui.node.NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui_release().getOuterCoordinator$ui_release();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.invalidateParentData();
        }
    }

    public final void markChildrenDirty() {
        int i;
        final int i2 = 1;
        this.measurePassDelegate.setChildDelegatesDirty$ui_release(i2);
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            i = 0;
            lookaheadPassDelegate.setChildDelegatesDirty$ui_release(i2);
        }
    }

    public final void markLayoutPending$ui_release() {
        final int i = 1;
        this.layoutPending = i;
        this.layoutPendingForAlignment = i;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        final int i = 1;
        this.lookaheadLayoutPending = i;
        this.lookaheadLayoutPendingForAlignment = i;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void onCoordinatesUsed() {
        androidx.compose.ui.node.LayoutNode.LayoutState lookaheadLayingOut;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate;
        int i;
        androidx.compose.ui.node.LayoutNode.LayoutState layoutState$ui_release = this.layoutNode.getLayoutState$ui_release();
        final int i2 = 1;
        if (layoutState$ui_release != LayoutNode.LayoutState.LayingOut) {
            if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
                if (this.measurePassDelegate.getLayingOutChildren()) {
                    setCoordinatesAccessedDuringPlacement(i2);
                } else {
                    setCoordinatesAccessedDuringModifierPlacement(i2);
                }
            }
        } else {
        }
        lookaheadPassDelegate = this.lookaheadPassDelegate;
        i = 0;
        if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut && lookaheadPassDelegate != null && lookaheadPassDelegate.getLayingOutChildren() == i2) {
            lookaheadPassDelegate = this.lookaheadPassDelegate;
            i = 0;
            if (lookaheadPassDelegate != null) {
                if (lookaheadPassDelegate.getLayingOutChildren() == i2) {
                    i = i2;
                }
            }
            if (i != 0) {
                setLookaheadCoordinatesAccessedDuringPlacement(i2);
            } else {
                setLookaheadCoordinatesAccessedDuringModifierPlacement(i2);
            }
        }
    }

    public final void resetAlignmentLines() {
        Object lookaheadPassDelegate;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        lookaheadPassDelegate = this.lookaheadPassDelegate;
        lookaheadPassDelegate = lookaheadPassDelegate.getAlignmentLines();
        if (lookaheadPassDelegate != null && lookaheadPassDelegate != null) {
            lookaheadPassDelegate = lookaheadPassDelegate.getAlignmentLines();
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.reset$ui_release();
            }
        }
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int value) {
        int layoutDelegate$ui_release;
        int i;
        int i2;
        this.childrenAccessingCoordinatesDuringPlacement = value;
        i = 1;
        i2 = this.childrenAccessingCoordinatesDuringPlacement == 0 ? i : layoutDelegate$ui_release;
        if (value == null) {
            layoutDelegate$ui_release = i;
        }
        if (i2 != layoutDelegate$ui_release) {
            androidx.compose.ui.node.LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release();
            } else {
                layoutDelegate$ui_release = 0;
            }
            if (layoutDelegate$ui_release != null) {
                if (value == null) {
                    layoutDelegate$ui_release.setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement2--);
                } else {
                    layoutDelegate$ui_release.setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement3 += i);
                }
            }
        }
    }

    public final void setChildrenAccessingLookaheadCoordinatesDuringPlacement(int value) {
        int layoutDelegate$ui_release;
        int i2;
        int i;
        this.childrenAccessingLookaheadCoordinatesDuringPlacement = value;
        i2 = 1;
        i = this.childrenAccessingLookaheadCoordinatesDuringPlacement == 0 ? i2 : layoutDelegate$ui_release;
        if (value == null) {
            layoutDelegate$ui_release = i2;
        }
        if (i != layoutDelegate$ui_release) {
            androidx.compose.ui.node.LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release();
            } else {
                layoutDelegate$ui_release = 0;
            }
            if (layoutDelegate$ui_release != null) {
                if (value == null) {
                    layoutDelegate$ui_release.setChildrenAccessingLookaheadCoordinatesDuringPlacement(childrenAccessingLookaheadCoordinatesDuringPlacement2--);
                } else {
                    layoutDelegate$ui_release.setChildrenAccessingLookaheadCoordinatesDuringPlacement(childrenAccessingLookaheadCoordinatesDuringPlacement3 += i2);
                }
            }
        }
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean value) {
        int coordinatesAccessedDuringPlacement;
        if (this.coordinatesAccessedDuringModifierPlacement != value) {
            this.coordinatesAccessedDuringModifierPlacement = value;
            if (value != null && !this.coordinatesAccessedDuringPlacement) {
                if (!this.coordinatesAccessedDuringPlacement) {
                    setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement++);
                } else {
                    if (value == null && !this.coordinatesAccessedDuringPlacement) {
                        if (!this.coordinatesAccessedDuringPlacement) {
                            setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement2--);
                        }
                    }
                }
            } else {
            }
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean value) {
        int coordinatesAccessedDuringModifierPlacement;
        if (this.coordinatesAccessedDuringPlacement != value) {
            this.coordinatesAccessedDuringPlacement = value;
            if (value != null && !this.coordinatesAccessedDuringModifierPlacement) {
                if (!this.coordinatesAccessedDuringModifierPlacement) {
                    setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement++);
                } else {
                    if (value == null && !this.coordinatesAccessedDuringModifierPlacement) {
                        if (!this.coordinatesAccessedDuringModifierPlacement) {
                            setChildrenAccessingCoordinatesDuringPlacement(childrenAccessingCoordinatesDuringPlacement2--);
                        }
                    }
                }
            } else {
            }
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringModifierPlacement(boolean value) {
        int lookaheadCoordinatesAccessedDuringPlacement;
        if (this.lookaheadCoordinatesAccessedDuringModifierPlacement != value) {
            this.lookaheadCoordinatesAccessedDuringModifierPlacement = value;
            if (value != null && !this.lookaheadCoordinatesAccessedDuringPlacement) {
                if (!this.lookaheadCoordinatesAccessedDuringPlacement) {
                    setChildrenAccessingLookaheadCoordinatesDuringPlacement(childrenAccessingLookaheadCoordinatesDuringPlacement++);
                } else {
                    if (value == null && !this.lookaheadCoordinatesAccessedDuringPlacement) {
                        if (!this.lookaheadCoordinatesAccessedDuringPlacement) {
                            setChildrenAccessingLookaheadCoordinatesDuringPlacement(childrenAccessingLookaheadCoordinatesDuringPlacement2--);
                        }
                    }
                }
            } else {
            }
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringPlacement(boolean value) {
        int lookaheadCoordinatesAccessedDuringModifierPlacement;
        if (this.lookaheadCoordinatesAccessedDuringPlacement != value) {
            this.lookaheadCoordinatesAccessedDuringPlacement = value;
            if (value != null && !this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                if (!this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                    setChildrenAccessingLookaheadCoordinatesDuringPlacement(childrenAccessingLookaheadCoordinatesDuringPlacement++);
                } else {
                    if (value == null && !this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                        if (!this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                            setChildrenAccessingLookaheadCoordinatesDuringPlacement(childrenAccessingLookaheadCoordinatesDuringPlacement2--);
                        }
                    }
                }
            } else {
            }
        }
    }

    public final void updateParentData() {
        boolean parentData;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate;
        androidx.compose.ui.node.LayoutNode parent$ui_release2;
        int parent$ui_release;
        int i4;
        int i;
        int i2;
        int i3;
        int i5;
        parent$ui_release2 = this.layoutNode.getParent$ui_release();
        if (this.measurePassDelegate.updateParentData() && parent$ui_release2 != null) {
            parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release2 != null) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, false, false, 7, 0);
            }
        }
        lookaheadPassDelegate = this.lookaheadPassDelegate;
        parent$ui_release = 0;
        i4 = 1;
        if (lookaheadPassDelegate != null && lookaheadPassDelegate.updateParentData() == i4) {
            i4 = 1;
            if (lookaheadPassDelegate.updateParentData() == i4) {
                parent$ui_release = i4;
            }
        }
        if (parent$ui_release != 0) {
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode)) {
                parent$ui_release = this.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 7, 0);
                }
            } else {
                parent$ui_release = this.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release, false, false, false, 7, 0);
                }
            }
        }
    }
}
