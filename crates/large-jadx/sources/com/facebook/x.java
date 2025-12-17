package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/ProfileCache;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", "", "load", "Lcom/facebook/Profile;", "save", "profile", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class x {

    private final SharedPreferences a;
    static {
    }

    public x() {
        super();
        SharedPreferences sharedPreferences = o.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        n.e(sharedPreferences, "FacebookSdk.getApplicati…ME, Context.MODE_PRIVATE)");
        this.a = sharedPreferences;
    }

    public final void a() {
        this.a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }

    public final com.facebook.w b() {
        final int i = 0;
        String string = this.a.getString("com.facebook.ProfileManager.CachedProfile", i);
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            w wVar = new w(jSONObject);
            return wVar;
        }
        return i;
    }

    public final void c(com.facebook.w w) {
        Object edit;
        String str;
        Object obj3;
        n.f(w, "profile");
        obj3 = w.c();
        if (obj3 != null) {
            this.a.edit().putString("com.facebook.ProfileManager.CachedProfile", obj3.toString()).apply();
        }
    }
}
