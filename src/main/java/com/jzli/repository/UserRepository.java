package com.jzli.repository;

import com.jzli.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * =======================================================
 *
 * @Company 金色家网络科技有限公司-云存储业务部
 * @Date ：2017/3/21
 * @Author ：li.jinzhao
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {
    /**
     * 根据用户昵称和手机号模糊查询
     *
     * @param name
     * @param mobile
     * @param pageable
     * @return
     */
    Page<User> findByNameLikeOrMobileLike(String name, String mobile, Pageable pageable);
}
