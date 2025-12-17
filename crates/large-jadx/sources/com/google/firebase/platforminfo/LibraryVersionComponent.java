package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;

/* loaded from: classes2.dex */
public class LibraryVersionComponent {

    public interface VersionExtractor {
        public abstract String extract(T t);
    }
    static com.google.firebase.platforminfo.LibraryVersion a(String string, com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor libraryVersionComponent$VersionExtractor2, ComponentContainer componentContainer3) {
        return LibraryVersion.create(string, versionExtractor2.extract((Context)componentContainer3.get(Context.class)));
    }

    public static Component<?> create(String string, String string2) {
        return Component.intoSet(LibraryVersion.create(string, string2), LibraryVersion.class);
    }

    public static Component<?> fromContext(String string, com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor<Context> libraryVersionComponent$VersionExtractor2) {
        b bVar = new b(string, versionExtractor2);
        return Component.intoSetBuilder(LibraryVersion.class).add(Dependency.required(Context.class)).factory(bVar).build();
    }
}
