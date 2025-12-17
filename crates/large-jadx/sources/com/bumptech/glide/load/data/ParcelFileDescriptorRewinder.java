package com.bumptech.glide.load.data;

import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements com.bumptech.glide.load.data.e<ParcelFileDescriptor> {

    private final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.InternalRewinder a;

    private static final class InternalRewinder {

        private final ParcelFileDescriptor a;
        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            super();
            this.a = parcelFileDescriptor;
        }

        ParcelFileDescriptor rewind() {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0, obj2);
                return this.a;
                IOException iOException = new IOException(th);
                throw iOException;
            }
        }
    }

    public static final class a implements com.bumptech.glide.load.data.e.a<ParcelFileDescriptor> {
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.e$a
        public com.bumptech.glide.load.data.e b(Object object) {
            return c((ParcelFileDescriptor)object);
        }

        public com.bumptech.glide.load.data.e<ParcelFileDescriptor> c(ParcelFileDescriptor parcelFileDescriptor) {
            ParcelFileDescriptorRewinder parcelFileDescriptorRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
            return parcelFileDescriptorRewinder;
        }
    }
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        super();
        ParcelFileDescriptorRewinder.InternalRewinder internalRewinder = new ParcelFileDescriptorRewinder.InternalRewinder(parcelFileDescriptor);
        this.a = internalRewinder;
    }

    public static boolean c() {
        int i;
        i = Build.VERSION.SDK_INT >= 21 ? 1 : 0;
        return i;
    }

    @Override // com.bumptech.glide.load.data.e
    public Object a() {
        return d();
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.e
    public ParcelFileDescriptor d() {
        return this.a.rewind();
    }
}
