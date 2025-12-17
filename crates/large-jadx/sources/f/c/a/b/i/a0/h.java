package f.c.a.b.i.a0;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.o;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.b0.a;

/* loaded from: classes.dex */
public abstract class h {
    static x a(Context context, i0 i02, s s3, a a4) {
        if (Build.VERSION.SDK_INT >= 21) {
            r obj5 = new r(context, i02, s3);
            return obj5;
        }
        o oVar = new o(context, i02, a4, s3);
        return oVar;
    }
}
