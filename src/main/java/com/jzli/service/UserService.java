package com.jzli.service;

import com.jzli.bean.User;
import com.jzli.repository.UserRepository;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * =======================================================
 *
 * @Company 金色家网络科技有限公司-云存储业务部
 * @Date ：2017/3/2
 * @Author ：li.jinzhao
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 保存指定用户名的用户信息到ES中
     *
     * @param id
     */
    public Boolean save(String id) {
        return Boolean.FALSE;
    }

    /**
     * 保存所有用户信息到ES中
     *
     * @return
     */
    public Boolean saveAll() {
        LinkedBlockingDeque<User> users = new LinkedBlockingDeque<>();
        for (int i = 1; i < 101; i++) {
            User user = new User();
            user.setId(Integer.toString(i));
            user.setName(UUID.randomUUID().toString());
            user.setMobile(Integer.toString(RandomUtils.nextInt()));
            users.add(user);
        }
        userRepository.save(users);
        return Boolean.TRUE;
    }

    /**
     * 根据用户昵称和手机号模糊查询
     *
     * @param search
     * @return
     */
    public Page<User> findByNameLikeOrMobileLike(String search) {
        Page<User> userEsPage = userRepository.findByNameLikeOrMobileLike(search, search, new PageRequest(0, 15));
        return userEsPage;
    }

    /**
     * 获取指定userName的用户
     *
     * @param id
     * @return
     */
    public User get(String id) {
        return userRepository.findOne(id);
    }


}
