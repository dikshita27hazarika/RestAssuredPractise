package testcases;

import models.listuser.Users;
import models.singleresource.UnknownTwo;
import models.singleuser.UsersTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ApiResource;

public class TestcaseOne extends TestBaseSetup{

    @Test
    public void testOneGetApi(){
        Users users = ApiResource.getUsersForPageTwo();
        Assert.assertNotNull(users.getPage(), "Page is null");
    }

    @Test
    public  void testTwoGetApi(){
        UsersTwo usersTwo = ApiResource.getUsersForTwo();
        Assert.assertNotNull(usersTwo.getData().getFirstName(), "first name is null");
        Assert.assertNotNull(usersTwo.getData().getLastName(), "last name is null");
        Assert.assertNotNull(usersTwo.getData().getEmail(), "email is null");
        Assert.assertNotNull(usersTwo.getData().getAvatar(), "avatar name is null");
        Assert.assertNotNull(usersTwo.getData().getId(), "id is null");
    }

    @Test
    public  void t(){
        int i = 3;
        int j = i==3 ? 5 : 6;
        System.out.println(j);
    }

    @Test
    public void testSingleResource(){
        UnknownTwo unknownTwo =  ApiResource.ResourceUnknownTwo();
        Assert.assertNotNull(unknownTwo.getData(), "page is null");
    }

}
