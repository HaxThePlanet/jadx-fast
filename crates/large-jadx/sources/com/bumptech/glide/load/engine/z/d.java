package com.bumptech.glide.load.engine.z;

import com.bumptech.glide.t.l;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes.dex */
abstract class d<T extends m> {

    private final Queue<T> a;
    d() {
        super();
        this.a = l.e(20);
    }

    T b() {
        Object poll;
        if ((m)this.a.poll() == null) {
            com.bumptech.glide.load.engine.z.m mVar = a();
        }
        return poll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }

    abstract T a();
}
