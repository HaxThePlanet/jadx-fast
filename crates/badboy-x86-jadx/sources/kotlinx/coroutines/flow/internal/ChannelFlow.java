package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000e2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH¤@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0008\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R9\u0010\n\u001a$\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000c\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006&", d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ChannelFlow<T>  implements kotlinx.coroutines.flow.internal.FusibleFlow<T> {

    public final int capacity;
    public final CoroutineContext context;
    public final BufferOverflow onBufferOverflow;
    public ChannelFlow(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        boolean aSSERTIONS_ENABLED;
        int i;
        int i2;
        super();
        this.context = context;
        this.capacity = capacity;
        this.onBufferOverflow = onBufferOverflow;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = this.capacity != -1 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
    }

    static <T> Object collect$suspendImpl(kotlinx.coroutines.flow.internal.ChannelFlow<T> $this, FlowCollector<? super T> collector, Continuation<? super Unit> $completion) {
        ChannelFlow.collect.2 anon = new ChannelFlow.collect.2(collector, $this, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    protected String additionalToStringProps() {
        return null;
    }

    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation2) {
        return ChannelFlow.collect$suspendImpl(this, flowCollector, continuation2);
    }

    protected abstract Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation2);

    protected abstract kotlinx.coroutines.flow.internal.ChannelFlow<T> create(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow3);

    public Flow<T> dropChannelOperators() {
        return 0;
    }

    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        int $i$a$AssertChannelFlow$fuse$1;
        int sum;
        int i;
        int i2;
        BufferOverflow onBufferOverflow3;
        int i3;
        boolean onBufferOverflow2;
        int aSSERTIONS_ENABLED;
        int $i$a$AssertChannelFlow$fuse$2;
        int capacity2;
        i = 1;
        i2 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i4 = 0;
            $i$a$AssertChannelFlow$fuse$1 = capacity != -1 ? i : i2;
            if ($i$a$AssertChannelFlow$fuse$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        CoroutineContext plus = context.plus(this.context);
        int i5 = 0;
        final int i6 = 0;
        if (onBufferOverflow != BufferOverflow.SUSPEND) {
            sum = capacity;
            onBufferOverflow3 = onBufferOverflow;
        } else {
            capacity2 = -3;
            if (this.capacity == capacity2) {
                sum = capacity;
            } else {
                if (capacity == capacity2) {
                    sum = this.capacity;
                } else {
                    capacity2 = -2;
                    if (this.capacity == capacity2) {
                    } else {
                        if (capacity == capacity2) {
                            sum = this.capacity;
                        } else {
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                int i7 = 0;
                                $i$a$AssertChannelFlow$fuse$2 = this.capacity >= 0 ? i : i2;
                                if ($i$a$AssertChannelFlow$fuse$2 == 0) {
                                } else {
                                }
                                AssertionError assertionError2 = new AssertionError();
                                throw assertionError2;
                            }
                            if (DebugKt.getASSERTIONS_ENABLED()) {
                                aSSERTIONS_ENABLED = 0;
                                if (capacity >= 0) {
                                } else {
                                    i = i2;
                                }
                                if (i == 0) {
                                } else {
                                }
                                AssertionError assertionError3 = new AssertionError();
                                throw assertionError3;
                            }
                            if (capacity3 += capacity >= 0) {
                            } else {
                                sum = i2;
                            }
                        }
                    }
                }
            }
            onBufferOverflow3 = this.onBufferOverflow;
        }
        if (Intrinsics.areEqual(plus, this.context) && sum == this.capacity && onBufferOverflow3 == this.onBufferOverflow) {
            if (sum == this.capacity) {
                if (onBufferOverflow3 == this.onBufferOverflow) {
                    return (Flow)this;
                }
            }
        }
        return (Flow)create(plus, sum, onBufferOverflow3);
    }

    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> getCollectToFun$kotlinx_coroutines_core() {
        ChannelFlow.collectToFun.1 anon = new ChannelFlow.collectToFun.1(this, 0);
        return (Function2)anon;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final int getProduceCapacity$kotlinx_coroutines_core() {
        int capacity;
        capacity = this.capacity == -3 ? -2 : this.capacity;
        return capacity;
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope scope) {
        return ProduceKt.produce$default(scope, this.context, getProduceCapacity$kotlinx_coroutines_core(), this.onBufferOverflow, CoroutineStart.ATOMIC, 0, getCollectToFun$kotlinx_coroutines_core(), 16, 0);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public String toString() {
        Object it;
        int capacity;
        Object onBufferOverflow2;
        int i;
        CoroutineContext iNSTANCE;
        int capacity2;
        BufferOverflow onBufferOverflow;
        ArrayList arrayList = new ArrayList(4);
        String additionalToStringProps = additionalToStringProps();
        if (additionalToStringProps != null) {
            i = 0;
            arrayList.add(additionalToStringProps);
        }
        if (this.context != EmptyCoroutineContext.INSTANCE) {
            StringBuilder stringBuilder = new StringBuilder();
            arrayList.add(stringBuilder.append("context=").append(this.context).toString());
        }
        if (this.capacity != -3) {
            StringBuilder stringBuilder4 = new StringBuilder();
            arrayList.add(stringBuilder4.append("capacity=").append(this.capacity).toString());
        }
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            StringBuilder stringBuilder2 = new StringBuilder();
            arrayList.add(stringBuilder2.append("onBufferOverflow=").append(this.onBufferOverflow).toString());
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        return stringBuilder3.append(DebugStringsKt.getClassSimpleName(this)).append('[').append(CollectionsKt.joinToString$default((Iterable)arrayList, (CharSequence)", ", 0, 0, 0, 0, 0, 62, 0)).append(']').toString();
    }
}
