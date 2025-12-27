package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import com.bumptech.glide.o.p.b;
import com.bumptech.glide.p.a;
import com.bumptech.glide.p.c;
import java.util.Collections;
import java.util.Set;

/* compiled from: GeneratedAppGlideModuleImpl.java */
/* loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    private final MyAppGlideModule a = new MyAppGlideModule();
    public GeneratedAppGlideModuleImpl(Context context) {
        super();
        MyAppGlideModule myAppGlideModule = new MyAppGlideModule();
        String str2 = "Glide";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Discovered AppGlideModule from annotation: app.dogo.com.dogo_android.util.MyAppGlideModule");
        }
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public void a(Context context, c cVar, Registry registry) {
        this.a.a(context, cVar, registry);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public void b(Context context, d dVar) {
        this.a.b(context, dVar);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public boolean c() {
        return this.a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> d() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    a f() {
        return new a();
    }
}
