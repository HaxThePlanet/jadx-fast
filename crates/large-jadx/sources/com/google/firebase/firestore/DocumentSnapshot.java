package com.google.firebase.firestore;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Date;
import java.util.Map;

/* loaded from: classes2.dex */
public class DocumentSnapshot {

    private final Document doc;
    private final com.google.firebase.firestore.FirebaseFirestore firestore;
    private final DocumentKey key;
    private final com.google.firebase.firestore.SnapshotMetadata metadata;

    public static enum ServerTimestampBehavior {

        NONE,
        NONE,
        ESTIMATE,
        PREVIOUS;
    }
    DocumentSnapshot(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, DocumentKey documentKey2, Document document3, boolean z4, boolean z5) {
        super();
        this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(firebaseFirestore);
        this.key = (DocumentKey)Preconditions.checkNotNull(documentKey2);
        this.doc = document3;
        SnapshotMetadata obj1 = new SnapshotMetadata(z5, z4);
        this.metadata = obj1;
    }

    private <T> T castTypedValue(Object object, String string2, Class<T> class3) {
        if (object == null) {
            return 0;
        }
        if (!class3.isInstance(object)) {
        } else {
            return class3.cast(object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field '");
        stringBuilder.append(string2);
        stringBuilder.append("' is not a ");
        stringBuilder.append(class3.getName());
        RuntimeException obj3 = new RuntimeException(stringBuilder.toString());
        throw obj3;
    }

    static com.google.firebase.firestore.DocumentSnapshot fromDocument(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, Document document2, boolean z3, boolean z4) {
        super(firebaseFirestore, document2.getKey(), document2, z3, z4);
        return documentSnapshot2;
    }

    static com.google.firebase.firestore.DocumentSnapshot fromNoDocument(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, DocumentKey documentKey2, boolean z3) {
        super(firebaseFirestore, documentKey2, 0, z3, 0);
        return documentSnapshot2;
    }

    private Object getInternal(FieldPath fieldPath, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        Object obj3;
        Document doc = this.doc;
        obj3 = doc.getField(fieldPath);
        if (doc != null && obj3 != null) {
            obj3 = doc.getField(fieldPath);
            if (obj3 != null) {
                UserDataWriter userDataWriter = new UserDataWriter(this.firestore, serverTimestampBehavior2);
                return userDataWriter.convertValue(obj3);
            }
        }
        return null;
    }

    private <T> T getTypedValue(String string, Class<T> class2) {
        Preconditions.checkNotNull(string, "Provided field must not be null.");
        return castTypedValue(get(string, DocumentSnapshot.ServerTimestampBehavior.DEFAULT), string, class2);
    }

    public boolean contains(com.google.firebase.firestore.FieldPath fieldPath) {
        Object obj2;
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Document doc = this.doc;
        if (doc != null && doc.getField(fieldPath.getInternalPath()) != null) {
            obj2 = doc.getField(fieldPath.getInternalPath()) != null ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public boolean contains(String string) {
        return contains(FieldPath.fromDotSeparatedPath(string));
    }

    public boolean equals(Object object) {
        int i;
        com.google.firebase.firestore.SnapshotMetadata metadata;
        DocumentKey firestore;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof DocumentSnapshot) {
            return i2;
        }
        if (this.firestore.equals(object.firestore) && this.key.equals(object.key)) {
            if (this.key.equals(object.key)) {
                Document doc = this.doc;
                if (doc == null) {
                    if (object.doc == null) {
                        if (this.metadata.equals(object.metadata)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                    if (doc.equals(object.doc) && this.metadata.equals(object.metadata)) {
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public boolean exists() {
        int i;
        i = this.doc != null ? 1 : 0;
        return i;
    }

    public Object get(com.google.firebase.firestore.FieldPath fieldPath) {
        return get(fieldPath, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public Object get(com.google.firebase.firestore.FieldPath fieldPath, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior2, "Provided serverTimestampBehavior value must not be null.");
        return getInternal(fieldPath.getInternalPath(), serverTimestampBehavior2);
    }

    public <T> T get(com.google.firebase.firestore.FieldPath fieldPath, Class<T> class2) {
        return get(fieldPath, class2, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public <T> T get(com.google.firebase.firestore.FieldPath fieldPath, Class<T> class2, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior3) {
        int obj1;
        Object obj3;
        obj1 = get(fieldPath, serverTimestampBehavior3);
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = CustomClassMapper.convertToCustomClass(obj1, class2, getReference());
        }
        return obj1;
    }

    public Object get(String string) {
        return get(FieldPath.fromDotSeparatedPath(string), DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public Object get(String string, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        return get(FieldPath.fromDotSeparatedPath(string), serverTimestampBehavior2);
    }

    public <T> T get(String string, Class<T> class2) {
        return get(FieldPath.fromDotSeparatedPath(string), class2, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public <T> T get(String string, Class<T> class2, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior3) {
        return get(FieldPath.fromDotSeparatedPath(string), class2, serverTimestampBehavior3);
    }

    public com.google.firebase.firestore.Blob getBlob(String string) {
        return (Blob)getTypedValue(string, Blob.class);
    }

    public Boolean getBoolean(String string) {
        return (Boolean)getTypedValue(string, Boolean.class);
    }

    public Map<String, Object> getData() {
        return getData(DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public Map<String, Object> getData(com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior) {
        int obj3;
        Preconditions.checkNotNull(serverTimestampBehavior, "Provided serverTimestampBehavior value must not be null.");
        UserDataWriter userDataWriter = new UserDataWriter(this.firestore, serverTimestampBehavior);
        obj3 = this.doc;
        if (obj3 == null) {
            obj3 = 0;
        } else {
            obj3 = userDataWriter.convertObject(obj3.getData().getFieldsMap());
        }
        return obj3;
    }

    public Date getDate(String string) {
        return getDate(string, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public Date getDate(String string, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        Date obj2;
        Preconditions.checkNotNull(string, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior2, "Provided serverTimestampBehavior value must not be null.");
        obj2 = getTimestamp(string, serverTimestampBehavior2);
        if (obj2 != null) {
            obj2 = obj2.toDate();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    Document getDocument() {
        return this.doc;
    }

    public com.google.firebase.firestore.DocumentReference getDocumentReference(String string) {
        return (DocumentReference)getTypedValue(string, DocumentReference.class);
    }

    public Double getDouble(String string) {
        double doubleValue;
        Double obj3;
        obj3 = getTypedValue(string, Number.class);
        if ((Number)obj3 != null) {
            obj3 = Double.valueOf((Number)obj3.doubleValue());
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    public com.google.firebase.firestore.GeoPoint getGeoPoint(String string) {
        return (GeoPoint)getTypedValue(string, GeoPoint.class);
    }

    public String getId() {
        return this.key.getPath().getLastSegment();
    }

    public Long getLong(String string) {
        long longValue;
        Long obj3;
        obj3 = getTypedValue(string, Number.class);
        if ((Number)obj3 != null) {
            obj3 = Long.valueOf((Number)obj3.longValue());
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    public com.google.firebase.firestore.SnapshotMetadata getMetadata() {
        return this.metadata;
    }

    public com.google.firebase.firestore.DocumentReference getReference() {
        DocumentReference documentReference = new DocumentReference(this.key, this.firestore);
        return documentReference;
    }

    public String getString(String string) {
        return (String)getTypedValue(string, String.class);
    }

    public Timestamp getTimestamp(String string) {
        return getTimestamp(string, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public Timestamp getTimestamp(String string, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        Preconditions.checkNotNull(string, "Provided field path must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior2, "Provided serverTimestampBehavior value must not be null.");
        return (Timestamp)castTypedValue(getInternal(FieldPath.fromDotSeparatedPath(string).getInternalPath(), serverTimestampBehavior2), string, Timestamp.class);
    }

    public int hashCode() {
        int i2;
        Object data;
        int i;
        Document doc = this.doc;
        if (doc != null) {
            i2 = doc.getKey().hashCode();
        } else {
            i2 = i;
        }
        data = this.doc;
        if (data != null) {
            i = data.getData().hashCode();
        }
        return i10 += i13;
    }

    public <T> T toObject(Class<T> class) {
        return toObject(class, DocumentSnapshot.ServerTimestampBehavior.DEFAULT);
    }

    public <T> T toObject(Class<T> class, com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        Object reference;
        int obj2;
        Preconditions.checkNotNull(class, "Provided POJO type must not be null.");
        Preconditions.checkNotNull(serverTimestampBehavior2, "Provided serverTimestampBehavior value must not be null.");
        final Map obj3 = getData(serverTimestampBehavior2);
        if (obj3 == null) {
            obj2 = 0;
        } else {
            obj2 = CustomClassMapper.convertToCustomClass(obj3, class, getReference());
        }
        return obj2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DocumentSnapshot{key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", metadata=");
        stringBuilder.append(this.metadata);
        stringBuilder.append(", doc=");
        stringBuilder.append(this.doc);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
