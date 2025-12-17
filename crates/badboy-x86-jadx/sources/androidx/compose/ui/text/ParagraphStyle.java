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
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u00083\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001Bq\u0008\u0017\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B5\u0008\u0017\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0015BM\u0008\u0017\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0016Be\u0008\u0017\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0017Bg\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018Jr\u0010;\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J@\u0010;\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?JX\u0010;\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJp\u0010;\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008B\u0010CJ|\u0010;\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u0013\u0010F\u001a\u00020G2\u0008\u0010H\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010I\u001a\u00020JH\u0016J\u0014\u0010K\u001a\u00020\u00002\n\u0008\u0002\u0010H\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010L\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0000H\u0087\u0002J\u0008\u0010M\u001a\u00020NH\u0016R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00118GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u000f8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u001b\u001a\u0004\u0008 \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\u00038GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008#\u0010\u001b\u001a\u0004\u0008$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u00058GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008'\u0010\u001b\u001a\u0004\u0008(\u0010)R\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\u0008*\u0010+R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\u0008-\u0010+R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00100\u001a\u0004\u0008.\u0010/R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\u00085\u0010+R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010,\u001a\u0004\u00086\u0010+R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006O", d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "()V", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getHyphens-vmbZdU8", "()I", "I", "getLineBreak-rAG3T2k", "getLineHeight-XSAIIZE", "()J", "J", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getTextAlign-e0LSkKk", "getTextDirection-s_7X-co", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "copy", "copy-ykzQM6k", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ciSxzs0", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-NH1kkwU", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParagraphStyle {

    public static final int $stable;
    private final int hyphens;
    private final int lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final androidx.compose.ui.text.PlatformParagraphStyle platformStyle;
    private final int textAlign;
    private final int textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;
    static {
    }

    private ParagraphStyle(int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        boolean equals-impl0;
        long l;
        super();
        this.textAlign = textAlign;
        this.textDirection = textDirection;
        this.lineHeight = lineHeight;
        this.textIndent = platformStyle;
        this.platformStyle = lineHeightStyle;
        this.lineHeightStyle = lineBreak;
        this.lineBreak = hyphens;
        this.hyphens = textMotion;
        this.textMotion = obj14;
        if (!TextUnit.equals-impl0(this.lineHeight, obj1)) {
            equals-impl0 = Float.compare(value-impl, l) >= 0 ? 1 : 0;
            if (equals-impl0 == 0) {
            } else {
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("lineHeight can't be negative (").append(TextUnit.getValue-impl(this.lineHeight)).append(')').toString().toString());
            throw illegalStateException;
        }
    }

    public ParagraphStyle(int i, int i2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, int i7, int i8, TextMotion textMotion9, int i10, DefaultConstructorMarker defaultConstructorMarker11) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        long unspecified-XSAIIZE;
        int textIndent;
        int i5;
        int i3;
        int i4;
        int unspecified-rAG3T2k;
        int unspecified-vmbZdU8;
        int i6 = defaultConstructorMarker11;
        if (i6 & 1 != 0) {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        } else {
            unspecified-e0LSkKk = i;
        }
        if (i6 & 2 != 0) {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        } else {
            unspecified-s_7X-co = i2;
        }
        if (i6 & 4 != 0) {
            unspecified-XSAIIZE = TextUnit.Companion.getUnspecified-XSAIIZE();
        } else {
            unspecified-XSAIIZE = l3;
        }
        i5 = 0;
        textIndent = i6 & 8 != 0 ? i5 : platformParagraphStyle5;
        i3 = i6 & 16 != 0 ? i5 : lineHeightStyle6;
        i4 = i6 & 32 != 0 ? i5 : i7;
        if (i6 & 64 != 0) {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        } else {
            unspecified-rAG3T2k = i8;
        }
        if (i6 & 128 != 0) {
            unspecified-vmbZdU8 = Hyphens.Companion.getUnspecified-vmbZdU8();
        } else {
            unspecified-vmbZdU8 = textMotion9;
        }
        if (i6 &= 256 != 0) {
        } else {
            i5 = i10;
        }
        super(unspecified-e0LSkKk, unspecified-s_7X-co, unspecified-XSAIIZE, platformParagraphStyle5, textIndent, i3, i4, unspecified-rAG3T2k, unspecified-vmbZdU8, i5, 0);
    }

    public ParagraphStyle(int i, int i2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, int i7, int i8, TextMotion textMotion9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(i, i2, l3, textIndent4, platformParagraphStyle5, lineHeightStyle6, i7, i8, textMotion9, defaultConstructorMarker10);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        super(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj5, obj18, 0, 0, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), 0, 0);
    }

    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int i;
        int i2;
        long l;
        int i3;
        TextUnit.Companion obj9;
        long obj11;
        final int i4 = 0;
        i = defaultConstructorMarker6 & 1 != 0 ? i4 : textAlign;
        i2 = defaultConstructorMarker6 & 2 != 0 ? i4 : textDirection2;
        if (defaultConstructorMarker6 & 4 != 0) {
            l = obj11;
        } else {
            l = l3;
        }
        i3 = defaultConstructorMarker6 & 8 != 0 ? i4 : i5;
        super(i, i2, l, obj5, i3, 0);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        super(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj5, platformStyle, lineHeightStyle, obj20, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), 0, 0);
    }

    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int obj3;
        int obj4;
        long obj5;
        int obj7;
        int obj8;
        int obj9;
        final int i9 = 0;
        obj3 = defaultConstructorMarker8 & 1 != 0 ? i9 : obj3;
        obj4 = defaultConstructorMarker8 & 2 != 0 ? i9 : obj4;
        if (defaultConstructorMarker8 & 4 != 0) {
            obj5 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        obj7 = defaultConstructorMarker8 & 8 != 0 ? i9 : obj7;
        obj8 = defaultConstructorMarker8 & 16 != 0 ? i9 : obj8;
        obj9 = defaultConstructorMarker8 & 32 != 0 ? i9 : obj9;
        super(obj3, obj4, obj5, obj7, obj7, obj8, obj9, 0);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (hyphens != null) {
            unspecified-rAG3T2k = hyphens.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj22 != null) {
            unbox-impl = obj22.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        super(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj5, platformStyle, lineHeightStyle, lineBreak, unspecified-rAG3T2k, unbox-impl, 0, 0);
    }

    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, LineBreak lineBreak7, Hyphens hyphens8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        int i3;
        int i2;
        int i;
        int i4;
        int obj6;
        int obj7;
        long obj8;
        int obj10;
        i2 = 0;
        obj6 = defaultConstructorMarker10 & 1 != 0 ? i2 : obj6;
        obj7 = defaultConstructorMarker10 & 2 != 0 ? i2 : obj7;
        if (defaultConstructorMarker10 & 4 != 0) {
            obj8 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        obj10 = defaultConstructorMarker10 & 8 != 0 ? i2 : obj10;
        i3 = defaultConstructorMarker10 & 16 != 0 ? i2 : lineHeightStyle6;
        i = defaultConstructorMarker10 & 32 != 0 ? i2 : lineBreak7;
        i4 = defaultConstructorMarker10 & 64 != 0 ? i2 : hyphens8;
        if (defaultConstructorMarker10 & 128 != 0) {
        } else {
            i2 = i9;
        }
        super(obj6, obj7, obj8, obj10, obj10, i3, i, i4, i2, 0);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (hyphens != null) {
            unspecified-rAG3T2k = hyphens.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (textMotion != null) {
            unbox-impl = textMotion.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        super(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj5, platformStyle, lineHeightStyle, lineBreak, unspecified-rAG3T2k, unbox-impl, obj23, 0);
    }

    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, LineBreak lineBreak7, Hyphens hyphens8, TextMotion textMotion9, int i10, DefaultConstructorMarker defaultConstructorMarker11) {
        int i2;
        int i3;
        int i6;
        int i;
        int i4;
        int i5;
        int obj8;
        int obj9;
        long obj10;
        int i7 = defaultConstructorMarker11;
        i3 = 0;
        obj8 = i7 & 1 != 0 ? i3 : obj8;
        obj9 = i7 & 2 != 0 ? i3 : obj9;
        if (i7 & 4 != 0) {
            obj10 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        i2 = i7 & 8 != 0 ? i3 : platformParagraphStyle5;
        i6 = i7 & 16 != 0 ? i3 : lineHeightStyle6;
        i = i7 & 32 != 0 ? i3 : lineBreak7;
        i4 = i7 & 64 != 0 ? i3 : hyphens8;
        i5 = i7 & 128 != 0 ? i3 : textMotion9;
        if (i7 &= 256 != 0) {
        } else {
            i3 = i10;
        }
        super(obj8, obj9, obj10, platformParagraphStyle5, i2, i6, i, i4, i5, i3, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, LineBreak lineBreak7, Hyphens hyphens8, TextMotion textMotion9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(textAlign, textDirection2, l3, textIndent4, platformParagraphStyle5, lineHeightStyle6, lineBreak7, hyphens8, textMotion9, defaultConstructorMarker10);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable constructors.")
    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, LineBreak lineBreak7, Hyphens hyphens8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(textAlign, textDirection2, l3, textIndent4, platformParagraphStyle5, lineHeightStyle6, lineBreak7, hyphens8, defaultConstructorMarker9);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructors.")
    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle5, LineHeightStyle lineHeightStyle6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(textAlign, textDirection2, l3, textIndent4, platformParagraphStyle5, lineHeightStyle6, defaultConstructorMarker7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public ParagraphStyle(TextAlign textAlign, TextDirection textDirection2, long l3, TextIndent textIndent4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(textAlign, textDirection2, l3, textIndent4, defaultConstructorMarker5);
    }

    public static androidx.compose.ui.text.ParagraphStyle copy-Elsmlbk$default(androidx.compose.ui.text.ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection3, long l4, TextIndent textIndent5, int i6, Object object7) {
        TextAlign obj1;
        TextDirection obj2;
        long obj3;
        TextIndent obj5;
        TextIndent obj7;
        if (object7 & 1 != 0) {
            obj1 = TextAlign.box-impl(paragraphStyle.textAlign);
        }
        if (object7 & 2 != 0) {
            obj2 = TextDirection.box-impl(paragraphStyle.textDirection);
        }
        if (object7 & 4 != 0) {
            obj3 = paragraphStyle.lineHeight;
        }
        object7 &= 8;
        obj7 = obj6 != null ? obj5 : i6;
        return paragraphStyle.copy-Elsmlbk(obj1, obj2, obj3, obj6);
    }

    public static androidx.compose.ui.text.ParagraphStyle copy-NH1kkwU$default(androidx.compose.ui.text.ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection3, long l4, TextIndent textIndent5, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle6, LineHeightStyle lineHeightStyle7, LineBreak lineBreak8, Hyphens hyphens9, TextMotion textMotion10, int i11, Object object12) {
        TextAlign obj1;
        TextDirection obj2;
        long obj3;
        TextIndent obj5;
        androidx.compose.ui.text.PlatformParagraphStyle obj6;
        LineHeightStyle obj7;
        LineBreak obj8;
        Hyphens obj9;
        TextMotion obj10;
        TextMotion obj12;
        if (object12 & 1 != 0) {
            obj1 = TextAlign.box-impl(paragraphStyle.textAlign);
        }
        if (object12 & 2 != 0) {
            obj2 = TextDirection.box-impl(paragraphStyle.textDirection);
        }
        if (object12 & 4 != 0) {
            obj3 = paragraphStyle.lineHeight;
        }
        if (object12 & 8 != 0) {
            obj5 = paragraphStyle.textIndent;
        }
        if (object12 & 16 != 0) {
            obj6 = paragraphStyle.platformStyle;
        }
        if (object12 & 32 != 0) {
            obj7 = paragraphStyle.lineHeightStyle;
        }
        if (object12 & 64 != 0) {
            obj8 = LineBreak.box-impl(paragraphStyle.lineBreak);
        }
        if (object12 & 128 != 0) {
            obj9 = Hyphens.box-impl(paragraphStyle.hyphens);
        }
        obj12 = object12 &= 256 != 0 ? obj10 : i11;
        return paragraphStyle.copy-NH1kkwU(obj1, obj2, obj3, obj6, obj5, obj6, obj7, obj8, obj9);
    }

    public static androidx.compose.ui.text.ParagraphStyle copy-ciSxzs0$default(androidx.compose.ui.text.ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection3, long l4, TextIndent textIndent5, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle6, LineHeightStyle lineHeightStyle7, LineBreak lineBreak8, Hyphens hyphens9, int i10, Object object11) {
        TextAlign obj1;
        TextDirection obj2;
        long obj3;
        TextIndent obj5;
        androidx.compose.ui.text.PlatformParagraphStyle obj6;
        LineHeightStyle obj7;
        LineBreak obj8;
        Hyphens obj9;
        Hyphens obj11;
        if (object11 & 1 != 0) {
            obj1 = TextAlign.box-impl(paragraphStyle.textAlign);
        }
        if (object11 & 2 != 0) {
            obj2 = TextDirection.box-impl(paragraphStyle.textDirection);
        }
        if (object11 & 4 != 0) {
            obj3 = paragraphStyle.lineHeight;
        }
        if (object11 & 8 != 0) {
            obj5 = paragraphStyle.textIndent;
        }
        if (object11 & 16 != 0) {
            obj6 = paragraphStyle.platformStyle;
        }
        if (object11 & 32 != 0) {
            obj7 = paragraphStyle.lineHeightStyle;
        }
        if (object11 & 64 != 0) {
            obj8 = LineBreak.box-impl(paragraphStyle.lineBreak);
        }
        if (object11 &= 128 != 0) {
            obj11 = obj9;
        } else {
            obj11 = i10;
        }
        return paragraphStyle.copy-ciSxzs0(obj1, obj2, obj3, obj6, obj5, obj6, obj7, obj8);
    }

    public static androidx.compose.ui.text.ParagraphStyle copy-xPh5V4g$default(androidx.compose.ui.text.ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection3, long l4, TextIndent textIndent5, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle6, LineHeightStyle lineHeightStyle7, int i8, Object object9) {
        TextAlign obj1;
        TextDirection obj2;
        long obj3;
        TextIndent obj5;
        androidx.compose.ui.text.PlatformParagraphStyle obj6;
        LineHeightStyle obj7;
        LineHeightStyle obj9;
        if (object9 & 1 != 0) {
            obj1 = TextAlign.box-impl(paragraphStyle.textAlign);
        }
        if (object9 & 2 != 0) {
            obj2 = TextDirection.box-impl(paragraphStyle.textDirection);
        }
        if (object9 & 4 != 0) {
            obj3 = paragraphStyle.lineHeight;
        }
        if (object9 & 8 != 0) {
            obj5 = paragraphStyle.textIndent;
        }
        if (object9 & 16 != 0) {
            obj6 = paragraphStyle.platformStyle;
        }
        obj9 = object9 &= 32 != 0 ? obj7 : i8;
        return paragraphStyle.copy-xPh5V4g(obj1, obj2, obj3, obj6, obj5, obj6);
    }

    public static androidx.compose.ui.text.ParagraphStyle copy-ykzQM6k$default(androidx.compose.ui.text.ParagraphStyle paragraphStyle, int i2, int i3, long l4, TextIndent textIndent5, androidx.compose.ui.text.PlatformParagraphStyle platformParagraphStyle6, LineHeightStyle lineHeightStyle7, int i8, int i9, TextMotion textMotion10, int i11, Object object12) {
        int obj1;
        int obj2;
        long obj3;
        TextIndent obj5;
        androidx.compose.ui.text.PlatformParagraphStyle obj6;
        LineHeightStyle obj7;
        int obj8;
        int obj9;
        TextMotion obj10;
        TextMotion obj12;
        if (object12 & 1 != 0) {
            obj1 = paragraphStyle.textAlign;
        }
        if (object12 & 2 != 0) {
            obj2 = paragraphStyle.textDirection;
        }
        if (object12 & 4 != 0) {
            obj3 = paragraphStyle.lineHeight;
        }
        if (object12 & 8 != 0) {
            obj5 = paragraphStyle.textIndent;
        }
        if (object12 & 16 != 0) {
            obj6 = paragraphStyle.platformStyle;
        }
        if (object12 & 32 != 0) {
            obj7 = paragraphStyle.lineHeightStyle;
        }
        if (object12 & 64 != 0) {
            obj8 = paragraphStyle.lineBreak;
        }
        if (object12 & 128 != 0) {
            obj9 = paragraphStyle.hyphens;
        }
        obj12 = object12 &= 256 != 0 ? obj10 : i11;
        return paragraphStyle.copy-ykzQM6k(obj1, obj2, obj3, obj6, obj5, obj6, obj7, obj8, obj9);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getHyphens-EaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getLineBreak-LgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getTextAlign-buA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    public static void getTextDirection-mmuk1to$annotations() {
    }

    public static androidx.compose.ui.text.ParagraphStyle merge$default(androidx.compose.ui.text.ParagraphStyle paragraphStyle, androidx.compose.ui.text.ParagraphStyle paragraphStyle2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return paragraphStyle.merge(obj1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.ParagraphStyle copy-Elsmlbk(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj4, obj17, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, 0);
        return paragraphStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public final androidx.compose.ui.text.ParagraphStyle copy-NH1kkwU(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (hyphens != null) {
            unspecified-rAG3T2k = hyphens.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (textMotion != null) {
            unbox-impl = textMotion.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj4, platformStyle, lineHeightStyle, lineBreak, unspecified-rAG3T2k, unbox-impl, obj22, 0);
        return paragraphStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.ParagraphStyle copy-ciSxzs0(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        int unspecified-rAG3T2k;
        int unbox-impl;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        if (hyphens != null) {
            unspecified-rAG3T2k = hyphens.unbox-impl();
        } else {
            unspecified-rAG3T2k = LineBreak.Companion.getUnspecified-rAG3T2k();
        }
        if (obj21 != null) {
            unbox-impl = obj21.unbox-impl();
        } else {
            unbox-impl = Hyphens.Companion.getUnspecified-vmbZdU8();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj4, platformStyle, lineHeightStyle, lineBreak, unspecified-rAG3T2k, unbox-impl, this.textMotion, 0);
        return paragraphStyle;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    public final androidx.compose.ui.text.ParagraphStyle copy-xPh5V4g(TextAlign textAlign, TextDirection textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle) {
        int unspecified-e0LSkKk;
        int unspecified-s_7X-co;
        if (textAlign != null) {
            unspecified-e0LSkKk = textAlign.unbox-impl();
        } else {
            unspecified-e0LSkKk = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        if (textDirection != null) {
            unspecified-s_7X-co = textDirection.unbox-impl();
        } else {
            unspecified-s_7X-co = TextDirection.Companion.getUnspecified-s_7X-co();
        }
        ParagraphStyle paragraphStyle = new ParagraphStyle(unspecified-e0LSkKk, unspecified-s_7X-co, lineHeight, obj4, platformStyle, lineHeightStyle, obj19, this.lineBreak, this.hyphens, this.textMotion, 0);
        return paragraphStyle;
    }

    public final androidx.compose.ui.text.ParagraphStyle copy-ykzQM6k(int textAlign, int textDirection, long lineHeight, TextIndent textIndent, androidx.compose.ui.text.PlatformParagraphStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        ParagraphStyle paragraphStyle = new ParagraphStyle(textAlign, textDirection, lineHeight, obj4, platformStyle, lineHeightStyle, lineBreak, hyphens, textMotion, obj22, 0);
        return paragraphStyle;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ParagraphStyle) {
            return i2;
        }
        if (!TextAlign.equals-impl0(this.textAlign, obj2.textAlign)) {
            return i2;
        }
        if (!TextDirection.equals-impl0(this.textDirection, obj3.textDirection)) {
            return i2;
        }
        if (!TextUnit.equals-impl0(this.lineHeight, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textIndent, obj4.textIndent)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.platformStyle, obj5.platformStyle)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.lineHeightStyle, obj6.lineHeightStyle)) {
            return i2;
        }
        if (!LineBreak.equals-impl0(this.lineBreak, obj7.lineBreak)) {
            return i2;
        }
        if (!Hyphens.equals-impl0(this.hyphens, obj8.hyphens)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textMotion, obj9.textMotion)) {
            return i2;
        }
        return i;
    }

    public final Hyphens getHyphens-EaSxIns() {
        return Hyphens.box-impl(this.hyphens);
    }

    public final int getHyphens-vmbZdU8() {
        return this.hyphens;
    }

    public final LineBreak getLineBreak-LgCVezo() {
        return LineBreak.box-impl(this.lineBreak);
    }

    public final int getLineBreak-rAG3T2k() {
        return this.lineBreak;
    }

    public final long getLineHeight-XSAIIZE() {
        return this.lineHeight;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    public final androidx.compose.ui.text.PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final TextAlign getTextAlign-buA522U() {
        return TextAlign.box-impl(this.textAlign);
    }

    public final int getTextAlign-e0LSkKk() {
        return this.textAlign;
    }

    public final TextDirection getTextDirection-mmuk1to() {
        return TextDirection.box-impl(this.textDirection);
    }

    public final int getTextDirection-s_7X-co() {
        return this.textDirection;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    public int hashCode() {
        int i4;
        int i;
        int i3;
        int i2;
        TextIndent textIndent = this.textIndent;
        i2 = 0;
        if (textIndent != null) {
            i4 = textIndent.hashCode();
        } else {
            i4 = i2;
        }
        androidx.compose.ui.text.PlatformParagraphStyle platformStyle = this.platformStyle;
        if (platformStyle != null) {
            i = platformStyle.hashCode();
        } else {
            i = i2;
        }
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        if (lineHeightStyle != null) {
            i3 = lineHeightStyle.hashCode();
        } else {
            i3 = i2;
        }
        TextMotion textMotion = this.textMotion;
        if (textMotion != null) {
            i2 = textMotion.hashCode();
        }
        return result4 += i2;
    }

    public final androidx.compose.ui.text.ParagraphStyle merge(androidx.compose.ui.text.ParagraphStyle other) {
        if (other == null) {
            return this;
        }
        return ParagraphStyleKt.fastMerge-j5T8yCg(this, other.textAlign, other.textDirection, other.lineHeight, obj4, other.textIndent, other.platformStyle, other.lineHeightStyle, other.lineBreak, other.hyphens);
    }

    public final androidx.compose.ui.text.ParagraphStyle plus(androidx.compose.ui.text.ParagraphStyle other) {
        return merge(other);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ParagraphStyle(textAlign=").append(TextAlign.toString-impl(this.textAlign)).append(", textDirection=").append(TextDirection.toString-impl(this.textDirection)).append(", lineHeight=").append(TextUnit.toString-impl(this.lineHeight)).append(", textIndent=").append(this.textIndent).append(", platformStyle=").append(this.platformStyle).append(", lineHeightStyle=").append(this.lineHeightStyle).append(", lineBreak=").append(LineBreak.toString-impl(this.lineBreak)).append(", hyphens=").append(Hyphens.toString-impl(this.hyphens)).append(", textMotion=").append(this.textMotion).append(')').toString();
    }
}
