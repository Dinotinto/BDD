package water.support;

/**
 * All run settings come from environment variables (or -D system properties),
 * so no credentials or personal data ever live in the repo.
 */
public final class Config {

    private Config() {
    }

    /** Dashboard under test. Point it at a local `npm run dev` with BASE_URL=http://localhost:5173 */
    public static String baseUrl() {
        return stripTrailingSlash(get("BASE_URL", "https://dtinto-water-dashboard.web.app"));
    }

    /** chrome (default), firefox or edge. */
    public static String browser() {
        return get("BROWSER", "chrome").toLowerCase();
    }

    /** Headless by default on CI, visible browser by default locally. */
    public static boolean headless() {
        String fallback = System.getenv("CI") != null ? "true" : "false";
        return Boolean.parseBoolean(get("HEADLESS", fallback));
    }

    /** Window size as "width,height". Defaults to a phone-sized screen, which is how the factory uses the app. */
    public static int[] windowSize() {
        String[] parts = get("WINDOW_SIZE", "412,915").split(",");
        return new int[] {Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())};
    }

    /** Seconds to wait for the app to respond (Firebase login and first data load can be slow on mobile data). */
    public static int timeoutSeconds() {
        return Integer.parseInt(get("TIMEOUT_SECONDS", "30"));
    }

    public static String testEmail() {
        return get("WATER_EMAIL", "");
    }

    public static String testPassword() {
        return get("WATER_PASSWORD", "");
    }

    public static boolean hasTestAccount() {
        return !testEmail().isBlank() && !testPassword().isBlank();
    }

    private static String get(String key, String fallback) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            value = System.getenv(key);
        }
        return (value == null || value.isBlank()) ? fallback : value;
    }

    private static String stripTrailingSlash(String url) {
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }
}
