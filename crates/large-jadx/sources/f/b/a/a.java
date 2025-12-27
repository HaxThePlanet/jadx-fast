package f.b.a;

import com.coremedia.iso.boxes.b;
import java.io.EOFException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* compiled from: AbstractBoxParser.java */
/* loaded from: classes.dex */
public abstract class a implements b {

    private static Logger b;
    java.lang.ThreadLocal<ByteBuffer> a = new a$a<>();

    class a extends java.lang.ThreadLocal<ByteBuffer> {
        a() {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected ByteBuffer a() {
            return ByteBuffer.allocate(32);
        }
    }
    static {
        a.b = Logger.getLogger(a.class.getName());
    }

    public a() {
        super();
        final f.b.a.a.a aVar = new a.a(this);
    }

    public com.coremedia.iso.boxes.a a(com.googlecode.mp4parser.a aVar, b bVar) throws EOFException {
        long size;
        long l;
        String type;
        long l2 = 8;
        int i;
        int cmp3;
        byte[] bArr = null;
        final Object aVar4 = this;
        com.googlecode.mp4parser.a aVar3 = aVar;
        Object bVar22 = bVar;
        int cmp2 = 8;
        (ByteBuffer)aVar4.a.get().rewind().limit(cmp2);
        int read = aVar3.read((ByteBuffer)aVar4.a.get());
        while (read == cmp2) {
            if (read < 0) {
                aVar3.Z1(aVar.w0());
                throw new EOFException();
            }
        }
        (ByteBuffer)aVar4.a.get().rewind();
        size = e.k((ByteBuffer)aVar4.a.get());
        l2 = 8L;
        long l6 = 1L;
        if (size < l2) {
            if (size > l6) {
                String str3 = "Plausibility check failed: size < 8 (size = ";
                StringBuilder stringBuilder = new StringBuilder(str3);
                String str2 = "). Stop parsing!";
                str = str3 + size + str2;
                a.b.severe(str);
                return null;
            }
        }
        String str4 = e.b((ByteBuffer)aVar4.a.get());
        final long l7 = 16L;
        final int i5 = 16;
        if (size == l6) {
            (ByteBuffer)aVar4.a.get().limit(i5);
            aVar3.read((ByteBuffer)aVar4.a.get());
            (ByteBuffer)aVar4.a.get().position(cmp2);
            l = e.m((ByteBuffer)aVar4.a.get()) - 16L;
        } else {
            long l3 = 0L;
            if (size == l3) {
                size = aVar.size();
                l2 = aVar.w0();
            }
            l = size - l2;
        }
        if ("uuid".equals(str4)) {
            (ByteBuffer)aVar4.a.get().limit((ByteBuffer)aVar4.a.get().limit() + i5);
            aVar3.read((ByteBuffer)aVar4.a.get());
            bArr = new byte[i5];
            i = (ByteBuffer)aVar4.a.get().position() - i5;
            while (aVar4.a >= (ByteBuffer)aVar4.a.get().position()) {
                i2 = i - (ByteBuffer)aVar4.a.get().position() - i5;
                bArr[i2] = (ByteBuffer)aVar4.a.get().get(i);
                i = i + 1;
            }
            l = l - 16L;
        } else {
        }
        if (bVar22 instanceof a) {
            type = (a)bVar22.getType();
        } else {
            type = "";
        }
        com.coremedia.iso.boxes.a aVar2 = aVar4.b(str4, bArr, type);
        aVar2.setParent(bVar22);
        (ByteBuffer)aVar4.a.get().rewind();
        aVar2.parse(aVar, (ByteBuffer)aVar4.a.get(), l, this);
        return aVar2;
    }

    public abstract com.coremedia.iso.boxes.a b(String str, byte[] bArr, String str2);
}
