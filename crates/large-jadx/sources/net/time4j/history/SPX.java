package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.List;
import net.time4j.engine.z;
import net.time4j.g0;
import net.time4j.history.q.b;

/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final int[] c = null;
    private static final long serialVersionUID = 1L;
    private transient Object a;
    private transient int b;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            SPX.a.a = iArr;
            iArr[b.PROLEPTIC_GREGORIAN.ordinal()] = 1;
            SPX.a.a[b.PROLEPTIC_JULIAN.ordinal()] = 2;
            SPX.a.a[b.PROLEPTIC_BYZANTINE.ordinal()] = 3;
            SPX.a.a[b.SWEDEN.ordinal()] = 4;
            SPX.a.a[b.INTRODUCTION_ON_1582_10_15.ordinal()] = 5;
        }
    }
    static {
        SPX.c = new int[0];
    }

    SPX(Object object, int i2) {
        super();
        this.a = object;
        this.b = i2;
    }

    private static b a(int i) {
        int i2;
        b bVar;
        int serialValue;
        b[] values = b.values();
        i2 = 0;
        while (i2 < values.length) {
            bVar = values[i2];
            i2++;
        }
        StreamCorruptedException obj5 = new StreamCorruptedException("Unknown variant of chronological history.");
        throw obj5;
    }

    private net.time4j.history.d b(DataInput dataInput, byte b2) {
        int obj3 = SPX.a.a[SPX.a(b2 &= 15).ordinal()];
        if (obj3 != 1 && obj3 != 2 && obj3 != 3 && obj3 != 4 && obj3 != 5) {
            if (obj3 != 2) {
                if (obj3 != 3) {
                    if (obj3 != 4) {
                        if (obj3 != 5) {
                            return d.G(g0.P0(dataInput.readLong(), obj3));
                        }
                        return d.E();
                    }
                    return d.H();
                }
                return d.K;
            }
            return d.J;
        }
        return d.I;
    }

    private static net.time4j.history.a c(DataInput dataInput) {
        int i2;
        int i;
        final int int = dataInput.readInt();
        if (int > 0) {
            final int[] iArr = new int[int];
            i2 = 0;
            while (i2 < int) {
                iArr[i2] = int2 - 1;
                i2++;
            }
            return a.f(iArr);
        }
        return null;
    }

    private void d(DataOutput dataOutput) {
        b bVar;
        int[] iArr;
        int length;
        int i;
        Object obj = this.a;
        dataOutput.writeByte(serialValue |= i4);
        b sINGLE_CUTOVER_DATE = b.SINGLE_CUTOVER_DATE;
        if (obj.t() == sINGLE_CUTOVER_DATE) {
            dataOutput.writeLong(obj2.a);
        }
        if (obj.x()) {
            iArr = obj.m().e();
        } else {
            iArr = SPX.c;
        }
        dataOutput.writeInt(iArr.length);
        for (int length : obj1) {
            dataOutput.writeInt(length);
        }
        obj.w().g(dataOutput);
        obj.p().h(dataOutput);
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        byte byte;
        net.time4j.history.d dVar;
        int i;
        int i2;
        net.time4j.history.d obj4;
        byte = objectInput.readByte();
        i3 >>= 4;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    net.time4j.history.a aVar = SPX.c(objectInput);
                    if (aVar != null) {
                        dVar = b(objectInput, byte).I(aVar);
                    }
                    obj4 = dVar.K(o.e(objectInput)).J(g.g(objectInput));
                }
                obj4 = new StreamCorruptedException("Unknown serialized type.");
                throw obj4;
            }
            byte = b(objectInput, byte);
            obj4 = SPX.c(objectInput);
            if (obj4 != null) {
                obj4 = byte.I(obj4);
            } else {
                obj4 = byte;
            }
        } else {
            obj4 = b(objectInput, byte);
        }
        this.a = obj4;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        int i;
        int i2 = this.b;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                }
                InvalidClassException obj3 = new InvalidClassException("Unknown serialized type.");
                throw obj3;
            }
        }
        d(objectOutput);
    }
}
