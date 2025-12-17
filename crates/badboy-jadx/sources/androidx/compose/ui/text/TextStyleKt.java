package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDirection.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\u001a\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"createPlatformTextStyleInternal", "Landroidx/compose/ui/text/PlatformTextStyle;", "platformSpanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "platformParagraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lerp", "Landroidx/compose/ui/text/TextStyle;", "start", "stop", "fraction", "", "resolveDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveTextDirection", "Landroidx/compose/ui/text/style/TextDirection;", "layoutDirection", "textDirection", "resolveTextDirection-IhaHGbI", "(Landroidx/compose/ui/unit/LayoutDirection;I)I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextStyleKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            TextStyleKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final androidx.compose.ui.text.PlatformTextStyle access$createPlatformTextStyleInternal(androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle) {
        return TextStyleKt.createPlatformTextStyleInternal(platformSpanStyle, platformParagraphStyle);
    }

    private static final androidx.compose.ui.text.PlatformTextStyle createPlatformTextStyleInternal(androidx.compose.ui.text.PlatformSpanStyle platformSpanStyle, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle) {
        androidx.compose.ui.text.PlatformTextStyle platformTextStyle;
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            if (platformParagraphStyle == null) {
                platformTextStyle = 0;
            } else {
                platformTextStyle = AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
            }
        } else {
        }
        return platformTextStyle;
    }

    public static final androidx.compose.ui.text.TextStyle lerp(androidx.compose.ui.text.TextStyle start, androidx.compose.ui.text.TextStyle stop, float fraction) {
        TextStyle textStyle = new TextStyle(SpanStyleKt.lerp(start.toSpanStyle(), stop.toSpanStyle(), fraction), ParagraphStyleKt.lerp(start.toParagraphStyle(), stop.toParagraphStyle(), fraction));
        return textStyle;
    }

    public static final androidx.compose.ui.text.TextStyle resolveDefaults(androidx.compose.ui.text.TextStyle style, LayoutDirection direction) {
        TextStyle textStyle = new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(style.getSpanStyle$ui_text_release()), ParagraphStyleKt.resolveParagraphStyleDefaults(style.getParagraphStyle$ui_text_release(), direction), style.getPlatformStyle());
        return textStyle;
    }

    public static final int resolveTextDirection-IhaHGbI(LayoutDirection layoutDirection, int textDirection) {
        int contentOrRtl-s_7X-co;
        int ordinal;
        if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getContent-s_7X-co())) {
            switch (i3) {
                case 1:
                    contentOrRtl-s_7X-co = TextDirection.Companion.getContentOrLtr-s_7X-co();
                    break;
                case 2:
                    contentOrRtl-s_7X-co = TextDirection.Companion.getContentOrRtl-s_7X-co();
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException2;
            }
            return contentOrRtl-s_7X-co;
        }
        if (TextDirection.equals-impl0(textDirection, TextDirection.Companion.getUnspecified-s_7X-co())) {
            switch (i2) {
                case 1:
                    contentOrRtl-s_7X-co = TextDirection.Companion.getLtr-s_7X-co();
                    break;
                case 2:
                    contentOrRtl-s_7X-co = TextDirection.Companion.getRtl-s_7X-co();
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
        }
        contentOrRtl-s_7X-co = textDirection;
    }
}
