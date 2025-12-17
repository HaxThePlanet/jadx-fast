package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;
    static {
        TimeTypeAdapter.1 anon = new TimeTypeAdapter.1();
        TimeTypeAdapter.FACTORY = anon;
    }

    public TimeTypeAdapter() {
        super();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        this.format = simpleDateFormat;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        return read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public Time read(JsonReader jsonReader) {
        synchronized (this) {
            try {
                jsonReader.nextNull();
                return null;
                Time time = new Time(this.format.parse(jsonReader.nextString()).getTime(), obj2);
                return time;
                JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(jsonReader);
                throw jsonSyntaxException;
                throw jsonReader;
            } catch (java.text.ParseException parse) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object object2) {
        write(jsonWriter, (Time)object2);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Time time2) {
        DateFormat format;
        int obj3;
        synchronized (this) {
            obj3 = 0;
            jsonWriter.value(obj3);
        }
    }
}
