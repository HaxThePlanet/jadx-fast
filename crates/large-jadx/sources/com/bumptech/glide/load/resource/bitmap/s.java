package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.t.a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageReader.java */
/* loaded from: classes.dex */
interface s {

    public static final class a implements s {

        private final ByteBuffer a;
        private final List<ImageHeaderParser> b;
        private final b c;
        a(ByteBuffer byteBuffer, List<ImageHeaderParser> list, b bVar) {
            super();
            this.a = byteBuffer;
            this.b = list;
            this.c = bVar;
        }

        private InputStream e() {
            return a.g(a.d(this.a));
        }

        public int a() {
            return e.c(this.b, a.d(this.a), this.c);
        }

        public Bitmap b(BitmapFactory.Options options) throws java.io.IOException {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        public ImageHeaderParser.ImageType d() {
            return e.g(this.b, a.d(this.a));
        }

        public void c() {
        }
    }

    public static final class b implements s {

        private final com.bumptech.glide.load.data.k a = new k();
        private final b b;
        private final List<ImageHeaderParser> c;
        b(InputStream inputStream, List<ImageHeaderParser> list, b bVar) {
            super();
            k.d(bVar);
            this.b = (b)bVar;
            k.d(list);
            this.c = list;
            final com.bumptech.glide.load.data.k kVar = new k(inputStream, bVar);
        }

        public int a() {
            return e.b(this.c, this.a.d(), this.b);
        }

        public Bitmap b(BitmapFactory.Options options) throws java.io.IOException {
            return BitmapFactory.decodeStream(this.a.d(), null, options);
        }

        public void c() {
            this.a.c();
        }

        public ImageHeaderParser.ImageType d() {
            return e.f(this.c, this.a.d(), this.b);
        }
    }

    public static final class c implements s {

        private final b a;
        private final List<ImageHeaderParser> b;
        private final ParcelFileDescriptorRewinder c = new ParcelFileDescriptorRewinder();
        c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, b bVar) {
            super();
            k.d(bVar);
            this.a = bVar;
            k.d(list);
            this.b = list;
            final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public int a() {
            return e.a(this.b, this.c, this.a);
        }

        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), null, options);
        }

        public ImageHeaderParser.ImageType d() {
            return e.e(this.b, this.c, this.a);
        }

        public void c() {
        }
    }
    int a();

    Bitmap b(BitmapFactory.Options options);

    void c();

    ImageHeaderParser.ImageType d();
}
