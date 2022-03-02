package com.wiloke.corecommon.utils;

import com.github.slugify.Slugify;
import com.wiloke.corecommon.services.SlugServiceable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlugifyUtil {
    public static String slugify(String name) {
        Slugify slugify = new Slugify();
        return slugify.slugify(name);
    }

    public static <T> String slugify(SlugServiceable<T> slugServiceable, String name) {
        Slugify slugify = new Slugify();
        String handle = slugify.slugify(name);

        var lastHandle = slugServiceable.findLastHandleName(handle);

        if (lastHandle == null) {
            return handle;
        }
//
//        Pattern patter = Pattern.compile("-([0-9]+)$");
//        Matcher matcher = patter.matcher(lastHandle);
        String generatedSlug = null;
//        if (!matcher.find()) {
//            generatedSlug = lastHandle + "-1";
//        } else {
//            var number = Long.parseLong(matcher.group(1));
//            generatedSlug =  lastHandle.replaceAll("-[0-9]+", "-"+number);
//            System.out.println(generatedSlug);
//        }
//
//        var makeSureGeneratedSlugNotExists = slugServiceable.findLastHandleName(generatedSlug);
//        if (makeSureGeneratedSlugNotExists == null) {
//            return generatedSlug;
//        }

        var isGeneratedSlug = false;
        String randomSlug;
        while (!isGeneratedSlug) {
            randomSlug = handle + StringUtil.randomString();
            if (slugServiceable.findLastHandleName(randomSlug) == null) {
                generatedSlug = randomSlug;
            }

            isGeneratedSlug = true;
        }

        return generatedSlug;
    }
}
