package app.dogo.com.dogo_android.util.e0;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.util.k0.g;

/* loaded from: classes.dex */
public abstract class x extends app.dogo.com.dogo_android.util.e0.w {

    protected g x;

    class a extends g {

        final app.dogo.com.dogo_android.util.e0.x a;
        a(app.dogo.com.dogo_android.util.e0.x x) {
            this.a = x;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            return this.a.I1();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return 1;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            this.a.G1().onBackPressed();
        }
    }
    public x() {
        super();
        x.a aVar = new x.a(this);
        this.x = aVar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.w
    public abstract cn b2();

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
    public void onViewCreated(View view, Bundle bundle2) {
        cn obj1;
        Object obj2;
        super.onViewCreated(view, bundle2);
        if (b2() != null) {
            b2().U(this.x);
        }
    }
}
