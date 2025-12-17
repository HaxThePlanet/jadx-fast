package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class o {

    static final net.time4j.history.o d;
    private static final Comparator<net.time4j.history.o> e;
    private final List<net.time4j.history.o> a;
    private final net.time4j.history.n b;
    private final int c;

    static class a {
    }

    private static class b implements Comparator<net.time4j.history.o> {
        b(net.time4j.history.o.a o$a) {
            super();
        }

        @Override // java.util.Comparator
        public int a(net.time4j.history.o o, net.time4j.history.o o2) {
            int obj3;
            net.time4j.history.o obj4;
            obj3 = o.a(o) < o.a(o2) ? -1 : obj3 > obj4 ? 1 : 0;
            return obj3;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((o)object, (o)object2);
        }
    }
    static {
        o oVar = new o(n.BEGIN_OF_JANUARY, Integer.MAX_VALUE);
        o.d = oVar;
        o.b bVar = new o.b(0);
        o.e = bVar;
    }

    o(List<net.time4j.history.o> list) {
        int i2;
        Object next;
        int i;
        int i3;
        super();
        Collections.sort(list, o.e);
        Iterator iterator = list.iterator();
        i2 = 0;
        for (o next : iterator) {
            i2 = next;
            iterator.remove();
        }
        this.a = Collections.unmodifiableList(list);
        this.b = n.BEGIN_OF_JANUARY;
        this.c = Integer.MAX_VALUE;
    }

    o(net.time4j.history.n n, int i2) {
        super();
        this.a = Collections.emptyList();
        this.b = n;
        this.c = i2;
    }

    static int a(net.time4j.history.o o) {
        return o.c;
    }

    static net.time4j.history.o e(DataInput dataInput) {
        int bEGIN_OF_JANUARY;
        int i;
        net.time4j.history.n valueOf;
        int int;
        net.time4j.history.o oVar;
        int int2 = dataInput.readInt();
        net.time4j.history.n valueOf2 = n.valueOf(dataInput.readUTF());
        int obj6 = dataInput.readInt();
        if (int2 == 0 && obj6 == Integer.MAX_VALUE && valueOf2 == n.BEGIN_OF_JANUARY) {
            valueOf2 = n.valueOf(dataInput.readUTF());
            obj6 = dataInput.readInt();
            if (obj6 == Integer.MAX_VALUE) {
                if (valueOf2 == n.BEGIN_OF_JANUARY) {
                    return o.d;
                }
            }
            o oVar2 = new o(valueOf2, obj6);
            return oVar2;
        }
        ArrayList arrayList = new ArrayList(int2);
        i = 0;
        while (i < int2) {
            oVar = new o(n.valueOf(dataInput.readUTF()), dataInput.readInt());
            arrayList.add(oVar);
            i++;
        }
        obj6 = new o(arrayList);
        return obj6;
    }

    public net.time4j.history.o b(net.time4j.history.o o) {
        Object obj3;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        if (arrayList.isEmpty()) {
            arrayList.add(this);
        }
        if (o.a.isEmpty()) {
            arrayList.add(o);
        } else {
            arrayList.addAll(o.a);
        }
        obj3 = new o(arrayList);
        return obj3;
    }

    int c(net.time4j.history.h h) {
        int i2;
        int i;
        Object obj;
        int annoDomini = h.e().annoDomini(h.i());
        i2 = Integer.MIN_VALUE;
        i = 0;
        while (i < this.a.size()) {
            obj = this.a.get(i);
            i2 = obj.c;
            i++;
        }
        return this.b.displayedYear(this, h);
    }

    net.time4j.history.h d(net.time4j.history.j j, int i2) {
        return f(j, i2).newYear(j, i2);
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object list;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof o) {
            if (this.a.equals(object.a) && this.b == object.b && this.c == object.c) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    net.time4j.history.n f(net.time4j.history.j j, int i2) {
        int i4;
        int i;
        int i3;
        Enum obj5;
        int obj6;
        obj6 = j.annoDomini(i2);
        i4 = Integer.MIN_VALUE;
        i = 0;
        i3 = 0;
        while (i3 < this.a.size()) {
            Object obj = this.a.get(i3);
            i4 = obj.c;
            i = obj.b;
            i3++;
        }
        if (obj6 == i4 && j == j.BYZANTINE && i == n.BEGIN_OF_SEPTEMBER) {
            if (j == j.BYZANTINE) {
                if (i == n.BEGIN_OF_SEPTEMBER) {
                    return i;
                }
            }
        }
        return this.b;
    }

    void g(DataOutput dataOutput) {
        int i2;
        int i;
        String name;
        int size = this.a.size();
        dataOutput.writeInt(size);
        if (size == 0) {
            dataOutput.writeUTF(this.b.name());
            dataOutput.writeInt(this.c);
        }
        i2 = 0;
        while (i2 < size) {
            Object obj = this.a.get(i2);
            dataOutput.writeUTF(obj.b.name());
            dataOutput.writeInt(obj.c);
            i2++;
        }
    }

    public int hashCode() {
        return i3 += i7;
    }

    public String toString() {
        int i3;
        int i2;
        Iterator iterator;
        boolean next;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "->";
        i2 = 91;
        if (this.a.isEmpty()) {
            stringBuilder.append(i2);
            stringBuilder.append(this.b);
            if (this.c != Integer.MAX_VALUE) {
                stringBuilder.append(str);
                stringBuilder.append(this.c);
            }
        } else {
            i3 = 1;
            iterator = this.a.iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                if (i3 != 0) {
                } else {
                }
                stringBuilder.append(',');
                stringBuilder.append(next2.b);
                stringBuilder.append(str);
                stringBuilder.append(next2.c);
                stringBuilder.append(i2);
                i3 = 0;
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
