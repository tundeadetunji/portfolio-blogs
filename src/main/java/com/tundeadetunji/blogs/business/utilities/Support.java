package com.tundeadetunji.blogs.business.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Support {
    public enum category {
        business,
        culture,
        lifestyle
    }
    public static String toShortDate(String published){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date(Date.parse(published)));
    }
    public static ArrayList<String> splitTextInSplits(String string_to_split, String separator) {
        if (string_to_split.trim().length() < 1 || separator.length() < 1) {
            return new ArrayList<String>();
        }
        String[] s = string_to_split.split(separator);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            arrayList.add(s[i]);
        }
        return arrayList;
    }

    public static String joinTextFromSplits(ArrayList<String> splits, String separator) {
        if (splits.size() < 1 || separator.length() < 1) {
            return "";
        }
        //return String.join(separator, splits);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < splits.size(); i++) {
            s.append(splits.get(i));
            if (i < splits.size() - 1) {
                s.append(separator);
            }
        }
        return s.toString();
    }

    public static String clipped(String content, boolean with_trailing_ellipses){
        ArrayList<String> all_words = splitTextInSplits(content, " ");
        ArrayList<String> words = new ArrayList<String>();
        int count=50;
        if(all_words.size() < 50){
            count = all_words.size();
        }
        for(int i = 0; i < count; i++){
            try{
                words.add(all_words.get(i));
            }
            catch (Exception ex){}
        }
        if (!with_trailing_ellipses){
            return joinTextFromSplits(words, " ");
        }
        return joinTextFromSplits(words, " ") + "...";
    }

    public static ArrayList<String> leftRightOfClipped(String content){
        ArrayList<String> strings = new ArrayList<String>();
        String l = clipped(content, false);
        strings.add(l.substring(0,1));
        strings.add(l.substring(1));
        return strings;
    }

    public static String restAfterClipped(String content){
        ArrayList<String> all_words = splitTextInSplits(content, " ");
        ArrayList<String> r = new ArrayList<String>();
        int count=50;
        if(all_words.size() > 50){
            count = all_words.size() - 50;
        }
        return content.substring(count);
    }
}
