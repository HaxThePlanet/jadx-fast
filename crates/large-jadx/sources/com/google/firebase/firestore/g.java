package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Function;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class g implements Function {

    public final com.google.firebase.firestore.FirebaseFirestore a;
    public final Executor b;
    public final com.google.firebase.firestore.Transaction.Function c;
    public g(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, Executor executor2, com.google.firebase.firestore.Transaction.Function transaction$Function3) {
        super();
        this.a = firebaseFirestore;
        this.b = executor2;
        this.c = function3;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return this.a.k(this.b, this.c, (Transaction)object);
    }
}
