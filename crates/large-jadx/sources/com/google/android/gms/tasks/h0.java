package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
final class h0<TResult>  {

    private final Object a;
    private Queue<com.google.android.gms.tasks.g0<TResult>> b;
    private boolean c;
    h0() {
        super();
        Object object = new Object();
        this.a = object;
    }

    public final void a(com.google.android.gms.tasks.g0<TResult> g0) {
        Object arrayDeque;
        final Object obj = this.a;
        synchronized (obj) {
            arrayDeque = new ArrayDeque();
            this.b = arrayDeque;
            this.b.add(g0);
        }
    }

    public final void b(com.google.android.gms.tasks.j<TResult> j) {
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
                    while ((g0)poll == null) {
                        (g0)poll.a(j);
                        i = this.a;
                        poll = this.b.poll();
                    }
                    this.c = false;
                    (g0)poll.a(j);
                    throw j;
                    throw j;
                } catch (Throwable th) {
                }
            }
        }
    }
}
