package app.dogo.com.dogo_android.util.e0;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.util.k0.g;

/* compiled from: LegacyFullScreenFragment.java */
/* loaded from: classes.dex */
public abstract class x extends w {

    protected g x = new x$a();

    class a extends g {

        final /* synthetic */ x a;
        a() {
            this.a = xVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            return this.a.I1();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            this.a.G1().onBackPressed();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return true;
        }
    }
    public x() {
        super();
        final app.dogo.com.dogo_android.util.e0.x.a aVar = new app.dogo.com.dogo_android.util.base_classes.x.a(this);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onStart() {
        super.onStart();
        G1().getWindow().setSoftInputMode(16);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onStop() {
        super.onStop();
        G1().getWindow().setSoftInputMode(32);
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (b2() != null) {
            b2().U(this.x);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public abstract cn b2();
}
