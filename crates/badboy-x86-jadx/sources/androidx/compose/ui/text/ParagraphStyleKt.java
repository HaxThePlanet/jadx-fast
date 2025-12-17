package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.Hyphens.Companion;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineBreak.Companion;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDirection.Companion;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndent.Companion;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextMotion.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0005\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0008H\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001af\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\u0008\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ParagraphStyleKt {

    private static final long DefaultLineHeight;
    static {
        ParagraphStyleKt.DefaultLineHeight = TextUnit.Companion.getUnspecified-XSAIIZE();
    }

    public static final androidx.compose.ui.text.ParagraphStyle fastMerge-j5T8yCg(androidx.compose.ui.text.ParagraphStyle $this$fastMerge_u2dj5T8yCg, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        boolean equal;
        int i;
        boolean unspecified--R2X_6o;
        int textAlign-e0LSkKk;
        int textDirection-s_7X-co;
        int lineBreak-rAG3T2k;
        int textMotion2;
        boolean z2;
        boolean unspecified--R2X_6o2;
        long lineHeight-XSAIIZE;
        int i5;
        int i4;
        long z;
        Object obj;
        Object obj3;
        int i2;
        int i3;
        Object obj2;
        final androidx.compose.ui.text.ParagraphStyle paragraphStyle = $this$fastMerge_u2dj5T8yCg;
        final int i6 = textAlign;
        final int i7 = textDirection;
        final Object obj4 = platformStyle;
        final Object obj5 = lineHeightStyle;
        final Object obj6 = lineBreak;
        final int i8 = hyphens;
        final int i9 = textMotion;
        final Object obj7 = obj37;
        if (!TextAlign.equals-impl0(i6, TextAlign.Companion.getUnspecified-e0LSkKk())) {
            if (TextAlign.equals-impl0(i6, paragraphStyle.getTextAlign-e0LSkKk())) {
                int i10 = 0;
                unspecified--R2X_6o2 = TextUnitKt.isUnspecified--R2X_6o(lineHeight);
                if (!unspecified--R2X_6o2) {
                    if (TextUnit.equals-impl0(lineHeight, unspecified--R2X_6o2)) {
                        if (obj4 != null) {
                            if (Intrinsics.areEqual(obj4, paragraphStyle.getTextIndent())) {
                                if (!TextDirection.equals-impl0(i7, TextDirection.Companion.getUnspecified-s_7X-co())) {
                                    if (TextDirection.equals-impl0(i7, paragraphStyle.getTextDirection-s_7X-co())) {
                                        if (obj5 != null) {
                                            if (Intrinsics.areEqual(obj5, paragraphStyle.getPlatformStyle())) {
                                                if (obj6 != null) {
                                                    if (Intrinsics.areEqual(obj6, paragraphStyle.getLineHeightStyle())) {
                                                        if (!LineBreak.equals-impl0(i8, LineBreak.Companion.getUnspecified-rAG3T2k())) {
                                                            if (LineBreak.equals-impl0(i8, paragraphStyle.getLineBreak-rAG3T2k())) {
                                                                if (!Hyphens.equals-impl0(i9, Hyphens.Companion.getUnspecified-vmbZdU8())) {
                                                                    if (Hyphens.equals-impl0(i9, paragraphStyle.getHyphens-vmbZdU8())) {
                                                                        if (obj7 != null && !Intrinsics.areEqual(obj7, paragraphStyle.getTextMotion())) {
                                                                            i = !Intrinsics.areEqual(obj7, paragraphStyle.getTextMotion()) ? 1 : 0;
                                                                        } else {
                                                                        }
                                                                    } else {
                                                                    }
                                                                } else {
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    z2 = lineHeight;
                }
            } else {
                z2 = lineHeight;
            }
        } else {
        }
        if (i == 0) {
            return paragraphStyle;
        }
        if (TextUnitKt.isUnspecified--R2X_6o(z2)) {
            z = lineHeight-XSAIIZE;
        } else {
            z = z2;
        }
        if (obj4 == null) {
            obj = unspecified--R2X_6o;
        } else {
            obj = obj4;
        }
        if (!TextAlign.equals-impl0(i6, TextAlign.Companion.getUnspecified-e0LSkKk())) {
            i5 = i6;
        } else {
            i5 = textAlign-e0LSkKk;
        }
        if (!TextDirection.equals-impl0(i7, TextDirection.Companion.getUnspecified-s_7X-co())) {
            i4 = i7;
        } else {
            i4 = textDirection-s_7X-co;
        }
        if (obj6 == null) {
            obj3 = textDirection-s_7X-co;
        } else {
            obj3 = obj6;
        }
        if (!LineBreak.equals-impl0(i8, LineBreak.Companion.getUnspecified-rAG3T2k())) {
            i2 = i8;
        } else {
            i2 = lineBreak-rAG3T2k;
        }
        if (!Hyphens.equals-impl0(i9, Hyphens.Companion.getUnspecified-vmbZdU8())) {
            i3 = i9;
        } else {
            i3 = textMotion2;
        }
        if (obj7 == null) {
            obj2 = textMotion2;
        } else {
            obj2 = obj7;
        }
        ParagraphStyle paragraphStyle2 = new ParagraphStyle(i5, i4, z, obj19, obj, ParagraphStyleKt.mergePlatformStyle(paragraphStyle, obj5), obj3, i2, i3, obj2, 0);
        return paragraphStyle2;
    }

    public static final androidx.compose.ui.text.ParagraphStyle lerp(androidx.compose.ui.text.ParagraphStyle start, androidx.compose.ui.text.ParagraphStyle stop, float fraction) {
        TextIndent textIndent2;
        TextIndent textIndent;
        if (start.getTextIndent() == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        if (stop.getTextIndent() == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle((TextAlign)SpanStyleKt.lerpDiscrete(TextAlign.box-impl(start.getTextAlign-e0LSkKk()), TextAlign.box-impl(stop.getTextAlign-e0LSkKk()), fraction).unbox-impl(), (TextDirection)SpanStyleKt.lerpDiscrete(TextDirection.box-impl(start.getTextDirection-s_7X-co()), TextDirection.box-impl(stop.getTextDirection-s_7X-co()), fraction).unbox-impl(), SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(start.getLineHeight-XSAIIZE(), obj4, stop.getLineHeight-XSAIIZE()), obj4, TextIndentKt.lerp(textIndent2, textIndent, fraction), ParagraphStyleKt.lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), fraction), (LineHeightStyle)SpanStyleKt.lerpDiscrete(start.getLineHeightStyle(), stop.getLineHeightStyle(), fraction), (LineBreak)SpanStyleKt.lerpDiscrete(LineBreak.box-impl(start.getLineBreak-rAG3T2k()), LineBreak.box-impl(stop.getLineBreak-rAG3T2k()), fraction).unbox-impl(), (Hyphens)SpanStyleKt.lerpDiscrete(Hyphens.box-impl(start.getHyphens-vmbZdU8()), Hyphens.box-impl(stop.getHyphens-vmbZdU8()), fraction).unbox-impl(), (TextMotion)SpanStyleKt.lerpDiscrete(start.getTextMotion(), stop.getTextMotion(), fraction), 0);
        return paragraphStyle;
    }

    private static final androidx.compose.ui.text.PlatformParagraphStyle lerpPlatformStyle(androidx.compose.ui.text.PlatformParagraphStyle start, androidx.compose.ui.text.PlatformParagraphStyle stop, float fraction) {
        androidx.compose.ui.text.PlatformParagraphStyle default;
        androidx.compose.ui.text.PlatformParagraphStyle default2;
        if (start == null && stop == null) {
            if (stop == null) {
                return null;
            }
        }
        if (start == null) {
            default = PlatformParagraphStyle.Companion.getDefault();
        } else {
            default = start;
        }
        if (stop == null) {
            default2 = PlatformParagraphStyle.Companion.getDefault();
        } else {
            default2 = stop;
        }
        return AndroidTextStyle_androidKt.lerp(default, default2, fraction);
    }

    private static final androidx.compose.ui.text.PlatformParagraphStyle mergePlatformStyle(androidx.compose.ui.text.ParagraphStyle $this$mergePlatformStyle, androidx.compose.ui.text.PlatformParagraphStyle other) {
        if ($this$mergePlatformStyle.getPlatformStyle() == null) {
            return other;
        }
        if (other == null) {
            return $this$mergePlatformStyle.getPlatformStyle();
        }
        return $this$mergePlatformStyle.getPlatformStyle().merge(other);
    }

    public static final androidx.compose.ui.text.ParagraphStyle resolveParagraphStyleDefaults(androidx.compose.ui.text.ParagraphStyle style, LayoutDirection direction) {
        int textAlign-e0LSkKk;
        long lineHeight-XSAIIZE;
        TextIndent textIndent;
        int lineBreak-rAG3T2k;
        int none-vmbZdU8;
        TextMotion textMotion;
        if (TextAlign.equals-impl0(style.getTextAlign-e0LSkKk(), TextAlign.Companion.getUnspecified-e0LSkKk())) {
            textAlign-e0LSkKk = TextAlign.Companion.getStart-e0LSkKk();
        } else {
            textAlign-e0LSkKk = style.getTextAlign-e0LSkKk();
        }
        if (TextUnitKt.isUnspecified--R2X_6o(style.getLineHeight-XSAIIZE())) {
            lineHeight-XSAIIZE = ParagraphStyleKt.DefaultLineHeight;
        } else {
            lineHeight-XSAIIZE = style.getLineHeight-XSAIIZE();
        }
        if (style.getTextIndent() == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        if (LineBreak.equals-impl0(style.getLineBreak-rAG3T2k(), LineBreak.Companion.getUnspecified-rAG3T2k())) {
            lineBreak-rAG3T2k = LineBreak.Companion.getSimple-rAG3T2k();
        } else {
            lineBreak-rAG3T2k = style.getLineBreak-rAG3T2k();
        }
        if (Hyphens.equals-impl0(style.getHyphens-vmbZdU8(), Hyphens.Companion.getUnspecified-vmbZdU8())) {
            none-vmbZdU8 = Hyphens.Companion.getNone-vmbZdU8();
        } else {
            none-vmbZdU8 = style.getHyphens-vmbZdU8();
        }
        if (style.getTextMotion() == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(textAlign-e0LSkKk, TextStyleKt.resolveTextDirection-IhaHGbI(direction, style.getTextDirection-s_7X-co()), lineHeight-XSAIIZE, obj4, textIndent, style.getPlatformStyle(), style.getLineHeightStyle(), lineBreak-rAG3T2k, none-vmbZdU8, textMotion, 0);
        return paragraphStyle;
    }
}
