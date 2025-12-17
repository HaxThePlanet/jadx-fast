package com.google.android.exoplayer2.video;

import android.accounts.Account;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.j2.h1;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.q;
import com.google.android.exoplayer2.mediacodec.q.a;
import com.google.android.exoplayer2.mediacodec.q.b;
import com.google.android.exoplayer2.mediacodec.q.c;
import com.google.android.exoplayer2.mediacodec.r;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.b0.l;
import com.google.firebase.firestore.local.SQLiteIndexManager;
import com.google.firebase.inappmessaging.MessagesProto.ModalMessage;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.revenuecat.purchases.strings.Emojis;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class s extends MediaCodecRenderer {

    private static final int[] I1;
    private static boolean J1;
    private static boolean K1;
    private int A1;
    private int B1;
    private float C1;
    private com.google.android.exoplayer2.video.a0 D1;
    private boolean E1;
    private int F1;
    com.google.android.exoplayer2.video.s.b G1;
    private com.google.android.exoplayer2.video.w H1;
    private final Context Z0;
    private final com.google.android.exoplayer2.video.x a1;
    private final com.google.android.exoplayer2.video.z.a b1;
    private final long c1;
    private final int d1;
    private final boolean e1;
    private com.google.android.exoplayer2.video.s.a f1;
    private boolean g1;
    private boolean h1;
    private Surface i1;
    private com.google.android.exoplayer2.video.p j1;
    private boolean k1;
    private int l1;
    private boolean m1;
    private boolean n1;
    private boolean o1;
    private long p1;
    private long q1;
    private long r1;
    private int s1;
    private int t1;
    private int u1;
    private long v1;
    private long w1;
    private long x1;
    private int y1;
    private int z1;

    protected static final class a {

        public final int a;
        public final int b;
        public final int c;
        public a(int i, int i2, int i3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    private final class b implements q.c, Handler.Callback {

        private final Handler a;
        final com.google.android.exoplayer2.video.s b;
        public b(com.google.android.exoplayer2.video.s s, q q2) {
            this.b = s;
            super();
            final Handler obj1 = p0.v(this);
            this.a = obj1;
            q2.i(this, obj1);
        }

        private void b(long l) {
            long obj4;
            com.google.android.exoplayer2.video.s obj5;
            final com.google.android.exoplayer2.video.s sVar = this.b;
            if (this != sVar.G1) {
            }
            if (Long.compare(l, l2) == 0) {
                s.t1(sVar);
            } else {
                sVar.S1(l);
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.q$c
        public void a(q q, long l2, long l3) {
            int i;
            Message obj3;
            Handler obj4;
            int obj6;
            int obj7;
            if (p0.a < 30) {
                this.a.sendMessageAtFrontOfQueue(Message.obtain(this.a, 0, (int)i, (int)l2));
            } else {
                b(l2);
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.q$c
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return 0;
            }
            b(p0.H0(message.arg1, message.arg2));
            return 1;
        }
    }
    static {
        int[] iArr = new int[9];
        iArr = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
        s.I1 = iArr;
    }

    public s(Context context, q.b q$b2, s s3, long l4, boolean z5, Handler handler6, com.google.android.exoplayer2.video.z z7, int i8) {
        super(2, b2, s3, handler6, 1106247680);
        this.c1 = l4;
        this.d1 = obj15;
        Context obj7 = context.getApplicationContext();
        this.Z0 = obj7;
        x obj8 = new x(obj7);
        this.a1 = obj8;
        obj7 = new z.a(z7, i8);
        this.b1 = obj7;
        this.e1 = s.z1();
        this.q1 = -9223372036854775807L;
        obj7 = -1;
        this.z1 = obj7;
        this.A1 = obj7;
        this.C1 = -1082130432;
        this.l1 = 1;
        this.F1 = 0;
        w1();
    }

    public s(Context context, s s2, long l3, boolean z4, Handler handler5, com.google.android.exoplayer2.video.z z6, int i7) {
        super(context, q.b.a, s2, l3, obj5, handler5, z6, i7, obj18);
    }

    private static boolean B1() {
        int equals3;
        Emojis emojis;
        int str2;
        boolean cmp;
        int str3;
        int str;
        int i3;
        int i;
        int i4;
        int i2;
        int i5;
        int l2;
        String equals2;
        int equals;
        String str4;
        equals3 = p0.a;
        str3 = 5;
        final int i6 = 4;
        final int i7 = 3;
        final int i8 = 28;
        i2 = 2;
        final int i9 = -1;
        final int i11 = 0;
        final int i13 = 1;
        if (equals3 <= i8) {
            equals2 = p0.b;
            equals2.hashCode();
            switch (equals2) {
                case "dangal":
                    l2 = i9;
                    l2 = i11;
                    break;
                case "dangalFHD":
                    l2 = i9;
                    l2 = i13;
                    break;
                case "dangalUHD":
                    l2 = i9;
                    l2 = i2;
                    break;
                case "oneday":
                    l2 = i9;
                    l2 = i7;
                    break;
                case "magnolia":
                    l2 = i9;
                    l2 = i6;
                    break;
                case "once":
                    l2 = i9;
                    l2 = str3;
                    break;
                case "machuca":
                    l2 = i9;
                    l2 = str2;
                    break;
                default:
                    l2 = i9;
            }
            if (/* condition */) {
                return i13;
            }
        }
        int i14 = 27;
        if (equals3 <= i14 && "HWEML".equals(p0.b)) {
            if ("HWEML".equals(p0.b)) {
                return i13;
            }
        }
        int i15 = 26;
        if (equals3 <= i15) {
            equals3 = p0.b;
            equals3.hashCode();
            switch (equals3) {
                case "GIONEE_SWW1609":
                    str2 = i9;
                    str2 = i11;
                    break;
                case "GIONEE_SWW1627":
                    str2 = i9;
                    str2 = i13;
                    break;
                case "GIONEE_SWW1631":
                    str2 = i9;
                    str2 = i2;
                    break;
                case "K50a40":
                    str2 = i9;
                    str2 = i7;
                    break;
                case "CP8676_I02":
                    str2 = i9;
                    str2 = i6;
                    break;
                case "NX541J":
                    str2 = i9;
                    str2 = str3;
                    break;
                case "NX573J":
                    str2 = i9;
                    break;
                case "PGN528":
                    str2 = i9;
                    str2 = 7;
                    break;
                case "PGN610":
                    str2 = i9;
                    str2 = 8;
                    break;
                case "PGN611":
                    str2 = i9;
                    str2 = 9;
                    break;
                case "AquaPowerM":
                    str2 = i9;
                    str2 = 10;
                    break;
                case "RAIJIN":
                    str2 = i9;
                    str2 = 11;
                    break;
                case "XT1663":
                    str2 = i9;
                    str2 = 12;
                    break;
                case "ComioS1":
                    str2 = i9;
                    str2 = 13;
                    break;
                case "Phantom6":
                    str2 = i9;
                    str2 = 14;
                    break;
                case "pacificrim":
                    str2 = i9;
                    str2 = 15;
                    break;
                case "vernee_M5":
                    str2 = i9;
                    str2 = 16;
                    break;
                case "panell_dl":
                    str2 = i9;
                    str2 = 17;
                    break;
                case "panell_ds":
                    str2 = i9;
                    str2 = 18;
                    break;
                case "panell_dt":
                    str2 = i9;
                    str2 = 19;
                    break;
                case "GiONEE_GBL7319":
                    str2 = i9;
                    str2 = 20;
                    break;
                case "BRAVIA_ATV2":
                    str2 = i9;
                    str2 = 21;
                    break;
                case "iris60":
                    str2 = i9;
                    str2 = 22;
                    break;
                case "Slate_Pro":
                    str2 = i9;
                    str2 = 23;
                    break;
                case "namath":
                    str2 = i9;
                    str2 = 24;
                    break;
                case "A10-70F":
                    str2 = i9;
                    str2 = 25;
                    break;
                case "A10-70L":
                    str2 = i9;
                    str2 = i15;
                    break;
                case "s905x018":
                    str2 = i9;
                    str2 = i14;
                    break;
                case "ELUGA_Ray_X":
                    str2 = i9;
                    str2 = i8;
                    break;
                case "tcl_eu":
                    str2 = i9;
                    str2 = 29;
                    break;
                case "nicklaus_f":
                    str2 = i9;
                    str2 = 30;
                    break;
                case "A7000-a":
                    str2 = i9;
                    str2 = 31;
                    break;
                case "SVP-DTV15":
                    str2 = i9;
                    str2 = 32;
                    break;
                case "watson":
                    str2 = i9;
                    str2 = 33;
                    break;
                case "whyred":
                    str2 = i9;
                    str2 = 34;
                    break;
                case "OnePlus5T":
                    str2 = i9;
                    str2 = 35;
                    break;
                case "GiONEE_CBL7513":
                    str2 = i9;
                    str2 = 36;
                    break;
                case "GIONEE_GBL7360":
                    str2 = i9;
                    str2 = 37;
                    break;
                case "Pixi4-7_3G":
                    str2 = i9;
                    str2 = 38;
                    break;
                case "taido_row":
                    str2 = i9;
                    str2 = 39;
                    break;
                case "BLACK-1X":
                    str2 = i9;
                    str2 = 40;
                    break;
                case "Z12_PRO":
                    str2 = i9;
                    str2 = 41;
                    break;
                case "ELUGA_A3_Pro":
                    str2 = i9;
                    str2 = 42;
                    break;
                case "woods_fn":
                    str2 = i9;
                    str2 = 43;
                    break;
                case "C1":
                    str2 = i9;
                    str2 = 44;
                    break;
                case "Q5":
                    str2 = i9;
                    str2 = 45;
                    break;
                case "V1":
                    str2 = i9;
                    str2 = 46;
                    break;
                case "V5":
                    str2 = i9;
                    str2 = 47;
                    break;
                case "b5":
                    str2 = i9;
                    str2 = 48;
                    break;
                case "mh":
                    str2 = i9;
                    str2 = 49;
                    break;
                case "JGZ":
                    str2 = i9;
                    str2 = 50;
                    break;
                case "M04":
                    str2 = i9;
                    str2 = 51;
                    break;
                case "M5c":
                    str2 = i9;
                    str2 = 52;
                    break;
                case "MX6":
                    str2 = i9;
                    str2 = 53;
                    break;
                case "P85":
                    str2 = i9;
                    str2 = 54;
                    break;
                case "PLE":
                    str2 = i9;
                    str2 = 55;
                    break;
                case "QX1":
                    str2 = i9;
                    str2 = 56;
                    break;
                case "Z80":
                    str2 = i9;
                    str2 = 57;
                    break;
                case "cv1":
                    str2 = i9;
                    str2 = 58;
                    break;
                case "cv3":
                    str2 = i9;
                    str2 = 59;
                    break;
                case "deb":
                    str2 = i9;
                    str2 = 60;
                    break;
                case "flo":
                    str2 = i9;
                    str2 = 61;
                    break;
                case "1601":
                    str2 = i9;
                    str2 = 62;
                    break;
                case "1713":
                    str2 = i9;
                    str2 = 63;
                    break;
                case "1714":
                    str2 = i9;
                    str2 = 64;
                    break;
                case "F01H":
                    str2 = i9;
                    str2 = 65;
                    break;
                case "F01J":
                    str2 = i9;
                    str2 = 66;
                    break;
                case "F02H":
                    str2 = i9;
                    str2 = 67;
                    break;
                case "F03H":
                    str2 = i9;
                    str2 = 68;
                    break;
                case "F04H":
                    str2 = i9;
                    str2 = 69;
                    break;
                case "F04J":
                    str2 = i9;
                    str2 = 70;
                    break;
                case "P681":
                    str2 = i9;
                    str2 = 71;
                    break;
                case "Q350":
                    str2 = i9;
                    str2 = 72;
                    break;
                case "Q427":
                    str2 = i9;
                    str2 = 73;
                    break;
                case "XE2X":
                    str2 = i9;
                    str2 = 74;
                    break;
                case "fugu":
                    str2 = i9;
                    str2 = 75;
                    break;
                case "kate":
                    str2 = i9;
                    str2 = 76;
                    break;
                case "mido":
                    str2 = i9;
                    str2 = 77;
                    break;
                case "p212":
                    str2 = i9;
                    str2 = 78;
                    break;
                case "MEIZU_M5":
                    str2 = i9;
                    str2 = 79;
                    break;
                case "601LV":
                    str2 = i9;
                    str2 = 80;
                    break;
                case "602LV":
                    str2 = i9;
                    str2 = 81;
                    break;
                case "Aura_Note_2":
                    str2 = i9;
                    str2 = 82;
                    break;
                case "A1601":
                    str2 = i9;
                    str2 = 83;
                    break;
                case "E5643":
                    str2 = i9;
                    str2 = 84;
                    break;
                case "F3111":
                    str2 = i9;
                    str2 = 85;
                    break;
                case "F3113":
                    str2 = i9;
                    str2 = 86;
                    break;
                case "F3116":
                    str2 = i9;
                    str2 = 87;
                    break;
                case "F3211":
                    str2 = i9;
                    str2 = 88;
                    break;
                case "F3213":
                    str2 = i9;
                    str2 = 89;
                    break;
                case "F3215":
                    str2 = i9;
                    str2 = 90;
                    break;
                case "F3311":
                    str2 = i9;
                    str2 = 91;
                    break;
                case "PRO7S":
                    str2 = i9;
                    str2 = 92;
                    break;
                case "Q4260":
                    str2 = i9;
                    str2 = 93;
                    break;
                case "Q4310":
                    str2 = i9;
                    str2 = 94;
                    break;
                case "V23GB":
                    str2 = i9;
                    str2 = 95;
                    break;
                case "X3_HK":
                    str2 = i9;
                    str2 = 96;
                    break;
                case "i9031":
                    str2 = i9;
                    str2 = 97;
                    break;
                case "l5460":
                    str2 = i9;
                    str2 = 98;
                    break;
                case "le_x6":
                    str2 = i9;
                    str2 = 99;
                    break;
                case "A2016a40":
                    str2 = i9;
                    str2 = 100;
                    break;
                case "CPY83_I00":
                    str2 = i9;
                    str2 = 101;
                    break;
                case "marino_f":
                    str2 = i9;
                    str2 = 102;
                    break;
                case "griffin":
                    str2 = i9;
                    str2 = 103;
                    break;
                case "A7010a48":
                    str2 = i9;
                    str2 = 104;
                    break;
                case "A7020a48":
                    str2 = i9;
                    str2 = 105;
                    break;
                case "TB3-730F":
                    str2 = i9;
                    str2 = 106;
                    break;
                case "TB3-730X":
                    str2 = i9;
                    str2 = 107;
                    break;
                case "TB3-850F":
                    str2 = i9;
                    str2 = 108;
                    break;
                case "TB3-850M":
                    str2 = i9;
                    str2 = 109;
                    break;
                case "Pixi5-10_4G":
                    str2 = i9;
                    str2 = 110;
                    break;
                case "QM16XE_U":
                    str2 = i9;
                    str2 = 111;
                    break;
                case "GIONEE_WBL5708":
                    str2 = i9;
                    str2 = 112;
                    break;
                case "GIONEE_WBL7365":
                    str2 = i9;
                    str2 = 113;
                    break;
                case "GIONEE_WBL7519":
                    str2 = i9;
                    str2 = 114;
                    break;
                case "manning":
                    str2 = i9;
                    str2 = 115;
                    break;
                case "A7000plus":
                    str2 = i9;
                    str2 = 116;
                    break;
                case "j2xlteins":
                    str2 = i9;
                    str2 = 117;
                    break;
                case "panell_d":
                    str2 = i9;
                    str2 = 118;
                    break;
                case "LS-5017":
                    str2 = i9;
                    str2 = 119;
                    break;
                case "itel_S41":
                    str2 = i9;
                    str2 = 120;
                    break;
                case "hwALE-H":
                    str2 = i9;
                    str2 = 121;
                    break;
                case "EverStar_S":
                    str2 = i9;
                    str2 = 122;
                    break;
                case "htc_e56ml_dtul":
                    str2 = i9;
                    str2 = 123;
                    break;
                case "woods_f":
                    str2 = i9;
                    str2 = 124;
                    break;
                case "CPH1609":
                    str2 = i9;
                    str2 = 125;
                    break;
                case "CPH1715":
                    str2 = i9;
                    str2 = 126;
                    break;
                case "iball8735_9806":
                    str2 = i9;
                    str2 = 127;
                    break;
                case "santoni":
                    str2 = i9;
                    str2 = 128;
                    break;
                case "PB2-670M":
                    str2 = i9;
                    str2 = 129;
                    break;
                case "Infinix-X572":
                    str2 = i9;
                    str2 = 130;
                    break;
                case "BRAVIA_ATV3_4K":
                    str2 = i9;
                    str2 = 131;
                    break;
                case "DM-01K":
                    str2 = i9;
                    str2 = 132;
                    break;
                case "HWBLN-H":
                    str2 = i9;
                    str2 = 133;
                    break;
                case "HWCAM-H":
                    str2 = i9;
                    str2 = 134;
                    break;
                case "ASUS_X00AD_2":
                    str2 = i9;
                    str2 = 135;
                    break;
                case "ELUGA_Note":
                    str2 = i9;
                    str2 = 136;
                    break;
                case "ELUGA_Prim":
                    str2 = i9;
                    str2 = 137;
                    break;
                case "HWVNS-H":
                    str2 = i9;
                    str2 = 138;
                    break;
                case "HWWAS-H":
                    str2 = i9;
                    str2 = 139;
                    break;
                default:
                    str2 = i9;
            }
            if (/* condition */) {
                return i13;
            } else {
                equals3 = p0.d;
                equals3.hashCode();
                switch (equals3) {
                    case "JSN-L21":
                        i2 = i9;
                        i2 = i11;
                        break;
                    case "AFTA":
                        i2 = i9;
                        i2 = i13;
                        break;
                    case "AFTN":
                        i2 = i9;
                        break;
                    default:
                        i2 = i9;
                }
                if (/* condition */) {
                }
            }
        }
        return i11;
    }

    private static int C1(r r, i1 i12) {
        int i;
        String equals;
        int str;
        int i3;
        Object obj10;
        android.util.Pair obj11;
        int i4 = i12.I;
        final int i9 = i12.J;
        final int i10 = -1;
        if (i4 != i10) {
            if (i9 == i10) {
            } else {
                final String str6 = "video/avc";
                final String str7 = "video/hevc";
                final int i14 = 2;
                if ("video/dolby-vision".equals(i12.D)) {
                    obj11 = MediaCodecUtil.l(i12);
                    if (obj11 != null) {
                        obj11 = (Integer)obj11.first.intValue();
                        if (obj11 != 512 && obj11 != 1) {
                            if (obj11 != 1) {
                                equals = obj11 == i14 ? str6 : str7;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
                equals.hashCode();
                final int i15 = 3;
                switch (equals) {
                    case "video/3gpp":
                        i3 = i10;
                        i3 = 0;
                        break;
                    case "video/hevc":
                        i3 = i10;
                        break;
                    case "video/mp4v-es":
                        i3 = i10;
                        i3 = i14;
                        break;
                    case "video/avc":
                        i3 = i10;
                        i3 = i15;
                        break;
                    case "video/x-vnd.on2.vp8":
                        i3 = i10;
                        i3 = str;
                        break;
                    case "video/x-vnd.on2.vp9":
                        i3 = i10;
                        i3 = 5;
                        break;
                    default:
                        i3 = i10;
                }
                switch (i3) {
                    case 0:
                        i4 *= i9;
                        break;
                    case 1:
                        i4 *= i9;
                        return i6 /= i11;
                    case 2:
                        obj11 = p0.d;
                        obj10 = 16;
                        i = obj11 * 16;
                        return i10;
                    default:
                        return i10;
                }
                str = i14;
            }
        }
        return i10;
    }

    private static Point D1(r r, i1 i12) {
        int i9;
        int i8;
        int i10;
        int i;
        int i7;
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        int obj14;
        i9 = i12.J;
        int i11 = i12.I;
        i10 = i9 > i11 ? 1 : i8;
        i = i10 != 0 ? i9 : i11;
        if (i10 != 0) {
            i9 = i11;
        }
        int[] i1 = s.I1;
        while (i8 < i1.length) {
            i4 = i1[i8];
            i3 = (int)i15;
            int i18 = 16;
            i14 *= i18;
            i16 *= i18;
            i8++;
            if (i10 != 0) {
            } else {
            }
            i2 = i4;
            if (i10 != 0) {
            } else {
            }
            i4 = i3;
            i7 = r.b(i2, i4);
            i2 = i3;
        }
        return null;
    }

    private static List<r> F1(s s, i1 i12, boolean z3, boolean z4) {
        int equals;
        List obj3;
        Object obj4;
        String str = i12.D;
        if (str == null) {
            return Collections.emptyList();
        }
        List list2 = MediaCodecUtil.p(s.a(str, z3, z4), i12);
        obj4 = MediaCodecUtil.l(i12);
        if ("video/dolby-vision".equals(str) && obj4 != null) {
            obj4 = MediaCodecUtil.l(i12);
            if (obj4 != null) {
                obj4 = (Integer)obj4.first.intValue();
                if (obj4 != 16) {
                    if (obj4 == 256) {
                        list2.addAll(s.a("video/hevc", z3, z4));
                    } else {
                        if (obj4 == 512) {
                            list2.addAll(s.a("video/avc", z3, z4));
                        }
                    }
                } else {
                }
            }
        }
        return Collections.unmodifiableList(list2);
    }

    protected static int G1(r r, i1 i12) {
        int i;
        int i2;
        int length;
        if (i12.E != -1) {
            i2 = i;
            while (i < i12.F.size()) {
                i2 += length;
                i++;
            }
            return obj3 += i2;
        }
        return s.C1(r, i12);
    }

    private static boolean I1(long l) {
        int obj2;
        obj2 = Long.compare(l, i) < 0 ? 1 : 0;
        return obj2;
    }

    private static boolean J1(long l) {
        int obj2;
        obj2 = Long.compare(l, i) < 0 ? 1 : 0;
        return obj2;
    }

    private void L1() {
        int elapsedRealtime;
        int i2;
        com.google.android.exoplayer2.video.z.a aVar;
        int i;
        if (this.s1 > 0) {
            elapsedRealtime = SystemClock.elapsedRealtime();
            this.b1.d(this.s1, elapsedRealtime - l);
            this.s1 = 0;
            this.r1 = elapsedRealtime;
        }
    }

    private void N1() {
        int i;
        com.google.android.exoplayer2.video.z.a aVar;
        long l;
        i = this.y1;
        if (i != 0) {
            this.b1.B(this.x1, obj3);
            this.x1 = 0;
            this.y1 = 0;
        }
    }

    private void O1() {
        int a0Var;
        com.google.android.exoplayer2.video.a0 i3;
        int i2;
        int i;
        float f;
        a0Var = this.z1;
        i3 = -1;
        if (a0Var == i3) {
            if (this.A1 != i3) {
                i3 = this.D1;
                if (i3 != null && i3.a == a0Var && i3.b == this.A1 && i3.c == this.B1) {
                    if (i3.a == a0Var) {
                        if (i3.b == this.A1) {
                            if (i3.c == this.B1) {
                                if (Float.compare(f2, i3) != 0) {
                                    a0Var = new a0(this.z1, this.A1, this.B1, this.C1);
                                    this.D1 = a0Var;
                                    this.b1.D(a0Var);
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
    }

    private void P1() {
        boolean z;
        Surface surface;
        if (this.k1) {
            this.b1.A(this.i1);
        }
    }

    private void Q1() {
        com.google.android.exoplayer2.video.z.a aVar;
        final com.google.android.exoplayer2.video.a0 d1 = this.D1;
        if (d1 != null) {
            this.b1.D(d1);
        }
    }

    private void R1(long l, long l2, i1 i13) {
        long l3;
        i1 i1Var;
        Object obj;
        MediaFormat mediaFormat;
        final com.google.android.exoplayer2.video.w h1 = this.H1;
        if (h1 != null) {
            h1.e(l, obj2, i13, obj4);
        }
    }

    private void T1() {
        i1();
    }

    private static void W1(q q, byte[] b2Arr2) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", b2Arr2);
        q.e(bundle);
    }

    private void X1() {
        int i2;
        long i;
        if (Long.compare(l, i) > 0) {
            elapsedRealtime += i;
        } else {
            i2 = -9223372036854775807L;
        }
        this.q1 = i2;
    }

    private void Y1(Object object) {
        boolean z;
        Surface state;
        boolean z2;
        int i2;
        int i;
        Object obj5;
        if (object instanceof Surface) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
            z = this.j1;
            if (z != null) {
                obj5 = z;
            } else {
                z = u0();
                if (z != null && d2(z)) {
                    if (d2(z)) {
                        this.j1 = p.c(this.Z0, z.f);
                    }
                }
            }
        }
        if (this.i1 != obj5) {
            this.i1 = obj5;
            this.a1.o(obj5);
            this.k1 = false;
            z2 = t0();
            if (z2 != null) {
                if (p0.a >= 23 && obj5 != null && !this.g1) {
                    if (obj5 != null) {
                        if (!this.g1) {
                            Z1(z2, obj5);
                        } else {
                            b1();
                            L0();
                        }
                    } else {
                    }
                } else {
                }
            }
            if (obj5 != null && obj5 != this.j1) {
                if (obj5 != this.j1) {
                    Q1();
                    v1();
                    if (getState() == 2) {
                        X1();
                    }
                } else {
                    w1();
                    v1();
                }
            } else {
            }
        } else {
            if (obj5 != null && obj5 != this.j1) {
                if (obj5 != this.j1) {
                    Q1();
                    P1();
                }
            }
        }
    }

    private boolean d2(r r) {
        int i;
        int obj3;
        if (p0.a >= 23 && !this.E1 && !x1(r.a)) {
            if (!this.E1) {
                if (!x1(r.a)) {
                    if (r.f) {
                        obj3 = p.b(this.Z0) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    static void t1(com.google.android.exoplayer2.video.s s) {
        s.T1();
    }

    static void u1(com.google.android.exoplayer2.video.s s, ExoPlaybackException exoPlaybackException2) {
        s.j1(exoPlaybackException2);
    }

    private void v1() {
        int i;
        int bVar;
        this.m1 = false;
        i = t0();
        if (p0.a >= 23 && this.E1 && i != null) {
            if (this.E1) {
                i = t0();
                if (i != null) {
                    bVar = new s.b(this, i);
                    this.G1 = bVar;
                }
            }
        }
    }

    private void w1() {
        this.D1 = 0;
    }

    private static void y1(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    private static boolean z1() {
        return "NVIDIA".equals(p0.c);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected q.a A0(r r, i1 i12, MediaCrypto mediaCrypto3, float f4) {
        com.google.android.exoplayer2.video.p pVar2;
        int i;
        com.google.android.exoplayer2.video.p pVar;
        Surface surface;
        boolean z2;
        i1 i1Var;
        boolean z;
        pVar2 = this.j1;
        if (pVar2 != null && pVar2.a != r.f) {
            if (pVar2.a != r.f) {
                pVar2.release();
                this.j1 = 0;
            }
        }
        com.google.android.exoplayer2.video.s.a aVar2 = E1(r, i12, H());
        this.f1 = aVar2;
        i = this.E1 ? this.F1 : 0;
        if (this.i1 == null) {
            if (!d2(r)) {
            } else {
                if (this.j1 == null) {
                    this.j1 = p.c(this.Z0, r.f);
                }
                this.i1 = this.j1;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        super(r, this.H1(i12, r.c, aVar2, f4, this.e1, i), i12, this.i1, mediaCrypto3, 0);
        return aVar3;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void A1(q q, int i2, long l3) {
        n0.a("dropVideoBuffer");
        q.j(i2, false);
        n0.c();
        f2(1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void D0(DecoderInputBuffer decoderInputBuffer) {
        int remaining;
        int short2;
        short short;
        byte b;
        byte b2;
        int i;
        int i2;
        Object obj8;
        if (!this.h1) {
        }
        obj8 = decoderInputBuffer.x;
        g.e(obj8);
        i = 0;
        obj8.position(i);
        if ((ByteBuffer)obj8.remaining() >= 7 && obj8.get() == -75 && obj8.getShort() == 60 && obj8.getShort() == 1 && obj8.get() == 4 && obj8.get() == 0) {
            i = 0;
            obj8.position(i);
            if (obj8.get() == -75) {
                if (obj8.getShort() == 60) {
                    if (obj8.getShort() == 1) {
                        if (obj8.get() == 4) {
                            if (obj8.get() == 0) {
                                remaining = new byte[obj8.remaining()];
                                obj8.get(remaining);
                                obj8.position(i);
                                s.W1(t0(), remaining);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected com.google.android.exoplayer2.video.s.a E1(r r, i1 i12, i1[] i13Arr3) {
        int i5;
        int i3;
        int i8;
        int length;
        int str;
        int i4;
        int i6;
        int i2;
        Object obj;
        int i7;
        com.google.android.exoplayer2.video.n nVar;
        int i;
        r obj13;
        Object obj14;
        int obj15;
        i8 = s.G1(r, i12);
        str = 1;
        i4 = -1;
        obj13 = s.C1(r, i12);
        if (i13Arr3.length == str && i8 != i4 && obj13 != i4) {
            if (i8 != i4) {
                obj13 = s.C1(r, i12);
                if (obj13 != i4) {
                    i8 = Math.min((int)obj14, obj13);
                }
            }
            obj13 = new s.a(i12.I, i12.J, i8);
            return obj13;
        }
        final int i9 = 0;
        i2 = i6;
        while (i6 < i13Arr3.length) {
            obj = i13Arr3[i6];
            if (i12.P != null && obj.P == null) {
            }
            if (eVar.d != 0) {
            }
            i6++;
            int i10 = obj.I;
            if (i10 != i4) {
            } else {
            }
            i = str;
            i2 |= i;
            i5 = Math.max(i5, i10);
            i3 = Math.max(i3, obj.J);
            i8 = Math.max(i8, s.G1(r, obj));
            if (obj.J == i4) {
            } else {
            }
            i = i9;
            if (obj.P == null) {
            }
            i1.b bVar = obj.a();
            bVar.J(i12.P);
            obj = bVar.E();
        }
        StringBuilder stringBuilder = new StringBuilder(66);
        stringBuilder.append("Resolutions unknown. Codec max resolution: ");
        stringBuilder.append(i5);
        obj15 = "x";
        stringBuilder.append(obj15);
        stringBuilder.append(i3);
        str = "MediaCodecVideoRenderer";
        v.h(str, stringBuilder.toString());
        length = s.D1(r, i12);
        if (i2 != 0 && length != null) {
            stringBuilder = new StringBuilder(66);
            stringBuilder.append("Resolutions unknown. Codec max resolution: ");
            stringBuilder.append(i5);
            obj15 = "x";
            stringBuilder.append(obj15);
            stringBuilder.append(i3);
            str = "MediaCodecVideoRenderer";
            v.h(str, stringBuilder.toString());
            length = s.D1(r, i12);
            if (length != null) {
                i5 = Math.max(i5, length.x);
                i3 = Math.max(i3, length.y);
                obj14 = i12.a();
                obj14.j0(i5);
                obj14.Q(i3);
                i8 = Math.max(i8, s.C1(r, obj14.E()));
                obj14 = new StringBuilder(57);
                obj14.append("Codec max resolution adjusted to: ");
                obj14.append(i5);
                obj14.append(obj15);
                obj14.append(i3);
                v.h(str, obj14.toString());
            }
        }
        obj13 = new s.a(i5, i3, i8);
        return obj13;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaFormat H1(i1 i1, String string2, com.google.android.exoplayer2.video.s.a s$a3, float f4, boolean z5, int i6) {
        Object obj3;
        boolean obj4;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", string2);
        mediaFormat.setInteger("width", i1.I);
        mediaFormat.setInteger("height", i1.J);
        y.e(mediaFormat, i1.F);
        y.c(mediaFormat, "frame-rate", i1.K);
        y.d(mediaFormat, "rotation-degrees", i1.L);
        y.b(mediaFormat, i1.P);
        obj3 = MediaCodecUtil.l(i1);
        if ("video/dolby-vision".equals(i1.D) && obj3 != null) {
            obj3 = MediaCodecUtil.l(i1);
            if (obj3 != null) {
                y.d(mediaFormat, "profile", (Integer)obj3.first.intValue());
            }
        }
        mediaFormat.setInteger("max-width", a3.a);
        mediaFormat.setInteger("max-height", a3.b);
        y.d(mediaFormat, "max-input-size", a3.c);
        final int obj5 = 0;
        mediaFormat.setInteger("priority", obj5);
        if (p0.a >= 23 && Float.compare(f4, obj3) != 0) {
            mediaFormat.setInteger("priority", obj5);
            if (Float.compare(f4, obj3) != 0) {
                mediaFormat.setFloat("operating-rate", f4);
            }
        }
        if (z5) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", obj5);
        }
        if (i6 != 0) {
            s.y1(mediaFormat, i6);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void J() {
        w1();
        v1();
        this.k1 = false;
        this.a1.g();
        this.G1 = 0;
        super.J();
        this.b1.c(this.U0);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void K(boolean z, boolean z2) {
        int i;
        int i2;
        super.K(z, z2);
        boolean obj3 = obj3.a;
        final int i3 = 0;
        if (obj3 != null) {
            if (this.F1 != 0) {
                i = 1;
            } else {
                i = i3;
            }
        } else {
        }
        g.f(i);
        if (this.E1 != obj3) {
            this.E1 = obj3;
            b1();
        }
        this.b1.e(this.U0);
        this.a1.h();
        this.n1 = z2;
        this.o1 = i3;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean K1(long l, boolean z2) {
        int obj3;
        obj3 = R(l);
        if (obj3 == null) {
            return 0;
        }
        final d obj4 = this.U0;
        final int i5 = 1;
        obj4.i = i += i5;
        i3 += obj3;
        if (obj5 != null) {
            obj4.f = obj3 += i4;
        } else {
            f2(i4);
        }
        q0();
        return i5;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void L(long l, boolean z2) {
        super.L(l, z2);
        v1();
        this.a1.l();
        long obj2 = -9223372036854775807L;
        this.v1 = obj2;
        this.p1 = obj2;
        this.t1 = 0;
        if (obj4 != null) {
            X1();
        } else {
            this.q1 = obj2;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void M() {
        Throwable th;
        com.google.android.exoplayer2.video.p pVar2;
        com.google.android.exoplayer2.video.p pVar;
        final int i = 0;
        super.M();
        final com.google.android.exoplayer2.video.p pVar3 = this.j1;
        if (pVar3 != null && this.i1 == pVar3) {
            try {
                if (this.i1 == pVar3) {
                }
                this.i1 = i;
                pVar3.release();
                this.j1 = i;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    void M1() {
        boolean z;
        Surface surface;
        final int i = 1;
        this.o1 = i;
        if (!this.m1) {
            this.m1 = i;
            this.b1.A(this.i1);
            this.k1 = i;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void N() {
        super.N();
        int i = 0;
        this.s1 = i;
        this.r1 = SystemClock.elapsedRealtime();
        this.w1 = elapsedRealtime2 *= i4;
        this.x1 = 0;
        this.y1 = i;
        this.a1.m();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void O() {
        this.q1 = -9223372036854775807L;
        L1();
        N1();
        this.a1.n();
        super.O();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void O0(Exception exception) {
        v.d("MediaCodecVideoRenderer", "Video codec error", exception);
        this.b1.C(exception);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void P0(String string, long l2, long l3) {
        int obj7;
        int obj8;
        this.b1.a(string, l2, obj3);
        this.g1 = x1(string);
        obj7 = u0();
        g.e(obj7);
        this.h1 = (r)obj7.n();
        if (p0.a >= 23 && this.E1) {
            if (this.E1) {
                obj8 = t0();
                g.e(obj8);
                obj7 = new s.b(this, (q)obj8);
                this.G1 = obj7;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Q0(String string) {
        this.b1.b(string);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected e R0(j1 j1) {
        final e eVar = super.R0(j1);
        this.b1.f(j1.b, eVar);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void S0(i1 i1, MediaFormat mediaFormat2) {
        boolean integer;
        int i2;
        int integer2;
        int i3;
        int i4;
        boolean key;
        String str;
        String str2;
        int integer3;
        int i;
        int obj8;
        q qVar = t0();
        if (qVar != null) {
            qVar.k(this.l1);
        }
        if (this.E1) {
            this.z1 = i1.I;
            this.A1 = i1.J;
        } else {
            g.e(mediaFormat2);
            String str3 = "crop-right";
            str = "crop-top";
            str2 = "crop-bottom";
            integer3 = "crop-left";
            i = 1;
            if (mediaFormat2.containsKey(str3) && mediaFormat2.containsKey(integer3) && mediaFormat2.containsKey(str2) && mediaFormat2.containsKey(str)) {
                if (mediaFormat2.containsKey(integer3)) {
                    if (mediaFormat2.containsKey(str2)) {
                        i3 = mediaFormat2.containsKey(str) ? i : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i3 != 0) {
                i7 += i;
            } else {
                integer2 = mediaFormat2.getInteger("width");
            }
            this.z1 = integer2;
            if (i3 != 0) {
                i8 += i;
            } else {
                integer = mediaFormat2.getInteger("height");
            }
            this.A1 = integer;
        }
        obj8 = i1.M;
        this.C1 = obj8;
        if (p0.a >= 21) {
            i2 = i1.L;
            if (i2 != 90) {
                if (i2 == 270) {
                    this.z1 = this.A1;
                    this.A1 = this.z1;
                    this.C1 = i6 /= obj8;
                }
            } else {
            }
        } else {
            this.B1 = i1.L;
        }
        this.a1.i(i1.K);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void S1(long l) {
        s1(l);
        O1();
        final d u0 = this.U0;
        u0.e = i++;
        M1();
        T0(l);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void T0(long l) {
        boolean obj1;
        super.T0(l);
        if (!this.E1) {
            this.u1 = obj1--;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected e U(r r, i1 i12, i1 i13) {
        int i2;
        int i;
        com.google.android.exoplayer2.video.s.a aVar;
        int obj9;
        final e eVar = r.e(i12, i13);
        aVar = this.f1;
        if (i13.I <= aVar.a) {
            if (i13.J > aVar.b) {
                i2 |= 256;
            }
        } else {
        }
        if (s.G1(r, i13) > aVar2.c) {
            i2 |= 64;
        }
        final int i7 = i2;
        obj9 = i7 != 0 ? 0 : eVar.d;
        super(r.a, i12, i13, obj9, i7);
        return eVar2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void U0() {
        super.U0();
        v1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void U1(q q, int i2, long l3) {
        O1();
        n0.a("releaseOutputBuffer");
        int obj5 = 1;
        q.j(i2, obj5);
        n0.c();
        this.w1 = obj3 *= i;
        d obj3 = this.U0;
        obj3.e = obj4 += obj5;
        this.t1 = 0;
        M1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void V0(DecoderInputBuffer decoderInputBuffer) {
        boolean l;
        int i;
        l = this.E1;
        if (!l) {
            this.u1 = i2++;
        }
        int i3 = p0.a;
        if (i3 < 23 && l) {
            if (l) {
                S1(decoderInputBuffer.w);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void V1(q q, int i2, long l3, long l4) {
        O1();
        n0.a("releaseOutputBuffer");
        q.f(i2, obj5);
        n0.c();
        this.w1 = obj1 *= obj3;
        d obj1 = this.U0;
        obj1.e = obj2++;
        this.t1 = 0;
        M1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean X0(long l, long l2, q q3, ByteBuffer byteBuffer4, int i5, int i6, int i7, long l8, boolean z9, boolean z10, i1 i111) {
        long l3;
        boolean z;
        long l4;
        int cmp2;
        int cmp;
        int nanoTime;
        int i3;
        int i;
        int i4;
        int i8;
        boolean z2;
        int i9;
        double d;
        int i2;
        long l5;
        Object obj29;
        int obj30;
        int obj31;
        long obj32;
        long obj34;
        final Object obj3 = this;
        final long l14 = l;
        final q qVar = i5;
        final int i26 = i7;
        long l6 = z10;
        g.e(i5);
        if (Long.compare(l9, l12) == 0) {
            obj3.p1 = l14;
        }
        if (Long.compare(l6, l10) != 0) {
            obj3.a1.j(l6);
            obj3.v1 = l6;
        }
        cmp = B0();
        final int i27 = l6 - cmp;
        int i28 = 1;
        if (obj33 != 0 && obj34 == 0) {
            if (obj34 == 0) {
                obj3.e2(qVar, i26, i27);
                return i28;
            }
        }
        final int i29 = 0;
        i = getState() == 2 ? i28 : i29;
        final int i31 = 1000;
        elapsedRealtime *= i31;
        if (i != 0) {
            l3 -= d;
        }
        if (obj3.i1 == obj3.j1 && s.I1(l3)) {
            if (s.I1(l3)) {
                obj3.e2(qVar, i26, i27);
                obj3.g2(l3);
                return i28;
            }
            return i29;
        }
        i2 = i30 - l16;
        if (!obj3.o1) {
            if (i == 0) {
                if (obj3.n1) {
                    i4 = i28;
                    obj31 = i2;
                } else {
                    obj31 = i2;
                    i4 = i29;
                }
            } else {
            }
        } else {
            if (!obj3.m1) {
            } else {
            }
        }
        if (Long.compare(l15, l5) == 0 && Long.compare(l14, cmp) >= 0) {
            if (Long.compare(l14, cmp) >= 0) {
                if (i4 == 0) {
                    if (i != 0 && obj3.c2(l3, obj1)) {
                        nanoTime = obj3.c2(l3, obj1) ? 1 : i29;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (nanoTime != 0) {
            nanoTime = System.nanoTime();
            this.R1(i27, obj31, nanoTime);
            if (p0.a >= 21) {
                this.V1(i5, i7, i27, obj33);
            } else {
                obj3.U1(qVar, i26, i27);
            }
            obj3.g2(l3);
            return 1;
        } else {
        }
        return i29;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void Z1(q q, Surface surface2) {
        q.m(surface2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean a() {
        boolean z;
        Surface surface;
        final int i = 1;
        final long l = -9223372036854775807L;
        if (super.a() && !this.m1) {
            if (!this.m1) {
                z = this.j1;
                if (z != null) {
                    if (this.i1 != z && t0() != null && this.E1) {
                        if (t0() != null) {
                            if (this.E1) {
                            }
                        }
                    }
                } else {
                }
            }
            this.q1 = l;
            return i;
        }
        int i2 = 0;
        if (Long.compare(l2, l) == 0) {
            return i2;
        }
        if (Long.compare(elapsedRealtime, l3) < 0) {
            return i;
        }
        this.q1 = l;
        return i2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean a2(long l, long l2, boolean z3) {
        int obj1;
        if (s.J1(l) && obj5 == null) {
            obj1 = obj5 == null ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean b2(long l, long l2, boolean z3) {
        int obj1;
        if (s.I1(l) && obj5 == null) {
            obj1 = obj5 == null ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean c2(long l, long l2) {
        boolean obj1;
        if (s.I1(l) && Long.compare(obj3, obj1) > 0) {
            obj1 = Long.compare(obj3, obj1) > 0 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void d1() {
        super.d1();
        this.u1 = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException e0(Throwable throwable, r r2) {
        MediaCodecVideoDecoderException mediaCodecVideoDecoderException = new MediaCodecVideoDecoderException(throwable, r2, this.i1);
        return mediaCodecVideoDecoderException;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void e2(q q, int i2, long l3) {
        n0.a("skipVideoBuffer");
        q.j(i2, false);
        n0.c();
        final d obj1 = this.U0;
        obj1.f = obj2++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void f2(int i) {
        d dVar;
        dVar = this.U0;
        dVar.g = i2 += i;
        this.s1 = i4 += i;
        i6 += i;
        this.t1 = i7;
        dVar.h = Math.max(i7, dVar.h);
        int obj3 = this.d1;
        if (obj3 > 0 && this.s1 >= obj3) {
            if (this.s1 >= obj3) {
                L1();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void g2(long l) {
        this.U0.a(l);
        this.x1 = l2 += l;
        this.y1 = obj3++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean m1(r r) {
        int obj2;
        if (this.i1 == null) {
            if (d2(r)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int o1(s s, i1 i12) {
        int empty2;
        int i;
        List list;
        int i2;
        boolean empty;
        s obj6;
        i = 0;
        if (!z.q(i12.D)) {
            return a2.r(i);
        }
        final int i3 = 1;
        empty2 = i12.G != null ? i3 : i;
        if (empty2 != 0 && s.F1(s, i12, empty2, i).isEmpty()) {
            if (list.isEmpty()) {
                list = s.F1(s, i12, i, i);
            }
        }
        if (list.isEmpty()) {
            return a2.r(i3);
        }
        if (!MediaCodecRenderer.p1(i12)) {
            return a2.r(2);
        }
        Object obj = list.get(i);
        boolean z4 = (r)obj.m(i12);
        i2 = obj.o(i12) ? 16 : 8;
        obj6 = s.F1(s, i12, empty2, i3);
        obj6 = obj6.get(i);
        if (z4 && !obj6.isEmpty() && (r)obj6.m(i12) && obj6.o(i12)) {
            obj6 = s.F1(s, i12, empty2, i3);
            if (!obj6.isEmpty()) {
                obj6 = obj6.get(i);
                if ((r)obj6.m(i12)) {
                    if (obj6.o(i12)) {
                        i = 32;
                    }
                }
            }
        }
        obj6 = z4 ? 4 : 3;
        return a2.n(obj6, i2, i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void p(float f, float f2) {
        super.p(f, f2);
        this.a1.k(f);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void v(int i, Object object2) {
        int i2;
        int obj2;
        Object obj3;
        if (i != 1) {
            if (i != 4) {
                if (i != 6) {
                    if (i != 102) {
                        super.v(i, object2);
                    } else {
                        obj2 = (Integer)object2.intValue();
                        this.F1 = obj2;
                        if (this.F1 != obj2 && this.E1) {
                            this.F1 = obj2;
                            if (this.E1) {
                                b1();
                            }
                        }
                    }
                } else {
                    this.H1 = (w)object2;
                }
            } else {
                this.l1 = (Integer)object2.intValue();
                obj2 = t0();
                if (obj2 != null) {
                    obj2.k(this.l1);
                }
            }
        } else {
            Y1(object2);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean v0() {
        boolean z;
        int i2;
        int i;
        if (this.E1 && p0.a < 23) {
            i2 = p0.a < 23 ? 1 : 0;
        } else {
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float w0(float f, i1 i12, i1[] i13Arr3) {
        int i;
        int i2;
        int i3;
        float f2;
        int cmp;
        i = -1082130432;
        i2 = 0;
        i3 = i;
        while (i2 < i13Arr3.length) {
            f2 = obj.K;
            if (Float.compare(f2, i) != 0) {
            }
            i2++;
            i3 = Math.max(i3, f2);
        }
        if (Float.compare(i3, i) == 0) {
        } else {
            i = i3 * f;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean x1(String string) {
        boolean i;
        if (string.startsWith("OMX.google")) {
            return 0;
        }
        Class<com.google.android.exoplayer2.video.s> obj2 = s.class;
        synchronized (obj2) {
            s.K1 = s.B1();
            s.J1 = true;
            return s.K1;
        }
    }

    protected List<r> y0(s s, i1 i12, boolean z3) {
        return s.F1(s, i12, z3, this.E1);
    }
}
