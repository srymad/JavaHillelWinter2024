package org.example;

public class Main {
    public static void main(String[] args) {
        CacheHelper cacheHelper = new CacheHelper();

        cacheHelper.put("dogs", "dog_bobik", new Animal("Dog", "Bobik", 5));
        cacheHelper.put("cats", "cat_murk", new Animal("Cat", "Murk", 8));

        System.out.println(cacheHelper.get("dogs", "dog_bobik"));
        System.out.println(cacheHelper.isCacheExist("dogs") ? "true" : "false");

        cacheHelper.clear("cats");
        System.out.println(cacheHelper.isCacheExist("dogs") ? "true" : "false");
        cacheHelper.clear();
        System.out.println(cacheHelper.isCacheExist("dogs") ? "true" : "false");
        System.out.println(cacheHelper.isCacheExist("cats") ? "true" : "false");




    }
}