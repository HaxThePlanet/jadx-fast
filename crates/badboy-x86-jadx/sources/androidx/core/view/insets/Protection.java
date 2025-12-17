package androidx.core.view.insets;

import android.animation.ValueAnimator;
import android.app.Notification.Action;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;

/* loaded from: classes5.dex */
public abstract class Protection {

    private static final long DEFAULT_DURATION_IN = 333L;
    private static final long DEFAULT_DURATION_OUT = 166L;
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN;
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT;
    private final androidx.core.view.insets.Protection.Attributes mAttributes;
    private Object mController = null;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;
    private final int mSide;
    private float mSystemAlpha = 1f;
    private float mSystemInsetAmount = 1f;
    private float mUserAlpha = 1f;
    private ValueAnimator mUserAlphaAnimator = null;
    private float mUserInsetAmount = 1f;
    private ValueAnimator mUserInsetAmountAnimator = null;

    static class Attributes {

        private static final int UNSPECIFIED = -1;
        private float mAlpha = 1f;
        private androidx.core.view.insets.Protection.Attributes.Callback mCallback;
        private Drawable mDrawable = null;
        private int mHeight = -1;
        private Insets mMargin = -1;
        private float mTranslationX = 0f;
        private float mTranslationY = 0f;
        private boolean mVisible = false;
        private int mWidth = -1;
        Attributes() {
            super();
            int i = -1;
            Insets nONE = Insets.NONE;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1065353216;
        }

        static void access$000(androidx.core.view.insets.Protection.Attributes x0, Insets x1) {
            x0.setMargin(x1);
        }

        static void access$100(androidx.core.view.insets.Protection.Attributes x0, int x1) {
            x0.setWidth(x1);
        }

        static void access$200(androidx.core.view.insets.Protection.Attributes x0, int x1) {
            x0.setHeight(x1);
        }

        static void access$300(androidx.core.view.insets.Protection.Attributes x0, boolean x1) {
            x0.setVisible(x1);
        }

        static void access$400(androidx.core.view.insets.Protection.Attributes x0, float x1) {
            x0.setAlpha(x1);
        }

        static int access$500(androidx.core.view.insets.Protection.Attributes x0) {
            return x0.mWidth;
        }

        static void access$600(androidx.core.view.insets.Protection.Attributes x0, float x1) {
            x0.setTranslationX(x1);
        }

        static int access$700(androidx.core.view.insets.Protection.Attributes x0) {
            return x0.mHeight;
        }

        static void access$800(androidx.core.view.insets.Protection.Attributes x0, float x1) {
            x0.setTranslationY(x1);
        }

        static void access$900(androidx.core.view.insets.Protection.Attributes x0, Drawable x1) {
            x0.setDrawable(x1);
        }

        private void setAlpha(float alpha) {
            int mCallback;
            this.mAlpha = alpha;
            if (Float.compare(mAlpha, alpha) != 0 && this.mCallback != null) {
                this.mAlpha = alpha;
                if (this.mCallback != null) {
                    this.mCallback.onAlphaChanged(alpha);
                }
            }
        }

        private void setDrawable(Drawable drawable) {
            androidx.core.view.insets.Protection.Attributes.Callback mCallback;
            this.mDrawable = drawable;
            if (this.mCallback != null) {
                this.mCallback.onDrawableChanged(drawable);
            }
        }

        private void setHeight(int height) {
            int mCallback;
            this.mHeight = height;
            if (this.mHeight != height && this.mCallback != null) {
                this.mHeight = height;
                if (this.mCallback != null) {
                    this.mCallback.onHeightChanged(height);
                }
            }
        }

        private void setMargin(Insets margin) {
            boolean mCallback;
            this.mMargin = margin;
            if (!this.mMargin.equals(margin) && this.mCallback != null) {
                this.mMargin = margin;
                if (this.mCallback != null) {
                    this.mCallback.onMarginChanged(margin);
                }
            }
        }

        private void setTranslationX(float translationX) {
            int mCallback;
            this.mTranslationX = translationX;
            if (Float.compare(mTranslationX, translationX) != 0 && this.mCallback != null) {
                this.mTranslationX = translationX;
                if (this.mCallback != null) {
                    this.mCallback.onTranslationXChanged(translationX);
                }
            }
        }

        private void setTranslationY(float translationY) {
            int mCallback;
            this.mTranslationY = translationY;
            if (Float.compare(mTranslationY, translationY) != 0 && this.mCallback != null) {
                this.mTranslationY = translationY;
                if (this.mCallback != null) {
                    this.mCallback.onTranslationYChanged(translationY);
                }
            }
        }

        private void setVisible(boolean visible) {
            boolean mCallback;
            this.mVisible = visible;
            if (this.mVisible != visible && this.mCallback != null) {
                this.mVisible = visible;
                if (this.mCallback != null) {
                    this.mCallback.onVisibilityChanged(visible);
                }
            }
        }

