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
import net.time4j.engine.q;
import net.time4j.f1.c;
import net.time4j.h0;
import net.time4j.tz.p;
import net.time4j.tz.q;
import net.time4j.x0;

/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final long serialVersionUID = 6526945678752534989L;
    private transient Object a;
    private transient int b;
    SPX(Object object, int i2) {
        super();
        this.a = object;
        this.b = i2;
    }

    private static Object a(ObjectInput objectInput) {
        final int i = 0;
        a aVar = new a(SPX.j(objectInput), i, i);
        return aVar;
    }

    private static Object b(ObjectInput objectInput) {
        final List list = SPX.j(objectInput);
        final int i = 0;
        return l.g(p.u((q)list.get(i).j()), list, SPX.h(objectInput), i, i);
    }

    private static net.time4j.tz.model.d c(DataInput dataInput) {
        int i3;
        int i2;
        int i4;
        int i5;
        int i;
        DataInput obj10;
        byte &= 255;
        i6 &= 15;
        byte2 &= 255;
        byte3 &= 255;
        int i15 = 1;
        i = i11 >>> 7 == i15 ? i15 : i4;
        int i13 = 63;
        i11 &= i13;
        if (SPX.i(i7) == -1) {
            i3 = SPX.f(dataInput);
        }
        if (i2 == i13) {
            i5 = obj10;
        } else {
            i5 = i2;
        }
        super(c0.valueOf(i6 >>> 4), i9 >>> 3, x0.valueOf(i9 &= 7), i5, i.VALUES[i7 % 3], i3, i);
        return obj10;
    }

    private static net.time4j.tz.model.d d(DataInput dataInput) {
        int i;
        int i2;
        int obj10;
        byte &= 255;
        i3 &= 15;
        byte2 &= 255;
        int i8 = SPX.n(i6 &= 7);
        int i10 = -1;
        if (SPX.i(i4) == i10) {
            i = SPX.f(dataInput);
        }
        if (i8 == i10) {
            i2 = obj10;
        } else {
            i2 = i8;
        }
        super(c0.valueOf(i3 >>> 4), i6 >>> 3, i2, i.VALUES[i4 % 3], i);
        return obj10;
    }

    private static net.time4j.tz.model.d e(DataInput dataInput) {
        int i;
        int i2;
        int i3;
        int obj8;
        byte &= 255;
        i4 &= 15;
        byte2 &= 255;
        int i10 = 31;
        i7 &= i10;
        if (SPX.i(i5) == -1) {
            i = SPX.f(dataInput);
        }
        if (i2 == i10) {
            i3 = obj8;
        } else {
            i3 = i2;
        }
        super(c0.valueOf(i4 >>> 4), x0.valueOf(i7 >>> 5), i3, i.VALUES[i5 % 3], i);
        return obj8;
    }

    private static int f(DataInput dataInput) {
        byte byte = dataInput.readByte();
        if (byte == 127) {
            return dataInput.readInt();
        }
        return byte *= 900;
    }

    private static Object g(ObjectInput objectInput) {
        long long;
        int i;
        long l;
        byte byte;
        i = 255;
        byte2 &= i;
        if (i2 == i) {
            long = objectInput.readLong();
        } else {
            i6 += l;
        }
        super(long, obj4, SPX.f(objectInput), SPX.f(objectInput), SPX.f(objectInput));
        j jVar = new j(qVar, SPX.h(objectInput), 0);
        return jVar;
    }

    private static List<net.time4j.tz.model.d> h(ObjectInput objectInput) {
        int compare;
        int i;
        net.time4j.tz.model.d object;
        net.time4j.tz.model.k iNSTANCE;
        byte byte = objectInput.readByte();
        if (byte == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(byte);
        compare = 0;
        i = 0;
        while (i < byte) {
            object = objectInput.readObject();
            arrayList.add(object);
            i++;
            compare = object;
            object = SPX.e(objectInput);
            object = SPX.c(objectInput);
            object = SPX.d(objectInput);
        }
        return arrayList;
    }

    private static int i(int i) {
        final int i2 = 3;
        i /= i2;
        if (obj2 != null && obj2 != 1 && obj2 != 2 && obj2 != i2) {
            if (obj2 != 1) {
                if (obj2 != 2) {
                    if (obj2 != i2) {
                        return -1;
                    }
                    return 7200;
                }
                return 3600;
            }
            return 1800;
        }
        return 0;
    }

    private static List<q> j(ObjectInput objectInput) {
        int i4;
        long l2;
        int cmp;
        int i;
        q qVar2;
        long l;
        q qVar;
        int byte;
        int i5;
        int i3;
        int i9;
        int i2;
        int i8;
        int i6;
        int long;
        int i7;
        long l3;
        int int = objectInput.readInt();
        if (int == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(int);
        l2 = Long.MIN_VALUE;
        i9 = i4;
        i6 = 0;
        while (i6 < int) {
            byte = objectInput.readByte();
            int i17 = 1;
            if (byte < 0) {
            } else {
            }
            i3 = 0;
            int i20 = 3;
            i18 &= i20;
            int i23 = SPX.o(i21 &= 7);
            if (i23 == -1) {
            } else {
            }
            long = i7;
            if (i19 != i17) {
            } else {
            }
            i8 = 0;
            if (i3 != 0) {
            }
            if (i8 == Integer.MAX_VALUE) {
            } else {
            }
            i = i8;
            i += i4;
            super(long, i3, i9, i12, i8);
            arrayList.add(qVar2);
            i6++;
            i9 = i12;
            l2 = long;
            i = 0;
            i4 = SPX.f(objectInput);
            if (i19 != 2) {
            } else {
            }
            cmp = 3600;
            i8 = cmp;
            if (i19 != i20) {
            } else {
            }
            cmp = 7200;
            cmp = SPX.f(objectInput);
            long = objectInput.readLong();
            i3 = i17;
        }
        return arrayList;
    }

    private static int k(int i) {
        if (i != 0 && i != 3600 && i != 7200 && i != 10800 && i != 79200 && i != 82800 && i != 86400) {
            if (i != 3600) {
                if (i != 7200) {
                    if (i != 10800) {
                        if (i != 79200) {
                            if (i != 82800) {
                                if (i != 86400) {
                                    return 0;
                                }
                                return 7;
                            }
                            return 6;
                        }
                        return 5;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private static int l(int i) {
        if (i != 0 && i != 60 && i != 3600 && i != 7200 && i != 10800 && i != 14400 && i != 18000) {
            if (i != 60) {
                if (i != 3600) {
                    if (i != 7200) {
                        if (i != 10800) {
                            if (i != 14400) {
                                if (i != 18000) {
                                    return 0;
                                }
                                return 7;
                            }
                            return 6;
                        }
                        return 5;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private static int m(net.time4j.tz.model.g g) {
        return i += obj5;
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

    private static void p(Object object, ObjectOutput objectOutput2) {
        (a)object.u(objectOutput2);
    }

    private static void q(Object object, ObjectOutput objectOutput2) {
        (b)object.l(objectOutput2);
        SPX.x(object.k(), objectOutput2);
    }

    private static void r(Object object, DataOutput dataOutput2) {
        int i3;
        int i;
        int i2;
        net.time4j.tz.model.g obj5;
        dataOutput2.writeByte(i6 &= 255);
        i3 = object.o() ? 128 : i2;
        final int i10 = SPX.m(object);
        if (i10 % 1800 == 0) {
            i3 |= i9;
            i2 = 1;
        } else {
            i3 |= 63;
        }
        dataOutput2.writeByte(i &= 255);
        if (!SPX.u((c)object, dataOutput2)) {
            SPX.v(dataOutput2, object.e());
        }
        if (i2 == 0) {
            dataOutput2.writeInt(i10);
        }
    }

    private Object readResolve() {
        return this.a;
    }

    private static void s(Object object, DataOutput dataOutput2) {
        net.time4j.tz.model.g obj4;
        final int i5 = SPX.m(object);
        final int i6 = SPX.k(i5);
        dataOutput2.writeByte(i3 &= 255);
        if (!SPX.u((f)object, dataOutput2)) {
            SPX.v(dataOutput2, object.e());
        }
        if (i6 == 0) {
            dataOutput2.writeInt(i5);
        }
    }

    private static void t(Object object, DataOutput dataOutput2) {
        int i2;
        int i;
        net.time4j.tz.model.g obj4;
        b <<= 5;
        final int i5 = SPX.m(object);
        if (i5 % 3600 == 0) {
            i3 |= i7;
            i = 1;
        } else {
            i3 |= 31;
            i = 0;
        }
        dataOutput2.writeByte(i2 &= 255);
        if (!SPX.u((h)object, dataOutput2)) {
            SPX.v(dataOutput2, object.e());
        }
        if (i == 0) {
            dataOutput2.writeInt(i5);
        }
    }

    private static boolean u(net.time4j.tz.model.g g, DataOutput dataOutput2) {
        int ordinal;
        int i2;
        int i;
        ordinal = g.d().ordinal();
        int obj4 = g.e();
        i2 = 1;
        if (obj4 != null) {
            if (obj4 != 1800) {
                if (obj4 != 3600) {
                    ordinal = obj4 != 7200 ? ordinal + 12 : ordinal + 9;
                } else {
                    ordinal += 6;
                }
            } else {
                ordinal += 3;
            }
        }
        dataOutput2.writeByte(obj4 &= 255);
        return i2;
    }

    private static void v(DataOutput dataOutput, int i2) {
        int i;
        int obj2;
        if (i2 % 900 == 0) {
            dataOutput.writeByte(i2 /= 900);
        } else {
            dataOutput.writeByte(127);
            dataOutput.writeInt(i2);
        }
    }

    private static void w(Object object, ObjectOutput objectOutput2) {
        int i2;
        int i3;
        int cmp;
        int l;
        int i;
        int i4;
        q qVar = (j)object.l();
        long l2 = qVar.i();
        final long l3 = -4575744000L;
        final int i14 = 255;
        l = 900;
        if (Long.compare(l2, l3) >= 0 && Long.compare(l2, l) < 0 && Long.compare(i, i4) == 0) {
            if (Long.compare(l2, l) < 0) {
                l = 900;
                if (Long.compare(i, i4) == 0) {
                    int i8 = (int)i7;
                    objectOutput2.writeByte(i11 &= i14);
                    objectOutput2.writeByte(i13 &= i14);
                    objectOutput2.writeByte(i8 &= i14);
                } else {
                    objectOutput2.writeByte(i14);
                    objectOutput2.writeLong(qVar.i());
                }
            } else {
            }
        } else {
        }
        SPX.v(objectOutput2, qVar.j());
        SPX.v(objectOutput2, qVar.n());
        SPX.v(objectOutput2, qVar.f());
        SPX.x(object.n(), objectOutput2);
    }

    private static void x(List<net.time4j.tz.model.d> list, ObjectOutput objectOutput2) {
        int size;
        int i;
        objectOutput2.writeByte(list.size());
        final Iterator obj2 = list.iterator();
        for (d size : obj2) {
            objectOutput2.writeByte(size.g());
            objectOutput2.writeObject(size);
            SPX.t(size, objectOutput2);
            SPX.r(size, objectOutput2);
            SPX.s(size, objectOutput2);
        }
    }

    private static int y(q q, int i2, DataOutput dataOutput3) {
        int i5;
        int i;
        int i4;
        byte b;
        int i3;
        int l2;
        long l;
        int obj13;
        int obj14;
        final int i6 = q.m();
        i = 0;
        i4 = i6 != i2 ? i5 : i;
        b = i4 != 0 ? (byte)i12 : i;
        final int i13 = q.f();
        final int i14 = 3;
        if (i13 != 0) {
            if (i13 != 3600) {
                i5 = i13 != 7200 ? i : i14;
            } else {
                i5 = 2;
            }
        }
        i16 += i18;
        l2 = -4575744000L;
        if (Long.compare(i3, l2) >= 0 && Long.compare(i3, l) < 0) {
            if (Long.compare(i3, l) < 0) {
                i = SPX.l(c.d(i3, obj8));
            }
        }
        obj14 = (byte)obj14;
        if (i == 0) {
            dataOutput3.writeByte(obj14);
            dataOutput3.writeLong(q.i());
        } else {
            obj13 = (int)i3;
            dataOutput3.writeByte((byte)obj14);
            dataOutput3.writeByte(obj14 &= 255);
            dataOutput3.writeByte(obj13 &= 255);
        }
        if (i5 == 0) {
            SPX.v(dataOutput3, i13);
        }
        if (i4 != 0) {
            SPX.v(dataOutput3, i6);
        }
        return i6;
    }

    static void z(q[] qArr, int i2, DataOutput dataOutput3) {
        int length;
        int i;
        Object obj;
        final int obj4 = Math.min(i2, qArr.length);
        dataOutput3.writeInt(obj4);
        if (obj4 > 0) {
            SPX.v(dataOutput3, qArr[0].j());
            while (length < obj4) {
                i = SPX.y(qArr[length], i, dataOutput3);
                length++;
            }
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        Object obj2;
        switch (byte) {
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
                obj2 = new StreamCorruptedException("Unknown serialized type.");
                throw obj2;
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
    public void writeExternal(ObjectOutput objectOutput) {
        Object obj;
        objectOutput.writeByte(this.b);
        switch (i3) {
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
                InvalidClassException obj2 = new InvalidClassException("Unknown serialized type.");
                throw obj2;
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
}
