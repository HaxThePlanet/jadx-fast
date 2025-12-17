package com.google.firebase.dynamiclinks;

import android.net.Uri;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes2.dex */
public interface ShortDynamicLink {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Suffix {

        public static final int SHORT = 2;
        public static final int UNGUESSABLE = 1;
    }

    public interface Warning {
        @Deprecated
        public abstract String getCode();

        public abstract String getMessage();
    }
    public abstract Uri getPreviewLink();

    public abstract Uri getShortLink();

    public abstract List<? extends com.google.firebase.dynamiclinks.ShortDynamicLink.Warning> getWarnings();
}
