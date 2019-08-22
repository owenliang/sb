package cc.yuerblog.sb.service.impl;

import cc.yuerblog.sb.entity.User;
import cc.yuerblog.sb.mapper.userdb.UserMapper;
import cc.yuerblog.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional  // 开启事务
    public void login() {
        User user = userMapper.getUserById(1);
        if (user != null) {
            userMapper.update(user.getAge() + 1, user.getId());
        } else {
            userMapper.insertUser("sb", 10);
        }
    }
}
