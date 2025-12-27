package d.u;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class u {

    public final Map<String, Object> a = new HashMap<>();
    public View b;
    final ArrayList<o> c = new ArrayList<>();
    @Deprecated
    public u() {
        super();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
    }

    public boolean equals(Object object) {
        z = object instanceof u;
        if (object instanceof u) {
            if (this.b == object.b) {
                if (this.a.equals(object.a)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str5 = "TransitionValues@";
        String str6 = Integer.toHexString(hashCode());
        String str7 = ":\n";
        str2 = str5 + str6 + str7;
        StringBuilder stringBuilder3 = new StringBuilder();
        String str3 = "    view = ";
        String str4 = "\n";
        str8 = str2 + str3 + this.b + str4;
        StringBuilder stringBuilder4 = new StringBuilder();
        String str9 = "    values:";
        str = str8 + str9;
        Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            StringBuilder stringBuilder = new StringBuilder();
            String str10 = "    ";
            String str11 = ": ";
            Object value = this.a.get(item);
            str = str + str10 + item + str11 + value + str4;
        }
        return str;
    }

    public u(View view) {
        super();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        this.b = view;
    }
}
