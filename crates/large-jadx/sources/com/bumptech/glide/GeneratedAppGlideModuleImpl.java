package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import com.bumptech.glide.o.p.b;
import com.bumptech.glide.p.a;
import com.bumptech.glide.p.c;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends com.bumptech.glide.GeneratedAppGlideModule {

    private final MyAppGlideModule a;
    public GeneratedAppGlideModuleImpl(Context context) {
        boolean loggable;
        super();
        MyAppGlideModule obj2 = new MyAppGlideModule();
        this.a = obj2;
        obj2 = "Glide";
        if (Log.isLoggable(obj2, 3)) {
            Log.d(obj2, "Discovered AppGlideModule from annotation: app.dogo.com.dogo_android.util.MyAppGlideModule");
        }
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public void a(Context context, com.bumptech.glide.c c2, com.bumptech.glide.Registry registry3) {
        this.a.a(context, c2, registry3);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public void b(Context context, com.bumptech.glide.d d2) {
        this.a.b(context, d2);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public boolean c() {
        return this.a.c();
    }

    public Set<Class<?>> d() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    p.b e() {
        return f();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    com.bumptech.glide.a f() {
        a aVar = new a();
        return aVar;
    }
}
