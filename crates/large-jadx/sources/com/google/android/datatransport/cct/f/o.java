package com.google.android.datatransport.cct.f;

import android.util.SparseArray;

/* loaded from: classes.dex */
public abstract class o {

    public static abstract class a {
        public abstract com.google.android.datatransport.cct.f.o a();

        public abstract com.google.android.datatransport.cct.f.o.a b(com.google.android.datatransport.cct.f.o.b o$b);

        public abstract com.google.android.datatransport.cct.f.o.a c(com.google.android.datatransport.cct.f.o.c o$c);
    }

    public static enum b {

        UNKNOWN_MOBILE_SUBTYPE(false),
        GPRS(true),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(6),
        HSDPA(5),
        HSUPA(4),
        HSPA(3),
        IDEN(2),
        EVDO_B(true),
        LTE(false),
        EHRPD(2),
        HSPAP(true),
        GSM(false),
        TD_SCDMA(2),
        IWLAN(true),
        LTE_CA(false),
        COMBINED(3);

        private final int value;
        public static com.google.android.datatransport.cct.f.o.b forNumber(int i) {
            return (o.b)o.b.valueMap.get(i);
        }

        @Override // java.lang.Enum
        public int getValue() {
            return this.value;
        }
    }

    public static enum c {

        MOBILE(false),
        WIFI(true),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(6),
        DUMMY(5),
        ETHERNET(4),
        MOBILE_FOTA(3),
        MOBILE_IMS(2),
        MOBILE_CBS(true),
        WIFI_P2P(false),
        MOBILE_IA(2),
        MOBILE_EMERGENCY(true),
        PROXY(false),
        VPN(2),
        NONE(3);

        private final int value;
        public static com.google.android.datatransport.cct.f.o.c forNumber(int i) {
            return (o.c)o.c.valueMap.get(i);
        }

        @Override // java.lang.Enum
        public int getValue() {
            return this.value;
        }
    }
    public static com.google.android.datatransport.cct.f.o.a a() {
        i.b bVar = new i.b();
        return bVar;
    }

    public abstract com.google.android.datatransport.cct.f.o.b b();

    public abstract com.google.android.datatransport.cct.f.o.c c();
}
