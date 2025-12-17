package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008!\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004B\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0008\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000f", d2 = {"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SuspendLambda extends kotlin.coroutines.jvm.internal.ContinuationImpl implements FunctionBase<Object>, kotlin.coroutines.jvm.internal.SuspendFunction {

    private final int arity;
    public SuspendLambda(int arity) {
        super(arity, 0);
    }

    public SuspendLambda(int arity, Continuation<Object> completion) {
        super(completion);
        this.arity = arity;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public String toString() {
        String renderLambdaToString;
        String str;
        if (getCompletion() == null) {
            Intrinsics.checkNotNullExpressionValue(Reflection.renderLambdaToString((FunctionBase)this), "renderLambdaToString(...)");
        } else {
            renderLambdaToString = super.toString();
        }
        return renderLambdaToString;
    }
}
