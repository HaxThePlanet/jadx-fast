package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class DefaultUserAgentPublisher implements com.google.firebase.platforminfo.UserAgentPublisher {

    private final com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar gamesSDKRegistrar;
    private final String javaSDKVersionUserAgent;
    DefaultUserAgentPublisher(Set<com.google.firebase.platforminfo.LibraryVersion> set, com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2) {
        super();
        this.javaSDKVersionUserAgent = DefaultUserAgentPublisher.toUserAgent(set);
        this.gamesSDKRegistrar = globalLibraryVersionRegistrar2;
    }

    static com.google.firebase.platforminfo.UserAgentPublisher a(ComponentContainer componentContainer) {
        DefaultUserAgentPublisher defaultUserAgentPublisher = new DefaultUserAgentPublisher(componentContainer.setOf(LibraryVersion.class), GlobalLibraryVersionRegistrar.getInstance());
        return defaultUserAgentPublisher;
    }

    public static Component<com.google.firebase.platforminfo.UserAgentPublisher> component() {
        return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(LibraryVersion.class)).factory(a.a).build();
    }

    private static String toUserAgent(Set<com.google.firebase.platforminfo.LibraryVersion> set) {
        boolean next;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator obj3 = set.iterator();
        while (obj3.hasNext()) {
            Object next3 = obj3.next();
            stringBuilder.append((LibraryVersion)next3.getLibraryName());
            stringBuilder.append('/');
            stringBuilder.append(next3.getVersion());
            if (obj3.hasNext()) {
            }
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public String getUserAgent() {
        if (this.gamesSDKRegistrar.getRegisteredVersions().isEmpty()) {
            return this.javaSDKVersionUserAgent;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.javaSDKVersionUserAgent);
        stringBuilder.append(' ');
        stringBuilder.append(DefaultUserAgentPublisher.toUserAgent(this.gamesSDKRegistrar.getRegisteredVersions()));
        return stringBuilder.toString();
    }
}
