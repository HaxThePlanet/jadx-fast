package net.time4j.tz;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final long serialVersionUID = -1000776907354520172L;
    private transient Object a;
    private transient int b;
    SPX(Object object, int i2) {
        super();
        this.a = object;
        this.b = i2;
    }

    private Object a(ObjectInput objectInput, byte b2) {
        a aVar = new a((k)objectInput.readObject(), (l)objectInput.readObject());
        return aVar;
    }

    private Object b(ObjectInput objectInput, byte b2) {
        int obj3;
        if (b2 &= 15 == 1) {
            obj3 = objectInput.readInt();
        } else {
            obj3 = 0;
        }
        return p.v(objectInput.readInt(), obj3);
    }

    private Object c(byte b) {
        b &= 15;
        return n.d(b.values()[obj3 / 2], g.values()[obj3 %= 2]);
    }

    private Object d(ObjectInput objectInput, byte b2) {
        Object oVar;
        Object obj5;
        oVar = l.c;
        if (b2 &= 15 == 1) {
            oVar = obj5;
        }
        obj5 = new c((k)objectInput.readObject(), (m)objectInput.readObject(), oVar);
        return obj5;
    }

    private void e(ObjectOutput objectOutput) {
        Object obj = this.a;
        objectOutput.writeByte(192);
        objectOutput.writeObject((a)obj.z());
        objectOutput.writeObject(obj.R());
    }

    private void f(ObjectOutput objectOutput) {
        Object obj;
        int i;
        int i2;
        obj = this.a;
        i = (p)obj.n() != 0 ? 1 : 0;
        i2 = 240;
        if (i != 0) {
            i2 = 241;
        }
        objectOutput.writeByte(i2);
        objectOutput.writeInt(obj.o());
        if (i != 0) {
            objectOutput.writeInt(obj.n());
        }
    }

    private void g(ObjectOutput objectOutput) {
        objectOutput.writeByte(i |= 208);
    }

    private void h(ObjectOutput objectOutput) {
        Object obj;
        int i;
        int i2;
        obj = this.a;
        i = (c)obj.E() != l.c ? 1 : 0;
        i2 = i != 0 ? 225 : 224;
        objectOutput.writeByte(i2);
        objectOutput.writeObject(obj.z());
        objectOutput.writeObject(obj.y());
        if (i != 0) {
            objectOutput.writeObject(obj.E());
        }
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        Object obj3;
        byte byte = objectInput.readByte();
        switch (i2) {
            case 12:
                this.a = a(objectInput, byte);
                break;
            case 13:
                this.a = c(byte);
                break;
            case 14:
                this.a = d(objectInput, byte);
                break;
            case 15:
                this.a = b(objectInput, byte);
                break;
            default:
                obj3 = new StreamCorruptedException("Unknown serialized type.");
                throw obj3;
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        switch (i) {
            case 12:
                e(objectOutput);
                break;
            case 13:
                g(objectOutput);
                break;
            case 14:
                h(objectOutput);
                break;
            case 15:
                f(objectOutput);
                break;
            default:
                InvalidClassException obj2 = new InvalidClassException("Unknown serialized type.");
                throw obj2;
        }
    }
}
