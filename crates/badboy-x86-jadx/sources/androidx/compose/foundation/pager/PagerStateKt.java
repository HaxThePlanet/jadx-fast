package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPosition.Start;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000m\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\r\u001a(\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\n2\u0008\u0008\u0003\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u00172\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0015H\u0082\u0008\u001a/\u0010\u001a\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001b\u001a\u00020\n2\u0008\u0008\u0003\u0010\u001c\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0015H\u0007¢\u0006\u0002\u0010\u001d\u001aO\u0010\u001e\u001a\u00020\u0017*\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00132\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00130#2\u001d\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0002\u0008'H\u0082@¢\u0006\u0002\u0010(\u001a\u0012\u0010)\u001a\u00020\u0017*\u00020\u0010H\u0080@¢\u0006\u0002\u0010*\u001a\u0012\u0010+\u001a\u00020\u0017*\u00020\u0010H\u0080@¢\u0006\u0002\u0010*\u001a\u0014\u0010,\u001a\u00020-*\u00020.2\u0006\u0010\u0014\u001a\u00020\nH\u0000\u001a\u0014\u0010/\u001a\u00020-*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u00060", d2 = {"DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "MaxPagesForAnimateScroll", "", "PagesToPrefetch", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "PagerState", "Landroidx/compose/foundation/pager/PagerState;", "currentPage", "currentPageOffsetFraction", "", "pageCount", "Lkotlin/Function0;", "debugLog", "", "generateMsg", "", "rememberPagerState", "initialPage", "initialPageOffsetFraction", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateScrollToPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "calculateNewMaxScrollOffset", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateNewMinScrollOffset", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerStateKt {

    private static final float DefaultPositionThreshold = 0f;
    private static final androidx.compose.foundation.pager.PagerMeasureResult EmptyLayoutInfo = null;
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final androidx.compose.foundation.pager.PagerStateKt.UnitDensity.1 UnitDensity;
    static {
        int i2 = 0;
        PagerStateKt.DefaultPositionThreshold = Dp.constructor-impl((float)i);
        PagerStateKt.EmptyLayoutInfo.1 anon2 = new PagerStateKt.EmptyLayoutInfo.1();
        PagerMeasureResult pagerMeasureResult = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, 0, 0, 0, 0, 0, 0, 0, (SnapPosition)SnapPosition.Start.INSTANCE, (MeasureResult)anon2, 0, 0, 0, CoroutineScopeKt.CoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE), 393216, 0);
        PagerStateKt.EmptyLayoutInfo = pagerMeasureResult;
        PagerStateKt.UnitDensity.1 anon = new PagerStateKt.UnitDensity.1();
        PagerStateKt.UnitDensity = anon;
    }

    public static final androidx.compose.foundation.pager.PagerState PagerState(int currentPage, float currentPageOffsetFraction, Function0<Integer> pageCount) {
        DefaultPagerState defaultPagerState = new DefaultPagerState(currentPage, currentPageOffsetFraction, pageCount);
        return (PagerState)defaultPagerState;
    }

    public static androidx.compose.foundation.pager.PagerState PagerState$default(int i, float f2, Function0 function03, int i4, Object object5) {
        int obj0;
        int obj1;
        if (i4 & 1 != 0) {
            obj0 = 0;
        }
        if (i4 &= 2 != 0) {
            obj1 = 0;
        }
        return PagerStateKt.PagerState(obj0, obj1, function03);
    }

    public static final Object access$animateScrollToPage(LazyLayoutAnimateScrollScope $receiver, int targetPage, float targetPageOffsetToSnappedPosition, AnimationSpec animationSpec, Function2 updateTargetPage, Continuation $completion) {
        return PagerStateKt.animateScrollToPage($receiver, targetPage, targetPageOffsetToSnappedPosition, animationSpec, updateTargetPage, $completion);
    }

    public static final long access$calculateNewMinScrollOffset(androidx.compose.foundation.pager.PagerMeasureResult $receiver, int pageCount) {
        return PagerStateKt.calculateNewMinScrollOffset($receiver, pageCount);
    }

    public static final androidx.compose.foundation.pager.PagerStateKt.UnitDensity.1 access$getUnitDensity$p() {
        return PagerStateKt.UnitDensity;
    }

    private static final Object animateScrollToPage(LazyLayoutAnimateScrollScope $this$animateScrollToPage, int targetPage, float targetPageOffsetToSnappedPosition, AnimationSpec<Float> animationSpec, Function2<? super ScrollScope, ? super Integer, Unit> updateTargetPage, Continuation<? super Unit> $completion) {
        final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = $this$animateScrollToPage;
        PagerStateKt.animateScrollToPage.2 anon = new PagerStateKt.animateScrollToPage.2(updateTargetPage, targetPage, lazyLayoutAnimateScrollScope, targetPageOffsetToSnappedPosition, animationSpec, 0);
        Object obj7 = lazyLayoutAnimateScrollScope.scroll((Function2)anon, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public static final Object animateToNextPage(androidx.compose.foundation.pager.PagerState $this$animateToNextPage, Continuation<? super Unit> $completion) {
        Object obj8 = PagerState.animateScrollToPage$default($this$animateToNextPage, currentPage2 + 1, 0, 0, $completion, 6, 0);
        if (currentPage++ < $this$animateToNextPage.getPageCount() && obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            obj8 = PagerState.animateScrollToPage$default($this$animateToNextPage, currentPage2 + 1, 0, 0, $completion, 6, 0);
            if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj8;
            }
            return Unit.INSTANCE;
        }
        androidx.compose.foundation.pager.PagerState $this$animateToNextPage2 = $this$animateToNextPage;
        return Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(androidx.compose.foundation.pager.PagerState $this$animateToPreviousPage, Continuation<? super Unit> $completion) {
        Object obj8 = PagerState.animateScrollToPage$default($this$animateToPreviousPage, currentPage2 + -1, 0, 0, $completion, 6, 0);
        if (currentPage-- >= 0 && obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            obj8 = PagerState.animateScrollToPage$default($this$animateToPreviousPage, currentPage2 + -1, 0, 0, $completion, 6, 0);
            if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj8;
            }
            return Unit.INSTANCE;
        }
        androidx.compose.foundation.pager.PagerState $this$animateToPreviousPage2 = $this$animateToPreviousPage;
        return Unit.INSTANCE;
    }

    public static final long calculateNewMaxScrollOffset(androidx.compose.foundation.pager.PagerLayoutInfo $this$calculateNewMaxScrollOffset, int pageCount) {
        int height-impl;
        Orientation horizontal = Orientation.Horizontal;
        if ($this$calculateNewMaxScrollOffset.getOrientation() == horizontal) {
            height-impl = IntSize.getWidth-impl($this$calculateNewMaxScrollOffset.getViewportSize-YbymL2g());
        } else {
            height-impl = IntSize.getHeight-impl($this$calculateNewMaxScrollOffset.getViewportSize-YbymL2g());
        }
        final int i8 = height-impl;
        SnapPosition snapPosition = $this$calculateNewMaxScrollOffset.getSnapPosition();
        final int beforeContentPadding2 = $this$calculateNewMaxScrollOffset.getBeforeContentPadding();
        int i6 = 0;
        return RangesKt.coerceAtLeast(i4 - $i$f$debugLog, snapPosition);
    }

    private static final long calculateNewMinScrollOffset(androidx.compose.foundation.pager.PagerMeasureResult $this$calculateNewMinScrollOffset, int pageCount) {
        int height-impl;
        Orientation horizontal = Orientation.Horizontal;
        if ($this$calculateNewMinScrollOffset.getOrientation() == horizontal) {
            height-impl = IntSize.getWidth-impl($this$calculateNewMinScrollOffset.getViewportSize-YbymL2g());
        } else {
            height-impl = IntSize.getHeight-impl($this$calculateNewMinScrollOffset.getViewportSize-YbymL2g());
        }
        final int i2 = height-impl;
        return (long)obj9;
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    public static final float getDefaultPositionThreshold() {
        return PagerStateKt.DefaultPositionThreshold;
    }

    public static final androidx.compose.foundation.pager.PagerMeasureResult getEmptyLayoutInfo() {
        return PagerStateKt.EmptyLayoutInfo;
    }

    public static final androidx.compose.foundation.pager.PagerState rememberPagerState(int initialPage, float initialPageOffsetFraction, Function0<Integer> pageCount, Composer $composer, int $changed, int i6) {
        int str;
        int i;
        boolean changed2;
        boolean changed3;
        int i2;
        int changed;
        Object empty;
        Object anon;
        int obj8;
        int obj9;
        boolean obj13;
        int i3 = -1210768637;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberPagerState)*87@3977L130,87@3927L180:PagerState.kt#g6yjnt");
        if (i6 & 1 != 0) {
            obj8 = 0;
        }
        if (i6 &= 2 != 0) {
            obj9 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:86)");
        }
        obj13 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 17132194, "CC(remember):PagerState.kt#9igjgp");
        int i10 = 4;
        int i14 = 1;
        if (i7 ^= 6 > i10) {
            if (!$composer.changed(obj8)) {
                i = $changed & 6 == i10 ? i14 : obj13;
            } else {
            }
        } else {
        }
        int i15 = 32;
        if (i11 ^= 48 > i15) {
            if (!$composer.changed(obj9)) {
                i2 = $changed & 48 == i15 ? i14 : obj13;
            } else {
            }
        } else {
        }
        int i16 = 256;
        if (i12 ^= 384 > i16) {
            if (!$composer.changed(pageCount)) {
                if ($changed & 384 == i16) {
                    obj13 = i14;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i13 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i17 = 0;
        if (obj13 |= i8 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new PagerStateKt.rememberPagerState.1.1(obj8, obj9, pageCount);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        final Object obj11 = RememberSaveableKt.rememberSaveable(new Object[obj13], DefaultPagerState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
        int i4 = 0;
        (DefaultPagerState)obj11.getPageCountState().setValue(pageCount);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (PagerState)(DefaultPagerState)obj11;
    }
}
