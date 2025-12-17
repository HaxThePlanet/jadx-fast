package com.vimeo.networking;

import com.google.gson.Gson;
import com.vimeo.networking.callbacks.ModelCallback;
import com.vimeo.networking.callbacks.VimeoCallback;
import com.vimeo.networking.logging.ClientLogger;

/* loaded from: classes2.dex */
public class GsonDeserializer {
    public void deserialize(Gson gson, Object object2, ModelCallback<Object> modelCallback3) {
        modelCallback3.success(deserializeObject(gson, object2, modelCallback3));
    }

    protected Object deserializeObject(Gson gson, Object object2, ModelCallback<Object> modelCallback3) {
        try {
            return gson.fromJson(gson.toJson(object2), modelCallback3.getObjectType());
            object2 = "Error when deserializing object!";
            ClientLogger.e(object2, gson);
            gson = null;
            return gson;
        }
    }
}
