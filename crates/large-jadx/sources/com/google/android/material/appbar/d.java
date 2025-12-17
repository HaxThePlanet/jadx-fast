package com.google.android.material.appbar;

import android.view.View;
import d.h.l.u;

/* loaded from: classes2.dex */
class d {

    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f = true;
    private boolean g = true;
    public d(View view) {
        super();
        final int i = 1;
        this.a = view;
    }

    void a() {
        View view = this.a;
        u.X(view, i -= i5);
        View view2 = this.a;
        u.W(view2, i3 -= i6);
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public boolean d() {
        return this.g;
    }

    public boolean e() {
        return this.f;
    }

    void f() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
    }

    public void g(boolean z) {
        this.g = z;
    }

    public boolean h(int i) {
        boolean z;
        if (this.g && this.e != i) {
            if (this.e != i) {
                this.e = i;
                a();
                return 1;
            }
        }
        return 0;
    }

    public boolean i(int i) {
        boolean z;
        if (this.f && this.d != i) {
            if (this.d != i) {
                this.d = i;
                a();
                return 1;
            }
        }
        return 0;
    }

    public void j(boolean z) {
        this.f = z;
    }
}
