package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u000c2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000c2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000c2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000c2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000c2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0007H\u0086\u0008¨\u0006\u001e", d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasKt {
    public static final void withClip(Canvas $this$withClip, float left, float top, float right, float bottom, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withClip.clipRect(left, top, right, bottom);
        block.invoke($this$withClip);
        $this$withClip.restoreToCount($this$withClip.save());
    }

    public static final void withClip(Canvas $this$withClip, int left, int top, int right, int bottom, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withClip.clipRect(left, top, right, bottom);
        block.invoke($this$withClip);
        $this$withClip.restoreToCount($this$withClip.save());
    }

    public static final void withClip(Canvas $this$withClip, Path clipPath, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withClip.clipPath(clipPath);
        block.invoke($this$withClip);
        $this$withClip.restoreToCount($this$withClip.save());
    }

    public static final void withClip(Canvas $this$withClip, Rect clipRect, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withClip.clipRect(clipRect);
        block.invoke($this$withClip);
        $this$withClip.restoreToCount($this$withClip.save());
    }

    public static final void withClip(Canvas $this$withClip, RectF clipRect, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withClip.clipRect(clipRect);
        block.invoke($this$withClip);
        $this$withClip.restoreToCount($this$withClip.save());
    }

    public static final void withMatrix(Canvas $this$withMatrix, Matrix matrix, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withMatrix.concat(matrix);
        block.invoke($this$withMatrix);
        $this$withMatrix.restoreToCount($this$withMatrix.save());
    }

    public static void withMatrix$default(Canvas $this$withMatrix_u24default, Matrix matrix, Function1 block, int i4, Object object5) {
        Matrix obj2;
        int obj4;
        if (i4 &= 1 != 0) {
            obj4 = new Matrix();
            obj2 = obj4;
        }
        obj4 = 0;
        $this$withMatrix_u24default.concat(obj2);
        block.invoke($this$withMatrix_u24default);
        $this$withMatrix_u24default.restoreToCount($this$withMatrix_u24default.save());
    }

    public static final void withRotation(Canvas $this$withRotation, float degrees, float pivotX, float pivotY, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withRotation.rotate(degrees, pivotX, pivotY);
        block.invoke($this$withRotation);
        $this$withRotation.restoreToCount($this$withRotation.save());
    }

    public static void withRotation$default(Canvas $this$withRotation_u24default, float degrees, float pivotX, float pivotY, Function1 block, int i6, Object object7) {
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj2 = 0;
        }
        if (i6 & 2 != 0) {
            obj3 = 0;
        }
        if (i6 &= 4 != 0) {
            obj4 = 0;
        }
        int obj6 = 0;
        $this$withRotation_u24default.rotate(obj2, obj3, obj4);
        block.invoke($this$withRotation_u24default);
        $this$withRotation_u24default.restoreToCount($this$withRotation_u24default.save());
    }

    public static final void withSave(Canvas $this$withSave, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        block.invoke($this$withSave);
        $this$withSave.restoreToCount($this$withSave.save());
    }

    public static final void withScale(Canvas $this$withScale, float x, float y, float pivotX, float pivotY, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withScale.scale(x, y, pivotX, pivotY);
        block.invoke($this$withScale);
        $this$withScale.restoreToCount($this$withScale.save());
    }

    public static void withScale$default(Canvas $this$withScale_u24default, float x, float y, float pivotX, float pivotY, Function1 block, int i7, Object object8) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        if (i7 & 1 != 0) {
            obj2 = 1065353216;
        }
        if (i7 & 2 != 0) {
            obj3 = 1065353216;
        }
        if (i7 & 4 != 0) {
            obj4 = 0;
        }
        if (i7 &= 8 != 0) {
            obj5 = 0;
        }
        int obj7 = 0;
        $this$withScale_u24default.scale(obj2, obj3, obj4, obj5);
        block.invoke($this$withScale_u24default);
        $this$withScale_u24default.restoreToCount($this$withScale_u24default.save());
    }

    public static final void withSkew(Canvas $this$withSkew, float x, float y, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withSkew.skew(x, y);
        block.invoke($this$withSkew);
        $this$withSkew.restoreToCount($this$withSkew.save());
    }

    public static void withSkew$default(Canvas $this$withSkew_u24default, float x, float y, Function1 block, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj2 = 0;
        }
        if (i5 &= 2 != 0) {
            obj3 = 0;
        }
        int obj5 = 0;
        $this$withSkew_u24default.skew(obj2, obj3);
        block.invoke($this$withSkew_u24default);
        $this$withSkew_u24default.restoreToCount($this$withSkew_u24default.save());
    }

    public static final void withTranslation(Canvas $this$withTranslation, float x, float y, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        $this$withTranslation.translate(x, y);
        block.invoke($this$withTranslation);
        $this$withTranslation.restoreToCount($this$withTranslation.save());
    }

    public static void withTranslation$default(Canvas $this$withTranslation_u24default, float x, float y, Function1 block, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj2 = 0;
        }
        if (i5 &= 2 != 0) {
            obj3 = 0;
        }
        int obj5 = 0;
        $this$withTranslation_u24default.translate(obj2, obj3);
        block.invoke($this$withTranslation_u24default);
        $this$withTranslation_u24default.restoreToCount($this$withTranslation_u24default.save());
    }
}
