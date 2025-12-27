package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;

/* compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* loaded from: classes.dex */
public final class v implements j<ParcelFileDescriptor, Bitmap> {

    private final m a;
    public v(m mVar) {
        super();
        this.a = mVar;
    }

    private boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        boolean z = false;
        mANUFACTURER2 = Build.MANUFACTURER;
        z = true;
        if (!"HUAWEI".equalsIgnoreCase(mANUFACTURER2)) {
            return true;
        }
        long statSize = parcelFileDescriptor.getStatSize();
        if (statSize > 536870912) {
            int i = 0;
        }
        return z;
    }

    public u<Bitmap> c(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, h hVar) {
        return this.a.d(parcelFileDescriptor, i, i2, hVar);
    }

    public boolean d(ParcelFileDescriptor parcelFileDescriptor, h hVar) {
        boolean z3 = false;
        boolean z2;
        if (e(parcelFileDescriptor) != null) {
            parcelFileDescriptor = this.a.o(parcelFileDescriptor) != null ? 1 : 0;
        }
        return (this.a.o(parcelFileDescriptor) != null ? 1 : 0);
    }
}
