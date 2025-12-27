package com.iterable.iterableapi;

/* compiled from: IterableConfig.java */
/* loaded from: classes2.dex */
public class q {

    final String a;
    final y0 b;
    final r c;
    final boolean d;
    final int e;
    final d0 f;
    final double g;
    final o h;
    final long i;
    final String[] j;

    static class a {
    }

    public static class b {

        private String a;
        private y0 b;
        private r c;
        private boolean d = true;
        private boolean e;
        private int f = 6;
        private d0 g = new t();
        private double h = 30d;
        private o i;
        private long j = 60000;
        private String[] k;
        public b() {
            super();
            com.iterable.iterableapi.t tVar = new t();
            this.k = new String[0];
        }

        static /* synthetic */ String a(q.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ y0 b(q.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ String[] c(q.b bVar) {
            return bVar.k;
        }

        static /* synthetic */ r d(q.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ boolean e(q.b bVar) {
            return bVar.d;
        }

        static /* synthetic */ boolean f(q.b bVar) {
            return bVar.e;
        }

        static /* synthetic */ int g(q.b bVar) {
            return bVar.f;
        }

        static /* synthetic */ d0 h(q.b bVar) {
            return bVar.g;
        }

        static /* synthetic */ double i(q.b bVar) {
            return bVar.h;
        }

        static /* synthetic */ o j(q.b bVar) {
            return bVar.i;
        }

        static /* synthetic */ long k(q.b bVar) {
            return bVar.j;
        }

        public q l() {
            return new q(this, null);
        }

        public q.b m(String[] strArr) {
            this.k = strArr;
            return this;
        }
    }
    /* synthetic */ q(q.b bVar, q.a aVar) {
        this(bVar);
    }

    private q(q.b bVar) {
        super();
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        bVar.e;
        this.e = bVar.f;
        this.f = bVar.g;
        this.g = bVar.h;
        this.h = bVar.i;
        this.i = bVar.j;
        this.j = bVar.k;
    }
}
