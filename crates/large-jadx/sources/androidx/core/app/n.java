package androidx.core.app;

import android.app.Person;
import android.app.Person.Builder;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class n {

    java.lang.CharSequence a;
    IconCompat b;
    String c;
    String d;
    boolean e;
    boolean f;
    public IconCompat a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public java.lang.CharSequence c() {
        return this.a;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String g() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        if (this.a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("name:");
            stringBuilder.append(this.a);
            return stringBuilder.toString();
        }
        return "";
    }

    public Person h() {
        android.graphics.drawable.Icon icon;
        Person.Builder builder = new Person.Builder();
        if (a() != null) {
            icon = a().p();
        } else {
            icon = 0;
        }
        return builder.setName(c()).setIcon(icon).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
