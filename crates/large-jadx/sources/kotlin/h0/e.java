package kotlin.h0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.y.h0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class e extends h0 {

    private final int a;
    private boolean b = false;
    private int c;
    private final int v;
    public e(int i, int i2, int i3) {
        int obj3;
        super();
        this.v = i3;
        this.a = i2;
        int i4 = 1;
        if (i3 > 0) {
            if (i <= i2) {
            }
        } else {
            if (i >= i2) {
            }
        }
        if (0 != 0) {
        } else {
            obj3 = i2;
        }
        this.c = obj3;
    }

    @Override // kotlin.y.h0
    public int d() {
        int i;
        int i2 = this.c;
        if (i2 == this.a) {
            if (!this.b) {
            } else {
                this.b = false;
                return i2;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        this.c = i4 += i2;
    }

    @Override // kotlin.y.h0
    public boolean hasNext() {
        return this.b;
    }
}
