package com.googlecode.mp4parser.boxes.piff;

import com.googlecode.mp4parser.f.a;
import f.b.a.c;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: ProtectionSpecificHeader.java */
/* loaded from: classes2.dex */
public abstract class a {

    protected static Map<UUID, Class<? extends a>> a;
    static {
        a.a = new HashMap();
    }

    public static a a(UUID uuid, ByteBuffer byteBuffer) {
        int i = 0;
        Object value = a.a.get(uuid);
        if (value != null) {
            try {
                Object obj = value.newInstance();
            } catch (java.lang.IllegalAccessException illegalAccess) {
                byteBuffer = new RuntimeException(illegalAccess);
                throw byteBuffer;
            } catch (java.lang.InstantiationException instantiation1) {
                byteBuffer = new RuntimeException(instantiation1);
                throw byteBuffer;
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            a aVar = new a();
        }
        i.c(byteBuffer);
        return i;
    }

    public boolean equals(Object object) {
        throw new RuntimeException("somebody called equals on me but that's not supposed to happen.");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProtectionSpecificHeader";
        String str3 = "{data=";
        ByteBuffer duplicate = b().duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        String str4 = c.a(bArr);
        str = str2 + str3 + str4 + 125;
        return str;
    }

    public abstract ByteBuffer b();

    public abstract void c(ByteBuffer byteBuffer);
}
