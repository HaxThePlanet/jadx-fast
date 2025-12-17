package app.dogo.com.dogo_android.util.o0;

import java.util.Map;
import n.a.a;

/* loaded from: classes.dex */
public class a {

    private boolean a;
    private String b;
    private String c;
    private int d;
    public a(Object object) {
        String str;
        int i;
        boolean assignableFrom;
        Throwable obj5;
        str = "error";
        super();
        if (Map.class.isAssignableFrom(object.getClass()) && (Map)object.containsKey(str)) {
            if ((Map)object.containsKey(str)) {
                this.d = (Integer)(Map)object.get(str).get("code").intValue();
                this.a = false;
            }
            (Boolean)object.get("success").booleanValue();
            this.c = (String)object.get("imageId");
            this.b = (String)object.get("entryId");
            this.a = true;
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
