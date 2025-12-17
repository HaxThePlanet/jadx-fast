package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class Preconditions {
    public static void checkArgument(boolean expression) {
        if (!expression) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
        if (!expression) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(errorMessage));
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean expression, String messageTemplate, Object... messageArgs) {
        if (!expression) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(messageTemplate, messageArgs));
        throw illegalArgumentException;
    }

    public static float checkArgumentFinite(float value, String valueName) {
        if (Float.isNaN(value)) {
        } else {
            if (Float.isInfinite(value)) {
            } else {
                return value;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(valueName).append(" must not be infinite").toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append(valueName).append(" must not be NaN").toString());
        throw illegalArgumentException2;
    }

    public static double checkArgumentInRange(double value, double lower, double upper, String valueName) {
        if (Double.compare(value, upper) < 0) {
        } else {
            if (Double.compare(value, obj8) > 0) {
            } else {
                return value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", /* result */));
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", /* result */));
        throw illegalArgumentException2;
    }

    public static float checkArgumentInRange(float value, float lower, float upper, String valueName) {
        if (Float.compare(value, lower) < 0) {
        } else {
            if (Float.compare(value, upper) > 0) {
            } else {
                return value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", /* result */));
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", /* result */));
        throw illegalArgumentException2;
    }

    public static int checkArgumentInRange(int value, int lower, int upper, String valueName) {
        if (value < lower) {
        } else {
            if (value > upper) {
            } else {
                return value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", /* result */));
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", /* result */));
        throw illegalArgumentException2;
    }

    public static long checkArgumentInRange(long value, long lower, long upper, String valueName) {
        if (Long.compare(value, upper) < 0) {
        } else {
            if (Long.compare(value, obj8) > 0) {
            } else {
                return value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", /* result */));
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", /* result */));
        throw illegalArgumentException2;
    }

    public static int checkArgumentNonnegative(int value) {
        if (value < 0) {
        } else {
            return value;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static int checkArgumentNonnegative(int value, String errorMessage) {
        if (value < 0) {
        } else {
            return value;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(errorMessage);
        throw illegalArgumentException;
    }

    public static int checkFlagsArgument(int requestedFlags, int allowedFlags) {
        if (requestedFlags & allowedFlags != requestedFlags) {
        } else {
            return requestedFlags;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Requested flags 0x").append(Integer.toHexString(requestedFlags)).append(", but only 0x").append(Integer.toHexString(allowedFlags)).append(" are allowed").toString());
        throw illegalArgumentException;
    }

    public static <T> T checkNotNull(T t) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException nullPointerException = new NullPointerException();
        throw nullPointerException;
    }

    public static <T> T checkNotNull(T t, Object errorMessage) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException nullPointerException = new NullPointerException(String.valueOf(errorMessage));
        throw nullPointerException;
    }

    public static void checkState(boolean expression) {
        Preconditions.checkState(expression, 0);
    }

    public static void checkState(boolean expression, String message) {
        if (!expression) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw illegalStateException;
    }

    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(T t) {
        if (TextUtils.isEmpty(t)) {
        } else {
            return t;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(T t, Object errorMessage) {
        if (TextUtils.isEmpty(t)) {
        } else {
            return t;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(errorMessage));
        throw illegalArgumentException;
    }

    public static <T extends java.lang.CharSequence> T checkStringNotEmpty(T t, String messageTemplate, Object... messageArgs) {
        if (TextUtils.isEmpty(t)) {
        } else {
            return t;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(messageTemplate, messageArgs));
        throw illegalArgumentException;
    }
}
