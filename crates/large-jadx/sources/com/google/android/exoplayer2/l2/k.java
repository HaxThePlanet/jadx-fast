package com.google.android.exoplayer2.l2;

/* loaded from: classes2.dex */
public interface k {

    public static final com.google.android.exoplayer2.l2.k e;

    class a implements com.google.android.exoplayer2.l2.k {
        @Override // com.google.android.exoplayer2.l2.k
        public void d(com.google.android.exoplayer2.l2.q q) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // com.google.android.exoplayer2.l2.k
        public void n() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        @Override // com.google.android.exoplayer2.l2.k
        public com.google.android.exoplayer2.l2.s t(int i, int i2) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }
    }
    static {
        k.a aVar = new k.a();
        k.e = aVar;
    }

    public abstract void d(com.google.android.exoplayer2.l2.q q);

    public abstract void n();

    public abstract com.google.android.exoplayer2.l2.s t(int i, int i2);
}
