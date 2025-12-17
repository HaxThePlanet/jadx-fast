package androidx.core.util;

import android.app.Notification.Action;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class TypedValueCompat {

    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    private static class Api34Impl {
        public static float deriveDimension(int unitToConvertTo, float pixelValue, DisplayMetrics metrics) {
            return TypedValue.deriveDimension(unitToConvertTo, pixelValue, metrics);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }
    public static float deriveDimension(int unitToConvertTo, float pixelValue, DisplayMetrics metrics) {
        if (Build.VERSION.SDK_INT >= 34) {
            return TypedValueCompat.Api34Impl.deriveDimension(unitToConvertTo, pixelValue, metrics);
        }
        int i = 0;
        switch (unitToConvertTo) {
            case 0:
                return pixelValue;
            case 1:
                return i;
                return pixelValue / density;
            case 2:
                return i;
                return pixelValue / scaledDensity;
            case 3:
                return i;
                return i5 /= i11;
            case 4:
                return i;
                return pixelValue / xdpi2;
            case 5:
                return i;
                return i2 /= i10;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid unitToConvertTo ").append(unitToConvertTo).toString());
                throw illegalArgumentException;
        }
    }

    public static float dpToPx(float dpValue, DisplayMetrics metrics) {
        return TypedValue.applyDimension(1, dpValue, metrics);
    }

    public static int getUnitFromComplexDimension(int complexDimension) {
        return i &= 15;
    }

    public static float pxToDp(float pixelValue, DisplayMetrics metrics) {
        return TypedValueCompat.deriveDimension(1, pixelValue, metrics);
    }

    public static float pxToSp(float pixelValue, DisplayMetrics metrics) {
        return TypedValueCompat.deriveDimension(2, pixelValue, metrics);
    }

    public static float spToPx(float spValue, DisplayMetrics metrics) {
        return TypedValue.applyDimension(2, spValue, metrics);
    }
}
