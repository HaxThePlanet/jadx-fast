package app.dogo.com.dogo_android.y.q;

import android.os.Bundle;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.u2;

/* compiled from: VideoPlaybackViewModel.java */
/* loaded from: classes.dex */
public class e extends r {

    private Exam A;
    private o3 z;
    public e() {
        this(App.o());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String w() {
        String videoUrl = null;
        if (this.A != null) {
            videoUrl = this.A.getVideoUrl();
        } else {
            int i = 0;
        }
        return videoUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean x() {
        boolean z = false;
        if (this.A != null) {
            int r0 = !this.A.getVideoUrl().isEmpty() ? 1 : 0;
        }
        return (!this.A.getVideoUrl().isEmpty() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void y(Bundle bundle) {
        if (bundle != null) {
            str = "model";
            java.io.Serializable serializable = bundle.getSerializable(str);
            this.A = serializable;
            if (serializable != null) {
                this.z.logEvent(E_Training.c.c(new EP_TrickId(), this.A.getTrickId()));
            }
        }
    }

    public e(o3 o3Var) {
        super();
        this.z = o3Var;
    }
}
