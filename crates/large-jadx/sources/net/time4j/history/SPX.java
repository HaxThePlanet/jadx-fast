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

/* compiled from: SPX.java */
/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final int[] c;
    private static final long serialVersionUID = 1L;
    private transient Object a;
    private transient int b;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[b.values().length];
            SPX.a.a = iArr;
            try {
                iArr[b.PROLEPTIC_GREGORIAN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                SPX.a.a[b.PROLEPTIC_JULIAN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                SPX.a.a[b.PROLEPTIC_BYZANTINE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                SPX.a.a[b.SWEDEN.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                SPX.a.a[b.INTRODUCTION_ON_1582_10_15.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        SPX.c = new int[0];
    }

    private static b a(int i) throws StreamCorruptedException {
        int i2 = 0;
        b[] values = b.values();
        i2 = 0;
        for (b bVar : values) {
            if (bVar.getSerialValue() == i) {
                return bVar;
            }
        }
        throw new StreamCorruptedException("Unknown variant of chronological history.");
    }

    private d b(DataInput dataInput, byte b) throws java.io.IOException {
        int i7 = SPX.a.a[SPX.a(b & 15).ordinal()];
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3 && i7 != 4) {
                if (i7 != 5) {
                    return d.G(g0.P0(dataInput.readLong(), z.MODIFIED_JULIAN_DATE));
                }
                return d.E();
            }
            return d.K;
        }
        return d.I;
    }

    private static a c(DataInput dataInput) throws java.io.IOException {
        int i = 0;
        final int _int = dataInput.readInt();
        if (_int > 0) {
            final int[] iArr = new int[_int];
            i = 0;
            while (i < _int) {
                i2 = dataInput.readInt() - 1;
                iArr[i] = i2;
                i = i + 1;
            }
            return a.f(iArr);
        }
        return null;
    }

    private void d(DataOutput dataOutput) throws java.io.IOException {
        int[] iArr;
        int i = 0;
        dataOutput.writeByte(obj.t().getSerialValue() | (this.b << 4));
        b sINGLE_CUTOVER_DATE2 = b.SINGLE_CUTOVER_DATE;
        i = 0;
        if (obj.t() == b.SINGLE_CUTOVER_DATE) {
            dataOutput.writeLong((f)obj.q().get(0).a);
        }
        if (obj.x()) {
            iArr = obj.m().e();
        } else {
            iArr = SPX.c;
        }
        length = iArr.length;
        dataOutput.writeInt(length);
        for (int length : iArr) {
            dataOutput.writeInt(length);
        }
        obj.w().g(dataOutput);
        obj.p().h(dataOutput);
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws StreamCorruptedException {
        net.time4j.history.d dVar2;
        net.time4j.history.d dVar;
        byte _byte = objectInput.readByte();
        i = (_byte & 255) >> 4;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    throw new StreamCorruptedException("Unknown serialized type.");
                } else {
                    net.time4j.history.a aVar = SPX.c(objectInput);
                    if (aVar != null) {
                        dVar2 = b(objectInput, _byte).I(aVar);
                    }
                    dVar = dVar2.K(o.e(objectInput)).J(g.g(objectInput));
                }
            }
            dVar = b(objectInput, _byte);
            net.time4j.history.a aVar2 = SPX.c(objectInput);
            if (aVar2 != null) {
                dVar = dVar.I(aVar2);
            } else {
            }
        } else {
            dVar = b(objectInput, _byte);
        }
        this.a = dVar;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws InvalidClassException {
        int i = 1;
        d(objectOutput);
    }

    SPX(Object object, int i) {
        super();
        this.a = object;
        this.b = i;
    }
}
