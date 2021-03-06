package com.example.demo.service;

import com.example.demo.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by WangXinbiao on 2019/02/13
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。

        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        if(username.equals("admin"))
        {
            //假设返回的用户信息如下;
            UserInfo userInfo=new UserInfo("admin", "123456", "ROLE_ADMIN", true,true,true, true);
            return userInfo;
        }
        if(username.equals("zhangsan"))
        {
            //假设返回的用户信息如下;
            UserInfo userInfo=new UserInfo("zhangsan", "123456", "ROLE_p1", true,true,true, true);
            return userInfo;
        }
        return null;
    }
}
