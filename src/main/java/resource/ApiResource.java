package resource;

import common.RestAssuredHelper;
import constants.ApiPaths;
import constants.ServerConfig;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import models.UpdatePut.Put;
import models.UpdatePut.PutRequest;
import models.listresource.DatumListResource;
import models.singleresource.UnknownTwo;
import models.singleuser.UsersTwo;

import java.util.HashMap;
import java.util.Map;

public class ApiResource {



    public static DatumListResource getUsersForPageTwo() {
        String url = ServerConfig.SERVER_URL + ApiPaths.LIST_RESOURCE;
        Map<String, String> params = new HashMap<String, String>();
        //params.put("page", "2");
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept", "*/*");
        ExtractableResponse<Response> response = RestAssuredHelper.callGetApi(url, params, header);
        //response.statusCode();
        //response.body();
        DatumListResource datumListResource = response.as(DatumListResource.class);
        return datumListResource;
    }

    public static UsersTwo getUsersForTwo(String userID) {
        String url = ServerConfig.SERVER_URL + ApiPaths.SINGLE_USER.replace("{id}", userID);
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept", "*/*");
        ExtractableResponse<Response> response = RestAssuredHelper.callGetApi(url, params, header);
        //response.statusCode();
        UsersTwo user = response.as(UsersTwo.class);
        return user;
        //return response.statusCode()==200 ? response.as(UsersTwo.class) : null;
    }

    public static UnknownTwo resourceUnknownTwo(){
        String url = ServerConfig.SERVER_URL + ApiPaths.SINGLE_RESOURCE.replace("{id}", "2");
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept", "*/*");
        ExtractableResponse<Response> response = RestAssuredHelper.callGetApi(url, params, header);
        UnknownTwo unknownTwo = response.as(UnknownTwo.class);
        return unknownTwo;
    }

    public static Put putResponse(String name, String location){
        String url = ServerConfig.SERVER_URL + ApiPaths.SINGLE_USER.replace("{id}", "2");
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept", "*/*");
        PutRequest putRequest = new PutRequest();
        putRequest.setName(name);
        putRequest.setJob(location);
        ExtractableResponse<Response> response = RestAssuredHelper.callPutApi(url, params,header, putRequest);
        Put put = response.as(Put.class);
        return put;
    }

}
