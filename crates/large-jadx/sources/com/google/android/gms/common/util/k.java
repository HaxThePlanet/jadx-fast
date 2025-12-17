package com.google.android.gms.common.util;

import java.io.Closeable;

/* loaded from: classes2.dex */
@Deprecated
public final class k {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            closeable.close();
        }
        try {
        }
    }
}
