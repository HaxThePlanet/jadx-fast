package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a!\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001aC\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00122'\u0010\u0017\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0018H\u0000\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0002X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000cX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001c²\u0006\n\u0010\u001b\u001a\u00020\u0002X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0002X\u008a\u0084\u0002", d2 = {"MagnifierSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierSpringSpec", "()Landroidx/compose/animation/core/SpringSpec;", "OffsetDisplacementThreshold", "getOffsetDisplacementThreshold", "()J", "J", "UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "getUnspecifiedSafeOffsetVectorConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "rememberAnimatedMagnifierPosition", "Landroidx/compose/runtime/State;", "targetCalculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animatedSelectionMagnifier", "Landroidx/compose/ui/Modifier;", "magnifierCenter", "platformMagnifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animatedCenter", "foundation_release", "targetValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionMagnifierKt {

    private static final SpringSpec<Offset> MagnifierSpringSpec;
    private static final long OffsetDisplacementThreshold;
    private static final AnimationVector2D UnspecifiedAnimationVector2D;
    private static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter;
    static {
        int i2 = 2143289344;
        AnimationVector2D animationVector2D = new AnimationVector2D(i2, i2);
        SelectionMagnifierKt.UnspecifiedAnimationVector2D = animationVector2D;
        androidx.compose.foundation.text.selection.SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter.2 iNSTANCE2 = SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter.2.INSTANCE;
        SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter((Function1)SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter.1.INSTANCE, (Function1)iNSTANCE2);
        int i = 1008981770;
        SelectionMagnifierKt.OffsetDisplacementThreshold = OffsetKt.Offset(i, i);
        SpringSpec springSpec = new SpringSpec(0, 0, Offset.box-impl(SelectionMagnifierKt.OffsetDisplacementThreshold), 3, 0);
        SelectionMagnifierKt.MagnifierSpringSpec = springSpec;
    }

    public static final AnimationVector2D access$getUnspecifiedAnimationVector2D$p() {
        return SelectionMagnifierKt.UnspecifiedAnimationVector2D;
    }

    public static final State access$rememberAnimatedMagnifierPosition(Function0 targetCalculation, Composer $composer, int $changed) {
        return SelectionMagnifierKt.rememberAnimatedMagnifierPosition(targetCalculation, $composer, $changed);
    }

    public static final long access$rememberAnimatedMagnifierPosition$lambda$1(State $targetValue$delegate) {
        return SelectionMagnifierKt.rememberAnimatedMagnifierPosition$lambda$1($targetValue$delegate);
    }

    public static final Modifier animatedSelectionMagnifier(Modifier $this$animatedSelectionMagnifier, Function0<Offset> magnifierCenter, Function1<? super Function0<Offset>, ? extends Modifier> platformMagnifier) {
        SelectionMagnifierKt.animatedSelectionMagnifier.1 anon = new SelectionMagnifierKt.animatedSelectionMagnifier.1(magnifierCenter, platformMagnifier);
        final int i2 = 0;
        return ComposedModifierKt.composed$default($this$animatedSelectionMagnifier, i2, (Function3)anon, 1, i2);
    }

    public static final SpringSpec<Offset> getMagnifierSpringSpec() {
        return SelectionMagnifierKt.MagnifierSpringSpec;
    }

    public static final long getOffsetDisplacementThreshold() {
        return SelectionMagnifierKt.OffsetDisplacementThreshold;
    }

    public static final TwoWayConverter<Offset, AnimationVector2D> getUnspecifiedSafeOffsetVectorConverter() {
        return SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter;
    }

    private static final State<Offset> rememberAnimatedMagnifierPosition(Function0<Offset> targetCalculation, Composer $composer, int $changed) {
        int traceInProgress;
        String str;
        int i4;
        Object derivedStateOf;
        int empty;
        Object animatable;
        Offset box-impl;
        Object anon;
        TwoWayConverter unspecifiedSafeOffsetVectorConverter;
        Offset box-impl2;
        int i;
        int i2;
        int i3;
        final Composer composer = $composer;
        int i5 = -1589795249;
        ComposerKt.sourceInformationMarkerStart(composer, i5, "C(rememberAnimatedMagnifierPosition)77@2973L46,78@3041L208,82@3275L1165,82@3254L1186:SelectionMagnifier.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:76)");
        } else {
            i4 = $changed;
        }
        String str3 = "CC(remember):SelectionMagnifier.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 494972156, str3);
        int i7 = 0;
        Composer composer2 = $composer;
        int i11 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i14 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i17 = 0;
            composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf(targetCalculation));
        } else {
            derivedStateOf = rememberedValue;
        }
        State invalid$iv = derivedStateOf;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 494974494, str3);
        int i10 = 0;
        Composer composer3 = $composer;
        int i12 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i16 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty = 0;
            animatable = new Animatable(Offset.box-impl(SelectionMagnifierKt.rememberAnimatedMagnifierPosition$lambda$1((State)invalid$iv)), SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter, Offset.box-impl(SelectionMagnifierKt.OffsetDisplacementThreshold), 0, 8, 0);
            composer3.updateRememberedValue(animatable);
        } else {
            animatable = rememberedValue2;
        }
        Animatable invalid$iv2 = animatable;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 494982939, str3);
        Composer composer4 = $composer;
        int i15 = 0;
        Object rememberedValue3 = composer4.rememberedValue();
        int i18 = 0;
        if (!composer.changedInstance((Animatable)invalid$iv2)) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                animatable = 0;
                anon = new SelectionMagnifierKt.rememberAnimatedMagnifierPosition.1.1(invalid$iv, invalid$iv2, 0);
                composer4.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, (Function2)anon, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return invalid$iv2.asState();
    }

    private static final long rememberAnimatedMagnifierPosition$lambda$1(State<Offset> $targetValue$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Offset)$targetValue$delegate.getValue().unbox-impl();
    }
}
