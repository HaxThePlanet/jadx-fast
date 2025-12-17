package com.google.firebase.database;

import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class Transaction {

    public interface Handler {
        public abstract com.google.firebase.database.Transaction.Result doTransaction(com.google.firebase.database.MutableData mutableData);

        public abstract void onComplete(com.google.firebase.database.DatabaseError databaseError, boolean z2, com.google.firebase.database.DataSnapshot dataSnapshot3);
    }

    public static class Result {

        private Node data;
        private boolean success;
        private Result(boolean z, Node node2) {
            super();
            this.success = z;
            this.data = node2;
        }

        Result(boolean z, Node node2, com.google.firebase.database.Transaction.1 transaction$13) {
            super(z, node2);
        }

        public Node getNode() {
            return this.data;
        }

        public boolean isSuccess() {
            return this.success;
        }
    }
    public static com.google.firebase.database.Transaction.Result abort() {
        final int i2 = 0;
        Transaction.Result result = new Transaction.Result(0, i2, i2);
        return result;
    }

    public static com.google.firebase.database.Transaction.Result success(com.google.firebase.database.MutableData mutableData) {
        Transaction.Result result = new Transaction.Result(1, mutableData.getNode(), 0);
        return result;
    }
}
