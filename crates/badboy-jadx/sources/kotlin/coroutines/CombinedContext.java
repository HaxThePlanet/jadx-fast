package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\u000c\u001a\u00020\t2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0008\u0008\u0000\u0010\u0016*\u00020\u00062\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u0018H\u0016J\u0008\u0010\u001d\u001a\u00020\u001bH\u0002J\u0008\u0010\u001e\u001a\u00020\u001fH\u0016J\u0008\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CombinedContext implements kotlin.coroutines.CoroutineContext, Serializable {

    private final kotlin.coroutines.CoroutineContext.Element element;
    private final kotlin.coroutines.CoroutineContext left;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u000c2\u00060\u0001j\u0002`\u0002:\u0001\u000cB\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Serialized implements Serializable {

        public static final kotlin.coroutines.CombinedContext.Serialized.Companion Companion;
        private static final long serialVersionUID;
        private final kotlin.coroutines.CoroutineContext[] elements;
        static {
            CombinedContext.Serialized.Companion companion = new CombinedContext.Serialized.Companion(0);
            CombinedContext.Serialized.Companion = companion;
        }

        public Serialized(kotlin.coroutines.CoroutineContext[] elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            super();
            this.elements = elements;
        }

        private final Object readResolve() {
            kotlin.coroutines.EmptyCoroutineContext accumulator$iv;
            int i;
            kotlin.coroutines.CoroutineContext context2;
            kotlin.coroutines.CoroutineContext p0;
            kotlin.coroutines.CoroutineContext context;
            int i2;
            final kotlin.coroutines.CoroutineContext[] elements = this.elements;
            final int i3 = 0;
            accumulator$iv = iNSTANCE;
            i = 0;
            while (i < elements.length) {
                i2 = 0;
                accumulator$iv = p0;
                i++;
            }
            return accumulator$iv;
        }

        @Override // java.io.Serializable
        public final kotlin.coroutines.CoroutineContext[] getElements() {
            return this.elements;
        }
    }
    public CombinedContext(kotlin.coroutines.CoroutineContext left, kotlin.coroutines.CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        super();
        this.left = left;
        this.element = element;
    }

    private final boolean contains(kotlin.coroutines.CoroutineContext.Element element) {
        return Intrinsics.areEqual(get(element.getKey()), element);
    }

    private final boolean containsAll(kotlin.coroutines.CombinedContext context) {
        Object cur;
        kotlin.coroutines.CoroutineContext left;
        boolean z;
        cur = context;
        while (!contains(cur.element)) {
            left = cur.left;
            cur = left;
        }
        return 0;
    }

    private final int size() {
        Object cur;
        int size;
        int left;
        boolean z;
        cur = this;
        size = 2;
        while (left instanceof CombinedContext != null) {
            if (left != 0) {
            }
            cur = left;
            size++;
            left = 0;
        }
        return size;
    }

    private final Object writeReplace() {
        int i;
        final int size = size();
        final kotlin.coroutines.CoroutineContext[] arr = new CoroutineContext[size];
        Ref.IntRef intRef = new Ref.IntRef();
        CombinedContext.writeReplace.1 anon = new CombinedContext.writeReplace.1(arr, intRef);
        fold(Unit.INSTANCE, (Function2)anon);
        i = intRef.element == size ? 1 : 0;
        if (i == 0) {
        } else {
            CombinedContext.Serialized serialized = new CombinedContext.Serialized(arr);
            return serialized;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public boolean equals(Object other) {
        int i;
        boolean size;
        int size2;
        if (this != other) {
            if (other instanceof CombinedContext != null && (CombinedContext)other.size() == size() && (CombinedContext)other.containsAll(this)) {
                if ((CombinedContext)other.size() == size()) {
                    if ((CombinedContext)other.containsAll(this)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public <R> R fold(R initial, Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(this.left.fold(initial, operation), this.element);
    }

    public <E extends kotlin.coroutines.CoroutineContext.Element> E get(kotlin.coroutines.CoroutineContext.Key<E> key) {
        Object cur;
        kotlin.coroutines.CoroutineContext it;
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        cur = this;
        kotlin.coroutines.CoroutineContext.Element context = cur.element.get(key);
        while (context != null) {
            it = cur.left;
            cur = it;
            context = cur.element.get(key);
        }
        int i = 0;
        return context;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public int hashCode() {
        return i += i3;
    }

    public kotlin.coroutines.CoroutineContext minusKey(kotlin.coroutines.CoroutineContext.Key<?> key) {
        Object combinedContext;
        kotlin.coroutines.CoroutineContext.Element element;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            int i = 0;
            return this.left;
        }
        kotlin.coroutines.CoroutineContext minusKey = this.left.minusKey(key);
        if (minusKey == this.left) {
            combinedContext = this;
        } else {
            if (minusKey == EmptyCoroutineContext.INSTANCE) {
                combinedContext = this.element;
            } else {
                combinedContext = new CombinedContext(minusKey, this.element);
            }
        }
        return combinedContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public kotlin.coroutines.CoroutineContext plus(kotlin.coroutines.CoroutineContext context) {
        return CoroutineContext.DefaultImpls.plus(this, context);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('[').append((String)fold("", (Function2)CombinedContext.toString.1.INSTANCE)).append(']').toString();
    }
}
