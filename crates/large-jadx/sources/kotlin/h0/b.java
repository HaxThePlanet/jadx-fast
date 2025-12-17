package kotlin.h0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.o;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u000f", d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextChar", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class b extends o {

    private final int a;
    private boolean b = false;
    private int c;
    private final int v;
    public b(char c, char c2, int i3) {
        int obj3;
        int obj5;
        super();
        this.v = i3;
        this.a = c2;
        int i = 1;
        if (i3 > 0) {
            if (n.h(c, c2) <= 0) {
            }
        } else {
            if (n.h(c, c2) >= 0) {
            }
        }
        if (0 != 0) {
        } else {
            obj3 = c2;
        }
        this.c = obj3;
    }

    @Override // kotlin.y.o
    public char d() {
        int i;
        int i2 = this.c;
        if (i2 == this.a) {
            if (!this.b) {
            } else {
                this.b = false;
                return (char)i2;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        this.c = i4 += i2;
    }

    @Override // kotlin.y.o
    public boolean hasNext() {
        return this.b;
    }
}
