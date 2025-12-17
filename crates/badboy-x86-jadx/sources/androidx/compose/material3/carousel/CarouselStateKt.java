package androidx.compose.material3.carousel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"rememberCarouselState", "Landroidx/compose/material3/carousel/CarouselState;", "initialItem", "", "itemCount", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/carousel/CarouselState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CarouselStateKt {
    public static final androidx.compose.material3.carousel.CarouselState rememberCarouselState(int initialItem, Function0<Integer> itemCount, Composer $composer, int $changed, int i5) {
        int changed;
        int i2;
        int i;
        String str;
        int changed2;
        Object empty;
        Object anon;
        int obj9;
        boolean obj13;
        int i3 = -217285684;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberCarouselState)*103@3725L181,103@3679L227:CarouselState.kt#dcf9yb");
        i = 1;
        if (i5 &= i != 0) {
            obj9 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.carousel.rememberCarouselState (CarouselState.kt:102)");
        }
        obj13 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -1536566770, "CC(remember):CarouselState.kt#9igjgp");
        int i9 = 4;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed(obj9)) {
                i2 = $changed & 6 == i9 ? i : obj13;
            } else {
            }
        } else {
        }
        int i12 = 32;
        if (i10 ^= 48 > i12) {
            if (!$composer.changed(itemCount)) {
                if ($changed & 48 == i12) {
                } else {
                    i = obj13;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i13 = 0;
        if (i2 | i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new CarouselStateKt.rememberCarouselState.1.1(obj9, itemCount);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        final Object obj11 = RememberSaveableKt.rememberSaveable(new Object[obj13], CarouselState.Companion.getSaver(), 0, (Function0)anon, composer2, 0, 4);
        int i7 = 0;
        (CarouselState)obj11.getItemCountState().setValue(itemCount);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (CarouselState)obj11;
    }
}
