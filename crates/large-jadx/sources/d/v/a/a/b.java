package d.v.a.a;

import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class b {

    Animatable2.AnimationCallback mPlatformCallback;

    class a extends Animatable2.AnimationCallback {

        final d.v.a.a.b a;
        a(d.v.a.a.b b) {
            this.a = b;
            super();
        }

        @Override // android.graphics.drawable.Animatable2$AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            this.a.onAnimationEnd(drawable);
        }

        @Override // android.graphics.drawable.Animatable2$AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            this.a.onAnimationStart(drawable);
        }
    }
    Animatable2.AnimationCallback getPlatformCallback() {
        Animatable2.AnimationCallback mPlatformCallback;
        if (this.mPlatformCallback == null) {
            mPlatformCallback = new b.a(this);
            this.mPlatformCallback = mPlatformCallback;
        }
        return this.mPlatformCallback;
    }

    public void onAnimationEnd(Drawable drawable) {
    }

    public void onAnimationStart(Drawable drawable) {
    }
}
