package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.d0.c.p;
import kotlin.d0.d.p;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.y1;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aN\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022/\u0008\u0005\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tH\u0081\u0008ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\u0008\u00030\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0080\u0010\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0012", d2 = {"unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "checkContext", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class g {

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n", d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements p<Integer, g.b, Integer> {

        final kotlinx.coroutines.flow.internal.e<?> $this_checkContext;
        a(kotlinx.coroutines.flow.internal.e<?> e) {
            this.$this_checkContext = e;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final Integer a(int i, g.b g$b2) {
            int obj4;
            kotlin.b0.g.c key = b2.getKey();
            g.b bVar = $this_checkContext.collectContext.get(key);
            if (key != y1.s) {
                obj4 = b2 != bVar ? -2147483648 : i + 1;
                return Integer.valueOf(obj4);
            }
            y1 obj5 = g.b((y1)b2, (y1)bVar);
            if (obj5 != bVar) {
            } else {
                if (bVar == null) {
                } else {
                    i++;
                }
                return Integer.valueOf(obj4);
            }
            obj4 = new StringBuilder();
            obj4.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of ");
            obj4.append(obj5);
            obj4.append(", expected child of ");
            obj4.append(bVar);
            obj4.append(".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'");
            obj5 = new IllegalStateException(obj4.toString().toString());
            throw obj5;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a((Number)object.intValue(), (g.b)object2);
        }
    }
    public static final void a(kotlinx.coroutines.flow.internal.e<?> e, g g2) {
        g.a aVar = new g.a(e);
        if ((Number)g2.fold(0, aVar).intValue() != e.collectContextSize) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Flow invariant is violated:\n\t\tFlow was collected in ");
        stringBuilder.append(e.collectContext);
        stringBuilder.append(",\n\t\tbut emission happened in ");
        stringBuilder.append(g2);
        stringBuilder.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString().toString());
        throw obj3;
    }

    public static final y1 b(y1 y1, y1 y12) {
        while (y1 == null) {
            y1 obj1 = (x)y1.K0();
        }
        return null;
    }
}
