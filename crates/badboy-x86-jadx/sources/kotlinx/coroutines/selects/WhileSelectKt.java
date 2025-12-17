package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u001f\u0008\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0006H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0008", d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WhileSelectKt {
    public static final Object whileSelect(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation2) {
        boolean $result;
        Object $continuation2;
        int i3;
        kotlinx.coroutines.selects.WhileSelectKt.whileSelect.1 anon;
        Object $continuation;
        int i;
        Object $i$f$select;
        int $i$a$RunSelectKt$select$3$iv;
        Object l$0;
        int i2;
        int i4;
        kotlinx.coroutines.selects.WhileSelectKt.whileSelect.1 anon2;
        int obj8;
        Object obj9;
        $result = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof WhileSelectKt.whileSelect.1 && label &= i != 0) {
            $result = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj9 -= i;
            } else {
                $result = new WhileSelectKt.whileSelect.1(continuation2);
            }
        } else {
        }
        obj9 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = function1;
                obj8 = $i$f$select;
                break;
            case 1:
                obj8 = 0;
                l$0 = $result.L$0;
                ResultKt.throwOnFailure(obj9);
                i2 = i7;
                $i$a$RunSelectKt$select$3$iv = i5;
                $i$f$select = $continuation;
                anon = $result;
                $continuation2 = obj9;
                return Unit.INSTANCE;
                obj9 = $continuation2;
                $result = anon;
                $continuation = $i$f$select;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        SelectImplementation selectImplementation = new SelectImplementation($result.getContext());
        i2 = 0;
        l$0.invoke(selectImplementation);
        $result.L$0 = l$0;
        $result.label = 1;
        Object $this$select_u24lambda_u241$iv = selectImplementation.doSelect($result);
        if ($this$select_u24lambda_u241$iv != $continuation) {
            $continuation2 = obj9;
            obj9 = $this$select_u24lambda_u241$iv;
            $i$a$RunSelectKt$select$3$iv = i6;
            $i$f$select = $continuation;
            anon = anon2;
        }
        return $continuation;
    }

    private static final Object whileSelect$$forInline(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super Boolean>, Unit> builder, Continuation<? super Unit> $completion) {
        int obj0 = 0;
        obj0.getContext();
        throw obj0;
    }
}
