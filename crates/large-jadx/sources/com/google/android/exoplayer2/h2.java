package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
final class h2 {

    private final PowerManager a;
    private PowerManager.WakeLock b;
    private boolean c;
    private boolean d;
    public h2(Context context) {
        super();
        this.a = (PowerManager)context.getApplicationContext().getSystemService("power");
    }

    private void c() {
        boolean z;
        final PowerManager.WakeLock wakeLock = this.b;
        if (wakeLock == null) {
        }
        if (this.c && this.d) {
            if (this.d) {
                wakeLock.acquire();
            } else {
                wakeLock.release();
            }
        } else {
        }
    }

    public void a(boolean z) {
        PowerManager.WakeLock wakeLock;
        int i;
        String str;
        PowerManager powerManager = this.a;
        if (z && this.b == null && powerManager == null) {
            if (this.b == null) {
                powerManager = this.a;
                if (powerManager == null) {
                    v.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                }
                wakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.b = wakeLock;
                wakeLock.setReferenceCounted(false);
            }
        }
        this.c = z;
        c();
    }

    public void b(boolean z) {
        this.d = z;
        c();
    }
}
