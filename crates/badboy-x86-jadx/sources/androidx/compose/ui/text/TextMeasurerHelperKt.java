package androidx.compose.ui.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"DefaultCacheSize", "", "rememberTextMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "cacheSize", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/TextMeasurer;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextMeasurerHelperKt {

    private static final int DefaultCacheSize = 8;
    static {
        final int i = 8;
    }

    public static final androidx.compose.ui.text.TextMeasurer rememberTextMeasurer(int cacheSize, Composer $composer, int $changed, int i4) {
        int i;
        String str;
        int changed;
        Object empty;
        Object textMeasurer;
        int obj9;
        boolean obj12;
        int i2 = 1538166871;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberTextMeasurer)46@1995L7,47@2034L7,48@2089L7,50@2109L151:TextMeasurerHelper.kt#ruzxt2");
        if (i4 &= i != 0) {
            obj9 = TextMeasurerHelperKt.DefaultCacheSize;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.ui.text.rememberTextMeasurer (TextMeasurerHelper.kt:45)");
        }
        int i3 = 6;
        int i6 = 0;
        int i8 = 2023513938;
        String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        obj12 = consume2;
        int i7 = 6;
        int i14 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume3;
        int i15 = 6;
        int i17 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv2 = consume;
        ComposerKt.sourceInformationMarkerStart($composer, 119404045, "CC(remember):TextMeasurerHelper.kt#9igjgp");
        int i16 = 4;
        if (i12 ^= 6 > i16) {
            if (!$composer.changed(obj9)) {
                if ($changed & 6 == i16) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i13 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i18 = 0;
        if (i |= i11 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                textMeasurer = new TextMeasurer(obj12, this_$iv, this_$iv2, obj9);
                composer.updateRememberedValue(textMeasurer);
            } else {
                textMeasurer = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (TextMeasurer)textMeasurer;
    }
}
