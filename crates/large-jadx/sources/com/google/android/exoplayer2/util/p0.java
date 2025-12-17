package com.google.android.exoplayer2.util;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import android.widget.ImageButton;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.m2.k.d.a;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.api.internal.i0;
import com.google.android.gms.internal.firebase-auth-api.j2;
import com.google.android.gms.internal.firebase-auth-api.yp;
import com.google.android.gms.measurement.internal.g5;
import com.google.android.material.appbar.d;
import com.google.common.base.b;
import com.google.common.base.d;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.database.collection.R.styleable;
import com.google.firebase.events.Event;
import com.google.firebase.firestore.util.Util;
import com.google.firebase.inappmessaging.display.R.styleable;
import com.google.firebase.inappmessaging.display.ktx.R.id;
import com.google.firebase.inappmessaging.ktx.R.id;
import com.google.firebase.perf.R.styleable;
import com.google.firebase.storage.R.dimen;
import com.google.firebase.storage.o;
import com.google.protobuf.k;
import com.googlecode.mp4parser.boxes.dece.AssetInformationBox;
import com.revenuecat.purchases.api.R.styleable;
import com.revenuecat.purchases.identity.R.string;
import com.revenuecat.purchases.subscriberattributes.R.id;
import com.vimeo.networking.model.playback.Drm;
import f.c.a.e.d0.k;
import f.c.a.e.q.b;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class p0 {

    public static final int a = 30;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    private static final Pattern g;
    private static final Pattern h;
    private static HashMap<String, String> i;
    private static final String[] j;
    private static final String[] k;
    private static final int[] l;
    static {
        String cODENAME = Build.VERSION.CODENAME;
        if ("S".equals(cODENAME)) {
            int i2 = 31;
        }
        if ("R".equals(cODENAME)) {
            int i3 = 30;
        }
        String dEVICE = Build.DEVICE;
        p0.b = dEVICE;
        String mANUFACTURER = Build.MANUFACTURER;
        p0.c = mANUFACTURER;
        String mODEL = Build.MODEL;
        p0.d = mODEL;
        StringBuilder stringBuilder = new StringBuilder(i10 += length3);
        stringBuilder.append(dEVICE);
        String str7 = ", ";
        stringBuilder.append(str7);
        stringBuilder.append(mODEL);
        stringBuilder.append(str7);
        stringBuilder.append(mANUFACTURER);
        stringBuilder.append(str7);
        stringBuilder.append(Build.VERSION.SDK_INT);
        p0.e = stringBuilder.toString();
        p0.f = new byte[0];
        p0.g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        p0.h = Pattern.compile("%([A-Fa-f0-9]{2})");
        Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        p0.j = /* result */;
        p0.k = /* result */;
        int[] iArr = new int[256];
        iArr = new int[]{
            0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535,
            797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929,
            1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891,
            1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643,
            -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409,
            -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623,
            -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412,
            771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010,
            2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128,
            1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818,
            -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188,
            -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246,
            -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281,
            1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463,
            1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301,
            1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555,
            -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943,
            -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337,
            -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819,
            -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660,
            2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886,
            404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920,
            613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318,
            -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492,
            -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458,
            -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108
        };
        p0.l = iArr;
    }

    public static String A(byte[] bArr) {
        String string = new String(bArr, d.c);
        return string;
    }

    public static void A0(Throwable throwable) {
        p0.B0(throwable);
        throw 0;
    }

    public static String B(byte[] bArr, int i2, int i3) {
        String string = new String(bArr, i2, i3, d.c);
        return string;
    }

    private static <T extends Throwable> void B0(Throwable throwable) {
        throw throwable;
    }

    public static int C(int i) {
        final int i2 = 0;
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int obj3 = p0.a;
                final int i5 = 6396;
                return i5;
                return i5;
                return i2;
            default:
                return i2;
        }
    }

    public static String[] C0(String string, String string2) {
        return string.split(string2, -1);
    }

    public static int D(ByteBuffer byteBuffer, int i2) {
        int obj2;
        if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
        } else {
            obj2 = Integer.reverseBytes(byteBuffer.getInt(i2));
        }
        return obj2;
    }

    public static String[] D0(String string, String string2) {
        return string.split(string2, 2);
    }

    public static int E(String string, int i2) {
        int i;
        int i3;
        int i4;
        final String[] obj4 = p0.E0(string);
        i3 = i;
        while (i < obj4.length) {
            if (i2 == z.m(obj4[i])) {
            }
            i++;
            i3++;
        }
        return i3;
    }

    public static String[] E0(String string) {
        if (TextUtils.isEmpty(string)) {
            return new String[0];
        }
        return p0.C0(string.trim(), "(\\s*,\\s*)");
    }

    public static String F(String string, int i2) {
        int string2;
        int i;
        String str;
        int length;
        String[] obj6 = p0.E0(string);
        if (obj6.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < obj6.length) {
            str = obj6[i];
            if (i2 == z.m(str) && stringBuilder.length() > 0) {
            }
            i++;
            if (stringBuilder.length() > 0) {
            }
            stringBuilder.append(str);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static boolean F0(SQLiteDatabase sQLiteDatabase, String string2) {
        int i;
        final String[] strArr = new String[1];
        final int i2 = 0;
        strArr[i2] = string2;
        if (Long.compare(obj5, i3) > 0) {
        } else {
            i = i2;
        }
        return i;
    }

    public static String G(Context context) {
        String empty;
        Object obj1;
        obj1 = context.getSystemService("phone");
        obj1 = (TelephonyManager)obj1.getNetworkCountryIso();
        if (context != null && obj1 != null && !TextUtils.isEmpty(obj1)) {
            obj1 = context.getSystemService("phone");
            if ((TelephonyManager)obj1 != null) {
                obj1 = (TelephonyManager)obj1.getNetworkCountryIso();
                if (!TextUtils.isEmpty(obj1)) {
                    return b.e(obj1);
                }
            }
        }
        return b.e(Locale.getDefault().getCountry());
    }

    public static byte[] G0(InputStream inputStream) {
        int read;
        int i;
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        read = inputStream.read(bArr);
        while (read != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Point H(Context context) {
        int systemService;
        int defaultDisplay;
        int i;
        systemService = context.getSystemService("display");
        if (p0.a >= 17 && (DisplayManager)systemService != null) {
            systemService = context.getSystemService("display");
            if ((DisplayManager)(DisplayManager)systemService != null) {
                defaultDisplay = (DisplayManager)(DisplayManager)systemService.getDisplay(0);
            } else {
                defaultDisplay = 0;
            }
        } else {
        }
        if (defaultDisplay == 0) {
            Object systemService2 = context.getSystemService("window");
            g.e((WindowManager)systemService2);
            defaultDisplay = (WindowManager)systemService2.getDefaultDisplay();
        }
        return p0.I(context, defaultDisplay);
    }

    public static long H0(int i, int i2) {
        return obj2 |= i3;
    }

    public static Point I(Context context, Display display2) {
        String concat;
        int startsWith;
        boolean empty;
        String[] int;
        String str;
        int i2;
        int length2;
        int length;
        int i;
        Context obj4;
        if (display2.getDisplayId() == 0 && p0.j0(context)) {
            if (p0.j0(context)) {
                if (p0.a < 28) {
                    concat = p0.b0("sys.display-size");
                } else {
                    concat = p0.b0("vendor.display-size");
                }
                int = p0.C0(concat.trim(), "x");
                length = Integer.parseInt(int[0]);
                int = Integer.parseInt(int[1]);
                if (!TextUtils.isEmpty(concat) && int.length == 2 && length > 0 && int > 0) {
                    int = p0.C0(concat.trim(), "x");
                    if (int.length == 2) {
                        length = Integer.parseInt(int[0]);
                        int = Integer.parseInt(int[1]);
                        if (length > 0) {
                            if (int > 0) {
                                Point point = new Point(length, int);
                                return point;
                            }
                        }
                    }
                    String str7 = "Invalid display size: ";
                    String valueOf = String.valueOf(concat);
                    if (valueOf.length() != 0) {
                        concat = str7.concat(valueOf);
                    } else {
                        concat = new String(str7);
                    }
                    v.c("Util", concat);
                }
                if ("Sony".equals(p0.c) && p0.d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                    if (p0.d.startsWith("BRAVIA")) {
                        if (context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                            obj4 = new Point(3840, 2160);
                            return obj4;
                        }
                    }
                }
            }
        }
        obj4 = new Point();
        int i5 = p0.a;
        if (i5 >= 23) {
            p0.M(display2, obj4);
        } else {
            if (i5 >= 17) {
                p0.L(display2, obj4);
            } else {
                p0.K(display2, obj4);
            }
        }
        return obj4;
    }

    public static long I0(int i) {
        return l &= l2;
    }

    public static Looper J() {
        Looper mainLooper;
        if (Looper.myLooper() != null) {
        } else {
            mainLooper = Looper.getMainLooper();
        }
        return mainLooper;
    }

    public static java.lang.CharSequence J0(java.lang.CharSequence charSequence, int i2) {
        int length;
        java.lang.CharSequence obj1;
        if (charSequence.length() <= i2) {
        } else {
            obj1 = charSequence.subSequence(0, i2);
        }
        return obj1;
    }

    private static void K(Display display, Point point2) {
        display.getSize(point2);
    }

    public static String K0(String string) {
        int i2;
        int i3;
        int i4;
        char charAt;
        int i;
        char find;
        int start;
        final int length = string.length();
        i4 = i3;
        while (i3 < length) {
            if (string.charAt(i3) == 37) {
            }
            i3++;
            i4++;
        }
        if (i4 == 0) {
            return string;
        }
        int i6 = length - i5;
        StringBuilder stringBuilder = new StringBuilder(i6);
        Matcher matcher = p0.h.matcher(string);
        while (i4 > 0) {
            if (matcher.find()) {
            }
            String group = matcher.group(1);
            g.e(group);
            stringBuilder.append(string, i2, matcher.start());
            stringBuilder.append((char)int);
            i2 = matcher.end();
            i4--;
        }
        if (i2 < length) {
            stringBuilder.append(string, i2, length);
        }
        if (stringBuilder.length() != i6) {
            return null;
        }
        return stringBuilder.toString();
    }

    private static void L(Display display, Point point2) {
        display.getRealSize(point2);
    }

    public static void L0(Parcel parcel, boolean z2) {
        parcel.writeInt(z2);
    }

    private static void M(Display display, Point point2) {
        Display.Mode obj1 = display.getMode();
        point2.x = obj1.getPhysicalWidth();
        point2.y = obj1.getPhysicalHeight();
    }

    public static int N(String string) {
        int int;
        int length;
        String[] obj5;
        int i = 0;
        if (string == null) {
            return i;
        }
        obj5 = p0.C0(string, "_");
        length = obj5.length;
        final int i3 = 2;
        if (length < i3) {
            return i;
        }
        String str2 = obj5[length + -1];
        if (length >= 3 && "neg".equals(obj5[length -= i3])) {
            obj5 = "neg".equals(obj5[length -= i3]) ? 1 : i;
        } else {
        }
        g.e(str2);
        if (obj5 != null) {
            int = -int;
        }
        return int;
    }

    public static String O(Locale locale) {
        String obj2;
        if (p0.a >= 21) {
            obj2 = p0.P(locale);
        } else {
            obj2 = locale.toString();
        }
        return obj2;
    }

    private static String P(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long Q(long l, float f2) {
        if (Float.compare(obj4, i) == 0) {
            return l;
        }
        return Math.round(obj2 *= d);
    }

    public static long R(long l) {
        int elapsedRealtime;
        long obj2;
        if (Long.compare(l, l2) == 0) {
            obj2 = System.currentTimeMillis();
        } else {
            l += elapsedRealtime;
        }
        return obj2;
    }

    public static int S(int i) {
        if (i != 8 && i != 16 && i != 24 && i != 32) {
            if (i != 16) {
                if (i != 24) {
                    if (i != 32) {
                        return 0;
                    }
                    return 805306368;
                }
                return 536870912;
            }
            return 2;
        }
        return 3;
    }

    public static i1 T(int i, int i2, int i3) {
        i1.b bVar = new i1.b();
        bVar.e0("audio/raw");
        bVar.H(i2);
        bVar.f0(i3);
        bVar.Y(i);
        return bVar.E();
    }

    public static int U(int i, int i2) {
        int i4;
        int i3;
        int i5;
        int i6;
        int obj5;
        i4 = 2;
        i3 = 3;
        if (i != i4 && i != i3) {
            i3 = 3;
            if (i != i3) {
                i5 = 4;
                if (i != i5) {
                    if (i != 268435456 && i != 536870912) {
                        if (i != 536870912) {
                            if (i != 805306368) {
                            } else {
                                i2 *= i5;
                            }
                            IllegalArgumentException obj4 = new IllegalArgumentException();
                            throw obj4;
                        }
                        return i2 *= i3;
                    }
                } else {
                }
            }
            return obj5;
        }
        return i2 *= i4;
    }

    public static long V(long l, float f2) {
        if (Float.compare(obj4, i) == 0) {
            return l;
        }
        return Math.round(obj2 /= d);
    }

    public static int W(int i) {
        if (i != 13) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }
        return 1;
    }

    public static String X(StringBuilder stringBuilder, Formatter formatter2, long l3) {
        String str;
        String obj9;
        long obj11;
        int i = 0;
        if (Long.compare(l3, l) == 0) {
            obj11 = i;
        }
        str = Long.compare(obj11, i) < 0 ? "-" : "";
        obj11 /= i5;
        int i6 = 60;
        final int i10 = obj11 % i6;
        i11 %= i6;
        obj11 /= i7;
        int i8 = 0;
        stringBuilder.setLength(i8);
        int i2 = 2;
        final int i3 = 1;
        final int i9 = 3;
        if (Long.compare(obj11, i) > 0) {
            obj9 = new Object[4];
            obj9[i8] = str;
            obj9[i3] = Long.valueOf(obj11);
            obj9[i2] = Long.valueOf(i12);
            obj9[i9] = Long.valueOf(i10);
            obj9 = formatter2.format("%s%d:%02d:%02d", obj9).toString();
        } else {
            obj9 = new Object[i9];
            obj9[i8] = str;
            obj9[i3] = Long.valueOf(i12);
            obj9[i2] = Long.valueOf(i10);
            obj9 = formatter2.format("%s%02d:%02d", obj9).toString();
        }
        return obj9;
    }

    public static String[] Y() {
        int i;
        String str;
        final String[] strArr = p0.Z();
        i = 0;
        for (Object str2 : obj0) {
            strArr[i] = p0.p0(str2);
        }
        return strArr;
    }

    private static String[] Z() {
        String[] strArr2;
        int strArr;
        int i;
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (p0.a >= 24) {
            strArr2 = p0.a0(configuration);
        } else {
            strArr = new String[1];
            strArr2 = strArr;
        }
        return strArr2;
    }

    public static long a(long l, long l2, long l3) {
        final int i = l + l3;
        if (Long.compare(obj2, obj4) < 0) {
            return obj6;
        }
        return i;
    }

    private static String[] a0(Configuration configuration) {
        return p0.C0(configuration.getLocales().toLanguageTags(), ",");
    }

    public static boolean b(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    private static String b0(String string) {
        try {
            Class forName = Class.forName("android.os.SystemProperties");
            int i = 1;
            final Class[] arr2 = new Class[i];
            final int i2 = 0;
            arr2[i2] = String.class;
            Object[] arr = new Object[i];
            arr[i2] = string;
            return (String)forName.getMethod("get", arr2).invoke(forName, arr);
            String str2 = "Failed to read system property ";
            string = String.valueOf(string);
            if (string.length() != 0) {
            } else {
            }
            string = str2.concat(string);
            string = new String(str2);
            str2 = "Util";
            v.d(str2, string, th);
            string = null;
            return string;
        }
    }

    public static <T extends Comparable<? super T>> int c(List<? extends Comparable<? super T>> list, T t2, boolean z3, boolean z4) {
        int binarySearch;
        int size;
        int compareTo;
        List obj3;
        int obj4;
        binarySearch = Collections.binarySearch(list, t2);
        if (binarySearch < 0) {
            obj4 = ~binarySearch;
        } else {
            binarySearch++;
            while (binarySearch < list.size()) {
                if ((Comparable)list.get(binarySearch).compareTo(t2) == 0) {
                }
                binarySearch++;
            }
            obj4 = z3 ? binarySearch + -1 : binarySearch;
        }
        if (z4) {
            obj4 = Math.min(obj3--, obj4);
        }
        return obj4;
    }

    public static String c0(Context context, String string2) {
        String obj3;
        try {
            obj3 = obj3.versionName;
            context = "?";
            String rELEASE = Build.VERSION.RELEASE;
            StringBuilder stringBuilder = new StringBuilder(i3 += length3);
            stringBuilder.append(string2);
            stringBuilder.append("/");
            stringBuilder.append(obj3);
            stringBuilder.append(" (Linux;Android ");
            stringBuilder.append(rELEASE);
            stringBuilder.append(") ");
            stringBuilder.append("ExoPlayerLib/2.15.1");
            return stringBuilder.toString();
        }
    }

    public static int d(long[] lArr, long l2, boolean z3, boolean z4) {
        int binarySearch;
        int length;
        int obj3;
        int obj4;
        binarySearch = Arrays.binarySearch(lArr, l2);
        if (binarySearch < 0) {
            obj4 = ~binarySearch;
        }
        if (obj7 != null) {
            obj4 = Math.min(obj3--, obj4);
        }
        return obj4;
    }

    public static byte[] d0(String string) {
        return string.getBytes(d.c);
    }

    public static int e(com.google.android.exoplayer2.util.w w, long l2, boolean z3, boolean z4) {
        int i2;
        int i3;
        int i4;
        int i;
        int cmp;
        int obj6;
        int obj9;
        i5--;
        i4 = i3;
        while (i4 <= i2) {
            i6 >>>= 1;
            if (Long.compare(l, l2) < 0) {
            } else {
            }
            i2 = i;
            i4 = i + 1;
        }
        obj9 = i2 + 1;
        if (z4 != 0 && obj9 < w.c() && Long.compare(i4, l2) == 0) {
            obj9 = i2 + 1;
            if (obj9 < w.c()) {
                if (Long.compare(i4, l2) == 0) {
                    i3 = obj9;
                } else {
                    if (obj10 != null && i2 == -1) {
                        if (i2 == -1) {
                        } else {
                            i3 = i2;
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        return i3;
    }

    public static boolean e0(com.google.android.exoplayer2.util.d0 d0, com.google.android.exoplayer2.util.d0 d02, Inflater inflater3) {
        int i2;
        byte[] bArr;
        boolean needsDictionary;
        int i;
        int obj3;
        Inflater obj5;
        final int i6 = 0;
        if (d0.a() <= 0) {
            return i6;
        }
        if (d02.b() < d0.a()) {
            d02.c(i4 *= 2);
        }
        if (inflater3 == null) {
            obj5 = new Inflater();
        }
        obj5.setInput(d0.d(), d0.e(), d0.a());
        obj3 = i6;
        obj3 += inflate;
        while (obj5.finished()) {
            if (obj3 == d02.b()) {
            }
            obj3 += inflate;
            d02.c(i5 *= 2);
        }
        d02.H(obj3);
        obj5.reset();
        return 1;
    }

    public static <T extends Comparable<? super T>> int f(List<? extends Comparable<? super T>> list, T t2, boolean z3, boolean z4) {
        int binarySearch;
        int compareTo;
        int obj2;
        Object obj3;
        binarySearch = Collections.binarySearch(list, t2);
        if (binarySearch < 0) {
            obj2 = -binarySearch;
        }
        if (z4) {
            obj2 = Math.max(0, obj2);
        }
        return obj2;
    }

    public static boolean f0(int i) {
        int i2;
        int obj1;
        if (i != 536870912 && i != 805306368) {
            if (i != 805306368) {
                if (i == 4) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static int g(int[] iArr, int i2, boolean z3, boolean z4) {
        int binarySearch;
        int i;
        int obj2;
        int obj3;
        binarySearch = Arrays.binarySearch(iArr, i2);
        if (binarySearch < 0) {
            obj2 = -binarySearch;
        }
        if (z4) {
            obj2 = Math.max(0, obj2);
        }
        return obj2;
    }

    public static boolean g0(int i) {
        int i2;
        int obj1;
        if (i != 3 && i != 2 && i != 268435456 && i != 536870912 && i != 805306368) {
            if (i != 2) {
                if (i != 268435456) {
                    if (i != 536870912) {
                        if (i != 805306368) {
                            if (i == 4) {
                                obj1 = 1;
                            } else {
                                obj1 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static int h(long[] lArr, long l2, boolean z3, boolean z4) {
        int binarySearch;
        int cmp;
        int obj3;
        long[] obj4;
        binarySearch = Arrays.binarySearch(lArr, l2);
        if (binarySearch < 0) {
            obj3 = -binarySearch;
        }
        if (obj7 != null) {
            obj3 = Math.max(0, obj3);
        }
        return obj3;
    }

    public static boolean h0(int i) {
        int i2;
        int obj1;
        if (i != 10) {
            if (i == 13) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    @EnsuresNonNull("#1")
    public static <T> T i(T t) {
        return t;
    }

    public static boolean i0(Uri uri) {
        String empty;
        int obj1;
        obj1 = uri.getScheme();
        if (!TextUtils.isEmpty(obj1)) {
            if ("file".equals(obj1) != null) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    @EnsuresNonNull("#1")
    public static <T> T[] j(T[] tArr) {
        return tArr;
    }

    public static boolean j0(Context context) {
        String str;
        Object obj1;
        obj1 = context.getApplicationContext().getSystemService("uimode");
        if (obj1 != null && (UiModeManager)obj1.getCurrentModeType() == 4) {
            obj1 = obj1.getCurrentModeType() == 4 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static int k(int i, int i2) {
        return obj0 /= i2;
    }

    static Thread k0(String string, Runnable runnable2) {
        Thread thread = new Thread(runnable2, string);
        return thread;
    }

    public static void l(l l) {
        if (l != null) {
            l.close();
        }
        try {
        }
    }

    public static int l0(int[] iArr, int i2) {
        int i3;
        int i;
        i3 = 0;
        for (int i : iArr) {
        }
        return -1;
    }

    public static void m(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }

    private static String m0(String string) {
        int i;
        String[] strArr;
        boolean startsWith;
        String obj3;
        i = 0;
        strArr = p0.k;
        while (i < strArr.length) {
            i += 2;
            strArr = p0.k;
        }
        return string;
    }

    public static int n(long l, long l2) {
        int obj0;
        obj0 = Long.compare(l, obj2);
        obj0 = obj0 < 0 ? -1 : obj0 == null ? 0 : 1;
        return obj0;
    }

    public static <T> void n0(List<T> list, int i2, int i3, int i4) {
        Object remove;
        int obj4;
        ArrayDeque arrayDeque = new ArrayDeque();
        obj4--;
        while (obj4 >= 0) {
            arrayDeque.addFirst(list.remove(i2 + obj4));
            obj4--;
        }
        list.addAll(Math.min(i4, list.size()), arrayDeque);
    }

    public static float o(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static ExecutorService o0(String string) {
        f fVar = new f(string);
        return Executors.newSingleThreadExecutor(fVar);
    }

    public static int p(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static String p0(String string) {
        Object equals2;
        boolean equals;
        HashMap map;
        String equals3;
        String valueOf;
        String obj3;
        if (string == null) {
            return null;
        }
        String replace = string.replace('_', '-');
        if (!replace.isEmpty()) {
            if (replace.equals("und")) {
            } else {
                obj3 = replace;
            }
        }
        obj3 = b.c(obj3);
        equals2 = p0.D0(obj3, "-")[0];
        if (p0.i == null) {
            p0.i = p0.y();
        }
        Object obj = p0.i.get(equals2);
        if ((String)obj != null) {
            valueOf = String.valueOf((String)obj);
            obj3 = String.valueOf(obj3.substring(equals2.length()));
            if (obj3.length() != 0) {
                obj3 = valueOf.concat(obj3);
            } else {
                obj3 = new String(valueOf);
            }
            equals2 = obj;
        }
        if (!"no".equals(equals2) && !"i".equals(equals2)) {
            if (!"i".equals(equals2)) {
                if ("zh".equals(equals2)) {
                    obj3 = p0.m0(obj3);
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public static long q(long l, long l2, long l3) {
        return Math.max(l3, obj3);
    }

    public static <T> T[] q0(T[] tArr, T t2) {
        Object[] copyOf = Arrays.copyOf(tArr, length++);
        copyOf[tArr.length] = t2;
        p0.j(copyOf);
        return copyOf;
    }

    public static boolean r(Object[] objectArr, Object object2) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < objectArr.length) {
            i++;
        }
        return i2;
    }

    public static <T> T[] r0(T[] tArr, T[] t2Arr2) {
        Object[] copyOf = Arrays.copyOf(tArr, length += length2);
        System.arraycopy(t2Arr2, 0, copyOf, tArr.length, t2Arr2.length);
        return copyOf;
    }

    public static int s(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            obj6 ^= i;
            i2++;
        }
        return i4;
    }

    public static <T> T[] s0(T[] tArr, int i2) {
        int i;
        i = i2 <= tArr.length ? 1 : 0;
        g.a(i);
        return Arrays.copyOf(tArr, i2);
    }

    public static Handler t(Looper looper, Handler.Callback handler$Callback2) {
        Handler handler = new Handler(looper, callback2);
        return handler;
    }

    public static <T> T[] t0(T[] tArr, int i2, int i3) {
        int i;
        int i4;
        final int i5 = 0;
        i4 = i2 >= 0 ? i : i5;
        g.a(i4);
        if (i3 <= tArr.length) {
        } else {
            i = i5;
        }
        g.a(i);
        return Arrays.copyOfRange(tArr, i2, i3);
    }

    public static Handler u() {
        return p0.v(0);
    }

    public static long u0(String string) {
        String string2;
        Matcher matcher;
        long timeInMillis;
        String group;
        int intValue;
        int i;
        int length;
        boolean bigDecimal;
        int str;
        String obj10;
        matcher = p0.g.matcher(string);
        if (!matcher.matches()) {
            String str2 = "Invalid date/time format: ";
            obj10 = String.valueOf(string);
            if (obj10.length() != 0) {
                obj10 = str2.concat(obj10);
            } else {
                obj10 = new String(str2);
            }
            throw ParserException.a(obj10, 0);
        }
        obj10 = 9;
        i = 0;
        if (matcher.group(obj10) == null) {
        } else {
            if (matcher.group(obj10).equalsIgnoreCase("Z")) {
            } else {
                if ("-".equals(matcher.group(11))) {
                    i *= -1;
                }
            }
        }
        obj10 = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        obj10.clear();
        intValue = 3;
        obj10.set(Integer.parseInt(matcher.group(1)), int2 + -1, Integer.parseInt(matcher.group(intValue)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        length = 8;
        if (!TextUtils.isEmpty(matcher.group(length))) {
            str = "0.";
            String valueOf = String.valueOf(matcher.group(length));
            if (valueOf.length() != 0) {
                string2 = str.concat(valueOf);
            } else {
                string2 = new String(str);
            }
            bigDecimal = new BigDecimal(string2);
            obj10.set(14, bigDecimal.movePointRight(intValue).intValue());
        }
        if (i != 0) {
            timeInMillis -= i;
        }
        return timeInMillis;
    }

    public static Handler v(Handler.Callback handler$Callback) {
        final Looper myLooper = Looper.myLooper();
        g.h(myLooper);
        return p0.t((Looper)myLooper, callback);
    }

    public static boolean v0(Handler handler, Runnable runnable2) {
        if (!handler.getLooper().getThread().isAlive()) {
            return 0;
        }
        if (handler.getLooper() == Looper.myLooper()) {
            runnable2.run();
            return 1;
        }
        return handler.post(runnable2);
    }

    public static Handler w() {
        return p0.x(0);
    }

    public static boolean w0(Parcel parcel) {
        int obj0;
        obj0 = parcel.readInt() != 0 ? 1 : 0;
        return obj0;
    }

    public static Handler x(Handler.Callback handler$Callback) {
        return p0.t(p0.J(), callback);
    }

    public static <T> void x0(List<T> list, int i2, int i3) {
        int size;
        List obj1;
        if (i2 < 0) {
        } else {
            if (i3 > list.size()) {
            } else {
                if (i2 > i3) {
                } else {
                    if (i2 != i3) {
                        list.subList(i2, i3).clear();
                    }
                }
            }
        }
        obj1 = new IllegalArgumentException();
        throw obj1;
    }

    private static HashMap<String, String> y() {
        String[] iSOLanguages;
        int length;
        int i2;
        int i;
        String str;
        String iSO3Language;
        boolean empty;
        iSOLanguages = Locale.getISOLanguages();
        HashMap hashMap = new HashMap(length2 += length4);
        i = i2;
        while (i < iSOLanguages.length) {
            str = iSOLanguages[i];
            Locale locale = new Locale(str);
            iSO3Language = locale.getISO3Language();
            if (!TextUtils.isEmpty(iSO3Language)) {
            }
            i++;
            hashMap.put(iSO3Language, str);
        }
        String[] strArr = p0.j;
        while (i2 < strArr.length) {
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
            strArr = p0.j;
        }
        return hashMap;
    }

    public static long y0(long l, long l2, long l3) {
        int cmp;
        int cmp2;
        cmp = Long.compare(obj9, l3);
        final int i = 0;
        if (cmp >= 0 && Long.compare(i2, i) == 0) {
            if (Long.compare(i2, i) == 0) {
                return l /= obj9;
            }
        }
        if (cmp < 0 && Long.compare(cmp2, i) == 0) {
            if (Long.compare(cmp2, i) == 0) {
                return l *= obj7;
            }
        }
        return (long)obj5;
    }

    public static String z(String string, Object... object2Arr2) {
        return String.format(Locale.US, string, object2Arr2);
    }

    public static void z0(long[] lArr, long l2, long l3) {
        int cmp;
        int i;
        int cmp2;
        int obj7;
        int obj9;
        cmp = Long.compare(obj9, l2);
        final int i2 = 0;
        i = 0;
        if (cmp >= 0 && Long.compare(i3, i2) == 0) {
            if (Long.compare(i3, i2) == 0) {
                for (long obj7 : lArr) {
                    lArr[i] = obj7 /= obj9;
                }
            } else {
                if (cmp < 0 && Long.compare(cmp2, i2) == 0) {
                    if (Long.compare(cmp2, i2) == 0) {
                        for (long obj9 : lArr) {
                            lArr[i] = obj9 *= obj7;
                        }
                    } else {
                        for (long obj9 : lArr) {
                            lArr[i] = (long)obj9;
                        }
                    }
                } else {
                }
            }
        } else {
        }
    }
}
