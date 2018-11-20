package es.gate;

import android.util.Log;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.regex.Pattern;

public class Static_Functions {

    //---------Check Inputs---------\\
    private static final Pattern patternEMAIL = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" + "@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");

    public static boolean checkLength(String str, int length) {

        return str.length() >= length;
    }

    public static boolean checkEmail(String email) {

        return email != null && patternEMAIL.matcher(email).matches();
    }


    //---------Check ORCID---------\\

    public static HashMap<String, String> loginORCID(String orcid) {


        HashMap<String, String> loginResult = new HashMap<>();

        String orcidFormat = formatORCID(orcid);
        String response = doGetRequest(orcidFormat);

        Gson gson = new Gson();
        HashMap responseMap = gson.fromJson(response, HashMap.class);
        if (responseMap == null)
            return null;
        HashMap<String, String> infoMap = createHash(responseMap.toString());

        String name = "", lastName = "", institution = "", email = "";

        try {
            name = infoMap.get("given-names");
            lastName = infoMap.get("family-name");
            institution = infoMap.get("organization");
        } catch (NullPointerException e) {
            loginResult.put("status", "There was a problem communicating with server");
            return loginResult;
        }

        try {
            name = name.replace("{value=", "").replace("}", "");
        } catch (NullPointerException e) {
            Log.d("ORCIDSearch", "Null first name");
        }
        try {
            lastName = lastName.replace("{value=", "").replace("}", "");
        } catch (NullPointerException e) {
            Log.d("ORCIDSearch", "Null last name");
        }
        try {
            institution = institution.replace("{name=", "");
        } catch (NullPointerException e) {
            Log.d("ORCIDSearch", "Null institution name");
        }
        try {
            email = infoMap.get("email");
        } catch (NullPointerException e) {
            Log.d("ORCIDSearch", "Null email name");
        }


        if (name == null) {
            loginResult.put("status", "Not a valid orcid ID");
        } else {
            loginResult.put("status", "Successful");
            loginResult.put("FirstName", name);
            loginResult.put("LastName", lastName);
            loginResult.put("Institution", institution);
            loginResult.put("Email", email);
        }

        return loginResult;

    }

    public static String formatORCID(String orcid) {
        String orcidFormat = "";
        int size = orcid.length() / 4;
        int rest = orcid.length() % 4;
        int i;

        for (i = 0; i < size; i++) {
            orcidFormat = orcidFormat.concat(orcid.substring(4 * i, 4 + 4 * i) + "-");
        }
        if (rest > 0) {
            orcidFormat = orcidFormat.concat(orcid.substring(4 * i, (4 * i) + rest));
        } else {
            orcidFormat = orcidFormat.substring(0, orcidFormat.length() - 1);
        }

        System.out.println("orcid " + orcidFormat);

        return orcidFormat;
    }

    private static String doGetRequest(String orcid) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://pub.orcid.org/v2.1/" + orcid)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization_type", "Bearer")
                .addHeader("Access_token", "80948901-a164-49cb-b892-aeea1cbdf986")
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Log.d("StaticFunctions", "Response was null");
        }
        return null;
    }

    private static HashMap<String, String> createHash(String input) {
        String propertiesFormat = input.replaceAll(",", "\n");
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(propertiesFormat));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry : entrySet) {
            hashMap.put((String) entry.getKey(), (String) entry.getValue());
        }
        return hashMap;
    }
}
