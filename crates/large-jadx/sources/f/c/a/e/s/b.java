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
import d.a.o.d;
import d.h.l.u;
import f.c.a.e.d0.g;
import f.c.a.e.k;

/* compiled from: MaterialAlertDialogBuilder.java */
/* loaded from: classes2.dex */
public class b extends c.a {

    private static final int e = 0;
    private static final int f = 0;
    private static final int g = 0;
    private Drawable c;
    private final Rect d;
    static {
        b.e = b.a;
        b.f = k.b;
        b.g = b.y;
    }

    public b(Context context) {
        this(context, 0);
    }

    private static Context p(Context context) {
        final int i = b.q(context);
        final Context context2 = a.c(context, null, b.e, b.f);
        if (i == 0) {
            return context2;
        }
        return new d(context2, i);
    }

    private static int q(Context context) {
        TypedValue typedValue = b.a(context, b.g);
        if (typedValue == null) {
            return 0;
        }
        return typedValue.data;
    }

    private static int r(Context context, int i) {
        if (i == 0) {
            i = b.q(context);
        }
        return i;
    }

    @Override // androidx.appcompat.app.c$a
    public b A(int i, DialogInterface.OnClickListener list) {
        super.h(i, list);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b B(DialogInterface.OnCancelListener list) {
        super.i(list);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b C(DialogInterface.OnKeyListener list) {
        super.j(list);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b D(int i, DialogInterface.OnClickListener list) {
        return (b)super.setPositiveButton(i, list);
    }

    @Override // androidx.appcompat.app.c$a
    public b E(java.lang.CharSequence charSequence, DialogInterface.OnClickListener list) {
        super.k(charSequence, list);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b F(ListAdapter list, int i, DialogInterface.OnClickListener list2) {
        super.l(list, i, list2);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b G(int i) {
        super.m(i);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b H(java.lang.CharSequence charSequence) {
        return (b)super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.c$a
    public b I(int i) {
        super.n(i);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b J(View view) {
        return (b)super.setView(view);
    }

    @Override // androidx.appcompat.app.c$a
    public c create() {
        final c aVar = super.create();
        Window window = aVar.getWindow();
        final View decorView = window.getDecorView();
        z = drawable instanceof g;
        if (drawable instanceof g) {
            drawable.Y(u.w(decorView));
        }
        window.setBackgroundDrawable(c.b(this.c, this.d));
        decorView.setOnTouchListener(new a(aVar, this.d));
        return aVar;
    }

    @Override // androidx.appcompat.app.c$a
    public b s(ListAdapter list, DialogInterface.OnClickListener list2) {
        super.a(list, list2);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b t(boolean z) {
        super.b(z);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b u(View view) {
        super.c(view);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b v(Drawable drawable) {
        super.d(drawable);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b w(int i) {
        super.e(i);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b x(java.lang.CharSequence charSequence) {
        super.f(charSequence);
        return (b)this;
    }

    @Override // androidx.appcompat.app.c$a
    public b y(int i, DialogInterface.OnClickListener list) {
        return (b)super.setNegativeButton(i, list);
    }

    @Override // androidx.appcompat.app.c$a
    public b z(java.lang.CharSequence charSequence, DialogInterface.OnClickListener list) {
        super.g(charSequence, list);
        return (b)this;
    }

    public b(Context context, int i) {
        super(b.p(context), b.r(context, i));
        Context context3 = getContext();
        int i4 = b.e;
        i3 = b.f;
        this.d = c.a(context3, i4, i3);
        g gVar = new g(context3, null, i4, i3);
        gVar.O(context3);
        gVar.Z(ColorStateList.valueOf(a.c(context3, b.q, b.class.getCanonicalName())));
        i = 28;
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            context3.getTheme().resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            i = 5;
            if (typedValue.type == 5) {
                if (dimension >= 0) {
                    gVar.W(dimension);
                }
            }
        }
        this.c = gVar;
    }
}
