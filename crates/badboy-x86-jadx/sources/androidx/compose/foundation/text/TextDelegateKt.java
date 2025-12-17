package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a\u000c\u0010\u0018\u001a\u00020\u0010*\u00020\u0019H\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "ceilToIntPx", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextDelegateKt {
    public static final int ceilToIntPx(float $this$ceilToIntPx) {
        final int i = 0;
        return Math.round((float)ceil);
    }

    public static final androidx.compose.foundation.text.TextDelegate updateTextDelegate-rm0N8CA(androidx.compose.foundation.text.TextDelegate current, AnnotatedString text, TextStyle style, Density density, FontFamily.Resolver fontFamilyResolver, boolean softWrap, int overflow, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders) {
        FontFamily.Resolver fontFamilyResolver2;
        androidx.compose.foundation.text.TextDelegate textDelegate;
        Object obj;
        Object obj3;
        int i;
        int i4;
        boolean z;
        int i2;
        Object obj2;
        FontFamily.Resolver resolver;
        Object obj4;
        int i3;
        if (Intrinsics.areEqual(current.getText(), text)) {
            if (Intrinsics.areEqual(current.getStyle(), style)) {
                if (current.getSoftWrap() == softWrap) {
                    if (TextOverflow.equals-impl0(current.getOverflow-gIe3tQ8(), overflow)) {
                        if (current.getMaxLines() == maxLines) {
                            if (current.getMinLines() == minLines) {
                                if (Intrinsics.areEqual(current.getDensity(), density)) {
                                    if (Intrinsics.areEqual(current.getPlaceholders(), placeholders)) {
                                        if (current.getFontFamilyResolver() != fontFamilyResolver) {
                                            textDelegate = new TextDelegate(text, style, i, i4, z, i2, density, resolver, obj4, 0);
                                        } else {
                                            textDelegate = current;
                                        }
                                    } else {
                                        resolver = fontFamilyResolver;
                                    }
                                } else {
                                    resolver = fontFamilyResolver;
                                    obj4 = placeholders;
                                }
                            } else {
                                resolver = fontFamilyResolver;
                                obj4 = placeholders;
                            }
                        } else {
                            resolver = fontFamilyResolver;
                            i4 = minLines;
                            obj4 = placeholders;
                        }
                    } else {
                        resolver = fontFamilyResolver;
                        i = maxLines;
                        i4 = minLines;
                        obj4 = placeholders;
                    }
                } else {
                    resolver = fontFamilyResolver;
                    i2 = overflow;
                    i = maxLines;
                    i4 = minLines;
                    obj4 = placeholders;
                }
            } else {
                resolver = fontFamilyResolver;
                z = softWrap;
                i2 = overflow;
                i = maxLines;
                i4 = minLines;
                obj4 = placeholders;
            }
        } else {
            resolver = fontFamilyResolver;
            z = softWrap;
            i2 = overflow;
            i = maxLines;
            i4 = minLines;
            obj4 = placeholders;
        }
        return textDelegate;
    }

    public static androidx.compose.foundation.text.TextDelegate updateTextDelegate-rm0N8CA$default(androidx.compose.foundation.text.TextDelegate textDelegate, AnnotatedString annotatedString2, TextStyle textStyle3, Density density4, FontFamily.Resolver fontFamily$Resolver5, boolean z6, int i7, int i8, int i9, List list10, int i11, Object object12) {
        int obj6;
        int obj7;
        int obj8;
        int obj9;
        final int i = 1;
        if (i11 & 32 != 0) {
            obj6 = i;
        }
        if (i11 & 64 != 0) {
            obj7 = TextOverflow.Companion.getClip-gIe3tQ8();
        }
        if (i11 & 128 != 0) {
            obj8 = Integer.MAX_VALUE;
        }
        if (i11 &= 256 != 0) {
            obj9 = i;
        }
        return TextDelegateKt.updateTextDelegate-rm0N8CA(textDelegate, annotatedString2, textStyle3, density4, resolver5, obj6, obj7, obj8, obj9, list10);
    }
}
