package utilities;

import org.apache.commons.lang3.SystemUtils;
import services.emailServices.EmailServices;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Helper {

    public static String generateRandomString(int length) {
        return "";
    }

    public static String genRandomCharacter(int length, int capitalInclude) {

        int limit = 26;
        if (capitalInclude > 0) {
            limit = 52;
        }
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = genRandomNumber(limit);
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static String genRandomCharacter(int length) {
        return genRandomCharacter(length, 0);
    }

    public static int genRandomNumber(int length) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(length);
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }

    }

    public static int genRandomNumber(int min, int max) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(max - min + 1) + min;
        return randomInt;
    }

    public static String genRandomDigit(int length) {
        String CHAR_LIST = "0123456789";
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = genRandomNumber(0, 9);
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    public static String genRandomName(String firstChar) {
        return firstChar + genRandomCharacter(10);
    }

    public static String genRandomName() {
        return genRandomName("A");
    }

    public static String genRandomPhone() {
        return "0" + genRandomDigit(9);
    }

    public static String getCurrentDate(String format) {

        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(dt);

    }

    /**
     * Get the method name for a depth in call stack. <br />
     * Utility function
     *
     * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
     * @return method name
     */
    public static String getMethodName(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[2 + depth].getMethodName();
    }


    public static void sendReport() {
        EmailServices emailServices = new EmailServices();
        emailServices.sendMail("GoBear test report", "Test finished. Please check details report at: abc", "anhlando@yahoo.com");
    }

    public static String getSetting(String key){
        try {
            return Environment.settings.getProperty(key);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    public static String getResource(String key){
        try {
            String resourceName = key + "." + getSetting("language").trim().toLowerCase();
            return Environment.resources.getProperty(resourceName);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

    /**
     * this method is used to replace the {PARAM} in the resource text with the input value
    Ex: String t = "This is the test value with {PARAM1} and {PARAM2}";
        String r = processTextWithParams(t,"1","2");
        => r = This is the test value with 1 and 2
    */
    public static String processTextWithParams(String source, String... params){
        String result = source;
        if (params.length == 1){
            result = result.replace("{PARAM}",params[0]);
        }
        else if (params.length > 1){
            for (int i=0; i<params.length;i++){
                result = result.replace("{PARAM" + (i+1) + "}",params[i]);
            }
        }

        return result;
    }

    public static boolean isWindows() {
        return SystemUtils.IS_OS_WINDOWS;
    }

    public static boolean isLinux() {
        return SystemUtils.IS_OS_LINUX;
    }

    public static String getDefaultLocalFolder() {
        if (isLinux()){
            return "/data/var/gobeartest/";
        }
        else  {
            return System.getProperty("user.dir") + System.getProperty("file.separator") + "gobeartest" + System.getProperty("file.separator");
        }

    }

    public static String getTemplatesFolder(){
        return System.getProperty("user.dir") + System.getProperty("file.separator")
                + "target" + System.getProperty("file.separator")
                + "classes" + System.getProperty("file.separator")
                + "templates" + System.getProperty("file.separator");
    }

    public static String getScreenshotsFolder() {
        try{
            return getDefaultLocalFolder() + "screenshots" + System.getProperty("file.separator");
        }catch (Throwable e){
            Log.error(e.getMessage());
            throw e;
        }
    }

    public static String getBaseUrl() {
        try{
            return Environment.properties.getProperty("baseURL").trim().toLowerCase();
        }catch (Throwable e){
            Log.error(e.getMessage());
            throw e;
        }
    }
}
