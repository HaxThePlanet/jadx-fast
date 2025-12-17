package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0008\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineName extends AbstractCoroutineContextElement {

    public static final kotlinx.coroutines.CoroutineName.Key Key;
    private final String name;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/CoroutineName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineName;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<kotlinx.coroutines.CoroutineName> {
        public Key(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        CoroutineName.Key key = new CoroutineName.Key(0);
        CoroutineName.Key = key;
    }

    public CoroutineName(String name) {
        super((CoroutineContext.Key)CoroutineName.Key);
        this.name = name;
    }

    public static kotlinx.coroutines.CoroutineName copy$default(kotlinx.coroutines.CoroutineName coroutineName, String string2, int i3, Object object4) {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = coroutineName.name;
        }
        return coroutineName.copy(obj1);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public final String component1() {
        return this.name;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public final kotlinx.coroutines.CoroutineName copy(String string) {
        CoroutineName coroutineName = new CoroutineName(string);
        return coroutineName;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CoroutineName) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.name, obj.name)) {
            return i2;
        }
        return i;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public final String getName() {
        return this.name;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CoroutineName(").append(this.name).append(')').toString();
    }
}
