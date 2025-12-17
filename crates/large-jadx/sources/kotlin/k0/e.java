package kotlin.k0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.h0.g;
import kotlin.j0.h;
import kotlin.o;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\u0008\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\u0008\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\u0008\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class e implements h<f> {

    private final java.lang.CharSequence a;
    private final int b;
    private final int c;
    private final p<java.lang.CharSequence, Integer, o<Integer, Integer>> d;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0008\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0006\"\u0004\u0008\u000b\u0010\u0008R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0006\"\u0004\u0008\u0013\u0010\u0008R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0006\"\u0004\u0008\u0016\u0010\u0008¨\u0006\u001c", d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Iterator<f>, a {

        private int a = -1;
        private int b;
        private int c;
        private f v;
        private int w;
        final kotlin.k0.e x;
        a(kotlin.k0.e e) {
            this.x = e;
            super();
            int i = -1;
            int obj3 = g.g(e.e(e), 0, e.c(e).length());
            this.b = obj3;
            this.c = obj3;
        }

        private final void c() {
            int intValue;
            int i3;
            f fVar;
            int i;
            int i2;
            int length;
            Integer valueOf;
            if (this.c < 0) {
                this.a = 0;
                this.v = 0;
            } else {
                i = -1;
                i2 = 1;
                if (e.d(this.x) > 0) {
                    i5 += i2;
                    this.w = i3;
                    if (i3 < e.d(this.x)) {
                        if (this.c > e.c(this.x).length()) {
                            fVar = new f(this.b, l.Y(e.c(this.x)));
                            this.v = fVar;
                            this.c = i;
                        } else {
                            Object invoke = e.b(this.x).invoke(e.c(this.x), Integer.valueOf(this.c));
                            if ((o)invoke == null) {
                                fVar = new f(this.b, l.Y(e.c(this.x)));
                                this.v = fVar;
                                this.c = i;
                            } else {
                                int intValue2 = (Number)(o)invoke.a().intValue();
                                intValue = (Number)invoke.b().intValue();
                                this.v = g.l(this.b, intValue2);
                                intValue2 += intValue;
                                this.b = i6;
                                if (intValue == 0) {
                                    fVar = i2;
                                }
                                this.c = i6 += fVar;
                            }
                        }
                    } else {
                    }
                } else {
                }
                this.a = i2;
            }
        }

        @Override // java.util.Iterator
        public f d() {
            final int i3 = -1;
            if (this.a == i3) {
                c();
            }
            if (this.a == 0) {
            } else {
                f fVar = this.v;
                Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.v = 0;
                this.a = i3;
                return fVar;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            if (this.a == -1) {
                c();
            }
            if (this.a == 1) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return d();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }
    public e(java.lang.CharSequence charSequence, int i2, int i3, p<? super java.lang.CharSequence, ? super Integer, o<Integer, Integer>> p4) {
        n.f(charSequence, "input");
        n.f(p4, "getNextMatch");
        super();
        this.a = charSequence;
        this.b = i2;
        this.c = i3;
        this.d = p4;
    }

    public static final p b(kotlin.k0.e e) {
        return e.d;
    }

    public static final java.lang.CharSequence c(kotlin.k0.e e) {
        return e.a;
    }

    public static final int d(kotlin.k0.e e) {
        return e.c;
    }

    public static final int e(kotlin.k0.e e) {
        return e.b;
    }

    public Iterator<f> iterator() {
        e.a aVar = new e.a(this);
        return aVar;
    }
}
