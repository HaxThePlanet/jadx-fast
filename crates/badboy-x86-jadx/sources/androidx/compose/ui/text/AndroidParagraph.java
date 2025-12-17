package androidx.compose.ui.text;

import _COROUTINE.ArtificialStackFrames;
import android.graphics.Canvas;
import android.graphics.Path;
import android.text.Spanned;
import android.text.TextUtils.TruncateAt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u000c\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001Bg\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00080\u0007\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016B%\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0019JJ\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\r2\u0008\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\rH\u0002J,\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0008\u0008\u0001\u0010Z\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\rH\u0016J\u0010\u0010`\u001a\u00020<2\u0006\u0010_\u001a\u00020\rH\u0016J\u0010\u0010a\u001a\u00020<2\u0006\u0010_\u001a\u00020\rH\u0016J\u0018\u0010b\u001a\u00020(2\u0006\u0010_\u001a\u00020\r2\u0006\u0010c\u001a\u00020\u000fH\u0016J\u0015\u0010d\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0002\u0008fJ\u0010\u0010g\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010h\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0015\u0010i\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0000¢\u0006\u0002\u0008jJ\u0018\u0010k\u001a\u00020\r2\u0006\u0010e\u001a\u00020\r2\u0006\u0010l\u001a\u00020\u000fH\u0016J\u0010\u0010m\u001a\u00020\r2\u0006\u0010_\u001a\u00020\rH\u0016J\u0010\u0010n\u001a\u00020\r2\u0006\u0010o\u001a\u00020(H\u0016J\u0010\u0010p\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010q\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010r\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010s\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010t\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010u\u001a\u00020(2\u0006\u0010e\u001a\u00020\rH\u0016J\u001a\u0010v\u001a\u00020\r2\u0006\u0010w\u001a\u00020xH\u0016ø\u0001\u0000¢\u0006\u0004\u0008y\u0010zJ\u0010\u0010{\u001a\u00020^2\u0006\u0010_\u001a\u00020\rH\u0016J\u0018\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\r2\u0006\u0010\u007f\u001a\u00020\rH\u0016J2\u0010\u0080\u0001\u001a\u00020W2\u0007\u0010\u0081\u0001\u001a\u00020<2\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0008\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0086\u0001\u0010\u0087\u0001J \u0010\u0088\u0001\u001a\u00020W2\u0006\u0010_\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\rH\u0016J\u0013\u0010\u008c\u0001\u001a\u00020U2\u0008\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J`\u0010\u008c\u0001\u001a\u00020U2\u0008\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0008\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020(2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0008\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u009a\u0001\u0010\u009b\u0001JA\u0010\u008c\u0001\u001a\u00020U2\u0008\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0008\u0010\u009c\u0001\u001a\u00030\u009d\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u009e\u0001\u0010\u009f\u0001JW\u0010\u008c\u0001\u001a\u00020U2\u0008\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0008\u0010\u009c\u0001\u001a\u00030\u009d\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0008\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008 \u0001\u0010¡\u0001J\u001d\u0010¢\u0001\u001a\u000c\u0012\u0005\u0012\u00030¤\u0001\u0018\u00010£\u0001*\u000200H\u0002¢\u0006\u0003\u0010¥\u0001J\u001c\u0010¦\u0001\u001a\u00020\u000f*\u00030§\u00012\u000c\u0010¨\u0001\u001a\u0007\u0012\u0002\u0008\u00030©\u0001H\u0002R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001fR\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008 \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010%R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010*R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00082\u00103R\u0014\u00104\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00085\u0010*R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00103R\u0014\u00107\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00088\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010>R\u001a\u0010?\u001a\u00020@8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008A\u0010\u001d\u001a\u0004\u0008B\u0010CR\u001a\u0010D\u001a\u00020E8@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008F\u0010\u001d\u001a\u0004\u0008G\u0010HR\u0014\u0010I\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010*\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006ª\u0001", d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "hasSpan", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidParagraph implements androidx.compose.ui.text.Paragraph {

    public static final int $stable = 8;
    private final java.lang.CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    private final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            AndroidParagraph.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    private AndroidParagraph(AndroidParagraphIntrinsics paragraphIntrinsics, int maxLines, boolean ellipsis, long constraints) {
        int i14;
        int i19;
        int style;
        ShaderBrushSpan[] shaderBrushSpans;
        java.lang.CharSequence charSequence;
        int spanStart;
        int maxLines2;
        int maxHeight-impl;
        int minHeight-impl;
        java.lang.CharSequence charSequence$ui_text_release;
        int alignment;
        Iterator iterator;
        int i8;
        int spanEnd;
        int end2;
        int i15;
        float alpha;
        Object[] spans;
        float line;
        Object $this$map$iv;
        int eND;
        TextLayout firstLayout2;
        AndroidTextPaint textPaint$ui_text_release;
        int i;
        int i17;
        int lineBaseline;
        Rect isPlaceholderSpanTruncated;
        int lineEllipsisOffset;
        ArrayList arrayList;
        int i7;
        int lineTop;
        Object[] i2;
        int i18;
        boolean ellipsis2;
        Brush height;
        TextLayout firstLayout;
        androidx.compose.ui.text.TextStyle textStyle;
        int i12;
        int i3;
        int i10;
        int $this$placeholderRects_u24lambda_u245;
        float horizontalPosition;
        int i13;
        ShaderBrushSpan[] objArr;
        ShaderBrushSpan[] shaderBrushSpans2;
        Iterator it;
        int i16;
        int i6;
        ResolvedTextDirection bidiRunDirection;
        int end;
        float f;
        int start;
        int i4;
        int i5;
        int verticalAlign;
        int i9;
        int i11;
        androidx.compose.ui.text.TextStyle span;
        int heightPx;
        final Object obj = this;
        super();
        obj.paragraphIntrinsics = paragraphIntrinsics;
        obj.maxLines = maxLines;
        obj.ellipsis = ellipsis;
        obj.constraints = constraints;
        int i30 = 1;
        if (Constraints.getMinHeight-impl(obj.constraints) == 0 && Constraints.getMinWidth-impl(obj.constraints) == 0) {
            i14 = Constraints.getMinWidth-impl(obj.constraints) == 0 ? i30 : 0;
        } else {
        }
        if (i14 == 0) {
        } else {
            i19 = obj.maxLines >= i30 ? i30 : 0;
            if (i19 == 0) {
            } else {
                androidx.compose.ui.text.TextStyle style2 = obj.paragraphIntrinsics.getStyle();
                if (AndroidParagraph_androidKt.access$shouldAttachIndentationFixSpan(style2, obj.ellipsis)) {
                    charSequence$ui_text_release = AndroidParagraph_androidKt.access$attachIndentationFixSpan(obj.paragraphIntrinsics.getCharSequence$ui_text_release());
                } else {
                    charSequence$ui_text_release = obj.paragraphIntrinsics.getCharSequence$ui_text_release();
                }
                obj.charSequence = charSequence$ui_text_release;
                i15 = TextAlign.equals-impl0(style2.getTextAlign-e0LSkKk(), TextAlign.Companion.getJustify-e0LSkKk()) ? i30 : 0;
                arrayList = AndroidParagraph_androidKt.access$toLayoutHyphenationFrequency--3fSNIE(style2.getParagraphStyle$ui_text_release().getHyphens-vmbZdU8());
                i7 = AndroidParagraph_androidKt.access$toLayoutBreakStrategy-xImikfE(LineBreak.getStrategy-fcGXIks(style2.getLineBreak-rAG3T2k()));
                i2 = AndroidParagraph_androidKt.access$toLayoutLineBreakStyle-hpcqdu8(LineBreak.getStrictness-usljTpc(style2.getLineBreak-rAG3T2k()));
                i18 = AndroidParagraph_androidKt.access$toLayoutLineBreakWordStyle-wPN0Rpw(LineBreak.getWordBreak-jp8hJ3c(style2.getLineBreak-rAG3T2k()));
                final int i31 = 0;
                eND = obj.ellipsis ? TextUtils.TruncateAt.END : i31;
                textStyle = style2;
                style = i22;
                alignment = i15;
                int justificationMode = eND;
                firstLayout2 = obj.constructTextLayout(style, alignment, justificationMode, obj.maxLines, arrayList, i7, i2, i18);
                if (obj.ellipsis) {
                    i12 = style;
                    i10 = alignment;
                    if (firstLayout2.getHeight() > Constraints.getMaxHeight-impl(obj.constraints) && obj.maxLines > i30) {
                        if (obj.maxLines > i30) {
                            ellipsis2 = maxLines2;
                            if (ellipsis2 >= 0 && ellipsis2 != obj.maxLines) {
                                if (ellipsis2 != obj.maxLines) {
                                    firstLayout = textLayout;
                                    firstLayout2 = obj.constructTextLayout(i12, i10, justificationMode, RangesKt.coerceAtLeast(ellipsis2, i30), arrayList, i7, i2, i18);
                                } else {
                                    style = i12;
                                    alignment = i10;
                                    firstLayout2 = firstLayout;
                                }
                            } else {
                            }
                            obj.layout = firstLayout2;
                        } else {
                            firstLayout = firstLayout2;
                            style = i12;
                            alignment = i10;
                            obj.layout = firstLayout;
                        }
                    } else {
                    }
                } else {
                    firstLayout = firstLayout2;
                }
                i3 = style;
                $this$placeholderRects_u24lambda_u245 = alignment;
                iterator = obj.getHeight();
                i13 = justificationMode;
                obj.getTextPaint$ui_text_release().setBrush-12SF9DM(textStyle.getBrush(), SizeKt.Size(obj.getWidth(), iterator), iterator);
                shaderBrushSpans = obj.getShaderBrushSpans(obj.layout);
                if (shaderBrushSpans != null) {
                    iterator = ArrayIteratorKt.iterator(shaderBrushSpans);
                    for (ShaderBrushSpan alpha : iterator) {
                        alpha.setSize-uvyYCjk(SizeKt.Size(obj.getWidth(), obj.getHeight()));
                        shaderBrushSpans = objArr;
                        iterator = it;
                    }
                    shaderBrushSpans2 = shaderBrushSpans;
                } else {
                    shaderBrushSpans2 = shaderBrushSpans;
                }
                charSequence = obj.charSequence;
                i8 = 0;
                if (!charSequence instanceof Spanned) {
                    $this$map$iv = CollectionsKt.emptyList();
                } else {
                    i7 = 0;
                    spans = (Spanned)charSequence.getSpans(i7, charSequence.length(), PlaceholderSpan.class);
                    textPaint$ui_text_release = 0;
                    arrayList = new ArrayList(spans.length);
                    i2 = spans;
                    i18 = 0;
                    firstLayout = i7;
                    while (firstLayout < i2.length) {
                        lineTop = textStyle;
                        i3 = 0;
                        $this$placeholderRects_u24lambda_u245 = charSequence;
                        spanStart = (Spanned)$this$placeholderRects_u24lambda_u245.getSpanStart((PlaceholderSpan)lineTop);
                        spanEnd = (Spanned)$this$placeholderRects_u24lambda_u245.getSpanEnd(lineTop);
                        line = obj.layout.getLineForOffset(spanStart);
                        if (line >= obj.maxLines) {
                        } else {
                        }
                        i = 0;
                        if (obj.layout.getLineEllipsisCount(line) > 0 && spanEnd > obj.layout.getLineEllipsisOffset(line)) {
                        } else {
                        }
                        i17 = 0;
                        if (spanEnd > obj.layout.getLineEnd(line)) {
                        } else {
                        }
                        lineBaseline = 0;
                        start = spanStart;
                        end = spanEnd;
                        i5 = line;
                        i9 = lineBaseline;
                        span = lineTop;
                        isPlaceholderSpanTruncated = i31;
                        (Collection)arrayList.add(isPlaceholderSpanTruncated);
                        firstLayout++;
                        charSequence = $this$placeholderRects_u24lambda_u245;
                        i8 = i13;
                        spans = shaderBrushSpans2;
                        textPaint$ui_text_release = it;
                        i7 = 0;
                        end = spanEnd;
                        horizontalPosition2 -= f3;
                        end2 = 1;
                        f = horizontalPosition;
                        start = spanStart;
                        TextLayout start3 = obj.layout;
                        i4 = 0;
                        i9 = lineBaseline;
                        int i34 = 2;
                        lineBaseline = lineTop.getFontMetrics();
                        i11 = 0;
                        f9 += verticalAlign;
                        i5 = line;
                        isPlaceholderSpanTruncated = new Rect(f, lineTop, f4 += f, f2 += lineTop);
                        span = lineTop;
                        lineTop = lineBaseline - f8;
                        lineBaseline2 += lineBaseline;
                        lineTop = lineBaseline / f7;
                        lineTop = lineBaseline - f11;
                        span = lineTop;
                        lineTop = start3.getLineTop(line);
                        lineTop = lineBaseline - f10;
                        end = spanEnd;
                        horizontalPosition = obj.getHorizontalPosition(spanStart, true);
                        start = spanStart;
                        end = spanEnd;
                        i5 = line;
                        i9 = lineBaseline;
                        span = lineTop;
                        lineBaseline = 1;
                        if (spanEnd > obj.layout.getLineEllipsisOffset(line)) {
                        } else {
                        }
                        i17 = 1;
                        i = 1;
                    }
                    $this$placeholderRects_u24lambda_u245 = charSequence;
                    i13 = i8;
                    shaderBrushSpans2 = spans;
                    it = textPaint$ui_text_release;
                    $this$map$iv = arrayList;
                }
                obj.placeholderRects = $this$map$iv;
            }
            int i20 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxLines should be greater than 0".toString());
            throw illegalArgumentException;
        }
        int i21 = 0;
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        throw illegalArgumentException2;
    }

    public AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i2, boolean z3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(androidParagraphIntrinsics, i2, z3, l4, defaultConstructorMarker5);
    }

    private AndroidParagraph(String text, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis, long constraints, FontFamily.Resolver fontFamilyResolver, Density density) {
        final FontFamily.Resolver resolver = density;
        AndroidParagraphIntrinsics androidParagraphIntrinsics = new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, resolver, obj17);
        super(androidParagraphIntrinsics, maxLines, ellipsis, constraints, resolver, 0);
    }

    public AndroidParagraph(String string, androidx.compose.ui.text.TextStyle textStyle2, List list3, List list4, int i5, boolean z6, long l7, FontFamily.Resolver fontFamily$Resolver8, Density density9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(string, textStyle2, list3, list4, i5, z6, l7, resolver8, density9, defaultConstructorMarker10);
    }

    private final TextLayout constructTextLayout(int alignment, int justificationMode, TextUtils.TruncateAt ellipsize, int maxLines, int hyphens, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle) {
        final Object obj = this;
        TextLayout textLayout = new TextLayout(obj.charSequence, obj.getWidth(), (TextPaint)obj.getTextPaint$ui_text_release(), alignment, ellipsize, obj.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release(), 1065353216, 0, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(obj.paragraphIntrinsics.getStyle()), 1, maxLines, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphens, justificationMode, 0, 0, obj.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release(), 196736, 0);
        return textLayout;
    }

    public static void getCharSequence$ui_text_release$annotations() {
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout $this$getShaderBrushSpans) {
        int i = 0;
        if (!text instanceof Spanned) {
            return i;
        }
        java.lang.CharSequence text2 = $this$getShaderBrushSpans.getText();
        String str = "null cannot be cast to non-null type android.text.Spanned";
        Intrinsics.checkNotNull(text2, str);
        if (!hasSpan((Spanned)text2, ShaderBrushSpan.class)) {
            return i;
        }
        java.lang.CharSequence text3 = $this$getShaderBrushSpans.getText();
        Intrinsics.checkNotNull(text3, str);
        return (ShaderBrushSpan[])(Spanned)text3.getSpans(0, $this$getShaderBrushSpans.getText().length(), ShaderBrushSpan.class);
    }

    public static void getTextLocale$ui_text_release$annotations() {
    }

    public static void getTextPaint$ui_text_release$annotations() {
    }

    private final boolean hasSpan(Spanned $this$hasSpan, Class<?> clazz) {
        int i;
        i = $this$hasSpan.nextSpanTransition(-1, $this$hasSpan.length(), clazz) != $this$hasSpan.length() ? 1 : 0;
        return i;
    }

    private final void paint(Canvas canvas) {
        boolean didExceedMaxLines;
        float height;
        int i;
        final Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            i = 0;
            nativeCanvas.clipRect(i, i, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void fillBoundingBoxes-8ffj60Q(long range, float[] array, int arrayStart) {
        this.layout.fillBoundingBoxes(TextRange.getMin-impl(range), TextRange.getMax-impl(range), arrayStart, obj7);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getBidiRunDirection(int offset) {
        ResolvedTextDirection rtl;
        rtl = this.layout.isRtlCharAt(offset) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
        return rtl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getBoundingBox(int offset) {
        int i;
        int length;
        i = 0;
        if (offset >= 0 && offset < this.charSequence.length()) {
            if (offset < this.charSequence.length()) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            android.graphics.RectF rectF2 = boundingBox;
            int i3 = 0;
            Rect rect = new Rect(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
            return rect;
        }
        int rectF = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("offset(").append(offset).append(") is out of bounds [0,").append(this.charSequence.length()).append(')').toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final java.lang.CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final long getConstraints-msEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getCursorRect(int offset) {
        int length;
        int i;
        int i2 = 0;
        if (offset >= 0 && offset <= this.charSequence.length()) {
            i = offset <= this.charSequence.length() ? 1 : i2;
        } else {
        }
        if (i == 0) {
        } else {
            float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, offset, i2, 2, 0);
            int lineForOffset = this.layout.getLineForOffset(offset);
            Rect rect = new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
            return rect;
        }
        int horizontal = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("offset(").append(offset).append(") is out of bounds [0,").append(this.charSequence.length()).append(']').toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return (float)height;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        float primaryHorizontal$default;
        TextLayout layout;
        int i = 0;
        final int i2 = 2;
        final int i3 = 0;
        if (usePrimaryDirection) {
            primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, offset, i3, i2, i);
        } else {
            primaryHorizontal$default = TextLayout.getSecondaryHorizontal$default(this.layout, offset, i3, i2, i);
        }
        return primaryHorizontal$default;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return getLineBaseline(lineCount--);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLineAscent$ui_text_release(int lineIndex) {
        return this.layout.getLineAscent(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBaseline(int lineIndex) {
        return this.layout.getLineBaseline(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int lineIndex) {
        return this.layout.getLineBottom(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLineDescent$ui_text_release(int lineIndex) {
        return this.layout.getLineDescent(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int lineIndex, boolean visibleEnd) {
        int lineVisibleEnd;
        if (visibleEnd) {
            lineVisibleEnd = this.layout.getLineVisibleEnd(lineIndex);
        } else {
            lineVisibleEnd = this.layout.getLineEnd(lineIndex);
        }
        return lineVisibleEnd;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float vertical) {
        return this.layout.getLineForVertical((int)vertical);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineHeight(int lineIndex) {
        return this.layout.getLineHeight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int lineIndex) {
        return this.layout.getLineTop(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final int getMaxLines() {
        return this.maxLines;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getOffsetForPosition-k-4lQ0M(long position) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int)y-impl), Offset.getX-impl(position));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getParagraphDirection(int offset) {
        ResolvedTextDirection ltr;
        ltr = this.layout.getParagraphDirection(this.layout.getLineForOffset(offset)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
        return ltr;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path getPathForRange(int start, int end) {
        int i;
        int length;
        int i2 = 0;
        if (start >= 0 && start <= end) {
            length = start <= end ? i : i2;
        } else {
        }
        if (length != 0 && end <= this.charSequence.length()) {
            if (end <= this.charSequence.length()) {
            } else {
                i = i2;
            }
        } else {
        }
        if (i == 0) {
        } else {
            Path path2 = new Path();
            this.layout.getSelectionPath(start, end, path2);
            return AndroidPath_androidKt.asComposePath(path2);
        }
        int path = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("start(").append(start).append(") or end(").append(end).append(") is out of range [0..").append(this.charSequence.length()).append("], or start > end!").toString().toString());
        throw illegalArgumentException;
    }

    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public long getRangeForRect-8-6BmAI(Rect rect, int granularity, androidx.compose.ui.text.TextInclusionStrategy inclusionStrategy) {
        AndroidParagraph.getRangeForRect.range.1 anon = new AndroidParagraph.getRangeForRect.range.1(inclusionStrategy);
        int[] rangeForRect = this.layout.getRangeForRect(RectHelper_androidKt.toAndroidRectF(rect), AndroidParagraph_androidKt.access$toLayoutTextGranularity-duNsdkg(granularity), (Function2)anon);
        if (rangeForRect == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        return TextRangeKt.TextRange(rangeForRect[0], rangeForRect[1]);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final Locale getTextLocale$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return (float)maxWidth-impl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public long getWordBoundary--jx7JFs(int offset) {
        androidx.compose.ui.text.android.selection.WordIterator wordIterator = this.layout.getWordIterator();
        return TextRangeKt.TextRange(WordBoundary_androidKt.getWordStart(wordIterator, offset), WordBoundary_androidKt.getWordEnd(wordIterator, offset));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean isLineEllipsized(int lineIndex) {
        return this.layout.isLineEllipsized(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void paint-LG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        AndroidTextPaint textPaint$ui_text_release2 = getTextPaint$ui_text_release();
        final int i = 0;
        textPaint$ui_text_release2.setColor-8_81llA(color);
        textPaint$ui_text_release2.setShadow(textDecoration);
        textPaint$ui_text_release2.setTextDecoration(drawStyle);
        textPaint$ui_text_release2.setDrawStyle(blendMode);
        textPaint$ui_text_release2.setBlendMode-s9anfk8(obj10);
        paint(canvas);
        getTextPaint$ui_text_release().setBlendMode-s9anfk8(getTextPaint$ui_text_release().getBlendMode-0nO6VwU());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void paint-RPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration) {
        final AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        final int i = 0;
        textPaint$ui_text_release.setColor-8_81llA(color);
        textPaint$ui_text_release.setShadow(textDecoration);
        textPaint$ui_text_release.setTextDecoration(obj7);
        paint(canvas);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public void paint-hn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        AndroidTextPaint textPaint$ui_text_release2 = getTextPaint$ui_text_release();
        final int i = 0;
        final float height = getHeight();
        textPaint$ui_text_release2.setBrush-12SF9DM(brush, SizeKt.Size(getWidth(), height), height);
        textPaint$ui_text_release2.setShadow(shadow);
        textPaint$ui_text_release2.setTextDecoration(textDecoration);
        textPaint$ui_text_release2.setDrawStyle(drawStyle);
        textPaint$ui_text_release2.setBlendMode-s9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().setBlendMode-s9anfk8(getTextPaint$ui_text_release().getBlendMode-0nO6VwU());
    }
}
