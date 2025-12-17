package com.bumptech.glide.load.engine.z;

import com.bumptech.glide.t.l;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class d<T extends com.bumptech.glide.load.engine.z.m>  {

    private final Queue<T> a;
    d() {
        super();
        this.a = l.e(20);
    }

    abstract T a();

    T b() {
        Object poll;
        if ((m)this.a.poll() == null) {
            poll = a();
        }
        return poll;
    }

    public void c(T t) {
        int size;
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
