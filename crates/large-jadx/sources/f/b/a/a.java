package f.b.a;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.a;
import java.io.EOFException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class a implements f.b.a.b {

    private static Logger b;
    java.lang.ThreadLocal<ByteBuffer> a;

    class a extends java.lang.ThreadLocal<ByteBuffer> {
        a(f.b.a.a a) {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected ByteBuffer a() {
            return ByteBuffer.allocate(32);
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }
    static {
        a.b = Logger.getLogger(a.class.getName());
    }

    public a() {
        super();
        a.a aVar = new a.a(this);
        this.a = aVar;
    }

    @Override // f.b.a.b
    public a a(a a, b b2) {
        long size;
        int i4;
        String type;
        Buffer rewind;
        int cmp2;
        int cmp;
        byte[] bArr;
        int i3;
        int i5;
        int i2;
        int position;
        int cmp3;
        byte[] i;
        int i6;
        final Object obj18 = this;
        a aVar2 = a;
        Object obj = b2;
        cmp = 8;
        (ByteBuffer)obj18.a.get().rewind().limit(cmp);
        rewind = aVar2.read((ByteBuffer)obj18.a.get());
        while (rewind == cmp) {
            rewind = aVar2.read((ByteBuffer)obj18.a.get());
        }
        (ByteBuffer)obj18.a.get().rewind();
        size = e.k((ByteBuffer)obj18.a.get());
        int i10 = 1;
        if (Long.compare(size, i3) < 0 && Long.compare(size, i10) > 0) {
            if (Long.compare(size, i10) > 0) {
                StringBuilder stringBuilder = new StringBuilder("Plausibility check failed: size < 8 (size = ");
                stringBuilder.append(size);
                stringBuilder.append("). Stop parsing!");
                a.b.severe(stringBuilder.toString());
                return null;
            }
        }
        String str3 = e.b((ByteBuffer)obj18.a.get());
        final int i12 = 16;
        final int i11 = 16;
        if (Long.compare(size, i10) == 0) {
            (ByteBuffer)obj18.a.get().limit(i11);
            aVar2.read((ByteBuffer)obj18.a.get());
            (ByteBuffer)obj18.a.get().position(cmp);
            l2 -= i12;
        } else {
            if (Long.compare(size, i6) == 0) {
                size = a.size();
                i3 = a.w0();
            }
            size -= i3;
        }
        if ("uuid".equals(str3)) {
            (ByteBuffer)obj18.a.get().limit(limit += i11);
            aVar2.read((ByteBuffer)obj18.a.get());
            bArr = new byte[i11];
            position2 -= i11;
            while (i5 >= (ByteBuffer)obj18.a.get().position()) {
                bArr[i5 - i9] = (ByteBuffer)obj18.a.get().get(i5);
                i5++;
            }
            i2 = i4;
            i = bArr;
        } else {
            i2 = i4;
        }
        if (obj instanceof a) {
            type = (a)obj.getType();
        } else {
            type = "";
        }
        a aVar4 = obj18.b(str3, i, type);
        aVar4.setParent(obj);
        (ByteBuffer)obj18.a.get().rewind();
        aVar4.parse(a, (ByteBuffer)obj18.a.get(), i2, str3);
        return aVar4;
    }

    @Override // f.b.a.b
    public abstract a b(String string, byte[] b2Arr2, String string3);
}
