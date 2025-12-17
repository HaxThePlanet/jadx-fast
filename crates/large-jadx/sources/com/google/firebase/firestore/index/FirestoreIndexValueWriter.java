package com.google.firebase.firestore.index;

import android.accounts.Account;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.protobuf.r1;
import f.c.e.c.a;
import f.c.e.c.r;
import f.c.e.c.x;
import f.c.e.c.x.c;
import f.c.h.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class FirestoreIndexValueWriter {

    public static final int DOCUMENT_NAME_OFFSET = 5;
    public static final int INDEX_TYPE_ARRAY = 50;
    public static final int INDEX_TYPE_BLOB = 30;
    public static final int INDEX_TYPE_BOOLEAN = 10;
    public static final int INDEX_TYPE_GEOPOINT = 45;
    public static final int INDEX_TYPE_MAP = 55;
    public static final int INDEX_TYPE_NAN = 13;
    public static final int INDEX_TYPE_NULL = 5;
    public static final int INDEX_TYPE_NUMBER = 15;
    public static final int INDEX_TYPE_REFERENCE = 37;
    public static final int INDEX_TYPE_REFERENCE_SEGMENT = 60;
    public static final int INDEX_TYPE_STRING = 25;
    public static final int INDEX_TYPE_TIMESTAMP = 20;
    public static final com.google.firebase.firestore.index.FirestoreIndexValueWriter INSTANCE;
    static {
        FirestoreIndexValueWriter firestoreIndexValueWriter = new FirestoreIndexValueWriter();
        FirestoreIndexValueWriter.INSTANCE = firestoreIndexValueWriter;
    }

    private void writeIndexArray(a a, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        int next;
        writeValueTypeLabel(directionalIndexByteEncoder2, 50);
        Iterator obj2 = a.a().iterator();
        for (x next : obj2) {
            writeIndexValueAux(next, directionalIndexByteEncoder2);
        }
    }

    private void writeIndexEntityRef(String string, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        int i2;
        String segment;
        int i;
        writeValueTypeLabel(directionalIndexByteEncoder2, 37);
        final ResourcePath obj5 = ResourcePath.fromString(string);
        i2 = 5;
        while (i2 < obj5.length()) {
            writeValueTypeLabel(directionalIndexByteEncoder2, 60);
            writeUnlabeledIndexString(obj5.getSegment(i2), directionalIndexByteEncoder2);
            i2++;
        }
    }

    private void writeIndexMap(r r, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        int value;
        Object key;
        writeValueTypeLabel(directionalIndexByteEncoder2, 55);
        Iterator obj3 = r.f().entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            writeIndexString((String)next2.getKey(), directionalIndexByteEncoder2);
            writeIndexValueAux((x)next2.getValue(), directionalIndexByteEncoder2);
        }
    }

    private void writeIndexString(String string, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        writeValueTypeLabel(directionalIndexByteEncoder2, 25);
        writeUnlabeledIndexString(string, directionalIndexByteEncoder2);
    }

    private void writeIndexValueAux(x x, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        int i;
        double doubleValue;
        r obj5;
        int i5 = 15;
        switch (i) {
            case 1:
                writeValueTypeLabel(directionalIndexByteEncoder2, 5);
                break;
            case 2:
                writeValueTypeLabel(directionalIndexByteEncoder2, 10);
                i = 1;
                i = 0;
                directionalIndexByteEncoder2.writeLong(i);
                break;
            case 3:
                doubleValue = x.getDoubleValue();
                writeValueTypeLabel(directionalIndexByteEncoder2, 13);
                writeValueTypeLabel(directionalIndexByteEncoder2, i5);
                directionalIndexByteEncoder2.writeDouble(doubleValue);
                break;
            case 4:
                writeValueTypeLabel(directionalIndexByteEncoder2, i5);
                directionalIndexByteEncoder2.writeDouble((double)l);
                break;
            case 5:
                obj5 = x.v();
                writeValueTypeLabel(directionalIndexByteEncoder2, 20);
                directionalIndexByteEncoder2.writeLong(obj5.g());
                directionalIndexByteEncoder2.writeLong((long)obj5);
                break;
            case 6:
                writeIndexString(x.getStringValue(), directionalIndexByteEncoder2);
                break;
            case 7:
                writeValueTypeLabel(directionalIndexByteEncoder2, 30);
                directionalIndexByteEncoder2.writeBytes(x.p());
                break;
            case 8:
                writeIndexEntityRef(x.u(), directionalIndexByteEncoder2);
                break;
            case 9:
                obj5 = x.r();
                writeValueTypeLabel(directionalIndexByteEncoder2, 45);
                directionalIndexByteEncoder2.writeDouble(obj5.f());
                directionalIndexByteEncoder2.writeDouble(obj5.g());
                break;
            case 10:
                writeIndexMap(x.t(), directionalIndexByteEncoder2);
                break;
            case 11:
                writeIndexArray(x.n(), directionalIndexByteEncoder2);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown index value type ");
                stringBuilder.append(x.w());
                IllegalArgumentException obj6 = new IllegalArgumentException(stringBuilder.toString());
                throw obj6;
        }
    }

    private void writeUnlabeledIndexString(String string, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        directionalIndexByteEncoder2.writeString(string);
    }

    private void writeValueTypeLabel(com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder, int i2) {
        directionalIndexByteEncoder.writeLong((long)i2);
    }

    public void writeIndexValue(x x, com.google.firebase.firestore.index.DirectionalIndexByteEncoder directionalIndexByteEncoder2) {
        writeIndexValueAux(x, directionalIndexByteEncoder2);
    }
}
