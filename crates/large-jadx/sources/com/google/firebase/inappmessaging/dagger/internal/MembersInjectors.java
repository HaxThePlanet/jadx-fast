package com.google.firebase.inappmessaging.dagger.internal;

import com.google.firebase.inappmessaging.dagger.MembersInjector;

/* loaded from: classes2.dex */
public final class MembersInjectors {

    private static enum NoOpMembersInjector implements MembersInjector<Object> {

        INSTANCE;
        @Override // java.lang.Enum
        public void injectMembers(Object object) {
            Preconditions.checkNotNull(object, "Cannot inject members into a null reference");
        }
    }
    public static <T> MembersInjector<T> noOp() {
        return MembersInjectors.NoOpMembersInjector.INSTANCE;
    }
}
