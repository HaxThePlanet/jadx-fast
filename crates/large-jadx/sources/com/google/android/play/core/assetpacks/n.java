package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class n extends com.google.android.play.core.assetpacks.l<android.os.ParcelFileDescriptor> {
    n(com.google.android.play.core.assetpacks.t t, o o2) {
        super(t, o2);
    }

    @Override // com.google.android.play.core.assetpacks.l
    public final void p(Bundle bundle, Bundle bundle2) {
        super.p(bundle, bundle2);
        this.a.e((ParcelFileDescriptor)bundle.getParcelable("chunk_file_descriptor"));
    }
}
