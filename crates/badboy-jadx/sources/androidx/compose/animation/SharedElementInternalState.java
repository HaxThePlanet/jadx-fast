package androidx.compose.animation;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u00082\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010a\u001a\u00020bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008c\u00101J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u0008\u0010h\u001a\u00020eH\u0016J\u0008\u0010i\u001a\u00020eH\u0016J\u0008\u0010j\u001a\u00020eH\u0016R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR/\u0010!\u001a\u0004\u0018\u00010 2\u0008\u0010\u0013\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008&\u0010\u0019\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\"\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-R\u0017\u0010.\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u00080\u00101R+\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u000c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00086\u0010\u0019\u001a\u0004\u00082\u00103\"\u0004\u00084\u00105R\u001c\u00107\u001a\u0004\u0018\u00010\u0000X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R+\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008@\u0010\u0019\u001a\u0004\u0008<\u0010=\"\u0004\u0008>\u0010?R+\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008E\u0010\u0019\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR+\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008H\u0010\u0019\u001a\u0004\u0008F\u0010B\"\u0004\u0008G\u0010DR+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008M\u0010\u0019\u001a\u0004\u0008I\u0010J\"\u0004\u0008K\u0010LR\u0014\u0010N\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010BR\u0014\u0010P\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008Q\u0010BR\u0011\u0010R\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008S\u0010BR\u0011\u0010T\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008U\u0010BR+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008Z\u0010\u0019\u001a\u0004\u0008V\u0010W\"\u0004\u0008X\u0010YR+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008_\u0010`\u001a\u0004\u0008[\u0010\\\"\u0004\u0008]\u0010^\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006k", d2 = {"Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", "userState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "Landroidx/compose/runtime/MutableState;", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation_release", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation_release", "(Landroidx/compose/ui/graphics/Path;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "lookaheadCoords", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadCoords", "()Lkotlin/jvm/functions/Function0;", "setLookaheadCoords", "(Lkotlin/jvm/functions/Function0;)V", "nonNullLookaheadSize", "Landroidx/compose/ui/geometry/Size;", "getNonNullLookaheadSize-NH-jbRc", "()J", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "setParentState", "(Landroidx/compose/animation/SharedElementInternalState;)V", "getPlaceHolderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "setPlaceHolderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;)V", "placeHolderSize$delegate", "getRenderInOverlayDuringTransition", "()Z", "setRenderInOverlayDuringTransition", "(Z)V", "renderInOverlayDuringTransition$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "shouldRenderBasedOnTarget", "getShouldRenderBasedOnTarget", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation_release", "shouldRenderInPlace", "getShouldRenderInPlace", "target", "getTarget", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "calculateLookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "calculateLookaheadOffset-F1C5BW0", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedElementInternalState implements androidx.compose.animation.LayerRenderer, RememberObserver {

    public static final int $stable = 8;
    private final MutableState boundsAnimation$delegate;
    private Path clipPathInOverlay;
    private final MutableState layer$delegate;
    private Function0<? extends LayoutCoordinates> lookaheadCoords;
    private final MutableState overlayClip$delegate;
    private androidx.compose.animation.SharedElementInternalState parentState;
    private final MutableState placeHolderSize$delegate;
    private final MutableState renderInOverlayDuringTransition$delegate;
    private final MutableState renderOnlyWhenVisible$delegate;
    private final MutableState sharedElement$delegate;
    private final MutableState userState$delegate;
    private final MutableFloatState zIndex$delegate;
    static {
        final int i = 8;
    }

    public SharedElementInternalState(androidx.compose.animation.SharedElement sharedElement, androidx.compose.animation.BoundsAnimation boundsAnimation, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderOnlyWhenVisible, androidx.compose.animation.SharedTransitionScope.OverlayClip overlayClip, boolean renderInOverlayDuringTransition, androidx.compose.animation.SharedTransitionScope.SharedContentState userState, float zIndex) {
        super();
        this.zIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(zIndex);
        final int i = 0;
        final int i2 = 2;
        this.renderInOverlayDuringTransition$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(renderInOverlayDuringTransition), i, i2, i);
        this.sharedElement$delegate = SnapshotStateKt.mutableStateOf$default(sharedElement, i, i2, i);
        this.boundsAnimation$delegate = SnapshotStateKt.mutableStateOf$default(boundsAnimation, i, i2, i);
        this.placeHolderSize$delegate = SnapshotStateKt.mutableStateOf$default(placeHolderSize, i, i2, i);
        this.renderOnlyWhenVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(renderOnlyWhenVisible), i, i2, i);
        this.overlayClip$delegate = SnapshotStateKt.mutableStateOf$default(overlayClip, i, i2, i);
        this.userState$delegate = SnapshotStateKt.mutableStateOf$default(userState, i, i2, i);
        this.lookaheadCoords = (Function0)SharedElementInternalState.lookaheadCoords.1.INSTANCE;
        this.layer$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
    }

    private final boolean getShouldRenderBasedOnTarget() {
        int i;
        boolean renderOnlyWhenVisible;
        if (!Intrinsics.areEqual(getSharedElement().getTargetBoundsProvider$animation_release(), this)) {
            if (!getRenderOnlyWhenVisible()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final long calculateLookaheadOffset-F1C5BW0() {
        Object invoke = this.lookaheadCoords.invoke();
        if (invoke == null) {
        } else {
            return getSharedElement().getScope().getLookaheadRoot$animation_release().localPositionOf-R5De75A((LayoutCoordinates)invoke, Offset.Companion.getZero-F1C5BW0());
        }
        int c = 0;
        IllegalArgumentException $i$a$RequireNotNullSharedElementInternalState$calculateLookaheadOffset$c$1 = new IllegalArgumentException("Error: lookahead coordinates is null.".toString());
        throw $i$a$RequireNotNullSharedElementInternalState$calculateLookaheadOffset$c$1;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void drawInOverlay(DrawScope drawScope) {
        int box-impl;
        Object shouldRenderInOverlay$animation_release;
        long size-NH-jbRc;
        int i8;
        int iNSTANCE;
        long topLeft-F1C5BW0;
        Object l4;
        long f;
        int i4;
        long l2;
        int intersect-rtfAjoo;
        int i2;
        long l;
        int i3;
        DrawContext drawContext;
        int i7;
        long $this$drawInOverlay_u24lambda_u245;
        int i6;
        long l3;
        int i5;
        DrawScope drawScope2;
        int i;
        DrawContext context;
        GraphicsLayer layer = getLayer();
        if (layer == null) {
        }
        final GraphicsLayer graphicsLayer = layer;
        if (getShouldRenderInOverlay$animation_release()) {
            size-NH-jbRc = drawScope;
            i8 = 0;
            if (getSharedElement().getCurrentBounds() == null) {
            } else {
                Rect currentBounds2 = getSharedElement().getCurrentBounds();
                if (currentBounds2 != null) {
                    box-impl = Offset.box-impl(currentBounds2.getTopLeft-F1C5BW0());
                } else {
                    box-impl = iNSTANCE;
                }
                Intrinsics.checkNotNull(box-impl);
                long unbox-impl = box-impl.unbox-impl();
                int i9 = 0;
                f = $i$f$component1Impl;
                int i10 = 0;
                topLeft-F1C5BW0 = $i$f$component2Impl;
                shouldRenderInOverlay$animation_release = l4.clipPathInOverlay;
                if (shouldRenderInOverlay$animation_release != null) {
                    Path path = shouldRenderInOverlay$animation_release;
                    i4 = 0;
                    i2 = 0;
                    l = l2;
                    i3 = 0;
                    drawContext = l.getDrawContext();
                    i7 = 0;
                    $this$drawInOverlay_u24lambda_u245 = size-NH-jbRc;
                    i6 = i8;
                    drawContext.getCanvas().save();
                    int i13 = 0;
                    drawContext.getTransform().clipPath-mtrdD-E(path, ClipOp.Companion.getIntersect-rtfAjoo());
                    i5 = 0;
                    drawScope2 = l3;
                    i = 0;
                    drawScope2.getDrawContext().getTransform().translate(f, topLeft-F1C5BW0);
                    int i14 = 0;
                    GraphicsLayerKt.drawLayer(drawScope2, graphicsLayer);
                    context = path;
                    drawScope2.getDrawContext().getTransform().translate(-f, -topLeft-F1C5BW0);
                    drawContext.getCanvas().restore();
                    drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
                    iNSTANCE = Unit.INSTANCE;
                } else {
                    $this$drawInOverlay_u24lambda_u245 = size-NH-jbRc;
                    i6 = i8;
                }
                if (iNSTANCE == null) {
                    size-NH-jbRc = $this$drawInOverlay_u24lambda_u245;
                    i8 = 0;
                    size-NH-jbRc.getDrawContext().getTransform().translate(f, topLeft-F1C5BW0);
                    int i12 = 0;
                    GraphicsLayerKt.drawLayer(size-NH-jbRc, graphicsLayer);
                    size-NH-jbRc.getDrawContext().getTransform().translate(-f, -topLeft-F1C5BW0);
                }
            }
            long l5 = size-NH-jbRc;
            int i11 = 0;
            IllegalArgumentException $i$a$RequireNotNullSharedElementInternalState$drawInOverlay$1$1 = new IllegalArgumentException("Error: current bounds not set yet.".toString());
            throw $i$a$RequireNotNullSharedElementInternalState$drawInOverlay$1$1;
        }
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final androidx.compose.animation.BoundsAnimation getBoundsAnimation() {
        final int i = 0;
        final int i2 = 0;
        return (BoundsAnimation)(State)this.boundsAnimation$delegate.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final Path getClipPathInOverlay$animation_release() {
        return this.clipPathInOverlay;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final GraphicsLayer getLayer() {
        final int i = 0;
        final int i2 = 0;
        return (GraphicsLayer)(State)this.layer$delegate.getValue();
    }

    public final Function0<LayoutCoordinates> getLookaheadCoords() {
        return this.lookaheadCoords;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final long getNonNullLookaheadSize-NH-jbRc() {
        Object invoke = this.lookaheadCoords.invoke();
        if (invoke == null) {
        } else {
            return IntSizeKt.toSize-ozmzZPI((LayoutCoordinates)invoke.getSize-YbymL2g());
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Error: lookahead coordinates is null for ").append(getSharedElement().getKey()).append('.').toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final androidx.compose.animation.SharedTransitionScope.OverlayClip getOverlayClip() {
        final int i = 0;
        final int i2 = 0;
        return (SharedTransitionScope.OverlayClip)(State)this.overlayClip$delegate.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public androidx.compose.animation.SharedElementInternalState getParentState() {
        return this.parentState;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final androidx.compose.animation.SharedTransitionScope.PlaceHolderSize getPlaceHolderSize() {
        final int i = 0;
        final int i2 = 0;
        return (SharedTransitionScope.PlaceHolderSize)(State)this.placeHolderSize$delegate.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final boolean getRenderInOverlayDuringTransition() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.renderInOverlayDuringTransition$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final boolean getRenderOnlyWhenVisible() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.renderOnlyWhenVisible$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final androidx.compose.animation.SharedElement getSharedElement() {
        final int i = 0;
        final int i2 = 0;
        return (SharedElement)(State)this.sharedElement$delegate.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final boolean getShouldRenderInOverlay$animation_release() {
        int i;
        boolean shouldRenderBasedOnTarget;
        if (getShouldRenderBasedOnTarget() && getSharedElement().getFoundMatch() && getRenderInOverlayDuringTransition()) {
            if (getSharedElement().getFoundMatch()) {
                i = getRenderInOverlayDuringTransition() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final boolean getShouldRenderInPlace() {
        boolean shouldRenderInOverlay$animation_release;
        int i;
        if (getSharedElement().getFoundMatch()) {
            if (!getShouldRenderInOverlay$animation_release() && getShouldRenderBasedOnTarget()) {
                if (getShouldRenderBasedOnTarget()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final androidx.compose.animation.SharedTransitionScope.SharedContentState getUserState() {
        final int i = 0;
        final int i2 = 0;
        return (SharedTransitionScope.SharedContentState)(State)this.userState$delegate.getValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float getZIndex() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.zIndex$delegate.getFloatValue();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void onAbandoned() {
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void onForgotten() {
        getSharedElement().getScope().onStateRemoved$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void onRemembered() {
        getSharedElement().getScope().onStateAdded$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setBoundsAnimation(androidx.compose.animation.BoundsAnimation <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.boundsAnimation$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setClipPathInOverlay$animation_release(Path <set-?>) {
        this.clipPathInOverlay = <set-?>;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setLayer(GraphicsLayer <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.layer$delegate.setValue(<set-?>);
    }

    public final void setLookaheadCoords(Function0<? extends LayoutCoordinates> <set-?>) {
        this.lookaheadCoords = <set-?>;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setOverlayClip(androidx.compose.animation.SharedTransitionScope.OverlayClip <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.overlayClip$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void setParentState(androidx.compose.animation.SharedElementInternalState <set-?>) {
        this.parentState = <set-?>;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setPlaceHolderSize(androidx.compose.animation.SharedTransitionScope.PlaceHolderSize <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.placeHolderSize$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setRenderInOverlayDuringTransition(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.renderInOverlayDuringTransition$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setRenderOnlyWhenVisible(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.renderOnlyWhenVisible$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setSharedElement(androidx.compose.animation.SharedElement <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.sharedElement$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.LayerRenderer
    public final void setUserState(androidx.compose.animation.SharedTransitionScope.SharedContentState <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.userState$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void setZIndex(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.zIndex$delegate.setFloatValue(<set-?>);
    }
}
