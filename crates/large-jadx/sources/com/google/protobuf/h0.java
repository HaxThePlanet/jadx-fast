package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public class h0 extends com.google.protobuf.c<String> implements com.google.protobuf.i0, RandomAccess {

    private static final com.google.protobuf.h0 c;
    private final List<Object> b;
    static {
        h0 h0Var = new h0();
        h0.c = h0Var;
        h0Var.F();
    }

    public h0() {
        super(10);
    }

    public h0(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(arrayList);
    }

    private h0(ArrayList<Object> arrayList) {
        super();
        this.b = arrayList;
    }

    private static String g(Object object) {
        if (object instanceof String != null) {
            return (String)object;
        }
        if (object instanceof j) {
            return (j)object.R();
        }
        return c0.j((byte[])object);
    }

    @Override // com.google.protobuf.c
    public Object O1(int i) {
        return this.b.get(i);
    }

    @Override // com.google.protobuf.c
    public void T(com.google.protobuf.j j) {
        b();
        this.b.add(j);
        this.modCount = obj2++;
    }

    @Override // com.google.protobuf.c
    public void add(int i, Object object2) {
        d(i, (String)object2);
    }

    public boolean addAll(int i, Collection<? extends String> collection2) {
        Object obj3;
        b();
        if (collection2 instanceof i0) {
            obj3 = (i0)collection2.k();
        }
        this.modCount = obj3++;
        return this.b.addAll(i, obj3);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.c
    public com.google.protobuf.c0.j c(int i) {
        return i(i);
    }

    @Override // com.google.protobuf.c
    public void clear() {
        b();
        this.b.clear();
        this.modCount = modCount++;
    }

    @Override // com.google.protobuf.c
    public void d(int i, String string2) {
        b();
        this.b.add(i, string2);
        this.modCount = obj2++;
    }

    @Override // com.google.protobuf.c
    public Object get(int i) {
        return h(i);
    }

    @Override // com.google.protobuf.c
    public String h(int i) {
        boolean z;
        boolean z2;
        Object obj = this.b.get(i);
        if (obj instanceof String != null) {
            return (String)obj;
        }
        String str = (j)obj.R();
        if (obj instanceof j && obj.B()) {
            str = (j)obj.R();
            if (obj.B()) {
                this.b.set(i, str);
            }
            return str;
        }
        String str2 = c0.j((byte[])obj);
        if (c0.g(obj)) {
            this.b.set(i, str2);
        }
        return str2;
    }

    @Override // com.google.protobuf.c
    public com.google.protobuf.h0 i(int i) {
        if (i < size()) {
        } else {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            h0 obj2 = new h0(arrayList);
            return obj2;
        }
        obj2 = new IllegalArgumentException();
        throw obj2;
    }

    public List<?> k() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.protobuf.c
    public String l(int i) {
        b();
        this.modCount = modCount++;
        return h0.g(this.b.remove(i));
    }

    @Override // com.google.protobuf.c
    public String m(int i, String string2) {
        b();
        return h0.g(this.b.set(i, string2));
    }

    @Override // com.google.protobuf.c
    public com.google.protobuf.i0 n() {
        if (c2()) {
            v1 v1Var = new v1(this);
            return v1Var;
        }
        return this;
    }

    @Override // com.google.protobuf.c
    public Object remove(int i) {
        return l(i);
    }

    @Override // com.google.protobuf.c
    public Object set(int i, Object object2) {
        return m(i, (String)object2);
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.b.size();
    }
}
