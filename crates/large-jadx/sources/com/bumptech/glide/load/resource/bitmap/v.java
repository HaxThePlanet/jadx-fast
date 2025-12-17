package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;

/* loaded from: classes.dex */
public final class v implements j<ParcelFileDescriptor, Bitmap> {

    private final com.bumptech.glide.load.resource.bitmap.m a;
    public v(com.bumptech.glide.load.resource.bitmap.m m) {
        super();
        this.a = m;
    }

    private boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        String equalsIgnoreCase;
        boolean equalsIgnoreCase2;
        int i;
        equalsIgnoreCase = Build.MANUFACTURER;
        if (!"HUAWEI".equalsIgnoreCase(equalsIgnoreCase) && "HONOR".equalsIgnoreCase(equalsIgnoreCase)) {
            if ("HONOR".equalsIgnoreCase(equalsIgnoreCase)) {
            }
            return 1;
        }
        if (Long.compare(statSize, i2) <= 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((ParcelFileDescriptor)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((ParcelFileDescriptor)object, i2, i3, h4);
    }

    public u<Bitmap> c(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, h h4) {
        return this.a.d(parcelFileDescriptor, i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(ParcelFileDescriptor parcelFileDescriptor, h h2) {
        ParcelFileDescriptor obj1;
        boolean obj2;
        if (e(parcelFileDescriptor) != null && this.a.o(parcelFileDescriptor) != null) {
            obj1 = this.a.o(parcelFileDescriptor) != null ? 1 : 0;
        } else {
        }
        return obj1;
    }
}
