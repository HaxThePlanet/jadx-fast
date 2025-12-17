package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.core.Query.LimitType;
import com.google.firebase.firestore.core.Target;

/* loaded from: classes2.dex */
public class BundledQuery implements com.google.firebase.firestore.bundle.BundleElement {

    private final Query.LimitType limitType;
    private final Target target;
    public BundledQuery(Target target, Query.LimitType query$LimitType2) {
        super();
        this.target = target;
        this.limitType = limitType2;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public boolean equals(Object object) {
        int i;
        Class class2;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (!this.target.equals(object.target)) {
                    return i2;
                }
                if (this.limitType == object.limitType) {
                } else {
                    i = i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public Query.LimitType getLimitType() {
        return this.limitType;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public Target getTarget() {
        return this.target;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int hashCode() {
        return i2 += i4;
    }
}
