package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class w {

    private Map<String, Integer> a;
    public w() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    public boolean a(String string, int i2) {
        int intValue;
        int i;
        Object obj = this.a.get(string);
        if ((Integer)obj != null) {
            intValue = (Integer)obj.intValue();
        } else {
            intValue = i;
        }
        if (intValue & i2 != 0) {
            i = i4;
        }
        this.a.put(string, Integer.valueOf(i2 |= intValue));
        return i ^ 1;
    }
}
