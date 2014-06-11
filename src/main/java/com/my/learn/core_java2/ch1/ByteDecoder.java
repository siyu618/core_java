package com.my.learn.core_java2.ch1;


import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.util.*;

/**
 * Created by tianzy on 5/27/14.
 */
public class ByteDecoder {
    private static Set<String> unknownCountries = new HashSet<String>();
    private static Map<String, Collection<String>> countryToEncodingList =
            new HashMap<String, Collection<String>>();

    static {
        // default encoding lists in priority descending order
        // see http://en.wikipedia.org/wiki/Chinese_character_encoding
        // see http://en.wikipedia.org/wiki/ISO/IEC_8859
        // encoding names are taken from
        // http://download.oracle.com/javase/7/docs/technotes/guides/intl/encoding.doc.html
        // NOTE:
        //   The latest encoding in the list is a fallback one or set it null if you don't want this feature.
        countryToEncodingList.put("US", Arrays.asList("UTF-8", "ISO-8859-1"));
        countryToEncodingList.put("GB", Arrays.asList("UTF-8", "ISO-8859-1"));
        countryToEncodingList.put("DE", Arrays.asList("UTF-8", "ISO-8859-1", "ISO-8859-16"));
        countryToEncodingList.put("FR", Arrays.asList("UTF-8", "ISO-8859-1", "ISO-8859-15"));
        countryToEncodingList.put("IT", Arrays.asList("UTF-8", "ISO-8859-1", "ISO-8859-16"));
        countryToEncodingList.put("ES", Arrays.asList("UTF-8", "ISO-8859-1"));
        countryToEncodingList.put("TW", Arrays.asList("UTF-8", "Big5", "Big5-HKSCS", "EUC_TW", "Big5"));
        countryToEncodingList.put("HK", Arrays.asList("UTF-8", "Big5", "Big5-HKSCS", "EUC_TW", "Big5"));
        countryToEncodingList.put("SG", Arrays.asList("UTF-8", "GB18030", "EUC_TW", "Big5"));
    }

    public static String detectEncoding(ByteBuffer data, String iso) throws CharacterCodingException {
        Collection<String> encodingList = countryToEncodingList.get(iso);
        if (null == encodingList) {
            encodingList = countryToEncodingList.get("US");
            if (!unknownCountries.contains(iso)) {
                unknownCountries.add(iso);
            }
        }
        for (String encoding : encodingList) {
            data.rewind();
            try {
                decodeAs(data, encoding);
            } catch (CharacterCodingException e) {
                e.printStackTrace();
            }
            return encoding;
        }
        throw new CharacterCodingException();

    }

    public static CharBuffer decodeAs(ByteBuffer in, String encoding) throws CharacterCodingException {
        Charset charset = Charset.forName(encoding);
        CharsetDecoder decoder = charset.newDecoder();
        decoder.onMalformedInput(CodingErrorAction.REPORT);
        decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        CharBuffer charBuffer = decoder.decode(in);
        return charBuffer;

    }

    public static ByteBuffer encodeAs(CharBuffer in, String encoding) throws CharacterCodingException {
        Charset charset = Charset.forName(encoding);
        CharsetEncoder encoder = charset.newEncoder();
        encoder.onMalformedInput(CodingErrorAction.REPORT);
        encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        ByteBuffer byteBuffer = encoder.encode(in);
        return byteBuffer;
    }


    public static String transcode(ByteBuffer data, String iso) throws CharacterCodingException {
        Collection<String> encodingList = countryToEncodingList.get(iso);
        if (encodingList == null) {
            encodingList = countryToEncodingList.get("US");
            if (!unknownCountries.contains(iso)) {
                unknownCountries.add(iso);
            }
        }

        String fallbackEncoding = null;
        for (String encoding: encodingList) {
            fallbackEncoding = encoding;
            if (encoding == null) continue;
                data.rewind();
            CharBuffer cbuf = null;
            try {
                cbuf = decodeAs(data, encoding);
            } catch (CharacterCodingException e) {
            }
            return cbuf.toString();

        }

        if (fallbackEncoding == null) {
            throw new CharacterCodingException();
        }
        return new String(data.array(), Charset.forName(fallbackEncoding));
    }
}
