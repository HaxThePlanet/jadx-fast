package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontSynthesis_androidKt {
    public static final Object synthesizeTypeface-FxwP2eA(int $this$synthesizeTypeface_u2dFxwP2eA, Object typeface, androidx.compose.ui.text.font.Font font, androidx.compose.ui.text.font.FontWeight requestedWeight, int requestedStyle) {
        boolean weightOn-impl$ui_text_release;
        int i;
        int i2;
        int weight;
        androidx.compose.ui.text.font.FontWeight androidBold;
        boolean styleOn-impl$ui_text_release;
        boolean equals-impl0;
        int italic-_-LCdwA;
        if (!typeface instanceof Typeface) {
            return typeface;
        }
        int i3 = 0;
        if (FontSynthesis.isWeightOn-impl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !Intrinsics.areEqual(font.getWeight(), requestedWeight) && requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) < 0) {
            if (!Intrinsics.areEqual(font.getWeight(), requestedWeight)) {
                if (requestedWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0) {
                    i = font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) < 0 ? i2 : i3;
                } else {
                }
            } else {
            }
        } else {
        }
        if (FontSynthesis.isStyleOn-impl$ui_text_release($this$synthesizeTypeface_u2dFxwP2eA) && !FontStyle.equals-impl0(requestedStyle, font.getStyle-_-LCdwA())) {
            if (!FontStyle.equals-impl0(requestedStyle, font.getStyle-_-LCdwA())) {
            } else {
                i2 = i3;
            }
        } else {
        }
        if (i2 == 0 && i == 0) {
            if (i == 0) {
                return typeface;
            }
        }
        if (i != 0) {
            weight = requestedWeight.getWeight();
        } else {
            weight = font.getWeight().getWeight();
        }
        if (i2 != 0) {
            equals-impl0 = FontStyle.equals-impl0(requestedStyle, FontStyle.Companion.getItalic-_-LCdwA());
        } else {
            equals-impl0 = FontStyle.equals-impl0(font.getStyle-_-LCdwA(), FontStyle.Companion.getItalic-_-LCdwA());
        }
        return TypefaceHelperMethodsApi28.INSTANCE.create((Typeface)typeface, weight, equals-impl0);
    }
}
