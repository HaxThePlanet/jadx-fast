package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0007\u0018\u00002\u00020\u0001B+\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nBY\u0008\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017BY\u0008\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aBY\u0008\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001eJ*\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020>2\u0008\u0008\u0001\u0010B\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020:2\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020:2\u0006\u0010G\u001a\u00020\u0005J\u0016\u0010J\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010N\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u0018\u0010O\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00052\u0008\u0008\u0002\u0010P\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005J\u000e\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\tJ\u000e\u0010T\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010U\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010V\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010X\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0005J\u0018\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\\ø\u0001\u0000¢\u0006\u0004\u0008]\u0010^J\u000e\u0010_\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0005J\u0016\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u0005J(\u0010d\u001a\u00020@2\u0006\u0010e\u001a\u00020:2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iø\u0001\u0000¢\u0006\u0004\u0008j\u0010kJ\u001b\u0010l\u001a\u00020@2\u0006\u0010G\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008m\u0010nJ\u000e\u0010o\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0005JY\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\u0008\u0008\u0002\u0010v\u001a\u00020\t2\n\u0008\u0002\u0010w\u001a\u0004\u0018\u00010x2\n\u0008\u0002\u0010y\u001a\u0004\u0018\u00010z2\n\u0008\u0002\u0010{\u001a\u0004\u0018\u00010|2\u0008\u0008\u0002\u0010}\u001a\u00020~ø\u0001\u0000¢\u0006\u0005\u0008\u007f\u0010\u0080\u0001J@\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\n\u0008\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0008\u0002\u0010w\u001a\u0004\u0018\u00010x2\n\u0008\u0002\u0010y\u001a\u0004\u0018\u00010zH\u0007ø\u0001\u0000¢\u0006\u0006\u0008\u0083\u0001\u0010\u0084\u0001JT\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\n\u0008\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0008\u0002\u0010w\u001a\u0004\u0018\u00010x2\n\u0008\u0002\u0010y\u001a\u0004\u0018\u00010z2\n\u0008\u0002\u0010{\u001a\u0004\u0018\u00010|2\u0008\u0008\u0002\u0010}\u001a\u00020~ø\u0001\u0000¢\u0006\u0006\u0008\u0085\u0001\u0010\u0086\u0001J\u0011\u0010\u0087\u0001\u001a\u00020q2\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0011\u0010\u0088\u0001\u001a\u00020q2\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0011\u0010\u0089\u0001\u001a\u00020q2\u0006\u0010M\u001a\u00020\u0005H\u0002R\u0014\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0011\u0010'\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008,\u0010&R\u0011\u0010-\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u00081\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010/R\u0011\u00103\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u00084\u0010&R\u001a\u00105\u001a\u0008\u0012\u0004\u0012\u0002060\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u00108R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010&\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u008a\u0001", d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "maxLines", "", "ellipsis", "", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)[F", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiParagraph {

    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    private final androidx.compose.ui.text.MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List<androidx.compose.ui.text.ParagraphInfo> paragraphInfoList;
    private final List<Rect> placeholderRects;
    private final float width;
    static {
        final int i = 8;
    }

    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(...))
    public MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle style, float width, Density density, FontFamily.Resolver fontFamilyResolver, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver);
        final int i5 = 0;
        int i2 = 0;
        super(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), i2, 0, 13, i5), i2, maxLines, ellipsis, i5);
    }

    public MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle textStyle2, float f3, Density density4, FontFamily.Resolver fontFamily$Resolver5, List list6, int i7, boolean z8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        int i4;
        int emptyList;
        int i2;
        List list;
        int i3;
        int i;
        int i5 = i9;
        if (i5 & 32 != 0) {
            list = emptyList;
        } else {
            list = list6;
        }
        i3 = i5 & 64 != 0 ? i2 : i7;
        i = i5 &= 128 != 0 ? i4 : z8;
        super(annotatedString, textStyle2, f3, density4, resolver5, list, i3, i);
    }

    private MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle style, long constraints, Density density, FontFamily.Resolver fontFamilyResolver, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, style, maxLines, fontFamilyResolver, placeholders);
        super(multiParagraphIntrinsics, constraints, density, ellipsis, obj15, 0);
    }

    public MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle textStyle2, long l3, Density density4, FontFamily.Resolver fontFamily$Resolver5, List list6, int i7, boolean z8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        int i2;
        int emptyList;
        int i3;
        List list;
        int i4;
        int i;
        int i5 = defaultConstructorMarker10;
        if (i5 & 32 != 0) {
            list = emptyList;
        } else {
            list = i7;
        }
        i4 = i5 & 64 != 0 ? i3 : z8;
        i = i5 &= 128 != 0 ? i2 : i9;
        super(annotatedString, textStyle2, l3, obj6, resolver5, list6, list, i4, i, 0);
    }

    public MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle textStyle2, long l3, Density density4, FontFamily.Resolver fontFamily$Resolver5, List list6, int i7, boolean z8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(annotatedString, textStyle2, l3, density4, resolver5, list6, i7, z8, defaultConstructorMarker9);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @ReplaceWith(...))
    public MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle style, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, int maxLines, boolean ellipsis, float width, Density density, Font.ResourceLoader resourceLoader) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
        final int i5 = 0;
        int i2 = 0;
        super(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), i2, 0, 13, i5), i2, maxLines, ellipsis, i5);
    }

    public MultiParagraph(androidx.compose.ui.text.AnnotatedString annotatedString, androidx.compose.ui.text.TextStyle textStyle2, List list3, int i4, boolean z5, float f6, Density density7, Font.ResourceLoader font$ResourceLoader8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        List list;
        int i2;
        int i;
        List obj12;
        int obj13;
        int obj14;
        if (i9 & 4 != 0) {
            list = obj12;
        } else {
            list = list3;
        }
        i2 = i9 & 8 != 0 ? obj13 : i4;
        i = i9 & 16 != 0 ? obj14 : z5;
        super(annotatedString, textStyle2, list, i2, i, f6, density7, resourceLoader8);
    }

    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(...))
    public MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics intrinsics, int maxLines, boolean ellipsis, float width) {
        super(intrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), 0, 0, 13, 0), obj9, maxLines, ellipsis, 0);
    }

    public MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics multiParagraphIntrinsics, int i2, boolean z3, float f4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        obj2 = i5 & 2 != 0 ? 0x7fffffff /* Unknown resource */ : obj2;
        obj3 = i5 &= 4 != 0 ? 0 : obj3;
        super(multiParagraphIntrinsics, obj2, obj3, f4);
    }

    private MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics intrinsics, long constraints, int maxLines, boolean ellipsis) {
        androidx.compose.ui.text.MultiParagraphIntrinsics multiParagraphIntrinsics;
        int size;
        int i5;
        int i7;
        Rect it;
        int minHeight-impl;
        int i8;
        int currentHeight2;
        Object plus;
        int currentHeight;
        int index$iv$iv2;
        int i17;
        boolean z;
        int currentLineCount;
        int didExceedMaxLines;
        int index;
        int size2;
        int arrayList;
        Object obj;
        int arrayList2;
        int i;
        ArrayList it2;
        boolean didExceedMaxLines2;
        int i12;
        int maxHeight-impl;
        int maxWidth-impl;
        int index$iv$iv;
        int ceilToInt;
        int i16;
        androidx.compose.ui.text.ParagraphInfo paragraphInfo;
        androidx.compose.ui.text.Paragraph paragraph;
        int startIndex;
        int endIndex;
        int i13;
        int global;
        int i10;
        int placeholderRects;
        int i3;
        int i6;
        int i11;
        ArrayList list;
        int i9;
        int i4;
        int i15;
        int i14;
        int $this$fastForEach$iv$iv;
        int i2;
        int index$iv$iv3;
        final Object obj2 = this;
        super();
        obj2.intrinsics = intrinsics;
        obj2.maxLines = ellipsis;
        if (Constraints.getMinWidth-impl(constraints) == 0 && Constraints.getMinHeight-impl(constraints) == 0) {
            i8 = Constraints.getMinHeight-impl(constraints) == 0 ? 1 : i17;
        } else {
        }
        if (i8 == 0) {
        } else {
            currentHeight2 = 0;
            currentLineCount = 0;
            didExceedMaxLines = 0;
            ArrayList arrayList4 = new ArrayList();
            List infoList$ui_text_release = obj2.intrinsics.getInfoList$ui_text_release();
            index = 0;
            while (index < infoList$ui_text_release.size()) {
                obj = infoList$ui_text_release.get(index);
                maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
                if (Constraints.getHasBoundedHeight-impl(constraints)) {
                } else {
                }
                i16 = maxHeight-impl;
                paragraph = ParagraphKt.Paragraph-_EkL_-Y((ParagraphIntrinsicInfo)obj.getIntrinsics(), ConstraintsKt.Constraints$default(0, maxWidth-impl, 0, i16, 5, 0), maxWidth-impl, maxLines2 -= currentLineCount);
                placeholderRects = currentHeight2 + height;
                currentHeight2 = placeholderRects;
                i13 = currentLineCount;
                global = i13 + lineCount;
                currentLineCount = global;
                paragraphInfo = new ParagraphInfo(paragraph, obj.getStartIndex(), obj.getEndIndex(), i13, global, currentHeight2, placeholderRects);
                (List)arrayList4.add(paragraphInfo);
                index++;
                i17 = 0;
                i16 = maxHeight-impl;
            }
            z = obj41;
            obj2.height = currentHeight2;
            obj2.lineCount = currentLineCount;
            obj2.didExceedMaxLines = didExceedMaxLines;
            obj2.paragraphInfoList = arrayList4;
            obj2.width = (float)maxWidth-impl2;
            ArrayList list7 = arrayList4;
            arrayList = 0;
            arrayList2 = new ArrayList(list7.size());
            it2 = list7;
            i12 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < it2.size()) {
                startIndex = 0;
                i13 = 0;
                i10 = 0;
                placeholderRects = (ParagraphInfo)it2.get(index$iv$iv).getParagraph().getPlaceholderRects();
                i3 = 0;
                ArrayList arrayList3 = new ArrayList(placeholderRects.size());
                i6 = 0;
                list = arrayList3;
                size = placeholderRects.size();
                currentHeight = i11;
                while (currentHeight < size) {
                    i15 = 0;
                    int $this$fastForEach$iv$iv2 = i4;
                    i2 = 0;
                    if ((Rect)$this$fastForEach$iv$iv2 != 0) {
                    } else {
                    }
                    index$iv$iv3 = currentHeight;
                    index$iv$iv2 = global;
                    it = 0;
                    (Collection)list.add(it);
                    global = index$iv$iv2;
                    i7 = $this$fastForEach$iv$iv;
                    currentHeight = i18;
                    size = i14;
                    index$iv$iv3 = currentHeight;
                    it = global;
                }
                $this$fastForEach$iv$iv = i7;
                index$iv$iv3 = currentHeight;
                int index$iv$iv4 = global;
                CollectionsKt.addAll((Collection)arrayList2, (Iterable)(List)list);
                index$iv$iv++;
                multiParagraphIntrinsics = intrinsics;
                i5 = ellipsis;
                currentHeight2 = i9;
                i15 = 0;
                $this$fastForEach$iv$iv2 = i4;
                i2 = 0;
                if ((Rect)$this$fastForEach$iv$iv2 != 0) {
                } else {
                }
                index$iv$iv3 = currentHeight;
                index$iv$iv2 = global;
                it = 0;
                (Collection)list.add(it);
                global = index$iv$iv2;
                i7 = $this$fastForEach$iv$iv;
                currentHeight = i18;
                size = i14;
                index$iv$iv3 = currentHeight;
                it = global;
            }
            int currentHeight3 = currentHeight2;
            ArrayList list2 = arrayList2;
            int i20 = 0;
            if ((List)list2.size() < obj2.intrinsics.getPlaceholders().size()) {
                size5 -= size7;
                arrayList = new ArrayList(size2);
                arrayList2 = 0;
                while (arrayList2 < size2) {
                    int i21 = arrayList2;
                    i12 = 0;
                    arrayList.add(null);
                    arrayList2++;
                }
                plus = CollectionsKt.plus((Collection)list2, (Iterable)(List)arrayList);
            } else {
                plus = list2;
            }
            obj2.placeholderRects = plus;
        }
        boolean z2 = obj41;
        int i19 = 0;
        IllegalArgumentException $i$a$RequireMultiParagraph$1 = new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        throw $i$a$RequireMultiParagraph$1;
    }

    public MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics multiParagraphIntrinsics, long l2, int i3, boolean z4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int i2;
        int i;
        int obj11;
        int obj12;
        i2 = defaultConstructorMarker6 & 4 != 0 ? obj11 : z4;
        i = defaultConstructorMarker6 & 8 != 0 ? obj12 : i5;
        super(multiParagraphIntrinsics, l2, obj3, i2, i, 0);
    }

    public MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics multiParagraphIntrinsics, long l2, int i3, boolean z4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(multiParagraphIntrinsics, l2, i3, z4, defaultConstructorMarker5);
    }

    private final androidx.compose.ui.text.AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public static int getLineEnd$default(androidx.compose.ui.text.MultiParagraph multiParagraph, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return multiParagraph.getLineEnd(i2, obj2);
    }

    public static void paint-LG529CI$default(androidx.compose.ui.text.MultiParagraph multiParagraph, Canvas canvas2, long l3, Shadow shadow4, TextDecoration textDecoration5, DrawStyle drawStyle6, int i7, int i8, Object object9) {
        long unspecified-0d7_KjU;
        int i2;
        int i3;
        int i;
        int defaultBlendMode-0nO6VwU;
        if (object9 & 2 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l3;
        }
        i3 = 0;
        i2 = object9 & 4 != 0 ? i3 : textDecoration5;
        i = object9 & 8 != 0 ? i3 : drawStyle6;
        if (object9 & 16 != 0) {
        } else {
            i3 = i7;
        }
        if (object9 & 32 != 0) {
            defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
        } else {
            defaultBlendMode-0nO6VwU = i8;
        }
        multiParagraph.paint-LG529CI(canvas2, unspecified-0d7_KjU, drawStyle6, i2, i, i3);
    }

    public static void paint-RPmYEkk$default(androidx.compose.ui.text.MultiParagraph multiParagraph, Canvas canvas2, long l3, Shadow shadow4, TextDecoration textDecoration5, int i6, Object object7) {
        long l;
        int i;
        int i2;
        long obj8;
        if (object7 & 2 != 0) {
            l = obj8;
        } else {
            l = l3;
        }
        final int obj9 = 0;
        i = object7 & 4 != 0 ? obj9 : textDecoration5;
        i2 = object7 & 8 != 0 ? obj9 : i6;
        multiParagraph.paint-RPmYEkk(canvas2, l, obj3, i);
    }

    public static void paint-hn5TExg$default(androidx.compose.ui.text.MultiParagraph multiParagraph, Canvas canvas2, Brush brush3, float f4, Shadow shadow5, TextDecoration textDecoration6, DrawStyle drawStyle7, int i8, int i9, Object object10) {
        int i5;
        int i4;
        int i3;
        int i;
        int i2;
        int obj11;
        i5 = i9 & 4 != 0 ? obj11 : f4;
        int i7 = 0;
        i4 = i9 & 8 != 0 ? i7 : shadow5;
        i3 = i9 & 16 != 0 ? i7 : textDecoration6;
        i = i9 & 32 != 0 ? i7 : drawStyle7;
        if (i9 & 64 != 0) {
            i2 = obj11;
        } else {
            i2 = i8;
        }
        multiParagraph.paint-hn5TExg(canvas2, brush3, i5, i4, i3, i, i2);
    }

    private final void requireIndexInRange(int offset) {
        int i;
        int length;
        i = 0;
        if (offset >= 0 && offset < getAnnotatedString().getText().length()) {
            if (offset < getAnnotatedString().getText().length()) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("offset(").append(offset).append(") is out of bounds [0, ").append(getAnnotatedString().length()).append(')').toString().toString());
        throw illegalArgumentException;
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        int i;
        int length;
        i = 0;
        if (offset >= 0 && offset <= getAnnotatedString().getText().length()) {
            if (offset <= getAnnotatedString().getText().length()) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("offset(").append(offset).append(") is out of bounds [0, ").append(getAnnotatedString().length()).append(']').toString().toString());
        throw illegalArgumentException;
    }

    private final void requireLineIndexInRange(int lineIndex) {
        int i;
        int lineCount;
        i = 0;
        if (lineIndex >= 0 && lineIndex < this.lineCount) {
            if (lineIndex < this.lineCount) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("lineIndex(").append(lineIndex).append(") is out of bounds [0, ").append(this.lineCount).append(')').toString().toString());
        throw illegalArgumentException;
    }

    public final float[] fillBoundingBoxes-8ffj60Q(long range, float[] array, int arrayStart) {
        requireIndexInRange(TextRange.getMin-impl(range));
        requireIndexInRangeInclusiveEnd(TextRange.getMax-impl(range));
        Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef3 = intRef;
        intRef3.element = obj11;
        Ref.FloatRef floatRef = new Ref.FloatRef();
        final long l = range;
        final Ref.IntRef intRef2 = arrayStart;
        MultiParagraph.fillBoundingBoxes.1 anon = new MultiParagraph.fillBoundingBoxes.1(l, obj3, intRef2, intRef3, floatRef);
        MultiParagraphKt.findParagraphsByRange-Sb-Bc2M(this.paragraphInfoList, l, obj3);
        return intRef2;
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        int paragraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        Object obj = this.paragraphInfoList.get(paragraphByIndex);
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getBidiRunDirection(obj.toLocalIndex(offset));
    }

    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        final int i = 0;
        return obj.toGlobal((ParagraphInfo)obj.getParagraph().getBoundingBox(obj.toLocalIndex(offset)));
    }

    public final Rect getCursorRect(int offset) {
        int paragraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        Object obj = this.paragraphInfoList.get(paragraphByIndex);
        final int i = 0;
        return obj.toGlobal((ParagraphInfo)obj.getParagraph().getCursorRect(obj.toLocalIndex(offset)));
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        int firstBaseline;
        int i;
        if (this.paragraphInfoList.isEmpty()) {
            firstBaseline = 0;
        } else {
            firstBaseline = (ParagraphInfo)this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
        }
        return firstBaseline;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        int paragraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        Object obj = this.paragraphInfoList.get(paragraphByIndex);
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getHorizontalPosition(obj.toLocalIndex(offset), usePrimaryDirection);
    }

    public final androidx.compose.ui.text.MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final float getLastBaseline() {
        int $this$_get_lastBaseline__u24lambda_u240;
        int i;
        float lastBaseline;
        if (this.paragraphInfoList.isEmpty()) {
            $this$_get_lastBaseline__u24lambda_u240 = 0;
        } else {
            Object last = CollectionsKt.last(this.paragraphInfoList);
            i = 0;
            $this$_get_lastBaseline__u24lambda_u240 = last.toGlobalYPosition((ParagraphInfo)last.getParagraph().getLastBaseline());
        }
        return $this$_get_lastBaseline__u24lambda_u240;
    }

    public final float getLineBaseline(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return obj.toGlobalYPosition((ParagraphInfo)obj.getParagraph().getLineBaseline(obj.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return obj.toGlobalYPosition((ParagraphInfo)obj.getParagraph().getLineBottom(obj.toLocalLineIndex(lineIndex)));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return obj.toGlobalIndex((ParagraphInfo)obj.getParagraph().getLineEnd(obj.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final int getLineForOffset(int offset) {
        int paragraphByIndex;
        if (offset >= getAnnotatedString().length()) {
            paragraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            if (offset < 0) {
                paragraphByIndex = 0;
            } else {
                paragraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
            }
        }
        Object obj = this.paragraphInfoList.get(paragraphByIndex);
        final int i = 0;
        return obj.toGlobalLineIndex((ParagraphInfo)obj.getParagraph().getLineForOffset(obj.toLocalIndex(offset)));
    }

    public final int getLineForVerticalPosition(float vertical) {
        int globalLineIndex;
        float localYPosition;
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical));
        final int i = 0;
        if ((ParagraphInfo)obj.getLength() == 0) {
            globalLineIndex = obj.getStartLineIndex();
        } else {
            globalLineIndex = obj.toGlobalLineIndex(obj.getParagraph().getLineForVerticalPosition(obj.toLocalYPosition(vertical)));
        }
        return globalLineIndex;
    }

    public final float getLineHeight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getLineHeight(obj.toLocalLineIndex(lineIndex));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getLineLeft(obj.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getLineRight(obj.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return obj.toGlobalIndex((ParagraphInfo)obj.getParagraph().getLineStart(obj.toLocalLineIndex(lineIndex)));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return obj.toGlobalYPosition((ParagraphInfo)obj.getParagraph().getLineTop(obj.toLocalLineIndex(lineIndex)));
    }

    public final float getLineWidth(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getLineWidth(obj.toLocalLineIndex(lineIndex));
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForPosition-k-4lQ0M(long position) {
        int globalIndex;
        long local-MK-Hz9U;
        Object obj = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.getY-impl(position)));
        final int i = 0;
        if ((ParagraphInfo)obj.getLength() == 0) {
            globalIndex = obj.getStartIndex();
        } else {
            globalIndex = obj.toGlobalIndex(obj.getParagraph().getOffsetForPosition-k-4lQ0M(obj.toLocal-MK-Hz9U(position)));
        }
        return globalIndex;
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        int paragraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        Object obj = this.paragraphInfoList.get(paragraphByIndex);
        final int i = 0;
        return (ParagraphInfo)obj.getParagraph().getParagraphDirection(obj.toLocalIndex(offset));
    }

    public final List<androidx.compose.ui.text.ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    public final Path getPathForRange(int start, int end) {
        int i;
        int length;
        int i2 = 0;
        if (start >= 0 && start <= end) {
            length = start <= end ? i : i2;
        } else {
        }
        if (length != 0 && end <= getAnnotatedString().getText().length()) {
            if (end <= getAnnotatedString().getText().length()) {
            } else {
                i = i2;
            }
        } else {
        }
        if (i == 0) {
        } else {
            if (start == end) {
                return AndroidPath_androidKt.Path();
            }
            Path path = AndroidPath_androidKt.Path();
            MultiParagraph.getPathForRange.2 anon = new MultiParagraph.getPathForRange.2(path, start, end);
            MultiParagraphKt.findParagraphsByRange-Sb-Bc2M(this.paragraphInfoList, TextRangeKt.TextRange(start, end), obj3);
            return path;
        }
        int path3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Start(").append(start).append(") or End(").append(end).append(") is out of range [0..").append(getAnnotatedString().getText().length()).append("), or start > end!").toString().toString());
        throw illegalArgumentException;
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final long getRangeForRect-8-6BmAI(Rect rect, int granularity, androidx.compose.ui.text.TextInclusionStrategy inclusionStrategy) {
        int firstParagraph;
        int lastParagraph;
        int lastIndex;
        long startRange;
        long $i$a$WithMultiParagraph$getRangeForRect$2;
        long endRange;
        long l;
        long $i$a$WithMultiParagraph$getRangeForRect$3;
        Rect local2;
        int rangeForRect-8-6BmAI;
        int local;
        int i;
        int i2;
        int i3;
        final Object obj = this;
        final Rect rect2 = rect;
        final int i4 = granularity;
        final androidx.compose.ui.text.TextInclusionStrategy textInclusionStrategy = inclusionStrategy;
        firstParagraph = MultiParagraphKt.findParagraphByY(obj.paragraphInfoList, rect2.getTop());
        if (Float.compare(bottom, bottom2) < 0) {
            if (firstParagraph == CollectionsKt.getLastIndex(obj.paragraphInfoList)) {
            } else {
                startRange = TextRange.Companion.getZero-d9O1mEE();
                while (TextRange.equals-impl0(startRange, obj7)) {
                    if (firstParagraph <= MultiParagraphKt.findParagraphByY(obj.paragraphInfoList, rect2.getBottom())) {
                    }
                    l = obj5;
                    int i6 = 0;
                    local2 = l.toLocal(rect2);
                    startRange = $i$a$WithMultiParagraph$getRangeForRect$2;
                    firstParagraph++;
                }
                if (TextRange.equals-impl0(startRange, obj7)) {
                    return TextRange.Companion.getZero-d9O1mEE();
                }
                endRange = TextRange.Companion.getZero-d9O1mEE();
                while (TextRange.equals-impl0(endRange, l)) {
                    if (firstParagraph <= lastParagraph) {
                    }
                    local2 = obj6;
                    int i8 = 0;
                    local = local2.toLocal(rect2);
                    endRange = $i$a$WithMultiParagraph$getRangeForRect$3;
                    lastParagraph--;
                }
                if (TextRange.equals-impl0(endRange, l)) {
                    return startRange;
                }
            }
            return TextRangeKt.TextRange(TextRange.getStart-impl(startRange), TextRange.getEnd-impl(endRange));
        }
        Object obj4 = obj3;
        int i5 = 0;
        Rect local3 = obj4.toLocal(rect2);
        return ParagraphInfo.toGlobal-xdX6-G0$default(obj4, (ParagraphInfo)obj4.getParagraph().getRangeForRect-8-6BmAI(local3, i4, textInclusionStrategy), local3, 0, 1);
    }

    public final float getWidth() {
        return this.width;
    }

    public final long getWordBoundary--jx7JFs(int offset) {
        int paragraphByIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        Object obj = this.paragraphInfoList.get(paragraphByIndex);
        final int i = 0;
        final int localIndex = obj.toLocalIndex(offset);
        return obj.toGlobal-xdX6-G0((ParagraphInfo)obj.getParagraph().getWordBoundary--jx7JFs(localIndex), localIndex);
    }

    public final boolean isLineEllipsized(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        final int i = 0;
        return (ParagraphInfo)this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex)).getParagraph().isLineEllipsized(lineIndex);
    }

    public final void paint-LG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        int index$iv;
        Object obj2;
        Object obj;
        int i3;
        float height;
        int i2;
        Canvas canvas2;
        TextDecoration textDecoration;
        DrawStyle drawStyle2;
        int i;
        Object obj4;
        canvas.save();
        final List paragraphInfoList = obj3.paragraphInfoList;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < paragraphInfoList.size()) {
            obj = obj2;
            i3 = 0;
            (ParagraphInfo)obj.getParagraph().paint-LG529CI(canvas, color, obj11, decoration, drawStyle, blendMode);
            canvas.translate(0, obj.getParagraph().getHeight());
            index$iv++;
        }
        canvas.restore();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the new paint function that takes canvas as the only required parameter.")
    public final void paint-RPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration decoration) {
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        float height;
        Canvas canvas2;
        int i;
        TextDecoration textDecoration;
        Object obj3;
        canvas.save();
        final List paragraphInfoList = this.paragraphInfoList;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < paragraphInfoList.size()) {
            obj = obj2;
            i2 = 0;
            (ParagraphInfo)obj.getParagraph().paint-RPmYEkk(canvas, color, obj10, decoration);
            canvas.translate(0, obj.getParagraph().getHeight());
            index$iv++;
        }
        canvas.restore();
    }

    public final void paint-hn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        AndroidMultiParagraphDraw_androidKt.drawMultiParagraph-7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }
}
