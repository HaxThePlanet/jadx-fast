package net.time4j.tz.model;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.time4j.c0;
import net.time4j.f1.c;
import net.time4j.h0;
import net.time4j.tz.p;
import net.time4j.x0;

/* compiled from: SPX.java */
/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final long serialVersionUID = 6526945678752534989L;
    private transient Object a;
    private transient int b;
    private static Object a(ObjectInput objectInput) {
        final boolean z = false;
        return new a(SPX.j(objectInput), z, z);
    }

    private static Object b(ObjectInput objectInput) {
        final List list = SPX.j(objectInput);
        final int i = 0;
        return l.g(p.u((q)list.get(i).j()), list, SPX.h(objectInput), false, false);
    }

    private static d c(DataInput dataInput) throws java.io.IOException {
        int i;
        int dataInput2;
        boolean z;
        int i4 = dataInput.readByte() & 255;
        i4 &= 15;
        int i7 = dataInput.readByte() & 255;
        int i9 = dataInput.readByte() & 255;
        i2 = i9 >>> 7;
        int i3 = 1;
        i3 = i9 >>> 7 == i3 ? i3 : i2;
        int i11 = 63;
        dataInput2 = i9 & i11;
        if (SPX.i(i5) == -1) {
            i = SPX.f(dataInput);
        }
        dataInput2 = i.VALUES == i11 ? dataInput2 : dataInput2;
        c dataInput3 = new c(c0.valueOf(i4 >>> 4), i7 >>> 3, x0.valueOf(i7 & 7), dataInput2, i.VALUES[i5 % 3], i, z);
        return dataInput3;
    }

    private static d d(DataInput dataInput) throws java.io.IOException {
        int i;
        int dataInput2;
        int i2 = dataInput.readByte() & 255;
        i2 &= 15;
        int i5 = dataInput.readByte() & 255;
        dataInput2 = SPX.n(i5 & 7);
        int i8 = -1;
        if (SPX.i(i3) == i8) {
            i = SPX.f(dataInput);
        }
        dataInput2 = dataInput2 == i8 ? dataInput2 : dataInput2;
        f dataInput3 = new f(c0.valueOf(i2 >>> 4), i5 >>> 3, dataInput2, i.VALUES[i3 % 3], i);
        return dataInput3;
    }

    private static d e(DataInput dataInput) throws java.io.IOException {
        int i;
        int dataInput2;
        int i2 = dataInput.readByte() & 255;
        i2 &= 15;
        int i5 = dataInput.readByte() & 255;
        int i8 = 31;
        dataInput2 = i5 & i8;
        if (SPX.i(i3) == -1) {
            i = SPX.f(dataInput);
        }
        dataInput2 = i.VALUES == i8 ? dataInput2 : dataInput2;
        h dataInput3 = new h(c0.valueOf(i2 >>> 4), x0.valueOf(i5 >>> 5), dataInput2, i.VALUES[i3 % 3], i);
        return dataInput3;
    }

    private static int f(DataInput dataInput) throws java.io.IOException {
        byte _byte = dataInput.readByte();
        if (_byte == 127) {
            return dataInput.readInt();
        }
        return _byte * 900;
    }

    private static Object g(ObjectInput objectInput) {
        long _long;
        int i = 255;
        int i2 = objectInput.readByte() & i;
        if (i2 == i) {
            _long = objectInput.readLong();
        } else {
            i = i & objectInput.readByte();
            long l = -4575744000L;
            _long = (long)(i2 << 16) + (objectInput.readByte() & i) << 8 + i * 900L + l;
        }
        q qVar = new q(_long, i10, SPX.f(objectInput), SPX.f(objectInput), SPX.f(objectInput));
        return new j(qVar, SPX.h(objectInput), false);
    }

    private static List<d> h(ObjectInput objectInput) throws InvalidObjectException, java.io.IOException, java.lang.ClassNotFoundException {
        net.time4j.tz.model.d dVar = null;
        int i = 0;
        net.time4j.tz.model.k iNSTANCE2;
        byte _byte = objectInput.readByte();
        if (_byte == 0) {
            return Collections.emptyList();
        }
        final ArrayList arrayList = new ArrayList(_byte);
        int i2 = 0;
        i = 0;
        while (i < _byte) {
            Object object = objectInput.readObject();
            if (dVar != null) {
            }
            dVar = SPX.e(objectInput);
            dVar = SPX.c(objectInput);
            dVar = SPX.d(objectInput);
        }
        return arrayList;
    }

    private static int i(int i) {
        final int i2 = 3;
        i /= i2;
        if (i5 != 0 && i5 != 1) {
            if (i5 != 2 && i5 != i2) {
                return -1;
            }
            return 3600;
        }
        return 0;
    }

    private static List<net.time4j.tz.q> j(ObjectInput objectInput) throws StreamCorruptedException {
        int i;
        long _long = -9223372036854775808L;
        int cmp = 7200;
        long l;
        int i3 = 0;
        int i4 = 0;
        long l2;
        int _int = objectInput.readInt();
        if (_int == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(_int);
        _long = Long.MIN_VALUE;
        i4 = 0;
        while (i4 < _int) {
            byte _byte = objectInput.readByte();
            i3 = 1;
            int r8 = _byte < 0 ? i3 : 0;
            int i13 = 3;
            int i12 = (_byte >>> 5) & i13;
            int i16 = SPX.o(_byte >>> 2 & 7);
            if (_long <= _long) {
                throw new StreamCorruptedException("Wrong order of transitions.");
            }
        }
        return arrayList;
    }

    private static int m(g gVar) {
        return gVar.f().e(h0.R) + (c.g(gVar.c() * 86400L));
    }

    private static void p(Object object, ObjectOutput objectOutput) {
        object.u(objectOutput);
    }

    private static void q(Object object, ObjectOutput objectOutput) {
        object.l(objectOutput);
        SPX.x(object.k(), objectOutput);
    }

    private static void r(Object object, DataOutput dataOutput) throws java.io.IOException {
        int i = 128;
        int i2;
        dataOutput.writeByte((object.m() << 3) | object.n() & 255);
        i = 0;
        int r1 = object.o() ? 128 : 0;
        final int i10 = SPX.m(object);
        if (i10 % 1800 == 0) {
            i2 = i | (i10 / 1800);
            i = 1;
        } else {
            i2 = i | 63;
        }
        dataOutput.writeByte(i2 & 255);
        if (!SPX.u(object, dataOutput)) {
            SPX.v(dataOutput, object.e());
        }
        if (i == 0) {
            dataOutput.writeInt(i10);
        }
    }

    private Object readResolve() {
        return this.a;
    }

    private static void s(Object object, DataOutput dataOutput) throws java.io.IOException {
        final int i6 = SPX.m(object);
        final int i7 = SPX.k(i6);
        dataOutput.writeByte((object.m() << 3) | i7 & 255);
        if (!SPX.u(object, dataOutput)) {
            SPX.v(dataOutput, object.e());
        }
        if (i7 == 0) {
            dataOutput.writeInt(i6);
        }
    }

    private static void t(Object object, DataOutput dataOutput) throws java.io.IOException {
        int i;
        int i2 = 0;
        int i4 = object.m() << 5;
        final int i6 = SPX.m(object);
        if (i6 % 3600 == 0) {
            i = i4 | (i6 / 3600);
            i2 = 1;
        } else {
            i = i4 | 31;
            i2 = 0;
        }
        dataOutput.writeByte(i & 255);
        if (!SPX.u(object, dataOutput)) {
            SPX.v(dataOutput, object.e());
        }
        if (i2 == 0) {
            dataOutput.writeInt(i6);
        }
    }

    private static boolean u(g gVar, DataOutput dataOutput) throws java.io.IOException {
        int ordinal;
        boolean z = true;
        ordinal = gVar.d().ordinal();
        int i5 = gVar.e();
        int i3 = 1;
        if (i5 != 0 && i5 != 1800 && i5 != 3600 && i5 != 7200) {
            int i4 = 0;
            ordinal = ordinal + 12;
        }
        dataOutput.writeByte((gVar.k() << 4) | ordinal & 255);
        return z;
    }

    private static void v(DataOutput dataOutput, int i) throws java.io.IOException {
        i = i % 900;
        if (i % 900 == 0) {
            i3 = i / 900;
            dataOutput.writeByte(i3);
        } else {
            i = 127;
            dataOutput.writeByte(i);
            dataOutput.writeInt(i);
        }
    }

    private static void w(Object object, ObjectOutput objectOutput) {
        int cmp;
        long l = 10464767099L;
        long l2;
        long l3 = 0;
        net.time4j.tz.q qVar = object.l();
        long l4 = qVar.i();
        final long l8 = -4575744000L;
        final int i10 = 255;
        if (l4 >= l8) {
            l = 10464767099L;
            if (l4 < l) {
                l = 900L;
                l2 = l4 % l;
                l3 = 0L;
                if (l2 == l3) {
                    int i4 = (int)(l4 - (-4575744000L)) / 900L;
                    objectOutput.writeByte((i4 >>> 16) & i10);
                    i2 = (i4 >>> 8) & i10;
                    objectOutput.writeByte(i2);
                    i = i4 & i10;
                    objectOutput.writeByte(i);
                } else {
                    objectOutput.writeByte(i10);
                    objectOutput.writeLong(qVar.i());
                }
            }
        }
        SPX.v(objectOutput, qVar.j());
        SPX.v(objectOutput, qVar.n());
        SPX.v(objectOutput, qVar.f());
        SPX.x(object.n(), objectOutput);
    }

    private static void x(List<d> list, ObjectOutput objectOutput) throws java.io.IOException {
        objectOutput.writeByte(list.size());
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            objectOutput.writeByte(item.g());
            objectOutput.writeObject(item);
            SPX.t(item, objectOutput);
            SPX.r(item, objectOutput);
            SPX.s(item, objectOutput);
        }
    }

    private static int y(net.time4j.tz.q qVar, int i, DataOutput dataOutput) throws java.io.IOException {
        byte b2;
        final int i5 = qVar.m();
        i = 1;
        i = 0;
        int r3 = i5 != i ? 1 : i;
        b2 = i != 0 ? (byte)128 : i;
        final int i12 = qVar.f();
        i = 3;
        if (i12 != 0 && i12 != 3600 && i12 != 7200) {
        }
        l = (qVar.i() + (long)i) + 7200L;
        long l2 = -4575744000L;
        if (l >= l2 && l < l3) {
            i = SPX.l(c.d(l, 86400));
        }
        byte b4 = (byte)(i << 2) | (byte)(b2 | (i << 5));
        if (i == 0) {
            dataOutput.writeByte(b4);
            dataOutput.writeLong(qVar.i());
        } else {
            l2 = 86400L;
            l = (l - (-4575744000L)) / l2;
            int i15 = (int)l;
            b = (byte)(i15 >>> 16) & i;
            dataOutput.writeByte((byte)(b4 | b));
            i4 = (i15 >>> 8) & 255;
            dataOutput.writeByte(i4);
            i3 = i15 & 255;
            dataOutput.writeByte(i3);
        }
        if (i == 0) {
            SPX.v(dataOutput, i12);
        }
        if (i != 0) {
            SPX.v(dataOutput, i5);
        }
        return i5;
    }

    static void z(net.time4j.tz.q[] qVarArr, int i, DataOutput dataOutput) throws java.io.IOException {
        int length = 0;
        int i3;
        net.time4j.tz.q qVar;
        length = qVarArr.length;
        final int min = Math.min(i, length);
        dataOutput.writeInt(min);
        if (min > 0) {
            length = 0;
            SPX.v(dataOutput, qVarArr[i].j());
            while (qVarArr.length < min) {
                i3 = SPX.y(qVarArr[length], i3, dataOutput);
                length = length + 1;
            }
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws StreamCorruptedException {
        switch (objectInput.readByte()) {
            case 120:
                this.a = SPX.d(objectInput);
                break;
            case 121:
                this.a = SPX.c(objectInput);
                break;
            case 122:
                this.a = SPX.e(objectInput);
                break;
            case 123:
                throw new StreamCorruptedException("Unknown serialized type.");
            case 124:
                this.a = SPX.g(objectInput);
                break;
            case 125:
                this.a = SPX.a(objectInput);
                break;
            default:
                this.a = SPX.b(objectInput);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws InvalidClassException {
        objectOutput.writeByte(this.b);
        switch (this.b) {
            case 120:
                SPX.s(this.a, objectOutput);
                break;
            case 121:
                SPX.r(this.a, objectOutput);
                break;
            case 122:
                SPX.t(this.a, objectOutput);
                break;
            case 123:
                throw new InvalidClassException("Unknown serialized type.");
            case 124:
                SPX.w(this.a, objectOutput);
                break;
            case 125:
                SPX.p(this.a, objectOutput);
                break;
            default:
                SPX.q(this.a, objectOutput);
        }
    }

    SPX(Object object, int i) {
        super();
        this.a = object;
        this.b = i;
    }

    private static int k(int i) {
        if (i != 0 && i != 3600) {
            if (i != 7200 && i != 10800) {
                if (i != 79200 && i != 82800) {
                    if (i != 86400) {
                        return 0;
                    }
                    return 7;
                }
                return 5;
            }
            return 3;
        }
        return 1;
    }

    private static int l(int i) {
        if (i != 0 && i != 60) {
            if (i != 3600 && i != 7200) {
                if (i != 10800 && i != 14400) {
                    if (i != 18000) {
                        return 0;
                    }
                    return 7;
                }
                return 5;
            }
            return 3;
        }
        return 1;
    }

    private static int n(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 3600;
            case 3:
                return 7200;
            case 4:
                return 10800;
            case 5:
                return 79200;
            case 6:
                return 82800;
            case 7:
                return 86400;
            default:
                return -1;
        }
    }

    private static int o(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 60;
            case 3:
                return 3600;
            case 4:
                return 7200;
            case 5:
                return 10800;
            case 6:
                return 14400;
            case 7:
                return 18000;
            default:
                return -1;
        }
    }
}
