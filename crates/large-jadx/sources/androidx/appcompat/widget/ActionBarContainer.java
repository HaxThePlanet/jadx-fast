package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import d.a.f;
import d.a.j;
import d.h.l.u;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    boolean A;
    private int B;
    private boolean a;
    private View b;
    private View c;
    private View v;
    Drawable w;
    Drawable x;
    Drawable y;
    boolean z = true;
    public ActionBarContainer(Context context, AttributeSet attributeSet2) {
        int i;
        Drawable obj3;
        int obj4;
        super(context, attributeSet2);
        b bVar = new b(this);
        u.o0(this, bVar);
        obj3 = context.obtainStyledAttributes(attributeSet2, j.a);
        this.w = obj3.getDrawable(j.b);
        this.x = obj3.getDrawable(j.d);
        this.B = obj3.getDimensionPixelSize(j.j, -1);
        i = 1;
        if (getId() == f.H) {
            this.y = obj3.getDrawable(j.c);
        }
        obj3.recycle();
        if (this.z) {
            if (this.y == null) {
            } else {
                i = obj4;
            }
        } else {
            if (this.w == null && this.x == null) {
                if (this.x == null) {
                } else {
                }
            } else {
            }
        }
        setWillNotDraw(i);
    }

    private int a(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return obj3 += bottomMargin;
    }

    private boolean b(View view) {
        int visibility;
        int i;
        int obj3;
        if (view != null && view.getVisibility() != 8) {
            if (view.getVisibility() != 8) {
                if (view.getMeasuredHeight() == 0) {
                    obj3 = 1;
                } else {
                    obj3 = 0;
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // android.widget.FrameLayout
    protected void drawableStateChanged() {
        Drawable stateful3;
        Drawable stateful2;
        Drawable stateful;
        int[] drawableState;
        super.drawableStateChanged();
        stateful3 = this.w;
        if (stateful3 != null && stateful3.isStateful()) {
            if (stateful3.isStateful()) {
                this.w.setState(getDrawableState());
            }
        }
        stateful2 = this.x;
        if (stateful2 != null && stateful2.isStateful()) {
            if (stateful2.isStateful()) {
                this.x.setState(getDrawableState());
            }
        }
        stateful = this.y;
        if (stateful != null && stateful.isStateful()) {
            if (stateful.isStateful()) {
                this.y.setState(getDrawableState());
            }
        }
    }

    @Override // android.widget.FrameLayout
    public View getTabContainer() {
        return this.b;
    }

    @Override // android.widget.FrameLayout
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.x;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.y;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.widget.FrameLayout
    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = findViewById(f.a);
        this.v = findViewById(f.f);
    }

    @Override // android.widget.FrameLayout
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return 1;
    }

    @Override // android.widget.FrameLayout
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int obj2;
        if (!this.a) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.widget.FrameLayout
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int right;
        int visibility;
        int i6;
        int bottomMargin;
        int i;
        int obj5;
        View obj6;
        int obj7;
        int obj8;
        int obj9;
        super.onLayout(z, i2, i3, i4, i5);
        obj5 = this.b;
        obj7 = 8;
        obj9 = 1;
        right = 0;
        if (obj5 != null && obj5.getVisibility() != obj7) {
            i6 = obj5.getVisibility() != obj7 ? obj9 : right;
        } else {
        }
        if (obj5 != null && obj5.getVisibility() != obj7) {
            if (obj5.getVisibility() != obj7) {
                obj7 = getMeasuredHeight();
                bottomMargin = layoutParams.bottomMargin;
                obj5.layout(i2, i7 -= bottomMargin, i4, obj7 -= bottomMargin);
            }
        }
        obj5 = this.y;
        if (this.z && obj5 != null) {
            obj5 = this.y;
            if (obj5 != null) {
                obj5.setBounds(right, right, getMeasuredWidth(), getMeasuredHeight());
            } else {
                obj9 = right;
            }
        } else {
        }
        if (obj9 != null) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout
    public void onMeasure(int i, int i2) {
        View mode;
        int i4;
        View visibility;
        int i5;
        int i3;
        int obj4;
        int obj5;
        i5 = Integer.MIN_VALUE;
        mode = this.B;
        if (this.c == null && View.MeasureSpec.getMode(i2) == i5 && mode >= 0) {
            if (View.MeasureSpec.getMode(i2) == i5) {
                mode = this.B;
                if (mode >= 0) {
                    obj5 = View.MeasureSpec.makeMeasureSpec(Math.min(mode, View.MeasureSpec.getSize(i2)), i5);
                }
            }
        }
        super.onMeasure(i, obj5);
        if (this.c == null) {
        }
        obj4 = View.MeasureSpec.getMode(obj5);
        visibility = this.b;
        if (visibility != null && visibility.getVisibility() != 8 && obj4 != 1073741824) {
            if (visibility.getVisibility() != 8) {
                if (obj4 != 1073741824) {
                    if (!b(this.c)) {
                        i4 = a(this.c);
                    } else {
                        if (!b(this.v)) {
                            i4 = a(this.v);
                        } else {
                            i4 = 0;
                        }
                    }
                    if (obj4 == i5) {
                        obj4 = View.MeasureSpec.getSize(obj5);
                    } else {
                        obj4 = Integer.MAX_VALUE;
                    }
                    setMeasuredDimension(getMeasuredWidth(), Math.min(i4 += i5, obj4));
                }
            }
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return 1;
    }

    @Override // android.widget.FrameLayout
    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2;
        int i;
        int top;
        int right;
        int bottom;
        Drawable obj5;
        drawable2 = this.w;
        if (drawable2 != null) {
            drawable2.setCallback(0);
            unscheduleDrawable(this.w);
        }
        this.w = drawable;
        drawable.setCallback(this);
        obj5 = this.c;
        if (drawable != null && obj5 != null) {
            drawable.setCallback(this);
            obj5 = this.c;
            if (obj5 != null) {
                this.w.setBounds(obj5.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        i = 1;
        if (this.z) {
            if (this.y == null) {
            } else {
                i = i3;
            }
        } else {
            if (this.w == null && this.x == null) {
                if (this.x == null) {
                } else {
                }
            } else {
            }
        }
        setWillNotDraw(i);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.FrameLayout
    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        int i;
        int measuredWidth;
        int measuredHeight;
        Drawable obj4;
        drawable2 = this.y;
        if (drawable2 != null) {
            drawable2.setCallback(0);
            unscheduleDrawable(this.y);
        }
        this.y = drawable;
        i = 0;
        drawable.setCallback(this);
        obj4 = this.y;
        if (drawable != null && this.z && obj4 != null) {
            drawable.setCallback(this);
            if (this.z) {
                obj4 = this.y;
                if (obj4 != null) {
                    obj4.setBounds(i, i, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        }
        if (this.z) {
            if (this.y == null) {
                i = i3;
            }
        } else {
        }
        setWillNotDraw(i);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.FrameLayout
    public void setStackedBackground(Drawable drawable) {
        Drawable left;
        int i;
        int top;
        int right;
        int bottom;
        Drawable obj5;
        left = this.x;
        if (left != null) {
            left.setCallback(0);
            unscheduleDrawable(this.x);
        }
        this.x = drawable;
        drawable.setCallback(this);
        obj5 = this.x;
        if (drawable != null && this.A && obj5 != null) {
            drawable.setCallback(this);
            if (this.A) {
                obj5 = this.x;
                if (obj5 != null) {
                    obj5.setBounds(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
                }
            }
        }
        i = 1;
        if (this.z) {
            if (this.y == null) {
            } else {
                i = i3;
            }
        } else {
            if (this.w == null && this.x == null) {
                if (this.x == null) {
                } else {
                }
            } else {
            }
        }
        setWillNotDraw(i);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.FrameLayout
    public void setTabContainer(androidx.appcompat.widget.m0 m0) {
        View view;
        int i;
        view = this.b;
        if (view != null) {
            removeView(view);
        }
        this.b = m0;
        if (m0 != null) {
            addView(m0);
            android.view.ViewGroup.LayoutParams layoutParams = m0.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            m0.setAllowCollapse(false);
        }
    }

    @Override // android.widget.FrameLayout
    public void setTransitioning(boolean z) {
        int obj1;
        this.a = z;
        obj1 = z ? 393216 : 262144;
        setDescendantFocusability(obj1);
    }

    @Override // android.widget.FrameLayout
    public void setVisibility(int i) {
        int obj3;
        super.setVisibility(i);
        final int i2 = 0;
        obj3 = i == 0 ? 1 : i2;
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setVisible(obj3, i2);
        }
        Drawable drawable2 = this.x;
        if (drawable2 != null) {
            drawable2.setVisible(obj3, i2);
        }
        Drawable drawable3 = this.y;
        if (drawable3 != null) {
            drawable3.setVisible(obj3, i2);
        }
    }

    @Override // android.widget.FrameLayout
    public ActionMode startActionModeForChild(View view, ActionMode.Callback actionMode$Callback2) {
        return null;
    }

    @Override // android.widget.FrameLayout
    public ActionMode startActionModeForChild(View view, ActionMode.Callback actionMode$Callback2, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback2, i3);
        }
        return null;
    }

    @Override // android.widget.FrameLayout
    protected boolean verifyDrawable(Drawable drawable) {
        boolean drawable2;
        Drawable obj2;
        if (drawable == this.w) {
            if (this.z) {
                if (drawable == this.x) {
                    if (!this.A) {
                        if (drawable == this.y) {
                            if (!this.z) {
                                obj2 = super.verifyDrawable(drawable) ? 1 : 0;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }
}
