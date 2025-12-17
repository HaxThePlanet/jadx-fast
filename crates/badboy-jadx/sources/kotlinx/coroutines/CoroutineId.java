package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0081\u0008\u0018\u0000 \u00182\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0008\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineId extends AbstractCoroutineContextElement implements kotlinx.coroutines.ThreadContextElement<String> {

    public static final kotlinx.coroutines.CoroutineId.Key Key;
    private final long id;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<kotlinx.coroutines.CoroutineId> {
        public Key(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        CoroutineId.Key key = new CoroutineId.Key(0);
        CoroutineId.Key = key;
    }

    public CoroutineId(long id) {
        super((CoroutineContext.Key)CoroutineId.Key);
        this.id = id;
    }

    public static kotlinx.coroutines.CoroutineId copy$default(kotlinx.coroutines.CoroutineId coroutineId, long l2, int i3, Object object4) {
        long obj1;
        if (object4 &= 1 != 0) {
            obj1 = coroutineId.id;
        }
        return coroutineId.copy(obj1);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public final long component1() {
        return this.id;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public final kotlinx.coroutines.CoroutineId copy(long l) {
        CoroutineId coroutineId = new CoroutineId(l, obj3);
        return coroutineId;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CoroutineId) {
            return i2;
        }
        if (Long.compare(l, l2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public final long getId() {
        return this.id;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public int hashCode() {
        return Long.hashCode(this.id);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public void restoreThreadContext(CoroutineContext context, Object oldState) {
        restoreThreadContext(context, (String)oldState);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public void restoreThreadContext(CoroutineContext context, String oldState) {
        Thread.currentThread().setName(oldState);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CoroutineId(").append(this.id).append(')').toString();
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public Object updateThreadContext(CoroutineContext context) {
        return updateThreadContext(context);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public String updateThreadContext(CoroutineContext context) {
        String name;
        int lastIndex;
        name = context.get((CoroutineContext.Key)CoroutineName.Key);
        if ((CoroutineName)name != null) {
            if ((CoroutineName)name.getName() == null) {
                name = "coroutine";
            }
        } else {
        }
        final Thread currentThread = Thread.currentThread();
        final String name2 = currentThread.getName();
        int i = 0;
        if (StringsKt.lastIndexOf$default((CharSequence)name2, " @", 0, false, 6, 0) < 0) {
            lastIndex = name2.length();
        }
        StringBuilder stringBuilder = new StringBuilder(i2 += 10);
        StringBuilder sb = stringBuilder;
        int i5 = 0;
        String substring = name2.substring(0, lastIndex);
        String str5 = "this as java.lang.String…ing(startIndex, endIndex)";
        Intrinsics.checkNotNullExpressionValue(substring, str5);
        sb.append(substring);
        sb.append(" @");
        sb.append(name);
        sb.append('#');
        sb.append(this.id);
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(string);
        return name2;
    }
}
