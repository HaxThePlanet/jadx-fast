package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Range;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;

/* loaded from: classes2.dex */
public final class r {

    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    private final boolean g;
    r(String string, String string2, String string3, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        super();
        g.e(string);
        this.a = (String)string;
        this.b = string2;
        this.c = string3;
        this.d = codecCapabilities4;
        this.e = z8;
        this.f = z10;
        this.g = z.q(string2);
    }

    public static com.google.android.exoplayer2.mediacodec.r A(String string, String string2, String string3, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        boolean z;
        int i2;
        int i3;
        int i;
        int i4 = 1;
        int i5 = 0;
        if (!z8 && codecCapabilities4 != null && r.h(codecCapabilities4) && !r.y(string)) {
            if (codecCapabilities4 != null) {
                if (r.h(codecCapabilities4)) {
                    i2 = !r.y(string) ? i4 : i5;
                } else {
                }
            } else {
            }
        } else {
        }
        if (codecCapabilities4 != null && r.r(codecCapabilities4)) {
            i3 = r.r(codecCapabilities4) ? i4 : i5;
        } else {
        }
        if (!z9) {
            if (codecCapabilities4 != null && r.p(codecCapabilities4)) {
                if (r.p(codecCapabilities4)) {
                    i = i4;
                } else {
                    i = i5;
                }
            } else {
            }
        } else {
        }
        super(string, string2, string3, codecCapabilities4, z5, z6, z7, i2, i3, i);
        return rVar2;
    }

