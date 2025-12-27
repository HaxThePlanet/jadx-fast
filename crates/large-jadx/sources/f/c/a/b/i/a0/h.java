package f.c.a.b.i.a0;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.o;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.b0.a;

/* compiled from: SchedulingModule.java */
/* loaded from: classes.dex */
public abstract class h {
    static x a(Context context, i0 i0Var, s sVar, a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new r(context, i0Var, sVar);
        }
        return new o(context, i0Var, aVar, sVar);
    }
}
