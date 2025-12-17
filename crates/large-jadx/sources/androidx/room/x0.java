package androidx.room;

import d.s.a.i;
import d.s.a.j;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class x0 implements j, i {

    static final TreeMap<Integer, androidx.room.x0> A;
    private volatile String a;
    final long[] b;
    final double[] c;
    final String[] v;
    final byte[][] w;
    private final int[] x;
    final int y;
    int z;
    static {
        TreeMap treeMap = new TreeMap();
        x0.A = treeMap;
    }

    private x0(int i) {
        super();
        this.y = i;
        i++;
        this.x = new int[obj2];
        this.b = new long[obj2];
        this.c = new double[obj2];
        this.v = new String[obj2];
        this.w = new byte[obj2];
    }

    public static androidx.room.x0 e(String string, int i2) {
        TreeMap map = x0.A;
        Map.Entry ceilingEntry = map.ceilingEntry(Integer.valueOf(i2));
        synchronized (map) {
            map.remove(ceilingEntry.getKey());
            Object value = ceilingEntry.getValue();
            (x0)value.f(string, i2);
            return value;
        }
    }

    private static void i() {
        Object iterator;
        int size;
        int i;
        iterator = x0.A;
        if (iterator.size() > 15) {
            size2 += -10;
            iterator = iterator.descendingKeySet().iterator();
            while (size > 0) {
                iterator.next();
                iterator.remove();
                size = i;
            }
        }
    }

    @Override // d.s.a.j
    public void B0(int i, byte[] b2Arr2) {
        this.x[i] = 5;
        this.w[i] = b2Arr2;
    }

    @Override // d.s.a.j
    public void D(int i, String string2) {
        this.x[i] = 4;
        this.v[i] = string2;
    }

    @Override // d.s.a.j
    public void W(int i, double d2) {
        this.x[i] = 3;
        this.c[i] = d2;
    }

    @Override // d.s.a.j
    public String a() {
        return this.a;
    }

    @Override // d.s.a.j
    public void c(i i) {
        int i2;
        long[] lArr;
        long l;
        final int i3 = 1;
        i2 = i3;
        while (i2 <= this.z) {
            lArr = this.x[i2];
            if (lArr != i3) {
            } else {
            }
            i.k1(i2);
            i2++;
            if (lArr != 2) {
            } else {
            }
            i.u0(i2, this.b[i2]);
            if (lArr != 3) {
            } else {
            }
            i.W(i2, this.c[i2]);
            if (lArr != 4) {
            } else {
            }
            i.D(i2, this.v[i2]);
            if (lArr != 5) {
            } else {
            }
            i.B0(i2, this.w[i2]);
        }
    }

    @Override // d.s.a.j
    public void close() {
    }

    @Override // d.s.a.j
    void f(String string, int i2) {
        this.a = string;
        this.z = i2;
    }

    @Override // d.s.a.j
    public void j() {
        final TreeMap map = x0.A;
        map.put(Integer.valueOf(this.y), this);
        x0.i();
        return;
        synchronized (map) {
            map = x0.A;
            map.put(Integer.valueOf(this.y), this);
            x0.i();
        }
    }

    @Override // d.s.a.j
    public void k1(int i) {
        this.x[i] = 1;
    }

    @Override // d.s.a.j
    public void u0(int i, long l2) {
        this.x[i] = 2;
        this.b[i] = l2;
    }
}
