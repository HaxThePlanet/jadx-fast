package com.google.common.base;

/* loaded from: classes2.dex */
public abstract class u {

    private static final com.google.common.base.u a;

    class a extends com.google.common.base.u {
        @Override // com.google.common.base.u
        public long a() {
            return m.e();
        }
    }
    static {
        u.a aVar = new u.a();
        u.a = aVar;
    }

    public static com.google.common.base.u b() {
        return u.a;
    }

    public abstract long a();
}
