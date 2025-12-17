package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class b {
    public static int a(Parcel parcel) {
        return b.u(parcel, 20293);
    }

    public static void b(Parcel parcel, int i2) {
        b.v(parcel, i2);
    }

    public static void c(Parcel parcel, int i2, boolean z3) {
        b.t(parcel, i2, 4);
        parcel.writeInt(z3);
    }

    public static void d(Parcel parcel, int i2, Boolean boolean3, boolean z4) {
        int obj2;
        if (boolean3 == 0 && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        b.t(parcel, i2, 4);
        parcel.writeInt(boolean3.booleanValue());
    }

    public static void e(Parcel parcel, int i2, Bundle bundle3, boolean z4) {
        int obj2;
        if (bundle3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeBundle(bundle3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void f(Parcel parcel, int i2, byte[] b3Arr3, boolean z4) {
        int obj2;
        if (b3Arr3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeByteArray(b3Arr3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void g(Parcel parcel, int i2, Double double3, boolean z4) {
        int obj2;
        if (double3 == 0 && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        b.t(parcel, i2, 8);
        parcel.writeDouble(double3.doubleValue());
    }

    public static void h(Parcel parcel, int i2, Float float3, boolean z4) {
        int obj2;
        if (float3 == 0 && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        b.t(parcel, i2, 4);
        parcel.writeFloat(float3.floatValue());
    }

    public static void i(Parcel parcel, int i2, IBinder iBinder3, boolean z4) {
        int obj2;
        if (iBinder3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeStrongBinder(iBinder3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void j(Parcel parcel, int i2, int i3) {
        b.t(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void k(Parcel parcel, int i2, int[] i3Arr3, boolean z4) {
        int obj2;
        if (i3Arr3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeIntArray(i3Arr3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void l(Parcel parcel, int i2, long l3) {
        b.t(parcel, i2, 8);
        parcel.writeLong(l3);
    }

    public static void m(Parcel parcel, int i2, Long long3, boolean z4) {
        int obj2;
        if (long3 == 0 && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        b.t(parcel, i2, 8);
        parcel.writeLong(long3.longValue());
    }

    public static void n(Parcel parcel, int i2, Parcelable parcelable3, int i4, boolean z5) {
        int obj2;
        if (parcelable3 == 0 && z5) {
            if (z5) {
                b.t(parcel, i2, 0);
            }
        }
        parcelable3.writeToParcel(parcel, i4);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void o(Parcel parcel, int i2, String string3, boolean z4) {
        int obj2;
        if (string3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeString(string3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void p(Parcel parcel, int i2, String[] string3Arr3, boolean z4) {
        int obj2;
        if (string3Arr3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeStringArray(string3Arr3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static void q(Parcel parcel, int i2, List<String> list3, boolean z4) {
        int obj2;
        if (list3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, 0);
            }
        }
        parcel.writeStringList(list3);
        b.v(parcel, b.u(parcel, i2));
    }

    public static <T extends Parcelable> void r(Parcel parcel, int i2, T[] t3Arr3, int i4, boolean z5) {
        int i;
        Object obj;
        final int i3 = 0;
        if (t3Arr3 == null && z5) {
            if (z5) {
                b.t(parcel, i2, i3);
            }
        }
        final int obj7 = t3Arr3.length;
        parcel.writeInt(obj7);
        i = i3;
        while (i < obj7) {
            obj = t3Arr3[i];
            if (obj == null) {
            } else {
            }
            b.w(parcel, obj, i4);
            i++;
            parcel.writeInt(i3);
        }
        b.v(parcel, b.u(parcel, i2));
    }

    public static <T extends Parcelable> void s(Parcel parcel, int i2, List<T> list3, boolean z4) {
        int i;
        Object obj;
        final int i3 = 0;
        if (list3 == null && z4) {
            if (z4) {
                b.t(parcel, i2, i3);
            }
        }
        final int obj6 = list3.size();
        parcel.writeInt(obj6);
        i = i3;
        while (i < obj6) {
            obj = list3.get(i);
            if ((Parcelable)obj == null) {
            } else {
            }
            b.w(parcel, (Parcelable)obj, i3);
            i++;
            parcel.writeInt(i3);
        }
        b.v(parcel, b.u(parcel, i2));
    }

    private static void t(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 |= obj2);
    }

    private static int u(Parcel parcel, int i2) {
        parcel.writeInt(i2 |= i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void v(Parcel parcel, int i2) {
        final int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 + -4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    private static <T extends Parcelable> void w(Parcel parcel, T t2, int i3) {
        parcel.writeInt(1);
        t2.writeToParcel(parcel, i3);
        final int obj3 = parcel.dataPosition();
        parcel.setDataPosition(parcel.dataPosition());
        parcel.writeInt(obj3 - dataPosition2);
        parcel.setDataPosition(obj3);
    }
}
