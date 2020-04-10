package cn.losemen.ucenter.mapper;

import cn.losemen.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-04
 */
public interface MemberMapper extends BaseMapper<Member> {

    Integer selectRegisterCount(String day);
}