        private void setWidth(int width) {
            int mCallback;
            this.mWidth = width;
            if (this.mWidth != width && this.mCallback != null) {
                this.mWidth = width;
                if (this.mCallback != null) {
                    this.mCallback.onWidthChanged(width);
                }
            }
        }

        float getAlpha() {
            return this.mAlpha;
        }

        Drawable getDrawable() {
            return this.mDrawable;
        }

        int getHeight() {
            return this.mHeight;
        }

        Insets getMargin() {
            return this.mMargin;
        }

        float getTranslationX() {
            return this.mTranslationX;
        }

        float getTranslationY() {
            return this.mTranslationY;
        }

        int getWidth() {
            return this.mWidth;
        }

        boolean isVisible() {
            return this.mVisible;
        }

        void setCallback(androidx.core.view.insets.Protection.Attributes.Callback callback) {
            if (this.mCallback != null) {
                if (callback != null) {
                } else {
                }
                IllegalStateException illegalStateException = new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
                throw illegalStateException;
            }
            this.mCallback = callback;
        }
    }
    static {
        final int i = 0;
        final int i2 = 1065353216;
        PathInterpolator pathInterpolator = new PathInterpolator(i, i, i, i2);
        Protection.DEFAULT_INTERPOLATOR_MOVE_IN = pathInterpolator;
        PathInterpolator pathInterpolator2 = new PathInterpolator(1058642330, i, i2, i2);
        Protection.DEFAULT_INTERPOLATOR_MOVE_OUT = pathInterpolator2;
        PathInterpolator pathInterpolator3 = new PathInterpolator(i, i, 1045220557, i2);
        Protection.DEFAULT_INTERPOLATOR_FADE_IN = pathInterpolator3;
        PathInterpolator pathInterpolator4 = new PathInterpolator(1053609165, i, i2, i2);
        Protection.DEFAULT_INTERPOLATOR_FADE_OUT = pathInterpolator4;
    }

    public Protection(int side) {
        if (/* condition */) {
        } else {
            this.mSide = side;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unexpected side: ").append(side).toString());
        throw illegalArgumentException;
    }

    private void cancelUserAlphaAnimation() {
        ValueAnimator mUserAlphaAnimator;
        if (this.mUserAlphaAnimator != null) {
            this.mUserAlphaAnimator.cancel();
            this.mUserAlphaAnimator = 0;
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        ValueAnimator mUserInsetAmountAnimator;
        if (this.mUserInsetAmountAnimator != null) {
            this.mUserInsetAmountAnimator.cancel();
            this.mUserInsetAmountAnimator = 0;
        }
    }

    private void setAlphaInternal(float alpha) {
        this.mUserAlpha = alpha;
        updateAlpha();
    }

    private void setInsetAmountInternal(float insetAmount) {
        this.mUserInsetAmount = insetAmount;
        updateInsetAmount();
    }

    private void updateAlpha() {
        Protection.Attributes.access$400(this.mAttributes, mSystemAlpha *= mUserAlpha);
    }

    private void updateInsetAmount() {
        androidx.core.view.insets.Protection.Attributes mAttributes;
        int i;
        float f;
        mUserInsetAmount *= mSystemInsetAmount;
        i = 1065353216;
        switch (mAttributes) {
            case 1:
                Protection.Attributes.access$600(this.mAttributes, i5 *= f);
                break;
            case 2:
                Protection.Attributes.access$800(this.mAttributes, i7 *= f);
                break;
            case 4:
                Protection.Attributes.access$600(this.mAttributes, i3 *= f);
                break;
            case 8:
                Protection.Attributes.access$800(this.mAttributes, i8 *= f);
                break;
            default:
        }
    }

    public void animateAlpha(float toAlpha) {
        ValueAnimator mUserAlphaAnimator;
        Interpolator dEFAULT_INTERPOLATOR_FADE_IN;
        cancelUserAlphaAnimation();
        if (Float.compare(toAlpha, mUserAlpha) == 0) {
        }
        float[] fArr = new float[2];
        final int i5 = 0;
        fArr[i5] = this.mUserAlpha;
        fArr[1] = toAlpha;
        this.mUserAlphaAnimator = ValueAnimator.ofFloat(fArr);
        if (Float.compare(mUserAlpha3, toAlpha) < 0) {
            this.mUserAlphaAnimator.setDuration(333);
            this.mUserAlphaAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_FADE_IN);
        } else {
            this.mUserAlphaAnimator.setDuration(166);
            this.mUserAlphaAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_FADE_OUT);
        }
        Protection$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new Protection$$ExternalSyntheticLambda1(this);
        this.mUserAlphaAnimator.addUpdateListener(externalSyntheticLambda1);
        this.mUserAlphaAnimator.start();
    }

