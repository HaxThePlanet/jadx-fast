package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012-\u0010\u0007\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0008¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u000b2\n\u0010\u001f\u001a\u0006\u0012\u0002\u0008\u00030 2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u000cH\u0002J\u0008\u0010!\u001a\u00020\u000bH\u0014J\u0019\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J&\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u000b0%2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00120\u00118VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "", "cause", "", "offer", "element", "(Ljava/lang/Object;)Z", "onSendRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onStart", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyActorCoroutine<E>  extends kotlinx.coroutines.channels.ActorCoroutine<E> {

    private Continuation<? super Unit> continuation;
    public LazyActorCoroutine(CoroutineContext parentContext, kotlinx.coroutines.channels.Channel<E> channel, Function2<? super kotlinx.coroutines.channels.ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        super(parentContext, channel, 0);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(block, this, (Continuation)this);
    }

    public static final void access$onSendRegFunction(kotlinx.coroutines.channels.LazyActorCoroutine $this, SelectInstance select, Object element) {
        $this.onSendRegFunction(select, element);
    }

    public static void getOnSend$annotations() {
    }

    private final void onSendRegFunction(SelectInstance<?> select, Object element) {
        onStart();
        super.getOnSend().getRegFunc().invoke(this, select, element);
    }

    @Override // kotlinx.coroutines.channels.ActorCoroutine
    public boolean close(Throwable cause) {
        start();
        return super.close(cause);
    }

    public SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> getOnSend() {
        kotlinx.coroutines.channels.LazyActorCoroutine.onSend.1 iNSTANCE = LazyActorCoroutine.onSend.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        SelectClause2Impl selectClause2Impl = new SelectClause2Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, 3), super.getOnSend().getProcessResFunc(), 0, 8, 0);
        return (SelectClause2)selectClause2Impl;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
    public boolean offer(E element) {
        start();
        return super.offer(element);
    }

    @Override // kotlinx.coroutines.channels.ActorCoroutine
    protected void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, (Continuation)this);
    }

    public Object send(E element, Continuation<? super Unit> $completion) {
        start();
        Object send = super.send(element, $completion);
        if (send == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return send;
        }
        return Unit.INSTANCE;
    }

    public Object trySend-JP2dKIU(E element) {
        start();
        return super.trySend-JP2dKIU(element);
    }
}
