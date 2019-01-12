package com.shsxt.crm.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings("all")
public class RedisUtils {
    private RedisTemplate<String,Object> redisTemplate;
    private ValueOperations<String, Object> valueOperations;
    private ListOperations<String, Object> listOperations;
    private HashOperations<String, String, Object> hashOperations;
    public RedisUtils(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations=this.redisTemplate.opsForValue();
        listOperations=this.redisTemplate.opsForList();
        hashOperations=this.redisTemplate.opsForHash();
    }
    public void setString(String key,Object value){
        valueOperations.set(key, value);
    }
    public void setStringExpires(String key,Object value,Long time){
        valueOperations.set(key, value, time, TimeUnit.MINUTES);
    }
    
    public Object getString(String key){
        return valueOperations.get(key);
    }

    public void clearKeyByPattern(String pattern){
        Set<String> keys= redisTemplate.keys(pattern);
        if(!CollectionUtils.isEmpty(keys)){
            redisTemplate.delete(keys);
        }
    }
    
    public void delKey(String key){
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
    }
    
    public void setList(String key,List list){
        if(!CollectionUtils.isEmpty(list)){
            for(Object t:list){
                listOperations.rightPush(key, t);
            }
        }
    }
    
    public List<Object> getList(String key){
        List<Object> list=null;
        if(redisTemplate.hasKey(key)){
            list=listOperations.range(key, 0, -1);
        }
        return list;
    }

    public void setHash(String key,String field,Object t){
        hashOperations.put(key, field, t);
    }
    
    public void setHashAll(String key,Map<String, Object> map){
        hashOperations.putAll(key, map);
    }
    
    public Object getHash(String key,String field){
        return hashOperations.get(key, field);
    }
    
    public List<Object> getMultiHash(String key,List fields){
        return  hashOperations.multiGet(key, fields);
    }
    
    public Map getHashMap(String key){
        return hashOperations.entries(key);
    }
}