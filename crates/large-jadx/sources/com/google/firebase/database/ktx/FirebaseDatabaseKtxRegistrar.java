package com.google.firebase.database.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0002H\u0016¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0008", d2 = {"Lcom/google/firebase/database/ktx/FirebaseDatabaseKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "", "Lcom/google/firebase/components/Component;", "getComponents", "()Ljava/util/List;", "<init>", "()V", "com.google.firebase-firebase-database-ktx"}, k = 1, mv = {1, 4, 0})
public final class FirebaseDatabaseKtxRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return p.b(LibraryVersionComponent.create("fire-db-ktx", "20.0.2"));
    }
}
