package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import d.a.a;

/* loaded from: classes.dex */
public class c extends androidx.appcompat.app.h implements DialogInterface {

    final androidx.appcompat.app.AlertController a;

    public static class a {

        private final androidx.appcompat.app.AlertController.f a;
        private final int b;
        public a(Context context) {
            super(context, c.b(context, 0));
        }

        public a(Context context, int i2) {
            super();
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, c.b(context, i2));
            AlertController.f fVar = new AlertController.f(contextThemeWrapper);
            this.a = fVar;
            this.b = i2;
        }

        public androidx.appcompat.app.c.a a(ListAdapter listAdapter, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener2;
            return this;
        }

        public androidx.appcompat.app.c.a b(boolean z) {
            fVar.r = z;
            return this;
        }

        public androidx.appcompat.app.c.a c(View view) {
            fVar.g = view;
            return this;
        }

        public androidx.appcompat.app.c create() {
            boolean z;
            c cVar = new c(fVar.a, this.b);
            this.a.a(cVar.a);
            cVar.setCancelable(fVar3.r);
            if (fVar4.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(fVar5.s);
            cVar.setOnDismissListener(fVar6.t);
            DialogInterface.OnKeyListener list3 = fVar7.u;
            if (list3 != null) {
                cVar.setOnKeyListener(list3);
            }
            return cVar;
        }

        public androidx.appcompat.app.c.a d(Drawable drawable) {
            fVar.d = drawable;
            return this;
        }

        public androidx.appcompat.app.c.a e(int i) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.h = fVar.a.getText(i);
            return this;
        }

        public androidx.appcompat.app.c.a f(java.lang.CharSequence charSequence) {
            fVar.h = charSequence;
            return this;
        }

        public androidx.appcompat.app.c.a g(java.lang.CharSequence charSequence, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.l = charSequence;
            fVar.n = onClickListener2;
            return this;
        }

        public Context getContext() {
            return fVar.a;
        }

        public androidx.appcompat.app.c.a h(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.o = fVar.a.getText(i);
            obj3.q = onClickListener2;
            return this;
        }

        public androidx.appcompat.app.c.a i(DialogInterface.OnCancelListener dialogInterface$OnCancelListener) {
            fVar.s = onCancelListener;
            return this;
        }

        public androidx.appcompat.app.c.a j(DialogInterface.OnKeyListener dialogInterface$OnKeyListener) {
            fVar.u = onKeyListener;
            return this;
        }

        public androidx.appcompat.app.c.a k(java.lang.CharSequence charSequence, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.i = charSequence;
            fVar.k = onClickListener2;
            return this;
        }

        public androidx.appcompat.app.c.a l(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener dialogInterface$OnClickListener3) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener3;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public androidx.appcompat.app.c.a m(int i) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.f = fVar.a.getText(i);
            return this;
        }

        public androidx.appcompat.app.c.a n(int i) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.z = 0;
            fVar.y = i;
            fVar.E = false;
            return this;
        }

        public androidx.appcompat.app.c o() {
            final androidx.appcompat.app.c create = create();
            create.show();
            return create;
        }

        public androidx.appcompat.app.c.a setNegativeButton(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.l = fVar.a.getText(i);
            obj3.n = onClickListener2;
            return this;
        }

        public androidx.appcompat.app.c.a setPositiveButton(int i, DialogInterface.OnClickListener dialogInterface$OnClickListener2) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.i = fVar.a.getText(i);
            obj3.k = onClickListener2;
            return this;
        }

        public androidx.appcompat.app.c.a setTitle(java.lang.CharSequence charSequence) {
            fVar.f = charSequence;
            return this;
        }

        public androidx.appcompat.app.c.a setView(View view) {
            final androidx.appcompat.app.AlertController.f fVar = this.a;
            fVar.z = view;
            final int obj2 = 0;
            fVar.y = obj2;
            fVar.E = obj2;
            return this;
        }
    }
    protected c(Context context, int i2) {
        super(context, c.b(context, i2));
        AlertController obj2 = new AlertController(getContext(), this, getWindow());
        this.a = obj2;
    }

    static int b(Context context, int i2) {
        final int i5 = 1;
        if (i &= 255 >= i5) {
            return i2;
        }
        TypedValue obj3 = new TypedValue();
        context.getTheme().resolveAttribute(a.o, obj3, i5);
        return obj3.resourceId;
    }

    @Override // androidx.appcompat.app.h
    public ListView a() {
        return this.a.d();
    }

    @Override // androidx.appcompat.app.h
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.e();
    }

    @Override // androidx.appcompat.app.h
    public boolean onKeyDown(int i, KeyEvent keyEvent2) {
        if (this.a.g(i, keyEvent2)) {
            return 1;
        }
        return super.onKeyDown(i, keyEvent2);
    }

    @Override // androidx.appcompat.app.h
    public boolean onKeyUp(int i, KeyEvent keyEvent2) {
        if (this.a.h(i, keyEvent2)) {
            return 1;
        }
        return super.onKeyUp(i, keyEvent2);
    }

    @Override // androidx.appcompat.app.h
    public void setTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
        this.a.q(charSequence);
    }
}
