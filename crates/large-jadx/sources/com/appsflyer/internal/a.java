package com.appsflyer.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.widget.c.a;
import app.dogo.com.dogo_android.d.d.n;
import app.dogo.com.dogo_android.h.za;
import com.appsflyer.AFLogger;
import com.coremedia.iso.boxes.OriginalFormatBox;
import d.a.g;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class a {

    private static long AFInAppEventParameterName = -6342812728503490611L;
    private static int AFInAppEventType = 0;
    private static long AFKeystoreWrapper = 0L;
    private static int AFLogger$LogLevel = 1;
    private static char valueOf = '\uca5a';
    private static int values;

    static class d extends HashMap<String, Object> {

        private static char[] AFInAppEventType = null;
        private static int AFKeystoreWrapper = 78;
        private static int AFVersionDeclaration = 1;
        private static int AppsFlyer2dXConversionCallback;
        private static int[] getLevel;
        private static boolean init;
        private static boolean values;
        private final Map<String, Object> AFInAppEventParameterName;
        private final Context valueOf;
        static {
            char[] cArr = new char[40];
            cArr = new short[]{
                175, 180, 173, 194, 183, 187, 179, 193, 190, 176,
                192, 188, 178, 185, 186, 'n', 181, 199, 197, 182,
                198, 177, 189, 136, 135, 154, 195, 146, 132, '|',
                131, '~', '{', 'x', 130, 127, 128, 134, 't', 191
            };
            a.d.AFInAppEventType = cArr;
            int i3 = 1;
            a.d.init = i3;
            a.d.values = i3;
            int[] iArr = new int[18];
            iArr = new int[]{
                -780211649, 145441905, 2074237029, -1855010193, -2090385575, 426822019, 1295866497, 96733486, -769624980, -1625956689,
                -613435452, 411771510, 1136710016, 936659668, 1750506028, -1118865621, 1151874214, 1069789572
            };
            a.d.getLevel = iArr;
        }

        d(Map<String, Object> map, Context context2) {
            super();
            this.AFInAppEventParameterName = map;
            this.valueOf = context2;
            put(AFInAppEventParameterName(), AFInAppEventType());
        }

        private String AFInAppEventParameterName() {
            int length;
            String string;
            int i;
            int i3;
            int i2;
            int i4;
            String str = "";
            appsFlyer2dXConversionCallback += 69;
            a.d.AFVersionDeclaration = i6 % 128;
            int i10 = 2;
            i6 %= i10;
            int i8 = 0;
            final int i13 = 0;
            final int i16 = 48;
            i2 = 3;
            int i18 = 4;
            final int i19 = 1;
            if (this.AFInAppEventParameterName.get(a.d.AFInAppEventParameterName("\u008d\u008c\u0081\u008b\u008a", i8, i8, indexOf2 - 126).intern()).toString() == null) {
                int[] iArr = new int[i18];
                iArr[i13] = 439274998;
                iArr[i19] = -1569650570;
                iArr[i10] = -353125301;
                iArr[i2] = -235653732;
                string = a.d.values(iArr, i24 - 8).intern();
            }
            StringBuilder stringBuilder = new StringBuilder(this.AFInAppEventParameterName.get(a.d.AFInAppEventParameterName("\u0089\u0086\u0081\u0084\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", i8, i8, indexOf += 127).intern()).toString());
            stringBuilder.reverse();
            String[] strArr = new String[i2];
            strArr[i13] = Integer.toString(Build.VERSION.SDK_INT);
            strArr[i19] = string;
            strArr[i10] = stringBuilder.toString();
            StringBuilder sb = a.d.AFInAppEventType(strArr);
            length = sb.length();
            i = length > i18 ? i13 : i19;
            if (i != i19) {
                sb.delete(i18, length);
            }
            sb.insert(i13, a.d.AFInAppEventParameterName("\u0082\u0087\u008e", i8, i8, lastIndexOf += 128).intern());
            return sb.toString();
        }

        private static String AFInAppEventParameterName(String string, int[] i2Arr2, String string3, int i4) {
            int str;
            int i6;
            boolean init;
            int i3;
            int i5;
            char c;
            int i7;
            int i;
            int i2;
            byte[] obj7;
            int obj8;
            char[] obj9;
            str = 50;
            i6 = string3 != null ? str : 54;
            if (i6 != str) {
            } else {
                obj9 = string3.toCharArray();
            }
            if (string != null) {
                obj7 = string.getBytes("ISO-8859-1");
            }
            char[] aFInAppEventType = a.d.AFInAppEventType;
            int aFKeystoreWrapper = a.d.AFKeystoreWrapper;
            i3 = 0;
            i5 = 1;
            if (a.d.init) {
                obj8 += 35;
                a.d.AppsFlyer2dXConversionCallback = obj8 % 128;
                if (obj8 %= 2 != 0) {
                    obj9 = new char[obj7.length];
                    i3 = i5;
                } else {
                    obj9 = new char[obj7.length];
                }
                while (i3 < obj8) {
                    obj9[i3] = (char)i11;
                    i3++;
                    aFVersionDeclaration += 11;
                    a.d.AppsFlyer2dXConversionCallback = i12 % 128;
                    i12 %= 2;
                }
                obj7 = new String(obj9);
                return obj7;
            }
            if (a.d.values) {
                obj7 = obj9.length;
                char[] cArr = new char[obj7];
                obj8 = i3;
                int i25 = 76;
                while (obj8 < obj7) {
                    i2 = i25;
                    if (i2 == i25) {
                    }
                    aFVersionDeclaration3 += i5;
                    a.d.AppsFlyer2dXConversionCallback = i26 % 128;
                    if (i26 %= 2 != 0) {
                    } else {
                    }
                    i7 = i5;
                    if (i7 != 0) {
                    } else {
                    }
                    cArr[obj8] = (char)i31;
                    obj8 += 65;
                    i25 = 76;
                    i2 = 60;
                    cArr[obj8] = (char)i35;
                    obj8++;
                    i7 = i3;
                }
                obj7 = new String(cArr);
                return obj7;
            }
            obj7 = i2Arr2.length;
            obj9 = new char[obj7];
            while (i3 < obj7) {
                aFVersionDeclaration2 += 125;
                a.d.AppsFlyer2dXConversionCallback = i13 % 128;
                if (i13 %= 2 != 0) {
                } else {
                }
                obj9[i3] = (char)i24;
                i3++;
                obj9[i3] = (char)i19;
                i3 += 103;
            }
            obj7 = new String(obj9);
            return obj7;
        }

        private String AFInAppEventType() {
            String string;
            int i4;
            String string2;
            String nativeLibraryDir;
            StringBuilder stringBuilder;
            int i5;
            int i6;
            int intern2;
            int i3;
            int i;
            StringBuilder stringBuilder3;
            String replaceAll;
            int intExtra;
            StringBuilder stringBuilder2;
            String intern;
            int i7;
            int i2;
            final Object obj2 = this;
            String str7 = "";
            int i13 = 22;
            int i15 = 0;
            i = 44;
            final int i22 = 16;
            final int i23 = 0;
            final int i24 = 0;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(obj2.AFInAppEventParameterName.get(a.d.AFInAppEventParameterName("\u0089\u0086\u0081\u0084\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", i24, i24, i25 += 127).intern()).toString());
            stringBuilder2.append(obj2.AFInAppEventParameterName.get(a.d.AFInAppEventParameterName("\u0087\u0084\u0081\u009c\u0094\u0096\u008c\u009b\u0081\u009a\u0084\u0088\u008b\u0085\u0082", i24, i24, packedPositionType += 127).intern()).toString());
            stringBuilder2.append(a.d.AFInAppEventParameterName(" \u009e\u009f\u009e\u009d", i24, i24, i29 += 127).intern().replaceAll(a.d.AFInAppEventParameterName("¢\u009e\u0096\u008b¡", i24, i24, cmp += 126).intern(), str7));
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str7);
            stringBuilder3.append(ag.valueOf(stringBuilder2.toString()).substring(i23, i22));
            string = stringBuilder3.toString();
            int[] iArr3 = new int[20];
            iArr3[i23] = -1859507902;
            final int i58 = 1;
            iArr3[i58] = 1132501388;
            int i59 = 2;
            iArr3[i59] = 1850003163;
            iArr3[3] = -1089792202;
            iArr3[4] = -449535943;
            iArr3[5] = -1110485080;
            iArr3[6] = 600228246;
            iArr3[7] = 326945485;
            iArr3[8] = -2114278808;
            iArr3[9] = -1265040853;
            iArr3[10] = -1923304371;
            iArr3[11] = -1324958136;
            iArr3[12] = -1746739303;
            iArr3[13] = 1818899899;
            iArr3[14] = 915267405;
            iArr3[15] = -1132845774;
            iArr3[i22] = 1763214286;
            intern2 = 17;
            iArr3[intern2] = 1605349196;
            iArr3[18] = 1611484443;
            iArr3[19] = 1220727640;
            IntentFilter intentFilter = new IntentFilter(a.d.values(iArr3, measureSpec += 37).intern());
            Intent registerReceiver = obj2.valueOf.registerReceiver(i24, intentFilter);
            if (registerReceiver != null) {
                intExtra = registerReceiver.getIntExtra(a.d.AFInAppEventParameterName("\u0087\u008b\u009b\u0084\u0081\u008b\u0087\u0089\u0086\u0087\u0084", i24, i24, i56 - 127).intern(), -2700);
            }
            nativeLibraryDir = applicationInfo.nativeLibraryDir;
            i7 = nativeLibraryDir != null ? 88 : intern2;
            if (i7 != intern2) {
                nativeLibraryDir = nativeLibraryDir.contains(a.d.AFInAppEventParameterName("\u009d¦\u0095", i24, i24, i33 - 127).intern()) ? 84 : i;
                if (nativeLibraryDir != i) {
                    aFVersionDeclaration += 111;
                    a.d.AppsFlyer2dXConversionCallback = i10 % 128;
                    i10 %= i59;
                    i4 = i58;
                } else {
                    appsFlyer2dXConversionCallback += 59;
                    a.d.AFVersionDeclaration = i8 % 128;
                    i8 %= i59;
                    i4 = i23;
                }
            } else {
            }
            try {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(a.d.AFInAppEventParameterName("\u008a", i24, i24, packedPositionChild += 128).intern());
                stringBuilder4.append(intExtra);
                int[] iArr = new int[i59];
                iArr[i23] = 162666322;
                iArr[i58] = -1739038780;
                stringBuilder4.append(a.d.values(iArr, i59 -= i19).intern());
                stringBuilder4.append(i4);
                stringBuilder4.append(a.d.AFInAppEventParameterName("\u0088§", i24, i24, mode += 127).intern());
                stringBuilder4.append((SensorManager)obj2.valueOf.getSystemService(a.d.AFInAppEventParameterName("\u008b\u0097\u0088\u008c\u0087\u0088", i24, i24, cmp2 += 126).intern()).getSensorList(-1).size());
                stringBuilder4.append(a.d.AFInAppEventParameterName("\u0089§", i24, i24, indexOf - 126).intern());
                stringBuilder4.append(obj2.AFInAppEventParameterName.size());
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(a.d.a.AFKeystoreWrapper(a.d.a.AFInAppEventParameterName(a.d.a.valueOf(stringBuilder4.toString()))));
                string2 = stringBuilder.toString();
                StringBuilder str6 = new StringBuilder();
                int str8 = 22;
                str8 = new int[str8];
                str8 = new int[]{
                    -275009063, 1347801849, 649983574, 1548012426, 1593260139, 1804931426, 1242763522, 1977775544, -744572194, -1142299558,
                    -957648203, -1141383731, -2086069163, -1681098831, -1066804092, 759717691, -740192763, -1504123216, -687185419, 1571937846,
                    1693777542, 797976598
                };
                int i14 = ViewConfiguration.getFadingEdgeLength();
                i14 >>= i21;
                i20 -= i14;
                str8 = a.d.values(str8, i20);
                str8 = str8.intern();
                str6.append(str8);
                str6.append(th);
                Throwable th = str6.toString();
                AFLogger.AFKeystoreWrapper(th);
                th = new StringBuilder();
                th.append(intern7);
                str6 = Color.red(obj8);
                str6 = str6 - 127;
                str8 = "\u0086\u0081\u0084\u0094\u0096¥¥\u0089¤\u0089¤¨ ¨ \u0082";
                str6 = a.d.AFInAppEventParameterName(str8, obj9, obj9, str6);
                str6 = str6.intern();
                th.append(str6);
                th = th.toString();
                return string2;
                th = th;
                th = null;
                obj177 = obj155 - -17;
                th = l.field#63062;
                i20 *= str6;
                int[] iArr2 = (int)i27;
                obj92 = obj107[obj56];
                int i74 = g.e;
                i74 = obj18963;
                l <<= i21;
                obj117 = obj222 >>> -70;
                obj211 = obj90 / obj228;
                str6 &= i21;
                i34 *= i34;
                int i27 = obj1.field#33705;
                i21 -= i21;
                iArr2 -= obj9;
                i27 = (int)i34;
                OriginalFormatBox.ajc$tjp_1 = obj192;
                obj45 = l[obj142];
                obj211 = obj176 >> -26;
                int i20 = intern7.a;
                obj215 = /* result */;
                int d = (double)obj15;
                obj40 = 12176;
                th = th;
                th = null;
                obj177 = obj155 - -17;
                th = l.field#63062;
                i20 *= str6;
                iArr2 = (int)i27;
                obj92 = obj107[obj56];
                i74 = g.e;
                i74 = obj18963;
                l <<= i21;
                obj117 = obj222 >>> -70;
                obj211 = obj90 / obj228;
                str6 &= i21;
                i34 *= i34;
                i27 = obj1.field#33705;
                i21 -= i21;
                iArr2 -= obj9;
                i27 = (int)i34;
                OriginalFormatBox.ajc$tjp_1 = obj192;
                obj45 = l[obj142];
                obj211 = obj176 >> -26;
                i20 = intern7.a;
                obj215 = /* result */;
                d = (double)obj15;
                obj40 = 12176;
            } catch (Exception e) {
            }
        }

        private static StringBuilder AFInAppEventType(String... stringArr) {
            int i2;
            Integer valueOf;
            int i;
            int hexString;
            int valueOf2;
            int intValue;
            int i6;
            int i5;
            int charAt;
            int i4;
            int i3;
            ArrayList arrayList = new ArrayList();
            final int i7 = 0;
            i2 = i7;
            int i8 = 3;
            while (i2 < i8) {
                arrayList.add(Integer.valueOf(stringArr[i2].length()));
                i2++;
                i8 = 3;
            }
            Collections.sort(arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            aFVersionDeclaration += 67;
            a.d.AppsFlyer2dXConversionCallback = i9 % 128;
            i9 %= 2;
            i = i7;
            int i11 = 1;
            while (i < (Integer)arrayList.get(i7).intValue()) {
                i5 = i7;
                if (i5 != i11) {
                }
                valueOf2 = 0;
                i6 = i7;
                charAt = 81;
                while (i6 < i8) {
                    i4 = charAt;
                    if (i4 == charAt) {
                    }
                    appsFlyer2dXConversionCallback2 += 5;
                    a.d.AFVersionDeclaration = i13 % 128;
                    i13 %= 2;
                    i4 = 94;
                    if (valueOf2 == 0) {
                    } else {
                    }
                    i3 = i4;
                    if (i3 != i4) {
                    } else {
                    }
                    charAt ^= intValue;
                    valueOf2 = Integer.valueOf(charAt);
                    i6++;
                    charAt = 81;
                    i4 = i8;
                    appsFlyer2dXConversionCallback += 79;
                    a.d.AFVersionDeclaration = i12 % 128;
                    i12 %= 2;
                    i3 = 30;
                }
                i4 = i8;
                if (i4 == charAt) {
                }
                appsFlyer2dXConversionCallback2 += 5;
                a.d.AFVersionDeclaration = i13 % 128;
                i13 %= 2;
                i4 = 94;
                if (valueOf2 == 0) {
                } else {
                }
                i3 = i4;
                if (i3 != i4) {
                } else {
                }
                charAt ^= intValue;
                valueOf2 = Integer.valueOf(charAt);
                i6++;
                appsFlyer2dXConversionCallback += 79;
                a.d.AFVersionDeclaration = i12 % 128;
                i12 %= 2;
                i3 = 30;
                stringBuilder.append(Integer.toHexString(valueOf2.intValue()));
                i++;
                i11 = 1;
                i5 = i11;
                i4 = charAt;
            }
            return stringBuilder;
        }

        private static String values(int[] iArr, int i2) {
            int i3;
            int i;
            int i5;
            int i4;
            int i6;
            char c;
            int obj12;
            aFVersionDeclaration += 23;
            a.d.AppsFlyer2dXConversionCallback = i7 % 128;
            int i13 = 2;
            i7 %= i13;
            char[] cArr = new char[4];
            final int i15 = 1;
            char[] cArr2 = new char[length <<= i15];
            final int i16 = 0;
            i3 = i16;
            int i25 = 76;
            i6 = 3;
            while (i3 < iArr.length) {
                i5 = i25;
                if (i5 == i25) {
                }
                cArr[i16] = (char)i18;
                cArr[i15] = (char)i19;
                int i20 = i3 + 1;
                cArr[i13] = (char)i27;
                cArr[i6] = (char)i21;
                cw.AFInAppEventType(cArr, (int[])a.d.getLevel.clone(), i16);
                int i22 = i3 << 1;
                cArr2[i22] = cArr[i16];
                cArr2[i22 + 1] = cArr[i15];
                cArr2[i22 + 2] = cArr[i13];
                cArr2[i22 += i6] = cArr[i6];
                i3 += 2;
                aFVersionDeclaration2 += 89;
                a.d.AppsFlyer2dXConversionCallback = i24 % 128;
                i24 %= i13;
                i25 = 76;
                i6 = 3;
                i5 = i6;
            }
            String obj11 = new String(cArr2, i16, i2);
            obj12 += 57;
            a.d.AFVersionDeclaration = obj12 % 128;
            int i11 = 96;
            obj12 = obj12 %= i13 == 0 ? 51 : i11;
            if (obj12 != i11) {
                obj12 /= i16;
                return obj11;
            }
            return obj11;
        }
    }
    static {
    }

    private static String AFInAppEventParameterName(Context context) {
        int i;
        aFLogger$LogLevel += 121;
        a.AFInAppEventType = i2 % 128;
        i2 %= 2;
        int i10 = 0;
        String obj3 = obj3.packageName;
        aFInAppEventType += 113;
        int i11 = i4 % 128;
        a.AFLogger$LogLevel = i11;
        i4 %= 2;
        i11 += 103;
        a.AFInAppEventType = i12 % 128;
        i = i12 %= 2 != 0 ? 1 : i10;
        if (i != 0) {
            i7 /= i10;
            return obj3;
        }
        return obj3;
    }

    private static String AFInAppEventParameterName(String string) {
        int i3;
        int i4;
        int i;
        int i2;
        int obj7;
        final String str = "윞윰뜓瞌";
        final int i5 = 0;
        i3 = !string.contains(a.AFInAppEventType(str).intern()) ? i5 : i4;
        if (i3 != 0) {
            String[] split = string.split(a.AFInAppEventType("ꪀꫜ㙽ᆞ豫").intern());
            StringBuilder stringBuilder = new StringBuilder();
            final int i6 = obj7 + -1;
            stringBuilder.append(split[i6]);
            stringBuilder.append(a.AFInAppEventType(str).intern());
            a.AFInAppEventType = obj7 % 128;
            obj7 %= 2;
            obj7 = 3;
            while (i4 < i6) {
                i2 = obj7;
                if (i2 == obj7) {
                }
                obj7 += 9;
                a.AFLogger$LogLevel = obj7 % 128;
                obj7 %= 2;
                stringBuilder.append(split[i4]);
                stringBuilder.append(a.AFInAppEventType(str).intern());
                i4++;
                a.AFInAppEventType = obj7 % 128;
                obj7 %= 2;
                obj7 = 3;
                i2 = 39;
            }
            stringBuilder.append(split[i5]);
            return stringBuilder.toString();
        }
        return string;
    }

    private static String AFInAppEventType(String string) {
        int aFInAppEventType;
        int i3;
        int i2;
        long l2;
        int i4;
        long l;
        char c;
        int i;
        long aFInAppEventParameterName;
        char[] obj11;
        aFInAppEventType = a.AFInAppEventType;
        int i9 = aFInAppEventType + 83;
        a.AFLogger$LogLevel = i9 % 128;
        i9 %= 2;
        int i11 = 0;
        int i13 = 1;
        i3 = string != null ? i11 : i13;
        if (i3 != 0) {
        } else {
            aFInAppEventType += 47;
            a.AFLogger$LogLevel = i6 % 128;
            i6 %= 2;
            obj11 = string.toCharArray();
            aFInAppEventType2 += 27;
            a.AFLogger$LogLevel = i8 % 128;
            i8 %= 2;
        }
        obj11 = dc.AFInAppEventType(a.AFInAppEventParameterName, obj4);
        int i5 = 4;
        i2 = i5;
        for (char c2 : string) {
            i4 = i11;
            if (i4 == 0) {
            }
            aFLogger$LogLevel += 49;
            a.AFInAppEventType = i16 % 128;
            i16 %= 2;
            obj11[i2] = (char)i20;
            i4 = i13;
        }
        String string2 = new String(obj11, i5, length -= i5);
        return string2;
    }

    static String AFKeystoreWrapper(Context context, long l2) {
        int i8;
        int i3;
        String valueOf2;
        String intern7;
        int i6;
        String intern10;
        String intern6;
        int i7;
        int i9;
        String intern3;
        String intern5;
        char c3;
        String valueOf;
        int i4;
        String intern4;
        String str;
        String valueOf3;
        String intern2;
        String intern9;
        int i10;
        char c4;
        String intern;
        int i2;
        char c2;
        String str2;
        char c5;
        int packageName;
        int i14;
        int i12;
        char c;
        int i11;
        char i;
        long packedPositionForGroup;
        int i5;
        int i13;
        int lastIndexOf;
        int packedPositionForGroup2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        String str6 = "";
        int i25 = 48;
        int i73 = 0;
        final String str11 = "\u0000\u0000\u0000\u0000";
        str2 = "⍂瀓ⷧ棜";
        final String str16 = "";
        int i120 = 16;
        int i130 = 35154;
        final String str22 = "疔糜勦馉";
        str = "㆐";
        int i26 = 0;
        if (a.valueOf(a.valueOf(indexOf2 - -1, str11, "력儮䄟輻ᯏ嬿㦴똅䑾贰࿄눮䡴듣⒣缅咧쀶⮖ⅻ⏿撨䴛珳碨鬩ℷ洉Ⱎ轓", "飘籓寒䪛", (char)i89).intern())) {
            valueOf3 = a.valueOf(i87 += i105, str11, str, str22, (char)i119);
        } else {
            valueOf3 = a.valueOf(i99 - trimmedLength, str11, str16, str2, (char)i118);
        }
        stringBuilder2.append(valueOf3.intern());
        StringBuilder stringBuilder6 = new StringBuilder();
        packageName = context.getPackageName();
        stringBuilder2.append(a.valueOf(lastIndexOf3 + i92, str11, str, str22, (char)i93).intern());
        stringBuilder6.append(a.AFInAppEventParameterName(packageName));
        i6 = a.valueOf(context) == null ? 0 : 1;
        if (i6 != 0) {
            int i69 = 0;
            stringBuilder2.append(a.valueOf(i70 - measureSpec, str11, str, str22, (char)i72).intern());
            stringBuilder6.append(packageName);
        } else {
            int i103 = 0;
            stringBuilder2.append(a.valueOf(i67 -= bitsPerPixel, str11, str16, str2, (char)i98).intern());
            stringBuilder6.append(packageName);
        }
        intern6 = a.AFInAppEventParameterName(context);
        final int i132 = 0;
        if (intern6 == null) {
            int i63 = 0;
            stringBuilder2.append(a.valueOf(indexOf4 += i64, str11, str16, str2, (char)i66).intern());
            stringBuilder6.append(packageName);
        } else {
            packageName = 0;
            stringBuilder2.append(a.valueOf(i96 -= lastIndexOf, str11, str, str22, (char)i101).intern());
            stringBuilder6.append(intern6);
        }
        stringBuilder6.append(Boolean.TRUE.toString());
        stringBuilder.append(stringBuilder6.toString());
        int i94 = 0;
        String str14 = str22;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(a.valueOf(TextUtils.getOffsetAfter(str6, i94), str11, "蟁髤Ნ蒠웧돧㜬ᨢ롻夑㕟Ⱌ㵜酀ޢ襇", "鳑믓噕䒌", (char)i76).intern(), Locale.US);
        Date date = new Date(packageInfo.firstInstallTime, str22);
        stringBuilder.append(simpleDateFormat.format(date));
        aFInAppEventType2 += 77;
        a.AFLogger$LogLevel = i28 % 128;
        int i95 = 2;
        i28 %= i95;
        stringBuilder.append(l2);
        int i78 = 0;
        i7 = a.valueOf(a.valueOf(cmp5 += i30, str11, string#53900, "劧丑㮽ﵐ", (char)i31).intern()) ? 1 : 0;
        if (i7 != 0) {
            aFLogger$LogLevel2 += 37;
            a.AFInAppEventType = i57 % 128;
            i4 = i57 %= i95 != 0 ? 0 : 1;
            if (i4 != 0) {
                intern4 = a.valueOf(i10 - i61, str11, str, str14, (char)i62).intern();
            } else {
                intern4 = a.valueOf(i10 / i59, str11, str, str14, (char)i60).intern();
            }
            intern2 = intern4;
            i9 = 0;
        } else {
            i9 = 0;
            int i127 = 0;
            intern2 = a.valueOf(i128 - cmp7, str11, str16, str2, (char)i11).intern();
        }
        stringBuilder3.append(intern2);
        if (a.valueOf(a.valueOf(cmp6 += i79, str11, string#53902, "⡟郾୷讥", (char)i32).intern())) {
            aFLogger$LogLevel += 41;
            a.AFInAppEventType = i33 % 128;
            if (i33 %= i95 != 0) {
                intern3 = intern9;
            } else {
                int i35 = 0;
                valueOf = a.valueOf(i12 - intern9, str11, str, str14, (char)i36);
                intern3 = valueOf.intern();
            }
        } else {
            valueOf = a.valueOf(i108 - indexOf, str11, str16, str2, (char)i110);
        }
        stringBuilder3.append(intern3);
        if (a.valueOf(a.AFInAppEventType("㣓㢲鶴葽먗쮃ᒘ掍ꞈ嫜櫗ȭ۔ﯲੑꄖ颤ꤥ䇸䑗㥈䡤").intern())) {
            intern5 = a.valueOf(i111 - cmp2, str11, str, str14, (char)i113).intern();
        } else {
            int i53 = 0;
            intern5 = a.valueOf(i54 - capsMode2, str11, str16, str2, (char)i56).intern();
            aFLogger$LogLevel3 += 37;
            a.AFInAppEventType = i117 % 128;
            i117 %= i95;
        }
        stringBuilder3.append(intern5);
        int i115 = 0;
        i8 = a.valueOf(a.valueOf(i40 -= i114, str11, string#53883, "浞忴᪳䁂", (char)i17).intern()) ? 68 : 54;
        if (i8 != 54) {
            aFInAppEventType += 21;
            a.AFLogger$LogLevel = i19 % 128;
            i3 = i19 %= i95 == 0 ? 1 : 0;
            if (i3 != 0) {
                int i50 = 1;
                intern7 = a.valueOf(i23 *= i49, str11, str, str14, (char)i51).intern();
            } else {
                int i48 = 0;
                valueOf2 = a.valueOf(i21 += i47, str11, str, str14, (char)str2);
                intern7 = valueOf2.intern();
            }
        } else {
        }
        stringBuilder3.append(intern7);
        StringBuilder stringBuilder5 = new StringBuilder(ag.AFInAppEventParameterName(ag.valueOf(stringBuilder.toString())));
        int i52 = 16;
        int i74 = 0;
        stringBuilder5.setCharAt(17, Integer.toString(Integer.parseInt(stringBuilder2.toString(), i95), i52).charAt(i74));
        StringBuilder stringBuilder4 = new StringBuilder(stringBuilder5.toString());
        stringBuilder4.setCharAt(27, Integer.toString(Integer.parseInt(stringBuilder3.toString(), i95), i52).charAt(i74));
        return a.valueOf(stringBuilder4.toString(), Long.valueOf(l2));
    }

    private static String valueOf(int i, String string2, String string3, String string4, char c5) {
        int i4;
        int i3;
        int i6;
        char c;
        int i5;
        int i2;
        long l;
        char[] obj8;
        char[] obj9;
        char[] obj10;
        aFLogger$LogLevel += 25;
        i6 = i7 % 128;
        a.AFInAppEventType = i6;
        final int i19 = 2;
        i7 %= i19;
        if (string4 != null) {
            i6 += 89;
            a.AFLogger$LogLevel = i8 % 128;
            i8 %= i19;
            obj10 = string4.toCharArray();
        }
        if (string3 != null) {
            obj9 = string3.toCharArray();
        }
        i3 = 0;
        if (string2 != null) {
            aFInAppEventType2 += 29;
            a.AFLogger$LogLevel = i16 % 128;
            i5 = 1;
            i6 = i16 %= i19 == 0 ? i5 : i3;
            if (i6 != i5) {
                obj8 = string2.toCharArray();
            } else {
                obj8 = string2.toCharArray();
                i18 /= i3;
            }
        }
        obj10 = (char[])obj10.clone();
        obj8 = (char[])obj8.clone();
        obj10[i3] = (char)obj11;
        obj8[i19] = (char)obj11;
        int obj7 = obj9.length;
        char[] obj11 = new char[obj7];
        int i9 = 36;
        while (i3 < obj7) {
            i2 = i9;
            if (i2 == i9) {
            }
            aFInAppEventType += 51;
            a.AFLogger$LogLevel = i10 % 128;
            if (i10 %= i19 == 0) {
            } else {
            }
            df.AFInAppEventType(obj10, obj8, i3);
            obj11[i3] = (char)i13;
            i3++;
            i9 = 36;
            i2 = 40;
            df.AFInAppEventType(obj10, obj8, i3);
            obj11[i3] = (char)i15;
            i3 += 41;
        }
        obj7 = new String(obj11);
        return obj7;
    }

    private static String valueOf(Context context) {
        int find;
        boolean key;
        String i3;
        int intern;
        float strArr;
        Object intern2;
        int i;
        int i2;
        int str;
        String str4;
        int str2;
        String str3;
        Object obj11;
        aFLogger$LogLevel += 81;
        a.AFInAppEventType = i4 % 128;
        i4 %= 2;
        if (System.getProperties().containsKey(a.AFInAppEventType("⹱⸛㟬၀ꛜ⍼呺녫ޑ㗉ၭ冴杂雗㋷").intern())) {
            aFLogger$LogLevel2 += 49;
            a.AFInAppEventType = i6 % 128;
            intern = string#53895;
            strArr = "뇞뇱↫埌؅ᠷ몲춶⺂";
            intern2 = "";
            i = 1;
            if (i6 %= 2 != 0) {
                super.hashCode();
                if (Pattern.compile(a.AFInAppEventType(intern).intern()).matcher(context.getCacheDir().getPath().replace(a.AFInAppEventType(strArr).intern(), intern2)).find()) {
                    aFLogger$LogLevel3 += 83;
                    a.AFInAppEventType = i8 % 128;
                    find = i8 %= 2 != 0 ? i : i2;
                    i3 = obj11;
                }
            } else {
                intern = 86;
                find = Pattern.compile(a.AFInAppEventType(intern).intern()).matcher(context.getCacheDir().getPath().replace(a.AFInAppEventType(strArr).intern(), intern2)).find() ? intern : 37;
                if (find != intern) {
                } else {
                }
            }
            obj11 += 53;
            a.AFLogger$LogLevel = obj11 % 128;
            obj11 %= 2;
        }
        return i3;
    }

    private static String valueOf(String string, Long long2) {
        int length;
        int i5;
        int i3;
        int cmp;
        int i2;
        int str2;
        String str;
        int i4;
        int i;
        int numericValue;
        int obj9;
        int obj10;
        aFInAppEventType += 103;
        a.AFLogger$LogLevel = i6 % 128;
        String str4 = "\u0000\u0000\u0000\u0000";
        i3 = 1;
        final int i15 = 0;
        if (i6 %= 2 == 0) {
            super.hashCode();
            length = 67;
            cmp = string != null ? 64 : length;
            if (cmp != length) {
                length = 11;
                cmp = 7;
                i2 = long2 != null ? cmp : length;
                if (i2 != length) {
                    aFLogger$LogLevel += 25;
                    a.AFInAppEventType = i8 % 128;
                    if (i8 %= 2 != 0) {
                        i5 = i15;
                    } else {
                        try {
                            i5 = i3;
                        }
                        if (string.length() == 58) {
                            StringBuilder stringBuilder = new StringBuilder(string);
                            obj9 = long2.toString();
                            str2 = 0;
                            i4 = obj10;
                            while (obj10 < obj9.length()) {
                                i4 += numericValue;
                                obj10++;
                            }
                            obj9 = Integer.toHexString(i4);
                            stringBuilder.replace(cmp, obj10 += cmp, obj9);
                            obj9 = i15;
                            while (obj9 < stringBuilder.length()) {
                                str2 += i4;
                                obj9++;
                            }
                            obj9 = 100;
                            while (Long.compare(str2, obj9) > 0) {
                                str2 %= obj9;
                                obj9 = 100;
                            }
                            obj10 = 23;
                            stringBuilder.insert(obj10, (int)str2);
                            if (Long.compare(str2, i) < 0) {
                                obj9 += 63;
                                a.AFLogger$LogLevel = obj9 % 128;
                                cmp = 56365;
                                str2 = "⍂瀓ⷧ棜";
                                str = "";
                                i = -412085469;
                                if (obj9 %= 2 == 0) {
                                    stringBuilder.insert(126, a.valueOf(obj10 *= i, str4, str, str2, (char)i14).intern());
                                } else {
                                    stringBuilder.insert(obj10, a.valueOf(obj9 += i, str4, str, str2, (char)cmp).intern());
                                }
                            }
                            return stringBuilder.toString();
                        }
                    }
                }
            }
        } else {
            length = string != null ? i3 : i15;
            if (length != 0) {
            }
        }
        return a.valueOf(obj9 >>= 16, str4, string#53893, "䏌模퓵㜱", (char)obj10).intern();
    }

    private static boolean valueOf(String string) {
        int i2;
        int i;
        aFLogger$LogLevel += 67;
        a.AFInAppEventType = i3 % 128;
        i = 1;
        i2 = i3 %= 2 != 0 ? 10 : i;
        if (i2 != i) {
            Class.forName(string);
            i = i6;
        } else {
            Class.forName(string);
        }
        return i;
    }
}
