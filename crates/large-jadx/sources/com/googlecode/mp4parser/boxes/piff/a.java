package com.googlecode.mp4parser.boxes.piff;

import com.googlecode.mp4parser.f.a;
import f.b.a.c;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class a {

    protected static Map<UUID, Class<? extends com.googlecode.mp4parser.boxes.piff.a>> a;
    static {
        HashMap hashMap = new HashMap();
        a.a = hashMap;
    }

    public static com.googlecode.mp4parser.boxes.piff.a a(UUID uUID, ByteBuffer byteBuffer2) {
        Object obj1;
        obj1 = a.a.get(uUID);
        if ((Class)obj1 != null) {
            obj1 = (Class)obj1.newInstance();
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = new a();
        }
        obj1.c(byteBuffer2);
        return obj1;
    }

    public abstract ByteBuffer b();

    public abstract void c(ByteBuffer byteBuffer);

    public boolean equals(Object object) {
        RuntimeException obj2 = new RuntimeException("somebody called equals on me but that's not supposed to happen.");
        throw obj2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProtectionSpecificHeader");
        stringBuilder.append("{data=");
        ByteBuffer duplicate = b().duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        stringBuilder.append(c.a(bArr));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
