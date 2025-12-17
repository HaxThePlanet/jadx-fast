package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.d;
import kotlin.b0.f;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlinx.coroutines.c3.a;
import kotlinx.coroutines.c3.b;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0008\u001a\u00020\t\"\u0004\u0008\u0000\u0010\n2\u001c\u0010\u000b\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000c2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\\\u0010\u0008\u001a\u00020\t\"\u0004\u0008\u0000\u0010\u0011\"\u0004\u0008\u0001\u0010\n2'\u0010\u000b\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012¢\u0006\u0002\u0008\u00132\u0006\u0010\u0014\u001a\u0002H\u00112\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0003\u0010\u0007j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum o0 {

    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[o0.DEFAULT.ordinal()] = 1;
            iArr[o0.ATOMIC.ordinal()] = 2;
            iArr[o0.UNDISPATCHED.ordinal()] = 3;
            iArr[o0.LAZY.ordinal()] = 4;
            o0.a.a = iArr;
        }
    }
    private static final kotlinx.coroutines.o0[] $values() {
        kotlinx.coroutines.o0[] arr = new o0[4];
        return arr;
    }

    public static void isLazy$annotations() {
    }

    public final <T> void invoke(l<? super d<? super T>, ? extends Object> l, d<? super T> d2) {
        int i;
        l obj3;
        int i2 = o0.a.a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                    }
                    obj3 = new NoWhenBranchMatchedException();
                    throw obj3;
                }
                b.a(l, d2);
            } else {
                f.a(l, d2);
            }
        } else {
            a.d(l, d2);
        }
    }

    public final <R, T> void invoke(p<? super R, ? super d<? super T>, ? extends Object> p, R r2, d<? super T> d3) {
        int i5;
        int i2;
        d dVar;
        int i3;
        int i4;
        int i;
        p obj7;
        i5 = o0.a.a[ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                    } else {
                    }
                    obj7 = new NoWhenBranchMatchedException();
                    throw obj7;
                }
                b.b(p, r2, d3);
            } else {
                f.b(p, r2, d3);
            }
        } else {
            a.f(p, r2, d3, 0, 4, 0);
        }
    }

    @Override // java.lang.Enum
    public final boolean isLazy() {
        int i;
        i = this == o0.LAZY ? 1 : 0;
        return i;
    }
}
