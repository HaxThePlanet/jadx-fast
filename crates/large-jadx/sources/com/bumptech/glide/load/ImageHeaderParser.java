package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.z.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ImageHeaderParser.java */
/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {

        ANIMATED_WEBP,
        AVIF,
        GIF,
        JPEG,
        PNG,
        PNG_A,
        RAW,
        UNKNOWN,
        WEBP,
        WEBP_A;

        private final boolean hasAlpha;
        @Override // java.lang.Enum
        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        @Override // java.lang.Enum
        public boolean isWebp() {
            int i2 = ImageHeaderParser.a.a[ordinal()];
            int i4 = 1;
            if (ImageHeaderParser.a.a != i4 && ImageHeaderParser.a.a != 2 && ImageHeaderParser.a.a != 3) {
                return false;
            }
            return true;
        }
    }

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ImageHeaderParser.ImageType.values().length];
            ImageHeaderParser.a.a = iArr;
            try {
                iArr[ImageHeaderParser.ImageType.WEBP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                ImageHeaderParser.a.a[ImageHeaderParser.ImageType.WEBP_A.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                ImageHeaderParser.a.a[ImageHeaderParser.ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    ImageHeaderParser.ImageType a(ByteBuffer byteBuffer);

    int b(ByteBuffer byteBuffer, b bVar);

    ImageHeaderParser.ImageType c(InputStream inputStream);

    int d(InputStream inputStream, b bVar);
}
