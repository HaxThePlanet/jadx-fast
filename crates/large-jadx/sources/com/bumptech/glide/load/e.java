package com.bumptech.glide.load;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.resource.bitmap.w;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    private interface g {
        public abstract int a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser);
    }

    private interface h {
        public abstract com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser);
    }

    class a implements com.bumptech.glide.load.e.h {

        final InputStream a;
        a(InputStream inputStream) {
            this.a = inputStream;
            super();
        }

        @Override // com.bumptech.glide.load.e$h
        public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
            try {
                this.a.reset();
                return imageHeaderParser.c(this.a);
                this.a.reset();
                throw imageHeaderParser;
            }
        }
    }

    class b implements com.bumptech.glide.load.e.h {

        final ByteBuffer a;
        b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            super();
        }

        @Override // com.bumptech.glide.load.e$h
        public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.a(this.a);
        }
    }

    class c implements com.bumptech.glide.load.e.h {

        final ParcelFileDescriptorRewinder a;
        final b b;
        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, b b2) {
            this.a = parcelFileDescriptorRewinder;
            this.b = b2;
            super();
        }

        @Override // com.bumptech.glide.load.e$h
        public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
            int i = 0;
            FileInputStream fileInputStream = new FileInputStream(this.a.d().getFileDescriptor());
            w wVar = new w(fileInputStream, this.b);
            wVar.close();
            this.a.d();
            return imageHeaderParser.c(wVar);
        }
    }

    class d implements com.bumptech.glide.load.e.g {

        final ByteBuffer a;
        final b b;
        d(ByteBuffer byteBuffer, b b2) {
            this.a = byteBuffer;
            this.b = b2;
            super();
        }

        @Override // com.bumptech.glide.load.e$g
        public int a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.b(this.a, this.b);
        }
    }

    class e implements com.bumptech.glide.load.e.g {

        final InputStream a;
        final b b;
        e(InputStream inputStream, b b2) {
            this.a = inputStream;
            this.b = b2;
            super();
        }

        @Override // com.bumptech.glide.load.e$g
        public int a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
            try {
                this.a.reset();
                return imageHeaderParser.d(this.a, this.b);
                this.a.reset();
                throw imageHeaderParser;
            }
        }
    }

    class f implements com.bumptech.glide.load.e.g {

        final ParcelFileDescriptorRewinder a;
        final b b;
        f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, b b2) {
            this.a = parcelFileDescriptorRewinder;
            this.b = b2;
            super();
        }

        @Override // com.bumptech.glide.load.e$g
        public int a(com.bumptech.glide.load.ImageHeaderParser imageHeaderParser) {
            int i = 0;
            FileInputStream fileInputStream = new FileInputStream(this.a.d().getFileDescriptor());
            w wVar = new w(fileInputStream, this.b);
            wVar.close();
            this.a.d();
            return imageHeaderParser.d(wVar, this.b);
        }
    }
    public static int a(List<com.bumptech.glide.load.ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder2, b b3) {
        e.f fVar = new e.f(parcelFileDescriptorRewinder2, b3);
        return e.d(list, fVar);
    }

    public static int b(List<com.bumptech.glide.load.ImageHeaderParser> list, InputStream inputStream2, b b3) {
        boolean markSupported;
        Object obj2;
        if (inputStream2 == null) {
            return -1;
        }
        if (!inputStream2.markSupported()) {
            markSupported = new w(inputStream2, b3);
            obj2 = markSupported;
        }
        obj2.mark(5242880);
        e.e eVar = new e.e(obj2, b3);
        return e.d(list, eVar);
    }

    public static int c(List<com.bumptech.glide.load.ImageHeaderParser> list, ByteBuffer byteBuffer2, b b3) {
        if (byteBuffer2 == null) {
            return -1;
        }
        e.d dVar = new e.d(byteBuffer2, b3);
        return e.d(list, dVar);
    }

    private static int d(List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.e.g e$g2) {
        int i2;
        int i;
        int i3;
        i2 = 0;
        i = -1;
        while (i2 < list.size()) {
            i3 = g2.a((ImageHeaderParser)list.get(i2));
            i2++;
            i = -1;
        }
        return i;
    }

    public static com.bumptech.glide.load.ImageHeaderParser.ImageType e(List<com.bumptech.glide.load.ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder2, b b3) {
        e.c cVar = new e.c(parcelFileDescriptorRewinder2, b3);
        return e.h(list, cVar);
    }

    public static com.bumptech.glide.load.ImageHeaderParser.ImageType f(List<com.bumptech.glide.load.ImageHeaderParser> list, InputStream inputStream2, b b3) {
        boolean markSupported;
        Object obj2;
        if (inputStream2 == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream2.markSupported()) {
            markSupported = new w(inputStream2, b3);
            obj2 = markSupported;
        }
        obj2.mark(5242880);
        e.a obj3 = new e.a(obj2);
        return e.h(list, obj3);
    }

    public static com.bumptech.glide.load.ImageHeaderParser.ImageType g(List<com.bumptech.glide.load.ImageHeaderParser> list, ByteBuffer byteBuffer2) {
        if (byteBuffer2 == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        e.b bVar = new e.b(byteBuffer2);
        return e.h(list, bVar);
    }

    private static com.bumptech.glide.load.ImageHeaderParser.ImageType h(List<com.bumptech.glide.load.ImageHeaderParser> list, com.bumptech.glide.load.e.h e$h2) {
        int i;
        com.bumptech.glide.load.ImageHeaderParser.ImageType imageType;
        com.bumptech.glide.load.ImageHeaderParser.ImageType uNKNOWN;
        i = 0;
        while (i < list.size()) {
            imageType = h2.a((ImageHeaderParser)list.get(i));
            i++;
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
