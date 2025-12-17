package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
final class f2 {

    private final Context a;
    private final Handler b;
    private final com.google.android.exoplayer2.f2.b c;
    private final AudioManager d;
    private com.google.android.exoplayer2.f2.c e;
    private int f = 3;
    private int g;
    private boolean h;

    static class a {
    }

    public interface b {
        public abstract void I(int i);

        public abstract void V(int i, boolean z2);
    }

    private final class c extends BroadcastReceiver {

        final com.google.android.exoplayer2.f2 a;
        private c(com.google.android.exoplayer2.f2 f2) {
            this.a = f2;
            super();
        }

        c(com.google.android.exoplayer2.f2 f2, com.google.android.exoplayer2.f2.a f2$a2) {
            super(f2);
        }

        static void a(com.google.android.exoplayer2.f2 f2) {
            f2.b(f2);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            l0 l0Var = new l0(this.a);
            f2.a(this.a).post(l0Var);
        }
    }
    public f2(Context context, Handler handler2, com.google.android.exoplayer2.f2.b f2$b3) {
        Context obj2;
        com.google.android.exoplayer2.f2.c obj3;
        IntentFilter obj4;
        super();
        obj2 = context.getApplicationContext();
        this.a = obj2;
        this.b = handler2;
        this.c = b3;
        obj3 = obj2.getSystemService("audio");
        g.h((AudioManager)obj3);
        this.d = (AudioManager)obj3;
        this.g = f2.f(obj3, 3);
        this.h = f2.e(obj3, this.f);
        obj3 = new f2.c(this, 0);
        obj4 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        obj2.registerReceiver(obj3, obj4);
        this.e = obj3;
    }

    static Handler a(com.google.android.exoplayer2.f2 f2) {
        return f2.b;
    }

    static void b(com.google.android.exoplayer2.f2 f2) {
        f2.i();
    }

    private static boolean e(AudioManager audioManager, int i2) {
        int obj2;
        if (p0.a >= 23) {
            return audioManager.isStreamMute(i2);
        }
        obj2 = f2.f(audioManager, i2) == 0 ? 1 : 0;
        return obj2;
    }

    private static int f(AudioManager audioManager, int i2) {
        try {
            return audioManager.getStreamVolume(i2);
            int string = 60;
            StringBuilder str = new StringBuilder(string);
            string = "Could not retrieve stream volume for stream type ";
            str.append(string);
            str.append(i2);
            string = str.toString();
            str = "StreamVolumeManager";
            v.i(str, string, th);
            audioManager = audioManager.getStreamMaxVolume(i2);
            return audioManager;
        }
    }

    private void i() {
        boolean i;
        int i2 = f2.f(this.d, this.f);
        boolean z = f2.e(this.d, this.f);
        if (this.g == i2) {
            if (this.h != z) {
                this.g = i2;
                this.h = z;
                this.c.V(i2, z);
            }
        } else {
        }
    }

    public int c() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public int d() {
        int streamMinVolume;
        int i;
        if (p0.a >= 28) {
            streamMinVolume = this.d.getStreamMinVolume(this.f);
        } else {
            streamMinVolume = 0;
        }
        return streamMinVolume;
    }

    public void g() {
        com.google.android.exoplayer2.f2.c cVar;
        Context str2;
        String str;
        cVar = this.e;
        if (cVar != null) {
            this.a.unregisterReceiver(cVar);
            this.e = 0;
        }
        try {
        }
    }

    public void h(int i) {
        if (this.f == i) {
        }
        this.f = i;
        i();
        this.c.I(i);
    }
}
