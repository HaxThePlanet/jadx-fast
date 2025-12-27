package com.vimeo.networking;

import com.google.gson.Gson;
import com.vimeo.networking.callbacks.ModelCallback;
import com.vimeo.networking.callbacks.VimeoCallback;
import com.vimeo.networking.logging.ClientLogger;

/* compiled from: GsonDeserializer.java */
/* loaded from: classes2.dex */
public class GsonDeserializer {
    public void deserialize(Gson gson, Object object, ModelCallback<Object> modelCallback) {
        modelCallback.success(deserializeObject(gson, object, modelCallback));
    }

    protected Object deserializeObject(Gson gson, Object object, ModelCallback<Object> modelCallback) {
        try {
        } catch (Exception e) {
            object = "Error when deserializing object!";
            ClientLogger.e(object, e);
            e = null;
            return e;
        }
        return gson.fromJson(gson.toJson(object), modelCallback.getObjectType());
    }
}
