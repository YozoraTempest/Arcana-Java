package fun.yozora.arcana.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import fun.yozora.arcana.entity.User;
import fun.yozora.arcana.mapper.UserMapper;
import fun.yozora.arcana.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户 服务层实现。
 *
 * @author <a href="https://github.com/YozoraTempest">YozoraTempest</a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

}
