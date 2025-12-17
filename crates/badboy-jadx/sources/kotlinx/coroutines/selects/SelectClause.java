package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004Rs\u0010\u0005\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0018\u00010\u0006j\u0004\u0018\u0001`\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012Ra\u0010\u0013\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0002`\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0012Ra\u0010\u0017\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000f0\u0006j\u0002`\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0012\u0082\u0001\u0003\u001a\u001b\u001c¨\u0006\u001d", d2 = {"Lkotlinx/coroutines/selects/SelectClause;", "", "clauseObject", "getClauseObject", "()Ljava/lang/Object;", "onCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnCancellationConstructor", "()Lkotlin/jvm/functions/Function3;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "getProcessResFunc", "regFunc", "Lkotlinx/coroutines/selects/RegistrationFunction;", "getRegFunc", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SelectClause {
    public abstract Object getClauseObject();

    public abstract Function3<kotlinx.coroutines.selects.SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor();

    public abstract Function3<Object, Object, Object, Object> getProcessResFunc();

    public abstract Function3<Object, kotlinx.coroutines.selects.SelectInstance<?>, Object, Unit> getRegFunc();
}
