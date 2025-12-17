package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.internal.u;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00052\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\u001a\u001a\u0006\u0012\u0002\u0008\u00030\u001bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u0008\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\nR\u0014\u0010\u000c\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u0014\u0010\r\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\n\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class n<E>  extends kotlinx.coroutines.channels.a<E> {
    public n(l<? super E, w> l) {
        super(l);
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean A() {
        return 1;
    }

    protected void D(Object object, kotlinx.coroutines.channels.l<?> l2) {
        int i;
        boolean z;
        int i3;
        int i2;
        l lVar;
        Object obj6;
        Object obj7;
        i = 0;
        if (object == null) {
        } else {
            if (object instanceof ArrayList == null) {
                if (object instanceof c.a) {
                    obj7 = this.a;
                    if (obj7 == null) {
                    } else {
                        i = obj6;
                    }
                } else {
                    (c.a)(v)object.A(l2);
                }
            } else {
                Objects.requireNonNull(object, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                if (size-- >= 0) {
                    i3 = i;
                    i2 = z + -1;
                    z = object.get(z);
                    while (z instanceof c.a) {
                        lVar = this.a;
                        if (lVar == null) {
                        } else {
                        }
                        i3 = z;
                        if (i2 >= 0) {
                        }
                        z = i2;
                        i2 = z + -1;
                        z = object.get(z);
                        (v)(c.a)(v)z.A(l2);
                        i3 = i;
                    }
                    i = i3;
                }
            }
        }
        if (i != 0) {
        } else {
        }
        throw i;
    }

    protected Object m(E e) {
        Object obj = super.m(e);
        kotlinx.coroutines.internal.z zVar = b.b;
        while (obj == zVar) {
            kotlinx.coroutines.channels.t tVar = o(e);
            obj = super.m(e);
            zVar = b.b;
        }
        return zVar;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean z() {
        return 1;
    }
}
