package com.bumptech.glide.s;

import android.content.Context;
import android.content.res.Resources;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class a implements f {

    private final int b;
    private final f c;
    private a(int i, f f2) {
        super();
        this.b = i;
        this.c = f2;
    }

    public static f c(Context context) {
        a aVar = new a(obj2 &= 48, b.c(context));
        return aVar;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        this.c.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        boolean i2;
        int i3;
        int i;
        Object obj4;
        i3 = 0;
        if (object instanceof a && this.b == object.b && this.c.equals(object.c)) {
            if (this.b == object.b) {
                if (this.c.equals(object.c)) {
                    i3 = 1;
                }
            }
        }
        return i3;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return l.o(this.c, this.b);
    }
}
