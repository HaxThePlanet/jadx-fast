package androidx.compose.ui.text;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.Hyphens.Companion;
import androidx.compose.ui.text.style.LineBreak.Strategy;
import androidx.compose.ui.text.style.LineBreak.Strategy.Companion;
import androidx.compose.ui.text.style.LineBreak.Strictness;
import androidx.compose.ui.text.style.LineBreak.Strictness.Companion;
import androidx.compose.ui.text.style.LineBreak.WordBreak;
import androidx.compose.ui.text.style.LineBreak.WordBreak.Companion;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\n\u001a\u000c\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u001a\u0016\u0010 \u001a\u00020\u0006*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidParagraph_androidKt {
    public static final java.lang.CharSequence access$attachIndentationFixSpan(java.lang.CharSequence $receiver) {
        return AndroidParagraph_androidKt.attachIndentationFixSpan($receiver);
    }

    public static final int access$numberOfLinesThatFitMaxHeight(TextLayout $receiver, int maxHeight) {
        return AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight($receiver, maxHeight);
    }

    public static final boolean access$shouldAttachIndentationFixSpan(androidx.compose.ui.text.TextStyle textStyle, boolean ellipsis) {
        return AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(textStyle, ellipsis);
    }

    public static final int access$toLayoutAlign-aXe7zB0(int align) {
        return AndroidParagraph_androidKt.toLayoutAlign-aXe7zB0(align);
    }

    public static final int access$toLayoutBreakStrategy-xImikfE(int breakStrategy) {
        return AndroidParagraph_androidKt.toLayoutBreakStrategy-xImikfE(breakStrategy);
    }

    public static final int access$toLayoutHyphenationFrequency--3fSNIE(int hyphens) {
        return AndroidParagraph_androidKt.toLayoutHyphenationFrequency--3fSNIE(hyphens);
    }

    public static final int access$toLayoutLineBreakStyle-hpcqdu8(int lineBreakStrictness) {
        return AndroidParagraph_androidKt.toLayoutLineBreakStyle-hpcqdu8(lineBreakStrictness);
    }

    public static final int access$toLayoutLineBreakWordStyle-wPN0Rpw(int lineBreakWordStyle) {
        return AndroidParagraph_androidKt.toLayoutLineBreakWordStyle-wPN0Rpw(lineBreakWordStyle);
    }

    public static final int access$toLayoutTextGranularity-duNsdkg(int $receiver) {
        return AndroidParagraph_androidKt.toLayoutTextGranularity-duNsdkg($receiver);
    }

    private static final java.lang.CharSequence attachIndentationFixSpan(java.lang.CharSequence $this$attachIndentationFixSpan) {
        int i;
        Object spannableString;
        int i2 = 1;
        i = $this$attachIndentationFixSpan.length() == 0 ? i2 : 0;
        if (i != 0) {
            return $this$attachIndentationFixSpan;
        }
        if ($this$attachIndentationFixSpan instanceof Spannable) {
            spannableString = $this$attachIndentationFixSpan;
        } else {
            spannableString = new SpannableString($this$attachIndentationFixSpan);
        }
        IndentationFixSpan indentationFixSpan = new IndentationFixSpan();
        SpannableExtensions_androidKt.setSpan(spannableString, indentationFixSpan, length2 -= i2, length3 -= i2);
        return (CharSequence)spannableString;
    }

    private static final int numberOfLinesThatFitMaxHeight(TextLayout $this$numberOfLinesThatFitMaxHeight, int maxHeight) {
        int lineIndex;
        int cmp;
        float f;
        lineIndex = 0;
        while (lineIndex < $this$numberOfLinesThatFitMaxHeight.getLineCount()) {
            lineIndex++;
        }
        return $this$numberOfLinesThatFitMaxHeight.getLineCount();
    }

    private static final boolean shouldAttachIndentationFixSpan(androidx.compose.ui.text.TextStyle textStyle, boolean ellipsis) {
        int i;
        boolean equals-impl0;
        long unspecified-e0LSkKk;
        long unspecified-XSAIIZE;
        final Object obj = textStyle;
        final int i2 = 0;
        if (ellipsis && !TextUnit.equals-impl0(obj.getLetterSpacing-XSAIIZE(), obj4) && !TextUnit.equals-impl0(obj.getLetterSpacing-XSAIIZE(), obj4) && !TextAlign.equals-impl0(obj.getTextAlign-e0LSkKk(), TextAlign.Companion.getUnspecified-e0LSkKk()) && !TextAlign.equals-impl0(obj.getTextAlign-e0LSkKk(), TextAlign.Companion.getStart-e0LSkKk()) && !TextAlign.equals-impl0(obj.getTextAlign-e0LSkKk(), TextAlign.Companion.getJustify-e0LSkKk())) {
            if (!TextUnit.equals-impl0(obj.getLetterSpacing-XSAIIZE(), obj4)) {
                if (!TextUnit.equals-impl0(obj.getLetterSpacing-XSAIIZE(), obj4)) {
                    if (!TextAlign.equals-impl0(obj.getTextAlign-e0LSkKk(), TextAlign.Companion.getUnspecified-e0LSkKk())) {
                        if (!TextAlign.equals-impl0(obj.getTextAlign-e0LSkKk(), TextAlign.Companion.getStart-e0LSkKk())) {
                            if (!TextAlign.equals-impl0(obj.getTextAlign-e0LSkKk(), TextAlign.Companion.getJustify-e0LSkKk())) {
                                i = 1;
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
        return i;
    }

    private static final int toLayoutAlign-aXe7zB0(int align) {
        int i2;
        int i;
        i2 = TextAlign.equals-impl0(align, TextAlign.Companion.getLeft-e0LSkKk()) ? 3 : equals-impl02 ? 4 : equals-impl03 ? 2 : equals-impl04 ? i : equals-impl05 ? 1 : i;
        return i2;
    }

    private static final int toLayoutBreakStrategy-xImikfE(int breakStrategy) {
        boolean equals-impl0;
        int i;
        i = 0;
        if (LineBreak.Strategy.equals-impl0(breakStrategy, LineBreak.Strategy.Companion.getSimple-fcGXIks())) {
        } else {
            if (LineBreak.Strategy.equals-impl0(breakStrategy, LineBreak.Strategy.Companion.getHighQuality-fcGXIks())) {
                i = 1;
            } else {
                if (LineBreak.Strategy.equals-impl0(breakStrategy, LineBreak.Strategy.Companion.getBalanced-fcGXIks())) {
                    i = 2;
                } else {
                }
            }
        }
        return i;
    }

    private static final int toLayoutHyphenationFrequency--3fSNIE(int hyphens) {
        int i2;
        int i;
        if (Hyphens.equals-impl0(hyphens, Hyphens.Companion.getAuto-vmbZdU8())) {
            i2 = Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        } else {
            i = 0;
            i2 = Hyphens.equals-impl0(hyphens, Hyphens.Companion.getNone-vmbZdU8()) ? i : i;
        }
        return i2;
    }

    private static final int toLayoutLineBreakStyle-hpcqdu8(int lineBreakStrictness) {
        boolean equals-impl0;
        int i;
        i = 0;
        if (LineBreak.Strictness.equals-impl0(lineBreakStrictness, LineBreak.Strictness.Companion.getDefault-usljTpc())) {
        } else {
            if (LineBreak.Strictness.equals-impl0(lineBreakStrictness, LineBreak.Strictness.Companion.getLoose-usljTpc())) {
                i = 1;
            } else {
                if (LineBreak.Strictness.equals-impl0(lineBreakStrictness, LineBreak.Strictness.Companion.getNormal-usljTpc())) {
                    i = 2;
                } else {
                    if (LineBreak.Strictness.equals-impl0(lineBreakStrictness, LineBreak.Strictness.Companion.getStrict-usljTpc())) {
                        i = 3;
                    } else {
                    }
                }
            }
        }
        return i;
    }

    private static final int toLayoutLineBreakWordStyle-wPN0Rpw(int lineBreakWordStyle) {
        boolean equals-impl0;
        int i;
        i = 0;
        if (LineBreak.WordBreak.equals-impl0(lineBreakWordStyle, LineBreak.WordBreak.Companion.getDefault-jp8hJ3c())) {
        } else {
            if (LineBreak.WordBreak.equals-impl0(lineBreakWordStyle, LineBreak.WordBreak.Companion.getPhrase-jp8hJ3c())) {
                i = 1;
            } else {
            }
        }
        return i;
    }

    private static final int toLayoutTextGranularity-duNsdkg(int $this$toLayoutTextGranularity_u2dduNsdkg) {
        boolean equals-impl0;
        int i;
        i = 0;
        if (TextGranularity.equals-impl0($this$toLayoutTextGranularity_u2dduNsdkg, TextGranularity.Companion.getCharacter-DRrd7Zo())) {
        } else {
            if (TextGranularity.equals-impl0($this$toLayoutTextGranularity_u2dduNsdkg, TextGranularity.Companion.getWord-DRrd7Zo())) {
                i = 1;
            } else {
            }
        }
        return i;
    }
}
