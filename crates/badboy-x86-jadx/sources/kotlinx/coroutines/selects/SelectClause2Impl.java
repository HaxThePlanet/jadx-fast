package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B¦\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012U\u0010\u0006\u001aQ\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0004\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\n¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000e\u0012U\u0010\u000f\u001aQ\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\u0002`\u0011\u0012i\u0008\u0002\u0010\u0012\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\n¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u0014\u0018\u00010\u0007j\u0004\u0018\u0001`\u0016¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019Ru\u0010\u0012\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\n¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u0014\u0018\u00010\u0007j\u0004\u0018\u0001`\u0016X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bRc\u0010\u000f\u001aQ\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\u0002`\u0011X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bRc\u0010\u0006\u001aQ\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0004\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\n¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u0007j\u0002`\u000eX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001b¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/selects/SelectClause2Impl;", "P", "Q", "Lkotlinx/coroutines/selects/SelectClause2;", "clauseObject", "", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "onCancellationConstructor", "internalResult", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "getClauseObject", "()Ljava/lang/Object;", "getOnCancellationConstructor", "()Lkotlin/jvm/functions/Function3;", "getProcessResFunc", "getRegFunc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectClause2Impl<P, Q>  implements kotlinx.coroutines.selects.SelectClause2<P, Q> {

    private final Object clauseObject;
    private final Function3<kotlinx.coroutines.selects.SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
    private final Function3<Object, Object, Object, Object> processResFunc;
    private final Function3<Object, kotlinx.coroutines.selects.SelectInstance<?>, Object, Unit> regFunc;
    public SelectClause2Impl(Object clauseObject, Function3<Object, ? super kotlinx.coroutines.selects.SelectInstance<?>, Object, Unit> regFunc, Function3<Object, Object, Object, ? extends Object> processResFunc, Function3<? super kotlinx.coroutines.selects.SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> onCancellationConstructor) {
        super();
        this.clauseObject = clauseObject;
        this.regFunc = regFunc;
        this.processResFunc = processResFunc;
        this.onCancellationConstructor = onCancellationConstructor;
    }

    public SelectClause2Impl(Object object, Function3 function32, Function3 function33, Function3 function34, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj4;
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(object, function32, function33, obj4);
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public Object getClauseObject() {
        return this.clauseObject;
    }

    public Function3<kotlinx.coroutines.selects.SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.processResFunc;
    }

    public Function3<Object, kotlinx.coroutines.selects.SelectInstance<?>, Object, Unit> getRegFunc() {
        return this.regFunc;
    }
}
