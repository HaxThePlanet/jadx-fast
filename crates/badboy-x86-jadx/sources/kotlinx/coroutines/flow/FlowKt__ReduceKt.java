package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aG\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001ay\u0010\u000b\u001a\u0002H\u000c\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\u000c2H\u0008\u0004\u0010\u000e\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\u000c¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0013\u0012\u0011H\u0001¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000c0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u000fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001as\u0010\u0017\u001a\u0002H\u0018\"\u0004\u0008\u0000\u0010\u0018\"\u0008\u0008\u0001\u0010\u0001*\u0002H\u0018*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0019\u0012\u0013\u0012\u0011H\u0001¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001d", d2 = {"first", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", "reduce", "S", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ReduceKt {
    public static final <T> Object first(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super T> continuation2) {
        boolean anon;
        Throwable th;
        Object l$1;
        int i2;
        Object objectRef;
        Throwable $i$f$collectWhile;
        Object collector$iv;
        Object collect;
        int i;
        int obj7;
        Object obj8;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__ReduceKt.first.1 && label &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj8 -= i2;
            } else {
                anon = new FlowKt__ReduceKt.first.1(continuation2);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                collector$iv = new FlowKt__ReduceKt.first$$inlined.collectWhile.1(objectRef);
                anon.L$0 = objectRef;
                anon.L$1 = collector$iv;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj7 = $i$f$collectWhile;
                l$1 = collector$iv;
                break;
            case 1:
                obj7 = 0;
                l$1 = anon.L$1;
                objectRef = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
        } else {
            return objectRef.element;
        }
        obj7 = new NoSuchElementException("Expected at least one element");
        throw obj7;
    }

    public static final <T> Object first(kotlinx.coroutines.flow.Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22, Continuation<? super T> continuation3) {
        boolean anon;
        Throwable th;
        Object l$1;
        int i2;
        Object l$0;
        Throwable $i$f$collectWhile;
        Object collector$iv;
        Object collect;
        int i;
        int obj7;
        Object obj8;
        Object obj9;
        anon = continuation3;
        i2 = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__ReduceKt.first.3 && label &= i2 != 0) {
            anon = continuation3;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj9 -= i2;
            } else {
                anon = new FlowKt__ReduceKt.first.3(continuation3);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = function22;
                obj8 = new Ref.ObjectRef();
                obj8.element = NullSurrogateKt.NULL;
                collector$iv = new FlowKt__ReduceKt.first$$inlined.collectWhile.2(l$0, obj8);
                anon.L$0 = l$0;
                anon.L$1 = obj8;
                anon.L$2 = collector$iv;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$1 = obj8;
                obj7 = $i$f$collectWhile;
                obj8 = collector$iv;
                break;
            case 1:
                obj7 = 0;
                obj8 = anon.L$2;
                l$1 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if (l$1.element == NullSurrogateKt.NULL) {
        } else {
            return l$1.element;
        }
        obj8 = new StringBuilder();
        obj7 = new NoSuchElementException(obj8.append("Expected at least one element matching the predicate ").append(l$0).toString());
        throw obj7;
    }

    public static final <T> Object firstOrNull(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super T> continuation2) {
        boolean anon;
        Throwable th;
        Object l$1;
        int i2;
        Object objectRef;
        Throwable $i$f$collectWhile;
        Object collector$iv;
        Object collect;
        int i;
        int obj7;
        Object obj8;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__ReduceKt.firstOrNull.1 && label &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj8 -= i2;
            } else {
                anon = new FlowKt__ReduceKt.firstOrNull.1(continuation2);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                objectRef = new Ref.ObjectRef();
                collector$iv = new FlowKt__ReduceKt.firstOrNull$$inlined.collectWhile.1(objectRef);
                anon.L$0 = objectRef;
                anon.L$1 = collector$iv;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj7 = $i$f$collectWhile;
                l$1 = collector$iv;
                break;
            case 1:
                obj7 = 0;
                l$1 = anon.L$1;
                objectRef = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        return objectRef.element;
    }

    public static final <T> Object firstOrNull(kotlinx.coroutines.flow.Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22, Continuation<? super T> continuation3) {
        boolean anon;
        Throwable th;
        Object l$0;
        Throwable result;
        int objectRef;
        int $i$f$collectWhile;
        Object anon2;
        int i;
        int obj6;
        Object obj7;
        Object obj8;
        anon = continuation3;
        result = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__ReduceKt.firstOrNull.3 && label &= result != null) {
            anon = continuation3;
            result = Integer.MIN_VALUE;
            if (label &= result != null) {
                anon.label = obj8 -= result;
            } else {
                anon = new FlowKt__ReduceKt.firstOrNull.3(continuation3);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                objectRef = new Ref.ObjectRef();
                anon2 = new FlowKt__ReduceKt.firstOrNull$$inlined.collectWhile.2(function22, objectRef);
                anon.L$0 = objectRef;
                anon.L$1 = anon2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = objectRef;
                obj6 = $i$f$collectWhile;
                obj7 = anon2;
                break;
            case 1:
                obj6 = 0;
                obj7 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        return l$0.element;
    }

    public static final <T, R> Object fold(kotlinx.coroutines.flow.Flow<? extends T> flow, R r2, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function33, Continuation<? super R> continuation4) {
        boolean anon;
        int i2;
        int i;
        int label;
        Ref.ObjectRef objectRef;
        int i3;
        int obj5;
        Object obj6;
        Object obj8;
        anon = continuation4;
        i = Integer.MIN_VALUE;
        if (continuation4 instanceof FlowKt__ReduceKt.fold.1 && label2 &= i != 0) {
            anon = continuation4;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj8 -= i;
            } else {
                anon = new FlowKt__ReduceKt.fold.1(continuation4);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                objectRef = new Ref.ObjectRef();
                objectRef.element = r2;
                obj6 = new FlowKt__ReduceKt.fold.2(objectRef, function33);
                anon.L$0 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = label;
                obj6 = objectRef;
                break;
            case 1:
                obj5 = 0;
                obj6 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return obj6.element;
    }

    private static final <T, R> Object fold$$forInline(kotlinx.coroutines.flow.Flow<? extends T> $this$fold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation, Continuation<? super R> $completion) {
        final int i = 0;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = initial;
        FlowKt__ReduceKt.fold.2 anon = new FlowKt__ReduceKt.fold.2(objectRef, operation);
        $this$fold.collect((FlowCollector)anon, $completion);
        return objectRef.element;
    }

    public static final <T> Object last(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super T> continuation2) {
        boolean anon;
        int i3;
        int i;
        Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.last.2 anon2;
        int i2;
        Object obj5;
        Object obj6;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__ReduceKt.last.1 && label &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj6 -= i;
            } else {
                anon = new FlowKt__ReduceKt.last.1(continuation2);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                anon2 = new FlowKt__ReduceKt.last.2(objectRef);
                anon.L$0 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = objectRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        if (obj5.element == NullSurrogateKt.NULL) {
        } else {
            return obj5.element;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Expected at least one element");
        throw noSuchElementException;
    }

    public static final <T> Object lastOrNull(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super T> continuation2) {
        boolean anon;
        int i;
        int i3;
        Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.lastOrNull.2 anon2;
        int i2;
        Object obj5;
        Object obj6;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__ReduceKt.lastOrNull.1 && label &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj6 -= i3;
            } else {
                anon = new FlowKt__ReduceKt.lastOrNull.1(continuation2);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                objectRef = new Ref.ObjectRef();
                anon2 = new FlowKt__ReduceKt.lastOrNull.2(objectRef);
                anon.L$0 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = objectRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return obj5.element;
    }

    public static final <S, T extends S> Object reduce(kotlinx.coroutines.flow.Flow<? extends T> flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function32, Continuation<? super S> continuation3) {
        boolean anon;
        int i;
        int i3;
        Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.reduce.2 anon2;
        int i2;
        Object obj5;
        Object obj7;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__ReduceKt.reduce.1 && label &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj7 -= i3;
            } else {
                anon = new FlowKt__ReduceKt.reduce.1(continuation3);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                anon2 = new FlowKt__ReduceKt.reduce.2(objectRef, function32);
                anon.L$0 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = objectRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        if (obj5.element == NullSurrogateKt.NULL) {
        } else {
            return obj5.element;
        }
        NoSuchElementException obj6 = new NoSuchElementException("Empty flow can't be reduced");
        throw obj6;
    }

    public static final <T> Object single(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super T> continuation2) {
        boolean anon;
        int i2;
        int i3;
        Ref.ObjectRef objectRef;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.single.2 anon2;
        int i;
        Object obj5;
        Object obj6;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__ReduceKt.single.1 && label &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj6 -= i3;
            } else {
                anon = new FlowKt__ReduceKt.single.1(continuation2);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (objectRef) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                anon2 = new FlowKt__ReduceKt.single.2(objectRef);
                anon.L$0 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = objectRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        if (obj5.element == NullSurrogateKt.NULL) {
        } else {
            return obj5.element;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Flow is empty");
        throw noSuchElementException;
    }

    public static final <T> Object singleOrNull(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super T> continuation2) {
        boolean anon;
        Throwable th;
        Object l$1;
        int i2;
        Object objectRef;
        Throwable $i$f$collectWhile;
        Object collector$iv;
        Object collect;
        int i;
        int obj7;
        Object obj8;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__ReduceKt.singleOrNull.1 && label &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj8 -= i2;
            } else {
                anon = new FlowKt__ReduceKt.singleOrNull.1(continuation2);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                objectRef = new Ref.ObjectRef();
                objectRef.element = NullSurrogateKt.NULL;
                collector$iv = new FlowKt__ReduceKt.singleOrNull$$inlined.collectWhile.1(objectRef);
                anon.L$0 = objectRef;
                anon.L$1 = collector$iv;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj7 = $i$f$collectWhile;
                l$1 = collector$iv;
                break;
            case 1:
                obj7 = 0;
                l$1 = anon.L$1;
                objectRef = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        obj7 = objectRef.element == NullSurrogateKt.NULL ? 0 : objectRef.element;
        return obj7;
    }
}
