package com.google.firebase.database;

/* loaded from: classes2.dex */
public interface ChildEventListener {
    public abstract void onCancelled(com.google.firebase.database.DatabaseError databaseError);

    public abstract void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String string2);

    public abstract void onChildChanged(com.google.firebase.database.DataSnapshot dataSnapshot, String string2);

    public abstract void onChildMoved(com.google.firebase.database.DataSnapshot dataSnapshot, String string2);

    public abstract void onChildRemoved(com.google.firebase.database.DataSnapshot dataSnapshot);
}
