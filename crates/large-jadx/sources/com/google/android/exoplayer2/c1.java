package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink.d;
import com.google.android.exoplayer2.audio.a0;
import com.google.android.exoplayer2.audio.q;
import com.google.android.exoplayer2.audio.s;
import com.google.android.exoplayer2.m2.e;
import com.google.android.exoplayer2.m2.f;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.s;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.text.l;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.video.b0.e;
import com.google.android.exoplayer2.video.s;
import com.google.android.exoplayer2.video.z;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c1 implements com.google.android.exoplayer2.c2 {

    private final Context a;
    private int b = 0;
    private long c = 5000;
    private boolean d;
    private s e = null;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    public c1(Context context) {
        super();
        this.a = context;
        int obj3 = 0;
        final int i = 5000;
        obj3 = s.a;
    }

    @Override // com.google.android.exoplayer2.c2
    public com.google.android.exoplayer2.z1[] a(Handler handler, z z2, s s3, k k4, e e5) {
        Context context;
        boolean z;
        boolean z4;
        boolean z3;
        boolean z5;
        Object zVar;
        long l;
        ArrayList list;
        final Object obj3 = this;
        ArrayList arrayList = new ArrayList();
        this.h(obj3.a, obj3.b, obj3.e, obj3.d, handler, z2, obj3.c, obj8);
        AudioSink audioSink = c(obj3.a, obj3.i, obj3.j, obj3.k);
        if (audioSink != null) {
            this.b(obj3.a, obj3.b, obj3.e, obj3.d, audioSink, handler, s3, arrayList);
        }
        Object obj2 = this;
        ArrayList list2 = arrayList;
        obj2.g(obj3.a, k4, handler.getLooper(), obj3.b, list2);
        obj2.e(obj3.a, e5, handler.getLooper(), obj3.b, list2);
        d(obj3.a, obj3.b, arrayList);
        Handler handler2 = handler;
        f(obj3.a, handler, obj3.b, arrayList);
        return (z1[])arrayList.toArray(new z1[0]);
    }

    protected void b(Context context, int i2, s s3, boolean z4, AudioSink audioSink5, Handler handler6, s s7, ArrayList<com.google.android.exoplayer2.z1> arrayList8) {
        int size;
        int i3;
        int i;
        final Object obj = this;
        int i4 = i2;
        final Object obj5 = arrayList8;
        final String str8 = "DefaultRenderersFactory";
        final Class<AudioSink> obj6 = AudioSink.class;
        final Class<s> obj7 = s.class;
        super(context, s3, z4, handler6, s7, audioSink5);
        a0Var2.l0(obj.f);
        a0Var2.m0(obj.g);
        a0Var2.n0(obj.h);
        obj5.add(a0Var2);
        if (i4 == 0) {
        }
        int i6 = 2;
        if (i4 == i6) {
            size--;
        }
        int i5 = 0;
        int i7 = 3;
        int i8 = 1;
        Class[] arr4 = new Class[i7];
        arr4[i5] = Handler.class;
        arr4[i8] = obj7;
        arr4[i6] = obj6;
        Object[] arr5 = new Object[i7];
        arr5[i5] = handler6;
        arr5[i8] = s7;
        arr5[i6] = audioSink5;
        i = size + 1;
        obj5.add(size, (z1)Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(arr4).newInstance(arr5));
        v.f(str8, "Loaded LibopusAudioRenderer.");
        Class[] arr2 = new Class[i7];
        arr2[i5] = Handler.class;
        arr2[i8] = obj7;
        arr2[i6] = obj6;
        Object[] arr3 = new Object[i7];
        arr3[i5] = handler6;
        arr3[i8] = s7;
        arr3[i6] = audioSink5;
        i3 = i + 1;
        obj5.add(i, (z1)Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(arr2).newInstance(arr3));
        v.f(str8, "Loaded LibflacAudioRenderer.");
        Class[] arr6 = new Class[i7];
        arr6[i5] = Handler.class;
        arr6[i8] = obj7;
        arr6[i6] = obj6;
        Object[] arr = new Object[i7];
        arr[i5] = handler6;
        arr[i8] = s7;
        arr[i6] = audioSink5;
        obj5.add(i3, (z1)Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(arr6).newInstance(arr));
        v.f(str8, "Loaded FfmpegAudioRenderer.");
    }

    @Override // com.google.android.exoplayer2.c2
    protected AudioSink c(Context context, boolean z2, boolean z3, boolean z4) {
        DefaultAudioSink.d dVar = new DefaultAudioSink.d(new AudioProcessor[0]);
        super(q.c(context), dVar, z2, z3, z4);
        return defaultAudioSink2;
    }

    protected void d(Context context, int i2, ArrayList<com.google.android.exoplayer2.z1> arrayList3) {
        e obj1 = new e();
        arrayList3.add(obj1);
    }

    protected void e(Context context, e e2, Looper looper3, int i4, ArrayList<com.google.android.exoplayer2.z1> arrayList5) {
        f obj1 = new f(e2, looper3);
        arrayList5.add(obj1);
    }

    protected void f(Context context, Handler handler2, int i3, ArrayList<com.google.android.exoplayer2.z1> arrayList4) {
    }

    protected void g(Context context, k k2, Looper looper3, int i4, ArrayList<com.google.android.exoplayer2.z1> arrayList5) {
        l obj1 = new l(k2, looper3);
        arrayList5.add(obj1);
    }

    protected void h(Context context, int i2, s s3, boolean z4, Handler handler5, z z6, long l7, ArrayList<com.google.android.exoplayer2.z1> arrayList8) {
        int size;
        int i;
        final Object obj = this;
        int i3 = i2;
        final Object obj4 = obj24;
        final String str6 = "DefaultRenderersFactory";
        final Class<z> obj5 = z.class;
        super(context, s3, l7, obj6, z4, handler5, z6, 50);
        sVar3.l0(obj.f);
        sVar3.m0(obj.g);
        sVar3.n0(obj.h);
        obj4.add(sVar3);
        if (i3 == 0) {
        }
        int i5 = 2;
        if (i3 == i5) {
            size--;
        }
        int i4 = 50;
        int i6 = 3;
        int i7 = 0;
        int i8 = 4;
        int i9 = 1;
        Class[] arr3 = new Class[i8];
        arr3[i7] = Long.TYPE;
        arr3[i9] = Handler.class;
        arr3[i5] = obj5;
        arr3[i6] = Integer.TYPE;
        Object[] arr4 = new Object[i8];
        arr4[i7] = Long.valueOf(l7);
        arr4[i9] = handler5;
        arr4[i5] = z6;
        arr4[i6] = Integer.valueOf(i4);
        i = size + 1;
        obj4.add(size, (z1)Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(arr3).newInstance(arr4));
        v.f(str6, "Loaded LibvpxVideoRenderer.");
        Class[] arr2 = new Class[i8];
        arr2[i7] = Long.TYPE;
        arr2[i9] = Handler.class;
        arr2[i5] = obj5;
        arr2[i6] = Integer.TYPE;
        Object[] arr = new Object[i8];
        arr[i7] = Long.valueOf(l7);
        arr[i9] = handler5;
        arr[i5] = z6;
        arr[i6] = Integer.valueOf(i4);
        obj4.add(i, (z1)Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(arr2).newInstance(arr));
        v.f(str6, "Loaded Libgav1VideoRenderer.");
    }
}
