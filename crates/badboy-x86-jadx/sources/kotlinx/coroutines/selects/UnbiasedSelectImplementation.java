package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0011\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00028\u0000H\u0091@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0008\u0010\u000b\u001a\u00020\u000cH\u0002J3\u0010\r\u001a\u00020\u000c*\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0013JE\u0010\r\u001a\u00020\u000c\"\u0004\u0008\u0001\u0010\u0014*\u0008\u0012\u0004\u0012\u0002H\u00140\u00152\"\u0010\u000f\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0017JY\u0010\r\u001a\u00020\u000c\"\u0004\u0008\u0001\u0010\u0018\"\u0004\u0008\u0002\u0010\u0014*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00140\u00192\u0006\u0010\u001a\u001a\u0002H\u00182\"\u0010\u000f\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u001e\u0010\u0006\u001a\u0012\u0012\u000e\u0012\u000c0\u0008R\u0008\u0012\u0004\u0012\u00028\u00000\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clausesToRegister", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shuffleAndRegisterClauses", "", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class UnbiasedSelectImplementation<R>  extends kotlinx.coroutines.selects.SelectImplementation<R> {

    private final List<kotlinx.coroutines.selects.SelectImplementation.ClauseData<R>> clausesToRegister;
    public UnbiasedSelectImplementation(CoroutineContext context) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.clausesToRegister = (List)arrayList;
    }

    static <R> Object doSelect$suspendImpl(kotlinx.coroutines.selects.UnbiasedSelectImplementation<R> $this, Continuation<? super R> $completion) {
        $this.shuffleAndRegisterClauses();
        return super.doSelect($completion);
    }

    private final void shuffleAndRegisterClauses() {
        Object next;
        Object obj2;
        int i3;
        Object obj;
        int i4;
        int i;
        int i2;
        Collections.shuffle(this.clausesToRegister);
        final int i5 = 0;
        final Iterator iterator = (Iterable)this.clausesToRegister.iterator();
        try {
            for (Object next : iterator) {
                i3 = 0;
                SelectImplementation.register$default((SelectImplementation)this, (SelectImplementation.ClauseData)next, false, 1, 0);
            }
            i3 = 0;
            SelectImplementation.register$default((SelectImplementation)this, (SelectImplementation.ClauseData)iterator.next(), false, 1, 0);
            this.clausesToRegister.clear();
            this.clausesToRegister.clear();
            throw th;
        }
    }

    public Object doSelect(Continuation<? super R> continuation) {
        return UnbiasedSelectImplementation.doSelect$suspendImpl(this, continuation);
    }

    public void invoke(kotlinx.coroutines.selects.SelectClause0 $this$invoke, Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.ClauseData clauseData = new SelectImplementation.ClauseData((SelectImplementation)this, $this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), block, $this$invoke.getOnCancellationConstructor());
        (Collection)this.clausesToRegister.add(clauseData);
    }

    public <Q> void invoke(kotlinx.coroutines.selects.SelectClause1<? extends Q> $this$invoke, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.ClauseData clauseData = new SelectImplementation.ClauseData((SelectImplementation)this, $this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), 0, block, $this$invoke.getOnCancellationConstructor());
        (Collection)this.clausesToRegister.add(clauseData);
    }

    public <P, Q> void invoke(kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> $this$invoke, P param, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.ClauseData clauseData = new SelectImplementation.ClauseData((SelectImplementation)this, $this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), param, block, $this$invoke.getOnCancellationConstructor());
        (Collection)this.clausesToRegister.add(clauseData);
    }
}
