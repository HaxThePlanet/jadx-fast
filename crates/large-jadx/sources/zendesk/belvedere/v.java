package zendesk.belvedere;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* loaded from: classes3.dex */
class v {

    private final SharedPreferences a;
    v(Context context) {
        super();
        this.a = context.getSharedPreferences("belvedere_prefs", 0);
    }

    void a(String string) {
        this.a.edit().putBoolean(string, true).apply();
    }

    boolean b(String string) {
        return this.a.contains(string);
    }
}
