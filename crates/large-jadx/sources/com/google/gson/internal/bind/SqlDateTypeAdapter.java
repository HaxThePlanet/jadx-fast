package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;
    static {
        SqlDateTypeAdapter.1 anon = new SqlDateTypeAdapter.1();
        SqlDateTypeAdapter.FACTORY = anon;
    }

    public SqlDateTypeAdapter() {
        super();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy");
        this.format = simpleDateFormat;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        return read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) {
        final JsonToken nULL = JsonToken.NULL;
        synchronized (this) {
            try {
                jsonReader.nextNull();
                return null;
                Date obj3 = new Date(this.format.parse(jsonReader.nextString()).getTime(), nULL);
                return obj3;
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
        write(jsonWriter, (Date)object2);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date2) {
        DateFormat format;
        int obj3;
        synchronized (this) {
            obj3 = 0;
            jsonWriter.value(obj3);
        }
    }
}
