package app.dogo.com.dogo_android.y.q;

import android.os.Bundle;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p0;
import app.dogo.com.dogo_android.w.u2;

/* loaded from: classes.dex */
public class e extends r {

    private Exam A;
    private o3 z;
    public e() {
        super(App.o());
    }

    public e(o3 o3) {
        super();
        this.z = o3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public String w() {
        String videoUrl;
        Exam exam = this.A;
        if (exam != null) {
            videoUrl = exam.getVideoUrl();
        } else {
            videoUrl = 0;
        }
        return videoUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public boolean x() {
        Exam empty;
        int i;
        empty = this.A;
        if (empty != null && !empty.getVideoUrl().isEmpty()) {
            i = !empty.getVideoUrl().isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public void y(Bundle bundle) {
        Object str;
        n2 n2Var;
        String trickId;
        Object obj4;
        obj4 = bundle.getSerializable("model");
        this.A = (Exam)obj4;
        if (bundle != null && obj4 != null) {
            obj4 = bundle.getSerializable("model");
            this.A = (Exam)obj4;
            if (obj4 != null) {
                n2Var = new n2();
                this.z.d(p0.c.c(n2Var, this.A.getTrickId()));
            }
        }
    }
}
