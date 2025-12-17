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

/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final long serialVersionUID = 1L;
    private transient Object a;
    private transient int b;
    SPX(Object object, int i2) {
        super();
        this.a = object;
        this.b = i2;
    }

    private net.time4j.g0 a(DataInput dataInput, byte b2) {
        int i;
        int obj5;
        byte byte = dataInput.readByte();
        final int i5 = 3;
        i3 &= i5;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != i5) {
                } else {
                    obj5 = dataInput.readInt();
                }
                obj5 = new StreamCorruptedException("Unknown year range.");
                throw obj5;
            }
            obj5 = dataInput.readShort();
        } else {
            obj5 += 128;
        }
        return g0.O0(obj5, c0.valueOf(b2 &= 15), byte &= 31);
    }

    private Object b(ObjectInput objectInput, byte b2) {
        int i;
        Locale locale;
        int indexOf;
        Locale locale2;
        int obj7;
        int i3 = 0;
        final int i4 = 1;
        i = b2 & 1 == i4 ? i4 : i3;
        int i5 = 2;
        obj7 = b2 &= i5 == i5 ? i4 : i3;
        if (obj7 != null) {
            obj7 = new l.b(i, l.s((Map)objectInput.readObject()));
            return obj7;
        }
        obj7 = objectInput.readUTF();
        indexOf = obj7.indexOf("-");
        if (indexOf == -1) {
            locale = new Locale(obj7);
        } else {
            locale2 = new Locale(obj7.substring(i3, indexOf), obj7.substring(indexOf += i4));
            locale = locale2;
        }
        obj7 = new l.b(i, locale, objectInput.readUTF());
        return obj7;
    }

    private Object c(ObjectInput objectInput, byte b2) {
        int i;
        int i2;
        j0.a aVar;
        long long;
        Object object;
        if (b2 &= 15 == 1) {
        } else {
            i2 = i;
        }
        int obj8 = objectInput.readInt();
        if (obj8 == null) {
            return o.i();
        }
        ArrayList arrayList = new ArrayList(obj8);
        while (i < obj8) {
            if (i2 != 0) {
            } else {
            }
            long = (long)int;
            arrayList.add(j0.a.c(long, obj4));
            i++;
            long = objectInput.readLong();
        }
        obj8 = new o(arrayList, objectInput.readBoolean());
        return obj8;
    }

    private Object d(ObjectInput objectInput, byte b2) {
        f pOSIX;
        int obj5;
        pOSIX = b2 & 1 == 1 ? f.UTC : f.POSIX;
        long long = objectInput.readLong();
        final int i3 = 2;
        if (b2 &= i3 == i3) {
            obj5 = objectInput.readInt();
        } else {
            obj5 = 0;
        }
        if (pOSIX == f.UTC) {
            return z.o(long, obj2);
        }
        return z.n(long, obj2);
    }

    private Object e(DataInput dataInput, byte b2) {
        int i;
        int i2;
        i2 = 1;
        final int i4 = 0;
        i = b2 & 1 != 0 ? i2 : i4;
        if (obj5 >>>= i2 != 0) {
        } else {
            i2 = i4;
        }
        return b0.r0(dataInput, i, i2);
    }

    private net.time4j.h0 f(DataInput dataInput) {
        int byte;
        int i2;
        byte byte2;
        int i;
        int obj6;
        final byte byte3 = dataInput.readByte();
        if (byte3 < 0) {
            return h0.I0(~byte3);
        }
        byte = dataInput.readByte();
        i2 = 0;
        if (byte < 0) {
            byte = ~byte;
            obj6 = i2;
        } else {
            byte2 = dataInput.readByte();
            if (byte2 < 0) {
                i2 = obj6;
                obj6 = i;
            } else {
                obj6 = int;
                i2 = byte2;
            }
        }
        return h0.L0(byte3, byte, i2, obj6);
    }

    private Object g(DataInput dataInput, byte b2) {
        return i0.d0(a(dataInput, b2), f(dataInput));
    }

    private Object h(DataInput dataInput, byte b2) {
        net.time4j.x0 sATURDAY;
        net.time4j.x0 valueOf;
        int obj6;
        int obj7;
        byte byte = dataInput.readByte();
        sATURDAY = x0.SATURDAY;
        valueOf = x0.SUNDAY;
        if (b2 &= 15 == 1) {
            obj6 = dataInput.readByte();
            sATURDAY = x0.valueOf(obj6 >> 4);
            valueOf = x0.valueOf(obj6 &= 15);
        }
        return z0.l(x0.valueOf(byte >> 4), byte &= 15, sATURDAY, valueOf);
    }

    private void i(DataOutput dataOutput) {
        SPX.j((g0)this.a, 1, dataOutput);
    }

    private static void j(net.time4j.g0 g0, int i2, DataOutput dataOutput3) {
        int i4;
        int i5;
        int i;
        int i3;
        i4 = g0.m();
        final int i7 = 1;
        final int i8 = 2;
        final int i9 = 1850;
        if (i4 >= i9 && i4 <= 2100) {
            i = i4 <= 2100 ? i7 : i10 < i3 ? i8 : 3;
        } else {
        }
        dataOutput3.writeByte(obj7 |= i11);
        dataOutput3.writeByte(obj6 |= obj7);
        if (i == i7) {
            dataOutput3.writeByte(i6 += -128);
        } else {
            if (i == i8) {
                dataOutput3.writeShort(i4);
            } else {
                dataOutput3.writeInt(i4);
            }
        }
    }

    private void k(ObjectOutput objectOutput) {
        Object str;
        Object country;
        int language;
        boolean stringBuilder;
        Object cast = l.b.class.cast(this.a);
        country = (l.b)cast.w();
        language = cast.A() ? 113 : 112;
        if (country == null) {
            language |= 2;
        }
        objectOutput.writeByte(language);
        if (country == null) {
            objectOutput.writeObject(cast.r());
        } else {
            if (!country.getCountry().isEmpty()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(country.getLanguage());
                stringBuilder.append("-");
                stringBuilder.append(country.getCountry());
                language = stringBuilder.toString();
            }
            objectOutput.writeUTF(language);
            objectOutput.writeUTF(cast.l());
        }
    }

    private void l(ObjectOutput objectOutput) {
        Object cast;
        int i2;
        int i3;
        int i;
        int i5;
        int cmp;
        int i4;
        cast = o.class.cast(this.a);
        int size = (o)cast.c().size();
        i3 = 0;
        i = i3;
        while (i < Math.min(size, 6)) {
            i++;
        }
        i2 = i3;
        i5 = 96;
        if (i2 != 0) {
            i5 = 97;
        }
        objectOutput.writeByte(i5);
        objectOutput.writeInt(size);
        while (i3 < size) {
            Object obj3 = cast.c().get(i3);
            if (i2 != 0) {
            } else {
            }
            objectOutput.writeInt((int)l);
            objectOutput.writeObject(obj3.b());
            i3++;
            objectOutput.writeLong(obj3.a());
        }
        if (size > 0) {
            objectOutput.writeBoolean(cast.a());
        }
    }

    private void m(ObjectOutput objectOutput) {
        int i2;
        int i;
        Object cast = z.class.cast(this.a);
        i = (z)cast.k() == f.UTC ? 81 : 80;
        int i4 = cast.j();
        if (i4 == 0) {
            objectOutput.writeByte(i);
            objectOutput.writeLong(cast.m());
        } else {
            objectOutput.writeByte(i |= 2);
            objectOutput.writeLong(cast.m());
            objectOutput.writeInt(cast.j());
        }
    }

    private void n(DataOutput dataOutput) {
        (b0)this.a.z0(dataOutput);
    }

    private void o(DataOutput dataOutput) {
        dataOutput.writeByte(32);
        SPX.p((h0)this.a, dataOutput);
    }

    private static void p(net.time4j.h0 h0, DataOutput dataOutput2) {
        int i;
        int obj1;
        if (h0.a() == 0) {
            if (h0.u() == 0) {
                if (h0.i() == 0) {
                    dataOutput2.writeByte(~obj1);
                } else {
                    dataOutput2.writeByte(h0.s());
                    dataOutput2.writeByte(~obj1);
                }
            } else {
                dataOutput2.writeByte(h0.s());
                dataOutput2.writeByte(h0.i());
                dataOutput2.writeByte(~obj1);
            }
        } else {
            dataOutput2.writeByte(h0.s());
            dataOutput2.writeByte(h0.i());
            dataOutput2.writeByte(h0.u());
            dataOutput2.writeInt(h0.a());
        }
    }

    private void q(DataOutput dataOutput) {
        Object obj = this.a;
        SPX.j((i0)obj.X(), 8, dataOutput);
        SPX.p(obj.Z(), dataOutput);
    }

    private void r(DataOutput dataOutput) {
        Object obj;
        net.time4j.x0 x0Var;
        int i;
        net.time4j.x0 sATURDAY;
        int i2;
        obj = this.a;
        if ((z0)obj.h() == x0.SATURDAY && obj.e() == x0.SUNDAY) {
            i = obj.e() == x0.SUNDAY ? 1 : 0;
        } else {
        }
        i2 = 48;
        if (i == 0) {
            i2 = 49;
        }
        dataOutput.writeByte(i2);
        dataOutput.writeByte(i3 |= i5);
        if (i == 0) {
            dataOutput.writeByte(value |= i);
        }
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        Object obj3;
        byte byte = objectInput.readByte();
        switch (i3) {
            case 1:
                this.a = a(objectInput, byte);
                break;
            case 2:
                this.a = f(objectInput);
                break;
            case 3:
                this.a = h(objectInput, byte);
                break;
            case 4:
                this.a = e(objectInput, byte);
                break;
            case 5:
                this.a = d(objectInput, byte);
                break;
            case 6:
                this.a = c(objectInput, byte);
                break;
            case 7:
                this.a = b(objectInput, byte);
                break;
            case 8:
                this.a = g(objectInput, byte);
                break;
            default:
                obj3 = new StreamCorruptedException("Unknown serialized type.");
                throw obj3;
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        switch (i) {
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
                InvalidClassException obj2 = new InvalidClassException("Unknown serialized type.");
                throw obj2;
        }
    }
}
