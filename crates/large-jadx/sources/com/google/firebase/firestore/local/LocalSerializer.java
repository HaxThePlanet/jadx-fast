package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.bundle.BundledQuery;
import com.google.firebase.firestore.core.Query.LimitType;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldIndex.Segment;
import com.google.firebase.firestore.model.FieldIndex.Segment.Kind;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.proto.MaybeDocument.Builder;
import com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase;
import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.NoDocument.Builder;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.proto.Target.Builder;
import com.google.firebase.firestore.proto.Target.TargetTypeCase;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firebase.firestore.proto.UnknownDocument.Builder;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.proto.WriteBatch.Builder;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.z.a;
import f.c.e.a.a.a;
import f.c.e.a.a.a.b;
import f.c.e.a.a.a.c;
import f.c.e.a.a.a.c.a;
import f.c.e.a.a.a.c.b;
import f.c.e.a.a.a.c.c;
import f.c.e.a.a.a.c.d;
import f.c.e.a.a.a.d;
import f.c.e.b.a;
import f.c.e.b.a.b;
import f.c.e.b.a.c;
import f.c.e.c.h;
import f.c.e.c.h.b;
import f.c.e.c.m;
import f.c.e.c.u.d;
import f.c.e.c.y;
import f.c.e.c.y.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class LocalSerializer {

    private final RemoteSerializer rpcSerializer;
    public LocalSerializer(RemoteSerializer remoteSerializer) {
        super();
        this.rpcSerializer = remoteSerializer;
    }

    private MutableDocument decodeDocument(h h, boolean z2) {
        MutableDocument obj4;
        if (z2) {
            obj4 = MutableDocument.newFoundDocument(this.rpcSerializer.decodeKey(h.getName()), this.rpcSerializer.decodeVersion(h.i()), ObjectValue.fromMap(h.g())).setHasCommittedMutations();
        }
        return obj4;
    }

    private MutableDocument decodeNoDocument(NoDocument noDocument, boolean z2) {
        MutableDocument obj3;
        if (z2) {
            obj3 = MutableDocument.newNoDocument(this.rpcSerializer.decodeKey(noDocument.getName()), this.rpcSerializer.decodeVersion(noDocument.getReadTime())).setHasCommittedMutations();
        }
        return obj3;
    }

    private MutableDocument decodeUnknownDocument(UnknownDocument unknownDocument) {
        return MutableDocument.newUnknownDocument(this.rpcSerializer.decodeKey(unknownDocument.getName()), this.rpcSerializer.decodeVersion(unknownDocument.getVersion()));
    }

    private h encodeDocument(MutableDocument mutableDocument) {
        final h.b bVar = h.l();
        bVar.c(this.rpcSerializer.encodeKey(mutableDocument.getKey()));
        bVar.b(mutableDocument.getData().getFieldsMap());
        bVar.d(this.rpcSerializer.encodeTimestamp(mutableDocument.getVersion().getTimestamp()));
        return (h)bVar.build();
    }

    private NoDocument encodeNoDocument(MutableDocument mutableDocument) {
        final NoDocument.Builder builder = NoDocument.newBuilder();
        builder.setName(this.rpcSerializer.encodeKey(mutableDocument.getKey()));
        builder.setReadTime(this.rpcSerializer.encodeTimestamp(mutableDocument.getVersion().getTimestamp()));
        return (NoDocument)builder.build();
    }

    private UnknownDocument encodeUnknownDocument(MutableDocument mutableDocument) {
        final UnknownDocument.Builder builder = UnknownDocument.newBuilder();
        builder.setName(this.rpcSerializer.encodeKey(mutableDocument.getKey()));
        builder.setVersion(this.rpcSerializer.encodeTimestamp(mutableDocument.getVersion().getTimestamp()));
        return (UnknownDocument)builder.build();
    }

    public BundledQuery decodeBundledQuery(a a) {
        Query.LimitType lIMIT_TO_FIRST;
        lIMIT_TO_FIRST = a.f().equals(a.c.FIRST) ? Query.LimitType.LIMIT_TO_FIRST : Query.LimitType.LIMIT_TO_LAST;
        BundledQuery bundledQuery = new BundledQuery(this.rpcSerializer.decodeQueryTarget(a.g(), a.h()), lIMIT_TO_FIRST);
        return bundledQuery;
    }

    public FieldIndex decodeFieldIndex(String string, int i2, a a3, int i4, int i5) {
        FieldIndex fieldIndex;
        a.c.d aRRAY_CONFIG;
        int obj4;
        FieldPath obj5;
        fieldIndex = new FieldIndex(string, i2);
        Iterator obj3 = a3.g().iterator();
        while (obj3.hasNext()) {
            obj4 = obj3.next();
            if (obj4.g().equals(a.c.d.ARRAY_CONFIG)) {
            } else {
            }
            obj4 = FieldIndex.Segment.Kind.ORDERED;
            fieldIndex = fieldIndex.withAddedField(FieldPath.fromServerFormat((a.c)obj4.f()), obj4);
            obj4 = FieldIndex.Segment.Kind.CONTAINS;
        }
        obj4 = new Timestamp((long)i4, i4, i5);
        obj3 = new SnapshotVersion(obj4);
        return fieldIndex.withVersion(obj3);
    }

    MutableDocument decodeMaybeDocument(MaybeDocument maybeDocument) {
        int i = LocalSerializer.1.$SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[maybeDocument.getDocumentTypeCase().ordinal()];
        int i2 = 1;
        if (i != i2 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return decodeUnknownDocument(maybeDocument.getUnknownDocument());
                }
                Object[] arr = new Object[i2];
                arr[0] = maybeDocument;
                throw Assert.fail("Unknown MaybeDocument %s", arr);
            }
            return decodeNoDocument(maybeDocument.getNoDocument(), maybeDocument.getHasCommittedMutations());
        }
        return decodeDocument(maybeDocument.getDocument(), maybeDocument.getHasCommittedMutations());
    }

    public Mutation decodeMutation(y y) {
        return this.rpcSerializer.decodeMutation(y);
    }

    MutationBatch decodeMutationBatch(WriteBatch writeBatch) {
        int i2;
        int i3;
        Mutation decodeMutation;
        y rpcSerializer;
        int next2;
        Object[] next;
        int writesCount;
        int i;
        String str;
        int baseWritesCount = writeBatch.getBaseWritesCount();
        ArrayList arrayList2 = new ArrayList(baseWritesCount);
        final int i4 = 0;
        i2 = i4;
        while (i2 < baseWritesCount) {
            arrayList2.add(this.rpcSerializer.decodeMutation(writeBatch.getBaseWrites(i2)));
            i2++;
        }
        ArrayList arrayList = new ArrayList(writeBatch.getWritesCount());
        i3 = i4;
        while (i3 < writeBatch.getWritesCount()) {
            y writes2 = writeBatch.getWrites(i3);
            rpcSerializer = i3 + 1;
            i = 1;
            if (rpcSerializer < writeBatch.getWritesCount() && writeBatch.getWrites(rpcSerializer).t()) {
            } else {
            }
            next2 = i4;
            if (next2 != 0) {
            } else {
            }
            arrayList.add(this.rpcSerializer.decodeMutation(writes2));
            i3 += i;
            Assert.hardAssert(writeBatch.getWrites(i3).u(), "TransformMutation should be preceded by a patch or set mutation", new Object[i4]);
            y.b bVar = y.x(writes2);
            Iterator iterator = writeBatch.getWrites(rpcSerializer).n().d().iterator();
            for (m.c next : iterator) {
                bVar.b(next);
            }
            arrayList.add(this.rpcSerializer.decodeMutation((y)bVar.build()));
            i3 = rpcSerializer;
            bVar.b((m.c)iterator.next());
            if (writeBatch.getWrites(rpcSerializer).t()) {
            } else {
            }
            next2 = i;
        }
        MutationBatch obj12 = new MutationBatch(writeBatch.getBatchId(), this.rpcSerializer.decodeTimestamp(writeBatch.getLocalWriteTime()), arrayList2, arrayList);
        return obj12;
    }

    com.google.firebase.firestore.local.TargetData decodeTargetData(Target target) {
        RemoteSerializer rpcSerializer;
        int i;
        Target obj10;
        int i2 = LocalSerializer.1.$SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[target.getTargetTypeCase().ordinal()];
        int i3 = 1;
        if (i2 != i3) {
            if (i2 != 2) {
            } else {
                obj10 = this.rpcSerializer.decodeQueryTarget(target.getQuery());
                super(obj10, target.getTargetId(), target.getLastListenSequenceNumber(), obj4, QueryPurpose.LISTEN, this.rpcSerializer.decodeVersion(target.getSnapshotVersion()), this.rpcSerializer.decodeVersion(target.getLastLimboFreeSnapshotVersion()), target.getResumeToken());
                return obj10;
            }
            Object[] arr = new Object[i3];
            arr[0] = target.getTargetTypeCase();
            throw Assert.fail("Unknown targetType %d", arr);
        }
        obj10 = this.rpcSerializer.decodeDocumentsTarget(target.getDocuments());
    }

    public a encodeBundledQuery(BundledQuery bundledQuery) {
        a.c obj4;
        u.d encodeQueryTarget = this.rpcSerializer.encodeQueryTarget(bundledQuery.getTarget());
        a.b bVar = a.i();
        obj4 = bundledQuery.getLimitType().equals(Query.LimitType.LIMIT_TO_FIRST) ? a.c.FIRST : a.c.LAST;
        bVar.b(obj4);
        bVar.c(encodeQueryTarget.f());
        bVar.d(encodeQueryTarget.g());
        return (a)bVar.build();
    }

    public a encodeFieldIndex(FieldIndex fieldIndex) {
        int i;
        a.c.a aSCENDING;
        a.c.b bVar;
        FieldIndex.Segment.Kind cONTAINS;
        final a.b bVar2 = a.h();
        bVar2.c(a.d.COLLECTION_GROUP);
        i = 0;
        while (i < fieldIndex.segmentCount()) {
            FieldIndex.Segment segment = fieldIndex.getSegment(i);
            bVar = a.c.h();
            bVar.c(segment.getFieldPath().canonicalString());
            if (segment.getKind() == FieldIndex.Segment.Kind.CONTAINS) {
            } else {
            }
            bVar.d(a.c.c.ASCENDING);
            bVar2.b(bVar);
            i++;
            bVar.b(a.c.a.CONTAINS);
        }
        return (a)bVar2.build();
    }

    MaybeDocument encodeMaybeDocument(MutableDocument mutableDocument) {
        com.google.protobuf.z encodeUnknownDocument;
        MaybeDocument.Builder builder = MaybeDocument.newBuilder();
        if (mutableDocument.isNoDocument()) {
            builder.setNoDocument(encodeNoDocument(mutableDocument));
            builder.setHasCommittedMutations(mutableDocument.hasCommittedMutations());
            return (MaybeDocument)builder.build();
        } else {
            if (mutableDocument.isFoundDocument()) {
                builder.setDocument(encodeDocument(mutableDocument));
            } else {
                if (!mutableDocument.isUnknownDocument()) {
                } else {
                    builder.setUnknownDocument(encodeUnknownDocument(mutableDocument));
                }
            }
        }
        Object[] arr = new Object[1];
        throw Assert.fail("Cannot encode invalid document %s", mutableDocument);
    }

    public y encodeMutation(Mutation mutation) {
        return this.rpcSerializer.encodeMutation(mutation);
    }

    WriteBatch encodeMutationBatch(MutationBatch mutationBatch) {
        Iterator encodeMutation;
        Timestamp localWriteTime;
        boolean rpcSerializer;
        RemoteSerializer rpcSerializer2;
        final WriteBatch.Builder builder = WriteBatch.newBuilder();
        builder.setBatchId(mutationBatch.getBatchId());
        builder.setLocalWriteTime(this.rpcSerializer.encodeTimestamp(mutationBatch.getLocalWriteTime()));
        encodeMutation = mutationBatch.getBaseMutations().iterator();
        for (Mutation next3 : encodeMutation) {
            builder.addBaseWrites(this.rpcSerializer.encodeMutation(next3));
        }
        Iterator obj5 = mutationBatch.getMutations().iterator();
        for (Mutation next2 : obj5) {
            builder.addWrites(this.rpcSerializer.encodeMutation(next2));
        }
        return (WriteBatch)builder.build();
    }

    Target encodeTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        RemoteSerializer rpcSerializer;
        com.google.protobuf.z obj5;
        com.google.firebase.firestore.local.QueryPurpose lISTEN = QueryPurpose.LISTEN;
        Object[] arr = new Object[2];
        int i3 = 1;
        arr[i3] = targetData.getPurpose();
        Assert.hardAssert(lISTEN.equals(targetData.getPurpose()), "Only queries with purpose %s may be stored, got %s", arr);
        Target.Builder builder = Target.newBuilder();
        builder.setTargetId(targetData.getTargetId()).setLastListenSequenceNumber(targetData.getSequenceNumber()).setLastLimboFreeSnapshotVersion(this.rpcSerializer.encodeVersion(targetData.getLastLimboFreeSnapshotVersion())).setSnapshotVersion(this.rpcSerializer.encodeVersion(targetData.getSnapshotVersion())).setResumeToken(targetData.getResumeToken());
        obj5 = targetData.getTarget();
        if (obj5.isDocumentQuery()) {
            builder.setDocuments(this.rpcSerializer.encodeDocumentsTarget(obj5));
        } else {
            builder.setQuery(this.rpcSerializer.encodeQueryTarget(obj5));
        }
        return (Target)builder.build();
    }
}
