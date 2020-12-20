package org.springframework.duck.uitls;

import org.springframework.util.StringUtils;

public class PathUtils {

    public static String cleanPath(String path) {
        path = path.trim();
        if (StringUtils.hasLength(path)) {
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
        }
        return path;
    }
}
