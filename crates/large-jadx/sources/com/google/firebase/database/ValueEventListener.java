package com.google.firebase.database;

/* loaded from: classes2.dex */
public interface ValueEventListener {
    public abstract void onCancelled(com.google.firebase.database.DatabaseError databaseError);

    public abstract void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot);
}
