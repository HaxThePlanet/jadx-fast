package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a!\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00062\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00062\u0008\u0008\u0002\u0010\n\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"DeltaThresholdForScrollAnimation", "Landroidx/compose/ui/unit/Dp;", "F", "EmptyLazyListMeasureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "NumberOfItemsToTeleport", "", "rememberLazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "initialFirstVisibleItemIndex", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListStateKt {

    private static final float DeltaThresholdForScrollAnimation = 0f;
    private static final androidx.compose.foundation.lazy.LazyListMeasureResult EmptyLazyListMeasureResult = null;
    private static final int NumberOfItemsToTeleport = 100;
    static {
        int i2 = 0;
        LazyListStateKt.DeltaThresholdForScrollAnimation = Dp.constructor-impl((float)i);
        LazyListStateKt.EmptyLazyListMeasureResult.1 anon = new LazyListStateKt.EmptyLazyListMeasureResult.1();
        int i9 = 0;
        int i11 = 0;
        LazyListMeasureResult lazyListMeasureResult = new LazyListMeasureResult(0, i9, i11, 0, (MeasureResult)anon, 0, 0, CoroutineScopeKt.CoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1065353216, 0, 2, 0), ConstraintsKt.Constraints$default(0, 0, i9, i11, 15, 0), obj12, CollectionsKt.emptyList(), 0, 0, 0, 0, Orientation.Vertical, 0, 0, 0);
        LazyListStateKt.EmptyLazyListMeasureResult = lazyListMeasureResult;
    }

    public static final float access$getDeltaThresholdForScrollAnimation$p() {
        return LazyListStateKt.DeltaThresholdForScrollAnimation;
    }

    public static final androidx.compose.foundation.lazy.LazyListMeasureResult access$getEmptyLazyListMeasureResult$p() {
        return LazyListStateKt.EmptyLazyListMeasureResult;
    }

    public static final androidx.compose.foundation.lazy.LazyListState rememberLazyListState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemScrollOffset, androidx.compose.foundation.lazy.LazyListPrefetchStrategy prefetchStrategy, Composer $composer, int $changed, int i6) {
        int i8;
        int i7;
        int i2;
        int invalid$iv;
        boolean traceInProgress;
        boolean changed;
        int changed2;
        int i;
        boolean changedInstance;
        int i5;
        int i9;
        int i3;
        Object obj;
        int str;
        Object rememberedValue;
        int i10;
        Object anon;
        Object obj2;
        int i4;
        final Composer composer2 = $composer;
        final int i25 = $changed;
        int i11 = 1287535208;
        ComposerKt.sourceInformationMarkerStart(composer2, i11, "C(rememberLazyListState)106@4651L39,108@4804L160,108@4722L242:LazyListState.kt#428nma");
        i9 = i6 & 1 != 0 ? i8 : initialFirstVisibleItemIndex;
        i3 = i6 & 2 != 0 ? i7 : initialFirstVisibleItemScrollOffset;
        int i12 = 4;
        String str3 = "CC(remember):LazyListState.kt#9igjgp";
        i5 = 0;
        int i23 = 1;
        if (i6 & 4 != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -61869191, str3);
            int i17 = 0;
            Composer composer3 = $composer;
            str = 0;
            rememberedValue = composer3.rememberedValue();
            i10 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i30 = 0;
                composer3.updateRememberedValue(LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(i5, i23, 0));
            } else {
                obj2 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            obj = invalid$iv;
        } else {
            obj = prefetchStrategy;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i25, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:107)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -61864174, str3);
        if (i18 ^= 6 > i12) {
            if (!composer2.changed(i9)) {
                i2 = i25 & 6 == i12 ? i23 : i5;
            } else {
            }
        } else {
        }
        int i27 = 32;
        if (i19 ^= 48 > i27) {
            if (!composer2.changed(i3)) {
                i = i25 & 48 == i27 ? i23 : i5;
            } else {
            }
        } else {
        }
        int i28 = 256;
        if (i20 ^= 384 > i28) {
            if (!composer2.changedInstance(obj)) {
                if (i25 & 384 == i28) {
                    i5 = i23;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i21 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i29 = 0;
        if (i13 |= i5 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                anon = new LazyListStateKt.rememberLazyListState.3.1(i9, i3, obj);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyListState)RememberSaveableKt.rememberSaveable(/* result */, LazyListState.Companion.saver$foundation_release(obj), 0, (Function0)anon, composer2, 0, 4);
    }

    public static final androidx.compose.foundation.lazy.LazyListState rememberLazyListState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemScrollOffset, Composer $composer, int $changed, int i5) {
        int str;
        int i;
        boolean changed;
        boolean changed2;
        Object empty;
        Object anon;
        int obj8;
        int obj9;
        boolean obj12;
        int i2 = 1470655220;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberLazyListState)81@3758L130,81@3712L176:LazyListState.kt#428nma");
        if (i5 & 1 != 0) {
            obj8 = 0;
        }
        if (i5 &= 2 != 0) {
            obj9 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:80)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -61897676, "CC(remember):LazyListState.kt#9igjgp");
        int i7 = 4;
        int i10 = 1;
        if (i4 ^= 6 > i7) {
            if (!$composer.changed(obj8)) {
                i = $changed & 6 == i7 ? i10 : obj12;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i8 ^= 48 > i11) {
            if (!$composer.changed(obj9)) {
                if ($changed & 48 == i11) {
                    obj12 = i10;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i9 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (obj12 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new LazyListStateKt.rememberLazyListState.1.1(obj8, obj9);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (LazyListState)RememberSaveableKt.rememberSaveable(new Object[obj12], LazyListState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
    }
}
