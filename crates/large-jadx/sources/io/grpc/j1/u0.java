package io.grpc.j1;

import com.google.common.base.d;
import com.google.common.base.n;
import io.grpc.d1;
import io.grpc.j0;
import io.grpc.j0.a;
import io.grpc.l0;
import io.grpc.t0;
import io.grpc.t0.f;
import java.nio.charset.Charset;

/* compiled from: Http2ClientStreamTransportState.java */
/* loaded from: classes3.dex */
public abstract class u0 extends a.c {

    private static final j0.a<Integer> v = new u0$a<>();
    private static final t0.f<Integer> w;
    private d1 r;
    private t0 s;
    private Charset t;
    private boolean u;

    class a implements j0.a<Integer> {
        a() {
            super();
        }

        public Integer c(byte[] bArr) throws java.io.UnsupportedEncodingException {
            if (bArr.length < 3) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Malformed status code ";
                String string = new String(bArr, j0.a);
                bArr = str + string;
                throw new NumberFormatException(bArr);
            } else {
                return Integer.valueOf((bArr[0] - 48) * 100 + (bArr[1] - 48) * 10 + (bArr[2] - 48));
            }
        }

        public byte[] d(Integer integer) {
            throw new UnsupportedOperationException();
        }
    }
    static {
        u0.w = j0.b(":status", aVar);
    }

    protected u0(int i, i2 i2Var, o2 o2Var) {
        super(i, i2Var, o2Var);
        this.t = d.c;
    }

    private static Charset O(t0 t0Var) {
        Object obj = t0Var.f(r0.g);
        if (obj != null) {
            String[] parts = obj.split("charset=", 2);
            try {
            } catch (Exception unused) {
                return d.c;
            }
            return Charset.forName(parts[parts.length - 1].trim());
        }
    }

    private d1 Q(t0 t0Var) {
        d1 d1Var;
        Object obj = t0Var.f(l0.b);
        if (obj != null) {
            return obj.r((String)t0Var.f(l0.a));
        }
        if (this.u) {
            return d1.h.r("missing GRPC status in response");
        }
        Object obj2 = t0Var.f(u0.w);
        if (obj2 != null) {
            d1Var = r0.l(obj2.intValue());
        } else {
            str = "missing HTTP status code";
            d1Var = d1.m.r(str);
        }
        return d1Var.f("missing GRPC status, inferred error from HTTP status code");
    }

    private static void R(t0 t0Var) {
        t0Var.d(u0.w);
        t0Var.d(l0.b);
        t0Var.d(l0.a);
    }

    private d1 V(t0 t0Var) {
        Object obj = t0Var.f(u0.w);
        if (obj == null) {
            return d1.m.r("Missing HTTP status code");
        }
        Object obj2 = t0Var.f(r0.g);
        if (!r0.m(obj2)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "invalid content-type: ";
            str3 = str2 + obj2;
            return r0.l(obj.intValue()).f(str3);
        }
        return null;
    }

    @Override // io.grpc.j1.a$c
    protected void S(v1 v1Var, boolean z) {
        final boolean z3 = false;
        if (this.r == null) {
            if (!this.u) {
                P(d1.m.r("headers not received before payload"), z3, new t0());
                return;
            }
            D(v1Var);
            if (z && v1Var.g() > 0) {
                str3 = "Received unexpected EOS on non-empty DATA frame from server";
                this.r = d1.m.r(str3);
                t0 t0Var2 = new t0();
                this.s = t0Var2;
                N(this.r, z3, t0Var2);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "DATA-----------------------------\n";
            String str2 = w1.e(v1Var, this.t);
            str = str4 + str2;
            this.r = this.r.f(str);
            v1Var.close();
            int i = 1000;
            if (this.r.o().length() > 1000 || this.r) {
                P(this.r, z3, this.s);
            }
        }
    }

    @Override // io.grpc.j1.a$c
    protected void T(t0 t0Var) {
        String str4;
        d1 d1Var7;
        int value = 200;
        StringBuilder stringBuilder6;
        n.p(t0Var, "headers");
        str = "headers: ";
        if (this.r != null) {
            StringBuilder stringBuilder = new StringBuilder();
            str5 = str + t0Var;
            this.r = this.r.f(str5);
            return;
        }
        try {
            str2 = "Received headers twice";
            d1 d1Var = d1.m.r(str2);
            this.r = d1Var;
        } catch (Throwable th) {
        }
        try {
            Object obj = t0Var.f(u0.w);
            int i = 100;
        } catch (Throwable th) {
        }
        try {
            this.u = true;
            d1 d1Var2 = V(t0Var);
            this.r = d1Var2;
        } catch (Throwable th) {
        }
        if (d1.m != null && d1.m != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            str = str + t0Var;
            this.r = d1Var2.f(str);
            this.s = t0Var;
            this.t = u0.O(t0Var);
            return;
        }
        try {
            u0.R(t0Var);
            E(t0Var);
        } catch (Throwable th) {
        }
        if (this.r != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            str = str + t0Var;
            this.r = this.r.f(str);
            this.s = t0Var;
            this.t = u0.O(t0Var);
        }
    }

    @Override // io.grpc.j1.a$c
    protected void U(t0 t0Var) {
        n.p(t0Var, "trailers");
        if (this.r == null && !this.u && d1Var != null) {
            this.s = t0Var;
        }
        if (this.r != null) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "trailers: ";
            str3 = str + t0Var;
            d1 d1Var3 = this.r.f(str3);
            this.r = d1Var3;
            P(d1Var3, false, this.s);
        } else {
            u0.R(t0Var);
            F(t0Var, Q(t0Var));
        }
    }

    @Override // io.grpc.j1.a$c
    protected abstract void P(d1 d1Var, boolean z, t0 t0Var);
}
