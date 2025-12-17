package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a!\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a+\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"EmptyLazyGridLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridStateKt {

    private static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult EmptyLazyGridLayoutInfo;
    static {
        LazyGridStateKt.EmptyLazyGridLayoutInfo.1 anon = new LazyGridStateKt.EmptyLazyGridLayoutInfo.1();
        final int i2 = 0;
        LazyGridMeasureResult lazyGridMeasureResult = new LazyGridMeasureResult(i2, 0, 0, 0, (MeasureResult)anon, 0, CoroutineScopeKt.CoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1065353216, 0, 2, i2), 0, (Function1)LazyGridStateKt.EmptyLazyGridLayoutInfo.2.INSTANCE, CollectionsKt.emptyList(), 0, 0, 0, 0, Orientation.Vertical, 0, 0);
        LazyGridStateKt.EmptyLazyGridLayoutInfo = lazyGridMeasureResult;
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult access$getEmptyLazyGridLayoutInfo$p() {
        return LazyGridStateKt.EmptyLazyGridLayoutInfo;
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridState rememberLazyGridState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemScrollOffset, androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy prefetchStrategy, Composer $composer, int $changed, int i6) {
        int i7;
        int i4;
        int i;
        int invalid$iv;
        boolean traceInProgress;
        boolean changed;
        int changed2;
        int i5;
        boolean changedInstance;
        int i3;
        int i10;
        int i2;
        Object obj;
        int str;
        Object rememberedValue;
        int i9;
        Object anon;
        Object obj2;
        int i8;
        final Composer composer2 = $composer;
        final int i25 = $changed;
        int i11 = -20335728;
        ComposerKt.sourceInformationMarkerStart(composer2, i11, "C(rememberLazyGridState)97@4208L39,99@4361L161,99@4279L243:LazyGridState.kt#7791vq");
        i10 = i6 & 1 != 0 ? i7 : initialFirstVisibleItemIndex;
        i2 = i6 & 2 != 0 ? i4 : initialFirstVisibleItemScrollOffset;
        int i12 = 4;
        String str3 = "CC(remember):LazyGridState.kt#9igjgp";
        i3 = 0;
        int i23 = 1;
        if (i6 & 4 != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -890184503, str3);
            int i17 = 0;
            Composer composer3 = $composer;
            str = 0;
            rememberedValue = composer3.rememberedValue();
            i9 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i30 = 0;
                composer3.updateRememberedValue(LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(i3, i23, 0));
            } else {
                obj2 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            obj = invalid$iv;
        } else {
            obj = prefetchStrategy;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i25, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:98)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -890179485, str3);
        if (i18 ^= 6 > i12) {
            if (!composer2.changed(i10)) {
                i = i25 & 6 == i12 ? i23 : i3;
            } else {
            }
        } else {
        }
        int i27 = 32;
        if (i19 ^= 48 > i27) {
            if (!composer2.changed(i2)) {
                i5 = i25 & 48 == i27 ? i23 : i3;
            } else {
            }
        } else {
        }
        int i28 = 256;
        if (i20 ^= 384 > i28) {
            if (!composer2.changedInstance(obj)) {
                if (i25 & 384 == i28) {
                    i3 = i23;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i21 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i29 = 0;
        if (i13 |= i3 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                anon = new LazyGridStateKt.rememberLazyGridState.3.1(i10, i2, obj);
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
        return (LazyGridState)RememberSaveableKt.rememberSaveable(/* result */, LazyGridState.Companion.saver$foundation_release(obj), 0, (Function0)anon, composer2, 0, 4);
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridState rememberLazyGridState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemScrollOffset, Composer $composer, int $changed, int i5) {
        int str;
        int i;
        boolean changed;
        boolean changed2;
        Object empty;
        Object anon;
        int obj8;
        int obj9;
        boolean obj12;
        int i2 = 29186956;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberLazyGridState)72@3315L130,72@3269L176:LazyGridState.kt#7791vq");
        if (i5 & 1 != 0) {
            obj8 = 0;
        }
        if (i5 &= 2 != 0) {
            obj9 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:71)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -890212988, "CC(remember):LazyGridState.kt#9igjgp");
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
                anon = new LazyGridStateKt.rememberLazyGridState.1.1(obj8, obj9);
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
        return (LazyGridState)RememberSaveableKt.rememberSaveable(new Object[obj12], LazyGridState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
    }
}
