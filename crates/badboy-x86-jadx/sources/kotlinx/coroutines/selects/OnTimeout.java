package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002R\u0017\u0010\u0005\u001a\u00020\u00068F¢\u0006\u000c\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/selects/OnTimeout;", "", "timeMillis", "", "(J)V", "selectClause", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "register", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OnTimeout {

    private final long timeMillis;
    public OnTimeout(long timeMillis) {
        super();
        this.timeMillis = timeMillis;
    }

    public static final void access$register(kotlinx.coroutines.selects.OnTimeout $this, kotlinx.coroutines.selects.SelectInstance select, Object ignoredParam) {
        $this.register(select, ignoredParam);
    }

    public static void getSelectClause$annotations() {
    }

    private final void register(kotlinx.coroutines.selects.SelectInstance<?> select, Object ignoredParam) {
        if (Long.compare(timeMillis, i2) <= 0) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
        int i = 0;
        OnTimeout.register$$inlined.Runnable.1 anon = new OnTimeout.register$$inlined.Runnable.1(select, this);
        Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        kotlinx.coroutines.selects.SelectInstance selectInstance = select;
        kotlin.coroutines.CoroutineContext context = select.getContext();
        select.disposeOnCompletion(DelayKt.getDelay(context).invokeOnTimeout(this.timeMillis, obj4, (Runnable)anon));
    }

    public final kotlinx.coroutines.selects.SelectClause0 getSelectClause() {
        kotlinx.coroutines.selects.OnTimeout.selectClause.1 iNSTANCE = OnTimeout.selectClause.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        SelectClause0Impl selectClause0Impl = new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, 3), 0, 4, 0);
        return (SelectClause0)selectClause0Impl;
    }
}
