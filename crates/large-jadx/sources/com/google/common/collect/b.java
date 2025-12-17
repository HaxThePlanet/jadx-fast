package com.google.common.collect;

import com.google.common.base.n;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class b<T>  extends com.google.common.collect.b1<T> {

    private com.google.common.collect.b.b a;
    private T b;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[b.b.DONE.ordinal()] = 1;
            b.a.a[b.b.READY.ordinal()] = 2;
        }
    }

    private static enum b {

        READY,
        NOT_READY,
        DONE,
        FAILED;
        private static com.google.common.collect.b.b[] $values() {
            com.google.common.collect.b.b[] arr = new b.b[4];
            return arr;
        }
    }
    protected b() {
        super();
        this.a = b.b.NOT_READY;
    }

    private boolean d() {
        this.a = b.b.FAILED;
        this.b = b();
        if (this.a != b.b.DONE) {
            this.a = b.b.READY;
            return 1;
        }
        return 0;
    }

    protected abstract T b();

    protected final T c() {
        this.a = b.b.DONE;
        return 0;
    }

    @Override // com.google.common.collect.b1
    public final boolean hasNext() {
        int i;
        final int i4 = 0;
        final int i5 = 1;
        i = this.a != b.b.FAILED ? i5 : i4;
        n.u(i);
        int i2 = b.a.a[this.a.ordinal()];
        if (i2 != i5 && i2 != 2) {
            if (i2 != 2) {
                return d();
            }
            return i5;
        }
        return i4;
    }

    public final T next() {
        if (!hasNext()) {
        } else {
            this.a = b.b.NOT_READY;
            this.b = 0;
            return this.b;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
