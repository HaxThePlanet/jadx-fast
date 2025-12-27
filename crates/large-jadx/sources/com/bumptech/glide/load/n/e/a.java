package com.bumptech.glide.load.n.e;

import android.graphics.Bitmap.Config;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.Source;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: AnimatedWebpDecoder.java */
/* loaded from: classes.dex */
public final class a {

    private final List<ImageHeaderParser> a;
    private final b b;

    private static final class a implements u<Drawable> {

        private final AnimatedImageDrawable a;
        a(AnimatedImageDrawable animatedImageDrawable) {
            super();
            this.a = animatedImageDrawable;
        }

        public void a() {
            this.a.stop();
            this.a.clearAnimationCallbacks();
        }

        public Class<Drawable> b() {
            return Drawable.class;
        }

        public AnimatedImageDrawable c() {
            return this.a;
        }

        public int getSize() {
            return (this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight()) * l.h(Bitmap.Config.ARGB_8888) * 2;
        }
    }

    private static final class b implements j<ByteBuffer, Drawable> {

        private final a a;
        b() {
            super();
            this.a = aVar;
        }

        public u<Drawable> c(ByteBuffer byteBuffer, int i, int i2, h hVar) {
            return this.a.b(ImageDecoder.createSource(byteBuffer), i, i2, hVar);
        }

        public boolean d(ByteBuffer byteBuffer, h hVar) {
            return this.a.d(byteBuffer);
        }
    }

    private static final class c implements j<InputStream, Drawable> {

        private final a a;
        c() {
            super();
            this.a = aVar;
        }

        public u<Drawable> c(InputStream inputStream, int i, int i2, h hVar) {
            return this.a.b(ImageDecoder.createSource(a.b(inputStream)), i, i2, hVar);
        }

        public boolean d(InputStream inputStream, h hVar) {
            return this.a.c(inputStream);
        }
    }
    private a(List<ImageHeaderParser> list, b bVar) {
        super();
        this.a = list;
        this.b = bVar;
    }

    public static j<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, b bVar) {
        return new a.b(new a(list, bVar));
    }

    private boolean e(ImageHeaderParser.ImageType imageType) {
        boolean z = true;
        imageType = imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP ? 1 : 0;
        return (imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP ? 1 : 0);
    }

    public static j<InputStream, Drawable> f(List<ImageHeaderParser> list, b bVar) {
        return new a.c(new a(list, bVar));
    }

    u<Drawable> b(ImageDecoder.Source source, int i, int i2, h hVar) throws IOException {
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new a(i, i2, hVar));
        if (!(decodeDrawable instanceof AnimatedImageDrawable)) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Received unexpected drawable type for animated webp, failing: ";
            source = str + decodeDrawable;
            throw new IOException(source);
        } else {
            return new a.a(decodeDrawable);
        }
    }

    boolean c(InputStream inputStream) {
        return e(e.f(this.a, inputStream, this.b));
    }

    boolean d(ByteBuffer byteBuffer) {
        return e(e.g(this.a, byteBuffer));
    }
}
