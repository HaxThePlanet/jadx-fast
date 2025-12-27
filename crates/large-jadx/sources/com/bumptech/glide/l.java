package com.bumptech.glide;

import com.bumptech.glide.r.l.c;
import com.bumptech.glide.r.l.e;
import com.bumptech.glide.t.k;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class l<CHILD extends l<CHILD, TranscodeType>, TranscodeType> implements java.lang.Cloneable {

    private e<? super TranscodeType> a;
    public l() {
        super();
        this.a = c.c();
    }

    public final CHILD a() {
        try {
        } catch (java.lang.CloneNotSupportedException cloneNotSupported) {
            throw new RuntimeException(cloneNotSupported);
        }
        return (l)super.clone();
    }

    final e<? super TranscodeType> b() {
        return this.a;
    }

    public final CHILD d(e<? super TranscodeType> eVar) {
        k.d(eVar);
        this.a = eVar;
        c();
        return this;
    }

    private CHILD c() {
        return this;
    }
}
