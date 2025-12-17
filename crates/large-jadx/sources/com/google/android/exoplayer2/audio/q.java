package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.provider.Settings.Global;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.v;
import com.google.common.collect.v.a;
import f.c.c.b.b;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class q {

    public static final com.google.android.exoplayer2.audio.q c;
    private static final com.google.android.exoplayer2.audio.q d;
    private static final int[] e;
    private final int[] a;
    private final int b;

    private static final class a {
        public static int[] a() {
            int i2;
            int valueOf;
            boolean directPlaybackSupported;
            android.media.AudioAttributes build;
            int i;
            v.a aVar = v.s();
            int[] iArr2 = q.a();
            final int i4 = 0;
            i2 = i4;
            while (i2 < iArr2.length) {
                valueOf = iArr2[i2];
                AudioFormat.Builder builder = new AudioFormat.Builder();
                AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                if (AudioTrack.isDirectPlaybackSupported(builder.setChannelMask(12).setEncoding(valueOf).setSampleRate(48000).build(), builder2.setUsage(1).setContentType(3).setFlags(i4).build())) {
                }
                i2++;
                aVar.d(Integer.valueOf(valueOf));
            }
            aVar.d(2);
            return b.k(aVar.e());
        }
    }
    static {
        int[] iArr2 = new int[1];
        int i5 = 8;
        q qVar = new q(iArr2, i5);
        q.c = qVar;
        int[] iArr3 = new int[3];
        iArr3 = new int[]{2, 5, 6};
        q qVar2 = new q(iArr3, i5);
        q.d = qVar2;
        int[] iArr = new int[7];
        iArr = new int[]{5, 6, 18, 17, 14, 7, 8};
        q.e = iArr;
    }

    public q(int[] iArr, int i2) {
        int length;
        int[] obj2;
        super();
        if (iArr != null) {
            obj2 = Arrays.copyOf(iArr, iArr.length);
            this.a = obj2;
            Arrays.sort(obj2);
        } else {
            this.a = new int[0];
        }
        this.b = i2;
    }

    static int[] a() {
        return q.e;
    }

    private static boolean b() {
        String equals;
        int i;
        boolean equals2;
        if (p0.a >= 17) {
            equals = p0.c;
            if (!"Amazon".equals(equals)) {
                i = "Xiaomi".equals(equals) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static com.google.android.exoplayer2.audio.q c(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
        return q.d(context, context.registerReceiver(0, intentFilter));
    }

    static com.google.android.exoplayer2.audio.q d(Context context, Intent intent2) {
        boolean int;
        int i;
        Context obj4;
        int i3 = 0;
        if (q.b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", i3) == 1) {
            if (Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", i3) == 1) {
                return q.d;
            }
        }
        final int i5 = 8;
        if (p0.a >= 29 && p0.j0(context)) {
            if (p0.j0(context)) {
                obj4 = new q(q.a.a(), i5);
                return obj4;
            }
        }
        if (intent2 != null && intent2.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", i3) == 0) {
            if (intent2.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", i3) == 0) {
            }
            obj4 = new q(intent2.getIntArrayExtra("android.media.extra.ENCODINGS"), intent2.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", i5));
            return obj4;
        }
        return q.c;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof q) {
            return i2;
        }
        if (Arrays.equals(this.a, object.a) && this.b == object.b) {
            if (this.b == object.b) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public boolean f(int i) {
        int obj2;
        obj2 = Arrays.binarySearch(this.a, i) >= 0 ? 1 : 0;
        return obj2;
    }

    public int hashCode() {
        return i += i4;
    }

    public String toString() {
        String string2 = Arrays.toString(this.a);
        StringBuilder stringBuilder = new StringBuilder(length += 67);
        stringBuilder.append("AudioCapabilities[maxChannelCount=");
        stringBuilder.append(this.b);
        stringBuilder.append(", supportedEncodings=");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
