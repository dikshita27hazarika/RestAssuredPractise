package resource;

import common.RestAssuredHelper;
import constants.ApiPaths;
import constants.ServerConfig;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import models.Users;

import java.util.HashMap;
import java.util.Map;

public class ApiResource {

    public static Users getUsersForPageTwo() {
        String url = ServerConfig.SERVER_URL + ApiPaths.LIST_USERS;
        Map<String, String> params = new HashMap<String, String>();
        params.put("page", "2");
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept", "*/*");
        ExtractableResponse<Response> response = RestAssuredHelper.callGetApi(url, params, header);
        Users users = response.as(Users.class);
        return users;
    }
}
