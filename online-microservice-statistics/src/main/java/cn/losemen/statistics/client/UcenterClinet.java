package cn.losemen.statistics.client;


import cn.losemen.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FeignClient注解用于指定从哪个服务中调用功能 ，名称与被调用的服务名保持一致。
 * @GetMapping注解用于对被调用的微服务进行地址映射。
 * @PathVariable注解一定要指定参数名称，否则出错
 * @Component注解防止，在其他位置注入UcenterClient时idea报错
 * @author helen
 * @since 2019/7/1
 */
@Component
@FeignClient("online-ucenter")
public interface UcenterClinet {

	@GetMapping(value = "/admin/ucenter/member/count-register/{day}")
	public R registerCount(
            @PathVariable("day") String day);

}
