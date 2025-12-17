package com.google.android.exoplayer2.util;

import android.accounts.Account;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.exoplayer2.audio.m;
import com.google.common.base.b;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.installations.R.styleable;
import f.c.e.c.p.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class z {

    private static final ArrayList<com.google.android.exoplayer2.util.z.a> a;
    private static final Pattern b;

    private static final class a {

        public final String a;
        public final String b;
        public final int c;
    }

    static final class b {

        public final int a;
        public final int b;
        public b(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }
    }
    static {
        ArrayList arrayList = new ArrayList();
        z.a = arrayList;
        z.b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
    }

    public static boolean a(String string, String string2) {
        int i;
        int i3;
        String str;
        float f;
        boolean obj4;
        String obj5;
        i = 0;
        if (string == null) {
            return i;
        }
        string.hashCode();
        i3 = -1;
        final int i4 = 1;
        switch (string) {
            case "audio/eac3-joc":
                i3 = i;
                break;
            case "audio/mpeg-L1":
                i3 = i4;
                break;
            case "audio/mpeg-L2":
                i3 = 2;
                break;
            case "audio/mp4a-latm":
                i3 = 3;
                break;
            case "audio/ac3":
                i3 = 4;
                break;
            case "audio/raw":
                i3 = 5;
                break;
            case "audio/eac3":
                i3 = 6;
                break;
            case "audio/flac":
                i3 = 7;
                break;
            case "audio/mpeg":
                i3 = 8;
                break;
            case "audio/g711-alaw":
                i3 = 9;
                break;
            case "audio/g711-mlaw":
                i3 = 10;
                break;
            default:
        }
        switch (i3) {
            case 0:
                return i4;
            case 1:
                obj4 = z.i(string2);
                return i;
                obj4 = m.c(obj4.b);
                i = i4;
                return i;
            default:
                return i;
        }
        return i;
    }

    public static boolean b(String string, String string2) {
        int obj0;
        obj0 = z.d(string, string2) != null ? 1 : 0;
        return obj0;
    }

    public static String c(String string) {
        int i;
        String str;
        boolean z;
        final int i2 = 0;
        if (string == null) {
            return i2;
        }
        final String[] obj5 = p0.E0(string);
        i = 0;
        while (i < obj5.length) {
            str = z.g(obj5[i]);
            i++;
        }
        return i2;
    }

    public static String d(String string, String string2) {
        int string3;
        StringBuilder stringBuilder;
        int length;
        int i;
        String str;
        boolean equals;
        String obj6;
        string3 = 0;
        if (string != null) {
            if (string2 == null) {
            } else {
                obj6 = p0.E0(string);
                stringBuilder = new StringBuilder();
                i = 0;
                while (i < obj6.length) {
                    str = obj6[i];
                    if (string2.equals(z.g(str)) && stringBuilder.length() > 0) {
                    }
                    i++;
                    if (stringBuilder.length() > 0) {
                    }
                    stringBuilder.append(str);
                    stringBuilder.append(",");
                }
                if (stringBuilder.length() > 0) {
                    string3 = stringBuilder.toString();
                }
            }
        }
        return string3;
    }

    private static String e(String string) {
        int i;
        Object obj;
        boolean startsWith;
        i = 0;
        while (i < z.a.size()) {
            obj = z.a.get(i);
            i++;
        }
        return null;
    }

    public static int f(String string, String string2) {
        String str;
        int i2;
        int i;
        boolean obj7;
        string.hashCode();
        final int i3 = 8;
        final int i4 = 7;
        final int i5 = 6;
        final int i6 = 5;
        final int i7 = 0;
        i = -1;
        switch (string) {
            case "audio/eac3-joc":
                i = i7;
                break;
            case "audio/vnd.dts":
                i = 1;
                break;
            case "audio/mp4a-latm":
                i = 2;
                break;
            case "audio/ac3":
                i = 3;
                break;
            case "audio/ac4":
                i = 4;
                break;
            case "audio/eac3":
                i = i6;
                break;
            case "audio/mpeg":
                i = i5;
                break;
            case "audio/vnd.dts.hd":
                i = i4;
                break;
            case "audio/true-hd":
                i = i3;
                break;
            default:
        }
        switch (i) {
            case 0:
                return 18;
            case 1:
                return i4;
            case 2:
                return i7;
                obj7 = z.i(string2);
                return i7;
                return m.c(obj7.b);
            case 3:
                return i6;
            case 4:
                return 17;
            case 5:
                return i5;
            case 6:
                return 9;
            case 7:
                return i3;
            case 8:
                return 14;
            default:
                return i7;
        }
    }

    public static String g(String string) {
        int str;
        boolean startsWith8;
        boolean startsWith4;
        boolean contains;
        boolean startsWith5;
        boolean startsWith3;
        boolean startsWith6;
        boolean startsWith7;
        boolean startsWith9;
        boolean startsWith;
        boolean startsWith2;
        String obj2;
        if (string == null) {
            return null;
        }
        obj2 = b.c(string.trim());
        if (!obj2.startsWith("avc1")) {
            if (obj2.startsWith("avc3")) {
            } else {
                if (!obj2.startsWith("hev1")) {
                    if (obj2.startsWith("hvc1")) {
                    } else {
                        if (!obj2.startsWith("dvav") && !obj2.startsWith("dva1") && !obj2.startsWith("dvhe")) {
                            if (!obj2.startsWith("dva1")) {
                                if (!obj2.startsWith("dvhe")) {
                                    if (obj2.startsWith("dvh1")) {
                                    } else {
                                        if (obj2.startsWith("av01")) {
                                            return "video/av01";
                                        }
                                        if (!obj2.startsWith("vp9")) {
                                            if (obj2.startsWith("vp09")) {
                                            } else {
                                                if (!obj2.startsWith("vp8")) {
                                                    if (obj2.startsWith("vp08")) {
                                                    } else {
                                                        obj2 = z.i(obj2);
                                                        if (obj2.startsWith("mp4a") && obj2.startsWith("mp4a.") && obj2 != null) {
                                                            if (obj2.startsWith("mp4a.")) {
                                                                obj2 = z.i(obj2);
                                                                if (obj2 != null) {
                                                                    str = z.h(obj2.a);
                                                                }
                                                            }
                                                            if (str == null) {
                                                                str = "audio/mp4a-latm";
                                                            }
                                                            return str;
                                                        }
                                                        if (obj2.startsWith("mha1")) {
                                                            return "audio/mha1";
                                                        }
                                                        if (obj2.startsWith("mhm1")) {
                                                            return "audio/mhm1";
                                                        }
                                                        if (!obj2.startsWith("ac-3")) {
                                                            if (obj2.startsWith("dac3")) {
                                                            } else {
                                                                if (!obj2.startsWith("ec-3")) {
                                                                    if (obj2.startsWith("dec3")) {
                                                                    } else {
                                                                        if (obj2.startsWith("ec+3")) {
                                                                            return "audio/eac3-joc";
                                                                        }
                                                                        if (!obj2.startsWith("ac-4")) {
                                                                            if (obj2.startsWith("dac4")) {
                                                                            } else {
                                                                                if (obj2.startsWith("dtsc")) {
                                                                                    return "audio/vnd.dts";
                                                                                }
                                                                                if (obj2.startsWith("dtse")) {
                                                                                    return "audio/vnd.dts.hd;profile=lbr";
                                                                                }
                                                                                if (!obj2.startsWith("dtsh")) {
                                                                                    if (obj2.startsWith("dtsl")) {
                                                                                    } else {
                                                                                        if (obj2.startsWith("dtsx")) {
                                                                                            return "audio/vnd.dts.uhd";
                                                                                        }
                                                                                        if (obj2.startsWith("opus")) {
                                                                                            return "audio/opus";
                                                                                        }
                                                                                        if (obj2.startsWith("vorbis")) {
                                                                                            return "audio/vorbis";
                                                                                        }
                                                                                        if (obj2.startsWith("flac")) {
                                                                                            return "audio/flac";
                                                                                        }
                                                                                        if (obj2.startsWith("stpp")) {
                                                                                            return "application/ttml+xml";
                                                                                        }
                                                                                        if (obj2.startsWith("wvtt")) {
                                                                                            return "text/vtt";
                                                                                        }
                                                                                        if (obj2.contains("cea708")) {
                                                                                            return "application/cea-708";
                                                                                        }
                                                                                        if (!obj2.contains("eia608") && obj2.contains("cea608")) {
                                                                                            if (obj2.contains("cea608")) {
                                                                                            }
                                                                                            return z.e(obj2);
                                                                                        }
                                                                                    }
                                                                                    return "application/cea-608";
                                                                                }
                                                                            }
                                                                            return "audio/vnd.dts.hd";
                                                                        }
                                                                    }
                                                                    return "audio/ac4";
                                                                }
                                                            }
                                                            return "audio/eac3";
                                                        }
                                                    }
                                                    return "audio/ac3";
                                                }
                                            }
                                            return "video/x-vnd.on2.vp8";
                                        }
                                    }
                                    return "video/x-vnd.on2.vp9";
                                }
                            }
                        }
                    }
                    return "video/dolby-vision";
                }
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    public static String h(int i) {
        int i2;
        if (i != 32 && i != 33 && i != 35 && i != 64 && i != 163 && i != 177 && i != 165 && i != 166) {
            if (i != 33) {
                if (i != 35) {
                    if (i != 64) {
                        if (i != 163) {
                            if (i != 177) {
                                if (i != 165) {
                                    if (i != 166) {
                                        switch (i) {
                                            case 96:
                                                return "video/mpeg2";
                                            case 97:
                                                return "audio/mp4a-latm";
                                            case 98:
                                                return "audio/mpeg";
                                            case 99:
                                                return "video/mpeg";
                                            default:
                                                return "audio/ac4";
                                                return "audio/opus";
                                                return "audio/vnd.dts.hd";
                                                return "audio/vnd.dts";
                                        }
                                        return null;
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                            return "video/x-vnd.on2.vp9";
                        }
                        return "video/wvc1";
                    }
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    static com.google.android.exoplayer2.util.z.b i(String string) {
        int int;
        Matcher obj4 = z.b.matcher(string);
        if (!obj4.matches()) {
            return null;
        }
        String group = obj4.group(1);
        g.e(group);
        obj4 = obj4.group(2);
        int = 0;
        if (obj4 != null) {
            int = Integer.parseInt(obj4);
        }
        obj4 = new z.b(Integer.parseInt((String)group, 16), int);
        return obj4;
    }

    private static String j(String string) {
        int i = 0;
        if (string == null) {
            return i;
        }
        int indexOf = string.indexOf(47);
        if (indexOf == -1) {
            return i;
        }
        return string.substring(0, indexOf);
    }

    public static int k(String string) {
        boolean equals;
        if (TextUtils.isEmpty(string)) {
            return -1;
        }
        if (z.o(string)) {
            return 1;
        }
        if (z.q(string)) {
            return 2;
        }
        if (z.p(string)) {
            return 3;
        }
        if (!"application/id3".equals(string) && !"application/x-emsg".equals(string)) {
            if (!"application/x-emsg".equals(string)) {
                if ("application/x-scte35".equals(string)) {
                } else {
                    if ("application/x-camera-motion".equals(string)) {
                        return 6;
                    }
                }
                return z.l(string);
            }
        }
        return 5;
    }

    private static int l(String string) {
        int i;
        Object obj;
        boolean equals;
        i = 0;
        while (i < z.a.size()) {
            obj = z.a.get(i);
            i++;
        }
        return -1;
    }

    public static int m(String string) {
        return z.k(z.g(string));
    }

    public static String n(String string) {
        int i;
        String str;
        boolean z;
        final int i2 = 0;
        if (string == null) {
            return i2;
        }
        final String[] obj5 = p0.E0(string);
        i = 0;
        while (i < obj5.length) {
            str = z.g(obj5[i]);
            i++;
        }
        return i2;
    }

    public static boolean o(String string) {
        return "audio".equals(z.j(string));
    }

    public static boolean p(String string) {
        boolean equals;
        String obj2;
        if (!"text".equals(z.j(string)) && !"application/cea-608".equals(string) && !"application/cea-708".equals(string) && !"application/x-mp4-cea-608".equals(string) && !"application/x-subrip".equals(string) && !"application/ttml+xml".equals(string) && !"application/x-quicktime-tx3g".equals(string) && !"application/x-mp4-vtt".equals(string) && !"application/x-rawcc".equals(string) && !"application/vobsub".equals(string) && !"application/pgs".equals(string)) {
            if (!"application/cea-608".equals(string)) {
                if (!"application/cea-708".equals(string)) {
                    if (!"application/x-mp4-cea-608".equals(string)) {
                        if (!"application/x-subrip".equals(string)) {
                            if (!"application/ttml+xml".equals(string)) {
                                if (!"application/x-quicktime-tx3g".equals(string)) {
                                    if (!"application/x-mp4-vtt".equals(string)) {
                                        if (!"application/x-rawcc".equals(string)) {
                                            if (!"application/vobsub".equals(string)) {
                                                if (!"application/pgs".equals(string)) {
                                                    if ("application/dvbsubs".equals(string)) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = 0;
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
        } else {
        }
        return obj2;
    }

    public static boolean q(String string) {
        return "video".equals(z.j(string));
    }

    public static String r(String string) {
        int equals;
        int i;
        string.hashCode();
        i = -1;
        switch (string) {
            case "audio/x-flac":
                i = 0;
                break;
            case "audio/x-wav":
                i = 1;
                break;
            case "audio/mp3":
                i = 2;
                break;
            default:
        }
        switch (i) {
            case 0:
                return "audio/flac";
            case 1:
                return "audio/wav";
            case 2:
                return "audio/mpeg";
            default:
                return string;
        }
    }
}
