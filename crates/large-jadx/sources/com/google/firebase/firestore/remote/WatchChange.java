package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.j;
import io.grpc.d1;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class WatchChange {

    public static enum WatchTargetChangeType {

        NoChange,
        Added,
        Removed,
        Current,
        Reset;
    }

    public static final class DocumentChange extends com.google.firebase.firestore.remote.WatchChange {

        private final DocumentKey documentKey;
        private final MutableDocument newDocument;
        private final List<Integer> removedTargetIds;
        private final List<Integer> updatedTargetIds;
        public DocumentChange(List<Integer> list, List<Integer> list2, DocumentKey documentKey3, MutableDocument mutableDocument4) {
            super(0);
            this.updatedTargetIds = list;
            this.removedTargetIds = list2;
            this.documentKey = documentKey3;
            this.newDocument = mutableDocument4;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public boolean equals(Object object) {
            boolean equals;
            Class<com.google.firebase.firestore.remote.WatchChange.DocumentChange> obj;
            Class class;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (WatchChange.DocumentChange.class != object.getClass()) {
                } else {
                    if (!this.updatedTargetIds.equals(object.updatedTargetIds)) {
                        return i;
                    }
                    if (!this.removedTargetIds.equals(object.removedTargetIds)) {
                        return i;
                    }
                    if (!this.documentKey.equals(object.documentKey)) {
                        return i;
                    }
                    MutableDocument newDocument = this.newDocument;
                    final MutableDocument obj5 = object.newDocument;
                    if (newDocument != null) {
                        equals = newDocument.equals(obj5);
                    } else {
                        if (obj5 == null) {
                        } else {
                            equals = i;
                        }
                    }
                }
                return equals;
            }
            return i;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public DocumentKey getDocumentKey() {
            return this.documentKey;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public MutableDocument getNewDocument() {
            return this.newDocument;
        }

        public List<Integer> getRemovedTargetIds() {
            return this.removedTargetIds;
        }

        public List<Integer> getUpdatedTargetIds() {
            return this.updatedTargetIds;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public int hashCode() {
            int i;
            MutableDocument newDocument = this.newDocument;
            if (newDocument != null) {
                i = newDocument.hashCode();
            } else {
                i = 0;
            }
            return i7 += i;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DocumentChange{updatedTargetIds=");
            stringBuilder.append(this.updatedTargetIds);
            stringBuilder.append(", removedTargetIds=");
            stringBuilder.append(this.removedTargetIds);
            stringBuilder.append(", key=");
            stringBuilder.append(this.documentKey);
            stringBuilder.append(", newDocument=");
            stringBuilder.append(this.newDocument);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static final class ExistenceFilterWatchChange extends com.google.firebase.firestore.remote.WatchChange {

        private final com.google.firebase.firestore.remote.ExistenceFilter existenceFilter;
        private final int targetId;
        public ExistenceFilterWatchChange(int i, com.google.firebase.firestore.remote.ExistenceFilter existenceFilter2) {
            super(0);
            this.targetId = i;
            this.existenceFilter = existenceFilter2;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public com.google.firebase.firestore.remote.ExistenceFilter getExistenceFilter() {
            return this.existenceFilter;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public int getTargetId() {
            return this.targetId;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ExistenceFilterWatchChange{targetId=");
            stringBuilder.append(this.targetId);
            stringBuilder.append(", existenceFilter=");
            stringBuilder.append(this.existenceFilter);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static final class WatchTargetChange extends com.google.firebase.firestore.remote.WatchChange {

        private final d1 cause;
        private final com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType changeType;
        private final j resumeToken;
        private final List<Integer> targetIds;
        public WatchTargetChange(com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType watchChange$WatchTargetChangeType, List<Integer> list2) {
            super(watchTargetChangeType, list2, WatchStream.EMPTY_RESUME_TOKEN, 0);
        }

        public WatchTargetChange(com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType watchChange$WatchTargetChangeType, List<Integer> list2, j j3) {
            super(watchTargetChangeType, list2, j3, 0);
        }

        public WatchTargetChange(com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType watchChange$WatchTargetChangeType, List<Integer> list2, j j3, d1 d14) {
            int i;
            com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType removed;
            boolean obj5;
            final int i2 = 0;
            super(i2);
            int i3 = 0;
            if (d14 != null) {
                if (watchTargetChangeType == WatchChange.WatchTargetChangeType.Removed) {
                    i = 1;
                } else {
                    i = i3;
                }
            } else {
            }
            Assert.hardAssert(i, "Got cause for a target change that was not a removal", new Object[i3]);
            this.changeType = watchTargetChangeType;
            this.targetIds = list2;
            this.resumeToken = j3;
            if (d14 != null && !d14.p()) {
                if (!d14.p()) {
                    this.cause = d14;
                } else {
                    this.cause = i2;
                }
            } else {
            }
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public boolean equals(Object object) {
            int i;
            Object cause;
            Class<com.google.firebase.firestore.remote.WatchChange.WatchTargetChange> obj;
            Class class;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (WatchChange.WatchTargetChange.class != object.getClass()) {
                } else {
                    if (this.changeType != object.changeType) {
                        return i2;
                    }
                    if (!this.targetIds.equals(object.targetIds)) {
                        return i2;
                    }
                    if (!this.resumeToken.equals(object.resumeToken)) {
                        return i2;
                    }
                    cause = this.cause;
                    if (cause != null) {
                        if (object.cause != null && cause.n().equals(object.cause.n())) {
                            if (cause.n().equals(object.cause.n())) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                        return i;
                    }
                    if (object.cause == null) {
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
            return i2;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public d1 getCause() {
            return this.cause;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType getChangeType() {
            return this.changeType;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public j getResumeToken() {
            return this.resumeToken;
        }

        public List<Integer> getTargetIds() {
            return this.targetIds;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public int hashCode() {
            int i;
            d1 cause = this.cause;
            if (cause != null) {
                i = cause.n().hashCode();
            } else {
                i = 0;
            }
            return i7 += i;
        }

        @Override // com.google.firebase.firestore.remote.WatchChange
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WatchTargetChange{changeType=");
            stringBuilder.append(this.changeType);
            stringBuilder.append(", targetIds=");
            stringBuilder.append(this.targetIds);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    WatchChange(com.google.firebase.firestore.remote.WatchChange.1 watchChange$1) {
        super();
    }
}
