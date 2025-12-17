package com.google.firebase.datatransport;

import androidx.annotation.Keep;
import com.google.android.datatransport.cct.c;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import f.c.a.b.g;
import f.c.a.b.i.t;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class TransportRegistrar implements ComponentRegistrar {
    static g a(ComponentContainer componentContainer) {
        t.f((Context)componentContainer.get(Context.class));
        return t.c().g(c.g);
    }

    public List<Component<?>> getComponents() {
        return Collections.singletonList(Component.builder(g.class).add(Dependency.required(Context.class)).factory(a.a).build());
    }
}
