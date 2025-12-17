package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.lifecycle.b0;
import androidx.lifecycle.j;
import androidx.lifecycle.j.c;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import d.e.g;
import d.h.l.f;
import d.h.l.f.a;

/* loaded from: classes.dex */
public class f extends Activity implements q, f.a {

    private g<Class<? extends androidx.core.app.f.a>, androidx.core.app.f.a> mExtraDataMap;
    private s mLifecycleRegistry;

    @Deprecated
    public static class a {
    }
    public f() {
        super();
        g gVar = new g();
        this.mExtraDataMap = gVar;
        s sVar = new s(this);
        this.mLifecycleRegistry = sVar;
    }

    @Override // android.app.Activity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        android.view.View decorView = getWindow().getDecorView();
        if (decorView != null && f.d(decorView, keyEvent)) {
            if (f.d(decorView, keyEvent)) {
                return 1;
            }
        }
        return f.e(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        android.view.View decorView;
        decorView = getWindow().getDecorView();
        if (decorView != null && f.d(decorView, keyEvent)) {
            if (f.d(decorView, keyEvent)) {
                return 1;
            }
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Deprecated
    public <T extends androidx.core.app.f.a> T getExtraData(Class<T> class) {
        return (f.a)this.mExtraDataMap.get(class);
    }

    @Override // android.app.Activity
    public j getLifecycle() {
        throw 0;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b0.g(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.j(j.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(androidx.core.app.f.a f$a) {
        this.mExtraDataMap.put(a.getClass(), a);
    }

    @Override // android.app.Activity
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
