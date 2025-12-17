package com.bumptech.glide;

import com.bumptech.glide.r.l.c;
import com.bumptech.glide.r.l.e;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public abstract class l<CHILD extends com.bumptech.glide.l<CHILD, TranscodeType>, TranscodeType>  implements java.lang.Cloneable {

    private e<? super TranscodeType> a;
    public l() {
        super();
        this.a = c.c();
    }

    private CHILD c() {
        return this;
    }

    public final CHILD a() {
        try {
            return (l)super.clone();
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    final e<? super TranscodeType> b() {
        return this.a;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return a();
    }

    public final CHILD d(e<? super TranscodeType> e) {
        k.d(e);
        this.a = (e)e;
        c();
        return this;
    }
}
