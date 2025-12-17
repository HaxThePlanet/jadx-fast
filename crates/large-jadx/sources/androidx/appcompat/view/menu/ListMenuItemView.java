package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.t0;
import d.a.a;
import d.a.f;
import d.a.g;
import d.a.j;
import d.h.l.u;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements androidx.appcompat.view.menu.n.a, AbsListView.SelectionBoundsAdjuster {

    private LinearLayout A;
    private Drawable B;
    private int C;
    private Context D;
    private boolean E;
    private Drawable F;
    private boolean G;
    private LayoutInflater H;
    private boolean I;
    private androidx.appcompat.view.menu.i a;
    private ImageView b;
    private RadioButton c;
    private TextView v;
    private CheckBox w;
    private TextView x;
    private ImageView y;
    private ImageView z;
    public ListMenuItemView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.D);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2);
        final int i6 = 0;
        final t0 obj5 = t0.v(getContext(), attributeSet2, j.L1, i3, i6);
        this.B = obj5.g(j.N1);
        this.C = obj5.n(j.M1, -1);
        this.E = obj5.a(j.O1, i6);
        this.D = context;
        this.F = obj5.g(j.P1);
        int[] obj6 = new int[1];
        obj6[i6] = 16843049;
        TypedArray obj4 = context.getTheme().obtainStyledAttributes(0, obj6, a.A, i6);
        this.G = obj4.hasValue(i6);
        obj5.w();
        obj4.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        final LinearLayout linearLayout = this.A;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void c() {
        View inflate = getInflater().inflate(g.h, this, false);
        this.w = (CheckBox)inflate;
        a(inflate);
    }

    private void d() {
        final int i2 = 0;
        View inflate = getInflater().inflate(g.i, this, i2);
        this.b = (ImageView)inflate;
        b(inflate, i2);
    }

    private void e() {
        View inflate = getInflater().inflate(g.k, this, false);
        this.c = (RadioButton)inflate;
        a(inflate);
    }

    private LayoutInflater getInflater() {
        LayoutInflater from;
        if (this.H == null) {
            this.H = LayoutInflater.from(getContext());
        }
        return this.H;
    }

    private void setSubMenuArrowVisible(boolean z) {
        int obj2;
        final ImageView view = this.y;
        if (view != null) {
            obj2 = z != 0 ? 0 : 8;
            view.setVisibility(obj2);
        }
    }

    @Override // android.widget.LinearLayout
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView bottomMargin;
        int i2;
        int i;
        int topMargin;
        bottomMargin = this.z;
        if (bottomMargin != null && bottomMargin.getVisibility() == 0) {
            if (bottomMargin.getVisibility() == 0) {
                android.view.ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
                rect.top = top += i;
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void f(boolean z, char c2) {
        String str;
        boolean obj2;
        TextView obj3;
        if (z && this.a.A()) {
            obj2 = this.a.A() ? 0 : 8;
        } else {
        }
        if (obj2 == null) {
            this.x.setText(this.a.h());
        }
        if (this.x.getVisibility() != obj2) {
            this.x.setVisibility(obj2);
        }
    }

    @Override // android.widget.LinearLayout
    public boolean g() {
        return 0;
    }

    @Override // android.widget.LinearLayout
    public androidx.appcompat.view.menu.i getItemData() {
        return this.a;
    }

    @Override // android.widget.LinearLayout
    public void h(androidx.appcompat.view.menu.i i, int i2) {
        int obj3;
        this.a = i;
        obj3 = i.isVisible() ? 0 : 8;
        setVisibility(obj3);
        setTitle(i.i(this));
        setCheckable(i.isCheckable());
        f(i.A(), i.g());
        setIcon(i.getIcon());
        setEnabled(i.isEnabled());
        setSubMenuArrowVisible(i.hasSubMenu());
        setContentDescription(i.getContentDescription());
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        int i;
        int i2;
        super.onFinishInflate();
        u.o0(this, this.B);
        View viewById = findViewById(f.M);
        this.v = (TextView)viewById;
        i = this.C;
        if (i != -1) {
            viewById.setTextAppearance(this.D, i);
        }
        this.x = (TextView)findViewById(f.F);
        View viewById3 = findViewById(f.I);
        this.y = (ImageView)viewById3;
        if (viewById3 != null) {
            viewById3.setImageDrawable(this.F);
        }
        this.z = (ImageView)findViewById(f.r);
        this.A = (LinearLayout)findViewById(f.l);
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        ImageView height;
        android.view.ViewGroup.LayoutParams layoutParams;
        int width;
        layoutParams = this.b.getLayoutParams();
        height = layoutParams2.height;
        if (this.b != null && this.E && height > 0 && layoutParams.width <= 0) {
            if (this.E) {
                layoutParams = this.b.getLayoutParams();
                height = layoutParams2.height;
                if (height > 0) {
                    if (layoutParams.width <= 0) {
                        layoutParams.width = height;
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.LinearLayout
    public void setCheckable(boolean z) {
        Object radioButton;
        Object obj;
        Object obj2;
        int obj4;
        if (!z && this.c == null && this.w == null) {
            if (this.c == null) {
                if (this.w == null) {
                }
            }
        }
        if (this.a.m()) {
            if (this.c == null) {
                e();
            }
            obj = this.c;
            obj2 = this.w;
        } else {
            if (this.w == null) {
                c();
            }
            obj = this.w;
            obj2 = this.c;
        }
        final int i = 8;
        if (z) {
            obj.setChecked(this.a.isChecked());
            if (obj.getVisibility() != 0) {
                obj.setVisibility(0);
            }
            if (obj2 != null && obj2.getVisibility() != i) {
                if (obj2.getVisibility() != i) {
                    obj2.setVisibility(i);
                }
            }
        } else {
            obj4 = this.w;
            if (obj4 != null) {
                obj4.setVisibility(i);
            }
            obj4 = this.c;
            if (obj4 != null) {
                obj4.setVisibility(i);
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void setChecked(boolean z) {
        Object obj;
        if (this.a.m()) {
            if (this.c == null) {
                e();
            }
            obj = this.c;
        } else {
            if (this.w == null) {
                c();
            }
            obj = this.w;
        }
        obj.setChecked(z);
    }

    @Override // android.widget.LinearLayout
    public void setForceShowIcon(boolean z) {
        this.I = z;
        this.E = z;
    }

    @Override // android.widget.LinearLayout
    public void setGroupDividerEnabled(boolean z) {
        boolean z2;
        int obj3;
        final ImageView view = this.z;
        if (view != null) {
            if (!this.G && z != 0) {
                obj3 = z != 0 ? 0 : 8;
            } else {
            }
            view.setVisibility(obj3);
        }
    }

    @Override // android.widget.LinearLayout
    public void setIcon(Drawable drawable) {
        boolean z;
        int i;
        boolean z3;
        boolean view;
        boolean z2;
        ImageView obj5;
        final int i2 = 0;
        if (!this.a.z()) {
            if (this.I) {
                i = 1;
            } else {
                i = i2;
            }
        } else {
        }
        if (i == 0 && !this.E) {
            if (!this.E) {
            }
        }
        view = this.b;
        if (view == null && drawable == null && !this.E) {
            if (drawable == null) {
                if (!this.E) {
                }
            }
        }
        if (view == null) {
            d();
        }
        if (drawable == null) {
            if (this.E) {
                if (i != 0) {
                } else {
                    obj5 = 0;
                }
                this.b.setImageDrawable(obj5);
                if (this.b.getVisibility() != 0) {
                    this.b.setVisibility(i2);
                }
            } else {
                this.b.setVisibility(8);
            }
        } else {
        }
    }

    @Override // android.widget.LinearLayout
    public void setTitle(java.lang.CharSequence charSequence) {
        int i;
        int obj2;
        if (charSequence != null) {
            this.v.setText(charSequence);
            if (this.v.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
        } else {
            i = 8;
            if (this.v.getVisibility() != i) {
                this.v.setVisibility(i);
            }
        }
    }
}
