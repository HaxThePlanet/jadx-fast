package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class r extends com.google.android.gms.tasks.a {

    private final com.google.android.gms.tasks.m0<Void> a;
    r() {
        super();
        m0 m0Var = new m0();
        this.a = m0Var;
    }

    @Override // com.google.android.gms.tasks.a
    public final com.google.android.gms.tasks.a a(com.google.android.gms.tasks.h h) {
        n nVar = new n(this, h);
        this.a.addOnSuccessListener(l.a, nVar);
        return this;
    }

    @Override // com.google.android.gms.tasks.a
    public final void b() {
        this.a.b(0);
    }
}
