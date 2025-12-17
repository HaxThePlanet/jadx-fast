package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public class l {

    private final com.google.android.exoplayer2.util.i a;
    private boolean b;
    public l() {
        super(i.a);
    }

    public l(com.google.android.exoplayer2.util.i i) {
        super();
        this.a = i;
    }

    public void a() {
        Throwable th;
        synchronized (this) {
            try {
                while (!this.b) {
                    wait();
                }
                wait();
                throw th;
            }
        }
    }

    public void b() {
        int currentThread;
        boolean z;
        currentThread = 0;
        synchronized (this) {
            while (!this.b) {
                wait();
            }
            if (currentThread != 0) {
                Thread.currentThread().interrupt();
            }
            try {
                throw i;
            }
        }
    }

    public boolean c() {
        this.b = false;
        return this.b;
        synchronized (this) {
            this.b = false;
            return this.b;
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                return 0;
                int i2 = 1;
                this.b = i2;
                notifyAll();
                return i2;
            }
        }
    }
}
