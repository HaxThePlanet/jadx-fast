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

/* compiled from: ParametersHolder.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000c\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001J\u0016\u0010\u000e\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0014\u001a\u0002H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\n¢\u0006\u0002\u0010\u0010J'\u0010\u0015\u001a\u0002H\u000f\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0002H\u000f\"\n\u0008\u0000\u0010\u000f\u0018\u0001*\u00020\u0001H\u0086\u0008¢\u0006\u0002\u0010\u0010J\u001c\u0010\u001b\u001a\u0002H\u000f\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u0001H\u000f\"\u0006\u0008\u0000\u0010\u000f\u0018\u0001H\u0086\u0008¢\u0006\u0002\u0010\u0010J!\u0010\u001d\u001a\u0004\u0018\u0001H\u000f\"\u0004\u0008\u0000\u0010\u000f2\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0019H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0001J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J!\u0010$\u001a\u00020%\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u0002H\u000f¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0017J\u0008\u0010)\u001a\u00020*H\u0016R$\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u0008¨\u0006,", d2 = {"Lorg/koin/core/parameter/ParametersHolder;", "", "_values", "", "(Ljava/util/List;)V", "get_values$annotations", "()V", "get_values", "()Ljava/util/List;", "values", "", "getValues", "add", "value", "component1", "T", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "elementAt", "i", "", "clazz", "Lkotlin/reflect/KClass;", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getOrNull", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "insert", "index", "isEmpty", "", "isNotEmpty", "set", "", "t", "(ILjava/lang/Object;)V", "size", "toString", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public class ParametersHolder {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<Object> values;
    public a(List<Object> list) {
        n.f(list, "_values");
        super();
        this.values = list;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public <T> T elementAt(int i, d<?> clazz) throws NoParameterFoundException {
        n.f(clazz, "clazz");
        if (this.values.size() <= i) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Can't get injected parameter #";
            String str3 = " from ";
            String str4 = " for type '";
            String str5 = a.a(clazz);
            i = str2 + i + str3 + this + str4 + str5 + 39;
            throw new NoParameterFoundException(i);
        } else {
            return this.values.get(i);
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    public <T> T add(d<?> value) {
        int i = 0;
        boolean z;
        n.f(value, "clazz");
        Iterator it = this.values.iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            if (i != 0) {
                return i;
            }
            i = 0;
        }
        return i;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final a insert(int index, Object value) {
        n.f(value, "value");
        this.values.add(index, value);
        return this;
    }

    public String toString() {
        return n.o("DefinitionParameters", z.L0(this.values));
    }

    public /* synthetic */ a(List list, int i, g gVar) {
        ArrayList arrayList;
        if (i & 1 != 0) {
            arrayList = new ArrayList();
        }
        this(arrayList);
    }


    public a() {
        final List list = null;
        this(list, 1, list);
    }
}
