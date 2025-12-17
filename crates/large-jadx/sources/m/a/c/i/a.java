package m.a.c.i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.d;
import kotlin.y.p;
import m.a.e.a;
import org.koin.core.error.NoParameterFoundException;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000c\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u0016\u0010\u000e\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0014\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J'\u0010\u0015\u001a\u0002H\u000f\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0002H\u000f\"\n\u0008\u0000\u0010\u000f\u0018\u0001*\u00020\u0001H\u0086\u0008¢\u0006\u0002\u0010\u0010J\u001c\u0010\u001b\u001a\u0002H\u000f\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u0001H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\u0008¢\u0006\u0002\u0010\u0010J!\u0010\u001d\u001a\u0004\u0018\u0001H\u000f\"\u0004\u0008\u0000\u0010\u000f2\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0019H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0001J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J!\u0010$\u001a\u00020%\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u0002H\u000f¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0017J\u0008\u0010)\u001a\u00020*H\u0016R$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u0008¨\u0006,", d2 = {"Lorg/koin/core/parameter/ParametersHolder;", "", "_values", "", "(Ljava/util/List;)V", "get_values$annotations", "()V", "get_values", "()Ljava/util/List;", "values", "", "getValues", "add", "value", "component1", "T", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "elementAt", "i", "", "clazz", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getOrNull", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "insert", "index", "isEmpty", "", "isNotEmpty", "set", "", "t", "(ILjava/lang/Object;)V", "size", "toString", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class a {

    private final List<Object> a;
    static {
    }

    public a() {
        final int i = 0;
        super(i, 1, i);
    }

    public a(List<Object> list) {
        n.f(list, "_values");
        super();
        this.a = list;
    }

    public a(List list, int i2, g g3) {
        ArrayList obj1;
        if (i2 &= 1 != 0) {
            obj1 = new ArrayList();
        }
        super(obj1);
    }

    public <T> T a(int i, d<?> d2) {
        n.f(d2, "clazz");
        if (this.a.size() <= i) {
        } else {
            return this.a.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't get injected parameter #");
        stringBuilder.append(i);
        stringBuilder.append(" from ");
        stringBuilder.append(this);
        stringBuilder.append(" for type '");
        stringBuilder.append(a.a(d2));
        stringBuilder.append('\'');
        NoParameterFoundException noParameterFoundException = new NoParameterFoundException(stringBuilder.toString());
        throw noParameterFoundException;
    }

    public <T> T b(d<?> d) {
        Object next;
        int i;
        boolean z;
        n.f(d, "clazz");
        Iterator iterator = this.a.iterator();
        i = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (d.q(next)) {
            }
            if (i == 0) {
            }
            i = 0;
            i = next;
        }
        return i;
    }

    public final m.a.c.i.a c(int i, Object object2) {
        n.f(object2, "value");
        this.a.add(i, object2);
        return this;
    }

    public String toString() {
        return n.o("DefinitionParameters", p.L0(this.a));
    }
}
