package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation.Bounds;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R.id;
import androidx.core.graphics.Insets;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.util.List;

/* loaded from: classes5.dex */
public final class WindowInsetsAnimationCompat {

    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private androidx.core.view.WindowInsetsAnimationCompat.Impl mImpl;

    public static final class BoundsCompat {

        private final Insets mLowerBound;
        private final Insets mUpperBound;
        private BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            super();
            this.mLowerBound = WindowInsetsAnimationCompat.Impl30.getLowerBounds(bounds);
            this.mUpperBound = WindowInsetsAnimationCompat.Impl30.getHigherBounds(bounds);
        }

        public BoundsCompat(Insets lowerBound, Insets upperBound) {
            super();
            this.mLowerBound = lowerBound;
            this.mUpperBound = upperBound;
        }

        public static androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            WindowInsetsAnimationCompat.BoundsCompat boundsCompat = new WindowInsetsAnimationCompat.BoundsCompat(bounds);
            return boundsCompat;
        }

        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        public androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat inset(Insets insets) {
            WindowInsetsAnimationCompat.BoundsCompat boundsCompat = new WindowInsetsAnimationCompat.BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
            return boundsCompat;
        }

        public WindowInsetsAnimation.Bounds toBounds() {
            return WindowInsetsAnimationCompat.Impl30.createPlatformBounds(this);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Bounds{lower=").append(this.mLowerBound).append(" upper=").append(this.mUpperBound).append("}").toString();
        }
    }

    public static abstract class Callback {

        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP;
        androidx.core.view.WindowInsetsCompat mDispachedInsets;
        private final int mDispatchMode;
        public Callback(int dispatchMode) {
            super();
            this.mDispatchMode = dispatchMode;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(androidx.core.view.WindowInsetsAnimationCompat animation) {
        }

        public void onPrepare(androidx.core.view.WindowInsetsAnimationCompat animation) {
        }

        public abstract androidx.core.view.WindowInsetsCompat onProgress(androidx.core.view.WindowInsetsCompat windowInsetsCompat, List<androidx.core.view.WindowInsetsAnimationCompat> list2);

        public androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat onStart(androidx.core.view.WindowInsetsAnimationCompat animation, androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat bounds) {
            return bounds;
        }
    }

    private static class Impl {

        private float mAlpha = 1f;
        private final long mDurationMillis;
        private float mFraction;
        private final Interpolator mInterpolator;
        private final int mTypeMask;
        Impl(int typeMask, Interpolator interpolator, long durationMillis) {
            super();
            final int i = 1065353216;
            this.mTypeMask = typeMask;
            this.mInterpolator = interpolator;
            this.mDurationMillis = durationMillis;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            if (this.mInterpolator != null) {
                return this.mInterpolator.getInterpolation(this.mFraction);
            }
            return this.mFraction;
        }

        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float alpha) {
            this.mAlpha = alpha;
        }

        public void setFraction(float fraction) {
            this.mFraction = fraction;
        }
    }

    private static class Impl21 extends androidx.core.view.WindowInsetsAnimationCompat.Impl {

        private static final Interpolator HIDE_IME_INTERPOLATOR;
        private static final Interpolator HIDE_SYSTEM_BAR_INTERPOLATOR;
        private static final Interpolator SHOW_IME_INTERPOLATOR;
        private static final Interpolator SHOW_SYSTEM_BAR_INTERPOLATOR;
        static {
            final int i4 = 0;
            PathInterpolator pathInterpolator = new PathInterpolator(i4, 1066192077, i4, 1065353216);
            WindowInsetsAnimationCompat.Impl21.SHOW_IME_INTERPOLATOR = pathInterpolator;
            FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
            WindowInsetsAnimationCompat.Impl21.HIDE_IME_INTERPOLATOR = fastOutLinearInInterpolator;
            int i2 = 1069547520;
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(i2);
            WindowInsetsAnimationCompat.Impl21.SHOW_SYSTEM_BAR_INTERPOLATOR = decelerateInterpolator;
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(i2);
            WindowInsetsAnimationCompat.Impl21.HIDE_SYSTEM_BAR_INTERPOLATOR = accelerateInterpolator;
        }

        Impl21(int typeMask, Interpolator interpolator, long durationMillis) {
            super(typeMask, interpolator, durationMillis, obj4);
        }

        static void buildAnimationMask(androidx.core.view.WindowInsetsCompat targetInsets, androidx.core.view.WindowInsetsCompat currentInsets, int[] showingTypes, int[] hidingTypes) {
            int i2;
            Insets insets;
            Insets insets2;
            int i;
            int bottom2;
            int bottom4;
            int bottom;
            int i3;
            int i4;
            int bottom3;
            i2 = 1;
            while (i2 <= 512) {
                insets = targetInsets.getInsets(i2);
                insets2 = currentInsets.getInsets(i2);
                i4 = 0;
                if (insets.left <= insets2.left && insets.top <= insets2.top && insets.right <= insets2.right) {
                } else {
                }
                i = i3;
                if (insets.left >= insets2.left && insets.top >= insets2.top && insets.right >= insets2.right) {
                }
                if (i != i3) {
                }
                i2 <<= 1;
                if (i != 0) {
                } else {
                }
                hidingTypes[i4] = i7 |= i2;
                showingTypes[i4] = i6 |= i2;
                if (insets.top >= insets2.top) {
                }
                if (insets.right >= insets2.right) {
                }
                if (insets.bottom < insets2.bottom) {
                } else {
                }
                i3 = i4;
                if (insets.top <= insets2.top) {
                } else {
                }
                if (insets.right <= insets2.right) {
                } else {
                }
                if (insets.bottom > insets2.bottom) {
                } else {
                }
                i = i4;
            }
        }

        static androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat computeAnimationBounds(androidx.core.view.WindowInsetsCompat targetInsets, androidx.core.view.WindowInsetsCompat startingInsets, int mask) {
            final Insets insets = targetInsets.getInsets(mask);
            final Insets insets2 = startingInsets.getInsets(mask);
            WindowInsetsAnimationCompat.BoundsCompat boundsCompat = new WindowInsetsAnimationCompat.BoundsCompat(Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
            return boundsCompat;
        }

        static Interpolator createInsetInterpolator(int showingTypes, int hidingTypes) {
            if (i &= showingTypes != 0) {
                return WindowInsetsAnimationCompat.Impl21.SHOW_IME_INTERPOLATOR;
            }
            if (i3 &= hidingTypes != 0) {
                return WindowInsetsAnimationCompat.Impl21.HIDE_IME_INTERPOLATOR;
            }
            if (systemBars &= showingTypes != 0) {
                return WindowInsetsAnimationCompat.Impl21.SHOW_SYSTEM_BAR_INTERPOLATOR;
            }
            if (systemBars2 &= hidingTypes != 0) {
                return WindowInsetsAnimationCompat.Impl21.HIDE_SYSTEM_BAR_INTERPOLATOR;
            }
            return null;
        }

        private static View.OnApplyWindowInsetsListener createProxyListener(View view, androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
            WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener = new WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener(view, callback);
            return impl21OnApplyWindowInsetsListener;
        }

        static void dispatchOnEnd(View v, androidx.core.view.WindowInsetsAnimationCompat anim) {
            int dispatchMode;
            boolean z;
            int i;
            int childCount;
            final androidx.core.view.WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(v);
            callback.onEnd(anim);
            if (callback != null && callback.getDispatchMode() == 0) {
                callback.onEnd(anim);
                if (callback.getDispatchMode() == 0) {
                }
            }
            if (v instanceof ViewGroup) {
                z = v;
                i = 0;
                while (i < (ViewGroup)z.getChildCount()) {
                    WindowInsetsAnimationCompat.Impl21.dispatchOnEnd(z.getChildAt(i), anim);
                    i++;
                }
            }
        }

        static void dispatchOnPrepare(View v, androidx.core.view.WindowInsetsAnimationCompat anim, androidx.core.view.WindowInsetsCompat insets, boolean stopDispatch) {
            int i;
            boolean view;
            int i2;
            View childCount;
            int obj7;
            final androidx.core.view.WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(v);
            callback.mDispachedInsets = insets;
            if (callback != null && stopDispatch == 0) {
                callback.mDispachedInsets = insets;
                if (stopDispatch == 0) {
                    callback.onPrepare(anim);
                    i = callback.getDispatchMode() == 0 ? 1 : 0;
                    obj7 = i;
                }
            }
            if (v instanceof ViewGroup) {
                view = v;
                i2 = 0;
                while (i2 < (ViewGroup)view.getChildCount()) {
                    WindowInsetsAnimationCompat.Impl21.dispatchOnPrepare(view.getChildAt(i2), anim, insets, obj7);
                    i2++;
                }
            }
        }

        static void dispatchOnProgress(View v, androidx.core.view.WindowInsetsCompat interpolateInsets, List<androidx.core.view.WindowInsetsAnimationCompat> list3) {
            androidx.core.view.WindowInsetsCompat insets;
            int dispatchMode;
            boolean z;
            int i;
            int childCount;
            final androidx.core.view.WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(v);
            insets = callback.onProgress(interpolateInsets, list3);
            if (callback != null && callback.getDispatchMode() == 0) {
                insets = callback.onProgress(insets, list3);
                if (callback.getDispatchMode() == 0) {
                }
            }
            if (v instanceof ViewGroup) {
                z = v;
                i = 0;
                while (i < (ViewGroup)z.getChildCount()) {
                    WindowInsetsAnimationCompat.Impl21.dispatchOnProgress(z.getChildAt(i), insets, list3);
                    i++;
                }
            }
        }

        static void dispatchOnStart(View v, androidx.core.view.WindowInsetsAnimationCompat anim, androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat animationBounds) {
            int dispatchMode;
            boolean z;
            int i;
            int childCount;
            final androidx.core.view.WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(v);
            callback.onStart(anim, animationBounds);
            if (callback != null && callback.getDispatchMode() == 0) {
                callback.onStart(anim, animationBounds);
                if (callback.getDispatchMode() == 0) {
                }
            }
            if (v instanceof ViewGroup) {
                z = v;
                i = 0;
                while (i < (ViewGroup)z.getChildCount()) {
                    WindowInsetsAnimationCompat.Impl21.dispatchOnStart(z.getChildAt(i), anim, animationBounds);
                    i++;
                }
            }
        }

        static WindowInsets forwardToViewIfNeeded(View v, WindowInsets insets) {
            if (v.getTag(R.id.tag_on_apply_window_listener) != null) {
                return insets;
            }
            return v.onApplyWindowInsets(insets);
        }

        static androidx.core.view.WindowInsetsAnimationCompat.Callback getCallback(View child) {
            int callback;
            boolean z;
            Object tag = child.getTag(R.id.tag_window_insets_animation_callback);
            callback = 0;
            if (tag instanceof WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener != null) {
                callback = z.mCallback;
            }
            return callback;
        }

        static androidx.core.view.WindowInsetsCompat interpolateInsets(androidx.core.view.WindowInsetsCompat target, androidx.core.view.WindowInsetsCompat starting, float fraction, int typeMask) {
            int i5;
            Insets insets;
            Insets insets2;
            Insets insetInsets;
            int i4;
            int i3;
            int i;
            long l;
            int i2;
            int bottom;
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(target);
            i5 = 1;
            while (i5 <= 512) {
                if (typeMask & i5 == 0) {
                } else {
                }
                insets = target.getInsets(i5);
                insets2 = starting.getInsets(i5);
                int i11 = 1065353216;
                l = 4602678819172646912L;
                builder.setInsets(i5, WindowInsetsCompat.insetInsets(insets, (int)i14, (int)i17, (int)i22, (int)i2));
                i5 <<= 1;
                builder.setInsets(i5, target.getInsets(i5));
            }
            return builder.build();
        }

        static void setCallback(View view, androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
            View.OnApplyWindowInsetsListener proxyListener;
            Object tag;
            if (callback != null) {
                proxyListener = WindowInsetsAnimationCompat.Impl21.createProxyListener(view, callback);
            } else {
                proxyListener = 0;
            }
            view.setTag(R.id.tag_window_insets_animation_callback, proxyListener);
            if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
                if (view.getTag(R.id.tag_on_apply_window_listener) == null) {
                    view.setOnApplyWindowInsetsListener(proxyListener);
                }
            }
        }
    }

    private static class Impl30 extends androidx.core.view.WindowInsetsAnimationCompat.Impl {

        private final WindowInsetsAnimation mWrapped;
        Impl30(int typeMask, Interpolator interpolator, long durationMillis) {
            WindowInsetsAnimation windowInsetsAnimation = new WindowInsetsAnimation(typeMask, interpolator, durationMillis, obj5);
            super(windowInsetsAnimation);
        }

        Impl30(WindowInsetsAnimation wrapped) {
            super(0, 0, 0, obj2);
            this.mWrapped = wrapped;
        }

        public static WindowInsetsAnimation.Bounds createPlatformBounds(androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat bounds) {
            WindowInsetsAnimation.Bounds bounds2 = new WindowInsetsAnimation.Bounds(bounds.getLowerBound().toPlatformInsets(), bounds.getUpperBound().toPlatformInsets());
            return bounds2;
        }

        public static Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getUpperBound());
        }

        public static Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
            return Insets.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(View view, androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
            androidx.core.view.WindowInsetsAnimationCompat.Impl30.ProxyCallback proxyCallback;
            if (callback != null) {
                proxyCallback = new WindowInsetsAnimationCompat.Impl30.ProxyCallback(callback);
            } else {
                proxyCallback = 0;
            }
            view.setWindowInsetsAnimationCallback(proxyCallback);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public float getAlpha() {
            return this.mWrapped.getAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public void setAlpha(float alpha) {
            this.mWrapped.setAlpha(alpha);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat$Impl
        public void setFraction(float fraction) {
            this.mWrapped.setFraction(fraction);
        }
    }
    public WindowInsetsAnimationCompat(int typeMask, Interpolator interpolator, long durationMillis) {
        androidx.core.view.WindowInsetsAnimationCompat.Impl impl;
        super();
        if (Build.VERSION.SDK_INT >= 30) {
            impl = new WindowInsetsAnimationCompat.Impl30(typeMask, interpolator, durationMillis, obj6);
            this.mImpl = impl;
        } else {
            impl = new WindowInsetsAnimationCompat.Impl21(typeMask, interpolator, durationMillis, obj6);
            this.mImpl = impl;
        }
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation animation) {
        int sDK_INT;
        super(0, 0, 0, obj2);
        if (Build.VERSION.SDK_INT >= 30) {
            sDK_INT = new WindowInsetsAnimationCompat.Impl30(animation);
            this.mImpl = sDK_INT;
        }
    }

    static void setCallback(View view, androidx.core.view.WindowInsetsAnimationCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsAnimationCompat.Impl30.setCallback(view, callback);
        } else {
            WindowInsetsAnimationCompat.Impl21.setCallback(view, callback);
        }
    }

    static androidx.core.view.WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(windowInsetsAnimation);
        return windowInsetsAnimationCompat;
    }

    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(float alpha) {
        this.mImpl.setAlpha(alpha);
    }

    public void setFraction(float fraction) {
        this.mImpl.setFraction(fraction);
    }
}
