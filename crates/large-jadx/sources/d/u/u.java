package d.u;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class u {

    public final Map<String, Object> a;
    public View b;
    final ArrayList<d.u.o> c;
    @Deprecated
    public u() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
    }

    public u(View view) {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.b = view;
    }

    public boolean equals(Object object) {
        boolean view2;
        View view;
        Object obj3;
        if (object instanceof u && this.b == object.b && this.a.equals(object.a)) {
            if (this.b == object.b) {
                if (this.a.equals(object.a)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        String string;
        Object next;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("TransitionValues@");
        stringBuilder2.append(Integer.toHexString(hashCode()));
        stringBuilder2.append(":\n");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2.toString());
        stringBuilder3.append("    view = ");
        stringBuilder3.append(this.b);
        String str2 = "\n";
        stringBuilder3.append(str2);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder3.toString());
        stringBuilder4.append("    values:");
        string = stringBuilder4.toString();
        Iterator iterator = this.a.keySet().iterator();
        for (String next : iterator) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("    ");
            stringBuilder.append(next);
            stringBuilder.append(": ");
            stringBuilder.append(this.a.get(next));
            stringBuilder.append(str2);
            string = stringBuilder.toString();
        }
        return string;
    }
}
