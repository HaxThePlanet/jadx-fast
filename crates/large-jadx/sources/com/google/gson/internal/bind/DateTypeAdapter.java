package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    public static final TypeAdapterFactory FACTORY;
    private final List<DateFormat> dateFormats;
    static {
        DateTypeAdapter.1 anon = new DateTypeAdapter.1();
        DateTypeAdapter.FACTORY = anon;
    }

    public DateTypeAdapter() {
        boolean dateTimeInstance;
        boolean uSDateTimeFormat;
        super();
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Locale uS = Locale.US;
        final int i = 2;
        arrayList.add(DateFormat.getDateTimeInstance(i, i, uS));
        if (!Locale.getDefault().equals(uS)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i));
        }
    }

    private Date deserializeToDate(String string) {
        Iterator iterator = this.dateFormats.iterator();
        synchronized (this) {
            try {
                return (DateFormat)iterator.next().parse(string);
                ParsePosition parsePosition = new ParsePosition(0);
                return ISO8601Utils.parse(string, parsePosition);
                JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(string, th);
                throw jsonSyntaxException;
                throw string;
            } catch (java.text.ParseException parse) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        return read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return deserializeToDate(jsonReader.nextString());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object object2) {
        write(jsonWriter, (Date)object2);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date2) {
        synchronized (this) {
            jsonWriter.nullValue();
        }
    }
}
