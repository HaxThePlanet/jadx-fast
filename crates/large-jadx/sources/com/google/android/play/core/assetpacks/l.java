package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.j2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;
import java.util.List;

/* loaded from: classes2.dex */
class l<T>  extends j2 {

    final o<T> a;
    final com.google.android.play.core.assetpacks.t b;
    l(com.google.android.play.core.assetpacks.t t, o o2) {
        this.b = t;
        super();
        this.a = o2;
    }

    @Override // com.google.android.play.core.internal.j2
    public void G0(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        t.q().d("onRequestDownloadInfo()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.j2
    public void Q1(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[1];
        t.q().d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // com.google.android.play.core.internal.j2
    public void W1(int i, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[1];
        t.q().d("onStartDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.j2
    public void c(Bundle bundle) {
        t.r(this.b).s(this.a);
        final int obj5 = bundle.getInt("error_code");
        Object[] arr = new Object[1];
        t.q().b("onError(%d)", Integer.valueOf(obj5));
        AssetPackException assetPackException = new AssetPackException(obj5);
        this.a.d(assetPackException);
    }

    @Override // com.google.android.play.core.internal.j2
    public final void d2(int i, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[1];
        t.q().d("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.j2
    public final void g(int i, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[1];
        t.q().d("onCancelDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.j2
    public final void h(Bundle bundle) {
        t.r(this.b).s(this.a);
        t.q().d("onCancelDownloads()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.j2
    public final void k0(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        t.q().d("onRemoveModule()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.j2
    public final void k1(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[2];
        t.q().d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.internal.j2
    public final void o2(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[4];
        t.q().d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.internal.j2
    public void p(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        t.q().d("onGetChunkFileDescriptor", new Object[0]);
    }

    public void x(List<Bundle> list) {
        t.r(this.b).s(this.a);
        t.q().d("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.j2
    public final void y1(Bundle bundle, Bundle bundle2) {
        t.r(this.b).s(this.a);
        Object[] arr = new Object[1];
        t.q().d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }
}
