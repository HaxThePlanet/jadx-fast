package com.google.common.collect;

/* loaded from: classes2.dex */
class o extends com.google.common.collect.w<Object, Object> {

    private static final long serialVersionUID;
    static final com.google.common.collect.o x;
    static {
        o oVar = new o();
        o.x = oVar;
    }

    private o() {
        super(x.k(), 0);
    }

    private Object readResolve() {
        return o.x;
    }
}
