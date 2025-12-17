package kotlin.h0;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.c0.c;
import kotlin.d0.d.j0.a;
import kotlin.y.o;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000c\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 \u00192\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0006H\u0016J\u0008\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0008\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public class a implements Iterable<Character>, a {

    private final char a;
    private final char b;
    private final int c;
    static {
    }

    public a(char c, char c2, int i3) {
        super();
        if (i3 == 0) {
        } else {
            if (i3 == Integer.MIN_VALUE) {
            } else {
                this.a = c;
                this.b = (char)obj2;
                this.c = i3;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw obj2;
        }
        obj2 = new IllegalArgumentException("Step must be non-zero.");
        throw obj2;
    }

    @Override // java.lang.Iterable
    public final char d() {
        return this.a;
    }

    @Override // java.lang.Iterable
    public final char g() {
        return this.b;
    }

    @Override // java.lang.Iterable
    public o h() {
        b bVar = new b(this.a, this.b, this.c);
        return bVar;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return h();
    }
}
