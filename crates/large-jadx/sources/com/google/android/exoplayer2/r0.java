package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes.dex */
final class r0 {

    private final Context a;
    private final com.google.android.exoplayer2.r0.a b;
    private boolean c;

    private final class a extends BroadcastReceiver implements Runnable {

        private final com.google.android.exoplayer2.r0.b a;
        private final Handler b;
        final com.google.android.exoplayer2.r0 c;
        public a(com.google.android.exoplayer2.r0 r0, Handler handler2, com.google.android.exoplayer2.r0.b r0$b3) {
            this.c = r0;
            super();
            this.b = handler2;
            this.a = b3;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            boolean obj1;
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent2.getAction())) {
                this.b.post(this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void run() {
            boolean z;
            if (r0.a(this.c)) {
                this.a.J();
            }
        }
    }

    public interface b {
        public abstract void J();
    }
    public r0(Context context, Handler handler2, com.google.android.exoplayer2.r0.b r0$b3) {
        super();
        this.a = context.getApplicationContext();
        r0.a obj1 = new r0.a(this, handler2, b3);
        this.b = obj1;
    }

    static boolean a(com.google.android.exoplayer2.r0 r0) {
        return r0.c;
    }

    public void b(boolean z) {
        boolean z2;
        IntentFilter intentFilter;
        String str;
        boolean obj4;
        if (z && !this.c) {
            if (!this.c) {
                intentFilter = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");
                this.a.registerReceiver(this.b, intentFilter);
                this.c = true;
            } else {
                if (!z && this.c) {
                    if (this.c) {
                        this.a.unregisterReceiver(this.b);
                        this.c = false;
                    }
                }
            }
        } else {
        }
    }
}
