package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001aQ\u0010\u000b\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122#\u0008\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001aQ\u0010\u0019\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122#\u0008\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0007\u001aQ\u0010\u001d\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122#\u0008\u0002\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a\"\u0010!\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000e2\u0008\u0008\u0002\u0010\"\u001a\u00020\u0002H\u0007\u001a\"\u0010#\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000e2\u0008\u0008\u0002\u0010%\u001a\u00020\u0002H\u0007\u001a6\u0010&\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000e2\u0008\u0008\u0002\u0010'\u001a\u00020\u00022\u0008\u0008\u0002\u0010(\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a6\u0010+\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000e2\u0008\u0008\u0002\u0010,\u001a\u00020\u00022\u0008\u0008\u0002\u0010(\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001aQ\u0010/\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000e2\u0008\u0008\u0002\u00100\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122#\u0008\u0002\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001aQ\u00102\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000e2\u0008\u0008\u0002\u00100\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122#\u0008\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0007\u001aQ\u00104\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000e2\u0008\u0008\u0002\u00100\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122#\u0008\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a;\u00106\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a=\u00108\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e2#\u0008\u0002\u00109\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a=\u0010:\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e2#\u0008\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a;\u0010<\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a=\u0010>\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e2#\u0008\u0002\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a=\u0010@\u001a\u00020$2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e2#\u0008\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a/\u0010B\u001a\u00020C*\u0008\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\u000c2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0003¢\u0006\u0002\u0010J\u001a?\u0010K\u001a\u00020L*\u0008\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\u000c2\u0006\u0010G\u001a\u00020$2\u000e\u0008\u0002\u0010M\u001a\u0008\u0012\u0004\u0012\u00020\u00120N2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\u0010O\u001a,\u0010P\u001a\u0004\u0018\u0001HQ\"\u0008\u0008\u0000\u0010Q*\u00020R*\u00020\u000c2\u000c\u0010S\u001a\u0008\u0012\u0004\u0012\u0002HQ0TH\u0080\u0002¢\u0006\u0002\u0010U\u001a,\u0010P\u001a\u0004\u0018\u0001HQ\"\u0008\u0008\u0000\u0010Q*\u00020R*\u00020$2\u000c\u0010S\u001a\u0008\u0012\u0004\u0012\u0002HQ0TH\u0080\u0002¢\u0006\u0002\u0010V\u001a\u000c\u0010W\u001a\u00020\u001a*\u00020\u0010H\u0002\u001a\u000c\u0010W\u001a\u00020\u001a*\u00020\u001eH\u0002\u001a\u001f\u0010X\u001a\u00020\u000c*\u0008\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\u000cH\u0001¢\u0006\u0002\u0010Y\u001a\u001f\u0010Z\u001a\u00020$*\u0008\u0012\u0004\u0012\u00020E0D2\u0006\u0010G\u001a\u00020$H\u0001¢\u0006\u0002\u0010[\u001a\u0015\u0010\\\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010]\u001a\u00020RH\u0080\u0004\u001a\u0015\u0010\\\u001a\u00020$*\u00020$2\u0006\u0010]\u001a\u00020RH\u0080\u0004\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006^²\u0006\n\u0010_\u001a\u00020\u000cX\u008a\u008e\u0002²\u0006\n\u0010`\u001a\u00020$X\u008a\u008e\u0002", d2 = {"DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createModifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "get", "T", "Landroidx/compose/animation/TransitionEffect;", "key", "Landroidx/compose/animation/TransitionEffectKey;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "toAlignment", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "withEffect", "effect", "animation_release", "activeEnter", "activeExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EnterExitTransitionKt {

    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring;
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec;
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec;
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter;
    public static Function1 $r8$lambda$GEMmNwaA6iO1ANzb7W_coQ_F-Iw(Transition.DeferredAnimation transition$DeferredAnimation, Transition.DeferredAnimation transition$DeferredAnimation2, Transition transition3, androidx.compose.animation.EnterTransition enterTransition4, androidx.compose.animation.ExitTransition exitTransition5, Transition.DeferredAnimation transition$DeferredAnimation6) {
        return EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(deferredAnimation, deferredAnimation2, transition3, enterTransition4, exitTransition5, deferredAnimation6);
    }

    static {
        EnterExitTransitionKt.TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter((Function1)EnterExitTransitionKt.TransformOriginVectorConverter.1.INSTANCE, (Function1)EnterExitTransitionKt.TransformOriginVectorConverter.2.INSTANCE);
        int i2 = 0;
        final int i3 = 1137180672;
        final int i4 = 0;
        EnterExitTransitionKt.DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(i2, i3, i4, 5, i4);
        int i5 = 1;
        EnterExitTransitionKt.DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(i2, i3, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), i5, i4);
        EnterExitTransitionKt.DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(i2, i3, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i5, i4);
    }

    public static final SpringSpec access$getDefaultAlphaAndScaleSpring$p() {
        return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
    }

    public static final SpringSpec access$getDefaultOffsetAnimationSpec$p() {
        return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
    }

    public static final SpringSpec access$getDefaultSizeAnimationSpec$p() {
        return EnterExitTransitionKt.DefaultSizeAnimationSpec;
    }

    private static final androidx.compose.animation.GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(Transition<androidx.compose.animation.EnterExitState> $this$createGraphicsLayerBlock, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Composer $composer, int $changed) {
        Object obj5;
        Object empty;
        androidx.compose.animation.Fade fade;
        int i4;
        int i3;
        int i5;
        int i6;
        Transition transition2;
        androidx.compose.animation.Scale scale;
        boolean transformOriginVectorConverter;
        String $this$cache$iv;
        Object obj4;
        int i8;
        int i;
        Object obj6;
        int changed;
        int i2;
        Object transition;
        Object string;
        String str;
        boolean changed2;
        Object deferredAnimation;
        int empty2;
        Object append;
        int companion;
        androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        int i9;
        int i7;
        int i10;
        int i11;
        Object obj;
        Object obj3;
        Object obj2;
        Transition.DeferredAnimation deferredAnimation3;
        Transition.DeferredAnimation deferredAnimation2;
        empty = label;
        final Composer composer3 = $composer;
        final int i40 = $changed;
        int i13 = 642253525;
        ComposerKt.sourceInformationMarkerStart(composer3, i13, "C(createGraphicsLayerBlock)985@42946L2853:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i13, i40, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:958)");
        }
        if (enter.getData$animation_release().getFade() == null) {
            if (exit.getData$animation_release().getFade() != null) {
                i4 = 1;
            } else {
                i4 = 0;
            }
        } else {
        }
        if (enter.getData$animation_release().getScale() == null) {
            if (exit.getData$animation_release().getScale() != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
        } else {
        }
        final int i44 = i3;
        changed2 = "CC(remember):EnterExitTransition.kt#9igjgp";
        if (i4 != 0) {
            composer3.startReplaceGroup(-675389204);
            ComposerKt.sourceInformation(composer3, "968@42460L27,967@42377L120");
            ComposerKt.sourceInformationMarkerStart(composer3, -1545804535, changed2);
            int i22 = 0;
            Composer composer2 = $composer;
            int i36 = 0;
            Object rememberedValue2 = composer2.rememberedValue();
            empty2 = 0;
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                append = 0;
                StringBuilder stringBuilder = new StringBuilder();
                composer2.updateRememberedValue(stringBuilder.append(empty).append(" alpha").toString());
            } else {
                string = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endReplaceGroup();
            i9 = transformOriginVectorConverter;
        } else {
            composer3.startReplaceGroup(-675252433);
            composer3.endReplaceGroup();
            i9 = 0;
        }
        int i41 = i9;
        if (i44 != 0) {
            composer3.startReplaceGroup(-675193780);
            ComposerKt.sourceInformation(composer3, "974@42657L27,973@42574L120");
            ComposerKt.sourceInformationMarkerStart(composer3, -1545798231, changed2);
            int i18 = 0;
            Composer composer = $composer;
            int i35 = 0;
            Object rememberedValue = composer.rememberedValue();
            str = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty2 = 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                composer.updateRememberedValue(stringBuilder2.append(empty).append(" scale").toString());
            } else {
                deferredAnimation = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endReplaceGroup();
            i10 = transformOriginVectorConverter;
        } else {
            composer3.startReplaceGroup(-675057009);
            composer3.endReplaceGroup();
            i10 = 0;
        }
        int i42 = i10;
        if (i44 != 0) {
            composer3.startReplaceGroup(-674987940);
            ComposerKt.sourceInformation(composer3, "979@42781L136");
            composer3.endReplaceGroup();
            deferredAnimation3 = deferredAnimation;
        } else {
            composer3.startReplaceGroup(-674835793);
            composer3.endReplaceGroup();
            deferredAnimation3 = 0;
        }
        Transition.DeferredAnimation deferredAnimation4 = deferredAnimation3;
        ComposerKt.sourceInformationMarkerStart(composer3, -1545786157, changed2);
        int i32 = 32;
        if (i30 ^= 48 > i32) {
            if (!composer3.changed(enter)) {
                i = i40 & 48 == i32 ? 1 : 0;
            } else {
            }
        } else {
            obj4 = enter;
        }
        int i37 = 256;
        if (i33 ^= 384 > i37) {
            if (!composer3.changed(exit)) {
                i2 = i40 & 384 == i37 ? 1 : 0;
            } else {
            }
        } else {
            obj6 = exit;
        }
        int i45 = 4;
        if (i38 ^= 6 > i45) {
            if (!composer3.changed($this$createGraphicsLayerBlock)) {
                companion = i40 & 6 == i45 ? 1 : 0;
            } else {
            }
        } else {
            transition = $this$createGraphicsLayerBlock;
        }
        Composer composer4 = $composer;
        int i46 = 0;
        Object rememberedValue3 = composer4.rememberedValue();
        int i47 = 0;
        if (i28 |= changedInstance3 == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                int i12 = 0;
                externalSyntheticLambda0 = new EnterExitTransitionKt$$ExternalSyntheticLambda0(i41, i42, transition, obj4, obj6, deferredAnimation4);
                composer4.updateRememberedValue(externalSyntheticLambda0);
            } else {
                deferredAnimation2 = deferredAnimation4;
                i7 = i41;
                i11 = i42;
                obj5 = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        return (GraphicsLayerBlockForEnterExit)obj5;
    }

    private static final Function1 createGraphicsLayerBlock$lambda$13$lambda$12(Transition.DeferredAnimation $alphaAnimation, Transition.DeferredAnimation $scaleAnimation, Transition $this_createGraphicsLayerBlock, androidx.compose.animation.EnterTransition $enter, androidx.compose.animation.ExitTransition $exit, Transition.DeferredAnimation $transformOriginAnimation) {
        int animate;
        State animate2;
        androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock.1.1.alpha.2 anon2;
        State animate3;
        androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock.1.1.scale.2 anon;
        int box-impl;
        androidx.compose.animation.Scale scale2;
        androidx.compose.animation.Scale scale;
        Object preEnter;
        animate = 0;
        if ($alphaAnimation != null) {
            EnterExitTransitionKt.createGraphicsLayerBlock.1.1.alpha.1 anon3 = new EnterExitTransitionKt.createGraphicsLayerBlock.1.1.alpha.1($enter, $exit);
            anon2 = new EnterExitTransitionKt.createGraphicsLayerBlock.1.1.alpha.2($enter, $exit);
            animate2 = $alphaAnimation.animate((Function1)anon3, (Function1)anon2);
        } else {
            animate2 = animate;
        }
        if ($scaleAnimation != null) {
            EnterExitTransitionKt.createGraphicsLayerBlock.1.1.scale.1 anon4 = new EnterExitTransitionKt.createGraphicsLayerBlock.1.1.scale.1($enter, $exit);
            anon = new EnterExitTransitionKt.createGraphicsLayerBlock.1.1.scale.2($enter, $exit);
            animate3 = $scaleAnimation.animate((Function1)anon4, (Function1)anon);
        } else {
            animate3 = animate;
        }
        preEnter = EnterExitState.PreEnter;
        if ($this_createGraphicsLayerBlock.getCurrentState() == preEnter) {
            if ($enter.getData$animation_release().getScale() != null) {
                box-impl = TransformOrigin.box-impl(scale.getTransformOrigin-SzJe1aQ());
            } else {
            }
        } else {
            if ($exit.getData$animation_release().getScale() != null) {
                box-impl = TransformOrigin.box-impl(scale2.getTransformOrigin-SzJe1aQ());
            } else {
            }
        }
        if ($transformOriginAnimation != null) {
            preEnter = new EnterExitTransitionKt.createGraphicsLayerBlock.1.1.transformOrigin.2(box-impl, $enter, $exit);
            animate = $transformOriginAnimation.animate((Function1)EnterExitTransitionKt.createGraphicsLayerBlock.1.1.transformOrigin.1.INSTANCE, (Function1)preEnter);
        }
        EnterExitTransitionKt.createGraphicsLayerBlock.1.1.block.1 anon5 = new EnterExitTransitionKt.createGraphicsLayerBlock.1.1.block.1(animate2, animate3, animate);
        return (Function1)anon5;
    }

    public static final Modifier createModifier(Transition<androidx.compose.animation.EnterExitState> $this$createModifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, Function0<Boolean> isEnabled, String label, Composer $composer, int $changed, int i8) {
        Object string2;
        Transition transition2;
        Object string3;
        Transition transition3;
        Object string;
        Transition transition;
        int i;
        int i5;
        Object empty2;
        Object anon;
        androidx.compose.animation.ChangeSize changeSize3;
        androidx.compose.animation.ChangeSize changeSize;
        int i7;
        int i6;
        String deferredAnimation;
        Object vectorConverter2;
        Object vectorConverter;
        androidx.compose.animation.ChangeSize changeSize2;
        androidx.compose.animation.Slide slide;
        int iNSTANCE;
        boolean traceInProgress;
        Object i2;
        Transition.DeferredAnimation $this$cache$iv;
        String str2;
        Transition.DeferredAnimation deferredAnimation3;
        int i3;
        int changed;
        androidx.compose.animation.EnterExitTransitionKt.createModifier.1 anon2;
        String str;
        int i4;
        Object empty;
        Transition.DeferredAnimation deferredAnimation2;
        int i9;
        int companion2;
        String companion;
        TwoWayConverter twoWayConverter;
        int obj25;
        Transition transition4 = $this$createModifier;
        String str8 = label;
        Composer composer3 = $composer;
        final int i44 = $changed;
        int i21 = 28261782;
        ComposerKt.sourceInformationMarkerStart(composer3, i21, "C(createModifier)870@38224L31,871@38277L28,896@39249L56,898@39349L58:EnterExitTransition.kt#xbi5r1");
        if (i8 & 4 != 0) {
            anon2 = iNSTANCE;
        } else {
            anon2 = isEnabled;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i21, i44, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:869)");
        }
        androidx.compose.animation.EnterTransition trackActiveEnter = EnterExitTransitionKt.trackActiveEnter(transition4, enter, composer3, i22 |= i28);
        androidx.compose.animation.ExitTransition trackActiveExit = EnterExitTransitionKt.trackActiveExit(transition4, exit, composer3, i24 |= i2);
        if (trackActiveEnter.getData$animation_release().getSlide() == null) {
            if (trackActiveExit.getData$animation_release().getSlide() != null) {
                i7 = 1;
            } else {
                i7 = 0;
            }
        } else {
        }
        if (trackActiveEnter.getData$animation_release().getChangeSize() == null) {
            if (trackActiveExit.getData$animation_release().getChangeSize() != null) {
                i6 = 1;
            } else {
                i6 = 0;
            }
        } else {
        }
        final int i46 = i6;
        deferredAnimation2 = 0;
        deferredAnimation = "CC(remember):EnterExitTransition.kt#9igjgp";
        if (i7 != 0) {
            composer3.startReplaceGroup(-821375963);
            ComposerKt.sourceInformation(composer3, "878@38627L27,878@38576L79");
            ComposerKt.sourceInformationMarkerStart(composer3, -165041447, deferredAnimation);
            int i34 = 0;
            Composer composer5 = $composer;
            i9 = 0;
            Object rememberedValue3 = composer5.rememberedValue();
            companion2 = 0;
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty = 0;
                StringBuilder stringBuilder = new StringBuilder();
                companion = deferredAnimation;
                composer5.updateRememberedValue(stringBuilder.append(str8).append(" slide").toString());
            } else {
                companion = deferredAnimation;
                string2 = rememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            str = companion;
            composer3.endReplaceGroup();
            deferredAnimation3 = deferredAnimation;
        } else {
            str = deferredAnimation;
            composer3.startReplaceGroup(-821278096);
            composer3.endReplaceGroup();
            deferredAnimation3 = deferredAnimation2;
        }
        if (i46 != 0) {
            composer3.startReplaceGroup(-821202177);
            ComposerKt.sourceInformation(composer3, "883@38800L35,883@38751L85");
            vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
            ComposerKt.sourceInformationMarkerStart(composer3, -165035903, str);
            Composer composer = $composer;
            int i36 = 0;
            Object rememberedValue = composer.rememberedValue();
            i9 = 0;
            companion = i12;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                companion2 = i14;
                StringBuilder stringBuilder2 = new StringBuilder();
                twoWayConverter = vectorConverter2;
                composer.updateRememberedValue(stringBuilder2.append(str8).append(" shrink/expand").toString());
            } else {
                twoWayConverter = vectorConverter2;
                string3 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endReplaceGroup();
            $this$cache$iv = deferredAnimation;
        } else {
            composer3.startReplaceGroup(-821099041);
            composer3.endReplaceGroup();
            $this$cache$iv = deferredAnimation2;
        }
        if (i46 != 0) {
            composer3.startReplaceGroup(-821034002);
            ComposerKt.sourceInformation(composer3, "889@38995L48,887@38919L134");
            vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(composer3, -165029650, str);
            Composer composer2 = $composer;
            int i37 = 0;
            Object rememberedValue2 = composer2.rememberedValue();
            int i47 = 0;
            companion = i17;
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                companion2 = i19;
                StringBuilder stringBuilder3 = new StringBuilder();
                twoWayConverter = vectorConverter;
                composer2.updateRememberedValue(stringBuilder3.append(str8).append(" InterruptionHandlingOffset").toString());
            } else {
                twoWayConverter = vectorConverter;
                string = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            deferredAnimation2 = TransitionKt.createDeferredAnimation($this$createModifier, twoWayConverter, (String)string, composer3, i18 | 384, 0);
            composer3.endReplaceGroup();
        } else {
            composer3.startReplaceGroup(-820883777);
            composer3.endReplaceGroup();
        }
        changeSize = trackActiveEnter.getData$animation_release().getChangeSize();
        if (changeSize != null && !changeSize.getClip()) {
            i = !changeSize.getClip() ? 1 : 0;
        } else {
        }
        if (i == 0) {
            changeSize3 = trackActiveExit.getData$animation_release().getChangeSize();
            if (changeSize3 != null && !changeSize3.getClip()) {
                i = !changeSize3.getClip() ? 1 : 0;
            } else {
            }
            if (i == 0) {
                if (i46 == 0) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
            } else {
            }
        } else {
        }
        Composer composer4 = composer3;
        androidx.compose.animation.EnterTransition enterTransition = trackActiveEnter;
        androidx.compose.animation.ExitTransition exitTransition = trackActiveExit;
        int activeExit2 = i5;
        empty2 = composer4;
        ComposerKt.sourceInformationMarkerStart(empty2, -165018312, str);
        int i42 = 2048;
        if (i41 ^= 3072 > i42) {
            if (!empty2.changed(anon2)) {
                i4 = i44 & 3072 == i42 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer6 = $composer;
        int i43 = 0;
        Object rememberedValue4 = composer6.rememberedValue();
        int i48 = 0;
        if (changed2 |= i4 == 0) {
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                obj25 = i20;
                anon = new EnterExitTransitionKt.createModifier.2.1(activeExit2, anon2);
                composer6.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue4;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        androidx.compose.animation.EnterTransition enterTransition3 = enterTransition;
        androidx.compose.animation.ExitTransition exitTransition2 = exitTransition;
        Transition.DeferredAnimation activeExit = deferredAnimation8;
        EnterExitTransitionElement enterExitTransitionElement = new EnterExitTransitionElement($this$createModifier, activeExit, deferredAnimation2, deferredAnimation3, enterTransition3, exitTransition2, anon2, EnterExitTransitionKt.createGraphicsLayerBlock($this$createModifier, enterTransition, exitTransition, str8, composer4, i27 | i32));
        androidx.compose.animation.EnterTransition enterTransition2 = enterTransition3;
        Transition.DeferredAnimation deferredAnimation4 = activeExit;
        androidx.compose.animation.ExitTransition sizeAnimation = exitTransition2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return GraphicsLayerModifierKt.graphicsLayer((Modifier)Modifier.Companion, (Function1)anon).then((Modifier)enterExitTransitionElement);
    }

    public static final androidx.compose.animation.EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal expandFrom, boolean clip, Function1<? super Integer, Integer> initialWidth) {
        EnterExitTransitionKt.expandHorizontally.2 anon = new EnterExitTransitionKt.expandHorizontally.2(initialWidth);
        return EnterExitTransitionKt.expandIn(animationSpec, EnterExitTransitionKt.toAlignment(expandFrom), clip, (Function1)anon);
    }

    public static androidx.compose.animation.EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal alignment$Horizontal2, boolean z3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        SpringSpec obj3;
        Alignment.Horizontal obj4;
        int obj5;
        androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.1 obj6;
        int obj8;
        final int i2 = 1;
        if (i5 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i2, 0);
        }
        if (i5 & 2 != 0) {
            obj4 = Alignment.Companion.getEnd();
        }
        if (i5 & 4 != 0) {
            obj5 = i2;
        }
        if (i5 &= 8 != 0) {
            obj6 = EnterExitTransitionKt.expandHorizontally.1.INSTANCE;
        }
        return EnterExitTransitionKt.expandHorizontally(obj3, obj4, obj5, obj6);
    }

    public static final androidx.compose.animation.EnterTransition expandIn(FiniteAnimationSpec<IntSize> animationSpec, Alignment expandFrom, boolean clip, Function1<? super IntSize, IntSize> initialSize) {
        ChangeSize changeSize = new ChangeSize(expandFrom, initialSize, animationSpec, clip);
        TransitionData transitionData = new TransitionData(0, 0, changeSize, 0, 0, 0, 59, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        return (EnterTransition)enterTransitionImpl;
    }

    public static androidx.compose.animation.EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment2, boolean z3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        SpringSpec obj3;
        Alignment obj4;
        int obj5;
        androidx.compose.animation.EnterExitTransitionKt.expandIn.1 obj6;
        int obj8;
        final int i2 = 1;
        if (i5 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i2, 0);
        }
        if (i5 & 2 != 0) {
            obj4 = Alignment.Companion.getBottomEnd();
        }
        if (i5 & 4 != 0) {
            obj5 = i2;
        }
        if (i5 &= 8 != 0) {
            obj6 = EnterExitTransitionKt.expandIn.1.INSTANCE;
        }
        return EnterExitTransitionKt.expandIn(obj3, obj4, obj5, obj6);
    }

    public static final androidx.compose.animation.EnterTransition expandVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical expandFrom, boolean clip, Function1<? super Integer, Integer> initialHeight) {
        EnterExitTransitionKt.expandVertically.2 anon = new EnterExitTransitionKt.expandVertically.2(initialHeight);
        return EnterExitTransitionKt.expandIn(animationSpec, EnterExitTransitionKt.toAlignment(expandFrom), clip, (Function1)anon);
    }

    public static androidx.compose.animation.EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical alignment$Vertical2, boolean z3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        SpringSpec obj3;
        Alignment.Vertical obj4;
        int obj5;
        androidx.compose.animation.EnterExitTransitionKt.expandVertically.1 obj6;
        int obj8;
        final int i2 = 1;
        if (i5 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i2, 0);
        }
        if (i5 & 2 != 0) {
            obj4 = Alignment.Companion.getBottom();
        }
        if (i5 & 4 != 0) {
            obj5 = i2;
        }
        if (i5 &= 8 != 0) {
            obj6 = EnterExitTransitionKt.expandVertically.1.INSTANCE;
        }
        return EnterExitTransitionKt.expandVertically(obj3, obj4, obj5, obj6);
    }

    public static final androidx.compose.animation.EnterTransition fadeIn(FiniteAnimationSpec<Float> animationSpec, float initialAlpha) {
        Fade fade = new Fade(initialAlpha, animationSpec);
        TransitionData transitionData = new TransitionData(fade, 0, 0, 0, 0, 0, 62, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        return (EnterTransition)enterTransitionImpl;
    }

    public static androidx.compose.animation.EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f2, int i3, Object object4) {
        int i;
        SpringSpec obj2;
        int obj3;
        int obj5;
        final int i2 = 0;
        if (i3 & 1 != 0) {
            i = 0;
            obj2 = AnimationSpecKt.spring$default(i2, 1137180672, i, 5, i);
        }
        if (i3 &= 2 != 0) {
            obj3 = i2;
        }
        return EnterExitTransitionKt.fadeIn(obj2, obj3);
    }

    public static final androidx.compose.animation.ExitTransition fadeOut(FiniteAnimationSpec<Float> animationSpec, float targetAlpha) {
        Fade fade = new Fade(targetAlpha, animationSpec);
        TransitionData transitionData = new TransitionData(fade, 0, 0, 0, 0, 0, 62, 0);
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        return (ExitTransition)exitTransitionImpl;
    }

    public static androidx.compose.animation.ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f2, int i3, Object object4) {
        int i;
        SpringSpec obj2;
        int obj3;
        int obj5;
        final int i2 = 0;
        if (i3 & 1 != 0) {
            i = 0;
            obj2 = AnimationSpecKt.spring$default(i2, 1137180672, i, 5, i);
        }
        if (i3 &= 2 != 0) {
            obj3 = i2;
        }
        return EnterExitTransitionKt.fadeOut(obj2, obj3);
    }

    public static final <T extends androidx.compose.animation.TransitionEffect> T get(androidx.compose.animation.EnterTransition $this$get, androidx.compose.animation.TransitionEffectKey<T> key) {
        Object obj;
        if (obj instanceof TransitionEffect) {
        } else {
            obj = 0;
        }
        return obj;
    }

    public static final <T extends androidx.compose.animation.TransitionEffect> T get(androidx.compose.animation.ExitTransition $this$get, androidx.compose.animation.TransitionEffectKey<T> key) {
        Object obj;
        if (obj instanceof TransitionEffect) {
        } else {
            obj = 0;
        }
        return obj;
    }

    public static final androidx.compose.animation.EnterTransition scaleIn-L8ZKh-E(FiniteAnimationSpec<Float> animationSpec, float initialScale, long transformOrigin) {
        final int i5 = 0;
        Scale scale = new Scale(initialScale, transformOrigin, obj5, animationSpec, i5);
        TransitionData transitionData = new TransitionData(0, 0, 0, scale, 0, i5, 55, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        return (EnterTransition)enterTransitionImpl;
    }

    public static androidx.compose.animation.EnterTransition scaleIn-L8ZKh-E$default(FiniteAnimationSpec finiteAnimationSpec, float f2, long l3, int i4, Object object5) {
        int i;
        SpringSpec obj2;
        int obj3;
        long obj4;
        int obj7;
        final int i2 = 0;
        if (object5 & 1 != 0) {
            i = 0;
            obj2 = AnimationSpecKt.spring$default(i2, 1137180672, i, 5, i);
        }
        if (object5 & 2 != 0) {
            obj3 = i2;
        }
        if (object5 &= 4 != 0) {
            obj4 = TransformOrigin.Companion.getCenter-SzJe1aQ();
        }
        return EnterExitTransitionKt.scaleIn-L8ZKh-E(obj2, obj3, obj4);
    }

    public static final androidx.compose.animation.ExitTransition scaleOut-L8ZKh-E(FiniteAnimationSpec<Float> animationSpec, float targetScale, long transformOrigin) {
        final int i5 = 0;
        Scale scale = new Scale(targetScale, transformOrigin, obj5, animationSpec, i5);
        TransitionData transitionData = new TransitionData(0, 0, 0, scale, 0, i5, 55, 0);
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        return (ExitTransition)exitTransitionImpl;
    }

    public static androidx.compose.animation.ExitTransition scaleOut-L8ZKh-E$default(FiniteAnimationSpec finiteAnimationSpec, float f2, long l3, int i4, Object object5) {
        int i;
        SpringSpec obj2;
        int obj3;
        long obj4;
        int obj7;
        final int i2 = 0;
        if (object5 & 1 != 0) {
            i = 0;
            obj2 = AnimationSpecKt.spring$default(i2, 1137180672, i, 5, i);
        }
        if (object5 & 2 != 0) {
            obj3 = i2;
        }
        if (object5 &= 4 != 0) {
            obj4 = TransformOrigin.Companion.getCenter-SzJe1aQ();
        }
        return EnterExitTransitionKt.scaleOut-L8ZKh-E(obj2, obj3, obj4);
    }

    public static final androidx.compose.animation.ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Horizontal shrinkTowards, boolean clip, Function1<? super Integer, Integer> targetWidth) {
        EnterExitTransitionKt.shrinkHorizontally.2 anon = new EnterExitTransitionKt.shrinkHorizontally.2(targetWidth);
        return EnterExitTransitionKt.shrinkOut(animationSpec, EnterExitTransitionKt.toAlignment(shrinkTowards), clip, (Function1)anon);
    }

    public static androidx.compose.animation.ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal alignment$Horizontal2, boolean z3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        SpringSpec obj3;
        Alignment.Horizontal obj4;
        int obj5;
        androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.1 obj6;
        int obj8;
        final int i2 = 1;
        if (i5 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i2, 0);
        }
        if (i5 & 2 != 0) {
            obj4 = Alignment.Companion.getEnd();
        }
        if (i5 & 4 != 0) {
            obj5 = i2;
        }
        if (i5 &= 8 != 0) {
            obj6 = EnterExitTransitionKt.shrinkHorizontally.1.INSTANCE;
        }
        return EnterExitTransitionKt.shrinkHorizontally(obj3, obj4, obj5, obj6);
    }

    public static final androidx.compose.animation.ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> animationSpec, Alignment shrinkTowards, boolean clip, Function1<? super IntSize, IntSize> targetSize) {
        ChangeSize changeSize = new ChangeSize(shrinkTowards, targetSize, animationSpec, clip);
        TransitionData transitionData = new TransitionData(0, 0, changeSize, 0, 0, 0, 59, 0);
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        return (ExitTransition)exitTransitionImpl;
    }

    public static androidx.compose.animation.ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment2, boolean z3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        SpringSpec obj3;
        Alignment obj4;
        int obj5;
        androidx.compose.animation.EnterExitTransitionKt.shrinkOut.1 obj6;
        int obj8;
        final int i2 = 1;
        if (i5 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i2, 0);
        }
        if (i5 & 2 != 0) {
            obj4 = Alignment.Companion.getBottomEnd();
        }
        if (i5 & 4 != 0) {
            obj5 = i2;
        }
        if (i5 &= 8 != 0) {
            obj6 = EnterExitTransitionKt.shrinkOut.1.INSTANCE;
        }
        return EnterExitTransitionKt.shrinkOut(obj3, obj4, obj5, obj6);
    }

    public static final androidx.compose.animation.ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> animationSpec, Alignment.Vertical shrinkTowards, boolean clip, Function1<? super Integer, Integer> targetHeight) {
        EnterExitTransitionKt.shrinkVertically.2 anon = new EnterExitTransitionKt.shrinkVertically.2(targetHeight);
        return EnterExitTransitionKt.shrinkOut(animationSpec, EnterExitTransitionKt.toAlignment(shrinkTowards), clip, (Function1)anon);
    }

    public static androidx.compose.animation.ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical alignment$Vertical2, boolean z3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        SpringSpec obj3;
        Alignment.Vertical obj4;
        int obj5;
        androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.1 obj6;
        int obj8;
        final int i2 = 1;
        if (i5 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i2, 0);
        }
        if (i5 & 2 != 0) {
            obj4 = Alignment.Companion.getBottom();
        }
        if (i5 & 4 != 0) {
            obj5 = i2;
        }
        if (i5 &= 8 != 0) {
            obj6 = EnterExitTransitionKt.shrinkVertically.1.INSTANCE;
        }
        return EnterExitTransitionKt.shrinkVertically(obj3, obj4, obj5, obj6);
    }

    public static final androidx.compose.animation.EnterTransition slideIn(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> initialOffset) {
        Slide slide = new Slide(initialOffset, animationSpec);
        TransitionData transitionData = new TransitionData(0, slide, 0, 0, 0, 0, 61, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        return (EnterTransition)enterTransitionImpl;
    }

    public static androidx.compose.animation.EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function12, int i3, Object object4) {
        int i;
        long l;
        SpringSpec obj2;
        int obj4;
        final int obj5 = 1;
        if (i3 &= obj5 != 0) {
            obj2 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), obj5, 0);
        }
        return EnterExitTransitionKt.slideIn(obj2, function12);
    }

    public static final androidx.compose.animation.EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffsetX) {
        EnterExitTransitionKt.slideInHorizontally.2 anon = new EnterExitTransitionKt.slideInHorizontally.2(initialOffsetX);
        return EnterExitTransitionKt.slideIn(animationSpec, (Function1)anon);
    }

    public static androidx.compose.animation.EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function12, int i3, Object object4) {
        int i2;
        long i4;
        int i;
        SpringSpec obj3;
        androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.1 obj4;
        int obj6;
        if (i3 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, 0);
        }
        if (i3 &= 2 != 0) {
            obj4 = EnterExitTransitionKt.slideInHorizontally.1.INSTANCE;
        }
        return EnterExitTransitionKt.slideInHorizontally(obj3, obj4);
    }

    public static final androidx.compose.animation.EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffsetY) {
        EnterExitTransitionKt.slideInVertically.2 anon = new EnterExitTransitionKt.slideInVertically.2(initialOffsetY);
        return EnterExitTransitionKt.slideIn(animationSpec, (Function1)anon);
    }

    public static androidx.compose.animation.EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function12, int i3, Object object4) {
        int i4;
        long i;
        int i2;
        SpringSpec obj3;
        androidx.compose.animation.EnterExitTransitionKt.slideInVertically.1 obj4;
        int obj6;
        if (i3 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, 0);
        }
        if (i3 &= 2 != 0) {
            obj4 = EnterExitTransitionKt.slideInVertically.1.INSTANCE;
        }
        return EnterExitTransitionKt.slideInVertically(obj3, obj4);
    }

    public static final androidx.compose.animation.ExitTransition slideOut(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super IntSize, IntOffset> targetOffset) {
        Slide slide = new Slide(targetOffset, animationSpec);
        TransitionData transitionData = new TransitionData(0, slide, 0, 0, 0, 0, 61, 0);
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        return (ExitTransition)exitTransitionImpl;
    }

    public static androidx.compose.animation.ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function12, int i3, Object object4) {
        int i;
        long l;
        SpringSpec obj2;
        int obj4;
        final int obj5 = 1;
        if (i3 &= obj5 != 0) {
            obj2 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), obj5, 0);
        }
        return EnterExitTransitionKt.slideOut(obj2, function12);
    }

    public static final androidx.compose.animation.ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffsetX) {
        EnterExitTransitionKt.slideOutHorizontally.2 anon = new EnterExitTransitionKt.slideOutHorizontally.2(targetOffsetX);
        return EnterExitTransitionKt.slideOut(animationSpec, (Function1)anon);
    }

    public static androidx.compose.animation.ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function12, int i3, Object object4) {
        int i;
        long i2;
        int i4;
        SpringSpec obj3;
        androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.1 obj4;
        int obj6;
        if (i3 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, 0);
        }
        if (i3 &= 2 != 0) {
            obj4 = EnterExitTransitionKt.slideOutHorizontally.1.INSTANCE;
        }
        return EnterExitTransitionKt.slideOutHorizontally(obj3, obj4);
    }

    public static final androidx.compose.animation.ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffsetY) {
        EnterExitTransitionKt.slideOutVertically.2 anon = new EnterExitTransitionKt.slideOutVertically.2(targetOffsetY);
        return EnterExitTransitionKt.slideOut(animationSpec, (Function1)anon);
    }

    public static androidx.compose.animation.ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function12, int i3, Object object4) {
        int i4;
        long i;
        int i2;
        SpringSpec obj3;
        androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.1 obj4;
        int obj6;
        if (i3 & 1 != 0) {
            obj3 = AnimationSpecKt.spring$default(0, 1137180672, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, 0);
        }
        if (i3 &= 2 != 0) {
            obj4 = EnterExitTransitionKt.slideOutVertically.1.INSTANCE;
        }
        return EnterExitTransitionKt.slideOutVertically(obj3, obj4);
    }

    private static final Alignment toAlignment(Alignment.Horizontal $this$toAlignment) {
        Alignment centerStart;
        if (Intrinsics.areEqual($this$toAlignment, Alignment.Companion.getStart())) {
            centerStart = Alignment.Companion.getCenterStart();
        } else {
            if (Intrinsics.areEqual($this$toAlignment, Alignment.Companion.getEnd())) {
                centerStart = Alignment.Companion.getCenterEnd();
            } else {
                centerStart = Alignment.Companion.getCenter();
            }
        }
        return centerStart;
    }

    private static final Alignment toAlignment(Alignment.Vertical $this$toAlignment) {
        Alignment bottomCenter;
        if (Intrinsics.areEqual($this$toAlignment, Alignment.Companion.getTop())) {
            bottomCenter = Alignment.Companion.getTopCenter();
        } else {
            if (Intrinsics.areEqual($this$toAlignment, Alignment.Companion.getBottom())) {
                bottomCenter = Alignment.Companion.getBottomCenter();
            } else {
                bottomCenter = Alignment.Companion.getCenter();
            }
        }
        return bottomCenter;
    }

    public static final androidx.compose.animation.EnterTransition trackActiveEnter(Transition<androidx.compose.animation.EnterExitState> $this$trackActiveEnter, androidx.compose.animation.EnterTransition enter, Composer $composer, int $changed) {
        int changed;
        int i3;
        boolean traceInProgress;
        Object currentState;
        Object targetState2;
        String str;
        Object targetState;
        Object empty;
        Object mutableStateOf$default;
        int i2;
        int i;
        int i4 = 21614502;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(trackActiveEnter)915@40149L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:910)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1583278438, "CC(remember):EnterExitTransition.kt#9igjgp");
        int i7 = 4;
        if (i6 ^= 6 > i7) {
            if (!$composer.changed($this$trackActiveEnter)) {
                i3 = $changed & 6 == i7 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (i3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i10 = 0;
                i = 0;
                composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(enter, i, 2, i));
            } else {
                mutableStateOf$default = rememberedValue;
            }
        } else {
        }
        MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ($this$trackActiveEnter.getCurrentState() == $this$trackActiveEnter.getTargetState() && $this$trackActiveEnter.getCurrentState() == EnterExitState.Visible) {
            if ($this$trackActiveEnter.getCurrentState() == EnterExitState.Visible) {
                if ($this$trackActiveEnter.isSeeking()) {
                    EnterExitTransitionKt.trackActiveEnter$lambda$6((MutableState)invalid$iv, enter);
                } else {
                    EnterExitTransitionKt.trackActiveEnter$lambda$6(invalid$iv, EnterTransition.Companion.getNone());
                }
            } else {
                if ($this$trackActiveEnter.getTargetState() == EnterExitState.Visible) {
                    EnterExitTransitionKt.trackActiveEnter$lambda$6(invalid$iv, EnterExitTransitionKt.trackActiveEnter$lambda$5(invalid$iv).plus(enter));
                }
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return EnterExitTransitionKt.trackActiveEnter$lambda$5(invalid$iv);
    }

    private static final androidx.compose.animation.EnterTransition trackActiveEnter$lambda$5(MutableState<androidx.compose.animation.EnterTransition> $activeEnter$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (EnterTransition)(State)$activeEnter$delegate.getValue();
    }

    private static final void trackActiveEnter$lambda$6(MutableState<androidx.compose.animation.EnterTransition> $activeEnter$delegate, androidx.compose.animation.EnterTransition value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $activeEnter$delegate.setValue(value);
    }

    public static final androidx.compose.animation.ExitTransition trackActiveExit(Transition<androidx.compose.animation.EnterExitState> $this$trackActiveExit, androidx.compose.animation.ExitTransition exit, Composer $composer, int $changed) {
        int changed;
        int i2;
        boolean traceInProgress;
        Object currentState;
        Object targetState2;
        String str;
        Object targetState;
        Object empty;
        Object mutableStateOf$default;
        int i3;
        int i;
        int i4 = -1363864804;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(trackActiveExit)935@41130L39:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:930)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1483140299, "CC(remember):EnterExitTransition.kt#9igjgp");
        int i7 = 4;
        if (i6 ^= 6 > i7) {
            if (!$composer.changed($this$trackActiveExit)) {
                i2 = $changed & 6 == i7 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (i2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i10 = 0;
                i = 0;
                composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(exit, i, 2, i));
            } else {
                mutableStateOf$default = rememberedValue;
            }
        } else {
        }
        MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ($this$trackActiveExit.getCurrentState() == $this$trackActiveExit.getTargetState() && $this$trackActiveExit.getCurrentState() == EnterExitState.Visible) {
            if ($this$trackActiveExit.getCurrentState() == EnterExitState.Visible) {
                if ($this$trackActiveExit.isSeeking()) {
                    EnterExitTransitionKt.trackActiveExit$lambda$9((MutableState)invalid$iv, exit);
                } else {
                    EnterExitTransitionKt.trackActiveExit$lambda$9(invalid$iv, ExitTransition.Companion.getNone());
                }
            } else {
                if ($this$trackActiveExit.getTargetState() != EnterExitState.Visible) {
                    EnterExitTransitionKt.trackActiveExit$lambda$9(invalid$iv, EnterExitTransitionKt.trackActiveExit$lambda$8(invalid$iv).plus(exit));
                }
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return EnterExitTransitionKt.trackActiveExit$lambda$8(invalid$iv);
    }

    private static final androidx.compose.animation.ExitTransition trackActiveExit$lambda$8(MutableState<androidx.compose.animation.ExitTransition> $activeExit$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (ExitTransition)(State)$activeExit$delegate.getValue();
    }

    private static final void trackActiveExit$lambda$9(MutableState<androidx.compose.animation.ExitTransition> $activeExit$delegate, androidx.compose.animation.ExitTransition value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $activeExit$delegate.setValue(value);
    }

    public static final androidx.compose.animation.EnterTransition withEffect(androidx.compose.animation.EnterTransition $this$withEffect, androidx.compose.animation.TransitionEffect effect) {
        TransitionData transitionData = new TransitionData(0, 0, 0, 0, 0, MapsKt.mapOf(TuplesKt.to(effect.getKey$animation_release(), effect)), 31, 0);
        EnterTransitionImpl enterTransitionImpl = new EnterTransitionImpl(transitionData);
        return (EnterTransition)enterTransitionImpl;
    }

    public static final androidx.compose.animation.ExitTransition withEffect(androidx.compose.animation.ExitTransition $this$withEffect, androidx.compose.animation.TransitionEffect effect) {
        TransitionData transitionData = new TransitionData(0, 0, 0, 0, 0, MapsKt.mapOf(TuplesKt.to(effect.getKey$animation_release(), effect)), 31, 0);
        ExitTransitionImpl exitTransitionImpl = new ExitTransitionImpl(transitionData);
        return (ExitTransition)exitTransitionImpl;
    }
}
