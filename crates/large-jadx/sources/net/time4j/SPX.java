package net.time4j;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.time4j.engine.j0.a;
import net.time4j.i1.f;

/* compiled from: SPX.java */
/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final long serialVersionUID = 1L;
    private transient Object a;
    private transient int b;
    private g0 a(DataInput dataInput, byte b) throws java.io.IOException, StreamCorruptedException {
        int _int;
        byte _byte = dataInput.readByte();
        final int i5 = 3;
        int i4 = (_byte >> 5) & i5;
        int i = 1;
        if (i4 != 1) {
            i = 2;
            if (i4 != 2) {
                if (i4 != i5) {
                    throw new StreamCorruptedException("Unknown year range.");
                } else {
                    _int = dataInput.readInt();
                }
            }
            short _short = dataInput.readShort();
        } else {
            _int = (dataInput.readByte() + 1850) + 128;
        }
        return g0.O0(_int, c0.valueOf(b & 15), _byte & 31);
    }

    private Object b(ObjectInput objectInput, byte b) throws java.lang.ClassNotFoundException, java.io.IOException {
        boolean z;
        Locale locale;
        int i;
        i = 0;
        i = 1;
        int r0 = i;
        int i3 = 2;
        b = i;
        if (i != 0) {
            return new l.b(z, l.s((Map)objectInput.readObject()));
        }
        String substring = objectInput.readUTF();
        int indexOf = substring.indexOf("-");
        if (indexOf == -1) {
            locale = new Locale(substring);
        } else {
            indexOf = indexOf + i;
        }
        return new l.b(z, locale, objectInput.readUTF());
    }

    private Object c(ObjectInput objectInput, byte b) throws java.lang.ClassNotFoundException, java.io.IOException {
        int i = 0;
        long _long;
        i = 0;
        i = 1;
        if ((b & 15) != 1) {
        }
        int _int2 = objectInput.readInt();
        if (_int2 == 0) {
            return o.i();
        }
        final ArrayList arrayList = new ArrayList(_int2);
        while (i < _int2) {
            arrayList.add(j0.a.c(_long, (x)objectInput.readObject()));
            i = i + 1;
        }
        return new o(arrayList, objectInput.readBoolean());
    }

    private Object d(ObjectInput objectInput, byte b) {
        f pOSIX2;
        int _int = 0;
        f r0 = (b & 1) == 1 ? f.UTC : f.POSIX;
        long _long = objectInput.readLong();
        final int i3 = 2;
        if ((b & i3) == i3) {
            _int = objectInput.readInt();
        } else {
            _int = 0;
        }
        if (pOSIX2 == f.UTC) {
            return z.o(_long, _int);
        }
        return z.n(_long, _int);
    }

    private Object e(DataInput dataInput, byte b) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        final int i2 = 0;
        int r0 = b & 1 != 0 ? i : i2;
        if ((b & 2) >>> i == 0) {
        }
        return b0.r0(dataInput, z, z2);
    }

    private h0 f(DataInput dataInput) throws java.io.IOException {
        int i;
        int dataInput2 = 0;
        final byte _byte2 = dataInput.readByte();
        if (_byte2 < 0) {
            return h0.I0(~_byte2);
        }
        byte _byte3 = dataInput.readByte();
        dataInput2 = 0;
        if (_byte3 < 0) {
            i = ~_byte3;
        } else {
            byte _byte = dataInput.readByte();
            if (_byte < 0) {
            } else {
            }
        }
        return h0.L0(_byte2, i, dataInput2, dataInput2);
    }

    private Object g(DataInput dataInput, byte b) {
        return i0.d0(a(dataInput, b), f(dataInput));
    }

    private Object h(DataInput dataInput, byte b) throws java.io.IOException {
        net.time4j.x0 str;
        net.time4j.x0 str2;
        byte _byte = dataInput.readByte();
        str = x0.SATURDAY;
        str2 = x0.SUNDAY;
        i2 = b & 15;
        if ((b & 15) == 1) {
            byte _byte2 = dataInput.readByte();
            i2 = _byte2 >> 4;
            str = x0.valueOf(i2);
            i = _byte2 & 15;
            str2 = x0.valueOf(i);
        }
        return z0.l(x0.valueOf(_byte >> 4), _byte & 15, str, str2);
    }

    private void i(DataOutput dataOutput) {
        SPX.j((g0)this.a, 1, dataOutput);
    }

    private static void j(g0 g0Var, int i, DataOutput dataOutput) throws java.io.IOException {
        int i3 = 3;
        i = g0Var.m();
        i3 = 1;
        i3 = 2;
        final int i7 = 1850;
        if (i < i7 || i > 2100) {
            int i5 = 10000;
            int r4 = Math.abs(i) < 10000 ? i3 : 3;
        } else {
        }
        dataOutput.writeByte(i << 4 | g0Var.o());
        dataOutput.writeByte(g0Var.q() | (Math.abs(i) < 10000 ? i3 : 3) << 5);
        if (r4 == i3) {
            i = (i - i7) - 128;
            dataOutput.writeByte(i);
        } else {
            if (r4 == i3) {
                dataOutput.writeShort(i);
            } else {
                dataOutput.writeInt(i);
            }
        }
    }

    private void k(ObjectOutput objectOutput) throws java.io.IOException {
        Locale locale;
        int i = 112;
        String language;
        boolean empty;
        Object cast = l.b.class.cast(this.a);
        locale = cast.w();
        int r2 = cast.A() ? 113 : 112;
        if (locale == null) {
            i = i | 2;
        }
        objectOutput.writeByte(i);
        if (locale == null) {
            objectOutput.writeObject(cast.r());
        } else {
            language = locale.getLanguage();
            if (!locale.getCountry().isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "-";
                String country = locale.getCountry();
                language = language + str2 + country;
            }
            objectOutput.writeUTF(language);
            objectOutput.writeUTF(cast.l());
        }
    }

    private void l(ObjectOutput objectOutput) throws java.io.IOException {
        int i = 1;
        int i2 = 96;
        int cmp;
        long l = 1000;
        Object cast = o.class.cast(this.a);
        int size = cast.c().size();
        i = 0;
        while (i < Math.min(size, 6)) {
            long l4 = (j0.a)cast.c().get(i).a();
            l = 1000L;
            if (l4 >= l) {
                break;
            }
        }
        i2 = 96;
        if (i != 0) {
            i2 = 97;
        }
        objectOutput.writeByte(i2);
        objectOutput.writeInt(size);
        while (i < this.a) {
            Object item = cast.c().get(i);
            objectOutput.writeObject(item.b());
            i = i + 1;
        }
        if (this.a > 0) {
            objectOutput.writeBoolean(cast.a());
        }
    }

    private void m(ObjectOutput objectOutput) {
        int i2 = 81;
        Object cast = z.class.cast(this.a);
        int r1 = cast.k() == f.UTC ? 81 : 80;
        int i4 = cast.j();
        if (i4 == 0) {
            objectOutput.writeByte(i2);
            objectOutput.writeLong(cast.m());
        } else {
            objectOutput.writeByte(i2 | 2);
            objectOutput.writeLong(cast.m());
            objectOutput.writeInt(cast.j());
        }
    }

    private void n(DataOutput dataOutput) {
        (b0)this.a.z0(dataOutput);
    }

    private void o(DataOutput dataOutput) throws java.io.IOException {
        dataOutput.writeByte(32);
        SPX.p((h0)this.a, dataOutput);
    }

    private static void p(h0 h0Var, DataOutput dataOutput) throws java.io.IOException {
        if (h0Var.a() != 0) {
            dataOutput.writeByte(h0Var.s());
            dataOutput.writeByte(h0Var.i());
            dataOutput.writeByte(h0Var.u());
            dataOutput.writeInt(h0Var.a());
        } else {
            if (h0Var.u() != 0) {
                dataOutput.writeByte(h0Var.s());
                dataOutput.writeByte(h0Var.i());
                i2 = ~h0Var.u();
                dataOutput.writeByte(i2);
            } else {
                if (h0Var.i() == 0) {
                    i2 = ~h0Var.s();
                    dataOutput.writeByte(i2);
                } else {
                    dataOutput.writeByte(h0Var.s());
                    i2 = ~h0Var.i();
                    dataOutput.writeByte(i2);
                }
            }
        }
    }

    private void q(DataOutput dataOutput) {
        SPX.j(obj.X(), 8, dataOutput);
        SPX.p(obj.Z(), dataOutput);
    }

    private void r(DataOutput dataOutput) throws java.io.IOException {
        int i = 0;
        net.time4j.x0 sATURDAY2;
        int i2 = 48;
        if (obj.h() == x0.SATURDAY) {
            int r1 = obj.e() == x0.SUNDAY ? 1 : 0;
        }
        i2 = 48;
        if (i == 0) {
            i2 = 49;
        }
        dataOutput.writeByte(i2);
        dataOutput.writeByte((obj.f().getValue() << 4) | obj.g());
        if (i == 0) {
            i = obj.h().getValue() << 4;
            dataOutput.writeByte(obj.e().getValue() | i);
        }
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws StreamCorruptedException {
        byte _byte = objectInput.readByte();
        switch ((_byte & 255) >> 4) {
            case 1:
                this.a = this.a(objectInput, _byte);
                break;
            case 2:
                this.a = this.f(objectInput);
                break;
            case 3:
                this.a = this.h(objectInput, _byte);
                break;
            case 4:
                this.a = this.e(objectInput, _byte);
                break;
            case 5:
                this.a = this.d(objectInput, _byte);
                break;
            case 6:
                this.a = this.c(objectInput, _byte);
                break;
            case 7:
                this.a = this.b(objectInput, _byte);
                break;
            case 8:
                this.a = this.g(objectInput, _byte);
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type.");
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws InvalidClassException {
        switch (this.b) {
            case 1:
                i(objectOutput);
                break;
            case 2:
                o(objectOutput);
                break;
            case 3:
                r(objectOutput);
                break;
            case 4:
                n(objectOutput);
                break;
            case 5:
                m(objectOutput);
                break;
            case 6:
                l(objectOutput);
                break;
            case 7:
                k(objectOutput);
                break;
            case 8:
                q(objectOutput);
                break;
            default:
                throw new InvalidClassException("Unknown serialized type.");
        }
    }

    SPX(Object object, int i) {
        super();
        this.a = object;
        this.b = i;
    }
}
