package com.google.gson;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
final class DefaultDateTypeAdapter extends com.google.gson.TypeAdapter<Date> {

    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;
    public DefaultDateTypeAdapter(int i, int i2) {
        super(Date.class, i, i2);
    }

    DefaultDateTypeAdapter(Class<? extends Date> class) {
        boolean obj4;
        super();
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = DefaultDateTypeAdapter.verifyDateType(class);
        obj4 = Locale.US;
        final int i = 2;
        arrayList.add(DateFormat.getDateTimeInstance(i, i, obj4));
        if (!Locale.getDefault().equals(obj4)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> class, int i2) {
        boolean obj3;
        super();
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = DefaultDateTypeAdapter.verifyDateType(class);
        obj3 = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i2, obj3));
        if (!Locale.getDefault().equals(obj3)) {
            arrayList.add(DateFormat.getDateInstance(i2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i2));
        }
    }

    public DefaultDateTypeAdapter(Class<? extends Date> class, int i2, int i3) {
        boolean obj3;
        super();
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = DefaultDateTypeAdapter.verifyDateType(class);
        obj3 = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, obj3));
        if (!Locale.getDefault().equals(obj3)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i2, i3));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> class, String string2) {
        boolean obj3;
        super();
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = DefaultDateTypeAdapter.verifyDateType(class);
        final Locale uS = Locale.US;
        obj3 = new SimpleDateFormat(string2, uS);
        arrayList.add(obj3);
        if (!Locale.getDefault().equals(uS)) {
            obj3 = new SimpleDateFormat(string2);
            arrayList.add(obj3);
        }
    }

    private Date deserializeToDate(String string) {
        final List dateFormats = this.dateFormats;
        Iterator iterator = this.dateFormats.iterator();
        synchronized (dateFormats) {
            return (DateFormat)iterator.next().parse(string);
        }
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> class) {
        Class<Date> obj;
        if (class != Date.class && class != Date.class) {
            if (class != Date.class) {
                if (class != Timestamp.class) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Date type must be one of ");
                stringBuilder.append(Date.class);
                stringBuilder.append(", ");
                stringBuilder.append(Timestamp.class);
                stringBuilder.append(", or ");
                stringBuilder.append(Date.class);
                stringBuilder.append(" but was ");
                stringBuilder.append(class);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
        }
        return class;
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
        Date obj4 = deserializeToDate(jsonReader.nextString());
        Class dateType = this.dateType;
        if (dateType == Date.class) {
            return obj4;
        }
        if (dateType == Timestamp.class) {
            Timestamp timestamp = new Timestamp(obj4.getTime(), obj2);
            return timestamp;
        }
        if (dateType != Date.class) {
        } else {
            Date date = new Date(obj4.getTime(), obj2);
            return date;
        }
        obj4 = new AssertionError();
        throw obj4;
    }

    @Override // com.google.gson.TypeAdapter
    public String toString() {
        Object obj = this.dateFormats.get(0);
        final int i2 = 41;
        final String str = "DefaultDateTypeAdapter(";
        if (obj instanceof SimpleDateFormat) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append((SimpleDateFormat)(DateFormat)obj.toPattern());
            stringBuilder.append(i2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(obj.getClass().getSimpleName());
        stringBuilder2.append(i2);
        return stringBuilder2.toString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object object2) {
        write(jsonWriter, (Date)object2);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date2) {
        if (date2 == null) {
            jsonWriter.nullValue();
        }
        final List dateFormats = this.dateFormats;
        jsonWriter.value((DateFormat)this.dateFormats.get(0).format(date2));
        return;
        synchronized (dateFormats) {
            dateFormats = this.dateFormats;
            jsonWriter.value((DateFormat)this.dateFormats.get(0).format(date2));
        }
    }
}
