package com.google.firebase.inappmessaging.display.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;

/* loaded from: classes2.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    private long mAnimationTime;
    private com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks mDismissCallbacks;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private int mViewWidth = 1;

    public interface DismissCallbacks {
        public abstract boolean canDismiss(Object object);

        public abstract void onDismiss(View view, Object object2);
    }
    public SwipeDismissTouchListener(View view, Object object2, com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks swipeDismissTouchListener$DismissCallbacks3) {
        super();
        int i = 1;
        ViewConfiguration view2 = ViewConfiguration.get(view.getContext());
        this.mSlop = view2.getScaledTouchSlop();
        this.mMinFlingVelocity = scaledMinimumFlingVelocity *= 16;
        this.mMaxFlingVelocity = view2.getScaledMaximumFlingVelocity();
        this.mAnimationTime = (long)integer;
        this.mView = view;
        this.mToken = object2;
        this.mDismissCallbacks = dismissCallbacks3;
    }

    static void access$000(com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener swipeDismissTouchListener) {
        swipeDismissTouchListener.performDismiss();
    }

    static View access$100(com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener swipeDismissTouchListener) {
        return swipeDismissTouchListener.mView;
    }

    static Object access$200(com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener swipeDismissTouchListener) {
        return swipeDismissTouchListener.mToken;
    }

    static com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks access$300(com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener swipeDismissTouchListener) {
        return swipeDismissTouchListener.mDismissCallbacks;
    }

    private void animateTo(float f, float f2, AnimatorListenerAdapter animatorListenerAdapter3) {
        final float translationX = getTranslationX();
        final float alpha = this.mView.getAlpha();
        float[] obj7 = new float[2];
        obj7 = new int[]{0, 1065353216};
        obj7 = ValueAnimator.ofFloat(obj7);
        obj7.setDuration(this.mAnimationTime);
        super(this, translationX, f - translationX, alpha, f2 - alpha);
        obj7.addUpdateListener(obj8);
        if (animatorListenerAdapter3 != null) {
            obj7.addListener(animatorListenerAdapter3);
        }
        obj7.start();
    }

    private void performDismiss() {
        ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        int height = this.mView.getHeight();
        int[] iArr = new int[2];
        int i3 = 1;
        iArr[i3] = i3;
        ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(this.mAnimationTime);
        SwipeDismissTouchListener.3 anon2 = new SwipeDismissTouchListener.3(this, layoutParams, height);
        duration.addListener(anon2);
        SwipeDismissTouchListener.4 anon = new SwipeDismissTouchListener.4(this, layoutParams);
        duration.addUpdateListener(anon);
        duration.start();
    }

    @Override // android.view.View$OnTouchListener
    protected float getTranslationX() {
        return this.mView.getTranslationX();
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent2) {
        int mSwiping;
        int mSlop;
        int cmp;
        int i3;
        int i5;
        int i;
        float f;
        int i2;
        int i4;
        int obj11;
        Object obj12;
        int i6 = 0;
        motionEvent2.offsetLocation(this.mTranslationX, i6);
        mSwiping = 2;
        if (this.mViewWidth < mSwiping) {
            this.mViewWidth = this.mView.getWidth();
        }
        obj11 = motionEvent2.getActionMasked();
        final int i7 = 0;
        if (obj11 != null) {
            cmp = 0;
            i3 = 1;
            if (obj11 != i3) {
                i5 = 3;
                if (obj11 != mSwiping) {
                    if (obj11 != i5) {
                    } else {
                        if (this.mVelocityTracker == null) {
                        } else {
                            startCancelAnimation();
                            this.mVelocityTracker.recycle();
                            this.mVelocityTracker = cmp;
                            this.mTranslationX = i6;
                            this.mDownX = i6;
                            this.mDownY = i6;
                            this.mSwiping = i7;
                        }
                    }
                } else {
                    obj11 = this.mVelocityTracker;
                    if (obj11 == null) {
                    } else {
                        obj11.addMovement(motionEvent2);
                        obj11 -= mDownX;
                        i = 1073741824;
                        if (Float.compare(f6, f8) > 0 && Float.compare(f2, cmp) < 0) {
                            if (Float.compare(f2, cmp) < 0) {
                                this.mSwiping = i3;
                                mSlop = Float.compare(obj11, i6) > 0 ? this.mSlop : -mSlop2;
                                this.mSwipingSlop = mSlop;
                                this.mView.getParent().requestDisallowInterceptTouchEvent(i3);
                                mSwiping = MotionEvent.obtain(motionEvent2);
                                mSwiping.setAction(obj12 |= i5);
                                this.mView.onTouchEvent(mSwiping);
                                mSwiping.recycle();
                            }
                        }
                        if (this.mSwiping) {
                            this.mTranslationX = obj11;
                            setTranslationX(obj11 - obj12);
                            obj12 = 1065353216;
                            setAlpha(Math.max(i6, Math.min(obj12, obj12 - obj11)));
                            return i3;
                        }
                    }
                }
            } else {
                if (this.mVelocityTracker == null) {
                } else {
                    obj11 -= mDownX2;
                    this.mVelocityTracker.addMovement(motionEvent2);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    obj12 = this.mVelocityTracker.getXVelocity();
                    i5 = Math.abs(obj12);
                    if (Float.compare(f, f3) > 0 && this.mSwiping) {
                        if (this.mSwiping) {
                            obj11 = Float.compare(obj11, i6) > 0 ? i3 : i7;
                        } else {
                            mSwiping = Float.compare(i, i5);
                            if (Float.compare(f4, i5) <= 0 && Float.compare(i5, f5) <= 0 && mSwiping < 0 && mSwiping < 0 && this.mSwiping) {
                                if (Float.compare(i5, f5) <= 0) {
                                    mSwiping = Float.compare(i, i5);
                                    if (mSwiping < 0) {
                                        if (mSwiping < 0) {
                                            if (this.mSwiping) {
                                                obj12 = Float.compare(obj12, i6) < 0 ? i3 : i7;
                                                obj11 = Float.compare(obj11, i6) < 0 ? i3 : i7;
                                                obj11 = obj12 == obj11 ? i3 : i7;
                                                if (Float.compare(obj12, i6) > 0) {
                                                } else {
                                                    i3 = i7;
                                                }
                                                i3 = obj11;
                                                obj11 = i4;
                                            } else {
                                                i3 = obj11;
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    if (i3 != 0) {
                        startDismissAnimation(obj11);
                    } else {
                        if (this.mSwiping) {
                            startCancelAnimation();
                        }
                    }
                    obj11 = this.mVelocityTracker;
                    if (obj11 != null) {
                        obj11.recycle();
                    }
                    this.mVelocityTracker = cmp;
                    this.mTranslationX = i6;
                    this.mDownX = i6;
                    this.mDownY = i6;
                    this.mSwiping = i7;
                }
            }
            return i7;
        }
        this.mDownX = motionEvent2.getRawX();
        this.mDownY = motionEvent2.getRawY();
        if (this.mDismissCallbacks.canDismiss(this.mToken)) {
            obj11 = VelocityTracker.obtain();
            this.mVelocityTracker = obj11;
            obj11.addMovement(motionEvent2);
        }
        return i7;
    }

    @Override // android.view.View$OnTouchListener
    protected void setAlpha(float f) {
        this.mView.setAlpha(f);
    }

    @Override // android.view.View$OnTouchListener
    protected void setTranslationX(float f) {
        this.mView.setTranslationX(f);
    }

    @Override // android.view.View$OnTouchListener
    protected void startCancelAnimation() {
        animateTo(0, 1065353216, 0);
    }

    @Override // android.view.View$OnTouchListener
    protected void startDismissAnimation(boolean z) {
        int obj3;
        obj3 = z ? this.mViewWidth : -obj3;
        SwipeDismissTouchListener.1 anon = new SwipeDismissTouchListener.1(this);
        animateTo((float)obj3, 0, anon);
    }
}
