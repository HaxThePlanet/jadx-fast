package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class l extends AbstractList<String> implements RandomAccess, kotlin.reflect.jvm.internal.impl.protobuf.m {

    public static final kotlin.reflect.jvm.internal.impl.protobuf.m b;
    private final List<Object> a;
    static {
        l lVar = new l();
        l.b = lVar.n();
    }

    public l() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public l(kotlin.reflect.jvm.internal.impl.protobuf.m m) {
        super();
        ArrayList arrayList = new ArrayList(m.size());
        this.a = arrayList;
        addAll(m);
    }

    private static kotlin.reflect.jvm.internal.impl.protobuf.d d(Object object) {
        if (object instanceof d) {
            return (d)object;
        }
        if (object instanceof String != null) {
            return d.l((String)object);
        }
        return d.h((byte[])object);
    }

    private static String g(Object object) {
        if (object instanceof String != null) {
            return (String)object;
        }
        if (object instanceof d) {
            return (d)object.D();
        }
        return i.b((byte[])object);
    }

    @Override // java.util.AbstractList
    public void X1(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
        this.a.add(d);
        this.modCount = obj2++;
    }

    @Override // java.util.AbstractList
    public void add(int i, Object object2) {
        b(i, (String)object2);
    }

    public boolean addAll(int i, Collection<? extends String> collection2) {
        Object obj3;
        if (collection2 instanceof m) {
            obj3 = (m)collection2.k();
        }
        this.modCount = obj3++;
        return this.a.addAll(i, obj3);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList
    public void b(int i, String string2) {
        this.a.add(i, string2);
        this.modCount = obj2++;
    }

    @Override // java.util.AbstractList
    public void clear() {
        this.a.clear();
        this.modCount = modCount++;
    }

    @Override // java.util.AbstractList
    public Object get(int i) {
        return h(i);
    }

    @Override // java.util.AbstractList
    public String h(int i) {
        boolean z;
        boolean z2;
        Object obj = this.a.get(i);
        if (obj instanceof String != null) {
            return (String)obj;
        }
        String str = (d)obj.D();
        if (obj instanceof d && obj.t()) {
            str = (d)obj.D();
            if (obj.t()) {
                this.a.set(i, str);
            }
            return str;
        }
        String str2 = i.b((byte[])obj);
        if (i.a(obj)) {
            this.a.set(i, str2);
        }
        return str2;
    }

    @Override // java.util.AbstractList
    public String i(int i) {
        this.modCount = modCount++;
        return l.g(this.a.remove(i));
    }

    public List<?> k() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // java.util.AbstractList
    public String l(int i, String string2) {
        return l.g(this.a.set(i, string2));
    }

    @Override // java.util.AbstractList
    public kotlin.reflect.jvm.internal.impl.protobuf.m n() {
        u uVar = new u(this);
        return uVar;
    }

    @Override // java.util.AbstractList
    public kotlin.reflect.jvm.internal.impl.protobuf.d o1(int i) {
        Object obj;
        obj = this.a.get(i);
        final kotlin.reflect.jvm.internal.impl.protobuf.d dVar = l.d(obj);
        if (dVar != obj) {
            this.a.set(i, dVar);
        }
        return dVar;
    }

    @Override // java.util.AbstractList
    public Object remove(int i) {
        return i(i);
    }

    @Override // java.util.AbstractList
    public Object set(int i, Object object2) {
        return l(i, (String)object2);
    }

    @Override // java.util.AbstractList
    public int size() {
        return this.a.size();
    }
}
