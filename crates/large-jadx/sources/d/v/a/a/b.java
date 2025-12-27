package d.v.a.a;

import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;

/* compiled from: Animatable2Compat.java */
/* loaded from: classes.dex */
public abstract class b {

    Animatable2.AnimationCallback mPlatformCallback;

    class a extends Animatable2.AnimationCallback {

        final /* synthetic */ b a;
        a() {
            this.a = bVar;
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
        if (this.mPlatformCallback == null) {
            this.mPlatformCallback = new b.a(this);
        }
        return this.mPlatformCallback;
    }

    public void onAnimationEnd(Drawable drawable) {
    }

    public void onAnimationStart(Drawable drawable) {
    }
}
