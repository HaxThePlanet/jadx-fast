package f.c.a.e.s;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.c;
import androidx.appcompat.app.c.a;
import com.google.android.material.theme.a.a;
import d.a.o.d;
import d.h.l.u;
import f.c.a.e.a0.b;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.k;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public class b extends c.a {

    private static final int e;
    private static final int f;
    private static final int g;
    private Drawable c;
    private final Rect d;
    static {
        b.e = b.a;
        b.f = k.b;
        b.g = b.y;
    }

    public b(Context context) {
        super(context, 0);
    }

    public b(Context context, int i2) {
        int i3;
        int i;
        int obj6;
        Resources.Theme obj7;
        super(b.p(context), b.r(context, i2));
        obj6 = getContext();
        int i4 = b.e;
        i = b.f;
        this.d = c.a(obj6, i4, i);
        g gVar = new g(obj6, 0, i4, i);
        gVar.O(obj6);
        gVar.Z(ColorStateList.valueOf(a.c(obj6, b.q, b.class.getCanonicalName())));
        obj6 = new TypedValue();
        obj6.getTheme().resolveAttribute(16844145, obj6, true);
        obj7 = obj6.getDimension(getContext().getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT >= 28 && obj6.type == 5 && Float.compare(obj7, obj6) >= 0) {
            obj6 = new TypedValue();
            obj7.resolveAttribute(16844145, obj6, true);
            obj7 = obj6.getDimension(getContext().getResources().getDisplayMetrics());
            if (obj6.type == 5) {
                if (Float.compare(obj7, obj6) >= 0) {
                    gVar.W(obj7);
                }
            }
        }
        this.c = gVar;
    }

    private static Context p(Context context) {
        final int i = b.q(context);
        final Context obj4 = a.c(context, 0, b.e, b.f);
        if (i == 0) {
            return obj4;
        }
        d dVar = new d(obj4, i);
        return dVar;
    }

    private static int q(Context context) {
        TypedValue obj1 = b.a(context, b.g);
        if (obj1 == null) {
            return 0;
        }
        return obj1.data;
    }

    private static int r(Context context, int i2) {
        int obj1;
        if (i2 == 0) {
            obj1 = b.q(context);
        }
        return obj1;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b A(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        super.h(i, onClickListener2);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b B(DialogInterface.OnCancelListener dialogInterface$OnCancelListener) {
        super.i(onCancelListener);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b C(DialogInterface.OnKeyListener dialogInterface$OnKeyListener) {
        super.j(onKeyListener);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b D(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        return (b)super.setPositiveButton(i, onClickListener2);
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b E(java.lang.CharSequence charSequence, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        super.k(charSequence, onClickListener2);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b F(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener dialogInterface$OnClickListener3) {
        super.l(listAdapter, i2, onClickListener3);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b G(int i) {
        super.m(i);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b H(java.lang.CharSequence charSequence) {
        return (b)super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b I(int i) {
        super.n(i);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b J(View view) {
        return (b)super.setView(view);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a a(ListAdapter listAdapter, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        return s(listAdapter, onClickListener2);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a c(View view) {
        return u(view);
    }

    @Override // androidx.appcompat.app.c$a
    public c create() {
        boolean z;
        final c create = super.create();
        Window window = create.getWindow();
        final View decorView = window.getDecorView();
        Drawable drawable = this.c;
        if (drawable instanceof g) {
            (g)drawable.Y(u.w(decorView));
        }
        window.setBackgroundDrawable(c.b(this.c, this.d));
        a aVar = new a(create, this.d);
        decorView.setOnTouchListener(aVar);
        return create;
    }

    @Override // androidx.appcompat.app.c$a
    public c.a d(Drawable drawable) {
        return v(drawable);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a e(int i) {
        return w(i);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a j(DialogInterface.OnKeyListener dialogInterface$OnKeyListener) {
        return C(onKeyListener);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a l(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener dialogInterface$OnClickListener3) {
        return F(listAdapter, i2, onClickListener3);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a m(int i) {
        return G(i);
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b s(ListAdapter listAdapter, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        super.a(listAdapter, onClickListener2);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public c.a setNegativeButton(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        return y(i, onClickListener2);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a setPositiveButton(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        return D(i, onClickListener2);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a setTitle(java.lang.CharSequence charSequence) {
        return H(charSequence);
    }

    @Override // androidx.appcompat.app.c$a
    public c.a setView(View view) {
        return J(view);
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b t(boolean z) {
        super.b(z);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b u(View view) {
        super.c(view);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b v(Drawable drawable) {
        super.d(drawable);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b w(int i) {
        super.e(i);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b x(java.lang.CharSequence charSequence) {
        super.f(charSequence);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b y(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        return (b)super.setNegativeButton(i, onClickListener2);
    }

    @Override // androidx.appcompat.app.c$a
    public f.c.a.e.s.b z(java.lang.CharSequence charSequence, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
        super.g(charSequence, onClickListener2);
        return (b)this;
    }
}
