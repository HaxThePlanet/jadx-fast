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

/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class e {

    private interface g {
        int a(ImageHeaderParser imageHeaderParser);
    }

    private interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    class a implements e.h {

        final /* synthetic */ InputStream a;
        a(InputStream inputStream) {
            this.a = inputStream;
            super();
        }

        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
            } finally {
                this.a.reset();
                throw imageHeaderParser;
            }
            this.a.reset();
            return imageHeaderParser.c(this.a);
        }
    }

    class b implements e.h {

        final /* synthetic */ ByteBuffer a;
        b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            super();
        }

        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.a(this.a);
        }
    }

    class c implements e.h {

        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ b b;
        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = bVar;
            super();
        }

        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                final w wVar = new w(new FileInputStream(this.a.d().getFileDescriptor()), this.b);
            } catch (Throwable th) {
            }
            try {
            } catch (java.io.IOException unused) {
                this.a.d();
                throw th;
            }
            try {
                wVar.close();
            } catch (java.io.IOException unused) {
                this.a.d();
                return th.c(wVar);
            }
        }
    }

    class d implements e.g {

        final /* synthetic */ ByteBuffer a;
        final /* synthetic */ b b;
        d(ByteBuffer byteBuffer, b bVar) {
            this.a = byteBuffer;
            this.b = bVar;
            super();
        }

        public int a(ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.b(this.a, this.b);
        }
    }

    class e implements e.g {

        final /* synthetic */ InputStream a;
        final /* synthetic */ b b;
        e(InputStream inputStream, b bVar) {
            this.a = inputStream;
            this.b = bVar;
            super();
        }

        public int a(ImageHeaderParser imageHeaderParser) {
            try {
            } finally {
                this.a.reset();
                throw imageHeaderParser;
            }
            this.a.reset();
            return imageHeaderParser.d(this.a, this.b);
        }
    }

    class f implements e.g {

        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ b b;
        f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = bVar;
            super();
        }

        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                final w wVar = new w(new FileInputStream(this.a.d().getFileDescriptor()), this.b);
            } catch (Throwable th) {
            }
            try {
            } catch (java.io.IOException unused) {
                this.a.d();
                throw th;
            }
            try {
                wVar.close();
            } catch (java.io.IOException unused) {
                this.a.d();
                return th.d(wVar, this.b);
            }
        }
    }
    public static int a(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, b bVar) {
        return e.d(list, new e.f(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(List<ImageHeaderParser> list, InputStream inputStream, b bVar) {
        Object obj;
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
        }
        obj.mark(5242880);
        return e.d(list, new e.e(obj, bVar));
    }

    public static int c(List<ImageHeaderParser> list, ByteBuffer byteBuffer, b bVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return e.d(list, new e.d(byteBuffer, bVar));
    }

    private static int d(List<ImageHeaderParser> list, e.g gVar) {
        int i = 0;
        i = 0;
        int i2 = -1;
        while (i < list.size()) {
            int i3 = gVar.a((ImageHeaderParser)list.get(i));
            if (i3 != i2) {
                return i3;
            }
        }
        return i2;
    }

    public static ImageHeaderParser.ImageType e(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, b bVar) {
        return e.h(list, new e.c(parcelFileDescriptorRewinder, bVar));
    }

    public static ImageHeaderParser.ImageType f(List<ImageHeaderParser> list, InputStream inputStream, b bVar) {
        Object obj;
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
        }
        obj.mark(5242880);
        return e.h(list, new e.a(obj));
    }

    public static ImageHeaderParser.ImageType g(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return e.h(list, new e.b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType h(List<ImageHeaderParser> list, e.h hVar) {
        int i = 0;
        i = 0;
        while (i < list.size()) {
            com.bumptech.glide.load.ImageHeaderParser.ImageType imageType = hVar.a((ImageHeaderParser)list.get(i));
            if (imageType != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageType;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
