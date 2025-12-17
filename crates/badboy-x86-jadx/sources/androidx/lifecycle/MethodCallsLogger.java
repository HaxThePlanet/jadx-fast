package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0017R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/lifecycle/MethodCallsLogger;", "", "<init>", "()V", "calledMethods", "", "", "", "approveCall", "", "name", "type", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class MethodCallsLogger {

    private final Map<String, Integer> calledMethods;
    public MethodCallsLogger() {
        super();
        HashMap hashMap = new HashMap();
        this.calledMethods = (Map)hashMap;
    }

    public boolean approveCall(String name, int type) {
        int i;
        int intValue;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.calledMethods.get(name);
        i = 0;
        if ((Integer)obj != null) {
            intValue = (Integer)obj.intValue();
        } else {
            intValue = i;
        }
        final int i4 = 1;
        i2 = intValue & type != 0 ? i4 : i;
        this.calledMethods.put(name, Integer.valueOf(intValue | type));
        if (i2 == 0) {
            i = i4;
        }
        return i;
    }
}
