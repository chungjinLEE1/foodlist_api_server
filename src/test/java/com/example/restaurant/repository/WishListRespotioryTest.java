package com.example.restaurant.repository;

import com.example.restaurant.wishlist.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishListRespotioryTest {

    @Autowired
    private WishListRespotiory wishListRespotiory;


    private WishListEntity create(){
        var wishList = new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setRoadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);
        return wishList;
    }

    @Test
    public void saveTest(){
        var wishListEntity = create();
        var expected = wishListRespotiory.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishListRespotiory.save(wishListEntity);

        expected.setTitle("update test");
        var saveEntity = wishListRespotiory.save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitle());
        Assertions.assertEquals(1, wishListRespotiory.findAll().size());
    }


    @Test
    public void findByTest(){

        var wishListEntity = create();
        wishListRespotiory.save(wishListEntity);

        var expected = wishListRespotiory.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());


    }


    @Test
    public void deleteTest(){
        var wishListEntity = create();
        wishListRespotiory.save(wishListEntity);
        wishListRespotiory.deleteById(1);

        int count = wishListRespotiory.findAll().size();

        Assertions.assertEquals(0, count);
    }

    @Test
    public void listAll(){
        var wishListEntity = create();
        wishListRespotiory.save(wishListEntity);

        var wishListEntity2 = create();
        wishListRespotiory.save(wishListEntity2);

        int count = wishListRespotiory.findAll().size();

        Assertions.assertEquals(2, count);


    }

}