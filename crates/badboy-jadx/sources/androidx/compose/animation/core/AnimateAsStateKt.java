package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aH\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001aR\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001aM\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00152\u0008\u0008\u0002\u0010 \u001a\u00020\u00022\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010!\u001aW\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00152\u0008\u0008\u0002\u0010 \u001a\u00020\u00022\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\"\u001aC\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010$\u001aM\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010%\u001aH\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u0013\u001a\u00020\u00082\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u001aR\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00122\u0006\u0010\u0013\u001a\u00020\u00082\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001aH\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010(\u001aR\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010*\u001aH\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00122\u0006\u0010\u0013\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u0010(\u001aR\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00122\u0006\u0010\u0013\u001a\u00020\u000c2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u00080\u0010*\u001aC\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00102\u001aM\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u00103\u001aH\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00152\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u00085\u0010(\u001aR\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00152\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u0010*\u001as\u00107\u001a\u0008\u0012\u0004\u0012\u0002H80\u0012\"\u0004\u0008\u0000\u00108\"\u0008\u0008\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H80\u00152\n\u0008\u0002\u0010 \u001a\u0004\u0018\u0001H82\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010=\u001a}\u00107\u001a\u0008\u0012\u0004\u0012\u0002H80\u0012\"\u0004\u0008\u0000\u00108\"\u0008\u0008\u0001\u00109*\u00020:2\u0006\u0010\u0013\u001a\u0002H82\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H90<2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H80\u00152\n\u0008\u0002\u0010 \u001a\u0004\u0018\u0001H82\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0016\u0008\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006?²\u0006(\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\"\u0004\u0008\u0000\u00108\"\u0008\u0008\u0001\u00109*\u00020:X\u008a\u0084\u0002²\u0006 \u0010A\u001a\u0008\u0012\u0004\u0012\u0002H80\u0015\"\u0004\u0008\u0000\u00108\"\u0008\u0008\u0001\u00109*\u00020:X\u008a\u0084\u0002", d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "dpDefaultSpring", "Landroidx/compose/ui/unit/Dp;", "intDefaultSpring", "", "intOffsetDefaultSpring", "Landroidx/compose/ui/unit/IntOffset;", "intSizeDefaultSpring", "Landroidx/compose/ui/unit/IntSize;", "offsetDefaultSpring", "Landroidx/compose/ui/geometry/Offset;", "rectDefaultSpring", "Landroidx/compose/ui/geometry/Rect;", "sizeDefaultSpring", "Landroidx/compose/ui/geometry/Size;", "animateDpAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "label", "", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloatAsState", "visibilityThreshold", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntAsState", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState", "animateIntOffsetAsState-8f6pmRE", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-HyPO7BM", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntSizeAsState", "animateIntSizeAsState-zTRF_AQ", "animateIntSizeAsState-4goxYXU", "animateOffsetAsState", "animateOffsetAsState-N6fFfp4", "animateOffsetAsState-7362WCg", "animateRectAsState", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState", "animateSizeAsState-LjSzlW0", "animateSizeAsState-YLp_XPw", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release", "listener", "animSpec"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimateAsStateKt {

    private static final androidx.compose.animation.core.SpringSpec<Float> defaultAnimation;
    private static final androidx.compose.animation.core.SpringSpec<Dp> dpDefaultSpring;
    private static final androidx.compose.animation.core.SpringSpec<Integer> intDefaultSpring;
    private static final androidx.compose.animation.core.SpringSpec<IntOffset> intOffsetDefaultSpring;
    private static final androidx.compose.animation.core.SpringSpec<IntSize> intSizeDefaultSpring;
    private static final androidx.compose.animation.core.SpringSpec<Offset> offsetDefaultSpring;
    private static final androidx.compose.animation.core.SpringSpec<Rect> rectDefaultSpring;
    private static final androidx.compose.animation.core.SpringSpec<Size> sizeDefaultSpring;
    static {
        final int i2 = 0;
        final int i3 = 0;
        AnimateAsStateKt.defaultAnimation = AnimationSpecKt.spring$default(i2, i2, i3, 7, i3);
        final int i4 = 3;
        AnimateAsStateKt.dpDefaultSpring = AnimationSpecKt.spring$default(i2, i2, Dp.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), i4, i3);
        AnimateAsStateKt.sizeDefaultSpring = AnimationSpecKt.spring$default(i2, i2, Size.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), i4, i3);
        AnimateAsStateKt.offsetDefaultSpring = AnimationSpecKt.spring$default(i2, i2, Offset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), i4, i3);
        AnimateAsStateKt.rectDefaultSpring = AnimationSpecKt.spring$default(i2, i2, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), i4, i3);
        AnimateAsStateKt.intDefaultSpring = AnimationSpecKt.spring$default(i2, i2, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), i4, i3);
        AnimateAsStateKt.intOffsetDefaultSpring = AnimationSpecKt.spring$default(i2, i2, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), i4, i3);
        AnimateAsStateKt.intSizeDefaultSpring = AnimationSpecKt.spring$default(i2, i2, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), i4, i3);
    }

    public static final Function1 access$animateValueAsState$lambda$4(State $listener$delegate) {
        return AnimateAsStateKt.animateValueAsState$lambda$4($listener$delegate);
    }

    public static final androidx.compose.animation.core.AnimationSpec access$animateValueAsState$lambda$6(State $animSpec$delegate) {
        return AnimateAsStateKt.animateValueAsState$lambda$6($animSpec$delegate);
    }

    public static final State<Dp> animateDpAsState-AjpBEmI(float targetValue, androidx.compose.animation.core.AnimationSpec<Dp> animationSpec, String label, Function1<? super Dp, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int dpDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj13;
        String obj14;
        int obj15;
        final int i2 = $changed;
        final int i3 = -1407150062;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateDpAsState)P(3:c#ui.unit.Dp!1,2)114@5081L165:AnimateAsState.kt#pdpnli");
        if (i7 & 2 != 0) {
            springSpec = obj13;
        } else {
            springSpec = animationSpec;
        }
        str = i7 & 4 != 0 ? obj14 : label;
        i = i7 & 8 != 0 ? obj15 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:113)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return AnimateAsStateKt.animateValueAsState(Dp.box-impl(targetValue), VectorConvertersKt.getVectorConverter(Dp.Companion), springSpec, 0, str, i, composer, obj13 | obj14, 8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateDpAsState-Kz89ssw(float targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int dpDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj11;
        int obj12;
        final int i2 = 704104481;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(animateDpAsState)P(2:c#ui.unit.Dp)463@20491L142:AnimateAsState.kt#pdpnli");
        if (i6 & 2 != 0) {
            springSpec = obj11;
        } else {
            springSpec = animationSpec;
        }
        i = i6 & 4 != 0 ? obj12 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:462)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return AnimateAsStateKt.animateValueAsState(Dp.box-impl(targetValue), VectorConvertersKt.getVectorConverter(Dp.Companion), springSpec, 0, 0, i, composer, obj11 | obj12, 24);
    }

    public static final State<Float> animateFloatAsState(float targetValue, androidx.compose.animation.core.AnimationSpec<Float> animationSpec, float visibilityThreshold, String label, Function1<? super Float, Unit> finishedListener, Composer $composer, int $changed, int i8) {
        int changed;
        int i9;
        int defaultAnimation;
        int i;
        int str;
        int i5;
        boolean traceInProgress;
        String str2;
        Object obj;
        Object rememberedValue;
        String str3;
        int i7;
        int i3;
        Object $i$a$CacheAnimateAsStateKt$animateFloatAsState$resolvedAnimSpec$1;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i4;
        Float valueOf;
        int i2;
        int i6;
        int i10;
        final Composer composer = $composer;
        final int i29 = $changed;
        int i11 = 668842840;
        ComposerKt.sourceInformationMarkerStart(composer, i11, "C(animateFloatAsState)P(3!1,4,2)75@3368L173:AnimateAsState.kt#pdpnli");
        if (i8 & 2 != 0) {
            springSpec = defaultAnimation;
        } else {
            springSpec = animationSpec;
        }
        i4 = i8 & 4 != 0 ? i : visibilityThreshold;
        str3 = i8 & 8 != 0 ? str : label;
        i7 = i8 & 16 != 0 ? i5 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i29, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:68)");
        }
        if (springSpec == AnimateAsStateKt.defaultAnimation) {
            composer.startReplaceGroup(1125598679);
            ComposerKt.sourceInformation(composer, "71@3220L83");
            ComposerKt.sourceInformationMarkerStart(composer, 313404723, "CC(remember):AnimateAsState.kt#9igjgp");
            int i15 = 256;
            if (i14 ^= 384 > i15) {
                if (!composer.changed(i4)) {
                    i9 = i29 & 384 == i15 ? 1 : 0;
                } else {
                }
            } else {
            }
            traceInProgress = $composer;
            int i16 = 0;
            rememberedValue = traceInProgress.rememberedValue();
            i3 = 0;
            if (i9 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i21 = 0;
                    i6 = 0;
                    traceInProgress.updateRememberedValue(AnimationSpecKt.spring$default(i6, i6, Float.valueOf(i4), 3, 0));
                } else {
                    $i$a$CacheAnimateAsStateKt$animateFloatAsState$resolvedAnimSpec$1 = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            obj = $i$a$CacheAnimateAsStateKt$animateFloatAsState$resolvedAnimSpec$1;
        } else {
            composer.startReplaceGroup(1125708605);
            composer.endReplaceGroup();
            obj = springSpec;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return AnimateAsStateKt.animateValueAsState(Float.valueOf(targetValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), obj, Float.valueOf(i4), str3, i7, composer, i19 |= i27, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateFloatAsState(float targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, float visibilityThreshold, Function1 finishedListener, Composer $composer, int $changed, int i7) {
        int defaultAnimation;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        int i2;
        androidx.compose.animation.core.SpringSpec obj10;
        int obj11;
        int obj12;
        final int i3 = 1091643291;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(animateFloatAsState)P(2!1,3)446@20047L143:AnimateAsState.kt#pdpnli");
        if (i7 & 2 != 0) {
            springSpec = obj10;
        } else {
            springSpec = animationSpec;
        }
        i = i7 & 4 != 0 ? obj11 : visibilityThreshold;
        i2 = i7 & 8 != 0 ? obj12 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:446)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return AnimateAsStateKt.animateFloatAsState(targetValue, springSpec, i, 0, i2, composer, obj10 | obj11, 8);
    }

    public static final State<Integer> animateIntAsState(int targetValue, androidx.compose.animation.core.AnimationSpec<Integer> animationSpec, String label, Function1<? super Integer, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int intDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj13;
        String obj14;
        int obj15;
        final int i2 = $changed;
        final int i3 = 428074472;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateIntAsState)P(3!1,2)274@12363L166:AnimateAsState.kt#pdpnli");
        if (i7 & 2 != 0) {
            springSpec = obj13;
        } else {
            springSpec = animationSpec;
        }
        str = i7 & 4 != 0 ? obj14 : label;
        i = i7 & 8 != 0 ? obj15 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:273)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return AnimateAsStateKt.animateValueAsState(Integer.valueOf(targetValue), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), springSpec, 0, str, i, composer, obj13 | obj14, 8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateIntAsState(int targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int intDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj11;
        int obj12;
        final int i2 = -842612981;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(animateIntAsState)P(2)529@22285L119:AnimateAsState.kt#pdpnli");
        if (i6 & 2 != 0) {
            springSpec = obj11;
        } else {
            springSpec = animationSpec;
        }
        i = i6 & 4 != 0 ? obj12 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:528)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return AnimateAsStateKt.animateValueAsState(Integer.valueOf(targetValue), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), springSpec, 0, 0, i, composer, obj11 | obj12, 24);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateIntOffsetAsState-8f6pmRE(long targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int intOffsetDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        int obj15;
        final int i2 = i6;
        int i3 = 1010307371;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateIntOffsetAsState)P(2:c#ui.unit.IntOffset)544@22749L125:AnimateAsState.kt#pdpnli");
        if (obj18 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = finishedListener;
        }
        i = obj18 & 4 != 0 ? obj15 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:543)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(IntOffset.box-impl(targetValue), VectorConvertersKt.getVectorConverter(IntOffset.Companion), springSpec, 0, 0, i, composer, obj14 | obj15, 24);
    }

    public static final State<IntOffset> animateIntOffsetAsState-HyPO7BM(long targetValue, androidx.compose.animation.core.AnimationSpec<IntOffset> animationSpec, String label, Function1<? super IntOffset, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int intOffsetDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        String obj15;
        final int i2 = i7;
        int i3 = -696782904;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateIntOffsetAsState)P(3:c#ui.unit.IntOffset!1,2)314@14224L172:AnimateAsState.kt#pdpnli");
        if (obj19 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = label;
        }
        str = obj19 & 4 != 0 ? obj15 : finishedListener;
        i = obj19 & 8 != 0 ? obj14 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:313)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(IntOffset.box-impl(targetValue), VectorConvertersKt.getVectorConverter(IntOffset.Companion), springSpec, 0, str, i, composer, obj14 | obj15, 8);
    }

    public static final State<IntSize> animateIntSizeAsState-4goxYXU(long targetValue, androidx.compose.animation.core.AnimationSpec<IntSize> animationSpec, String label, Function1<? super IntSize, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int intSizeDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        String obj15;
        final int i2 = i7;
        int i3 = 582576328;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateIntSizeAsState)P(3:c#ui.unit.IntSize!1,2)352@16009L170:AnimateAsState.kt#pdpnli");
        if (obj19 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = label;
        }
        str = obj19 & 4 != 0 ? obj15 : finishedListener;
        i = obj19 & 8 != 0 ? obj14 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:351)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(IntSize.box-impl(targetValue), VectorConvertersKt.getVectorConverter(IntSize.Companion), springSpec, 0, str, i, composer, obj14 | obj15, 8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateIntSizeAsState-zTRF_AQ(long targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int intSizeDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        int obj15;
        final int i2 = i6;
        int i3 = -1749239765;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateIntSizeAsState)P(2:c#ui.unit.IntSize)559@23207L123:AnimateAsState.kt#pdpnli");
        if (obj18 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = finishedListener;
        }
        i = obj18 & 4 != 0 ? obj15 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:558)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(IntSize.box-impl(targetValue), VectorConvertersKt.getVectorConverter(IntSize.Companion), springSpec, 0, 0, i, composer, obj14 | obj15, 24);
    }

    public static final State<Offset> animateOffsetAsState-7362WCg(long targetValue, androidx.compose.animation.core.AnimationSpec<Offset> animationSpec, String label, Function1<? super Offset, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int offsetDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        String obj15;
        final int i2 = i7;
        int i3 = 357896800;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateOffsetAsState)P(3:c#ui.geometry.Offset!1,2)195@8761L169:AnimateAsState.kt#pdpnli");
        if (obj19 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = label;
        }
        str = obj19 & 4 != 0 ? obj15 : finishedListener;
        i = obj19 & 8 != 0 ? obj14 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:194)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(Offset.box-impl(targetValue), VectorConvertersKt.getVectorConverter(Offset.Companion), springSpec, 0, str, i, composer, obj14 | obj15, 8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateOffsetAsState-N6fFfp4(long targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int offsetDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        int obj15;
        final int i2 = i6;
        int i3 = -456513133;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateOffsetAsState)P(2:c#ui.geometry.Offset)499@21419L122:AnimateAsState.kt#pdpnli");
        if (obj18 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = finishedListener;
        }
        i = obj18 & 4 != 0 ? obj15 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:498)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(Offset.box-impl(targetValue), VectorConvertersKt.getVectorConverter(Offset.Companion), springSpec, 0, 0, i, composer, obj14 | obj15, 24);
    }

    public static final State<Rect> animateRectAsState(Rect targetValue, androidx.compose.animation.core.AnimationSpec<Rect> animationSpec, String label, Function1<? super Rect, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int rectDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj13;
        String obj14;
        int obj15;
        final int i2 = $changed;
        final int i3 = 536062978;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateRectAsState)P(3!1,2)236@10633L167:AnimateAsState.kt#pdpnli");
        if (i7 & 2 != 0) {
            springSpec = obj13;
        } else {
            springSpec = animationSpec;
        }
        str = i7 & 4 != 0 ? obj14 : label;
        i = i7 & 8 != 0 ? obj15 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:235)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return AnimateAsStateKt.animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.Companion), springSpec, 0, str, i, composer, obj13 | obj14, 8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateRectAsState(Rect targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int rectDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj11;
        int obj12;
        final int i2 = -782613967;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(animateRectAsState)P(2)514@21856L120:AnimateAsState.kt#pdpnli");
        if (i6 & 2 != 0) {
            springSpec = obj11;
        } else {
            springSpec = animationSpec;
        }
        i = i6 & 4 != 0 ? obj12 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:513)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return AnimateAsStateKt.animateValueAsState(targetValue, VectorConvertersKt.getVectorConverter(Rect.Companion), springSpec, 0, 0, i, composer, obj11 | obj12, 24);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateSizeAsState-LjSzlW0(long targetValue, androidx.compose.animation.core.AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int sizeDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        int obj15;
        final int i2 = i6;
        int i3 = 875212471;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateSizeAsState)P(2:c#ui.geometry.Size)481@20948L144:AnimateAsState.kt#pdpnli");
        if (obj18 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = finishedListener;
        }
        i = obj18 & 4 != 0 ? obj15 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:480)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(Size.box-impl(targetValue), VectorConvertersKt.getVectorConverter(Size.Companion), springSpec, 0, 0, i, composer, obj14 | obj15, 24);
    }

    public static final State<Size> animateSizeAsState-YLp_XPw(long targetValue, androidx.compose.animation.core.AnimationSpec<Size> animationSpec, String label, Function1<? super Size, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        int sizeDefaultSpring;
        androidx.compose.animation.core.SpringSpec springSpec;
        String str;
        int i;
        androidx.compose.animation.core.SpringSpec obj14;
        String obj15;
        final int i2 = i7;
        int i3 = 1374633148;
        final Composer composer = $changed;
        ComposerKt.sourceInformationMarkerStart(composer, i3, "C(animateSizeAsState)P(3:c#ui.geometry.Size!1,2)155@6928L167:AnimateAsState.kt#pdpnli");
        if (obj19 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = label;
        }
        str = obj19 & 4 != 0 ? obj15 : finishedListener;
        i = obj19 & 8 != 0 ? obj14 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i2, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:154)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(Size.box-impl(targetValue), VectorConvertersKt.getVectorConverter(Size.Companion), springSpec, 0, str, i, composer, obj14 | obj15, 8);
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> State<T> animateValueAsState(T targetValue, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, androidx.compose.animation.core.AnimationSpec<T> animationSpec, T visibilityThreshold, String label, Function1<? super T, Unit> finishedListener, Composer $composer, int $changed, int i9) {
        androidx.compose.animation.core.TwoWayConverter twoWayConverter;
        Object obj2;
        int changedInstance;
        int i3;
        Object invalid$iv;
        Object value;
        Object animationSpec2;
        Object animatable;
        Object animatable2;
        Composer composer;
        int visibilityThreshold2;
        int i;
        String label2;
        Object rememberedValue;
        int finishedListener2;
        int i2;
        boolean traceInProgress;
        Object $i$a$CacheAnimateAsStateKt$animateValueAsState$1;
        Object mutableStateOf$default;
        int i5;
        int i6;
        Object spring;
        Object rememberedValue2;
        float stiffness;
        Object empty4;
        int empty;
        Object empty2;
        int empty3;
        int anon;
        Object companion;
        Object obj;
        State state2;
        State state;
        int i4;
        Object obj24;
        int obj27;
        final Object obj3 = targetValue;
        final Composer composer2 = $composer;
        int i10 = -1994373980;
        ComposerKt.sourceInformationMarkerStart(composer2, i10, "C(animateValueAsState)P(3,4!1,5,2)393@18031L21,399@18213L44,400@18279L79,401@18379L38,402@18456L339,413@18814L42,414@18872L44,414@18861L55,417@18945L697,417@18921L721:AnimateAsState.kt#pdpnli");
        String str2 = "CC(remember):AnimateAsState.kt#9igjgp";
        int i25 = 0;
        if (i9 & 4 != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 728506592, str2);
            int i23 = 0;
            composer = $composer;
            i = 0;
            rememberedValue = composer.rememberedValue();
            i2 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i39 = 0;
                i6 = 0;
                composer.updateRememberedValue(AnimationSpecKt.spring$default(i6, i6, i25, 7, i25));
            } else {
                $i$a$CacheAnimateAsStateKt$animateValueAsState$1 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            animationSpec2 = $i$a$CacheAnimateAsStateKt$animateValueAsState$1;
        } else {
            animationSpec2 = animationSpec;
        }
        visibilityThreshold2 = i9 & 8 != 0 ? 0 : visibilityThreshold;
        label2 = i9 & 16 != 0 ? "ValueAnimation" : label;
        finishedListener2 = i9 & 32 != 0 ? 0 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i10, $changed, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:397)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 728512439, str2);
        int i12 = 0;
        Composer composer5 = $composer;
        int i40 = 0;
        Object rememberedValue5 = composer5.rememberedValue();
        int i46 = 0;
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
            empty = 0;
            composer5.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i25, i25, 2, i25));
        } else {
            mutableStateOf$default = rememberedValue5;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, 728514586, str2);
        int i30 = 0;
        Composer composer6 = $composer;
        int i41 = 0;
        rememberedValue2 = composer6.rememberedValue();
        stiffness = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty2 = 0;
            animatable = new Animatable(obj3, typeConverter, visibilityThreshold2, label2);
            composer6.updateRememberedValue(animatable);
        } else {
            twoWayConverter = typeConverter;
            animatable = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(finishedListener2, composer2, i31 &= 14);
        Object obj4 = animationSpec2;
        int i42 = 0;
        if (visibilityThreshold2 != 0 && obj4 instanceof SpringSpec && !Intrinsics.areEqual((SpringSpec)obj4.getVisibilityThreshold(), visibilityThreshold2)) {
            if (obj4 instanceof SpringSpec) {
                if (!Intrinsics.areEqual((SpringSpec)obj4.getVisibilityThreshold(), visibilityThreshold2)) {
                    spring = AnimationSpecKt.spring((SpringSpec)obj4.getDampingRatio(), (SpringSpec)obj4.getStiffness(), visibilityThreshold2);
                } else {
                    spring = obj4;
                }
            } else {
            }
        } else {
        }
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(spring, composer2, 0);
        ComposerKt.sourceInformationMarkerStart(composer2, 728531669, str2);
        int i44 = 0;
        Composer composer7 = $composer;
        empty3 = 0;
        Object rememberedValue3 = composer7.rememberedValue();
        anon = 0;
        int toolingOverride = 6;
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            obj27 = i8;
            obj24 = animationSpec2;
            animationSpec2 = 0;
            composer7.updateRememberedValue(ChannelKt.Channel$default(-1, animationSpec2, animationSpec2, toolingOverride, animationSpec2));
        } else {
            obj24 = animationSpec2;
            obj2 = rememberedValue3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, 728533527, str2);
        int i37 = 4;
        if (toolingOverride ^= i36 > i37) {
            if (!composer2.changedInstance(obj3)) {
                i3 = $changed & 6 == i37 ? 1 : 0;
            } else {
            }
        } else {
        }
        i3 |= changedInstance3;
        Composer composer3 = $composer;
        int i38 = 0;
        Object rememberedValue6 = composer3.rememberedValue();
        empty4 = 0;
        if (i13 == 0) {
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                empty3 = 0;
                obj27 = i13;
                invalid$iv = new AnimateAsStateKt.animateValueAsState.2.1(obj2, obj3);
                composer3.updateRememberedValue((Function0)invalid$iv);
            } else {
                obj27 = i13;
                invalid$iv = rememberedValue6;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.SideEffect((Function0)invalid$iv, composer2, 0);
        ComposerKt.sourceInformationMarkerStart(composer2, 728536516, str2);
        Composer composer4 = $composer;
        int i24 = 0;
        Object rememberedValue4 = composer4.rememberedValue();
        int i45 = 0;
        if (i16 |= changed2 == 0) {
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                empty4 = 0;
                anon = new AnimateAsStateKt.animateValueAsState.3.1(obj2, animatable, rememberUpdatedState2, rememberUpdatedState, 0);
                composer4.updateRememberedValue((Function2)anon);
            } else {
                obj = animatable;
                state = rememberUpdatedState;
                animatable2 = rememberedValue4;
                state2 = rememberUpdatedState2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect(obj2, (Function2)animatable2, composer2, 0);
        if ((State)(MutableState)mutableStateOf$default.getValue() == null) {
            value = obj.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return value;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateValueAsState(Object targetValue, androidx.compose.animation.core.TwoWayConverter typeConverter, androidx.compose.animation.core.AnimationSpec animationSpec, Object visibilityThreshold, Function1 finishedListener, Composer $composer, int $changed, int i8) {
        int i2;
        Object obj;
        int i6;
        int i;
        Object rememberedValue;
        int i7;
        int i5;
        Object $i$a$CacheAnimateAsStateKt$animateValueAsState$4;
        int i3;
        int i4;
        int i9;
        Object obj14;
        int obj15;
        final Composer composer2 = $composer;
        final int i16 = $changed;
        int i10 = -846382129;
        ComposerKt.sourceInformationMarkerStart(composer2, i10, "C(animateValueAsState)P(2,3!1,4)572@23613L21,575@23730L240:AnimateAsState.kt#pdpnli");
        if (i8 & 4 != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 728685216, "CC(remember):AnimateAsState.kt#9igjgp");
            i2 = 0;
            Composer composer = $composer;
            i6 = 0;
            rememberedValue = composer.rememberedValue();
            i7 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i14 = 0;
                i4 = 0;
                i9 = 0;
                composer.updateRememberedValue(AnimationSpecKt.spring$default(i4, i4, i9, 7, i9));
            } else {
                $i$a$CacheAnimateAsStateKt$animateValueAsState$4 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            obj = obj14;
        } else {
            obj = animationSpec;
        }
        i = i8 & 8 != 0 ? obj15 : visibilityThreshold;
        i5 = i8 & 16 != 0 ? obj14 : finishedListener;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i10, i16, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:575)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return AnimateAsStateKt.animateValueAsState(targetValue, typeConverter, obj, i, "ValueAnimation", i5, composer2, obj14 | obj15, 0);
    }

    private static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> $listener$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function1)$listener$delegate.getValue();
    }

    private static final <T> androidx.compose.animation.core.AnimationSpec<T> animateValueAsState$lambda$6(State<? extends androidx.compose.animation.core.AnimationSpec<T>> $animSpec$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (AnimationSpec)$animSpec$delegate.getValue();
    }
}