    public void animateInsetsAmount(float toInsetsAmount) {
        ValueAnimator mUserInsetAmountAnimator;
        Interpolator dEFAULT_INTERPOLATOR_MOVE_IN;
        cancelUserInsetsAmountAnimation();
        if (Float.compare(toInsetsAmount, mUserInsetAmount) == 0) {
        }
        float[] fArr = new float[2];
        final int i5 = 0;
        fArr[i5] = this.mUserInsetAmount;
        fArr[1] = toInsetsAmount;
        this.mUserInsetAmountAnimator = ValueAnimator.ofFloat(fArr);
        if (Float.compare(mUserInsetAmount3, toInsetsAmount) < 0) {
            this.mUserInsetAmountAnimator.setDuration(333);
            this.mUserInsetAmountAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_MOVE_IN);
        } else {
            this.mUserInsetAmountAnimator.setDuration(166);
            this.mUserInsetAmountAnimator.setInterpolator(Protection.DEFAULT_INTERPOLATOR_MOVE_OUT);
        }
        Protection$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Protection$$ExternalSyntheticLambda0(this);
        this.mUserInsetAmountAnimator.addUpdateListener(externalSyntheticLambda0);
        this.mUserInsetAmountAnimator.start();
    }

    void dispatchColorHint(int color) {
    }

    Insets dispatchInsets(Insets insets, Insets insetsIgnoringVisibility, Insets consumed) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insetsIgnoringVisibility;
        Protection.Attributes.access$000(this.mAttributes, consumed);
        return updateLayout();
    }

    public float getAlpha() {
        return this.mUserAlpha;
    }

    androidx.core.view.insets.Protection.Attributes getAttributes() {
        return this.mAttributes;
    }

    Object getController() {
        return this.mController;
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    public int getSide() {
        return this.mSide;
    }

    int getThickness(int inset) {
        return inset;
    }

    void lambda$animateAlpha$0$androidx-core-view-insets-Protection(ValueAnimator animation) {
        setAlphaInternal((Float)animation.getAnimatedValue().floatValue());
    }

    void lambda$animateInsetsAmount$1$androidx-core-view-insets-Protection(ValueAnimator animation) {
        setAlphaInternal((Float)animation.getAnimatedValue().floatValue());
    }

    boolean occupiesCorners() {
        return 0;
    }

    public void setAlpha(float alpha) {
        int cmp;
        if (Float.compare(alpha, i) < 0) {
        } else {
            if (Float.compare(alpha, i2) > 0) {
            } else {
                cancelUserAlphaAnimation();
                setAlphaInternal(alpha);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Alpha must in a range of [0, 1]. Got: ").append(alpha).toString());
        throw illegalArgumentException;
    }

    void setController(Object controller) {
        this.mController = controller;
    }

    void setDrawable(Drawable drawable) {
        Protection.Attributes.access$900(this.mAttributes, drawable);
    }

    public void setInsetAmount(float insetAmount) {
        int cmp;
        if (Float.compare(insetAmount, i) < 0) {
        } else {
            if (Float.compare(insetAmount, i2) > 0) {
            } else {
                cancelUserInsetsAmountAnimation();
                setInsetAmountInternal(insetAmount);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Inset amount must in a range of [0, 1]. Got: ").append(insetAmount).toString());
        throw illegalArgumentException;
    }

    void setSystemAlpha(float alpha) {
        this.mSystemAlpha = alpha;
        updateAlpha();
    }

    void setSystemInsetAmount(float insetAmount) {
        this.mSystemInsetAmount = insetAmount;
        updateInsetAmount();
    }

    void setSystemVisible(boolean visible) {
        Protection.Attributes.access$300(this.mAttributes, visible);
    }

    Insets updateLayout() {
        Insets consumed;
        int bottom;
        int i2;
        int i3;
        boolean occupiesCorners;
        int thickness;
        int i;
        consumed = Insets.NONE;
        i2 = 0;
        switch (mSide) {
            case 1:
                Protection.Attributes.access$100(this.mAttributes, getThickness(mInsetsIgnoringVisibility4.left));
                consumed = Insets.of(getThickness(inset4.left), i2, i2, i2);
                break;
            case 2:
                Protection.Attributes.access$200(this.mAttributes, getThickness(mInsetsIgnoringVisibility.top));
                consumed = Insets.of(i2, getThickness(inset.top), i2, i2);
                break;
            case 4:
                Protection.Attributes.access$100(this.mAttributes, getThickness(mInsetsIgnoringVisibility2.right));
                consumed = Insets.of(i2, i2, getThickness(inset2.right), i2);
                break;
            case 8:
                Protection.Attributes.access$200(this.mAttributes, getThickness(mInsetsIgnoringVisibility3.bottom));
                consumed = Insets.of(i2, i2, i2, getThickness(inset3.bottom));
                break;
            default:
                bottom = 0;
        }
        if (bottom > 0) {
            i2 = 1;
        }
        setSystemVisible(i2);
        int i4 = 0;
        i = bottom > 0 ? i3 : i4;
        setSystemAlpha(i);
        if (bottom > 0) {
        } else {
            i3 = i4;
        }
        setSystemInsetAmount(i3);
        return consumed;
    }
}
