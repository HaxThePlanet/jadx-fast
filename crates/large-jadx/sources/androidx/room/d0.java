package androidx.room;

import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.q1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u000c\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0006", d2 = {"transactionDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Landroidx/room/RoomDatabase;", "getTransactionDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/CoroutineDispatcher;", "getQueryDispatcher", "room-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class d0 {
    public static final h0 a(androidx.room.u0 u0) {
        Object obj;
        Object obj3;
        n.f(u0, "<this>");
        Map map = u0.i();
        n.e(map, "backingFieldMap");
        String str3 = "QueryDispatcher";
        if (map.get(str3) == null) {
            obj3 = u0.l();
            n.e(obj3, "queryExecutor");
            map.put(str3, q1.a(obj3));
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (h0)obj;
    }

    public static final h0 b(androidx.room.u0 u0) {
        Object obj;
        Object obj3;
        n.f(u0, "<this>");
        Map map = u0.i();
        n.e(map, "backingFieldMap");
        String str3 = "TransactionDispatcher";
        if (map.get(str3) == null) {
            obj3 = u0.o();
            n.e(obj3, "transactionExecutor");
            map.put(str3, q1.a(obj3));
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (h0)obj;
    }
}
