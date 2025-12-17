package androidx.coordinatorlayout.widget;

import d.e.g;
import d.h.k.f;
import d.h.k.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a<T>  {

    private final f<ArrayList<T>> a;
    private final g<T, ArrayList<T>> b;
    private final ArrayList<T> c;
    private final HashSet<T> d;
    public a() {
        super();
        g gVar = new g(10);
        this.a = gVar;
        g gVar2 = new g();
        this.b = gVar2;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        HashSet hashSet = new HashSet();
        this.d = hashSet;
    }

    private void e(T t, ArrayList<T> arrayList2, HashSet<T> hashSet3) {
        int i;
        int size;
        Object obj;
        if (arrayList2.contains(t)) {
        }
        if (hashSet3.contains(t)) {
        } else {
            hashSet3.add(t);
            Object obj2 = this.b.get(t);
            if ((ArrayList)obj2 != null) {
                i = 0;
                while (i < (ArrayList)obj2.size()) {
                    e(obj2.get(i), arrayList2, hashSet3);
                    i++;
                }
            }
            hashSet3.remove(t);
            arrayList2.add(t);
        }
        RuntimeException obj5 = new RuntimeException("This graph contains cyclic dependencies");
        throw obj5;
    }

    private ArrayList<T> f() {
        Object arrayList;
        if ((ArrayList)this.a.b() == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.a(arrayList);
    }

    public void a(T t, T t2) {
        boolean key;
        Object obj;
        g gVar;
        if (!this.b.containsKey(t)) {
        } else {
            if (!this.b.containsKey(t2)) {
            } else {
                if ((ArrayList)this.b.get(t) == null) {
                    this.b.put(t, f());
                }
                obj.add(t2);
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        throw obj3;
    }

    public void b(T t) {
        boolean key;
        int i;
        if (!this.b.containsKey(t)) {
            this.b.put(t, 0);
        }
    }

    public void c() {
        int i;
        Object obj;
        i = 0;
        while (i < this.b.size()) {
            obj = this.b.n(i);
            if ((ArrayList)obj != null) {
            }
            i++;
            k((ArrayList)obj);
        }
        this.b.clear();
    }

    public boolean d(T t) {
        return this.b.containsKey(t);
    }

    public List g(T t) {
        return (List)this.b.get(t);
    }

    public List<T> h(T t) {
        int arrayList;
        int i;
        Object contains;
        arrayList = 0;
        i = 0;
        while (i < this.b.size()) {
            contains = this.b.n(i);
            if (contains != null && (ArrayList)contains.contains(t) && arrayList == null) {
            }
            i++;
            if (contains.contains(t)) {
            }
            if (arrayList == null) {
            }
            arrayList.add(this.b.j(i));
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        int i;
        Object obj;
        ArrayList list;
        HashSet set;
        this.c.clear();
        this.d.clear();
        i = 0;
        while (i < this.b.size()) {
            e(this.b.j(i), this.c, this.d);
            i++;
        }
        return this.c;
    }

    public boolean j(T t) {
        int i;
        Object contains;
        final int i2 = 0;
        i = i2;
        while (i < this.b.size()) {
            contains = this.b.n(i);
            i++;
        }
        return i2;
    }
}
