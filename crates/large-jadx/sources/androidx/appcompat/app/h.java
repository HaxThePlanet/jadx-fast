package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import d.a.a;
import d.a.o.b;
import d.a.o.b.a;
import d.h.l.f;
import d.h.l.f.a;

/* loaded from: classes.dex */
public class h extends Dialog implements androidx.appcompat.app.e {

    private androidx.appcompat.app.f mDelegate;
    private final f.a mKeyDispatcher;

    class a implements f.a {

        final androidx.appcompat.app.h a;
        a(androidx.appcompat.app.h h) {
            this.a = h;
            super();
        }

        @Override // d.h.l.f$a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return this.a.superDispatchKeyEvent(keyEvent);
        }
    }
    public h(Context context) {
        super(context, 0);
    }

    public h(Context context, int i2) {
        super(context, h.getThemeResId(context, i2));
        h.a aVar = new h.a(this);
        this.mKeyDispatcher = aVar;
        androidx.appcompat.app.f delegate = getDelegate();
        delegate.H(h.getThemeResId(context, i2));
        delegate.s(0);
    }

    protected h(Context context, boolean z2, DialogInterface.OnCancelListener dialogInterface$OnCancelListener3) {
        super(context, z2, onCancelListener3);
        h.a obj1 = new h.a(this);
        this.mKeyDispatcher = obj1;
    }

    private static int getThemeResId(Context context, int i2) {
        int i3;
        int i;
        Resources.Theme obj2;
        int obj3;
        if (i2 == 0) {
            obj3 = new TypedValue();
            context.getTheme().resolveAttribute(a.z, obj3, true);
            obj3 = obj3.resourceId;
        }
        return obj3;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        getDelegate().d(view, layoutParams2);
    }

    @Override // android.app.Dialog
    public void dismiss() {
        super.dismiss();
        getDelegate().t();
    }

    @Override // android.app.Dialog
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return f.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().i(i);
    }

    @Override // android.app.Dialog
    public androidx.appcompat.app.f getDelegate() {
        androidx.appcompat.app.f mDelegate;
        if (this.mDelegate == null) {
            this.mDelegate = f.h(this, this);
        }
        return this.mDelegate;
    }

    @Override // android.app.Dialog
    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().n();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().p();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        getDelegate().o();
        super.onCreate(bundle);
        getDelegate().s(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().y();
    }

    @Override // android.app.Dialog
    public void onSupportActionModeFinished(b b) {
    }

    @Override // android.app.Dialog
    public void onSupportActionModeStarted(b b) {
    }

    @Override // android.app.Dialog
    public b onWindowStartingSupportActionMode(b.a b$a) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        getDelegate().D(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().E(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        getDelegate().F(view, layoutParams2);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().I(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().I(charSequence);
    }

    @Override // android.app.Dialog
    boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().B(i);
    }
}
