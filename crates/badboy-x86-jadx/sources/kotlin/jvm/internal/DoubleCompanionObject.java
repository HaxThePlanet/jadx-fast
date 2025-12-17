package kotlin.jvm.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0002R\u0016\u0010\u0008\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000b\u0010\u0002R\u0016\u0010\u000c\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\r\u0010\u0002R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0002R\u0016\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0012\u0010\u0002¨\u0006\u0018", d2 = {"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE$annotations", "MIN_VALUE", "getMIN_VALUE$annotations", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY$annotations", "NaN", "getNaN$annotations", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY$annotations", "SIZE_BITS", "", "getSIZE_BITS$annotations", "SIZE_BYTES", "getSIZE_BYTES$annotations", "getMAX_VALUE", "getMIN_VALUE", "getNEGATIVE_INFINITY", "getNaN", "getPOSITIVE_INFINITY", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DoubleCompanionObject {

    public static final kotlin.jvm.internal.DoubleCompanionObject INSTANCE = null;
    public static final double MAX_VALUE = 179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000d;
    public static final double MIN_VALUE = 0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005d;
    public static final double NEGATIVE_INFINITY = -infd;
    public static final double NaN = NaNd;
    public static final double POSITIVE_INFINITY = infd;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    static {
        DoubleCompanionObject doubleCompanionObject = new DoubleCompanionObject();
        DoubleCompanionObject.INSTANCE = doubleCompanionObject;
    }

    public static void getMAX_VALUE$annotations() {
    }

    public static void getMIN_VALUE$annotations() {
    }

    public static void getNEGATIVE_INFINITY$annotations() {
    }

    public static void getNaN$annotations() {
    }

    public static void getPOSITIVE_INFINITY$annotations() {
    }

    public static void getSIZE_BITS$annotations() {
    }

    public static void getSIZE_BYTES$annotations() {
    }

    public final double getMAX_VALUE() {
        return 9218868437227405311L;
    }

    public final double getMIN_VALUE() {
        return 1;
    }

    public final double getNEGATIVE_INFINITY() {
        return -4503599627370496L;
    }

    public final double getNaN() {
        return 9221120237041090560L;
    }

    public final double getPOSITIVE_INFINITY() {
        return 9218868437227405312L;
    }
}
