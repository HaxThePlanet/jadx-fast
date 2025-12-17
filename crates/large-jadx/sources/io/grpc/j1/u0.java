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

/* loaded from: classes3.dex */
public abstract class u0 extends io.grpc.j1.a.c {

    private static final j0.a<Integer> v;
    private static final t0.f<Integer> w;
    private d1 r;
    private t0 s;
    private Charset t;
    private boolean u;

    class a implements j0.a<Integer> {
        @Override // io.grpc.j0$a
        public byte[] a(Object object) {
            d((Integer)object);
            throw 0;
        }

        @Override // io.grpc.j0$a
        public Object b(byte[] bArr) {
            return c(bArr);
        }

        @Override // io.grpc.j0$a
        public Integer c(byte[] bArr) {
            if (bArr.length < 3) {
            } else {
                return Integer.valueOf(i4 += obj5);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Malformed status code ");
            String string = new String(bArr, j0.a);
            stringBuilder.append(string);
            NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.toString());
            throw numberFormatException;
        }

        @Override // io.grpc.j0$a
        public byte[] d(Integer integer) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }
    }
    static {
        u0.a aVar = new u0.a();
        u0.v = aVar;
        u0.w = j0.b(":status", aVar);
    }

    protected u0(int i, io.grpc.j1.i2 i22, io.grpc.j1.o2 o23) {
        super(i, i22, o23);
        this.t = d.c;
    }

    private static Charset O(t0 t0) {
        Object obj2 = t0.f(r0.g);
        if ((String)obj2 != null) {
            obj2 = (String)obj2.split("charset=", 2);
            return Charset.forName(obj2[length--].trim());
        }
        return d.c;
    }

    private d1 Q(t0 t0) {
        Object str;
        d1 obj3;
        Object obj = t0.f(l0.b);
        if ((d1)obj != null) {
            return (d1)obj.r((String)t0.f(l0.a));
        }
        if (this.u) {
            return d1.h.r("missing GRPC status in response");
        }
        obj3 = t0.f(u0.w);
        if ((Integer)obj3 != null) {
            obj3 = r0.l((Integer)obj3.intValue());
        } else {
            obj3 = d1.m.r("missing HTTP status code");
        }
        return obj3.f("missing GRPC status, inferred error from HTTP status code");
    }

    private static void R(t0 t0) {
        t0.d(u0.w);
        t0.d(l0.b);
        t0.d(l0.a);
    }

    private d1 V(t0 t0) {
        Object obj = t0.f(u0.w);
        if ((Integer)obj == null) {
            return d1.m.r("Missing HTTP status code");
        }
        Object obj4 = t0.f(r0.g);
        if (!r0.m((String)obj4)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid content-type: ");
            stringBuilder.append(obj4);
            return r0.l((Integer)obj.intValue()).f(stringBuilder.toString());
        }
        return null;
    }

    @Override // io.grpc.j1.a$c
    protected abstract void P(d1 d1, boolean z2, t0 t03);

    @Override // io.grpc.j1.a$c
    protected void S(io.grpc.j1.v1 v1, boolean z2) {
        int i;
        String string;
        String str;
        d1 obj5;
        Object obj6;
        d1 d1Var = this.r;
        final int i2 = 0;
        if (d1Var != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DATA-----------------------------\n");
            stringBuilder.append(w1.e(v1, this.t));
            this.r = d1Var.f(stringBuilder.toString());
            v1.close();
            if (this.r.o().length() <= 1000) {
                if (z2 != null) {
                    P(this.r, i2, this.s);
                }
            } else {
            }
        } else {
            if (!this.u) {
                obj6 = new t0();
                P(d1.m.r("headers not received before payload"), i2, obj6);
            }
            D(v1);
            if (z2 != null) {
                if (v1.g() > 0) {
                    this.r = d1.m.r("Received unexpected EOS on non-empty DATA frame from server");
                } else {
                    this.r = d1.m.r("Received unexpected EOS on empty DATA frame from server");
                }
                obj5 = new t0();
                this.s = obj5;
                N(this.r, i2, obj5);
            }
        }
    }

    @Override // io.grpc.j1.a$c
    protected void T(t0 t0) {
        d1 d1Var4;
        Object intValue;
        d1 d1Var;
        d1 d1Var2;
        d1 d1Var3;
        String str;
        String string;
        d1 stringBuilder;
        Object stringBuilder2;
        StringBuilder stringBuilder3;
        Object obj5;
        n.p(t0, "headers");
        d1 d1Var5 = this.r;
        string = "headers: ";
        if (d1Var5 != null) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string);
            stringBuilder4.append(t0);
            this.r = d1Var5.f(stringBuilder4.toString());
        }
        d1Var4 = d1.m.r("Received headers twice");
        this.r = d1Var4;
        if (this.u && d1Var4 != null) {
            d1Var4 = d1.m.r("Received headers twice");
            this.r = d1Var4;
            if (d1Var4 != null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(t0);
                this.r = d1Var4.f(stringBuilder2.toString());
                this.s = t0;
                this.t = u0.O(t0);
            }
        }
        intValue = t0.f(u0.w);
        d1Var3 = this.r;
        if (intValue != null && (Integer)intValue.intValue() >= 100 && intValue.intValue() < 200 && d1Var3 != null) {
            if (intValue.intValue() >= 100) {
                if (intValue.intValue() < 200) {
                    d1Var3 = this.r;
                    if (d1Var3 != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        stringBuilder.append(t0);
                        this.r = d1Var3.f(stringBuilder.toString());
                        this.s = t0;
                        this.t = u0.O(t0);
                    }
                }
            }
        }
        this.u = true;
        d1Var = V(t0);
        this.r = d1Var;
        if (d1Var != null && d1Var != null) {
            if (d1Var != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(t0);
                this.r = d1Var.f(stringBuilder.toString());
                this.s = t0;
                this.t = u0.O(t0);
            }
        }
        u0.R(t0);
        E(t0);
        d1Var2 = this.r;
        if (d1Var2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(t0);
            this.r = d1Var2.f(stringBuilder.toString());
            this.s = t0;
            this.t = u0.O(t0);
        }
    }

    @Override // io.grpc.j1.a$c
    protected void U(t0 t0) {
        d1 d1Var;
        d1 d1Var2;
        t0 t0Var;
        String str;
        Object obj4;
        n.p(t0, "trailers");
        d1Var = V(t0);
        this.r = d1Var;
        if (this.r == null && !this.u && d1Var != null) {
            if (!this.u) {
                d1Var = V(t0);
                this.r = d1Var;
                if (d1Var != null) {
                    this.s = t0;
                }
            }
        }
        d1 d1Var3 = this.r;
        if (d1Var3 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trailers: ");
            stringBuilder.append(t0);
            obj4 = d1Var3.f(stringBuilder.toString());
            this.r = obj4;
            P(obj4, false, this.s);
        } else {
            u0.R(t0);
            F(t0, Q(t0));
        }
    }
}
