/*
* Copyright © 2015 S.J. Blair <https://github.com/sjblair>
* This work is free. You can redistribute it and/or modify it under the
* terms of the Do What The Fuck You Want To Public License, Version 2,
* as published by Sam Hocevar. See the COPYING file for more details.
*/

package datamuse;

import com.json.parsers.JsonParserFactory;
import com.json.parsers.JSONParser;

import java.util.List;
import java.util.Map;

/**
 * A JSON parser for the data returned from Datamuse.
 *
 * @author sjblair
 * @since 21/02/15
 */
public class JSONParse {

    public JSONParse() {

    }

    /**
     * A JSON parser for the words returned in the data.
     * @param in JSON data returned from the DatamuseQuery class.
     * @return An array of the words.
     */
    public String[] parseWords(String in) {
        JsonParserFactory factory=JsonParserFactory.getInstance();
        JSONParser parser=factory.newJsonParser();
        Map jsonData=parser.parseJson(in);
        List al= (List) jsonData.get("root");
        String[] results = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            results[i] = (String) ((Map)al.get(i)).get("word");
        }
        return results;
    }

    /**
     * A JSON parser for the word scores returned in the data.
     * @param in JSON data returned from the DatamuseQuery class.
     * @return An array of the scores.
     */
    public int[] parseScores(String in) {
        JsonParserFactory factory=JsonParserFactory.getInstance();
        JSONParser parser=factory.newJsonParser();
        Map jsonData=parser.parseJson(in);
        List al= (List) jsonData.get("root");
        int[] results = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            results[i] = Integer.parseInt((String) ((Map) al.get(i)).get("score"));
        }
        return results;
    }
}
