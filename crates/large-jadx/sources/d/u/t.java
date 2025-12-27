package d.u;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: TransitionUtils.java */
/* loaded from: classes.dex */
class t {

    private static final boolean a = false;
    private static final boolean b = false;
    private static final boolean c = false;
    static {
        final int sDK_INT2 = Build.VERSION.SDK_INT;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        final Matrix matrix = new Matrix();
        matrix.setTranslate((float)-view2.getScrollX(), (float)-view2.getScrollY());
        f0.i(view, matrix);
        f0.j(viewGroup, matrix);
        float f4 = 0.0f;
        RectF rectF = new RectF(f4, f4, (float)view.getWidth(), (float)view.getHeight());
        matrix.mapRect(rectF);
        int rounded = Math.round(rectF.left);
        int rounded2 = Math.round(rectF.top);
        int rounded3 = Math.round(rectF.right);
        int rounded4 = Math.round(rectF.bottom);
        final ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmap = t.b(view, matrix, rectF, viewGroup);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        int i3 = 1073741824;
        imageView.measure(View.MeasureSpec.makeMeasureSpec(rounded3 - rounded, i3), View.MeasureSpec.makeMeasureSpec(rounded4 - rounded2, i3));
        imageView.layout(rounded, rounded2, rounded3, rounded4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        int indexOfChild;
        android.view.ViewParent parent;
        boolean attachedToWindow;
        int i = 0;
        indexOfChild = 0;
        if (!t.a) {
        } else {
            indexOfChild = !view.isAttachedToWindow();
            if (viewGroup == null) {
            } else {
                attachedToWindow = viewGroup.isAttachedToWindow();
            }
        }
        final boolean z2 = t.b;
        i = 0;
        if (!t.b || t.a == 0) {
        } else {
            if (!attachedToWindow) {
                return null;
            }
            indexOfChild = (ViewGroup)view.getParent().indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int rounded = Math.round(rectF.width());
        int rounded2 = Math.round(rectF.height());
        if (rounded > 0 && rounded2 > 0) {
            f = (float)(rounded * rounded2);
            float min = Math.min(1f, 1048576f / f);
            rounded = Math.round((float)rounded * min);
            rounded2 = Math.round((float)rounded2 * min);
            i2 = -rectF.left;
            matrix.postTranslate(i2, -rectF.top);
            matrix.postScale(min, min);
            if (t.c) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(rounded, rounded2);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                Bitmap bitmap = Bitmap.createBitmap(picture);
            } else {
                Canvas canvas = new Canvas(Bitmap.createBitmap(rounded, rounded2, Bitmap.Config.ARGB_8888));
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (t.b && t.a != 0) {
            viewGroup.getOverlay().remove(view);
            parent.addView(view, indexOfChild);
        }
        return i;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        final AnimatorSet animatorSet = new AnimatorSet();
        Animator[] arr = new Animator[2];
        animatorSet.playTogether(new Animator[] { animator, animator2 });
        return animatorSet;
    }
}
