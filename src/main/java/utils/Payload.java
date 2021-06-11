package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static utils.Logger.logError;
import static utils.Logger.logInfo;

public class Payload {

    public static String getPayLoad(String fileName) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/Requests/" + fileName));
            JSONObject jsonObject = (JSONObject) obj;

            return jsonObject.toJSONString();
        } catch (Exception ex) {
            logError(ex.getMessage());
            return "";
        }
    }

    public static String getPayloadCreateUserAPI(String name, String job) {
        String payload = getPayLoad("addUser.json");
        payload = payload.replace("NAME_PARAM", name).
                replace("JOB_PARAM", job);

        logInfo("Payload : " + payload);

        return payload;
    }
}
