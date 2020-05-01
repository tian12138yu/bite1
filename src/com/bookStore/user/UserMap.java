package com.bookStore.user;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tjy
 * @Date 2020/5/1 15:39
 */

public class UserMap {

    Map map;

    public UserMap() {
        map = new HashMap<String,User>();
        map.put("管理员",new Admin(
                "管理员","123",1
        ));
        map.put("用户",new NomalUser(
                "用户","123",2
        ));
    }

    public User getUsre(String name){
        if (map.get(name) != null){
            return (User) map.get(name);
        }

        return null;
    }
}
