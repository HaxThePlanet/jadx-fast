package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0001uB\u0017\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\u00083J\u0015\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001eH\u0000¢\u0006\u0002\u00086J\u0015\u00107\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001eH\u0000¢\u0006\u0002\u00088J\u0015\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\u0008<J\u0015\u0010=\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\u0008>J\u0015\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020$H\u0017¢\u0006\u0002\u0010BJM\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\nH\u0003¢\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u00020%2\u0006\u0010A\u001a\u00020$H\u0002J\u0008\u0010&\u001a\u00020\u001bH\u0002J3\u0010Q\u001a\u00020R*\u00020\u00122\u0006\u0010S\u001a\u00020\u00122\u0008\u0008\u0002\u0010T\u001a\u00020R2\u0008\u0008\u0002\u0010U\u001a\u00020\nH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\u0008V\u0010WJ>\u0010X\u001a\u00020Y*\u00020Y2\u000c\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020\n0\u001a2\u0006\u0010L\u001a\u00020M2\u001a\u0010K\u001a\u0016\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020]\u0012\u0006\u0012\u0004\u0018\u00010^0[H\u0016J\\\u0010_\u001a\u00020Y*\u00020Y2\u0006\u0010J\u001a\u00020@2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0016Jp\u0010j\u001a\u00020Y\"\u0004\u0008\u0000\u0010k*\u00020Y2\u0006\u0010J\u001a\u00020@2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u0002Hk\u0018\u00010m2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u0002Hk\u0012\u0004\u0012\u00020\n0'2\u0006\u0010f\u001a\u00020g2\u0008\u0008\u0002\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0002JS\u0010o\u001a\u00020Y*\u00020Y2\u0006\u0010J\u001a\u00020@2\u0006\u0010n\u001a\u00020\n2\u0008\u0008\u0002\u0010f\u001a\u00020g2\u0008\u0008\u0002\u0010G\u001a\u00020H2\u0008\u0008\u0002\u0010N\u001a\u00020\n2\u0008\u0008\u0002\u0010L\u001a\u00020M2\u0008\u0008\u0002\u0010K\u001a\u00020-H\u0000¢\u0006\u0002\u0008pJD\u0010D\u001a\u00020Y*\u00020Y2\u0006\u0010q\u001a\u00020@2\u0006\u0010`\u001a\u00020a2\u0006\u0010f\u001a\u00020g2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0016JD\u0010r\u001a\u00020Y*\u00020Y2\u0006\u0010J\u001a\u00020@2\u0006\u0010n\u001a\u00020\n2\u0006\u0010f\u001a\u00020g2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020-H\u0016J\u000c\u0010s\u001a\u00020Y*\u00020YH\u0016J\r\u0010t\u001a\u00020\u0012*\u00020\u0012H\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014\"\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0012X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0014\"\u0004\u0008!\u0010\u0018R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\u00020\u0012*\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008*\u0010+\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006v", d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "isTransitionActive", "()Z", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "lookaheadRoot", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadRoot$animation_release", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "nullableLookaheadRoot", "getNullableLookaheadRoot$animation_release", "setNullableLookaheadRoot$animation_release", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "observeAnimatingBlock", "Lkotlin/Function0;", "", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "root", "getRoot$animation_release", "setRoot$animation_release", "sharedElements", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/compose/animation/SharedElement;", "updateTransitionActiveness", "Lkotlin/Function1;", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "OverlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "drawInOverlay", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation_release", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation_release", "onLayerRendererRemoved", "onLayerRendererRemoved$animation_release", "onStateAdded", "sharedElementState", "Landroidx/compose/animation/SharedElementInternalState;", "onStateAdded$animation_release", "onStateRemoved", "onStateRemoved$animation_release", "rememberSharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "key", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "rememberSharedElementState", "sharedElement", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "sharedContentState", "clipInOverlayDuringTransition", "zIndexInOverlay", "", "renderInOverlayDuringTransition", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementInternalState;", "sharedElementsFor", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "renderInSharedTransitionScopeOverlay", "Landroidx/compose/ui/Modifier;", "renderInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "sharedBounds", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedBoundsImpl", "T", "parentTransition", "Landroidx/compose/animation/core/Transition;", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation_release", "state", "sharedElementWithCallerManagedVisibility", "skipToLookaheadSize", "toLookaheadCoordinates", "ShapeBasedClip", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedTransitionScopeImpl implements androidx.compose.animation.SharedTransitionScope, LookaheadScope {

    public static final int $stable;
    private final LookaheadScope $$delegate_0;
    private final CoroutineScope coroutineScope;
    private final MutableState isTransitionActive$delegate;
    private LayoutCoordinates nullableLookaheadRoot;
    private final Function0<Unit> observeAnimatingBlock;
    private final SnapshotStateList<androidx.compose.animation.LayerRenderer> renderers;
    public LayoutCoordinates root;
    private final MutableScatterMap<Object, androidx.compose.animation.SharedElement> sharedElements;
    private final Function1<androidx.compose.animation.SharedTransitionScope, Unit> updateTransitionActiveness;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "state", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ShapeBasedClip implements androidx.compose.animation.SharedTransitionScope.OverlayClip {

        private final Shape clipShape;
        private final Path path;
        public ShapeBasedClip(Shape clipShape) {
            super();
            this.clipShape = clipShape;
            this.path = AndroidPath_androidKt.Path();
        }

        @Override // androidx.compose.animation.SharedTransitionScope$OverlayClip
        public Path getClipPath(androidx.compose.animation.SharedTransitionScope.SharedContentState state, Rect bounds, LayoutDirection layoutDirection, Density density) {
            this.path.reset();
            final long size-NH-jbRc = bounds.getSize-NH-jbRc();
            OutlineKt.addOutline(this.path, this.clipShape.createOutline-Pq9zytI(size-NH-jbRc, obj3, layoutDirection));
            this.path.translate-k-4lQ0M(bounds.getTopLeft-F1C5BW0());
            return this.path;
        }

        @Override // androidx.compose.animation.SharedTransitionScope$OverlayClip
        public final Shape getClipShape() {
            return this.clipShape;
        }
    }
    static {
    }

    public SharedTransitionScopeImpl(LookaheadScope lookaheadScope, CoroutineScope coroutineScope) {
        super();
        this.coroutineScope = coroutineScope;
        this.$$delegate_0 = lookaheadScope;
        final int i = 0;
        final int i4 = 0;
        this.isTransitionActive$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i), i4, 2, i4);
        SharedTransitionScopeImpl.observeAnimatingBlock.1 anon = new SharedTransitionScopeImpl.observeAnimatingBlock.1(this);
        this.observeAnimatingBlock = (Function0)anon;
        SharedTransitionScopeImpl.updateTransitionActiveness.1 anon2 = new SharedTransitionScopeImpl.updateTransitionActiveness.1(this);
        this.updateTransitionActiveness = (Function1)anon2;
        this.renderers = SnapshotStateKt.mutableStateListOf();
        MutableScatterMap mutableScatterMap = new MutableScatterMap(i, 1, i4);
        this.sharedElements = mutableScatterMap;
    }

    public static final MutableScatterMap access$getSharedElements$p(androidx.compose.animation.SharedTransitionScopeImpl $this) {
        return $this.sharedElements;
    }

    public static final androidx.compose.animation.SharedElementInternalState access$rememberSharedElementState(androidx.compose.animation.SharedTransitionScopeImpl $this, androidx.compose.animation.SharedElement sharedElement, androidx.compose.animation.BoundsAnimation boundsAnimation, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderOnlyWhenVisible, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition, float zIndexInOverlay, boolean renderInOverlayDuringTransition, Composer $composer, int $changed) {
        return $this.rememberSharedElementState(sharedElement, boundsAnimation, placeHolderSize, renderOnlyWhenVisible, sharedContentState, clipInOverlayDuringTransition, zIndexInOverlay, renderInOverlayDuringTransition, $composer, $changed);
    }

    public static final androidx.compose.animation.SharedElement access$sharedElementsFor(androidx.compose.animation.SharedTransitionScopeImpl $this, Object key) {
        return $this.sharedElementsFor(key);
    }

    public static final void access$updateTransitionActiveness(androidx.compose.animation.SharedTransitionScopeImpl $this) {
        $this.updateTransitionActiveness();
    }

    private final androidx.compose.animation.SharedElementInternalState rememberSharedElementState(androidx.compose.animation.SharedElement sharedElement, androidx.compose.animation.BoundsAnimation boundsAnimation, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderOnlyWhenVisible, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition, float zIndexInOverlay, boolean renderInOverlayDuringTransition, Composer $composer, int $changed) {
        Object sharedElementInternalState;
        boolean traceInProgress;
        Object str2;
        String str;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize2;
        boolean z2;
        androidx.compose.animation.SharedTransitionScope.OverlayClip overlayClip;
        boolean z;
        androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState2;
        float f;
        int i;
        int i2;
        final Composer composer = $composer;
        int i3 = 2066772852;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(rememberSharedElementState)P(6!1,2,4,5!1,7)*1032@54440L467:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:1032)");
        } else {
            i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, -663265575, "CC(remember):SharedTransitionScope.kt#9igjgp");
        int i6 = 0;
        Composer composer2 = $composer;
        final int i7 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i8 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            i2 = 0;
            sharedElementInternalState = new SharedElementInternalState(sharedElement, boundsAnimation, placeHolderSize, renderOnlyWhenVisible, clipInOverlayDuringTransition, renderInOverlayDuringTransition, sharedContentState, zIndexInOverlay);
            composer2.updateRememberedValue(sharedElementInternalState);
        } else {
            sharedContentState2 = sharedContentState;
            sharedElementInternalState = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object obj = sharedElementInternalState;
        int i5 = 0;
        sharedContentState2.setInternalState$animation_release(obj);
        obj.setSharedElement(sharedElement);
        obj.setRenderOnlyWhenVisible(renderOnlyWhenVisible);
        obj.setBoundsAnimation(boundsAnimation);
        obj.setPlaceHolderSize(placeHolderSize);
        obj.setOverlayClip(clipInOverlayDuringTransition);
        obj.setZIndex(zIndexInOverlay);
        obj.setRenderInOverlayDuringTransition(renderInOverlayDuringTransition);
        obj.setUserState(sharedContentState2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (SharedElementInternalState)sharedElementInternalState;
    }

    private void setTransitionActive(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isTransitionActive$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final <T> Modifier sharedBoundsImpl(Modifier $this$sharedBoundsImpl, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState, Transition<T> parentTransition, Function1<? super T, Boolean> visible, androidx.compose.animation.BoundsTransform boundsTransform, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderOnlyWhenVisible, boolean renderInOverlayDuringTransition, float zIndexInOverlay, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition) {
        SharedTransitionScopeImpl.sharedBoundsImpl.1 anon = new SharedTransitionScopeImpl.sharedBoundsImpl.1(sharedContentState, parentTransition, visible, this, placeHolderSize, renderOnlyWhenVisible, clipInOverlayDuringTransition, zIndexInOverlay, renderInOverlayDuringTransition, boundsTransform);
        int i2 = 0;
        return ComposedModifierKt.composed$default($this$sharedBoundsImpl, i2, (Function3)anon, 1, i2);
    }

    static Modifier sharedBoundsImpl$default(androidx.compose.animation.SharedTransitionScopeImpl sharedTransitionScopeImpl, Modifier modifier2, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState3, Transition transition4, Function1 function15, androidx.compose.animation.BoundsTransform boundsTransform6, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize7, boolean z8, boolean z9, float f10, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip11, int i12, Object object13) {
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize contentSize;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize;
        if (i12 & 16 != 0) {
            placeHolderSize = contentSize;
        } else {
            placeHolderSize = placeHolderSize7;
        }
        return sharedTransitionScopeImpl.sharedBoundsImpl(modifier2, sharedContentState3, transition4, function15, boundsTransform6, placeHolderSize, z8, z9, f10, overlayClip11);
    }

    public static Modifier sharedBoundsWithCallerManagedVisibility$animation_release$default(androidx.compose.animation.SharedTransitionScopeImpl sharedTransitionScopeImpl, Modifier modifier2, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedTransitionScope$SharedContentState3, boolean z4, androidx.compose.animation.BoundsTransform boundsTransform5, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize sharedTransitionScope$PlaceHolderSize6, boolean z7, float f8, androidx.compose.animation.SharedTransitionScope.OverlayClip sharedTransitionScope$OverlayClip9, int i10, Object object11) {
        androidx.compose.animation.BoundsTransform boundsTransform;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize;
        int i2;
        int i;
        androidx.compose.animation.SharedTransitionScope.OverlayClip overlayClip;
        androidx.compose.animation.BoundsTransform obj13;
        androidx.compose.animation.SharedTransitionScope.PlaceHolderSize obj14;
        if (i10 & 4 != 0) {
            boundsTransform = obj13;
        } else {
            boundsTransform = boundsTransform5;
        }
        if (i10 & 8 != 0) {
            placeHolderSize = obj14;
        } else {
            placeHolderSize = placeHolderSize6;
        }
        i2 = i10 & 16 != 0 ? obj13 : z7;
        i = i10 & 32 != 0 ? obj13 : f8;
        if (i10 & 64 != 0) {
            overlayClip = obj13;
        } else {
            overlayClip = overlayClip9;
        }
        return sharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility$animation_release(modifier2, sharedContentState3, z4, boundsTransform, placeHolderSize, i2, i, overlayClip);
    }

    private final androidx.compose.animation.SharedElement sharedElementsFor(Object key) {
        Object sharedElement;
        androidx.compose.animation.SharedElement sharedElement2;
        int i;
        MutableScatterMap sharedElements;
        if ((SharedElement)this.sharedElements.get(key) == null) {
            sharedElement = new SharedElement(key, this);
            i = 0;
            this.sharedElements.set(key, sharedElement);
        }
        return sharedElement;
    }

    private final void updateTransitionActiveness() {
        int j$iv$iv2;
        int isActive2;
        int j$iv$iv;
        int sharedElements;
        int j$iv$iv$iv;
        boolean $i$f$isFull2;
        int index$iv$iv;
        int $i$f$isFull;
        MutableScatterMap map2;
        int keys;
        Object[] values;
        Object[] values2;
        MutableScatterMap map;
        int metadata2;
        long[] metadata;
        int i$iv$iv;
        int slot$iv$iv;
        int i$iv$iv$iv;
        int i5;
        long value$iv$iv$iv$iv;
        int isActive;
        long $this$maskEmptyOrDeleted$iv$iv$iv;
        Object this_$iv2;
        MutableScatterMap this_$iv;
        int slot$iv$iv2;
        int i3;
        int i4;
        Object cmp;
        Object obj;
        int i2;
        boolean element;
        int i;
        final Object obj2 = this;
        sharedElements = obj2.sharedElements;
        map2 = sharedElements;
        keys = 0;
        metadata2 = 0;
        metadata = map.metadata;
        length3 += -2;
        final int i32 = 7;
        final int i33 = 0;
        final long l = -9187201950435737472L;
        final int i34 = 128;
        i5 = 8;
        if (0 <= slot$iv$iv) {
        } else {
            this_$iv = sharedElements;
            slot$iv$iv2 = j$iv$iv$iv;
            i4 = 255;
            j$iv$iv2 = i33;
        }
        if (j$iv$iv2 != obj2.isTransitionActive()) {
            obj2.setTransitionActive(j$iv$iv2);
            if (j$iv$iv2 == 0) {
                $i$f$isFull2 = obj2.sharedElements;
                map2 = 0;
                map = 0;
                metadata2 = values2.metadata;
                length2 += -2;
                if (0 <= metadata) {
                } else {
                    isActive = j$iv$iv2;
                    $this$maskEmptyOrDeleted$iv$iv$iv = $i$f$isFull2;
                }
            } else {
                isActive = j$iv$iv2;
            }
        } else {
            isActive = j$iv$iv2;
        }
        isActive2 = obj2.sharedElements;
        int i28 = 0;
        long[] metadata3 = map3.metadata;
        length += -2;
        if (0 <= i29) {
        } else {
            this_$iv2 = isActive2;
            slot$iv$iv2 = index$iv$iv;
        }
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(obj2, obj2.updateTransitionActiveness, obj2.observeAnimatingBlock);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public androidx.compose.animation.SharedTransitionScope.OverlayClip OverlayClip(Shape clipShape) {
        SharedTransitionScopeImpl.ShapeBasedClip shapeBasedClip = new SharedTransitionScopeImpl.ShapeBasedClip(clipShape);
        return (SharedTransitionScope.OverlayClip)shapeBasedClip;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void drawInOverlay$animation_release(ContentDrawScope scope) {
        int size;
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        androidx.compose.ui.graphics.drawscope.DrawScope drawScope;
        SnapshotStateList renderers = this.renderers;
        int i2 = 0;
        if ((List)renderers.size() > 1) {
            size = new SharedTransitionScopeImpl.drawInOverlay$$inlined.sortBy.1();
            CollectionsKt.sortWith(renderers, (Comparator)size);
        }
        SnapshotStateList $this$sortBy$iv = this.renderers;
        int i3 = 0;
        index$iv = 0;
        while (index$iv < (List)$this$sortBy$iv.size()) {
            i = 0;
            (LayerRenderer)$this$sortBy$iv.get(index$iv).drawInOverlay((DrawScope)scope);
            index$iv++;
        }
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final LayoutCoordinates getLookaheadRoot$animation_release() {
        LayoutCoordinates nullableLookaheadRoot = this.nullableLookaheadRoot;
        if (nullableLookaheadRoot == null) {
        } else {
            return nullableLookaheadRoot;
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placeable$PlacementScope) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(placementScope);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final LayoutCoordinates getNullableLookaheadRoot$animation_release() {
        return this.nullableLookaheadRoot;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final LayoutCoordinates getRoot$animation_release() {
        LayoutCoordinates root = this.root;
        if (root != null) {
            return root;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean isTransitionActive() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isTransitionActive$delegate.getValue().booleanValue();
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public long localLookaheadPositionOf-au-aQtc(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long l3, boolean z4) {
        return this.$$delegate_0.localLookaheadPositionOf-au-aQtc(layoutCoordinates, layoutCoordinates2, l3, obj4);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void onLayerRendererCreated$animation_release(androidx.compose.animation.LayerRenderer renderer) {
        this.renderers.add(renderer);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void onLayerRendererRemoved$animation_release(androidx.compose.animation.LayerRenderer renderer) {
        this.renderers.remove(renderer);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void onStateAdded$animation_release(androidx.compose.animation.SharedElementInternalState sharedElementState) {
        SnapshotStateList renderers;
        int i3;
        int index$iv;
        Object next;
        int i2;
        Object obj;
        int i;
        boolean equal;
        Object obj2;
        int sharedElement;
        final androidx.compose.animation.SharedElement sharedElement2 = sharedElementState.getSharedElement();
        final int i4 = 0;
        sharedElement2.addState(sharedElementState);
        this.updateTransitionActiveness.invoke(this);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(sharedElement2.getScope(), this.updateTransitionActiveness, this.observeAnimatingBlock);
        i3 = 0;
        index$iv = 0;
        Iterator iterator = (List)this.renderers.iterator();
        i2 = -1;
        while (iterator.hasNext()) {
            obj = next;
            i = 0;
            if (obj instanceof SharedElementInternalState) {
            } else {
            }
            obj2 = sharedElement;
            if (obj2 != null) {
            }
            index$iv++;
            i2 = -1;
            sharedElement = obj2.getSharedElement();
            obj2 = obj;
        }
        index$iv = i2;
        if (index$iv != size--) {
            if (index$iv == i2) {
                this.renderers.add(sharedElementState);
            } else {
                this.renderers.add(index$iv + 1, sharedElementState);
            }
        } else {
        }
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void onStateRemoved$animation_release(androidx.compose.animation.SharedElementInternalState sharedElementState) {
        boolean empty;
        Object coroutineScope;
        Function1 updateTransitionActiveness;
        Function0 observeAnimatingBlock;
        androidx.compose.animation.SharedTransitionScopeImpl.onStateRemoved.1.1 anon;
        int i2;
        int i;
        final androidx.compose.animation.SharedElement sharedElement = sharedElementState.getSharedElement();
        final int i3 = 0;
        sharedElement.removeState(sharedElementState);
        this.updateTransitionActiveness.invoke(this);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(sharedElement.getScope(), this.updateTransitionActiveness, this.observeAnimatingBlock);
        this.renderers.remove(sharedElementState);
        if (sharedElement.getStates().isEmpty()) {
            updateTransitionActiveness = 0;
            empty = new SharedTransitionScopeImpl.onStateRemoved.1.1(sharedElement, updateTransitionActiveness);
            BuildersKt.launch$default(scope.coroutineScope, updateTransitionActiveness, 0, (Function2)empty, 3, 0);
        }
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public androidx.compose.animation.SharedTransitionScope.SharedContentState rememberSharedContentState(Object key, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object sharedContentState;
        int i = 799702514;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(rememberSharedContentState)912@49465L53:SharedTransitionScope.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedContentState (SharedTransitionScope.kt:912)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 935469886, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Composer composer = $composer;
        int i3 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i4 = 0;
        if (!$composer.changed(key)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                sharedContentState = new SharedTransitionScope.SharedContentState(key);
                composer.updateRememberedValue(sharedContentState);
            } else {
                sharedContentState = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return (SharedTransitionScope.SharedContentState)sharedContentState;
    }

    public Modifier renderInSharedTransitionScopeOverlay(Modifier $this$renderInSharedTransitionScopeOverlay, Function0<Boolean> renderInOverlay, float zIndexInOverlay, Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlayDuringTransition) {
        RenderInTransitionOverlayNodeElement renderInTransitionOverlayNodeElement = new RenderInTransitionOverlayNodeElement(this, renderInOverlay, zIndexInOverlay, clipInOverlayDuringTransition);
        return $this$renderInSharedTransitionScopeOverlay.then((Modifier)renderInTransitionOverlayNodeElement);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void setNullableLookaheadRoot$animation_release(LayoutCoordinates <set-?>) {
        this.nullableLookaheadRoot = <set-?>;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final void setRoot$animation_release(LayoutCoordinates <set-?>) {
        this.root = <set-?>;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedBounds(Modifier $this$sharedBounds, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState, androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, androidx.compose.animation.BoundsTransform boundsTransform, androidx.compose.animation.SharedTransitionScope.ResizeMode resizeMode, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderInOverlayDuringTransition, float zIndexInOverlay, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition) {
        SharedTransitionScopeImpl.sharedBounds.2 anon2 = new SharedTransitionScopeImpl.sharedBounds.2(animatedVisibilityScope, enter, exit, sharedContentState, resizeMode);
        int i2 = 0;
        return ComposedModifierKt.composed$default(this.sharedBoundsImpl($this$sharedBounds, sharedContentState, animatedVisibilityScope.getTransition(), (Function1)SharedTransitionScopeImpl.sharedBounds.1.INSTANCE, boundsTransform, placeHolderSize, false, renderInOverlayDuringTransition, zIndexInOverlay, clipInOverlayDuringTransition), i2, (Function3)anon2, 1, i2);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final Modifier sharedBoundsWithCallerManagedVisibility$animation_release(Modifier $this$sharedBoundsWithCallerManagedVisibility, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState, boolean visible, androidx.compose.animation.BoundsTransform boundsTransform, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderInOverlayDuringTransition, float zIndexInOverlay, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition) {
        SharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility.1 anon = new SharedTransitionScopeImpl.sharedBoundsWithCallerManagedVisibility.1(visible);
        return this.sharedBoundsImpl($this$sharedBoundsWithCallerManagedVisibility, sharedContentState, 0, (Function1)anon, boundsTransform, placeHolderSize, false, renderInOverlayDuringTransition, zIndexInOverlay, clipInOverlayDuringTransition);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElement(Modifier $this$sharedElement, androidx.compose.animation.SharedTransitionScope.SharedContentState state, androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope, androidx.compose.animation.BoundsTransform boundsTransform, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderInOverlayDuringTransition, float zIndexInOverlay, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition) {
        return this.sharedBoundsImpl($this$sharedElement, state, animatedVisibilityScope.getTransition(), (Function1)SharedTransitionScopeImpl.sharedElement.1.INSTANCE, boundsTransform, placeHolderSize, true, renderInOverlayDuringTransition, zIndexInOverlay, clipInOverlayDuringTransition);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElementWithCallerManagedVisibility(Modifier $this$sharedElementWithCallerManagedVisibility, androidx.compose.animation.SharedTransitionScope.SharedContentState sharedContentState, boolean visible, androidx.compose.animation.BoundsTransform boundsTransform, androidx.compose.animation.SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean renderInOverlayDuringTransition, float zIndexInOverlay, androidx.compose.animation.SharedTransitionScope.OverlayClip clipInOverlayDuringTransition) {
        SharedTransitionScopeImpl.sharedElementWithCallerManagedVisibility.1 anon = new SharedTransitionScopeImpl.sharedElementWithCallerManagedVisibility.1(visible);
        return this.sharedBoundsImpl($this$sharedElementWithCallerManagedVisibility, sharedContentState, 0, (Function1)anon, boundsTransform, placeHolderSize, true, renderInOverlayDuringTransition, zIndexInOverlay, clipInOverlayDuringTransition);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier skipToLookaheadSize(Modifier $this$skipToLookaheadSize) {
        final int i = 0;
        SkipToLookaheadElement skipToLookaheadElement = new SkipToLookaheadElement(i, i, 3, i);
        return $this$skipToLookaheadSize.then((Modifier)skipToLookaheadElement);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
        return this.$$delegate_0.toLookaheadCoordinates(layoutCoordinates);
    }
}
