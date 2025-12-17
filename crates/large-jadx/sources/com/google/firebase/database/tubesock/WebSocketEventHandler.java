package com.google.firebase.database.tubesock;

/* loaded from: classes2.dex */
public interface WebSocketEventHandler {
    public abstract void onClose();

    public abstract void onError(com.google.firebase.database.tubesock.WebSocketException webSocketException);

    public abstract void onLogMessage(String string);

    public abstract void onMessage(com.google.firebase.database.tubesock.WebSocketMessage webSocketMessage);

    public abstract void onOpen();
}
