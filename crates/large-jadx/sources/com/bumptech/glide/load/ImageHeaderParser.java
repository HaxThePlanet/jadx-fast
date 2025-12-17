package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.z.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public static enum ImageType {

        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);

        private final boolean hasAlpha;
        @Override // java.lang.Enum
        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        @Override // java.lang.Enum
        public boolean isWebp() {
            int i;
            int i2 = ImageHeaderParser.a.a[ordinal()];
            int i4 = 1;
            if (i2 != i4 && i2 != 2 && i2 != 3) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return 0;
                    }
                }
            }
            return i4;
        }
    }

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            ImageHeaderParser.a.a = iArr;
            iArr[ImageHeaderParser.ImageType.WEBP.ordinal()] = 1;
            ImageHeaderParser.a.a[ImageHeaderParser.ImageType.WEBP_A.ordinal()] = 2;
            ImageHeaderParser.a.a[ImageHeaderParser.ImageType.ANIMATED_WEBP.ordinal()] = 3;
        }
    }
    public abstract com.bumptech.glide.load.ImageHeaderParser.ImageType a(ByteBuffer byteBuffer);

    public abstract int b(ByteBuffer byteBuffer, b b2);

    public abstract com.bumptech.glide.load.ImageHeaderParser.ImageType c(InputStream inputStream);

    public abstract int d(InputStream inputStream, b b2);
}
