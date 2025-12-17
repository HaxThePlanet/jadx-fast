package com.google.android.exoplayer2.source.m0;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public interface e {

    public static final com.google.android.exoplayer2.source.m0.e a;

    class a implements com.google.android.exoplayer2.source.m0.e {
        @Override // com.google.android.exoplayer2.source.m0.e
        public long a() {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // com.google.android.exoplayer2.source.m0.e
        public long b() {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // com.google.android.exoplayer2.source.m0.e
        public boolean next() {
            return 0;
        }
    }
    static {
        e.a aVar = new e.a();
        e.a = aVar;
    }

    public abstract long a();

    public abstract long b();

    public abstract boolean next();
}
