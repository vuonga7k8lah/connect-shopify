package com.wiloke.corecommon.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IgnoreFilter {
    public static List<String> ignoreURIs = List.of(
            "/document",
            "/document/",
            "/swagger-ui/.+",
            "/v3/api-docs",
            "/v3/api-docs/swagger-config",
            "/configuration/ui",
            "/swagger-resources/.+",
            "/configuration/security",
            "/webjars/.+"
    );
    private static HttpServletRequest request;

    private static boolean maybeIgnoreFilter() {
        Pattern pattern;
        Matcher matcher;
        var requestUrl = request.getRequestURI();
        for (String ignoreURI : ignoreURIs) {
            pattern = Pattern.compile(ignoreURI);
            matcher = pattern.matcher(requestUrl);
            if (matcher.matches()) {
                return true;
            }
        }

        return false;
    }

    public static boolean exactlyMatch(HttpServletRequest request, List<String> ignoreURIs) {
        return ignoreURIs.contains(request.getRequestURI());
    }

    public static boolean matchWithPattern(HttpServletRequest request, List<String> additional) {
        IgnoreFilter.request = request;
        ignoreURIs = Stream.concat(ignoreURIs.stream(), additional.stream()).collect(Collectors.toList());

        return maybeIgnoreFilter();
    }

    public static boolean matchWithPattern(HttpServletRequest request) {
        IgnoreFilter.request = request;

        return maybeIgnoreFilter();
    }
}
