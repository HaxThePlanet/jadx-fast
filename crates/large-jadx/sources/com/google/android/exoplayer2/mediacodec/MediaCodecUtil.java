package com.google.android.exoplayer2.mediacodec;

import android.accounts.Account;
import android.content.pm.PackageInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.n;
import com.google.common.base.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class MediaCodecUtil {

    private static final Pattern a;
    private static final HashMap<com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b, List<com.google.android.exoplayer2.mediacodec.r>> b;
    private static int c;

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable throwable) {
            super("Failed to query underlying media codecs", throwable);
        }

        DecoderQueryException(Throwable throwable, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a mediaCodecUtil$a2) {
            super(throwable);
        }
    }

    static class a {
    }

    private static final class b {

        public final String a;
        public final boolean b;
        public final boolean c;
        public b(String string, boolean z2, boolean z3) {
            super();
            this.a = string;
            this.b = z2;
            this.c = z3;
        }

        public boolean equals(Object object) {
            int i;
            boolean equals;
            Class class;
            boolean str;
            Class<com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b> obj;
            boolean obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (object.getClass() != MediaCodecUtil.b.class) {
                } else {
                    if (TextUtils.equals(this.a, object.a) && this.b == object.b && this.c == object.c) {
                        if (this.b == object.b) {
                            if (this.c == object.c) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            int i;
            int i2;
            int i9 = 31;
            final int i10 = 1237;
            i = this.b ? i2 : i10;
            if (this.c) {
            } else {
                i2 = i10;
            }
            return i7 += i2;
        }
    }

    private interface c {
        public abstract MediaCodecInfo a(int i);

        public abstract boolean b(String string, String string2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities3);

        public abstract boolean c(String string, String string2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities3);

        public abstract int d();

        public abstract boolean e();
    }

    private interface f {
        public abstract int a(T t);
    }

    private static final class d implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c {
        d(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a mediaCodecUtil$a) {
            super();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public boolean b(String string, String string2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities3) {
            boolean obj1;
            if ("secure-playback".equals(string) && "video/avc".equals(string2)) {
                obj1 = "video/avc".equals(string2) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public boolean c(String string, String string2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities3) {
            return 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public boolean e() {
            return 0;
        }
    }

    private static final class e implements com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c {

        private final int a = 1;
        private MediaCodecInfo[] b;
        public e(boolean z, boolean z2) {
            super();
            if (!z && z2) {
                int obj1 = !z2 ? 0 : obj1;
            }
            obj1 = 1;
        }

        @EnsuresNonNull("mediaCodecInfos")
        private void f() {
            MediaCodecInfo[] codecInfos;
            int i;
            if (this.b == null) {
                MediaCodecList mediaCodecList = new MediaCodecList(this.a);
                this.b = mediaCodecList.getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public MediaCodecInfo a(int i) {
            f();
            return this.b[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public boolean b(String string, String string2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities3) {
            return codecCapabilities3.isFeatureSupported(string);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public boolean c(String string, String string2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities3) {
            return codecCapabilities3.isFeatureRequired(string);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public int d() {
            f();
            return objArr.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c
        public boolean e() {
            return 1;
        }
    }
    static {
        MediaCodecUtil.a = Pattern.compile("^\\D?(\\d+)$");
        HashMap hashMap = new HashMap();
        MediaCodecUtil.b = hashMap;
        MediaCodecUtil.c = -1;
    }

    private static boolean A(MediaCodecInfo mediaCodecInfo) {
        boolean startsWith;
        int i;
        String obj2;
        if (p0.a >= 29) {
            return MediaCodecUtil.B(mediaCodecInfo);
        }
        obj2 = b.c(mediaCodecInfo.getName());
        if (obj2.startsWith("arc.")) {
            return 0;
        }
        if (!obj2.startsWith("omx.google.") && !obj2.startsWith("omx.ffmpeg.")) {
            if (!obj2.startsWith("omx.ffmpeg.")) {
                if (obj2.startsWith("omx.sec.")) {
                    if (!obj2.contains(".sw.") && !obj2.equals("omx.qcom.video.decoder.hevcswvdec") && !obj2.startsWith("c2.android.") && !obj2.startsWith("c2.google.")) {
                        if (!obj2.equals("omx.qcom.video.decoder.hevcswvdec")) {
                            if (!obj2.startsWith("c2.android.")) {
                                if (!obj2.startsWith("c2.google.")) {
                                    if (!obj2.startsWith("omx.") && !obj2.startsWith("c2.")) {
                                        if (!obj2.startsWith("c2.")) {
                                            i = 1;
                                        }
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
        return i;
    }

    private static boolean B(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean C(MediaCodecInfo mediaCodecInfo) {
        String startsWith;
        int obj2;
        if (p0.a >= 29) {
            return MediaCodecUtil.D(mediaCodecInfo);
        }
        obj2 = b.c(mediaCodecInfo.getName());
        if (!obj2.startsWith("omx.google.") && !obj2.startsWith("c2.android.") && !obj2.startsWith("c2.google.")) {
            if (!obj2.startsWith("c2.android.")) {
                obj2 = !obj2.startsWith("c2.google.") ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    static int E(com.google.android.exoplayer2.mediacodec.r r) {
        boolean startsWith;
        int str;
        String obj2;
        obj2 = r.a;
        if (!obj2.startsWith("OMX.google")) {
            if (obj2.startsWith("c2.android")) {
            } else {
                if (p0.a < 26 && obj2.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    if (obj2.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                        return -1;
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    static int F(com.google.android.exoplayer2.mediacodec.r r) {
        return r.a.startsWith("OMX.google");
    }

    static int G(i1 i1, com.google.android.exoplayer2.mediacodec.r r2) {
        try {
            return r2.m(i1);
            i1 = -1;
            return i1;
        }
    }

    static int H(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f mediaCodecUtil$f, Object object2, Object object3) {
        return obj2 -= obj0;
    }

    public static int I() {
        int i3;
        int i;
        int length;
        int i4;
        int i2;
        i = 0;
        i3 = MediaCodecUtil.m("video/avc", i, i);
        if (MediaCodecUtil.c == -1 && i3 != null) {
            i = 0;
            i3 = MediaCodecUtil.m("video/avc", i, i);
            if (i3 != null) {
                android.media.MediaCodecInfo.CodecProfileLevel[] objArr = i3.g();
                i4 = i;
                while (i < objArr.length) {
                    i4 = Math.max(MediaCodecUtil.d(codecProfileLevel.level), i4);
                    i++;
                }
                i3 = p0.a >= 21 ? 345600 : 172800;
                i = Math.max(i4, i3);
            }
            MediaCodecUtil.c = i;
        }
        return MediaCodecUtil.c;
    }

    private static int J(int i) {
        int i2;
        if (i != 17 && i != 20 && i != 23 && i != 29 && i != 39 && i != 42) {
            if (i != 20) {
                if (i != 23) {
                    if (i != 29) {
                        if (i != 39) {
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    private static <T> void K(List<T> list, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f<T> mediaCodecUtil$f2) {
        h hVar = new h(f2);
        Collections.sort(list, hVar);
    }

    private static int L(int i) {
        if (i != 10 && i != 11 && i != 20 && i != 21 && i != 30 && i != 31 && i != 40 && i != 41 && i != 50 && i != 51) {
            if (i != 11) {
                if (i != 20) {
                    if (i != 21) {
                        if (i != 30) {
                            if (i != 31) {
                                if (i != 40) {
                                    if (i != 41) {
                                        if (i != 50) {
                                            if (i != 51) {
                                                switch (i) {
                                                    case 60:
                                                        return 2048;
                                                    case 61:
                                                        return 4096;
                                                    case 62:
                                                        return 8192;
                                                    default:
                                                        return -1;
                                                }
                                            }
                                            return 512;
                                        }
                                        return 256;
                                    }
                                    return 128;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static int M(int i) {
        int i2 = 1;
        final int i4 = 2;
        if (i != 0 && i != i2 && i != i4 && i != 3) {
            i4 = 2;
            if (i != i2) {
                if (i != i4) {
                    if (i != 3) {
                        return -1;
                    }
                    return 8;
                }
                return 4;
            }
            return i4;
        }
        return i2;
    }

    private static void a(String string, List<com.google.android.exoplayer2.mediacodec.r> list2) {
        int str;
        int str2;
        int equals;
        String equals2;
        String str3;
        int i3;
        int i5;
        int i4;
        int i6;
        int i;
        int i2;
        int obj11;
        str = 1;
        final int i7 = 0;
        if ("audio/raw".equals(string) && p0.a < 26 && p0.b.equals("R9") && list2.size() == str && obj11.a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            if (p0.a < 26) {
                if (p0.b.equals("R9")) {
                    if (list2.size() == str) {
                        if (obj11.a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                            list2.add(r.A("OMX.google.raw.decoder", "audio/raw", "audio/raw", 0, false, true, false, false, false));
                        }
                    }
                }
            }
            MediaCodecUtil.K(list2, e.a);
        }
        obj11 = p0.a;
        if (obj11 < 21 && list2.size() > str) {
            if (list2.size() > str) {
                equals = obj.a;
                if (!"OMX.SEC.mp3.dec".equals(equals) && !"OMX.SEC.MP3.Decoder".equals(equals)) {
                    if (!"OMX.SEC.MP3.Decoder".equals(equals)) {
                        if ("OMX.brcm.audio.mp3.decoder".equals(equals)) {
                            MediaCodecUtil.K(list2, f.a);
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        if (obj11 < 32 && list2.size() > str && "OMX.qti.audio.decoder.flac".equals(obj11.a)) {
            if (list2.size() > str) {
                if ("OMX.qti.audio.decoder.flac".equals(obj11.a)) {
                    list2.add((r)list2.remove(i7));
                }
            }
        }
    }

    private static int b(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int c(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                return 65536;
                return 32768;
                return 16384;
                return 8192;
                return 4096;
                return 2048;
                return 1024;
                return 512;
                return 256;
                return 128;
                return 64;
                return 32;
        }
        return -1;
    }

    private static int d(int i) {
        int i2;
        if (i != 1 && i != 2) {
            if (i != 2) {
                switch (i) {
                    case 8:
                        return 101376;
                    case 16:
                        return 202752;
                    case 32:
                        return 414720;
                    case 64:
                        return 921600;
                    case 128:
                        return 1310720;
                    case 256:
                        return 2097152;
                    case 512:
                        return 2228224;
                    case 1024:
                        return 5652480;
                    case 2048:
                        return 9437184;
                    case 4096:
                        return 35651584;
                    default:
                        return -1;
                }
            }
        }
        return 25344;
    }

    private static int e(int i) {
        if (i != 66 && i != 77 && i != 88 && i != 100 && i != 110 && i != 122 && i != 244) {
            if (i != 77) {
                if (i != 88) {
                    if (i != 100) {
                        if (i != 110) {
                            if (i != 122) {
                                if (i != 244) {
                                    return -1;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static Integer f(String string) {
        int i;
        String str;
        Throwable obj;
        boolean obj7;
        final int i2 = 0;
        if (string == null) {
            return i2;
        }
        string.hashCode();
        i = -1;
        final int i3 = 8;
        final int i4 = 4;
        final int i5 = 2;
        final int i6 = 1;
        switch (string) {
            case "01":
                i = 0;
                break;
            case "02":
                i = i6;
                break;
            case "03":
                i = i5;
                break;
            case "04":
                i = 3;
                break;
            case "05":
                i = i4;
                break;
            case "06":
                i = 5;
                break;
            case "07":
                i = 6;
                break;
            case "08":
                i = 7;
                break;
            case "09":
                i = i3;
                break;
            case "10":
                i = 9;
                break;
            case "11":
                i = 10;
                break;
            case "12":
                i = 11;
                break;
            case "13":
                i = 12;
                break;
            default:
        }
        switch (i) {
            case 0:
                return Integer.valueOf(i6);
            case 1:
                return Integer.valueOf(i5);
            case 2:
                return Integer.valueOf(i4);
            case 3:
                return Integer.valueOf(i3);
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            default:
                return i2;
        }
    }

    private static Integer g(String string) {
        int i;
        String str;
        boolean obj7;
        final int i2 = 0;
        if (string == null) {
            return i2;
        }
        string.hashCode();
        i = -1;
        final int i3 = 8;
        final int i4 = 4;
        final int i5 = 2;
        final int i6 = 1;
        switch (string) {
            case "00":
                i = 0;
                break;
            case "01":
                i = i6;
                break;
            case "02":
                i = i5;
                break;
            case "03":
                i = 3;
                break;
            case "04":
                i = i4;
                break;
            case "05":
                i = 5;
                break;
            case "06":
                i = 6;
                break;
            case "07":
                i = 7;
                break;
            case "08":
                i = i3;
                break;
            case "09":
                i = 9;
                break;
            default:
        }
        switch (i) {
            case 0:
                return Integer.valueOf(i6);
            case 1:
                return Integer.valueOf(i5);
            case 2:
                return Integer.valueOf(i4);
            case 3:
                return Integer.valueOf(i3);
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            default:
                return i2;
        }
    }

    private static Pair<Integer, Integer> h(String string, String[] string2Arr2) {
        boolean equals;
        Object obj5;
        int obj6;
        final int i3 = 0;
        final String str2 = "Ignoring malformed MP4A codec string: ";
        if (string2Arr2.length != 3) {
            obj5 = String.valueOf(string);
            if (obj5.length() != 0) {
                obj5 = str2.concat(obj5);
            } else {
                obj5 = new String(str2);
            }
            v.h("MediaCodecUtil", obj5);
            return i3;
        }
        obj6 = MediaCodecUtil.J(Integer.parseInt(string2Arr2[2]));
        if ("audio/mp4a-latm".equals(z.h(Integer.parseInt(string2Arr2[1], 16))) && obj6 != -1) {
            obj6 = MediaCodecUtil.J(Integer.parseInt(string2Arr2[2]));
            if (obj6 != -1) {
                Pair pair = new Pair(Integer.valueOf(obj6), 0);
                return pair;
            }
        }
        return i3;
    }

    private static Pair<Integer, Integer> i(String string, String[] string2Arr2, n n3) {
        int i;
        String str;
        String obj8;
        int obj9;
        str = "Ignoring malformed AV1 codec string: ";
        final int i2 = 0;
        final String str2 = "MediaCodecUtil";
        if (string2Arr2.length < 4) {
            obj8 = String.valueOf(string);
            if (obj8.length() != 0) {
                obj8 = str.concat(obj8);
            } else {
                obj8 = new String(str);
            }
            v.h(str2, obj8);
            return i2;
        }
        int int = Integer.parseInt(string2Arr2[1]);
        final int i4 = 2;
        int int2 = Integer.parseInt(string2Arr2[i4].substring(0, i4));
        obj8 = Integer.parseInt(string2Arr2[3]);
        if (int != 0) {
            obj9 = new StringBuilder(32);
            obj9.append("Unknown AV1 profile: ");
            obj9.append(int);
            v.h(str2, obj9.toString());
            return i2;
        }
        obj9 = 8;
        if (obj8 != obj9 && obj8 != 10) {
            if (obj8 != 10) {
                StringBuilder obj10 = new StringBuilder(34);
                obj10.append("Unknown AV1 bit depth: ");
                obj10.append(obj8);
                v.h(str2, obj10.toString());
                return i2;
            }
        }
        if (obj8 == obj9) {
        } else {
            if (n3 != null) {
                obj8 = n3.c;
                if (n3.v == null && obj8 != 7) {
                    obj8 = n3.c;
                    if (obj8 != 7) {
                        i = obj8 == 6 ? 4096 : i4;
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        obj8 = MediaCodecUtil.b(int2);
        if (obj8 == -1) {
            obj9 = new StringBuilder(30);
            obj9.append("Unknown AV1 level: ");
            obj9.append(int2);
            v.h(str2, obj9.toString());
            return i2;
        }
        obj9 = new Pair(Integer.valueOf(i), Integer.valueOf(obj8));
        return obj9;
    }

    private static Pair<Integer, Integer> j(String string, String[] string2Arr2) {
        int int;
        int int2;
        int length;
        int i;
        String obj7;
        Object obj8;
        String str = "Ignoring malformed AVC codec string: ";
        int i5 = 2;
        final int i6 = 0;
        final String str2 = "MediaCodecUtil";
        if (string2Arr2.length < i5) {
            obj7 = String.valueOf(string);
            if (obj7.length() != 0) {
                obj7 = str.concat(obj7);
            } else {
                obj7 = new String(str);
            }
            v.h(str2, obj7);
            return i6;
        }
        int i2 = 1;
        if (string2Arr2[i2].length() == 6) {
            length = 16;
            int2 = Integer.parseInt(string2Arr2[i2].substring(0, i5), length);
            obj7 = Integer.parseInt(string2Arr2[i2].substring(4), length);
            obj8 = MediaCodecUtil.e(int2);
            int i3 = -1;
            if (obj8 == i3) {
                obj8 = new StringBuilder(32);
                obj8.append("Unknown AVC profile: ");
                obj8.append(int2);
                v.h(str2, obj8.toString());
                return i6;
            }
            int i4 = MediaCodecUtil.c(obj7);
            if (i4 == i3) {
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown AVC level: ");
                stringBuilder.append(obj7);
                v.h(str2, stringBuilder.toString());
                return i6;
            }
            obj7 = new Pair(Integer.valueOf(obj8), Integer.valueOf(i4));
            return obj7;
        } else {
            if (string2Arr2.length >= 3) {
                obj7 = Integer.parseInt(string2Arr2[i5]);
                int2 = int;
            }
        }
        obj8 = String.valueOf(string);
        if (obj8.length() != 0) {
            obj8 = str.concat(obj8);
        } else {
            obj8 = new String(str);
        }
        v.h(str2, obj8);
        return i6;
    }

    private static String k(MediaCodecInfo mediaCodecInfo, String string2, String string3) {
        int i;
        String str;
        boolean equalsIgnoreCase;
        boolean obj4;
        obj4 = mediaCodecInfo.getSupportedTypes();
        i = 0;
        while (i < obj4.length) {
            str = obj4[i];
            i++;
        }
        if (string3.equals("video/dolby-vision") && "OMX.MS.HEVCDV.Decoder".equals(string2)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(string2)) {
                return "video/hevcdv";
            }
            if (!"OMX.RTK.video.decoder".equals(string2) && "OMX.realtek.video.decoder.tunneled".equals(string2)) {
                if ("OMX.realtek.video.decoder.tunneled".equals(string2)) {
                }
                return null;
            }
            return "video/dv_hevc";
        }
        if (string3.equals("audio/alac") && "OMX.lge.alac.decoder".equals(string2)) {
            if ("OMX.lge.alac.decoder".equals(string2)) {
                return "audio/x-lg-alac";
            }
        }
        if (string3.equals("audio/flac") && "OMX.lge.flac.decoder".equals(string2)) {
            if ("OMX.lge.flac.decoder".equals(string2)) {
                return "audio/x-lg-flac";
            }
        }
    }

    public static Pair<Integer, Integer> l(i1 i1) {
        int equals2;
        String equals;
        int str;
        String str2 = i1.A;
        int i2 = 0;
        if (str2 == null) {
            return i2;
        }
        String[] split = str2.split("\\.");
        if ("video/dolby-vision".equals(i1.D)) {
            return MediaCodecUtil.r(i1.A, split);
        }
        equals = split[0];
        equals.hashCode();
        switch (equals) {
            case "av01":
                equals2 = i3;
                break;
            case "avc1":
                equals2 = i3;
                equals2 = 1;
                break;
            case "avc2":
                equals2 = i3;
                equals2 = 2;
                break;
            case "hev1":
                equals2 = i3;
                equals2 = 3;
                break;
            case "hvc1":
                equals2 = i3;
                equals2 = 4;
                break;
            case "mp4a":
                equals2 = i3;
                equals2 = 5;
                break;
            case "vp09":
                equals2 = i3;
                equals2 = 6;
                break;
            default:
                equals2 = i3;
        }
        switch (equals2) {
            case 0:
                return MediaCodecUtil.i(i1.A, split, i1.P);
            case 1:
                return MediaCodecUtil.j(i1.A, split);
            case 2:
                return MediaCodecUtil.s(i1.A, split);
            case 3:
                return MediaCodecUtil.h(i1.A, split);
            case 4:
                return MediaCodecUtil.t(i1.A, split);
            default:
                return i2;
        }
    }

    public static com.google.android.exoplayer2.mediacodec.r m(String string, boolean z2, boolean z3) {
        int obj0;
        boolean obj1;
        obj0 = MediaCodecUtil.n(string, z2, z3);
        if (obj0.isEmpty()) {
            obj0 = 0;
        } else {
            obj0 = obj0.get(0);
        }
        return obj0;
    }

    public static List<com.google.android.exoplayer2.mediacodec.r> n(String string, boolean z2, boolean z3) {
        int string2;
        int str;
        int stringBuilder;
        Object eVar;
        boolean obj8;
        ArrayList obj9;
        final Class<com.google.android.exoplayer2.mediacodec.MediaCodecUtil> obj = MediaCodecUtil.class;
        MediaCodecUtil.b bVar = new MediaCodecUtil.b(string, z2, z3);
        final HashMap map = MediaCodecUtil.b;
        Object obj2 = map.get(bVar);
        synchronized (obj) {
            return (List)obj2;
        }
    }

    private static ArrayList<com.google.android.exoplayer2.mediacodec.r> o(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b mediaCodecUtil$b, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c mediaCodecUtil$c2) {
        int i2;
        int stringBuilder;
        int i7;
        String str;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean z4;
        boolean name;
        int i3;
        boolean z2;
        int i5;
        boolean z5;
        boolean z3;
        int i6;
        int i4;
        Object obj;
        Object obj2;
        int i;
        boolean z;
        final Object obj3 = b;
        final String obj4 = c2;
        final String str3 = "secure-playback";
        final String str4 = "tunneled-playback";
        ArrayList arrayList = new ArrayList();
        final String str8 = obj3.a;
        i5 = c2.d();
        z2 = c2.e();
        i3 = i2;
        while (i3 < i5) {
            i2 = obj4.a(i3);
            name = i2.getName();
            z4 = MediaCodecUtil.k(i2, name, str8);
            capabilitiesForType = i2.getCapabilitiesForType(z4);
            str = obj3.c;
            stringBuilder = obj4.b(str3, z4, capabilitiesForType);
            str = obj3.b;
            z5 = MediaCodecUtil.y(i2);
            z3 = MediaCodecUtil.A(i2);
            i2 = MediaCodecUtil.C(i2);
            i = i3;
            i6 = i5;
            i3 = i + 1;
            i5 = i6;
            z2 = z;
            obj = z4;
            obj2 = name;
            i = i3;
            z = z2;
            i6 = i5;
            arrayList.add(r.A(name, str8, z4, capabilitiesForType, z5, z3, i2, false, false));
            i = i3;
            z = z2;
            i6 = i5;
            obj = obj10;
            obj2 = obj11;
            i = obj12;
            z = obj13;
            i6 = obj14;
            stringBuilder = p0.a;
            i7 = 23;
            str = "MediaCodecUtil";
            stringBuilder = obj5.isEmpty();
            Throwable th = String.valueOf(obj2);
            th = th.length();
            th += 46;
            stringBuilder = new StringBuilder(th);
            th = "Skipping codec ";
            stringBuilder.append(th);
            i7 = obj2;
            stringBuilder.append(i7);
            th = " (failed to query capabilities)";
            stringBuilder.append(th);
            th = stringBuilder.toString();
            v.c(str, th);
        }
        return arrayList;
    }

    public static List<com.google.android.exoplayer2.mediacodec.r> p(List<com.google.android.exoplayer2.mediacodec.r> list, i1 i12) {
        ArrayList arrayList = new ArrayList(list);
        g obj1 = new g(i12);
        MediaCodecUtil.K(arrayList, obj1);
        return arrayList;
    }

    public static com.google.android.exoplayer2.mediacodec.r q() {
        final int i = 0;
        return MediaCodecUtil.m("audio/raw", i, i);
    }

    private static Pair<Integer, Integer> r(String string, String[] string2Arr2) {
        String obj6;
        final String str = "Ignoring malformed Dolby Vision codec string: ";
        final int i = 0;
        final String str2 = "MediaCodecUtil";
        if (string2Arr2.length < 3) {
            obj6 = String.valueOf(string);
            if (obj6.length() != 0) {
                obj6 = str.concat(obj6);
            } else {
                obj6 = new String(str);
            }
            v.h(str2, obj6);
            return i;
        }
        int i3 = 1;
        Matcher matcher = MediaCodecUtil.a.matcher(string2Arr2[i3]);
        if (!matcher.matches()) {
            obj6 = String.valueOf(string);
            if (obj6.length() != 0) {
                obj6 = str.concat(obj6);
            } else {
                obj6 = new String(str);
            }
            v.h(str2, obj6);
            return i;
        }
        obj6 = matcher.group(i3);
        Integer num = MediaCodecUtil.g(obj6);
        if (num == null) {
            String obj7 = "Unknown Dolby Vision profile string: ";
            obj6 = String.valueOf(obj6);
            if (obj6.length() != 0) {
                obj6 = obj7.concat(obj6);
            } else {
                obj6 = new String(obj7);
            }
            v.h(str2, obj6);
            return i;
        }
        obj6 = string2Arr2[2];
        obj7 = MediaCodecUtil.f(obj6);
        if (obj7 == null) {
            obj7 = "Unknown Dolby Vision level string: ";
            obj6 = String.valueOf(obj6);
            if (obj6.length() != 0) {
                obj6 = obj7.concat(obj6);
            } else {
                obj6 = new String(obj7);
            }
            v.h(str2, obj6);
            return i;
        }
        obj6 = new Pair(num, obj7);
        return obj6;
    }

    private static Pair<Integer, Integer> s(String string, String[] string2Arr2) {
        boolean equals;
        int i;
        String obj6;
        final String str3 = "Ignoring malformed HEVC codec string: ";
        final int i2 = 0;
        final String str4 = "MediaCodecUtil";
        if (string2Arr2.length < 4) {
            obj6 = String.valueOf(string);
            if (obj6.length() != 0) {
                obj6 = str3.concat(obj6);
            } else {
                obj6 = new String(str3);
            }
            v.h(str4, obj6);
            return i2;
        }
        i = 1;
        Matcher matcher = MediaCodecUtil.a.matcher(string2Arr2[i]);
        if (!matcher.matches()) {
            obj6 = String.valueOf(string);
            if (obj6.length() != 0) {
                obj6 = str3.concat(obj6);
            } else {
                obj6 = new String(str3);
            }
            v.h(str4, obj6);
            return i2;
        }
        obj6 = matcher.group(i);
        if ("1".equals(obj6)) {
            obj6 = string2Arr2[3];
            Integer obj7 = MediaCodecUtil.u(obj6);
            if (obj7 == null) {
                obj7 = "Unknown HEVC level string: ";
                obj6 = String.valueOf(obj6);
                if (obj6.length() != 0) {
                    obj6 = obj7.concat(obj6);
                } else {
                    obj6 = new String(obj7);
                }
                v.h(str4, obj6);
                return i2;
            }
            obj6 = new Pair(Integer.valueOf(i), obj7);
            return obj6;
        } else {
            if ("2".equals(obj6)) {
                i = 2;
            }
        }
        obj7 = "Unknown HEVC profile string: ";
        obj6 = String.valueOf(obj6);
        if (obj6.length() != 0) {
            obj6 = obj7.concat(obj6);
        } else {
            obj6 = new String(obj7);
        }
        v.h(str4, obj6);
        return i2;
    }

    private static Pair<Integer, Integer> t(String string, String[] string2Arr2) {
        String obj5;
        String str = "Ignoring malformed VP9 codec string: ";
        final int i4 = 0;
        final String str2 = "MediaCodecUtil";
        if (string2Arr2.length < 3) {
            obj5 = String.valueOf(string);
            if (obj5.length() != 0) {
                obj5 = str.concat(obj5);
            } else {
                obj5 = new String(str);
            }
            v.h(str2, obj5);
            return i4;
        }
        int int = Integer.parseInt(string2Arr2[1]);
        obj5 = Integer.parseInt(string2Arr2[2]);
        int obj6 = MediaCodecUtil.M(int);
        int i3 = -1;
        if (obj6 == i3) {
            obj6 = new StringBuilder(32);
            obj6.append("Unknown VP9 profile: ");
            obj6.append(int);
            v.h(str2, obj6.toString());
            return i4;
        }
        int i2 = MediaCodecUtil.L(obj5);
        if (i2 == i3) {
            StringBuilder stringBuilder = new StringBuilder(30);
            stringBuilder.append("Unknown VP9 level: ");
            stringBuilder.append(obj5);
            v.h(str2, stringBuilder.toString());
            return i4;
        }
        obj5 = new Pair(Integer.valueOf(obj6), Integer.valueOf(i2));
        return obj5;
    }

    private static Integer u(String string) {
        Object obj;
        int i;
        String str2;
        boolean obj8;
        final int i2 = 0;
        if (string == null) {
            return i2;
        }
        string.hashCode();
        i = -1;
        final int i3 = 16;
        final int i4 = 8;
        final int i5 = 4;
        final int i6 = 2;
        final int i7 = 1;
        switch (string) {
            case "H30":
                i = 0;
                break;
            case "H60":
                i = i7;
                break;
            case "H63":
                i = i6;
                break;
            case "H90":
                i = 3;
                break;
            case "H93":
                i = i5;
                break;
            case "L30":
                i = 5;
                break;
            case "L60":
                i = 6;
                break;
            case "L63":
                i = 7;
                break;
            case "L90":
                i = i4;
                break;
            case "L93":
                i = 9;
                break;
            case "H120":
                i = 10;
                break;
            case "H123":
                i = 11;
                break;
            case "H150":
                i = 12;
                break;
            case "H153":
                i = 13;
                break;
            case "H156":
                i = 14;
                break;
            case "H180":
                i = 15;
                break;
            case "H183":
                i = i3;
                break;
            case "H186":
                i = 17;
                break;
            case "L120":
                i = 18;
                break;
            case "L123":
                i = 19;
                break;
            case "L150":
                i = 20;
                break;
            case "L153":
                i = 21;
                break;
            case "L156":
                i = 22;
                break;
            case "L180":
                i = 23;
                break;
            case "L183":
                i = 24;
                break;
            case "L186":
                i = 25;
                break;
            default:
        }
        switch (i) {
            case 0:
                return Integer.valueOf(i6);
            case 1:
                return Integer.valueOf(i4);
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return Integer.valueOf(i7);
            case 6:
                return Integer.valueOf(i5);
            case 7:
                return Integer.valueOf(i3);
            case 8:
                return 64;
            case 9:
                return 256;
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return i2;
        }
    }

    private static boolean v(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo obj2;
        if (p0.a >= 29 && MediaCodecUtil.w(mediaCodecInfo)) {
            obj2 = MediaCodecUtil.w(mediaCodecInfo) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static boolean w(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean x(MediaCodecInfo mediaCodecInfo, String string2, boolean z3, String string4) {
        boolean equals;
        String startsWith2;
        String startsWith;
        boolean startsWith3;
        boolean obj4;
        int obj6;
        final int i = 0;
        if (!mediaCodecInfo.isEncoder()) {
            if (!z3 && string2.endsWith(".secure")) {
                if (string2.endsWith(".secure")) {
                } else {
                    obj4 = p0.a;
                    if (obj4 < 21 && !"CIPAACDecoder".equals(string2) && !"CIPMP3Decoder".equals(string2) && !"CIPVorbisDecoder".equals(string2) && !"CIPAMRNBDecoder".equals(string2) && !"AACDecoder".equals(string2) && "MP3Decoder".equals(string2)) {
                        if (!"CIPAACDecoder".equals(string2)) {
                            if (!"CIPMP3Decoder".equals(string2)) {
                                if (!"CIPVorbisDecoder".equals(string2)) {
                                    if (!"CIPAMRNBDecoder".equals(string2)) {
                                        if (!"AACDecoder".equals(string2)) {
                                            if ("MP3Decoder".equals(string2)) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return i;
                    }
                    obj6 = p0.b;
                    if (obj4 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(string2) && !"a70".equals(obj6) && "Xiaomi".equals(p0.c) && obj6.startsWith("HM")) {
                        if ("OMX.MTK.AUDIO.DECODER.AAC".equals(string2)) {
                            obj6 = p0.b;
                            if (!"a70".equals(obj6)) {
                                if ("Xiaomi".equals(p0.c)) {
                                    if (obj6.startsWith("HM")) {
                                    }
                                }
                            }
                            return i;
                        }
                    }
                    obj6 = 16;
                    equals = p0.b;
                    if (obj4 == obj6 && "OMX.qcom.audio.decoder.mp3".equals(string2) && !"dlxu".equals(equals) && !"protou".equals(equals) && !"ville".equals(equals) && !"villeplus".equals(equals) && !"villec2".equals(equals) && !equals.startsWith("gee") && !"C6602".equals(equals) && !"C6603".equals(equals) && !"C6606".equals(equals) && !"C6616".equals(equals) && !"L36h".equals(equals) && "SO-02E".equals(equals)) {
                        if ("OMX.qcom.audio.decoder.mp3".equals(string2)) {
                            equals = p0.b;
                            if (!"dlxu".equals(equals)) {
                                if (!"protou".equals(equals)) {
                                    if (!"ville".equals(equals)) {
                                        if (!"villeplus".equals(equals)) {
                                            if (!"villec2".equals(equals)) {
                                                if (!equals.startsWith("gee")) {
                                                    if (!"C6602".equals(equals)) {
                                                        if (!"C6603".equals(equals)) {
                                                            if (!"C6606".equals(equals)) {
                                                                if (!"C6616".equals(equals)) {
                                                                    if (!"L36h".equals(equals)) {
                                                                        if ("SO-02E".equals(equals)) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return i;
                        }
                    }
                    obj6 = p0.b;
                    if (obj4 == obj6 && "OMX.qcom.audio.decoder.aac".equals(string2) && !"C1504".equals(obj6) && !"C1505".equals(obj6) && !"C1604".equals(obj6) && "C1605".equals(obj6)) {
                        if ("OMX.qcom.audio.decoder.aac".equals(string2)) {
                            obj6 = p0.b;
                            if (!"C1504".equals(obj6)) {
                                if (!"C1505".equals(obj6)) {
                                    if (!"C1604".equals(obj6)) {
                                        if ("C1605".equals(obj6)) {
                                        }
                                    }
                                }
                            }
                            return i;
                        }
                    }
                    startsWith2 = "samsung";
                    if (obj4 < 24) {
                        if (!"OMX.SEC.aac.dec".equals(string2)) {
                            obj6 = p0.b;
                            if ("OMX.Exynos.AAC.Decoder".equals(string2) && startsWith2.equals(p0.c) && !obj6.startsWith("zeroflte") && !obj6.startsWith("zerolte") && !obj6.startsWith("zenlte") && !"SC-05G".equals(obj6) && !"marinelteatt".equals(obj6) && !"404SC".equals(obj6) && !"SC-04G".equals(obj6) && "SCV31".equals(obj6)) {
                                if (startsWith2.equals(p0.c)) {
                                    obj6 = p0.b;
                                    if (!obj6.startsWith("zeroflte")) {
                                        if (!obj6.startsWith("zerolte")) {
                                            if (!obj6.startsWith("zenlte")) {
                                                if (!"SC-05G".equals(obj6)) {
                                                    if (!"marinelteatt".equals(obj6)) {
                                                        if (!"404SC".equals(obj6)) {
                                                            if (!"SC-04G".equals(obj6)) {
                                                                if ("SCV31".equals(obj6)) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return i;
                                }
                            }
                        } else {
                        }
                    }
                    obj6 = "jflte";
                    int i2 = 19;
                    startsWith2 = p0.b;
                    if (obj4 <= i2 && "OMX.SEC.vp8.dec".equals(string2) && startsWith2.equals(p0.c) && !startsWith2.startsWith("d2") && !startsWith2.startsWith("serrano") && !startsWith2.startsWith(obj6) && !startsWith2.startsWith("santos") && startsWith2.startsWith("t0")) {
                        if ("OMX.SEC.vp8.dec".equals(string2)) {
                            if (startsWith2.equals(p0.c)) {
                                startsWith2 = p0.b;
                                if (!startsWith2.startsWith("d2")) {
                                    if (!startsWith2.startsWith("serrano")) {
                                        if (!startsWith2.startsWith(obj6)) {
                                            if (!startsWith2.startsWith("santos")) {
                                                if (startsWith2.startsWith("t0")) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return i;
                            }
                        }
                    }
                    if (obj4 <= i2 && p0.b.startsWith(obj6) && "OMX.qcom.video.decoder.vp8".equals(string2)) {
                        if (p0.b.startsWith(obj6)) {
                            if ("OMX.qcom.video.decoder.vp8".equals(string2)) {
                                return i;
                            }
                        }
                    }
                    if ("audio/eac3-joc".equals(string4) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(string2)) {
                        if ("OMX.MTK.AUDIO.DECODER.DSPAC3".equals(string2)) {
                            return i;
                        }
                    }
                }
            } else {
            }
            return 1;
        }
        return i;
    }

    private static boolean y(MediaCodecInfo mediaCodecInfo) {
        if (p0.a >= 29) {
            return MediaCodecUtil.z(mediaCodecInfo);
        }
        return obj2 ^= 1;
    }

    private static boolean z(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }
}
