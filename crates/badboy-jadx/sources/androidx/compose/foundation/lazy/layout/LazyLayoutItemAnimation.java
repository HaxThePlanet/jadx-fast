package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010C\u001a\u00020\u0008J\u0006\u0010D\u001a\u00020\u0008J \u0010E\u001a\u00020\u00082\u0006\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ\u0006\u0010J\u001a\u00020\u0008J\u0006\u0010K\u001a\u00020\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u000e\"\u0004\u0008\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008!\u0010\"\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R+\u0010#\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008%\u0010\"\u001a\u0004\u0008#\u0010\u001e\"\u0004\u0008$\u0010 R+\u0010&\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008(\u0010\"\u001a\u0004\u0008&\u0010\u001e\"\u0004\u0008'\u0010 R+\u0010)\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008+\u0010\"\u001a\u0004\u0008)\u0010\u001e\"\u0004\u0008*\u0010 R\u001e\u0010,\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001eR\"\u0010.\u001a\u0004\u0018\u00010-2\u0008\u0010\u001b\u001a\u0004\u0018\u00010-@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\"\u00101\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\u00082\u0010\u0017\"\u0004\u00083\u0010\u0019R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R1\u00104\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00158F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00087\u0010\"\u001a\u0004\u00085\u0010\u0017\"\u0004\u00086\u0010\u0019R\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010\u000e\"\u0004\u0008=\u0010\u0010R\"\u0010>\u001a\u00020\u0015X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\u0008?\u0010\u0017\"\u0004\u0008@\u0010\u0019R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020B09X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006M", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "onLayerPropertyChanged", "Lkotlin/Function0;", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "finalOffset", "Landroidx/compose/ui/unit/IntOffset;", "getFinalOffset-nOcc-ac", "()J", "setFinalOffset--gyyYBs", "(J)V", "J", "<set-?>", "", "isAppearanceAnimationInProgress", "()Z", "setAppearanceAnimationInProgress", "(Z)V", "isAppearanceAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "isDisappearanceAnimationFinished$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "isPlacementAnimationInProgress$delegate", "isRunningMovingAwayAnimation", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "placementSpec", "getPlacementSpec", "setPlacementSpec", "rawOffset", "getRawOffset-nOcc-ac", "setRawOffset--gyyYBs", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "animateAppearance", "animateDisappearance", "animatePlacementDelta", "delta", "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "cancelPlacementAnimation", "release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutItemAnimation {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.Companion Companion;
    private static final long NotInitialized;
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;
    private final MutableState isAppearanceAnimationInProgress$delegate;
    private final MutableState isDisappearanceAnimationFinished$delegate;
    private final MutableState isDisappearanceAnimationInProgress$delegate;
    private final MutableState isPlacementAnimationInProgress$delegate;
    private boolean isRunningMovingAwayAnimation;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0<Unit> onLayerPropertyChanged;
    private final MutableState placementDelta$delegate;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getNotInitialized-nOcc-ac() {
            return LazyLayoutItemAnimation.access$getNotInitialized$cp();
        }
    }
    static {
        LazyLayoutItemAnimation.Companion companion = new LazyLayoutItemAnimation.Companion(0);
        LazyLayoutItemAnimation.Companion = companion;
        int i = 8;
        int i2 = Integer.MAX_VALUE;
        LazyLayoutItemAnimation.NotInitialized = IntOffsetKt.IntOffset(i2, i2);
    }

    public LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext, Function0<Unit> onLayerPropertyChanged) {
        GraphicsLayer graphicsLayer;
        super();
        this.coroutineScope = coroutineScope;
        this.graphicsContext = graphicsContext;
        this.onLayerPropertyChanged = onLayerPropertyChanged;
        Boolean valueOf = false;
        final int i3 = 0;
        final int i4 = 2;
        this.isPlacementAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.isAppearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.isDisappearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.isDisappearanceAnimationFinished$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.rawOffset = LazyLayoutItemAnimation.NotInitialized;
        this.finalOffset = IntOffset.Companion.getZero-nOcc-ac();
        GraphicsContext graphicsContext2 = this.graphicsContext;
        if (graphicsContext2 != null) {
            graphicsLayer = graphicsContext2.createGraphicsLayer();
        } else {
            graphicsLayer = i3;
        }
        this.layer = graphicsLayer;
        final int i6 = 0;
        Animatable animatable = new Animatable(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), VectorConvertersKt.getVectorConverter(IntOffset.Companion), 0, i6, 12, 0);
        this.placementDeltaAnimation = animatable;
        Animatable animatable2 = new Animatable(1f, VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), i6, 0, 12, 0);
        this.visibilityAnimation = animatable2;
        this.placementDelta$delegate = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), i3, i4, i3);
        this.lookaheadOffset = LazyLayoutItemAnimation.NotInitialized;
    }

    public LazyLayoutItemAnimation(CoroutineScope coroutineScope, GraphicsContext graphicsContext2, Function0 function03, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.1 obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        if (i4 &= 4 != 0) {
            obj3 = LazyLayoutItemAnimation.1.INSTANCE;
        }
        super(coroutineScope, obj2, obj3);
    }

    public static final long access$getNotInitialized$cp() {
        return LazyLayoutItemAnimation.NotInitialized;
    }

    public static final Function0 access$getOnLayerPropertyChanged$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this) {
        return $this.onLayerPropertyChanged;
    }

    public static final Animatable access$getPlacementDeltaAnimation$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this) {
        return $this.placementDeltaAnimation;
    }

    public static final Animatable access$getVisibilityAnimation$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this) {
        return $this.visibilityAnimation;
    }

    public static final void access$setAppearanceAnimationInProgress(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this, boolean <set-?>) {
        $this.setAppearanceAnimationInProgress(<set-?>);
    }

    public static final void access$setDisappearanceAnimationFinished(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this, boolean <set-?>) {
        $this.setDisappearanceAnimationFinished(<set-?>);
    }

    public static final void access$setDisappearanceAnimationInProgress(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this, boolean <set-?>) {
        $this.setDisappearanceAnimationInProgress(<set-?>);
    }

    public static final void access$setPlacementAnimationInProgress(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this, boolean <set-?>) {
        $this.setPlacementAnimationInProgress(<set-?>);
    }

    public static final void access$setPlacementDelta--gyyYBs(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this, long <set-?>) {
        $this.setPlacementDelta--gyyYBs(<set-?>);
    }

    public static final void access$setRunningMovingAwayAnimation$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation $this, boolean <set-?>) {
        $this.isRunningMovingAwayAnimation = <set-?>;
    }

    private final void setAppearanceAnimationInProgress(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isAppearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setDisappearanceAnimationFinished(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isDisappearanceAnimationFinished$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setDisappearanceAnimationInProgress(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isDisappearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setPlacementAnimationInProgress(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isPlacementAnimationInProgress$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setPlacementDelta--gyyYBs(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.placementDelta$delegate.setValue(IntOffset.box-impl(<set-?>));
    }

    public final void animateAppearance() {
        int i4;
        int disappearanceAnimationInProgress;
        int i3;
        Object obj;
        CoroutineScope coroutineScope;
        int i5;
        int i6;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.animateAppearance.1 anon;
        int i;
        int i2;
        final GraphicsLayer layer = this.layer;
        final FiniteAnimationSpec fadeInSpec = this.fadeInSpec;
        if (!isAppearanceAnimationInProgress() && fadeInSpec != null) {
            if (fadeInSpec != null) {
                if (layer == null) {
                    obj = this;
                    if (isDisappearanceAnimationInProgress()) {
                        if (layer == null) {
                        } else {
                            layer.setAlpha(1065353216);
                        }
                        disappearanceAnimationInProgress = new LazyLayoutItemAnimation.animateAppearance.1(this, 0);
                        BuildersKt.launch$default(obj.coroutineScope, 0, 0, (Function2)disappearanceAnimationInProgress, 3, 0);
                    }
                } else {
                    i4 = 1;
                    setAppearanceAnimationInProgress(i4);
                    disappearanceAnimationInProgress2 ^= i4;
                    if (i7 != 0) {
                        layer.setAlpha(0);
                    }
                }
                LazyLayoutItemAnimation.animateAppearance.2 anon2 = new LazyLayoutItemAnimation.animateAppearance.2(i7, this, fadeInSpec, layer, 0);
                BuildersKt.launch$default(this.coroutineScope, 0, 0, (Function2)anon2, 3, 0);
            }
        }
        obj = this;
    }

    public final void animateDisappearance() {
        boolean disappearanceAnimationInProgress;
        final GraphicsLayer layer = this.layer;
        final FiniteAnimationSpec fadeOutSpec = this.fadeOutSpec;
        if (layer != null && !isDisappearanceAnimationInProgress() && fadeOutSpec == null) {
            if (!isDisappearanceAnimationInProgress()) {
                if (fadeOutSpec == null) {
                }
                setDisappearanceAnimationInProgress(true);
                final int i2 = 0;
                LazyLayoutItemAnimation.animateDisappearance.1 anon = new LazyLayoutItemAnimation.animateDisappearance.1(this, fadeOutSpec, layer, i2);
                BuildersKt.launch$default(this.coroutineScope, i2, 0, (Function2)anon, 3, 0);
            }
        }
    }

    public final void animatePlacementDelta-ar5cAso(long delta, boolean isMovingAway) {
        FiniteAnimationSpec placementSpec = this.placementSpec;
        if (placementSpec == null) {
        }
        final long minus-qkQi6aY = IntOffset.minus-qkQi6aY(getPlacementDelta-nOcc-ac(), obj1);
        setPlacementDelta--gyyYBs(minus-qkQi6aY);
        setPlacementAnimationInProgress(true);
        this.isRunningMovingAwayAnimation = obj15;
        LazyLayoutItemAnimation.animatePlacementDelta.1 anon = new LazyLayoutItemAnimation.animatePlacementDelta.1(this, placementSpec, minus-qkQi6aY, obj5, 0);
        BuildersKt.launch$default(this.coroutineScope, 0, 0, (Function2)anon, 3, 0);
    }

    public final void cancelPlacementAnimation() {
        boolean placementAnimationInProgress;
        CoroutineScope coroutineScope;
        int i4;
        int i3;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.cancelPlacementAnimation.1 anon;
        int i;
        int i2;
        if (isPlacementAnimationInProgress()) {
            i4 = 0;
            placementAnimationInProgress = new LazyLayoutItemAnimation.cancelPlacementAnimation.1(this, i4);
            BuildersKt.launch$default(this.coroutineScope, i4, 0, (Function2)placementAnimationInProgress, 3, 0);
        }
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    public final long getFinalOffset-nOcc-ac() {
        return this.finalOffset;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    public final long getLookaheadOffset-nOcc-ac() {
        return this.lookaheadOffset;
    }

    public final long getPlacementDelta-nOcc-ac() {
        final int i = 0;
        final int i2 = 0;
        return (IntOffset)(State)this.placementDelta$delegate.getValue().unbox-impl();
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    public final long getRawOffset-nOcc-ac() {
        return this.rawOffset;
    }

    public final boolean isAppearanceAnimationInProgress() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isAppearanceAnimationInProgress$delegate.getValue().booleanValue();
    }

    public final boolean isDisappearanceAnimationFinished() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isDisappearanceAnimationFinished$delegate.getValue().booleanValue();
    }

    public final boolean isDisappearanceAnimationInProgress() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isDisappearanceAnimationInProgress$delegate.getValue().booleanValue();
    }

    public final boolean isPlacementAnimationInProgress() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isPlacementAnimationInProgress$delegate.getValue().booleanValue();
    }

    public final boolean isRunningMovingAwayAnimation() {
        return this.isRunningMovingAwayAnimation;
    }

    public final void release() {
        boolean placementAnimationInProgress;
        boolean appearanceAnimationInProgress;
        boolean disappearanceAnimationInProgress;
        int i2;
        CoroutineScope graphicsContext;
        int i3;
        int i;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.release.1 anon;
        int i5;
        int i4;
        i2 = 0;
        final int i6 = 0;
        if (isPlacementAnimationInProgress()) {
            setPlacementAnimationInProgress(i2);
            placementAnimationInProgress = new LazyLayoutItemAnimation.release.1(this, i6);
            BuildersKt.launch$default(this.coroutineScope, 0, 0, (Function2)placementAnimationInProgress, 3, 0);
        }
        if (isAppearanceAnimationInProgress()) {
            setAppearanceAnimationInProgress(i2);
            appearanceAnimationInProgress = new LazyLayoutItemAnimation.release.2(this, i6);
            BuildersKt.launch$default(this.coroutineScope, 0, 0, (Function2)appearanceAnimationInProgress, 3, 0);
        }
        if (isDisappearanceAnimationInProgress()) {
            setDisappearanceAnimationInProgress(i2);
            disappearanceAnimationInProgress = new LazyLayoutItemAnimation.release.3(this, i6);
            BuildersKt.launch$default(this.coroutineScope, 0, 0, (Function2)disappearanceAnimationInProgress, 3, 0);
        }
        this.isRunningMovingAwayAnimation = i2;
        setPlacementDelta--gyyYBs(IntOffset.Companion.getZero-nOcc-ac());
        this.rawOffset = LazyLayoutItemAnimation.NotInitialized;
        GraphicsLayer layer = this.layer;
        i2 = 0;
        graphicsContext = this.graphicsContext;
        if (layer != null && graphicsContext != null) {
            i2 = 0;
            graphicsContext = this.graphicsContext;
            if (graphicsContext != null) {
                graphicsContext.releaseGraphicsLayer(layer);
            }
        }
        this.layer = i6;
        this.fadeInSpec = i6;
        this.fadeOutSpec = i6;
        this.placementSpec = i6;
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> <set-?>) {
        this.fadeInSpec = <set-?>;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> <set-?>) {
        this.fadeOutSpec = <set-?>;
    }

    public final void setFinalOffset--gyyYBs(long <set-?>) {
        this.finalOffset = <set-?>;
    }

    public final void setLookaheadOffset--gyyYBs(long <set-?>) {
        this.lookaheadOffset = <set-?>;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> <set-?>) {
        this.placementSpec = <set-?>;
    }

    public final void setRawOffset--gyyYBs(long <set-?>) {
        this.rawOffset = <set-?>;
    }
}
