package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import d.h.l.u;

/* loaded from: classes.dex */
class a extends ImageView {

    private Animation.AnimationListener a;
    int b = 1080033280;

    private class a extends OvalShape {

        private RadialGradient a;
        private Paint b;
        final androidx.swiperefreshlayout.widget.a c;
        a(androidx.swiperefreshlayout.widget.a a, int i2) {
            this.c = a;
            super();
            Paint paint = new Paint();
            this.b = paint;
            a.b = i2;
            a((int)obj2);
        }

        private void a(int i) {
            int i2 = 2;
            final float f2 = (float)obj9;
            final int[] iArr = new int[i2];
            iArr = new int[]{1023410176, 0};
            super(f2, f2, (float)obj9, iArr, 0, Shader.TileMode.CLAMP);
            this.a = radialGradient2;
            this.b.setShader(radialGradient2);
        }

        @Override // android.graphics.drawable.shapes.OvalShape
        public void draw(Canvas canvas, Paint paint2) {
            width /= 2;
            final float f3 = (float)i;
            float f2 = (float)i3;
            canvas.drawCircle(f3, f2, f3, this.b);
            canvas.drawCircle(f3, f2, (float)i2, paint2);
        }

        @Override // android.graphics.drawable.shapes.OvalShape
        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int)f);
        }
    }
    a(Context context, int i2) {
        ShapeDrawable shapeDrawable2;
        int i3;
        boolean shapeDrawable;
        float f;
        int i;
        int obj6;
        super(context);
        obj6 = obj6.density;
        int i12 = (int)i11;
        if (a()) {
            OvalShape ovalShape = new OvalShape();
            shapeDrawable2 = new ShapeDrawable(ovalShape);
            u.s0(this, obj6 *= i3);
        } else {
            obj6 = new a.a(this, this.b);
            shapeDrawable = new ShapeDrawable(obj6);
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float)i14, (float)i9, (float)i6, 503316480);
            obj6 = this.b;
            setPadding(obj6, obj6, obj6, obj6);
            shapeDrawable2 = shapeDrawable;
        }
        shapeDrawable2.getPaint().setColor(i2);
        u.o0(this, shapeDrawable2);
    }

    private boolean a() {
        int i;
        i = Build.VERSION.SDK_INT >= 21 ? 1 : 0;
        return i;
    }

    @Override // android.widget.ImageView
    public void b(Animation.AnimationListener animation$AnimationListener) {
        this.a = animationListener;
    }

    @Override // android.widget.ImageView
    public void onAnimationEnd() {
        android.view.animation.Animation animation;
        super.onAnimationEnd();
        final Animation.AnimationListener list = this.a;
        if (list != null) {
            list.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.widget.ImageView
    public void onAnimationStart() {
        android.view.animation.Animation animation;
        super.onAnimationStart();
        final Animation.AnimationListener list = this.a;
        if (list != null) {
            list.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean obj2;
        int obj3;
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(obj2 += obj3, obj3 += i3);
        }
    }

    @Override // android.widget.ImageView
    public void setBackgroundColor(int i) {
        boolean paint;
        if (background instanceof ShapeDrawable) {
            (ShapeDrawable)getBackground().getPaint().setColor(i);
        }
    }
}
