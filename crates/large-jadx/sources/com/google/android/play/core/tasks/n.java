package com.google.android.play.core.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
final class n<ResultT>  {

    private final Object a;
    private Queue<com.google.android.play.core.tasks.m<ResultT>> b;
    private boolean c;
    n() {
        super();
        Object object = new Object();
        this.a = object;
    }

    public final void a(com.google.android.play.core.tasks.m<ResultT> m) {
        Object arrayDeque;
        final Object obj = this.a;
        synchronized (obj) {
            arrayDeque = new ArrayDeque();
            this.b = arrayDeque;
            this.b.add(m);
        }
    }

    public final void b(com.google.android.play.core.tasks.d<ResultT> d) {
        Object poll;
        int i;
        Queue queue;
        poll = this.a;
        synchronized (poll) {
            if (this.c) {
            } else {
                try {
                    this.c = true;
                    i = this.a;
                    poll = this.b.poll();
                    while ((m)poll == null) {
                        (m)poll.a(d);
                        i = this.a;
                        poll = this.b.poll();
                    }
                    this.c = false;
                    (m)poll.a(d);
                    throw d;
                    throw d;
                } catch (Throwable th) {
                }
            }
        }
    }
}
