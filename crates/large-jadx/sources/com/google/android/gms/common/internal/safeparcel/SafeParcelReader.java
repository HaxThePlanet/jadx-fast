package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String string, Parcel parcel2) {
            StringBuilder stringBuilder = new StringBuilder(length += 41);
            stringBuilder.append(string);
            stringBuilder.append(" Parcel: pos=");
            stringBuilder.append(parcel2.dataPosition());
            stringBuilder.append(" size=");
            stringBuilder.append(parcel2.dataSize());
            super(stringBuilder.toString());
        }
    }
    public static Bundle a(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.readBundle();
    }

    public static byte[] b(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.createByteArray();
    }

    public static int[] c(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.createIntArray();
    }

    public static <T extends android.os.Parcelable> T d(Parcel parcel, int i2, Parcelable.Creator<T> parcelable$Creator3) {
        final int obj2 = SafeParcelReader.u(parcel, i2);
        if (obj2 == null) {
            return 0;
        }
        parcel.setDataPosition(dataPosition += obj2);
        return (Parcelable)creator3.createFromParcel(parcel);
    }

    public static String e(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.readString();
    }

    public static String[] f(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.createStringArray();
    }

    public static ArrayList<String> g(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return 0;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.createStringArrayList();
    }

    public static <T> T[] h(Parcel parcel, int i2, Parcelable.Creator<T> parcelable$Creator3) {
        final int obj2 = SafeParcelReader.u(parcel, i2);
        if (obj2 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj2);
        return parcel.createTypedArray(creator3);
    }

    public static <T> ArrayList<T> i(Parcel parcel, int i2, Parcelable.Creator<T> parcelable$Creator3) {
        final int obj2 = SafeParcelReader.u(parcel, i2);
        if (obj2 == null) {
            return 0;
        }
        parcel.setDataPosition(dataPosition += obj2);
        return parcel.createTypedArrayList(creator3);
    }

    public static void j(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(i2);
        SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(stringBuilder.toString(), parcel);
        throw parseException;
    }

    public static int k(int i) {
        return (char)i;
    }

    public static boolean l(Parcel parcel, int i2) {
        SafeParcelReader.x(parcel, i2, 4);
        if (parcel.readInt() != 0) {
            return 1;
        }
        return 0;
    }

    public static Boolean m(Parcel parcel, int i2) {
        int obj2;
        final int i = SafeParcelReader.u(parcel, i2);
        if (i == 0) {
            return null;
        }
        SafeParcelReader.y(parcel, i2, i, 4);
        obj2 = parcel.readInt() != 0 ? 1 : 0;
        return Boolean.valueOf(obj2);
    }

    public static Double n(Parcel parcel, int i2) {
        final int i = SafeParcelReader.u(parcel, i2);
        if (i == 0) {
            return null;
        }
        SafeParcelReader.y(parcel, i2, i, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static Float o(Parcel parcel, int i2) {
        final int i = SafeParcelReader.u(parcel, i2);
        if (i == 0) {
            return null;
        }
        SafeParcelReader.y(parcel, i2, i, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int p(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder q(Parcel parcel, int i2) {
        final int obj3 = SafeParcelReader.u(parcel, i2);
        if (obj3 == null) {
            return null;
        }
        parcel.setDataPosition(dataPosition += obj3);
        return parcel.readStrongBinder();
    }

    public static int r(Parcel parcel, int i2) {
        SafeParcelReader.x(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long s(Parcel parcel, int i2) {
        SafeParcelReader.x(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long t(Parcel parcel, int i2) {
        final int i = SafeParcelReader.u(parcel, i2);
        if (i == 0) {
            return null;
        }
        SafeParcelReader.y(parcel, i2, i, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int u(Parcel parcel, int i2) {
        final int i = -65536;
        if (i2 & i != i) {
            return (char)obj2;
        }
        return parcel.readInt();
    }

    public static void v(Parcel parcel, int i2) {
        parcel.setDataPosition(dataPosition += obj2);
    }

    public static int w(Parcel parcel) {
        int dataSize;
        String string;
        dataSize = SafeParcelReader.p(parcel);
        int dataPosition = parcel.dataPosition();
        if (SafeParcelReader.k(dataSize) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(dataSize));
            String str2 = "Expected object header. Got 0x";
            if (valueOf.length() != 0) {
                string = str2.concat(valueOf);
            } else {
                string = new String(str2);
            }
            SafeParcelReader.ParseException parseException2 = new SafeParcelReader.ParseException(string, parcel);
            throw parseException2;
        }
        i += dataPosition;
        if (i2 < dataPosition) {
        } else {
            if (i2 > parcel.dataSize()) {
            } else {
                return i2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Size read is invalid start=");
        stringBuilder.append(dataPosition);
        stringBuilder.append(" end=");
        stringBuilder.append(i2);
        SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(stringBuilder.toString(), parcel);
        throw parseException;
    }

    private static void x(Parcel parcel, int i2, int i3) {
        int obj5 = SafeParcelReader.u(parcel, i2);
        if (obj5 != i3) {
        } else {
        }
        final String hexString = Integer.toHexString(obj5);
        StringBuilder stringBuilder = new StringBuilder(length += 46);
        stringBuilder.append("Expected size ");
        stringBuilder.append(i3);
        stringBuilder.append(" got ");
        stringBuilder.append(obj5);
        stringBuilder.append(" (0x");
        stringBuilder.append(hexString);
        stringBuilder.append(")");
        SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(stringBuilder.toString(), parcel);
        throw parseException;
    }

    private static void y(Parcel parcel, int i2, int i3, int i4) {
        if (i3 != i4) {
        } else {
        }
        final String hexString = Integer.toHexString(i3);
        StringBuilder stringBuilder = new StringBuilder(length += 46);
        stringBuilder.append("Expected size ");
        stringBuilder.append(i4);
        stringBuilder.append(" got ");
        stringBuilder.append(i3);
        stringBuilder.append(" (0x");
        stringBuilder.append(hexString);
        stringBuilder.append(")");
        SafeParcelReader.ParseException obj4 = new SafeParcelReader.ParseException(stringBuilder.toString(), parcel);
        throw obj4;
    }
}
