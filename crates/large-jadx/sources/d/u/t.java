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

/* loaded from: classes.dex */
class t {

    private static final boolean a = false;
    private static final boolean b = false;
    private static final boolean c = false;
    static {
        final int sDK_INT = Build.VERSION.SDK_INT;
        int i = 1;
        final int i3 = 0;
        if (sDK_INT >= 19) {
            int i5 = i;
        }
        int i6 = i3;
        if (sDK_INT >= 18) {
            int i8 = i;
        }
        int i9 = i3;
        if (sDK_INT >= 28) {
        }
        int i2 = i3;
    }

    static View a(ViewGroup viewGroup, View view2, View view3) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float)i, (float)obj9);
        f0.i(view2, matrix);
        f0.j(viewGroup, matrix);
        int i2 = 0;
        RectF obj9 = new RectF(i2, i2, (float)width, (float)height);
        matrix.mapRect(obj9);
        int round = Math.round(obj9.left);
        int round2 = Math.round(obj9.top);
        int round3 = Math.round(obj9.right);
        int round4 = Math.round(obj9.bottom);
        ImageView imageView = new ImageView(view2.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap obj7 = t.b(view2, matrix, obj9, viewGroup);
        if (obj7 != null) {
            imageView.setImageBitmap(obj7);
        }
        int obj8 = 1073741824;
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, obj8), View.MeasureSpec.makeMeasureSpec(round4 - round2, obj8));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    private static Bitmap b(View view, Matrix matrix2, RectF rectF3, ViewGroup viewGroup4) {
        int i;
        android.view.ViewParent parent;
        boolean attachedToWindow;
        int indexOfChild;
        int bitmap;
        ViewGroupOverlay overlay;
        int round2;
        int round;
        int i2;
        float f;
        Object obj10;
        Object obj11;
        int i3 = 0;
        if (t.a) {
            attachedToWindow2 ^= 1;
            if (viewGroup4 == null) {
                attachedToWindow = i3;
            } else {
                attachedToWindow = viewGroup4.isAttachedToWindow();
            }
        } else {
            attachedToWindow = i;
        }
        final boolean z2 = t.b;
        bitmap = 0;
        if (z2 && i != 0) {
            if (i != 0) {
                if (!attachedToWindow) {
                    return bitmap;
                }
                indexOfChild = (ViewGroup)view.getParent().indexOfChild(view);
                viewGroup4.getOverlay().add(view);
            } else {
                indexOfChild = i3;
                parent = bitmap;
            }
        } else {
        }
        round2 = Math.round(rectF3.width());
        round = Math.round(rectF3.height());
        if (round2 > 0 && round > 0) {
            if (round > 0) {
                float f2 = Math.min(1065353216, i7 /= f);
                round2 = Math.round(f3 *= f2);
                round = Math.round(f4 *= f2);
                matrix2.postTranslate(-left, -obj11);
                matrix2.postScale(f2, f2);
                if (t.c) {
                    obj11 = new Picture();
                    Canvas beginRecording = obj11.beginRecording(round2, round);
                    beginRecording.concat(matrix2);
                    view.draw(beginRecording);
                    obj11.endRecording();
                    bitmap = Bitmap.createBitmap(obj11);
                } else {
                    obj11 = new Canvas(Bitmap.createBitmap(round2, round, Bitmap.Config.ARGB_8888));
                    obj11.concat(matrix2);
                    view.draw(obj11);
                }
            }
        }
        if (z2 && i != 0) {
            if (i != 0) {
                viewGroup4.getOverlay().remove(view);
                parent.addView(view, indexOfChild);
            }
        }
        return bitmap;
    }

    static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] arr = new Animator[2];
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
