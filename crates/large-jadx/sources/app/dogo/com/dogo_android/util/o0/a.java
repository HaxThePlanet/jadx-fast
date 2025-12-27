package app.dogo.com.dogo_android.util.o0;

import java.util.Map;
import n.a.a;

/* compiled from: EntryValidationResponse.java */
/* loaded from: classes.dex */
public class a {

    private boolean a;
    private String b;
    private String c;
    private int d;
    public a(Object object) {
        str = "error";
        super();
        boolean z = false;
        try {
            if (object.containsKey(str)) {
                this.d = (Integer)(Map)object.get(str).get("code").intValue();
                this.a = z;
                return;
            }
        } catch (Exception e) {
            this.a = str5;
            boolean str5 = "EntryCreationResponse invalid response data";
            a.e(e, str5, new Object[str5]);
        }
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.a;
    }
}
