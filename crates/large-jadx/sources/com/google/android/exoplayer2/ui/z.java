package com.google.android.exoplayer2.ui;

/* loaded from: classes2.dex */
public interface z {

    public interface a {
        public abstract void D(com.google.android.exoplayer2.ui.z z, long l2, boolean z3);

        public abstract void E(com.google.android.exoplayer2.ui.z z, long l2);

        public abstract void t(com.google.android.exoplayer2.ui.z z, long l2);
    }
    public abstract void a(long[] lArr, boolean[] z2Arr2, int i3);

    public abstract void b(com.google.android.exoplayer2.ui.z.a z$a);

    public abstract long getPreferredUpdateDelay();

    public abstract void setBufferedPosition(long l);

    public abstract void setDuration(long l);

    public abstract void setEnabled(boolean z);

    public abstract void setPosition(long l);
}
