package cn.losemen.ucenter.service.impl;

import cn.losemen.ucenter.entity.Member;
import cn.losemen.ucenter.mapper.MemberMapper;
import cn.losemen.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-04
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public Integer countRegisterByDay(String day) {
        return baseMapper.selectRegisterCount(day);
    }
}
