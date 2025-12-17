package androidx.core.util;

import android.util.SizeF;

/* loaded from: classes5.dex */
public final class SizeFCompat {

    private final float mHeight;
    private final float mWidth;

    private static final class Api21Impl {
        static SizeF toSizeF(androidx.core.util.SizeFCompat size) {
            Preconditions.checkNotNull(size);
            SizeF sizeF = new SizeF(size.getWidth(), size.getHeight());
            return sizeF;
        }

        static androidx.core.util.SizeFCompat toSizeFCompat(SizeF size) {
            Preconditions.checkNotNull(size);
            SizeFCompat sizeFCompat = new SizeFCompat(size.getWidth(), size.getHeight());
            return sizeFCompat;
        }
    }
    public SizeFCompat(float width, float height) {
        super();
        this.mWidth = Preconditions.checkArgumentFinite(width, "width");
        this.mHeight = Preconditions.checkArgumentFinite(height, "height");
    }

    public static androidx.core.util.SizeFCompat toSizeFCompat(SizeF size) {
        return SizeFCompat.Api21Impl.toSizeFCompat(size);
    }

    public boolean equals(Object o) {
        int i;
        int cmp;
        float mHeight;
        if (this == o) {
            return 1;
        }
        final int i2 = 0;
        if (!o instanceof SizeFCompat) {
            return i2;
        }
        Object obj = o;
        if (Float.compare(mWidth, mHeight) == 0 && Float.compare(mHeight2, mHeight) == 0) {
            if (Float.compare(mHeight2, mHeight) == 0) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return floatToIntBits ^= floatToIntBits2;
    }

    public SizeF toSizeF() {
        return SizeFCompat.Api21Impl.toSizeF(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.mWidth).append("x").append(this.mHeight).toString();
    }
}
