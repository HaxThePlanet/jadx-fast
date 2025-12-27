package net.time4j.tz;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* compiled from: SPX.java */
/* loaded from: classes3.dex */
final class SPX implements Externalizable {

    private static final long serialVersionUID = -1000776907354520172L;
    private transient Object a;
    private transient int b;
    private Object a(ObjectInput objectInput, byte b) throws java.io.IOException, java.lang.ClassNotFoundException {
        return new a((k)objectInput.readObject(), (l)objectInput.readObject());
    }

    private Object b(ObjectInput objectInput, byte b) {
        int _int = 0;
        if ((b & 15) == 1) {
            _int = objectInput.readInt();
        } else {
            _int = 0;
        }
        return p.v(objectInput.readInt(), _int);
    }

    private Object c(byte b) {
        b &= 15;
        return n.d(b.values()[i2 / 2], g.values()[i2 % 2]);
    }

    private Object d(ObjectInput objectInput, byte b) throws java.io.IOException, java.lang.ClassNotFoundException {
        net.time4j.tz.o oVar;
        oVar = l.c;
        if ((b & 15) == 1) {
        }
        return new c((k)objectInput.readObject(), (m)objectInput.readObject(), oVar);
    }

    private void e(ObjectOutput objectOutput) throws java.io.IOException {
        objectOutput.writeByte(192);
        objectOutput.writeObject(obj.z());
        objectOutput.writeObject(obj.R());
    }

    private void f(ObjectOutput objectOutput) {
        int i = 0;
        int i2 = 240;
        int r1 = obj.n() != 0 ? 1 : 0;
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
        objectOutput.writeByte((n)this.a.c() | 208);
    }

    private void h(ObjectOutput objectOutput) throws java.io.IOException {
        int i = 0;
        int i2 = 224;
        int r1 = obj.E() != l.c ? 1 : 0;
        int r2 = i != 0 ? 225 : 224;
        objectOutput.writeByte((i != 0 ? 225 : 224));
        objectOutput.writeObject((i != 0 ? 225 : 224));
        objectOutput.writeObject((i != 0 ? 225 : 224));
        if (i != 0) {
            objectOutput.writeObject(obj.E());
        }
    }

    private Object readResolve() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws StreamCorruptedException {
        byte _byte = objectInput.readByte();
        switch ((_byte & 255) >> 4) {
            case 12:
                this.a = this.a(objectInput, _byte);
                break;
            case 13:
                this.a = this.c(_byte);
                break;
            case 14:
                this.a = this.d(objectInput, _byte);
                break;
            case 15:
                this.a = this.b(objectInput, _byte);
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type.");
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws InvalidClassException {
        switch (this.b) {
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
                throw new InvalidClassException("Unknown serialized type.");
        }
    }

    SPX(Object object, int i) {
        super();
        this.a = object;
        this.b = i;
    }
}