    private static int a(String string, String string2, int i3) {
        int equals;
        boolean equals2;
        int i;
        int obj3;
        if (i3 <= 1) {
            if (p0.a >= 26 && i3 > 0) {
                if (i3 > 0) {
                } else {
                    if (!"audio/mpeg".equals(string2) && !"audio/3gpp".equals(string2) && !"audio/amr-wb".equals(string2) && !"audio/mp4a-latm".equals(string2) && !"audio/vorbis".equals(string2) && !"audio/opus".equals(string2) && !"audio/raw".equals(string2) && !"audio/flac".equals(string2) && !"audio/g711-alaw".equals(string2) && !"audio/g711-mlaw".equals(string2)) {
                        if (!"audio/3gpp".equals(string2)) {
                            if (!"audio/amr-wb".equals(string2)) {
                                if (!"audio/mp4a-latm".equals(string2)) {
                                    if (!"audio/vorbis".equals(string2)) {
                                        if (!"audio/opus".equals(string2)) {
                                            if (!"audio/raw".equals(string2)) {
                                                if (!"audio/flac".equals(string2)) {
                                                    if (!"audio/g711-alaw".equals(string2)) {
                                                        if (!"audio/g711-mlaw".equals(string2)) {
                                                            if ("audio/gsm".equals(string2)) {
                                                            } else {
                                                                obj3 = "audio/ac3".equals(string2) ? 6 : obj3 != null ? 16 : 30;
                                                            }
                                                            StringBuilder stringBuilder = new StringBuilder(length += 59);
                                                            stringBuilder.append("AssumedMaxChannelAdjustment: ");
                                                            stringBuilder.append(string);
                                                            stringBuilder.append(", [");
                                                            stringBuilder.append(i3);
                                                            stringBuilder.append(" to ");
                                                            stringBuilder.append(obj3);
                                                            stringBuilder.append("]");
                                                            v.h("MediaCodecInfo", stringBuilder.toString());
                                                            return obj3;
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
            } else {
            }
        }
        return i3;
    }

    private static Point c(MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities, int i2, int i3) {
        final int widthAlignment = videoCapabilities.getWidthAlignment();
        final int obj2 = videoCapabilities.getHeightAlignment();
        Point point = new Point(obj3 *= widthAlignment, obj4 *= obj2);
        return point;
    }

    private static boolean d(MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities, int i2, int i3, double d4) {
        int cmp;
        Point obj3 = r.c(videoCapabilities, i2, i3);
        final int obj4 = obj3.x;
        obj3 = obj3.y;
        if (Double.compare(d4, l) != 0 && Double.compare(d4, l2) < 0) {
            if (Double.compare(d4, l2) < 0) {
            }
            return videoCapabilities.areSizeAndRateSupported(obj4, obj3, Math.floor(d4));
        }
        return videoCapabilities.isSizeSupported(obj4, obj3);
    }

    private static MediaCodecInfo.CodecProfileLevel[] f(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        int i;
        MediaCodecInfo.VideoCapabilities obj3;
        final int i2 = 0;
        obj3 = codecCapabilities.getVideoCapabilities();
        if (codecCapabilities != null && obj3 != null) {
            obj3 = codecCapabilities.getVideoCapabilities();
            if (obj3 != null) {
                obj3 = (Integer)obj3.getBitrateRange().getUpper().intValue();
            } else {
                obj3 = i2;
            }
        } else {
        }
        final int i3 = 1;
        obj3 = obj3 >= 180000000 ? 1024 : obj3 >= i ? 512 : obj3 >= i ? 256 : obj3 >= i ? 128 : obj3 >= i ? 64 : obj3 >= i ? 32 : obj3 >= i ? 16 : obj3 >= i ? 8 : obj3 >= i ? 4 : obj3 >= i ? 2 : i3;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i3;
        codecProfileLevel.level = obj3;
        obj3 = new MediaCodecInfo.CodecProfileLevel[i3];
        obj3[i2] = codecProfileLevel;
        return obj3;
    }

    private static boolean h(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        MediaCodecInfo.CodecCapabilities obj2;
        if (p0.a >= 19 && r.i(codecCapabilities)) {
            obj2 = r.i(codecCapabilities) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static boolean i(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean p(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        MediaCodecInfo.CodecCapabilities obj2;
        if (p0.a >= 21 && r.q(codecCapabilities)) {
            obj2 = r.q(codecCapabilities) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static boolean q(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean r(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        MediaCodecInfo.CodecCapabilities obj2;
        if (p0.a >= 21 && r.s(codecCapabilities)) {
            obj2 = r.s(codecCapabilities) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void u(String string) {
        String str = this.a;
        final String str4 = this.b;
        final String str5 = p0.e;
        StringBuilder stringBuilder = new StringBuilder(i3 += length4);
        stringBuilder.append("AssumedSupport [");
        stringBuilder.append(string);
        String obj6 = "] [";
        stringBuilder.append(obj6);
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(str4);
        stringBuilder.append(obj6);
        stringBuilder.append(str5);
        stringBuilder.append("]");
        v.b("MediaCodecInfo", stringBuilder.toString());
    }

    private void v(String string) {
        String str = this.a;
        final String str4 = this.b;
        final String str5 = p0.e;
        StringBuilder stringBuilder = new StringBuilder(i3 += length4);
        stringBuilder.append("NoSupport [");
        stringBuilder.append(string);
        String obj6 = "] [";
        stringBuilder.append(obj6);
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(str4);
        stringBuilder.append(obj6);
        stringBuilder.append(str5);
        stringBuilder.append("]");
        v.b("MediaCodecInfo", stringBuilder.toString());
    }

    private static boolean w(String string) {
        return "audio/opus".equals(string);
    }

    private static boolean x(String string) {
        boolean startsWith;
        Object obj2;
        if (p0.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(string)) {
            obj2 = "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private static boolean y(String string) {
        int equals;
        int equals2;
        int obj2;
        if (p0.a <= 22) {
            equals = p0.d;
            if (!"ODROID-XU3".equals(equals)) {
                if ("Nexus 10".equals(equals)) {
                    if (!"OMX.Exynos.AVC.Decoder".equals(string)) {
                        obj2 = "OMX.Exynos.AVC.Decoder.secure".equals(string) ? 1 : 0;
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

    private static final boolean z(String string) {
        String str;
        boolean obj1;
        if ("OMX.MTK.VIDEO.DECODER.HEVC".equals(string) && "mcv5a".equals(p0.b)) {
            if ("mcv5a".equals(p0.b)) {
                return 0;
            }
        }
        return 1;
    }

    public Point b(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        final int i3 = 0;
        if (codecCapabilities == null) {
            return i3;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            return i3;
        }
        return r.c(videoCapabilities, i, i2);
    }

    public e e(i1 i1, i1 i12) {
        int i2;
        int intValue;
        boolean z;
        int z2;
        int i;
        int intValue2;
        int i3;
        int i4;
        i2 = !p0.b(i1.D, i12.D) ? 8 : 0;
        if (this.g) {
            if (i1.L != i12.L) {
                i2 |= 1024;
            }
            if (!this.e) {
                if (i1.I == i12.I) {
                    if (i1.J != i12.J) {
                        i2 |= 512;
                    }
                } else {
                }
            }
            if (!p0.b(i1.P, i12.P)) {
                i2 |= 2048;
            }
            if (r.x(this.a) && !i1.d(i12)) {
                if (!i1.d(i12)) {
                    i2 |= 2;
                }
            }
            if (i2 == 0) {
                i = i1.d(i12) ? 3 : 2;
                super(this.a, i1, i12, i, 0);
                return eVar4;
            }
        } else {
            if (i1.Q != i12.Q) {
                i2 |= 4096;
            }
            if (i1.R != i12.R) {
                i2 |= 8192;
            }
            if (i1.S != i12.S) {
                i2 |= 16384;
            }
            intValue = MediaCodecUtil.l(i1);
            intValue2 = MediaCodecUtil.l(i12);
            i4 = 42;
            if (i2 == 0 && "audio/mp4a-latm".equals(this.b) && intValue != null && intValue2 != null && (Integer)intValue.first.intValue() == i4 && (Integer)intValue2.first.intValue() == i4) {
                if ("audio/mp4a-latm".equals(this.b)) {
                    intValue = MediaCodecUtil.l(i1);
                    intValue2 = MediaCodecUtil.l(i12);
                    if (intValue != null) {
                        if (intValue2 != null) {
                            i4 = 42;
                            if ((Integer)intValue.first.intValue() == i4) {
                                if ((Integer)intValue2.first.intValue() == i4) {
                                    super(this.a, i1, i12, 3, 0);
                                    return eVar;
                                }
                            }
                        }
                    }
                }
            }
            if (!i1.d(i12)) {
                i2 |= 32;
            }
            if (r.w(this.b)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                super(this.a, i1, i12, 1, 0);
                return eVar2;
            }
        }
        super(this.a, i1, i12, 0, i2);
        return eVar3;
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] profileLevels;
        profileLevels = this.d;
        if (profileLevels != null) {
            if (profileLevels.profileLevels == null) {
                profileLevels = new MediaCodecInfo.CodecProfileLevel[0];
            }
        } else {
        }
        return profileLevels;
    }

    public boolean j(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        final int i4 = 0;
        if (codecCapabilities == null) {
            v("channelCount.caps");
            return i4;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            v("channelCount.aCaps");
            return i4;
        }
        if (r.a(this.a, this.b, audioCapabilities.getMaxInputChannelCount()) < i) {
            StringBuilder stringBuilder = new StringBuilder(33);
            stringBuilder.append("channelCount.support, ");
            stringBuilder.append(i);
            v(stringBuilder.toString());
            return i4;
        }
        return 1;
    }

    public boolean k(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        final int i3 = 0;
        if (codecCapabilities == null) {
            v("sampleRate.caps");
            return i3;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            v("sampleRate.aCaps");
            return i3;
        }
        if (!audioCapabilities.isSampleRateSupported(i)) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("sampleRate.support, ");
            stringBuilder.append(i);
            v(stringBuilder.toString());
            return i3;
        }
        return 1;
    }

    public boolean l(i1 i1) {
        String str;
        boolean z;
        MediaCodecInfo.CodecProfileLevel[] objArr;
        int equals;
        int str2;
        int i;
        MediaCodecInfo.CodecProfileLevel level;
        int profile;
        String str3 = i1.A;
        int i2 = 1;
        if (str3 != null) {
            if (this.b == null) {
            } else {
                String str4 = z.g(str3);
                if (str4 == null) {
                    return i2;
                }
                final String str8 = ", ";
                final int i7 = 0;
                if (!this.b.equals(str4)) {
                    String obj12 = i1.A;
                    StringBuilder stringBuilder = new StringBuilder(i3 += length3);
                    stringBuilder.append("codec.mime ");
                    stringBuilder.append(obj12);
                    stringBuilder.append(str8);
                    stringBuilder.append(str4);
                    v(stringBuilder.toString());
                    return i7;
                }
                android.util.Pair pair = MediaCodecUtil.l(i1);
                if (pair == null) {
                    return i2;
                }
                int intValue2 = (Integer)pair.first.intValue();
                if (!this.g && intValue2 != 42) {
                    if (intValue2 != 42) {
                        return i2;
                    }
                }
                if (p0.a <= 23 && "video/x-vnd.on2.vp9".equals(this.b) && objArr.length == 0) {
                    if ("video/x-vnd.on2.vp9".equals(this.b)) {
                        if (objArr.length == 0) {
                            objArr = r.f(this.d);
                        }
                    }
                }
                i = i7;
                while (i < objArr.length) {
                    level = objArr[i];
                    i++;
                }
            }
            obj12 = i1.A;
            StringBuilder stringBuilder2 = new StringBuilder(i5 += length4);
            stringBuilder2.append("codec.profileLevel, ");
            stringBuilder2.append(obj12);
            stringBuilder2.append(str8);
            stringBuilder2.append(str4);
            v(stringBuilder2.toString());
            return i7;
        }
        return i2;
    }

    public boolean m(i1 i1) {
        int str;
        int i2;
        int i3;
        int str2;
        int i4;
        int stringBuilder;
        int i;
        Object obj7;
        if (!l(i1)) {
            return 0;
        }
        i4 = 21;
        stringBuilder = 1;
        int i5 = i1.I;
        if (this.g && i5 > 0) {
            i5 = i1.I;
            if (i5 > 0) {
                i = i1.J;
                if (i <= 0) {
                } else {
                    if (p0.a >= i4) {
                        return t(i5, i, (double)obj7);
                    }
                    if (i5 *= i <= MediaCodecUtil.I()) {
                        i3 = stringBuilder;
                    }
                    if (i3 == 0) {
                        stringBuilder = new StringBuilder(40);
                        stringBuilder.append("legacyFrameSize, ");
                        stringBuilder.append(i1.I);
                        stringBuilder.append("x");
                        stringBuilder.append(i1.J);
                        v(stringBuilder.toString());
                    }
                }
                return i3;
            }
            return stringBuilder;
        }
        if (p0.a >= i4) {
            i2 = i1.R;
            i4 = -1;
            if (i2 != i4) {
                if (k(i2)) {
                    obj7 = i1.Q;
                    if (obj7 != i4) {
                        if (j(obj7)) {
                            i3 = stringBuilder;
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

    public boolean n() {
        int equals;
        int length;
        int i2;
        int profile;
        int i;
        final int i4 = 0;
        if (p0.a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            if ("video/x-vnd.on2.vp9".equals(this.b)) {
                equals = g();
                i2 = i4;
                while (i2 < equals.length) {
                    i2++;
                }
            }
        }
        return i4;
    }

    public boolean o(i1 i1) {
        boolean z;
        android.util.Pair obj2;
        if (this.g) {
            return this.e;
        }
        obj2 = MediaCodecUtil.l(i1);
        if (obj2 != null && (Integer)obj2.first.intValue() == 42) {
            obj2 = (Integer)obj2.first.intValue() == 42 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public boolean t(int i, int i2, double d3) {
        Object videoCapabilities;
        int str;
        boolean z2;
        String str2;
        boolean z;
        Object obj6;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        str = 0;
        if (codecCapabilities == null) {
            v("sizeAndRate.caps");
            return str;
        }
        videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            v("sizeAndRate.vCaps");
            return str;
        }
        z2 = 69;
        str2 = "x";
        if (!r.d(videoCapabilities, i, i2, d3) && i < i2 && r.z(this.a) && !r.d(videoCapabilities, i2, i, d3)) {
            z2 = 69;
            str2 = "x";
            if (i < i2) {
                if (r.z(this.a)) {
                    if (!r.d(videoCapabilities, i2, i, d3)) {
                    }
                    videoCapabilities = new StringBuilder(z2);
                    videoCapabilities.append("sizeAndRate.rotated, ");
                    videoCapabilities.append(i);
                    videoCapabilities.append(str2);
                    videoCapabilities.append(i2);
                    videoCapabilities.append(str2);
                    videoCapabilities.append(d3);
                    u(videoCapabilities.toString());
                }
            }
            StringBuilder stringBuilder = new StringBuilder(z2);
            stringBuilder.append("sizeAndRate.support, ");
            stringBuilder.append(i);
            stringBuilder.append(str2);
            stringBuilder.append(i2);
            stringBuilder.append(str2);
            stringBuilder.append(d3);
            v(stringBuilder.toString());
            return str;
        }
        return 1;
    }

    public String toString() {
        return this.a;
    }
}
