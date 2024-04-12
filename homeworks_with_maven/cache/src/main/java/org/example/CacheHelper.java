package org.example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CacheHelper {

    private static final Logger loggerFile = LoggerFactory.getLogger("console.info");
    private static Map <String, Map<String, Object>> cacheMap;

    public CacheHelper(){
        cacheMap = new HashMap<>();
    }


    /**
     * Putting object in certain cache by key
     * */
    public boolean put(String cache, String key, Object o){
        if(!isCacheExist(cache)){
            cacheMap.put(cache, new HashMap<>());
        }
        cacheMap.get(cache).put(key, o);
        loggerFile.info("Object was put in cache");
        return true;
    }

    /**
     * Retrieving object from certain cache by key
     * */
    public Object get(String cache, String key){
        if(isCacheExist(cache) && cacheMap.get(cache).containsKey(key)){
            loggerFile.info("Object was taken from cache");
            return cacheMap.get(cache).get(key);
        }
        loggerFile.info("Object wasnt found in cache");
        return null;

    }

    /**
     * Clears all caches
     * */
    public void clear(){
        cacheMap.clear();
        loggerFile.info("Cache was fully cleared ");
    }

    /**
     * Clears certain cache
     * */
    public void clear(String cache){
        if(isCacheExist(cache) && !cacheMap.get(cache).isEmpty()){
            loggerFile.info(cache + " was cleared");
            cacheMap.get(cache);
        }
        loggerFile.info(cache + " was empty");
    }

    /**
     * Verifying is the cache existing
     * */
    public boolean isCacheExist(String cache){
        return cacheMap.containsKey(cache);
    }


}
