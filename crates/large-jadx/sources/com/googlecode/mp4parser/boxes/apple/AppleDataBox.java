package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public abstract class AppleDataBox extends AbstractBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static HashMap<String, String> language;
    int dataCountry;
    int dataLanguage;
    int dataType;
    static {
        AppleDataBox.ajc$preClinit();
        HashMap hashMap = new HashMap();
        AppleDataBox.language = hashMap;
        hashMap.put("0", "English");
        AppleDataBox.language.put("1", "French");
        AppleDataBox.language.put("2", "German");
        AppleDataBox.language.put("3", "Italian");
        AppleDataBox.language.put("4", "Dutch");
        AppleDataBox.language.put("5", "Swedish");
        AppleDataBox.language.put("6", "Spanish");
        AppleDataBox.language.put("7", "Danish");
        AppleDataBox.language.put("8", "Portuguese");
        AppleDataBox.language.put("9", "Norwegian");
        AppleDataBox.language.put("10", "Hebrew");
        AppleDataBox.language.put("11", "Japanese");
        AppleDataBox.language.put("12", "Arabic");
        AppleDataBox.language.put("13", "Finnish");
        AppleDataBox.language.put("14", "Greek");
        AppleDataBox.language.put("15", "Icelandic");
        AppleDataBox.language.put("16", "Maltese");
        AppleDataBox.language.put("17", "Turkish");
        AppleDataBox.language.put("18", "Croatian");
        AppleDataBox.language.put("19", "Traditional_Chinese");
        AppleDataBox.language.put("20", "Urdu");
        AppleDataBox.language.put("21", "Hindi");
        AppleDataBox.language.put("22", "Thai");
        AppleDataBox.language.put("23", "Korean");
        AppleDataBox.language.put("24", "Lithuanian");
        AppleDataBox.language.put("25", "Polish");
        AppleDataBox.language.put("26", "Hungarian");
        AppleDataBox.language.put("27", "Estonian");
        AppleDataBox.language.put("28", "Lettish");
        AppleDataBox.language.put("29", "Sami");
        AppleDataBox.language.put("30", "Faroese");
        AppleDataBox.language.put("31", "Farsi");
        AppleDataBox.language.put("32", "Russian");
        AppleDataBox.language.put("33", "Simplified_Chinese");
        AppleDataBox.language.put("34", "Flemish");
        AppleDataBox.language.put("35", "Irish");
        AppleDataBox.language.put("36", "Albanian");
        AppleDataBox.language.put("37", "Romanian");
        AppleDataBox.language.put("38", "Czech");
        AppleDataBox.language.put("39", "Slovak");
        AppleDataBox.language.put("40", "Slovenian");
        AppleDataBox.language.put("41", "Yiddish");
        AppleDataBox.language.put("42", "Serbian");
        AppleDataBox.language.put("43", "Macedonian");
        AppleDataBox.language.put("44", "Bulgarian");
        AppleDataBox.language.put("45", "Ukrainian");
        AppleDataBox.language.put("46", "Belarusian");
        AppleDataBox.language.put("47", "Uzbek");
        AppleDataBox.language.put("48", "Kazakh");
        AppleDataBox.language.put("49", "Azerbaijani");
        AppleDataBox.language.put("50", "AzerbaijanAr");
        AppleDataBox.language.put("51", "Armenian");
        AppleDataBox.language.put("52", "Georgian");
        AppleDataBox.language.put("53", "Moldavian");
        AppleDataBox.language.put("54", "Kirghiz");
        AppleDataBox.language.put("55", "Tajiki");
        AppleDataBox.language.put("56", "Turkmen");
        AppleDataBox.language.put("57", "Mongolian");
        AppleDataBox.language.put("58", "MongolianCyr");
        AppleDataBox.language.put("59", "Pashto");
        AppleDataBox.language.put("60", "Kurdish");
        AppleDataBox.language.put("61", "Kashmiri");
        AppleDataBox.language.put("62", "Sindhi");
        AppleDataBox.language.put("63", "Tibetan");
        AppleDataBox.language.put("64", "Nepali");
        AppleDataBox.language.put("65", "Sanskrit");
        AppleDataBox.language.put("66", "Marathi");
        AppleDataBox.language.put("67", "Bengali");
        AppleDataBox.language.put("68", "Assamese");
        AppleDataBox.language.put("69", "Gujarati");
        AppleDataBox.language.put("70", "Punjabi");
        AppleDataBox.language.put("71", "Oriya");
        AppleDataBox.language.put("72", "Malayalam");
        AppleDataBox.language.put("73", "Kannada");
        AppleDataBox.language.put("74", "Tamil");
        AppleDataBox.language.put("75", "Telugu");
        AppleDataBox.language.put("76", "Sinhala");
        AppleDataBox.language.put("77", "Burmese");
        AppleDataBox.language.put("78", "Khmer");
        AppleDataBox.language.put("79", "Lao");
        AppleDataBox.language.put("80", "Vietnamese");
        AppleDataBox.language.put("81", "Indonesian");
        AppleDataBox.language.put("82", "Tagalog");
        AppleDataBox.language.put("83", "MalayRoman");
        AppleDataBox.language.put("84", "MalayArabic");
        AppleDataBox.language.put("85", "Amharic");
        String str87 = "87";
        AppleDataBox.language.put(str87, "Galla");
        AppleDataBox.language.put(str87, "Oromo");
        AppleDataBox.language.put("88", "Somali");
        AppleDataBox.language.put("89", "Swahili");
        AppleDataBox.language.put("90", "Kinyarwanda");
        AppleDataBox.language.put("91", "Rundi");
        AppleDataBox.language.put("92", "Nyanja");
        AppleDataBox.language.put("93", "Malagasy");
        AppleDataBox.language.put("94", "Esperanto");
        AppleDataBox.language.put("128", "Welsh");
        AppleDataBox.language.put("129", "Basque");
        AppleDataBox.language.put("130", "Catalan");
        AppleDataBox.language.put("131", "Latin");
        AppleDataBox.language.put("132", "Quechua");
        AppleDataBox.language.put("133", "Guarani");
        AppleDataBox.language.put("134", "Aymara");
        AppleDataBox.language.put("135", "Tatar");
        AppleDataBox.language.put("136", "Uighur");
        AppleDataBox.language.put("137", "Dzongkha");
        AppleDataBox.language.put("138", "JavaneseRom");
        AppleDataBox.language.put("32767", "Unspecified");
    }

    protected AppleDataBox(String string, int i2) {
        super(string);
        this.dataType = i2;
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("AppleDataBox.java", AppleDataBox.class);
        final String str44 = "method-execution";
        AppleDataBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getLanguageString", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "java.lang.String"), 25);
        AppleDataBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "getDataType", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 43);
        AppleDataBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "getDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 47);
        AppleDataBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "setDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "int", "dataCountry", "", "void"), 51);
        AppleDataBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 55);
        AppleDataBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "setDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "int", "dataLanguage", "", "void"), 59);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseData(parseDataLength4ccTypeCountryLanguageAndReturnRest(byteBuffer));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeDataLength4ccTypeCountryLanguage(byteBuffer);
        byteBuffer.put(writeData());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDataCountry() {
        d.b().c(b.c(AppleDataBox.ajc$tjp_2, this, this));
        return this.dataCountry;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDataLanguage() {
        d.b().c(b.c(AppleDataBox.ajc$tjp_4, this, this));
        return this.dataLanguage;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected abstract int getDataLength();

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDataType() {
        d.b().c(b.c(AppleDataBox.ajc$tjp_1, this, this));
        return this.dataType;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getLanguageString() {
        Object displayLanguage;
        Object string;
        d.b().c(b.c(AppleDataBox.ajc$tjp_0, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dataLanguage);
        if ((String)AppleDataBox.language.get(stringBuilder.toString()) == null) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[2]);
            g.e(wrap, this.dataLanguage);
            wrap.reset();
            string = new Locale(e.f(wrap));
            displayLanguage = string.getDisplayLanguage();
        }
        return displayLanguage;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected abstract void parseData(ByteBuffer byteBuffer);

    @Override // com.googlecode.mp4parser.AbstractBox
    protected ByteBuffer parseDataLength4ccTypeCountryLanguageAndReturnRest(ByteBuffer byteBuffer) {
        short short2;
        short short;
        byteBuffer.getInt();
        this.dataType = byteBuffer.getInt();
        short2 = byteBuffer.getShort();
        this.dataCountry = short2;
        int i3 = 65536;
        if (short2 < 0) {
            this.dataCountry = short2 += i3;
        }
        short = byteBuffer.getShort();
        this.dataLanguage = short;
        if (short < 0) {
            this.dataLanguage = short += i3;
        }
        int += -16;
        byteBuffer.position(i += position);
        return (ByteBuffer)byteBuffer.duplicate().slice().limit(i);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDataCountry(int i) {
        d.b().c(b.d(AppleDataBox.ajc$tjp_3, this, this, a.e(i)));
        this.dataCountry = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDataLanguage(int i) {
        d.b().c(b.d(AppleDataBox.ajc$tjp_5, this, this, a.e(i)));
        this.dataLanguage = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected abstract byte[] writeData();

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void writeDataLength4ccTypeCountryLanguage(ByteBuffer byteBuffer) {
        byteBuffer.putInt(dataLength += 16);
        byteBuffer.put("data".getBytes());
        byteBuffer.putInt(this.dataType);
        g.e(byteBuffer, this.dataCountry);
        g.e(byteBuffer, this.dataLanguage);
    }
}
