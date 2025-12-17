package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.c;

/* loaded from: classes.dex */
class o {

    private static final int[] c;
    private final ProgressBar a;
    private Bitmap b;
    static {
        int[] iArr = new int[2];
        iArr = new int[]{16843067, 16843068};
        o.c = iArr;
    }

    o(ProgressBar progressBar) {
        super();
        this.a = progressBar;
    }

    private Shape a() {
        float[] fArr = new float[8];
        fArr = new int[]{1084227584, 1084227584, 1084227584, 1084227584, 1084227584, 1084227584, 1084227584, 1084227584};
        final int i3 = 0;
        RoundRectShape roundRectShape = new RoundRectShape(fArr, i3, i3);
        return roundRectShape;
    }

    private Drawable d(Drawable drawable, boolean z2) {
        Drawable[] arr;
        boolean z;
        int i;
        int i3;
        Object shapeDrawable;
        int i4;
        Drawable drawable2;
        int i2;
        Drawable drawable3;
        int i5;
        Object obj8;
        boolean obj9;
        if (drawable instanceof c) {
            z = drawable;
            i = (c)z.b();
            if (i != null) {
                z.a(d(i, z2));
            }
        } else {
            i = 1;
            if (drawable instanceof LayerDrawable) {
                obj9 = (LayerDrawable)drawable.getNumberOfLayers();
                arr = new Drawable[obj9];
                i3 = 0;
                i4 = i3;
                while (i4 < obj9) {
                    int id = drawable.getId(i4);
                    if (id != 16908301) {
                    } else {
                    }
                    i2 = i;
                    arr[i4] = d(drawable.getDrawable(i4), i2);
                    i4++;
                    if (id == 16908303) {
                    } else {
                    }
                    i2 = i3;
                }
                LayerDrawable layerDrawable = new LayerDrawable(arr);
                while (i3 < obj9) {
                    layerDrawable.setId(i3, drawable.getId(i3));
                    i3++;
                }
                return layerDrawable;
            }
            Bitmap bitmap = (BitmapDrawable)drawable.getBitmap();
            if (drawable instanceof BitmapDrawable && this.b == null) {
                bitmap = (BitmapDrawable)drawable.getBitmap();
                if (this.b == null) {
                    this.b = bitmap;
                }
                shapeDrawable = new ShapeDrawable(a());
                BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                shapeDrawable.getPaint().setShader(bitmapShader);
                shapeDrawable.getPaint().setColorFilter(drawable.getPaint().getColorFilter());
                if (z2) {
                    obj8 = new ClipDrawable(shapeDrawable, 3, i);
                    shapeDrawable = obj8;
                }
                return shapeDrawable;
            }
        }
        return drawable;
    }

    private Drawable e(Drawable drawable) {
        boolean numberOfFrames;
        AnimationDrawable animationDrawable;
        int i;
        int duration;
        Drawable drawable2;
        int i2;
        Object obj7;
        if (drawable instanceof AnimationDrawable) {
            animationDrawable = new AnimationDrawable();
            animationDrawable.setOneShot(drawable.isOneShot());
            i = 0;
            duration = 10000;
            while (i < (AnimationDrawable)drawable.getNumberOfFrames()) {
                drawable2 = d(drawable.getFrame(i), true);
                drawable2.setLevel(duration);
                animationDrawable.addFrame(drawable2, drawable.getDuration(i));
                i++;
                duration = 10000;
            }
            animationDrawable.setLevel(duration);
            obj7 = animationDrawable;
        }
        return obj7;
    }

    Bitmap b() {
        return this.b;
    }

    void c(AttributeSet attributeSet, int i2) {
        Object context;
        Drawable obj5;
        final int i = 0;
        final androidx.appcompat.widget.t0 obj4 = t0.v(this.a.getContext(), attributeSet, o.c, i2, i);
        obj5 = obj4.h(i);
        if (obj5 != null) {
            this.a.setIndeterminateDrawable(e(obj5));
        }
        obj5 = obj4.h(1);
        if (obj5 != null) {
            this.a.setProgressDrawable(d(obj5, i));
        }
        obj4.w();
    }
}
