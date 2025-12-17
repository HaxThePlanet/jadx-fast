package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.google.android.play.core.internal.b1;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;
import java.util.List;

/* loaded from: classes2.dex */
class w<T>  extends b1 {

    final o<T> a;
    final com.google.android.play.core.splitinstall.x b;
    w(com.google.android.play.core.splitinstall.x x, o o2) {
        this.b = x;
        super();
        this.a = o2;
    }

    @Override // com.google.android.play.core.internal.b1
    public final void J0(int i, Bundle bundle2) {
        obj4.b.s(this.a);
        Object[] arr = new Object[1];
        x.b().d("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.b1
    public final void K0(Bundle bundle) {
        obj3.b.s(this.a);
        x.b().d("onGetSplitsForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.b1
    public void K1(int i, Bundle bundle2) {
        obj4.b.s(this.a);
        Object[] arr = new Object[1];
        x.b().d("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.b1
    public void Q(Bundle bundle) {
        obj3.b.s(this.a);
        x.b().d("onDeferredUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.b1
    public void c(Bundle bundle) {
        obj3.b.s(this.a);
        x.b().d("onDeferredLanguageInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.b1
    public final void d1(Bundle bundle) {
        xVar.b.s(this.a);
        final int obj5 = bundle.getInt("error_code");
        Object[] arr = new Object[1];
        x.b().b("onError(%d)", Integer.valueOf(obj5));
        SplitInstallException splitInstallException = new SplitInstallException(obj5);
        this.a.d(splitInstallException);
    }

    @Override // com.google.android.play.core.internal.b1
    public void g(int i, Bundle bundle2) {
        obj4.b.s(this.a);
        Object[] arr = new Object[1];
        x.b().d("onCancelInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.b1
    public void h(Bundle bundle) {
        obj3.b.s(this.a);
        x.b().d("onDeferredInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.b1
    public void i0(Bundle bundle) {
        obj3.b.s(this.a);
        x.b().d("onDeferredLanguageUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.b1
    public void l1(int i, Bundle bundle2) {
        obj4.b.s(this.a);
        Object[] arr = new Object[1];
        x.b().d("onStartInstall(%d)", Integer.valueOf(i));
    }

    public void u(List<Bundle> list) {
        obj3.b.s(this.a);
        x.b().d("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.b1
    public final void w1(Bundle bundle) {
        obj3.b.s(this.a);
        x.b().d("onCompleteInstallForAppUpdate", new Object[0]);
    }
}
