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
import com.bumptech.glide.load.n.a;
import com.bumptech.glide.t.a;
import com.bumptech.glide.t.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

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

        @Override // com.bumptech.glide.load.engine.u
        public void a() {
            this.a.stop();
            this.a.clearAnimationCallbacks();
        }

        public Class<Drawable> b() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.u
        public AnimatedImageDrawable c() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.engine.u
        public Object get() {
            return c();
        }

        @Override // com.bumptech.glide.load.engine.u
        public int getSize() {
            return i2 *= 2;
        }
    }

    private static final class b implements j<ByteBuffer, Drawable> {

        private final com.bumptech.glide.load.n.e.a a;
        b(com.bumptech.glide.load.n.e.a a) {
            super();
            this.a = a;
        }

        @Override // com.bumptech.glide.load.j
        public boolean a(Object object, h h2) {
            return d((ByteBuffer)object, h2);
        }

        @Override // com.bumptech.glide.load.j
        public u b(Object object, int i2, int i3, h h4) {
            return c((ByteBuffer)object, i2, i3, h4);
        }

        public u<Drawable> c(ByteBuffer byteBuffer, int i2, int i3, h h4) {
            return this.a.b(ImageDecoder.createSource(byteBuffer), i2, i3, h4);
        }

        @Override // com.bumptech.glide.load.j
        public boolean d(ByteBuffer byteBuffer, h h2) {
            return this.a.d(byteBuffer);
        }
    }

    private static final class c implements j<InputStream, Drawable> {

        private final com.bumptech.glide.load.n.e.a a;
        c(com.bumptech.glide.load.n.e.a a) {
            super();
            this.a = a;
        }

        @Override // com.bumptech.glide.load.j
        public boolean a(Object object, h h2) {
            return d((InputStream)object, h2);
        }

        @Override // com.bumptech.glide.load.j
        public u b(Object object, int i2, int i3, h h4) {
            return c((InputStream)object, i2, i3, h4);
        }

        public u<Drawable> c(InputStream inputStream, int i2, int i3, h h4) {
            return this.a.b(ImageDecoder.createSource(a.b(inputStream)), i2, i3, h4);
        }

        @Override // com.bumptech.glide.load.j
        public boolean d(InputStream inputStream, h h2) {
            return this.a.c(inputStream);
        }
    }
    private a(List<ImageHeaderParser> list, b b2) {
        super();
        this.a = list;
        this.b = b2;
    }

    public static j<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, b b2) {
        a aVar = new a(list, b2);
        a.b bVar = new a.b(aVar);
        return bVar;
    }

    private boolean e(ImageHeaderParser.ImageType imageHeaderParser$ImageType) {
        int obj2;
        obj2 = imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP ? 1 : 0;
        return obj2;
    }

    public static j<InputStream, Drawable> f(List<ImageHeaderParser> list, b b2) {
        a aVar = new a(list, b2);
        a.c cVar = new a.c(aVar);
        return cVar;
    }

    u<Drawable> b(ImageDecoder.Source imageDecoder$Source, int i2, int i3, h h4) {
        a aVar = new a(i2, i3, h4);
        Drawable obj2 = ImageDecoder.decodeDrawable(source, aVar);
        if (!obj2 instanceof AnimatedImageDrawable) {
        } else {
            a.a obj3 = new a.a((AnimatedImageDrawable)obj2);
            return obj3;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Received unexpected drawable type for animated webp, failing: ");
        obj4.append(obj2);
        obj3 = new IOException(obj4.toString());
        throw obj3;
    }

    boolean c(InputStream inputStream) {
        return e(e.f(this.a, inputStream, this.b));
    }

    boolean d(ByteBuffer byteBuffer) {
        return e(e.g(this.a, byteBuffer));
    }
}
