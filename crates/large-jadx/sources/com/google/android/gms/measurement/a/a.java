package com.google.android.gms.measurement.a;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.g3;
import com.google.android.gms.measurement.internal.d6;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {

    private final g3 a;

    public interface a extends d6 {
    }
    public a(g3 g3) {
        super();
        this.a = g3;
    }

    public void a(String string, String string2, Bundle bundle3) {
        this.a.O(string, string2, bundle3);
    }

    public List<Bundle> b(String string, String string2) {
        return this.a.I(string, string2);
    }

    public int c(String string) {
        return this.a.v(string);
    }

    public Map<String, Object> d(String string, String string2, boolean z3) {
        return this.a.J(string, string2, z3);
    }

    public void e(String string, String string2, Bundle bundle3) {
        this.a.R(string, string2, bundle3);
    }

    public void f(com.google.android.gms.measurement.a.a.a a$a) {
        this.a.b(a);
    }

    public void g(Bundle bundle) {
        this.a.d(bundle);
    }

    public void h(String string, String string2, Object object3) {
        this.a.m(string, string2, object3, true);
    }

    public final void i(boolean z) {
        this.a.g(z);
    }
}
