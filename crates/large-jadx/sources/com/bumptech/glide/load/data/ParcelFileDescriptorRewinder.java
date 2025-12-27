package com.bumptech.glide.load.data;

import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* compiled from: ParcelFileDescriptorRewinder.java */
/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {

    private final ParcelFileDescriptorRewinder.InternalRewinder a = new ParcelFileDescriptorRewinder$InternalRewinder();

    private static final class InternalRewinder {

        private final ParcelFileDescriptor a;
        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            super();
            this.a = parcelFileDescriptor;
        }

        ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
            } catch (android.system.ErrnoException errno) {
                throw new IOException(errno);
            }
            return this.a;
        }
    }

    public static final class a implements e.a<ParcelFileDescriptor> {
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }

        public e<ParcelFileDescriptor> c(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        super();
        final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.InternalRewinder internalRewinder = new ParcelFileDescriptorRewinder.InternalRewinder(parcelFileDescriptor);
    }

    public static boolean c() {
        boolean z = true;
        int r0 = Build.VERSION.SDK_INT >= 21 ? 1 : 0;
        return (Build.VERSION.SDK_INT >= 21 ? 1 : 0);
    }

    public ParcelFileDescriptor d() {
        return this.a.rewind();
    }

    public void b() {
    }
}
