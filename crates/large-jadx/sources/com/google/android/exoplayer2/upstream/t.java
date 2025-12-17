package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public class t implements com.google.android.exoplayer2.upstream.w {

    private final int a;
    public t() {
        super(-1);
    }

    public t(int i) {
        super();
        this.a = i;
    }

    @Override // com.google.android.exoplayer2.upstream.w
    public long a(com.google.android.exoplayer2.upstream.w.c w$c) {
        long l;
        IOException exc;
        boolean z;
        Object obj3;
        exc = c.a;
        if (exc instanceof ParserException == null && exc instanceof FileNotFoundException == null && exc instanceof HttpDataSource.CleartextNotPermittedException == null) {
            if (exc instanceof FileNotFoundException == null) {
                if (exc instanceof HttpDataSource.CleartextNotPermittedException == null) {
                    if (exc instanceof Loader.UnexpectedLoaderException != null) {
                        l = -9223372036854775807L;
                    } else {
                        l = (long)obj3;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return l;
    }

    @Override // com.google.android.exoplayer2.upstream.w
    public com.google.android.exoplayer2.upstream.w.b b(com.google.android.exoplayer2.upstream.w.a w$a, com.google.android.exoplayer2.upstream.w.c w$c2) {
        int i = 0;
        if (!e(c2.a)) {
            return i;
        }
        int obj4 = 1;
        final boolean z = a.a(obj4);
        if (z) {
            w.b obj3 = new w.b(obj4, 300000, z);
            return obj3;
        }
        obj4 = 2;
        if (a.a(obj4)) {
            obj3 = new w.b(obj4, 60000, z);
            return obj3;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.w
    public int d(int i) {
        int obj3;
        int i2 = this.a;
        if (i2 == -1) {
            obj3 = i == 7 ? 6 : 3;
            return obj3;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.upstream.w
    protected boolean e(IOException iOException) {
        int i2;
        int i;
        if (iOException instanceof HttpDataSource.InvalidResponseCodeException == null) {
            return 0;
        }
        final int obj3 = iOException.responseCode;
        if (obj3 != 403 && obj3 != 404 && obj3 != 410 && obj3 != 416 && obj3 != 500) {
            if (obj3 != 404) {
                if (obj3 != 410) {
                    if (obj3 != 416) {
                        if (obj3 != 500) {
                            if (obj3 == 503) {
                                i = 1;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
