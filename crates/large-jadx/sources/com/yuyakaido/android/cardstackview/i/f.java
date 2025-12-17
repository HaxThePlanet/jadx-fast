package com.yuyakaido.android.cardstackview.i;

import com.yuyakaido.android.cardstackview.b;

/* loaded from: classes2.dex */
public class f {

    public com.yuyakaido.android.cardstackview.i.f.b a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = -1;
    public float h = 0f;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            f.a.a = iArr;
            iArr[f.b.ManualSwipeAnimating.ordinal()] = 1;
            f.a.a[f.b.AutomaticSwipeAnimating.ordinal()] = 2;
        }
    }

    public static enum b {

        Idle,
        Dragging,
        RewindAnimating,
        AutomaticSwipeAnimating,
        AutomaticSwipeAnimated,
        ManualSwipeAnimating,
        ManualSwipeAnimated;
        @Override // java.lang.Enum
        public boolean isBusy() {
            int i;
            i = this != f.b.Idle ? 1 : 0;
            return i;
        }

        @Override // java.lang.Enum
        public boolean isDragging() {
            int i;
            i = this == f.b.Dragging ? 1 : 0;
            return i;
        }

        @Override // java.lang.Enum
        public boolean isSwipeAnimating() {
            int i;
            com.yuyakaido.android.cardstackview.i.f.b manualSwipeAnimating;
            if (this != f.b.ManualSwipeAnimating) {
                if (this == f.b.AutomaticSwipeAnimating) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // java.lang.Enum
        public com.yuyakaido.android.cardstackview.i.f.b toAnimatedStatus() {
            int i = f.a.a[ordinal()];
            if (i != 1 && i != 2) {
                if (i != 2) {
                    return f.b.Idle;
                }
                return f.b.AutomaticSwipeAnimated;
            }
            return f.b.ManualSwipeAnimated;
        }
    }
    public f() {
        super();
        this.a = f.b.Idle;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
    }

    public boolean a(int i, int i2) {
        final int i4 = 0;
        if (i == this.f) {
            return i4;
        }
        if (i < 0) {
            return i4;
        }
        if (i2 < i) {
            return i4;
        }
        if (this.a.isBusy()) {
            return i4;
        }
        return 1;
    }

    public b b() {
        final int i7 = 0;
        if (Math.abs(this.e) < Math.abs(this.d) && Float.compare(f, i7) < 0) {
            if (Float.compare(f, i7) < 0) {
                return b.Left;
            }
            return b.Right;
        }
        if (Float.compare(f2, i7) < 0) {
            return b.Top;
        }
        return b.Bottom;
    }

    public float c() {
        float f;
        int i;
        int i3 = Math.abs(this.d);
        int i6 = Math.abs(this.e);
        i = i3 < i6 ? this.c : this.b;
        return Math.min(f /= i7, 1065353216);
    }

    public boolean d() {
        int swipeAnimating;
        int i;
        if (this.a.isSwipeAnimating() && this.f < this.g && this.b >= Math.abs(this.d) && this.c < Math.abs(this.e)) {
            if (this.f < this.g) {
                if (this.b >= Math.abs(this.d)) {
                    if (this.c < Math.abs(this.e)) {
                    }
                }
                return 1;
            }
        }
        return 0;
    }

    public void e(com.yuyakaido.android.cardstackview.i.f.b f$b) {
        this.a = b;
    }
}
