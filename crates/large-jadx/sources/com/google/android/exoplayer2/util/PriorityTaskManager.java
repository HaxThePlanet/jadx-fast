package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public final class PriorityTaskManager {

    private final Object a;
    private final PriorityQueue<Integer> b;
    private int c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder(60);
            stringBuilder.append("Priority too low [priority=");
            stringBuilder.append(i);
            stringBuilder.append(", highest=");
            stringBuilder.append(i2);
            stringBuilder.append("]");
            super(stringBuilder.toString());
        }
    }
    public PriorityTaskManager() {
        super();
        Object object = new Object();
        this.a = object;
        PriorityQueue priorityQueue = new PriorityQueue(10, Collections.reverseOrder());
        this.b = priorityQueue;
        int i = Integer.MIN_VALUE;
    }

    public void a(int i) {
        final Object obj = this.a;
        this.b.add(Integer.valueOf(i));
        this.c = Math.max(this.c, i);
        return;
        synchronized (obj) {
            obj = this.a;
            this.b.add(Integer.valueOf(i));
            this.c = Math.max(this.c, i);
        }
    }

    public void b(int i) {
        final Object obj = this.a;
        synchronized (obj) {
        }
    }

    public void c(int i) {
        int obj3;
        final Object obj = this.a;
        this.b.remove(Integer.valueOf(i));
        synchronized (obj) {
            obj3 = Integer.MIN_VALUE;
            try {
                this.c = obj3;
                this.a.notifyAll();
                throw i;
            }
        }
    }
}
