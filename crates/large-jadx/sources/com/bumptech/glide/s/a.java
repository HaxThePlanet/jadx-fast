package com.bumptech.glide.s;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: AndroidResourceSignature.java */
/* loaded from: classes.dex */
public final class a implements f {

    private final int b;
    private final f c;
    private a(int i, f fVar) {
        super();
        this.b = i;
        this.c = fVar;
    }

    public static f c(Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    public void a(MessageDigest messageDigest) {
        this.c.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z2 = false;
        z = object instanceof a;
        int i3 = 0;
        if (object instanceof a) {
            if (this.b == object.b) {
                if (this.c.equals(object.c)) {
                    int i4 = 1;
                }
            }
        }
        return z2;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return l.o(this.c, this.b);
    }
}
