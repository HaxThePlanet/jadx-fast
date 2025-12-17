package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001ar\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u00082\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"canReuse", "", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "canReuse-7_7YC6M", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutHelperKt {
    public static final boolean canReuse-7_7YC6M(TextLayoutResult $this$canReuse_u2d7_7YC6M, AnnotatedString text, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines, boolean softWrap, int overflow, Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        boolean sameLayoutAffectingAttributes;
        int i;
        TextStyle textStyle;
        Object obj3;
        int i2;
        Object obj;
        LayoutDirection layoutDirection2;
        Object obj2;
        int minWidth-impl;
        int maxHeight-impl;
        int maxHeight-impl2;
        final boolean z = softWrap;
        final int i3 = overflow;
        final TextLayoutInput layoutInput = $this$canReuse_u2d7_7YC6M.getLayoutInput();
        i = 0;
        if ($this$canReuse_u2d7_7YC6M.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return i;
        }
        if (Intrinsics.areEqual(layoutInput.getText(), text)) {
            if (layoutInput.getStyle().hasSameLayoutAffectingAttributes(style)) {
                if (Intrinsics.areEqual(layoutInput.getPlaceholders(), placeholders)) {
                    if (layoutInput.getMaxLines() == maxLines) {
                        if (layoutInput.getSoftWrap() == z) {
                            if (TextOverflow.equals-impl0(layoutInput.getOverflow-gIe3tQ8(), i3)) {
                                if (Intrinsics.areEqual(layoutInput.getDensity(), density)) {
                                    if (layoutInput.getLayoutDirection() == layoutDirection) {
                                        if (!Intrinsics.areEqual(layoutInput.getFontFamilyResolver(), fontFamilyResolver)) {
                                        } else {
                                            if (Constraints.getMinWidth-impl(constraints) != Constraints.getMinWidth-impl(layoutInput.getConstraints-msEJaDk())) {
                                                return i;
                                            }
                                            int i4 = 1;
                                            if (!z && !TextOverflow.equals-impl0(i3, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                                                if (!TextOverflow.equals-impl0(i3, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                                                    return i4;
                                                }
                                            }
                                            if (Constraints.getMaxWidth-impl(constraints) == Constraints.getMaxWidth-impl(layoutInput.getConstraints-msEJaDk()) && Constraints.getMaxHeight-impl(constraints) == Constraints.getMaxHeight-impl(layoutInput.getConstraints-msEJaDk())) {
                                                if (Constraints.getMaxHeight-impl(constraints) == Constraints.getMaxHeight-impl(layoutInput.getConstraints-msEJaDk())) {
                                                    i = i4;
                                                } else {
                                                }
                                            } else {
                                            }
                                        }
                                        return i;
                                    }
                                    obj2 = fontFamilyResolver;
                                } else {
                                    layoutDirection2 = layoutDirection;
                                    obj2 = fontFamilyResolver;
                                }
                            } else {
                                obj = density;
                                layoutDirection2 = layoutDirection;
                                obj2 = fontFamilyResolver;
                            }
                        } else {
                            obj = density;
                            layoutDirection2 = layoutDirection;
                            obj2 = fontFamilyResolver;
                        }
                    } else {
                        obj = density;
                        layoutDirection2 = layoutDirection;
                        obj2 = fontFamilyResolver;
                    }
                } else {
                    i2 = maxLines;
                    obj = density;
                    layoutDirection2 = layoutDirection;
                    obj2 = fontFamilyResolver;
                }
            } else {
                obj3 = placeholders;
                i2 = maxLines;
                obj = density;
                layoutDirection2 = layoutDirection;
                obj2 = fontFamilyResolver;
            }
        } else {
            textStyle = style;
            obj3 = placeholders;
            i2 = maxLines;
            obj = density;
            layoutDirection2 = layoutDirection;
            obj2 = fontFamilyResolver;
        }
        return i;
    }
}
