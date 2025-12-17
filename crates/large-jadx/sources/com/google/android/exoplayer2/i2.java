package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
final class i2 {

    private final WifiManager a;
    private WifiManager.WifiLock b;
    private boolean c;
    private boolean d;
    public i2(Context context) {
        super();
        this.a = (WifiManager)context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        boolean z;
        final WifiManager.WifiLock wifiLock = this.b;
        if (wifiLock == null) {
        }
        if (this.c && this.d) {
            if (this.d) {
                wifiLock.acquire();
            } else {
                wifiLock.release();
            }
        } else {
        }
    }

    public void a(boolean z) {
        WifiManager.WifiLock wifiLock;
        int i;
        String str;
        WifiManager wifiManager = this.a;
        if (z && this.b == null && wifiManager == null) {
            if (this.b == null) {
                wifiManager = this.a;
                if (wifiManager == null) {
                    v.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                }
                wifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.b = wifiLock;
                wifiLock.setReferenceCounted(false);
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
