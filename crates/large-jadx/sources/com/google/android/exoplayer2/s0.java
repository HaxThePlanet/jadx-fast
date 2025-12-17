package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import com.google.android.exoplayer2.audio.p;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
final class s0 {

    private final AudioManager a;
    private final com.google.android.exoplayer2.s0.a b;
    private com.google.android.exoplayer2.s0.b c;
    private p d;
    private int e = 0;
    private int f;
    private float g = 1f;
    private AudioFocusRequest h;
    private boolean i;

    private class a implements AudioManager.OnAudioFocusChangeListener {

        private final Handler a;
        final com.google.android.exoplayer2.s0 b;
        public a(com.google.android.exoplayer2.s0 s0, Handler handler2) {
            this.b = s0;
            super();
            this.a = handler2;
        }

        private void a(int i) {
            s0.d(this.b, i);
        }

        @Override // android.media.AudioManager$OnAudioFocusChangeListener
        public void b(int i) {
            a(i);
        }

        @Override // android.media.AudioManager$OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            b bVar = new b(this, i);
            this.a.post(bVar);
        }
    }

    public interface b {
        public abstract void M(float f);

        public abstract void N(int i);
    }
    public s0(Context context, Handler handler2, com.google.android.exoplayer2.s0.b s0$b3) {
        super();
        int i = 1065353216;
        Object obj2 = context.getApplicationContext().getSystemService("audio");
        g.e((AudioManager)obj2);
        this.a = (AudioManager)obj2;
        this.c = b3;
        obj2 = new s0.a(this, handler2);
        this.b = obj2;
        obj2 = 0;
    }

    private void a() {
        this.a.abandonAudioFocus(this.b);
    }

    private void b() {
        if (this.e == 0) {
        }
        if (p0.a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    private void c() {
        AudioManager audioManager;
        final AudioFocusRequest request = this.h;
        if (request != null) {
            this.a.abandonAudioFocusRequest(request);
        }
    }

    static void d(com.google.android.exoplayer2.s0 s0, int i2) {
        s0.h(i2);
    }

    private static int e(p p) {
        Object obj6;
        int i = 0;
        if (p == null) {
            return i;
        }
        final int i3 = p.c;
        final String str2 = "AudioFocusManager";
        final int i5 = 2;
        final int i6 = 1;
        switch (i3) {
            case 0:
                v.h(str2, "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return i6;
            case 1:
                return i6;
            case 2:
                return i5;
            case 3:
                return i;
            case 4:
                return 3;
            case 5:
                return i4;
            case 6:
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unidentified audio usage: ");
                stringBuilder.append(i3);
                v.h(str2, stringBuilder.toString());
                return i;
            default:
                return 4;
                return i5;
        }
        return i5;
    }

    private void f(int i) {
        final com.google.android.exoplayer2.s0.b bVar = this.c;
        if (bVar != null) {
            bVar.N(i);
        }
    }

    private void h(int i) {
        int obj3;
        int i6 = -2;
        int i3 = -1;
        int i4 = 1;
        if (i != -3 && i != i6 && i != i3 && i != i4) {
            if (i != i6) {
                i3 = -1;
                if (i != i3) {
                    i4 = 1;
                    if (i != i4) {
                        StringBuilder stringBuilder = new StringBuilder(38);
                        stringBuilder.append("Unknown focus change type: ");
                        stringBuilder.append(i);
                        v.h("AudioFocusManager", stringBuilder.toString());
                    }
                    n(i4);
                    f(i4);
                }
                f(i3);
                b();
            }
        }
        if (i != i6) {
            if (q()) {
                f(0);
                n(2);
            } else {
                n(3);
            }
        } else {
        }
    }

    private int j() {
        int i;
        final int i6 = 1;
        if (this.e == i6) {
            return i6;
        }
        if (p0.a >= 26) {
            i = l();
        } else {
            i = k();
        }
        if (i == i6) {
            n(i6);
            return i6;
        }
        n(0);
        return -1;
    }

    private int k() {
        p pVar = this.d;
        g.e(pVar);
        return this.a.requestAudioFocus(this.b, p0.W(pVar.c), this.f);
    }

    private int l() {
        AudioFocusRequest request;
        AudioFocusRequest.Builder builder;
        boolean z;
        int i;
        android.media.AudioAttributes audioAttributes;
        request = this.h;
        if (request != null) {
            if (this.i) {
                if (request == null) {
                    builder = new AudioFocusRequest.Builder(this.f);
                } else {
                    builder = new AudioFocusRequest.Builder(this.h);
                }
                p pVar = this.d;
                g.e(pVar);
                this.h = builder.setAudioAttributes((p)pVar.a()).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.b).build();
                this.i = false;
            }
        } else {
        }
        return this.a.requestAudioFocus(this.h);
    }

    private void n(int i) {
        int obj2;
        if (this.e == i) {
        }
        this.e = i;
        obj2 = i == 3 ? 1045220557 : 1065353216;
        if (Float.compare(f, obj2) == 0) {
        }
        this.g = obj2;
        com.google.android.exoplayer2.s0.b bVar = this.c;
        if (bVar != null) {
            bVar.M(obj2);
        }
    }

    private boolean o(int i) {
        int i2;
        int obj2;
        i2 = 1;
        if (i != i2) {
            if (this.f != i2) {
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    private boolean q() {
        p pVar;
        int i;
        pVar = this.d;
        if (pVar != null && pVar.a == 1) {
            if (pVar.a == 1) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public float g() {
        return this.g;
    }

    public void i() {
        this.c = 0;
        b();
    }

    public void m(p p) {
        int z;
        Object obj2;
        this.d = p;
        obj2 = s0.e(p);
        this.f = obj2;
        if (!p0.b(this.d, p) && obj2 != 1) {
            this.d = p;
            obj2 = s0.e(p);
            this.f = obj2;
            if (obj2 != 1) {
                if (obj2 == null) {
                } else {
                    z = 0;
                }
            }
            g.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int p(boolean z, int i2) {
        int i;
        i = -1;
        b();
        if (o(i2) && z) {
            b();
            if (z) {
                i = 1;
            }
            return i;
        }
        if (z) {
            i = j();
        }
        return i;
    }
}
