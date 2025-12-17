package androidx.room;

import android.os.CancellationSignal;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.d.g;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c0 {

    public static final androidx.room.c0.a a;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\u0008\u00060\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J5\u0010\u0011\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u000fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0016", d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "()V", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final <R> Object a(androidx.room.u0 u0, boolean z2, CancellationSignal cancellationSignal3, Callable<R> callable4, d<? super R> d5) {
            boolean z;
            kotlin.b0.e eVar;
            kotlinx.coroutines.h0 obj9;
            if (u0.v() && u0.p()) {
                if (u0.p()) {
                    return callable4.call();
                }
            }
            kotlin.b0.g.b bVar = d5.getContext().get(c1.b);
            int i2 = 0;
            if ((c1)bVar == null) {
                eVar = i2;
            } else {
                eVar = (c1)bVar.b();
            }
            if (eVar == null) {
                if (z2) {
                    obj9 = d0.b(u0);
                } else {
                    obj9 = d0.a(u0);
                }
                eVar = obj9;
            }
            obj9 = new q(b.c(d5), 1);
            obj9.B();
            c0.a.c cVar = new c0.a.c(callable4, obj9, i2);
            c0.a.b obj12 = new c0.a.b(cancellationSignal3, k.d(r1.a, eVar, 0, cVar, 2, 0));
            obj9.g(obj12);
            obj9 = obj9.y();
            if (obj9 == b.d()) {
                h.c(d5);
            }
            return obj9;
        }

        public final <R> Object b(androidx.room.u0 u0, boolean z2, Callable<R> callable3, d<? super R> d4) {
            boolean z;
            kotlin.b0.e eVar;
            kotlinx.coroutines.h0 obj3;
            if (u0.v() && u0.p()) {
                if (u0.p()) {
                    return callable3.call();
                }
            }
            kotlin.b0.g.b bVar = d4.getContext().get(c1.b);
            int i = 0;
            if ((c1)bVar == null) {
                eVar = i;
            } else {
                eVar = (c1)bVar.b();
            }
            if (eVar == null) {
                if (z2) {
                    obj3 = d0.b(u0);
                } else {
                    obj3 = d0.a(u0);
                }
                eVar = obj3;
            }
            obj3 = new c0.a.a(callable3, i);
            return k.e(eVar, obj3, d4);
        }
    }
    static {
        c0.a aVar = new c0.a(0);
        c0.a = aVar;
    }

    public static final <R> Object a(androidx.room.u0 u0, boolean z2, CancellationSignal cancellationSignal3, Callable<R> callable4, d<? super R> d5) {
        return c0.a.a(u0, z2, cancellationSignal3, callable4, d5);
    }

    public static final <R> Object b(androidx.room.u0 u0, boolean z2, Callable<R> callable3, d<? super R> d4) {
        return c0.a.b(u0, z2, callable3, d4);
    }
}
