package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.d;
import com.google.android.datatransport.runtime.backends.h;
import com.google.android.datatransport.runtime.backends.m;

/* loaded from: classes.dex */
public class CctBackendFactory implements d {
    @Override // com.google.android.datatransport.runtime.backends.d
    public m create(h h) {
        d dVar = new d(h.b(), h.e(), h.d());
        return dVar;
    }
}
