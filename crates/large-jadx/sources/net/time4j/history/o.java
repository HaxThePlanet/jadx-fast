package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: NewYearStrategy.java */
/* loaded from: classes3.dex */
public final class o {

    static final o d = new o();
    private static final Comparator<o> e = new o$b<>(0);
    private final List<o> a;
    private final n b;
    private final int c;

    static class a {
    }

    private static class b implements Comparator<o> {
        private b() {
            super();
        }

        public int a(o oVar, o oVar2) {
            int i = -1;
            if (oVar.c < oVar2.c) {
                i = -1;
            } else {
                oVar = oVar.c > oVar2.c ? 1 : 0;
            }
            return (oVar.c > oVar2.c ? 1 : 0);
        }

        /* synthetic */ b(o.a aVar) {
            this();
        }
    }
    static {
    }

    o(n nVar, int i) {
        super();
        this.a = Collections.emptyList();
        this.b = nVar;
        this.c = i;
    }

    static /* synthetic */ int a(o oVar) {
        return oVar.c;
    }

    static o e(DataInput dataInput) throws java.io.IOException {
        int i2 = 0;
        int _int2 = dataInput.readInt();
        if (_int2 == 0) {
            net.time4j.history.n str2 = n.valueOf(dataInput.readUTF());
            int _int3 = dataInput.readInt();
            int i = Integer.MAX_VALUE;
            if (_int3 == Integer.MAX_VALUE && str2 == n.BEGIN_OF_JANUARY) {
                return o.d;
            }
            return new o(str2, _int3);
        }
        ArrayList arrayList = new ArrayList(_int2);
        i2 = 0;
        while (i2 < _int2) {
            arrayList.add(new o(n.valueOf(dataInput.readUTF()), dataInput.readInt()));
            i2 = i2 + 1;
        }
        return new o(arrayList);
    }

    public o b(o oVar) {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        if (arrayList.isEmpty()) {
            arrayList.add(this);
        }
        if (oVar.a.isEmpty()) {
            arrayList.add(oVar);
        } else {
            arrayList.addAll(oVar.a);
        }
        return new o(arrayList);
    }

    int c(h hVar) {
        int i = -2147483648;
        int i2 = 0;
        int annoDomini = hVar.e().annoDomini(hVar.i());
        i = Integer.MIN_VALUE;
        i2 = 0;
        while (i2 < this.a.size()) {
            Object item = this.a.get(i2);
            if (annoDomini >= item.c && annoDomini < item.c) {
            }
        }
        return this.b.displayedYear(this, hVar);
    }

    h d(j jVar, int i) {
        return f(jVar, i).newYear(jVar, i);
    }

    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        List list;
        int i2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof o) {
            if (this.a.equals(object.a)) {
                if (this.b == object.b) {
                    if (this.c != object.c) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    n f(j jVar, int i) {
        int i3 = 0;
        int i4 = 0;
        int annoDomini = jVar.annoDomini(i);
        i = Integer.MIN_VALUE;
        i3 = 0;
        i4 = 0;
        while (i4 < this.a.size()) {
            Object item = this.a.get(i4);
            if (annoDomini >= item.c && annoDomini < item.c) {
            }
        }
        if (j.BYZANTINE == item.c && n.BEGIN_OF_SEPTEMBER == j.BYZANTINE && this.a == n.BEGIN_OF_SEPTEMBER) {
            return i3;
        }
        return this.b;
    }

    void g(DataOutput dataOutput) throws java.io.IOException {
        int i = 0;
        int size = this.a.size();
        dataOutput.writeInt(size);
        if (size == 0) {
            dataOutput.writeUTF(this.b.name());
            dataOutput.writeInt(this.c);
            return;
        }
        i = 0;
        while (i < size) {
            Object item = this.a.get(i);
            dataOutput.writeUTF(item.b.name());
            dataOutput.writeInt(item.c);
            i = i + 1;
        }
    }

    public int hashCode() {
        return (this.a.hashCode() * 17) + (this.b.hashCode() * 37) + this.c;
    }

    public String toString() {
        int i = 1;
        net.time4j.history.n nVar;
        StringBuilder stringBuilder = new StringBuilder();
        final String str2 = "->";
        char c = '[';
        if (!this.a.isEmpty()) {
            i = 1;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                stringBuilder.append(item.b);
                stringBuilder.append(str2);
                stringBuilder.append(item.c);
            }
        } else {
            stringBuilder.append(c);
            stringBuilder.append(this.b);
            if (this.c != Integer.MAX_VALUE) {
                stringBuilder.append(str2);
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    o(List<o> list) {
        int i = 0;
        net.time4j.history.n nVar;
        int i2;
        super();
        Collections.sort(list, o.e);
        Iterator it = list.iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            if (i != 0) {
            }
        }
        this.a = Collections.unmodifiableList(list);
        this.b = n.BEGIN_OF_JANUARY;
        this.c = Integer.MAX_VALUE;
    }
}
