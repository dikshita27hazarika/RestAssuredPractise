package testcases;

import models.UpdatePut.Put;
import models.UpdatePut.PutRequest;
import models.listresource.DatumListResource;
import models.singleresource.UnknownTwo;
import models.singleuser.UsersTwo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resource.ApiResource;

public class TestcaseOne extends TestBaseSetup{

//    @Test
//    public void testOneGetApi(){
//        Users users = ApiResource.getUsersForPageTwo();
//        Assert.assertNotNull(users.getPage(), "Page is null");
//    }

    @Test (dataProvider = "testTwo")
    public  void testTwoGetApi(String userID){
        UsersTwo usersTwo = ApiResource.getUsersForTwo(userID);
        System.out.println(usersTwo.getData().getFirstName());
        Assert.assertNotNull(usersTwo.getData().getFirstName(), "first name is null");
//        Assert.assertNotNull(usersTwo.getData().getLastName(), "last name is null");
//        Assert.assertNotNull(usersTwo.getData().getEmail(), "email is null");
//        Assert.assertNotNull(usersTwo.getData().getAvatar(), "avatar name is null");
//        Assert.assertNotNull(usersTwo.getData().getId(), "id is null");
    }
    @DataProvider(name = "testTwo")
    public Object[][] getDataDataProvider(){
        return new Object[][] {
                { "1" },
                { "3" }
        };
    }


    @Test
    public  void t(){
        int i = 3;
        int j = i==3 ? 5 : 6;
        System.out.println(j);
    }

    @Test
    public void testSingleResource(){
        UnknownTwo unknownTwo =  ApiResource.resourceUnknownTwo();
        Assert.assertNotNull(unknownTwo.getData(), "page is null");
    }
    @Test
    public void testListResource(){
        DatumListResource datumListResource = ApiResource.getUsersForPageTwo();
        Assert.assertNotNull(datumListResource.getData());
    }


    @Test (dataProvider = "userDetails")
    public void updatePut(String name, String location){

        System.out.println(name);
        Put put = ApiResource.putResponse(name, location);

    }

    @DataProvider(name = "userDetails")
    public Object[][] getDataFromDataProvider(){
        return new Object[][] {
                { "morpheus", "zion resident" },
                { "Krishna", "UK" },
                { "Bhupesh", "USA" }
        };
    }


}
