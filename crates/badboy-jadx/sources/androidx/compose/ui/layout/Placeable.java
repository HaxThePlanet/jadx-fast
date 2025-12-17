package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u00002\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u001d\u001a\u00020\u001eH\u0002J=\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001e\u0018\u00010$¢\u0006\u0002\u0008&H$ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J*\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0014ø\u0001\u0000¢\u0006\u0004\u0008'\u0010+R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u001a\u0004\u0008\u0012\u0010\u0007\"\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000cR,\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u001a\u0004\u0008\u0019\u0010\u0007\"\u0004\u0008\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006-", d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "()J", "J", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "onMeasuredSizeChanged", "", "placeAt", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "PlacementScope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Placeable implements androidx.compose.ui.layout.Measured {

    public static final int $stable = 8;
    private long apparentToRealOffset;
    private int height;
    private long measuredSize;
    private long measurementConstraints;
    private int width;

    @PlacementScopeMarker
    @Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0008\u0015J\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u000c\u0010\u001a\u001a\u00020\u0012*\u00020\u001bH\u0002J&\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J$\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017JD\u0010$\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u001b\u0008\u0008\u0010%\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0002\u0008\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J/\u0010$\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008'\u0010+JD\u0010,\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u001b\u0008\u0008\u0010%\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014¢\u0006\u0002\u0008\u0015H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008-\u0010(J/\u0010,\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008-\u0010+J&\u0010.\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\u0008/\u0010!J$\u0010.\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017J.\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\u00081\u00102JA\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00172\u0019\u0008\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0008\u0015ø\u0001\u0000¢\u0006\u0004\u00081\u0010(J,\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017J?\u00100\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00172\u0019\u0008\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0008\u0015J.\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\u00084\u00102JA\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00172\u0019\u0008\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0008\u0015ø\u0001\u0000¢\u0006\u0004\u00084\u0010(J,\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u0017J?\u00103\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00172\u0019\u0008\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\u0008\u0015R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0012\u0010\r\u001a\u00020\u000eX¤\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00065", d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "motionFrameOfReferencePlacement", "", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "withMotionFrameOfReferencePlacement", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "current", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "handleMotionFrameOfReferencePlacement", "Landroidx/compose/ui/layout/Placeable;", "place", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class PlacementScope {

        public static final int $stable = 8;
        private boolean motionFrameOfReferencePlacement;
        static {
            final int i = 8;
        }

        public static final LayoutDirection access$getParentLayoutDirection(androidx.compose.ui.layout.Placeable.PlacementScope $this) {
            return $this.getParentLayoutDirection();
        }

        public static final int access$getParentWidth(androidx.compose.ui.layout.Placeable.PlacementScope $this) {
            return $this.getParentWidth();
        }

        public static final void access$handleMotionFrameOfReferencePlacement(androidx.compose.ui.layout.Placeable.PlacementScope $this, androidx.compose.ui.layout.Placeable $receiver) {
            $this.handleMotionFrameOfReferencePlacement($receiver);
        }

        private final void handleMotionFrameOfReferencePlacement(androidx.compose.ui.layout.Placeable $this$handleMotionFrameOfReferencePlacement) {
            boolean z;
            boolean motionFrameOfReferencePlacement;
            if ($this$handleMotionFrameOfReferencePlacement instanceof MotionReferencePlacementDelegate) {
                (MotionReferencePlacementDelegate)$this$handleMotionFrameOfReferencePlacement.setPlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        public static void place$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, int i3, int i4, float f5, int i6, Object object7) {
            int obj4;
            if (object7 != null) {
            } else {
                if (i6 &= 4 != 0) {
                    obj4 = 0;
                }
                placementScope.place(placeable2, i3, i4, obj4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            throw obj0;
        }

        public static void place-70tqf50$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, long l3, float f4, int i5, Object object6) {
            int obj4;
            if (obj6 != null) {
            } else {
                if (object6 &= 2 != 0) {
                    obj4 = 0;
                }
                placementScope.place-70tqf50(placeable2, l3, f4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            throw obj0;
        }

        public static void placeRelative$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, int i3, int i4, float f5, int i6, Object object7) {
            int obj4;
            if (object7 != null) {
            } else {
                if (i6 &= 4 != 0) {
                    obj4 = 0;
                }
                placementScope.placeRelative(placeable2, i3, i4, obj4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            throw obj0;
        }

        public static void placeRelative-70tqf50$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, long l3, float f4, int i5, Object object6) {
            int obj4;
            if (obj6 != null) {
            } else {
                if (object6 &= 2 != 0) {
                    obj4 = 0;
                }
                placementScope.placeRelative-70tqf50(placeable2, l3, f4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            throw obj0;
        }

        public static void placeRelativeWithLayer$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, int i3, int i4, float f5, Function1 function16, int i7, Object object8) {
            int i;
            Function1 function1;
            int obj10;
            Function1 obj11;
            if (object8 != null) {
            } else {
                i = i7 & 4 != 0 ? obj10 : f5;
                if (i7 & 8 != 0) {
                    function1 = obj11;
                } else {
                    function1 = function16;
                }
                placementScope.placeRelativeWithLayer(placeable2, i3, i4, i, function1);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            throw obj6;
        }

        public static void placeRelativeWithLayer$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, int i3, int i4, GraphicsLayer graphicsLayer5, float f6, int i7, Object object8) {
            int i;
            int obj11;
            if (object8 != null) {
            } else {
                i = i7 &= 8 != 0 ? obj11 : f6;
                placementScope.placeRelativeWithLayer(placeable2, i3, i4, graphicsLayer5, i);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            throw obj6;
        }

        public static void placeRelativeWithLayer-aW-9-wM$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, long l3, float f4, Function1 function15, int i6, Object object7) {
            int i;
            Function1 function1;
            int obj10;
            Function1 obj11;
            if (obj13 != null) {
            } else {
                i = object7 & 2 != 0 ? obj10 : function15;
                if (object7 & 4 != 0) {
                    function1 = obj11;
                } else {
                    function1 = i6;
                }
                placementScope.placeRelativeWithLayer-aW-9-wM(placeable2, l3, obj3, i);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            throw obj6;
        }

        public static void placeRelativeWithLayer-aW-9-wM$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, long l3, GraphicsLayer graphicsLayer4, float f5, int i6, Object object7) {
            int i;
            int obj11;
            if (obj13 != null) {
            } else {
                i = object7 &= 4 != 0 ? obj11 : i6;
                placementScope.placeRelativeWithLayer-aW-9-wM(placeable2, l3, obj3, f5);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            throw obj6;
        }

        public static void placeWithLayer$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, int i3, int i4, float f5, Function1 function16, int i7, Object object8) {
            int i;
            Function1 function1;
            int obj10;
            Function1 obj11;
            if (object8 != null) {
            } else {
                i = i7 & 4 != 0 ? obj10 : f5;
                if (i7 & 8 != 0) {
                    function1 = obj11;
                } else {
                    function1 = function16;
                }
                placementScope.placeWithLayer(placeable2, i3, i4, i, function1);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            throw obj6;
        }

        public static void placeWithLayer$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, int i3, int i4, GraphicsLayer graphicsLayer5, float f6, int i7, Object object8) {
            int i;
            int obj11;
            if (object8 != null) {
            } else {
                i = i7 &= 8 != 0 ? obj11 : f6;
                placementScope.placeWithLayer(placeable2, i3, i4, graphicsLayer5, i);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            throw obj6;
        }

        public static void placeWithLayer-aW-9-wM$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, long l3, float f4, Function1 function15, int i6, Object object7) {
            int i;
            Function1 function1;
            int obj10;
            Function1 obj11;
            if (obj13 != null) {
            } else {
                i = object7 & 2 != 0 ? obj10 : function15;
                if (object7 & 4 != 0) {
                    function1 = obj11;
                } else {
                    function1 = i6;
                }
                placementScope.placeWithLayer-aW-9-wM(placeable2, l3, obj3, i);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            throw obj6;
        }

        public static void placeWithLayer-aW-9-wM$default(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope, androidx.compose.ui.layout.Placeable placeable2, long l3, GraphicsLayer graphicsLayer4, float f5, int i6, Object object7) {
            int i;
            int obj11;
            if (obj13 != null) {
            } else {
                i = object7 &= 4 != 0 ? obj11 : i6;
                placementScope.placeWithLayer-aW-9-wM(placeable2, l3, obj3, f5);
            }
            UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            throw obj6;
        }

        public float current(androidx.compose.ui.layout.Ruler $this$current, float defaultValue) {
            return defaultValue;
        }

        public androidx.compose.ui.layout.LayoutCoordinates getCoordinates() {
            return null;
        }

        protected abstract LayoutDirection getParentLayoutDirection();

        protected abstract int getParentWidth();

        public final void place(androidx.compose.ui.layout.Placeable $this$place, int x, int y, float zIndex) {
            final androidx.compose.ui.layout.Placeable placeable = $this$place;
            final int i2 = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(x, y), obj1), obj7, zIndex);
        }

        public final void place-70tqf50(androidx.compose.ui.layout.Placeable $this$place_u2d70tqf50, long position, float zIndex) {
            final androidx.compose.ui.layout.Placeable placeable = $this$place_u2d70tqf50;
            final int i2 = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(position, zIndex), obj5, obj10);
        }

        public final void placeApparentToRealOffset-aW-9-wM$ui_release(androidx.compose.ui.layout.Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM, long position, float zIndex, GraphicsLayer layer) {
            final int i = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM);
            Placeable.access$placeAt-f8xVGno($this$placeApparentToRealOffset_u2daW_u2d9_u2dwM, IntOffset.plus-qkQi6aY(position, zIndex), obj2, layer);
        }

        public final void placeApparentToRealOffset-aW-9-wM$ui_release(androidx.compose.ui.layout.Placeable $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            final int i = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, $this$placeApparentToRealOffset_u2daW_u2d9_u2dwM);
            Placeable.access$placeAt-f8xVGno($this$placeApparentToRealOffset_u2daW_u2d9_u2dwM, IntOffset.plus-qkQi6aY(position, zIndex), obj2, layerBlock);
        }

        public final void placeAutoMirrored-aW-9-wM$ui_release(androidx.compose.ui.layout.Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM, long position, float zIndex, GraphicsLayer layer) {
            long position$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable placeable;
            androidx.compose.ui.layout.Placeable.PlacementScope plus-qkQi6aY;
            int i;
            long plus-qkQi6aY2;
            final int i2 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(this) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(this) == 0) {
                    position$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM;
                    placeable = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, position$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv, IntOffset.plus-qkQi6aY(position, zIndex), obj5, layer);
                } else {
                    y-impl = IntOffset.getY-impl(position);
                    placeable = $this$placeAutoMirrored_u2daW_u2d9_u2dwM;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
                    Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i4 -= x-impl, y-impl), y-impl), obj7, layer);
                }
            } else {
            }
        }

        public final void placeAutoMirrored-aW-9-wM$ui_release(androidx.compose.ui.layout.Placeable $this$placeAutoMirrored_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            long position$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable placeable;
            androidx.compose.ui.layout.Placeable.PlacementScope plus-qkQi6aY2;
            int i;
            long plus-qkQi6aY;
            final int i2 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(this) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(this) == 0) {
                    position$iv = $this$placeAutoMirrored_u2daW_u2d9_u2dwM;
                    placeable = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, position$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv, IntOffset.plus-qkQi6aY(position, zIndex), obj5, layerBlock);
                } else {
                    y-impl = IntOffset.getY-impl(position);
                    placeable = $this$placeAutoMirrored_u2daW_u2d9_u2dwM;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
                    Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i4 -= x-impl, y-impl), y-impl), obj7, layerBlock);
                }
            } else {
            }
        }

        public final void placeRelative(androidx.compose.ui.layout.Placeable $this$placeRelative, int x, int y, float zIndex) {
            long position$iv$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable placeable;
            androidx.compose.ui.layout.Placeable.PlacementScope plus-qkQi6aY;
            int i;
            long plus-qkQi6aY2;
            final float f = zIndex;
            final long l = IntOffsetKt.IntOffset(x, y);
            final int i2 = 0;
            final androidx.compose.ui.layout.Placeable placeable2 = $this$placeRelative;
            final androidx.compose.ui.layout.Placeable.PlacementScope placementScope = this;
            final int i3 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(placementScope) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(placementScope) == 0) {
                    position$iv$iv = placeable2;
                    placeable = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, position$iv$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv$iv, IntOffset.plus-qkQi6aY(l, obj2), obj11, f);
                } else {
                    y-impl = IntOffset.getY-impl(l);
                    placeable = placeable2;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i5 -= x-impl, y-impl), y-impl), obj13, f);
                }
            } else {
            }
        }

        public final void placeRelative-70tqf50(androidx.compose.ui.layout.Placeable $this$placeRelative_u2d70tqf50, long position, float zIndex) {
            long position$iv$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable.PlacementScope placementScope;
            androidx.compose.ui.layout.Placeable plus-qkQi6aY2;
            int i;
            long plus-qkQi6aY;
            final int i2 = 0;
            final androidx.compose.ui.layout.Placeable placeable = $this$placeRelative_u2d70tqf50;
            final androidx.compose.ui.layout.Placeable.PlacementScope placementScope2 = this;
            final int i3 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(placementScope2) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(placementScope2) == 0) {
                    position$iv$iv = placeable;
                    placementScope = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope2, position$iv$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv$iv, IntOffset.plus-qkQi6aY(position, zIndex), obj8, obj15);
                } else {
                    y-impl = IntOffset.getY-impl(position);
                    plus-qkQi6aY2 = placeable;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope2, plus-qkQi6aY2);
                    Placeable.access$placeAt-f8xVGno(plus-qkQi6aY2, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i5 -= x-impl, y-impl), y-impl), obj10, obj15);
                }
            } else {
            }
        }

        public final void placeRelativeWithLayer(androidx.compose.ui.layout.Placeable $this$placeRelativeWithLayer, int x, int y, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            long position$iv$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable placeable;
            androidx.compose.ui.layout.Placeable.PlacementScope plus-qkQi6aY;
            int i;
            long plus-qkQi6aY2;
            final float f = zIndex;
            final Function1 function1 = layerBlock;
            final long l = IntOffsetKt.IntOffset(x, y);
            final androidx.compose.ui.layout.Placeable.PlacementScope placementScope = this;
            final androidx.compose.ui.layout.Placeable placeable2 = $this$placeRelativeWithLayer;
            final int i2 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(placementScope) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(placementScope) == 0) {
                    position$iv$iv = placeable2;
                    placeable = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, position$iv$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv$iv, IntOffset.plus-qkQi6aY(l, obj3), obj11, f);
                } else {
                    y-impl = IntOffset.getY-impl(l);
                    placeable = placeable2;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i4 -= x-impl, y-impl), y-impl), obj13, f);
                }
            } else {
            }
        }

        public final void placeRelativeWithLayer(androidx.compose.ui.layout.Placeable $this$placeRelativeWithLayer, int x, int y, GraphicsLayer layer, float zIndex) {
            long position$iv$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable placeable;
            androidx.compose.ui.layout.Placeable.PlacementScope plus-qkQi6aY;
            int i;
            long plus-qkQi6aY2;
            final GraphicsLayer graphicsLayer = layer;
            final float f = zIndex;
            final long l = IntOffsetKt.IntOffset(x, y);
            final androidx.compose.ui.layout.Placeable.PlacementScope placementScope = this;
            final androidx.compose.ui.layout.Placeable placeable2 = $this$placeRelativeWithLayer;
            final int i2 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(placementScope) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(placementScope) == 0) {
                    position$iv$iv = placeable2;
                    placeable = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, position$iv$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv$iv, IntOffset.plus-qkQi6aY(l, obj3), obj11, f);
                } else {
                    y-impl = IntOffset.getY-impl(l);
                    placeable = placeable2;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i4 -= x-impl, y-impl), y-impl), obj13, f);
                }
            } else {
            }
        }

        public final void placeRelativeWithLayer-aW-9-wM(androidx.compose.ui.layout.Placeable $this$placeRelativeWithLayer_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            long position$iv$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable.PlacementScope placementScope;
            androidx.compose.ui.layout.Placeable plus-qkQi6aY2;
            int i;
            long plus-qkQi6aY;
            final androidx.compose.ui.layout.Placeable placeable = $this$placeRelativeWithLayer_u2daW_u2d9_u2dwM;
            final androidx.compose.ui.layout.Placeable.PlacementScope placementScope2 = this;
            final int i2 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(placementScope2) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(placementScope2) == 0) {
                    position$iv$iv = placeable;
                    placementScope = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope2, position$iv$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv$iv, IntOffset.plus-qkQi6aY(position, zIndex), obj7, layerBlock);
                } else {
                    y-impl = IntOffset.getY-impl(position);
                    plus-qkQi6aY2 = placeable;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope2, plus-qkQi6aY2);
                    Placeable.access$placeAt-f8xVGno(plus-qkQi6aY2, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i4 -= x-impl, y-impl), y-impl), obj9, layerBlock);
                }
            } else {
            }
        }

        public final void placeRelativeWithLayer-aW-9-wM(androidx.compose.ui.layout.Placeable $this$placeRelativeWithLayer_u2daW_u2d9_u2dwM, long position, GraphicsLayer layer, float zIndex) {
            long position$iv$iv;
            LayoutDirection layoutDirection;
            int y-impl;
            androidx.compose.ui.layout.Placeable.PlacementScope placementScope;
            androidx.compose.ui.layout.Placeable plus-qkQi6aY2;
            int i;
            long plus-qkQi6aY;
            final androidx.compose.ui.layout.Placeable placeable = $this$placeRelativeWithLayer_u2daW_u2d9_u2dwM;
            final androidx.compose.ui.layout.Placeable.PlacementScope placementScope2 = this;
            final int i2 = 0;
            if (Placeable.PlacementScope.access$getParentLayoutDirection(placementScope2) != LayoutDirection.Ltr) {
                if (Placeable.PlacementScope.access$getParentWidth(placementScope2) == 0) {
                    position$iv$iv = placeable;
                    placementScope = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope2, position$iv$iv);
                    Placeable.access$placeAt-f8xVGno(position$iv$iv, IntOffset.plus-qkQi6aY(position, layer), obj7, obj15);
                } else {
                    y-impl = IntOffset.getY-impl(position);
                    plus-qkQi6aY2 = placeable;
                    i = 0;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope2, plus-qkQi6aY2);
                    Placeable.access$placeAt-f8xVGno(plus-qkQi6aY2, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(i4 -= x-impl, y-impl), y-impl), obj9, obj15);
                }
            } else {
            }
        }

        public final void placeWithLayer(androidx.compose.ui.layout.Placeable $this$placeWithLayer, int x, int y, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            final androidx.compose.ui.layout.Placeable placeable = $this$placeWithLayer;
            final int i = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(x, y), obj1), obj6, zIndex);
        }

        public final void placeWithLayer(androidx.compose.ui.layout.Placeable $this$placeWithLayer, int x, int y, GraphicsLayer layer, float zIndex) {
            final androidx.compose.ui.layout.Placeable placeable = $this$placeWithLayer;
            final int i = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(IntOffsetKt.IntOffset(x, y), obj1), obj6, zIndex);
        }

        public final void placeWithLayer-aW-9-wM(androidx.compose.ui.layout.Placeable $this$placeWithLayer_u2daW_u2d9_u2dwM, long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            final androidx.compose.ui.layout.Placeable placeable = $this$placeWithLayer_u2daW_u2d9_u2dwM;
            final int i = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(position, zIndex), obj4, layerBlock);
        }

        public final void placeWithLayer-aW-9-wM(androidx.compose.ui.layout.Placeable $this$placeWithLayer_u2daW_u2d9_u2dwM, long position, GraphicsLayer layer, float zIndex) {
            final androidx.compose.ui.layout.Placeable placeable = $this$placeWithLayer_u2daW_u2d9_u2dwM;
            final int i = 0;
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(this, placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffset.plus-qkQi6aY(position, layer), obj4, obj10);
        }

        public final void withMotionFrameOfReferencePlacement(Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> block) {
            this.motionFrameOfReferencePlacement = true;
            block.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }
    }
    static {
        final int i = 8;
    }

    public Placeable() {
        super();
        int i = 0;
        this.measuredSize = IntSizeKt.IntSize(i, i);
        this.measurementConstraints = PlaceableKt.access$getDefaultConstraints$p();
        this.apparentToRealOffset = IntOffset.Companion.getZero-nOcc-ac();
    }

    public static final long access$getApparentToRealOffset-nOcc-ac(androidx.compose.ui.layout.Placeable $this) {
        return $this.apparentToRealOffset;
    }

    public static final void access$placeAt-f8xVGno(androidx.compose.ui.layout.Placeable $this, long position, float zIndex, GraphicsLayer layer) {
        $this.placeAt-f8xVGno(position, zIndex, layer);
    }

    public static final void access$placeAt-f8xVGno(androidx.compose.ui.layout.Placeable $this, long position, float zIndex, Function1 layerBlock) {
        $this.placeAt-f8xVGno(position, zIndex, layerBlock);
    }

    private final void onMeasuredSizeChanged() {
        int minWidth-impl = Constraints.getMinWidth-impl(this.measurementConstraints);
        int maxWidth-impl = Constraints.getMaxWidth-impl(this.measurementConstraints);
        this.width = RangesKt.coerceIn(IntSize.getWidth-impl(this.measuredSize), minWidth-impl, maxWidth-impl);
        int maxHeight-impl = Constraints.getMaxHeight-impl(this.measurementConstraints);
        this.height = RangesKt.coerceIn(IntSize.getHeight-impl(this.measuredSize), Constraints.getMinHeight-impl(this.measurementConstraints), maxHeight-impl);
        this.apparentToRealOffset = IntOffsetKt.IntOffset(i /= 2, i3 /= 2);
    }

    @Override // androidx.compose.ui.layout.Measured
    protected final long getApparentToRealOffset-nOcc-ac() {
        return this.apparentToRealOffset;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return IntSize.getHeight-impl(this.measuredSize);
    }

    @Override // androidx.compose.ui.layout.Measured
    protected final long getMeasuredSize-YbymL2g() {
        return this.measuredSize;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return IntSize.getWidth-impl(this.measuredSize);
    }

    @Override // androidx.compose.ui.layout.Measured
    protected final long getMeasurementConstraints-msEJaDk() {
        return this.measurementConstraints;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int getWidth() {
        return this.width;
    }

    @Override // androidx.compose.ui.layout.Measured
    protected void placeAt-f8xVGno(long position, float zIndex, GraphicsLayer layer) {
        placeAt-f8xVGno(position, zIndex, layer);
    }

    protected abstract void placeAt-f8xVGno(long l, float f2, Function1<? super GraphicsLayerScope, Unit> function13);

    @Override // androidx.compose.ui.layout.Measured
    protected final void setMeasuredSize-ozmzZPI(long value) {
        if (!IntSize.equals-impl0(this.measuredSize, obj1)) {
            this.measuredSize = value;
            onMeasuredSizeChanged();
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    protected final void setMeasurementConstraints-BRTryo0(long value) {
        if (!Constraints.equals-impl0(this.measurementConstraints, obj1)) {
            this.measurementConstraints = value;
            onMeasuredSizeChanged();
        }
    }
}
