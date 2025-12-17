package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView.a;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.v0;
import d.a.j;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements androidx.appcompat.view.menu.n.a, View.OnClickListener, ActionMenuView.a {

    private int A;
    private int B;
    private int C;
    androidx.appcompat.view.menu.i a;
    private java.lang.CharSequence b;
    private Drawable c;
    androidx.appcompat.view.menu.g.b v;
    private d0 w;
    androidx.appcompat.view.menu.ActionMenuItemView.b x;
    private boolean y;
    private boolean z;

    public static abstract class b {
        public abstract androidx.appcompat.view.menu.p a();
    }

    private class a extends d0 {

        final androidx.appcompat.view.menu.ActionMenuItemView B;
        public a(androidx.appcompat.view.menu.ActionMenuItemView actionMenuItemView) {
            this.B = actionMenuItemView;
            super(actionMenuItemView);
        }

        @Override // androidx.appcompat.widget.d0
        public androidx.appcompat.view.menu.p b() {
            androidx.appcompat.view.menu.ActionMenuItemView.b view2 = view.x;
            if (view2 != null) {
                return view2.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.d0
        protected boolean c() {
            androidx.appcompat.view.menu.ActionMenuItemView view;
            int i;
            view = this.B;
            final androidx.appcompat.view.menu.g.b bVar = view.v;
            i = 0;
            view = b();
            if (bVar != null && bVar.a(view.a) && view != null && view.b()) {
                if (bVar.a(view.a)) {
                    view = b();
                    if (view != null) {
                        if (view.b()) {
                            i = 1;
                        }
                    }
                }
            }
            return i;
        }
    }
    public ActionMenuItemView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        this.y = j();
        final int i = 0;
        TypedArray obj4 = context.obtainStyledAttributes(attributeSet2, j.v, i3, i);
        this.A = obj4.getDimensionPixelSize(j.w, i);
        obj4.recycle();
        this.C = (int)obj4;
        setOnClickListener(this);
        this.B = -1;
        setSaveEnabled(i);
    }

    private boolean j() {
        int i;
        Configuration configuration;
        int screenWidthDp;
        int i2;
        configuration = getContext().getResources().getConfiguration();
        screenWidthDp = configuration.screenWidthDp;
        final int i3 = 480;
        if (screenWidthDp < i3) {
            if (screenWidthDp >= 640) {
                if (configuration.screenHeightDp < i3) {
                    if (configuration.orientation == 2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void k() {
        int i;
        int i2;
        int title;
        Drawable drawable;
        java.lang.CharSequence charSequence;
        java.lang.CharSequence contentDescription;
        if (this.c != null) {
            if (this.a.B()) {
                if (!this.y) {
                    if (this.z) {
                    } else {
                        i2 = 0;
                    }
                }
            } else {
            }
        }
        i3 &= i2;
        title = 0;
        charSequence = i != 0 ? this.b : title;
        setText(charSequence);
        contentDescription = this.a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (i != 0) {
                contentDescription = title;
            } else {
                contentDescription = this.a.getTitle();
            }
            setContentDescription(contentDescription);
        } else {
            setContentDescription(contentDescription);
        }
        java.lang.CharSequence tooltipText = this.a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (i != 0) {
            } else {
                title = this.a.getTitle();
            }
            v0.a(this, title);
        } else {
            v0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public boolean e() {
        return i();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public boolean f() {
        boolean icon;
        int i;
        if (i() && this.a.getIcon() == null) {
            i = this.a.getIcon() == null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public boolean g() {
        return 1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public androidx.appcompat.view.menu.i getItemData() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void h(androidx.appcompat.view.menu.i i, int i2) {
        boolean obj1;
        int obj2;
        this.a = i;
        setIcon(i.getIcon());
        setTitle(i.i(this));
        setId(i.getItemId());
        obj2 = i.isVisible() ? 0 : 8;
        setVisibility(obj2);
        setEnabled(i.isEnabled());
        if (i.hasSubMenu() && this.w == null) {
            if (this.w == null) {
                obj1 = new ActionMenuItemView.a(this);
                this.w = obj1;
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public boolean i() {
        return empty ^= 1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onClick(View view) {
        androidx.appcompat.view.menu.i iVar;
        final androidx.appcompat.view.menu.g.b obj2 = this.v;
        if (obj2 != null) {
            obj2.a(this.a);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.y = j();
        k();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    protected void onMeasure(int i, int i2) {
        boolean paddingRight2;
        int i3;
        int paddingBottom2;
        int paddingTop;
        int paddingRight;
        int i4;
        int paddingBottom;
        int obj6;
        int obj7;
        paddingRight2 = i();
        i3 = this.B;
        if (paddingRight2 && i3 >= 0) {
            i3 = this.B;
            if (i3 >= 0) {
                super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
        }
        super.onMeasure(i, i2);
        paddingBottom2 = View.MeasureSpec.getMode(i);
        if (paddingBottom2 == Integer.MIN_VALUE) {
            obj6 = Math.min(View.MeasureSpec.getSize(i), this.A);
        } else {
            obj6 = this.A;
        }
        int i5 = 1073741824;
        if (paddingBottom2 != i5 && this.A > 0 && getMeasuredWidth() < obj6) {
            if (this.A > 0) {
                if (getMeasuredWidth() < obj6) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(obj6, i5), i2);
                }
            }
        }
        if (!paddingRight2 && this.c != null) {
            if (this.c != null) {
                super.setPadding(obj6 /= 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean subMenu;
        subMenu = this.w;
        if (this.a.hasSubMenu() && subMenu != null && subMenu.onTouch(this, motionEvent)) {
            subMenu = this.w;
            if (subMenu != null) {
                if (subMenu.onTouch(this, motionEvent)) {
                    return 1;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setCheckable(boolean z) {
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setChecked(boolean z) {
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setExpandedFormat(boolean z) {
        boolean obj2;
        this.z = z;
        obj2 = this.a;
        if (this.z != z && obj2 != null) {
            this.z = z;
            obj2 = this.a;
            if (obj2 != null) {
                obj2.c();
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setIcon(Drawable drawable) {
        int intrinsicWidth;
        int i;
        int intrinsicHeight;
        int i3;
        int i2;
        this.c = drawable;
        intrinsicWidth = drawable.getIntrinsicWidth();
        i3 = this.C;
        if (drawable != null && intrinsicWidth > i3) {
            intrinsicWidth = drawable.getIntrinsicWidth();
            i3 = this.C;
            if (intrinsicWidth > i3) {
                intrinsicHeight = (int)i6;
                intrinsicWidth = i3;
            }
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int)i5;
            } else {
                i3 = intrinsicHeight;
            }
            i = 0;
            drawable.setBounds(i, i, intrinsicWidth, i3);
        }
        int i4 = 0;
        setCompoundDrawables(drawable, i4, i4, i4);
        k();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setItemInvoker(androidx.appcompat.view.menu.g.b g$b) {
        this.v = b;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setPadding(int i, int i2, int i3, int i4) {
        this.B = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setPopupCallback(androidx.appcompat.view.menu.ActionMenuItemView.b actionMenuItemView$b) {
        this.x = b;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setTitle(java.lang.CharSequence charSequence) {
        this.b = charSequence;
        k();
    }
}
