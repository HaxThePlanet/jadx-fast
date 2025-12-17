package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.t.a;
import com.bumptech.glide.t.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
interface s {

    public static final class a implements com.bumptech.glide.load.resource.bitmap.s {

        private final ByteBuffer a;
        private final List<ImageHeaderParser> b;
        private final b c;
        a(ByteBuffer byteBuffer, List<ImageHeaderParser> list2, b b3) {
            super();
            this.a = byteBuffer;
            this.b = list2;
            this.c = b3;
        }

        private InputStream e() {
            return a.g(a.d(this.a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public int a() {
            return e.c(this.b, a.d(this.a), this.c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public Bitmap b(BitmapFactory.Options bitmapFactory$Options) {
            return BitmapFactory.decodeStream(e(), 0, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public ImageHeaderParser.ImageType d() {
            return e.g(this.b, a.d(this.a));
        }
    }

    public static final class b implements com.bumptech.glide.load.resource.bitmap.s {

        private final k a;
        private final b b;
        private final List<ImageHeaderParser> c;
        b(InputStream inputStream, List<ImageHeaderParser> list2, b b3) {
            super();
            k.d(b3);
            this.b = (b)b3;
            k.d(list2);
            this.c = (List)list2;
            k obj3 = new k(inputStream, b3);
            this.a = obj3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public int a() {
            return e.b(this.c, this.a.d(), this.b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public Bitmap b(BitmapFactory.Options bitmapFactory$Options) {
            return BitmapFactory.decodeStream(this.a.d(), 0, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public void c() {
            this.a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public ImageHeaderParser.ImageType d() {
            return e.f(this.c, this.a.d(), this.b);
        }
    }

    public static final class c implements com.bumptech.glide.load.resource.bitmap.s {

        private final b a;
        private final List<ImageHeaderParser> b;
        private final ParcelFileDescriptorRewinder c;
        c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list2, b b3) {
            super();
            k.d(b3);
            this.a = (b)b3;
            k.d(list2);
            this.b = (List)list2;
            ParcelFileDescriptorRewinder obj2 = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
            this.c = obj2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public int a() {
            return e.a(this.b, this.c, this.a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public Bitmap b(BitmapFactory.Options bitmapFactory$Options) {
            return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), 0, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.s
        public ImageHeaderParser.ImageType d() {
            return e.e(this.b, this.c, this.a);
        }
    }
    public abstract int a();

    public abstract Bitmap b(BitmapFactory.Options bitmapFactory$Options);

    public abstract void c();

    public abstract ImageHeaderParser.ImageType d();
}
