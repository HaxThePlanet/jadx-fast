package com.yuyakaido.android.cardstackview.i;

import com.yuyakaido.android.cardstackview.b;

/* compiled from: CardStackState.java */
/* loaded from: classes2.dex */
public class f {

    public f.b a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = -1;
    public float h = 0f;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[f.b.values().length];
            f.a.a = iArr;
            try {
                iArr[f.b.ManualSwipeAnimating.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                f.a.a[f.b.AutomaticSwipeAnimating.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        AutomaticSwipeAnimated,
        AutomaticSwipeAnimating,
        Dragging,
        Idle,
        ManualSwipeAnimated,
        ManualSwipeAnimating,
        RewindAnimating;
        @Override // java.lang.Enum
        public boolean isBusy() {
            boolean z = true;
            int r0 = this != f.b.Idle ? 1 : 0;
            return (this != f.b.Idle ? 1 : 0);
        }

        @Override // java.lang.Enum
        public boolean isDragging() {
            boolean z = true;
            int r0 = this == f.b.Dragging ? 1 : 0;
            return (this == f.b.Dragging ? 1 : 0);
        }

        @Override // java.lang.Enum
        public boolean isSwipeAnimating() {
            boolean z = false;
            if (this == f.b.ManualSwipeAnimating || this == f.b.AutomaticSwipeAnimating) {
                int i2 = 1;
            }
            return z;
        }

        @Override // java.lang.Enum
        public f.b toAnimatedStatus() {
            int i = f.a.a[ordinal()];
            if (f.a.a != 1 && f.a.a != 2) {
                return f.b.Idle;
            }
            return f.b.ManualSwipeAnimated;
        }
    }
    public f() {
        super();
        this.a = f.b.Idle;
    }

    public boolean a(int i, int i2) {
        final boolean z = false;
        if (i == this.f) {
            return false;
        }
        if (i < 0) {
            return false;
        }
        if (i2 < i) {
            return false;
        }
        if (this.a.isBusy()) {
            return false;
        }
        return true;
    }

    public b b() {
        final float f3 = 0.0f;
        if (Math.abs(this.e) < Math.abs(this.d)) {
            float f = (float)this.d;
            if (this.e < 0.0f) {
                return b.Left;
            }
            return b.Right;
        }
        float f2 = (float)this.e;
        if (this.e < 0.0f) {
            return b.Top;
        }
        return b.Bottom;
    }

    public float c() {
        float f;
        int i;
        int abs = Math.abs(this.d);
        int abs2 = Math.abs(this.e);
        i = abs < abs2 ? this.c : this.b;
        return Math.min(f / (float)i / 2f, 1f);
    }

    public boolean d() {
        if (this.a.isSwipeAnimating()) {
            if (this.f < this.g) {
                return true;
            }
        }
        return false;
    }

    public void e(f.b bVar) {
        this.a = bVar;
    }
}
