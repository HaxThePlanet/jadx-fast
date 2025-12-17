package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class GlobalLibraryVersionRegistrar {

    private static volatile com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar INSTANCE;
    private final Set<com.google.firebase.platforminfo.LibraryVersion> infos;
    GlobalLibraryVersionRegistrar() {
        super();
        HashSet hashSet = new HashSet();
        this.infos = hashSet;
    }

    public static com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar getInstance() {
        com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar;
        Class<com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar> obj;
        obj = GlobalLibraryVersionRegistrar.class;
        if (GlobalLibraryVersionRegistrar.INSTANCE == null && GlobalLibraryVersionRegistrar.INSTANCE == null) {
            obj = GlobalLibraryVersionRegistrar.class;
            synchronized (obj) {
                globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                GlobalLibraryVersionRegistrar.INSTANCE = globalLibraryVersionRegistrar;
            }
        }
        return globalLibraryVersionRegistrar;
    }

    Set<com.google.firebase.platforminfo.LibraryVersion> getRegisteredVersions() {
        final Set infos = this.infos;
        return Collections.unmodifiableSet(this.infos);
        synchronized (infos) {
            infos = this.infos;
            return Collections.unmodifiableSet(this.infos);
        }
    }

    public void registerVersion(String string, String string2) {
        final Set infos = this.infos;
        this.infos.add(LibraryVersion.create(string, string2));
        return;
        synchronized (infos) {
            infos = this.infos;
            this.infos.add(LibraryVersion.create(string, string2));
        }
    }
}
