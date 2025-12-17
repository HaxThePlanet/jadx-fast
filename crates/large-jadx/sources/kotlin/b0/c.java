package kotlin.b0;

import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.z;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\u000c\u001a\u00020\t2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0008\u0008\u0000\u0010\u0016*\u00020\u00062\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u0018H\u0016J\u0008\u0010\u001d\u001a\u00020\u001bH\u0002J\u0008\u0010\u001e\u001a\u00020\u001fH\u0016J\u0008\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class c implements kotlin.b0.g, Serializable {

    private final kotlin.b0.g.b element;
    private final kotlin.b0.g left;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u000c2\u00060\u0001j\u0002`\u0002:\u0001\u000cB\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private static final class a implements Serializable {

        private static final long serialVersionUID;
        private final kotlin.b0.g[] elements;
        static {
        }

        public a(kotlin.b0.g[] gArr) {
            n.f(gArr, "elements");
            super();
            this.elements = gArr;
        }

        private final Object readResolve() {
            kotlin.b0.h plus;
            int i;
            kotlin.b0.g gVar;
            final kotlin.b0.g[] elements = this.elements;
            plus = h.a;
            i = 0;
            while (i < elements.length) {
                plus = plus.plus(elements[i]);
                i++;
            }
            return plus;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class b extends p implements p<String, kotlin.b0.g.b, String> {

        public static final kotlin.b0.c.b a;
        static {
            c.b bVar = new c.b();
            c.b.a = bVar;
        }

        b() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final String a(String string, kotlin.b0.g.b g$b2) {
            int stringBuilder;
            String obj2;
            n.f(string, "acc");
            n.f(b2, "element");
            stringBuilder = string.length() == 0 ? 1 : 0;
            if (stringBuilder != null) {
                obj2 = b2.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(", ");
                stringBuilder.append(b2);
                obj2 = stringBuilder.toString();
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return a((String)object, (g.b)object2);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 5, 1})
    static final class c extends p implements p<w, kotlin.b0.g.b, w> {

        final kotlin.b0.g[] $elements;
        final z $index;
        c(kotlin.b0.g[] gArr, z z2) {
            this.$elements = gArr;
            this.$index = z2;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final void a(w w, kotlin.b0.g.b g$b2) {
            n.f(w, "<anonymous parameter 0>");
            n.f(b2, "element");
            z $index = this.$index;
            final int element = $index.element;
            $index.element = element + 1;
            this.$elements[element] = b2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a((w)object, (g.b)object2);
            return w.a;
        }
    }
    public c(kotlin.b0.g g, kotlin.b0.g.b g$b2) {
        n.f(g, "left");
        n.f(b2, "element");
        super();
        this.left = g;
        this.element = b2;
    }

    private final boolean b(kotlin.b0.g.b g$b) {
        return n.b(get(b.getKey()), b);
    }

    private final boolean d(kotlin.b0.c c) {
        while (!b(c.element)) {
            kotlin.b0.g obj2 = c.left;
        }
        return 0;
    }

    private final int g() {
        int i;
        Object left;
        boolean z;
        i = 2;
        left = this;
        while (!left instanceof c) {
            left = 0;
            if ((c)left != null) {
            }
            i++;
        }
        return i;
    }

    private final Object writeReplace() {
        int i;
        int i2 = g();
        kotlin.b0.g[] arr = new g[i2];
        z zVar = new z();
        zVar.element = 0;
        c.c cVar = new c.c(arr, zVar);
        fold(w.a, cVar);
        if (zVar.element == i2) {
            i = 1;
        }
        if (i == 0) {
        } else {
            c.a aVar = new c.a(arr);
            return aVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.b0.g
    public boolean equals(Object object) {
        int i;
        int i2;
        int obj3;
        if (this != object) {
            if (object instanceof c && (c)object.g() == g() && object.d(this)) {
                if ((c)object.g() == g()) {
                    if (object.d(this)) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public <R> R fold(R r, p<? super R, ? super kotlin.b0.g.b, ? extends R> p2) {
        n.f(p2, "operation");
        return p2.invoke(this.left.fold(r, p2), this.element);
    }

    public <E extends kotlin.b0.g.b> E get(kotlin.b0.g.c<E> g$c) {
        Object left;
        boolean z;
        n.f(c, "key");
        left = this;
        kotlin.b0.g.b bVar = left.element.get(c);
        while (bVar != null) {
            left = left.left;
            bVar = left.element.get(c);
        }
        return bVar;
    }

    @Override // kotlin.b0.g
    public int hashCode() {
        return i += i3;
    }

    public kotlin.b0.g minusKey(kotlin.b0.g.c<?> g$c) {
        kotlin.b0.g cVar;
        kotlin.b0.g.b element;
        Object obj3;
        n.f(c, "key");
        if (this.element.get(c) != null) {
            return this.left;
        }
        obj3 = this.left.minusKey(c);
        if (obj3 == this.left) {
            obj3 = this;
        } else {
            if (obj3 == h.a) {
                obj3 = this.element;
            } else {
                cVar = new c(obj3, this.element);
                obj3 = cVar;
            }
        }
        return obj3;
    }

    @Override // kotlin.b0.g
    public kotlin.b0.g plus(kotlin.b0.g g) {
        n.f(g, "context");
        return g.a.a(this, g);
    }

    @Override // kotlin.b0.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append((String)fold("", c.b.a));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
