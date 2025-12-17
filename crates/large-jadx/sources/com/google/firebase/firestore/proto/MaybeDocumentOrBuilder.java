package com.google.firebase.firestore.proto;

import com.google.protobuf.t0;
import com.google.protobuf.u0;
import f.c.e.c.h;

/* loaded from: classes2.dex */
public interface MaybeDocumentOrBuilder extends u0 {
    @Override // com.google.protobuf.u0
    public abstract t0 getDefaultInstanceForType();

    @Override // com.google.protobuf.u0
    public abstract h getDocument();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase getDocumentTypeCase();

    @Override // com.google.protobuf.u0
    public abstract boolean getHasCommittedMutations();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.firestore.proto.NoDocument getNoDocument();

    @Override // com.google.protobuf.u0
    public abstract com.google.firebase.firestore.proto.UnknownDocument getUnknownDocument();

    @Override // com.google.protobuf.u0
    public abstract boolean hasDocument();

    @Override // com.google.protobuf.u0
    public abstract boolean hasNoDocument();

    @Override // com.google.protobuf.u0
    public abstract boolean hasUnknownDocument();

    @Override // com.google.protobuf.u0
    public abstract boolean isInitialized();
}
