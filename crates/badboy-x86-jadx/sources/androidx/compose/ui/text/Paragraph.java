package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u00002\u00020\u0001J,\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0008\u0001\u0010#\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000fH&J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fH&J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fH&J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u001a\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0008\u0008\u0002\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fH&J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0007H&J\u0010\u00105\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00106\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00107\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u00109\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000fH&J\u001a\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H&ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u0010\u0010@\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000fH&J\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fH&J*\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH&ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u001d\u0010M\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000fH&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008N\u0010OJ\u0010\u0010P\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u000fH&JZ\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0008\u0008\u0002\u0010V\u001a\u00020\u00072\n\u0008\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\u0008\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\u0008\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u0008\u0008\u0002\u0010]\u001a\u00020^H&ø\u0001\u0000¢\u0006\u0004\u0008_\u0010`J<\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\u0008\u0008\u0002\u0010a\u001a\u00020b2\n\u0008\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\u0008\u0002\u0010Y\u001a\u0004\u0018\u00010ZH&ø\u0001\u0000¢\u0006\u0004\u0008c\u0010dJR\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020S2\u0008\u0008\u0002\u0010a\u001a\u00020b2\n\u0008\u0002\u0010W\u001a\u0004\u0018\u00010X2\n\u0008\u0002\u0010Y\u001a\u0004\u0018\u00010Z2\n\u0008\u0002\u0010[\u001a\u0004\u0018\u00010\\2\u0008\u0008\u0002\u0010]\u001a\u00020^H&ø\u0001\u0000¢\u0006\u0004\u0008e\u0010fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tR\u0012\u0010\u000c\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\tR\u001a\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\t\u0082\u0001\u0001gø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006hÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/text/Paragraph;", "", "didExceedMaxLines", "", "getDidExceedMaxLines", "()Z", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "lineCount", "", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "minIntrinsicWidth", "getMinIntrinsicWidth", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "width", "getWidth", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBaseline", "lineIndex", "getLineBottom", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getRangeForRect", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/text/AndroidParagraph;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Paragraph {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int getLineEnd$default(androidx.compose.ui.text.Paragraph paragraph, int i2, boolean z3, int i4, Object object5) {
            return Paragraph.getLineEnd$default(paragraph, i2, z3, i4, object5);
        }

        public static void paint-LG529CI$default(androidx.compose.ui.text.Paragraph paragraph, Canvas canvas2, long l3, Shadow shadow4, TextDecoration textDecoration5, DrawStyle drawStyle6, int i7, int i8, Object object9) {
            Paragraph.paint-LG529CI$default(paragraph, canvas2, l3, shadow4, textDecoration5, drawStyle6, i7, i8, object9);
        }

        public static void paint-RPmYEkk$default(androidx.compose.ui.text.Paragraph paragraph, Canvas canvas2, long l3, Shadow shadow4, TextDecoration textDecoration5, int i6, Object object7) {
            Paragraph.paint-RPmYEkk$default(paragraph, canvas2, l3, shadow4, textDecoration5, i6, object7);
        }

        public static void paint-hn5TExg$default(androidx.compose.ui.text.Paragraph paragraph, Canvas canvas2, Brush brush3, float f4, Shadow shadow5, TextDecoration textDecoration6, DrawStyle drawStyle7, int i8, int i9, Object object10) {
            Paragraph.paint-hn5TExg$default(paragraph, canvas2, brush3, f4, shadow5, textDecoration6, drawStyle7, i8, i9, object10);
        }
    }
    public static int getLineEnd$default(androidx.compose.ui.text.Paragraph paragraph, int i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            return paragraph.getLineEnd(i2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEnd");
        throw obj0;
    }

    public static void paint-LG529CI$default(androidx.compose.ui.text.Paragraph paragraph, Canvas canvas2, long l3, Shadow shadow4, TextDecoration textDecoration5, DrawStyle drawStyle6, int i7, int i8, Object object9) {
        long unspecified-0d7_KjU;
        int i2;
        int i;
        int shadow;
        int defaultBlendMode-0nO6VwU;
        if (obj15 != null) {
        } else {
            if (object9 & 2 != 0) {
                unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
            } else {
                unspecified-0d7_KjU = l3;
            }
            i = 0;
            i2 = object9 & 4 != 0 ? i : textDecoration5;
            shadow = object9 & 8 != 0 ? i : drawStyle6;
            if (object9 & 16 != 0) {
            } else {
                i = i7;
            }
            if (object9 & 32 != 0) {
                defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
            } else {
                defaultBlendMode-0nO6VwU = i8;
            }
            paragraph.paint-LG529CI(canvas2, unspecified-0d7_KjU, drawStyle6, i2, shadow, i);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-LG529CI");
        throw unsupportedOperationException;
    }

    public static void paint-RPmYEkk$default(androidx.compose.ui.text.Paragraph paragraph, Canvas canvas2, long l3, Shadow shadow4, TextDecoration textDecoration5, int i6, Object object7) {
        long l;
        int i2;
        int i;
        long obj8;
        if (obj13 != null) {
        } else {
            if (object7 & 2 != 0) {
                l = obj8;
            } else {
                l = l3;
            }
            final int obj9 = 0;
            i2 = object7 & 4 != 0 ? obj9 : textDecoration5;
            i = object7 & 8 != 0 ? obj9 : i6;
            paragraph.paint-RPmYEkk(canvas2, l, obj3, i2);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-RPmYEkk");
        throw obj6;
    }

    public static void paint-hn5TExg$default(androidx.compose.ui.text.Paragraph paragraph, Canvas canvas2, Brush brush3, float f4, Shadow shadow5, TextDecoration textDecoration6, DrawStyle drawStyle7, int i8, int i9, Object object10) {
        int i2;
        int i3;
        int i;
        int i4;
        int i5;
        int obj11;
        if (object10 != null) {
        } else {
            i2 = i9 & 4 != 0 ? obj11 : f4;
            int i7 = 0;
            i3 = i9 & 8 != 0 ? i7 : shadow5;
            i = i9 & 16 != 0 ? i7 : textDecoration6;
            i4 = i9 & 32 != 0 ? i7 : drawStyle7;
            if (i9 & 64 != 0) {
                i5 = obj11;
            } else {
                i5 = i8;
            }
            paragraph.paint-hn5TExg(canvas2, brush3, i2, i3, i, i4, i5);
        }
        UnsupportedOperationException obj8 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-hn5TExg");
        throw obj8;
    }

    public abstract void fillBoundingBoxes-8ffj60Q(long l, float[] f2Arr2, int i3);

    public abstract ResolvedTextDirection getBidiRunDirection(int i);

    public abstract Rect getBoundingBox(int i);

    public abstract Rect getCursorRect(int i);

    public abstract boolean getDidExceedMaxLines();

    public abstract float getFirstBaseline();

    public abstract float getHeight();

    public abstract float getHorizontalPosition(int i, boolean z2);

    public abstract float getLastBaseline();

    public abstract float getLineBaseline(int i);

    public abstract float getLineBottom(int i);

    public abstract int getLineCount();

    public abstract int getLineEnd(int i, boolean z2);

    public abstract int getLineForOffset(int i);

    public abstract int getLineForVerticalPosition(float f);

    public abstract float getLineHeight(int i);

    public abstract float getLineLeft(int i);

    public abstract float getLineRight(int i);

    public abstract int getLineStart(int i);

    public abstract float getLineTop(int i);

    public abstract float getLineWidth(int i);

    public abstract float getMaxIntrinsicWidth();

    public abstract float getMinIntrinsicWidth();

    public abstract int getOffsetForPosition-k-4lQ0M(long l);

    public abstract ResolvedTextDirection getParagraphDirection(int i);

    public abstract Path getPathForRange(int i, int i2);

    public abstract List<Rect> getPlaceholderRects();

    public abstract long getRangeForRect-8-6BmAI(Rect rect, int i2, androidx.compose.ui.text.TextInclusionStrategy textInclusionStrategy3);

    public abstract float getWidth();

    public abstract long getWordBoundary--jx7JFs(int i);

    public abstract boolean isLineEllipsized(int i);

    public abstract void paint-LG529CI(Canvas canvas, long l2, Shadow shadow3, TextDecoration textDecoration4, DrawStyle drawStyle5, int i6);

    public abstract void paint-RPmYEkk(Canvas canvas, long l2, Shadow shadow3, TextDecoration textDecoration4);

    public abstract void paint-hn5TExg(Canvas canvas, Brush brush2, float f3, Shadow shadow4, TextDecoration textDecoration5, DrawStyle drawStyle6, int i7);
}
