package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"rememberLazyStaggeredGridState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridStateKt {
    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState rememberLazyStaggeredGridState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemScrollOffset, Composer $composer, int $changed, int i5) {
        int str;
        int i;
        boolean changed2;
        boolean changed;
        Object empty;
        Object anon;
        int obj8;
        int obj9;
        boolean obj12;
        int i2 = 161145796;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberLazyStaggeredGridState)73@3626L139,73@3571L194:LazyStaggeredGridState.kt#fzvcnm");
        if (i5 & 1 != 0) {
            obj8 = 0;
        }
        if (i5 &= 2 != 0) {
            obj9 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState (LazyStaggeredGridState.kt:73)");
        }
        obj12 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -1334922713, "CC(remember):LazyStaggeredGridState.kt#9igjgp");
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
                anon = new LazyStaggeredGridStateKt.rememberLazyStaggeredGridState.1.1(obj8, obj9);
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
        return (LazyStaggeredGridState)RememberSaveableKt.rememberSaveable(new Object[obj12], LazyStaggeredGridState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
    }
}
