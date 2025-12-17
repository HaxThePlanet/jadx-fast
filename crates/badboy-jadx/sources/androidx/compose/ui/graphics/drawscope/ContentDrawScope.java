package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0004À\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentDrawScope extends androidx.compose.ui.graphics.drawscope.DrawScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void drawImage-AZ2fEMs(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
            ContentDrawScope.access$drawImage-AZ2fEMs$jd($this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
        }

        @Deprecated
        public static long getCenter-F1C5BW0(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this) {
            return ContentDrawScope.access$getCenter-F1C5BW0$jd($this);
        }

        @Deprecated
        public static long getSize-NH-jbRc(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this) {
            return ContentDrawScope.access$getSize-NH-jbRc$jd($this);
        }

        @Deprecated
        public static void record-JVtK1S4(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, GraphicsLayer $receiver, long size, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
            ContentDrawScope.access$record-JVtK1S4$jd($this, $receiver, size, block);
        }

        @Deprecated
        public static int roundToPx--R2X_6o(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.access$roundToPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static int roundToPx-0680j_4(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.access$roundToPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, int $receiver) {
            return ContentDrawScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static long toDpSize-k-rfVVM(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.access$toDpSize-k-rfVVM$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx--R2X_6o(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.access$toPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx-0680j_4(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.access$toPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, DpRect $receiver) {
            return ContentDrawScope.access$toRect$jd($this, $receiver);
        }

        @Deprecated
        public static long toSize-XkaWNTQ(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
            return ContentDrawScope.access$toSize-XkaWNTQ$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.access$toSp-0xMU5do$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
            return ContentDrawScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, int $receiver) {
            return ContentDrawScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }
    }
    public static void access$drawImage-AZ2fEMs$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, androidx.compose.ui.graphics.drawscope.DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        super.drawImage-AZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    public static long access$getCenter-F1C5BW0$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this) {
        return super.getCenter-F1C5BW0();
    }

    public static long access$getSize-NH-jbRc$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this) {
        return super.getSize-NH-jbRc();
    }

    public static void access$record-JVtK1S4$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, GraphicsLayer $receiver, long size, Function1 block) {
        super.record-JVtK1S4($receiver, size, block);
    }

    public static int access$roundToPx--R2X_6o$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
        return super.roundToPx--R2X_6o($receiver);
    }

    public static int access$roundToPx-0680j_4$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
        return super.roundToPx-0680j_4($receiver);
    }

    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, int $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static long access$toDpSize-k-rfVVM$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
        return super.toDpSize-k-rfVVM($receiver);
    }

    public static float access$toPx--R2X_6o$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
        return super.toPx--R2X_6o($receiver);
    }

    public static float access$toPx-0680j_4$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
        return super.toPx-0680j_4($receiver);
    }

    public static Rect access$toRect$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, DpRect $receiver) {
        return super.toRect($receiver);
    }

    public static long access$toSize-XkaWNTQ$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, long $receiver) {
        return super.toSize-XkaWNTQ($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, float $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.graphics.drawscope.ContentDrawScope $this, int $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public abstract void drawContent();
}
